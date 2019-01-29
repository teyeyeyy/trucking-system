package com.finalcasestudy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;

public class DAOts {

	Connection con;
	private final String USERNAME = "root";
	private final String PASSWORD = "1234";
	private final String CONN_STRING = "jdbc:mysql://localhost:3306/trucking_system";
	

	public Connection open() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

// LIST OF TRUCKS

	public List<Truck> getlist_of_trucks() {
		List<Truck> trucks = new ArrayList<Truck>();
		Connection con = open();

		try {

			PreparedStatement pst = con.prepareStatement("SELECT * from list_of_trucks");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Truck truck = new Truck();

				truck.setTruckID(rs.getString("truckID"));
				truck.setModel(rs.getString("model"));
				truck.setMaxCapacity(rs.getString("maxCapacity"));
				truck.setPlateNumber(rs.getString("plateNumber"));
				truck.setPurchasedYear(rs.getString("purchasedYear"));
				truck.setIsAvailable(rs.getString("isAvailable"));
				truck.setTareWeight(rs.getString("tareWeight"));
				truck.setYearsInService(rs.getString("yearsInService"));
				trucks.add(truck);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return trucks;

	}

// LIST OF DRIVERS 

	public List<Driver> viewlist_of_drivers() {
		List<Driver> drivers = new ArrayList<Driver>();
		Connection con = open();

		try {
			PreparedStatement pst = con.prepareStatement("SELECT * from list_of_drivers");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				Driver driver = new Driver();

				driver.setDriverID(rs.getString("driverID"));
				driver.setName(rs.getString("name"));
				driver.setAge(rs.getString("age"));
				driver.setAddress(rs.getString("address"));
				driver.setIsAvailable(rs.getString("isAvailable"));
				drivers.add(driver);

			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return drivers;
	}

//ADD TRUCK

	public void addlist_of_trucks(String plateNumber) {
		Connection con = open();

		try {
			String sql = "INSERT INTO list_of_trucks (plateNumber) VALUES (?)";

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, plateNumber);
			pst.executeUpdate();

			pst.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


// SORT TRANSACTION
	public List<Transaction> sortTransaction(String sortBy) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		
		Connection con = open();
		
		try {
			String sql = "SELECT * from transaction ORDER BY " + sortBy + " DESC";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				
				Transaction trans = new Transaction();
				trans.setDriver(rs.getString("driver"));
				trans.setTransientEnd(rs.getString("transientFrom"));
				trans.setGrossWeight(rs.getInt("grossWeight"));
				trans.setOrigin(rs.getString("Origin"));
				trans.setDestination(rs.getString("Destination"));
				trans.setTareWeight(rs.getInt("TareWeight"));
				trans.setLoadWeight(rs.getInt("LoadWeight"));
				trans.setContent(rs.getString("Content"));
				transactions.add(trans);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactions;
	}

// AVAILABLE OR TRANSIENT

	public void Available(String status, String id) {

		Connection con = open();

		try {

			PreparedStatement pst = con.prepareStatement("update list_of_trucks set isAvailable= ? where truckID = ?");
			pst.setString(1, status);
			pst.setString(2, id);
			pst.executeUpdate();

			pst.close();
			con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public List<Transaction> addTransaction(Transaction trans) {
		

		try {
			String sql = "INSERT INTO `trucking_system`.`transaction` (`grossWeight`, `origin`, `destination`, `tareWeight`, `loadWeight`, `content`, `transientStart`, `transientFrom`, `driver`, `truckID`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement pst = open().prepareStatement(sql);

			pst.setInt(1, trans.getGrossWeight());
			pst.setString(2, trans.getOrigin());
			pst.setString(3, trans.getDestination());
			pst.setInt(4, trans.getTareWeight());
			pst.setInt(5, trans.getLoadWeight());
			pst.setString(6, trans.getContent());
			pst.setString(7, trans.getTransientStart());
			pst.setString(8, trans.getTransientEnd());
			pst.setString(9, trans.getDriver());
			pst.setString(10, trans.getTruckID());

			pst.executeUpdate();

			pst.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
//TARE - GROSS = LOAD WEIGHT
	
	public String TareTransaction(Transaction trans) {

		if (trans.getTareWeight() - trans.getGrossWeight() <= 6500) {
			Connection con = open();
			try {
				PreparedStatement pst = con.prepareStatement("insert into transaction(tareWeight, grossWeight, loadWeight)values(?,?,?)");
				pst.setInt(1, trans.getTareWeight());
				pst.setInt(2, trans.getGrossWeight());
				pst.setInt(3, (trans.getTareWeight() - trans.getGrossWeight()));
				pst.executeUpdate();
				return "Success";
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return "Max Capacity";

	}
	
	//AVAILABLE DRIVERS

	public void AvailableDriver(String status, String id) {

		Connection con = open();

		try {

			PreparedStatement pst = con.prepareStatement("update list_of_drivers set isAvailable= ? where driverID = ?");
			pst.setString(1, status);
			pst.setString(2, id);
			pst.executeUpdate();

			pst.close();
			con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
}
}
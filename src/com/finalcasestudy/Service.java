package com.finalcasestudy;

import java.sql.Connection;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/Service")
public class Service {
	
	DAOts dao = new DAOts();  
	Connection con = null;
	
	   @GET 
	   @Path("/truck") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public List<Truck> getListOfTrucks(){ 
	      return dao.getlist_of_trucks();
	  	
	   }

	   
	   @GET 
	   @Path("/driver") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public List<Driver> getListOfDrivers(){ 
	      return dao.viewlist_of_drivers();
	   }
	   
	   @GET 
	   @Path("/add") 
	   @Produces(MediaType.APPLICATION_JSON) 
	   public void setListOfTrucks(@QueryParam("plateNumber") String plateNumber){
		   System.out.println(plateNumber);
	      dao.addlist_of_trucks(plateNumber);
	   }
	
	   
	   @GET
	   @Path("/updateAvailability")
	   @Produces(MediaType.APPLICATION_JSON)
	   public void updateAvailability(@QueryParam("truck_id") String truckId, @QueryParam("status") String status) {
		   dao.Available(status, truckId);
		   
	   }
	   @GET
	   @Path("/driverAvailabilty")
	   @Produces(MediaType.APPLICATION_JSON)
	   public void availableDriver(@QueryParam("driverID") String driverID, @QueryParam("status") String status) {
		   dao.AvailableDriver(status, driverID);
}
}
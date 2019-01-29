package com.finalcasestudy;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "truck")

public class Truck{


	private String truckID;
	private String loadWeight;
	private String model;
	private String maxCapacity; 
	private String plateNumber;
	private String purchasedYear;
	private String isAvailable;
	private String grossWeight;
	private String tareWeight;
	private String yearsInService;

	
	public String getYearsInService() {
		return yearsInService;
	}
	@XmlElement
	public void setYearsInService(String yearsInService) {
		this.yearsInService = yearsInService;
	}
	public String getTruckID() {
		return truckID;
	}
	@XmlElement
	public void setTruckID(String truckID) {
		this.truckID = truckID;
	}

	public String getLoadWeight() {
		return loadWeight;
	}
	@XmlElement
	public void setLoadWeight(String loadWeight) {
		this.loadWeight = loadWeight;
	}

	public String getModel() {
		return model;
	}
	@XmlElement
	public void setModel(String model) {
		this.model = model;
	}

	public String getMaxCapacity() {
		return maxCapacity;
	}
	@XmlElement
	public void setMaxCapacity(String maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public String getPlateNumber() {
		return plateNumber;
	}
	@XmlElement
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getPurchasedYear() {
		return purchasedYear;
	}
	@XmlElement
	public void setPurchasedYear(String purchasedYear) {
		this.purchasedYear = purchasedYear;
	}

	public String getIsAvailable() {
		return isAvailable;
	}
	@XmlElement
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getGrossWeight() {
		return grossWeight;
	}
	@XmlElement
	public void setGrossWeight(String grossWeight) {
		this.grossWeight = grossWeight;
	}

	public String getTareWeight() {
		return tareWeight;
	}
	@XmlElement
	public void setTareWeight(String tareWeight) {
		this.tareWeight = tareWeight;
	}

	
}

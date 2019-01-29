package com.finalcasestudy;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "driver")

public class Driver implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String driverID;
	private String name;
	private String age;
	private String address;
	private String isAvailable;

	
	
	public String getIsAvailable() {
		return isAvailable;
	}
	@XmlElement
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getDriverID() {
		return driverID;
	}
	@XmlElement
	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAge() {
		return age;
	}
	@XmlElement
	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}
	@XmlElement
	public void setAddress(String address) {
		this.address = address;
	}

}

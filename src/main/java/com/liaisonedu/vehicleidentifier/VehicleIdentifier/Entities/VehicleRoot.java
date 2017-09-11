package com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="vehicles")
public class VehicleRoot {
	@XmlElement(name="vehicle")
    List<Vehicle> vehicles;

	@Override
	public String toString() {
		return "VehicleRoot [vehicles=" + vehicles + ", getVehicles()=" + getVehicles() + "]";
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
}


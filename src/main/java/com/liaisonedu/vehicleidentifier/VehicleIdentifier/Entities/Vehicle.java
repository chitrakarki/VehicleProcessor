package com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="vehicle")
public class Vehicle {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((powertrain == null) ? 0 : powertrain.getPowertrainType().toString().toLowerCase().hashCode());
		result = prime * result + ((vehicleFrame == null) ? 0 : vehicleFrame.getMaterial().toString().toLowerCase().hashCode());
		result = prime * result + ((wheels == null) ? 0 : wheels.size());
		result = prime * result + ((wheels == null) ? 0 : wheels.get(0).getMaterial().toLowerCase().toString().hashCode());
		return result;
	}

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param vehicleId
	 * @param wheels
	 * @param vehicleFrame
	 * @param powertrain
	 */
	public Vehicle(String vehicleId, List<Wheel> wheels, VehicleFrame vehicleFrame, Powertrain powertrain) {
		super();
		this.vehicleId = vehicleId;
		this.wheels = wheels;
		this.vehicleFrame = vehicleFrame;
		this.powertrain = powertrain;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (powertrain == null) {
			if (other.powertrain != null)
				return false;
		} else if (!powertrain.equals(other.powertrain))
			return false;
		if (vehicleFrame == null) {
			if (other.vehicleFrame != null)
				return false;
		} else if (!vehicleFrame.equals(other.vehicleFrame))
			return false;
		if (vehicleId == null) {
			if (other.vehicleId != null)
				return false;
		} else if (!vehicleId.equals(other.vehicleId))
			return false;
		if (wheels == null) {
			if (other.wheels != null)
				return false;
		} else if (!wheels.equals(other.wheels))
			return false;
		return true;
	}

	@Override
	public String toString() {

		StringBuilder value = new StringBuilder();

		value.append("Vehicle [vehicleId=");
		value.append(vehicleId);

		value.append(",Wheels ");		
		getWheels().forEach(x -> value.append(x.toString()));

		value.append(", vehicleFrame=");
		value.append(vehicleFrame.getMaterial());

		value.append(", powertrain=");
		value.append(powertrain.getPowertrainType().toString());

		value.append(", numberOfWheels=");
		value.append(this.wheels.size());

		return value.toString();
	}

	@XmlElement(name="id")
	private String vehicleId;

	@XmlElementWrapper(name="wheels")
	@XmlElement(name="wheel")
	private List<Wheel> wheels;

	@XmlElement(name="frame")
	private VehicleFrame vehicleFrame;

	@XmlElement(name="powertrain")
	private Powertrain powertrain;

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String value) {
		vehicleId = value;
	}

	public List<Wheel> getWheels(){
		return wheels;
	}

	public VehicleFrame getVehicleFrame() {
		return vehicleFrame;
	}

	public void setVehicleFrame(VehicleFrame value) {
		vehicleFrame = value;
	}

	public Powertrain getPowertrain() {
		return powertrain;
	}

	public void setPowertrain(Powertrain value) {
		powertrain = value;
	}

	public void setWheels(List<Wheel> wheels) {
		this.wheels = wheels;
	}
}

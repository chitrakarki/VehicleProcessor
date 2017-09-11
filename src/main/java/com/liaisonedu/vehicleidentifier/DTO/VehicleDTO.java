package com.liaisonedu.vehicleidentifier.DTO;

import com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities.Vehicle;
import com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities.Enums.MaterialType;
import com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities.Enums.PowertrainType;

public class VehicleDTO {
	
	private String frameMaterialType;
	private String powertrain;
	private int numberofWheels;
	private String wheelMatertialType;
	private Vehicle vehicle;
	
	/**
	 * default constructor
	 */
	public VehicleDTO() {
		super();
	}
	
	/**
	 * Constructor
	 * 
	 * @param frameMaterialType
	 * @param powertrain
	 * @param numberofWheels
	 * @param wheelMatertialType
	 */
	public VehicleDTO(MaterialType frameMaterialType, PowertrainType powertrain, int numberofWheels, MaterialType wheelMatertialType) {
		this.frameMaterialType = frameMaterialType.toString().toLowerCase();
		this.powertrain = powertrain.toString().toLowerCase();
		this.numberofWheels = numberofWheels;
		this.wheelMatertialType = wheelMatertialType.toString().toLowerCase();
	}

	public String getFrameMaterialType() {
		return frameMaterialType;
	}
	public void setFrameMaterialType(String frameMaterialType) {
		this.frameMaterialType = frameMaterialType;
	}
	public String getPowertrain() {
		return powertrain;
	}
	public void setPowertrain(String powertrain) {
		this.powertrain = powertrain;
	}
	public int getNumberofWheels() {
		return numberofWheels;
	}
	public void setNumberofWheels(int numberofWheels) {
		this.numberofWheels = numberofWheels;
	}
	public String getWheelMatertialType() {
		return wheelMatertialType;
	}
	public void setWheelMatertialType(String wheelMatertialType) {
		this.wheelMatertialType = wheelMatertialType;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((powertrain == null) ? 0 : powertrain.hashCode());
		result = prime * result + ((frameMaterialType == null) ? 0 : frameMaterialType.hashCode());
		result = prime * result + (numberofWheels);
		result = prime * result + ((wheelMatertialType == null) ? 0 : wheelMatertialType.hashCode());
		return result;
	}
}

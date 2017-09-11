package com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities.Enums.PowertrainType;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="powertrain")
public class Powertrain {
	
	private PowertrainType powertrainType;
	
	public Powertrain() {
		super();
	}

	public Powertrain(PowertrainType powertrainType) {
		super();
		this.powertrainType = powertrainType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((powertrainType == null) ? 0 : powertrainType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Powertrain other = (Powertrain) obj;
		if (powertrainType != other.powertrainType)
			return false;
		return true;
	}

	public PowertrainType getPowertrainType() {
		return powertrainType;
	}
	
	@XmlElement(name="human")
	public String getHuman() {
		return PowertrainType.Human.toString();
	}
	
	public void setHuman(String value) {
		powertrainType = PowertrainType.Human;
	}
	
	@XmlElement(name="bernoulli")
	public String getBernoulli() {
		return PowertrainType.Bernoulli.toString();
	}
	
	public void setBernoulli(String value) {
		powertrainType = PowertrainType.Bernoulli;
	}
	
	@XmlElement(name="internal_combustion")
	public String getInternalCombustion() {
		return PowertrainType.Internal_combustion.toString();
	}
	
	public void setInternalCombustion(String value) {
		powertrainType = PowertrainType.Internal_combustion;
	}
}

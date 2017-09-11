package com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="frame")
public class VehicleFrame {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		return result;
	}

	public VehicleFrame() {
		super();
	}

	public VehicleFrame(String material) {
		super();
		this.material = material;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleFrame other = (VehicleFrame) obj;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		return true;
	}

	@XmlElement(name="material")
	private String material;
	
	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String value) {
		material = value;
	}
}

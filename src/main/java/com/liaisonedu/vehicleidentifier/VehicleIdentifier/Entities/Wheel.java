package com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="wheel")
public class Wheel {
	
	@Override
	public String toString() {
		
		StringBuilder value = new StringBuilder();
		
		value.append(" Wheel position=");
		value.append(position);
				
		value.append(", material=");
		value.append(material);
		
		return value.toString();
	}

	public Wheel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wheel(String position, String material) {
		super();
		this.position = position;
		this.material = material;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((material == null) ? 0 : material.hashCode());
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
		Wheel other = (Wheel) obj;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	@XmlElement(name="position")
	private String position;
	@XmlElement(name="material")
	private String material;
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String value) {
		position = value;
	}
	
	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String value) {
		material = value;
	}
}

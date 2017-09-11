package com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities.Enums;

public enum VehicleType {
	Big_Wheel("Big Wheel"),
    Bicycle("Bicycle"),
    Motercycle("Motercycle"),
    Hang_Glider("Hang Glider"),
    Car("Car");
 
    private String name;

	VehicleType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
    @Override public String toString() { return name; }
}

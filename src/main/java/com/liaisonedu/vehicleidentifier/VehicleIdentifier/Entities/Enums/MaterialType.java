package com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities.Enums;

public enum MaterialType {
	Plastic("Plastic"),
	Metal("Metal"),
	None("");
	
	
	private String name;

	MaterialType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
    @Override public String toString() { return name; }
}

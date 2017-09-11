package com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities.Enums;

public enum PowertrainType {	
	Human("Human"),
	Bernoulli("Bernoulli"),
	Internal_combustion("Internal Combustion");
	
    private String name;

    PowertrainType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
    @Override public String toString() { return name; }

}

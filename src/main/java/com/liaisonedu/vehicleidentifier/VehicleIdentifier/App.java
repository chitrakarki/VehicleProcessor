package com.liaisonedu.vehicleidentifier.VehicleIdentifier;

import com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities.VehicleRoot;

/**
 * Hello world!
 *
 */
public class App 
{	
    public static void main( String[] args )
    {
        Util util = new Util();
        
        VehicleRoot vehicleRoot = util.TransformXMLToVehicles("vehicles.xml");
        
        util.InitializeVehicleTypes();
        util.IdentifyVehicleTypes(vehicleRoot);
        
        util.IdentifyVehicleTypesForLoop(vehicleRoot);
    }   
}

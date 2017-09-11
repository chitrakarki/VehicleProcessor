package com.liaisonedu.vehicleidentifier.VehicleIdentifier;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities.Powertrain;
import com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities.Vehicle;
import com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities.VehicleFrame;
import com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities.VehicleRoot;
import com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities.Wheel;
import com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities.Enums.PowertrainType;
import com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities.Enums.VehicleType;

import junit.framework.TestCase;

public class UtilTest extends TestCase {

	VehicleRoot mockedVehicleRoot;
	Vehicle vehicle1;
	Vehicle vehicle2;
	List<Vehicle> vehicles;

	public void setUp() throws Exception {
		super.setUp();
		//Create mock object of VehicleRoot
		mockedVehicleRoot = mock(VehicleRoot.class);

		//Create few instances of Vehicle class.
		List<Wheel> wheels1 = new ArrayList<Wheel>();
		wheels1.add(new Wheel("left rear", "plastic"));
		wheels1.add(new Wheel("right rear","plastic"));
		wheels1.add(new Wheel("front", "plastic"));

		vehicle1 = new Vehicle("vehicle 1",wheels1,new VehicleFrame("plastic"), new Powertrain(PowertrainType.Human));

		List<Wheel> wheels2 = new ArrayList<Wheel>();
		wheels2.add(new Wheel("rear", "metal"));
		wheels2.add(new Wheel("front","metal"));
		vehicle2 = new Vehicle("vehicle 2",wheels2,new VehicleFrame("metal"), new Powertrain(PowertrainType.Human));

		//Stubbing the methods of mocked BookDAL with mocked data. 
		when(mockedVehicleRoot.getVehicles()).thenReturn(Arrays.asList(vehicle1, vehicle2));
	}

	public void tearDown() throws Exception {
		super.tearDown();
	}

	public void testIdentifyVehicleTypes() throws Exception {
		Util nUtil = new Util();
		nUtil.InitializeVehicleTypes();
		// mockedVehicleRoot.setVehicles(vehicles);;

		int hashcode = vehicle1.hashCode();
		if (nUtil.vehicleTypes.containsKey(hashcode)) {
			VehicleType vehicleType1 = nUtil.vehicleTypes.get(vehicle1.hashCode());
			VehicleType vehicleType2 = nUtil.vehicleTypes.get(vehicle2.hashCode());
			assertNotNull(vehicleType1);
			assertNotNull(vehicleType2);
			//positive test case
			assertEquals(VehicleType.Big_Wheel.toString(), vehicleType1.toString());
			//negative test case
			assertFalse(VehicleType.Motercycle.toString().equals(vehicleType2.toString()));
		}
	}
}

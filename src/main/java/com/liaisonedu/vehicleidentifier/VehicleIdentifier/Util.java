package com.liaisonedu.vehicleidentifier.VehicleIdentifier;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.liaisonedu.vehicleidentifier.DTO.VehicleDTO;
import com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities.Vehicle;
import com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities.VehicleRoot;
import com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities.Enums.MaterialType;
import com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities.Enums.PowertrainType;
import com.liaisonedu.vehicleidentifier.VehicleIdentifier.Entities.Enums.VehicleType;

public class Util {

	public Map<Integer, VehicleType> vehicleTypes = new HashMap<Integer, VehicleType>();
	public Map<VehicleType, List<String>> finalVehicleTypes = new HashMap<VehicleType, List<String>>();

	private Hashtable<String, Vehicle> vehiclesDataSet = new Hashtable<String, Vehicle>();

	public VehicleRoot TransformXMLToVehicles(String fileName) {

		try {

			JAXBContext context = JAXBContext.newInstance(VehicleRoot.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();

			ClassLoader classLoader = getClass().getClassLoader();
			InputStream inputStream = classLoader.getResourceAsStream(fileName);

			VehicleRoot vehicleRoot = (VehicleRoot) unmarshaller.unmarshal(inputStream);

			return vehicleRoot;

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public void InitializeVehicleTypes() {

		vehicleTypes.put(new VehicleDTO(MaterialType.Plastic, PowertrainType.Human, 3, MaterialType.Plastic).hashCode(),
				VehicleType.Big_Wheel);
		vehicleTypes.put(new VehicleDTO(MaterialType.Metal, PowertrainType.Human, 2, MaterialType.Metal).hashCode(),
				VehicleType.Bicycle);
		vehicleTypes.put(new VehicleDTO(MaterialType.Metal, PowertrainType.Internal_combustion, 2, MaterialType.Metal)
				.hashCode(), VehicleType.Motercycle);
		vehicleTypes.put(
				new VehicleDTO(MaterialType.Plastic, PowertrainType.Bernoulli, 0, MaterialType.None).hashCode(),
				VehicleType.Hang_Glider);
		vehicleTypes.put(new VehicleDTO(MaterialType.Plastic, PowertrainType.Human, 4, MaterialType.Plastic).hashCode(),
				VehicleType.Car);
	}

	public void IdentifyVehicleTypes(VehicleRoot vehicleRoot) {

		// Map<Integer, Long> allVehicles = vehicleRoot.getVehicles().stream().collect(
		// Collectors.groupingBy(Vehicle::hashCode, Collectors.counting()));

		vehicleRoot.getVehicles().forEach(vehicle -> {
			int hashcode = vehicle.hashCode();
			if (vehicleTypes.containsKey(hashcode)) {
				VehicleType type = vehicleTypes.get(vehicle.hashCode());

				if (finalVehicleTypes.containsKey(type)) {
					finalVehicleTypes.get(type).add(vehicle.getVehicleId());
				} else {
					finalVehicleTypes.put(type, new ArrayList<String>());
					finalVehicleTypes.get(type).add(vehicle.getVehicleId());
				}

				System.out.println("-- vehicle id -- " + vehicle.getVehicleId());
				System.out.println("-- vehicle type -- " + type.toString());
			}
		});
	}

	public void IdentifyVehicleTypesForLoop(VehicleRoot vehicleRoot) {

		List<Vehicle> vehicles = vehicleRoot.getVehicles();

		vehicles.forEach((x) -> {
			System.out.println();

			System.out.println(" id: " + x.getVehicleId() + " vehicle type: ");

			if (x.getPowertrain().getPowertrainType().toString().equalsIgnoreCase(PowertrainType.Human.toString())
					&& x.getVehicleFrame().getMaterial().equalsIgnoreCase("Plastic") && x.getWheels().size() == 3) {
				vehiclesDataSet.put(VehicleType.Big_Wheel.toString(), x);
				System.out.print(VehicleType.Big_Wheel.toString());
			}
			if (x.getPowertrain().getPowertrainType().toString().equalsIgnoreCase(PowertrainType.Human.toString())
					&& x.getVehicleFrame().getMaterial().equalsIgnoreCase("Metal") && x.getWheels().size() == 2) {
				vehiclesDataSet.put(VehicleType.Bicycle.toString(), x);
				System.out.print(VehicleType.Bicycle.toString());
			}
			if (x.getPowertrain().getPowertrainType().toString()
					.equalsIgnoreCase(PowertrainType.Internal_combustion.toString())
					&& x.getVehicleFrame().getMaterial().equalsIgnoreCase("Metal") && x.getWheels().size() == 2) {
				vehiclesDataSet.put(VehicleType.Motercycle.toString(), x);
				System.out.print(VehicleType.Motercycle.toString());
			}
			if (x.getPowertrain().getPowertrainType().toString().equalsIgnoreCase(PowertrainType.Bernoulli.toString())
					&& x.getVehicleFrame().getMaterial().equalsIgnoreCase("Plastic") && x.getWheels().size() == 0) {
				vehiclesDataSet.put(VehicleType.Hang_Glider.toString(), x);
				System.out.print(VehicleType.Hang_Glider.toString());

			}
			if (x.getPowertrain().getPowertrainType().toString()
					.equalsIgnoreCase(PowertrainType.Internal_combustion.toString())
					&& x.getVehicleFrame().getMaterial().equalsIgnoreCase("Metal") && x.getWheels().size() == 4) {
				vehiclesDataSet.put(VehicleType.Car.toString(), x);
				System.out.print(VehicleType.Car.toString());

			}

		});
	}
}

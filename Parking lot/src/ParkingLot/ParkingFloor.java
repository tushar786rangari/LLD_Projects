package ParkingLot;

import Vehicle.Vehicle;
import Vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    List<ParkingSpot> parkingSpotList;
    private final String floorId;

    public ParkingFloor(String floorId, int noOfCars, int noOfBikes) {
        this.floorId = floorId;
        parkingSpotList = new ArrayList<ParkingSpot>();
        for(int i=1;i<=noOfCars;i++){
            parkingSpotList.add(new ParkingSpot(VehicleType.car,"C"+i));
        }
        for(int i=1;i<=noOfBikes;i++){
            parkingSpotList.add(new ParkingSpot(VehicleType.bike,"B"+i));
        }
    }

    public ParkingSpot findAvailableParkingSpot(Vehicle vehicle) {
        for(ParkingSpot spot : parkingSpotList){
            if(spot.IsAvailable() && spot.getVehicleType() == vehicle.getType())
                return spot;
        }
        return null;
    }
}

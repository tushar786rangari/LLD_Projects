package ParkingLot;

import Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<ParkingFloor> parkingFloorList;
    public ParkingLot(String lotId,int floors,int noOfCars,int noOfBikes) {
        parkingFloorList = new ArrayList<ParkingFloor>();
        for(int i=1;i<=floors;i++){
            parkingFloorList.add(new ParkingFloor("F"+i,noOfCars,noOfBikes));
        }
    }

    public ParkingSpot assignSpot(Vehicle vehicle) {
        for(var floor : parkingFloorList){
            ParkingSpot spot = floor.findAvailableParkingSpot(vehicle);
            if(spot != null){
                spot.parkVehicle();
                return spot;
            }
        }
        return null;
    }
}

package ParkingLot;

import Vehicle.VehicleType;

public class ParkingSpot {
    private boolean occupied;
    private VehicleType vehicleType;
    private final String spotId;

    public ParkingSpot(VehicleType vehicleType,String spotId) {
        this.occupied = false;
        this.vehicleType = vehicleType;
        this.spotId = spotId;
    }

    public boolean IsAvailable() {
        return !occupied;
    }

    public void ParkTheVehicle() {
        occupied = true;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void parkVehicle() {
        occupied = true;
    }

    public void removeVehicle() {
        occupied = false;
    }
}

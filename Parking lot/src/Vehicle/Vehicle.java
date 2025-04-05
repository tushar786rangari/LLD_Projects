package Vehicle;


public class Vehicle {
    private final String liscenceNumber;
    private final VehicleType type;

    public Vehicle(String liscenceNumber, VehicleType type) {
        this.liscenceNumber = liscenceNumber;
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }
}



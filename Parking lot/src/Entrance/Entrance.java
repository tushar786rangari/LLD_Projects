package Entrance;

import ParkingLot.ParkingLot;
import Ticket.Ticket;
import Vehicle.Vehicle;
import ParkingLot.ParkingSpot;


public class Entrance {
    private final ParkingLot parkingLot;
    private static int ticketCounter = 1;

    public Entrance(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket generateTicket(Vehicle vehicle) {
        ParkingSpot spot = parkingLot.assignSpot(vehicle);
        if(spot == null) {
            System.out.println("There is no available parking spot, plz go somewhere else");
            return null;
        }

        return new Ticket("T" + ticketCounter++,vehicle,spot);
    }
}

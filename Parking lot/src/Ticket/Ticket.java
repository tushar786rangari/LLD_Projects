package Ticket;

import ParkingLot.ParkingSpot;
import Vehicle.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Ticket {
    private ParkingSpot spot;
    private Vehicle vehicle;
    private String ticketId;
    private LocalDateTime entryTime ;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalDateTime.now().minus(new Random().nextInt(1000) + 60, ChronoUnit.MINUTES);
    }

    public long getDuration(){
        return Duration.between(entryTime, LocalDateTime.now()).toMinutes();
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public String getTicketId() {
        return ticketId;
    }

}

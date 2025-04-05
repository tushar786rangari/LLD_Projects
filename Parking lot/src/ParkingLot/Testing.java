//package ParkingLot;
//
//
//public class ParkingSystem {
//    public static void main(String[] args) {
//        ParkingLot parkingLot = new ParkingLot("Lot1", 2, 5, 5);
//        Entrance entrance = new Entrance(parkingLot);
//        Exit exit = new Exit();
//
//        Vehicle car = new Car("ABC123");
//        Ticket ticket = entrance.generateTicket(car);
//
//        if (ticket != null) {
//            System.out.println("Ticket issued: " + ticket.getDuration() + " minutes");
//            exit.processPayment(ticket);
//        }
//    }
//}
//
//
//import java.util.*;
//
//class Entrance {
//    private ParkingLot parkingLot;
//    private static int ticketCounter = 1;
//
//    public Entrance(ParkingLot parkingLot) {
//        this.parkingLot = parkingLot;
//    }
//
//    public Ticket generateTicket(Vehicle vehicle) {
//        ParkingSpot spot = parkingLot.assignSpot(vehicle);
//        if (spot == null) {
//            System.out.println("No available spots!");
//            return null;
//        }
//        return new Ticket("T" + ticketCounter++, vehicle, spot);
//    }
//}
//
//class Exit {
//    public void processPayment(Ticket ticket) {
//        int amount = Payment.calculateFee(ticket);
//        System.out.println("Payment of $" + amount + " received. Thank you!");
//        ticket.spot.removeVehicle();
//    }
//}
//
//
//import java.time.*;
//
//class Ticket {
//    private String ticketId;
//    private Vehicle vehicle;
//    private LocalDateTime entryTime;
//    private ParkingSpot spot;
//
//    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot spot) {
//        this.ticketId = ticketId;
//        this.vehicle = vehicle;
//        this.entryTime = LocalDateTime.now();
//        this.spot = spot;
//    }
//
//    public long getDuration() {
//        return Duration.between(entryTime, LocalDateTime.now()).toMinutes();
//    }
//}
//
//class Payment {
//    private static final int RATE_PER_HOUR = 10;
//
//    public static int calculateFee(Ticket ticket) {
//        long minutes = ticket.getDuration();
//        return (int) Math.ceil(minutes / 60.0) * RATE_PER_HOUR;
//    }
//}
//
//
//import java.util.*;
//
//class ParkingLot {
//    private String lotId;
//    private List<ParkingFloor> floors;
//
//    public ParkingLot(String lotId, int numFloors, int carSpotsPerFloor, int bikeSpotsPerFloor) {
//        this.lotId = lotId;
//        this.floors = new ArrayList<>();
//        for (int i = 0; i < numFloors; i++) {
//            floors.add(new ParkingFloor("F" + i, carSpotsPerFloor, bikeSpotsPerFloor));
//        }
//    }
//
//    public ParkingSpot assignSpot(Vehicle vehicle) {
//        for (ParkingFloor floor : floors) {
//            ParkingSpot spot = floor.findAvailableSpot(vehicle.getType());
//            if (spot != null) {
//                spot.parkVehicle();
//                return spot;
//            }
//        }
//        return null;
//    }
//}
//
//
//import java.util.*;
//
//class ParkingFloor {
//    private String floorId;
//    private List<ParkingSpot> spots;
//
//    public ParkingFloor(String floorId, int carSpots, int bikeSpots) {
//        this.floorId = floorId;
//        this.spots = new ArrayList<>();
//
//        for (int i = 0; i < carSpots; i++) {
//            spots.add(new ParkingSpot("C" + i, VehicleType.CAR));
//        }
//        for (int i = 0; i < bikeSpots; i++) {
//            spots.add(new ParkingSpot("B" + i, VehicleType.BIKE));
//        }
//    }
//
//    public ParkingSpot findAvailableSpot(VehicleType type) {
//        for (ParkingSpot spot : spots) {
//            if (spot.getType() == type && spot.isAvailable()) {
//                return spot;
//            }
//        }
//        return null;
//    }
//}
//
//
//class ParkingSpot {
//    private final String spotId;
//    private final VehicleType type;
//    private boolean isOccupied;
//
//    public ParkingSpot(String spotId, VehicleType type) {
//        this.spotId = spotId;
//        this.type = type;
//        this.isOccupied = false;
//    }
//
//    public boolean isAvailable() {
//        return !isOccupied;
//    }
//
//    public void parkVehicle() {
//        isOccupied = true;
//    }
//
//    public void removeVehicle() {
//        isOccupied = false;
//    }
//
//    public VehicleType getType() {
//        return type;
//    }
//}
//
//
//abstract class Vehicle {
//    private String licensePlate;
//    private final VehicleType type;
//
//    public Vehicle(String licensePlate, VehicleType type) {
//        this.licensePlate = licensePlate;
//        this.type = type;
//    }
//
//    public VehicleType getType() {
//        return type;
//    }
//}
//
//class Car extends Vehicle {
//    public Car(String licensePlate) {
//        super(licensePlate, VehicleType.CAR);
//    }
//}
//
//class Bike extends Vehicle {
//    public Bike(String licensePlate) {
//        super(licensePlate, VehicleType.BIKE);
//    }
//}
//
//enum VehicleType {
//    CAR, BIKE, TRUCK
//}
//

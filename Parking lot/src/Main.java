import Entrance.Entrance;
import Entrance.Exit;
import ParkingLot.ParkingLot;
import Ticket.Ticket;
import Vehicle.Vehicle;
import Vehicle.Car;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot("Lot1",2,5,5);

        Entrance entrance = new Entrance(parkingLot);

        Vehicle Car = new Car("car1");
        //Vehicle Car2 = new Car("car2");

        Ticket ticket = entrance.generateTicket(Car);
        //Ticket ticket2 = entrance.generateTicket(Car2);

        if (ticket != null) {
            System.out.println("Ticket issued: " + ticket.getDuration() + " minutes and ticketId: " + ticket.getTicketId());
            Exit exit = new Exit();
            exit.calculatePayment(ticket);
        }

//        if (ticket2 != null) {
//            System.out.println("Ticket issued: " + ticket2.getDuration() + " minutes and ticketId: " + ticket2.getTicketId());
//            Exit exit = new Exit();
//            exit.calculatePayment(ticket2);
//        }
    }
}
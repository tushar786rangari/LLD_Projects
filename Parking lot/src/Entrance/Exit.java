package Entrance;

import Payment.Payment;
import Ticket.Ticket;

import java.sql.Time;

public class Exit {
    public void calculatePayment(Ticket ticket){
        long amount = Payment.calculatePayment(ticket);
        System.out.println("Payment of $" + amount + " received. Thank you!");
        ticket.getSpot().removeVehicle();
    }
}

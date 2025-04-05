package Payment;

import Ticket.Ticket;

public class Payment {
    private static final int RATE_PER_HOUR = 10;

    public static int calculatePayment(Ticket ticket){
        long minutes = ticket.getDuration();
        return (int) Math.ceil(minutes / 60.0) * RATE_PER_HOUR;
    }
}

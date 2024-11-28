import model.*;

public class Main {
    public static void main(String[] args) {
        TicketMachine machine = new TicketMachine();

        machine.selectTicket();
        machine.insertMoney();
        machine.dispenseTicket();
        machine.selectTicket();
    }
}

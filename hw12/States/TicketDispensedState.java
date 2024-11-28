package States;

import model.TicketMachine;

public class TicketDispensedState implements State {
    private TicketMachine machine;

    public TicketDispensedState(TicketMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectTicket() {
        System.out.println("Завершите текущую операцию перед выбором нового билета.");
    }

    @Override
    public void insertMoney() {
        System.out.println("Завершите текущую операцию.");
    }

    @Override
    public void dispenseTicket() {
        System.out.println("Билет уже выдан.");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Операция завершена, отмена невозможна.");
    }
}


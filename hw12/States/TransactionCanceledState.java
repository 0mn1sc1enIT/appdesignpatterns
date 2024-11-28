package States;

import model.TicketMachine;

public class TransactionCanceledState implements State {
    private TicketMachine machine;

    public TransactionCanceledState(TicketMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectTicket() {
        System.out.println("Транзакция отменена. Выберите новый билет.");
        machine.setState(machine.getIdleState());
    }

    @Override
    public void insertMoney() {
        System.out.println("Транзакция отменена. Выберите новый билет.");
    }

    @Override
    public void dispenseTicket() {
        System.out.println("Выдача билета невозможна. Транзакция отменена.");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Транзакция уже отменена.");
    }
}


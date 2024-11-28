package States;

import model.TicketMachine;

public class IdleState implements State {
    private TicketMachine machine;

    public IdleState(TicketMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectTicket() {
        System.out.println("Билет выбран. Ожидание внесения денег.");
        machine.setState(machine.getWaitingForMoneyState());
    }

    @Override
    public void insertMoney() {
        System.out.println("Сначала выберите билет.");
    }

    @Override
    public void dispenseTicket() {
        System.out.println("Выдача билета невозможна. Выберите билет.");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Транзакция не начата.");
    }
}


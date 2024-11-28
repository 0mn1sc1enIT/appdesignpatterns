package States;

import model.TicketMachine;

public class WaitingForMoneyState implements State {
    private TicketMachine machine;

    public WaitingForMoneyState(TicketMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectTicket() {
        System.out.println("Билет уже выбран. Внесите деньги.");
    }

    @Override
    public void insertMoney() {
        System.out.println("Деньги внесены. Ожидание выдачи билета.");
        machine.setState(machine.getMoneyReceivedState());
    }

    @Override
    public void dispenseTicket() {
        System.out.println("Выдача билета невозможна без оплаты.");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Транзакция отменена.");
        machine.setState(machine.getTransactionCanceledState());
    }
}


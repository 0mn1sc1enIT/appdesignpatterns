package States;

import model.TicketMachine;

public class MoneyReceivedState implements State {
    private TicketMachine machine;

    public MoneyReceivedState(TicketMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectTicket() {
        System.out.println("Билет уже выбран и оплачен.");
    }

    @Override
    public void insertMoney() {
        System.out.println("Деньги уже внесены.");
    }

    @Override
    public void dispenseTicket() {
        System.out.println("Выдача билета...");
        machine.setState(machine.getTicketDispensedState());
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Транзакция отменена. Возврат денег.");
        machine.setState(machine.getTransactionCanceledState());
    }
}


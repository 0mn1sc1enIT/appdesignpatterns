package model;

import States.*;
public class TicketMachine {
    private State idleState;
    private State waitingForMoneyState;
    private State moneyReceivedState;
    private State ticketDispensedState;
    private State transactionCanceledState;

    private State currentState;

    public TicketMachine() {
        idleState = new IdleState(this);
        waitingForMoneyState = new WaitingForMoneyState(this);
        moneyReceivedState = new MoneyReceivedState(this);
        ticketDispensedState = new TicketDispensedState(this);
        transactionCanceledState = new TransactionCanceledState(this);

        currentState = idleState; // начальное состояние
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public State getIdleState() {
        return idleState;
    }

    public State getWaitingForMoneyState() {
        return waitingForMoneyState;
    }

    public State getMoneyReceivedState() {
        return moneyReceivedState;
    }

    public State getTicketDispensedState() {
        return ticketDispensedState;
    }

    public State getTransactionCanceledState() {
        return transactionCanceledState;
    }

    public void selectTicket() {
        currentState.selectTicket();
    }

    public void insertMoney() {
        currentState.insertMoney();
    }

    public void dispenseTicket() {
        currentState.dispenseTicket();
    }

    public void cancelTransaction() {
        currentState.cancelTransaction();
    }
}

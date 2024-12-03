public class Main {
    public class BookingSystem {
        private BookingState currentState;

        public BookingSystem() {
            this.currentState = new IdleState(this);
        }

        public void setState(BookingState state) {
            this.currentState = state;
        }

        public void selectRoom() {
            currentState.selectRoom();
        }

        public void confirmBooking() {
            currentState.confirmBooking();
        }

        public void makePayment() {
            currentState.makePayment();
        }

        public void cancelBooking() {
            currentState.cancelBooking();
        }
    }

    interface BookingState {
        void selectRoom();
        void confirmBooking();
        void makePayment();
        void cancelBooking();
    }

    class IdleState implements BookingState {
        private BookingSystem bookingSystem;

        public IdleState(BookingSystem bookingSystem) {
            this.bookingSystem = bookingSystem;
        }

        @Override
        public void selectRoom() {
            System.out.println("Room selected. Moving to RoomSelected state.");
            bookingSystem.setState(new RoomSelectedState(bookingSystem));
        }

        @Override
        public void confirmBooking() {
            System.out.println("Cannot confirm booking. No room selected.");
        }

        @Override
        public void makePayment() {
            System.out.println("Cannot make payment. No booking confirmed.");
        }

        @Override
        public void cancelBooking() {
            System.out.println("No booking to cancel.");
        }
    }

    class RoomSelectedState implements BookingState {
        private BookingSystem bookingSystem;

        public RoomSelectedState(BookingSystem bookingSystem) {
            this.bookingSystem = bookingSystem;
        }

        @Override
        public void selectRoom() {
            System.out.println("Room already selected.");
        }

        @Override
        public void confirmBooking() {
            System.out.println("Booking confirmed. Moving to BookingConfirmed state.");
            bookingSystem.setState(new BookingConfirmedState(bookingSystem));
        }

        @Override
        public void makePayment() {
            System.out.println("Cannot make payment. Booking not confirmed.");
        }

        @Override
        public void cancelBooking() {
            System.out.println("Booking cancelled. Returning to Idle state.");
            bookingSystem.setState(new IdleState(bookingSystem));
        }
    }

    class BookingConfirmedState implements BookingState {
        private BookingSystem bookingSystem;

        public BookingConfirmedState(BookingSystem bookingSystem) {
            this.bookingSystem = bookingSystem;
        }

        @Override
        public void selectRoom() {
            System.out.println("Room already selected.");
        }

        @Override
        public void confirmBooking() {
            System.out.println("Booking already confirmed.");
        }

        @Override
        public void makePayment() {
            System.out.println("Payment successful. Moving to Paid state.");
            bookingSystem.setState(new PaidState(bookingSystem));
        }

        @Override
        public void cancelBooking() {
            System.out.println("Booking cancelled. Returning to Idle state.");
            bookingSystem.setState(new IdleState(bookingSystem));
        }
    }

    class PaidState implements BookingState {
        private BookingSystem bookingSystem;

        public PaidState(BookingSystem bookingSystem) {
            this.bookingSystem = bookingSystem;
        }

        @Override
        public void selectRoom() {
            System.out.println("Cannot select room. Booking is already paid.");
        }

        @Override
        public void confirmBooking() {
            System.out.println("Cannot confirm booking. Booking is already paid.");
        }

        @Override
        public void makePayment() {
            System.out.println("Payment already made.");
        }

        @Override
        public void cancelBooking() {
            System.out.println("Cannot cancel. Booking is already paid.");
        }
    }

    public void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();

        bookingSystem.selectRoom();
        bookingSystem.cancelBooking();
        bookingSystem.confirmBooking();
        bookingSystem.makePayment();
        bookingSystem.cancelBooking();
    }
}

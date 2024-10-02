package model;

public class Invoice implements Document {
    @Override
    public void open() {
        System.out.println("Идет открытие счета...");
    }
}

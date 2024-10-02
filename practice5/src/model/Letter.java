package model;

public class Letter implements Document {
    @Override
    public void open() {
        System.out.println("Идет открытие письма...");
    }
}

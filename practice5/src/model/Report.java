package model;

public class Report implements Document {
    @Override
    public void open() {
        System.out.println("Идет открытие отчета...");
    }
}

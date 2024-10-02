package model;

public class Resume implements Document {
    @Override
    public void open() {
        System.out.println("Идет открытие резюме...");
    }
}

package Model;

public class Thermostat {
    private double temperature;

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println(STR."Температура установлена на \{temperature} градусов");
    }

    public void increaseTemperature(int temperature) {
        this.temperature += temperature;
        System.out.println(STR."Температура увеличена до \{this.temperature} градусов");
    }

    public void decreaseTemperature(int temperature) {
        this.temperature -= temperature;
        System.out.println(STR."Температура уменьшена до \{this.temperature} градусов");
    }
}
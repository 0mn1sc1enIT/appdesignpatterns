import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements ISubject {
    private List<IObserver> observers;
    private float temperature;
    public WeatherStation() {
        this.observers = new ArrayList<IObserver>();
    }

    @Override
    public void RegisterObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void RemoveObserver(IObserver observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        } else {
            System.out.println("Нет такого наблюдателя");
        }
    }

    @Override
    public void NotifyObservers() {
        for (var observer: observers) {
            observer.Update(temperature);
        }
    }
    public void SetTemperature(float newTemperature) {
        if (checkTemperature(newTemperature)) {
            System.out.println(STR."Изменение температуры: \{newTemperature}°C");
            this.temperature = newTemperature;
            NotifyObservers();
        } else {
            System.out.println(STR."Температура \{newTemperature} имеет некорректное значение");
            NotifyObservers();
        }
    }
    public boolean checkTemperature(float temperature) {
        return temperature >= -89.2 && temperature <= 10000;
    }
}

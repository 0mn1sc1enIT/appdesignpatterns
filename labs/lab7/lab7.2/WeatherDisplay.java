public class WeatherDisplay implements IObserver {
    private String name;

    public WeatherDisplay(String name) {
        this.name = name;
    }
    @Override
    public void Update(float temerature) {
        System.out.println(STR."\{this.name} показывает новую температуру: \{temerature}°C");
    }
}

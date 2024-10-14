public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        WeatherDisplay mobileApp = new WeatherDisplay("Мобильное приложение");
        WeatherDisplay digitalBillboard = new WeatherDisplay("Электронное табло");
        WeatherDisplay email = new WeatherDisplay("Оповещение email");

        weatherStation.RegisterObserver(mobileApp);
        weatherStation.RegisterObserver(digitalBillboard);
        weatherStation.RegisterObserver(email);

        weatherStation.SetTemperature(25.0f);
        weatherStation.SetTemperature(-550.0f);

        weatherStation.RemoveObserver(digitalBillboard);
        weatherStation.SetTemperature(28.0f);
    }
}

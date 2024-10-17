import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public interface IObserver {
        void Update(String subChannel, double price);
    }

    public class Broker implements IObserver {
        String name;
        double previousPrice;

        public Broker(String name) {
            this.name = name;
            this.previousPrice = 0;
        }
        @Override
        public void Update(String subChannel, double price) {
            double oldPrice = previousPrice;
            SetPrice(price);
            System.out.println(STR."\{name} уведомляет об изменении на \{subChannel}: цена изменилась с \{oldPrice} на \{price}");
        }
        public void SetPrice(double price) {
            this.previousPrice = price;
        }
    }

    public class BankBot implements IObserver {
        String name;

        public BankBot(String name) {
            this.name = name;
        }

        @Override
        public void Update(String subChannel, double price) {
            System.out.println(STR."Бот \{name}: цена на \{subChannel} изменилась: \{price}");
        }
    }

    public class SocialMedia implements IObserver {
        String name;

        public SocialMedia(String name) {
            this.name = name;
        }

        @Override
        public void Update(String subChannel, double price) {
            System.out.println(STR."\{name}: цена на \{subChannel} изменилась: \{price}");
        }
    }

    public interface ISubject {
        void RegisterObserver(String subChannel, IObserver observer);
        void RemoveObserver(String subChannel, IObserver observer);
        void NotifyObservers(String subChannel);
    }

    public class StockExchange implements ISubject {
        private Map<String, List<IObserver>> observers;
        private Map<String, Double> stockPrices;

        public StockExchange() {
            observers = new HashMap<>();
            stockPrices = new HashMap<>();
        }

        @Override
        public void RegisterObserver(String subChannel, IObserver observer) {
            observers.computeIfAbsent(subChannel, k -> new ArrayList<>()).add(observer);
        }

        @Override
        public void RemoveObserver(String subChannel, IObserver observer) {
            if (observers.containsKey(subChannel)) {
                observers.get(subChannel).remove(observer);
            }
        }

        @Override
        public void NotifyObservers(String subChannel) {
            if (observers.containsKey(subChannel) && stockPrices.containsKey(subChannel)) {
                for (IObserver observer : observers.get(subChannel)) {
                    observer.Update(subChannel, stockPrices.get(subChannel));
                }
            }
        }

        public void SetStockPrice(String subChannel, double price) {
            stockPrices.put(subChannel, price);
            NotifyObservers(subChannel);
        }
    }

    public void main(String[] args) {
        StockExchange stockExchange = new StockExchange();

        IObserver observer1 = new Broker("Брокер Александр");
        IObserver observer2 = new Broker("Trading news");
        IObserver observer3 = new BankBot("Василий");

        stockExchange.RegisterObserver("Apple", observer1);
        stockExchange.RegisterObserver("Google", observer2);
        stockExchange.RegisterObserver("Google", observer3);
        stockExchange.RegisterObserver("Apple", observer3);

        stockExchange.SetStockPrice("Apple", 150.0);
        stockExchange.SetStockPrice("Google", 280.0);

        stockExchange.RemoveObserver("Apple", observer3);

        stockExchange.SetStockPrice("Apple", 155.0);
    }
}

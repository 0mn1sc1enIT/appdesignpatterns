import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {
    public interface IObserver {
        void Update(String stockSymbol, double price);
    }

    public class Trader implements IObserver {
        private String name;

        public Trader(String name) {
            this.name = name;
        }
        @Override
        public void Update(String stockSymbol, double price) {
            System.out.println(STR."\{name} получил уведомление: \{stockSymbol} -> \{price}");
        }
    }

    public class TradingBot implements IObserver {
        private String name;
        private double threshold;

        public TradingBot(String name, double threshold) {
            this.name = name;
            this.threshold = threshold;
        }
        @Override
        public void Update(String stockSymbol, double price) {
            if (price > threshold) {
                System.out.println(STR."\{name}: Цена \{stockSymbol} превысила \{threshold}, продаю акции.");
            } else {
                System.out.println(STR."\{name}: Цена \{stockSymbol} ниже \{threshold}, покупаю акции.");
            }
        }
    }

    public interface ISubject {
        void RegisterObserver(String stockSymbol, IObserver observer);
        void RemoveObserver(String stockSymbol, IObserver observer);
        void NotifyObservers(String stockSymbol);
    }

    public class StockExchange implements ISubject {
        private Map<String, Double> stocks = new HashMap<>();
        private Map<String, List<IObserver>> observers = new HashMap<>();

        @Override
        public void RegisterObserver(String stockSymbol, IObserver observer) {
            observers.putIfAbsent(stockSymbol, new ArrayList<>());
            if (!observers.get(stockSymbol).contains(observer)) {
                observers.get(stockSymbol).add(observer);
            }
        }
        @Override
        public void RemoveObserver(String stockSymbol, IObserver observer) {
            if (observers.containsKey(stockSymbol)) {
                observers.get(stockSymbol).remove(observer);
            }
        }
        @Override
        public void NotifyObservers(String stockSymbol) {
            if (observers.containsKey(stockSymbol)) {
                for (IObserver observer : observers.get(stockSymbol)) {
                    observer.Update(stockSymbol, stocks.get(stockSymbol));
                }
            }
        }
        public void SetStockPrice(String stockSymbol, double price) {
            stocks.put(stockSymbol, price);
            System.out.println(STR."Цена обновлена для акции: \{stockSymbol} -> \{price}");
            NotifyObservers(stockSymbol);
        }
    }

    public void main(String[] args) {
        StockExchange stockExchange = new StockExchange();
        Trader trader1 = new Trader("Трейдер 1");
        Trader trader2 = new Trader("Трейдер 2");
        TradingBot bot1 = new TradingBot("Бот трейдер", 100.0);

        stockExchange.RegisterObserver("AAPL", trader1);
        stockExchange.RegisterObserver("AAPL", bot1);
        stockExchange.RegisterObserver("GOOG", trader2);

        stockExchange.SetStockPrice("AAPL", 105.0);
        stockExchange.RemoveObserver("AAPL", trader1);
        stockExchange.SetStockPrice("GOOG", 950.0);
        stockExchange.SetStockPrice("AAPL", 90.0);
    }
}

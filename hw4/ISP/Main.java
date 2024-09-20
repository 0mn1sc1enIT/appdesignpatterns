package ISP;

public class Main {
    public interface IPrinter {
        void Print(String content);
    }
    public interface IScanner {
        void Scan(String content);
    }
    public interface IFax {
        void Fax(String content);
    }

    public class AllInOnePrinter implements IPrinter, IScanner, IFax {
        @Override
        public void Print(String content) {
            System.out.println("Printing: " + content);
        }
        @Override
        public void Scan(String content) {
            System.out.println("Scanning: " + content);
        }
        @Override
        public void Fax(String content) {
            System.out.println("Faxing: " + content);
        }
    }

    public class BasicPrinter implements IPrinter {
        @Override
        public void Print(String content) {
            System.out.println("Printing: " + content);
        }
    }
}

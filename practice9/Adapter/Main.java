public class Main {
    public interface IInternalDeliveryService {
        void DeliverOrder(String orderID);
        String GetDeliveryStatus(String orderID);
    }

    public class InternalDeliveryService implements IInternalDeliveryService {
        @Override
        public void DeliverOrder(String orderID) {
            System.out.println(STR."Delivery order: \{orderID}");
        }

        @Override
        public String GetDeliveryStatus(String orderID) {
            return STR."Order status in process: \{orderID}";
        }
    }

    public class ExternalLogisticsServiceGlovo {
        public void ShipItem(int itemID) {
            System.out.println(STR."Ship item: \{itemID}");
        }
        public String TrackShipment(int shipmentID) {
            return STR."Track shipment in process: \{shipmentID}";
        }
    }

    public class LogisticsAdapterGlovo implements IInternalDeliveryService {
        private ExternalLogisticsServiceGlovo logisticsServiceGlovo;

        public LogisticsAdapterGlovo(ExternalLogisticsServiceGlovo logisticsServiceGlovo) {
            this.logisticsServiceGlovo = logisticsServiceGlovo;
        }
        @Override
        public void DeliverOrder(String orderID) {
            int itemID = Integer.parseInt(orderID);
            logisticsServiceGlovo.ShipItem(itemID);
        }

        @Override
        public String GetDeliveryStatus(String orderID) {
            int shipmentID = Integer.parseInt(orderID);
            return logisticsServiceGlovo.TrackShipment(shipmentID);
        }
    }

    public class ExternalLogisticsServiceYandex {
        public void Deliver(String deliveryID) {
            System.out.println(STR."Delivery's progress: \{deliveryID}");
        }
        public String TrackDeliver(String deliveryID) {
            return STR."Tracking delivery: \{deliveryID}";
        }
    }

    public class LogisticsAdapterYandex implements IInternalDeliveryService {
        private ExternalLogisticsServiceYandex logisticsServiceYandex;

        public LogisticsAdapterYandex(ExternalLogisticsServiceYandex logisticsServiceYandex) {
            this.logisticsServiceYandex = logisticsServiceYandex;
        }
        @Override
        public void DeliverOrder(String deliveryID) {
            logisticsServiceYandex.Deliver(deliveryID);
        }

        @Override
        public String GetDeliveryStatus(String deliveryID) {
            return logisticsServiceYandex.TrackDeliver(deliveryID);
        }
    }

    public class ExternalLogisticsServiceWolt {
        public void Travel(int itemID) {
            System.out.println(STR."Travel item goint to you: \{itemID}");
        }
        public String TrackItem(int shipmentID) {
            return STR."Track travelling item: \{shipmentID}";
        }
    }

    public class LogisticsAdapterWolt implements IInternalDeliveryService {
        private ExternalLogisticsServiceWolt logisticsServiceWolt;

        public LogisticsAdapterWolt(ExternalLogisticsServiceWolt logisticsServiceWolt) {
            this.logisticsServiceWolt = logisticsServiceWolt;
        }
        @Override
        public void DeliverOrder(String orderID) {
            int itemID = Integer.parseInt(orderID);
            logisticsServiceWolt.Travel(itemID);
        }

        @Override
        public String GetDeliveryStatus(String orderID) {
            int travelID = Integer.parseInt(orderID);
            return logisticsServiceWolt.TrackItem(travelID);
        }
    }

    public class DeliveryServiceFactory {
        public IInternalDeliveryService GetDeliveryService(String serviceType) {
            switch (serviceType.toLowerCase()) {
                case "glovo":
                    return new LogisticsAdapterGlovo(new ExternalLogisticsServiceGlovo());
                case "yandex":
                    return new LogisticsAdapterYandex(new ExternalLogisticsServiceYandex());
                case "wolt":
                    return new LogisticsAdapterWolt(new ExternalLogisticsServiceWolt());
                default:
                    return new InternalDeliveryService();
            }
        }
    }
    public void main(String[] args) {
        IInternalDeliveryService service = new DeliveryServiceFactory().GetDeliveryService("Glovo");
        System.out.println(service.GetDeliveryStatus("123"));
        service.DeliverOrder("123");

        service = new DeliveryServiceFactory().GetDeliveryService("Yandex");
        System.out.println(service.GetDeliveryStatus("91384"));
        service.DeliverOrder("91384");

        service = new DeliveryServiceFactory().GetDeliveryService("Wolt");
        System.out.println(service.GetDeliveryStatus("22233"));
        service.DeliverOrder("22233");

        service = new DeliveryServiceFactory().GetDeliveryService("");
        System.out.println(service.GetDeliveryStatus("123112"));
        service.DeliverOrder("123112");
    }
}

public class PickUpPointDelivery implements IDelivery {
    @Override
    public void deliverOrder(Order order) {
        System.out.println("Заказ готов к выдаче в пункте самовывоза");
    }
}

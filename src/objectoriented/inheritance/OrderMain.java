package objectoriented.inheritance;

class Order{
    int orderId;
    String orderDate;

    Order(int orderId, String orderDate){
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus(){
        return "Order Placed";
    }
}

class ShippedOrder extends Order{
    String trackingNumber;

    ShippedOrder(int orderId, String orderDate, String trackingNumber){
        super(orderId,orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus(){
        return "Order Shipped Tracking number : " + trackingNumber;
    }
}


class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Delivered on: " + deliveryDate;
    }
}

public class OrderMain {
    public static void main(String[] args) {
        DeliveredOrder d = new DeliveredOrder(101, "12 Jan", "TRK12345", "15 Jan");
        System.out.println(d.getOrderStatus());
    }
}

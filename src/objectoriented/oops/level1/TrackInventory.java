package objectoriented.oops.level1;

class Item{
    String itemCode,itemName;
    double price;

    // method for displaying details
    void displayDetails(){
        System.out.println("ItemCode : " + itemCode);
        System.out.println("ItemName : " + itemName);
        System.out.println("Price : " + price);
    }

    double cost(int quantity){
        return price * quantity;
    }
}

public class TrackInventory {
    public static void main(String[] args) {
        // creating object of class Item
        Item i = new Item();

        // assigning values
        i.itemCode = "W-402";
        i.itemName = "CoffeeMachine";
        i.price = 9459.58;

        // calling display method
        i.displayDetails();

        int quantity = 5;
        // storing and calling cost method
        double totalCost = i.cost(quantity);

        System.out.println("Quantity : " + quantity);
        System.out.println("Cost : " + totalCost);
    }
}

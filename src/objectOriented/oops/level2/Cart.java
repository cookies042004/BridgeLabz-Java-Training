package objectOriented.oops.level2;

class CartItem{
    String itemName;
    int quantity;
    double price;

    // method for adding item in the cart
    void add(int quantity){
        this.quantity += quantity;
        System.out.println("Items in cart : " + this.quantity);
    }

    // method for removing item from the cart
    void remove(int quantity){
        if(quantity <= this.quantity){
            this.quantity -= quantity;
            System.out.println("Items remove from cart : " + quantity);
        }
        else{
            System.out.println("Not enough quantity to remove");
        }
    }

    // method for displaying details
    void displayItems(){
        System.out.println("Product : " + itemName);
        System.out.println("Quantity : " + quantity);
        System.out.println("Price : " + price);
    }
}

public class Cart {
    public static void main(String[] args) {
        // creating object of class CartItem
        CartItem item = new CartItem();

        // assigning values
        item.itemName = "Tablet";
        item.price = 14999;


        // calling add method for adding items in the cart
        item.add(15);

        // calling remove method for removing items from the cart
        item.remove(2);

        // calling method for display items
        item.displayItems();
    }
}

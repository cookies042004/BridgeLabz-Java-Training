package objectoriented.oops.level1;

class MobilePhone{
    String brand,model;
    double price;

    // method for displaying details
    void displayDetails(){
        System.out.println("Brand : " + brand);
        System.out.println("Model : " + model);
        System.out.println("Price : " + price);
    }
}

public class MobilePhoneDetails {
    public static void main(String[] args) {
        // creating objject of class MobilePhone
        MobilePhone m = new MobilePhone();

        // assigning values
        m.brand = "Realme";
        m.model = "RX-2027";
        m.price = 16999;

        // calling method display
        m.displayDetails();
    }
}

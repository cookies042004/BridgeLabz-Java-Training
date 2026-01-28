package generics;

// categories
enum BookCategory {
    EDUCATION, NOVEL
}

enum ClothingCategory {
    MEN, WOMEN
}

enum GadgetCategory {
    MOBILE, LAPTOP
}

// generic product
class Product<T> {
    String name;
    double price;
    T category;

    Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    void display() {
        System.out.println(name + " | Price: " + price + " | Category: " + category);
    }
}

// discount utility
class DiscountUtil {
    static <T extends Product<?>> void applyDiscount(T product, double percent) {
        product.price = product.price - (product.price * percent / 100);
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {

        Product<BookCategory> book =
                new Product<>("Java Programming", 500, BookCategory.EDUCATION);

        Product<ClothingCategory> shirt =
                new Product<>("T-Shirt", 1000, ClothingCategory.MEN);

        Product<GadgetCategory> phone =
                new Product<>("Smartphone", 20000, GadgetCategory.MOBILE);

        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(shirt, 20);
        DiscountUtil.applyDiscount(phone, 5);

        book.display();
        shirt.display();
        phone.display();
    }
}


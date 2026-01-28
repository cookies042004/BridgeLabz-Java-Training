package generics;

import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem{
    String name;

    WarehouseItem(String name){
        this.name = name;
    }

    abstract void display();
}
// class for electronics
class Electronics extends WarehouseItem{
    Electronics(String name){
        super(name);
    }

    void display(){
        System.out.println("Electronics Item :" + name);
    }
}

// class for grocery
class Groceries extends WarehouseItem{
    Groceries(String name){
        super(name);
    }

    void display(){
        System.out.println("Grocery item :" + name);
    }
}

// class for furniture
class Furniture extends WarehouseItem{
    Furniture(String name){
        super(name);
    }

    void display(){
        System.out.println("Furniture items : " + name);
    }
}

// Generic storage
class Storage<T extends WarehouseItem>{
    private List<T> items = new ArrayList<>();

    void addItem(T item){
        items.add(item);
    }

    List<T> getItems(){
        return items;
    }
}

class WarehouseUtil{
    static void displayAllItems(List<? extends WarehouseItem> items){
        for(WarehouseItem item : items){
            item.display();
        }
    }
}

public class SmartWarehouse {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Mobile"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Rice"));
        groceriesStorage.addItem(new Groceries("Sugar"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        System.out.println("---- Electronics ----");
        WarehouseUtil.displayAllItems(electronicsStorage.getItems());

        System.out.println("---- Groceries ----");
        WarehouseUtil.displayAllItems(groceriesStorage.getItems());

        System.out.println("---- Furniture ----");
        WarehouseUtil.displayAllItems(furnitureStorage.getItems());
    }
}

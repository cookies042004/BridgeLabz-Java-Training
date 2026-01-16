package coreprogramming.programming_elements.level1;

public class Profit {
    public static void main(String[] args){
        int costPrice = 129;
        int sellPrice = 191;

        int profit = sellPrice - costPrice;

        double profitPercent = (double)profit / costPrice * 100;

        System.out.printf("The Cost Price is INR %d and Selling Price is INR %d%n " +
                        "The Profit is INR %d and the Profit Percentage is %.2f",
                costPrice,sellPrice,profit,profitPercent);
    }
}

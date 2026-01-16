package coreprogramming.controlflows.level1;

public class SpringSeason {
    public static void main(String[] args){
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        if((month == 3 && day >= 20) || (month == 4) || (month == 5) ||
                (month == 6 && day <= 20)){
            System.out.println("It's a spring season");
        }
        else{
            System.out.println("It's not a spring season");
        }
    }
}

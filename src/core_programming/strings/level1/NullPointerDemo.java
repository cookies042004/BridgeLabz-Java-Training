package core_programming.strings.level1;

public class NullPointerDemo {
    // method to generate NullPointerException
    static void generateException(){
        String text = null;
        System.out.println(text.length());
    }

    // method to handle NullPointerException using try and catch block
    static void handleException(){
        String text = null;

        try{
            System.out.println(text.length());
        }
        catch(NullPointerException e){
            System.out.println("NullPointerException handled : text is null");
        }
    }

    public static void main(String[] args) {
        try{
            generateException();
        }
        catch (NullPointerException e){
            System.out.println("Exception caught in main method");
        }

        handleException();
    }
}

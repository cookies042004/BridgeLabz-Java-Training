package designpatterns;

class Logger{
    private static Logger instance;

    private Logger(){
        System.out.println("Logger Instance");
    }

    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message){
        System.out.println("Log: " + message);
    }
}

public class Singleton {
    public static void main(String[] args) {
        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();

        l1.log("Hello");
        System.out.println(l1 == l2);
    }
}

package exceptionhandling;


import java.util.ArrayList;
import java.util.List;


class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}

public class UserService {
    static List<String> user = new ArrayList<>();
    static void registerUser(String username) throws UserAlreadyExistsException{

        if(user.contains(username)){
            throw new UserAlreadyExistsException(username + " already exists");
        }

        user.add(username);
        System.out.println("User registered: " + username);
    }

    static void checkUserExistence(String username) throws UserNotFoundException{
        if(!user.contains(username)){
            throw new UserNotFoundException("User not found: " + username);
        }

        System.out.println("User exists: " + username);
    }

    public static void main(String[] args) {
        try{
            registerUser("Akhil");
            registerUser("Akhil");
        } catch (UserAlreadyExistsException e){
            System.out.println("Register error: " + e.getMessage());
        }

        try{
            checkUserExistence("Puri");
        } catch (UserNotFoundException e){
            System.out.println("User not exist: " + e.getMessage());
        }
    }
}

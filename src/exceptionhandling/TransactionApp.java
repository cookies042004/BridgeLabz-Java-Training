package exceptionhandling;


class TransactionException extends Exception {
    public TransactionException(String message) {
        super(message);
    }
}

class TransactionService {
    public void processTransaction(String user, double amount)
            throws TransactionException {

        try {
            if (amount < 0) {
                throw new TransactionException("Invalid amount");
            }

            System.out.println("Transaction successful");

        } catch (TransactionException e) {

            // Rethrow with additional context
            throw new TransactionException(
                    "Transaction failed for user: " + user +
                            ". Reason: " + e.getMessage());
        }
    }
}

public class TransactionApp {
    public static void main(String[] args) {
        TransactionService service = new TransactionService();

        try {
            service.processTransaction("Akhil", -500);
        } catch (TransactionException e) {
            System.out.println(e.getMessage());
        }
    }
}


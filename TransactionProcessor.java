
class TransactionException extends Exception {
    public TransactionException(String message) {
        super(message);
    }

    public TransactionException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class TransactionProcessor {
    public void processTransaction(String transactionId) throws TransactionException {
        try {
            performTransaction(transactionId);
        } catch (Exception e) {
            throw new TransactionException("Error processing transaction with ID: " + transactionId, e);
        }
    }
    private void performTransaction(String transactionId) throws Exception {
        if ("fail".equals(transactionId)) {
            throw new Exception("Simulated transaction failure");
        }
        System.out.println("Transaction " + transactionId + " processed successfully.");
    }

    public static void main(String[] args) {
        TransactionProcessor processor = new TransactionProcessor();

        try {
            processor.processTransaction("txn123");
            processor.processTransaction("fail"); // This will throw an exception
        } catch (TransactionException e) {
            System.err.println("Caught TransactionException: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


class DataProcessingException extends Exception {
    public DataProcessingException(String message) {
        super(message);
    }
}
class InvalidDataException extends RuntimeException {
    public InvalidDataException(String message) {
        super(message);
    }
}
public class dataprocessor {
    public void processData(String data) throws DataProcessingException {
        if (data == null) {
            throw new DataProcessingException("Data cannot be null");
        }

        if (data.isEmpty()) {
            throw new InvalidDataException("Data cannot be empty");
        }
        System.out.println("Data processed: " + data);
    }

    public static void main(String[] args) {
        dataprocessor processor = new dataprocessor();

        try {
            processor.processData("sample data");
            processor.processData("");
            processor.processData(null);
        } catch (DataProcessingException e) {
            System.err.println("Caught checked exception: " + e.getMessage());
            e.printStackTrace();
        } catch (InvalidDataException e) {
            System.err.println("Caught unchecked exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

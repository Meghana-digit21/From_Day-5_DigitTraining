
package ResourceManager;

class Connection implements AutoCloseable {
    public void open() {
        System.out.println("Connection opened.");
    }
    public void execute(String query) throws Exception {
        if (query == null) {
            throw new Exception("Query cannot be null");
        }
        System.out.println("Executing query: " + query);
    }
    @Override
    public void close() {
        System.out.println("Connection closed.");
    }
}


package ResourceManager;

public class ResourceManager {
    public void manageResource(String query) {
        try (Connection connection = new Connection()) {
            connection.open();
            connection.execute(query);
        } catch (Exception e) {
            System.err.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ResourceManager resourceManager = new ResourceManager();

        resourceManager.manageResource("SELECT * FROM users");

        resourceManager.manageResource(null);
    }
}


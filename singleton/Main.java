package singleton;

public class Main {
    public static void main(String[] args) {
        ConfigurationManager configManager = ConfigurationManager.getInstance();
        configManager.setConfig("New Configuration Setting");

        String config = configManager.getConfig();
        System.out.println("Current Configuration: " + config);

        ConfigurationManager anotherConfigManager = ConfigurationManager.getInstance();
        System.out.println("Are both instances the same ? "+ (configManager == anotherConfigManager));
    }
}
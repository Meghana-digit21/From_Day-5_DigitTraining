
package singleton;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private String config;

    private ConfigurationManager() {
        config = "Default Configuration";
    }

    public static ConfigurationManager getInstance() {
        if(instance == null) {
            synchronized (ConfigurationManager.class) {
                if(instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }
    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}

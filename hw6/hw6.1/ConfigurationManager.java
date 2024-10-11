import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private ConfigurationManager() {}
    Map<String, String> settings = new HashMap<>();
    public static ConfigurationManager GetInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }
    public void loadSettings(Map<String, String> newSettings) {
        settings.putAll(newSettings);
    }
    public String getSetting(String key) {
        return settings.get(key);
    }
    public String setSetting(String key, String value) {
        return settings.put(key, value);
    }
}

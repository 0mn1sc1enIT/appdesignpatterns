import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ConfigurationManager configManager1 = ConfigurationManager.GetInstance();
        Map<String, String> initialSettings = new HashMap<>();

        initialSettings.put("language", "Eng");
        initialSettings.put("version", "1.0");

        configManager1.loadSettings(initialSettings);

        ConfigurationManager configManager2 = ConfigurationManager.GetInstance();
        System.out.println(STR."language: \{configManager2.getSetting("language")}");
        System.out.println(STR."version: \{configManager2.getSetting("version")}");

        configManager2.setSetting("language", "Russian");
        configManager1.setSetting("version", "1.1");

        System.out.println(STR."Language (after update): \{configManager1.getSetting("language")}");
        System.out.println(STR."Version (after update): \{configManager2.getSetting("version")}");

        System.out.println(STR."configManager1 == configManager2: \{configManager1 == configManager2}");
    }
}

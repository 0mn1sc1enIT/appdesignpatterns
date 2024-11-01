import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserReport implements IReport {
    private List<Map<String, String>> userData;

    public UserReport() {
        userData = new ArrayList<>();

        Map<String, String> user1 = new HashMap<>();
        user1.put("id", "1");
        user1.put("name", "Alice");
        user1.put("email", "alice@example.com");
        user1.put("age", "30");
        user1.put("date", "2023-05-12");

        Map<String, String> user2 = new HashMap<>();
        user2.put("id", "2");
        user2.put("name", "Bob");
        user2.put("email", "bob@example.com");
        user2.put("age", "25");
        user2.put("date", "2024-04-27");

        Map<String, String> user3 = new HashMap<>();
        user3.put("id", "3");
        user3.put("name", "Charlie");
        user3.put("email", "charlie@example.com");
        user3.put("age", "35");
        user3.put("date", "2024-01-04");

        userData.add(user1);
        userData.add(user2);
        userData.add(user3);
    }

    public List<Map<String, String>> getUserData() {
        return userData;
    }


    @Override
    public String Generate() {
        StringBuilder reportBuilder = new StringBuilder();
        for (Map<String, String> user : userData) {
            reportBuilder.append(user.toString()).append("\n"); // Convert each map to string
        }
        return reportBuilder.toString().trim(); // Trim to remove the last newline
    }
}
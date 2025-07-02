

public class TestUser {
    public static void main(String[] args) {
        try {
            User user = new User("U001", "John Doe", "john@example.com", "1234567890");

            System.out.println("User ID: " + user.getId());
            System.out.println("User Name: " + user.getName());
            System.out.println("User Email: " + user.getEmail());
            System.out.println("User Phone: " + user.getPhone());

            user.setName("Jane Doe");
            user.setEmail("jane@example.com");
            System.out.println("Updated Name: " + user.getName());
            System.out.println("Updated Email: " + user.getEmail());

            System.out.println("TestUser completed successfully");
        } catch (Exception e) {
            System.out.println("Error in TestUser: " + e.getMessage());
        }
    }
}
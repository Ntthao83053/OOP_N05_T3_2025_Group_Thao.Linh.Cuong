public class testUser {
    public static void main(String[] args) {
        User user1 = new User("Nguyen Van A", "a.nguyen@mail.com");

        System.out.println("Thông tin ban đầu: ");
        System.out.println("Tên: " + user1.getName());
        System.out.println("Email: " + user1.getEmail());

        user1.setName("Tran Thi B");
        user1.setEmail("b.tran@mail.com");

        System.out.println("\nThông tin sau khi cập nhật:");
        System.out.println("Tên: " + user1.getName());
        System.out.println("Email: " + user1.getEmail());
    }
}
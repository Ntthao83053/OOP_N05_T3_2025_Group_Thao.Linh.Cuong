package btthuchanh.test;

import btthuchanh.khachhang;

public class testkhachhang {
   public static void test() {
      khachhang user1 = new khachhang();

      System.out.println("Thông tin ban đầu: ");
      System.out.println("Tên: " + user1.getten());
      System.out.println("Email: " + user1.getemail());

      user1.setten("Nguyen Thi B");
      user1.setemail("b.nguyen@mail.com");

      System.out.println("\nThông tin sau khi cập nhật:");
      System.out.println("Tên: " + user1.getten());
      System.out.println("Email: " + user1.getemail());
   }
}

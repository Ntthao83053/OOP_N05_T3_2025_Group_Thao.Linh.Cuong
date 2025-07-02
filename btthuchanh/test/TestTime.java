package btthuchanh.test;

import java.time.LocalTime;

public class TestTime {
    public static void test() {
        LocalTime t1 = LocalTime.of(7, 32, 23);
        LocalTime t2 = LocalTime.of(20, 3, 45);

        System.out.println("t1 is " + t1);
        System.out.println("t2 is " + t2);
    }
}

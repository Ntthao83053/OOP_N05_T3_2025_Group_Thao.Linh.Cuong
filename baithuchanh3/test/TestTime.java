
import java.time.LocalDateTime;

public class TestTime {
    public static void main(String[] args) {
        try {
            Time time = new Time();
            
            System.out.println("Current Time: " + time.getCurrentTime());

            LocalDateTime newTime = time.addHours(2);
            System.out.println("Time after adding 2 hours: " + newTime);

            LocalDateTime start = LocalDateTime.now();
            LocalDateTime end = start.plusMinutes(30);
            long duration = time.calculateDuration(start, end);
            System.out.println("Duration in seconds: " + duration);

            long minutes = time.getDifferenceInMinutes(start, end);
            System.out.println("Difference in minutes: " + minutes);

            System.out.println("TestTime completed successfully");
        } catch (Exception e) {
            System.out.println("Error in TestTime: " + e.getMessage());
        }
    }
}
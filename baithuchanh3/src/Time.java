
import java.time.LocalDateTime;
import java.time.Duration;

public class Time {
    private LocalDateTime startTime;
    @SuppressWarnings("unused")
    private LocalDateTime endTime;

    public Time() {
        this.startTime = LocalDateTime.now();
    }

    public LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }

    public long calculateDuration(LocalDateTime start, LocalDateTime end) {
        return Duration.between(start, end).getSeconds();
    }

    public LocalDateTime addHours(int hours) {
        return startTime.plusHours(hours);
    }

    public LocalDateTime addMinutes(int minutes) {
        return startTime.plusMinutes(minutes);
    }

    public long getDifferenceInMinutes(LocalDateTime start, LocalDateTime end) {
        return Duration.between(start, end).toMinutes();
    }
}

package TimeConversion;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for current time
        System.out.print("Enter current time in format 'yyyy-MM-dd HH:mm:ss': ");
        String inputTime = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(inputTime, formatter);

        // Prompt user for current time zone
        System.out.print("Enter current time zone: ");
        String sourceTimeZone = scanner.nextLine();
        ZoneId sourceZoneId = ZoneId.of(sourceTimeZone);

        // Prompt user for target time zone
        System.out.print("Enter target time zone: ");
        String targetTimeZone = scanner.nextLine();
        ZoneId targetZoneId = ZoneId.of(targetTimeZone);

        // Convert time zone
        ZonedDateTime sourceZonedDateTime = ZonedDateTime.of(localDateTime, sourceZoneId);
        ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(targetZoneId);
        LocalDateTime targetLocalDateTime = targetZonedDateTime.toLocalDateTime();

        // Display converted time
        String outputTime = formatter.format(targetLocalDateTime);
        System.out.println("Converted time is: " + outputTime);
    }
}


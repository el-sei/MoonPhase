import java.util.Scanner;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MoonPhase {

    public static void main(String[] args) throws ParseException
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a date in the format dd/mm/yyyy G: ");
        String dateString = scanner.nextLine();

        // Convert the date string to a Date object
        Date date = new SimpleDateFormat("dd/MM/yyyy G").parse(dateString);

        // Calculate the moon phase
        int moonPhase = calculateMoonPhase(date);

        // Print the moon phase
        System.out.println("The moon phase on " + dateString + " is ");
        switch (moonPhase) {
            case 0:
                System.out.println("New Moon");
                break;
            case 1:
                System.out.println("First Quarter");
                break;
            case 2:
                System.out.println("Full Moon");
                break;
            case 3:
                System.out.println("Last Quarter");
                break;
        }
    }

    private static int calculateMoonPhase(Date date) {
        // Create a Calendar object and set it to the given date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // Create another Calendar object and set it to January 1, 2000 AD
        Calendar start = Calendar.getInstance();
        start.set(Calendar.ERA, GregorianCalendar.AD);
        start.set(2000, 0, 1);

        // Get the number of days between the two dates
        long daysSince2000 = (calendar.getTimeInMillis() - start.getTimeInMillis()) / (1000 * 60 * 60 * 24);

        // Calculate the number of moon cycles since January 1, 2000
        int moonCycles = (int) (daysSince2000 / 29.53);

        // Calculate the moon phase
        int moonPhase = moonCycles % 4;

        return moonPhase;
    }
}


package coffee.fullstack.fullstackcoffee.common.helpers.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

    /**
     * This method is used to format a LocalDateTime object to a Brazilian friendly date and returns a String date.
     * @param date LocalDateTime object to be formatted.
     *             Example: LocalDateTime.now()
     * @return String date formatted to Brazilian friendly date.
     * */
    public static String toBrazilianFriendlyDate(LocalDateTime date ) {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(date);
    }
}

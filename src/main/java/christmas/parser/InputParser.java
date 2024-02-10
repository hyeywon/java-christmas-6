package christmas.parser;

import christmas.exception.DateException;

public class InputParser {

    public static int parseDate(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new DateException();
        }
    }
}

package christmas.validator;

import christmas.exception.DateException;

public class DateValidator {

    public static void validate(int date) throws DateException {
        validateRange(date);
    }

    public static void validateRange(int date) {
        if (date < 1 || date > 31) {
            throw new DateException();
        }
    }
}

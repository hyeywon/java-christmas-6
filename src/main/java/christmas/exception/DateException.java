package christmas.exception;

public class DateException extends IllegalArgumentException {
    public DateException() {
        super("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
}

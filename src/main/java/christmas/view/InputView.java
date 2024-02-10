package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.exception.DateException;
import christmas.parser.InputParser;
import christmas.validator.DateValidator;

public class InputView {

    public int readDate() throws DateException {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine().trim();
        int date = InputParser.parseDate(input);
        DateValidator.validate(date);
        return date;
    }
}

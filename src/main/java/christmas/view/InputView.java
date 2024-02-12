package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.enums.Menu;
import christmas.exception.DateException;
import christmas.parser.InputParser;
import christmas.validator.DateValidator;
import christmas.validator.OrderValidator;
import java.util.Map;

public class InputView {

    public int readDate() throws DateException {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine().trim();
        int date = InputParser.parseDate(input);
        DateValidator.validate(date);
        return date;
    }

    public Map<Menu, Integer> readOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine().trim();
        Map<Menu, Integer> order = InputParser.parseOrder(input);
        OrderValidator.validate(order);
        return order;
    }
}

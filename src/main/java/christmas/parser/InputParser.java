package christmas.parser;

import christmas.enums.Menu;
import christmas.exception.DateException;
import christmas.exception.OrderException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InputParser {

    public static int parseDate(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new DateException();
        }
    }

    public static Map<Menu, Integer> parseOrder(String input) {   // todo: refactor
        Map<Menu, Integer> order = new HashMap<>();
        try {
            String[] pairs = input.split(",");

            for (String pair : pairs) {
                String[] pairSplit = pair.split("-");
                if (pairSplit.length != 2) throw new OrderException();  // 메뉴 형식이 예시와 다른 경우 예외 발생

                Menu menu = findMenu(pairSplit[0]);  // 메뉴판에 없는 메뉴를 입력한 경우 예외 발생
                int quantity = Integer.parseInt(pairSplit[1]);    // 메뉴 형식이 예시와 다른 경우 예외 발생

                if (order.containsKey(menu)) throw new OrderException();    // 중복 메뉴를 입력한 경우 예외 발생
                order.put(menu, quantity);
            }
        } catch (NumberFormatException e) {
            throw new OrderException();
        }
        return order;
    }

    private static Menu findMenu(String name) {
        return Arrays.stream(Menu.values())
                .filter(m -> m.getName().equals(name))
                .findAny()
                .orElseThrow(OrderException::new);
    }
}

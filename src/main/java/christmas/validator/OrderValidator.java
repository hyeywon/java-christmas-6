package christmas.validator;

import christmas.enums.Menu;
import christmas.enums.MenuType;
import christmas.exception.OrderException;
import java.util.Map;

public class OrderValidator {

    private static Map<Menu, Integer> order;

    public static void validate(Map<Menu, Integer> order) throws OrderException {
        OrderValidator.order = order;

        validateQuantity();
        validateOnlyDrink();
        validateLimit();
    }

    public static void validateQuantity() {
        if (order.values().stream()
                .anyMatch(quantity -> quantity < 1)) {
            throw new OrderException();
        }
    }

    public static void validateOnlyDrink() {
        if (order.keySet().stream()
                .allMatch(menu -> menu.getType().equals(MenuType.DRINK))) {
            throw new OrderException();
        }
    }

    public static void validateLimit() {
        int total = order.values().stream()
                .mapToInt(q -> q)
                .sum();
        if (total > 20) throw new OrderException();
    }
}

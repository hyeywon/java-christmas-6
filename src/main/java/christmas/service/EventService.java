package christmas.service;

import christmas.enums.Menu;
import christmas.model.Order;
import java.util.Map;

public class EventService {

    public Order reserve(int date, Map<Menu, Integer> orderList) {
        return new Order(date, orderList);
    }
}

package christmas.controller;

import christmas.enums.Menu;
import christmas.model.Order;
import christmas.service.EventService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class EventController {

    private final InputView inputView = new InputView();
    private final EventService eventService = new EventService();
    private final OutputView outputView = new OutputView();

    public void reserve() {
        int date = getDate();
        Map<Menu, Integer> orderList = getOrder();

        Order order = eventService.reserve(date, orderList);
    }

    private int getDate() {
        try {
            return inputView.readDate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getDate();
        }
    }

    private Map<Menu, Integer> getOrder() {
        try {
            return inputView.readOrder();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getOrder();
        }
    }
}

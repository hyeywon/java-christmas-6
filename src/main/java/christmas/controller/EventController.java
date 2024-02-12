package christmas.controller;

import christmas.enums.Menu;
import christmas.view.InputView;
import java.util.Map;

public class EventController {

    private final InputView inputView = new InputView();

    public void reserve() {
        int date = getDate();
        Map<Menu, Integer> order = getOrder();
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

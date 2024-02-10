package christmas.controller;

import christmas.view.InputView;

public class EventController {

    private final InputView inputView = new InputView();

    public void reserve() {
        try {
            int date = inputView.readDate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            reserve();
        }
    }
}

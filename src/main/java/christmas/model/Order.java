package christmas.model;

import static christmas.enums.Menu.CHAMPAGNE;

import christmas.enums.Badge;
import christmas.enums.Menu;
import christmas.enums.MenuType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Order {

    private final int NONE = 0;

    private Integer date;
    private Map<Menu, Integer> order;
    private Integer totalPriceBeforeDiscount;
    private Boolean freeGift;
    private Map<String, Integer> benefits;
    private Integer totalBenefitAmount;
    private Badge badge;

    public Order(int date, Map<Menu, Integer> order) {
        this.date = date;
        this.order = order;
        initEvent();
    }

    private void initEvent() {
        totalPriceBeforeDiscount = calcTotalPriceBeforeDiscount();
        freeGift = canGetFreeGift();
        benefits = calcDiscountBenefits();
        totalBenefitAmount = calcTotalBenefitAmount();
        badge = calcBadge();
    }

    private int calcTotalPriceBeforeDiscount() {
        return order.entrySet().stream()
                .mapToInt(order -> order.getKey().getPrice() * order.getValue())
                .sum();
    }

    private boolean canGetFreeGift() {
        return totalPriceBeforeDiscount >= 120_000;
    }

    private Map<String, Integer> calcDiscountBenefits() {
        return new HashMap<>() {{
            put("크리스마스 디데이 할인", calcChristmasDday());
            put("평일 할인", calcWeekday());
            put("주말 할인", calcWeekend());
            put("특별 할인", 1000);
            put("증정 이벤트", canGetFreeGift() ? CHAMPAGNE.getPrice() : NONE);
        }};
    }

    private int calcChristmasDday() {
        if (date <= 25) {
            return 1000 + (date - 1) * 100;
        }
        return NONE;
    }

    private int calcWeekday() {
        if ((date % 7 == 0) || (date % 7 >= 3)) {
            return (int) (order.keySet().stream()
                    .filter(menu -> menu.getType().equals(MenuType.DESSERT))
                    .count() * 2023);
        }
        return NONE;
    }

    private int calcWeekend() {
        if ((date % 7 == 1) || (date % 7 == 2)) {
            return (int) (order.keySet().stream()
                    .filter(menu -> menu.getType().equals(MenuType.MAIN))
                    .count() * 2023);
        }
        return NONE;
    }

    private int isSpecial() {
        final int[] specialDay = {3, 10, 17, 24, 25, 31};

        if (Arrays.asList(specialDay).contains(date)) {
            return 1000;
        }
        return NONE;
    }

    private int calcTotalBenefitAmount() {
        return benefits.values().stream()
                .mapToInt(a -> a)
                .sum();
    }

    private Badge calcBadge() {
        if (totalBenefitAmount >= 20_000) {
            return Badge.SANTA;
        }
        if (totalBenefitAmount >= 10_000) {
            return Badge.TREE;
        }
        if (totalBenefitAmount >= 5_000) {
            return Badge.STAR;
        }
        return null;
    }
}

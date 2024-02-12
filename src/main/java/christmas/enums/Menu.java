package christmas.enums;

import static christmas.enums.MenuType.APPETIZER;
import static christmas.enums.MenuType.DESSERT;
import static christmas.enums.MenuType.DRINK;
import static christmas.enums.MenuType.MAIN;

public enum Menu {
    SOUP(6_000, APPETIZER, "양송이수프"),
    TAPAS(5_500, APPETIZER, "타파스"),
    CAESAR_SALAD(8_000, APPETIZER, "시저샐러드"),
    T_BONE_STEAK(55_000, MAIN, "티본스테이크"),
    BARBEQUE_LIB(54_000, MAIN, "바비큐립"),
    SEAFOOD_PASTA(35_000, MAIN, "해산물파스타"),
    CHRISTMAS_PASTA(25_000, MAIN, "크리스마스파스타"),
    CHOCO_CAKE(15_000, DESSERT, "초코케이크"),
    ICE_CREAM(5_000, DESSERT, "아이스크림"),
    ZERO_COKE(3_000, DRINK, "제로콜라"),
    RED_WINE(60_000, DRINK, "레드와인"),
    CHAMPAGNE(25_000, DRINK, "샴페인");

    private final Integer price;
    private final MenuType type;
    private final String name;

    Menu(Integer price, MenuType type, String name) {
        this.price = price;
        this.type = type;
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public MenuType getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}

package lt.vcs.pom.page.saucedemo;

import lt.vcs.pom.page.Common;
import org.openqa.selenium.By;

import java.util.List;

public class ShoppingCartPage {
    private static final By buttonsAddToCart = By.xpath("//div[@data-test='inventory-item']//button");
    public static final By spanCartBadge = By.xpath("//span[@data-test='shopping-cart-badge']");
    public static final By divsInventoryItemName = By.xpath("//div[@data-test='inventory-item-name']");
    public static final By linkCart = By.xpath("//a[@data-test='shopping-cart-link']");
    public static final By divCartItemName =
            By.xpath("//div[@data-test='cart-list']//div[@data-test='inventory-item-name']");

    public static void addAllItemsInFirstPage() {
        Common.clickOnElements(buttonsAddToCart);
    }

    public static String readNumberFromBadge() {
        return Common.getTextFromElement(spanCartBadge);
    }

    public static List<String> getAddItemNames() {
        return Common.getTextFromElements(divsInventoryItemName);
    }

    public static void clickOnBadgeIcon() {
        Common.clickOnElement(linkCart);
    }

    public static List<String> getAllNamesFromCart() {
        return Common.getTextFromElements(divCartItemName);
    }
}
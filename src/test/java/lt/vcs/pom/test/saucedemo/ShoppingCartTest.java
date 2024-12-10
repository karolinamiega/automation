package lt.vcs.pom.test.saucedemo;

import lt.vcs.pom.page.saucedemo.SauceDemoAfterLoginPage;
import lt.vcs.pom.page.saucedemo.SauceDemoLoginPage;
import lt.vcs.pom.page.saucedemo.ShoppingCartPage;
import lt.vcs.pom.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ShoppingCartTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp(){
        SauceDemoLoginPage.login("standard_user", "secret_sauce");

    }
    @Test
    public void testShoppingCart(){
        String expectedResult = "6";
        String actualResult = "";

        ShoppingCartPage.addAllItemsInFirstPage();
        actualResult = ShoppingCartPage.readNumberFromBadge();


        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
        );
    }
    @Test
    public void testShoppingCartAddItemsName() {
        List<String> expectedResult;
        List<String> actualResult;

        ShoppingCartPage.addAllItemsInFirstPage();
        expectedResult = ShoppingCartPage.getAddItemNames();
        ShoppingCartPage.clickOnBadgeIcon();
        actualResult = ShoppingCartPage.getAllNamesFromCart();

        Assert.assertTrue(
                actualResult.containsAll(expectedResult),
                "\nActual: %s\nExpected contains: %s".formatted(actualResult, expectedResult)
        );
    }
}

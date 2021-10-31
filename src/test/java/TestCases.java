import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class TestCases extends Config {

    Methods methods = new Methods();
    XPath xPath = new XPath();
    TextInserts textInserts = new TextInserts();

    @Test
    public void open() throws InterruptedException {
        methods.openSite(driver, xPath.myUrl);
        Assert.assertEquals(driver.getTitle(), textInserts.siteName, "Rozetka web site is not loaded");
        methods.waitForElement(driver, xPath.search);
        driver.findElement(By.xpath(xPath.search)).sendKeys(textInserts.product);
        driver.findElement(By.xpath(xPath.press_search)).click();
        methods.waitForElement(driver, xPath.rozetka);
        driver.findElement(By.xpath(xPath.rozetka)).click();
        methods.waitForElement(driver, xPath.gForce);
        driver.findElement(By.xpath(xPath.gForce)).click();
        methods.waitForElement(driver, xPath.priceSort);
        driver.findElement(By.xpath(xPath.priceSort)).click();
        methods.waitForElement(driver, xPath.goods);
        List<WebElement> goods;
        List<WebElement> prices;
        try {
            goods = driver.findElements(By.xpath(xPath.goods));
            prices = driver.findElements(By.xpath(xPath.prices));
        } catch (NoSuchElementException e) {
            goods = Collections.emptyList();
            prices = Collections.emptyList();
        }
            Assert.assertEquals(goods.isEmpty(), false, "Goods list doesn't contain cards with names");
            Assert.assertEquals(prices.isEmpty(), false, "Goods list doesn't contain cards with prices");

        for (int i = 0; i < goods.size(); i++) {
            System.out.println(i + 1 + textInserts.card + goods.get(i).getText() + textInserts.price + prices.get(i).getText() + textInserts.current);
        }

    }

}

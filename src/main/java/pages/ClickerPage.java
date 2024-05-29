package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utils.Urls;

public class ClickerPage extends BasePage {
    public ClickerPage(WebDriver driver) {
        super(driver);
    }

    private final static class Locators {
        private static final By plusButton = By.id("plus-btn");
        private static final By resultField = By.xpath("//div[@id='counter']/span");
        private static final By resetButton = By.id("reset");
        private static final By iframeElement = By.xpath("//iframe[contains(@src, \"counter/\")]");
        private static final By cookies =By.xpath("//button[@aria-label=\"Consent\"]");
    }

    public ClickerPage openMainPage(){
        driver.get(Urls.clickerPage);
        return this;
    }

    public ClickerPage acceptCookies(){
        try{workWithElements.click(Locators.cookies);}
        catch (Exception e){}
        return this;
    }

    public ClickerPage switchToFrame(){
        waiters.switchToFrame(Locators.iframeElement);
        return this;
    }
    public ClickerPage clickOnPlusButton(int count){
        for (int i = 0; i < count; i++){
            workWithElements.click(Locators.plusButton);
        }
        return this;
    }
    public ClickerPage checkResultNumber(int expected){
        Assert.assertEquals(Integer.parseInt(workWithElements.returnTextFromElement(Locators.resultField)), expected);
        return this;
    }

    public ClickerPage checkResetButton(){
        for (int i = 0; i < 5; i++){
            new Actions(driver).sendKeys(Keys.ARROW_DOWN).perform();
        }
        workWithElements.click(Locators.resetButton);
        checkResultNumber(0);
        return this;
    }

}

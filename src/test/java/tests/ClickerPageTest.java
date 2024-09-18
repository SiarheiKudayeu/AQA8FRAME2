package tests;

import org.testng.annotations.Test;

public class ClickerPageTest extends BaseTest {
    @Test
    public void checkPlusButton() throws InterruptedException {
        int countOfClick = 7;
        clickerPage.openMainPage()
                .acceptCookies()
                .switchToFrame()
                .clickOnPlusButton(countOfClick)
                .checkResultNumber(countOfClick);

    }

    @Test
    public void checkPlusAndResetButton() throws InterruptedException {
        int countOfClick = 7;
        clickerPage.openMainPage()
                .acceptCookies()
                .switchToFrame()
                .clickOnPlusButton(countOfClick)
                .checkResultNumber(10)
                .checkResetButton();
    }
}

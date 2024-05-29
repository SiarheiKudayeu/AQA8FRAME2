package tests;

import driver_init.DriverInit;
import functions.CustomWaiters;
import functions.WorkWithElements;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import pages.BasePage;
import pages.ClickerPage;
import utils.MyAllureTestListeners;

@Listeners(MyAllureTestListeners.class)
public class BaseTest {
    protected WebDriver driver = DriverInit.startDriver();;
    protected CustomWaiters waiters = new CustomWaiters(driver);
    protected WorkWithElements workWithElements = new WorkWithElements(driver, waiters);
    protected BasePage basePage = new BasePage(driver);
    protected ClickerPage clickerPage = new ClickerPage(driver);

    @BeforeSuite
    public void init(){
        driver = DriverInit.startDriver();
    }
    @AfterSuite
    public void stop(){
        driver.quit();
    }
}

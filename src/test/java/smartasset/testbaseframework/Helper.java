package smartasset.testbaseframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static java.lang.String.format;

public class Helper {
    private static int defaultTime = 15000;

    public static WebElement waitFindElement(By by){
        List<WebElement> w = waitForElement(by);
        if(w.isEmpty()) throw new NoSuchElementException(format("Element %s is not found!)", by.toString()));
        return w.get(0);
    }

    public static List<WebElement> waitForElement(By by) {
        int timeoutMs = defaultTime;
        WebDriver driver = TestBase.driver;
        List<WebElement> w;
        long timeSlice = 200; // milliseconds
        do {
            sleep(timeSlice);
            timeoutMs -= timeSlice;
            w = driver.findElements(by);
        } while (timeoutMs > 0 && w.size() != 1);
        return w;
    }

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
        }
    }

    public static List<WebElement> waitFindElements(By locator) {
        return waitFindElementsWithTimeout(locator, 15000);
    }

    public static List<WebElement> waitFindElementsWithTimeout(By locator, int timeoutMs) {
        WebDriver driver = TestBase.driver;
        int timeSlice = 100;   // milliseconds
        List<WebElement> ws = Arrays.asList();
        do {
            sleep(timeSlice);
            timeoutMs -= timeSlice;
            ws = driver.findElements(locator);
        } while (timeoutMs > 0 && ws.size() == 0);

        return ws;
    }

    public static WebElement waitForElementToBeVisible(By by){
        WebDriverWait wait = new WebDriverWait(TestBase.driver, 10);
        WebElement e = wait.until(ExpectedConditions
                .visibilityOfElementLocated(by));
       return e;
    }

}

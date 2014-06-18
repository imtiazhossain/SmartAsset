package smartasset.testbaseframework;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static String chrome = "Chrome";
    public static String firefox = "Firefox";
    public static String ie = "IE";

    public static SetDriver myDriver = new SetDriver(chrome);
    public static WebDriver driver = myDriver.getDriver();

    @Before
    public void startUp(){
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.SmartAsset.com");
    }

    @Rule
    public ScreenShotRule screenShotRule = new ScreenShotRule(driver);

    @AfterClass
    public static void cleanUp(){
       // driver.quit();
    }
}
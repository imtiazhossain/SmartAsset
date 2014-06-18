package smartasset.testbaseframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SetDriver {

    public WebDriver driver;

    public SetDriver(String browserName){
        if(browserName.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            this.driver=new ChromeDriver();
        }
        else if (browserName.equals("Firefox")){
        this.driver = new FirefoxDriver();
        }
        else if (browserName.equals("IE")){
            System.setProperty("webdriver.ie.driver", "C:\\Users\\rocky\\Downloads\\IEDriverServer_x64_2.27.0\\IEDriver.exe");
            this.driver=new InternetExplorerDriver();
        }
    }

    public WebDriver getDriver(){
        return driver;
    }



}

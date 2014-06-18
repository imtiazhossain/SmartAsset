package smartasset.testbaseframework;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rocky on 3/18/14.
 */
public class ScreenShotRule extends TestWatcher{

   private WebDriver browser;


   public ScreenShotRule(WebDriver browser) {
       this.browser =  browser;
   }

   @Override
   protected void failed(Throwable e, Description description) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) browser;
        File scrFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = getDestinationFile();
        try {
            FileUtils.copyFile(scrFile, destFile);
                System.out.print(destFile);
            } catch (IOException ioe) {
                throw new RuntimeException(ioe);
            }
        }

        private String addDateAndTime(){
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy_HHmmss");
            String formattedDate = formatter.format(date);
            return formattedDate;
        }

        private File getDestinationFile() {
            String userDirectory = "C:\\Users\\rocky\\screenshots";
            String fileName = addDateAndTime() +"screenShot.jpg";
            String absoluteFileName = userDirectory + "/" + fileName;
            return new File(absoluteFileName);
        }

    protected  void screenShot() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) browser;
        File scrFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = getDestinationFile();
        try {
            FileUtils.copyFile(scrFile, destFile);
            System.out.print(destFile);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

}

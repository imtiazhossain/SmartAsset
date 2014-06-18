package smartasset.tests;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import smartasset.entities.Customer;
import smartasset.pages.HowMuchCanIAffordPage;
import smartasset.testbaseframework.ScreenShotRule;
import smartasset.testbaseframework.TestBase;

public class CalculateHomeValueTest extends TestBase {
    HowMuchCanIAffordPage howMuchCanIAffordPage;
    Customer customerOne;

    @Before
    public void setUp(){
        driver.get("https://www.smartasset.com/first-time-home-buyer/affordability/how-much-house-can-i-afford");
        howMuchCanIAffordPage = new HowMuchCanIAffordPage();
    }

    @Test
    public void howMuchCanIAfford(){
        customerOne = new Customer(100000, 150000,0,0,"43201","10011");
        howMuchCanIAffordPage.fillInHomeCalculationForms(customerOne);

    }
}

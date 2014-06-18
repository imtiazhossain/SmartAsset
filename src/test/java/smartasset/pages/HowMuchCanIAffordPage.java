package smartasset.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import smartasset.entities.Customer;
import smartasset.testbaseframework.Helper;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static smartasset.testbaseframework.Helper.sleep;
import static smartasset.testbaseframework.Helper.waitFindElement;

public class HowMuchCanIAffordPage {
    public String nextButtonOnIncomeForm = "Income";
    public String nextButtonOnCashAndGiftForm = "CashAndGift";
    public String nextButtonOnDebtForm = "Debt";
    public String whereCustomerLivesWantsToLive = "Living";


    public void fillInHomeCalculationForms(Customer customer) {
        fillInAnnualPreTaxIncome(customer.getAnnualIncome());
        clickNextButton(nextButtonOnIncomeForm);
        fillInCashSavingsAndGifts(customer.getCashSavings(), customer.getGifts());
        clickNextButton(nextButtonOnCashAndGiftForm);
        if (customer.getTotalDebt() == 0)
            clickNextButton(nextButtonOnDebtForm);
        else{
        inputUserDebt(customer.getMonthlyPayments(), customer.getTotalDebt());
        clickNextButton(nextButtonOnDebtForm);
        };
        fillWhereCustomerLiveAndWantToLive(customer.getLiveNow(), customer.getLiveLater()+Keys.TAB);
        clickNextButton(whereCustomerLivesWantsToLive);
        assertDownPaymentAndMortgageValueEqualsHomeValue();


    }

    private void inputUserDebt(int monthlyPayment, int totalDebt) {
        WebElement yesRadioButton = waitFindElement(By.cssSelector("#have-totalDebt-yes"));
        yesRadioButton.click();

        WebElement monthlyPmtField = waitFindElement(By.cssSelector("#debt-monthly-hack"));
        WebElement totalDebtField = waitFindElement(By.cssSelector("#debt-total-hack"));

        monthlyPmtField.sendKeys(String.valueOf(monthlyPayment));
        totalDebtField.sendKeys(String.valueOf(totalDebt));
    }


    public void fillInAnnualPreTaxIncome(int income) {
        WebElement annualIncomeField = waitFindElement(By.cssSelector("#primaryIncome-hack"));
        annualIncomeField.sendKeys(String.valueOf(income));
    }

    public void fillInCashSavingsAndGifts(int cash, int gifts) {
        sleep(1000);
        WebElement cashField = waitFindElement(By.cssSelector("#savings-group-hack"));
        WebElement giftsField = waitFindElement(By.cssSelector("#gifts-group-hack"));
        cashField.sendKeys(String.valueOf(cash));
        giftsField.sendKeys(String.valueOf(gifts));
    }

    public void clickIncomeNextButton() {
        WebElement button = waitFindElement(By.cssSelector("#inputs-container div.inputs-income>form.form-vertical>div.input-buttons>button"));
        button.click();
    }

    public void clickMoneyTowardsNewHomeNextButton() {
        WebElement button = waitFindElement(By.cssSelector("#overlay-inputs-downpayment > div.inputs-block > " +
                "form > div.input-buttons > button.btn.btn-success.btn-next"));
        button.click();
    }


    private void clickNextButton(String location) {
        Map<String, Integer> mapLocation = new HashMap<String, Integer>();
        mapLocation.put("Income", 1);
        mapLocation.put("CashAndGift", 2);
        mapLocation.put("Debt", 3);
        mapLocation.put("Living", 4);


        WebElement button = null;
        switch (mapLocation.get(location)) {
            case 1:
                button = waitFindElement(By.cssSelector("#inputs-container div.inputs-income>form.form-vertical>div.input-buttons>button"));
                break;

            case 2:
                button = waitFindElement(By.cssSelector("#overlay-inputs-downpayment > div.inputs-block > " +
                        "form > div.input-buttons > button.btn.btn-success.btn-next"));
                break;

            case 3:
                button = waitFindElement(By.cssSelector("#overlay-inputs-debtpayments > div.inputs-block > " +
                        "form > div.input-buttons > button.btn.btn-success.btn-next"));
                break;
            case 4:
                button = waitFindElement(By.cssSelector("#donebutton"));
                break;
        }
        button.click();
    }

    public void fillWhereCustomerLiveAndWantToLive(String currentLocation, String wantToLive) {
        WebElement liveField = Helper.waitForElementToBeVisible(By.cssSelector("#whereview"));
        WebElement wantToLiveField = waitFindElement(By.cssSelector("#wherenewview"));

        liveField.clear();
        liveField.sendKeys(currentLocation);
        wantToLiveField.clear();
        wantToLiveField.sendKeys(wantToLive);
    }


    private void assertDownPaymentAndMortgageValueEqualsHomeValue() {
        WebElement downPaymentAmount = waitFindElement(By.cssSelector("#display-dp"));
        WebElement mortgageValue = waitFindElement(By.cssSelector("#display-mv"));
        WebElement homeValue = waitFindElement(By.cssSelector("#display-hv"));

        int downPayment = Integer.parseInt(downPaymentAmount.getAttribute("value").substring(1).replace(",",""));
        int mortgage = Integer.parseInt(mortgageValue.getAttribute("value").substring(1).replace(",",""));
        int homeVal = Integer.parseInt(homeValue.getAttribute("value").substring(1).replace(",",""));

        assertEquals(downPayment - mortgage, homeVal);

    }


}


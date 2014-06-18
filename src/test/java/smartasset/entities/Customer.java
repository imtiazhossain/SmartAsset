package smartasset.entities;

public class Customer {

    public int annualIncome;
    public int downPayment;
    public int cashSavings;
    public int gifts;
    public int totalDebt;
    public int monthlyPayments;
    public String liveNow;
    public String liveLater;


    public Customer(int annualIncome, int cashSavings, int gifts, int totalDebt, String currentLocation, String futureLocation){
        this.annualIncome = annualIncome;
        this.totalDebt = totalDebt;
        this.cashSavings = cashSavings;
        this.gifts = gifts;
        this.liveNow = currentLocation;
        this.liveLater = futureLocation;
    }

    public Customer(int annualIncome, int cashSavings, int gifts, int monthlyPayments, int totalDebt, String currentLocation, String futureLocation){
        this.annualIncome = annualIncome;
        this.totalDebt = totalDebt;
        this.cashSavings = cashSavings;
        this.gifts = gifts;
        this.monthlyPayments = monthlyPayments;
        this.liveNow = currentLocation;
        this.liveLater = futureLocation;
    }


    public int getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(int annualIncome) {
        this.annualIncome = annualIncome;
    }

    public int getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(int downPayment) {
        this.downPayment = downPayment;
    }

    public String getLiveLater() {
        return liveLater;
    }

    public void setLiveLater(String liveLater) {
        this.liveLater = liveLater;
    }

    public int getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(int totalDebt) {
        this.totalDebt = totalDebt;
    }

    public String getLiveNow() {
        return liveNow;
    }

    public void setLiveNow(String liveNow) {
        this.liveNow = liveNow;
    }

    public int getGifts() {
        return gifts;
    }

    public void setGifts(int gifts) {
        this.gifts = gifts;
    }

    public int getCashSavings() {
        return cashSavings;
    }

    public void setCashSavings(int cashSavings) {
        this.cashSavings = cashSavings;
    }

    public int getMonthlyPayments() {
        return monthlyPayments;
    }

    public void setMonthlyPayments(int monthlyPayments) {
        this.monthlyPayments = monthlyPayments;
    }

}

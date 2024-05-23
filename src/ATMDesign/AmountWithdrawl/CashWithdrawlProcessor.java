package ATMDesign.AmountWithdrawl;

import ATMDesign.ATM;

public abstract class CashWithdrawlProcessor {
    CashWithdrawlProcessor nextCashWithdrawlProcessor;

    CashWithdrawlProcessor(CashWithdrawlProcessor cashWithdrawlProcessor){
        this.nextCashWithdrawlProcessor = cashWithdrawlProcessor;
    }


    public void withdraw(ATM atm, int remainingAmount) {

        if (nextCashWithdrawlProcessor != null) {
            nextCashWithdrawlProcessor.withdraw(atm, remainingAmount);
        }
    }

}

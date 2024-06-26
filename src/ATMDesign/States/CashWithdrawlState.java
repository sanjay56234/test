package ATMDesign.States;

import ATMDesign.ATM;
import ATMDesign.AmountWithdrawl.CashWithdrawlProcessor;
import ATMDesign.AmountWithdrawl.FiveHundredWithdrawProcessor;
import ATMDesign.AmountWithdrawl.HundredWithdrawProcessor;
import ATMDesign.AmountWithdrawl.TwoThousandWithdrawProcessor;
import ATMDesign.Card;

public class CashWithdrawlState extends AtmStates{

    public CashWithdrawlState() {
        System.out.println("Please enter the Withdrawal Amount");
    }

    public void cashWithdrawal(ATM atmObject, Card card, int withdrawalAmountRequest) {

        if (atmObject.getAtmBalance() < withdrawalAmountRequest) {
            System.out.println("Insufficient fund in the ATM Machine");
            exit(atmObject);
        } else if (card.getBankBalance() < withdrawalAmountRequest) {
            System.out.println("Insufficient fund in the your Bank Account");
            exit(atmObject);
        } else {

            card.deductBankBalance(withdrawalAmountRequest);
            atmObject.deductATMBalance(withdrawalAmountRequest);

            //using chain of responsibility for this logic, how many 2k Rs notes, how many 500 Rs notes etc, has to be withdrawal
            CashWithdrawlProcessor withdrawProcessor =
                    new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new HundredWithdrawProcessor(null)));

            withdrawProcessor.withdraw(atmObject, withdrawalAmountRequest);
            exit(atmObject);
        }
    }

    @Override
    public void exit(ATM atmObject) {
        returnCard();
        atmObject.setCurrentATMState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }

}

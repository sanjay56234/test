package SplitWise.Expense;

import SplitWise.Expense.Split.EqualSplit;
import SplitWise.Expense.Split.ExpenseSplit;
import SplitWise.Expense.Split.PercentSplit;
import SplitWise.Expense.Split.UnequalSplit;

public class SplitFactory {

    public static   ExpenseSplit getExpenseSplit(SplitType splitType){
        switch (splitType){
            case EQUAL:
                return new EqualSplit();
            case UNEQUAL:
                return new UnequalSplit();
            case PERCENT:
                return new PercentSplit();
            default:
                return null;
        }
    }

}

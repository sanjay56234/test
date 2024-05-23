package SplitWise.Expense.Split;

import java.util.List;

public class PercentSplit implements ExpenseSplit{
    @Override
    public boolean validateSplit(List<Split> splitList, double amount) {
        return false;
    }
}

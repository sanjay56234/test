package SplitWise.Expense.Split;

import java.util.List;

public class EqualSplit implements ExpenseSplit{
    @Override
    public boolean validateSplit(List<Split> splitList, double amount) {
        // validate split logic
        return true;
    }
}

package SplitWise.Expense.Split;

import java.util.List;

public interface ExpenseSplit {
    public boolean validateSplit(List<Split> splitList, double amount);
}

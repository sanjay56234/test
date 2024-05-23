package SplitWise.Expense;

import SplitWise.BalanceSheetController;
import SplitWise.Expense.Split.ExpenseSplit;
import SplitWise.Expense.Split.Split;
import SplitWise.entities.User.User;

import java.util.List;

public class ExpenseController {


    BalanceSheetController balanceSheetController;
    public ExpenseController(){
        balanceSheetController = new BalanceSheetController();
    }
    public Expense createExpense(String expenseId, String description, double expenseAmount,
                                 List<Split> splitDetails, SplitType splitType, User paidByUser){

        ExpenseSplit expenseSplit = SplitFactory.getExpenseSplit(splitType);
        expenseSplit.validateSplit(splitDetails, expenseAmount);

        Expense expense = new Expense(expenseId,description, expenseAmount, splitType,paidByUser, splitDetails);

        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser, splitDetails, expenseAmount);
        return expense;
    }

}

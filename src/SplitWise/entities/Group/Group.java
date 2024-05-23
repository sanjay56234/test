package SplitWise.entities.Group;

import SplitWise.Expense.Expense;
import SplitWise.Expense.ExpenseController;
import SplitWise.Expense.Split.Split;
import SplitWise.Expense.SplitType;
import SplitWise.entities.User.User;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String id;
    String name;
    List<User> members;

    List<Expense> expenseList;

    ExpenseController expenseController;

    Group(){
        members = new ArrayList<>();
        expenseList = new ArrayList<>();
        expenseController = new ExpenseController();
    }
    public void addMember(User member){
        members.add(member);
    }

    public String getGroupId() {
        return id;
    }

    public void setGroupId(String groupId) {
        this.id = groupId;
    }

    public void setGroupName(String groupName) {
        this.name = groupName;
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount,
                                 List<Split> splitDetails, SplitType splitType, User paidByUser) {

        Expense expense = expenseController.createExpense(expenseId, description, expenseAmount, splitDetails, splitType, paidByUser);
        expenseList.add(expense);
        return expense;
    }




}

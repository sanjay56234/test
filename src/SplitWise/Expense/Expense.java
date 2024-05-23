package SplitWise.Expense;

import SplitWise.Expense.Split.*;
import SplitWise.entities.User.User;

import java.util.List;

public class Expense {

    String id;
    String description;
    double amount;
    SplitType splitType;

    User user;
    List<Split> splits;

    public Expense(String id, String description, double amount, SplitType splitType, User user, List<Split> splits) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.splitType = splitType;
        this.user = user;
        this.splits = splits;
    }
}

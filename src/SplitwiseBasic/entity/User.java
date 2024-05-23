package SplitwiseBasic.entity;

import java.util.Map;

public class User {

    private String userId;

    private long borrowMoney;
    private Map<User, Integer> borrowedBy;

    public User(String userId, long borrowMoney, Map<User, Integer> borrowedBy) {
        this.userId = userId;
        this.borrowMoney = borrowMoney;
        this.borrowedBy = borrowedBy;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getBorrowMoney() {
        return borrowMoney;
    }

    public void setBorrowMoney(long borrowMoney) {
        this.borrowMoney = borrowMoney;
    }

    public Map<User, Integer> getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(Map<User, Integer> borrowedBy) {
        this.borrowedBy = borrowedBy;
    }
}

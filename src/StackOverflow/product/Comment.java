package StackOverflow.product;

import StackOverflow.user.User;

public class Comment {
    private int id;
    private String text;
    private User user;

    public Comment(int id, String text, User user) {
        this.id = id;
        this.text = text;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

package StackOverflow.product;

import StackOverflow.user.User;

import java.util.List;

public class Answer {
    private int id;
    private String body;
    private User user;
    private List<Comment> comments;
    private int voteCount;
    private Question question;

    public Answer(int id, String body, User user, List<Comment> comments, int voteCount, Question question) {
        this.id = id;
        this.body = body;
        this.user = user;
        this.comments = comments;
        this.voteCount = voteCount;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}

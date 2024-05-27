package StackOverflow.product;


import StackOverflow.user.User;

import java.util.List;

public class Question {
    private int id;
    private String title;
    private String body;

    private User user;
    private List<Answer> answer;

    private List<Comment> comments;
    private List<Tag> tags;
    private int voteCount;

    public Question(int id, String title, String body, User user, List<Answer> answer, List<Comment> comments, List<Tag> tags, int voteCount) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.answer = answer;
        this.comments = comments;
        this.tags = tags;
        this.voteCount = voteCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}

package StackOverflow.stackOverflow;

import StackOverflow.product.Answer;
import StackOverflow.product.Comment;
import StackOverflow.product.Question;
import StackOverflow.product.Tag;
import StackOverflow.user.User;
import com.sun.xml.internal.ws.wsdl.parser.MemberSubmissionAddressingWSDLParserExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StackOverflow {

    private static StackOverflow instance;
    private Map<Integer, User> users;
    private Map<Integer, Question> questions;
    private Map<String, List<Question>> questionByTag;

    private StackOverflow(){
        users = new HashMap<>();
        questions = new HashMap<>();
        questionByTag = new HashMap<>();
    }

    public static StackOverflow getInstance(){
        if(instance == null){
            instance = new StackOverflow();
        }
        return instance;
    }

    public void registerUser(User user){
        users.put(user.getId(), user);
    }

    public User login(String username, String password){
        for(Map.Entry<Integer,User>entry : users.entrySet()){
            if(entry.getValue().getUsername().equals(username) && entry.getValue().getPassword().equals(password)){
                return entry.getValue();
            }
        }
        System.out.println("User not logged id");
        return null;
    }

    public void postQuestion(Question question){
        questions.put(question.getId(), question);
        updateQuestionTagMap(question);
    }

    private void updateQuestionTagMap(Question question){
        for (Tag tag : question.getTags()) {
            questionByTag.computeIfAbsent(tag.getName(), k -> new ArrayList<>()).add(question);
        }
    }

    public void postAnswer(Answer answer){
        Question question = answer.getQuestion();
        question.getAnswer().add(answer);
    }
    public void postComment(Comment comment) {
        // Add comment to the respective question or answer
        // ...
    }

    public void voteQuestion(Question question, int value) {
        synchronized (question) {
            question.setVoteCount(question.getVoteCount() + value);
        }
        updateUserReputation(question.getUser(), value);
    }

    public void voteAnswer(Answer answer, int value) {
        synchronized (answer) {
            answer.setVoteCount(answer.getVoteCount() + value);
        }
        updateUserReputation(answer.getUser(), value);
    }

    private void updateUserReputation(User user, int value) {
        synchronized (user) {
            user.setReputation(user.getReputation() + value);
        }
    }

    public List<Question> searchQuestions(String query) {
        List<Question> results = new ArrayList<>();
        for (Question question : questions.values()) {
            if (question.getTitle().contains(query) || question.getBody().contains(query)) {
                results.add(question);
            }
        }
        return results;
    }

    public List<Question> getQuestionsByTag(String tagName) {
        return questionByTag.getOrDefault(tagName, new ArrayList<>());
    }

    public List<Question> getQuestionsByUser(User user) {
        List<Question> results = new ArrayList<>();
        for (Question question : questions.values()) {
            if (question.getUser().equals(user)) {
                results.add(question);
            }
        }
        return results;
    }


}

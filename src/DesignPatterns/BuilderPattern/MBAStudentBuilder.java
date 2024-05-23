package DesignPatterns.BuilderPattern;

import java.util.ArrayList;
import java.util.List;

public class MBAStudentBuilder extends StudentBuilder{

    @Override
    public StudentBuilder setSubjects(){
        List<String> sub = new ArrayList<>();
        sub.add("ECO");
        this.subjects = sub;
        return this;
    }
}

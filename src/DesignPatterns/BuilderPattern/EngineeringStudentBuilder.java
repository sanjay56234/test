package DesignPatterns.BuilderPattern;

import java.util.ArrayList;
import java.util.List;

public class EngineeringStudentBuilder extends StudentBuilder{

    public StudentBuilder setSubjects(){
        List<String> sub = new ArrayList<>();
        sub.add("DSA");
        this.subjects = sub;
        return this;
    }
}

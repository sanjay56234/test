package DesignPatterns.BuilderPattern;

public class Director {


    StudentBuilder studentBuilder;

    public Director(StudentBuilder studentBuilder){
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent( ){
        if(studentBuilder instanceof EngineeringStudentBuilder){
            return createEngineeringStudent();
        }else if(studentBuilder instanceof MBAStudentBuilder){
            return mbaStudentBuilder();
        }
        return null;
    }

    private Student createEngineeringStudent(){
        return studentBuilder.setAge(12).setName("Engineer").setRollNumber(123).setSubjects().build();
    }

    private Student mbaStudentBuilder(){
        return studentBuilder.setAge(345).setName("MBA").setFatherName("Sanjay").setSubjects().build();
    }

}

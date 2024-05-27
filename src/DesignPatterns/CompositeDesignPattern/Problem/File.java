package DesignPatterns.CompositeDesignPattern.Problem;

public class File {
    String name;

    public File(String name){
        this.name = name;
    }

    public void ls(){
        System.out.println(String.format("File Name : %s", this.name));
    }

}

package DesignPatterns.CompositeDesignPattern.Problem;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    String name;
    List<Object> objectList;

    public Directory(String name){
        this.name = name;
        objectList = new ArrayList<>();
    }

    public void add(Object object){
        objectList.add(object);
    }

    public void ls(){
        System.out.println(String.format("Directory Name : %s", this.name));

        for(Object obj : objectList){
            if(obj instanceof Directory){
                ((Directory) obj).ls();
            }else{
                ((File)obj).ls();
            }
        }
    }


}

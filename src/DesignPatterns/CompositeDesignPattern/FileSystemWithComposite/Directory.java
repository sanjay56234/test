package DesignPatterns.CompositeDesignPattern.FileSystemWithComposite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{

    String name;
    List<FileSystem> fileSystemList;

    public Directory(String name){
        this.name =  name;
        fileSystemList = new ArrayList<>();
    }

    public void add(FileSystem fileSystem){
        this.fileSystemList.add(fileSystem);
    }
    @Override
    public void ls() {
        System.out.println(String.format("Directory name : %s", name));
        for(FileSystem fileSystem : fileSystemList){
            fileSystem.ls();
        }
    }
}

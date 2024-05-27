package DesignPatterns.CompositeDesignPattern.FileSystemWithComposite;

public class File implements FileSystem{
    String filename;

    public File(String name){
        this.filename = name;
    }
    @Override
    public void ls() {
        System.out.println(String.format("File nane : %s", this.filename));
    }
}

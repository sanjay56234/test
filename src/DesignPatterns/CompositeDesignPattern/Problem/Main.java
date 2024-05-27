package DesignPatterns.CompositeDesignPattern.Problem;

public class Main {
    public static void main(String[] args) {

        Directory directory = new Directory("Movies");
        File file = new File("OMG");
        directory.add(file);

        Directory directory1 = new Directory("COMEDY");
        File file1 = new File("ABCD");
        directory1.add(file1);
        directory.add(directory1);

        directory.ls();

    }

}

package DesignPatterns.MomentoPattern;

public class Main {
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();

        Configuration configuration = new Configuration(2,5);
        caretaker.addMemento(new ConfigurationMemento(configuration.h ,configuration.w));

        configuration.setH(5);
        configuration.setW(90);
        caretaker.addMemento(new ConfigurationMemento(configuration.h, configuration.w));

        configuration.setH(67);
        configuration.setW(123);
        caretaker.addMemento(new ConfigurationMemento(configuration.h, configuration.w));

        configuration.restoredMemento(caretaker.restoredMemento());
        configuration.restoredMemento(caretaker.restoredMemento());
        configuration.restoredMemento(caretaker.restoredMemento());
    }
}

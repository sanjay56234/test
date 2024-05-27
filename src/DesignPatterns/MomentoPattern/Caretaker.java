package DesignPatterns.MomentoPattern;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {

    List<ConfigurationMemento> configurationMementoList;

    public Caretaker(){
        this.configurationMementoList = new ArrayList<>();
    }
    public void addMemento(ConfigurationMemento configurationMemento){
        configurationMementoList.add(configurationMemento);
    }

    public ConfigurationMemento restoredMemento(){
        int idx = configurationMementoList.size();
        ConfigurationMemento configurationMemento =  configurationMementoList.get(idx-1);
        configurationMementoList.remove(configurationMemento);
        return configurationMemento;
    }

}

package DesignPatterns.MomentoPattern;

public class Configuration {
    int h;
    int w;

    public Configuration(int h, int w){
        this.h = h;
        this.w = w;

    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public ConfigurationMemento createMemento(){
        return new ConfigurationMemento(h,w);
    }

    public void restoredMemento(ConfigurationMemento configurationMemento){
        System.out.println(String.format("Restored values h : %s, w : %s", configurationMemento.h, configurationMemento.w));
        this.h = h;
        this.w = w;
    }


}

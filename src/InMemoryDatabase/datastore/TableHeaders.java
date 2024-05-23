package InMemoryDatabase.datastore;

public class TableHeaders {
    private String name;
    private String type;
    private Boolean canNull;

     Contraint contraint;
    public static enum Contraint { NONE, STRING_20, INT_1084 };

    public TableHeaders(String name, String type, Boolean canNull, Contraint contraint){
        this.name = name;
        this.type = type;
        this.canNull = canNull;
        this.contraint = contraint;
    }

    public String getName(){
        return this.name;
    }
}

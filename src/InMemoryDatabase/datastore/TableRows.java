package InMemoryDatabase.datastore;

import java.sql.Timestamp;
import java.util.HashMap;

public class TableRows {

    private HashMap<String, Object> columnValues;
    private Timestamp createTime;
    private String updateTime;
    private Integer id;

    TableRows(int id, HashMap<String, Object>columnValues){
        this.columnValues = columnValues;
        this.createTime = new Timestamp(System.currentTimeMillis());
        this.id = id;
    }

    public int getRowId(){
        return this.id;
    }

    public HashMap<String, Object> getColumnValues(){
        return this.columnValues;
    }
}

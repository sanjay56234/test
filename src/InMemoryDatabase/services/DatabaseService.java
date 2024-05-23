package InMemoryDatabase.services;

import InMemoryDatabase.datastore.Table;
import InMemoryDatabase.datastore.TableHeaders;
import InMemoryDatabase.datastore.TableRows;

import java.util.*;

public class DatabaseService {

    private static int tableId;
    private HashMap<Integer, Table> tableDetails;

    public DatabaseService(){
        tableId = 1;
        this.tableDetails = new HashMap<>();
    }

    public Integer createTable(String name, List<TableHeaders> tableHeaders){
        Table table = new Table(name, tableHeaders);
        tableDetails.put(tableId, table);
        return tableId++;
    }

    public Boolean deleteTable(Integer tableId){
        if(!tableDetails.containsKey(tableId)){
            System.out.println(String.format("Table not found with id %s", tableId));
            return false;
        }
        tableDetails.remove(tableId);
        return true;
    }

    public Boolean addEntryInTable(Integer tableId, List<Object> values) throws Exception {
        if(!tableDetails.containsKey(tableId)){
            System.out.println(String.format("Table not found with id %s", tableId));
            return false;
        }
        Table table = tableDetails.get(tableId);
        table.addEntryInTable(values);
        return true;
    }

    public Boolean deleteEntryInTable(Integer tableId, Integer rowId){
        if(!tableDetails.containsKey(tableId)){
            System.out.println(String.format("Table not found with id %s", tableId));
            return false;
        }
        Table table = tableDetails.get(tableId);
        table.deleteEntryInTable(rowId);
        return true;
    }

    public List<String> getAllTableName(){
        List<String> tableNames = new ArrayList<>();
        for(Map.Entry<Integer, Table>entry : tableDetails.entrySet()){
            tableNames.add(tableDetails.get(entry.getKey()).getName());
        }
        return tableNames;
    }

    public List<TableRows> getAllRowsOfTable(Integer tableId){
        if(!tableDetails.containsKey(tableId)){
            System.out.println(String.format("No Table found with id : %s", tableId));
            return null;
        }
        Table table = tableDetails.get(tableId);
        return table.getTableRows();
    }

}

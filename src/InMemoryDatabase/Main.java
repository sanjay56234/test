package InMemoryDatabase;

import InMemoryDatabase.datastore.TableHeaders;
import InMemoryDatabase.datastore.TableRows;
import InMemoryDatabase.services.DatabaseService;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        DatabaseService databaseService = new DatabaseService();

        Integer tableId1 = databaseService.createTable("My Table 1", Arrays.asList(
                new TableHeaders("Name", "String", true, TableHeaders.Contraint.STRING_20),
                new TableHeaders("age", "integer", false, TableHeaders.Contraint.INT_1084)
        ));

        Integer tableId2 = databaseService.createTable("My Table 2", Arrays.asList(
                new TableHeaders("id", "integer", true, TableHeaders.Contraint.INT_1084)
        ));

        databaseService.addEntryInTable(tableId1, Arrays.asList("Sanjay", 23));
        databaseService.addEntryInTable(tableId2, Arrays.asList(45));
        List<TableRows> table1 = databaseService.getAllRowsOfTable(tableId1);
        List<TableRows> table2 = databaseService.getAllRowsOfTable(tableId2);

        for(TableRows tableRows : table1){
            System.out.println(tableRows.getColumnValues());
        }

        databaseService.addEntryInTable(tableId1, Arrays.asList("Shubham", 34));
        for(TableRows tableRows : table1){
            System.out.println(tableRows.getColumnValues());
        }

        for(TableRows tableRows : table2){
            System.out.println(tableRows.getColumnValues());
        }
    }
}

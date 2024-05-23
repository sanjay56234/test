package InMemoryDatabase.datastore;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Table {

    private int nextRowId;
    private String name;
    private Timestamp createTime;
    private Timestamp updateTime;
    private List<TableHeaders> tableHeaders;
    private List<TableRows> tableRows;

    public Table(String name, List<TableHeaders> headersList){
        this.name = name;
        this.createTime = new Timestamp(System.currentTimeMillis());
        this.updateTime = new Timestamp(System.currentTimeMillis());
        this.tableRows = new ArrayList<>();
        this.tableHeaders = headersList;
        this.nextRowId = 0;
    }

    public int addEntryInTable(List<Object> value)throws Exception{
            validateRow(value);
            this.nextRowId += 1;
            HashMap<String, Object> map = new HashMap<>();
            for (int i = 0; i < value.size(); i++) {
                map.put(tableHeaders.get(i).getName(), value.get(i));
            }
            TableRows tableRows = new TableRows(nextRowId, map);
            this.tableRows.add(tableRows);
            return this.nextRowId;
    }

    public Boolean deleteEntryInTable(int nextRowId){
        Optional<TableRows> rowToDeleteOptional = tableRows.stream().filter(row -> row.getRowId() == nextRowId).findAny();
        if(!rowToDeleteOptional.isPresent()) {
            System.out.println(String.format("Row not found with given id : %s", nextRowId));
            // No row with given rowId found, therefore return false
            return false;
        }
        tableRows.remove(rowToDeleteOptional.get());
        return true;
    }

    void validateRow(List<Object> value) throws Exception {
        if(value.size()!=this.tableHeaders.size()) throw new Exception("Value Column Size Doesn't Match to column size");

        for(int i=0;i<value.size();i++){
            TableHeaders tableHeader = this.tableHeaders.get(i);
            Object val = value.get(i);

            switch (tableHeader.contraint){
                case STRING_20:
                    String stringValue = String.valueOf(val);
                    if(stringValue.length() > 20) throw new Exception("String column length is greater than 20 ");
                    break;
                case INT_1084:
                    int integerValue = (int) val;
                    if(integerValue < (-1024) || integerValue > 1024) throw new Exception("Integer value not in range");
                    break;
                case NONE :
                    break;
                default:
                    throw new Exception("Unknown constraint at column");

            }
        }
    }

    public String getName(){
        return this.name;
    }

    public List<TableRows> getTableRows(){
        return this.tableRows;
    }

}

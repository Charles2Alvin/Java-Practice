package Timetable;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TableData implements TableModel {
    private String[] title = {
            "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"
    };
    private String[][] data = new String[8][7];
    public TableData() {
        for (int i=0;i<data.length;i++) {
            for (int j=0;j<data[i].length;j++){
                data[i][j] = "";
            }
        }
    }
    @Override
    public int getRowCount() {
        return 8;
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return title[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = (String)aValue;
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}

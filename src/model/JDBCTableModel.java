package model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class JDBCTableModel extends AbstractTableModel {

    Object[][] contents;
    String[] columnNames;
    Class[] columnClasses;

    public JDBCTableModel(Connection conn, String tableName) throws SQLException {
        super();
        getTableContents(conn, tableName);
    }

    protected void getTableContents(Connection conn, String tableName) throws SQLException {
        DatabaseMetaData meta = conn.getMetaData();

        System.out.println("got meta = " + meta);

        ResultSet results = meta.getColumns(null, null, tableName, null);

        System.out.println("got column results");

        ArrayList colNamesList = new ArrayList<>();
        ArrayList colClassesList = new ArrayList<>();

        while (results.next()) {
            colNamesList.add(results.getString("COLUMN_NAME"));

            System.out.println("name: " + results.getString("COLUMN_NAME"));

            int dbType = results.getInt("DATA_TYPE");

            switch (dbType) {
                case Types.INTEGER:
                    colClassesList.add(Integer.class);
                    break;
                case Types.FLOAT:
                    colClassesList.add(Float.class);
                case Types.DOUBLE:
                case Types.REAL:
                    colClassesList.add(Double.class);
                case Types.DATE:
                case Types.TIME:
                case Types.TIMESTAMP:
                    colClassesList.add(java.sql.Date.class);
                    break;
                default:
                    colClassesList.add(String.class);
            }

            System.out.println("type: " + results.getInt("DATA_TYPE"));
        }

        columnNames = new String[colClassesList.size()];
        colNamesList.toArray(columnNames);
        columnClasses = new Class[colClassesList.size()];
        colClassesList.toArray(columnClasses);

        Statement statement = conn.createStatement();

        results = statement.executeQuery("SELECT * FROM " + tableName);

        ArrayList rowList = new ArrayList<>();

        while (results.next()) {
            ArrayList cellList = new ArrayList<>();

            for (int i = 0; i < columnClasses.length; i++) {
                Object cellValue = null;

                if (columnClasses[i] == String.class) {
                    cellValue = results.getString(columnNames[i]);
                } else if (columnClasses[i] == Integer.class) {
                    cellValue = new Integer(results.getInt(columnNames[i]));
                } else if (columnClasses[i] == Float.class) {
                    cellValue = new Float(results.getInt(columnNames[i]));
                } else if (columnClasses[i] == Double.class) {
                    cellValue = new Double(results.getInt(columnNames[i]));
                } else if (columnClasses[i] == java.sql.Date.class) {
                    cellValue = results.getDate(columnNames[i]);
                } else {
                    System.out.println("Can't assign " + columnNames[i]);
                }

                cellList.add(cellValue);
            }

            Object[] cells = cellList.toArray();

            rowList.add(cells);
        }

        contents = new Object[rowList.size()][];

        for (int i = 0; i < contents.length; i++) {
            contents[i] = (Object[]) rowList.get(i);
        }

        System.out.println("Created model with " + contents.length + " rows");

        results.close();
        statement.close();
    }

    public int getRowCount() {
        return contents.length;
    }

    public int getColumnCount() {
        if (contents.length == 0) {
            return 0;
        } else {
            return contents[0].length;
        }
    }

    public Object getValueAt(int row, int column) {
        return contents[row][column];
    }

    public Class getColumnClass(int col) {
        return columnClasses[col];
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }
}

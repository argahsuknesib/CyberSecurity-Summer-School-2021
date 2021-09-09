package com.j256.ormlite.stmt;

public class ColumnArg {
    private final String columnName;
    private final String tableName;

    public ColumnArg(String str) {
        this.tableName = null;
        this.columnName = str;
    }

    public ColumnArg(String str, String str2) {
        this.tableName = str;
        this.columnName = str2;
    }

    public String getTableName() {
        return this.tableName;
    }

    public String getColumnName() {
        return this.columnName;
    }
}

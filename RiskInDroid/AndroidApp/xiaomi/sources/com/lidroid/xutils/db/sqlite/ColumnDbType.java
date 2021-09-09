package com.lidroid.xutils.db.sqlite;

public enum ColumnDbType {
    INTEGER("INTEGER"),
    REAL("REAL"),
    TEXT("TEXT"),
    BLOB("BLOB");
    
    private String value;

    private ColumnDbType(String str) {
        this.value = str;
    }

    public final String toString() {
        return this.value;
    }
}

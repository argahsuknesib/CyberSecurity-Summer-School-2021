package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public class StringType extends BaseDataType {
    public static int DEFAULT_WIDTH = 255;
    private static final StringType singleTon = new StringType();

    public Object parseDefaultString(FieldType fieldType, String str) {
        return str;
    }

    public static StringType getSingleton() {
        return singleTon;
    }

    private StringType() {
        super(SqlType.STRING, new Class[]{String.class});
    }

    protected StringType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    protected StringType(SqlType sqlType) {
        super(sqlType);
    }

    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return databaseResults.getString(i);
    }

    public int getDefaultWidth() {
        return DEFAULT_WIDTH;
    }
}

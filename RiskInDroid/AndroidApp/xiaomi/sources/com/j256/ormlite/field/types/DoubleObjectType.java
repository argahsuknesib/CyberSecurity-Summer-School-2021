package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public class DoubleObjectType extends BaseDataType {
    private static final DoubleObjectType singleTon = new DoubleObjectType();

    public boolean isEscapedValue() {
        return false;
    }

    public static DoubleObjectType getSingleton() {
        return singleTon;
    }

    private DoubleObjectType() {
        super(SqlType.DOUBLE, new Class[]{Double.class});
    }

    protected DoubleObjectType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public Object parseDefaultString(FieldType fieldType, String str) {
        return Double.valueOf(Double.parseDouble(str));
    }

    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return Double.valueOf(databaseResults.getDouble(i));
    }
}

package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public class BooleanIntegerType extends BooleanType {
    private static final Integer FALSE_VALUE = 0;
    private static final Integer TRUE_VALUE = 1;
    private static final BooleanIntegerType singleTon = new BooleanIntegerType();

    public static BooleanIntegerType getSingleton() {
        return singleTon;
    }

    public BooleanIntegerType() {
        super(SqlType.INTEGER);
    }

    public Object parseDefaultString(FieldType fieldType, String str) {
        return javaToSqlArg(fieldType, Boolean.valueOf(Boolean.parseBoolean(str)));
    }

    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return ((Boolean) obj).booleanValue() ? TRUE_VALUE : FALSE_VALUE;
    }

    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return Integer.valueOf(databaseResults.getInt(i));
    }

    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) {
        return ((Integer) obj).intValue() == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public Object resultStringToJava(FieldType fieldType, String str, int i) {
        if (str.length() == 0) {
            return Boolean.FALSE;
        }
        return sqlArgToJava(fieldType, Integer.valueOf(Integer.parseInt(str)), i);
    }
}

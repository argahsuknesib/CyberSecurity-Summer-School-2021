package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.Arrays;

public class ByteArrayType extends BaseDataType {
    private static final ByteArrayType singleTon = new ByteArrayType();

    public boolean isArgumentHolderRequired() {
        return true;
    }

    public static ByteArrayType getSingleton() {
        return singleTon;
    }

    private ByteArrayType() {
        super(SqlType.BYTE_ARRAY);
    }

    protected ByteArrayType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public Object parseDefaultString(FieldType fieldType, String str) {
        if (str == null) {
            return null;
        }
        return str.getBytes();
    }

    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return databaseResults.getBytes(i);
    }

    public boolean dataIsEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return Arrays.equals((byte[]) obj, (byte[]) obj2);
    }

    public Object resultStringToJava(FieldType fieldType, String str, int i) {
        return str.getBytes();
    }

    public Class<?> getPrimaryClass() {
        return byte[].class;
    }
}

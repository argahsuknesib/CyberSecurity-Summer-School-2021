package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class StringBytesType extends BaseDataType {
    private static final StringBytesType singleTon = new StringBytesType();

    public boolean isArgumentHolderRequired() {
        return true;
    }

    public static StringBytesType getSingleton() {
        return singleTon;
    }

    private StringBytesType() {
        super(SqlType.BYTE_ARRAY);
    }

    protected StringBytesType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(getCharsetName(fieldType));
        } catch (UnsupportedEncodingException e) {
            throw SqlExceptionUtil.create("Could not convert default string: ".concat(String.valueOf(str)), e);
        }
    }

    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return databaseResults.getBytes(i);
    }

    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) throws SQLException {
        byte[] bArr = (byte[]) obj;
        String charsetName = getCharsetName(fieldType);
        try {
            return new String(bArr, charsetName);
        } catch (UnsupportedEncodingException e) {
            throw SqlExceptionUtil.create("Could not convert string with charset name: ".concat(String.valueOf(charsetName)), e);
        }
    }

    public Object javaToSqlArg(FieldType fieldType, Object obj) throws SQLException {
        String str = (String) obj;
        String charsetName = getCharsetName(fieldType);
        try {
            return str.getBytes(charsetName);
        } catch (UnsupportedEncodingException e) {
            throw SqlExceptionUtil.create("Could not convert string with charset name: ".concat(String.valueOf(charsetName)), e);
        }
    }

    public Object resultStringToJava(FieldType fieldType, String str, int i) throws SQLException {
        throw new SQLException("String-bytes type cannot be converted from string to Java");
    }

    public Class<?> getPrimaryClass() {
        return String.class;
    }

    private String getCharsetName(FieldType fieldType) {
        return (fieldType == null || fieldType.getFormat() == null) ? "Unicode" : fieldType.getFormat();
    }
}

package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.math.BigDecimal;
import java.sql.SQLException;

public class BigDecimalStringType extends BaseDataType {
    public static int DEFAULT_WIDTH = 255;
    private static final BigDecimalStringType singleTon = new BigDecimalStringType();

    public boolean isAppropriateId() {
        return false;
    }

    public static BigDecimalStringType getSingleton() {
        return singleTon;
    }

    private BigDecimalStringType() {
        super(SqlType.STRING, new Class[]{BigDecimal.class});
    }

    protected BigDecimalStringType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        try {
            return new BigDecimal(str).toString();
        } catch (IllegalArgumentException e) {
            throw SqlExceptionUtil.create("Problems with field " + fieldType + " parsing default BigDecimal string '" + str + "'", e);
        }
    }

    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return databaseResults.getString(i);
    }

    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) throws SQLException {
        try {
            return new BigDecimal((String) obj);
        } catch (IllegalArgumentException e) {
            throw SqlExceptionUtil.create("Problems with column " + i + " parsing BigDecimal string '" + obj + "'", e);
        }
    }

    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return ((BigDecimal) obj).toString();
    }

    public int getDefaultWidth() {
        return DEFAULT_WIDTH;
    }
}

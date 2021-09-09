package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.math.BigInteger;
import java.sql.SQLException;

public class BigIntegerType extends BaseDataType {
    public static int DEFAULT_WIDTH = 255;
    private static final BigIntegerType singleTon = new BigIntegerType();

    public boolean isValidForVersion() {
        return true;
    }

    public boolean isValidGeneratedType() {
        return true;
    }

    public static BigIntegerType getSingleton() {
        return singleTon;
    }

    protected BigIntegerType() {
        super(SqlType.STRING, new Class[]{BigInteger.class});
    }

    protected BigIntegerType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        try {
            return new BigInteger(str).toString();
        } catch (IllegalArgumentException e) {
            throw SqlExceptionUtil.create("Problems with field " + fieldType + " parsing default BigInteger string '" + str + "'", e);
        }
    }

    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return databaseResults.getString(i);
    }

    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) throws SQLException {
        try {
            return new BigInteger((String) obj);
        } catch (IllegalArgumentException e) {
            throw SqlExceptionUtil.create("Problems with column " + i + " parsing BigInteger string '" + obj + "'", e);
        }
    }

    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return ((BigInteger) obj).toString();
    }

    public Object moveToNextValue(Object obj) {
        if (obj == null) {
            return BigInteger.ONE;
        }
        return ((BigInteger) obj).add(BigInteger.ONE);
    }

    public Object convertIdNumber(Number number) {
        return BigInteger.valueOf(number.longValue());
    }
}

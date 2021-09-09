package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public class IntegerObjectType extends BaseDataType {
    private static final IntegerObjectType singleTon = new IntegerObjectType();

    public boolean isEscapedValue() {
        return false;
    }

    public boolean isValidForVersion() {
        return true;
    }

    public boolean isValidGeneratedType() {
        return true;
    }

    public static IntegerObjectType getSingleton() {
        return singleTon;
    }

    private IntegerObjectType() {
        super(SqlType.INTEGER, new Class[]{Integer.class});
    }

    protected IntegerObjectType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public Object parseDefaultString(FieldType fieldType, String str) {
        return Integer.valueOf(Integer.parseInt(str));
    }

    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return Integer.valueOf(databaseResults.getInt(i));
    }

    public Object convertIdNumber(Number number) {
        return Integer.valueOf(number.intValue());
    }

    public Object moveToNextValue(Object obj) {
        if (obj == null) {
            return 1;
        }
        return Integer.valueOf(((Integer) obj).intValue() + 1);
    }
}

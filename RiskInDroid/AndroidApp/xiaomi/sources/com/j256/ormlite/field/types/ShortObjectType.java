package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public class ShortObjectType extends BaseDataType {
    private static final ShortObjectType singleTon = new ShortObjectType();

    public boolean isEscapedValue() {
        return false;
    }

    public boolean isValidForVersion() {
        return true;
    }

    public static ShortObjectType getSingleton() {
        return singleTon;
    }

    private ShortObjectType() {
        super(SqlType.SHORT, new Class[]{Short.class});
    }

    protected ShortObjectType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public Object parseDefaultString(FieldType fieldType, String str) {
        return Short.valueOf(Short.parseShort(str));
    }

    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return Short.valueOf(databaseResults.getShort(i));
    }

    public Object convertIdNumber(Number number) {
        return Short.valueOf(number.shortValue());
    }

    public Object moveToNextValue(Object obj) {
        if (obj == null) {
            return (short) 1;
        }
        return Short.valueOf((short) (((Short) obj).shortValue() + 1));
    }
}

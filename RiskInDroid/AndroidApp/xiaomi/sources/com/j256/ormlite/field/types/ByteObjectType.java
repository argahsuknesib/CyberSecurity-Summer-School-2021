package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public class ByteObjectType extends BaseDataType {
    private static final ByteObjectType singleTon = new ByteObjectType();

    public boolean isEscapedValue() {
        return false;
    }

    public static ByteObjectType getSingleton() {
        return singleTon;
    }

    private ByteObjectType() {
        super(SqlType.BYTE, new Class[]{Byte.class});
    }

    protected ByteObjectType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public Object parseDefaultString(FieldType fieldType, String str) {
        return Byte.valueOf(Byte.parseByte(str));
    }

    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return Byte.valueOf(databaseResults.getByte(i));
    }

    public Object convertIdNumber(Number number) {
        return Byte.valueOf(number.byteValue());
    }
}

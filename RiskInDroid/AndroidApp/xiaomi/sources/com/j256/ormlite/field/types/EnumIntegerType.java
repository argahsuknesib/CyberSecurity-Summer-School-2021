package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EnumIntegerType extends BaseEnumType {
    private static final EnumIntegerType singleTon = new EnumIntegerType();

    public boolean isEscapedValue() {
        return false;
    }

    public static EnumIntegerType getSingleton() {
        return singleTon;
    }

    private EnumIntegerType() {
        super(SqlType.INTEGER);
    }

    protected EnumIntegerType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public Object parseDefaultString(FieldType fieldType, String str) {
        return Integer.valueOf(Integer.parseInt(str));
    }

    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return Integer.valueOf(databaseResults.getInt(i));
    }

    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) throws SQLException {
        if (fieldType == null) {
            return obj;
        }
        Integer num = (Integer) obj;
        Map map = (Map) fieldType.getDataTypeConfigObj();
        if (map == null) {
            return enumVal(fieldType, num, null, fieldType.getUnknownEnumVal());
        }
        return enumVal(fieldType, num, (Enum) map.get(num), fieldType.getUnknownEnumVal());
    }

    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return Integer.valueOf(((Enum) obj).ordinal());
    }

    public Object makeConfigObject(FieldType fieldType) throws SQLException {
        HashMap hashMap = new HashMap();
        Enum[] enumArr = (Enum[]) fieldType.getType().getEnumConstants();
        if (enumArr != null) {
            for (Enum enumR : enumArr) {
                hashMap.put(Integer.valueOf(enumR.ordinal()), enumR);
            }
            return hashMap;
        }
        throw new SQLException("Could not get enum-constants for field ".concat(String.valueOf(fieldType)));
    }

    public Class<?> getPrimaryClass() {
        return Integer.TYPE;
    }
}

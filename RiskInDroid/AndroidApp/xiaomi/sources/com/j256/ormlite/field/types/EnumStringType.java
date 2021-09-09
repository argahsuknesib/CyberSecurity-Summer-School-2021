package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EnumStringType extends BaseEnumType {
    public static int DEFAULT_WIDTH = 100;
    private static final EnumStringType singleTon = new EnumStringType();

    public Object parseDefaultString(FieldType fieldType, String str) {
        return str;
    }

    public static EnumStringType getSingleton() {
        return singleTon;
    }

    private EnumStringType() {
        super(SqlType.STRING, new Class[]{Enum.class});
    }

    protected EnumStringType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return databaseResults.getString(i);
    }

    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) throws SQLException {
        if (fieldType == null) {
            return obj;
        }
        String str = (String) obj;
        Map map = (Map) fieldType.getDataTypeConfigObj();
        if (map == null) {
            return enumVal(fieldType, str, null, fieldType.getUnknownEnumVal());
        }
        return enumVal(fieldType, str, (Enum) map.get(str), fieldType.getUnknownEnumVal());
    }

    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return getEnumName((Enum) obj);
    }

    public Object makeConfigObject(FieldType fieldType) throws SQLException {
        HashMap hashMap = new HashMap();
        Enum[] enumArr = (Enum[]) fieldType.getType().getEnumConstants();
        if (enumArr != null) {
            for (Enum enumR : enumArr) {
                hashMap.put(getEnumName(enumR), enumR);
            }
            return hashMap;
        }
        throw new SQLException("Could not get enum-constants for field " + fieldType + ", not an enum or maybe generic?");
    }

    public int getDefaultWidth() {
        return DEFAULT_WIDTH;
    }

    /* access modifiers changed from: protected */
    public String getEnumName(Enum<?> enumR) {
        return enumR.name();
    }
}

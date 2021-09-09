package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;

public class CharType extends CharacterObjectType {
    private static final CharType singleTon = new CharType();

    public boolean isPrimitive() {
        return true;
    }

    public static CharType getSingleton() {
        return singleTon;
    }

    private CharType() {
        super(SqlType.CHAR, new Class[]{Character.TYPE});
    }

    protected CharType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        Character ch = (Character) obj;
        if (ch == null || ch.charValue() == 0) {
            return null;
        }
        return ch;
    }
}

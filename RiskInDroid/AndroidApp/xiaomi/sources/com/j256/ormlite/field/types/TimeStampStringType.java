package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class TimeStampStringType extends DateStringType {
    private static final TimeStampStringType singleTon = new TimeStampStringType();

    public static TimeStampStringType getSingleton() {
        return singleTon;
    }

    private TimeStampStringType() {
        super(SqlType.STRING);
    }

    protected TimeStampStringType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) throws SQLException {
        return new Timestamp(((Date) super.sqlArgToJava(fieldType, obj, i)).getTime());
    }

    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return super.javaToSqlArg(fieldType, new Date(((Timestamp) obj).getTime()));
    }

    public boolean isValidForField(Field field) {
        return field.getType() == Timestamp.class;
    }

    public Object moveToNextValue(Object obj) {
        long currentTimeMillis = System.currentTimeMillis();
        if (obj == null) {
            return new Timestamp(currentTimeMillis);
        }
        if (currentTimeMillis == ((Timestamp) obj).getTime()) {
            return new Timestamp(currentTimeMillis + 1);
        }
        return new Timestamp(currentTimeMillis);
    }
}

package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.sql.Timestamp;

public class TimeStampType extends DateType {
    private static final TimeStampType singleTon = new TimeStampType();

    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return obj;
    }

    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) {
        return obj;
    }

    public static TimeStampType getSingleton() {
        return singleTon;
    }

    private TimeStampType() {
        super(SqlType.DATE, new Class[]{Timestamp.class});
    }

    protected TimeStampType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
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

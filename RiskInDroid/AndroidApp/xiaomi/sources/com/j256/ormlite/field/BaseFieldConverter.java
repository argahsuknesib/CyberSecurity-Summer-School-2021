package com.j256.ormlite.field;

import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public abstract class BaseFieldConverter implements FieldConverter {
    public boolean isStreamType() {
        return false;
    }

    public Object javaToSqlArg(FieldType fieldType, Object obj) throws SQLException {
        return obj;
    }

    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) throws SQLException {
        return obj;
    }

    public Object resultToJava(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        Object resultToSqlArg = resultToSqlArg(fieldType, databaseResults, i);
        if (resultToSqlArg == null) {
            return null;
        }
        return sqlArgToJava(fieldType, resultToSqlArg, i);
    }
}

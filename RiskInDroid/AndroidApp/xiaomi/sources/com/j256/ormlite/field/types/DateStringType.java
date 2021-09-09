package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.BaseDateType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

public class DateStringType extends BaseDateType {
    public static int DEFAULT_WIDTH = 50;
    private static final DateStringType singleTon = new DateStringType();

    public static DateStringType getSingleton() {
        return singleTon;
    }

    private DateStringType() {
        super(SqlType.STRING);
    }

    protected DateStringType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    protected DateStringType(SqlType sqlType) {
        super(sqlType);
    }

    public Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        BaseDateType.DateStringFormatConfig convertDateStringConfig = convertDateStringConfig(fieldType, defaultDateFormatConfig);
        try {
            return normalizeDateString(convertDateStringConfig, str);
        } catch (ParseException e) {
            throw SqlExceptionUtil.create("Problems with field " + fieldType + " parsing default date-string '" + str + "' using '" + convertDateStringConfig + "'", e);
        }
    }

    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return databaseResults.getString(i);
    }

    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) throws SQLException {
        String str = (String) obj;
        BaseDateType.DateStringFormatConfig convertDateStringConfig = convertDateStringConfig(fieldType, defaultDateFormatConfig);
        try {
            return parseDateString(convertDateStringConfig, str);
        } catch (ParseException e) {
            throw SqlExceptionUtil.create("Problems with column " + i + " parsing date-string '" + str + "' using '" + convertDateStringConfig + "'", e);
        }
    }

    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return convertDateStringConfig(fieldType, defaultDateFormatConfig).getDateFormat().format((Date) obj);
    }

    public Object makeConfigObject(FieldType fieldType) {
        String format = fieldType.getFormat();
        if (format == null) {
            return defaultDateFormatConfig;
        }
        return new BaseDateType.DateStringFormatConfig(format);
    }

    public int getDefaultWidth() {
        return DEFAULT_WIDTH;
    }

    public Object resultStringToJava(FieldType fieldType, String str, int i) throws SQLException {
        return sqlArgToJava(fieldType, str, i);
    }

    public Class<?> getPrimaryClass() {
        return byte[].class;
    }
}

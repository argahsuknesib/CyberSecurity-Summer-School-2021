package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.math.BigDecimal;
import java.sql.SQLException;

public class BigDecimalNumericType extends BaseDataType {
    private static final BigDecimalNumericType singleTon = new BigDecimalNumericType();

    public boolean isAppropriateId() {
        return false;
    }

    public boolean isEscapedValue() {
        return false;
    }

    public static BigDecimalNumericType getSingleton() {
        return singleTon;
    }

    private BigDecimalNumericType() {
        super(SqlType.BIG_DECIMAL);
    }

    protected BigDecimalNumericType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        try {
            return new BigDecimal(str);
        } catch (IllegalArgumentException e) {
            throw SqlExceptionUtil.create("Problems with field " + fieldType + " parsing default BigDecimal string '" + str + "'", e);
        }
    }

    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return databaseResults.getBigDecimal(i);
    }

    public Class<?> getPrimaryClass() {
        return BigDecimal.class;
    }
}

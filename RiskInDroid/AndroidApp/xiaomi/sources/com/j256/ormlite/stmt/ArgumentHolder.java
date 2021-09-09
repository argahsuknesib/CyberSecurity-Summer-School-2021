package com.j256.ormlite.stmt;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

public interface ArgumentHolder {
    String getColumnName();

    FieldType getFieldType();

    Object getSqlArgValue() throws SQLException;

    SqlType getSqlType();

    void setMetaInfo(FieldType fieldType);

    void setMetaInfo(String str);

    void setMetaInfo(String str, FieldType fieldType);

    void setValue(Object obj);
}

package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.List;

interface Comparison extends Clause {
    void appendOperation(StringBuilder sb);

    void appendValue(DatabaseType databaseType, StringBuilder sb, List<ArgumentHolder> list) throws SQLException;

    String getColumnName();
}

package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RawResultsImpl<T> implements GenericRawResults<T> {
    private final String[] columnNames = this.iterator.getRawResults().getColumnNames();
    private SelectIterator<T, Void> iterator;

    public RawResultsImpl(ConnectionSource connectionSource, DatabaseConnection databaseConnection, String str, Class<?> cls, CompiledStatement compiledStatement, GenericRowMapper<T> genericRowMapper, ObjectCache objectCache) throws SQLException {
        this.iterator = new SelectIterator(cls, null, genericRowMapper, connectionSource, databaseConnection, compiledStatement, str, objectCache);
    }

    public int getNumberColumns() {
        return this.columnNames.length;
    }

    public String[] getColumnNames() {
        return this.columnNames;
    }

    public List<T> getResults() throws SQLException {
        ArrayList arrayList = new ArrayList();
        while (this.iterator.hasNext()) {
            try {
                arrayList.add(this.iterator.next());
            } finally {
                IOUtils.closeThrowSqlException(this, "raw results iterator");
            }
        }
        return arrayList;
    }

    public T getFirstResult() throws SQLException {
        try {
            if (this.iterator.hasNextThrow()) {
                return this.iterator.nextThrow();
            }
            IOUtils.closeThrowSqlException(this, "raw results iterator");
            return null;
        } finally {
            IOUtils.closeThrowSqlException(this, "raw results iterator");
        }
    }

    public CloseableIterator<T> iterator() {
        return this.iterator;
    }

    public CloseableIterator<T> closeableIterator() {
        return this.iterator;
    }

    public void close() throws IOException {
        SelectIterator<T, Void> selectIterator = this.iterator;
        if (selectIterator != null) {
            selectIterator.close();
            this.iterator = null;
        }
    }
}

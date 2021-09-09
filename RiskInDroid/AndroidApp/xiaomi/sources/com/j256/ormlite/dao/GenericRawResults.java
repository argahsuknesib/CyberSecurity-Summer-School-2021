package com.j256.ormlite.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface GenericRawResults<T> extends CloseableWrappedIterable<T> {
    void close() throws IOException;

    String[] getColumnNames();

    T getFirstResult() throws SQLException;

    int getNumberColumns();

    List<T> getResults() throws SQLException;
}

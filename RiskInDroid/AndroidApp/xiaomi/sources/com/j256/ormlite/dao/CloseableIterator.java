package com.j256.ormlite.dao;

import com.j256.ormlite.support.DatabaseResults;
import java.io.Closeable;
import java.sql.SQLException;
import java.util.Iterator;

public interface CloseableIterator<T> extends Closeable, Iterator<T> {
    void closeQuietly();

    T current() throws SQLException;

    T first() throws SQLException;

    DatabaseResults getRawResults();

    T moveAbsolute(int i) throws SQLException;

    T moveRelative(int i) throws SQLException;

    void moveToNext();

    T nextThrow() throws SQLException;

    T previous() throws SQLException;
}

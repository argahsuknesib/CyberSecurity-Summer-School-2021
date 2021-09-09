package com.j256.ormlite.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

public interface ForeignCollection<T> extends CloseableIterable<T>, Collection<T> {
    boolean add(T t);

    void closeLastIterator() throws IOException;

    CloseableIterator<T> closeableIterator(int i);

    Dao<T, ?> getDao();

    CloseableWrappedIterable<T> getWrappedIterable();

    CloseableWrappedIterable<T> getWrappedIterable(int i);

    boolean isEager();

    CloseableIterator<T> iterator(int i);

    CloseableIterator<T> iteratorThrow() throws SQLException;

    CloseableIterator<T> iteratorThrow(int i) throws SQLException;

    int refresh(T t) throws SQLException;

    int refreshAll() throws SQLException;

    int refreshCollection() throws SQLException;

    int update(T t) throws SQLException;

    int updateAll() throws SQLException;
}

package com.j256.ormlite.support;

import com.j256.ormlite.dao.ObjectCache;
import java.io.Closeable;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;

public interface DatabaseResults extends Closeable {
    void closeQuietly();

    int findColumn(String str) throws SQLException;

    boolean first() throws SQLException;

    BigDecimal getBigDecimal(int i) throws SQLException;

    InputStream getBlobStream(int i) throws SQLException;

    boolean getBoolean(int i) throws SQLException;

    byte getByte(int i) throws SQLException;

    byte[] getBytes(int i) throws SQLException;

    char getChar(int i) throws SQLException;

    int getColumnCount() throws SQLException;

    String[] getColumnNames() throws SQLException;

    double getDouble(int i) throws SQLException;

    float getFloat(int i) throws SQLException;

    int getInt(int i) throws SQLException;

    long getLong(int i) throws SQLException;

    Object getObject(int i) throws SQLException;

    ObjectCache getObjectCacheForRetrieve();

    ObjectCache getObjectCacheForStore();

    short getShort(int i) throws SQLException;

    String getString(int i) throws SQLException;

    Timestamp getTimestamp(int i) throws SQLException;

    boolean last() throws SQLException;

    boolean moveAbsolute(int i) throws SQLException;

    boolean moveRelative(int i) throws SQLException;

    boolean next() throws SQLException;

    boolean previous() throws SQLException;

    boolean wasNull(int i) throws SQLException;
}

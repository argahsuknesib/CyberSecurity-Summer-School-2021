package com.j256.ormlite.support;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.StatementBuilder;
import java.io.Closeable;
import java.sql.SQLException;
import java.sql.Savepoint;

public interface DatabaseConnection extends Closeable {
    public static final Object MORE_THAN_ONE = new Object();

    void closeQuietly();

    void commit(Savepoint savepoint) throws SQLException;

    CompiledStatement compileStatement(String str, StatementBuilder.StatementType statementType, FieldType[] fieldTypeArr, int i, boolean z) throws SQLException;

    int delete(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException;

    int executeStatement(String str, int i) throws SQLException;

    int insert(String str, Object[] objArr, FieldType[] fieldTypeArr, GeneratedKeyHolder generatedKeyHolder) throws SQLException;

    boolean isAutoCommit() throws SQLException;

    boolean isAutoCommitSupported() throws SQLException;

    boolean isClosed() throws SQLException;

    boolean isTableExists(String str) throws SQLException;

    long queryForLong(String str) throws SQLException;

    long queryForLong(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException;

    <T> Object queryForOne(String str, Object[] objArr, FieldType[] fieldTypeArr, GenericRowMapper<T> genericRowMapper, ObjectCache objectCache) throws SQLException;

    void releaseSavePoint(Savepoint savepoint) throws SQLException;

    void rollback(Savepoint savepoint) throws SQLException;

    void setAutoCommit(boolean z) throws SQLException;

    Savepoint setSavePoint(String str) throws SQLException;

    int update(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException;
}

package com.j256.ormlite.support;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.StatementBuilder;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Savepoint;

public class DatabaseConnectionProxy implements DatabaseConnection {
    private final DatabaseConnection proxy;

    public DatabaseConnectionProxy(DatabaseConnection databaseConnection) {
        this.proxy = databaseConnection;
    }

    public boolean isAutoCommitSupported() throws SQLException {
        DatabaseConnection databaseConnection = this.proxy;
        if (databaseConnection == null) {
            return false;
        }
        return databaseConnection.isAutoCommitSupported();
    }

    public boolean isAutoCommit() throws SQLException {
        DatabaseConnection databaseConnection = this.proxy;
        if (databaseConnection == null) {
            return false;
        }
        return databaseConnection.isAutoCommit();
    }

    public void setAutoCommit(boolean z) throws SQLException {
        DatabaseConnection databaseConnection = this.proxy;
        if (databaseConnection != null) {
            databaseConnection.setAutoCommit(z);
        }
    }

    public Savepoint setSavePoint(String str) throws SQLException {
        DatabaseConnection databaseConnection = this.proxy;
        if (databaseConnection == null) {
            return null;
        }
        return databaseConnection.setSavePoint(str);
    }

    public void commit(Savepoint savepoint) throws SQLException {
        DatabaseConnection databaseConnection = this.proxy;
        if (databaseConnection != null) {
            databaseConnection.commit(savepoint);
        }
    }

    public void rollback(Savepoint savepoint) throws SQLException {
        DatabaseConnection databaseConnection = this.proxy;
        if (databaseConnection != null) {
            databaseConnection.rollback(savepoint);
        }
    }

    public void releaseSavePoint(Savepoint savepoint) throws SQLException {
        DatabaseConnection databaseConnection = this.proxy;
        if (databaseConnection != null) {
            databaseConnection.releaseSavePoint(savepoint);
        }
    }

    public int executeStatement(String str, int i) throws SQLException {
        DatabaseConnection databaseConnection = this.proxy;
        if (databaseConnection == null) {
            return 0;
        }
        return databaseConnection.executeStatement(str, i);
    }

    public CompiledStatement compileStatement(String str, StatementBuilder.StatementType statementType, FieldType[] fieldTypeArr, int i, boolean z) throws SQLException {
        DatabaseConnection databaseConnection = this.proxy;
        if (databaseConnection == null) {
            return null;
        }
        return databaseConnection.compileStatement(str, statementType, fieldTypeArr, i, z);
    }

    public int insert(String str, Object[] objArr, FieldType[] fieldTypeArr, GeneratedKeyHolder generatedKeyHolder) throws SQLException {
        DatabaseConnection databaseConnection = this.proxy;
        if (databaseConnection == null) {
            return 0;
        }
        return databaseConnection.insert(str, objArr, fieldTypeArr, generatedKeyHolder);
    }

    public int update(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        DatabaseConnection databaseConnection = this.proxy;
        if (databaseConnection == null) {
            return 0;
        }
        return databaseConnection.update(str, objArr, fieldTypeArr);
    }

    public int delete(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        DatabaseConnection databaseConnection = this.proxy;
        if (databaseConnection == null) {
            return 0;
        }
        return databaseConnection.delete(str, objArr, fieldTypeArr);
    }

    public <T> Object queryForOne(String str, Object[] objArr, FieldType[] fieldTypeArr, GenericRowMapper<T> genericRowMapper, ObjectCache objectCache) throws SQLException {
        DatabaseConnection databaseConnection = this.proxy;
        if (databaseConnection == null) {
            return null;
        }
        return databaseConnection.queryForOne(str, objArr, fieldTypeArr, genericRowMapper, objectCache);
    }

    public long queryForLong(String str) throws SQLException {
        DatabaseConnection databaseConnection = this.proxy;
        if (databaseConnection == null) {
            return 0;
        }
        return databaseConnection.queryForLong(str);
    }

    public long queryForLong(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        DatabaseConnection databaseConnection = this.proxy;
        if (databaseConnection == null) {
            return 0;
        }
        return databaseConnection.queryForLong(str, objArr, fieldTypeArr);
    }

    public void close() throws IOException {
        DatabaseConnection databaseConnection = this.proxy;
        if (databaseConnection != null) {
            databaseConnection.close();
        }
    }

    public void closeQuietly() {
        DatabaseConnection databaseConnection = this.proxy;
        if (databaseConnection != null) {
            databaseConnection.closeQuietly();
        }
    }

    public boolean isClosed() throws SQLException {
        DatabaseConnection databaseConnection = this.proxy;
        if (databaseConnection == null) {
            return true;
        }
        return databaseConnection.isClosed();
    }

    public boolean isTableExists(String str) throws SQLException {
        DatabaseConnection databaseConnection = this.proxy;
        if (databaseConnection == null) {
            return false;
        }
        return databaseConnection.isTableExists(str);
    }
}

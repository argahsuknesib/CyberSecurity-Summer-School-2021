package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.xiaomi.smarthome.miio.db.record.MessageRecord;
import java.io.IOException;
import java.sql.SQLException;

public class SelectIterator<T, ID> implements CloseableIterator<T> {
    private static final Logger logger = LoggerFactory.getLogger(SelectIterator.class);
    private boolean alreadyMoved;
    private final Dao<T, ID> classDao;
    private boolean closed;
    private final CompiledStatement compiledStmt;
    private final DatabaseConnection connection;
    private final ConnectionSource connectionSource;
    private final Class<?> dataClass;
    private boolean first = true;
    private T last;
    private final DatabaseResults results;
    private int rowC;
    private final GenericRowMapper<T> rowMapper;
    private final String statement;

    public SelectIterator(Class<?> cls, Dao<T, ID> dao, GenericRowMapper<T> genericRowMapper, ConnectionSource connectionSource2, DatabaseConnection databaseConnection, CompiledStatement compiledStatement, String str, ObjectCache objectCache) throws SQLException {
        this.dataClass = cls;
        this.classDao = dao;
        this.rowMapper = genericRowMapper;
        this.connectionSource = connectionSource2;
        this.connection = databaseConnection;
        this.compiledStmt = compiledStatement;
        this.results = compiledStatement.runQuery(objectCache);
        this.statement = str;
        if (str != null) {
            logger.debug("starting iterator @{} for '{}'", Integer.valueOf(hashCode()), str);
        }
    }

    public boolean hasNextThrow() throws SQLException {
        boolean z;
        if (this.closed) {
            return false;
        }
        if (this.alreadyMoved) {
            return true;
        }
        if (this.first) {
            this.first = false;
            z = this.results.first();
        } else {
            z = this.results.next();
        }
        if (!z) {
            IOUtils.closeThrowSqlException(this, "iterator");
        }
        this.alreadyMoved = true;
        return z;
    }

    public boolean hasNext() {
        try {
            return hasNextThrow();
        } catch (SQLException e) {
            this.last = null;
            closeQuietly();
            throw new IllegalStateException("Errors getting more results of " + this.dataClass, e);
        }
    }

    public T first() throws SQLException {
        if (this.closed) {
            return null;
        }
        this.first = false;
        if (this.results.first()) {
            return getCurrent();
        }
        return null;
    }

    public T previous() throws SQLException {
        if (this.closed) {
            return null;
        }
        this.first = false;
        if (this.results.previous()) {
            return getCurrent();
        }
        return null;
    }

    public T current() throws SQLException {
        if (this.closed) {
            return null;
        }
        if (this.first) {
            return first();
        }
        return getCurrent();
    }

    public T nextThrow() throws SQLException {
        boolean z;
        if (this.closed) {
            return null;
        }
        if (!this.alreadyMoved) {
            if (this.first) {
                this.first = false;
                z = this.results.first();
            } else {
                z = this.results.next();
            }
            if (!z) {
                this.first = false;
                return null;
            }
        }
        this.first = false;
        return getCurrent();
    }

    public T next() {
        try {
            T nextThrow = nextThrow();
            if (nextThrow != null) {
                return nextThrow;
            }
            e = null;
            this.last = null;
            closeQuietly();
            throw new IllegalStateException("Could not get next result for " + this.dataClass, e);
        } catch (SQLException e) {
            e = e;
        }
    }

    public T moveRelative(int i) throws SQLException {
        if (this.closed) {
            return null;
        }
        this.first = false;
        if (this.results.moveRelative(i)) {
            return getCurrent();
        }
        return null;
    }

    public T moveAbsolute(int i) throws SQLException {
        if (this.closed) {
            return null;
        }
        this.first = false;
        if (this.results.moveAbsolute(i)) {
            return getCurrent();
        }
        return null;
    }

    public void removeThrow() throws SQLException {
        T t = this.last;
        if (t != null) {
            Dao<T, ID> dao = this.classDao;
            if (dao != null) {
                try {
                    dao.delete((MessageRecord) t);
                } finally {
                    this.last = null;
                }
            } else {
                throw new IllegalStateException("Cannot remove " + this.dataClass + " object because classDao not initialized");
            }
        } else {
            throw new IllegalStateException("No last " + this.dataClass + " object to remove. Must be called after a call to next.");
        }
    }

    public void remove() {
        try {
            removeThrow();
        } catch (SQLException e) {
            closeQuietly();
            throw new IllegalStateException("Could not delete " + this.dataClass + " object " + ((Object) this.last), e);
        }
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.compiledStmt.close();
            this.closed = true;
            this.last = null;
            if (this.statement != null) {
                logger.debug("closed iterator @{} after {} rows", Integer.valueOf(hashCode()), Integer.valueOf(this.rowC));
            }
            try {
                this.connectionSource.releaseConnection(this.connection);
            } catch (SQLException e) {
                throw new IOException("could not release connection", e);
            }
        }
    }

    public void closeQuietly() {
        IOUtils.closeQuietly(this);
    }

    public DatabaseResults getRawResults() {
        return this.results;
    }

    public void moveToNext() {
        this.last = null;
        this.first = false;
        this.alreadyMoved = false;
    }

    private T getCurrent() throws SQLException {
        this.last = this.rowMapper.mapRow(this.results);
        this.alreadyMoved = false;
        this.rowC++;
        return this.last;
    }
}

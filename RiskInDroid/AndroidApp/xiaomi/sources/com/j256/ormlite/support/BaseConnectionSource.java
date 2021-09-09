package com.j256.ormlite.support;

import com.j256.ormlite.logger.Logger;
import java.sql.SQLException;

public abstract class BaseConnectionSource implements ConnectionSource {
    private ThreadLocal<NestedConnection> specialConnection = new ThreadLocal<>();

    public DatabaseConnection getSpecialConnection(String str) {
        NestedConnection nestedConnection = this.specialConnection.get();
        if (nestedConnection == null) {
            return null;
        }
        return nestedConnection.connection;
    }

    /* access modifiers changed from: protected */
    public DatabaseConnection getSavedConnection() {
        NestedConnection nestedConnection = this.specialConnection.get();
        if (nestedConnection == null) {
            return null;
        }
        return nestedConnection.connection;
    }

    /* access modifiers changed from: protected */
    public boolean isSavedConnection(DatabaseConnection databaseConnection) {
        NestedConnection nestedConnection = this.specialConnection.get();
        if (nestedConnection != null && nestedConnection.connection == databaseConnection) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean saveSpecial(DatabaseConnection databaseConnection) throws SQLException {
        NestedConnection nestedConnection = this.specialConnection.get();
        if (nestedConnection == null) {
            this.specialConnection.set(new NestedConnection(databaseConnection));
            return true;
        } else if (nestedConnection.connection == databaseConnection) {
            nestedConnection.increment();
            return false;
        } else {
            throw new SQLException("trying to save connection " + databaseConnection + " but already have saved connection " + nestedConnection.connection);
        }
    }

    /* access modifiers changed from: protected */
    public boolean clearSpecial(DatabaseConnection databaseConnection, Logger logger) {
        NestedConnection nestedConnection = this.specialConnection.get();
        if (databaseConnection != null) {
            if (nestedConnection == null) {
                logger.error("no connection has been saved when clear() called");
            } else if (nestedConnection.connection == databaseConnection) {
                if (nestedConnection.decrementAndGet() == 0) {
                    this.specialConnection.set(null);
                }
                return true;
            } else {
                logger.error("connection saved {} is not the one being cleared {}", nestedConnection.connection, databaseConnection);
            }
        }
        return false;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public boolean isSingleConnection(DatabaseConnection databaseConnection, DatabaseConnection databaseConnection2) throws SQLException {
        databaseConnection.setAutoCommit(true);
        databaseConnection2.setAutoCommit(true);
        try {
            databaseConnection.setAutoCommit(false);
            if (databaseConnection2.isAutoCommit()) {
                databaseConnection.setAutoCommit(true);
                return false;
            }
            databaseConnection.setAutoCommit(true);
            return true;
        } catch (Throwable th) {
            databaseConnection.setAutoCommit(true);
            throw th;
        }
    }

    static class NestedConnection {
        public final DatabaseConnection connection;
        private int nestedC = 1;

        public NestedConnection(DatabaseConnection databaseConnection) {
            this.connection = databaseConnection;
        }

        public void increment() {
            this.nestedC++;
        }

        public int decrementAndGet() {
            this.nestedC--;
            return this.nestedC;
        }
    }
}

package com.j256.ormlite.misc;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class TransactionManager {
    private static final Logger logger = LoggerFactory.getLogger(TransactionManager.class);
    private static final AtomicInteger savePointCounter = new AtomicInteger();
    private static final ThreadLocal<TransactionLevel> transactionLevelThreadLocal = new ThreadLocal<TransactionLevel>() {
        /* class com.j256.ormlite.misc.TransactionManager.AnonymousClass1 */

        /* access modifiers changed from: protected */
        public final TransactionLevel initialValue() {
            return new TransactionLevel();
        }
    };
    private ConnectionSource connectionSource;

    public TransactionManager() {
    }

    public TransactionManager(ConnectionSource connectionSource2) {
        this.connectionSource = connectionSource2;
        initialize();
    }

    public void initialize() {
        if (this.connectionSource == null) {
            throw new IllegalStateException("dataSource was not set on " + getClass().getSimpleName());
        }
    }

    public <T> T callInTransaction(Callable<T> callable) throws SQLException {
        return callInTransaction(this.connectionSource, callable);
    }

    public <T> T callInTransaction(String str, Callable<T> callable) throws SQLException {
        return callInTransaction(str, this.connectionSource, callable);
    }

    public static <T> T callInTransaction(ConnectionSource connectionSource2, Callable<T> callable) throws SQLException {
        return callInTransaction((String) null, connectionSource2, callable);
    }

    public static <T> T callInTransaction(String str, ConnectionSource connectionSource2, Callable<T> callable) throws SQLException {
        DatabaseConnection readWriteConnection = connectionSource2.getReadWriteConnection(str);
        try {
            return callInTransaction(readWriteConnection, connectionSource2.saveSpecialConnection(readWriteConnection), connectionSource2.getDatabaseType(), callable);
        } finally {
            connectionSource2.clearSpecialConnection(readWriteConnection);
            connectionSource2.releaseConnection(readWriteConnection);
        }
    }

    public static <T> T callInTransaction(DatabaseConnection databaseConnection, DatabaseType databaseType, Callable<T> callable) throws SQLException {
        return callInTransaction(databaseConnection, false, databaseType, callable);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0099 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x00af */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006e A[Catch:{ SQLException -> 0x00a5, Exception -> 0x008f, all -> 0x008b }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b8  */
    public static <T> T callInTransaction(DatabaseConnection databaseConnection, boolean z, DatabaseType databaseType, Callable<T> callable) throws SQLException {
        boolean z2;
        TransactionLevel transactionLevel = transactionLevelThreadLocal.get();
        Savepoint savepoint = null;
        boolean z3 = false;
        if (!z) {
            try {
                if (!databaseType.isNestedSavePointsSupported()) {
                    z2 = false;
                    transactionLevel.incrementAndGet();
                    T call = callable.call();
                    if (z3) {
                        if (transactionLevel.decrementAndGet() <= 0) {
                            commit(databaseConnection, savepoint);
                            transactionLevelThreadLocal.remove();
                        } else {
                            release(databaseConnection, savepoint);
                        }
                    }
                    if (z2) {
                        databaseConnection.setAutoCommit(true);
                        logger.trace("restored auto-commit to true");
                    }
                    return call;
                }
            } catch (Throwable th) {
                th = th;
                if (z3) {
                }
                throw th;
            }
        }
        if (databaseConnection.isAutoCommitSupported() && databaseConnection.isAutoCommit()) {
            databaseConnection.setAutoCommit(false);
            try {
                logger.trace("had to set auto-commit to false");
                z3 = true;
            } catch (Throwable th2) {
                th = th2;
                z3 = true;
                if (z3) {
                    databaseConnection.setAutoCommit(true);
                    logger.trace("restored auto-commit to true");
                }
                throw th;
            }
        }
        savepoint = databaseConnection.setSavePoint("ORMLITE" + savePointCounter.incrementAndGet());
        if (savepoint == null) {
            logger.trace("started savePoint transaction");
        } else {
            logger.trace("started savePoint transaction {}", savepoint.getSavepointName());
        }
        z2 = z3;
        z3 = true;
        try {
            transactionLevel.incrementAndGet();
            T call2 = callable.call();
            if (z3) {
            }
            if (z2) {
            }
            return call2;
        } catch (SQLException e) {
            transactionLevel.decrementAndGet();
            if (z3) {
                rollBack(databaseConnection, savepoint);
                logger.error(e, "after commit exception, rolling back to save-point also threw exception");
            }
            throw e;
        } catch (Exception e2) {
            transactionLevel.decrementAndGet();
            if (z3) {
                rollBack(databaseConnection, savepoint);
                logger.error(e2, "after commit exception, rolling back to save-point also threw exception");
            }
            throw SqlExceptionUtil.create("Transaction callable threw non-SQL exception", e2);
        } catch (Throwable th3) {
            z3 = z2;
            th = th3;
            if (z3) {
            }
            throw th;
        }
    }

    public void setConnectionSource(ConnectionSource connectionSource2) {
        this.connectionSource = connectionSource2;
    }

    private static void commit(DatabaseConnection databaseConnection, Savepoint savepoint) throws SQLException {
        String savepointName = savepoint == null ? null : savepoint.getSavepointName();
        databaseConnection.commit(savepoint);
        if (savepointName == null) {
            logger.trace("committed savePoint transaction");
        } else {
            logger.trace("committed savePoint transaction {}", savepointName);
        }
    }

    private static void release(DatabaseConnection databaseConnection, Savepoint savepoint) throws SQLException {
        String savepointName = savepoint == null ? null : savepoint.getSavepointName();
        databaseConnection.releaseSavePoint(savepoint);
        if (savepointName == null) {
            logger.trace("released savePoint transaction");
        } else {
            logger.trace("released savePoint transaction {}", savepointName);
        }
    }

    private static void rollBack(DatabaseConnection databaseConnection, Savepoint savepoint) throws SQLException {
        String savepointName = savepoint == null ? null : savepoint.getSavepointName();
        databaseConnection.rollback(savepoint);
        if (savepointName == null) {
            logger.trace("rolled back savePoint transaction");
        } else {
            logger.trace("rolled back savePoint transaction {}", savepointName);
        }
    }

    static class TransactionLevel {
        int counter;

        private TransactionLevel() {
        }

        /* access modifiers changed from: package-private */
        public int incrementAndGet() {
            int i = this.counter + 1;
            this.counter = i;
            return i;
        }

        /* access modifiers changed from: package-private */
        public int decrementAndGet() {
            int i = this.counter - 1;
            this.counter = i;
            return i;
        }
    }
}

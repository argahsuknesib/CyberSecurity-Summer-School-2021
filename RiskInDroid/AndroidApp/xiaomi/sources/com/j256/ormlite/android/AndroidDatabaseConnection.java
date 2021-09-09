package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.misc.VersionUtils;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Savepoint;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class AndroidDatabaseConnection implements DatabaseConnection {
    private static final String[] NO_STRING_ARGS = new String[0];
    private static Logger logger = LoggerFactory.getLogger(AndroidDatabaseConnection.class);
    private final boolean cancelQueriesEnabled;
    private final SQLiteDatabase db;
    private final boolean readWrite;

    public boolean isAutoCommitSupported() {
        return true;
    }

    public void releaseSavePoint(Savepoint savepoint) {
    }

    static {
        VersionUtils.checkCoreVersusAndroidVersions("VERSION__5.1__");
    }

    public AndroidDatabaseConnection(SQLiteDatabase sQLiteDatabase, boolean z) {
        this(sQLiteDatabase, z, false);
    }

    public AndroidDatabaseConnection(SQLiteDatabase sQLiteDatabase, boolean z, boolean z2) {
        this.db = sQLiteDatabase;
        this.readWrite = z;
        this.cancelQueriesEnabled = z2;
        logger.trace("{}: db {} opened, read-write = {}", this, sQLiteDatabase, Boolean.valueOf(z));
    }

    public boolean isAutoCommit() throws SQLException {
        try {
            boolean inTransaction = this.db.inTransaction();
            logger.trace("{}: in transaction is {}", this, Boolean.valueOf(inTransaction));
            return !inTransaction;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems getting auto-commit from database", e);
        }
    }

    public void setAutoCommit(boolean z) {
        if (z) {
            if (this.db.inTransaction()) {
                this.db.setTransactionSuccessful();
                this.db.endTransaction();
            }
        } else if (!this.db.inTransaction()) {
            this.db.beginTransaction();
        }
    }

    public Savepoint setSavePoint(String str) throws SQLException {
        try {
            this.db.beginTransaction();
            logger.trace("{}: save-point set with name {}", this, str);
            return new OurSavePoint(str);
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems beginning transaction ".concat(String.valueOf(str)), e);
        }
    }

    public boolean isReadWrite() {
        return this.readWrite;
    }

    public void commit(Savepoint savepoint) throws SQLException {
        try {
            this.db.setTransactionSuccessful();
            this.db.endTransaction();
            if (savepoint == null) {
                logger.trace("{}: transaction is successfully ended", this);
            } else {
                logger.trace("{}: transaction {} is successfully ended", this, savepoint.getSavepointName());
            }
        } catch (android.database.SQLException e) {
            if (savepoint == null) {
                throw SqlExceptionUtil.create("problems committing transaction", e);
            }
            throw SqlExceptionUtil.create("problems committing transaction " + savepoint.getSavepointName(), e);
        }
    }

    public void rollback(Savepoint savepoint) throws SQLException {
        try {
            this.db.endTransaction();
            if (savepoint == null) {
                logger.trace("{}: transaction is ended, unsuccessfully", this);
            } else {
                logger.trace("{}: transaction {} is ended, unsuccessfully", this, savepoint.getSavepointName());
            }
        } catch (android.database.SQLException e) {
            if (savepoint == null) {
                throw SqlExceptionUtil.create("problems rolling back transaction", e);
            }
            throw SqlExceptionUtil.create("problems rolling back transaction " + savepoint.getSavepointName(), e);
        }
    }

    public int executeStatement(String str, int i) throws SQLException {
        return AndroidCompiledStatement.execSql(this.db, str, str, NO_STRING_ARGS);
    }

    public CompiledStatement compileStatement(String str, StatementBuilder.StatementType statementType, FieldType[] fieldTypeArr, int i, boolean z) {
        AndroidCompiledStatement androidCompiledStatement = new AndroidCompiledStatement(str, this.db, statementType, this.cancelQueriesEnabled, z);
        logger.trace("{}: compiled statement got {}: {}", this, androidCompiledStatement, str);
        return androidCompiledStatement;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object):void
     arg types: [java.lang.String, com.j256.ormlite.android.AndroidDatabaseConnection, int, java.lang.String]
     candidates:
      com.j256.ormlite.logger.Logger.trace(java.lang.Throwable, java.lang.String, java.lang.Object, java.lang.Object):void
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object):void */
    public int insert(String str, Object[] objArr, FieldType[] fieldTypeArr, GeneratedKeyHolder generatedKeyHolder) throws SQLException {
        try {
            SQLiteStatement compileStatement = this.db.compileStatement(str);
            bindArgs(compileStatement, objArr, fieldTypeArr);
            long executeInsert = compileStatement.executeInsert();
            if (generatedKeyHolder != null) {
                generatedKeyHolder.addKey(Long.valueOf(executeInsert));
            }
            logger.trace("{}: insert statement is compiled and executed, changed {}: {}", (Object) this, (Object) 1, (Object) str);
            closeQuietly(compileStatement);
            return 1;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("inserting to database failed: ".concat(String.valueOf(str)), e);
        } catch (Throwable th) {
            closeQuietly((SQLiteStatement) null);
            throw th;
        }
    }

    public int update(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        return update(str, objArr, fieldTypeArr, "updated");
    }

    public int delete(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        return update(str, objArr, fieldTypeArr, "deleted");
    }

    public <T> Object queryForOne(String str, Object[] objArr, FieldType[] fieldTypeArr, GenericRowMapper<T> genericRowMapper, ObjectCache objectCache) throws SQLException {
        Cursor cursor;
        AndroidDatabaseResults androidDatabaseResults;
        android.database.SQLException e;
        T t = null;
        try {
            cursor = this.db.rawQuery(str, toStrings(objArr));
            try {
                androidDatabaseResults = new AndroidDatabaseResults(cursor, objectCache, true);
            } catch (android.database.SQLException e2) {
                androidDatabaseResults = null;
                e = e2;
                try {
                    throw SqlExceptionUtil.create("queryForOne from database failed: ".concat(String.valueOf(str)), e);
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly(androidDatabaseResults);
                    closeQuietly(cursor);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                androidDatabaseResults = null;
                IOUtils.closeQuietly(androidDatabaseResults);
                closeQuietly(cursor);
                throw th;
            }
            try {
                logger.trace("{}: queried for one result: {}", this, str);
                if (androidDatabaseResults.first()) {
                    t = genericRowMapper.mapRow(androidDatabaseResults);
                    if (androidDatabaseResults.next()) {
                        Object obj = MORE_THAN_ONE;
                        IOUtils.closeQuietly(androidDatabaseResults);
                        closeQuietly(cursor);
                        return obj;
                    }
                }
                IOUtils.closeQuietly(androidDatabaseResults);
                closeQuietly(cursor);
                return t;
            } catch (android.database.SQLException e3) {
                e = e3;
                throw SqlExceptionUtil.create("queryForOne from database failed: ".concat(String.valueOf(str)), e);
            }
        } catch (android.database.SQLException e4) {
            androidDatabaseResults = null;
            e = e4;
            cursor = null;
            throw SqlExceptionUtil.create("queryForOne from database failed: ".concat(String.valueOf(str)), e);
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            androidDatabaseResults = null;
            IOUtils.closeQuietly(androidDatabaseResults);
            closeQuietly(cursor);
            throw th;
        }
    }

    public long queryForLong(String str) throws SQLException {
        SQLiteStatement sQLiteStatement = null;
        try {
            sQLiteStatement = this.db.compileStatement(str);
            long simpleQueryForLong = sQLiteStatement.simpleQueryForLong();
            logger.trace("{}: query for long simple query returned {}: {}", this, Long.valueOf(simpleQueryForLong), str);
            closeQuietly(sQLiteStatement);
            return simpleQueryForLong;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("queryForLong from database failed: ".concat(String.valueOf(str)), e);
        } catch (Throwable th) {
            closeQuietly(sQLiteStatement);
            throw th;
        }
    }

    public long queryForLong(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        Cursor cursor;
        AndroidDatabaseResults androidDatabaseResults;
        android.database.SQLException e;
        try {
            cursor = this.db.rawQuery(str, toStrings(objArr));
            try {
                androidDatabaseResults = new AndroidDatabaseResults(cursor, null, false);
            } catch (android.database.SQLException e2) {
                android.database.SQLException sQLException = e2;
                androidDatabaseResults = null;
                e = sQLException;
                try {
                    throw SqlExceptionUtil.create("queryForLong from database failed: ".concat(String.valueOf(str)), e);
                } catch (Throwable th) {
                    th = th;
                    closeQuietly(cursor);
                    IOUtils.closeQuietly(androidDatabaseResults);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                androidDatabaseResults = null;
                closeQuietly(cursor);
                IOUtils.closeQuietly(androidDatabaseResults);
                throw th;
            }
            try {
                long j = androidDatabaseResults.first() ? androidDatabaseResults.getLong(0) : 0;
                logger.trace("{}: query for long raw query returned {}: {}", this, Long.valueOf(j), str);
                closeQuietly(cursor);
                IOUtils.closeQuietly(androidDatabaseResults);
                return j;
            } catch (android.database.SQLException e3) {
                e = e3;
                throw SqlExceptionUtil.create("queryForLong from database failed: ".concat(String.valueOf(str)), e);
            }
        } catch (android.database.SQLException e4) {
            androidDatabaseResults = null;
            e = e4;
            cursor = null;
            throw SqlExceptionUtil.create("queryForLong from database failed: ".concat(String.valueOf(str)), e);
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            androidDatabaseResults = null;
            closeQuietly(cursor);
            IOUtils.closeQuietly(androidDatabaseResults);
            throw th;
        }
    }

    public void close() throws IOException {
        try {
            this.db.close();
            logger.trace("{}: db {} closed", this, this.db);
        } catch (android.database.SQLException e) {
            throw new IOException("problems closing the database connection", e);
        }
    }

    public void closeQuietly() {
        IOUtils.closeQuietly(this);
    }

    public boolean isClosed() throws SQLException {
        try {
            boolean isOpen = this.db.isOpen();
            logger.trace("{}: db {} isOpen returned {}", this, this.db, Boolean.valueOf(isOpen));
            return !isOpen;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems detecting if the database is closed", e);
        }
    }

    public boolean isTableExists(String str) {
        boolean z = true;
        Cursor rawQuery = this.db.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name = ?", new String[]{str});
        try {
            if (rawQuery.getCount() <= 0) {
                z = false;
            }
            logger.trace("{}: isTableExists '{}' returned {}", this, str, Boolean.valueOf(z));
            return z;
        } finally {
            rawQuery.close();
        }
    }

    private int update(String str, Object[] objArr, FieldType[] fieldTypeArr, String str2) throws SQLException {
        int i;
        SQLiteStatement sQLiteStatement = null;
        try {
            SQLiteStatement compileStatement = this.db.compileStatement(str);
            try {
                bindArgs(compileStatement, objArr, fieldTypeArr);
                compileStatement.execute();
                closeQuietly(compileStatement);
                try {
                    sQLiteStatement = this.db.compileStatement("SELECT CHANGES()");
                    i = (int) sQLiteStatement.simpleQueryForLong();
                } catch (android.database.SQLException unused) {
                    i = 1;
                } catch (Throwable th) {
                    closeQuietly((SQLiteStatement) null);
                    throw th;
                }
                closeQuietly(sQLiteStatement);
                logger.trace("{} statement is compiled and executed, changed {}: {}", str2, Integer.valueOf(i), str);
                return i;
            } catch (android.database.SQLException e) {
                e = e;
                sQLiteStatement = compileStatement;
                try {
                    throw SqlExceptionUtil.create("updating database failed: ".concat(String.valueOf(str)), e);
                } catch (Throwable th2) {
                    th = th2;
                    closeQuietly(sQLiteStatement);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                sQLiteStatement = compileStatement;
                closeQuietly(sQLiteStatement);
                throw th;
            }
        } catch (android.database.SQLException e2) {
            e = e2;
            throw SqlExceptionUtil.create("updating database failed: ".concat(String.valueOf(str)), e);
        }
    }

    private void bindArgs(SQLiteStatement sQLiteStatement, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        if (objArr != null) {
            for (int i = 0; i < objArr.length; i++) {
                Object obj = objArr[i];
                if (obj == null) {
                    sQLiteStatement.bindNull(i + 1);
                } else {
                    SqlType sqlType = fieldTypeArr[i].getSqlType();
                    switch (AnonymousClass1.$SwitchMap$com$j256$ormlite$field$SqlType[sqlType.ordinal()]) {
                        case 1:
                        case 2:
                        case 3:
                            sQLiteStatement.bindString(i + 1, obj.toString());
                            continue;
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            sQLiteStatement.bindLong(i + 1, ((Number) obj).longValue());
                            continue;
                        case 9:
                        case 10:
                            sQLiteStatement.bindDouble(i + 1, ((Number) obj).doubleValue());
                            continue;
                        case 11:
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            sQLiteStatement.bindBlob(i + 1, (byte[]) obj);
                            continue;
                        case 13:
                        case 14:
                        case GmsLogger.MAX_PII_TAG_LENGTH:
                            throw new SQLException("Invalid Android type: ".concat(String.valueOf(sqlType)));
                        default:
                            throw new SQLException("Unknown sql argument type: ".concat(String.valueOf(sqlType)));
                    }
                }
            }
        }
    }

    /* renamed from: com.j256.ormlite.android.AndroidDatabaseConnection$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$field$SqlType = new int[SqlType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.STRING.ordinal()] = 1;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG_STRING.ordinal()] = 2;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.CHAR.ordinal()] = 3;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BOOLEAN.ordinal()] = 4;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE.ordinal()] = 5;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SHORT.ordinal()] = 6;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.INTEGER.ordinal()] = 7;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG.ordinal()] = 8;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.FLOAT.ordinal()] = 9;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DOUBLE.ordinal()] = 10;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE_ARRAY.ordinal()] = 11;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SERIALIZABLE.ordinal()] = 12;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DATE.ordinal()] = 13;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BLOB.ordinal()] = 14;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BIG_DECIMAL.ordinal()] = 15;
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.UNKNOWN.ordinal()] = 16;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private String[] toStrings(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        String[] strArr = new String[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                strArr[i] = null;
            } else {
                strArr[i] = obj.toString();
            }
        }
        return strArr;
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(super.hashCode());
    }

    private void closeQuietly(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    private void closeQuietly(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement != null) {
            sQLiteStatement.close();
        }
    }

    static class OurSavePoint implements Savepoint {
        private String name;

        public int getSavepointId() {
            return 0;
        }

        public OurSavePoint(String str) {
            this.name = str;
        }

        public String getSavepointName() {
            return this.name;
        }
    }
}

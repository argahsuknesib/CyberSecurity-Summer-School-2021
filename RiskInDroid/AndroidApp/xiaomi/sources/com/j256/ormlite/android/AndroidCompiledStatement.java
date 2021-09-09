package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.j256.ormlite.android.compat.ApiCompatibility;
import com.j256.ormlite.android.compat.ApiCompatibilityUtils;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseResults;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class AndroidCompiledStatement implements CompiledStatement {
    private static final String[] NO_STRING_ARGS = new String[0];
    private static final ApiCompatibility apiCompatibility = ApiCompatibilityUtils.getCompatibility();
    private static Logger logger = LoggerFactory.getLogger(AndroidCompiledStatement.class);
    private List<Object> args;
    private final boolean cacheStore;
    private final boolean cancelQueriesEnabled;
    private ApiCompatibility.CancellationHook cancellationHook;
    private Cursor cursor;
    private final SQLiteDatabase db;
    private Integer max;
    private final String sql;
    private final StatementBuilder.StatementType type;

    public void setQueryTimeout(long j) {
    }

    public AndroidCompiledStatement(String str, SQLiteDatabase sQLiteDatabase, StatementBuilder.StatementType statementType, boolean z, boolean z2) {
        this.sql = str;
        this.db = sQLiteDatabase;
        this.type = statementType;
        this.cancelQueriesEnabled = z;
        this.cacheStore = z2;
    }

    public int getColumnCount() throws SQLException {
        return getCursor().getColumnCount();
    }

    public String getColumnName(int i) throws SQLException {
        return getCursor().getColumnName(i);
    }

    public DatabaseResults runQuery(ObjectCache objectCache) throws SQLException {
        if (this.type.isOkForQuery()) {
            return new AndroidDatabaseResults(getCursor(), objectCache, this.cacheStore);
        }
        throw new IllegalArgumentException("Cannot call query on a " + this.type + " statement");
    }

    public int runUpdate() throws SQLException {
        String str;
        if (this.type.isOkForUpdate()) {
            if (this.max == null) {
                str = this.sql;
            } else {
                str = this.sql + " " + this.max;
            }
            return execSql(this.db, "runUpdate", str, getArgArray());
        }
        throw new IllegalArgumentException("Cannot call update on a " + this.type + " statement");
    }

    public int runExecute() throws SQLException {
        if (this.type.isOkForExecute()) {
            return execSql(this.db, "runExecute", this.sql, getArgArray());
        }
        throw new IllegalArgumentException("Cannot call execute on a " + this.type + " statement");
    }

    public void close() throws IOException {
        Cursor cursor2 = this.cursor;
        if (cursor2 != null && !cursor2.isClosed()) {
            try {
                this.cursor.close();
            } catch (android.database.SQLException e) {
                throw new IOException("Problems closing Android cursor", e);
            }
        }
        this.cancellationHook = null;
    }

    public void closeQuietly() {
        Cursor cursor2 = this.cursor;
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public void cancel() {
        ApiCompatibility.CancellationHook cancellationHook2 = this.cancellationHook;
        if (cancellationHook2 != null) {
            cancellationHook2.cancel();
        }
    }

    public void setObject(int i, Object obj, SqlType sqlType) throws SQLException {
        isInPrep();
        if (this.args == null) {
            this.args = new ArrayList();
        }
        if (obj == null) {
            this.args.add(i, null);
            return;
        }
        switch (AnonymousClass1.$SwitchMap$com$j256$ormlite$field$SqlType[sqlType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
            case 9:
            case 10:
            case 11:
                this.args.add(i, obj.toString());
                return;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
            case 13:
                this.args.add(i, obj);
                return;
            case 14:
            case GmsLogger.MAX_PII_TAG_LENGTH:
                throw new SQLException("Invalid Android type: ".concat(String.valueOf(sqlType)));
            default:
                throw new SQLException("Unknown sql argument type: ".concat(String.valueOf(sqlType)));
        }
    }

    /* renamed from: com.j256.ormlite.android.AndroidCompiledStatement$1  reason: invalid class name */
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
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DATE.ordinal()] = 3;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BOOLEAN.ordinal()] = 4;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.CHAR.ordinal()] = 5;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE.ordinal()] = 6;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SHORT.ordinal()] = 7;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.INTEGER.ordinal()] = 8;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG.ordinal()] = 9;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.FLOAT.ordinal()] = 10;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DOUBLE.ordinal()] = 11;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE_ARRAY.ordinal()] = 12;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SERIALIZABLE.ordinal()] = 13;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BLOB.ordinal()] = 14;
            $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BIG_DECIMAL.ordinal()] = 15;
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.UNKNOWN.ordinal()] = 16;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void setMaxRows(int i) throws SQLException {
        isInPrep();
        this.max = Integer.valueOf(i);
    }

    public Cursor getCursor() throws SQLException {
        String str;
        if (this.cursor == null) {
            try {
                if (this.max == null) {
                    str = this.sql;
                } else {
                    str = this.sql + " LIMIT " + this.max;
                }
                if (this.cancelQueriesEnabled) {
                    this.cancellationHook = apiCompatibility.createCancellationHook();
                }
                this.cursor = apiCompatibility.rawQuery(this.db, str, getStringArray(), this.cancellationHook);
                this.cursor.moveToFirst();
                logger.trace("{}: started rawQuery cursor for: {}", this, str);
            } catch (android.database.SQLException e) {
                throw SqlExceptionUtil.create("Problems executing Android query: ".concat(String.valueOf((Object) null)), e);
            }
        }
        return this.cursor;
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(super.hashCode());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
        if (r5 == null) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0020, code lost:
        com.j256.ormlite.android.AndroidCompiledStatement.logger.trace("executing statement {} changed {} rows: {}", r3, java.lang.Integer.valueOf(r2), r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        if (r5 != null) goto L_0x0011;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        r5.close();
     */
    static int execSql(SQLiteDatabase sQLiteDatabase, String str, String str2, Object[] objArr) throws SQLException {
        int i;
        try {
            sQLiteDatabase.execSQL(str2, objArr);
            SQLiteStatement sQLiteStatement = null;
            try {
                sQLiteStatement = sQLiteDatabase.compileStatement("SELECT CHANGES()");
                i = (int) sQLiteStatement.simpleQueryForLong();
            } catch (android.database.SQLException unused) {
                i = 1;
            } catch (Throwable th) {
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                throw th;
            }
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("Problems executing " + str + " Android statement: " + str2, e);
        }
    }

    private void isInPrep() throws SQLException {
        if (this.cursor != null) {
            throw new SQLException("Query already run. Cannot add argument values.");
        }
    }

    private Object[] getArgArray() {
        List<Object> list = this.args;
        if (list == null) {
            return NO_STRING_ARGS;
        }
        return list.toArray(new Object[list.size()]);
    }

    private String[] getStringArray() {
        List<Object> list = this.args;
        if (list == null) {
            return NO_STRING_ARGS;
        }
        return (String[]) list.toArray(new String[list.size()]);
    }
}

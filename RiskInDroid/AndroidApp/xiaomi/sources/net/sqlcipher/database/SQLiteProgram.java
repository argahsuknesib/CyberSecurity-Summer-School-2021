package net.sqlcipher.database;

import android.util.Log;

public abstract class SQLiteProgram extends SQLiteClosable {
    boolean mClosed = false;
    private SQLiteCompiledSql mCompiledSql;
    @Deprecated
    protected SQLiteDatabase mDatabase;
    final String mSql;
    @Deprecated
    protected long nHandle = 0;
    @Deprecated
    protected long nStatement = 0;

    private final native void native_clear_bindings();

    /* access modifiers changed from: protected */
    @Deprecated
    public void compile(String str, boolean z) {
    }

    /* access modifiers changed from: protected */
    public final native void native_bind_blob(int i, byte[] bArr);

    /* access modifiers changed from: protected */
    public final native void native_bind_double(int i, double d);

    /* access modifiers changed from: protected */
    public final native void native_bind_long(int i, long j);

    /* access modifiers changed from: protected */
    public final native void native_bind_null(int i);

    /* access modifiers changed from: protected */
    public final native void native_bind_string(int i, String str);

    /* access modifiers changed from: protected */
    @Deprecated
    public final native void native_compile(String str);

    /* access modifiers changed from: protected */
    @Deprecated
    public final native void native_finalize();

    SQLiteProgram(SQLiteDatabase sQLiteDatabase, String str) {
        this.mDatabase = sQLiteDatabase;
        this.mSql = str.trim();
        sQLiteDatabase.acquireReference();
        sQLiteDatabase.addSQLiteClosable(this);
        this.nHandle = sQLiteDatabase.mNativeHandle;
        String substring = this.mSql.length() >= 6 ? this.mSql.substring(0, 6) : this.mSql;
        if (substring.equalsIgnoreCase("INSERT") || substring.equalsIgnoreCase("UPDATE") || substring.equalsIgnoreCase("REPLAC") || substring.equalsIgnoreCase("DELETE") || substring.equalsIgnoreCase("SELECT")) {
            this.mCompiledSql = sQLiteDatabase.getCompiledStatementForSql(str);
            SQLiteCompiledSql sQLiteCompiledSql = this.mCompiledSql;
            if (sQLiteCompiledSql == null) {
                this.mCompiledSql = new SQLiteCompiledSql(sQLiteDatabase, str);
                this.mCompiledSql.acquire();
                sQLiteDatabase.addToCompiledQueries(str, this.mCompiledSql);
                if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                    Log.v("SQLiteProgram", "Created DbObj (id#" + this.mCompiledSql.nStatement + ") for sql: " + str);
                }
            } else if (!sQLiteCompiledSql.acquire()) {
                long j = this.mCompiledSql.nStatement;
                this.mCompiledSql = new SQLiteCompiledSql(sQLiteDatabase, str);
                if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                    Log.v("SQLiteProgram", "** possible bug ** Created NEW DbObj (id#" + this.mCompiledSql.nStatement + ") because the previously created DbObj (id#" + j + ") was not released for sql:" + str);
                }
            }
            this.nStatement = this.mCompiledSql.nStatement;
            return;
        }
        this.mCompiledSql = new SQLiteCompiledSql(sQLiteDatabase, str);
        this.nStatement = this.mCompiledSql.nStatement;
    }

    /* access modifiers changed from: protected */
    public void onAllReferencesReleased() {
        releaseCompiledSqlIfNotInCache();
        this.mDatabase.releaseReference();
        this.mDatabase.removeSQLiteClosable(this);
    }

    /* access modifiers changed from: protected */
    public void onAllReferencesReleasedFromContainer() {
        releaseCompiledSqlIfNotInCache();
        this.mDatabase.releaseReference();
    }

    private void releaseCompiledSqlIfNotInCache() {
        if (this.mCompiledSql != null) {
            synchronized (this.mDatabase.mCompiledQueries) {
                if (!this.mDatabase.mCompiledQueries.containsValue(this.mCompiledSql)) {
                    this.mCompiledSql.releaseSqlStatement();
                    this.mCompiledSql = null;
                    this.nStatement = 0;
                } else {
                    this.mCompiledSql.release();
                }
            }
        }
    }

    public final long getUniqueId() {
        return this.nStatement;
    }

    /* access modifiers changed from: package-private */
    public String getSqlString() {
        return this.mSql;
    }

    public void bindNull(int i) {
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        } else if (this.mDatabase.isOpen()) {
            acquireReference();
            try {
                native_bind_null(i);
            } finally {
                releaseReference();
            }
        } else {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
    }

    public void bindLong(int i, long j) {
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        } else if (this.mDatabase.isOpen()) {
            acquireReference();
            try {
                native_bind_long(i, j);
            } finally {
                releaseReference();
            }
        } else {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
    }

    public void bindDouble(int i, double d) {
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        } else if (this.mDatabase.isOpen()) {
            acquireReference();
            try {
                native_bind_double(i, d);
            } finally {
                releaseReference();
            }
        } else {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
    }

    public void bindString(int i, String str) {
        if (str == null) {
            throw new IllegalArgumentException("the bind value at index " + i + " is null");
        } else if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        } else if (this.mDatabase.isOpen()) {
            acquireReference();
            try {
                native_bind_string(i, str);
            } finally {
                releaseReference();
            }
        } else {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
    }

    public void bindBlob(int i, byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("the bind value at index " + i + " is null");
        } else if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        } else if (this.mDatabase.isOpen()) {
            acquireReference();
            try {
                native_bind_blob(i, bArr);
            } finally {
                releaseReference();
            }
        } else {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
    }

    public void clearBindings() {
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        } else if (this.mDatabase.isOpen()) {
            acquireReference();
            try {
                native_clear_bindings();
            } finally {
                releaseReference();
            }
        } else {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
    }

    /* JADX INFO: finally extract failed */
    public void close() {
        if (!this.mClosed && this.mDatabase.isOpen()) {
            this.mDatabase.lock();
            try {
                releaseReference();
                this.mDatabase.unlock();
                this.mClosed = true;
            } catch (Throwable th) {
                this.mDatabase.unlock();
                throw th;
            }
        }
    }
}

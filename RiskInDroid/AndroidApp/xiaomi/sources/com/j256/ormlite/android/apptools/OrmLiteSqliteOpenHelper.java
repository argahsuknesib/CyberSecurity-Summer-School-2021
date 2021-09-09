package com.j256.ormlite.android.apptools;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.android.AndroidDatabaseConnection;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.DatabaseTableConfigLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

public abstract class OrmLiteSqliteOpenHelper extends SQLiteOpenHelper {
    protected static Logger logger = LoggerFactory.getLogger(OrmLiteSqliteOpenHelper.class);
    protected boolean cancelQueriesEnabled;
    protected AndroidConnectionSource connectionSource;
    private volatile boolean isOpen;

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource2);

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource2, int i, int i2);

    public OrmLiteSqliteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.connectionSource = new AndroidConnectionSource(this);
        this.isOpen = true;
        logger.trace("{}: constructed connectionSource {}", this, this.connectionSource);
    }

    public OrmLiteSqliteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, int i2) {
        this(context, str, cursorFactory, i, openFileId(context, i2));
    }

    public OrmLiteSqliteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, File file) {
        this(context, str, cursorFactory, i, openFile(file));
    }

    public OrmLiteSqliteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, InputStream inputStream) {
        super(context, str, cursorFactory, i);
        this.connectionSource = new AndroidConnectionSource(this);
        this.isOpen = true;
        if (inputStream != null) {
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream), 4096);
                try {
                    DaoManager.addCachedDatabaseConfigs(DatabaseTableConfigLoader.loadDatabaseConfigFromReader(bufferedReader2));
                    IOUtils.closeQuietly(bufferedReader2);
                    IOUtils.closeQuietly(null);
                } catch (SQLException e) {
                    e = e;
                    inputStream = null;
                    bufferedReader = bufferedReader2;
                    try {
                        throw new IllegalStateException("Could not load object config file", e);
                    } catch (Throwable th) {
                        th = th;
                        IOUtils.closeQuietly(bufferedReader);
                        IOUtils.closeQuietly(inputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    bufferedReader = bufferedReader2;
                    IOUtils.closeQuietly(bufferedReader);
                    IOUtils.closeQuietly(inputStream);
                    throw th;
                }
            } catch (SQLException e2) {
                e = e2;
                throw new IllegalStateException("Could not load object config file", e);
            }
        }
    }

    public ConnectionSource getConnectionSource() {
        if (!this.isOpen) {
            logger.warn(new IllegalStateException(), "Getting connectionSource was called after closed");
        }
        return this.connectionSource;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ConnectionSource connectionSource2 = getConnectionSource();
        DatabaseConnection specialConnection = connectionSource2.getSpecialConnection(null);
        boolean z = true;
        if (specialConnection == null) {
            specialConnection = new AndroidDatabaseConnection(sQLiteDatabase, z, this.cancelQueriesEnabled);
            try {
                connectionSource2.saveSpecialConnection(specialConnection);
            } catch (SQLException e) {
                throw new IllegalStateException("Could not save special connection", e);
            }
        } else {
            z = false;
        }
        try {
            onCreate(sQLiteDatabase, connectionSource2);
        } finally {
            if (z) {
                connectionSource2.clearSpecialConnection(specialConnection);
            }
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        ConnectionSource connectionSource2 = getConnectionSource();
        DatabaseConnection specialConnection = connectionSource2.getSpecialConnection(null);
        boolean z = true;
        if (specialConnection == null) {
            specialConnection = new AndroidDatabaseConnection(sQLiteDatabase, z, this.cancelQueriesEnabled);
            try {
                connectionSource2.saveSpecialConnection(specialConnection);
            } catch (SQLException e) {
                throw new IllegalStateException("Could not save special connection", e);
            }
        } else {
            z = false;
        }
        try {
            onUpgrade(sQLiteDatabase, connectionSource2, i, i2);
        } finally {
            if (z) {
                connectionSource2.clearSpecialConnection(specialConnection);
            }
        }
    }

    public void close() {
        super.close();
        this.connectionSource.close();
        this.isOpen = false;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public <D extends Dao<T, ?>, T> D getDao(Class<T> cls) throws SQLException {
        return DaoManager.createDao(getConnectionSource(), cls);
    }

    public <D extends RuntimeExceptionDao<T, ?>, T> D getRuntimeExceptionDao(Class<T> cls) {
        try {
            return new RuntimeExceptionDao(getDao(cls));
        } catch (SQLException e) {
            throw new RuntimeException("Could not create RuntimeExcepitionDao for class ".concat(String.valueOf(cls)), e);
        }
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(super.hashCode());
    }

    private static InputStream openFileId(Context context, int i) {
        InputStream openRawResource = context.getResources().openRawResource(i);
        if (openRawResource != null) {
            return openRawResource;
        }
        throw new IllegalStateException("Could not find object config file with id ".concat(String.valueOf(i)));
    }

    private static InputStream openFile(File file) {
        if (file == null) {
            return null;
        }
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Could not open config file ".concat(String.valueOf(file)), e);
        }
    }
}

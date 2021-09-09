package com.j256.ormlite.android.apptools;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.database.Cursor;
import com.j256.ormlite.android.AndroidCompiledStatement;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.StatementBuilder;
import java.sql.SQLException;

public class OrmLiteCursorLoader<T> extends AsyncTaskLoader<Cursor> implements Dao.DaoObserver {
    protected Cursor cursor;
    protected Dao<T, ?> dao;
    protected PreparedQuery<T> query;

    public OrmLiteCursorLoader(Context context, Dao<T, ?> dao2, PreparedQuery<T> preparedQuery) {
        super(context);
        this.dao = dao2;
        this.query = preparedQuery;
    }

    public Cursor loadInBackground() {
        try {
            Cursor cursor2 = ((AndroidCompiledStatement) this.query.compile(this.dao.getConnectionSource().getReadOnlyConnection(this.dao.getTableName()), StatementBuilder.StatementType.SELECT)).getCursor();
            cursor2.getCount();
            return cursor2;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deliverResult(Cursor cursor2) {
        if (!isReset()) {
            Cursor cursor3 = this.cursor;
            this.cursor = cursor2;
            if (isStarted()) {
                super.deliverResult((Object) cursor2);
            }
            if (cursor3 != null && cursor3 != cursor2 && !cursor3.isClosed()) {
                cursor3.close();
            }
        } else if (cursor2 != null) {
            cursor2.close();
        }
    }

    /* access modifiers changed from: protected */
    public void onStartLoading() {
        this.dao.registerObserver(this);
        Cursor cursor2 = this.cursor;
        if (cursor2 == null) {
            forceLoad();
            return;
        }
        deliverResult(cursor2);
        if (takeContentChanged()) {
            forceLoad();
        }
    }

    /* access modifiers changed from: protected */
    public void onStopLoading() {
        cancelLoad();
    }

    public void onCanceled(Cursor cursor2) {
        if (cursor2 != null && !cursor2.isClosed()) {
            cursor2.close();
        }
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        super.onReset();
        onStopLoading();
        Cursor cursor2 = this.cursor;
        if (cursor2 != null) {
            if (!cursor2.isClosed()) {
                this.cursor.close();
            }
            this.cursor = null;
        }
        this.dao.unregisterObserver(this);
    }

    public void onChange() {
        onContentChanged();
    }

    public PreparedQuery<T> getQuery() {
        return this.query;
    }

    public void setQuery(PreparedQuery<T> preparedQuery) {
        this.query = preparedQuery;
    }
}

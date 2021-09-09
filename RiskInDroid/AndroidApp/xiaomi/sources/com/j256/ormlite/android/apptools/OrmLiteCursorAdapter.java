package com.j256.ormlite.android.apptools;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.CursorAdapter;
import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.stmt.PreparedQuery;
import java.sql.SQLException;

public abstract class OrmLiteCursorAdapter<T, ViewType extends View> extends CursorAdapter {
    protected PreparedQuery<T> preparedQuery;

    public abstract void bindView(ViewType viewtype, Context context, T t);

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.widget.CursorAdapter.<init>(android.content.Context, android.database.Cursor, boolean):void}
     arg types: [android.content.Context, ?[OBJECT, ARRAY], int]
     candidates:
      ClspMth{android.widget.CursorAdapter.<init>(android.content.Context, android.database.Cursor, int):void}
      ClspMth{android.widget.CursorAdapter.<init>(android.content.Context, android.database.Cursor, boolean):void} */
    public OrmLiteCursorAdapter(Context context) {
        super(context, (Cursor) null, false);
    }

    public final void bindView(View view, Context context, Cursor cursor) {
        doBindView(view, context, cursor);
    }

    /* access modifiers changed from: protected */
    public void doBindView(View view, Context context, Cursor cursor) {
        try {
            bindView(view, context, cursorToObject(cursor));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public T getTypedItem(int i) {
        try {
            return cursorToObject((Cursor) super.getItem(i));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    public T cursorToObject(Cursor cursor) throws SQLException {
        return this.preparedQuery.mapRow(new AndroidDatabaseResults(cursor, null, true));
    }

    public final void changeCursor(Cursor cursor) {
        throw new UnsupportedOperationException("Please use OrmLiteCursorAdapter.changeCursor(Cursor,PreparedQuery) instead");
    }

    public void changeCursor(Cursor cursor, PreparedQuery<T> preparedQuery2) {
        setPreparedQuery(preparedQuery2);
        super.changeCursor(cursor);
    }

    public void setPreparedQuery(PreparedQuery<T> preparedQuery2) {
        this.preparedQuery = preparedQuery2;
    }
}

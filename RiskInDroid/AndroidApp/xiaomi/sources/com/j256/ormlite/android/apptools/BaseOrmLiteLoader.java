package com.j256.ormlite.android.apptools;

import android.content.AsyncTaskLoader;
import android.content.Context;
import com.j256.ormlite.dao.Dao;
import java.util.List;

public abstract class BaseOrmLiteLoader<T, ID> extends AsyncTaskLoader<List<T>> implements Dao.DaoObserver {
    private List<T> cachedResults;
    protected Dao<T, ID> dao;

    public BaseOrmLiteLoader(Context context) {
        super(context);
    }

    public BaseOrmLiteLoader(Context context, Dao<T, ID> dao2) {
        super(context);
        this.dao = dao2;
    }

    public void deliverResult(List<T> list) {
        if (!isReset() && isStarted()) {
            super.deliverResult((Object) list);
        }
    }

    /* access modifiers changed from: protected */
    public void onStartLoading() {
        List<T> list = this.cachedResults;
        if (list != null) {
            deliverResult((List) list);
        }
        if (takeContentChanged() || this.cachedResults == null) {
            forceLoad();
        }
        this.dao.registerObserver(this);
    }

    /* access modifiers changed from: protected */
    public void onStopLoading() {
        cancelLoad();
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        super.onReset();
        onStopLoading();
        List<T> list = this.cachedResults;
        if (list != null) {
            list.clear();
            this.cachedResults = null;
        }
        this.dao.unregisterObserver(this);
    }

    public void onChange() {
        onContentChanged();
    }

    public void setDao(Dao<T, ID> dao2) {
        this.dao = dao2;
    }
}

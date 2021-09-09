package com.j256.ormlite.android.apptools;

import android.app.ActivityGroup;
import android.content.Context;
import android.os.Bundle;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;

public abstract class OrmLiteBaseActivityGroup<H extends OrmLiteSqliteOpenHelper> extends ActivityGroup {
    private volatile boolean created = false;
    private volatile boolean destroyed = false;
    private volatile H helper;

    public H getHelper() {
        if (this.helper != null) {
            return this.helper;
        }
        if (!this.created) {
            throw new IllegalStateException("A call has not been made to onCreate() yet so the helper is null");
        } else if (this.destroyed) {
            throw new IllegalStateException("A call to onDestroy has already been made and the helper cannot be used after that point");
        } else {
            throw new IllegalStateException("Helper is null for some unknown reason");
        }
    }

    public ConnectionSource getConnectionSource() {
        return getHelper().getConnectionSource();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        if (this.helper == null) {
            this.helper = getHelperInternal(this);
            this.created = true;
        }
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        releaseHelper(this.helper);
        this.destroyed = true;
    }

    /* access modifiers changed from: protected */
    public H getHelperInternal(Context context) {
        return OpenHelperManager.getHelper(context);
    }

    /* access modifiers changed from: protected */
    public void releaseHelper(H h) {
        OpenHelperManager.releaseHelper();
        this.helper = null;
    }
}

package com.mibi.sdk.component;

import android.os.Bundle;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.mvp.IView;
import com.mibi.sdk.mvp.Presenter;

public class BaseMvpPresenter<T extends IView> extends Presenter<T> {
    private Session mSession;

    public BaseMvpPresenter(Class<T> cls) {
        super(cls);
    }

    public void onInit(Bundle bundle) {
        super.onInit(bundle);
    }

    /* access modifiers changed from: package-private */
    public synchronized void updateSession(Session session) {
        this.mSession = session;
    }

    public synchronized Session getSession() {
        checkInLifecycle();
        return this.mSession;
    }
}

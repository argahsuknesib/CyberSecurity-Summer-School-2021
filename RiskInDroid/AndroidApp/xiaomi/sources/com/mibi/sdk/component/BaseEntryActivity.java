package com.mibi.sdk.component;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.mibi.sdk.common.Utils;
import com.mibi.sdk.common.account.loader.AccountLoader;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.common.session.SessionManager;

public abstract class BaseEntryActivity extends Activity implements EntryResultCallback {
    private final String TAG = getClass().getSimpleName();
    private BaseEntryHandler mEntryHandler;
    protected Session mSession;

    /* access modifiers changed from: protected */
    public abstract void doEntryFailed(int i, String str);

    /* access modifiers changed from: protected */
    public abstract void doEntrySuccess();

    /* access modifiers changed from: protected */
    public boolean isNoAccount() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        Log.d(this.TAG, "onCreate");
        doPreCreate(bundle);
        super.onCreate(bundle);
        doCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void doPreCreate(Bundle bundle) {
        if (this.mEntryHandler == null) {
            this.mEntryHandler = new BaseEntryHandler(this, this);
        }
        if (bundle != null) {
            this.mSession = SessionManager.restoreOrUpdateSession(this, (Session.SessionSaveData) bundle.getParcelable("session"), null);
        }
    }

    /* access modifiers changed from: protected */
    public void doCreate(Bundle bundle) {
        if (bundle == null) {
            startEntryProcess(bundle, isNoAccount());
        }
    }

    private void startEntryProcess(Bundle bundle, boolean z) {
        this.mEntryHandler.startEntryProcess(bundle, z);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        Log.d(this.TAG, "onSaveInstanceState");
        super.onSaveInstanceState(bundle);
        doSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void doSaveInstanceState(Bundle bundle) {
        Session session = this.mSession;
        if (session != null) {
            bundle.putParcelable("session", SessionManager.saveSession(session));
        }
    }

    public Session getSession() {
        return this.mSession;
    }

    /* access modifiers changed from: protected */
    public Session buildSession(AccountLoader accountLoader) {
        return SessionManager.newSession(this, accountLoader);
    }

    public final void onEntrySuccess(AccountLoader accountLoader) {
        this.mSession = buildSession(accountLoader);
        String str = this.TAG;
        Log.d(str, "versionName : 000.003.105 ; versionCode : " + 38L);
        doEntrySuccess();
    }

    public final void onEntryFailed(int i, String str) {
        doEntryFailed(i, str);
    }

    /* access modifiers changed from: protected */
    public void returnError(int i, String str) {
        returnError(i, str, null);
    }

    /* access modifiers changed from: protected */
    public void returnError(int i, String str, Bundle bundle) {
        setResult(i, EntryResultUtils.makeResult(i, str, bundle));
    }

    /* access modifiers changed from: protected */
    public void returnSuccess(Intent intent) {
        setResult(-1, intent);
    }

    /* access modifiers changed from: protected */
    public void returnResult(int i, Intent intent) {
        if (i == -1) {
            returnSuccess(intent);
        } else if (intent != null) {
            returnError(i, intent.getStringExtra("message"), intent.getBundleExtra("result"));
        } else {
            returnError(i, "data is null", null);
        }
    }

    public final void startActivityForResult(Intent intent, int i, Bundle bundle) {
        Session session;
        if (Utils.isInnerIntent(this, intent) && (session = this.mSession) != null) {
            intent.putExtra("session", SessionManager.saveSession(session));
        }
        super.startActivityForResult(intent, i, bundle);
    }

    public final void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        Session session;
        if (Utils.isInnerIntent(this, intent) && (session = this.mSession) != null) {
            intent.putExtra("session", SessionManager.saveSession(session));
        }
        super.startActivityFromFragment(fragment, intent, i, bundle);
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i, int i2, Intent intent) {
        Log.d(this.TAG, "onActivityResult");
        super.onActivityResult(i, i2, intent);
        doActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: protected */
    public void doActivityResult(int i, int i2, Intent intent) {
        this.mEntryHandler.handleActivityResult(i, i2, intent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.mEntryHandler.onRequestPermissionsResult(i, strArr, iArr);
    }
}

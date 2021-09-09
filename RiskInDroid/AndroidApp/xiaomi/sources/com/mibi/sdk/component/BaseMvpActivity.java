package com.mibi.sdk.component;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.mibi.sdk.common.Client;
import com.mibi.sdk.common.Utils;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.common.session.SessionManager;
import com.mibi.sdk.mvp.MvpActivity;
import com.xiaomi.smarthome.R;

public abstract class BaseMvpActivity extends MvpActivity {
    public Session mSession;
    private String mTag;

    /* access modifiers changed from: protected */
    public boolean handleBackPressed() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    public void handleCreate(Bundle bundle) {
        this.mTag = getClass().getSimpleName();
        Log.d(this.mTag, "handleCreate");
        Client.init(this);
        Session.SessionSaveData sessionSaveData = (Session.SessionSaveData) getIntent().getParcelableExtra("session");
        if (sessionSaveData == null) {
            Log.d(this.mTag, "session in intent is null");
        }
        Session.SessionSaveData sessionSaveData2 = null;
        if (bundle != null) {
            sessionSaveData2 = bundle.getParcelable("SAVE_SESSION");
        }
        this.mSession = SessionManager.restoreOrUpdateSession(this, sessionSaveData2, sessionSaveData);
        BaseMvpPresenter baseMvpPresenter = (BaseMvpPresenter) getPresenter();
        if (baseMvpPresenter != null) {
            baseMvpPresenter.updateSession(this.mSession);
        }
    }

    public void onResume() {
        Log.d(this.mTag, "onResume");
        super.onResume();
        Session session = this.mSession;
        if (session == null) {
            return;
        }
        if (session.isSessionClosed()) {
            finish();
        } else if (this.mSession.isAccountChanged()) {
            new AlertDialog.Builder(this).setTitle((int) R.string.mibi_error_account_changed_title).setMessage((int) R.string.mibi_error_account_changed_summary).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                /* class com.mibi.sdk.component.BaseMvpActivity.AnonymousClass1 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    BaseMvpActivity.this.mSession.closeSession(10, BaseMvpActivity.this.getString(R.string.mibi_error_account_changed_summary));
                    BaseMvpActivity.this.setResult(9805);
                    BaseMvpActivity.this.finish();
                }
            }).show().setCancelable(false);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        Log.d(this.mTag, "onSaveInstanceState");
        super.onSaveInstanceState(bundle);
        Session session = this.mSession;
        if (session != null) {
            bundle.putParcelable("SAVE_SESSION", SessionManager.saveSession(session));
        }
    }

    public void onBackPressed() {
        if (!handleBackPressed()) {
            setResult(9806, EntryResultUtils.makeResult(9806, "user canceled"));
        }
        super.onBackPressed();
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        dealWithStartIntent(intent);
        super.startActivityForResult(intent, i, bundle);
    }

    private void dealWithStartIntent(Intent intent) {
        Session session;
        if (Utils.isInnerIntent(this, intent) && (session = this.mSession) != null) {
            intent.putExtra("session", SessionManager.saveSession(session));
        }
    }
}

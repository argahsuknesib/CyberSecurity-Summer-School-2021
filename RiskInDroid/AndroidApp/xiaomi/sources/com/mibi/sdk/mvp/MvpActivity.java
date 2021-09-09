package com.mibi.sdk.mvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class MvpActivity extends Activity implements IPresenterFactory, IView {
    private Map<String, IPresenter> mPresenters = new HashMap();
    private String mViewUuid;

    /* access modifiers changed from: protected */
    public abstract void handleCreate(Bundle bundle);

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.mViewUuid = UUID.randomUUID().toString();
        } else {
            this.mViewUuid = bundle.getString("SAVE_VIEW_UUID");
        }
        handleCreate(bundle);
        IPresenter presenter = getPresenter();
        if (presenter != null) {
            Bundle bundle2 = null;
            if (bundle != null) {
                bundle2 = bundle.getBundle("KEY_SAVE_PRESENTER_DATA");
            }
            presenter.init(this, getIntent().getExtras(), bundle2);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        IPresenter presenter = getPresenter();
        if (presenter != null) {
            Bundle bundle2 = new Bundle();
            presenter.save(bundle2);
            bundle.putBundle("KEY_SAVE_PRESENTER_DATA", bundle2);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        IPresenter presenter = getPresenter();
        if (presenter != null) {
            presenter.attach(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IPresenter presenter = getPresenter();
        if (presenter != null) {
            presenter.resume(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        IPresenter presenter = getPresenter();
        if (presenter != null) {
            presenter.detach();
        }
    }

    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.onSaveInstanceState(bundle, persistableBundle);
        IPresenter presenter = getPresenter();
        if (presenter != null) {
            presenter.save(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (!isChangingConfigurations()) {
            for (IPresenter next : this.mPresenters.values()) {
                if (next != null) {
                    next.release();
                }
            }
            this.mPresenters.clear();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (getPresenter() != null) {
            if (intent == null) {
                intent = new Intent();
            }
            getPresenter().handleResult(i, i2, intent.getExtras());
        }
    }

    public final IPresenter getPresenter() {
        IPresenter iPresenter = this.mPresenters.get(this.mViewUuid);
        if (iPresenter != null) {
            return iPresenter;
        }
        IPresenter onCreatePresenter = onCreatePresenter();
        this.mPresenters.put(this.mViewUuid, onCreatePresenter);
        return onCreatePresenter;
    }
}

package com.xiaomi.passport.ui.internal;

import _m_j.egq;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.accountsdk.account.XMPassportSettings;

public class BaseActivity extends Activity {

    /* renamed from: O000000o  reason: collision with root package name */
    egq f6241O000000o;

    /* access modifiers changed from: protected */
    public boolean O000000o() {
        return true;
    }

    public void onBackPressed() {
        egq egq = this.f6241O000000o;
        if (egq == null || !egq.O000000o()) {
            try {
                super.onBackPressed();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        XMPassportSettings.ensureApplicationContext(getApplication());
        isTranslucentStatusBar();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    public void setContentView(int i) {
        setContentView(LayoutInflater.from(this).inflate(i, (ViewGroup) null));
    }

    public void setContentView(View view) {
        if (isTranslucentStatusBar()) {
            view.setFitsSystemWindows(true);
        }
        super.setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (isTranslucentStatusBar()) {
            view.setFitsSystemWindows(true);
        }
        super.setContentView(view, layoutParams);
    }

    public boolean isTranslucentStatusBar() {
        return O000000o();
    }

    public void setOnBackListener(egq egq) {
        this.f6241O000000o = egq;
    }

    public egq getOnBackListener() {
        return this.f6241O000000o;
    }
}

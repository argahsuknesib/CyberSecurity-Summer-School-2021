package com.xiaomi.smarthome.operation.js_sdk.base;

import _m_j.ee;
import _m_j.ei;
import _m_j.fvm;
import _m_j.gsy;
import _m_j.hke;
import _m_j.hkj;
import _m_j.hlc;
import _m_j.hlo;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.WebViewRouterFactory;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.operation.js_sdk.lifecycle.AppBackFrontObserver;
import com.xiaomi.smarthome.operation.js_sdk.lifecycle.LifeCycleEvent;
import com.xiaomi.smarthome.operation.js_sdk.statistics.WebViewDurationStatManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseFragmentWebViewActivity extends BaseActivity implements hkj {
    private final AppBackFrontObserver mAppBackFrontObserver = new AppBackFrontObserver();
    public hlc mWebViewLifeCycleDispatcher = null;

    /* access modifiers changed from: protected */
    public abstract int getFragmentContainerId();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        popAllFragmentIfNeeded();
    }

    private void popAllFragmentIfNeeded() {
        try {
            ee supportFragmentManager = getSupportFragmentManager();
            for (int i = 0; i < supportFragmentManager.O00000oO(); i++) {
                supportFragmentManager.O00000o0();
            }
        } catch (Exception unused) {
        }
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        installLifecycleDispatcher();
        try {
            WebViewRouterFactory.getWebViewHelpManager().assistActivity(this);
            WebViewRouterFactory.getWebViewHelpManager().setShouldFitSoftKeybord(true);
        } catch (Exception unused) {
        }
    }

    public void onDestroy() {
        super.onDestroy();
        WebViewRouterFactory.getWebViewHelpManager().cleanInstance();
    }

    private void installLifecycleDispatcher() {
        if (this.mWebViewLifeCycleDispatcher == null) {
            this.mWebViewLifeCycleDispatcher = new hlc();
            getLifecycle().O000000o(this.mAppBackFrontObserver);
            getLifecycle().O000000o(WebViewDurationStatManager.O000000o(this));
            hlc hlc = this.mWebViewLifeCycleDispatcher;
            WebViewDurationStatManager O000000o2 = WebViewDurationStatManager.O000000o(this);
            synchronized (hlc.f19030O000000o) {
                if (O000000o2 != null) {
                    hlc.f19030O000000o.add(O000000o2);
                }
            }
            this.mAppBackFrontObserver.O00000Oo = new AppBackFrontObserver.O000000o() {
                /* class com.xiaomi.smarthome.operation.js_sdk.base.BaseFragmentWebViewActivity.AnonymousClass1 */

                public final void O000000o() {
                    if (BaseFragmentWebViewActivity.this.mWebViewLifeCycleDispatcher != null) {
                        BaseFragmentWebViewActivity.this.mWebViewLifeCycleDispatcher.O000000o(LifeCycleEvent.APP_RESUME, BaseFragmentWebViewActivity.this.getLatestFragment(), null);
                    }
                }

                public final void O00000Oo() {
                    if (BaseFragmentWebViewActivity.this.mWebViewLifeCycleDispatcher != null) {
                        BaseFragmentWebViewActivity.this.mWebViewLifeCycleDispatcher.O000000o(LifeCycleEvent.APP_PAUSE, BaseFragmentWebViewActivity.this.getLatestFragment(), null);
                    }
                }
            };
        }
    }

    public void popWindow(String str) {
        List<hke> filterdFragments = getFilterdFragments();
        if (filterdFragments.size() == 1) {
            handlePopWindowOptions(str);
            return;
        }
        super.onBackPressed();
        if (filterdFragments.size() > 1) {
            hke hke = filterdFragments.get(filterdFragments.size() - 2);
            hlc hlc = this.mWebViewLifeCycleDispatcher;
            if (hlc != null) {
                hlc.O000000o(LifeCycleEvent.PAGE_RESUME, hke, str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void handlePopWindowOptions(String str) {
        if (TextUtils.isEmpty(str)) {
            finish();
            return;
        }
        try {
            String optString = new JSONObject(str).optString("homeId");
            if (TextUtils.isEmpty(optString)) {
                finish();
            } else {
                WebViewRouterFactory.getWebViewHelpManager().changeHome(this, optString);
            }
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    private List<hke> getFilterdFragments() {
        List<Fragment> O00000oo = getSupportFragmentManager().O00000oo();
        if (O00000oo == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Fragment next : O00000oo) {
            if (next instanceof hke) {
                arrayList.add((hke) next);
            }
        }
        return arrayList;
    }

    public void pushWindow(String str) {
        try {
            String optString = new JSONObject(str).optString("url");
            if (TextUtils.isEmpty(optString)) {
                gsy.O00000Oo("OperationCommonWebView", "pushWindow: invalid url: ".concat(String.valueOf(str)));
                return;
            }
            hke newInstance = hke.newInstance(optString, "", !isFullscreenRequested(str));
            List<hke> filterdFragments = getFilterdFragments();
            hke hke = !filterdFragments.isEmpty() ? filterdFragments.get(filterdFragments.size() - 1) : null;
            openNewWindow(hke, newInstance);
            if (this.mWebViewLifeCycleDispatcher != null) {
                this.mWebViewLifeCycleDispatcher.O000000o(LifeCycleEvent.PAGE_PAUSE, hke, null);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void openNewWindow(hke hke, hke hke2) {
        ee supportFragmentManager = getSupportFragmentManager();
        ei O000000o2 = supportFragmentManager.O000000o();
        String valueOf = String.valueOf(supportFragmentManager.O00000oO());
        if (hke != hke2) {
            if (hke != null) {
                O000000o2.O000000o((int) R.anim.fragment_in, (int) R.anim.fragment_out, (int) R.anim.fragment_in_right, (int) R.anim.fragment_out_right);
            }
            O000000o2.O000000o(valueOf);
            if (hke2.isAdded()) {
                if (hke != null) {
                    O000000o2.O00000Oo(hke);
                }
                O000000o2.O00000o0(hke2).O00000Oo();
                return;
            }
            if (hke != null) {
                O000000o2.O00000Oo(hke);
            }
            O000000o2.O000000o(getFragmentContainerId(), hke2, valueOf).O00000Oo();
        }
    }

    public void onBackPressed() {
        fvm fvm;
        List<hke> filterdFragments = getFilterdFragments();
        if (filterdFragments.size() <= 0 || (fvm = filterdFragments.get(filterdFragments.size() - 1)) == null || !fvm.onBackPressed()) {
            if (filterdFragments.size() == 1) {
                finish();
            } else {
                super.onBackPressed();
            }
            if (filterdFragments.size() > 1) {
                hke hke = filterdFragments.get(filterdFragments.size() - 2);
                hlc hlc = this.mWebViewLifeCycleDispatcher;
                if (hlc != null) {
                    hlc.O000000o(LifeCycleEvent.PAGE_RESUME, hke, "");
                }
            }
        }
    }

    public void onBackButtonClick() {
        onBackPressed();
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        AppBackFrontObserver appBackFrontObserver = this.mAppBackFrontObserver;
        if (i == 20 && appBackFrontObserver.O00000Oo != null && appBackFrontObserver.f10519O000000o != AppBackFrontObserver.CurrentAppState.BACK) {
            appBackFrontObserver.f10519O000000o = AppBackFrontObserver.CurrentAppState.BACK;
            appBackFrontObserver.O00000Oo.O00000Oo();
        }
    }

    /* access modifiers changed from: protected */
    public hke getLatestFragment() {
        List<hke> filterdFragments = getFilterdFragments();
        if (filterdFragments.isEmpty()) {
            return null;
        }
        return filterdFragments.get(filterdFragments.size() - 1);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (hlo.O000000o(i)) {
            hlo.O000000o(this).O000000o(i, i2, intent);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isFullscreenRequested(String str) {
        return str != null && str.contains("fullscreen=1");
    }
}

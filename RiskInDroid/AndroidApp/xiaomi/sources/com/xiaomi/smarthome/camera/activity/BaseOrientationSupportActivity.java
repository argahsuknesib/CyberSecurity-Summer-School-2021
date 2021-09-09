package com.xiaomi.smarthome.camera.activity;

import _m_j.cib;
import _m_j.exz;
import _m_j.gwg;
import _m_j.hyy;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.camera.v4.utils.OrientationListener;
import com.xiaomi.smarthome.framework.page.CommonActivity;

public class BaseOrientationSupportActivity extends CommonActivity implements cib {
    private volatile int mCurrOrientation = 1;
    public boolean mFullScreen;
    private OrientationListener mOrientationListener;
    private boolean mPadFullScreen;

    public boolean supportOrientationListen() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gwg.O00000Oo(getWindow());
        if (supportOrientationListen()) {
            this.mOrientationListener = new OrientationListener(this);
            this.mOrientationListener.setOnOrientationListener(new OrientationListener.OnOrientationListener() {
                /* class com.xiaomi.smarthome.camera.activity.$$Lambda$BaseOrientationSupportActivity$3IyK1d5sWtTHGkIbvj8A42vbBw4 */

                public final void onOrientationChanged(int i) {
                    BaseOrientationSupportActivity.this.lambda$onCreate$0$BaseOrientationSupportActivity(i);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreate$0$BaseOrientationSupportActivity(int i) {
        if (hyy.O000000o() && this.mCurrOrientation != i) {
            this.mCurrOrientation = i;
            setRequestedOrientation(i);
        }
    }

    public void setRequestedOrientation(int i) {
        super.setRequestedOrientation(i);
        hyy.O000000o(this, i);
    }

    public void onResume() {
        super.onResume();
        OrientationListener orientationListener = this.mOrientationListener;
        if (orientationListener != null) {
            orientationListener.registerListener();
        }
    }

    public void onPause() {
        super.onPause();
        OrientationListener orientationListener = this.mOrientationListener;
        if (orientationListener != null) {
            orientationListener.unregisterListener();
        }
    }

    public void enterPadFullScreen() {
        this.mPadFullScreen = true;
    }

    public boolean getFullScreenThroughPad(boolean z) {
        if (z) {
            z = hyy.O000000o() && this.mPadFullScreen;
        }
        if (!z) {
            this.mPadFullScreen = false;
        }
        return z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean z = true;
        if (configuration.orientation == 1) {
            z = false;
        }
        this.mFullScreen = z;
        if ((getContext() instanceof cib) && hyy.O000000o()) {
            this.mFullScreen = ((cib) getContext()).getFullScreenThroughPad(this.mFullScreen);
        }
    }

    public void exitFullScreen(String str) {
        boolean z;
        if (!TextUtils.isEmpty(str)) {
            exz exz = exz.f15941O000000o;
            z = !exz.O000000o().contains(str);
        } else {
            z = true;
        }
        if (!hyy.O000000o() || !z) {
            setRequestedOrientation(1);
            return;
        }
        this.mPadFullScreen = false;
        setRequestedOrientation(0);
    }
}

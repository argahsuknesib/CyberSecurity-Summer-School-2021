package com.xiaomi.smarthome.framework.plugin.rn;

import _m_j.fwz;
import _m_j.fxm;
import _m_j.gdt;
import _m_j.gdv;
import _m_j.gku;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;

@SuppressLint({"Registered"})
public class LoadingBaseActivity extends BaseActivity {
    private static volatile View O0000O0o = null;
    private static volatile boolean O0000OOo = true;
    private static volatile boolean O0000Oo0;

    /* renamed from: O000000o  reason: collision with root package name */
    protected FrameLayout f8119O000000o;
    protected View O00000Oo;
    protected SimpleDraweeView O00000o;
    protected AnimationDrawable O00000o0;
    protected DeviceStat O00000oO;
    protected int O00000oo = 1;

    public void onCreate(Bundle bundle) {
        ((gdt) gdv.f17570O000000o.getServiceInterface()).O000000o();
        super.onCreate(bundle);
        setContentView((int) R.layout.plugin_rn_activity);
        getWindow().setSoftInputMode(32);
        fxm.O000000o().O000000o(this);
        this.f8119O000000o = (FrameLayout) findViewById(R.id.fl_root);
        findViewById(R.id.title_bar).setBackground(null);
        this.O00000Oo = findViewById(R.id.ll_loading);
        this.O00000o = (SimpleDraweeView) findViewById(R.id.icon);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.LoadingBaseActivity.AnonymousClass1 */

            public final void onClick(View view) {
                LoadingBaseActivity.super.onBackPressed();
            }
        });
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.LoadingBaseActivity.AnonymousClass2 */

            public final void onClick(View view) {
            }
        });
        this.O00000oO = fwz.O000000o().O00000Oo().O0000o00;
        if (this.O00000oO == null) {
            this.O00000oO = (DeviceStat) getIntent().getParcelableExtra("extra_devicestat");
        }
        this.O00000oo = getIntent().getIntExtra("package_msgType", 1);
        DeviceStat deviceStat = this.O00000oO;
        if (deviceStat != null) {
            if (TextUtils.equals(deviceStat.model, "miot.clock.mijia")) {
                String str = this.O00000oO.deviceIconReal;
                if (!TextUtils.isEmpty(str)) {
                    this.O00000o.setImageURI(Uri.parse(str));
                }
            } else {
                DeviceFactory.O00000Oo(this.O00000oO.model, this.O00000o);
            }
            XmPluginHostApi instance = XmPluginHostApi.instance();
            instance.log("LoadingBaseActivity.onCreate", " did:" + this.O00000oO.did + " PinCode:" + this.O00000oO.isSetPinCode + " class:" + getClass().getSimpleName());
        }
    }

    public void setContentView(int i) {
        if (i == R.layout.plugin_rn_activity) {
            setContentView(O000000o((Context) this));
        } else {
            super.setContentView(i);
        }
    }

    private static synchronized View O000000o(Context context) {
        synchronized (LoadingBaseActivity.class) {
            O0000OOo = false;
            if (O0000O0o != null) {
                if (gku.O000000o(context) == O0000Oo0) {
                    View view = O0000O0o;
                    O0000O0o = null;
                    return view;
                }
            }
            View inflate = LayoutInflater.from(context).inflate((int) R.layout.plugin_rn_activity, (ViewGroup) null);
            return inflate;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        return false;
     */
    public static synchronized boolean preloadContentView() {
        synchronized (LoadingBaseActivity.class) {
            if (O0000OOo && O0000O0o == null) {
                Context appContext = CommonApplication.getAppContext();
                O0000O0o = LayoutInflater.from(appContext).inflate((int) R.layout.plugin_rn_activity, (ViewGroup) null);
                O0000Oo0 = gku.O000000o(appContext);
                O0000OOo = false;
                return true;
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        fxm.O000000o().O00000Oo();
    }
}

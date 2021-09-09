package com.xiaomi.smarthome.device.api;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import com.xiaomi.plugin.core.XmPluginPackage;

public abstract class BaseWidgetView {
    protected Context mContext;
    public DeviceStat mDeviceStat;
    protected Intent mIntent;
    protected LayoutInflater mLayoutInflater;
    protected XmPluginPackage mPluginPackage;
    protected View mView;

    public abstract View onCreateView(Intent intent);

    public abstract void onDestory();

    public abstract void onPause();

    public abstract void onRefresh();

    public abstract void onResume();

    public BaseWidgetView(Context context, LayoutInflater layoutInflater, XmPluginPackage xmPluginPackage, Intent intent, DeviceStat deviceStat) {
        this.mContext = context;
        this.mLayoutInflater = layoutInflater;
        this.mPluginPackage = xmPluginPackage;
        this.mDeviceStat = deviceStat;
        this.mIntent = intent;
    }

    public View getView() {
        if (this.mView == null) {
            this.mView = onCreateView(this.mIntent);
        }
        this.mDeviceStat = XmPluginHostApi.instance().getDeviceByDid(this.mDeviceStat.did);
        onRefresh();
        return this.mView;
    }
}

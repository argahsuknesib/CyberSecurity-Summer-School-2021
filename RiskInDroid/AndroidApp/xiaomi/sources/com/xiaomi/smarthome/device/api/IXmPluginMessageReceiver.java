package com.xiaomi.smarthome.device.api;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import com.xiaomi.plugin.core.XmPluginPackage;

public interface IXmPluginMessageReceiver {
    BaseWidgetView createWidgetView(Context context, LayoutInflater layoutInflater, XmPluginPackage xmPluginPackage, int i, Intent intent, DeviceStat deviceStat);

    boolean handleMessage(Context context, XmPluginPackage xmPluginPackage, int i, Intent intent, DeviceStat deviceStat);

    boolean handleMessage(Context context, XmPluginPackage xmPluginPackage, int i, Intent intent, DeviceStat deviceStat, MessageCallback messageCallback);
}

package com.xiaomi.idm.tap.dispatcher.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.xiaomi.idm.tap.dispatcher.utils.IDMTapLogger;
import com.xiaomi.mi_connect_service.util.PackageUtil;

public class EmptyNfcTagExecutor extends AbstractActionExecutor {
    private static final String TAG = "EmptyNfcTagExecutor";
    private Context context;

    public boolean execute() {
        Intent intent = new Intent();
        if (PackageUtil.checkPackageInstalled(this.context, "com.xiaomi.smarthome")) {
            IDMTapLogger.v(TAG, "mijia installed", new Object[0]);
        } else {
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(String.format("market://details?id=%s", "com.xiaomi.smarthome")));
            intent.addFlags(268435456);
            this.context.startActivity(intent);
        }
        return true;
    }

    public EmptyNfcTagExecutor(Context context2) {
        this.context = context2;
    }
}

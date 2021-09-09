package com.xiaomi.smarthome.frame.plugin;

import _m_j.fso;
import android.content.Intent;
import android.os.Bundle;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;

public class SendMessageCallback {
    public Object mObj;

    public void onDownInfoSuccess(String str, PluginDownloadTask pluginDownloadTask) {
    }

    public void onDownloadCancel() {
    }

    public void onDownloadFailure(PluginError pluginError) {
    }

    public void onDownloadProgress(String str, float f) {
    }

    public void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
    }

    public void onDownloadSuccess(String str) {
    }

    public void onInstallBefore(String str) {
    }

    public void onInstallFailure(PluginError pluginError) {
    }

    public void onInstallStart(String str) {
    }

    public void onInstallSuccess(String str) {
    }

    public void onLoadFailure(String str) {
    }

    public void onLoadSuccess(String str) {
    }

    public void onMessageFailure(int i, String str) {
    }

    public void onMessageHandle(boolean z) {
    }

    public void onMessageSuccess(Intent intent) {
    }

    public void onSendCancel() {
    }

    public void onSendFailure(fso fso) {
    }

    public void onSendSuccess(Bundle bundle) {
    }

    public SendMessageCallback() {
    }

    public SendMessageCallback(Object obj) {
        this.mObj = obj;
    }
}

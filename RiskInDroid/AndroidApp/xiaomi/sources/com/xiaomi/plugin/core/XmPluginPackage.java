package com.xiaomi.plugin.core;

import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import com.xiaomi.smarthome.device.api.IXmPluginMessageReceiver;
import java.util.List;

public class XmPluginPackage {
    @Deprecated
    public Drawable appIcon;
    public CharSequence appLabel;
    public AssetManager assetManager;
    public ClassLoader classLoader;
    private List<String> mModelList;
    private long mPackageId;
    private long mPluginId;
    public int miniApiVersion;
    @Deprecated
    public String model;
    public PackageInfo packageInfo;
    public String packageName;
    public String packagePath;
    public int packageVersion;
    public IXmPluginMessageReceiver xmPluginMessageReceiver;

    public XmPluginPackage(String str, String str2, ClassLoader classLoader2, AssetManager assetManager2, PackageInfo packageInfo2, String str3, IXmPluginMessageReceiver iXmPluginMessageReceiver) {
        this.packageName = str;
        this.packagePath = str2;
        this.classLoader = classLoader2;
        this.assetManager = assetManager2;
        this.packageInfo = packageInfo2;
        this.model = str3;
        this.xmPluginMessageReceiver = iXmPluginMessageReceiver;
    }

    public synchronized void setModelList(List<String> list) {
        this.mModelList = list;
    }

    public synchronized void setPluginId(long j) {
        this.mPluginId = j;
    }

    public synchronized void setPackageId(long j) {
        this.mPackageId = j;
    }

    public synchronized String getPackageName() {
        return this.packageName;
    }

    public synchronized String getPackagePath() {
        return this.packagePath;
    }

    public synchronized ClassLoader getClassLoader() {
        if (this.classLoader == null) {
            return getClass().getClassLoader();
        }
        return this.classLoader;
    }

    public synchronized AssetManager getAssetManager() {
        return this.assetManager;
    }

    public synchronized PackageInfo getRawPackageInfo() {
        return this.packageInfo;
    }

    public synchronized List<String> getModelList() {
        return this.mModelList;
    }

    public synchronized IXmPluginMessageReceiver getMessageReceiver() {
        return this.xmPluginMessageReceiver;
    }

    @Deprecated
    public synchronized Drawable getAppIcon() {
        return this.appIcon;
    }

    public synchronized CharSequence getAppLabel() {
        return this.appLabel;
    }

    public synchronized int getMinApiLevel() {
        return this.miniApiVersion;
    }

    public synchronized int getVersionCode() {
        return this.packageVersion;
    }

    public synchronized long getPluginId() {
        return this.mPluginId;
    }

    public synchronized long getPackageId() {
        return this.mPackageId;
    }
}

package com.xiaomi.smarthome.framework.plugin.rn.nativemodule;

import _m_j.fwz;
import _m_j.gba;
import _m_j.hxh;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.api.DeviceStat;
import java.io.File;

public abstract class MIOTBaseJavaModule extends ReactContextBaseJavaModule {
    public MIOTBaseJavaModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public DeviceStat getDevice() {
        return fwz.O000000o().O00000Oo().O0000o00;
    }

    public PluginPackageInfo getPluginRecord() {
        return fwz.O000000o().O00000Oo().O0000OoO;
    }

    public PluginDeviceInfo getPluginInfo() {
        return fwz.O000000o().O00000Oo().O0000Ooo;
    }

    public String getStatDevloperLabel() {
        PluginPackageInfo pluginRecord = getPluginRecord();
        if (pluginRecord == null) {
            return null;
        }
        return hxh.O000000o(pluginRecord.O000000o(), pluginRecord.O00000Oo());
    }

    public SharedPreferences getSharedPreferences() {
        File pluginDir = getPluginDir(getReactApplicationContext(), getPluginRecord());
        pluginDir.mkdirs();
        return gba.O000000o(new File(pluginDir, "config.xml"));
    }

    public SharedPreferences getSharedPreferencesV2() {
        File pluginSpFileDir = getPluginSpFileDir(getReactApplicationContext(), getPluginRecord(), getDevice());
        if (!pluginSpFileDir.exists()) {
            pluginSpFileDir.mkdirs();
        }
        return gba.O000000o(new File(pluginSpFileDir, "config.xml"));
    }

    public File getFilesPath() {
        DeviceStat device = getDevice();
        String str = (device == null || TextUtils.isEmpty(device.did)) ? "0" : device.did;
        File file = new File(getPluginDir(getReactApplicationContext(), getPluginRecord()).getAbsolutePath() + File.separator + str, "files");
        file.mkdirs();
        return file;
    }

    public File getTempFilesPath() {
        DeviceStat device = getDevice();
        String str = (device == null || TextUtils.isEmpty(device.did)) ? "0" : device.did;
        File file = new File(getPluginDir(getReactApplicationContext(), getPluginRecord()).getAbsolutePath() + File.separator + str, "plugin_temp_files");
        file.mkdirs();
        return file;
    }

    public File getDatabasePath() {
        File file = new File(getPluginDir(getReactApplicationContext(), getPluginRecord()).getAbsolutePath(), "databases");
        file.mkdirs();
        return file;
    }

    public static File getPluginDir(Context context, PluginPackageInfo pluginPackageInfo) {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append(getAppFilesDir(context));
        sb.append(File.separator);
        sb.append("plugin");
        sb.append(File.separator);
        sb.append("install");
        sb.append(File.separator);
        sb.append("rn");
        sb.append(File.separator);
        if (pluginPackageInfo == null) {
            obj = "0";
        } else {
            obj = Long.valueOf(pluginPackageInfo.O000000o());
        }
        sb.append(obj);
        sb.append(File.separator);
        sb.append("data");
        return new File(sb.toString());
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    public static File getPluginSpFileDir(Context context, PluginPackageInfo pluginPackageInfo, DeviceStat deviceStat) {
        Object obj = "0";
        String str = (deviceStat == null || TextUtils.isEmpty(deviceStat.did)) ? obj : deviceStat.did;
        StringBuilder sb = new StringBuilder();
        sb.append(getAppFilesDir(context));
        sb.append(File.separator);
        sb.append("plugin");
        sb.append(File.separator);
        sb.append("install");
        sb.append(File.separator);
        sb.append("rn");
        sb.append(File.separator);
        Object obj2 = obj;
        if (pluginPackageInfo != null) {
            obj2 = Long.valueOf(pluginPackageInfo.O000000o());
        }
        sb.append(obj2);
        sb.append(File.separator);
        sb.append("data");
        sb.append(File.separator);
        sb.append(str);
        sb.append(File.separator);
        sb.append("data");
        return new File(sb.toString());
    }

    public static File getPluginFilesPath(File file, DeviceStat deviceStat) {
        String str = (deviceStat == null || TextUtils.isEmpty(deviceStat.did)) ? "0" : deviceStat.did;
        return new File(file.getAbsolutePath() + File.separator + str, "files");
    }

    public static File getPluginDatabasePath(File file, DeviceStat deviceStat) {
        String str = (deviceStat == null || TextUtils.isEmpty(deviceStat.did)) ? "0" : deviceStat.did;
        return new File(file.getAbsolutePath() + File.separator + str, "databases");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        r0 = java.io.File.separator + "data" + java.io.File.separator + "data" + java.io.File.separator + r4.getPackageName() + java.io.File.separator + "files";
        new java.io.File(r0).mkdirs();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0042, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0043, code lost:
        r4 = r4.getDir("files", 0);
        r4.mkdirs();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004f, code lost:
        return r4.getPath();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000d */
    private static String getAppFilesDir(Context context) {
        return context.getFilesDir().getPath();
    }
}

package _m_j;

import _m_j.fkg;
import _m_j.fki;
import _m_j.hsi;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.DownloadRnSdkResult;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.core.server.internal.plugin.DynamicFeatureManager;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fkl {
    public static final String O0000OoO = (File.separator + "plugin" + File.separator + "rnsdk");
    private static final Comparator<? super String> O0000Ooo = $$Lambda$fkl$vHnYmW3YUZbd11vih45Xbq9NJU.INSTANCE;
    private static final Object O0000o0 = new Object();
    private static volatile fkl O0000o00;
    private static final String O0000ooO;

    /* renamed from: O000000o  reason: collision with root package name */
    public final fkg f16519O000000o;
    public ArrayList<fkd> O00000Oo = new ArrayList<>();
    public SharedPreferences O00000o;
    public Context O00000o0 = CommonApplication.getAppContext();
    Handler O00000oO;
    gpq O00000oo;
    public O0000o00 O0000O0o;
    public Map<String, PluginPackageInfo> O0000OOo = new ConcurrentHashMap();
    public Map<Long, O0000Oo> O0000Oo = new ConcurrentHashMap();
    public Map<String, PluginPackageInfo> O0000Oo0 = new ConcurrentHashMap();
    private String O0000o;
    private byte O0000o0O = 0;
    private String O0000o0o;
    private String O0000oO;
    private String O0000oO0;
    private String O0000oOO;
    private String O0000oOo;
    private String O0000oo;
    private String O0000oo0;
    private String O0000ooo = null;

    public static abstract class O00000Oo {
        public abstract void O000000o();

        public abstract void O000000o(String str);

        public abstract void O00000Oo();

        public abstract void O00000Oo(String str);
    }

    public interface O0000OOo {
        void O000000o(String str);

        void O00000Oo(String str);
    }

    public static class O0000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        String f16536O000000o;
        public long O00000Oo;
        long O00000o = 0;
        public long O00000o0 = 0;
        long O00000oO;
        long O00000oo;
        public int O0000O0o = 0;
        List<Object> O0000OOo = new CopyOnWriteArrayList();
        public volatile O0000Oo0 O0000Oo;
        long O0000Oo0 = 0;
    }

    public interface O0000Oo0 {
        void O000000o(DownloadRnSdkResult downloadRnSdkResult);

        void O00000Oo(DownloadRnSdkResult downloadRnSdkResult);
    }

    public static final boolean O00000o(long j) {
        return j >= 1000000;
    }

    public static final boolean O00000o0(long j) {
        return j >= 1000000;
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(O0000OoO);
        sb.append("_config");
        O0000ooO = sb.toString();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hhc.O000000o(java.lang.Object, int):int
     arg types: [java.lang.String, int]
     candidates:
      _m_j.hhc.O000000o(java.lang.Object, double):double
      _m_j.hhc.O000000o(java.lang.Object, int):int */
    /* access modifiers changed from: private */
    public static /* synthetic */ int O000000o(String str, String str2) {
        return hhc.O000000o((Object) str.replaceAll("\\D+", ""), 0) - hhc.O000000o((Object) str2.replaceAll("\\D+", ""), 0);
    }

    public class O0000o00 extends Handler {
        O0000o00(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            Message message2 = message;
            int i = message2.what;
            if (i != 4) {
                if (i != 18) {
                    switch (i) {
                        case 24:
                            if (message2.obj instanceof O0000Oo) {
                                fkl.this.O00000Oo((O0000Oo) message2.obj);
                                return;
                            }
                            return;
                        case 25:
                            if (message2.obj instanceof Map) {
                                fkl.O000000o((Map) message2.obj);
                                return;
                            }
                            return;
                        case 26:
                            if (message2.obj instanceof Object[]) {
                                Object[] objArr = (Object[]) message2.obj;
                                if ((objArr[0] instanceof String) && (objArr[1] instanceof O0000OOo)) {
                                    fkl fkl = fkl.this;
                                    String str = (String) objArr[0];
                                    O0000OOo o0000OOo = (O0000OOo) objArr[1];
                                    try {
                                        PluginPackageInfo pluginPackageInfo = fkl.O0000Oo0.get(str);
                                        if (pluginPackageInfo != null) {
                                            gsc.O00000o(pluginPackageInfo.O00000o());
                                        }
                                        PluginPackageInfo pluginPackageInfo2 = fkl.O0000OOo.get(str);
                                        if (pluginPackageInfo2 != null) {
                                            gsc.O00000o(pluginPackageInfo2.O00000o());
                                        }
                                        o0000OOo.O000000o(str);
                                        return;
                                    } catch (Exception unused) {
                                        o0000OOo.O00000Oo(str);
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        default:
                            return;
                    }
                } else if (message2.obj instanceof O0000O0o) {
                    O00000o0 o00000o0 = (O00000o0) ((O0000O0o) message2.obj).f16535O000000o;
                    fkl fkl2 = fkl.this;
                    O00000o O00000o = fkl2.O00000o();
                    if (O00000o.O00000oO) {
                        fkl.O00000oO();
                        if (o00000o0 != null) {
                            o00000o0.O000000o(O00000o.O00000oo);
                            return;
                        }
                        return;
                    }
                    long j = O00000o.O00000Oo;
                    long j2 = O00000o.O00000o0;
                    String str2 = O00000o.O00000o;
                    boolean equalsIgnoreCase = "rn".equalsIgnoreCase(str2);
                    String O000000o2 = fkl2.O000000o(j, j2, str2);
                    fkw.O00000Oo(O00000o.f16534O000000o, O000000o2);
                    String str3 = "rn";
                    PluginPackageInfo O000000o3 = fky.O000000o(fkl2.O00000o0, j, j2, str2, O000000o2);
                    if (O000000o3 == null) {
                        fkl.O00000oO();
                        if (o00000o0 != null) {
                            o00000o0.O000000o("未获取到插件包配置信息");
                            return;
                        }
                        return;
                    }
                    String developerInfo = PluginDeviceManager.instance.getDeveloperInfo(O000000o3.O0000Oo0());
                    if (!equalsIgnoreCase && developerInfo == null) {
                        fkl.O00000oO();
                        if (o00000o0 != null) {
                            o00000o0.O000000o("开发者不存在(id:" + O000000o3.O0000Oo0() + ")");
                        }
                    } else if (!fky.O000000o(fkl2.O00000o0, O000000o3, developerInfo)) {
                        fkl.O00000oO();
                        if (o00000o0 != null) {
                            o00000o0.O000000o("插件包签名错误");
                        }
                    } else if (!fky.O000000o(O000000o3)) {
                        fkl.O00000oO();
                        if (o00000o0 != null) {
                            o00000o0.O000000o("插件包MinApiLevel错误");
                        }
                    } else {
                        boolean O00000Oo = fkw.O00000Oo(O00000o.f16534O000000o, O000000o2);
                        fkl.O00000oO();
                        if (O00000Oo) {
                            fkl2.O00000Oo(O000000o3);
                            if (o00000o0 != null) {
                                o00000o0.O000000o();
                            }
                            if (gfr.O0000o0o) {
                                String O00000o2 = O000000o3.O00000o();
                                long O000000o4 = O000000o3.O000000o();
                                long O00000Oo2 = O000000o3.O00000Oo();
                                String O0000O0o = O000000o3.O0000O0o();
                                long O000000o5 = O000000o3.O000000o();
                                long O00000Oo3 = O000000o3.O00000Oo();
                                String str4 = str3;
                                String O00000Oo4 = fkl2.O00000Oo(O000000o5, O00000Oo3, O0000O0o);
                                if (O0000O0o.equalsIgnoreCase("mpk")) {
                                    if (!fkw.O00000Oo(O00000o2, O00000Oo4)) {
                                        fkw.O00000Oo(O00000Oo4);
                                        if (o00000o0 != null) {
                                            o00000o0.O00000Oo("");
                                            return;
                                        }
                                        return;
                                    }
                                } else if (str4.equalsIgnoreCase(O0000O0o)) {
                                    fkl fkl3 = fkl2;
                                    long j3 = O000000o4;
                                    long j4 = O00000Oo2;
                                    fkl3.O000000o(j3, j4, O00000o2, fkl3.O00000Oo(j3, j4, "rn"));
                                }
                                Object obj = "mpk";
                                String str5 = O0000O0o;
                                String str6 = O00000Oo4;
                                PluginPackageInfo O000000o6 = fky.O000000o(fkl2.O00000o0, O000000o4, O00000Oo2, str5, str6);
                                if (O000000o6 == null || PluginDeviceManager.instance.getDeveloperInfo(O000000o6.O0000Oo0()) == null) {
                                    fkw.O00000Oo(str6);
                                    if (o00000o0 != null) {
                                        o00000o0.O00000Oo("");
                                    }
                                } else if (!fky.O000000o(O000000o6)) {
                                    fkw.O00000Oo(str6);
                                    if (o00000o0 != null) {
                                        o00000o0.O00000Oo("");
                                    }
                                } else {
                                    if (str5.equals(obj)) {
                                        fkm.O000000o();
                                        fkm.O000000o(fkl2.O00000o0, O000000o4, O00000Oo2, str6);
                                    }
                                    fkl2.O000000o(O000000o6);
                                    if (o00000o0 != null) {
                                        o00000o0.O00000Oo();
                                    }
                                }
                            } else if (o00000o0 != null) {
                                o00000o0.O00000Oo("");
                            }
                        } else if (o00000o0 != null) {
                            o00000o0.O000000o("插件包拷贝失败");
                        }
                    }
                }
            } else if (message2.obj instanceof Pair) {
                Pair pair = (Pair) message2.obj;
                Object obj2 = pair.first;
                Object obj3 = pair.second;
            }
        }
    }

    private fkl() {
        Context context = this.O00000o0;
        this.f16519O000000o = new fkg(context, O00000oo() + File.separator + "plugin" + File.separator + "downloading");
    }

    public static fkl O000000o() {
        if (O0000o00 == null) {
            synchronized (O0000o0) {
                if (O0000o00 == null) {
                    O0000o00 = new fkl();
                }
            }
        }
        return O0000o00;
    }

    public final void O00000Oo() {
        byte b;
        ArrayList<fkd> arrayList;
        synchronized (O0000o0) {
            b = this.O0000o0O;
            if (this.O0000o0O == 0) {
                this.O0000o0O = (byte) (this.O0000o0O + 1);
            }
        }
        if (b == 0) {
            O00000o("start init");
            this.O0000o0o = O00000oo() + File.separator + "plugin" + File.separator + "download";
            this.O0000o = O00000oo() + File.separator + "plugin" + File.separator + "tmp";
            this.O0000oO0 = O00000oo() + File.separator + "plugin" + File.separator + "install" + File.separator + "mpk";
            this.O0000oO = O00000oo() + File.separator + "plugin" + File.separator + "install" + File.separator + "rn";
            StringBuilder sb = new StringBuilder();
            sb.append(this.O0000oO);
            sb.append("_temp");
            this.O0000oOO = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(O00000oo());
            sb2.append(O0000OoO);
            this.O0000oOo = sb2.toString();
            this.O0000oo0 = O00000oo() + O0000ooO;
            Context context = this.O00000o0;
            O00000oo();
            hsi.O000000o(context);
            this.O0000oo = O00000oo() + File.separator + "plugin" + File.separator + "install" + File.separator + "lib";
            this.O00000oO = new Handler(Looper.getMainLooper());
            this.O00000o = this.O00000o0.getSharedPreferences("plugin_record_list.parcel2", 0);
            this.O00000oo = new gpq("PluginWorker");
            this.O00000oo.start();
            this.O0000O0o = new O0000o00(this.O00000oo.getLooper());
            O0000Oo0();
            O0000OoO();
            synchronized (O0000o0) {
                this.O0000o0O = (byte) (this.O0000o0O + 1);
                arrayList = this.O00000Oo;
                this.O00000Oo = null;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).onPackageReady();
            }
        }
    }

    public final boolean O00000o0() {
        return this.O0000o0O > 0;
    }

    static class O000000o {
        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }
    }

    abstract class O00000o0 extends O000000o {
        /* access modifiers changed from: package-private */
        public abstract void O000000o();

        /* access modifiers changed from: package-private */
        public abstract void O000000o(String str);

        /* access modifiers changed from: package-private */
        public abstract void O00000Oo();

        /* access modifiers changed from: package-private */
        public abstract void O00000Oo(String str);

        private O00000o0() {
            super((byte) 0);
        }

        /* synthetic */ O00000o0(fkl fkl, byte b) {
            this();
        }
    }

    public static class O0000O0o {

        /* renamed from: O000000o  reason: collision with root package name */
        public O000000o f16535O000000o;

        private O0000O0o() {
        }

        public /* synthetic */ O0000O0o(byte b) {
            this();
        }
    }

    private String O00000oo() {
        if (TextUtils.isEmpty(this.O0000ooo)) {
            this.O0000ooo = fkw.O000000o(this.O00000o0);
        }
        return this.O0000ooo;
    }

    public final void O000000o(PluginPackageInfo pluginPackageInfo) {
        List<String> O0000OoO2;
        if (pluginPackageInfo != null && (O0000OoO2 = pluginPackageInfo.O0000OoO()) != null) {
            for (String put : O0000OoO2) {
                this.O0000OOo.put(put, pluginPackageInfo);
            }
        }
    }

    private void O0000O0o() {
        this.O0000OOo.clear();
    }

    public final void O00000Oo(PluginPackageInfo pluginPackageInfo) {
        List<String> O0000OoO2;
        if (pluginPackageInfo != null && (O0000OoO2 = pluginPackageInfo.O0000OoO()) != null) {
            for (String put : O0000OoO2) {
                this.O0000Oo0.put(put, pluginPackageInfo);
            }
        }
    }

    private void O0000OOo() {
        this.O0000Oo0.clear();
    }

    private void O0000Oo0() {
        O0000O0o();
        O0000OOo();
        PluginPackageInfo O000000o2 = fky.O000000o("app", "MessageReceiver", Arrays.asList(DeviceConstant.supportNativePlugin()));
        O00000Oo(O000000o2);
        O000000o(O000000o2);
        O000000o(this.O0000oO0, "mpk", ".apk");
        O000000o(this.O0000oO, "rn", "");
        O0000Oo();
        fkw.O00000o0(this.O0000o);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01b7, code lost:
        if ("rn".equalsIgnoreCase(r24) == false) goto L_0x01bc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00dc  */
    private void O000000o(String str, String str2, String str3) {
        String[] list;
        long j;
        int i;
        int length;
        long j2;
        long j3;
        int i2;
        String[] list2;
        File file = new File(str);
        if (file.isDirectory() && (list = file.list()) != null) {
            int length2 = list.length;
            int i3 = 0;
            int i4 = 0;
            while (i4 < length2) {
                String str4 = list[i4];
                try {
                    j = Long.parseLong(str4);
                } catch (Exception unused) {
                    O00000o("scanInstalledPackageInternal pluginId Exception parse:".concat(String.valueOf(str4)));
                    j = 0;
                }
                String str5 = file + File.separator + str4;
                if (j > 0) {
                    String[] list3 = new File(str5).list();
                    if (list3 != null && (length = list3.length) > 0) {
                        Arrays.sort(list3, O0000Ooo);
                        int i5 = length - 1;
                        while (true) {
                            if (i5 < 0) {
                                break;
                            }
                            String str6 = list3[i5];
                            String str7 = str5 + File.separator + str6;
                            if (str6.endsWith(str3)) {
                                try {
                                    i = i4;
                                    j2 = Long.parseLong(str6.substring(i3, str6.length() - str3.length()));
                                } catch (Exception unused2) {
                                    O00000o("scanInstalledPackageInternal packageId Exception parse:".concat(String.valueOf((Object) null)));
                                }
                                String O000000o2 = hsi.O000000o(this.O00000o0, j, j2);
                                if (j2 > 0) {
                                    O00000o(" scanInstalledPackageInternal packageId:".concat(String.valueOf(str7)));
                                } else {
                                    File file2 = new File(O000000o2);
                                    if (!file2.exists() || !file2.isDirectory() || (list2 = file2.list()) == null || list2.length <= 0 || fkm.O000000o(this.O00000o0, j, j2) != null) {
                                        String str8 = str7;
                                        long j4 = j;
                                        j3 = j;
                                        long j5 = j2;
                                        i2 = i5;
                                        PluginPackageInfo O000000o3 = fky.O000000o(this.O00000o0, j4, j5, str2, str8);
                                        if (O000000o3 == null) {
                                            O00000o(" scanInstalledPackageInternal createPluginPackageInfo  deleteFile:".concat(String.valueOf(str8)));
                                        } else {
                                            List<String> O0000OoO2 = O000000o3.O0000OoO();
                                            if (O0000OoO2 == null || O0000OoO2.size() == 0) {
                                                String str9 = str8;
                                                fkw.O00000Oo(str9);
                                                O00000o(" scanDownloadedPackageInternal validatePackage deleteFile:".concat(String.valueOf(str9)));
                                            } else if (!fky.O000000o(O000000o3)) {
                                                fkw.O00000Oo(str8);
                                                O00000o(" scanInstalledPackageInternal validatePackage  deleteFile:".concat(String.valueOf(str8)));
                                            } else {
                                                O000000o(O000000o3);
                                                O00000o("scanInstalledPackageInternal first modellist - " + O000000o3.O0000OoO() + ", pluginPath - " + str8);
                                                for (int i6 = 0; i6 < i2; i6++) {
                                                    String str10 = str5 + File.separator + list3[i6];
                                                    if (!new File(fky.O00000Oo(str10), "project.json").exists()) {
                                                    }
                                                    if (fky.O000000o(this.O00000o0, -1, -1, str2, str10) != null) {
                                                        fkw.O00000Oo(str10);
                                                        O00000o("scanInstalledPackageInternal little delete pluginPath - ".concat(String.valueOf(str10)));
                                                    }
                                                    O00000o("scanInstalledPackageInternal other file - ".concat(String.valueOf(str10)));
                                                }
                                            }
                                        }
                                        i5 = i2 - 1;
                                        i4 = i;
                                        j = j3;
                                        i3 = 0;
                                    } else {
                                        O00000o("scanInstalledPackageInternal do not find abi path pluginId:" + j + " packageId:" + j2);
                                        fkw.O00000Oo(str7);
                                    }
                                }
                                j3 = j;
                                i2 = i5;
                                i5 = i2 - 1;
                                i4 = i;
                                j = j3;
                                i3 = 0;
                            }
                            i = i4;
                            j2 = 0;
                            String O000000o22 = hsi.O000000o(this.O00000o0, j, j2);
                            if (j2 > 0) {
                            }
                            j3 = j;
                            i2 = i5;
                            i5 = i2 - 1;
                            i4 = i;
                            j = j3;
                            i3 = 0;
                        }
                    } else {
                        i = i4;
                        fkw.O00000Oo(str5);
                        O00000o(" scanInstalledPackageInternal plugin.size=0 packagePaths:".concat(String.valueOf(str5)));
                        i4 = i + 1;
                        i3 = 0;
                    }
                } else {
                    fkw.O00000Oo(str5);
                    O00000o(" scanInstalledPackageInternal pluginIdStr:".concat(String.valueOf(str5)));
                }
                i = i4;
                i4 = i + 1;
                i3 = 0;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x019f, code lost:
        if (r3.equalsIgnoreCase(r11) == false) goto L_0x01a4;
     */
    private void O0000Oo() {
        String[] list;
        long j;
        int length;
        String str;
        long j2;
        int i;
        String str2;
        String str3;
        File file = new File(this.O0000o0o);
        if (file.isDirectory() && (list = file.list()) != null) {
            Arrays.sort(list, O0000Ooo);
            int length2 = list.length;
            int i2 = 0;
            int i3 = 0;
            while (i3 < length2) {
                String str4 = list[i3];
                long j3 = 0;
                try {
                    j = Long.parseLong(str4);
                } catch (Exception unused) {
                    O00000o(" scanDownloadedPackageInternal pluginId Exception parse:".concat(String.valueOf(str4)));
                    j = 0;
                }
                String str5 = this.O0000o0o + File.separator + str4;
                if (j > 0 && j != 103) {
                    String[] list2 = new File(str5).list();
                    if (list2 != null && (length = list2.length) > 0) {
                        Arrays.sort(list2, O0000Ooo);
                        int i4 = length - 1;
                        while (true) {
                            if (i4 < 0) {
                                break;
                            }
                            String str6 = list2[i4];
                            String str7 = str5 + File.separator + str6;
                            String str8 = "";
                            if (str6.endsWith(".mpk")) {
                                str8 = str6.substring(i2, str6.length() - 4);
                                str3 = "mpk";
                            } else if (str6.endsWith(".h5")) {
                                str8 = str6.substring(i2, str6.length() - 3);
                                str3 = "h5";
                            } else if (str6.endsWith(".apk")) {
                                str8 = str6.substring(i2, str6.length() - 4);
                                str3 = "apk";
                            } else {
                                if (str6.endsWith(".rn")) {
                                    str8 = str6.substring(i2, str6.length() - 3);
                                    str = "rn";
                                } else {
                                    str = str8;
                                }
                                j2 = Long.parseLong(str8);
                                if (j2 > j3 || TextUtils.isEmpty(str)) {
                                    i = i4;
                                    O00000o(" scanDownloadedPackageInternal packageId:".concat(String.valueOf(str7)));
                                } else {
                                    String str9 = "rn";
                                    String str10 = str;
                                    long j4 = j2;
                                    String str11 = str7;
                                    i = i4;
                                    PluginPackageInfo O000000o2 = fky.O000000o(this.O00000o0, j, j4, str10, str11);
                                    if (O000000o2 == null) {
                                        O00000o(" scanDownloadedPackageInternal pluginPackageInfo:".concat(String.valueOf(str11)));
                                    } else {
                                        List<String> O0000OoO2 = O000000o2.O0000OoO();
                                        if (O0000OoO2 == null || O0000OoO2.size() == 0) {
                                            String str12 = str11;
                                            fkw.O00000Oo(str12);
                                            O00000o(" scanDownloadedPackageInternal validatePackage deleteFile:".concat(String.valueOf(str12)));
                                        } else if (!fky.O000000o(O000000o2)) {
                                            fkw.O00000Oo(str11);
                                            O00000o(" scanDownloadedPackageInternal validatePackage deleteFile:".concat(String.valueOf(str11)));
                                        } else {
                                            O00000Oo(O000000o2);
                                            O00000o("scanDownloadedPackageInternal first modellist - " + O0000OoO2 + ", pluginPath - " + str11);
                                            int i5 = 0;
                                            while (i5 < i) {
                                                String str13 = str5 + File.separator + list2[i5];
                                                if (!new File(fky.O00000Oo(str13), "project.json").exists()) {
                                                    str2 = str10;
                                                } else {
                                                    str2 = str10;
                                                }
                                                if (fky.O000000o(this.O00000o0, -1, -1, str2, str13) != null) {
                                                    fkw.O00000Oo(str13);
                                                    O00000o("scanDownloadedPackageInternal little delete pluginPath - ".concat(String.valueOf(str13)));
                                                    i5++;
                                                    str10 = str2;
                                                }
                                                O00000o("scanDownloadedPackageInternal other file - ".concat(String.valueOf(str13)));
                                                i5++;
                                                str10 = str2;
                                            }
                                        }
                                    }
                                }
                                i4 = i - 1;
                                i2 = 0;
                                j3 = 0;
                            }
                            str = str3;
                            try {
                                j2 = Long.parseLong(str8);
                            } catch (Exception unused2) {
                                O00000o(" scanDownloadedPackageInternal packageId Exception pase:".concat(String.valueOf(str8)));
                                j2 = j3;
                            }
                            if (j2 > j3) {
                            }
                            i = i4;
                            O00000o(" scanDownloadedPackageInternal packageId:".concat(String.valueOf(str7)));
                            i4 = i - 1;
                            i2 = 0;
                            j3 = 0;
                        }
                    } else {
                        fkw.O00000Oo(str5);
                        O00000o(" scanDownloadedPackageInternal plugins.size=0 pluginPath:".concat(String.valueOf(str5)));
                    }
                } else {
                    fkw.O00000Oo(str5);
                    O00000o(" scanDownloadedPackageInternal pluginIdStr:".concat(String.valueOf(str4)));
                }
                i3++;
                i2 = 0;
            }
        }
    }

    private void O0000OoO() {
        PluginPackageInfo O00000Oo2;
        List<String> O00000Oo3 = fkc.O000000o().O00000Oo();
        if (O00000Oo3.size() > 0) {
            for (String next : O00000Oo3) {
                PluginPackageInfo O00000o02 = O00000o0(next);
                if (!(O00000o02 == null || (O00000Oo2 = fkc.O000000o().O00000Oo(next)) == null || O00000Oo2.O00000oO() <= O00000o02.O00000oO())) {
                    O00000o("checkToUpdateAllDownloadInnerPlugin innerPackageInfo.getVersion=" + O00000Oo2.O00000oO() + "   installPackageInfo.getVersion=" + O00000o02.O00000oO());
                    O000000o(next, (fkh) null);
                }
            }
        }
    }

    public final void O000000o(String str, fkh fkh) {
        String str2 = str;
        fkh fkh2 = fkh;
        O00000o("downloadInnerPluginInternal 内置插件进行模拟下载过程...".concat(String.valueOf(str)));
        PluginPackageInfo O00000Oo2 = fkc.O000000o().O00000Oo(str2);
        if (O00000Oo2 == null) {
            O00000o("downloadInnerPluginInternal inner packageInfo is null, model is ".concat(String.valueOf(str)));
            if (fkh2 != null) {
                fkh2.O000000o(str2, -663);
                fky.O00000o0("innerplugin download error(-663),getInnerPluginPackageInfo=null:".concat(String.valueOf(str)));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        fki fki = new fki(str2);
        hashMap.put(str2, fki);
        if (fkh2 != null) {
            fkh2.O000000o(O000000o((HashMap<String, fki>) hashMap));
        }
        fki.O00000o((long) O00000Oo2.O0000OOo());
        fki.O000000o(O00000Oo2.O000000o());
        fki.O00000Oo(O00000Oo2.O00000Oo());
        fki.O000000o(O00000Oo2.O0000O0o());
        fki.O00000Oo("");
        fki.O00000o0("");
        fki.O00000o0(1132240);
        fki.O00000o0 = O00000Oo2.O00000oO();
        fki.O00000o = "";
        boolean z = false;
        fki.O000000o(false);
        if (fkh2 != null) {
            fkh2.O00000Oo(O000000o((HashMap<String, fki>) hashMap));
        }
        String str3 = O00000oo() + File.separator + "plugin" + File.separator + "downloading" + File.separator + O00000Oo2.O00000Oo() + ".raw";
        if (!fkw.O000000o(this.O00000o0, O00000Oo2.O00000o(), str3)) {
            O00000o("downloadInnerPluginInternal 内置插件压缩文件 从 assert 目录拷贝到下载目录出现错误...".concat(String.valueOf(str3)));
            if (fkh2 != null) {
                fkh2.O000000o(str2, -663);
                fky.O00000o0("innerplugin download error(-663),copyAsserts failed:".concat(String.valueOf(str)));
                return;
            }
            return;
        }
        String O000000o2 = O000000o(O00000Oo2.O000000o(), O00000Oo2.O00000Oo(), O00000Oo2.O0000O0o());
        fkw.O00000Oo(O000000o2);
        if (fla.O000000o(str3, O000000o2, null) && fkw.O00000oO(new File(O000000o2, "conf.json").getAbsolutePath()).exists()) {
            z = true;
        }
        fkw.O00000Oo(str3);
        if (!z) {
            O00000o("downloadInnerPluginInternal 内置插件进行解压出现错误...".concat(String.valueOf(O000000o2)));
            if (fkh2 != null) {
                fkh2.O000000o(str2, -663);
                fky.O00000o0("innerplugin download error(-663),syncUnzip failed:".concat(String.valueOf(str)));
                return;
            }
            return;
        }
        new fkk(new File(O000000o2)).O000000o(Collections.singletonList(str)).O000000o(O00000Oo2.O00000oO()).O00000Oo();
        O00000Oo(fky.O000000o(this.O00000o0, O00000Oo2.O000000o(), O00000Oo2.O00000Oo(), O00000Oo2.O0000O0o(), O000000o2));
        if (fkh2 != null) {
            fkh2.O000000o(str2);
        }
    }

    public static ArrayList<PluginDownloadTask> O000000o(HashMap<String, fki> hashMap) {
        ArrayList<PluginDownloadTask> arrayList = new ArrayList<>();
        for (Map.Entry<String, fki> value : hashMap.entrySet()) {
            arrayList.add(((fki) value.getValue()).O0000OoO());
        }
        return arrayList;
    }

    class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        String f16534O000000o;
        long O00000Oo;
        String O00000o;
        long O00000o0;
        boolean O00000oO;
        String O00000oo;

        O00000o() {
        }
    }

    public final String O000000o(long j, long j2, String str) {
        return this.O0000o0o + File.separator + j + File.separator + j2 + "." + str.toLowerCase();
    }

    public final String O000000o(long j, long j2) {
        return this.O0000oOO + File.separator + j + File.separator + j2;
    }

    public final String O00000Oo(long j, long j2, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.equalsIgnoreCase("mpk")) {
            return this.O0000oO0 + File.separator + j + File.separator + j2 + ".apk";
        } else if (!str.equalsIgnoreCase("rn")) {
            return "";
        } else {
            return this.O0000oO + File.separator + j + File.separator + j2;
        }
    }

    public final JSONObject O000000o(String str) {
        long j;
        String str2;
        PluginPackageInfo pluginPackageInfo = this.O0000OOo.get(str);
        PluginPackageInfo pluginPackageInfo2 = this.O0000Oo0.get(str);
        if (pluginPackageInfo != null) {
            j = pluginPackageInfo.O00000Oo();
            str2 = pluginPackageInfo.O0000O0o();
        } else if (pluginPackageInfo2 != null) {
            long O00000Oo2 = pluginPackageInfo2.O00000Oo();
            str2 = pluginPackageInfo2.O0000O0o();
            j = O00000Oo2;
        } else {
            j = 0;
            str2 = "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("model", str);
            jSONObject.put("package_id", j);
            jSONObject.put("type", str2);
        } catch (JSONException e) {
            O00000o(Log.getStackTraceString(e));
        }
        return jSONObject;
    }

    private String O000000o(long j, int i) {
        String str = this.O0000oOo + File.separator + j;
        if (i <= 5) {
            return str + ".zip";
        } else if (i < 7) {
            return str + "_install";
        } else {
            return str + File.separator;
        }
    }

    private String O00000o0(O0000Oo o0000Oo) {
        return O000000o(o0000Oo.O00000Oo, o0000Oo.O0000O0o);
    }

    public static hsi.O000000o O000000o(Context context) {
        String O000000o2 = fkw.O000000o(context);
        hsi.O000000o O000000o3 = hsi.O000000o(context);
        String str = O000000o2 + O0000ooO;
        String O000000o4 = fkw.O000000o(str);
        if (TextUtils.isEmpty(O000000o4)) {
            return O000000o3;
        }
        try {
            JSONObject jSONObject = new JSONObject(O000000o4);
            hsi.O000000o o000000o = new hsi.O000000o(jSONObject.getLong("max_api_level"), jSONObject.getLong("build_time"), jSONObject.getString("real_installed_path"), false, String.valueOf(jSONObject.optLong("package_version")));
            if (O000000o3 != null && O000000o3.f598O000000o > o000000o.f598O000000o) {
                fkw.O00000Oo(str);
                return O000000o3;
            } else if (O000000o3 == null || O000000o3.f598O000000o != o000000o.f598O000000o || O000000o3.O00000Oo <= o000000o.O00000Oo) {
                hsi.O000000o("load rn sdk info from file", Long.valueOf(o000000o.f598O000000o), o000000o.O00000o0);
                return o000000o;
            } else {
                fkw.O00000Oo(str);
                return O000000o3;
            }
        } catch (Exception e) {
            O00000o(Log.getStackTraceString(e));
            return O000000o3;
        }
    }

    public static final String O000000o(long j) {
        return "rn_sdk_timestamp_".concat(String.valueOf(j));
    }

    public final boolean O00000Oo(long j) {
        String O000000o2 = O000000o(j, 7);
        if (new File(O000000o2, "conf.json").exists()) {
            return true;
        }
        return new File(O000000o2, "_conf.json").exists();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(long j, fki fki) {
        O0000Oo o0000Oo = this.O0000Oo.get(Long.valueOf(j));
        if (o0000Oo != null) {
            if (o0000Oo.O0000O0o == 1) {
                o0000Oo.O0000O0o = 0;
            }
            o0000Oo.O0000OOo.add(fki);
            O000000o(o0000Oo);
            return;
        }
        String string = this.O00000o.getString(O000000o(j), "");
        if (!TextUtils.isEmpty(string)) {
            if (string.startsWith("!")) {
                if (10058 <= hhc.O000000o((Object) string.substring(1))) {
                    if (fki != null && fki.O0000Oo() != null) {
                        fki.O00000Oo("rn_sdk_is_forbidden", Boolean.TRUE);
                        fki.O0000Oo().O000000o(fki, -668);
                        return;
                    }
                    return;
                }
            } else if (string.startsWith("#")) {
                long O000000o2 = hhc.O000000o((Object) string.substring(1));
                if (O000000o2 > 0 && O00000Oo(j)) {
                    if (fki != null) {
                        O000000o(fki);
                    }
                    O0000Oo o0000Oo2 = new O0000Oo();
                    o0000Oo2.O00000Oo = j;
                    o0000Oo2.O0000O0o = 0;
                    o0000Oo2.O00000o0 = O000000o2;
                    this.O0000Oo.put(Long.valueOf(o0000Oo2.O00000Oo), o0000Oo2);
                    O000000o(o0000Oo2);
                    return;
                }
            }
        }
        O0000Oo o0000Oo3 = new O0000Oo();
        o0000Oo3.O00000Oo = j;
        o0000Oo3.O0000O0o = 0;
        o0000Oo3.O00000o0 = 0;
        if (fki != null) {
            o0000Oo3.O0000OOo.add(fki);
        }
        this.O0000Oo.put(Long.valueOf(o0000Oo3.O00000Oo), o0000Oo3);
        O000000o(o0000Oo3);
    }

    public static void O000000o(Map<String, Object> map) {
        File file = new File((String) map.get("installed_path"));
        File[] listFiles = file.getParentFile().listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (!file2.equals(file)) {
                    if (file2.isFile()) {
                        fkw.O00000Oo(file2.getAbsolutePath());
                    } else if (file2.getName().matches("^\\d+$")) {
                        fkw.O00000o0(file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public final boolean O000000o(long j, long j2, String str, String str2) {
        boolean z;
        if (!O00000o0()) {
            gsy.O00000o0(LogType.PLUGIN, "PluginManager", "installRNPackage failed, not init");
            return false;
        }
        File file = new File(str2);
        boolean O000000o2 = fky.O000000o(str, str2);
        boolean z2 = fky.O000000o(str2) != null;
        if (!file.exists() || !z2 || !O000000o2) {
            if (file.exists() && z2 && !O000000o2) {
                boolean O00000Oo2 = fkw.O00000Oo(str + File.separator + "model_list.json", str2 + File.separator + "model_list.json");
                O00000o("插件包存在，签名也能通过，model_list文件不一样，仅仅更新下model_list文件, isCopySuccess=".concat(String.valueOf(O00000Oo2)));
                if (O00000Oo2) {
                    return true;
                }
            } else if (!file.exists()) {
                O00000o("installRNPackage 首次进行安装: ".concat(String.valueOf(str2)));
            } else if (!O000000o2) {
                O00000o("installRNPackage 安装包完整性校验 error, 出现了重复安装，但model_list 文件不完整，需要再次进行安装: ".concat(String.valueOf(str2)));
            } else if (!z2) {
                O00000o("installRNPackage 安装包完整性校验 error, 出现了重复安装，model_list 文件完整, 但签名失败，需要再次进行安装: ".concat(String.valueOf(str2)));
            } else {
                O00000o("installRNPackage 安装包完整性校验 error, 未知错误: ".concat(String.valueOf(str2)));
            }
            fkw.O00000o0(str2);
            if (new File(str).isFile()) {
                String O000000o3 = O000000o(j, j2);
                fkw.O00000o0(O000000o3);
                if (!fla.O000000o(str, O000000o3, null)) {
                    fkw.O00000o0(O000000o3);
                    O00000o("installRNPackage syncUnzip false path:".concat(String.valueOf(O000000o3)));
                    return false;
                }
                fkw.O00000oO(new File(O000000o3, "conf.json").getAbsolutePath());
                fkw.O00000Oo(str);
                if (fky.O000000o(O000000o3) == null) {
                    fkw.O00000o0(O000000o3);
                    O00000o("installRNPackage checkRnBundleSignature false path:".concat(String.valueOf(O000000o3)));
                    return false;
                }
                fkw.O00000o0(O000000o3, str2);
                fkw.O00000o0(O000000o3);
                z = true;
            } else {
                z = fkw.O00000Oo(str, str2);
            }
            if (z && fky.O00000o(str2)) {
                return true;
            }
            O00000o("installRNPackage false pluginId: " + j + " , packageId: " + j2 + ", isCopyFileSuccess: " + z);
            return false;
        }
        O00000o("installRNPackage 安装包完整性校验 success,  出现了重复安装，但签名成功， 且 model_list 文件完整， 无需重复安装: ".concat(String.valueOf(str2)));
        return true;
    }

    public final void O000000o(O0000Oo o0000Oo) {
        this.O0000O0o.obtainMessage(24, o0000Oo).sendToTarget();
    }

    public final void O00000Oo(O0000Oo o0000Oo) {
        fki fki;
        fki.O000000o O0000Oo2;
        final O0000Oo o0000Oo2 = o0000Oo;
        if (o0000Oo2 != null) {
            synchronized (o0000Oo) {
                int i = o0000Oo2.O0000O0o;
                if (i != 10) {
                    switch (i) {
                        case 0:
                            o0000Oo2.O0000O0o = 2;
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(o0000Oo2.O00000Oo);
                            final long currentTimeMillis = System.currentTimeMillis();
                            fko.O000000o().O000000o(jSONArray, new fde<JSONArray, fdg>() {
                                /* class _m_j.fkl.AnonymousClass3 */

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    JSONArray jSONArray = (JSONArray) obj;
                                    if (jSONArray == null || jSONArray.length() != 1) {
                                        O000000o(2, jSONArray.length() <= 0 ? "not found the sdk" : "too more sdk info");
                                        return;
                                    }
                                    try {
                                        JSONObject jSONObject = jSONArray.getJSONObject(0);
                                        Long valueOf = Long.valueOf(jSONObject.optLong("sdk_version", 0));
                                        if (valueOf.longValue() != o0000Oo2.O00000Oo) {
                                            O000000o(3, "invalid sdk_api_level");
                                            return;
                                        }
                                        Long valueOf2 = Long.valueOf(jSONObject.optLong("create_time", 0));
                                        Long valueOf3 = Long.valueOf(jSONObject.optLong("change_time", 0));
                                        if (valueOf3 != null && valueOf3.longValue() > valueOf2.longValue()) {
                                            valueOf2 = valueOf3;
                                        }
                                        String optString = jSONObject.optString("download_url", "");
                                        Long valueOf4 = Long.valueOf(jSONObject.optLong("min_api_version", 0));
                                        Long valueOf5 = Long.valueOf(jSONObject.optLong("length", 0));
                                        long optLong = jSONObject.optLong("version", 0);
                                        if (valueOf4.longValue() > 10058) {
                                            SharedPreferences.Editor edit = fkl.this.O00000o.edit();
                                            edit.putString(fkl.O000000o(valueOf.longValue()), "!10058");
                                            edit.commit();
                                            fcx.f16092O000000o.O000000o("fetch_sdk", "", o0000Oo2.f16536O000000o, -1001, System.currentTimeMillis() - currentTimeMillis);
                                            o0000Oo2.O0000O0o = 10;
                                            o0000Oo2.f16536O000000o = null;
                                        } else {
                                            if (!TextUtils.isEmpty(optString)) {
                                                if (valueOf2.longValue() >= 1) {
                                                    if (valueOf2.longValue() > o0000Oo2.O00000o0 || !fkl.this.O00000Oo(valueOf.longValue())) {
                                                        fcx.f16092O000000o.O000000o("fetch_sdk", "", o0000Oo2.f16536O000000o, 0, System.currentTimeMillis() - currentTimeMillis);
                                                        o0000Oo2.f16536O000000o = optString;
                                                        o0000Oo2.O00000o0 = valueOf2.longValue();
                                                        o0000Oo2.O00000oO = valueOf5.longValue();
                                                        o0000Oo2.O00000oo = optLong;
                                                        o0000Oo2.O0000O0o = 3;
                                                    } else {
                                                        o0000Oo2.O0000O0o = 7;
                                                        fkl.this.O000000o(o0000Oo2);
                                                        fcx.f16092O000000o.O000000o("fetch_sdk", "", o0000Oo2.f16536O000000o, 1, System.currentTimeMillis() - currentTimeMillis);
                                                        return;
                                                    }
                                                }
                                            }
                                            O000000o(3, "download url of rn sdk is empty");
                                            return;
                                        }
                                        if (o0000Oo2.O0000Oo != null) {
                                            o0000Oo2.O0000Oo.O000000o(new DownloadRnSdkResult(1, "get rn sdk info success"));
                                        }
                                        fkl.this.O000000o(o0000Oo2);
                                    } catch (JSONException e) {
                                        fkl.O00000o(Log.getStackTraceString(e));
                                        O000000o(4, "failed to update info of rn sdk");
                                    }
                                }

                                private void O000000o(int i, String str) {
                                    O0000Oo o0000Oo = o0000Oo2;
                                    o0000Oo.O0000O0o = 1;
                                    if (o0000Oo.O0000Oo != null) {
                                        O0000Oo0 o0000Oo0 = o0000Oo2.O0000Oo;
                                        o0000Oo0.O00000Oo(new DownloadRnSdkResult(5, "get rn sdk info failure, code=" + i + "  msg=" + str));
                                    }
                                    fkl.this.O000000o(o0000Oo2);
                                }

                                public final void onFailure(fdg fdg) {
                                    fdg fdg2 = fdg;
                                    O000000o(fdg2.f16100O000000o, fdg2.O00000Oo);
                                    fkl.O00000o("download rn sdk,fetch_sdk error, code:" + fdg2.f16100O000000o + " msg:" + fdg2.O00000Oo);
                                    int i = fdg2.f16100O000000o;
                                    String str = "null";
                                    if (i > 0) {
                                        fcx fcx = fcx.f16092O000000o;
                                        Object[] objArr = new Object[2];
                                        objArr[0] = o0000Oo2.f16536O000000o;
                                        if (!TextUtils.isEmpty(fdg2.O00000Oo)) {
                                            str = URLEncoder.encode(fdg2.O00000Oo);
                                        }
                                        objArr[1] = str;
                                        fcx.O000000o("fetch_sdk", "", String.format("%s://%s", objArr), -10000 - i, 0);
                                        return;
                                    }
                                    fcx fcx2 = fcx.f16092O000000o;
                                    Object[] objArr2 = new Object[2];
                                    objArr2[0] = o0000Oo2.f16536O000000o;
                                    if (!TextUtils.isEmpty(fdg2.O00000Oo)) {
                                        str = URLEncoder.encode(fdg2.O00000Oo);
                                    }
                                    objArr2[1] = str;
                                    fcx2.O000000o("fetch_sdk", "", String.format("%s://%s", objArr2), i - 200000, 0);
                                }
                            });
                            break;
                        case 3:
                            for (Object next : o0000Oo2.O0000OOo) {
                                if ((next instanceof fki) && (O0000Oo2 = (fki = (fki) next).O0000Oo()) != null && !((Boolean) fki.O000000o("started", Boolean.FALSE)).booleanValue()) {
                                    fki.O00000Oo("started", Boolean.TRUE);
                                    fki.O00000Oo("download_sdk", Boolean.TRUE);
                                    O0000Oo2.O000000o(fki);
                                }
                            }
                            o0000Oo2.O0000Oo0 = System.currentTimeMillis();
                            o0000Oo2.O0000O0o = 4;
                            this.f16519O000000o.O000000o(o0000Oo2.f16536O000000o, null, o0000Oo2.O00000oO, O00000o0(o0000Oo), new fkg.O000000o() {
                                /* class _m_j.fkl.AnonymousClass4 */

                                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                 method: _m_j.fki.O000000o.O000000o(_m_j.fki, float):void
                                 arg types: [_m_j.fki, int]
                                 candidates:
                                  _m_j.fki.O000000o.O000000o(_m_j.fki, int):void
                                  _m_j.fki.O000000o.O000000o(_m_j.fki, com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo):void
                                  _m_j.fki.O000000o.O000000o(_m_j.fki, float):void */
                                /* access modifiers changed from: package-private */
                                public final void O00000Oo() {
                                    fki fki;
                                    fki.O000000o O0000Oo;
                                    super.O00000Oo();
                                    if (o0000Oo2.O0000O0o == 4) {
                                        O0000Oo o0000Oo = o0000Oo2;
                                        o0000Oo.O0000O0o = 5;
                                        for (Object next : o0000Oo.O0000OOo) {
                                            if ((next instanceof fki) && (O0000Oo = (fki = (fki) next).O0000Oo()) != null) {
                                                O0000Oo.O000000o(fki, 0.1f);
                                            }
                                        }
                                        if (o0000Oo2.O0000Oo != null) {
                                            o0000Oo2.O0000Oo.O000000o(new DownloadRnSdkResult(3, "rn sdk download success"));
                                        }
                                    }
                                    fkl.this.O000000o(o0000Oo2);
                                    fcx.f16092O000000o.O000000o("download_sdk", "", o0000Oo2.f16536O000000o, 0, System.currentTimeMillis() - o0000Oo2.O0000Oo0);
                                }

                                /* access modifiers changed from: package-private */
                                public final void O00000o0() {
                                    super.O00000o0();
                                    O0000Oo o0000Oo = o0000Oo2;
                                    o0000Oo.O0000O0o = 1;
                                    if (o0000Oo.O0000Oo != null) {
                                        o0000Oo2.O0000Oo.O00000Oo(new DownloadRnSdkResult(6, "rn sdk download failure"));
                                    }
                                    fkl.this.O000000o(o0000Oo2);
                                    fcx.f16092O000000o.O000000o("download_sdk", "", o0000Oo2.f16536O000000o, -1003, System.currentTimeMillis() - o0000Oo2.O0000Oo0);
                                }
                            });
                            break;
                        case 5:
                            String O00000o02 = O00000o0(o0000Oo);
                            String O000000o2 = O000000o(o0000Oo2.O00000Oo, 6);
                            fkw.O00000o0(O000000o2);
                            if (!fla.O000000o(O00000o02, O000000o2, null)) {
                                o0000Oo2.O0000O0o = 1;
                            } else {
                                o0000Oo2.O0000O0o = 6;
                            }
                            O000000o(o0000Oo);
                            fkw.O00000Oo(O00000o02);
                            break;
                        case 6:
                            String O00000o03 = O00000o0(o0000Oo);
                            File file = new File(O00000o03, "android");
                            fkw.O00000oO(new File(O00000o03, "conf.json").getAbsolutePath());
                            JSONObject O000000o3 = fky.O000000o(O00000o03);
                            if (O000000o3 != null) {
                                o0000Oo2.O00000o = O000000o3.optLong("build_time", 0);
                                String O000000o4 = O000000o(o0000Oo2.O00000Oo, 7);
                                File file2 = new File(O000000o4, "conf.json");
                                if (file2.exists()) {
                                    File file3 = new File(O000000o4, "_android");
                                    fkw.O00000o0(file3.getAbsolutePath());
                                    fkw.O00000oO(new File(O000000o4, "_conf.json").getAbsolutePath());
                                    file.renameTo(file3);
                                    fkw.O00000Oo(file2.getAbsolutePath());
                                } else {
                                    File file4 = new File(O000000o4, "android");
                                    fkw.O00000o0(file4.getAbsolutePath());
                                    fkw.O00000oO(file2.getAbsolutePath());
                                    file.renameTo(file4);
                                }
                                o0000Oo2.O0000O0o = 7;
                            } else {
                                fkw.O00000o0(O00000o03);
                                o0000Oo2.O0000O0o = 1;
                                if (o0000Oo2.O0000Oo != null) {
                                    o0000Oo2.O0000Oo.O00000Oo(new DownloadRnSdkResult(7, "rn sdk install failure, Signature failure"));
                                }
                                fcx.f16092O000000o.O000000o("download_sdk", "", o0000Oo2.f16536O000000o, -1002, 0);
                            }
                            O000000o(o0000Oo);
                            break;
                        case 7:
                            this.O0000Oo.remove(Long.valueOf(o0000Oo2.O00000Oo));
                            String O00000Oo2 = fky.O00000Oo(O00000o0(o0000Oo));
                            SharedPreferences.Editor edit = this.O00000o.edit();
                            edit.putString(O000000o(o0000Oo2.O00000Oo), "#" + o0000Oo2.O00000o0);
                            edit.apply();
                            hsi.O000000o O000000o5 = O000000o(this.O00000o0);
                            if ((O000000o5 == null || O000000o5.f598O000000o <= o0000Oo2.O00000Oo) && o0000Oo2.O00000o > 100000) {
                                String str = this.O0000oo0;
                                String str2 = "{\"max_api_level\":" + o0000Oo2.O00000Oo + ",\"build_time\":" + o0000Oo2.O00000o + ",\"real_installed_path\":\"" + O00000Oo2 + "\",\"package_version\":" + o0000Oo2.O00000oo + "}";
                                fkw.O000000o(new File(str), str2.getBytes());
                                hsi.O000000o("write rn sdk info", str2, str);
                            }
                            for (Object next2 : o0000Oo2.O0000OOo) {
                                if (next2 instanceof fki) {
                                    O000000o((fki) next2);
                                } else if (next2 instanceof Callback) {
                                    ((Callback) next2).onSuccess(o0000Oo2);
                                }
                            }
                            if (o0000Oo2.O00000o > 100000) {
                                Intent intent = new Intent("downrnsdk_action");
                                intent.putExtra("sdk_api_level", o0000Oo2.O00000Oo);
                                intent.putExtra("timestamp", o0000Oo2.O00000o0);
                                intent.putExtra("path", O00000Oo2);
                                this.O00000o0.sendBroadcast(intent);
                                O00000o("PluginManager update rn sdk success, send broadcast " + o0000Oo2.O00000o + "  " + o0000Oo2.O00000Oo);
                            }
                            if (o0000Oo2.O0000Oo != null) {
                                o0000Oo2.O0000Oo.O000000o(new DownloadRnSdkResult(4, "rn sdk install success"));
                                break;
                            }
                            break;
                    }
                }
                this.O0000Oo.remove(Long.valueOf(o0000Oo2.O00000Oo));
                for (Object next3 : o0000Oo2.O0000OOo) {
                    if (next3 instanceof fki) {
                        fki fki2 = (fki) next3;
                        if (o0000Oo2.O0000O0o == 10) {
                            fki2.O00000Oo("rn_sdk_is_forbidden", Boolean.TRUE);
                        }
                        fki.O000000o O0000Oo3 = fki2.O0000Oo();
                        if (O0000Oo3 != null) {
                            O0000Oo3.O000000o(fki2, -667);
                        }
                    } else if (next3 instanceof Callback) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(o0000Oo2.O00000Oo);
                        ((Callback) next3).onFailure(100, sb.toString());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01d1  */
    public final O00000o O00000o() {
        long j;
        boolean z;
        String str;
        Intent launchIntentForPackage;
        O00000o o00000o = new O00000o();
        File externalCacheDir = CommonApplication.getAppContext().getExternalCacheDir();
        File file = new File(externalCacheDir + File.separator + "debug");
        String[] list = file.list();
        if (list == null || list.length <= 0) {
            o00000o.O00000oO = true;
            o00000o.O00000oo = "SD卡无插件包\n".concat(String.valueOf(file));
            return o00000o;
        }
        String str2 = list[0];
        String str3 = "mpk";
        String str4 = "";
        if (str2.toLowerCase().endsWith(str3.toLowerCase())) {
            str4 = str2.substring(0, (str2.length() - 3) - 1);
        } else if (str2.toLowerCase().endsWith("h5".toLowerCase())) {
            str4 = str2.substring(0, (str2.length() - 2) - 1);
            str3 = "h5";
        } else if (str2.toLowerCase().endsWith("apk".toLowerCase())) {
            str4 = str2.substring(0, (str2.length() - 3) - 1);
            str3 = "apk";
        } else if (str2.toLowerCase().endsWith("rn".toLowerCase())) {
            str4 = str2.substring(0, (str2.length() - 2) - 1);
            str3 = "rn";
        } else {
            str3 = str4;
        }
        try {
            j = Long.parseLong(str4);
        } catch (Exception unused) {
            j = 0;
        }
        if (j <= 0) {
            o00000o.O00000oO = true;
            o00000o.O00000oo = "文件名格式非法(" + str2 + ")";
            return o00000o;
        } else if (TextUtils.isEmpty(str3)) {
            o00000o.O00000oO = true;
            o00000o.O00000oo = "文件名格式非法(" + str2 + ")";
            return o00000o;
        } else {
            String str5 = externalCacheDir + File.separator + "debug" + File.separator + str2;
            if (!TextUtils.isEmpty(str5)) {
                String str6 = this.O0000o + File.separator + "debug";
                String str7 = str6 + File.separator + "armeabi_zip";
                String str8 = str6 + File.separator + "armeabi-v7a_zip";
                String str9 = "lib" + File.separator + "armeabi";
                String str10 = "lib" + File.separator + "armeabi-v7a";
                fla.O000000o(str5, str7, str9);
                String[] list2 = new File(str7 + File.separator + str9).list();
                if (list2 == null || list2.length <= 0) {
                    fla.O000000o(str5, str8, str10);
                    String[] list3 = new File(str8 + File.separator + str10).list();
                    if (list3 != null && list3.length > 0) {
                        fkw.O00000o0(str6);
                    }
                } else {
                    fkw.O00000o0(str6);
                }
                z = true;
                if (z) {
                    ArrayList arrayList = new ArrayList();
                    for (long j2 = 1; j2 <= 100; j2++) {
                        arrayList.add(Long.valueOf(j2));
                    }
                    Collections.shuffle(arrayList);
                    if (arrayList.size() > 0) {
                        j = ((Long) arrayList.get(0)).longValue();
                        str = externalCacheDir + File.separator + "debug" + File.separator + j + "." + str3;
                        new File(str5).renameTo(new File(str));
                        o00000o.f16534O000000o = str;
                        o00000o.O00000Oo = 1;
                        o00000o.O00000o0 = j;
                        o00000o.O00000o = str3;
                        o00000o.O00000oO = false;
                        return o00000o;
                    }
                    fkw.O00000o0(this.O0000oO0);
                    fkw.O00000o0(this.O0000oo);
                    Notification.Builder smallIcon = new Notification.Builder(this.O00000o0).setContentTitle("米家正在重启以卸载已加载的so").setContentText("请稍候调试").setSmallIcon(17301504);
                    NotificationManager notificationManager = (NotificationManager) this.O00000o0.getSystemService("notification");
                    if (notificationManager != null) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            Context context = this.O00000o0;
                            smallIcon.setChannelId(fke.O000000o(context, notificationManager, null, "SmartHome", context.getString(R.string.app_name2)));
                        }
                        notificationManager.notify(1122, smallIcon.build());
                    }
                    if (gfr.O0000OOo || gfr.O0000Oo) {
                        try {
                            PackageManager packageManager = this.O00000o0.getPackageManager();
                            if (!(packageManager == null || (launchIntentForPackage = packageManager.getLaunchIntentForPackage(this.O00000o0.getPackageName())) == null)) {
                                launchIntentForPackage.addFlags(67108864);
                                ((AlarmManager) this.O00000o0.getSystemService("alarm")).set(1, System.currentTimeMillis() + 2000, PendingIntent.getActivity(this.O00000o0, 223344, launchIntentForPackage, 268435456));
                                Process.killProcess(Process.myPid());
                                System.exit(0);
                            }
                        } catch (Exception unused2) {
                        }
                    }
                }
                str = str5;
                o00000o.f16534O000000o = str;
                o00000o.O00000Oo = 1;
                o00000o.O00000o0 = j;
                o00000o.O00000o = str3;
                o00000o.O00000oO = false;
                return o00000o;
            }
            z = false;
            if (z) {
            }
            str = str5;
            o00000o.f16534O000000o = str;
            o00000o.O00000Oo = 1;
            o00000o.O00000o0 = j;
            o00000o.O00000o = str3;
            o00000o.O00000oO = false;
            return o00000o;
        }
    }

    static void O00000oO() {
        fkw.O00000o0(CommonApplication.getAppContext().getExternalCacheDir() + File.separator + "debug");
    }

    public final PluginPackageInfo O00000Oo(String str) {
        return this.O0000OOo.get(str);
    }

    public final PluginPackageInfo O00000o0(String str) {
        return this.O0000Oo0.get(str);
    }

    public static void O000000o(String str, fki fki, int i) {
        O000000o(str, fki, i, -1);
    }

    public static void O000000o(String str, fki fki, int i, long j) {
        if (fki != null && "rn".equalsIgnoreCase(fki.O00000o())) {
            if (j != 0 && fki.O00000Oo > 0) {
                j = System.currentTimeMillis() - fki.O00000Oo;
            }
            String str2 = str;
            fcx.f16092O000000o.O000000o(str2, fki.f16517O000000o, fki.O00000oO(), i, j);
        }
    }

    public static void O00000o(String str) {
        gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginManager", str);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(final fki fki) {
        String str = fki.f16517O000000o;
        long O00000o02 = fki.O00000o0();
        long O00000Oo2 = fki.O00000Oo();
        String O00000o2 = fki.O00000o();
        final fki.O000000o O0000Oo2 = fki.O0000Oo();
        String O000000o2 = O000000o(O00000Oo2, O00000o02, O00000o2);
        File file = new File(O000000o2);
        if (file.exists()) {
            if ("rn".equalsIgnoreCase(O00000o2)) {
                new fkk(file).O000000o(Collections.singletonList(str)).O00000Oo();
            }
            O00000o(str + " downloadPluginInternal has downloaded package  newTask:" + fki);
            PluginPackageInfo O000000o3 = fky.O000000o(this.O00000o0, O00000Oo2, O00000o02, O00000o2, O000000o2);
            if (O000000o3 == null) {
                O0000Oo2.O000000o(fki, -661);
            } else {
                O0000Oo2.O000000o(fki, O000000o3);
            }
        } else if (!"mpk".equalsIgnoreCase(O00000o2) || DynamicFeatureManager.instance.getFeatureSize() == 0) {
            O00000o(str + " downloadPluginInternal start Down task not exist path:" + O000000o2);
            this.f16519O000000o.O000000o(O000000o2, fki);
        } else if (DynamicFeatureManager.instance.isDynamicFeature(str)) {
            DynamicFeatureManager.instance.downloadPlugin(str, new DynamicFeatureManager.O000000o(str) {
                /* class _m_j.fkl.AnonymousClass5 */

                public final void onCancel(String str) {
                    O0000Oo2.O00000Oo(fki);
                    fkl.O00000o("downloadPluginInternal DynamicFeatureManager onCancel ".concat(String.valueOf(str)));
                }

                public final void onProgress(String str, float f) {
                    O0000Oo2.O000000o(fki, f);
                }

                public final void onSuccess(String str, PluginPackageInfo pluginPackageInfo) {
                    O0000Oo2.O000000o(fki, DynamicFeatureManager.instance.getPluginPackageInfo(str));
                    fkl.O00000o("downloadPluginInternal DynamicFeatureManager onSuccess ".concat(String.valueOf(str)));
                }

                public final void onFailure(String str, int i) {
                    O0000Oo2.O000000o(fki, i);
                    fkl.O00000o("downloadPluginInternal DynamicFeatureManager onFailure ".concat(String.valueOf(str)));
                }
            });
            O00000o("downloadPluginInternal DynamicFeatureManager downloadPlugin start");
        } else {
            O0000Oo2.O000000o(fki, -712);
            O00000o("downloadPluginInternal internal cannot use apk plugin and no DynamicFeature");
        }
    }

    public static void O000000o(String str, int i) {
        fcx.f16092O000000o.O000000o("install_plugin", str, i);
    }

    public static void O00000Oo(String str, int i) {
        fcx.f16092O000000o.O00000Oo("install_plugin_detail", str, i);
    }
}

package _m_j;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.application.CommonApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hsi {

    /* renamed from: O000000o  reason: collision with root package name */
    private static O000000o f597O000000o;

    public static boolean O000000o(long j) {
        return j > 0;
    }

    public static boolean O00000Oo(long j) {
        return j > 0;
    }

    public static final boolean O000000o() {
        return gfr.O0000OOo || gfr.O0000Oo;
    }

    public static final boolean O00000Oo() {
        return O000000o() && !TextUtils.isEmpty("/mnt/sdcard/SmartHome/logs/plugin_timestamp.log") && new File("/mnt/sdcard/SmartHome/logs/plugin_timestamp.log").exists();
    }

    public static final void O000000o(boolean z) {
        if (O000000o()) {
            if (z) {
                ftd.O00000oO("/mnt/sdcard/SmartHome/logs/plugin_timestamp.log");
            } else {
                ftd.O00000o("/mnt/sdcard/SmartHome/logs/plugin_timestamp.log");
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileWriter.<init>(java.io.File, boolean):void throws java.io.IOException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileWriter.<init>(java.lang.String, boolean):void throws java.io.IOException}
      ClspMth{java.io.FileWriter.<init>(java.io.File, boolean):void throws java.io.IOException} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007d A[SYNTHETIC, Splitter:B:28:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0083 A[SYNTHETIC, Splitter:B:32:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    public static final void O000000o(String str) {
        if (O000000o()) {
            long currentTimeMillis = System.currentTimeMillis();
            gsy.O000000o(4, "RN_TIMESTAMP", str + " : " + currentTimeMillis);
            if (O00000Oo()) {
                String str2 = currentTimeMillis + ":" + str + ";\n";
                if ("device item clicked".equals(str)) {
                    ftd.O000000o("/mnt/sdcard/SmartHome/logs/plugin_timestamp.log", str2, "");
                    return;
                }
                FileWriter fileWriter = null;
                try {
                    FileWriter fileWriter2 = new FileWriter(new File("/mnt/sdcard/SmartHome/logs/plugin_timestamp.log"), true);
                    try {
                        fileWriter2.append((CharSequence) str2);
                        fileWriter2.close();
                        try {
                            fileWriter2.close();
                        } catch (Exception unused) {
                        }
                    } catch (Exception e) {
                        e = e;
                        fileWriter = fileWriter2;
                        try {
                            Log.i("RN_TIMESTAMP", "failed to write file", e);
                            if (fileWriter == null) {
                                try {
                                    fileWriter.close();
                                } catch (Exception unused2) {
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (fileWriter != null) {
                                try {
                                    fileWriter.close();
                                } catch (Exception unused3) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileWriter = fileWriter2;
                        if (fileWriter != null) {
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    Log.i("RN_TIMESTAMP", "failed to write file", e);
                    if (fileWriter == null) {
                    }
                }
            }
        }
    }

    public static final void O00000o0() {
        if (O000000o()) {
            String O000000o2 = ftd.O000000o("/mnt/sdcard/SmartHome/logs/plugin_timestamp.log");
            if (!TextUtils.isEmpty(O000000o2)) {
                String[] split = O000000o2.split(";");
                int length = split.length;
                Long l = null;
                Long l2 = null;
                Long l3 = null;
                Long l4 = null;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = split[i];
                    if (!TextUtils.isEmpty(str)) {
                        String[] split2 = str.split(":");
                        if (split2.length < 2) {
                            continue;
                        } else if (l2 == null) {
                            if ("device item clicked".equals(split2[1].trim())) {
                                l2 = Long.valueOf(Long.parseLong(split2[0].trim()));
                            }
                        } else if (l3 == null) {
                            if ("runtime load plugin".equals(split2[1].trim())) {
                                l3 = Long.valueOf(Long.parseLong(split2[0].trim()));
                            }
                        } else if (l4 == null) {
                            if ("plugin componentWillMount".equals(split2[1].trim())) {
                                l4 = Long.valueOf(Long.parseLong(split2[0].trim()));
                            }
                        } else if ("plugin componentDidMount".equals(split2[1].trim())) {
                            l = Long.valueOf(Long.parseLong(split2[0].trim()));
                            break;
                        }
                    }
                    i++;
                }
                if (l != null) {
                    izb.O000000o(CommonApplication.getAppContext(), "time used:\n" + "ready:   " + (l3.longValue() - l2.longValue()) + " ms\n" + "loading: " + (l4.longValue() - l3.longValue()) + " ms\n" + "loadAll: " + (l4.longValue() - l2.longValue()) + " ms\n" + "render:  " + (l.longValue() - l4.longValue()) + " ms\n" + "all:     " + (l.longValue() - l2.longValue()) + " ms\n", 1).show();
                }
            }
        }
    }

    public static final void O000000o(Object... objArr) {
        if (objArr.length > 0) {
            if (objArr.length == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(objArr[0]);
                gsy.O000000o(4, "MIOTRNSDK10058", sb.toString());
            } else if (objArr.length != 2 || !(objArr[1] instanceof Throwable)) {
                StringBuilder sb2 = new StringBuilder();
                Throwable th = null;
                for (Object obj : objArr) {
                    if (obj instanceof Throwable) {
                        th = (Throwable) obj;
                    } else {
                        sb2.append(obj + " | ");
                    }
                }
                if (th != null) {
                    Log.i("MIOTRNSDK10058", sb2.toString(), th);
                } else {
                    gsy.O000000o(4, "MIOTRNSDK10058", sb2.toString());
                }
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(objArr[0]);
                Log.i("MIOTRNSDK10058", sb3.toString(), (Throwable) objArr[1]);
            }
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final long f598O000000o;
        public final long O00000Oo;
        public final String O00000o;
        public final String O00000o0;
        public final boolean O00000oO;
        public final String O00000oo;

        public O000000o(long j, long j2, String str, boolean z, String str2) {
            this.f598O000000o = j;
            this.O00000Oo = j2;
            if (z) {
                this.O00000o0 = str;
                this.O00000o = "asset:/plugin_rn_sdk" + File.separator;
            } else {
                if (str.endsWith(File.separator)) {
                    this.O00000o = str;
                } else {
                    this.O00000o = str + File.separator;
                }
                this.O00000o0 = this.O00000o + "sdk.bundle";
            }
            this.O00000oO = z;
            this.O00000oo = str2;
        }

        public final String toString() {
            return "api_level: " + this.f598O000000o + "   build_time: " + this.O00000Oo + "  is_inner_sdk: " + this.O00000oO + "  install_path: " + this.O00000o0 + " version:" + this.O00000oo;
        }
    }

    public static final O000000o O000000o(Context context) {
        O000000o o000000o = f597O000000o;
        if (o000000o != null) {
            return o000000o;
        }
        try {
            JSONObject jSONObject = new JSONObject(ftd.O000000o(context.getAssets().open("plugin_rn_sdk/project.json")));
            long j = jSONObject.getLong("sdk_api_level");
            long j2 = jSONObject.getLong("build_time");
            f597O000000o = new O000000o(j, j2, "assets://plugin_rn_sdk" + File.separator + "sdk.bundle", true, "0");
            O000000o("create inner rn sdk info", Long.valueOf(f597O000000o.f598O000000o), f597O000000o.O00000o0);
            return f597O000000o;
        } catch (Exception unused) {
            O000000o("not has inner rn sdk,  sdk api level is 10058");
            return null;
        }
    }

    public static final List<String> O00000Oo(String str) {
        return O000000o(str, "trigger_ids");
    }

    public static final List<String> O00000o0(String str) {
        return O000000o(str, "action_ids");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x008b A[SYNTHETIC, Splitter:B:25:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009a A[SYNTHETIC, Splitter:B:30:0x009a] */
    private static final List<String> O000000o(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        String str3 = fky.O00000Oo(str) + File.separator + "project.json";
        gsy.O00000Oo("project_json_path", str3);
        File file = new File(str3);
        if (file.exists()) {
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr);
                    JSONArray optJSONArray = new JSONObject(new String(bArr)).getJSONObject("entrance_scene").optJSONArray(str2);
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            arrayList.add(optJSONArray.get(i).toString());
                        }
                    }
                    fileInputStream2.close();
                    try {
                        fileInputStream2.close();
                    } catch (IOException e) {
                        gsy.O000000o(6, "PluginSetting", e.toString());
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    try {
                        gsy.O000000o(6, "PluginSetting", e.toString());
                        if (fileInputStream != null) {
                        }
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e3) {
                            gsy.O000000o(6, "PluginSetting", e3.toString());
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                gsy.O000000o(6, "PluginSetting", e.toString());
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return arrayList;
            }
        }
        return arrayList;
    }

    public static String O000000o(Context context, long j) {
        File dir = context.getDir("dex", 0);
        return dir.getAbsolutePath() + File.separator + "plugin" + File.separator + j;
    }

    private static String O00000Oo(Context context) {
        return context.getFilesDir().getPath() + File.separator + "plugin" + File.separator + "install" + File.separator + "lib";
    }

    public static String O000000o(Context context, long j, long j2) {
        return O00000Oo(context) + File.separator + j + File.separator + j2;
    }

    public static String O000000o(Context context, long j, long j2, String str) {
        return O00000Oo(context) + File.separator + j + File.separator + j2 + File.separator + str;
    }
}

package _m_j;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.ICloudDataCallback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class clf {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f14036O000000o = true;
    private static volatile clf O00000Oo = null;
    private static boolean O00000o = false;
    private static boolean O00000o0 = false;

    public interface O000000o {
        void onComplete();

        void onError(int i, String str);

        void onProgress(int i);
    }

    public static boolean O00000Oo() {
        return true;
    }

    private clf() {
    }

    public static clf O000000o() {
        if (O00000Oo == null) {
            synchronized (clf.class) {
                if (O00000Oo == null) {
                    O00000Oo = new clf();
                }
            }
        }
        return O00000Oo;
    }

    public final void O000000o(String str, String str2, final Callback<JSONObject> callback) {
        if (!TextUtils.isEmpty(str)) {
            XmPluginHostApi.instance().callSmartHomeApi(str, "business.smartcamera.", DeviceConstant.isNewChuangmi(str) ? "/miot/camera/app/v2/get/alarmSwitch" : "/miot/camera/app/v1/get/alarmSwitch", "GET", str2, new Callback<JSONObject>() {
                /* class _m_j.clf.AnonymousClass13 */

                public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onSuccess(jSONObject);
                    }
                }

                public final void onFailure(int i, String str) {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(i, str);
                    }
                }
            }, Parser.DEFAULT_PARSER);
            return;
        }
        callback.onFailure(-90001, "invalid params");
    }

    public final void O00000Oo(String str, String str2, final Callback<JSONObject> callback) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            callback.onFailure(-90001, "invalid params");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("prefix", "idm");
            jSONObject.put("did", str);
            jSONObject.put("offset", 0);
            jSONObject.put("limit", 20);
        } catch (JSONException e) {
            cki.O00000oO("AlarmNetUtils", e.toString());
        }
        XmPluginHostApi.instance().callSmartHomeApi(str2, "/v2/device/range_get_extra_data", jSONObject.toString(), new Callback<JSONObject>() {
            /* class _m_j.clf.AnonymousClass14 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(jSONObject);
                }
            }

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public final void O00000o0(String str, String str2, final Callback<JSONObject> callback) {
        if (!TextUtils.isEmpty(str)) {
            XmPluginHostApi.instance().callSmartHomeApi(str, "business.smartcamera.", (str.equals("chuangmi.camera.ipc009") || str.equals("chuangmi.camera.ipc019") || str.equals("mijia.camera.v3") || str.equals("isa.camera.hlc6")) ? "/miot/camera/app/v1/put/motionDetectionSwitch" : "/miot/camera/app/v2/put/motionDetectionSwitch", "POST", str2, new Callback<JSONObject>() {
                /* class _m_j.clf.AnonymousClass15 */

                public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onSuccess(jSONObject);
                    }
                }

                public final void onFailure(int i, String str) {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(i, str);
                    }
                }
            }, Parser.DEFAULT_PARSER);
        }
    }

    public final void O00000o(String str, String str2, final Callback<JSONObject> callback) {
        civ.O000000o("AlarmNetUtils", "level:" + XmPluginHostApi.instance().getApiLevel());
        if (!TextUtils.isEmpty(str)) {
            XmPluginHostApi.instance().callSmartHomeApi(str, "business.smartcamera.", "/miot/camera/app/v1/put/pushSwitch", "POST", str2, new Callback<JSONObject>() {
                /* class _m_j.clf.AnonymousClass16 */

                public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onSuccess(jSONObject);
                    }
                }

                public final void onFailure(int i, String str) {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(i, str);
                    }
                }
            }, Parser.DEFAULT_PARSER);
        }
    }

    public final void O00000oO(String str, String str2, final Callback<JSONObject> callback) {
        civ.O000000o("AlarmNetUtils", "level:" + XmPluginHostApi.instance().getApiLevel());
        if (!TextUtils.isEmpty(str)) {
            XmPluginHostApi.instance().callSmartHomeApi(str, "business.smartcamera.", "/miot/camera/app/v1/put/pedestrianDetectionPushSwitch", "POST", str2, new Callback<JSONObject>() {
                /* class _m_j.clf.AnonymousClass17 */

                public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onSuccess(jSONObject);
                    }
                }

                public final void onFailure(int i, String str) {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(i, str);
                    }
                }
            }, Parser.DEFAULT_PARSER);
        }
    }

    public final void O00000oo(String str, String str2, final Callback<JSONObject> callback) {
        civ.O000000o("AlarmNetUtils", "level:" + XmPluginHostApi.instance().getApiLevel());
        if (!TextUtils.isEmpty(str)) {
            XmPluginHostApi.instance().callSmartHomeApi(str, "business.smartcamera.", "/miot/camera/app/v1/put/sensitive", "POST", str2, new Callback<JSONObject>() {
                /* class _m_j.clf.AnonymousClass2 */

                public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onSuccess(jSONObject);
                    }
                }

                public final void onFailure(int i, String str) {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(i, str);
                    }
                }
            }, Parser.DEFAULT_PARSER);
        }
    }

    public final void O0000O0o(String str, String str2, final Callback<JSONObject> callback) {
        if (!TextUtils.isEmpty(str)) {
            XmPluginHostApi.instance().callSmartHomeApi(str, "business.smartcamera.", "/miot/camera/app/v1/alarm/playlist/limit", "GET", str2, new Callback<JSONObject>() {
                /* class _m_j.clf.AnonymousClass3 */

                public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onSuccess(jSONObject);
                    }
                }

                public final void onFailure(int i, String str) {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(i, str);
                    }
                }
            }, Parser.DEFAULT_PARSER);
        }
    }

    public final void O0000OOo(String str, String str2, final Callback<JSONObject> callback) {
        if (!TextUtils.isEmpty(str)) {
            gsy.O00000Oo("AlarmNetUtils", "getAlarmPlaylistLimitV2 model = ".concat(String.valueOf(str)));
            gsy.O00000Oo("AlarmNetUtils", "getAlarmPlaylistLimitV2 params = ".concat(String.valueOf(str2)));
            XmPluginHostApi.instance().callSmartHomeApi(str, "business.smartcamera.", "/common/app/get/cloudlist", "GET", str2, new Callback<JSONObject>() {
                /* class _m_j.clf.AnonymousClass4 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    gsy.O00000Oo("AlarmNetUtils", "getAlarmPlaylistLimitV2 onSuccess = ".concat(String.valueOf(jSONObject)));
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onSuccess(jSONObject);
                    }
                }

                public final void onFailure(int i, String str) {
                    gsy.O00000Oo("AlarmNetUtils", "getAlarmPlaylistLimitV2 onFailure = " + str + i);
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(i, str);
                    }
                }
            }, Parser.DEFAULT_PARSER);
        }
    }

    public final void O0000Oo0(String str, String str2, final Callback<JSONObject> callback) {
        if (!TextUtils.isEmpty(str)) {
            XmPluginHostApi.instance().callSmartHomeApi(str, "business.smartcamera.", "/common/app/v2/delete/files", "POST", str2, new Callback<JSONObject>() {
                /* class _m_j.clf.AnonymousClass5 */

                public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onSuccess(jSONObject);
                    }
                }

                public final void onFailure(int i, String str) {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(i, str);
                    }
                }
            }, Parser.DEFAULT_PARSER);
        }
    }

    public static boolean O000000o(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (new File(context.getApplicationContext().getCacheDir() + "/" + str + ".mp4").exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean O00000o0() {
        return "cn".equals(XmPluginHostApi.instance().getGlobalSettingServer());
    }

    public static void O000000o(boolean z) {
        O00000o0 = z;
    }

    public static boolean O00000o() {
        return O00000o0;
    }

    public static boolean O000000o(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (TextUtils.equals(str, str2)) {
                return true;
            }
            Pattern compile = Pattern.compile("[._]+");
            String[] split = compile.split(str);
            String[] split2 = compile.split(str2);
            int min = Math.min(split.length, split2.length);
            for (int i = 0; i < min; i++) {
                if (split[i].compareTo(split2[i]) > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean O00000Oo(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (TextUtils.equals(str, str2)) {
                return true;
            }
            Pattern compile = Pattern.compile("[._]+");
            String[] split = compile.split(str);
            String[] split2 = compile.split(str2);
            int min = Math.min(split.length, split2.length);
            for (int i = 0; i < min; i++) {
                if (split[i].compareTo(split2[i]) > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean O00000oO() {
        return O00000o;
    }

    public static void O00000Oo(boolean z) {
        O00000o = z;
    }

    public static String O000000o(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("prefix", "business.smartcamera.");
            jSONObject.put("method", "GET");
            jSONObject.put("path", "/common/app/m3u8");
            jSONObject2.put("did", str2);
            jSONObject2.put("fileId", str3);
            return XmPluginHostApi.instance().generateRequestUrl(str, jSONObject, jSONObject2);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final void O000000o(final String str, String str2, String str3, boolean z, String str4, final String str5, boolean z2, final O000000o o000000o) {
        String str6 = str3;
        String generateRequestUrl2 = XmPluginHostApi.instance().generateRequestUrl2(str2, str, str6, z, str4);
        cki.O00000oo("AlarmNetUtils", "downloadM3U8ToMP4 generateRequestUrl2=".concat(String.valueOf(generateRequestUrl2)));
        XmPluginHostApi.instance().getCloudVideoFile(str2, str6, generateRequestUrl2, z2, new ICloudDataCallback() {
            /* class _m_j.clf.AnonymousClass9 */

            public final void onCloudDataSuccess(Object obj, final Object obj2) {
                new AsyncTask<String, Void, Integer>() {
                    /* class _m_j.clf.AnonymousClass9.AnonymousClass1 */

                    /* access modifiers changed from: protected */
                    public final /* synthetic */ Object doInBackground(Object[] objArr) {
                        return O000000o();
                    }

                    /* access modifiers changed from: protected */
                    public final /* synthetic */ void onPostExecute(Object obj) {
                        Integer num = (Integer) obj;
                        super.onPostExecute(num);
                        if (num.intValue() == 0) {
                            o000000o.onComplete();
                        } else {
                            o000000o.onError(num.intValue(), "yd ffmpeg  failure");
                        }
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:44:0x0114 A[SYNTHETIC, Splitter:B:44:0x0114] */
                    /* JADX WARNING: Removed duplicated region for block: B:58:0x0170  */
                    /* JADX WARNING: Removed duplicated region for block: B:63:0x0180 A[SYNTHETIC, Splitter:B:63:0x0180] */
                    private Integer O000000o() {
                        BufferedOutputStream bufferedOutputStream;
                        int videoConverter;
                        File file;
                        IOException e;
                        String str = (String) obj2;
                        String str2 = str5;
                        File[] listFiles = new File(str).listFiles();
                        if (listFiles == null) {
                            return -1;
                        }
                        List<File> asList = Arrays.asList(listFiles);
                        Collections.sort(asList, new Comparator<File>() {
                            /* class _m_j.clf.AnonymousClass9.AnonymousClass1.AnonymousClass1 */

                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                return ((File) obj).getName().compareTo(((File) obj2).getName());
                            }
                        });
                        StringBuilder sb = new StringBuilder();
                        StringBuilder sb2 = new StringBuilder();
                        for (File absolutePath : asList) {
                            String absolutePath2 = absolutePath.getAbsolutePath();
                            if (absolutePath2.contains(".ts")) {
                                sb.append("file '" + absolutePath2 + "'\r\n");
                            } else if (absolutePath2.contains("mp4")) {
                                sb2.append("file '" + absolutePath2 + "'\r\n");
                            }
                        }
                        gsy.O00000Oo("M3u8ToMp4Task", "concat =  " + sb.toString() + " concatMp4 = " + sb2.toString());
                        if (TextUtils.isEmpty(sb) && TextUtils.isEmpty(sb2)) {
                            return -1;
                        }
                        File file2 = new File(str + "/fileList.txt");
                        if (!file2.exists()) {
                            try {
                                file2.createNewFile();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        try {
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                            try {
                                if (!TextUtils.isEmpty(sb)) {
                                    bufferedOutputStream.write(sb.toString().getBytes());
                                } else if (!TextUtils.isEmpty(sb2)) {
                                    bufferedOutputStream.write(sb2.toString().getBytes());
                                }
                                bufferedOutputStream.flush();
                            } catch (IOException e3) {
                                e = e3;
                                try {
                                    e.printStackTrace();
                                    if (bufferedOutputStream != null) {
                                        bufferedOutputStream.close();
                                    }
                                    file = new File(str2);
                                    file.delete();
                                    String str3 = "ffmpeg -f concat -safe 0 -i " + file2.getAbsolutePath() + " -c copy " + str2;
                                    gsy.O00000Oo("M3u8ToMp4Task", "begin transform ".concat(String.valueOf(str3)));
                                    videoConverter = XmPluginHostApi.instance().videoConverter(str, str3);
                                    if (videoConverter == 0) {
                                    }
                                    return Integer.valueOf(videoConverter);
                                } catch (Throwable th) {
                                    th = th;
                                    if (bufferedOutputStream != null) {
                                        try {
                                            bufferedOutputStream.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            }
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        } catch (IOException e6) {
                            bufferedOutputStream = null;
                            e = e6;
                            e.printStackTrace();
                            if (bufferedOutputStream != null) {
                            }
                            file = new File(str2);
                            file.delete();
                            String str32 = "ffmpeg -f concat -safe 0 -i " + file2.getAbsolutePath() + " -c copy " + str2;
                            gsy.O00000Oo("M3u8ToMp4Task", "begin transform ".concat(String.valueOf(str32)));
                            videoConverter = XmPluginHostApi.instance().videoConverter(str, str32);
                            if (videoConverter == 0) {
                            }
                            return Integer.valueOf(videoConverter);
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedOutputStream = null;
                            if (bufferedOutputStream != null) {
                            }
                            throw th;
                        }
                        try {
                            file = new File(str2);
                            if (file.exists() && file.isFile()) {
                                file.delete();
                            }
                        } catch (Exception e7) {
                            cki.O00000oO("AlarmNetUtils", e7.toString());
                        }
                        String str322 = "ffmpeg -f concat -safe 0 -i " + file2.getAbsolutePath() + " -c copy " + str2;
                        gsy.O00000Oo("M3u8ToMp4Task", "begin transform ".concat(String.valueOf(str322)));
                        videoConverter = XmPluginHostApi.instance().videoConverter(str, str322);
                        if (videoConverter == 0) {
                            O000000o(new File(str));
                        }
                        return Integer.valueOf(videoConverter);
                    }

                    private void O000000o(File file) {
                        if (file != null && file.exists() && file.isDirectory()) {
                            for (File file2 : file.listFiles()) {
                                if (file2.isFile()) {
                                    file2.delete();
                                } else if (file2.isDirectory()) {
                                    O000000o(file2);
                                }
                            }
                            file.delete();
                        }
                    }
                }.execute(new String[0]);
            }

            public final void onCloudDataFailed(int i, String str) {
                o000000o.onError(i, str);
            }

            public final void onCloudDataProgress(int i) {
                o000000o.onProgress(i);
            }
        });
    }

    public static void O0000Oo(String str, String str2, final Callback<JSONObject> callback) {
        if (O00000o && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("did", str);
                jSONObject.put("region", Locale.getDefault().getCountry());
                XmPluginHostApi.instance().callSmartHomeApi(str2, "business.smartcamera.", "/miot/camera/app/v1/vip/status", "GET", jSONObject.toString(), new Callback<JSONObject>() {
                    /* class _m_j.clf.AnonymousClass7 */

                    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        Callback callback = callback;
                        if (callback != null) {
                            callback.onSuccess(jSONObject);
                        }
                    }

                    public final void onFailure(int i, String str) {
                        Callback callback = callback;
                        if (callback != null) {
                            callback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (JSONException unused) {
            }
        }
    }

    public static String O000000o(String str) {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return "";
        }
        File externalFilesDir = CommonApplication.getAppContext().getExternalFilesDir("external");
        if (externalFilesDir == null) {
            return null;
        }
        File file = new File(externalFilesDir.toString() + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath() + "/";
    }
}

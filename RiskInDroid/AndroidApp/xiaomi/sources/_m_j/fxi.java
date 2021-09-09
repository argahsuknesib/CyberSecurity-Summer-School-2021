package _m_j;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.framework.plugin.rn.debug.LaunchRecordBean;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public final class fxi {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Gson f17372O000000o = new Gson();

    public static void O000000o(Map<String, Long> map) {
        long j;
        FileWriter fileWriter;
        Map<String, Long> map2 = map;
        long longValue = map2.get("plugin-load-time") != null ? map2.get("plugin-load-time").longValue() : 0;
        long longValue2 = map2.get("plugin-render-time") != null ? map2.get("plugin-render-time").longValue() : 0;
        long longValue3 = map2.get("plugin-start-time") != null ? map2.get("plugin-start-time").longValue() : 0;
        if (longValue > 0 && longValue2 > 0 && longValue3 > 0) {
            long j2 = (longValue3 - longValue) - longValue2;
            if (longValue <= 10000 && longValue2 <= 10000 && longValue3 <= 10000 && j2 <= 10000) {
                PluginPackageInfo pluginPackageInfo = fwz.O000000o().O00000Oo().O0000OoO;
                PluginDeviceInfo pluginDeviceInfo = fwz.O000000o().O00000Oo().O0000Ooo;
                if (pluginPackageInfo != null && pluginDeviceInfo != null) {
                    StringBuilder sb = new StringBuilder(80);
                    sb.append(pluginDeviceInfo.O00000Oo());
                    sb.append("-plugin.");
                    sb.append(pluginPackageInfo.O000000o());
                    sb.append(".");
                    sb.append(pluginPackageInfo.O00000Oo());
                    String sb2 = sb.toString();
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("plugin-load-time", Long.valueOf(longValue));
                    jsonObject.addProperty("plugin-render-time", Long.valueOf(longValue2));
                    jsonObject.addProperty("plugin-start-time", Long.valueOf(longValue3));
                    jsonObject.addProperty("init-time", Long.valueOf(j2));
                    jsonObject.addProperty("hot-launch", Boolean.TRUE);
                    boolean z = false;
                    if ((gfr.f17662O000000o || gfr.O0000Oo || gfr.O0000o0o) && gsd.O000000o(CommonApplication.getAppContext())) {
                        z = true;
                    }
                    if (z) {
                        LaunchRecordBean O000000o2 = O000000o();
                        Map<String, JsonArray> details = O000000o2.getDetails();
                        JsonArray jsonArray = details != null ? details.get(sb2) : null;
                        if (jsonArray == null) {
                            jsonArray = new JsonArray();
                        }
                        jsonArray.add(jsonObject);
                        long asLong = jsonObject.get("init-time").getAsLong();
                        long asLong2 = jsonObject.get("plugin-start-time").getAsLong();
                        boolean asBoolean = jsonObject.get("hot-launch").getAsBoolean();
                        float f = O000000o2.get_00_init_time();
                        long j3 = O000000o2.get_00_cold_launch_times();
                        long j4 = O000000o2.get_00_hot_launch_times();
                        long j5 = j4 + j3;
                        float f2 = O000000o2.get_00_plugin_open_time();
                        String str = O000000o2.get_00_device_model();
                        float f3 = (float) j5;
                        long j6 = j3;
                        float f4 = (float) (j5 + 1);
                        O000000o2.addDetails(sb2, jsonArray);
                        O000000o2.set_00_init_time((((f * f3) + ((float) asLong)) * 1.0f) / f4);
                        O000000o2.set_00_plugin_open_time((((f2 * f3) + ((float) asLong2)) * 1.0f) / f4);
                        if (asBoolean) {
                            j4++;
                            O000000o2.set_00_hot_launch_times(j4);
                            j = j6;
                        } else {
                            j = j6 + 1;
                            O000000o2.set_00_cold_launch_times(j);
                        }
                        if (j > 0 && j4 > 0) {
                            O000000o2.set_00_hotCold_ratio((((float) j4) * 1.0f) / ((float) j));
                        }
                        if (TextUtils.isEmpty(str)) {
                            O000000o2.set_00_device_model(Build.MODEL);
                        }
                        String json = f17372O000000o.toJson(O000000o2);
                        File file = new File(CommonApplication.getAppContext().getExternalFilesDir("launchRecord"), "rn-plugin-launch-perf-tracer.json");
                        if (file.exists()) {
                            file.delete();
                        }
                        try {
                            file.createNewFile();
                            fileWriter = new FileWriter(file);
                            try {
                                fileWriter.write(json);
                                fileWriter.flush();
                                fileWriter.close();
                                gsc.O000000o(fileWriter);
                            } catch (IOException e) {
                                e = e;
                                try {
                                    gsy.O00000Oo("RnLaunchPerfTracer", "exportAsFile error:" + Log.getStackTraceString(e));
                                    gsc.O000000o(fileWriter);
                                } catch (Throwable th) {
                                    th = th;
                                    gsc.O000000o(fileWriter);
                                    throw th;
                                }
                            }
                        } catch (IOException e2) {
                            e = e2;
                            fileWriter = null;
                            gsy.O00000Oo("RnLaunchPerfTracer", "exportAsFile error:" + Log.getStackTraceString(e));
                            gsc.O000000o(fileWriter);
                        } catch (Throwable th2) {
                            th = th2;
                            fileWriter = null;
                            gsc.O000000o(fileWriter);
                            throw th;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.io.InputStreamReader} */
    /* JADX WARNING: Multi-variable type inference failed */
    private static LaunchRecordBean O000000o() {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        IOException e;
        InputStreamReader inputStreamReader2;
        LaunchRecordBean launchRecordBean = new LaunchRecordBean();
        File file = new File(CommonApplication.getAppContext().getExternalFilesDir("launchRecord"), "rn-plugin-launch-perf-tracer.json");
        if (!file.exists()) {
            return launchRecordBean;
        }
        Closeable closeable = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
            } catch (IOException e2) {
                e = e2;
                inputStreamReader2 = null;
                e = e;
                inputStreamReader = inputStreamReader2;
                bufferedReader = inputStreamReader2;
                try {
                    e.printStackTrace();
                    gsc.O000000o(inputStreamReader);
                    gsc.O000000o(bufferedReader);
                    gsc.O000000o((Closeable) fileInputStream);
                    return launchRecordBean;
                } catch (Throwable th) {
                    th = th;
                    closeable = bufferedReader;
                    gsc.O000000o(inputStreamReader);
                    gsc.O000000o(closeable);
                    gsc.O000000o((Closeable) fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
                gsc.O000000o(inputStreamReader);
                gsc.O000000o(closeable);
                gsc.O000000o((Closeable) fileInputStream);
                throw th;
            }
            try {
                BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                try {
                    LaunchRecordBean launchRecordBean2 = (LaunchRecordBean) f17372O000000o.fromJson(bufferedReader2.readLine(), LaunchRecordBean.class);
                    gsc.O000000o(inputStreamReader);
                    gsc.O000000o(bufferedReader2);
                    gsc.O000000o((Closeable) fileInputStream);
                    return launchRecordBean2;
                } catch (IOException e3) {
                    e = e3;
                    bufferedReader = bufferedReader2;
                    e.printStackTrace();
                    gsc.O000000o(inputStreamReader);
                    gsc.O000000o(bufferedReader);
                    gsc.O000000o((Closeable) fileInputStream);
                    return launchRecordBean;
                }
            } catch (IOException e4) {
                IOException iOException = e4;
                bufferedReader = null;
                e = iOException;
                e.printStackTrace();
                gsc.O000000o(inputStreamReader);
                gsc.O000000o(bufferedReader);
                gsc.O000000o((Closeable) fileInputStream);
                return launchRecordBean;
            } catch (Throwable th3) {
                th = th3;
                gsc.O000000o(inputStreamReader);
                gsc.O000000o(closeable);
                gsc.O000000o((Closeable) fileInputStream);
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            fileInputStream = null;
            inputStreamReader2 = null;
            e = e;
            inputStreamReader = inputStreamReader2;
            bufferedReader = inputStreamReader2;
            e.printStackTrace();
            gsc.O000000o(inputStreamReader);
            gsc.O000000o(bufferedReader);
            gsc.O000000o((Closeable) fileInputStream);
            return launchRecordBean;
        } catch (Throwable th4) {
            th = th4;
            inputStreamReader = null;
            fileInputStream = null;
            gsc.O000000o(inputStreamReader);
            gsc.O000000o(closeable);
            gsc.O000000o((Closeable) fileInputStream);
            throw th;
        }
    }
}

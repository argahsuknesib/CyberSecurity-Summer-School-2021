package com.xiaomi.smarthome;

import _m_j.fkw;
import _m_j.gfr;
import _m_j.goq;
import _m_j.gow;
import _m_j.gpy;
import _m_j.gsc;
import _m_j.gsf;
import _m_j.gsg;
import _m_j.gsj;
import _m_j.gsl;
import _m_j.gsy;
import _m_j.hsk;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.concurrent.Executor;
import okhttp3.Call;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class AppConfigHelper {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Context f4002O000000o = CommonApplication.getAppContext();
    private final Executor O00000Oo = goq.O000000o();

    public static abstract class O000000o extends gsl<String, gsf> {
        /* renamed from: O000000o */
        public void onSuccess(String str, Response response) {
        }

        public final void processFailure(Call call, IOException iOException) {
        }

        public final void processResponse(Response response) {
        }
    }

    public interface O00000Oo {
        boolean O000000o(String str) throws Exception;

        boolean O00000Oo(String str) throws Exception;
    }

    public static void O000000o() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    static {
        if (gfr.O0000OOo || gfr.O0000Oo) {
            gfr.O0000oo0 = gpy.O00000o0(CommonApplication.getAppContext(), "appconfig_cache", "debug_use_preview_appconfig", false);
        }
    }

    public AppConfigHelper(Context context) {
    }

    public final void O000000o(String str, String str2, String str3, String str4, O000000o o000000o) {
        O000000o(str, str2, str3, str4, o000000o, this.O00000Oo);
    }

    public final void O000000o(String str, String str2, String str3, String str4, final O000000o o000000o, Executor executor) {
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final O000000o o000000o2 = o000000o;
        O000000o(str, str2, str3, str4, new O00000Oo() {
            /* class com.xiaomi.smarthome.AppConfigHelper.AnonymousClass1 */

            public final boolean O000000o(String str) throws Exception {
                if (!AppConfigHelper.O000000o(str)) {
                    return false;
                }
                LogType logType = LogType.GENERAL;
                gsy.O00000o0(logType, "AppConfigHelper", "requestConfigWitchCache JsonAsyncHandler processCache " + str5 + str6 + str7);
                O000000o o000000o = o000000o2;
                if (o000000o == null) {
                    return true;
                }
                o000000o.sendSuccessMessage(str, new Response.Builder().code(200).request(new Request.Builder().url(hsk.O000000o(CommonApplication.getAppContext())).build()).protocol(Protocol.HTTP_2).message("").build());
                return true;
            }

            public final boolean O00000Oo(String str) throws Exception {
                return O000000o(str);
            }
        }, new O000000o() {
            /* class com.xiaomi.smarthome.AppConfigHelper.AnonymousClass2 */

            /* renamed from: O000000o */
            public final void onSuccess(String str, Response response) {
                O000000o o000000o;
                if (AppConfigHelper.O000000o(str) && (o000000o = o000000o) != null) {
                    o000000o.onSuccess(str, response);
                }
            }

            public final void onFailure(gsf gsf, Exception exc, Response response) {
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.onFailure(gsf, exc, response);
                }
                LogType logType = LogType.GENERAL;
                gsy.O00000o0(logType, "AppConfigHelper", "requestConfigWitchCache JsonAsyncHandler onFailure" + Log.getStackTraceString(exc));
            }
        }, executor);
    }

    public final void O000000o(String str, String str2, String str3, String str4, O00000Oo o00000Oo, O000000o o000000o) {
        O000000o(str, str2, str3, str4, o00000Oo, o000000o, this.O00000Oo);
    }

    public final void O000000o(String str, String str2, String str3, String str4, O00000Oo o00000Oo, O000000o o000000o, Executor executor) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(gfr.O0000oo0 ? "_preview" : "");
        sb.append("_");
        final String str5 = str2;
        sb.append(str2);
        sb.append("_");
        final String str6 = str3;
        sb.append(str3);
        final String sb2 = sb.toString();
        gsy.O00000Oo("AppConfigHelper", "requestConfigWitchCache:".concat(String.valueOf(sb2)));
        final O00000Oo o00000Oo2 = o00000Oo;
        final String str7 = str;
        final String str8 = str4;
        final O000000o o000000o2 = o000000o;
        executor.execute(new Runnable() {
            /* class com.xiaomi.smarthome.AppConfigHelper.AnonymousClass3 */

            /* JADX WARNING: Removed duplicated region for block: B:39:0x00f4 A[Catch:{ Exception -> 0x0105 }] */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x00f6 A[Catch:{ Exception -> 0x0105 }] */
            public final void run() {
                final String str;
                InputStream inputStream;
                byte[] O000000o2;
                final File file = new File(AppConfigHelper.this.f4002O000000o.getFilesDir() + File.separator + "appconfig_cache" + hsk.O000000o(CommonApplication.getAppContext()).hashCode() + File.separator + sb2);
                if (file.exists() && (O000000o2 = fkw.O000000o(file)) != null && O000000o2.length > 0) {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(O000000o2));
                        if (o00000Oo2.O000000o(AppConfigHelper.O000000o(str7, jSONObject))) {
                            str = AppConfigHelper.O000000o(jSONObject);
                            final boolean isEmpty = TextUtils.isEmpty(str);
                            gsg.O00000Oo(AppConfigHelper.O000000o(str7, str5, str6, isEmpty ? null : "1"), new gsl<String, gsf>() {
                                /* class com.xiaomi.smarthome.AppConfigHelper.AnonymousClass3.AnonymousClass1 */
                                private boolean O00000oO = isEmpty;

                                public final /* synthetic */ void onSuccess(Object obj, Response response) {
                                    try {
                                        o000000o2.onSuccess(AppConfigHelper.O000000o(str7, new JSONObject((String) obj)), response);
                                        gsy.O00000Oo("AppConfigHelper", "requestConfigWitchCache onSuccess:" + sb2);
                                    } catch (Exception e) {
                                        LogType logType = LogType.GENERAL;
                                        gsy.O00000o0(logType, "AppConfigHelper", "requestConfigWitchCache onSuccess catch:" + sb2 + Log.getStackTraceString(e));
                                        o000000o2.onFailure(new gsf(-1, "jsonParse JSONException"), e, response);
                                    }
                                }

                                public final void processResponse(Response response) {
                                    try {
                                        String string = response.body().string();
                                        JSONObject jSONObject = new JSONObject(string);
                                        String O000000o2 = AppConfigHelper.O000000o(jSONObject);
                                        String O000000o3 = AppConfigHelper.O000000o(str7, jSONObject);
                                        if (!this.O00000oO) {
                                            if (!AppConfigHelper.O000000o(O000000o3)) {
                                                if (TextUtils.equals(str, O000000o2)) {
                                                    o000000o2.sendSuccessMessage(O000000o3, response);
                                                    gsy.O00000Oo("AppConfigHelper", "requestConfigWitchCache file_url equal usercache:" + sb2 + " url:" + O000000o2);
                                                    return;
                                                }
                                                this.O00000oO = true;
                                                gsg.O00000Oo(AppConfigHelper.O000000o(str7, str5, str6, null), this);
                                                gsy.O00000Oo("AppConfigHelper", "requestConfigWitchCache cache invalid:" + sb2 + " newurl:" + O000000o2);
                                                return;
                                            }
                                        }
                                        o000000o2.sendSuccessMessage(O000000o3, response);
                                        gsy.O00000Oo("AppConfigHelper", "requestConfigWitchCache new data:" + sb2);
                                        fkw.O000000o(file, string.getBytes());
                                    } catch (Exception e) {
                                        o000000o2.sendFailureMessage(new gsf(-1, "parse Exception"), e, null);
                                        LogType logType = LogType.GENERAL;
                                        gsy.O00000o0(logType, "AppConfigHelper", "requestConfigWitchCache processFailure parsefail:" + sb2);
                                    }
                                }

                                public final void processFailure(Call call, IOException iOException) {
                                    o000000o2.sendFailureMessage(new gsf(-1, "processFailure"), iOException, null);
                                    LogType logType = LogType.GENERAL;
                                    gsy.O00000o0(logType, "AppConfigHelper", "requestConfigWitchCache processFailure IOException:" + sb2);
                                }

                                public final void onFailure(gsf gsf, Exception exc, Response response) {
                                    o000000o2.onFailure(gsf, exc, response);
                                    LogType logType = LogType.GENERAL;
                                    gsy.O00000o0(logType, "AppConfigHelper", "requestConfigWitchCache onFailure:" + sb2);
                                }
                            });
                        }
                    } catch (Throwable th) {
                        gsy.O00000o0(LogType.GENERAL, "AppConfigHelper", Log.getStackTraceString(th));
                    }
                } else if (!TextUtils.isEmpty(str8)) {
                    try {
                        inputStream = CommonApplication.getAppContext().getAssets().open(str8);
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = null;
                        gow.O00000Oo(inputStream);
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[inputStream.available()];
                        inputStream.read(bArr);
                        JSONObject jSONObject2 = new JSONObject(new String(bArr, Charset.forName("UTF-8")));
                        String O000000o3 = o00000Oo2.O00000Oo(AppConfigHelper.O000000o(str7, jSONObject2)) ? AppConfigHelper.O000000o(jSONObject2) : null;
                        gow.O00000Oo(inputStream);
                        str = O000000o3;
                    } catch (Throwable th3) {
                        th = th3;
                        gsy.O00000o0(LogType.GENERAL, "AppConfigHelper", Log.getStackTraceString(th));
                        gow.O00000Oo(inputStream);
                        str = null;
                        final boolean isEmpty2 = TextUtils.isEmpty(str);
                        gsg.O00000Oo(AppConfigHelper.O000000o(str7, str5, str6, isEmpty2 ? null : "1"), new gsl<String, gsf>() {
                            /* class com.xiaomi.smarthome.AppConfigHelper.AnonymousClass3.AnonymousClass1 */
                            private boolean O00000oO = isEmpty2;

                            public final /* synthetic */ void onSuccess(Object obj, Response response) {
                                try {
                                    o000000o2.onSuccess(AppConfigHelper.O000000o(str7, new JSONObject((String) obj)), response);
                                    gsy.O00000Oo("AppConfigHelper", "requestConfigWitchCache onSuccess:" + sb2);
                                } catch (Exception e) {
                                    LogType logType = LogType.GENERAL;
                                    gsy.O00000o0(logType, "AppConfigHelper", "requestConfigWitchCache onSuccess catch:" + sb2 + Log.getStackTraceString(e));
                                    o000000o2.onFailure(new gsf(-1, "jsonParse JSONException"), e, response);
                                }
                            }

                            public final void processResponse(Response response) {
                                try {
                                    String string = response.body().string();
                                    JSONObject jSONObject = new JSONObject(string);
                                    String O000000o2 = AppConfigHelper.O000000o(jSONObject);
                                    String O000000o3 = AppConfigHelper.O000000o(str7, jSONObject);
                                    if (!this.O00000oO) {
                                        if (!AppConfigHelper.O000000o(O000000o3)) {
                                            if (TextUtils.equals(str, O000000o2)) {
                                                o000000o2.sendSuccessMessage(O000000o3, response);
                                                gsy.O00000Oo("AppConfigHelper", "requestConfigWitchCache file_url equal usercache:" + sb2 + " url:" + O000000o2);
                                                return;
                                            }
                                            this.O00000oO = true;
                                            gsg.O00000Oo(AppConfigHelper.O000000o(str7, str5, str6, null), this);
                                            gsy.O00000Oo("AppConfigHelper", "requestConfigWitchCache cache invalid:" + sb2 + " newurl:" + O000000o2);
                                            return;
                                        }
                                    }
                                    o000000o2.sendSuccessMessage(O000000o3, response);
                                    gsy.O00000Oo("AppConfigHelper", "requestConfigWitchCache new data:" + sb2);
                                    fkw.O000000o(file, string.getBytes());
                                } catch (Exception e) {
                                    o000000o2.sendFailureMessage(new gsf(-1, "parse Exception"), e, null);
                                    LogType logType = LogType.GENERAL;
                                    gsy.O00000o0(logType, "AppConfigHelper", "requestConfigWitchCache processFailure parsefail:" + sb2);
                                }
                            }

                            public final void processFailure(Call call, IOException iOException) {
                                o000000o2.sendFailureMessage(new gsf(-1, "processFailure"), iOException, null);
                                LogType logType = LogType.GENERAL;
                                gsy.O00000o0(logType, "AppConfigHelper", "requestConfigWitchCache processFailure IOException:" + sb2);
                            }

                            public final void onFailure(gsf gsf, Exception exc, Response response) {
                                o000000o2.onFailure(gsf, exc, response);
                                LogType logType = LogType.GENERAL;
                                gsy.O00000o0(logType, "AppConfigHelper", "requestConfigWitchCache onFailure:" + sb2);
                            }
                        });
                    }
                    final boolean isEmpty22 = TextUtils.isEmpty(str);
                    gsg.O00000Oo(AppConfigHelper.O000000o(str7, str5, str6, isEmpty22 ? null : "1"), new gsl<String, gsf>() {
                        /* class com.xiaomi.smarthome.AppConfigHelper.AnonymousClass3.AnonymousClass1 */
                        private boolean O00000oO = isEmpty22;

                        public final /* synthetic */ void onSuccess(Object obj, Response response) {
                            try {
                                o000000o2.onSuccess(AppConfigHelper.O000000o(str7, new JSONObject((String) obj)), response);
                                gsy.O00000Oo("AppConfigHelper", "requestConfigWitchCache onSuccess:" + sb2);
                            } catch (Exception e) {
                                LogType logType = LogType.GENERAL;
                                gsy.O00000o0(logType, "AppConfigHelper", "requestConfigWitchCache onSuccess catch:" + sb2 + Log.getStackTraceString(e));
                                o000000o2.onFailure(new gsf(-1, "jsonParse JSONException"), e, response);
                            }
                        }

                        public final void processResponse(Response response) {
                            try {
                                String string = response.body().string();
                                JSONObject jSONObject = new JSONObject(string);
                                String O000000o2 = AppConfigHelper.O000000o(jSONObject);
                                String O000000o3 = AppConfigHelper.O000000o(str7, jSONObject);
                                if (!this.O00000oO) {
                                    if (!AppConfigHelper.O000000o(O000000o3)) {
                                        if (TextUtils.equals(str, O000000o2)) {
                                            o000000o2.sendSuccessMessage(O000000o3, response);
                                            gsy.O00000Oo("AppConfigHelper", "requestConfigWitchCache file_url equal usercache:" + sb2 + " url:" + O000000o2);
                                            return;
                                        }
                                        this.O00000oO = true;
                                        gsg.O00000Oo(AppConfigHelper.O000000o(str7, str5, str6, null), this);
                                        gsy.O00000Oo("AppConfigHelper", "requestConfigWitchCache cache invalid:" + sb2 + " newurl:" + O000000o2);
                                        return;
                                    }
                                }
                                o000000o2.sendSuccessMessage(O000000o3, response);
                                gsy.O00000Oo("AppConfigHelper", "requestConfigWitchCache new data:" + sb2);
                                fkw.O000000o(file, string.getBytes());
                            } catch (Exception e) {
                                o000000o2.sendFailureMessage(new gsf(-1, "parse Exception"), e, null);
                                LogType logType = LogType.GENERAL;
                                gsy.O00000o0(logType, "AppConfigHelper", "requestConfigWitchCache processFailure parsefail:" + sb2);
                            }
                        }

                        public final void processFailure(Call call, IOException iOException) {
                            o000000o2.sendFailureMessage(new gsf(-1, "processFailure"), iOException, null);
                            LogType logType = LogType.GENERAL;
                            gsy.O00000o0(logType, "AppConfigHelper", "requestConfigWitchCache processFailure IOException:" + sb2);
                        }

                        public final void onFailure(gsf gsf, Exception exc, Response response) {
                            o000000o2.onFailure(gsf, exc, response);
                            LogType logType = LogType.GENERAL;
                            gsy.O00000o0(logType, "AppConfigHelper", "requestConfigWitchCache onFailure:" + sb2);
                        }
                    });
                }
                str = null;
                final boolean isEmpty222 = TextUtils.isEmpty(str);
                try {
                    gsg.O00000Oo(AppConfigHelper.O000000o(str7, str5, str6, isEmpty222 ? null : "1"), new gsl<String, gsf>() {
                        /* class com.xiaomi.smarthome.AppConfigHelper.AnonymousClass3.AnonymousClass1 */
                        private boolean O00000oO = isEmpty222;

                        public final /* synthetic */ void onSuccess(Object obj, Response response) {
                            try {
                                o000000o2.onSuccess(AppConfigHelper.O000000o(str7, new JSONObject((String) obj)), response);
                                gsy.O00000Oo("AppConfigHelper", "requestConfigWitchCache onSuccess:" + sb2);
                            } catch (Exception e) {
                                LogType logType = LogType.GENERAL;
                                gsy.O00000o0(logType, "AppConfigHelper", "requestConfigWitchCache onSuccess catch:" + sb2 + Log.getStackTraceString(e));
                                o000000o2.onFailure(new gsf(-1, "jsonParse JSONException"), e, response);
                            }
                        }

                        public final void processResponse(Response response) {
                            try {
                                String string = response.body().string();
                                JSONObject jSONObject = new JSONObject(string);
                                String O000000o2 = AppConfigHelper.O000000o(jSONObject);
                                String O000000o3 = AppConfigHelper.O000000o(str7, jSONObject);
                                if (!this.O00000oO) {
                                    if (!AppConfigHelper.O000000o(O000000o3)) {
                                        if (TextUtils.equals(str, O000000o2)) {
                                            o000000o2.sendSuccessMessage(O000000o3, response);
                                            gsy.O00000Oo("AppConfigHelper", "requestConfigWitchCache file_url equal usercache:" + sb2 + " url:" + O000000o2);
                                            return;
                                        }
                                        this.O00000oO = true;
                                        gsg.O00000Oo(AppConfigHelper.O000000o(str7, str5, str6, null), this);
                                        gsy.O00000Oo("AppConfigHelper", "requestConfigWitchCache cache invalid:" + sb2 + " newurl:" + O000000o2);
                                        return;
                                    }
                                }
                                o000000o2.sendSuccessMessage(O000000o3, response);
                                gsy.O00000Oo("AppConfigHelper", "requestConfigWitchCache new data:" + sb2);
                                fkw.O000000o(file, string.getBytes());
                            } catch (Exception e) {
                                o000000o2.sendFailureMessage(new gsf(-1, "parse Exception"), e, null);
                                LogType logType = LogType.GENERAL;
                                gsy.O00000o0(logType, "AppConfigHelper", "requestConfigWitchCache processFailure parsefail:" + sb2);
                            }
                        }

                        public final void processFailure(Call call, IOException iOException) {
                            o000000o2.sendFailureMessage(new gsf(-1, "processFailure"), iOException, null);
                            LogType logType = LogType.GENERAL;
                            gsy.O00000o0(logType, "AppConfigHelper", "requestConfigWitchCache processFailure IOException:" + sb2);
                        }

                        public final void onFailure(gsf gsf, Exception exc, Response response) {
                            o000000o2.onFailure(gsf, exc, response);
                            LogType logType = LogType.GENERAL;
                            gsy.O00000o0(logType, "AppConfigHelper", "requestConfigWitchCache onFailure:" + sb2);
                        }
                    });
                } catch (Exception e) {
                    gsy.O00000o0(LogType.GENERAL, "AppConfigHelper", "requestConfigWitchCache Exception:" + sb2);
                    o000000o2.sendFailureMessage(new gsf(-1, "getRequest Exception"), e, null);
                }
            }
        });
    }

    public static String O000000o(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("result");
        if (optJSONObject == null) {
            return "";
        }
        return optJSONObject.optString("file_url");
    }

    public static String O000000o(String str, JSONObject jSONObject) throws IOException {
        if (!gfr.O0000Oo0) {
            String externalStorageState = Environment.getExternalStorageState();
            if (!"mounted".equals(externalStorageState)) {
                gsy.O000000o(4, "AppConfigHelper", "parseContent loadLocal getExternalStorageState: ".concat(String.valueOf(externalStorageState)));
            } else {
                File file = new File(Environment.getExternalStorageDirectory(), str);
                if (file.exists()) {
                    gsy.O000000o(4, "AppConfigHelper", "parseContent loadLocal:".concat(String.valueOf(file)));
                    return new String(gsc.O000000o(file));
                }
                gsy.O000000o(4, "AppConfigHelper", "parseContent loadLocal files:" + Arrays.toString(Environment.getExternalStorageDirectory().list()));
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("result");
        if (optJSONObject == null) {
            return null;
        }
        return optJSONObject.optString("content");
    }

    public static boolean O000000o(String str) {
        return str != null && !str.equals("") && !str.equals("null") && !str.equals("{}") && !str.equals("[]");
    }

    public static gsj O000000o(String str, String str2, String str3, String str4) throws JSONException, UnsupportedEncodingException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("lang", str3);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(gfr.O0000oo0 ? "_preview" : "");
        jSONObject.put("name", sb.toString());
        jSONObject.put("version", str2);
        if (str4 != null) {
            jSONObject.put("result_level", str4);
        }
        String str5 = hsk.O000000o(CommonApplication.getAppContext()) + "/app/service/getappconfig?data=" + URLEncoder.encode(jSONObject.toString(), "UTF-8");
        gsj.O000000o o000000o = new gsj.O000000o();
        o000000o.f18212O000000o = "GET";
        return o000000o.O00000Oo(str5).O000000o();
    }
}

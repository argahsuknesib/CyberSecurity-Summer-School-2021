package _m_j;

import _m_j.cbm;
import _m_j.cej;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.google.android.exoplayer2.C;
import com.google.gson.Gson;
import com.mi.global.shop.activity.MainTabActivity;
import com.mi.global.shop.activity.WebActivity;
import com.mi.global.shop.model.SyncModel;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.notice.NewNoticeData;
import com.mi.global.shop.newmodel.sync.NewSyncData;
import com.mi.global.shop.newmodel.sync.NewSyncResult;
import com.mi.global.shop.newmodel.sync.NewVersionInfoNote;
import com.mi.global.shop.newmodel.usercenter.NewUserInfoData;
import com.mi.util.Device;
import com.squareup.wire.Wire;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONObject;

public final class cbi {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f13589O000000o = (Environment.getExternalStorageDirectory() + "/com.mi.global.shop/");
    public static O000000o O00000Oo;

    public interface O000000o {
        void O000000o(boolean z);
    }

    public interface O00000o0 {
        void O000000o(NewNoticeData newNoticeData);
    }

    public static void O000000o(O000000o o000000o) {
        O00000Oo = o000000o;
    }

    public static void O000000o(Context context, JSONObject jSONObject) {
        if (jSONObject != null && context != null) {
            try {
                String optString = jSONObject.optString("url");
                long optLong = jSONObject.optLong("startTime");
                long optLong2 = jSONObject.optLong("endTime");
                int optInt = jSONObject.optInt("duration");
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                ccr.O00000Oo("SplashUtil", "url:" + optString + ",startTime:" + optLong + ",endTime:" + optLong2 + ",duration:" + optInt);
                if (!TextUtils.isEmpty(optString) && currentTimeMillis >= optLong && currentTimeMillis < optLong2) {
                    Intent intent = new Intent(context, WebActivity.class);
                    intent.putExtra("url", optString);
                    context.startActivity(intent);
                }
            } catch (Exception e) {
                e.printStackTrace();
                ccr.O00000Oo("SplashUtil", "ActivityConfig parse error" + e.toString());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    public static void O000000o(final Context context, final Runnable runnable, final O00000o0 o00000o0) {
        String str;
        Request request;
        try {
            ZipFile zipFile = new ZipFile(cdw.O00000Oo(context, context.getPackageName()));
            ZipEntry entry = zipFile.getEntry("META-INF/md5.txt");
            if (entry != null) {
                str = new BufferedReader(new InputStreamReader(zipFile.getInputStream(entry))).readLine();
                try {
                    System.out.println(str);
                } catch (IOException e) {
                    e = e;
                }
            } else {
                str = null;
            }
        } catch (IOException e2) {
            e = e2;
            str = null;
            e.printStackTrace();
            Uri.Builder buildUpon = Uri.parse(cav.O000Oo00()).buildUpon();
            StringBuilder sb = new StringBuilder();
            sb.append(Device.O0000oO0);
            buildUpon.appendQueryParameter("version", sb.toString());
            buildUpon.appendQueryParameter("channel", cat.O000000o(context));
            buildUpon.appendQueryParameter("md5", str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cej.O00000Oo.O000000o(context, "pref_hotfix_version", -1));
            buildUpon.appendQueryParameter("hotfixVersion", sb2.toString());
            if (!byl.O0000OoO()) {
            }
            request.setTag("SplashUtil");
            if (ced.f13683O000000o == null) {
            }
        }
        Uri.Builder buildUpon2 = Uri.parse(cav.O000Oo00()).buildUpon();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(Device.O0000oO0);
        buildUpon2.appendQueryParameter("version", sb3.toString());
        buildUpon2.appendQueryParameter("channel", cat.O000000o(context));
        buildUpon2.appendQueryParameter("md5", str);
        StringBuilder sb22 = new StringBuilder();
        sb22.append(cej.O00000Oo.O000000o(context, "pref_hotfix_version", -1));
        buildUpon2.appendQueryParameter("hotfixVersion", sb22.toString());
        if (!byl.O0000OoO()) {
            request = new cam(buildUpon2.toString(), NewSyncResult.class, new cak<NewSyncResult>() {
                /* class _m_j.cbi.AnonymousClass1 */

                public final /* synthetic */ void O000000o(BaseResult baseResult) {
                    NewSyncResult newSyncResult = (NewSyncResult) baseResult;
                    SyncModel.data = newSyncResult.data;
                    ccr.O00000Oo("SplashUtil", "get data:" + SyncModel.data);
                    try {
                        if (!(SyncModel.data == null || SyncModel.data.searchConf == null || cbi.O00000Oo == null)) {
                            cbi.O00000Oo.O000000o(SyncModel.data.searchConf.switchData);
                        }
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        JSONObject jSONObject3 = new JSONObject();
                        JSONObject jSONObject4 = new JSONObject();
                        JSONObject jSONObject5 = new JSONObject();
                        if (SyncModel.data != null) {
                            if (SyncModel.data.versionInfo != null) {
                                jSONObject3.put("version", Wire.get(SyncModel.data.versionInfo.version, ""));
                                ccr.O00000Oo("SplashUtil", "get SyncModel.data.versionInfo.notes:" + SyncModel.data.versionInfo.notes);
                                JSONArray jSONArray = new JSONArray();
                                for (Iterator<NewVersionInfoNote> it = SyncModel.data.versionInfo.notes.iterator(); it.hasNext(); it = it) {
                                    JSONObject jSONObject6 = new JSONObject();
                                    jSONObject6.put("desc", Wire.get(it.next().desc, ""));
                                    jSONArray.put(jSONObject6);
                                }
                                jSONObject3.put("notes", jSONArray);
                                jSONObject3.put("url", Wire.get(SyncModel.data.versionInfo.url, ""));
                                jSONObject3.put("forceUpdate", Wire.get(Boolean.valueOf(SyncModel.data.versionInfo.forceUpdate), ""));
                                jSONObject3.put("versionCode", Wire.get(Integer.valueOf(SyncModel.data.versionInfo.versionCode), ""));
                                jSONObject3.put("patchUrl", Wire.get(SyncModel.data.versionInfo.patchUrl, ""));
                                jSONObject3.put("md5", Wire.get(SyncModel.data.versionInfo.md5, ""));
                                jSONObject3.put("hotfixUrl", Wire.get(SyncModel.data.versionInfo.hotfixUrl, ""));
                            }
                        }
                        jSONObject2.put("versionInfo", jSONObject3);
                        if (SyncModel.data != null) {
                            if (SyncModel.data.resurface != null) {
                                jSONObject5.put("switch", SyncModel.data.resurface.switch_);
                                jSONObject5.put("starttime", SyncModel.data.resurface.starttime);
                                jSONObject5.put("endtime", SyncModel.data.resurface.endtime);
                                jSONObject5.put("url", Wire.get(SyncModel.data.resurface.url, ""));
                                jSONObject5.put("md5", Wire.get(SyncModel.data.resurface.md5, ""));
                                jSONObject5.put("theme", Wire.get(SyncModel.data.resurface.theme, ""));
                                jSONObject5.put("duration", Wire.get(Integer.valueOf(SyncModel.data.resurface.duration), ""));
                            }
                        }
                        jSONObject2.put("resurface", jSONObject5);
                        if (SyncModel.data.packageInfo != null) {
                            jSONObject4.put("version", Wire.get(Integer.valueOf(SyncModel.data.packageInfo.version), ""));
                            jSONObject4.put("url", Wire.get(SyncModel.data.packageInfo.url, ""));
                        }
                        jSONObject2.put("packageInfo", jSONObject4);
                        jSONObject2.put("download", new JSONArray((Collection<?>) SyncModel.data.download));
                        jSONObject.put("data", jSONObject2);
                        SyncModel.response = jSONObject;
                        ccr.O00000Oo("SplashUtil", "parse SyncModel.response to JSON:" + SyncModel.response.toString());
                        if (!(SyncModel.data == null || SyncModel.data.inBrowserUrls == null)) {
                            SyncModel.inBrowserUrls = (String[]) SyncModel.data.inBrowserUrls.toArray(new String[SyncModel.data.inBrowserUrls.size()]);
                            ccr.O00000Oo("SplashUtil", "SyncModel.inBrowserUrls:" + SyncModel.inBrowserUrls);
                        }
                        if (!(SyncModel.data == null || SyncModel.data.inHardAccelerUrls == null)) {
                            SyncModel.inHardAccelerUrls = (String[]) SyncModel.data.inHardAccelerUrls.toArray(new String[SyncModel.data.inHardAccelerUrls.size()]);
                            ccr.O00000Oo("SplashUtil", "SyncModel.inHardAccelerUrls:" + SyncModel.inHardAccelerUrls.toString());
                        }
                        if (!(SyncModel.data == null || SyncModel.data.inSoftWareUrls == null)) {
                            SyncModel.inSoftWareUrls = (String[]) SyncModel.data.inSoftWareUrls.toArray(new String[SyncModel.data.inSoftWareUrls.size()]);
                        }
                        if (!(SyncModel.data == null || SyncModel.data.switchInfo == null)) {
                            SyncModel.hardwareAccelerateModel = SyncModel.data.switchInfo.hardwareAccelerateModel;
                        }
                        if (!(SyncModel.data == null || SyncModel.data.inAppUrls == null)) {
                            SyncModel.inAppUrls = (String[]) SyncModel.data.inAppUrls.toArray(new String[SyncModel.data.inAppUrls.size()]);
                            ccr.O00000Oo("SplashUtil", "SyncModel.inAppUrls:" + SyncModel.inAppUrls.toString());
                        }
                        if (!(SyncModel.data == null || SyncModel.data.centralHeader == null)) {
                            cbm.O00000o0.O000000o(context, "pref_user_central_header_bg", (String) Wire.get(SyncModel.data.centralHeader.userCentralHeaderBg, ""));
                            cbm.O00000o0.O000000o(context, "pref_user_central_title_color", (String) Wire.get(SyncModel.data.centralHeader.userCentralHeaderTitleColor, ""));
                        }
                        if (SyncModel.data.pagemsg != null) {
                            SyncModel.userCenterPageMessage = SyncModel.data.pagemsg;
                            if (context instanceof MainTabActivity) {
                                ((MainTabActivity) context).showPageNotice(SyncModel.userCenterPageMessage);
                            }
                        }
                        if (!(SyncModel.data == null || SyncModel.data.notice == null || o00000o0 == null)) {
                            o00000o0.O000000o(SyncModel.data.notice);
                        }
                        if (SyncModel.data != null) {
                            NewSyncData newSyncData = SyncModel.data;
                        }
                        if (!(SyncModel.data == null || SyncModel.data.passPortInfo == null || !SyncModel.data.passPortInfo.tokenInvalid)) {
                            ccn.O0000o00().O0000Oo();
                            cec.O000000o(byl.O00000oO(), SyncModel.data.passPortInfo.errInfo, 0);
                        }
                        if (!(SyncModel.data == null || SyncModel.data.switchInfo == null)) {
                            cbm.O00000o0.O00000Oo(context, "pref_key_using_go_mifile_host_swtich", SyncModel.data.switchInfo.usingGoMifileHostSwitch);
                        }
                        if (SyncModel.data != null) {
                            if (SyncModel.data.startPage != null) {
                                JSONObject jSONObject7 = new JSONObject();
                                jSONObject7.put("startTime", SyncModel.data.startPage.startTime);
                                jSONObject7.put("endTime", SyncModel.data.startPage.endTime);
                                jSONObject7.put("url", Wire.get(SyncModel.data.startPage.url, ""));
                                jSONObject7.put("img", Wire.get(SyncModel.data.startPage.img, ""));
                                jSONObject7.put("gif", Wire.get(SyncModel.data.startPage.gif, ""));
                                jSONObject7.put("duration", Wire.get(Integer.valueOf(SyncModel.data.startPage.duration), ""));
                                if (!jSONObject7.toString().equals(cbm.O00000o0.O00000Oo(byl.O00000oO(), "pref_key_splash_info", ""))) {
                                    new O00000Oo(jSONObject7).start();
                                }
                            }
                            if (SyncModel.data.cacheConfig != null) {
                                JSONObject jSONObject8 = new JSONObject();
                                jSONObject8.put("enable", SyncModel.data.cacheConfig.enable);
                                jSONObject8.put("js", SyncModel.data.cacheConfig.js);
                                jSONObject8.put("css", SyncModel.data.cacheConfig.css);
                                jSONObject8.put("html", SyncModel.data.cacheConfig.html);
                                cbm.O00000o0.O000000o(byl.O00000oO(), "pref_key_cache_config", jSONObject8.toString());
                            }
                            if (SyncModel.data.activityConfig != null) {
                                JSONObject jSONObject9 = new JSONObject();
                                jSONObject9.put("url", Wire.get(SyncModel.data.activityConfig.url, ""));
                                jSONObject9.put("startTime", SyncModel.data.activityConfig.startTime);
                                jSONObject9.put("endTime", SyncModel.data.activityConfig.endTime);
                                jSONObject9.put("duration", SyncModel.data.activityConfig.duration);
                                cbi.O000000o(context, jSONObject9);
                            }
                            if (SyncModel.data.pushTypeList != null) {
                                cbm.O00000o0.O000000o(byl.O00000oO(), "pref_key_push_classify_data", new Gson().toJson(SyncModel.data.pushTypeList));
                            } else {
                                cbm.O00000o0.O000000o(byl.O00000oO(), "pref_key_push_classify_data", "");
                            }
                        }
                        if (newSyncResult.data.httpsModel != null) {
                            cbm.O00000o0.O00000Oo(context, "pref_key_https_request", newSyncResult.data.httpsModel.api);
                            cbm.O00000o0.O00000Oo(context, "pref_key_https_image_request", newSyncResult.data.httpsModel.file);
                            cbm.O00000o0.O00000Oo(context, "pref_key_https_webview_url_request", newSyncResult.data.httpsModel.page);
                            byl.O00000o0 = newSyncResult.data.httpsModel.api;
                            byl.O00000o = newSyncResult.data.httpsModel.file;
                            byl.O00000oO = newSyncResult.data.httpsModel.page;
                            cav.O000000o();
                        }
                    } catch (Exception e) {
                        ccr.O00000Oo("SplashUtil", "Exception:" + e.toString());
                    }
                    Runnable runnable = runnable;
                    if (runnable != null) {
                        runnable.run();
                    }
                }

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void
                 arg types: [android.content.Context, java.lang.String, int]
                 candidates:
                  _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, java.lang.String):java.lang.String
                  _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, int):void
                  _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void */
                public final void O000000o(String str) {
                    cbm.O00000o0.O00000Oo(context, "pref_key_using_go_mifile_host_swtich", false);
                    cav.O00000o();
                }
            });
        } else {
            SyncModel.response = null;
            request = new cah(buildUpon2.toString(), new Response.Listener<JSONObject>() {
                /* class _m_j.cbi.AnonymousClass2 */

                public final /* synthetic */ void onResponse(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    SyncModel.response = jSONObject;
                    if (jSONObject != null) {
                        try {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data").optJSONObject("searchConf");
                            if (!(optJSONObject == null || cbi.O00000Oo == null)) {
                                cbi.O00000Oo.O000000o(optJSONObject.optBoolean("switch"));
                            }
                            JSONArray optJSONArray = jSONObject.getJSONObject("data").optJSONArray("inBrowserUrls");
                            if (optJSONArray != null) {
                                String[] strArr = new String[optJSONArray.length()];
                                for (int i = 0; i < optJSONArray.length(); i++) {
                                    strArr[i] = optJSONArray.getString(i);
                                }
                                SyncModel.inBrowserUrls = strArr;
                            }
                            JSONArray optJSONArray2 = jSONObject.getJSONObject("data").optJSONArray("inAppUrls");
                            if (optJSONArray2 != null) {
                                String[] strArr2 = new String[optJSONArray2.length()];
                                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    strArr2[i2] = optJSONArray2.getString(i2);
                                }
                                SyncModel.inAppUrls = strArr2;
                            }
                            JSONArray optJSONArray3 = jSONObject.getJSONObject("data").optJSONArray("inHardAccelerUrls");
                            if (optJSONArray3 != null) {
                                String[] strArr3 = new String[optJSONArray3.length()];
                                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                                    strArr3[i3] = optJSONArray3.getString(i3);
                                }
                                SyncModel.inHardAccelerUrls = strArr3;
                            }
                            JSONArray optJSONArray4 = jSONObject.getJSONObject("data").optJSONArray("inSoftWareUrls");
                            if (optJSONArray4 != null) {
                                String[] strArr4 = new String[optJSONArray4.length()];
                                for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                                    strArr4[i4] = optJSONArray4.getString(i4);
                                }
                                SyncModel.inSoftWareUrls = strArr4;
                            }
                            JSONObject optJSONObject2 = jSONObject.getJSONObject("data").optJSONObject("switchInfo");
                            if (optJSONObject2 != null) {
                                SyncModel.hardwareAccelerateModel = optJSONObject2.optBoolean("hardwareAccelerateModel", true);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    ccr.O00000Oo("SplashUtil", "SyncModel.response=" + SyncModel.response);
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("data").getJSONObject("startPage");
                        if (!jSONObject2.toString().equals(cbm.O00000o0.O00000Oo(byl.O00000oO(), "pref_key_splash_info", ""))) {
                            new O00000Oo(jSONObject2).start();
                        }
                        JSONObject optJSONObject3 = jSONObject.optJSONObject("data").optJSONObject("cacheConfig");
                        if (optJSONObject3 != null && !TextUtils.isEmpty(optJSONObject3.toString())) {
                            cbm.O00000o0.O000000o(byl.O00000oO(), "pref_key_cache_config", optJSONObject3.toString());
                        }
                        JSONObject optJSONObject4 = jSONObject.optJSONObject("data").optJSONObject("activityConfig");
                        if (optJSONObject4 != null && !TextUtils.isEmpty(optJSONObject4.toString())) {
                            cbi.O000000o(context, optJSONObject4);
                        }
                        JSONObject optJSONObject5 = jSONObject.optJSONObject("data").optJSONObject("passPortInfo");
                        if (optJSONObject5 != null && optJSONObject5.optBoolean("tokenInvalid")) {
                            ccn.O0000o00().O0000Oo();
                            cec.O000000o(byl.O00000oO(), optJSONObject5.optString("errInfo"), 0);
                        }
                        Gson gson = new Gson();
                        String optString = jSONObject.getJSONObject("data").optString("messageContent");
                        if (!TextUtils.isEmpty(optString) && (context instanceof MainTabActivity)) {
                            ((MainTabActivity) context).showHomeNotice((NewNoticeData) gson.fromJson(optString, NewNoticeData.class));
                        }
                        String optString2 = jSONObject.getJSONObject("data").optString("refreshUserInfo");
                        if (!TextUtils.isEmpty(optString2) && (context instanceof MainTabActivity)) {
                            NewUserInfoData newUserInfoData = (NewUserInfoData) gson.fromJson(optString2, NewUserInfoData.class);
                            if (SyncModel.data == null) {
                                SyncModel.data = new NewSyncData();
                            }
                            SyncModel.data.userInfo = newUserInfoData;
                        }
                        JSONObject optJSONObject6 = jSONObject.optJSONObject("data").optJSONObject("https");
                        if (optJSONObject6 != null) {
                            boolean optBoolean = optJSONObject6.optBoolean("api");
                            boolean optBoolean2 = optJSONObject6.optBoolean("file");
                            boolean optBoolean3 = optJSONObject6.optBoolean("page");
                            cbm.O00000o0.O00000Oo(context, "pref_key_https_request", optBoolean);
                            cbm.O00000o0.O00000Oo(context, "pref_key_https_image_request", optBoolean2);
                            cbm.O00000o0.O00000Oo(context, "pref_key_https_webview_url_request", optBoolean3);
                            byl.O00000o0 = optBoolean;
                            byl.O00000o = optBoolean2;
                            byl.O00000oO = optBoolean3;
                            cav.O000000o();
                        }
                    } catch (Exception unused2) {
                        VolleyLog.d("SplashUtil", "JSON parse error");
                    }
                    Runnable runnable = runnable;
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            }, new Response.ErrorListener() {
                /* class _m_j.cbi.AnonymousClass3 */

                public final void onErrorResponse(VolleyError volleyError) {
                    VolleyLog.d("SplashUtil", "Error: " + volleyError.getMessage());
                }
            });
        }
        request.setTag("SplashUtil");
        if (ced.f13683O000000o == null) {
            ced.f13683O000000o.add(request);
        }
    }

    static class O00000Oo extends Thread {

        /* renamed from: O000000o  reason: collision with root package name */
        private JSONObject f13592O000000o;
        private String O00000Oo;

        public O00000Oo(JSONObject jSONObject) {
            this.f13592O000000o = jSONObject;
            this.O00000Oo = jSONObject.optString("gif");
            if (TextUtils.isEmpty(this.O00000Oo)) {
                this.O00000Oo = jSONObject.optString("img");
            }
        }

        private static boolean O000000o(byte[] bArr, String str, String str2) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str + str2)));
                bufferedOutputStream.write(bArr);
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                ccr.O00000Oo("SplashUtil", "save splash.jpg success");
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public final void run() {
            byte[] O000000o2 = cbi.O000000o(this.O00000Oo);
            if (O000000o2 != null && Environment.getExternalStorageState().equals("mounted") && O000000o(O000000o2, cbi.f13589O000000o, "splash.jpg")) {
                cbm.O00000o0.O000000o(byl.O00000oO(), "pref_key_splash_info", this.f13592O000000o.toString());
            }
        }
    }

    public static byte[] O000000o(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setReadTimeout(C.MSG_CUSTOM_BASE);
            httpURLConnection.setConnectTimeout(C.MSG_CUSTOM_BASE);
            return O000000o(httpURLConnection.getInputStream());
        } catch (Exception unused) {
            ccr.O00000Oo("SplashUtil", "failed to get splash.jpg");
            return null;
        }
    }

    private static byte[] O000000o(InputStream inputStream) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static void O000000o() {
        cbm.O00000o0.O00000Oo(byl.O00000oO(), "pref_key_splash_info");
        try {
            File file = new File(f13589O000000o + "splash.jpg");
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }
}

package com.mi.activity;

import _m_j.ccr;
import _m_j.cdu;
import _m_j.cea;
import _m_j.cec;
import _m_j.ced;
import _m_j.cej;
import _m_j.cem;
import _m_j.cep;
import _m_j.cpf;
import _m_j.ei;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.mi.model.UpdaterInfo;
import com.mi.util.AppUpdater;
import com.mi.util.Device;
import com.xiaomi.smarthome.R;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class BaseActivity extends AppCompatActivity {
    public static final String TAG = "BaseActivity";
    public long end;
    public boolean hasRener = false;
    protected AppUpdater mUpdater;
    protected long renderDuration;
    public long start;

    /* access modifiers changed from: protected */
    public void getRenderDuration() {
    }

    /* access modifiers changed from: protected */
    public String getUpdateUrl() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void installHotfix(String str) {
    }

    /* access modifiers changed from: protected */
    public Fragment newFragmentByTag(String str) {
        return null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.start = System.nanoTime();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, com.mi.activity.BaseActivity$1, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void setContentView(int i) {
        AnonymousClass1 r0 = new FrameLayout(this) {
            /* class com.mi.activity.BaseActivity.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public final void dispatchDraw(Canvas canvas) {
                super.dispatchDraw(canvas);
                if (!BaseActivity.this.hasRener) {
                    BaseActivity.this.end = System.nanoTime();
                    BaseActivity baseActivity = BaseActivity.this;
                    baseActivity.renderDuration = ((System.nanoTime() - BaseActivity.this.start) / 10000) / 100;
                    baseActivity.hasRener = true;
                    baseActivity.getRenderDuration();
                }
            }
        };
        getLayoutInflater().inflate(i, (ViewGroup) r0, true);
        setContentView(r0);
    }

    /* access modifiers changed from: protected */
    public void checkUpdate(final boolean z) {
        if (this.mUpdater == null) {
            this.mUpdater = new AppUpdater(this);
        }
        if (!z && !this.mUpdater.needCheck()) {
            return;
        }
        if (z) {
            cep cep = new cep(getUpdateUrl(), new Response.Listener<JSONObject>() {
                /* class com.mi.activity.BaseActivity.AnonymousClass2 */

                public final /* synthetic */ void onResponse(Object obj) {
                    BaseActivity.this.handleUpdateData(z, (JSONObject) obj);
                }
            }, new Response.ErrorListener() {
                /* class com.mi.activity.BaseActivity.AnonymousClass3 */

                public final void onErrorResponse(VolleyError volleyError) {
                    String str = BaseActivity.TAG;
                    VolleyLog.d(str, "Error: " + volleyError.getMessage());
                }
            });
            cep.setTag(TAG);
            ced.f13683O000000o.add(cep);
            return;
        }
        ccr.O00000Oo("Check update", "SyncModel.response=" + cdu.response);
        handleUpdateData(z, cdu.response);
    }

    public void handleUpdateData(boolean z, JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            String str = TAG;
            ccr.O00000Oo(str, "handleUpdateData Device.APP_VERSION:" + Device.O0000oO0);
            UpdaterInfo updaterInfo = null;
            if (jSONObject != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("versionInfo");
                    String optString = optJSONObject2.optString("version", null);
                    int optInt = optJSONObject2.optInt("versionCode");
                    String optString2 = optJSONObject2.optString("googleUrl");
                    String optString3 = optJSONObject2.optString("url", null);
                    cej.O00000Oo.O00000Oo(this, "versionCode", optInt);
                    String str2 = TAG;
                    ccr.O00000Oo(str2, "handleUpdateData Device.APP_VERSION:" + Device.O0000oO0 + ", versionCode:" + optInt);
                    if (optInt > Device.O0000oO0) {
                        UpdaterInfo updaterInfo2 = new UpdaterInfo();
                        updaterInfo2.O00000Oo = optString3;
                        updaterInfo2.O00000o0 = optJSONObject2.optString("md5", null);
                        updaterInfo2.O00000o = optJSONObject2.optString("patchUrl", null);
                        updaterInfo2.O00000oO = optString;
                        updaterInfo2.O00000oo = optInt;
                        updaterInfo2.O0000O0o = optJSONObject2.optBoolean("forceUpdate", false);
                        JSONArray optJSONArray = optJSONObject2.optJSONArray("notes");
                        updaterInfo2.O0000Oo = optString2;
                        ArrayList<UpdaterInfo.DescType> arrayList = new ArrayList<>();
                        if (optJSONArray != null) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                if (!optJSONArray.isNull(i) && (jSONObject2 = (JSONObject) optJSONArray.opt(i)) != null) {
                                    UpdaterInfo.DescType descType = new UpdaterInfo.DescType();
                                    descType.mDescType = jSONObject2.optString("type");
                                    descType.mDesc = jSONObject2.optString("desc");
                                    arrayList.add(descType);
                                }
                            }
                        }
                        updaterInfo2.f5088O000000o = arrayList;
                        updaterInfo = updaterInfo2;
                    }
                } else {
                    cej.O00000Oo.O000000o(this, "pref_last_update_is_ok", Long.valueOf(System.currentTimeMillis()));
                }
            }
            if (updaterInfo != null) {
                this.mUpdater.loadVersionLogAndPopDialog(updaterInfo);
            } else if (z) {
                cec.O000000o(this, (int) R.string.no_update, 0);
            }
        } catch (Exception unused) {
            VolleyLog.d(TAG, "JSON parse error");
        }
    }

    /* access modifiers changed from: protected */
    public void checkHotfix() {
        JSONObject optJSONObject;
        if (cdu.response != null && (optJSONObject = cdu.response.optJSONObject("data")) != null) {
            cpf.O000000o((Object) "checkHotfix data:".concat(String.valueOf(optJSONObject)));
            String optString = optJSONObject.optJSONObject("versionInfo").optString("hotfixUrl", null);
            if (!TextUtils.isEmpty(optString)) {
                cej.O00000Oo.O000000o(getApplicationContext(), "hotfix_url", optString);
                final String str = getExternalCacheDir().getAbsolutePath() + "/" + optString.substring(optString.lastIndexOf(47));
                cea cea = new cea(optString);
                try {
                    new File(str).getParentFile().mkdirs();
                } catch (Exception unused) {
                }
                cea.O00000oo = str;
                cea.O0000O0o = new cea.O000000o() {
                    /* class com.mi.activity.BaseActivity.AnonymousClass4 */

                    public final void O000000o() {
                        BaseActivity.this.installHotfix(str);
                    }
                };
                cea.O0000Oo0 = 0;
                cea.O0000OoO = new Thread() {
                    /* class _m_j.cea.AnonymousClass1 */

                    /* JADX INFO: additional move instructions added (1) to help type inference */
                    /* JADX WARN: Type inference failed for: r3v0 */
                    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.InputStream] */
                    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.RandomAccessFile] */
                    /* JADX WARN: Type inference failed for: r3v3 */
                    /* JADX WARN: Type inference failed for: r3v4 */
                    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.RandomAccessFile] */
                    /* JADX WARN: Type inference failed for: r3v6 */
                    /* JADX WARN: Type inference failed for: r3v7 */
                    /* JADX WARN: Type inference failed for: r3v8 */
                    /* JADX WARNING: Code restructure failed: missing block: B:169:0x029f, code lost:
                        r12 = r15;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01c2, code lost:
                        r0 = th;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01c3, code lost:
                        r3 = r8;
                        r12 = r15;
                     */
                    /* JADX WARNING: Failed to process nested try/catch */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:153:0x0281 */
                    /* JADX WARNING: Multi-variable type inference failed */
                    /* JADX WARNING: Removed duplicated region for block: B:156:0x0285 A[Catch:{ Throwable -> 0x029a, all -> 0x0298 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:159:0x028e A[SYNTHETIC, Splitter:B:159:0x028e] */
                    /* JADX WARNING: Removed duplicated region for block: B:162:0x0293 A[Catch:{ Exception -> 0x0297 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:170:? A[ExcHandler: Throwable (unused java.lang.Throwable), SYNTHETIC, Splitter:B:77:0x019e] */
                    /* JADX WARNING: Removed duplicated region for block: B:181:0x02af A[SYNTHETIC, Splitter:B:181:0x02af] */
                    /* JADX WARNING: Removed duplicated region for block: B:184:0x02b4 A[Catch:{ Exception -> 0x02b7 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:192:0x02bd A[SYNTHETIC, Splitter:B:192:0x02bd] */
                    /* JADX WARNING: Removed duplicated region for block: B:195:0x02c2 A[Catch:{ Exception -> 0x02c6 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:216:? A[RETURN, SYNTHETIC] */
                    /* JADX WARNING: Removed duplicated region for block: B:219:? A[RETURN, SYNTHETIC] */
                    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fd A[Catch:{ Throwable -> 0x02b8, all -> 0x02a9 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:45:0x0148 A[Catch:{ Throwable -> 0x02b8, all -> 0x02a9 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:56:0x016e A[Catch:{ Throwable -> 0x02b8, all -> 0x02a9 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:59:0x017b A[Catch:{ Throwable -> 0x02b9, all -> 0x02a5 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:63:0x0182 A[SYNTHETIC, Splitter:B:63:0x0182] */
                    /* JADX WARNING: Removed duplicated region for block: B:72:0x0194 A[SYNTHETIC, Splitter:B:72:0x0194] */
                    /* JADX WARNING: Unknown variable types count: 1 */
                    public final void run() {
                        RandomAccessFile randomAccessFile;
                        InputStream inputStream;
                        File file;
                        byte[] bArr;
                        cea cea = cea.this;
                        ? r3 = 0;
                        try {
                            Uri parse = Uri.parse(Uri.decode(cea.O00000oO));
                            StringBuilder sb = new StringBuilder();
                            if (parse.getScheme() != null) {
                                sb.append(parse.getScheme());
                                sb.append("://");
                            } else {
                                sb.append("/");
                            }
                            if (parse.getAuthority() != null) {
                                sb.append(Uri.encode(parse.getAuthority(), ":@"));
                            }
                            if (parse.getPath() != null) {
                                sb.append(Uri.encode(parse.getPath(), "/"));
                            }
                            if (parse.getQuery() != null) {
                                sb.append("?");
                                sb.append(Uri.encode(parse.getQuery(), "=&:/"));
                            }
                            if (parse.getFragment() != null) {
                                sb.append("#");
                                sb.append(Uri.encode(parse.getFragment()));
                            }
                            URL url = new URL(sb.toString());
                            if (cea.O00000o0 == 0) {
                                if (cea.O00000oo != null) {
                                    file = new File(cea.O00000oo + ".tmp");
                                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                                    httpURLConnection.setConnectTimeout(20000);
                                    httpURLConnection.setReadTimeout(60000);
                                    httpURLConnection.setRequestMethod(cea.O0000o);
                                    if (cea.O0000o0O || cea.O00000o0 != 0 || file == null || file.length() <= 0) {
                                        cea.O0000Oo0 = 0;
                                    } else {
                                        cea.O0000Oo0 = file.length();
                                        httpURLConnection.setRequestProperty("Range", "bytes=" + cea.O0000Oo0 + "-");
                                    }
                                    if (cea.O0000oO0 != null) {
                                        for (int i = 0; i < cea.O0000oO0.length; i += 2) {
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append(cea.O0000oO0[i + 0]);
                                            String sb3 = sb2.toString();
                                            StringBuilder sb4 = new StringBuilder();
                                            sb4.append(cea.O0000oO0[i + 1]);
                                            httpURLConnection.setRequestProperty(sb3, sb4.toString());
                                        }
                                    }
                                    httpURLConnection.setRequestProperty("Cache-Control", "no-cache");
                                    httpURLConnection.setRequestProperty("Pragma", "no-cache");
                                    httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
                                    if (cea.O0000o.equalsIgnoreCase("POST")) {
                                        httpURLConnection.setDoOutput(true);
                                    }
                                    httpURLConnection.connect();
                                    if (cea.O0000Oo0 > 0 && httpURLConnection.getResponseCode() != 206) {
                                        cea.O0000Oo0 = 0;
                                    }
                                    if (cea.O0000Oo0 == 0 && file != null) {
                                        file.delete();
                                        file.createNewFile();
                                    }
                                    if (file == null) {
                                        randomAccessFile = new RandomAccessFile(file, "rw");
                                        try {
                                            randomAccessFile.seek(cea.O0000Oo0);
                                        } catch (Throwable th) {
                                            th = th;
                                            inputStream = null;
                                            r3 = randomAccessFile;
                                            cea.O0000o0o = true;
                                            if (r3 != 0) {
                                                try {
                                                    r3.close();
                                                } catch (Exception unused) {
                                                    throw th;
                                                }
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            throw th;
                                        }
                                    } else {
                                        randomAccessFile = null;
                                    }
                                    if (!cea.O0000Ooo) {
                                        if (cea.O0000O0o != null) {
                                            new Exception("UserCannelled");
                                        }
                                        cea.O0000o0o = true;
                                        if (randomAccessFile != null) {
                                            try {
                                                randomAccessFile.close();
                                                return;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        inputStream = httpURLConnection.getInputStream();
                                        try {
                                            InputStream inputStream2 = inputStream;
                                            try {
                                                cea.O0000OOo = ((long) httpURLConnection.getContentLength()) + cea.O0000Oo0;
                                                if (cea.O0000OOo < 0) {
                                                    if (cea.O0000O0o != null) {
                                                        new Exception("error");
                                                        cea.O0000o0o = true;
                                                        if (randomAccessFile != null) {
                                                            try {
                                                                randomAccessFile.close();
                                                            } catch (Exception unused3) {
                                                                return;
                                                            }
                                                        }
                                                        if (inputStream2 != null) {
                                                            inputStream2.close();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                }
                                                if (cea.O00000o0 == 1) {
                                                    bArr = new byte[((int) cea.O0000OOo)];
                                                } else {
                                                    bArr = new byte[16384];
                                                }
                                                cea.O0000o0o = false;
                                                new Thread() {
                                                    /* class _m_j.cea.AnonymousClass2 */

                                                    /* renamed from: O000000o  reason: collision with root package name */
                                                    int f13680O000000o = 1000;

                                                    public final void run() {
                                                        while (!cea.this.O0000o0o) {
                                                            try {
                                                                Thread.sleep((long) this.f13680O000000o);
                                                            } catch (Exception unused) {
                                                            }
                                                            if (!cea.this.O0000o0o) {
                                                                O000000o o000000o = cea.this.O0000O0o;
                                                            }
                                                        }
                                                    }
                                                }.start();
                                                int i2 = 0;
                                                while (true) {
                                                    inputStream = inputStream2;
                                                    int read = inputStream.read(bArr, i2, bArr.length - i2);
                                                    if (read <= 0 || cea.O0000Oo0 >= cea.O0000OOo || cea.O0000Ooo) {
                                                        cea.O0000o0o = true;
                                                    } else {
                                                        if (randomAccessFile != null) {
                                                            randomAccessFile.write(bArr, 0, read);
                                                            i2 = 0;
                                                        } else {
                                                            i2 += read;
                                                        }
                                                        cea.O0000Oo0 += (long) read;
                                                        inputStream2 = inputStream;
                                                    }
                                                }
                                                cea.O0000o0o = true;
                                                if (cea.O0000Ooo) {
                                                    if (cea.O0000O0o != null) {
                                                        new Exception("UserCannelled");
                                                    }
                                                    cea.O0000o0o = true;
                                                    if (randomAccessFile != null) {
                                                        try {
                                                            randomAccessFile.close();
                                                        } catch (Exception unused4) {
                                                            return;
                                                        }
                                                    }
                                                    if (inputStream != null) {
                                                        inputStream.close();
                                                        return;
                                                    }
                                                    return;
                                                } else if (httpURLConnection.getResponseCode() >= 300) {
                                                    if (cea.O0000O0o != null) {
                                                        new Exception("error");
                                                    }
                                                    cea.O0000o0o = true;
                                                    if (randomAccessFile != null) {
                                                        try {
                                                            randomAccessFile.close();
                                                        } catch (Exception unused5) {
                                                            return;
                                                        }
                                                    }
                                                    if (inputStream != null) {
                                                        inputStream.close();
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    if (cea.O00000o0 == 1) {
                                                        cea.O00000o = new String(bArr);
                                                    }
                                                    if (randomAccessFile != null) {
                                                        randomAccessFile.close();
                                                        File file2 = new File(cea.O00000oo);
                                                        if (file2.exists()) {
                                                            file2.delete();
                                                        }
                                                        new File(cea.O00000oo + ".tmp").renameTo(file2);
                                                    } else {
                                                        r3 = randomAccessFile;
                                                    }
                                                    try {
                                                        if (cea.O0000O0o != null) {
                                                            cea.O0000O0o.O000000o();
                                                        }
                                                        cea.O0000o0o = true;
                                                        if (r3 != 0) {
                                                            try {
                                                                r3.close();
                                                            } catch (Exception unused6) {
                                                                return;
                                                            }
                                                        }
                                                        if (inputStream == null) {
                                                            inputStream.close();
                                                            return;
                                                        }
                                                        return;
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        r3 = r3;
                                                        cea.O0000o0o = true;
                                                        if (r3 != 0) {
                                                        }
                                                        if (inputStream != null) {
                                                        }
                                                        throw th;
                                                    }
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                inputStream = inputStream2;
                                                r3 = randomAccessFile;
                                                cea.O0000o0o = true;
                                                if (r3 != 0) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                throw th;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            r3 = randomAccessFile;
                                            cea.O0000o0o = true;
                                            if (r3 != 0) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            throw th;
                                        }
                                    }
                                }
                            }
                            file = null;
                            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                            httpURLConnection2.setConnectTimeout(20000);
                            httpURLConnection2.setReadTimeout(60000);
                            httpURLConnection2.setRequestMethod(cea.O0000o);
                            if (cea.O0000o0O) {
                            }
                            cea.O0000Oo0 = 0;
                            if (cea.O0000oO0 != null) {
                            }
                            httpURLConnection2.setRequestProperty("Cache-Control", "no-cache");
                            httpURLConnection2.setRequestProperty("Pragma", "no-cache");
                            httpURLConnection2.setRequestProperty("Accept-Encoding", "identity");
                            if (cea.O0000o.equalsIgnoreCase("POST")) {
                            }
                            httpURLConnection2.connect();
                            cea.O0000Oo0 = 0;
                            file.delete();
                            file.createNewFile();
                            if (file == null) {
                            }
                            if (!cea.O0000Ooo) {
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            inputStream = null;
                            cea.O0000o0o = true;
                            if (r3 != 0) {
                            }
                            if (inputStream != null) {
                            }
                            throw th;
                        }
                    }
                };
                cea.O0000OoO.start();
            }
        }
    }

    public void showFragment(View view, String str, Bundle bundle, Bundle bundle2, boolean z) {
        if (view == null) {
            ccr.O00000o0(TAG, "mDecoratedView is NOT FOUND.");
        } else if (view.getId() <= 0) {
            throw new IllegalArgumentException("The activity in xml layout MUST has argument 'id'.");
        } else if (bundle == null) {
            ei O000000o2 = getSupportFragmentManager().O000000o();
            Fragment fragmentByTag = getFragmentByTag(str);
            if (fragmentByTag == null) {
                fragmentByTag = newFragmentByTag(str);
                if (bundle2 != null) {
                    fragmentByTag.setArguments(bundle2);
                }
            }
            if (fragmentByTag == null) {
                ccr.O00000o0(TAG, "NO fragment found by tag: ".concat(String.valueOf(str)));
                return;
            }
            O000000o2.O0000Oo0 = 4099;
            O000000o2.O00000Oo(view.getId(), fragmentByTag, str);
            if (z) {
                O000000o2.O000000o((String) null);
            }
            O000000o2.O00000o0();
        }
    }

    public Fragment getFragmentByTag(String str) {
        return getSupportFragmentManager().O000000o(str);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        cem.O000000o(i, iArr);
    }

    @TargetApi(23)
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        cem.O000000o(this, i);
    }

    public static boolean isActivityAlive(Context context) {
        if (context != null && (context instanceof Activity)) {
            if (Build.VERSION.SDK_INT >= 17) {
                Activity activity = (Activity) context;
                if (activity.isFinishing() || activity.isDestroyed()) {
                    return false;
                }
                return true;
            } else if (!((Activity) context).isFinishing()) {
                return true;
            }
        }
        return false;
    }
}

package _m_j;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.open.utils.HttpUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class djl {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Map<String, djl> f14721O000000o = Collections.synchronizedMap(new HashMap());
    private static String O00000Oo = null;
    private String O00000o = null;
    /* access modifiers changed from: private */
    public Context O00000o0 = null;
    private JSONObject O00000oO = null;
    private long O00000oo = 0;
    /* access modifiers changed from: private */
    public int O0000O0o = 0;
    private boolean O0000OOo = true;

    public static djl O000000o(Context context, String str) {
        djl djl;
        synchronized (f14721O000000o) {
            diz.O000000o("openSDK_LOG.OpenConfig", "getInstance begin");
            if (str != null) {
                O00000Oo = str;
            }
            if (str == null) {
                str = O00000Oo != null ? O00000Oo : "0";
            }
            djl = f14721O000000o.get(str);
            if (djl == null) {
                djl = new djl(context, str);
                f14721O000000o.put(str, djl);
            }
            diz.O000000o("openSDK_LOG.OpenConfig", "getInstance end");
        }
        return djl;
    }

    private djl(Context context, String str) {
        this.O00000o0 = context.getApplicationContext();
        this.O00000o = str;
        try {
            this.O00000oO = new JSONObject(O00000o0("com.tencent.open.config.json"));
        } catch (JSONException unused) {
            this.O00000oO = new JSONObject();
        }
        O000000o();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:7|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0077, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0078, code lost:
        r5.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007b, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r5 = r4.O00000o0.getAssets().open(r5);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0025 */
    private String O00000o0(String str) {
        String str2;
        String str3 = "";
        if (this.O00000o != null) {
            str2 = str + "." + this.O00000o;
        } else {
            str2 = str;
        }
        InputStream inputStream = this.O00000o0.openFileInput(str2);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(readLine);
            } catch (IOException e) {
                e.printStackTrace();
                inputStream.close();
                bufferedReader.close();
            } catch (Throwable th) {
                try {
                    inputStream.close();
                    bufferedReader.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                throw th;
            }
        }
        str3 = stringBuffer.toString();
        try {
            inputStream.close();
            bufferedReader.close();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return str3;
    }

    private void O000000o() {
        if (this.O0000O0o != 0) {
            O00000o("update thread is running, return");
            return;
        }
        this.O0000O0o = 1;
        final Bundle bundle = new Bundle();
        bundle.putString("appid", this.O00000o);
        bundle.putString("appid_for_getting_config", this.O00000o);
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", Build.VERSION.SDK);
        bundle.putString("sdkv", "3.5.2.lite");
        bundle.putString("sdkp", "a");
        new Thread() {
            /* class _m_j.djl.AnonymousClass1 */

            public final void run() {
                try {
                    djl.O000000o(djl.this, djp.O00000o(HttpUtils.O000000o(djl.this.O00000o0, "https://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", bundle).f14727O000000o));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                int unused = djl.this.O0000O0o = 0;
            }
        }.start();
    }

    private void O00000Oo() {
        int optInt = this.O00000oO.optInt("Common_frequency");
        if (optInt == 0) {
            optInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.O00000oo >= ((long) (optInt * 3600000))) {
            O000000o();
        }
    }

    public final int O000000o(String str) {
        O00000o("get ".concat(String.valueOf(str)));
        O00000Oo();
        return this.O00000oO.optInt(str);
    }

    public final boolean O00000Oo(String str) {
        O00000o("get ".concat(String.valueOf(str)));
        O00000Oo();
        Object opt = this.O00000oO.opt(str);
        if (opt == null) {
            return false;
        }
        if (opt instanceof Integer) {
            if (!opt.equals(0)) {
                return true;
            }
            return false;
        } else if (opt instanceof Boolean) {
            return ((Boolean) opt).booleanValue();
        } else {
            return false;
        }
    }

    private void O00000o(String str) {
        if (this.O0000OOo) {
            diz.O000000o("openSDK_LOG.OpenConfig", str + "; appid: " + this.O00000o);
        }
    }

    static /* synthetic */ void O000000o(djl djl, JSONObject jSONObject) {
        djl.O00000o("cgi back, do update");
        djl.O00000oO = jSONObject;
        String jSONObject2 = jSONObject.toString();
        try {
            String str = "com.tencent.open.config.json";
            if (djl.O00000o != null) {
                str = str + "." + djl.O00000o;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(djl.O00000o0.openFileOutput(str, 0), Charset.forName("UTF-8"));
            outputStreamWriter.write(jSONObject2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        djl.O00000oo = SystemClock.elapsedRealtime();
    }
}

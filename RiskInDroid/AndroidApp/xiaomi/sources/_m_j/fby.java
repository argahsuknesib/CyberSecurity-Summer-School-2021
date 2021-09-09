package _m_j;

import _m_j.gsj;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Call;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class fby {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f16056O000000o = "fby";
    private static volatile fby O0000O0o;
    public AtomicBoolean O00000Oo = new AtomicBoolean(false);
    public long O00000o = 0;
    public AtomicBoolean O00000o0 = new AtomicBoolean(false);
    public Map<String, O000000o> O00000oO = new ConcurrentHashMap();
    public List<Pair<String, fsm<O000000o, fso>>> O00000oo = new ArrayList();

    private fby() {
        try {
            String O00000Oo2 = O00000Oo(O00000o());
            if (!TextUtils.isEmpty(O00000Oo2)) {
                O000000o(O00000Oo2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static fby O000000o() {
        if (O0000O0o == null) {
            synchronized (fby.class) {
                if (O0000O0o == null) {
                    O0000O0o = new fby();
                }
            }
        }
        return O0000O0o;
    }

    public final void O00000Oo() {
        gsy.O00000Oo(f16056O000000o, "updateGreyUpgradeConfig in");
        if (Math.abs(System.currentTimeMillis() - this.O00000o) >= 5000 && !this.O00000Oo.getAndSet(true)) {
            gsy.O00000Oo(f16056O000000o, "updateGreyUpgradeConfig will issue request");
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("lang", "en");
                StringBuilder sb = new StringBuilder("android_appgreyupgrade");
                sb.append(gfr.O0000oo0 ? "_preview" : "");
                jSONObject.put("name", sb.toString());
                jSONObject.put("version", "1");
                arrayList.add(new KeyValuePair("data", jSONObject.toString()));
                gsj.O000000o o000000o = new gsj.O000000o();
                o000000o.f18212O000000o = "GET";
                gsg.O00000Oo(o000000o.O00000Oo(O000000o(jSONObject)).O000000o(), new gsl() {
                    /* class _m_j.fby.AnonymousClass1 */

                    public final void onSuccess(Object obj, Response response) {
                    }

                    public final void processResponse(Response response) {
                        JSONObject jSONObject;
                        try {
                            String string = response.body().string();
                            gsy.O00000Oo(fby.f16056O000000o, string);
                            JSONObject jSONObject2 = new JSONObject(string);
                            if (jSONObject2.isNull("result")) {
                                synchronized (fby.this.O00000oo) {
                                    fby.this.O00000o0.set(true);
                                    fby.this.O00000Oo.set(false);
                                }
                                return;
                            }
                            JSONObject optJSONObject = jSONObject2.optJSONObject("result");
                            LogType logType = LogType.NETWORK;
                            String str = fby.f16056O000000o;
                            gsy.O000000o(logType, str, "getRemoteConfig  result" + optJSONObject.toString());
                            if (optJSONObject.isNull("content")) {
                                synchronized (fby.this.O00000oo) {
                                    fby.this.O00000o0.set(true);
                                    fby.this.O00000Oo.set(false);
                                }
                                return;
                            }
                            Object obj = optJSONObject.get("content");
                            if (obj instanceof JSONObject) {
                                jSONObject = (JSONObject) obj;
                            } else {
                                jSONObject = obj instanceof String ? new JSONObject((String) obj) : null;
                            }
                            if (jSONObject.isNull("data")) {
                                synchronized (fby.this.O00000oo) {
                                    fby.this.O00000o0.set(true);
                                    fby.this.O00000Oo.set(false);
                                }
                                return;
                            }
                            JSONArray optJSONArray = jSONObject.optJSONArray("data");
                            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                O000000o O000000o2 = O000000o.O000000o(optJSONArray.optJSONObject(i));
                                if (O000000o2 != null && !TextUtils.isEmpty(O000000o2.f16058O000000o)) {
                                    concurrentHashMap.put(O000000o2.f16058O000000o, O000000o2);
                                }
                            }
                            fby.this.O00000oO = concurrentHashMap;
                            synchronized (fby.this.O00000oo) {
                                fby.this.O00000Oo.set(false);
                                gsy.O00000Oo(fby.f16056O000000o, "fetchGreyUpgradeConfig success: from network");
                                for (int i2 = 0; i2 < fby.this.O00000oo.size(); i2++) {
                                    Pair pair = fby.this.O00000oo.get(i2);
                                    if (!(pair == null || pair.second == null || TextUtils.isEmpty((CharSequence) pair.first))) {
                                        O000000o o000000o = (O000000o) concurrentHashMap.get(pair.first);
                                        if (gfr.O0000OOo) {
                                            try {
                                                String str2 = fby.f16056O000000o;
                                                StringBuilder sb = new StringBuilder("updateGreyUpgradeConfig callback.onSuccess ");
                                                sb.append(o000000o == null ? null : o000000o.O000000o().toString());
                                                gsy.O00000Oo(str2, sb.toString());
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        ((fsm) pair.second).onSuccess(o000000o);
                                    }
                                }
                                fby.this.O00000o0.set(true);
                            }
                            fby.this.O00000o = System.currentTimeMillis();
                            try {
                                fby.O000000o(fby.this.O00000o0(), fby.O00000o());
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } catch (Exception e3) {
                            synchronized (fby.this.O00000oo) {
                                fby.this.O00000o0.set(true);
                                fby.this.O00000Oo.set(false);
                                e3.printStackTrace();
                            }
                        }
                    }

                    public final void processFailure(Call call, IOException iOException) {
                        String str = fby.f16056O000000o;
                        StringBuilder sb = new StringBuilder("updateGreyUpgradeConfig processFailure1 ");
                        sb.append(iOException == null ? null : iOException.getMessage());
                        gsy.O00000Oo(str, sb.toString());
                        synchronized (fby.this.O00000oo) {
                            fby.this.O00000o0.set(true);
                            fby.this.O00000Oo.set(false);
                        }
                        fby.this.O00000o = System.currentTimeMillis();
                    }

                    public final void onFailure(gsf gsf, Exception exc, Response response) {
                        String str = fby.f16056O000000o;
                        StringBuilder sb = new StringBuilder("updateGreyUpgradeConfig processFailure2 ");
                        sb.append(exc == null ? null : exc.getMessage());
                        gsy.O00000Oo(str, sb.toString());
                        synchronized (fby.this.O00000oo) {
                            fby.this.O00000o0.set(true);
                            fby.this.O00000Oo.set(false);
                        }
                        fby.this.O00000o = System.currentTimeMillis();
                    }
                });
            } catch (Exception unused) {
                synchronized (this.O00000oo) {
                    this.O00000o0.set(true);
                    this.O00000Oo.set(false);
                }
            }
        }
    }

    public static boolean O000000o(String str, String str2) {
        try {
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            } else {
                file.mkdirs();
                file.createNewFile();
            }
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(str);
            printWriter.flush();
            printWriter.close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private void O000000o(String str) throws JSONException {
        JSONArray optJSONArray = new JSONObject(str).optJSONArray("data");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (int i = 0; i < optJSONArray.length(); i++) {
                O000000o O000000o2 = O000000o.O000000o(optJSONArray.optJSONObject(i));
                if (O000000o2 != null && !TextUtils.isEmpty(O000000o2.f16058O000000o)) {
                    concurrentHashMap.put(O000000o2.f16058O000000o, O000000o2);
                }
            }
            this.O00000oO = concurrentHashMap;
            this.O00000o0.set(true);
        }
    }

    /* access modifiers changed from: package-private */
    public final String O00000o0() throws JSONException {
        try {
            HashSet<O000000o> hashSet = new HashSet<>(this.O00000oO.values());
            JSONArray jSONArray = new JSONArray();
            for (O000000o o000000o : hashSet) {
                if (o000000o != null) {
                    jSONArray.put(o000000o.O000000o());
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", jSONArray);
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    static String O00000o() {
        ServerBean O000000o2 = ftn.O000000o(CommonApplication.getAppContext());
        StringBuilder sb = new StringBuilder();
        sb.append(CommonApplication.getAppContext().getFilesDir());
        sb.append(File.separator);
        sb.append("app_grey_upgrade_config_");
        sb.append(O000000o2 == null ? "" : O000000o2.f7546O000000o);
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x0012] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0040  */
    private static String O00000Oo(String str) throws IOException {
        String str2;
        File file = new File(str);
        FileReader fileReader = null;
        if (!file.exists()) {
            return null;
        }
        try {
            FileReader fileReader2 = new FileReader(file);
            try {
                char[] cArr = new char[((int) file.length())];
                fileReader2.read(cArr);
                str2 = new String(cArr);
                fileReader2.close();
                fileReader2.close();
            } catch (Exception e) {
                e = e;
                fileReader = fileReader2;
                try {
                    e.printStackTrace();
                    if (fileReader != null) {
                    }
                    return str2;
                } catch (Throwable th) {
                    th = th;
                    fileReader2 = fileReader;
                    if (fileReader2 != null) {
                        fileReader2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
            }
        } catch (Exception e2) {
            e = e2;
            str2 = null;
            e.printStackTrace();
            if (fileReader != null) {
            }
            return str2;
        }
        return str2;
    }

    private static String O000000o(JSONObject jSONObject) throws UnsupportedEncodingException {
        return hsk.O000000o(CommonApplication.getAppContext()) + "/app/service/getappconfig?data=" + URLEncoder.encode(jSONObject.toString(), "UTF-8");
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        String f16058O000000o;
        long O00000Oo;
        private long O00000o;
        public String O00000o0;

        public static O000000o O000000o(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString("key");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            O000000o o000000o = new O000000o();
            o000000o.f16058O000000o = optString;
            o000000o.O00000o = jSONObject.optLong("timestamp", System.currentTimeMillis());
            JSONObject optJSONObject = jSONObject.optJSONObject("value");
            o000000o.O00000Oo = (long) optJSONObject.optInt("min_app_v");
            o000000o.O00000o0 = optJSONObject.optString("download_url");
            return o000000o;
        }

        public final JSONObject O000000o() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("min_app_v", this.O00000Oo);
            jSONObject2.put("download_url", this.O00000o0);
            jSONObject.put("value", jSONObject2);
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("key", this.f16058O000000o);
            return jSONObject;
        }
    }

    public static boolean O000000o(O000000o o000000o) {
        if (o000000o == null || TextUtils.isEmpty(o000000o.O00000o0)) {
            return false;
        }
        long j = o000000o.O00000Oo;
        if (j == 0) {
            return false;
        }
        int i = gfr.O00000oO;
        if (i == 0) {
            try {
                i = CommonApplication.getApplication().getPackageManager().getPackageInfo(CommonApplication.getApplication().getPackageName(), 0).versionCode;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (((long) i) >= j) {
            return false;
        }
        return true;
    }
}

package _m_j;

import _m_j.fli;
import _m_j.gsj;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.api.spec.instance.SpecDevice;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hdh {
    private static final flg<Map<String, String>, Map<String, Map<String, String>>> O00000o0 = $$Lambda$hdh$Nxeo1fgCDg7wGYmmyfXIkl6hfIs.INSTANCE;

    /* renamed from: O000000o  reason: collision with root package name */
    final HashMap<String, SpecDevice> f18809O000000o = new HashMap<>();
    final Map<String, Map<String, String>> O00000Oo = new HashMap();
    private ExecutorService O00000o = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), $$Lambda$hdh$YOsffHAyAxCb6xSxbEVLDnztEPA.INSTANCE);

    /* access modifiers changed from: private */
    public static /* synthetic */ Map O000000o(Map map, String str) {
        Map map2 = (Map) map.get(str);
        if (map2 == null || map2.size() == 0) {
            return null;
        }
        return map2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Thread O000000o(Runnable runnable) {
        Thread thread = new Thread(runnable, "SpecCache_Executor");
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 10) {
            thread.setPriority(10);
        }
        return thread;
    }

    public hdh() {
        File O000000o2 = O000000o("/miot-spec-v2/instance");
        File O000000o3 = O000000o("/instance/v2/multiLanguage");
        boolean mkdirs = O000000o2.mkdirs();
        boolean mkdirs2 = O000000o3.mkdirs();
        O000000o();
        LogType logType = LogType.CARD;
        gsy.O00000Oo(logType, "mijia-card", "getSpecFilePath create language:" + mkdirs2 + " instance:" + mkdirs);
    }

    private void O000000o() {
        Parcel O00000Oo2;
        HashSet hashSet = new HashSet();
        File O000000o2 = O000000o("spec_urns.parcel");
        if (!O000000o2.exists() || (O00000Oo2 = fkw.O00000Oo(O000000o2)) == null) {
            gsy.O00000Oo(LogType.CARD, "mijia-card", "loadSpecInstanceLanguage no cache urns");
            return;
        }
        int readInt = O00000Oo2.readInt();
        for (int i = 0; i < readInt; i++) {
            String readString = O00000Oo2.readString();
            if (!TextUtils.isEmpty(readString)) {
                hashSet.add(readString);
            }
        }
        O00000Oo2.recycle();
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            O00000o((String) it.next());
        }
        gsy.O00000Oo("mijia-card", "readInstance cache spend time:" + (System.currentTimeMillis() - currentTimeMillis) + "  data size:" + this.f18809O000000o.size());
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            O00000oO((String) it2.next());
        }
        gsy.O00000Oo("mijia-card", "readLanguage cache spend time:" + (System.currentTimeMillis() - currentTimeMillis) + "  data size:" + this.O00000Oo.size());
    }

    private void O00000o(String str) {
        Parcel O00000Oo2;
        File O000000o2 = O000000o("/miot-spec-v2/instance", str);
        if (O000000o2.exists() && (O00000Oo2 = fkw.O00000Oo(O000000o2)) != null) {
            try {
                O00000Oo2.readLong();
                this.f18809O000000o.put(str, (SpecDevice) O00000Oo2.readParcelable(SpecDevice.class.getClassLoader()));
                O00000Oo2.recycle();
            } catch (Exception e) {
                boolean delete = O000000o2.delete();
                LogType logType = LogType.CARD;
                gsy.O00000Oo(logType, "mijia-card", Log.getStackTraceString(e) + " delete:" + delete);
            }
        }
    }

    private void O00000oO(String str) {
        Parcel O00000Oo2;
        File O000000o2 = O000000o("/instance/v2/multiLanguage", str);
        if (O000000o2.exists() && (O00000Oo2 = fkw.O00000Oo(O000000o2)) != null) {
            try {
                O00000Oo2.readLong();
                String readString = O00000Oo2.readString();
                Map map = (Map) gpl.O000000o(fkx.O000000o(O00000Oo2, new HashMap(), $$Lambda$hdh$2wSS5qK5ig6R8U8UyWUSvEMIQHI.INSTANCE), O00000o0);
                if (map != null) {
                    if (map.size() != 0) {
                        this.O00000Oo.put(readString, map);
                        return;
                    }
                }
                this.O00000Oo.put(readString, Collections.emptyMap());
            } catch (Exception e) {
                boolean delete = O000000o2.delete();
                LogType logType = LogType.CARD;
                gsy.O00000Oo(logType, "mijia-card", Log.getStackTraceString(e) + " delete:" + delete);
            }
        }
    }

    public final void O000000o(String str, Map<String, Map<String, String>> map, long j) {
        if (map == null) {
            try {
                gsy.O00000o0(LogType.CARD, "mijia-card", "writeLanguage stringMap is null str:".concat(String.valueOf(str)));
            } catch (Throwable th) {
                gpg.O000000o((OutputStream) null);
                throw th;
            }
        } else {
            Map map2 = (Map) gpl.O000000o(map, O00000o0);
            Map<String, Map<String, String>> map3 = this.O00000Oo;
            if (map2 == null) {
                map2 = Collections.emptyMap();
            }
            map3.put(str, map2);
            Parcel obtain = Parcel.obtain();
            obtain.writeLong(j);
            obtain.writeString(str);
            fkx.O000000o(obtain, map, $$Lambda$3l81UnZCZiOReEgZIa3sBD0gE.INSTANCE);
            fkw.O000000o(O000000o("/instance/v2/multiLanguage", str), obtain.marshall());
            obtain.recycle();
        }
        gpg.O000000o((OutputStream) null);
    }

    static File O000000o(String str, String str2) {
        return new File(O000000o(str), grv.O000000o(gqb.O0000O0o(str2)));
    }

    static File O000000o(String str) {
        return new File(CommonApplication.getAppContext().getFilesDir() + File.separator + "spec_support_cache_v3" + File.separator + grv.O000000o(str));
    }

    public static Map<String, Map<String, String>> O000000o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return Collections.emptyMap();
        }
        o0O0OOO0 o0o0ooo0 = new o0O0OOO0();
        fli.O000000o(jSONObject, o0o0ooo0, $$Lambda$hdh$8JQv1iKadmlL5ktvt0kkiO6q6mw.INSTANCE);
        return o0o0ooo0;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Map O000000o(JSONObject jSONObject, String str) {
        o0O0OOO0 o0o0ooo0 = new o0O0OOO0();
        fli.O000000o(jSONObject.optJSONObject(str), (Map) null, new fli.O00000Oo() {
            /* class _m_j.$$Lambda$hdh$yG0KBEBnHoDsbldY10VFCvvxGEs */

            public final Object getItem(Object obj, String str) {
                return hdh.O000000o(o0O0OOO0.this, (JSONObject) obj, str);
            }
        });
        return o0o0ooo0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hhc.O000000o(java.lang.Object, int):int
     arg types: [java.lang.String, int]
     candidates:
      _m_j.hhc.O000000o(java.lang.Object, double):double
      _m_j.hhc.O000000o(java.lang.Object, int):int */
    /* access modifiers changed from: private */
    public static /* synthetic */ String O000000o(o0O0OOO0 o0o0ooo0, JSONObject jSONObject, String str) {
        String str2;
        String str3;
        String optString = jSONObject.optString(str);
        String[] split = str.split(":");
        if (split.length > 1) {
            int O000000o2 = hhc.O000000o((Object) split[1], 0);
            if (split.length > 3) {
                int O000000o3 = hhc.O000000o((Object) split[3], 0);
                if (split.length > 5) {
                    try {
                        str3 = String.valueOf(Long.valueOf(split[5]));
                    } catch (Exception unused) {
                        str3 = split[5];
                    }
                    str2 = fax.O000000o(split[2]) + "." + O000000o2 + "." + O000000o3 + "." + str3;
                } else {
                    str2 = fax.O000000o(split[2]) + "." + O000000o2 + "." + O000000o3;
                }
            } else {
                str2 = String.valueOf(O000000o2);
            }
            o0o0ooo0.put(str2, optString);
        }
        return optString;
    }

    public final Map<String, String> O00000Oo(String str) {
        return this.O00000Oo.get(str);
    }

    public final SpecDevice O00000o0(String str) {
        return this.f18809O000000o.get(str);
    }

    public final int O000000o(String str, Set<String> set) {
        ArrayList<JSONArray> arrayList = new ArrayList<>();
        ArrayList<JSONArray> arrayList2 = new ArrayList<>();
        if ("/miot-spec-v2/instance".equals(str)) {
            O000000o(set, arrayList, arrayList2, null, new fkv() {
                /* class _m_j.$$Lambda$hdh$T12hAgFZbe9rWKsd_hkE5oamp3I */

                public final Object call(Object obj) {
                    return hdh.this.O0000O0o((String) obj);
                }
            });
        } else if ("/instance/v2/multiLanguage".equals(str)) {
            O000000o(set, arrayList, arrayList2, "0", new fkv() {
                /* class _m_j.$$Lambda$hdh$9xwfN7TAKU5BVFYEZhvKyeNnneU */

                public final Object call(Object obj) {
                    return hdh.this.O00000oo((String) obj);
                }
            });
        }
        int i = 0;
        for (JSONArray O000000o2 : arrayList) {
            i += O000000o(str, 2, O000000o2);
        }
        for (JSONArray O000000o3 : arrayList2) {
            i += O000000o(str, 3, O000000o3);
        }
        return i;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean O0000O0o(String str) throws RuntimeException {
        O00000o(str);
        return Boolean.valueOf(this.f18809O000000o.get(str) == null || !gfr.O0000Oo0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean O00000oo(String str) throws RuntimeException {
        O00000oO(str);
        return Boolean.valueOf(this.O00000Oo.get(str) == null || !gfr.O0000Oo0);
    }

    private static void O000000o(Collection<String> collection, List<JSONArray> list, List<JSONArray> list2, String str, fkv<String, Boolean> fkv) {
        Iterator<String> it = collection.iterator();
        JSONArray jSONArray = null;
        JSONArray jSONArray2 = null;
        while (it.hasNext()) {
            String next = it.next();
            if (fkv.call(next).booleanValue()) {
                boolean z = true;
                if (next != null && next.startsWith("urn:miot-spec-v2")) {
                    jSONArray = O000000o(list, jSONArray, new O000000o(next, str));
                } else {
                    if (next == null || !next.startsWith("urn:aiot-spec-v3")) {
                        z = false;
                    }
                    if (z) {
                        jSONArray2 = O000000o(list2, jSONArray2, new O000000o(next, str));
                    }
                }
            }
        }
    }

    private static JSONArray O000000o(List<JSONArray> list, JSONArray jSONArray, O000000o o000000o) {
        if (jSONArray == null) {
            jSONArray = new JSONArray();
            list.add(jSONArray);
        }
        jSONArray.put(o000000o);
        if (jSONArray.length() == 50) {
            return null;
        }
        return jSONArray;
    }

    static class O000000o extends Pair<String, String> {
        public O000000o(String str, String str2) {
            super(str, str2);
        }

        public final String toString() {
            if (this.second == null) {
                return (String) this.first;
            }
            return ((String) this.first) + "," + ((String) this.second);
        }
    }

    private int O000000o(final String str, int i, final JSONArray jSONArray) {
        final String str2;
        String str3 = "/miot-spec-v2/instance";
        if (!str3.equals(str)) {
            str3 = i == 2 ? "/instance/v2/multiLanguage" : "/instance/v3/multiLanguage";
        } else if (i != 2) {
            str3 = "/aiot-spec-v3/instance";
        }
        if (gfr.O0000Oo0 || !"st".equals(fdc.O000000o().O0000o0O().f7546O000000o)) {
            str2 = "https://miot-spec.org".concat(str3);
        } else {
            str2 = "http://st.miot-spec.srv".concat(str3);
        }
        gsj.O000000o o000000o = new gsj.O000000o();
        o000000o.f18212O000000o = "POST";
        gsj O000000o2 = o000000o.O00000Oo(str2).O000000o(new RequestBody() {
            /* class _m_j.hdh.AnonymousClass1 */

            public final MediaType contentType() {
                return MediaType.parse("application/json");
            }

            public final void writeTo(jay jay) throws IOException {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("urns", jSONArray);
                    jay.O00000Oo(jSONObject.toString(), Charset.forName("UTF-8"));
                } catch (JSONException e) {
                    gsy.O00000Oo(LogType.CARD, "mijia-card", Log.getStackTraceString(e));
                }
            }
        }).O000000o();
        if (jSONArray.length() == 0) {
            gsy.O000000o(4, "mijia-card", "SpecCache.loadSpecItemConfig cached url:" + str2 + "?urn=" + jSONArray);
            return 0;
        }
        gsy.O000000o(4, "mijia-card", "SpecCache.loadSpecItemConfig sendRequest url:" + str2 + "?urn=" + jSONArray);
        try {
            return ((Integer) gsg.O000000o(O000000o2, new gsp<Integer>() {
                /* class _m_j.hdh.AnonymousClass2 */

                /* access modifiers changed from: private */
                /* renamed from: O00000Oo */
                public Integer O000000o(Response response) throws Exception {
                    int i;
                    ResponseBody body = response.body();
                    if (body == null || !response.isSuccessful()) {
                        gsy.O000000o(6, "mijia-card", "SpecCache.loadSpecItemConfig processResponse code:" + response.code() + " noData url:" + str2 + "?urn=" + jSONArray);
                        return -1;
                    }
                    JSONObject jSONObject = new JSONObject(body.string());
                    if ("/miot-spec-v2/instance".equals(str)) {
                        int i2 = 0;
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            String str = (String) ((O000000o) jSONArray.opt(i3)).first;
                            JSONObject optJSONObject = jSONObject.optJSONObject(str);
                            if (optJSONObject == null || optJSONObject.length() <= 0) {
                                LogType logType = LogType.CARD;
                                gsy.O00000o0(logType, "SpecCache", "urn:" + str + " no instance data");
                            } else {
                                hdh hdh = hdh.this;
                                SpecDevice O000000o2 = hfd.O000000o(optJSONObject);
                                long optLong = optJSONObject.optLong("timestamp");
                                try {
                                    if (O000000o2.isEmpty()) {
                                        gsy.O00000Oo(LogType.CARD, "mijia-card", "writeInstance specDevice is null str:".concat(String.valueOf(str)));
                                    } else {
                                        hdh.f18809O000000o.put(str, O000000o2);
                                        Parcel obtain = Parcel.obtain();
                                        obtain.writeLong(optLong);
                                        obtain.writeParcelable(O000000o2, 0);
                                        fkw.O000000o(hdh.O000000o("/miot-spec-v2/instance", str), obtain.marshall());
                                        obtain.recycle();
                                    }
                                } catch (Throwable th) {
                                    gpg.O000000o((OutputStream) null);
                                    throw th;
                                }
                                gpg.O000000o((OutputStream) null);
                                i2++;
                            }
                        }
                        i = i2;
                    } else if ("/instance/v2/multiLanguage".equals(str)) {
                        i = 0;
                        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                            String str2 = (String) ((O000000o) jSONArray.opt(i4)).first;
                            JSONObject optJSONObject2 = jSONObject.optJSONObject(str2);
                            if (optJSONObject2 == null || optJSONObject2.length() <= 0) {
                                hdh.this.O000000o(str2, Collections.emptyMap(), -1);
                            } else {
                                hdh.this.O000000o(str2, hdh.O000000o(optJSONObject2.optJSONObject("data")), optJSONObject2.optLong("timestamp"));
                                i++;
                            }
                        }
                    } else {
                        i = 0;
                    }
                    gsy.O00000Oo("mijia-card", "SpecCache.loadSpecItemConfig processResponse url:" + str2 + "?urn=" + jSONArray);
                    return Integer.valueOf(i);
                }
            })).intValue();
        } catch (Exception e) {
            Log.e("mijia-card", "requestSpec", e);
            return 0;
        }
    }
}

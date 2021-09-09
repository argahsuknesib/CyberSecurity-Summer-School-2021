package _m_j;

import _m_j.fkx;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class hcd {
    protected Map<String, Map<String, hdi>> mPropsMap = new ConcurrentHashMap();
    private final LinkedList<hda> mStateChangedListener = new LinkedList<>();

    /* access modifiers changed from: protected */
    public abstract File getCacheFile();

    public abstract String getCardIconPath(String str);

    public Map<String, hdi> getPropsMap(String str) {
        try {
            return this.mPropsMap.get(str);
        } catch (Exception e) {
            LogType logType = LogType.CARD;
            gsy.O00000Oo(logType, "CardAbstractManager", this.mPropsMap.toString() + Log.getStackTraceString(e));
            return null;
        }
    }

    public Object getPropValue(String str, String str2) {
        Map map;
        hdi hdi;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (map = this.mPropsMap.get(str)) == null || (hdi = (hdi) map.get(str2)) == null) {
            return null;
        }
        return hdi.f18812O000000o;
    }

    public Map<String, hdi> removePropMap(String str) {
        return this.mPropsMap.remove(str);
    }

    /* access modifiers changed from: protected */
    public void loadPropsFromLocal() {
        Parcel O00000Oo;
        File cacheFile = getCacheFile();
        if (cacheFile == null || (O00000Oo = fkw.O00000Oo(cacheFile)) == null) {
            gsy.O000000o(6, "mijia-card", "loadPropsFromLocal file:".concat(String.valueOf(cacheFile)));
            return;
        }
        fkx.O000000o(O00000Oo, this.mPropsMap, new fkx.O00000o0() {
            /* class _m_j.$$Lambda$hcd$3CGZ1jv3od9i4gPsirt3bK13g4 */

            public final Object readValue(Parcel parcel) {
                return hcd.this.lambda$loadPropsFromLocal$1$hcd(parcel);
            }
        });
        gsy.O00000Oo("mijia-card", "loadPropsFromLocal refresh propSize:" + this.mPropsMap.size() + " file:" + cacheFile);
    }

    public /* synthetic */ Map lambda$loadPropsFromLocal$1$hcd(Parcel parcel) {
        return fkx.O000000o(parcel, Collections.synchronizedMap(new o0O0OOO0()), new fkx.O00000o0() {
            /* class _m_j.$$Lambda$hcd$2BOzQ18cTHhgDT6MfSQN8Z1N0CE */

            public final Object readValue(Parcel parcel) {
                return hcd.this.lambda$null$0$hcd(parcel);
            }
        });
    }

    public /* synthetic */ hdi lambda$null$0$hcd(Parcel parcel) {
        Object O000000o2 = fkx.O000000o(parcel, getClass().getClassLoader());
        long readLong = parcel.readLong();
        if (O000000o2 == null && readLong == 0) {
            return null;
        }
        return hdi.O000000o(O000000o2, readLong);
    }

    /* access modifiers changed from: protected */
    public void savePropsCache() {
        File cacheFile = getCacheFile();
        if (cacheFile == null) {
            gsy.O00000Oo("mijia-card", "savePropsCache cacheFile is null");
            return;
        }
        Parcel obtain = Parcel.obtain();
        fkx.O000000o(obtain, this.mPropsMap, $$Lambda$hcd$7eWcw3LkuzS8J4U7B93AZSxXf5c.INSTANCE);
        fkw.O000000o(cacheFile, obtain.marshall());
        obtain.recycle();
        gsy.O00000Oo("mijia-card", "savePropsCache size:" + this.mPropsMap.size() + " file:" + cacheFile);
    }

    static /* synthetic */ void lambda$null$2(Parcel parcel, hdi hdi) {
        if (hdi == null) {
            fkx.O000000o(parcel, (Object) null);
            parcel.writeLong(0);
            return;
        }
        fkx.O000000o(parcel, hdi.f18812O000000o);
        parcel.writeLong(hdi.O00000Oo);
    }

    public Object notifyPropChangedListener(String str, String str2, Object obj, byte b) {
        return notifyPropChangedListener(str, str2, obj, 0, b);
    }

    public Object notifyPropChangedListener(String str, String str2, Object obj, long j, byte b) {
        String str3 = str;
        String str4 = str2;
        Object obj2 = obj;
        byte b2 = b;
        if (TextUtils.isEmpty(str2)) {
            dispatchStateChange(str, str2, obj);
            return null;
        }
        long checkTime = checkTime(j, b2);
        Map map = this.mPropsMap.get(str3);
        if (map == null) {
            Map synchronizedMap = Collections.synchronizedMap(new o0O0OOO0());
            this.mPropsMap.put(str3, synchronizedMap);
            synchronizedMap.put(str4, hdi.O000000o(obj2, checkTime));
            dispatchStateChange(str, str2, obj);
            return null;
        }
        hdi hdi = (hdi) map.get(str4);
        if (hdi == null) {
            map.put(str4, hdi.O000000o(obj2, checkTime));
            dispatchStateChange(str, str2, obj);
            return null;
        } else if (!Objects.equals(hdi.f18812O000000o, obj2)) {
            Object obj3 = hdi.f18812O000000o;
            if (hdi.O00000o0 == 1 && (b2 == 5 || b2 == 4)) {
                long j2 = checkTime;
                if (System.currentTimeMillis() - hdi.O00000Oo > 10000) {
                    gsy.O000000o(6, "mijia-card", "notifyPropChangedListener long time set requesting " + hdi.O00000Oo);
                    hdi.O00000o0 = b2;
                    hdi.f18812O000000o = obj2;
                    hdi.O00000Oo = j2;
                    hdi.O00000oO = 0;
                    hdi.O00000o = null;
                    hdi.O00000oo = 0;
                    dispatchStateChange(str, str2, obj);
                } else {
                    gsy.O000000o(6, "mijia-card", "notifyPropChangedListener ignore " + ((int) b2) + " set requesting " + hdi.O00000Oo);
                    hdi.O00000oO = b2;
                    hdi.O00000o = obj2;
                    hdi.O00000oo = j2;
                }
            } else {
                long j3 = checkTime;
                if (b2 == 3) {
                    if (hdi.O00000o == null) {
                        gsy.O000000o(6, "mijia-card", "notifyPropChangedListener set fail ignore null old value ".concat(String.valueOf((int) b)));
                        hdi.O00000o0 = b2;
                        hdi.f18812O000000o = obj2;
                        hdi.O00000Oo = j3;
                    } else {
                        gsy.O000000o(6, "mijia-card", "notifyPropChangedListener set fail ignore " + hdi.O00000o);
                        hdi.O00000o0 = hdi.O00000oO;
                        hdi.f18812O000000o = hdi.O00000o;
                        hdi.O00000Oo = hdi.O00000oo;
                    }
                    dispatchStateChange(str, str2, obj);
                } else {
                    hdi.O00000o0 = b2;
                    hdi.f18812O000000o = obj2;
                    hdi.O00000Oo = j3;
                    hdi.O00000oO = 0;
                    hdi.O00000o = null;
                    hdi.O00000oo = 0;
                    dispatchStateChange(str, str2, obj);
                }
            }
            return obj3;
        } else {
            long j4 = checkTime;
            if (j4 == 0) {
                return null;
            }
            hdi.O00000Oo = j4;
            return null;
        }
    }

    private long checkTime(long j, byte b) {
        if (j > 0) {
            return hcg.O00000Oo(j);
        }
        if (b == 2 || b == 1) {
            return System.currentTimeMillis();
        }
        return 0;
    }

    private void dispatchStateChange(String str, String str2, Object obj) {
        for (int size = this.mStateChangedListener.size() - 1; size >= 0; size--) {
            this.mStateChangedListener.get(size).onStateChanged(str, str2, obj);
        }
    }

    public void registerStateChangedListener(hda hda) {
        if (hda != null && !this.mStateChangedListener.contains(hda)) {
            this.mStateChangedListener.add(hda);
        }
    }

    public void unregisterStateChangedListener(hda hda) {
        this.mStateChangedListener.remove(hda);
    }

    public static class O000000o implements frf {

        /* renamed from: O000000o  reason: collision with root package name */
        private final WeakReference<? extends hcd> f18770O000000o;

        public O000000o(hcd hcd) {
            this.f18770O000000o = new WeakReference<>(hcd);
        }

        public final List<String> O000000o(String str) {
            Map<String, hdi> propsMap;
            hcd hcd = (hcd) this.f18770O000000o.get();
            if (hcd == null || (propsMap = hcd.getPropsMap(str)) == null) {
                return null;
            }
            return new ArrayList(propsMap.keySet());
        }

        public final void O000000o(String str, JSONArray jSONArray) {
            hcd hcd;
            String str2 = str;
            hcd hcd2 = (hcd) this.f18770O000000o.get();
            if (hcd2 != null) {
                int i = 0;
                int i2 = 0;
                while (i2 < jSONArray.length()) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null && !optJSONObject.isNull("key")) {
                        Object opt = optJSONObject.opt("value");
                        String optString = optJSONObject.optString("key");
                        long optLong = optJSONObject.optLong("time", 0);
                        try {
                            if (!optString.startsWith("event.") && (opt instanceof JSONArray) && ((JSONArray) opt).length() > 0) {
                                opt = ((JSONArray) opt).get(i);
                            }
                        } catch (JSONException e) {
                            LogType logType = LogType.CARD;
                            gsy.O00000Oo(logType, "mijia-card", "onSubscribedValueChanged error：" + Log.getStackTraceString(e));
                        }
                        Object obj = opt;
                        Map<String, hdi> propsMap = hcd2.getPropsMap(str2);
                        hdi hdi = null;
                        if (optLong == 0 || propsMap == null || (hdi = propsMap.get(optString)) == null || hdi.O00000Oo < 1000 * optLong) {
                            hcd = hcd2;
                            hcd2.notifyPropChangedListener(str, optString, obj, optLong, (byte) 4);
                            gsy.O00000Oo("mijia-card", "onSubscribedValueChanged notify. time：" + optLong + " lastTime:" + hdi + " did:" + str2 + " key:" + optString + " value:" + obj);
                            i2++;
                            i = 0;
                            hcd2 = hcd;
                        } else {
                            LogType logType2 = LogType.CARD;
                            gsy.O00000Oo(logType2, "mijia-card", "onSubscribedValueChanged drop. time：" + optLong + " lastTime:" + hdi + " did:" + str2 + " key:" + optString + " value:" + obj);
                        }
                    }
                    hcd = hcd2;
                    i2++;
                    i = 0;
                    hcd2 = hcd;
                }
            }
        }

        public final JSONArray O00000Oo(String str) {
            Map<String, hdi> propsMap;
            JSONArray jSONArray = new JSONArray();
            hcd hcd = (hcd) this.f18770O000000o.get();
            if (hcd == null || (propsMap = hcd.getPropsMap(str)) == null) {
                return jSONArray;
            }
            for (Map.Entry next : propsMap.entrySet()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put((String) next.getKey(), ((hdi) next.getValue()).f18812O000000o);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jSONArray.put(jSONObject);
            }
            return jSONArray;
        }

        public final String toString() {
            return super.toString() + this.f18770O000000o.get();
        }
    }

    public String translateName(String str) {
        return hcg.O000000o(str);
    }

    public void dataReadyRefresh() {
        gsy.O00000Oo(LogType.CARD, "mijia-card", "dataReadyRefresh");
        fbd.O000000o().dataReadyRefresh();
    }
}

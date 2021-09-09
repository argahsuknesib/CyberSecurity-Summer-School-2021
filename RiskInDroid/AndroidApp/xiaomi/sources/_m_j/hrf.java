package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.scene.model.CorntabUtils;
import com.xiaomi.smarthome.scene.timer.CommonTimer;
import com.xiaomi.smarthome.scene.timer.PlugTimer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hrf {

    /* renamed from: O000000o  reason: collision with root package name */
    private static hrf f549O000000o;
    private String O00000Oo;
    public SharedPreferences O00000o;
    protected Device O00000o0;
    public boolean O00000oO;
    public List<O00000Oo> O00000oo;
    protected List<CommonTimer> O0000O0o;
    protected List<CommonTimer> O0000OOo;
    private String O0000Oo0;

    public interface O00000Oo {
        void onGetSceneFailed(int i);

        void onGetSceneSuccess();

        void onSetSceneFailed(fso fso);

        void onSetSceneSuccess(CommonTimer commonTimer);
    }

    public void O00000Oo(CommonTimer commonTimer) {
    }

    public List<List<CommonTimer>> O00000o() {
        return null;
    }

    public static hrf O0000O0o() {
        if (f549O000000o == null) {
            f549O000000o = new hrf();
        }
        return f549O000000o;
    }

    protected hrf() {
        this.O00000oO = false;
        this.O00000oo = new ArrayList();
        this.O0000O0o = new ArrayList();
        this.O0000OOo = new ArrayList();
        this.O0000O0o = new ArrayList();
        this.O0000OOo = new ArrayList();
    }

    public void O000000o(O00000Oo o00000Oo) {
        if (!this.O00000oo.contains(o00000Oo)) {
            this.O00000oo.add(o00000Oo);
        }
    }

    public void O00000Oo(O00000Oo o00000Oo) {
        this.O00000oo.remove(o00000Oo);
    }

    public void O000000o(Device device, String str, String str2) {
        this.O00000o0 = device;
        this.O00000Oo = str;
        this.O0000Oo0 = str2;
        this.O0000O0o.clear();
        try {
            Context appContext = ServiceApplication.getAppContext();
            this.O00000o = appContext.getSharedPreferences("common.timer.shared.prefs" + this.O00000o0.userId + this.O00000o0.did + this.O00000Oo, 0);
        } catch (Exception unused) {
            this.O00000o = ServiceApplication.getAppContext().getSharedPreferences(Base64.encodeToString(("common.timer.shared.prefs" + this.O00000o0.userId + this.O00000o0.did + this.O00000Oo).getBytes(), 0), 0);
        }
        try {
            O00000oO();
        } catch (JSONException unused2) {
        }
    }

    public final boolean O0000OOo() {
        Device device = this.O00000o0;
        if (device == null || TextUtils.isEmpty(device.model)) {
            return false;
        }
        fcc O000000o2 = fcc.O000000o();
        String str = this.O00000o0.model;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return O000000o2.f16073O000000o.contains(str);
    }

    public List<CommonTimer> O00000o0() {
        return this.O0000O0o;
    }

    public List<CommonTimer> O00000Oo() {
        List<CommonTimer> list = this.O0000O0o;
        if (list == null || list.size() <= 0) {
            return this.O0000O0o;
        }
        ArrayList arrayList = new ArrayList();
        for (CommonTimer next : this.O0000O0o) {
            if (next != null) {
                if (TextUtils.isEmpty(next.O0000o0O)) {
                    arrayList.add(next);
                } else if ("0".equals(next.O0000o0O)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    class O000000o implements Comparator<CommonTimer> {
        private O000000o() {
        }

        /* synthetic */ O000000o(hrf hrf, byte b) {
            this();
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            int i;
            int i2;
            int i3;
            int i4;
            CommonTimer commonTimer = (CommonTimer) obj;
            CommonTimer commonTimer2 = (CommonTimer) obj2;
            if (commonTimer.O0000O0o) {
                i2 = commonTimer.O0000Oo.O00000o0 * 60;
                i = commonTimer.O0000Oo.O00000Oo;
            } else {
                i2 = commonTimer.O0000o0.O00000o0 * 60;
                i = commonTimer.O0000o0.O00000Oo;
            }
            int i5 = i2 + i;
            if (commonTimer2.O0000O0o) {
                i4 = commonTimer2.O0000Oo.O00000o0 * 60;
                i3 = commonTimer2.O0000Oo.O00000Oo;
            } else {
                i4 = commonTimer2.O0000o0.O00000o0 * 60;
                i3 = commonTimer2.O0000o0.O00000Oo;
            }
            int i6 = i4 + i3;
            if (i5 < i6) {
                return -1;
            }
            return i5 == i6 ? 0 : 1;
        }
    }

    public final void O000000o(int[] iArr) {
        int length = iArr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(iArr[i]);
        }
        String sb2 = sb.toString();
        if (sb2 != null) {
            SharedPreferences.Editor edit = this.O00000o.edit();
            edit.remove("common.countdown.minute");
            edit.putString("common.countdown.minute", sb2);
            edit.apply();
        }
    }

    public final List<Integer> O0000Oo0() {
        String string = this.O00000o.getString("common.countdown.minute", null);
        if (TextUtils.isEmpty(string)) {
            return Collections.EMPTY_LIST;
        }
        String[] split = string.split(",");
        ArrayList arrayList = new ArrayList();
        for (String valueOf : split) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void O00000oO() throws JSONException {
        String string = this.O00000o.getString("common.setting", null);
        if (string != null) {
            List<CommonTimer> O00000o02 = O00000o0(new JSONObject(string));
            this.O0000O0o.clear();
            this.O0000O0o.addAll(O00000o02);
            this.O0000OOo.clear();
            this.O0000OOo.addAll(O00000o02);
        } else {
            this.O0000O0o.clear();
            this.O0000OOo.clear();
        }
        for (O00000Oo onGetSceneSuccess : this.O00000oo) {
            onGetSceneSuccess.onGetSceneSuccess();
        }
    }

    /* access modifiers changed from: protected */
    public void O000000o(String str) {
        SharedPreferences.Editor edit = this.O00000o.edit();
        edit.remove("common.setting");
        if (str != null) {
            edit.putString("common.setting", str);
        }
        edit.apply();
    }

    public void O00000Oo(String str) {
        if (!this.O00000oO) {
            this.O00000oO = true;
            boolean z = !TextUtils.isEmpty(str);
            hob O000000o2 = hob.O000000o();
            Context appContext = ServiceApplication.getAppContext();
            String str2 = this.O00000o0.did;
            if (!z) {
                str = this.O00000Oo;
            }
            O000000o2.O00000Oo(appContext, str2, str, new fsm<JSONObject, fso>() {
                /* class _m_j.hrf.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    hrf hrf = hrf.this;
                    hrf.O00000oO = false;
                    if (jSONObject != null) {
                        hrf.O000000o(jSONObject);
                        hrf hrf2 = hrf.this;
                        hrf2.O000000o(hrf2.O00000oo().toString());
                    } else {
                        hrf.O000000o((String) null);
                    }
                    for (O00000Oo onGetSceneSuccess : hrf.this.O00000oo) {
                        onGetSceneSuccess.onGetSceneSuccess();
                    }
                }

                public final void onFailure(fso fso) {
                    hrf hrf = hrf.this;
                    hrf.O00000oO = false;
                    for (O00000Oo onGetSceneFailed : hrf.O00000oo) {
                        onGetSceneFailed.onGetSceneFailed(fso.f17063O000000o);
                    }
                }
            }, z);
        }
    }

    public void O000000o(JSONObject jSONObject) {
        List<CommonTimer> O00000Oo2 = O00000Oo(jSONObject);
        this.O0000O0o.clear();
        this.O0000O0o.addAll(O00000Oo2);
        this.O0000OOo.clear();
        this.O0000OOo.addAll(O00000Oo2);
    }

    public List<CommonTimer> O00000Oo(JSONObject jSONObject) {
        JSONObject optJSONObject;
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext() && (optJSONObject = jSONObject.optJSONObject(keys.next())) != null) {
                CommonTimer commonTimer = new CommonTimer();
                commonTimer.f11210O000000o = optJSONObject.optString("us_id");
                commonTimer.O00000o0 = optJSONObject.optString("identify");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("setting");
                boolean z = true;
                commonTimer.O00000oO = optJSONObject2.optString("enable_push").equals("1");
                commonTimer.O00000oo = optJSONObject2.optString("enable_timer").equals("1");
                commonTimer.O0000O0o = optJSONObject2.optString("enable_timer_on").equals("1");
                commonTimer.O0000OOo = optJSONObject2.optString("on_method");
                commonTimer.O0000Oo0 = O000000o(optJSONObject2, "on_param");
                commonTimer.O0000Oo = CorntabUtils.O000000o(optJSONObject2.optString("on_time"));
                if (commonTimer.O0000Oo == null) {
                    commonTimer.O0000Oo = new CorntabUtils.CorntabParam();
                } else {
                    commonTimer.O0000Oo = CorntabUtils.O00000Oo(TimeZone.getDefault(), TimeZone.getTimeZone("Asia/Shanghai"), commonTimer.O0000Oo);
                }
                if (!optJSONObject2.optString("enable_timer_off").equals("1")) {
                    z = false;
                }
                commonTimer.O0000OoO = z;
                commonTimer.O0000Ooo = optJSONObject2.optString("off_method");
                commonTimer.O0000o00 = O000000o(optJSONObject2, "off_param");
                commonTimer.O0000o0 = CorntabUtils.O000000o(optJSONObject2.optString("off_time"));
                if (commonTimer.O0000o0 == null) {
                    commonTimer.O0000o0 = new CorntabUtils.CorntabParam();
                } else {
                    commonTimer.O0000o0 = CorntabUtils.O00000Oo(TimeZone.getDefault(), TimeZone.getTimeZone("Asia/Shanghai"), commonTimer.O0000o0);
                }
                String optString = optJSONObject2.optString("on_filter");
                if (!TextUtils.isEmpty(optString)) {
                    commonTimer.O0000Oo.O0000OOo = optString;
                }
                String optString2 = optJSONObject2.optString("off_filter");
                if (!TextUtils.isEmpty(optString2)) {
                    commonTimer.O0000o0.O0000OOo = optString2;
                }
                commonTimer.O0000o0o = optJSONObject.optInt("status", 0);
                String optString3 = optJSONObject2.optString("timer_type");
                if (!TextUtils.isEmpty(optString3)) {
                    commonTimer.O0000o0O = optString3;
                }
                arrayList.add(commonTimer);
            }
        } catch (Exception unused) {
        }
        Collections.sort(arrayList, new O000000o(this, (byte) 0));
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public String O000000o(JSONObject jSONObject, String str) {
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        String optString = jSONObject.optString(str);
        if (optString == null && (optJSONObject = jSONObject.optJSONObject(str)) != null) {
            optString = optJSONObject.toString();
        }
        if (optString == null && (optJSONArray = jSONObject.optJSONArray(str)) != null && optJSONArray.length() > 0) {
            optString = optJSONArray.toString();
        }
        return optString == null ? "" : optString;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0014, code lost:
        return new org.json.JSONArray(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000f */
    public Object O00000o0(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return new JSONObject(str);
    }

    public JSONObject O00000oo() {
        String str;
        String str2;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            for (CommonTimer next : this.O0000O0o) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("us_id", next.f11210O000000o);
                jSONObject2.put("identify", next.O00000o0);
                String str3 = "1";
                jSONObject2.put("enable_push", next.O00000oO ? str3 : "0");
                if (next.O00000oo) {
                    str = str3;
                } else {
                    str = "0";
                }
                jSONObject2.put("enable_timer", str);
                if (next.O0000OoO) {
                    str2 = str3;
                } else {
                    str2 = "0";
                }
                jSONObject2.put("enable_timer_off", str2);
                if (!next.O0000O0o) {
                    str3 = "0";
                }
                jSONObject2.put("enable_timer_on", str3);
                jSONObject2.put("off_method", O00000o0(next.O0000Ooo));
                jSONObject2.put("off_param", O00000o0(next.O0000o00));
                jSONObject2.put("on_method", O00000o0(next.O0000OOo));
                jSONObject2.put("on_param", O00000o0(next.O0000Oo0));
                String O000000o2 = CorntabUtils.O000000o(next.O0000Oo);
                jSONObject2.put("on_time", O000000o2);
                jSONObject2.put("off_time", O000000o(O000000o2, CorntabUtils.O000000o(next.O0000o0)));
                jSONObject2.put("status", next.O0000o0o);
                jSONObject2.put("timer_type", next.O0000o0O);
                if (!TextUtils.isEmpty(next.O0000Oo.O0000OOo)) {
                    jSONObject2.put("on_filter", next.O0000Oo.O0000OOo);
                }
                if (!TextUtils.isEmpty(next.O0000o0.O0000OOo)) {
                    jSONObject2.put("off_filter", next.O0000o0.O0000OOo);
                }
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("setting", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public List<CommonTimer> O00000o0(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("setting");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    CommonTimer commonTimer = new CommonTimer();
                    commonTimer.f11210O000000o = optJSONObject.optString("us_id");
                    commonTimer.O00000o0 = optJSONObject.optString("identify");
                    commonTimer.O00000oO = optJSONObject.optString("enable_push").equals("1");
                    boolean z = true;
                    commonTimer.O00000oo = optJSONObject.optString("enable_timer").equals("1");
                    commonTimer.O0000O0o = optJSONObject.optString("enable_timer_on").equals("1");
                    commonTimer.O0000OOo = optJSONObject.optString("on_method");
                    commonTimer.O0000Oo0 = O000000o(optJSONObject, "on_param");
                    commonTimer.O0000Oo = CorntabUtils.O000000o(optJSONObject.getString("on_time"));
                    if (commonTimer.O0000Oo == null) {
                        commonTimer.O0000Oo = new CorntabUtils.CorntabParam();
                    } else {
                        commonTimer.O0000Oo = CorntabUtils.O00000Oo(TimeZone.getDefault(), TimeZone.getTimeZone("Asia/Shanghai"), commonTimer.O0000Oo);
                    }
                    if (!optJSONObject.optString("enable_timer_off").equals("1")) {
                        z = false;
                    }
                    commonTimer.O0000OoO = z;
                    commonTimer.O0000Ooo = optJSONObject.optString("off_method");
                    commonTimer.O0000o00 = O000000o(optJSONObject, "off_param");
                    commonTimer.O0000o0 = CorntabUtils.O000000o(optJSONObject.optString("off_time"));
                    if (commonTimer.O0000o0 == null) {
                        commonTimer.O0000o0 = new CorntabUtils.CorntabParam();
                    } else {
                        commonTimer.O0000o0 = CorntabUtils.O00000Oo(TimeZone.getDefault(), TimeZone.getTimeZone("Asia/Shanghai"), commonTimer.O0000o0);
                    }
                    String optString = optJSONObject.optString("timer_type");
                    if (!TextUtils.isEmpty(optString)) {
                        commonTimer.O0000o0O = optString;
                    }
                    String optString2 = optJSONObject.optString("on_filter");
                    if (!TextUtils.isEmpty(optString2)) {
                        commonTimer.O0000Oo.O0000OOo = optString2;
                    }
                    String optString3 = optJSONObject.optString("off_filter");
                    if (!TextUtils.isEmpty(optString3)) {
                        commonTimer.O0000o0.O0000OOo = optString3;
                    }
                    commonTimer.O0000o0o = optJSONObject.optInt("status", 0);
                    arrayList.add(commonTimer);
                }
            }
        } catch (JSONException unused) {
        }
        return arrayList;
    }

    public final List<PlugTimer> O0000Oo() {
        if (this.O0000O0o == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (CommonTimer next : this.O0000O0o) {
            if (next != null && !TextUtils.isEmpty(next.O0000o0O) && "1".equals(next.O0000o0O)) {
                arrayList.add(CommonTimer.O000000o(next));
            }
        }
        return arrayList;
    }

    public final void O000000o(final CommonTimer commonTimer, final O00000Oo o00000Oo, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        if (this.O00000oO) {
            if (o00000Oo != null) {
                o00000Oo.onSetSceneFailed(new fso(-1, "isLoading"));
            }
            for (O00000Oo onSetSceneFailed : this.O00000oo) {
                onSetSceneFailed.onSetSceneFailed(new fso(-1, "isLoading"));
            }
            return;
        }
        this.O00000oO = true;
        JSONObject jSONObject = new JSONObject();
        try {
            String str6 = "1";
            jSONObject.put("enable_push", commonTimer.O00000oO ? str6 : "0");
            if (commonTimer.O00000oo) {
                str4 = str6;
            } else {
                str4 = "0";
            }
            jSONObject.put("enable_timer", str4);
            if (commonTimer.O0000OoO) {
                str5 = str6;
            } else {
                str5 = "0";
            }
            jSONObject.put("enable_timer_off", str5);
            if (!commonTimer.O0000O0o) {
                str6 = "0";
            }
            jSONObject.put("enable_timer_on", str6);
            jSONObject.put("off_method", commonTimer.O0000Ooo);
            jSONObject.put("off_param", O00000o0(commonTimer.O0000o00));
            jSONObject.put("on_method", commonTimer.O0000OOo);
            jSONObject.put("on_param", O00000o0(commonTimer.O0000Oo0));
            String O000000o2 = CorntabUtils.O000000o(CorntabUtils.O000000o(TimeZone.getTimeZone("Asia/Shanghai"), commonTimer.O0000Oo));
            jSONObject.put("on_time", O000000o2);
            jSONObject.put("off_time", O000000o(O000000o2, CorntabUtils.O000000o(CorntabUtils.O000000o(TimeZone.getTimeZone("Asia/Shanghai"), commonTimer.O0000o0))));
            if (!TextUtils.isEmpty(commonTimer.O0000o0O)) {
                jSONObject.put("timer_type", commonTimer.O0000o0O);
            }
            if (!TextUtils.isEmpty(commonTimer.O0000Oo.O0000OOo)) {
                jSONObject.put("on_filter", commonTimer.O0000Oo.O0000OOo);
            } else {
                jSONObject.put("on_filter", "");
            }
            if (!TextUtils.isEmpty(commonTimer.O0000o0.O0000OOo)) {
                jSONObject.put("off_filter", commonTimer.O0000o0.O0000OOo);
            } else {
                jSONObject.put("off_filter", "");
            }
        } catch (JSONException unused) {
        }
        JSONArray jSONArray = new JSONArray();
        Device device = this.O00000o0;
        if (device == null) {
            this.O00000oO = false;
            if (o00000Oo != null) {
                o00000Oo.onSetSceneFailed(new fso(-4003406, "device is null"));
            }
            for (O00000Oo onSetSceneFailed2 : this.O00000oo) {
                onSetSceneFailed2.onSetSceneFailed(new fso(-4003406, "device is null"));
            }
            return;
        }
        jSONArray.put(device.did);
        String str7 = this.O0000Oo0;
        if (TextUtils.isEmpty(str7)) {
            if (commonTimer.O0000O0o && commonTimer.O0000OoO) {
                str7 = this.O00000o0.name + "-" + ServiceApplication.getAppContext().getString(R.string.timer_on_off);
            } else if (commonTimer.O0000O0o) {
                str7 = this.O00000o0.name + "-" + ServiceApplication.getAppContext().getString(R.string.timer_on);
            } else if (commonTimer.O0000OoO) {
                str7 = this.O00000o0.name + "-" + ServiceApplication.getAppContext().getString(R.string.timer_off);
            }
        }
        String str8 = this.O00000o0.did;
        boolean isEmpty = true ^ TextUtils.isEmpty(str);
        if (isEmpty) {
            if (!TextUtils.isEmpty(this.O0000Oo0)) {
                str7 = this.O0000Oo0;
            }
            str3 = str;
            str2 = str7;
        } else {
            str2 = str7;
            str3 = str8;
        }
        gsy.O00000Oo("TimerCommonManager", "identifyFromRn is " + isEmpty + ",  mTimerDisplayName is " + this.O0000Oo0);
        hob.O000000o().O000000o(ServiceApplication.getAppContext(), commonTimer.f11210O000000o, str3, str2, jSONObject, jSONArray, new fsm<JSONObject, fso>() {
            /* class _m_j.hrf.AnonymousClass2 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                hrf.this.O00000oO = false;
                try {
                    commonTimer.f11210O000000o = jSONObject.getString("us_id");
                    commonTimer.O0000o0o = jSONObject.optInt("status", 0);
                } catch (JSONException unused) {
                }
                hrf.this.O0000O0o.clear();
                hrf.this.O0000O0o.addAll(hrf.this.O0000OOo);
                O00000Oo o00000Oo = o00000Oo;
                if (o00000Oo != null) {
                    o00000Oo.onSetSceneSuccess(commonTimer);
                }
                for (O00000Oo onSetSceneSuccess : hrf.this.O00000oo) {
                    onSetSceneSuccess.onSetSceneSuccess(commonTimer);
                }
                hrf hrf = hrf.this;
                hrf.O000000o(hrf.O00000oo().toString());
            }

            public final void onFailure(fso fso) {
                hrf hrf = hrf.this;
                hrf.O00000oO = false;
                hrf.O0000OOo.clear();
                hrf.this.O0000OOo.addAll(hrf.this.O0000O0o);
                O00000Oo o00000Oo = o00000Oo;
                if (o00000Oo != null) {
                    o00000Oo.onSetSceneFailed(fso);
                }
                for (O00000Oo onSetSceneFailed : hrf.this.O00000oo) {
                    onSetSceneFailed.onSetSceneFailed(fso);
                }
            }
        });
    }

    private static String O000000o(String str, String str2) {
        String str3;
        String[] split;
        String str4 = str;
        String[] split2 = str4.split(" ");
        String str5 = str2;
        String[] split3 = str5.split(" ");
        int length = split2.length - 1;
        if (length != split3.length - 1 || length != 6 || O00000o0(split2) || O00000o0(split3) || O000000o(split2) || O000000o(split3)) {
            str3 = str5;
        } else {
            Calendar instance = Calendar.getInstance();
            Calendar calendar = (Calendar) instance.clone();
            Calendar calendar2 = (Calendar) instance.clone();
            if (O00000Oo(split2) && O00000Oo(split3)) {
                calendar.set(Integer.parseInt(split2[6]), Integer.parseInt(split2[4]) - 1, Integer.parseInt(split2[3]), Integer.parseInt(split2[2]), Integer.parseInt(split2[1]));
                calendar2.set(Integer.parseInt(split3[6]), Integer.parseInt(split3[4]) - 1, Integer.parseInt(split3[3]), Integer.parseInt(split3[2]), Integer.parseInt(split3[1]));
                if (calendar2.before(calendar)) {
                    Calendar calendar3 = (Calendar) instance.clone();
                    calendar3.setTimeInMillis(calendar2.getTimeInMillis() + 86400000);
                    StringBuilder sb = new StringBuilder();
                    sb.append(calendar3.get(1));
                    split3[6] = sb.toString();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(calendar3.get(2) + 1);
                    split3[4] = sb2.toString();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(calendar3.get(5));
                    split3[3] = sb3.toString();
                }
            } else if (O000000o(split2) && O000000o(split3)) {
                calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), Integer.parseInt(split2[2]), Integer.parseInt(split2[1]));
                calendar2.set(calendar2.get(1), calendar2.get(2), calendar2.get(5), Integer.parseInt(split3[2]), Integer.parseInt(split3[1]));
                if (calendar2.before(calendar) && (split = split3[5].split(",")) != null) {
                    int length2 = split.length;
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < length2; i++) {
                        if (TextUtils.equals(split[i], "6")) {
                            arrayList.add(0);
                        } else {
                            arrayList.add(Integer.valueOf(Integer.parseInt(split[i]) + 1));
                        }
                    }
                    Collections.sort(arrayList);
                    StringBuilder sb4 = new StringBuilder();
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (i2 < arrayList.size() - 1) {
                            sb4.append(arrayList.get(i2));
                            sb4.append(",");
                        } else {
                            sb4.append(arrayList.get(i2));
                        }
                    }
                    split3[5] = sb4.toString();
                }
            }
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 <= 6; i3++) {
                if (i3 == 6) {
                    sb5.append(split3[i3]);
                } else {
                    sb5.append(split3[i3]);
                    sb5.append(" ");
                }
            }
            str3 = sb5.toString();
        }
        StringBuilder sb6 = new StringBuilder("------------");
        sb6.append("onTime:{ " + str4 + "} offTime:{ " + str3 + "}");
        return str3;
    }

    private static boolean O000000o(String[] strArr) {
        if (!TextUtils.equals("*", strArr[3]) || !TextUtils.equals("*", strArr[4]) || !TextUtils.equals("*", strArr[6]) || TextUtils.equals("*", strArr[5]) || TextUtils.equals("*", strArr[1]) || TextUtils.equals("*", strArr[2])) {
            return false;
        }
        return true;
    }

    private static boolean O00000Oo(String[] strArr) {
        if (!TextUtils.equals("*", strArr[5]) || TextUtils.equals("*", strArr[1]) || TextUtils.equals("*", strArr[2]) || TextUtils.equals("*", strArr[3]) || TextUtils.equals("*", strArr[4]) || TextUtils.equals("*", strArr[6])) {
            return false;
        }
        return true;
    }

    private static boolean O00000o0(String[] strArr) {
        return TextUtils.equals("*", strArr[3]) && TextUtils.equals("*", strArr[4]) && !TextUtils.equals("*", strArr[5]) && strArr[5].split(",") != null && strArr[5].split(",").length == 7 && TextUtils.equals("*", strArr[6]);
    }

    public void O000000o(final CommonTimer commonTimer, final O00000Oo o00000Oo) {
        if (!this.O00000oO) {
            this.O00000oO = true;
            hob.O000000o().O00000Oo(ServiceApplication.getAppContext(), commonTimer.f11210O000000o, new fsm<JSONObject, fso>() {
                /* class _m_j.hrf.AnonymousClass4 */

                public final void onFailure(fso fso) {
                    hrf hrf = hrf.this;
                    hrf.O00000oO = false;
                    hrf.O0000OOo.clear();
                    hrf.this.O0000OOo.addAll(hrf.this.O0000O0o);
                    O00000Oo o00000Oo = o00000Oo;
                    if (o00000Oo != null) {
                        o00000Oo.onSetSceneFailed(fso);
                    }
                    for (O00000Oo onSetSceneSuccess : hrf.this.O00000oo) {
                        onSetSceneSuccess.onSetSceneSuccess(commonTimer);
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    hrf hrf = hrf.this;
                    hrf.O00000oO = false;
                    hrf.O0000O0o.clear();
                    hrf.this.O0000O0o.addAll(hrf.this.O0000OOo);
                    O00000Oo o00000Oo = o00000Oo;
                    if (o00000Oo != null) {
                        o00000Oo.onSetSceneSuccess(commonTimer);
                    }
                    for (O00000Oo onSetSceneSuccess : hrf.this.O00000oo) {
                        onSetSceneSuccess.onSetSceneSuccess(commonTimer);
                    }
                    hrf hrf2 = hrf.this;
                    hrf2.O000000o(hrf2.O00000oo().toString());
                }
            });
        }
    }

    public boolean O000000o(CommonTimer commonTimer) {
        if (!commonTimer.O0000O0o || !commonTimer.O0000OoO || (commonTimer.O0000Oo.O00000o0 * 60) + commonTimer.O0000Oo.O00000Oo != (commonTimer.O0000o0.O00000o0 * 60) + commonTimer.O0000o0.O00000Oo) {
            return true;
        }
        return false;
    }

    public void O000000o(CommonTimer commonTimer, CommonTimer commonTimer2, String str) {
        O000000o(commonTimer, commonTimer2, (O00000Oo) null, str);
    }

    public void O000000o(CommonTimer commonTimer, CommonTimer commonTimer2, O00000Oo o00000Oo, String str) {
        O00000Oo(commonTimer);
        O00000Oo(commonTimer2);
        if (this.O0000OOo.isEmpty()) {
            this.O0000OOo.add(commonTimer2);
        } else {
            for (int i = 0; i < this.O0000OOo.size(); i++) {
                if (TextUtils.equals(this.O0000OOo.get(i).f11210O000000o, commonTimer.f11210O000000o)) {
                    this.O0000OOo.remove(i);
                }
            }
            this.O0000OOo.add(commonTimer2);
        }
        Collections.sort(this.O0000OOo, new O000000o(this, (byte) 0));
        O000000o(commonTimer2, o00000Oo, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    public final void O000000o(PlugTimer plugTimer, final PlugTimer plugTimer2, String str, String str2, String str3, String str4, O00000Oo o00000Oo, String str5) {
        CommonTimer commonTimer;
        String str6;
        String str7;
        PlugTimer plugTimer3 = plugTimer;
        PlugTimer plugTimer4 = plugTimer2;
        final O00000Oo o00000Oo2 = o00000Oo;
        if (plugTimer3 != null) {
            int i = 0;
            while (true) {
                try {
                    if (i >= this.O0000OOo.size()) {
                        break;
                    }
                    commonTimer = this.O0000OOo.get(i);
                    if (commonTimer != null && plugTimer3.O0000Oo.equals(commonTimer.f11210O000000o)) {
                        break;
                    }
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.O0000OOo.remove(commonTimer);
            final CommonTimer O000000o2 = CommonTimer.O000000o(plugTimer2, str, str3, str2, str4);
            this.O0000OOo.add(O000000o2);
            if (this.O00000oO) {
                this.O00000oO = true;
                if (this.O00000o0.isVirtualDevice()) {
                    this.O00000oO = false;
                    O000000o2.f11210O000000o = String.valueOf((int) ((Math.random() * 1000.0d) + 1.0d));
                    this.O0000O0o.clear();
                    this.O0000O0o.addAll(this.O0000OOo);
                    if (plugTimer4 != null) {
                        plugTimer4.O0000Oo = O000000o2.f11210O000000o;
                    }
                    for (O00000Oo onSetSceneSuccess : this.O00000oo) {
                        onSetSceneSuccess.onSetSceneSuccess(O000000o2);
                    }
                    O000000o(O00000oo().toString());
                    o00000Oo2.onSetSceneSuccess(O000000o2);
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    String str8 = "1";
                    jSONObject.put("enable_push", O000000o2.O00000oO ? str8 : "0");
                    if (O000000o2.O00000oo) {
                        str6 = str8;
                    } else {
                        str6 = "0";
                    }
                    jSONObject.put("enable_timer", str6);
                    if (O000000o2.O0000OoO) {
                        str7 = str8;
                    } else {
                        str7 = "0";
                    }
                    jSONObject.put("enable_timer_off", str7);
                    if (!O000000o2.O0000O0o) {
                        str8 = "0";
                    }
                    jSONObject.put("enable_timer_on", str8);
                    jSONObject.put("off_method", O000000o2.O0000Ooo);
                    jSONObject.put("off_param", O00000o0(O000000o2.O0000o00));
                    jSONObject.put("on_method", O000000o2.O0000OOo);
                    jSONObject.put("on_param", O00000o0(O000000o2.O0000Oo0));
                    String O000000o3 = CorntabUtils.O000000o(CorntabUtils.O000000o(TimeZone.getTimeZone("Asia/Shanghai"), O000000o2.O0000Oo));
                    jSONObject.put("on_time", O000000o3);
                    jSONObject.put("off_time", O000000o(O000000o3, CorntabUtils.O000000o(CorntabUtils.O000000o(TimeZone.getTimeZone("Asia/Shanghai"), O000000o2.O0000o0))));
                    String str9 = O000000o2.O0000o0O;
                    if (!TextUtils.isEmpty(str9)) {
                        jSONObject.put("timer_type", str9);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(this.O00000o0.did);
                String str10 = "";
                String str11 = TextUtils.isEmpty(this.O0000Oo0) ? str10 : this.O0000Oo0;
                if (!TextUtils.equals("display_name", str11)) {
                    str10 = str11;
                }
                String str12 = this.O00000o0.did;
                if (!TextUtils.isEmpty(str5)) {
                    if (!TextUtils.isEmpty(this.O0000Oo0)) {
                        str10 = this.O0000Oo0;
                    }
                    str12 = str5;
                }
                hob.O000000o().O000000o(ServiceApplication.getAppContext(), O000000o2.f11210O000000o, str12, str10, jSONObject, jSONArray, new fsm<JSONObject, fso>() {
                    /* class _m_j.hrf.AnonymousClass3 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        hrf.this.O00000oO = false;
                        try {
                            O000000o2.f11210O000000o = jSONObject.getString("us_id");
                            O000000o2.O0000o0o = jSONObject.optInt("status", 0);
                            if (plugTimer2 != null) {
                                plugTimer2.O0000Oo = O000000o2.f11210O000000o;
                                plugTimer2.O0000Oo0 = O000000o2.O0000o0o;
                            }
                        } catch (JSONException unused) {
                        }
                        hrf.this.O0000O0o.clear();
                        hrf.this.O0000O0o.addAll(hrf.this.O0000OOo);
                        O00000Oo o00000Oo = o00000Oo2;
                        if (o00000Oo != null) {
                            o00000Oo.onSetSceneSuccess(O000000o2);
                        }
                        for (O00000Oo onSetSceneSuccess : hrf.this.O00000oo) {
                            onSetSceneSuccess.onSetSceneSuccess(O000000o2);
                        }
                        hrf hrf = hrf.this;
                        hrf.O000000o(hrf.O00000oo().toString());
                    }

                    public final void onFailure(fso fso) {
                        hrf hrf = hrf.this;
                        hrf.O00000oO = false;
                        hrf.O0000OOo.clear();
                        hrf.this.O0000OOo.addAll(hrf.this.O0000O0o);
                        O00000Oo o00000Oo = o00000Oo2;
                        if (o00000Oo != null) {
                            o00000Oo.onSetSceneFailed(fso);
                        }
                        for (O00000Oo onSetSceneFailed : hrf.this.O00000oo) {
                            onSetSceneFailed.onSetSceneFailed(fso);
                        }
                    }
                });
                return;
            }
            return;
        }
        commonTimer = null;
        this.O0000OOo.remove(commonTimer);
        final CommonTimer O000000o22 = CommonTimer.O000000o(plugTimer2, str, str3, str2, str4);
        this.O0000OOo.add(O000000o22);
        if (this.O00000oO) {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Calendar.roll(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.Calendar.roll(int, int):void}
      ClspMth{java.util.Calendar.roll(int, boolean):void} */
    public void O000000o(CommonTimer commonTimer, boolean z, O00000Oo o00000Oo, String str) {
        Calendar calendar;
        boolean z2 = z;
        CommonTimer commonTimer2 = (CommonTimer) commonTimer.clone();
        commonTimer2.O00000oo = z2;
        if (z2) {
            Calendar instance = Calendar.getInstance();
            boolean z3 = false;
            instance.set(13, 0);
            Calendar calendar2 = null;
            if (!commonTimer2.O0000OoO || commonTimer2.O0000o0 == null || commonTimer2.O0000o0.O00000o == -1 || commonTimer2.O0000o0.O00000oO == -1 || commonTimer2.O0000o0.O00000oo == -1) {
                calendar = null;
            } else {
                calendar = Calendar.getInstance();
                calendar.set(1, commonTimer2.O0000o0.O00000oo);
                calendar.set(2, commonTimer2.O0000o0.O00000oO - 1);
                calendar.set(5, commonTimer2.O0000o0.O00000o);
                calendar.set(11, commonTimer2.O0000o0.O00000o0);
                calendar.set(12, commonTimer2.O0000o0.O00000Oo);
                calendar.set(13, 0);
            }
            if (!(!commonTimer2.O0000O0o || commonTimer2.O0000Oo == null || commonTimer2.O0000Oo.O00000o == -1 || commonTimer2.O0000Oo.O00000oO == -1 || commonTimer2.O0000Oo.O00000oo == -1)) {
                calendar2 = Calendar.getInstance();
                calendar2.set(1, commonTimer2.O0000Oo.O00000oo);
                calendar2.set(2, commonTimer2.O0000Oo.O00000oO - 1);
                calendar2.set(5, commonTimer2.O0000Oo.O00000o);
                calendar2.set(11, commonTimer2.O0000Oo.O00000o0);
                calendar2.set(12, commonTimer2.O0000Oo.O00000Oo);
                calendar2.set(13, 0);
            }
            if (!commonTimer2.O0000O0o || !commonTimer2.O0000OoO ? !(!commonTimer2.O0000O0o ? !commonTimer2.O0000OoO || calendar == null || !calendar.before(instance) : calendar2 == null || !calendar2.before(instance)) : !(calendar2 == null || calendar == null || !calendar.before(instance))) {
                z3 = true;
            }
            if (z3) {
                if (commonTimer2.O0000O0o) {
                    calendar2.roll(5, true);
                    commonTimer2.O0000Oo.O00000oo = calendar2.get(1);
                    commonTimer2.O0000Oo.O00000o = calendar2.get(5);
                    commonTimer2.O0000Oo.O00000oO = calendar2.get(2) + 1;
                }
                if (commonTimer2.O0000OoO) {
                    calendar.roll(5, true);
                    commonTimer2.O0000o0.O00000oo = calendar.get(1);
                    commonTimer2.O0000o0.O00000o = calendar.get(5);
                    commonTimer2.O0000o0.O00000oO = calendar.get(2) + 1;
                }
            }
        }
        O000000o(commonTimer, commonTimer2, o00000Oo, str);
    }

    public void O00000o0(CommonTimer commonTimer) {
        this.O0000OOo.remove(commonTimer);
        O000000o(commonTimer, (O00000Oo) null);
    }

    public final void O000000o(List<CommonTimer> list, final O00000Oo o00000Oo) {
        this.O0000OOo.remove(list);
        if (!this.O00000oO) {
            this.O00000oO = true;
            ArrayList arrayList = new ArrayList();
            for (CommonTimer commonTimer : list) {
                arrayList.add(commonTimer.f11210O000000o);
            }
            hob.O000000o().O000000o(ServiceApplication.getAppContext(), arrayList, new fsm<Void, fso>() {
                /* class _m_j.hrf.AnonymousClass5 */

                public final void onFailure(fso fso) {
                    hrf hrf = hrf.this;
                    hrf.O00000oO = false;
                    hrf.O0000OOo.clear();
                    hrf.this.O0000OOo.addAll(hrf.this.O0000O0o);
                    O00000Oo o00000Oo = o00000Oo;
                    if (o00000Oo != null) {
                        o00000Oo.onSetSceneFailed(fso);
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    hrf hrf = hrf.this;
                    hrf.O00000oO = false;
                    hrf.O0000O0o.clear();
                    hrf.this.O0000O0o.addAll(hrf.this.O0000OOo);
                    O00000Oo o00000Oo = o00000Oo;
                    if (o00000Oo != null) {
                        o00000Oo.onSetSceneSuccess(null);
                    }
                    hrf hrf2 = hrf.this;
                    hrf2.O000000o(hrf2.O00000oo().toString());
                }
            });
        }
    }

    public final void O000000o(PlugTimer plugTimer, O00000Oo o00000Oo) {
        int i = 0;
        CommonTimer commonTimer = null;
        while (i < this.O0000OOo.size()) {
            try {
                CommonTimer commonTimer2 = this.O0000OOo.get(i);
                if (commonTimer2 != null && plugTimer.O0000Oo.equals(commonTimer2.f11210O000000o)) {
                    commonTimer = commonTimer2;
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.O0000OOo.remove(commonTimer);
        O000000o(commonTimer, o00000Oo);
    }

    public static float O000000o(Calendar calendar) {
        return ((((float) calendar.get(11)) * 60.0f) + ((float) calendar.get(12))) / 1440.0f;
    }

    public static List<Pair<Float, Float>> O000000o(List<PlugTimer> list) {
        PlugTimer plugTimer;
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (PlugTimer next : list) {
            Calendar instance = Calendar.getInstance();
            if (next.O00000Oo && !(next.O00000oO == null && next.O0000OOo == null)) {
                if (!next.O00000o0) {
                    plugTimer = (PlugTimer) next.clone();
                    plugTimer.O00000oO = (CorntabUtils.CorntabParam) next.O00000oO.clone();
                    plugTimer.O00000oO.O00000o0 = 0;
                    plugTimer.O00000oO.O00000Oo = 0;
                } else if (!next.O00000oo) {
                    plugTimer = (PlugTimer) next.clone();
                    plugTimer.O0000OOo = (CorntabUtils.CorntabParam) next.O0000OOo.clone();
                    plugTimer.O0000OOo.O00000o0 = 23;
                    plugTimer.O0000OOo.O00000Oo = 59;
                } else {
                    plugTimer = next;
                }
                float f = 1.0f;
                if (plugTimer.O00000oO.O00000Oo() == 0) {
                    Calendar instance2 = Calendar.getInstance();
                    instance2.set(instance.get(1), plugTimer.O00000oO.O00000oO - 1, plugTimer.O00000oO.O00000o, plugTimer.O00000oO.O00000o0, plugTimer.O00000oO.O00000Oo);
                    float f2 = 2.0f;
                    if (goz.O000000o(instance, instance2)) {
                        float O000000o2 = O000000o(instance2);
                        if (!next.O00000oo) {
                            f = 2.0f;
                        } else {
                            instance2.set(instance.get(1), plugTimer.O0000OOo.O00000oO - 1, plugTimer.O0000OOo.O00000o, plugTimer.O0000OOo.O00000o0, plugTimer.O0000OOo.O00000Oo);
                            if (goz.O000000o(instance, instance2)) {
                                f = O000000o(instance2);
                            } else {
                                instance.add(6, 1);
                                if (goz.O000000o(instance, instance2)) {
                                    f = 1.0f + O000000o(instance2);
                                }
                            }
                        }
                        arrayList.add(new Pair(Float.valueOf(O000000o2), Float.valueOf(f)));
                    } else {
                        instance.add(5, 1);
                        if (goz.O000000o(instance, instance2)) {
                            float O000000o3 = O000000o(instance2) + 1.0f;
                            if (next.O00000oo) {
                                instance2.set(instance.get(1), plugTimer.O0000OOo.O00000oO - 1, plugTimer.O0000OOo.O00000o, plugTimer.O0000OOo.O00000o0, plugTimer.O0000OOo.O00000Oo);
                                if (goz.O000000o(instance, instance2)) {
                                    f2 = O000000o(instance2) + 1.0f;
                                }
                            }
                            arrayList.add(new Pair(Float.valueOf(O000000o3), Float.valueOf(f2)));
                        } else {
                            instance.add(5, -1);
                            instance2.set(instance.get(1), plugTimer.O0000OOo.O00000oO - 1, plugTimer.O0000OOo.O00000o, plugTimer.O0000OOo.O00000o0, plugTimer.O0000OOo.O00000Oo);
                            if (goz.O000000o(instance, instance2)) {
                                f2 = O000000o(instance2);
                            }
                            arrayList.add(new Pair(Float.valueOf(0.0f), Float.valueOf(f2)));
                        }
                    }
                } else if (plugTimer.O00000oO.O00000Oo() == 62) {
                    Pair<Float, Float> O000000o4 = O000000o(instance, plugTimer);
                    int i = instance.get(7);
                    if (i == 7) {
                        if (((double) ((Float) O000000o4.second).floatValue()) > 1.0d) {
                            arrayList.add(O000000o4);
                        }
                    } else if (i == 1) {
                        arrayList.add(new Pair(Float.valueOf(((Float) O000000o4.first).floatValue() + 1.0f), Float.valueOf(((Float) O000000o4.second).floatValue() + 1.0f)));
                    } else if (O000000o(instance) <= ((Float) O000000o4.second).floatValue()) {
                        arrayList.add(O000000o4);
                    } else if (i != 6) {
                        arrayList.add(new Pair(Float.valueOf(((Float) O000000o4.first).floatValue() + 1.0f), Float.valueOf(((Float) O000000o4.second).floatValue() + 1.0f)));
                    }
                } else if (plugTimer.O00000oO.O00000Oo() == 65) {
                    Pair<Float, Float> O000000o5 = O000000o(instance, plugTimer);
                    int i2 = instance.get(7);
                    if (i2 == 6) {
                        arrayList.add(new Pair(Float.valueOf(((Float) O000000o5.first).floatValue() + 1.0f), Float.valueOf(((Float) O000000o5.second).floatValue() + 1.0f)));
                    } else if (i2 == 7) {
                        if (O000000o(instance) <= ((Float) O000000o5.second).floatValue()) {
                            arrayList.add(O000000o5);
                        } else {
                            arrayList.add(new Pair(Float.valueOf(((Float) O000000o5.first).floatValue() + 1.0f), Float.valueOf(((Float) O000000o5.second).floatValue() + 1.0f)));
                        }
                    } else if (i2 == 1) {
                        if (O000000o(instance) <= ((Float) O000000o5.second).floatValue()) {
                            arrayList.add(O000000o5);
                        }
                    } else if (i2 == 2 && O000000o(instance) <= ((Float) O000000o5.second).floatValue()) {
                        arrayList.add(O000000o5);
                    }
                } else if (plugTimer.O00000oO.O00000Oo() == 127) {
                    Pair<Float, Float> O000000o6 = O000000o(instance, plugTimer);
                    if (O000000o(instance) <= ((Float) O000000o6.second).floatValue()) {
                        arrayList.add(O000000o6);
                    } else {
                        arrayList.add(new Pair(Float.valueOf(((Float) O000000o6.first).floatValue() + 1.0f), Float.valueOf(((Float) O000000o6.second).floatValue() + 1.0f)));
                    }
                } else if (plugTimer.O00000oO.O0000O0o != null) {
                    int i3 = instance.get(7);
                    boolean[] zArr = plugTimer.O00000oO.O0000O0o;
                    if (plugTimer.O00000oO.O0000O0o.length < 7) {
                        zArr = Arrays.copyOf(zArr, 7);
                    }
                    Pair<Float, Float> O000000o7 = O000000o(instance, plugTimer);
                    float O000000o8 = O000000o(instance);
                    int i4 = i3 - 1;
                    if (!zArr[i4]) {
                        if (zArr[i4 > 0 ? i3 - 2 : i3 + 5] && ((Float) O000000o7.second).floatValue() > 1.0f) {
                            double d = (double) O000000o8;
                            double floatValue = (double) ((Float) O000000o7.second).floatValue();
                            Double.isNaN(floatValue);
                            if (d <= floatValue - 1.0d) {
                                arrayList.add(new Pair(Float.valueOf(0.0f), Float.valueOf(((Float) O000000o7.second).floatValue() - 1.0f)));
                            }
                        }
                        if (zArr[i3 % 7]) {
                            arrayList.add(new Pair(Float.valueOf(((Float) O000000o7.first).floatValue() + 1.0f), Float.valueOf(((Float) O000000o7.second).floatValue() + 1.0f)));
                        }
                    } else if (O000000o8 <= ((Float) O000000o7.second).floatValue()) {
                        arrayList.add(O000000o7);
                    } else if (zArr[i3 % 7]) {
                        arrayList.add(new Pair(Float.valueOf(((Float) O000000o7.first).floatValue() + 1.0f), Float.valueOf(((Float) O000000o7.second).floatValue() + 1.0f)));
                    }
                }
            }
        }
        return arrayList;
    }

    private static Pair<Float, Float> O000000o(Calendar calendar, PlugTimer plugTimer) {
        Calendar instance = Calendar.getInstance();
        Calendar calendar2 = instance;
        calendar2.set(calendar.get(1), calendar.get(2), calendar.get(6), plugTimer.O00000oO.O00000o0, plugTimer.O00000oO.O00000Oo);
        float O000000o2 = O000000o(instance);
        calendar2.set(calendar.get(1), calendar.get(2), calendar.get(6), plugTimer.O0000OOo.O00000o0, plugTimer.O0000OOo.O00000Oo);
        float O000000o3 = O000000o(instance);
        if (O000000o3 < O000000o2) {
            O000000o3 += 1.0f;
        }
        return new Pair<>(Float.valueOf(O000000o2), Float.valueOf(O000000o3));
    }
}

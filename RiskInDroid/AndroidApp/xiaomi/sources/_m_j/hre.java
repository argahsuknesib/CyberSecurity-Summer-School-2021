package _m_j;

import _m_j.hrf;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.scene.model.CorntabUtils;
import com.xiaomi.smarthome.scene.timer.CommonTimer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hre extends hrf {
    private static hre O0000Oo0;

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f545O000000o = false;
    public List<hrf.O00000Oo> O00000Oo = new ArrayList();
    private String O0000Oo;
    private String O0000OoO;
    private SharedPreferences O0000Ooo;
    private List<List<CommonTimer>> O0000o00 = new ArrayList();

    public static hre O000000o() {
        if (O0000Oo0 == null) {
            O0000Oo0 = new hre();
        }
        return O0000Oo0;
    }

    private hre() {
        this.O0000O0o = new ArrayList();
        this.O0000OOo = new ArrayList();
    }

    public final void O000000o(hrf.O00000Oo o00000Oo) {
        super.O000000o(o00000Oo);
        if (!this.O00000Oo.contains(o00000Oo)) {
            this.O00000Oo.add(o00000Oo);
        }
    }

    public final void O00000Oo(hrf.O00000Oo o00000Oo) {
        this.O00000Oo.remove(o00000Oo);
    }

    public final void O000000o(Device device, String str, String str2) {
        this.O00000o0 = device;
        this.O0000Oo = str;
        this.O0000OoO = str2;
        this.O0000O0o.clear();
        Context appContext = ServiceApplication.getAppContext();
        this.O0000Ooo = appContext.getSharedPreferences("common.timer.shared.prefs" + this.O00000o0.userId + this.O00000o0.did + this.O0000Oo + "_group", 0);
        try {
            O00000oO();
        } catch (JSONException unused) {
        }
    }

    public final List<CommonTimer> O00000Oo() {
        if (this.O0000O0o == null || this.O0000O0o.size() <= 0) {
            return this.O0000O0o;
        }
        ArrayList arrayList = new ArrayList();
        for (CommonTimer commonTimer : this.O0000O0o) {
            if (commonTimer != null) {
                if (TextUtils.isEmpty(commonTimer.O0000o0O)) {
                    arrayList.add(commonTimer);
                } else if ("0".equals(commonTimer.O0000o0O)) {
                    arrayList.add(commonTimer);
                }
            }
        }
        return arrayList;
    }

    public final List<CommonTimer> O00000o0() {
        return this.O0000O0o;
    }

    public final List<List<CommonTimer>> O00000o() {
        return this.O0000o00;
    }

    class O000000o implements Comparator<CommonTimer> {
        private O000000o() {
        }

        /* synthetic */ O000000o(hre hre, byte b) {
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

    public final void O00000oO() throws JSONException {
        String string = this.O0000Ooo.getString("common.setting", null);
        if (string != null) {
            gsy.O000000o(3, "TimerCommonGroupManager", "readSharedPrefs reading :");
            List<CommonTimer> O00000o0 = O00000o0(new JSONObject(string));
            this.O0000O0o.clear();
            this.O0000O0o.addAll(O00000o0);
            this.O0000OOo.clear();
            this.O0000OOo.addAll(O00000o0);
        } else {
            gsy.O000000o(3, "TimerCommonGroupManager", "readSharedPrefs failure");
            this.O0000O0o.clear();
            this.O0000OOo.clear();
        }
        for (hrf.O00000Oo onGetSceneSuccess : this.O00000Oo) {
            onGetSceneSuccess.onGetSceneSuccess();
        }
    }

    public final void O000000o(String str) {
        SharedPreferences.Editor edit = this.O0000Ooo.edit();
        edit.remove("common.setting");
        if (str != null) {
            edit.putString("common.setting", str);
        }
        edit.apply();
    }

    public final void O00000Oo(String str) {
        if (!this.f545O000000o) {
            this.f545O000000o = true;
            boolean z = !TextUtils.isEmpty(str);
            gsy.O000000o(3, "TimerCommonGroupManager", "getScene start:");
            hob O000000o2 = hob.O000000o();
            Context appContext = ServiceApplication.getAppContext();
            String str2 = this.O00000o0.did;
            if (!z) {
                str = this.O0000Oo;
            }
            O000000o2.O000000o(appContext, str2, str, new fsm<JSONObject, fso>() {
                /* class _m_j.hre.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    hre.this.f545O000000o = false;
                    gsy.O000000o(3, "TimerCommonGroupManager", "getScene result: " + jSONObject.toString());
                    if (jSONObject != null) {
                        hre.this.O000000o(jSONObject);
                        hre hre = hre.this;
                        hre.O000000o(hre.O00000oo().toString());
                    } else {
                        hre.this.O000000o((String) null);
                    }
                    for (hrf.O00000Oo onGetSceneSuccess : hre.this.O00000Oo) {
                        onGetSceneSuccess.onGetSceneSuccess();
                    }
                }

                public final void onFailure(fso fso) {
                    hre.this.f545O000000o = false;
                    gsy.O000000o(3, "TimerCommonGroupManager", "getScene error: " + fso.f17063O000000o);
                    for (hrf.O00000Oo onGetSceneFailed : hre.this.O00000Oo) {
                        onGetSceneFailed.onGetSceneFailed(fso.f17063O000000o);
                    }
                }
            }, z);
        }
    }

    private CommonTimer O00000o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        CommonTimer commonTimer = new CommonTimer();
        commonTimer.f11210O000000o = jSONObject.optString("us_id");
        commonTimer.O00000o0 = jSONObject.optString("identify");
        JSONObject optJSONObject = jSONObject.optJSONObject("setting");
        commonTimer.O00000oO = optJSONObject.optString("enable_push").equals("1");
        commonTimer.O00000oo = optJSONObject.optString("enable_timer").equals("1");
        commonTimer.O0000O0o = optJSONObject.optString("enable_timer_on").equals("1");
        commonTimer.O0000OOo = optJSONObject.optString("on_method");
        commonTimer.O0000Oo0 = O000000o(optJSONObject, "on_param");
        commonTimer.O0000Oo = CorntabUtils.O000000o(optJSONObject.optString("on_time"));
        if (commonTimer.O0000Oo == null) {
            commonTimer.O0000Oo = new CorntabUtils.CorntabParam();
        } else {
            commonTimer.O0000Oo = CorntabUtils.O00000Oo(TimeZone.getDefault(), TimeZone.getTimeZone("Asia/Shanghai"), commonTimer.O0000Oo);
        }
        commonTimer.O0000OoO = optJSONObject.optString("enable_timer_off").equals("1");
        commonTimer.O0000Ooo = optJSONObject.optString("off_method");
        commonTimer.O0000o00 = O000000o(optJSONObject, "off_param");
        commonTimer.O0000o0 = CorntabUtils.O000000o(optJSONObject.optString("off_time"));
        if (commonTimer.O0000o0 == null) {
            commonTimer.O0000o0 = new CorntabUtils.CorntabParam();
        } else {
            commonTimer.O0000o0 = CorntabUtils.O00000Oo(TimeZone.getDefault(), TimeZone.getTimeZone("Asia/Shanghai"), commonTimer.O0000o0);
        }
        String optString = optJSONObject.optString("on_filter");
        if (!TextUtils.isEmpty(optString)) {
            commonTimer.O0000Oo.O0000OOo = optString;
        }
        String optString2 = optJSONObject.optString("off_filter");
        if (!TextUtils.isEmpty(optString2)) {
            commonTimer.O0000o0.O0000OOo = optString2;
        }
        commonTimer.O0000o0o = jSONObject.optInt("status", 0);
        String optString3 = jSONObject.optString("timer_type");
        if (!TextUtils.isEmpty(optString3)) {
            commonTimer.O0000o0O = optString3;
        }
        return commonTimer;
    }

    public final void O000000o(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                JSONArray optJSONArray = jSONObject.optJSONArray(keys.next());
                if (optJSONArray != null) {
                    ArrayList arrayList3 = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            CommonTimer O00000o = O00000o(optJSONObject);
                            if (TextUtils.equals(O00000o.O00000o0, this.O00000o0.did)) {
                                arrayList.add(O00000o);
                            } else {
                                arrayList3.add(O00000o);
                            }
                        }
                    }
                    if (arrayList3.size() > 0) {
                        Collections.sort(arrayList3, new O000000o(this, (byte) 0));
                        arrayList2.add(arrayList3);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(arrayList, new O000000o(this, (byte) 0));
        this.O0000O0o = arrayList;
        this.O0000OOo.clear();
        this.O0000OOo.addAll(arrayList);
        this.O0000o00 = arrayList2;
    }

    public final List<CommonTimer> O00000Oo(JSONObject jSONObject) {
        JSONObject optJSONObject;
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext() && (optJSONObject = jSONObject.optJSONObject(keys.next())) != null) {
                gsy.O000000o(3, "TimerCommonGroupManager", "jsonObj:" + optJSONObject.toString());
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
                commonTimer.O0000o0o = optJSONObject.optInt("status", 0);
                arrayList.add(commonTimer);
            }
        } catch (Exception unused) {
        }
        Collections.sort(arrayList, new O000000o(this, (byte) 0));
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final String O000000o(JSONObject jSONObject, String str) {
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
    public final Object O00000o0(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return new JSONObject(str);
    }

    public final JSONObject O00000oo() {
        String str;
        String str2;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            for (CommonTimer commonTimer : this.O0000O0o) {
                gsy.O000000o(3, "TimerCommonGroupManager", "timerToJson:" + commonTimer.O00000o0 + commonTimer.f11210O000000o);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("us_id", commonTimer.f11210O000000o);
                jSONObject2.put("identify", commonTimer.O00000o0);
                String str3 = "1";
                jSONObject2.put("enable_push", commonTimer.O00000oO ? str3 : "0");
                if (commonTimer.O00000oo) {
                    str = str3;
                } else {
                    str = "0";
                }
                jSONObject2.put("enable_timer", str);
                if (commonTimer.O0000OoO) {
                    str2 = str3;
                } else {
                    str2 = "0";
                }
                jSONObject2.put("enable_timer_off", str2);
                if (!commonTimer.O0000O0o) {
                    str3 = "0";
                }
                jSONObject2.put("enable_timer_on", str3);
                jSONObject2.put("off_method", O00000o0(commonTimer.O0000Ooo));
                jSONObject2.put("off_param", O00000o0(commonTimer.O0000o00));
                jSONObject2.put("off_time", CorntabUtils.O000000o(commonTimer.O0000o0));
                jSONObject2.put("on_method", O00000o0(commonTimer.O0000OOo));
                jSONObject2.put("on_param", O00000o0(commonTimer.O0000Oo0));
                jSONObject2.put("on_time", CorntabUtils.O000000o(commonTimer.O0000Oo));
                jSONObject2.put("status", commonTimer.O0000o0o);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("setting", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final List<CommonTimer> O00000o0(JSONObject jSONObject) {
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
                    commonTimer.O0000o0o = optJSONObject.optInt("status", 0);
                    arrayList.add(commonTimer);
                }
            }
        } catch (JSONException unused) {
        }
        return arrayList;
    }

    public final void O000000o(final CommonTimer commonTimer, final hrf.O00000Oo o00000Oo) {
        gsy.O000000o(3, "TimerCommonGroupManager", "deleteTimerScene");
        if (!this.f545O000000o) {
            this.f545O000000o = true;
            gsy.O000000o(3, "TimerCommonGroupManager", "mIsLoading" + this.f545O000000o);
            hob.O000000o().O00000Oo(ServiceApplication.getAppContext(), commonTimer.f11210O000000o, new fsm<JSONObject, fso>() {
                /* class _m_j.hre.AnonymousClass2 */

                public final void onFailure(fso fso) {
                    hre.this.f545O000000o = false;
                    gsy.O000000o(3, "TimerCommonGroupManager", "delete failed: " + fso.f17063O000000o);
                    hre.this.O0000OOo.clear();
                    hre.this.O0000OOo.addAll(hre.this.O0000O0o);
                    hrf.O00000Oo o00000Oo = o00000Oo;
                    if (o00000Oo != null) {
                        o00000Oo.onSetSceneFailed(fso);
                    }
                    for (hrf.O00000Oo onSetSceneSuccess : hre.this.O00000Oo) {
                        onSetSceneSuccess.onSetSceneSuccess(commonTimer);
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    hre.this.f545O000000o = false;
                    gsy.O000000o(3, "TimerCommonGroupManager", "delete success");
                    hre.this.O0000O0o.clear();
                    hre.this.O0000O0o.addAll(hre.this.O0000OOo);
                    hrf.O00000Oo o00000Oo = o00000Oo;
                    if (o00000Oo != null) {
                        o00000Oo.onSetSceneSuccess(commonTimer);
                    }
                    for (hrf.O00000Oo onSetSceneSuccess : hre.this.O00000Oo) {
                        onSetSceneSuccess.onSetSceneSuccess(commonTimer);
                    }
                    hre hre = hre.this;
                    hre.O000000o(hre.O00000oo().toString());
                }
            });
        }
    }

    public final boolean O000000o(CommonTimer commonTimer) {
        if (!commonTimer.O0000O0o || !commonTimer.O0000OoO || (commonTimer.O0000Oo.O00000o0 * 60) + commonTimer.O0000Oo.O00000Oo != (commonTimer.O0000o0.O00000o0 * 60) + commonTimer.O0000o0.O00000Oo) {
            return true;
        }
        return false;
    }

    public final void O00000Oo(CommonTimer commonTimer) {
        gsy.O000000o(3, "TimerCommonGroupManager", "us_id:" + commonTimer.f11210O000000o + "name:" + commonTimer.O00000o0 + "onMethod:" + commonTimer.O0000OOo + "onParams:" + commonTimer.O0000Oo0 + "offMethod:" + commonTimer.O0000Ooo + "offParams:" + commonTimer.O0000o00 + "enablePush:" + commonTimer.O00000oO + " enable:" + commonTimer.O00000oo + " on:" + commonTimer.O0000O0o + " onRepeat:" + commonTimer.O0000Oo.O000000o(ServiceApplication.getAppContext()) + " onHour:" + commonTimer.O0000Oo.O00000o0 + " onMin:" + commonTimer.O0000Oo.O00000Oo + " off:" + commonTimer.O0000OoO + " offRepeat:" + commonTimer.O0000o0.O000000o(ServiceApplication.getAppContext()) + " offHour:" + commonTimer.O0000o0.O00000o0 + " offMin:" + commonTimer.O0000o0.O00000Oo);
    }

    public final void O000000o(CommonTimer commonTimer, CommonTimer commonTimer2, String str) {
        O000000o(commonTimer, commonTimer2, (hrf.O00000Oo) null, str);
    }

    public final void O000000o(CommonTimer commonTimer, CommonTimer commonTimer2, hrf.O00000Oo o00000Oo, String str) {
        gsy.O000000o(3, "TimerCommonGroupManager", "originTimer: ");
        O00000Oo(commonTimer);
        gsy.O000000o(3, "TimerCommonGroupManager", "newTimer: ");
        O00000Oo(commonTimer2);
        if (this.O0000OOo.isEmpty()) {
            this.O0000OOo.add(commonTimer2);
        } else {
            for (int i = 0; i < this.O0000OOo.size(); i++) {
                if (TextUtils.equals(((CommonTimer) this.O0000OOo.get(i)).f11210O000000o, commonTimer.f11210O000000o)) {
                    this.O0000OOo.remove(i);
                }
            }
            this.O0000OOo.add(commonTimer2);
        }
        Collections.sort(this.O0000OOo, new O000000o(this, (byte) 0));
        O000000o(commonTimer2, o00000Oo, str);
    }

    public final void O000000o(CommonTimer commonTimer, boolean z, hrf.O00000Oo o00000Oo, String str) {
        CommonTimer commonTimer2 = (CommonTimer) commonTimer.clone();
        commonTimer2.O00000oo = z;
        if (z) {
            Calendar instance = Calendar.getInstance();
            if (!(!commonTimer2.O0000O0o || commonTimer2.O0000Oo == null || commonTimer2.O0000Oo.O00000o == -1)) {
                if ((commonTimer2.O0000Oo.O00000o0 * 60) + commonTimer2.O0000Oo.O00000Oo <= (instance.get(11) * 60) + instance.get(12)) {
                    instance.add(5, 1);
                }
                commonTimer2.O0000Oo.O00000o = instance.get(5);
                commonTimer2.O0000Oo.O00000oO = instance.get(2) + 1;
            }
            if (!(!commonTimer2.O0000OoO || commonTimer2.O0000o0 == null || commonTimer2.O0000o0.O00000o == -1)) {
                if ((commonTimer2.O0000o0.O00000o0 * 60) + commonTimer2.O0000o0.O00000Oo <= (instance.get(11) * 60) + instance.get(12)) {
                    instance.add(5, 1);
                }
                commonTimer2.O0000o0.O00000o = instance.get(5);
                commonTimer2.O0000o0.O00000oO = instance.get(2) + 1;
            }
        }
        O000000o(commonTimer, commonTimer2, o00000Oo, str);
    }

    public final void O00000o0(CommonTimer commonTimer) {
        this.O0000OOo.remove(commonTimer);
        O000000o(commonTimer, (hrf.O00000Oo) null);
    }
}

package _m_j;

import _m_j.fat;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mmkv.MMKV;
import com.xiaomi.smarthome.AppConfigHelper;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.sdk.SyncConfigCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class eyr {
    private static volatile eyr O00O0Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f15951O000000o = false;
    AppConfigHelper O00000Oo;
    public boolean O00000o = false;
    public List<String> O00000o0 = new ArrayList();
    public int O00000oO = 0;
    public List<String> O00000oo = new ArrayList();
    public boolean O0000O0o = false;
    public int O0000OOo = 0;
    public List<String> O0000Oo = new ArrayList();
    public List<String> O0000Oo0 = new ArrayList();
    public List<String> O0000OoO = new ArrayList();
    public boolean O0000Ooo = false;
    public List<String> O0000o = new ArrayList();
    public List<String> O0000o0 = new ArrayList();
    public int O0000o00 = 0;
    public boolean O0000o0O = false;
    public int O0000o0o = 0;
    public List<String> O0000oO = new ArrayList();
    public List<String> O0000oO0 = new ArrayList();
    public List<String> O0000oOO = new ArrayList();
    public List<String> O0000oOo = new ArrayList();
    public int O0000oo = 2000;
    public List<String> O0000oo0 = new ArrayList();
    public boolean O0000ooO = false;
    public int O0000ooo = 0;
    public int O000O00o = 2000;
    public List<String> O000O0OO = new ArrayList();
    public int O000O0Oo = 2000;
    public int O000O0o = 0;
    public boolean O000O0o0 = false;
    public List<String> O000O0oO = new ArrayList();
    public boolean O000O0oo = false;
    public boolean O000OO = false;
    public int O000OO00 = 0;
    public List<String> O000OO0o = new ArrayList();
    public int O000OOOo = 0;
    public boolean O000OOo = false;
    public List<String> O000OOo0 = new ArrayList();
    public int O000OOoO = 0;
    public List<String> O000OOoo = new ArrayList();
    public int O000Oo0 = 0;
    public boolean O000Oo00 = false;
    public List<String> O000Oo0O = new ArrayList();
    public boolean O000Oo0o = false;
    private O000000o O000OoO;
    public int O000OoO0 = 0;
    private List<String> O000OoOO = new ArrayList();
    private boolean O000OoOo = false;
    private List<String> O000Ooo = new ArrayList();
    private int O000Ooo0 = 0;
    private boolean O000OooO = false;
    private int O000Oooo = 0;
    private List<String> O000o = new ArrayList();
    private boolean O000o0 = false;
    private boolean O000o00 = false;
    private List<String> O000o000 = new ArrayList();
    private int O000o00O = 0;
    private List<String> O000o00o = new ArrayList();
    private List<String> O000o0O = new ArrayList();
    private int O000o0O0 = 0;
    private List<String> O000o0OO = new ArrayList();
    private int O000o0Oo = 0;
    private boolean O000o0o = false;
    private List<String> O000o0o0 = new ArrayList();
    private int O000o0oo = 0;
    private List<String> O000oO = new ArrayList();
    private int O000oO0 = 0;
    private boolean O000oO00 = false;
    private boolean O000oO0O = false;
    private int O000oO0o = 0;
    private List<String> O000oOO = new ArrayList();
    private int O000oOO0 = 0;
    private int O000oOOO = fjt.f16501O000000o;
    private List<String> O000oOOo = new ArrayList();
    private int O000oOo = 0;
    private boolean O000oOo0 = false;
    private boolean O000oOoO = false;
    private int O000oOoo = 0;
    private List<String> O000oo = new ArrayList();
    private boolean O000oo0 = false;
    private int O000oo0O = 0;
    private Map<String, int[]> O000oo0o = new HashMap();
    private int O000ooO = 0;
    private boolean O000ooO0 = false;
    public int O00oOoOo = 1;
    public boolean O00oOooO = true;
    public List<String> O00oOooo = new ArrayList();

    public static MMKV O000000o() {
        return MMKV.O000000o("COM.MIJIA.AB.TEST.CONFIG");
    }

    private eyr() {
        gpq gpq = new gpq("SmartConfigGreyManager");
        gpq.start();
        this.O000OoO = new O000000o(gpq.getLooper());
        this.O00000Oo = new AppConfigHelper(CommonApplication.getAppContext());
    }

    public static eyr O00000Oo() {
        if (O00O0Oo == null) {
            synchronized (eyr.class) {
                if (O00O0Oo == null) {
                    O00O0Oo = new eyr();
                }
            }
        }
        return O00O0Oo;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.tencent.mmkv.MMKV.O00000Oo(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      com.tencent.mmkv.MMKV.O00000Oo(java.lang.String, int):int
      com.tencent.mmkv.MMKV.O00000Oo(java.lang.String, java.util.Set<java.lang.String>):java.util.Set<java.lang.String>
      com.tencent.mmkv.MMKV.O00000Oo(java.lang.String, java.lang.String):boolean
      com.tencent.mmkv.MMKV.O00000Oo(java.lang.String, boolean):boolean */
    public final void O000000o(SyncConfigCallback.Stub stub) {
        if (!this.f15951O000000o) {
            String O00000o02 = MMKV.O000000o("COM.MIJIA.AB.TEST.CONFIG").O00000o0("KEY.AB.TEST.JSON", null);
            if (!TextUtils.isEmpty(O00000o02)) {
                try {
                    JSONObject jSONObject = new JSONObject(O00000o02);
                    gsy.O00000Oo("SmartConfigGreyManager", "start parseConfigResult from local file");
                    O000000o(jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        fat fat = fat.O000000o.f16039O000000o;
        this.O000O0o0 = MMKV.O000000o("smart.config.cache").O00000Oo("key.abtest.b35.SWITCHER", false);
        fat fat2 = fat.O000000o.f16039O000000o;
        this.O000O0o = MMKV.O000000o("smart.config.cache").O00000Oo("key.abtest.b35.RANGE", 0);
        LogType logType = LogType.BLUETOOTH;
        gsy.O00000o0(logType, "SmartConfigGreyManager", "load 35 local config: switcher=" + this.O000O0o0 + ",range=" + this.O000O0o);
        if (!this.f15951O000000o) {
            Message obtain = Message.obtain();
            obtain.what = 1000;
            Bundle bundle = new Bundle();
            bundle.putBinder("cb", stub);
            obtain.setData(bundle);
            this.O000OoO.sendMessage(obtain);
        } else if (stub != null) {
            try {
                stub.onResponse(-1, "");
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean O000000o(boolean z, int i) {
        if (!z) {
            return false;
        }
        String O00000Oo2 = fcn.O000000o().O00000Oo();
        if (TextUtils.isEmpty(O00000Oo2)) {
            return false;
        }
        try {
            if (Integer.parseInt(O00000Oo2.substring(O00000Oo2.length() - 2)) > i) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean O000000o(String str, boolean z, int i, List<String> list) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() != 0 && z) {
            String O00000Oo2 = fcn.O000000o().O00000Oo();
            if (TextUtils.isEmpty(O00000Oo2)) {
                return false;
            }
            try {
                if (Integer.parseInt(O00000Oo2.substring(O00000Oo2.length() - 2)) > i) {
                    return false;
                }
                if ("all".equalsIgnoreCase(list.get(0))) {
                    return true;
                }
                for (String equalsIgnoreCase : list) {
                    if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean O000000o(String str, List<String> list) {
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            if ("all".equalsIgnoreCase(list.get(0))) {
                return true;
            }
            for (String equalsIgnoreCase : list) {
                if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean O000000o(String str) {
        return O000000o(str, this.O000OoOo, this.O000Ooo0, this.O000OoOO);
    }

    public final boolean O00000Oo(String str) {
        return O000000o(str, this.O000OooO, this.O000Oooo, this.O000Ooo);
    }

    public final boolean O00000o0(String str) {
        return O000000o(str, this.O000o00, this.O000o00O, this.O000o000);
    }

    public final boolean O00000o(String str) {
        return O000000o(str, this.O000o0, this.O000o0O0, this.O000o00o);
    }

    public final boolean O00000oO(String str) {
        return O000000o(str, this.O000oOo0, this.O000oOo, this.O000oOOo);
    }

    public static boolean O00000oo(String str) {
        return "xiaomi.repeater.v6".equalsIgnoreCase(str);
    }

    public final boolean O0000O0o(String str) {
        return O000000o(str, true, 100, this.O000o0O);
    }

    public final boolean O00000o0() {
        return O000000o(this.O000oOoO, this.O000oOoo);
    }

    public final int[] O0000OOo(String str) {
        Map<String, int[]> map = this.O000oo0o;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final int O0000Oo0(String str) {
        if (O000000o(str, this.O000o0OO)) {
            return this.O000o0Oo;
        }
        return 0;
    }

    public final int O0000Oo(String str) {
        if (O000000o(str, this.O000oO)) {
            return this.O000oOO0;
        }
        return 0;
    }

    public final int O0000OoO(String str) {
        if (O000000o(str, this.O000oOO)) {
            return this.O000oOOO;
        }
        return fjt.f16501O000000o;
    }

    public final boolean O0000Ooo(String str) {
        return O000000o(str, true, 100, this.O0000oo0);
    }

    class O000000o extends Handler {
        O000000o(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            IBinder binder;
            super.handleMessage(message);
            if (message.what == 1000) {
                gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "get smartconfig appconfig from server");
                Bundle data = message.getData();
                SyncConfigCallback syncConfigCallback = null;
                if (!(data == null || (binder = data.getBinder("cb")) == null)) {
                    syncConfigCallback = SyncConfigCallback.Stub.asInterface(binder);
                }
                eyr eyr = eyr.this;
                eyr.O00000Oo.O000000o("mijia_grey_control_confignet", "1", "zh_CN", (String) null, new AppConfigHelper.O00000Oo() {
                    /* class _m_j.eyr.AnonymousClass1 */

                    public final boolean O000000o(String str) throws Exception {
                        return false;
                    }

                    public final boolean O00000Oo(String str) throws Exception {
                        return false;
                    }
                }, new AppConfigHelper.O000000o(syncConfigCallback) {
                    /* class _m_j.eyr.AnonymousClass2 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ SyncConfigCallback f15953O000000o;

                    {
                        this.f15953O000000o = r2;
                    }

                    /* renamed from: O000000o */
                    public final void onSuccess(String str, Response response) {
                        try {
                            gsy.O00000Oo("SmartConfigGreyManager", str);
                            eyr.O000000o().O00000Oo("KEY.AB.TEST.JSON", str);
                            JSONObject jSONObject = new JSONObject(str);
                            gsy.O00000Oo("SmartConfigGreyManager", "start parseConfigResult from remote");
                            eyr.this.O000000o(jSONObject);
                            eyr.this.f15951O000000o = true;
                        } catch (Exception e) {
                            gsy.O000000o(6, "SmartConfigGreyManager", Log.getStackTraceString(e));
                        }
                        SyncConfigCallback syncConfigCallback = this.f15953O000000o;
                        if (syncConfigCallback != null) {
                            try {
                                syncConfigCallback.onResponse(0, "");
                            } catch (RemoteException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }

                    public final void onFailure(gsf gsf, Exception exc, Response response) {
                        gsy.O000000o(6, "SmartConfigGreyManager", "loadConfigFromServer onFailure");
                        SyncConfigCallback syncConfigCallback = this.f15953O000000o;
                        if (syncConfigCallback != null) {
                            try {
                                syncConfigCallback.onResponse(-1, "");
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        }
    }

    public final void O000000o(JSONObject jSONObject) {
        try {
            O000000o(jSONObject, "A1", this.O000OoOO);
            JSONObject optJSONObject = jSONObject.optJSONObject("B1");
            this.O000Ooo0 = Integer.parseInt(optJSONObject.optString("gs"));
            this.O000OoOo = optJSONObject.optString("v").equals("1");
        } catch (Exception unused) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a1 b1 parse failed!");
        }
        try {
            O000000o(jSONObject, "A2", this.O000Ooo);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("B2");
            this.O000Oooo = Integer.parseInt(optJSONObject2.optString("gs"));
            this.O000OooO = optJSONObject2.optString("v").equals("1");
        } catch (Exception unused2) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a2 b2 parse failed!");
        }
        try {
            O000000o(jSONObject, "A4", this.O00000o0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("B4");
            this.O00000oO = Integer.parseInt(optJSONObject3.optString("gs"));
            this.O00000o = optJSONObject3.optString("v").equals("1");
        } catch (Exception unused3) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a4 b4 parse failed!");
        }
        try {
            O000000o(jSONObject, "A5", this.O00000oo);
            JSONObject optJSONObject4 = jSONObject.optJSONObject("B5");
            this.O0000OOo = Integer.parseInt(optJSONObject4.optString("gs"));
            this.O0000O0o = optJSONObject4.optString("v").equals("1");
        } catch (Exception unused4) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a5 b5 parse failed!");
        }
        try {
            O000000o(jSONObject, "A6", this.O000o000);
            JSONObject optJSONObject5 = jSONObject.optJSONObject("B6");
            this.O000o00O = Integer.parseInt(optJSONObject5.optString("gs"));
            this.O000o00 = optJSONObject5.optString("v").equals("1");
        } catch (Exception unused5) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a6 b6 parse failed!");
        }
        try {
            O000000o(jSONObject, "A7", this.O0000Oo0);
        } catch (Exception unused6) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a7 parse failed!");
        }
        try {
            O000000o(jSONObject, "A8", this.O000o00o);
            JSONObject optJSONObject6 = jSONObject.optJSONObject("B8");
            this.O000o0O0 = Integer.parseInt(optJSONObject6.optString("gs"));
            this.O000o0 = optJSONObject6.optString("v").equals("1");
        } catch (Exception unused7) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a8 b8 parse failed!");
        }
        try {
            O000000o(jSONObject, "A9", this.O0000Oo);
        } catch (Exception unused8) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a9 parse failed!");
        }
        try {
            O000000o(jSONObject, "A10", this.O000o0O);
        } catch (Exception unused9) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a10 parse failed!");
        }
        try {
            O000000o(jSONObject, "A11", this.O0000OoO);
            JSONObject optJSONObject7 = jSONObject.optJSONObject("B11");
            this.O0000o00 = Integer.parseInt(optJSONObject7.optString("gs"));
            this.O0000Ooo = optJSONObject7.optString("v").equals("1");
        } catch (Exception unused10) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a11 b11 parse failed!");
        }
        try {
            O000000o(jSONObject, "A12", this.O0000o0);
            JSONObject optJSONObject8 = jSONObject.optJSONObject("B12");
            this.O0000o0o = Integer.parseInt(optJSONObject8.optString("gs"));
            this.O0000o0O = optJSONObject8.optString("v").equals("1");
        } catch (Exception unused11) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a12 b12 parse failed!");
        }
        try {
            O000000o(jSONObject, "A13", this.O0000o);
        } catch (Exception unused12) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a13 parse failed!");
        }
        try {
            O000000o(jSONObject, "A14", this.O0000oO0);
        } catch (Exception unused13) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a14 parse failed!");
        }
        try {
            O000000o(jSONObject, "A15", this.O000o0OO);
            this.O000o0Oo = O00000Oo(jSONObject.getJSONObject("N15"));
        } catch (Exception unused14) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a15 parse failed!");
        }
        try {
            O000000o(jSONObject, "A16", this.O000o0o0);
            JSONObject optJSONObject9 = jSONObject.optJSONObject("B16");
            this.O000o0oo = Integer.parseInt(optJSONObject9.optString("gs"));
            this.O000o0o = optJSONObject9.optString("v").equals("1");
        } catch (Exception unused15) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a16, b16 parse failed!");
        }
        try {
            O000000o(jSONObject, "A19", this.O0000oO);
        } catch (Exception unused16) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a19 parse failed!");
        }
        try {
            O000000o(jSONObject, "A20", this.O000o);
            JSONObject optJSONObject10 = jSONObject.optJSONObject("B20");
            this.O000oO0 = Integer.parseInt(optJSONObject10.optString("gs"));
            this.O000oO00 = optJSONObject10.optString("v").equals("1");
        } catch (Exception unused17) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a20, b20 parse failed!");
        }
        try {
            JSONObject optJSONObject11 = jSONObject.optJSONObject("B21");
            this.O000oO0o = Integer.parseInt(optJSONObject11.optString("gs"));
            this.O000oO0O = optJSONObject11.optString("v").equals("1");
            fat fat = fat.O000000o.f16039O000000o;
            fat.O000000o(O000000o(this.O000oO0O, this.O000oO0o));
        } catch (Exception unused18) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a21, b21 parse failed!");
        }
        try {
            O000000o(jSONObject, "A22", this.O000oO);
            this.O000oOO0 = O00000Oo(jSONObject.getJSONObject("N22"));
        } catch (Exception unused19) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a22 n22 parse failed!");
        }
        try {
            O000000o(jSONObject, "A23", this.O0000oOo);
        } catch (Exception unused20) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a23 parse failed!");
        }
        try {
            O000000o(jSONObject, "A24", this.O000oOO);
            this.O000oOOO = O00000Oo(jSONObject.getJSONObject("N24"));
        } catch (Exception unused21) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a24 n24 parse failed!");
        }
        try {
            O000000o(jSONObject, "A25", this.O0000oOO);
        } catch (Exception unused22) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a25 parse failed!");
        }
        try {
            O000000o(jSONObject, "A26", this.O0000oo0);
            this.O0000oo = O00000Oo(jSONObject.getJSONObject("N26"));
        } catch (Exception unused23) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a24 n24 parse failed!");
        }
        try {
            JSONObject optJSONObject12 = jSONObject.optJSONObject("B30");
            this.O0000ooo = Integer.parseInt(optJSONObject12.optString("gs"));
            this.O0000ooO = optJSONObject12.optString("v").equals("1");
        } catch (Exception unused24) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "b30 parse failed!");
        }
        try {
            O000000o(jSONObject, "A28", this.O000oOOo);
            JSONObject optJSONObject13 = jSONObject.optJSONObject("B28");
            this.O000oOo = Integer.parseInt(optJSONObject13.optString("gs"));
            this.O000oOo0 = optJSONObject13.optString("v").equals("1");
        } catch (Exception unused25) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a28, b28 parse failed!");
        }
        try {
            JSONObject optJSONObject14 = jSONObject.optJSONObject("B29");
            this.O000oOoo = Integer.parseInt(optJSONObject14.optString("gs"));
            this.O000oOoO = optJSONObject14.optString("v").equals("1");
        } catch (Exception unused26) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "b29 parse failed!");
        }
        try {
            this.O00oOooO = "1".equals(jSONObject.optJSONObject("B31").optString("v"));
        } catch (Exception unused27) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "b31 parse failed!");
        }
        try {
            O000000o(jSONObject, "A32", this.O00oOooo);
            this.O000O00o = O00000Oo(jSONObject.getJSONObject("N32"));
        } catch (Exception unused28) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a32 n32 parse failed!");
        }
        try {
            O000000o(jSONObject, "A33", this.O000O0OO);
            this.O000O0Oo = O00000Oo(jSONObject.getJSONObject("N33"));
        } catch (Exception unused29) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a33 n33 parse failed!");
        }
        try {
            this.O00oOoOo = O00000Oo(jSONObject.getJSONObject("N34"));
        } catch (Exception unused30) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "n34 parse failed!");
        }
        try {
            JSONObject optJSONObject15 = jSONObject.optJSONObject("B35");
            this.O000O0o = Integer.parseInt(optJSONObject15.optString("gs"));
            this.O000O0o0 = optJSONObject15.optString("v").equals("1");
            fat fat2 = fat.O000000o.f16039O000000o;
            MMKV.O000000o("smart.config.cache").O000000o("key.abtest.b35.SWITCHER", this.O000O0o0);
            fat fat3 = fat.O000000o.f16039O000000o;
            MMKV.O000000o("smart.config.cache").O000000o("key.abtest.b35.RANGE", this.O000O0o);
            LogType logType = LogType.BLUETOOTH;
            gsy.O00000o0(logType, "SmartConfigGreyManager", "load 35 remote config: switcher=" + this.O000O0o0 + ",range=" + this.O000O0o);
        } catch (Exception unused31) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "b35 parse failed!");
        }
        try {
            JSONObject optJSONObject16 = jSONObject.optJSONObject("B37");
            this.O000oo0O = Integer.parseInt(optJSONObject16.optString("gs"));
            this.O000oo0 = optJSONObject16.optString("v").equals("1");
            JSONObject optJSONObject17 = jSONObject.optJSONObject("A37");
            gsy.O00000Oo("SmartConfigGreyManager", "A37=" + optJSONObject17.toString());
            JSONArray jSONArray = optJSONObject17.getJSONArray("v");
            if (O000000o(this.O000oo0, this.O000oo0O)) {
                this.O000oo0o = O000000o(jSONArray);
            }
        } catch (Exception unused32) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "A37, B37 parse failed!");
        }
        try {
            O000000o(jSONObject, "A39", this.O000oo);
        } catch (Exception unused33) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "a39 parse failed!");
        }
        try {
            int O00000Oo2 = O00000Oo(jSONObject.getJSONObject("N40"));
            int O00000Oo3 = O00000Oo(jSONObject.getJSONObject("N41"));
            gpy.O00000Oo(CommonApplication.getAppContext(), "SP_THREADPOOL_AB_CONFIG", "SP_THREADPOOL_COREPOOLSIZE", Math.max(O00000Oo2, 10));
            gpy.O00000Oo(CommonApplication.getAppContext(), "SP_THREADPOOL_AB_CONFIG", "SP_THREADPOOL_MAX_REQUESTS_PER_HOST", Math.max(O00000Oo3, 10));
        } catch (Exception unused34) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "n40 N41 parse failed!");
        }
        try {
            O000000o(jSONObject, "A42", this.O000O0oO);
            JSONObject optJSONObject18 = jSONObject.optJSONObject("B42");
            this.O000OO00 = Integer.parseInt(optJSONObject18.optString("gs"));
            this.O000O0oo = optJSONObject18.optString("v").equals("1");
        } catch (Exception unused35) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "b42 parse failed!");
        }
        try {
            O000000o(jSONObject, "A43", this.O000OO0o);
            JSONObject optJSONObject19 = jSONObject.optJSONObject("B43");
            this.O000OOOo = Integer.parseInt(optJSONObject19.optString("gs"));
            this.O000OO = optJSONObject19.optString("v").equals("1");
        } catch (Exception unused36) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "b43 parse failed!");
        }
        try {
            O000000o(jSONObject, "A44", this.O000OOo0);
            JSONObject optJSONObject20 = jSONObject.optJSONObject("B44");
            this.O000OOoO = Integer.parseInt(optJSONObject20.optString("gs"));
            this.O000OOo = optJSONObject20.optString("v").equals("1");
        } catch (Exception unused37) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "b44 parse failed!");
        }
        try {
            O000000o(jSONObject, "A45", this.O000OOoo);
            JSONObject optJSONObject21 = jSONObject.optJSONObject("B45");
            this.O000Oo0 = Integer.parseInt(optJSONObject21.optString("gs"));
            this.O000Oo00 = optJSONObject21.optString("v").equals("1");
        } catch (Exception unused38) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "b45 parse failed!");
        }
        try {
            O000000o(jSONObject, "A46", this.O000Oo0O);
            JSONObject optJSONObject22 = jSONObject.optJSONObject("B46");
            this.O000OoO0 = Integer.parseInt(optJSONObject22.optString("gs"));
            this.O000Oo0o = optJSONObject22.optString("v").equals("1");
        } catch (Exception unused39) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "b46 parse failed!");
        }
        try {
            JSONObject optJSONObject23 = jSONObject.optJSONObject("B47");
            this.O000ooO = Integer.parseInt(optJSONObject23.optString("gs"));
            this.O000ooO0 = optJSONObject23.optString("v").equals("1");
            gpy.O000000o(CommonApplication.getAppContext(), "SP_THREADPOOL_AB_CONFIG", "SP_KEY_USE_MIUI_MEMORY_OPT", this.O000ooO0);
        } catch (Exception unused40) {
            gsy.O00000Oo(LogType.KUAILIAN, "SmartConfigGreyManager", "n40 N41 parse failed!");
        }
    }

    private static Map<String, int[]> O000000o(JSONArray jSONArray) throws JSONException {
        String next;
        JSONArray jSONArray2;
        int length = jSONArray.length();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (!(!jSONObject.keys().hasNext() || (jSONArray2 = jSONObject.getJSONArray((next = jSONObject.keys().next()))) == null || jSONArray2.length() == 0)) {
                int length2 = jSONArray2.length();
                int[] iArr = new int[length2];
                for (int i2 = 0; i2 < length2; i2++) {
                    iArr[i2] = jSONArray2.getInt(i2);
                }
                hashMap.put(next, iArr);
            }
        }
        return hashMap;
    }

    private static void O000000o(JSONObject jSONObject, String str, List<String> list) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONObject(str).optJSONArray("v");
        if (optJSONArray != null) {
            list.clear();
            for (int i = 0; i < optJSONArray.length(); i++) {
                list.add(optJSONArray.getString(i));
            }
        }
    }

    private static boolean O000000o(int i) {
        String O00000Oo2 = fcn.O000000o().O00000Oo();
        if (TextUtils.isEmpty(O00000Oo2)) {
            return false;
        }
        try {
            if (Integer.parseInt(O00000Oo2.substring(O00000Oo2.length() - 2)) <= i) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }

    private static int O00000Oo(JSONObject jSONObject) {
        int parseInt = Integer.parseInt(jSONObject.optString("gs"));
        int parseInt2 = Integer.parseInt(jSONObject.optString("v"));
        if (O000000o(parseInt)) {
            return parseInt2;
        }
        return 0;
    }
}

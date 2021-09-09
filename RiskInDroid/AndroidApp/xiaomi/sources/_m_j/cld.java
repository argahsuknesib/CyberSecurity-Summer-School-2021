package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.ICloudDataCallback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cld {
    public static int O00000o = 20;

    /* renamed from: O000000o  reason: collision with root package name */
    public long f13988O000000o = (O000000o() / 1000);
    public long O00000Oo = (System.currentTimeMillis() / 1000);
    public boolean O00000o0 = false;
    public List<clb> O00000oO = new ArrayList();
    public ckz O00000oo = null;
    protected dty O0000O0o;
    public cla O0000OOo = new cla();
    public long O0000Oo = -1;
    public long O0000Oo0 = -1;
    private boolean O0000OoO = false;
    private long O0000Ooo = -1;

    public interface O000000o<T> {
        void onFailure(int i, String str);

        void onSuccess(T t, Object obj);
    }

    public cld(dty dty) {
        this.O0000O0o = dty;
    }

    public final clb O000000o(long j) {
        for (int i = 0; i < this.O00000oO.size(); i++) {
            if (this.O00000oO.get(i).O00000Oo == j) {
                return this.O00000oO.get(i);
            }
        }
        return null;
    }

    public final void O000000o(final Callback<Void> callback) {
        O000000o(this.f13988O000000o, this.O00000Oo, 50, new Callback<JSONArray>() {
            /* class _m_j.cld.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONArray jSONArray = (JSONArray) obj;
                ArrayList arrayList = new ArrayList();
                if (jSONArray == null || jSONArray.length() <= 0) {
                    cld.this.O00000o0 = false;
                } else {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(clb.O000000o(jSONArray.optJSONObject(i)));
                    }
                    if (jSONArray.length() == 50) {
                        cld.this.O00000Oo = (((clb) arrayList.get(arrayList.size() - 1)).O00000Oo / 1000) - 1;
                        cld.this.O00000o0 = true;
                    } else {
                        cld.this.O00000o0 = false;
                    }
                    cld.this.O00000oO = arrayList;
                }
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(null);
                }
            }

            public final void onFailure(int i, String str) {
                gsy.O000000o(3, "AlarmManager", "getUserDeviceData failed");
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        });
    }

    public static List<clb> O000000o(List<clb> list, List<clb> list2) {
        ArrayList arrayList = new ArrayList();
        if (list2.size() == 0) {
            if (list != null) {
                arrayList.addAll(list);
            }
            return arrayList;
        } else if (list == null || list.size() == 0) {
            arrayList.addAll(list2);
            return arrayList;
        } else {
            int i = 0;
            long j = list2.get(0).O00000Oo;
            while (i < list.size() && list.get(i).O00000Oo > j) {
                arrayList.add(list.get(i));
                i++;
            }
            arrayList.addAll(list2);
            return arrayList;
        }
    }

    public final void O000000o(final List<clb> list, final Callback<Void> callback) {
        if (list == null || list.size() == 0) {
            callback.onFailure(-1, "");
            return;
        }
        final ArrayList arrayList = new ArrayList();
        new Thread(new Runnable() {
            /* class _m_j.cld.AnonymousClass10 */

            public final void run() {
                int size = list.size();
                int i = cld.O00000o;
                int i2 = size < i ? size : i + 0;
                int i3 = 0;
                while (i3 < size) {
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    final List subList = list.subList(i3, i2);
                    JSONArray jSONArray = new JSONArray();
                    int i4 = 0;
                    while (i4 < subList.size()) {
                        try {
                            clb clb = (clb) subList.get(i4);
                            if (clb != null) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("did", clb.O00000o0);
                                jSONObject.put("type", clb.O00000o);
                                jSONObject.put("key", clb.O00000oO);
                                jSONObject.put("time", clb.O00000Oo / 1000);
                                jSONArray.put(jSONObject);
                            }
                            i4++;
                        } catch (JSONException unused) {
                            callback.onFailure(-1001, null);
                            return;
                        }
                    }
                    cld.this.O000000o(jSONArray.toString(), new Callback<JSONObject>() {
                        /* class _m_j.cld.AnonymousClass10.AnonymousClass1 */

                        public final void onFailure(int i, String str) {
                            try {
                                arrayList.add(Boolean.FALSE);
                            } catch (Exception e) {
                                gsy.O000000o(6, "AlarmManager", "delete alarm failed2:" + e.getLocalizedMessage());
                            }
                            countDownLatch.countDown();
                            civ.O00000o("alarm", "delete alarm fail ".concat(String.valueOf(str)));
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            try {
                                cld.this.O00000oO.removeAll(subList);
                                arrayList.add(Boolean.TRUE);
                            } catch (Exception e) {
                                gsy.O000000o(6, "AlarmManager", "delete alarm failed:" + e.getLocalizedMessage());
                            }
                            countDownLatch.countDown();
                            gsy.O00000Oo("alarm", "delete alarm success " + subList.size());
                        }
                    });
                    try {
                        countDownLatch.await();
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int i5 = i2 + i;
                    if (i5 >= size) {
                        i5 = size;
                    }
                    if (arrayList.isEmpty() || ((Boolean) arrayList.remove(0)).booleanValue()) {
                        int i6 = i2;
                        i2 = i5;
                        i3 = i6;
                    } else {
                        Callback callback = callback;
                        if (callback != null) {
                            callback.onFailure(-1, "");
                            return;
                        }
                        return;
                    }
                }
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onSuccess(null);
                }
            }
        }).start();
    }

    public final void O000000o(long j, final Callback<clb> callback) {
        O000000o(0, j / 1000, 1, new Callback<JSONArray>() {
            /* class _m_j.cld.AnonymousClass18 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONArray jSONArray = (JSONArray) obj;
                callback.onSuccess(jSONArray.length() > 0 ? clb.O000000o(jSONArray.optJSONObject(0)) : null);
            }

            public final void onFailure(int i, String str) {
                callback.onFailure(i, str);
                civ.O00000o("alarm", "get alarm fail ".concat(String.valueOf(str)));
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    public final void O000000o(long j, long j2, int i, Callback<JSONArray> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", this.O0000O0o.getDid());
            jSONObject.put("type", "event");
            jSONObject.put("key", "motion");
            jSONObject.put("time_start", j);
            jSONObject.put("time_end", j2);
            jSONObject.put("limit", i);
            jSONObject.put("fetchAlertVideo", true);
            XmPluginHostApi.instance().callSmartHomeApi(this.O0000O0o.getModel(), "/user/get_user_device_data", jSONObject, callback, new Parser<JSONArray>() {
                /* class _m_j.cld.AnonymousClass19 */

                public final /* synthetic */ Object parse(String str) throws JSONException {
                    return new JSONObject(str).getJSONArray("result");
                }
            });
        } catch (JSONException e) {
            callback.onFailure(-1, e.toString());
        }
    }

    public final void O000000o(String str, Callback<JSONObject> callback) {
        XmPluginHostApi.instance().callSmartHomeApi(this.O0000O0o.getModel(), "/user/del_user_device_data_batch", str, callback, Parser.DEFAULT_PARSER);
    }

    public final void O000000o(final Callback<Void> callback, int[][] iArr) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 8; i2++) {
                jSONArray.put(iArr[i][i2]);
            }
        }
        this.O0000O0o.callMethod("set_motion_region", jSONArray, new Callback<Object>() {
            /* class _m_j.cld.AnonymousClass20 */

            public final void onSuccess(Object obj) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(null);
                }
            }

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, (Parser) null);
    }

    public final void O00000Oo(final Callback<int[][]> callback) {
        this.O0000O0o.callMethod("get_motion_region", new JSONArray(), new Callback<Integer[][]>() {
            /* class _m_j.cld.AnonymousClass21 */

            public final /* synthetic */ void onSuccess(Object obj) {
                Integer[][] numArr = (Integer[][]) obj;
                Callback callback = callback;
                if (callback == null) {
                    return;
                }
                if (numArr == null) {
                    callback.onFailure(-1, "返回数目不对不是32");
                    return;
                }
                int[][] iArr = (int[][]) Array.newInstance(int.class, 4, 8);
                for (int i = 0; i < 4; i++) {
                    for (int i2 = 0; i2 < 8; i2++) {
                        iArr[i][i2] = numArr[i][i2].intValue();
                    }
                }
                callback.onSuccess(iArr);
            }

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, new Parser<Integer[][]>() {
            /* class _m_j.cld.AnonymousClass22 */

            public final /* synthetic */ Object parse(String str) throws JSONException {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.isNull("result")) {
                    return null;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("result");
                Integer[][] numArr = (Integer[][]) Array.newInstance(Integer.class, 4, 8);
                if (optJSONArray.length() != 32) {
                    return null;
                }
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    numArr[i / 8][i % 8] = Integer.valueOf(optJSONArray.getInt(i));
                }
                return numArr;
            }
        });
    }

    public final void O00000o0(final Callback<ckz> callback) {
        this.O0000O0o.callMethod("getAlarmConfig", new JSONArray(), new Callback<ckz>() {
            /* class _m_j.cld.AnonymousClass23 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                ckz ckz = (ckz) obj;
                Callback callback = callback;
                if (callback != null) {
                    cld.this.O00000oo = ckz;
                    callback.onSuccess(ckz);
                }
            }

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, new Parser<ckz>() {
            /* class _m_j.cld.AnonymousClass24 */

            public final /* synthetic */ Object parse(String str) throws JSONException {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("result");
                ckz ckz = new ckz();
                if (optJSONArray != null && optJSONArray.length() >= 6) {
                    ckz.f13979O000000o = optJSONArray.optInt(0);
                    if (ckz.f13979O000000o == 2) {
                        ckz.O00000Oo = optJSONArray.optInt(1);
                        ckz.O00000o0 = optJSONArray.optInt(2);
                        ckz.O00000o = optJSONArray.optInt(3);
                        ckz.O00000oO = optJSONArray.optInt(4);
                    }
                    if (optJSONArray.length() > 5) {
                        ckz.O00000oo = optJSONArray.optInt(5);
                    }
                    if (optJSONArray.length() > 6) {
                        ckz.O0000O0o = optJSONArray.optInt(6, 5);
                    }
                }
                return ckz;
            }
        });
    }

    public final void O000000o(long j, long j2, Callback<List<clb>> callback) {
        final long j3 = j2;
        final long j4 = j;
        final Callback<List<clb>> callback2 = callback;
        new Thread(new Runnable() {
            /* class _m_j.cld.AnonymousClass3 */

            public final void run() {
                long j = j3;
                long[] jArr = {j};
                jArr[0] = j;
                int[] iArr = {0};
                ArrayList arrayList = new ArrayList();
                do {
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    final long[] jArr2 = jArr;
                    final int[] iArr2 = iArr;
                    final ArrayList arrayList2 = arrayList;
                    final CountDownLatch countDownLatch2 = countDownLatch;
                    cld.this.O000000o(j4, jArr[0], 50, new Callback<JSONArray>() {
                        /* class _m_j.cld.AnonymousClass3.AnonymousClass1 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            JSONArray jSONArray = (JSONArray) obj;
                            ArrayList arrayList = new ArrayList();
                            if (jSONArray == null || jSONArray.length() <= 0) {
                                iArr2[0] = 0;
                            } else {
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    arrayList.add(clb.O000000o(jSONArray.optJSONObject(i)));
                                }
                                if (jSONArray.length() == 50) {
                                    jArr2[0] = (((clb) arrayList.get(arrayList.size() - 1)).O00000Oo / 1000) - 1;
                                    iArr2[0] = 50;
                                } else {
                                    iArr2[0] = jSONArray.length();
                                }
                                arrayList2.addAll(arrayList);
                            }
                            countDownLatch2.countDown();
                        }

                        public final void onFailure(int i, String str) {
                            iArr2[0] = -1;
                            countDownLatch2.countDown();
                        }
                    });
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } while (iArr[0] == 50);
                if (callback2 == null) {
                    return;
                }
                if (iArr[0] != -1 || !arrayList.isEmpty()) {
                    callback2.onSuccess(arrayList);
                } else {
                    callback2.onFailure(-1, "");
                }
            }
        }).start();
    }

    public static long O000000o() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(13, 0);
        instance.set(12, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis() - 518400000;
    }

    public final void O000000o(String str, JSONObject jSONObject, final O000000o o000000o) {
        clf.O000000o().O000000o(str, jSONObject.toString(), new Callback<JSONObject>() {
            /* class _m_j.cld.AnonymousClass4 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject != null) {
                    civ.O000000o("AlarmManager", "getAlarmConfig:" + jSONObject.toString());
                    if (jSONObject.optInt("code") == 0) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject != null) {
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("motionDetectionSwitch");
                            if (optJSONObject2 != null) {
                                cld.this.O0000OOo.f13985O000000o = optJSONObject2.optBoolean("detectionSwitch", false);
                                cld.this.O0000OOo.O00000oO = optJSONObject2.optInt("interval", 5);
                                cld.this.O0000OOo.O0000Oo0 = optJSONObject2.optBoolean("trackSwitch", false);
                                String optString = optJSONObject2.optString("startTime");
                                if (!TextUtils.isEmpty(optString)) {
                                    mj.O000000o();
                                    String O00000Oo2 = mj.O00000Oo(optString);
                                    if (!TextUtils.isEmpty(O00000Oo2)) {
                                        cld.this.O0000OOo.O00000Oo = O00000Oo2;
                                    } else {
                                        cld.this.O0000OOo.O00000Oo = optString;
                                    }
                                } else {
                                    cld.this.O0000OOo.O00000Oo = "00:00:00";
                                }
                                String optString2 = optJSONObject2.optString("endTime");
                                if (!TextUtils.isEmpty(optString2)) {
                                    mj.O000000o();
                                    String O00000Oo3 = mj.O00000Oo(optString2);
                                    if (!TextUtils.isEmpty(O00000Oo3)) {
                                        cld.this.O0000OOo.O00000o0 = O00000Oo3;
                                    } else {
                                        cld.this.O0000OOo.O00000o0 = optString2;
                                    }
                                } else {
                                    cld.this.O0000OOo.O00000o0 = "23:59:59";
                                }
                            }
                            cld.this.O0000OOo.O00000oo = optJSONObject.optBoolean("pedestrianDetectionPushSwitch", false);
                            cld.this.O0000OOo.O00000o = optJSONObject.optBoolean("pushSwitch", false);
                            cld.this.O0000OOo.O0000O0o = cld.O000000o(optJSONObject.optJSONArray("sensitive"));
                            cld.this.O0000OOo.O0000OOo = optJSONObject.optLong("upgradeTime", -1);
                            cld cld = cld.this;
                            cld.O0000Oo0 = String.valueOf(cld.O0000OOo.O0000OOo).length() == 10 ? cld.this.O0000OOo.O0000OOo * 1000 : cld.this.O0000OOo.O0000OOo;
                            O000000o o000000o = o000000o;
                            if (o000000o != null) {
                                o000000o.onSuccess(null, null);
                                return;
                            }
                            return;
                        }
                        O000000o o000000o2 = o000000o;
                        if (o000000o2 != null) {
                            o000000o2.onFailure(-90002, "data is null");
                            return;
                        }
                        return;
                    }
                    O000000o o000000o3 = o000000o;
                    if (o000000o3 != null) {
                        o000000o3.onFailure(-90002, "code is not 0");
                        return;
                    }
                    return;
                }
                O000000o o000000o4 = o000000o;
                if (o000000o4 != null) {
                    o000000o4.onFailure(-90002, "jsonObject is null");
                }
            }

            public final void onFailure(int i, String str) {
                PrintStream printStream = System.out;
                printStream.println("mytest:getAlarmConfig i:" + i + " s:" + str);
                civ.O00000o0("AlarmManager", "getAlarmConfig i:" + i + " s:" + str);
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.onFailure(i, str);
                }
            }
        });
    }

    public static int[] O000000o(JSONArray jSONArray) {
        int[] iArr = new int[jSONArray.length()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = jSONArray.optInt(i);
        }
        return iArr;
    }

    public final clb O000000o(JSONObject jSONObject) {
        clb clb = new clb();
        clb.O0000o0 = jSONObject.optLong("duration");
        clb.O0000o0O = jSONObject.optLong("expireTime");
        clb.O0000o0o = jSONObject.optLong("createTime");
        clb.O0000oO0 = jSONObject.optString("imgStoreId");
        clb.O0000oOO = jSONObject.optString("fileId");
        clb.O0000oo0 = jSONObject.optString("desc");
        clb.O0000oo = jSONObject.optString("tags");
        clb.O0000o = jSONObject.optInt("offset");
        clb.O0000oOo = jSONObject.optString("videoStoreId");
        clb.O0000oO = XmPluginHostApi.instance().getCloudImageUrl(this.O0000O0o.getDid(), clb.O0000oOO, clb.O0000oO0);
        clb.O0000Ooo = true;
        clb.O00000Oo = clb.O0000o0o;
        return clb;
    }

    private long O00000Oo() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.O0000Ooo);
        instance.set(11, 0);
        instance.set(13, 0);
        instance.set(12, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis();
    }

    private long O00000o0() {
        return O00000Oo() + 86400000;
    }

    public final List<clb> O000000o(List<clb> list) {
        if (list.size() == 0) {
            return list;
        }
        this.O0000Ooo = list.get(0).O00000Oo;
        if (O00000Oo(list.get(list.size() - 1).O00000Oo)) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            clb clb = list.get(i);
            if (O00000Oo(clb.O00000Oo)) {
                arrayList.add(clb);
            }
        }
        return arrayList;
    }

    public final void O000000o(final Callback<Void> callback, final boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", this.O0000O0o.getDid());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("language", Locale.getDefault().getLanguage());
            if (z) {
                jSONObject.put("beginTime", O000000o());
                jSONObject.put("endTime", System.currentTimeMillis());
            } else {
                jSONObject.put("beginTime", O00000Oo());
                jSONObject.put("endTime", this.O0000Oo);
            }
            jSONObject.put("limit", 20);
            clf.O000000o().O0000O0o(this.O0000O0o.getModel(), jSONObject.toString(), new Callback<JSONObject>() {
                /* class _m_j.cld.AnonymousClass8 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    gsy.O000000o(3, "zz", "loadDataNew:" + jSONObject.toString());
                    if (jSONObject == null || jSONObject.optInt("code") != 0 || jSONObject.optJSONObject("data") == null) {
                        Callback callback = callback;
                        if (callback != null) {
                            callback.onFailure(-90002, "jsonObject is null");
                            return;
                        }
                        return;
                    }
                    JSONArray optJSONArray = jSONObject.optJSONObject("data").optJSONArray("playUnits");
                    List arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            arrayList.add(cld.this.O000000o(optJSONObject));
                        }
                    }
                    if (z) {
                        arrayList = cld.this.O000000o(arrayList);
                        cld.this.O00000oO = arrayList;
                    } else {
                        cld cld = cld.this;
                        cld.O00000oO = cld.O000000o(cld.O00000oO, arrayList);
                    }
                    if (arrayList.size() == 20) {
                        cld.this.O0000Oo = ((clb) arrayList.get(arrayList.size() - 1)).O00000Oo - 1;
                        cld.this.O00000o0 = true;
                        Callback callback2 = callback;
                        if (callback2 != null) {
                            callback2.onSuccess(null);
                            return;
                        }
                        return;
                    }
                    cld.this.O00000o0 = false;
                    Callback callback3 = callback;
                    if (callback3 != null) {
                        callback3.onSuccess(null);
                    }
                }

                public final void onFailure(int i, String str) {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(i, str);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    private boolean O00000Oo(long j) {
        return j >= O00000Oo() && j <= O00000o0();
    }

    public final void O000000o(Context context, clb clb, final O000000o<String> o000000o) {
        if (clb == null || TextUtils.isEmpty(clb.O0000oOO) || TextUtils.isEmpty(clb.O0000oOo)) {
            o000000o.onFailure(-90001, "params is invalid");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", this.O0000O0o.getDid());
            jSONObject.put("fileId", clb.O0000oOO);
            jSONObject.put("stoId", clb.O0000oOo);
            XmPluginHostApi.instance().getCloudVideoFile(context, jSONObject.toString(), new ICloudDataCallback<String>() {
                /* class _m_j.cld.AnonymousClass9 */

                public final void onCloudDataProgress(int i) {
                }

                public final /* synthetic */ void onCloudDataSuccess(Object obj, Object obj2) {
                    String str = (String) obj;
                    O000000o o000000o = o000000o;
                    if (o000000o != null) {
                        o000000o.onSuccess(str, obj2);
                    }
                }

                public final void onCloudDataFailed(int i, String str) {
                    civ.O00000o0("AlarmManager", "getAlarmFile i:" + i + " s:" + str);
                    O000000o o000000o = o000000o;
                    if (o000000o != null) {
                        o000000o.onFailure(i, str);
                    }
                }
            });
        } catch (JSONException e) {
            o000000o.onFailure(-90001, e.getLocalizedMessage());
        }
    }

    public final void O00000o(final Callback<JSONArray> callback) {
        this.O0000O0o.callMethod("getAlarmSensitivity", new JSONArray(), new Callback<JSONArray>() {
            /* class _m_j.cld.AnonymousClass14 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                JSONArray jSONArray = (JSONArray) obj;
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(jSONArray);
                }
            }

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, new Parser<JSONArray>() {
            /* class _m_j.cld.AnonymousClass15 */

            public final /* synthetic */ Object parse(String str) throws JSONException {
                return new JSONObject(str).optJSONArray("result");
            }
        });
    }

    public final void O000000o(final Callback<Void> callback, int i) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(i);
        gsy.O00000Oo("AlarmManager", "setAlarmSelectSensitivity array=" + jSONArray.toString());
        this.O0000O0o.callMethod("setAlarmSensitivity", jSONArray, new Callback<Object>() {
            /* class _m_j.cld.AnonymousClass16 */

            public final void onSuccess(Object obj) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(null);
                }
            }

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, (Parser) null);
    }

    public final void O00000Oo(final Callback<Void> callback, int i) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(i);
        gsy.O00000Oo("AlarmManager", "setAlarmSelectSensitivity array=" + jSONArray.toString());
        this.O0000O0o.callMethod("upload_voice", jSONArray, new Callback<Object>() {
            /* class _m_j.cld.AnonymousClass17 */

            public final void onSuccess(Object obj) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(null);
                }
            }

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, (Parser) null);
    }

    public final void O000000o(final ckz ckz, final Callback<JSONObject> callback) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(ckz.f13979O000000o);
        jSONArray.put(ckz.O00000Oo);
        jSONArray.put(ckz.O00000o0);
        jSONArray.put(ckz.O00000o);
        jSONArray.put(ckz.O00000oO);
        jSONArray.put(ckz.O00000oo);
        jSONArray.put(ckz.O0000O0o);
        this.O0000O0o.callMethod("setAlarmConfig", jSONArray, new Callback<JSONObject>() {
            /* class _m_j.cld.AnonymousClass2 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                Callback callback = callback;
                if (callback != null) {
                    cld.this.O00000oo = ckz;
                    callback.onSuccess(jSONObject);
                }
            }

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }
}

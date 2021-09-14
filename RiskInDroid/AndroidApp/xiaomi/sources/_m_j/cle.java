package _m_j;

import _m_j.clf;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.ICloudDataCallback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cle {
    private static int O0000Oo0 = 20;

    /* renamed from: O000000o  reason: collision with root package name */
    public cla f14020O000000o = new cla();
    public long O00000Oo = -1;
    public boolean O00000o = false;
    public List<clc> O00000o0 = new ArrayList();
    protected dty O00000oO;
    private long O00000oo = -1;
    private long O0000O0o = (O00000o0() / 1000);
    private long O0000OOo = (System.currentTimeMillis() / 1000);
    private ckz O0000Oo = null;

    public interface O000000o<T> {
        void onFailure(int i, String str);

        void onSuccess(T t, Object obj);
    }

    public static String O000000o(String str, String str2, String str3) {
        clf.O000000o();
        return clf.O000000o(str, str2, str3);
    }

    public static void O000000o(String str, String str2, String str3, String str4, clf.O000000o o000000o) {
        clf O000000o2 = clf.O000000o();
        XmPluginHostApi.instance().getCloudVideoFile(str2, str3, clf.O000000o(str, str2, str3), new ICloudDataCallback(str4, str, o000000o) {
            /* class _m_j.clf.AnonymousClass8 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ String f14052O000000o;
            final /* synthetic */ String O00000Oo;
            final /* synthetic */ O000000o O00000o0;

            {
                this.f14052O000000o = r2;
                this.O00000Oo = r3;
                this.O00000o0 = r4;
            }

            public final void onCloudDataSuccess(Object obj, Object obj2) {
                final ArrayList arrayList = (ArrayList) obj;
                new AsyncTask<Void, Void, Integer>() {
                    /* class _m_j.clf.AnonymousClass8.AnonymousClass1 */

                    /* access modifiers changed from: protected */
                    public final /* synthetic */ Object doInBackground(Object[] objArr) {
                        return O000000o();
                    }

                    /* access modifiers changed from: protected */
                    public final /* synthetic */ void onPostExecute(Object obj) {
                        Integer num = (Integer) obj;
                        super.onPostExecute(num);
                        if (num.intValue() == 0) {
                            AnonymousClass8.this.O00000o0.onComplete();
                        } else {
                            AnonymousClass8.this.O00000o0.onError(num.intValue(), "yd ffmpeg  failure");
                        }
                    }

                    private Integer O000000o() {
                        Iterator it = arrayList.iterator();
                        String str = "";
                        while (it.hasNext()) {
                            str = str + "file '" + ((String) it.next()) + "'\r\n";
                        }
                        File file = new File(clf.O000000o("/CEN") + "fileList.txt");
                        if (!file.exists()) {
                            try {
                                file.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                            bufferedOutputStream.write(str.getBytes());
                            bufferedOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        String str2 = "ffmpeg -f concat -safe 0 -i " + file.getAbsolutePath() + " -c copy " + AnonymousClass8.this.f14052O000000o;
                        int videoConverter = XmPluginHostApi.instance().videoConverter(AnonymousClass8.this.O00000Oo, str2);
                        gsy.O00000Oo("AlarmV2Activity", "cmd===" + str2 + ",resutl=" + videoConverter);
                        return Integer.valueOf(videoConverter);
                    }
                }.execute(new Void[0]);
            }

            public final void onCloudDataFailed(int i, String str) {
                this.O00000o0.onError(i, str);
            }

            public final void onCloudDataProgress(int i) {
                this.O00000o0.onProgress(i);
            }
        });
    }

    public final void O000000o(final String str, JSONObject jSONObject, final O000000o o000000o) {
        clf.O000000o().O000000o(str, jSONObject.toString(), new Callback<JSONObject>() {
            /* class _m_j.cle.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject != null) {
                    LogType logType = LogType.CAMERA;
                    String str = str;
                    gsy.O00000o0(logType, str, "AlarmManagerV2", "getAlarmConfig(" + cle.this.O00000oO.getDid() + "):" + jSONObject.toString());
                    int optInt = jSONObject.optInt("code");
                    if (optInt == 0) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject != null) {
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("motionDetectionSwitch");
                            if (optJSONObject2 != null) {
                                cle.this.f14020O000000o.f13985O000000o = optJSONObject2.optBoolean("detectionSwitch", false);
                                cle.this.f14020O000000o.O00000oO = optJSONObject2.optInt("interval", 5);
                                cle.this.f14020O000000o.O0000Oo0 = optJSONObject2.optBoolean("trackSwitch", false);
                                String optString = optJSONObject2.optString("startTime");
                                if (!TextUtils.isEmpty(optString)) {
                                    mj.O000000o();
                                    String O00000Oo2 = mj.O00000Oo(optString);
                                    if (!TextUtils.isEmpty(O00000Oo2)) {
                                        cle.this.f14020O000000o.O00000Oo = O00000Oo2;
                                    } else {
                                        cle.this.f14020O000000o.O00000Oo = optString;
                                    }
                                } else {
                                    cle.this.f14020O000000o.O00000Oo = "00:00:00";
                                }
                                String optString2 = optJSONObject2.optString("endTime");
                                if (!TextUtils.isEmpty(optString2)) {
                                    mj.O000000o();
                                    String O00000Oo3 = mj.O00000Oo(optString2);
                                    if (!TextUtils.isEmpty(O00000Oo3)) {
                                        cle.this.f14020O000000o.O00000o0 = O00000Oo3;
                                    } else {
                                        cle.this.f14020O000000o.O00000o0 = optString2;
                                    }
                                } else {
                                    cle.this.f14020O000000o.O00000o0 = "23:59:59";
                                }
                            }
                            cle.this.f14020O000000o.O00000oo = optJSONObject.optBoolean("pedestrianDetectionPushSwitch", false);
                            cle.this.f14020O000000o.O00000o = optJSONObject.optBoolean("pushSwitch", false);
                            cle.this.f14020O000000o.O0000O0o = cle.O000000o(optJSONObject.optJSONArray("sensitive"));
                            cle.this.f14020O000000o.O0000OoO = optJSONObject.optBoolean("babyCrySwitch", false);
                            cle.this.f14020O000000o.O0000Ooo = optJSONObject.optBoolean("faceSwitch", false);
                            cle.this.f14020O000000o.O0000Oo = optJSONObject.optBoolean("dailyStorySwitch", false);
                            cle.this.f14020O000000o.O0000o0o = optJSONObject.optBoolean("babyPush", false);
                            cle.this.f14020O000000o.O0000o = optJSONObject.optBoolean("facePush", false);
                            cle.this.f14020O000000o.O0000o0O = optJSONObject.optBoolean("aiPush", false);
                            cle.this.f14020O000000o.O0000o0 = optJSONObject.optBoolean("areaPush", false);
                            cle.this.f14020O000000o.O0000oO0 = optJSONObject.optBoolean("petPushSwitch", false);
                            cle.this.f14020O000000o.O0000oO = optJSONObject.optBoolean("pedestrianDetectionPushSwitch", false);
                            O000000o o000000o = o000000o;
                            if (o000000o != null) {
                                o000000o.onSuccess(null, null);
                            }
                        } else if (o000000o != null) {
                            gsy.O000000o(LogType.CAMERA, str, 6, "AlarmManagerV2", "getAlarmConfig error data is null");
                            o000000o.onFailure(-90002, "data is null");
                        }
                    } else if (o000000o != null) {
                        gsy.O000000o(LogType.CAMERA, str, 6, "AlarmManagerV2", "getAlarmConfig error code=".concat(String.valueOf(optInt)));
                        o000000o.onFailure(-90002, "code is not 0");
                    }
                } else if (o000000o != null) {
                    gsy.O000000o(LogType.CAMERA, str, 6, "AlarmManagerV2", "getAlarmConfig error jsonObject is null");
                    o000000o.onFailure(-90002, "jsonObject is null");
                }
            }

            public final void onFailure(int i, String str) {
                LogType logType = LogType.CAMERA;
                String str2 = str;
                gsy.O000000o(logType, str2, 6, "AlarmManagerV2", "getAlarmConfig i:" + i + " s:" + str);
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.onFailure(i, str);
                }
            }
        });
    }

    public final void O00000Oo(String str, final JSONObject jSONObject, final O000000o o000000o) {
        if (!TextUtils.isEmpty(str)) {
            clf.O000000o().O00000o0(str, jSONObject.toString(), new Callback<JSONObject>() {
                /* class _m_j.cle.AnonymousClass10 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    if (jSONObject == null) {
                        O000000o o000000o = o000000o;
                        if (o000000o != null) {
                            o000000o.onFailure(-90002, "jsonObject is null");
                        }
                    } else if (jSONObject.optInt("code") == 0) {
                        cle.this.f14020O000000o.f13985O000000o = jSONObject.optBoolean("open");
                        cle.this.f14020O000000o.O00000oO = jSONObject.optInt("interval");
                        cle.this.f14020O000000o.O0000Oo0 = jSONObject.optBoolean("trackSwitch");
                        String optString = jSONObject.optString("startTime");
                        if (!TextUtils.isEmpty(optString)) {
                            mj.O000000o();
                            String O00000Oo2 = mj.O00000Oo(optString);
                            if (!TextUtils.isEmpty(O00000Oo2)) {
                                cle.this.f14020O000000o.O00000Oo = O00000Oo2;
                            } else {
                                cle.this.f14020O000000o.O00000Oo = optString;
                            }
                        } else {
                            cle.this.f14020O000000o.O00000Oo = "00:00:00";
                        }
                        String optString2 = jSONObject.optString("endTime");
                        if (!TextUtils.isEmpty(optString2)) {
                            mj.O000000o();
                            String O00000Oo3 = mj.O00000Oo(optString2);
                            if (!TextUtils.isEmpty(O00000Oo3)) {
                                cle.this.f14020O000000o.O00000o0 = O00000Oo3;
                            } else {
                                cle.this.f14020O000000o.O00000o0 = optString2;
                            }
                        } else {
                            cle.this.f14020O000000o.O00000o0 = "23:59:59";
                        }
                        O000000o o000000o2 = o000000o;
                        if (o000000o2 != null) {
                            o000000o2.onSuccess(null, null);
                        }
                    } else {
                        O000000o o000000o3 = o000000o;
                        if (o000000o3 != null) {
                            o000000o3.onFailure(-90002, "code is not 0");
                        }
                    }
                }

                public final void onFailure(int i, String str) {
                    civ.O00000o0("AlarmManagerV2", "setAlarmConfig i:" + i + " s:" + str);
                    O000000o o000000o = o000000o;
                    if (o000000o != null) {
                        o000000o.onFailure(i, str);
                    }
                }
            });
        }
    }

    public final void O000000o(final boolean z, final O000000o o000000o) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", this.O00000oO.getDid());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("open", z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        XmPluginHostApi.instance().callSmartHomeApi(this.O00000oO.getModel(), "business.smartcamera.", "/miot/camera/app/v1/put/areaChangePushSwitch", "POST", jSONObject.toString(), new Callback<JSONObject>() {
            /* class _m_j.cle.AnonymousClass14 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                cle.this.f14020O000000o.O0000o0 = z;
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.onSuccess(jSONObject, null);
                }
            }

            public final void onFailure(int i, String str) {
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public final void O00000Oo(final boolean z, final O000000o o000000o) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", this.O00000oO.getDid());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("open", z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        XmPluginHostApi.instance().callSmartHomeApi(this.O00000oO.getModel(), "business.smartcamera.", "/miot/camera/app/v1/put/pedestrianDetectionPushSwitch", "POST", jSONObject.toString(), new Callback<JSONObject>() {
            /* class _m_j.cle.AnonymousClass15 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                cle.this.f14020O000000o.O0000oO = z;
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.onSuccess(jSONObject, null);
                }
            }

            public final void onFailure(int i, String str) {
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public final void O00000o0(final boolean z, final O000000o o000000o) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", this.O00000oO.getDid());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("open", z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        XmPluginHostApi.instance().callSmartHomeApi(this.O00000oO.getModel(), "business.smartcamera.", "/miot/camera/app/v1/put/petPushSwitch", "POST", jSONObject.toString(), new Callback<JSONObject>() {
            /* class _m_j.cle.AnonymousClass2 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                cle.this.f14020O000000o.O0000oO0 = z;
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.onSuccess(jSONObject, null);
                }
            }

            public final void onFailure(int i, String str) {
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public final void O00000o(final boolean z, final O000000o o000000o) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", this.O00000oO.getDid());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("open", z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        XmPluginHostApi.instance().callSmartHomeApi(this.O00000oO.getModel(), "business.smartcamera.", "/miot/camera/app/v1/put/aiPushSwitch", "POST", jSONObject.toString(), new Callback<JSONObject>() {
            /* class _m_j.cle.AnonymousClass3 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                cle.this.f14020O000000o.O0000o0O = z;
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.onSuccess(jSONObject, null);
                }
            }

            public final void onFailure(int i, String str) {
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public final void O00000oO(final boolean z, final O000000o o000000o) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", this.O00000oO.getDid());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("open", z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        XmPluginHostApi.instance().callSmartHomeApi(this.O00000oO.getModel(), "business.smartcamera.", "/miot/camera/app/v1/put/babyCryPushSwitch", "POST", jSONObject.toString(), new Callback<JSONObject>() {
            /* class _m_j.cle.AnonymousClass4 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                cle.this.f14020O000000o.O0000o0o = z;
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.onSuccess(jSONObject, null);
                }
            }

            public final void onFailure(int i, String str) {
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public final void O00000oo(final boolean z, final O000000o o000000o) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", this.O00000oO.getDid());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("open", z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        XmPluginHostApi.instance().callSmartHomeApi(this.O00000oO.getModel(), "business.smartcamera.", "/miot/camera/app/v1/put/faceSwitch", "POST", jSONObject.toString(), new Callback<JSONObject>() {
            /* class _m_j.cle.AnonymousClass5 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                cle.this.f14020O000000o.O0000Ooo = z;
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.onSuccess(jSONObject, null);
                }
            }

            public final void onFailure(int i, String str) {
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public final void O0000O0o(final boolean z, final O000000o o000000o) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", this.O00000oO.getDid());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("open", z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        XmPluginHostApi.instance().callSmartHomeApi(this.O00000oO.getModel(), "business.smartcamera.", "/miot/camera/app/v1/put/babyCrySwitch", "POST", jSONObject.toString(), new Callback<JSONObject>() {
            /* class _m_j.cle.AnonymousClass6 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                cle.this.f14020O000000o.O0000OoO = z;
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.onSuccess(jSONObject, null);
                }
            }

            public final void onFailure(int i, String str) {
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public final void O000000o(final Callback<Void> callback, final boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", this.O00000oO.getDid());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("language", Locale.getDefault().getLanguage());
            if (z) {
                jSONObject.put("beginTime", O00000o0());
                jSONObject.put("endTime", System.currentTimeMillis());
            } else {
                jSONObject.put("beginTime", O000000o());
                jSONObject.put("endTime", this.O00000Oo);
            }
            jSONObject.put("limit", 20);
            clf.O000000o().O0000OOo(this.O00000oO.getModel(), jSONObject.toString(), new Callback<JSONObject>() {
                /* class _m_j.cle.AnonymousClass7 */

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
                            arrayList.add(cle.this.O000000o(optJSONObject));
                        }
                    }
                    if (z) {
                        arrayList = cle.this.O000000o(arrayList);
                        cle.this.O00000o0 = arrayList;
                    } else {
                        cle cle = cle.this;
                        cle.O00000o0 = cle.O000000o(cle.O00000o0, arrayList);
                    }
                    if (arrayList.size() == 20) {
                        cle.this.O00000Oo = ((clc) arrayList.get(arrayList.size() - 1)).O00000o0 - 1;
                        cle.this.O00000o = true;
                        Callback callback2 = callback;
                        if (callback2 != null) {
                            callback2.onSuccess(null);
                            return;
                        }
                        return;
                    }
                    cle.this.O00000o = false;
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

    public final clc O000000o(JSONObject jSONObject) {
        clc clc = new clc();
        clc.f13987O000000o = jSONObject.optLong("duration");
        clc.O00000Oo = jSONObject.optLong("expireTime");
        clc.O00000o0 = jSONObject.optLong("createTime");
        clc.O00000oO = jSONObject.optString("imgStoreId");
        clc.O0000O0o = jSONObject.optString("fileId");
        clc.O0000Oo0 = jSONObject.optString("desc");
        clc.O0000Oo = jSONObject.optString("tags");
        clc.O00000o = jSONObject.optInt("offset");
        clc.O0000OOo = jSONObject.optString("videoStoreId");
        clc.O00000oo = XmPluginHostApi.instance().getCloudImageUrl(this.O00000oO.getDid(), clc.O0000O0o, clc.O00000oO);
        return clc;
    }

    private long O000000o() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.O00000oo);
        instance.set(11, 0);
        instance.set(13, 0);
        instance.set(12, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis();
    }

    private long O00000Oo() {
        return O000000o() + 86400000;
    }

    public final List<clc> O000000o(List<clc> list) {
        if (list.size() == 0) {
            return list;
        }
        this.O00000oo = list.get(0).O00000o0;
        if (O000000o(list.get(list.size() - 1).O00000o0)) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            clc clc = list.get(i);
            if (O000000o(clc.O00000o0)) {
                arrayList.add(clc);
            }
        }
        return arrayList;
    }

    private boolean O000000o(long j) {
        return j >= O000000o() && j <= O00000Oo();
    }

    public final void O000000o(long j, long j2, final O000000o<List<clc>> o000000o) {
        try {
            Calendar instance = Calendar.getInstance();
            instance.setTime(new Date());
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", this.O00000oO.getDid());
            jSONObject.put("model", this.O00000oO.getModel());
            jSONObject.put("limit", 20);
            jSONObject.put("beginTime", j);
            jSONObject.put("endTime", j2);
            clf.O000000o().O0000OOo(this.O00000oO.getModel(), jSONObject.toString(), new Callback<JSONObject>() {
                /* class _m_j.cle.AnonymousClass8 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    if (jSONObject == null) {
                        O000000o o000000o = o000000o;
                        if (o000000o != null) {
                            o000000o.onFailure(-90002, "jsonObject is null");
                        }
                    } else if (jSONObject.optInt("code") == 0) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject != null) {
                            JSONArray optJSONArray = optJSONObject.optJSONArray("thirdPartPlayUnits");
                            ArrayList arrayList = new ArrayList();
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                                if (optJSONObject2 != null) {
                                    clc clc = new clc();
                                    clc.f13987O000000o = optJSONObject2.optLong("duration");
                                    clc.O00000Oo = optJSONObject2.optLong("expireTime");
                                    clc.O00000o0 = optJSONObject2.optLong("createTime");
                                    clc.O00000oO = optJSONObject2.optString("imgStoreId");
                                    clc.O0000O0o = optJSONObject2.optString("fileId");
                                    clc.O0000Oo0 = optJSONObject2.optString("desc");
                                    clc.O0000Oo = optJSONObject2.optString("tags");
                                    clc.O00000o = optJSONObject2.optInt("offset");
                                    clc.O0000OOo = optJSONObject2.optString("videoStoreId");
                                    clc.O00000oo = XmPluginHostApi.instance().getCloudImageUrl(cle.this.O00000oO.getDid(), clc.O0000O0o, clc.O00000oO);
                                    arrayList.add(clc);
                                }
                            }
                            O000000o o000000o2 = o000000o;
                            if (o000000o2 != null) {
                                o000000o2.onSuccess(arrayList, null);
                                return;
                            }
                            return;
                        }
                        O000000o o000000o3 = o000000o;
                        if (o000000o3 != null) {
                            o000000o3.onFailure(-90002, "data is null");
                        }
                    } else {
                        O000000o o000000o4 = o000000o;
                        if (o000000o4 != null) {
                            o000000o4.onFailure(-90002, "code is not 0");
                        }
                    }
                }

                public final void onFailure(int i, String str) {
                    civ.O00000o0("AlarmManagerV2", "i:" + i + " s:" + str);
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

    public final void O000000o(Context context, clc clc, final O000000o<String> o000000o) {
        if (clc == null || TextUtils.isEmpty(clc.O0000O0o) || TextUtils.isEmpty(clc.O0000OOo)) {
            o000000o.onFailure(-90001, "params is invalid");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", this.O00000oO.getDid());
            jSONObject.put("fileId", clc.O0000O0o);
            jSONObject.put("stoId", clc.O0000OOo);
            XmPluginHostApi.instance().getCloudVideoFile(context, jSONObject.toString(), new ICloudDataCallback<String>() {
                /* class _m_j.cle.AnonymousClass9 */

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
                    civ.O00000o0("AlarmManagerV2", "getAlarmFile i:" + i + " s:" + str);
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

    public static int[] O000000o(JSONArray jSONArray) {
        int[] iArr = new int[jSONArray.length()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = jSONArray.optInt(i);
        }
        return iArr;
    }

    public cle(dty dty) {
        this.O00000oO = dty;
    }

    public static List<clc> O000000o(List<clc> list, List<clc> list2) {
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
            long j = list2.get(0).O00000o0;
            while (i < list.size() && list.get(i).O00000o0 > j) {
                arrayList.add(list.get(i));
                i++;
            }
            arrayList.addAll(list2);
            return arrayList;
        }
    }

    private static long O00000o0() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(13, 0);
        instance.set(12, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis() - 518400000;
    }
}

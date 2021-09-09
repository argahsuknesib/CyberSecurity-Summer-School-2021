package com.mijia.model.alarmcloud;

import _m_j.civ;
import _m_j.dty;
import _m_j.gsy;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AlarmCloudManager {
    public static Gson gGson = new Gson();
    public dty mCameraDevice;

    @Retention(RetentionPolicy.SOURCE)
    public @interface EventType {
    }

    public static String getVideoSnapshotUrl(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("prefix", "processor.smartcamera.");
            jSONObject.put("method", "GET");
            jSONObject.put("path", "/common/app/v1/img");
            jSONObject2.put("did", str2);
            jSONObject2.put("stoId", str3);
            return XmPluginHostApi.instance().generateRequestUrl(str, jSONObject, jSONObject2);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String getFaceImg(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("model", str2);
            jSONObject.put("faceId", str3);
            jSONObject2.put("prefix", "business.smartcamera.");
            jSONObject2.put("method", "GET");
            jSONObject2.put("path", "/miot/camera/app/v1/get/face/img");
            return XmPluginHostApi.instance().generateRequestUrl(str2, jSONObject2, jSONObject);
        } catch (Exception e) {
            gsy.O000000o(6, "AlarmCloudManager", e.getLocalizedMessage());
            return null;
        }
    }

    public AlarmCloudManager(dty dty) {
        this.mCameraDevice = dty;
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
    public void getEventList(final String str, long j, long j2, AlarmCloudCallback<ArrayList<AlarmVideo>> alarmCloudCallback) {
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", this.mCameraDevice.getDid());
            jSONObject.put("model", this.mCameraDevice.getModel());
            jSONObject.put("eventType", str);
            jSONObject.put("beginTime", j);
            jSONObject.put("endTime", j2);
            jSONObject.put("limit", 50);
            jSONObject.put("needMerge", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        gsy.O00000Oo("AlarmCloudManager", "getEventList params " + jSONObject.toString());
        final AlarmCloudCallback<ArrayList<AlarmVideo>> alarmCloudCallback2 = alarmCloudCallback;
        XmPluginHostApi.instance().callSmartHomeApi(this.mCameraDevice.getModel(), "business.smartcamera.", "/common/app/get/eventlist", "GET", jSONObject, new Callback<JSONObject>() {
            /* class com.mijia.model.alarmcloud.AlarmCloudManager.AnonymousClass1 */

            public void onSuccess(JSONObject jSONObject) {
                try {
                    gsy.O00000Oo("AlarmCloudManager", "getEventList success result:");
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    final boolean z = jSONObject2.getBoolean("isContinue");
                    final long j = jSONObject2.getLong("nextTime");
                    final ArrayList arrayList = (ArrayList) AlarmCloudManager.gGson.fromJson(jSONObject2.getJSONArray("thirdPartPlayUnits").toString(), new TypeToken<ArrayList<AlarmVideo>>() {
                        /* class com.mijia.model.alarmcloud.AlarmCloudManager.AnonymousClass1.AnonymousClass1 */
                    }.getType());
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < arrayList.size(); i++) {
                        AlarmVideo alarmVideo = (AlarmVideo) arrayList.get(i);
                        alarmVideo.imgStoreUrl = AlarmCloudManager.getVideoSnapshotUrl(AlarmCloudManager.this.mCameraDevice.getModel(), AlarmCloudManager.this.mCameraDevice.getDid(), alarmVideo.imgStoreId);
                        gsy.O00000Oo("AlarmCloudManager", alarmVideo.toString());
                        if (!arrayList2.contains(alarmVideo.fileId)) {
                            arrayList2.add(alarmVideo.fileId);
                        }
                    }
                    AlarmCloudManager.this.getFaceIdsByFiledId(new Callback() {
                        /* class com.mijia.model.alarmcloud.AlarmCloudManager.AnonymousClass1.AnonymousClass2 */

                        public void onSuccess(Object obj) {
                            JSONObject jSONObject = (JSONObject) obj;
                            gsy.O00000Oo("AlarmCloudManager", "getFaceIdsByFiledId Success " + jSONObject.toString());
                            try {
                                ArrayList arrayList = (ArrayList) AlarmCloudManager.gGson.fromJson(jSONObject.getJSONObject("data").getJSONArray("fileIdMetaResults").toString(), new TypeToken<ArrayList<FileIdMetaResult>>() {
                                    /* class com.mijia.model.alarmcloud.AlarmCloudManager.AnonymousClass1.AnonymousClass2.AnonymousClass1 */
                                }.getType());
                                if (arrayList.size() > 0) {
                                    for (int i = 0; i < arrayList.size(); i++) {
                                        FileIdMetaResult fileIdMetaResult = (FileIdMetaResult) arrayList.get(i);
                                        if (fileIdMetaResult != null) {
                                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                                AlarmVideo alarmVideo = (AlarmVideo) arrayList.get(i2);
                                                if (alarmVideo.fileId.equals(fileIdMetaResult.fileId)) {
                                                    if (alarmVideo.offset == fileIdMetaResult.offset) {
                                                        alarmVideo.fileIdMetaResult = fileIdMetaResult;
                                                    } else if (alarmVideo.isAlarm && "Default".equalsIgnoreCase(str)) {
                                                        fileIdMetaResult.offset = 0;
                                                        if (alarmVideo.offset == fileIdMetaResult.offset) {
                                                            alarmVideo.fileIdMetaResult = fileIdMetaResult;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (alarmCloudCallback2 != null) {
                                    alarmCloudCallback2.onSuccess(arrayList, j, z);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                if (alarmCloudCallback2 != null) {
                                    alarmCloudCallback2.onSuccess(arrayList, j, z);
                                }
                            }
                        }

                        public void onFailure(int i, String str) {
                            gsy.O00000Oo("AlarmCloudManager", "getFaceIdsByFiledId fail errorCode = " + i + "errorMsg = " + str);
                            if (alarmCloudCallback2 != null) {
                                alarmCloudCallback2.onSuccess(arrayList, j, z);
                            }
                        }
                    }, arrayList2.toArray());
                } catch (JSONException e) {
                    e.printStackTrace();
                    AlarmCloudCallback alarmCloudCallback = alarmCloudCallback2;
                    if (alarmCloudCallback != null) {
                        alarmCloudCallback.onFailure(-1, "json error");
                    }
                }
            }

            public void onFailure(int i, String str) {
                gsy.O00000Oo("AlarmCloudManager", "getEventList fail errorCode = " + i + "errorMsg = " + str);
                alarmCloudCallback2.onFailure(i, str);
            }
        }, Parser.DEFAULT_PARSER);
    }

    public void getEventListByFileId(final String str, boolean z, final Callback<ArrayList<AlarmVideo>> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", this.mCameraDevice.getDid());
            jSONObject.put("model", this.mCameraDevice.getModel());
            jSONObject.put("fileId", str);
            jSONObject.put("isAlarm", z);
            jSONObject.put("limit", 40);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        XmPluginHostApi.instance().callSmartHomeApi(this.mCameraDevice.getModel(), "business.smartcamera.", "/common/app/get/fileIdEvents", "GET", jSONObject, new Callback<JSONObject>() {
            /* class com.mijia.model.alarmcloud.AlarmCloudManager.AnonymousClass2 */

            public void onSuccess(JSONObject jSONObject) {
                try {
                    gsy.O00000Oo("AlarmCloudManager", "getEventListByFileId success " + jSONObject.toString());
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    jSONObject2.getBoolean("isContinue");
                    jSONObject2.getLong("nextTime");
                    final ArrayList arrayList = (ArrayList) AlarmCloudManager.gGson.fromJson(jSONObject2.getJSONArray("thirdPartPlayUnits").toString(), new TypeToken<ArrayList<AlarmVideo>>() {
                        /* class com.mijia.model.alarmcloud.AlarmCloudManager.AnonymousClass2.AnonymousClass1 */
                    }.getType());
                    for (int i = 0; i < arrayList.size(); i++) {
                        AlarmVideo alarmVideo = (AlarmVideo) arrayList.get(i);
                        alarmVideo.imgStoreUrl = AlarmCloudManager.getVideoSnapshotUrl(AlarmCloudManager.this.mCameraDevice.getModel(), AlarmCloudManager.this.mCameraDevice.getDid(), alarmVideo.imgStoreId);
                        gsy.O00000Oo("AlarmCloudManager", alarmVideo.toString());
                    }
                    AlarmCloudManager.this.getFaceIdsByFiledId(new Callback() {
                        /* class com.mijia.model.alarmcloud.AlarmCloudManager.AnonymousClass2.AnonymousClass2 */

                        public void onSuccess(Object obj) {
                            JSONObject jSONObject = (JSONObject) obj;
                            gsy.O00000Oo("AlarmCloudManager", "getFaceIdsByFiledId Success " + jSONObject.toString());
                            try {
                                ArrayList arrayList = (ArrayList) AlarmCloudManager.gGson.fromJson(jSONObject.getJSONObject("data").getJSONArray("fileIdMetaResults").toString(), new TypeToken<ArrayList<FileIdMetaResult>>() {
                                    /* class com.mijia.model.alarmcloud.AlarmCloudManager.AnonymousClass2.AnonymousClass2.AnonymousClass1 */
                                }.getType());
                                if (arrayList.size() > 0) {
                                    for (int i = 0; i < arrayList.size(); i++) {
                                        FileIdMetaResult fileIdMetaResult = (FileIdMetaResult) arrayList.get(i);
                                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                            AlarmVideo alarmVideo = (AlarmVideo) arrayList.get(i2);
                                            if (alarmVideo.offset == fileIdMetaResult.offset) {
                                                alarmVideo.fileIdMetaResult = fileIdMetaResult;
                                            } else if (alarmVideo.isAlarm) {
                                                fileIdMetaResult.offset = 0;
                                                if (alarmVideo.offset == fileIdMetaResult.offset) {
                                                    alarmVideo.fileIdMetaResult = fileIdMetaResult;
                                                }
                                            }
                                        }
                                    }
                                }
                                if (callback != null) {
                                    callback.onSuccess(arrayList);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                if (callback != null) {
                                    callback.onSuccess(arrayList);
                                }
                            }
                        }

                        public void onFailure(int i, String str) {
                            gsy.O00000Oo("AlarmCloudManager", "getFaceIdsByFiledId fail errorCode = " + i + "errorMsg = " + str);
                            if (callback != null) {
                                callback.onSuccess(arrayList);
                            }
                        }
                    }, str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(-1, "json error");
                    }
                }
            }

            public void onFailure(int i, String str) {
                gsy.O00000Oo("AlarmCloudManager", "getEventListByFileId onFailure ".concat(String.valueOf(i)));
            }
        }, Parser.DEFAULT_PARSER);
    }

    public void markEvent(String str, int i, final Callback<Boolean> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", this.mCameraDevice.getDid());
            jSONObject.put("fileId", str);
            jSONObject.put("offset", i);
        } catch (Exception e) {
            civ.O00000o0("AlarmCloudManager", e.toString());
        }
        XmPluginHostApi.instance().callSmartHomeApi(this.mCameraDevice.getModel(), "business.smartcamera.", "/common/app/markRead", "POST", jSONObject.toString(), new Callback<JSONObject>() {
            /* class com.mijia.model.alarmcloud.AlarmCloudManager.AnonymousClass3 */

            public void onSuccess(JSONObject jSONObject) {
                try {
                    gsy.O00000Oo("AlarmCloudManager", "mark event read success " + jSONObject.toString());
                    String string = jSONObject.getString("result");
                    if (!TextUtils.isEmpty(string) && string.equals("ok") && callback != null) {
                        callback.onSuccess(Boolean.TRUE);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            public void onFailure(int i, String str) {
                gsy.O00000Oo("AlarmCloudManager", "getEventListByFileId onFailure ".concat(String.valueOf(i)));
            }
        }, Parser.DEFAULT_PARSER);
    }

    public void deleteStatus(String str, boolean z, final Callback<Boolean> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", this.mCameraDevice.getDid());
            jSONObject.put("fileId", str);
            jSONObject.put("isAlarm", z);
        } catch (Exception e) {
            civ.O00000o0("AlarmCloudManager", e.toString());
        }
        XmPluginHostApi.instance().callSmartHomeApi(this.mCameraDevice.getModel(), "business.smartcamera.", "/common/app/file/delete/status", "POST", jSONObject.toString(), new Callback<JSONObject>() {
            /* class com.mijia.model.alarmcloud.AlarmCloudManager.AnonymousClass4 */

            public void onSuccess(JSONObject jSONObject) {
                try {
                    gsy.O00000Oo("AlarmCloudManager", "deleteStatusByFileId success " + jSONObject.toString());
                    boolean optBoolean = new JSONObject(jSONObject.getString("data")).optBoolean("deleteStatus", false);
                    if (callback != null) {
                        callback.onSuccess(Boolean.valueOf(optBoolean));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            public void onFailure(int i, String str) {
                gsy.O00000Oo("AlarmCloudManager", "deleteStatusByFileId onFailure ".concat(String.valueOf(i)));
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public void getFaceIdsByFiledId(final Callback callback, Object... objArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", this.mCameraDevice.getDid());
            jSONObject.put("model", this.mCameraDevice.getModel());
            JSONArray jSONArray = new JSONArray();
            for (Object put : objArr) {
                jSONArray.put(put);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("fileIds", jSONArray);
            jSONObject.put("fileIds", jSONObject2);
        } catch (Exception e) {
            civ.O00000o0("AlarmCloudManager", e.toString());
        }
        String jSONObject3 = jSONObject.toString();
        civ.O00000Oo("AlarmCloudManager", "getFaceIdsByFiledId request params=".concat(String.valueOf(jSONObject3)));
        XmPluginHostApi.instance().callSmartHomeApi(this.mCameraDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/get/fileIdMetas", "GET", jSONObject3, new Callback<JSONObject>() {
            /* class com.mijia.model.alarmcloud.AlarmCloudManager.AnonymousClass5 */

            public void onSuccess(JSONObject jSONObject) {
                civ.O00000Oo("AlarmCloudManager", "onSuccess_getFaceIdsByFiledId=" + jSONObject.toString());
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(jSONObject);
                }
            }

            public void onFailure(int i, String str) {
                civ.O00000o0("AlarmCloudManager", "onFailure_getFaceIdsByFiledId code=" + i + " msg=" + str);
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public void deleteFiles(final Callback callback, boolean z, Object... objArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", this.mCameraDevice.getDid());
            jSONObject.put("model", this.mCameraDevice.getModel());
            JSONArray jSONArray = new JSONArray();
            for (Object put : objArr) {
                jSONArray.put(put);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("fileIds", jSONArray);
            jSONObject.put("fileIds", jSONObject2);
        } catch (Exception e) {
            gsy.O000000o(6, "AlarmCloudManager", e.toString());
        }
        String jSONObject3 = jSONObject.toString();
        gsy.O00000Oo("AlarmCloudManager", "deleteFiles request params=".concat(String.valueOf(jSONObject3)));
        XmPluginHostApi.instance().callSmartHomeApi(this.mCameraDevice.getModel(), "business.smartcamera.", "/common/app/v2/delete/files", "POST", jSONObject3, new Callback<JSONObject>() {
            /* class com.mijia.model.alarmcloud.AlarmCloudManager.AnonymousClass6 */

            public void onSuccess(JSONObject jSONObject) {
                civ.O00000Oo("AlarmCloudManager", "onSuccess_deleteFiles=" + jSONObject.toString());
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(jSONObject);
                }
            }

            public void onFailure(int i, String str) {
                civ.O00000o0("AlarmCloudManager", "onFailure_deleteFiles code=" + i + " msg=" + str);
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public void feedBack(String str, boolean z, final Callback callback, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", this.mCameraDevice.getDid());
            jSONObject.put("model", this.mCameraDevice.getModel());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("fileId", str);
            jSONObject.put("isVisible", z);
            jSONObject.put("type", str2);
        } catch (Exception e) {
            civ.O00000o0("AlarmCloudManager", e.toString());
        }
        String jSONObject2 = jSONObject.toString();
        civ.O00000Oo("AlarmCloudManager", "feedBack request params=".concat(String.valueOf(jSONObject2)));
        XmPluginHostApi.instance().callSmartHomeApi(this.mCameraDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/feedback", "POST", jSONObject2, new Callback<JSONObject>() {
            /* class com.mijia.model.alarmcloud.AlarmCloudManager.AnonymousClass7 */

            public void onSuccess(JSONObject jSONObject) {
                civ.O00000Oo("AlarmCloudManager", "onSuccess_feedBack=" + jSONObject.toString());
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(jSONObject);
                }
            }

            public void onFailure(int i, String str) {
                civ.O00000o0("AlarmCloudManager", "onFailure_feedBack code=" + i + " msg=" + str);
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }
}

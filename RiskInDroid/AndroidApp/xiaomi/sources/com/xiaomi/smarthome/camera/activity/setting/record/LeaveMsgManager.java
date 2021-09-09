package com.xiaomi.smarthome.camera.activity.setting.record;

import _m_j.cin;
import _m_j.civ;
import _m_j.dty;
import android.content.Context;
import com.google.gson.Gson;
import com.xiaomi.smarthome.camera.activity.setting.RecordingVoiceActivity;
import com.xiaomi.smarthome.camera.activity.setting.bean.CommonResult;
import com.xiaomi.smarthome.camera.activity.setting.bean.Desc;
import com.xiaomi.smarthome.camera.activity.setting.bean.GetLeavMsgData;
import com.xiaomi.smarthome.camera.activity.setting.bean.LeaveMsg;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class LeaveMsgManager {
    public static final String TAG = RecordingVoiceActivity.class.getSimpleName();
    public static Gson gson = new Gson();
    private static LeaveMsgManager leaveMsgManager = new LeaveMsgManager();
    public ArrayList<LeaveMsg> allMsgs = new ArrayList<>();
    private Context context;
    DownLoadLeaveMsgTask downLoadLeaveMsgTask = new DownLoadLeaveMsgTask();

    public static LeaveMsgManager getInstance(Context context2) {
        LeaveMsgManager leaveMsgManager2 = leaveMsgManager;
        leaveMsgManager2.context = context2;
        return leaveMsgManager2;
    }

    public void addDownLoadItem(long j, String str, String str2) {
        final String str3 = str2;
        final long j2 = j;
        final String str4 = str;
        this.downLoadLeaveMsgTask.start(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.setting.record.LeaveMsgManager.AnonymousClass1 */

            public void run() {
                String audioFilePath = LeaveMsgUtil.getAudioFilePath(str3, j2);
                civ.O000000o(LeaveMsgManager.TAG, "addDownLoadItem ==filePath".concat(String.valueOf(audioFilePath)));
                civ.O000000o(LeaveMsgManager.TAG, "dataHex===" + str4);
                try {
                    byte[] O000000o2 = cin.O000000o(str4);
                    File file = new File(audioFilePath);
                    if (!file.exists()) {
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            fileOutputStream.write(O000000o2);
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            LeaveMsgManager.this.downLoadLeaveMsgTask.successCount++;
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        });
    }

    class DownLoadLeaveMsgTask {
        LinkedBlockingDeque<Runnable> linkedBlockingDeque = new LinkedBlockingDeque<>();
        public volatile int successCount = 0;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, this.linkedBlockingDeque);

        DownLoadLeaveMsgTask() {
        }

        public void start(Runnable runnable) {
            this.threadPoolExecutor.execute(runnable);
        }
    }

    public void putData(dty dty, long j, String str, String str2, final Callback<Object> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", dty.getDid());
            jSONObject.put("type", "AUDIO");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", str2);
            jSONObject2.put("duration", j * 1000);
            jSONObject.put("desc", jSONObject2);
            jSONObject.put("itemData", str);
        } catch (Exception e) {
            civ.O000000o(TAG, e.toString());
        }
        XmPluginHostApi.instance().callSmartHomeApi(dty.getModel(), "business.smartcamera", "/common/app/data/put", "POST", jSONObject.toString(), new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.camera.activity.setting.record.LeaveMsgManager.AnonymousClass2 */

            public void onSuccess(JSONObject jSONObject) {
                try {
                    String str = LeaveMsgManager.TAG;
                    civ.O000000o(str, "putData onSuccess=" + jSONObject.toString());
                    long j = jSONObject.getJSONObject("data").getLong("id");
                    if (callback != null) {
                        callback.onSuccess(Long.valueOf(j));
                    }
                } catch (Exception e) {
                    civ.O000000o(LeaveMsgManager.TAG, e.toString());
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(0, e.toString());
                    }
                }
            }

            public void onFailure(int i, String str) {
                String str2 = LeaveMsgManager.TAG;
                civ.O000000o(str2, "putData onFailure=" + i + "  " + str);
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public ArrayList<LeaveMsg> getAllMsgs() {
        return this.allMsgs;
    }

    public void getData(final dty dty, int i, int i2, final Callback<Object> callback) {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", dty.getDid());
            jSONObject.put("type", "AUDIO");
            jSONObject.put("startItemId", i);
            jSONObject.put("limit", 1);
        } catch (Exception e) {
            civ.O000000o(TAG, e.toString());
        }
        String jSONObject2 = jSONObject.toString();
        civ.O000000o(TAG, "getData params=".concat(String.valueOf(jSONObject2)));
        getOneMsg(dty, jSONObject2, new Callback<GetLeavMsgData>() {
            /* class com.xiaomi.smarthome.camera.activity.setting.record.LeaveMsgManager.AnonymousClass3 */

            public void onSuccess(GetLeavMsgData getLeavMsgData) {
                try {
                    String str = LeaveMsgManager.TAG;
                    civ.O000000o(str, "getData onSuccess=" + getLeavMsgData.toString());
                    LeaveMsgManager.this.allMsgs.addAll(getLeavMsgData.resultList);
                    if (getLeavMsgData.isContinue) {
                        jSONObject.put("startItemId", getLeavMsgData.nextStartItemId);
                        String jSONObject = jSONObject.toString();
                        civ.O000000o(LeaveMsgManager.TAG, "getData params=".concat(String.valueOf(jSONObject)));
                        LeaveMsgManager.this.getOneMsg(dty, jSONObject, this);
                    } else if (callback != null) {
                        callback.onSuccess(null);
                    }
                } catch (Exception e) {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(0, e.toString());
                    }
                }
            }

            public void onFailure(int i, String str) {
                String str2 = LeaveMsgManager.TAG;
                civ.O000000o(str2, "getData onFailure=" + i + "  " + str);
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        });
    }

    public void getOneMsg(final dty dty, String str, final Callback<GetLeavMsgData> callback) {
        XmPluginHostApi.instance().callSmartHomeApi(dty.getModel(), "business.smartcamera", "/common/app/data/scan", "GET", str, new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.camera.activity.setting.record.LeaveMsgManager.AnonymousClass4 */

            public void onSuccess(JSONObject jSONObject) {
                String str = LeaveMsgManager.TAG;
                civ.O000000o(str, "getData onSuccess=" + jSONObject.toString());
                try {
                    CommonResult commonResult = (CommonResult) LeaveMsgManager.gson.fromJson(jSONObject.toString(), CommonResult.class);
                    if (commonResult.code == 0) {
                        String jsonObject = commonResult.data.getAsJsonObject().toString();
                        civ.O000000o(LeaveMsgManager.TAG, "dataJson=".concat(String.valueOf(jsonObject)));
                        GetLeavMsgData getLeavMsgData = (GetLeavMsgData) LeaveMsgManager.gson.fromJson(jsonObject, GetLeavMsgData.class);
                        Iterator<LeaveMsg> it = getLeavMsgData.resultList.iterator();
                        while (it.hasNext()) {
                            LeaveMsg next = it.next();
                            next.descObj = (Desc) LeaveMsgManager.gson.fromJson(next.desc, Desc.class);
                            String str2 = next.itemData;
                            next.itemData = null;
                            LeaveMsgManager.this.addDownLoadItem(next.itemId, str2, dty.getDid());
                        }
                        if (callback != null) {
                            callback.onSuccess(getLeavMsgData);
                        }
                    }
                } catch (Exception e) {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(0, e.toString());
                    }
                }
            }

            public void onFailure(int i, String str) {
                String str2 = LeaveMsgManager.TAG;
                civ.O000000o(str2, "getData onFailure=" + i + "  " + str);
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public void removeItem(dty dty, long j, final Callback<Object> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", dty.getDid());
            jSONObject.put("type", "AUDIO");
            jSONObject.put("itemId", j);
        } catch (Exception e) {
            civ.O000000o(TAG, e.toString());
        }
        String jSONObject2 = jSONObject.toString();
        civ.O000000o(TAG, "removeItem params=".concat(String.valueOf(jSONObject2)));
        XmPluginHostApi.instance().callSmartHomeApi(dty.getModel(), "business.smartcamera", "/common/app/data/remove", "POST", jSONObject2, new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.camera.activity.setting.record.LeaveMsgManager.AnonymousClass5 */

            public void onSuccess(JSONObject jSONObject) {
                try {
                    String str = LeaveMsgManager.TAG;
                    civ.O000000o(str, "removeItem onSuccess=" + jSONObject.toString());
                    boolean z = jSONObject.getJSONObject("data").getBoolean("removeResult");
                    if (!z) {
                        civ.O000000o(LeaveMsgManager.TAG, "removeResult=".concat(String.valueOf(z)));
                        if (callback != null) {
                            callback.onFailure(0, "removeResult = false");
                        }
                    } else if (callback != null) {
                        callback.onSuccess(Boolean.valueOf(z));
                    }
                } catch (Exception e) {
                    civ.O000000o(LeaveMsgManager.TAG, e.toString());
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(0, e.toString());
                    }
                }
            }

            public void onFailure(int i, String str) {
                String str2 = LeaveMsgManager.TAG;
                civ.O000000o(str2, "removeItem onFailure=" + i + "  " + str);
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public void modifyItem(dty dty, long j, String str, long j2, Callback<Object> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", dty.getDid());
            jSONObject.put("type", "AUDIO");
            long j3 = j;
            jSONObject.put("itemId", j);
            JSONObject jSONObject2 = new JSONObject();
            String str2 = str;
            jSONObject2.put("name", str);
            jSONObject2.put("duration", j2);
            jSONObject.put("desc", jSONObject2);
        } catch (Exception e) {
            civ.O000000o(TAG, e.toString());
        }
        String jSONObject3 = jSONObject.toString();
        civ.O000000o(TAG, "modifyItem params=".concat(String.valueOf(jSONObject3)));
        final Callback<Object> callback2 = callback;
        XmPluginHostApi.instance().callSmartHomeApi(dty.getModel(), "business.smartcamera", "/common/app/data/modify", "POST", jSONObject3, new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.camera.activity.setting.record.LeaveMsgManager.AnonymousClass6 */

            public void onSuccess(JSONObject jSONObject) {
                try {
                    String str = LeaveMsgManager.TAG;
                    civ.O000000o(str, "modifyItem onSuccess=" + jSONObject.toString());
                    boolean z = jSONObject.getJSONObject("data").getBoolean("modifyResult");
                    if (!z) {
                        civ.O000000o(LeaveMsgManager.TAG, "modifyResult=".concat(String.valueOf(z)));
                        if (callback2 != null) {
                            callback2.onFailure(0, "modifyResult = false");
                        }
                    } else if (callback2 != null) {
                        callback2.onSuccess(Boolean.valueOf(z));
                    }
                } catch (Exception e) {
                    civ.O000000o(LeaveMsgManager.TAG, e.toString());
                    Callback callback = callback2;
                    if (callback != null) {
                        callback.onFailure(0, e.toString());
                    }
                }
            }

            public void onFailure(int i, String str) {
                String str2 = LeaveMsgManager.TAG;
                civ.O000000o(str2, "modifyItem onFailure=" + i + "  " + str);
                Callback callback = callback2;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }
}

package com.xiaomi.smarthome.miio.camera.face.util;

import _m_j.clf;
import _m_j.gsy;
import android.content.Context;
import android.os.AsyncTask;
import com.Utils.MediaStoreUtil;
import com.google.gson.Gson;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.ICloudDataCallback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.miio.camera.face.model.CommonResult;
import com.xiaomi.smarthome.miio.camera.face.model.DailyStoryList;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DailyStoryNetUtils {
    public static Gson gGson = new Gson();
    private static volatile DailyStoryNetUtils sInstance;

    public interface ICallback<T> {
        void onFailure(int i, String str);

        void onSuccess(Object obj);
    }

    private DailyStoryNetUtils() {
    }

    public static DailyStoryNetUtils getInstance() {
        if (sInstance == null) {
            synchronized (DailyStoryNetUtils.class) {
                if (sInstance == null) {
                    sInstance = new DailyStoryNetUtils();
                }
            }
        }
        return sInstance;
    }

    public void switchDailyStory(String str, String str2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            Locale O00oOooo = CoreApi.O000000o().O00oOooo();
            if (O00oOooo != null) {
                jSONObject.put("region", O00oOooo.getCountry());
            } else {
                jSONObject.put("region", Locale.getDefault().getCountry());
            }
            jSONObject.put("open", z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        XmPluginHostApi.instance().callSmartHomeApi(str2, "business.smartcamera.", "/miot/camera/app/v1/put/dailyStorySwitch", "POST", jSONObject.toString(), new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.miio.camera.face.util.DailyStoryNetUtils.AnonymousClass1 */

            public void onSuccess(JSONObject jSONObject) {
                gsy.O00000Oo("DailyStoryNetUtils", "onSuccess_switchDailyStory=" + jSONObject.toString());
            }

            public void onFailure(int i, String str) {
                gsy.O00000Oo("DailyStoryNetUtils", "onFailure_switchDailyStory code = " + i + " message = " + str);
            }
        }, Parser.DEFAULT_PARSER);
    }

    public void getDailyStoryList(String str, int i, String str2, String str3, final ICallback iCallback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("category", i);
            jSONObject.put("model", str2);
            jSONObject.put("endTime", new Date().getTime());
            jSONObject.put("limit", 30);
            jSONObject.put("region", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        gsy.O00000Oo("DailyStoryNetUtils", "getDailyStoryList request params=".concat(String.valueOf(jSONObject2)));
        XmPluginHostApi.instance().callSmartHomeApi(str2, "business.smartcamera.", "/miot/camera/app/v1/dailyStory/playlist", "GET", jSONObject2, new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.miio.camera.face.util.DailyStoryNetUtils.AnonymousClass2 */

            public void onSuccess(JSONObject jSONObject) {
                gsy.O00000Oo("DailyStoryNetUtils", "onSuccess_getDailyStoryList = " + jSONObject.toString());
                iCallback.onSuccess(DailyStoryNetUtils.gGson.fromJson(((CommonResult) DailyStoryNetUtils.gGson.fromJson(jSONObject.toString(), CommonResult.class)).data, DailyStoryList.class));
            }

            public void onFailure(int i, String str) {
                gsy.O00000Oo("DailyStoryNetUtils", "onFailure_getDailyStoryList code = " + i + " message = " + str);
                iCallback.onFailure(i, str);
            }
        }, Parser.DEFAULT_PARSER);
    }

    public String getVideoFileUrl(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("prefix", "business.smartcamera.");
            jSONObject.put("method", "GET");
            jSONObject.put("path", "/miot/camera/app/v1/dailyStory/m3u8");
            jSONObject2.put("did", str2);
            jSONObject2.put("region", str3);
            jSONObject2.put("fileId", str4);
            return XmPluginHostApi.instance().generateRequestUrl(str, jSONObject, jSONObject2);
        } catch (JSONException unused) {
            return null;
        }
    }

    public void downloadVideo(String str, String str2, String str3, String str4, String str5, Context context, boolean z, clf.O000000o o000000o) {
        String videoFileUrl = getVideoFileUrl(str, str2, str3, str4);
        final String str6 = str5;
        final String str7 = str;
        final boolean z2 = z;
        final Context context2 = context;
        final String str8 = str2;
        final clf.O000000o o000000o2 = o000000o;
        final String str9 = str4;
        XmPluginHostApi.instance().getCloudVideoFile(str2, str4, videoFileUrl, new ICloudDataCallback() {
            /* class com.xiaomi.smarthome.miio.camera.face.util.DailyStoryNetUtils.AnonymousClass3 */

            public void onCloudDataSuccess(Object obj, Object obj2) {
                final ArrayList arrayList = (ArrayList) obj;
                new AsyncTask<Void, Void, Integer>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.util.DailyStoryNetUtils.AnonymousClass3.AnonymousClass1 */

                    /* access modifiers changed from: protected */
                    public Integer doInBackground(Void... voidArr) {
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
                        return Integer.valueOf(XmPluginHostApi.instance().videoConverter(str7, "ffmpeg -f concat -safe 0 -i " + file.getAbsolutePath() + " -c copy " + str6));
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(Integer num) {
                        super.onPostExecute((Object) num);
                        if (num.intValue() == 0) {
                            deleteM3U8();
                            File file = new File(str6);
                            if (!z2) {
                                MediaStoreUtil.O00000Oo(context2, str6, str8, file.getName());
                            }
                            o000000o2.onComplete();
                            return;
                        }
                        o000000o2.onError(num.intValue(), "yd ffmpeg  failure");
                    }

                    private void deleteM3U8() {
                        deleteDirWihtFile(new File(context2.getExternalFilesDir(str8) + File.separator + str9));
                    }

                    private void deleteDirWihtFile(File file) {
                        if (file != null && file.exists() && file.isDirectory()) {
                            for (File file2 : file.listFiles()) {
                                if (file2.isFile()) {
                                    file2.delete();
                                } else if (file2.isDirectory()) {
                                    deleteDirWihtFile(file2);
                                }
                            }
                            file.delete();
                        }
                    }
                }.execute(new Void[0]);
            }

            public void onCloudDataFailed(int i, String str) {
                o000000o2.onError(i, str);
            }

            public void onCloudDataProgress(int i) {
                o000000o2.onProgress(i);
            }
        });
    }

    public void deleteVideo(String str, String str2, String str3, Object[] objArr, final ICallback iCallback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("region", str3);
            JSONArray jSONArray = new JSONArray();
            for (Object put : objArr) {
                jSONArray.put(put);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("fileIds", jSONArray);
            jSONObject.put("fileIds", jSONObject2);
            XmPluginHostApi.instance().callSmartHomeApi(str2, "business.smartcamera.", "/miot/camera/app/v1/dailyStory/delete", "POST", jSONObject.toString(), new Callback<JSONObject>() {
                /* class com.xiaomi.smarthome.miio.camera.face.util.DailyStoryNetUtils.AnonymousClass4 */

                public void onSuccess(JSONObject jSONObject) {
                    gsy.O00000Oo("DailyStoryNetUtils", "onSuccess_deleteVideo=" + jSONObject.toString());
                    CommonResult commonResult = (CommonResult) DailyStoryNetUtils.gGson.fromJson(jSONObject.toString(), CommonResult.class);
                    if (commonResult.code == 0) {
                        ICallback iCallback = iCallback;
                        if (iCallback != null) {
                            iCallback.onSuccess(null);
                            return;
                        }
                        return;
                    }
                    ICallback iCallback2 = iCallback;
                    if (iCallback2 != null) {
                        int i = commonResult.code;
                        StringBuilder sb = new StringBuilder();
                        sb.append(commonResult.code);
                        iCallback2.onFailure(i, sb.toString());
                    }
                }

                public void onFailure(int i, String str) {
                    gsy.O000000o(6, "DailyStoryNetUtils", "onFailure_deleteVideo code=" + i + " msg=" + str);
                    ICallback iCallback = iCallback;
                    if (iCallback != null) {
                        iCallback.onFailure(i, str);
                    }
                }
            }, Parser.DEFAULT_PARSER);
        } catch (Exception e) {
            gsy.O000000o(6, "DailyStoryNetUtils", e.getLocalizedMessage());
            if (iCallback != null) {
                iCallback.onFailure(-1001, e.getLocalizedMessage());
            }
        }
    }
}

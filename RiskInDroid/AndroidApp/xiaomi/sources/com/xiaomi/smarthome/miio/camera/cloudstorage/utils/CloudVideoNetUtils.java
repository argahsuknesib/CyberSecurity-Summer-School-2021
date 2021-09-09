package com.xiaomi.smarthome.miio.camera.cloudstorage.utils;

import _m_j.cih;
import _m_j.fju;
import _m_j.flj;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ftn;
import _m_j.gkv;
import _m_j.grs;
import _m_j.grt;
import _m_j.grx;
import _m_j.grz;
import _m_j.gsy;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.ICloudDataCallback;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoWebActivity;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoUserStatus;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.DailyList;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.ICloudVideoCallback;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.StatsRecord;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.StatsRecord2;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.FileDownloadAndDecryptTask;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudVideoNetUtils {
    private static volatile CloudVideoNetUtils sInstance;
    private OkHttpClient client = new OkHttpClient();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    static /* synthetic */ JSONObject lambda$checkCloudStorageStatus$12(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    static /* synthetic */ JSONObject lambda$deleteFiles$6(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    static /* synthetic */ JSONObject lambda$getCloudPromoteTipsInternal$15(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    static /* synthetic */ JSONObject lambda$getCloudStatus$17(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    static /* synthetic */ JSONObject lambda$getDeductOrders$11(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    static /* synthetic */ JSONObject lambda$getMipaySignIN$14(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    static /* synthetic */ JSONObject lambda$getMipaySignV2$13(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    static /* synthetic */ JSONObject lambda$getSettingCapacity$9(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    static /* synthetic */ JSONObject lambda$getSettingStatus$10(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    static /* synthetic */ JSONObject lambda$getSettingUsage$7(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    static /* synthetic */ JSONObject lambda$getVideoDailyList$2(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    static /* synthetic */ JSONObject lambda$getVideoDailyListLimit$3(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    static /* synthetic */ JSONObject lambda$getVideoDailyListLimitV2$4(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    static /* synthetic */ JSONObject lambda$getVideoDates$0(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    static /* synthetic */ JSONObject lambda$getVideoDatesSerial$1(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    static /* synthetic */ JSONObject lambda$isNewUser$16(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    static /* synthetic */ JSONObject lambda$loadAllCameraCloudStorageInfo$5(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    static /* synthetic */ JSONObject lambda$setSettingUsage$8(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    private CloudVideoNetUtils() {
    }

    public static CloudVideoNetUtils getInstance() {
        if (sInstance == null) {
            synchronized (CloudVideoNetUtils.class) {
                if (sInstance == null) {
                    sInstance = new CloudVideoNetUtils();
                }
            }
        }
        return sInstance;
    }

    public long toGMT8TimeZone(long j) {
        Calendar instance = Calendar.getInstance(TimeZone.getDefault());
        instance.setTimeInMillis(j);
        instance.add(14, -(instance.get(15) + instance.get(16)));
        Calendar instance2 = Calendar.getInstance(TimeZone.getTimeZone("GMT+08"));
        instance2.setTimeInMillis(instance.getTimeInMillis());
        instance2.add(14, instance2.get(15) + instance2.get(16));
        return instance2.getTimeInMillis();
    }

    public long toLocalTimeZone(long j) {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("GMT+08"));
        instance.setTimeInMillis(j);
        instance.add(14, -(instance.get(15) + instance.get(16)));
        Calendar instance2 = Calendar.getInstance(TimeZone.getDefault());
        instance2.setTimeInMillis(instance.getTimeInMillis());
        instance2.add(14, instance2.get(15) + instance2.get(16));
        return instance2.getTimeInMillis();
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    public boolean isWifiConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return false;
        }
        if (activeNetworkInfo.getType() == 1 || activeNetworkInfo.getType() == 9) {
            return true;
        }
        return false;
    }

    public void openCloudVideoBuyPage(Context context, String str) {
        Intent intent = new Intent(context, CloudVideoWebActivity.class);
        intent.putExtra("title", context.getString(R.string.buy_cloud_service));
        intent.putExtra("url", cih.O000000o(getCloudVideoPurchaseUrl(str)));
        intent.putExtra("did", str);
        context.startActivity(intent);
    }

    public void openCloudVideoBuyPage(Context context, String str, String str2) {
        Intent intent = new Intent(context, CloudVideoWebActivity.class);
        intent.putExtra("title", context.getString(R.string.buy_cloud_service));
        if (TextUtils.isEmpty(str2)) {
            str2 = cih.O000000o("camera.api.io.mi.com/miot/camera/web/vip/mipay_sr62m5p7ds/v2/home");
        }
        intent.putExtra("url", str2);
        intent.putExtra("did", str);
        context.startActivity(intent);
    }

    public void openCloudVideoManagePage(Context context, String str) {
        openCloudVideoManagePage(context, str, false);
    }

    public void openCloudVideoManagePage(Context context, String str, boolean z) {
        openCloudVideoManagePage(context, str, null, z);
    }

    public void openCloudVideoManagePage(Context context, String str, String str2, boolean z) {
        Intent intent = new Intent(context, CloudVideoWebActivity.class);
        intent.putExtra("title", context.getString(R.string.cs_my_service));
        if (TextUtils.isEmpty(str2)) {
            str2 = getCloudVideoManagementUrl(str);
        }
        intent.putExtra("url", cih.O000000o(str2));
        intent.putExtra("did", str);
        intent.putExtra("is_hs_panorama_video", z);
        context.startActivity(intent);
    }

    public void getVideoDates(Context context, String str, final ICloudVideoCallback<List<StatsRecord>> iCloudVideoCallback) {
        if (TextUtils.isEmpty(str) || context == null) {
            gsy.O000000o(6, "CloudVideoNetUtils", "params is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", str));
        Context context2 = context;
        CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O00000o0("business.smartcamera.").O000000o("GET").O00000Oo("/miot/camera/app/v1/all").O000000o(arrayList).O000000o(), $$Lambda$CloudVideoNetUtils$uooh4jgVCRcidr7YSQXfY7Cv7WI.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils.AnonymousClass1 */

            public void onSuccess(JSONObject jSONObject) {
                ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                if (iCloudVideoCallback == null) {
                    return;
                }
                if (jSONObject == null) {
                    iCloudVideoCallback.onCloudVideoFailed(-90002, "result is null");
                } else if (jSONObject.optInt("code", -90003) == 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        JSONArray optJSONArray = optJSONObject.optJSONArray("statsRecords");
                        if (optJSONArray == null || optJSONArray.length() <= 0) {
                            iCloudVideoCallback.onCloudVideoFailed(-90002, "statsRecords is empty");
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            StatsRecord statsRecord = new StatsRecord();
                            statsRecord.date = optJSONArray.optJSONObject(i).optString("date", null);
                            statsRecord.count = optJSONArray.optJSONObject(i).optInt("count", 0);
                            arrayList.add(statsRecord);
                        }
                        if (iCloudVideoCallback == null || arrayList.size() <= 0) {
                            iCloudVideoCallback.onCloudVideoFailed(-90002, "list is empty");
                        } else {
                            iCloudVideoCallback.onCloudVideoSuccess(arrayList, null);
                        }
                    } else {
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "data is null");
                    }
                } else {
                    iCloudVideoCallback.onCloudVideoFailed(-90002, "code is not 0");
                }
            }

            public void onFailure(fso fso) {
                ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                if (iCloudVideoCallback == null) {
                    return;
                }
                if (fso != null) {
                    int i = fso.f17063O000000o;
                    iCloudVideoCallback.onCloudVideoFailed(i, fso.O00000Oo);
                    return;
                }
                iCloudVideoCallback.onCloudVideoFailed(-90001, "FAIL_GENERAL");
            }
        });
    }

    public void getVideoDatesSerial(Context context, String str, final ICloudVideoCallback<List<StatsRecord2>> iCloudVideoCallback) {
        if (TextUtils.isEmpty(str) || context == null) {
            gsy.O000000o(6, "CloudVideoNetUtils", "params is null");
            return;
        }
        gsy.O00000Oo("CloudVideoNetUtils", "getVideoDatesSerial params=".concat(String.valueOf(str)));
        gsy.O00000Oo("CloudVideoNetUtils", "getVideoDatesSerial url=/common/app/v1/cloud/file/exist");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", str));
        Context context2 = context;
        CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O00000o0("business.smartcamera.").O000000o("GET").O00000Oo("/common/app/v1/cloud/file/exist").O000000o(arrayList).O000000o(), $$Lambda$CloudVideoNetUtils$FDfqgjBFleQqpmS7NsoGToVXns.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils.AnonymousClass2 */

            public void onSuccess(JSONObject jSONObject) {
                gsy.O00000Oo("CloudVideoNetUtils", "getVideoDatesSerial result=".concat(String.valueOf(jSONObject)));
                ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                if (iCloudVideoCallback == null) {
                    return;
                }
                if (jSONObject == null) {
                    iCloudVideoCallback.onCloudVideoFailed(-90002, "result is null");
                } else if (jSONObject.optInt("code", -90003) == 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        JSONArray optJSONArray = optJSONObject.optJSONArray("filesExist");
                        if (optJSONArray == null || optJSONArray.length() <= 0) {
                            iCloudVideoCallback.onCloudVideoFailed(-90002, "FilesExist is empty");
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            StatsRecord2 statsRecord2 = new StatsRecord2();
                            statsRecord2.timeStamp = optJSONArray.optJSONObject(i).optLong("timeStamp", 0);
                            statsRecord2.isExist = optJSONArray.optJSONObject(i).optBoolean("exist", false);
                            arrayList.add(statsRecord2);
                        }
                        if (iCloudVideoCallback == null || arrayList.size() <= 0) {
                            iCloudVideoCallback.onCloudVideoFailed(-90002, "list is empty");
                        } else {
                            iCloudVideoCallback.onCloudVideoSuccess(arrayList, null);
                        }
                    } else {
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "data is null");
                    }
                } else {
                    iCloudVideoCallback.onCloudVideoFailed(-90002, "code is not 0");
                }
            }

            public void onFailure(fso fso) {
                if (iCloudVideoCallback == null) {
                    return;
                }
                if (fso != null) {
                    gsy.O00000Oo("CloudVideoNetUtils", "getVideoDatesSerial error=" + fso.f17063O000000o + "-" + fso.O00000Oo);
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    int i = fso.f17063O000000o;
                    iCloudVideoCallback.onCloudVideoFailed(i, fso.O00000Oo);
                    return;
                }
                gsy.O00000Oo("CloudVideoNetUtils", "getVideoDatesSerial error=null");
                iCloudVideoCallback.onCloudVideoFailed(-90001, "FAIL_GENERAL");
            }
        });
    }

    public void getVideoDailyList(Context context, String str, final ICloudVideoCallback<List<DailyList>> iCloudVideoCallback) {
        if (context != null && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", str));
            Context context2 = context;
            CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O00000o0("business.smartcamera.").O000000o("GET").O00000Oo("/miot/camera/app/v1/cloud/playlist").O000000o(arrayList).O000000o(), $$Lambda$CloudVideoNetUtils$HMDB_SVGbVOptt589_FFfsp7wfQ.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils.AnonymousClass3 */

                public void onSuccess(JSONObject jSONObject) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback != null) {
                        if (jSONObject != null) {
                            int optInt = jSONObject.optInt("code", -90003);
                            if (optInt == 0) {
                                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                                if (optJSONObject != null) {
                                    gsy.O00000Oo("CloudVideoNetUtils", "data:" + optJSONObject.toString());
                                    JSONArray optJSONArray = optJSONObject.optJSONArray("playUnits");
                                    String optString = optJSONObject.optString("date");
                                    ArrayList arrayList = new ArrayList();
                                    if (optJSONArray == null || optJSONArray.length() <= 0) {
                                        iCloudVideoCallback.onCloudVideoFailed(-90002, "playUnits error");
                                        return;
                                    }
                                    for (int i = 0; i < optJSONArray.length(); i++) {
                                        DailyList dailyList = new DailyList();
                                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                                        if (optJSONObject2 != null) {
                                            dailyList.duration = optJSONObject2.optLong("duration");
                                            dailyList.expireTime = optJSONObject2.optLong("expireTime");
                                            dailyList.createTime = optJSONObject2.optLong("createTime");
                                            dailyList.imgStoreId = optJSONObject2.optString("imgStoreId");
                                            dailyList.fileId = optJSONObject2.optString("fileId");
                                            String optString2 = optJSONObject2.optString("tags");
                                            if (TextUtils.isEmpty(optString2) || !optString2.contains("people")) {
                                                dailyList.isHuman = false;
                                            } else {
                                                dailyList.isHuman = true;
                                            }
                                            arrayList.add(dailyList);
                                        }
                                    }
                                    if (arrayList.size() > 0) {
                                        Collections.sort(arrayList, $$Lambda$CloudVideoNetUtils$3$9v64diKFdDa025JxO8NnK_A7dU.INSTANCE);
                                        iCloudVideoCallback.onCloudVideoSuccess(arrayList, optString);
                                        return;
                                    }
                                    iCloudVideoCallback.onCloudVideoFailed(-90002, "list data error");
                                    return;
                                }
                                iCloudVideoCallback.onCloudVideoFailed(-90002, "data is null");
                                return;
                            }
                            iCloudVideoCallback.onCloudVideoFailed(optInt, "result is fail");
                            return;
                        }
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "result is null");
                    }
                }

                static /* synthetic */ int lambda$onSuccess$0(DailyList dailyList, DailyList dailyList2) {
                    return dailyList.createTime > dailyList2.createTime ? 1 : -1;
                }

                public void onFailure(fso fso) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (fso != null) {
                        int i = fso.f17063O000000o;
                        iCloudVideoCallback.onCloudVideoFailed(i, fso.O00000Oo);
                        return;
                    }
                    iCloudVideoCallback.onCloudVideoFailed(-90001, "FAIL_GENERAL");
                }
            });
        }
    }

    public void getVideoDailyListLimit(Context context, String str, final ICloudVideoCallback<List<DailyList>> iCloudVideoCallback) {
        if (context != null && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", str));
            Context context2 = context;
            CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O00000o0("business.smartcamera.").O000000o("GET").O00000Oo("/miot/camera/app/v1/cloud/playlist/limit").O000000o(arrayList).O000000o(), $$Lambda$CloudVideoNetUtils$n0Nv0kZEE0F3RJszjTmSpNQWZ0I.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils.AnonymousClass4 */

                public void onSuccess(JSONObject jSONObject) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback != null) {
                        if (jSONObject != null) {
                            int optInt = jSONObject.optInt("code", -90003);
                            if (optInt == 0) {
                                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                                if (optJSONObject != null) {
                                    JSONArray optJSONArray = optJSONObject.optJSONArray("playUnits");
                                    optJSONObject.optString("date");
                                    Long valueOf = Long.valueOf(optJSONObject.optLong("timeStamp", 0));
                                    ArrayList arrayList = new ArrayList();
                                    if (optJSONArray == null || optJSONArray.length() <= 0) {
                                        iCloudVideoCallback.onCloudVideoFailed(-90004, "playUnits error");
                                        return;
                                    }
                                    gsy.O00000Oo("CloudVideoNetUtils", "playUnits:" + optJSONArray.toString());
                                    for (int i = 0; i < optJSONArray.length(); i++) {
                                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                                        if (optJSONObject2 != null) {
                                            DailyList dailyList = new DailyList();
                                            dailyList.duration = optJSONObject2.optLong("duration");
                                            dailyList.expireTime = optJSONObject2.optLong("expireTime");
                                            dailyList.createTime = optJSONObject2.optLong("createTime");
                                            dailyList.imgStoreId = optJSONObject2.optString("imgStoreId");
                                            dailyList.fileId = optJSONObject2.optString("fileId");
                                            String optString = optJSONObject2.optString("tags");
                                            if (TextUtils.isEmpty(optString) || !optString.contains("people")) {
                                                dailyList.isHuman = false;
                                            } else {
                                                dailyList.isHuman = true;
                                            }
                                            arrayList.add(dailyList);
                                        }
                                    }
                                    if (arrayList.size() > 0) {
                                        iCloudVideoCallback.onCloudVideoSuccess(arrayList, valueOf);
                                    } else {
                                        iCloudVideoCallback.onCloudVideoFailed(-90002, "list data error");
                                    }
                                } else {
                                    iCloudVideoCallback.onCloudVideoFailed(-90002, "data is null");
                                }
                            } else {
                                iCloudVideoCallback.onCloudVideoFailed(optInt, "result is fail");
                            }
                        } else {
                            iCloudVideoCallback.onCloudVideoFailed(-90002, "result is null");
                        }
                    }
                }

                public void onFailure(fso fso) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (fso != null) {
                        gsy.O000000o(6, "CloudVideoNetUtils", "error:" + fso.f17063O000000o + fso.O00000Oo);
                        ICloudVideoCallback iCloudVideoCallback2 = iCloudVideoCallback;
                        int i = fso.f17063O000000o;
                        iCloudVideoCallback2.onCloudVideoFailed(i, fso.O00000Oo);
                        return;
                    }
                    iCloudVideoCallback.onCloudVideoFailed(-90001, "FAIL_GENERAL");
                }
            });
        }
    }

    public void getVideoDailyListLimitV2(Context context, String str, final ICloudVideoCallback<List<DailyList>> iCloudVideoCallback) {
        if (context != null && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", str));
            NetRequest O000000o2 = new NetRequest.O000000o().O00000o0("business.smartcamera.").O000000o("GET").O00000Oo("/common/app/get/cloudlist").O000000o(arrayList).O000000o();
            gsy.O00000Oo("CloudVideoNetUtils", "getVideoDailyListLimitV2 url=/common/app/get/cloudlist");
            gsy.O00000Oo("CloudVideoNetUtils", "getVideoDailyListLimitV2 params=".concat(String.valueOf(str)));
            CoreApi.O000000o().O000000o(context, O000000o2, $$Lambda$CloudVideoNetUtils$sdrnHFfPm4wcaBZfLEiyaMQzzVM.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils.AnonymousClass5 */

                public void onSuccess(JSONObject jSONObject) {
                    if (iCloudVideoCallback != null) {
                        gsy.O00000Oo("CloudVideoNetUtils", "getVideoDailyListLimitV2 result=".concat(String.valueOf(jSONObject)));
                        if (jSONObject != null) {
                            int optInt = jSONObject.optInt("code", -90003);
                            if (optInt == 0) {
                                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                                if (optJSONObject != null) {
                                    JSONArray optJSONArray = optJSONObject.optJSONArray("thirdPartPlayUnits");
                                    optJSONObject.optString("date");
                                    Long valueOf = Long.valueOf(optJSONObject.optLong("nextTime", 0));
                                    boolean optBoolean = optJSONObject.optBoolean("isContinue");
                                    ArrayList arrayList = new ArrayList();
                                    if (optJSONArray == null || optJSONArray.length() <= 0) {
                                        iCloudVideoCallback.onCloudVideoFailed(-90004, "playUnits error");
                                        return;
                                    }
                                    gsy.O00000Oo("CloudVideoNetUtils", "playUnits:" + optJSONArray.toString());
                                    for (int i = 0; i < optJSONArray.length(); i++) {
                                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                                        if (optJSONObject2 != null) {
                                            DailyList dailyList = new DailyList();
                                            dailyList.duration = optJSONObject2.optLong("duration");
                                            dailyList.expireTime = optJSONObject2.optLong("expireTime");
                                            dailyList.createTime = optJSONObject2.optLong("createTime");
                                            dailyList.imgStoreId = optJSONObject2.optString("imgStoreId");
                                            dailyList.fileId = optJSONObject2.optString("fileId");
                                            String optString = optJSONObject2.optString("tags");
                                            if (TextUtils.isEmpty(optString) || !optString.contains("people")) {
                                                dailyList.isHuman = false;
                                            } else {
                                                dailyList.isHuman = true;
                                            }
                                            arrayList.add(dailyList);
                                        }
                                    }
                                    if (arrayList.size() > 0) {
                                        iCloudVideoCallback.onCloudVideoSuccess(arrayList, valueOf);
                                        iCloudVideoCallback.onCloudVideoSuccess(arrayList, valueOf, optBoolean);
                                        return;
                                    }
                                    iCloudVideoCallback.onCloudVideoFailed(-90002, "list data error");
                                    return;
                                }
                                iCloudVideoCallback.onCloudVideoFailed(-90002, "data is null");
                                return;
                            }
                            iCloudVideoCallback.onCloudVideoFailed(optInt, "result is fail");
                            return;
                        }
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "result is null");
                    }
                }

                public void onFailure(fso fso) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (fso != null) {
                        gsy.O000000o(6, "CloudVideoNetUtils", "getVideoDailyListLimitV2  error:" + fso.f17063O000000o + fso.O00000Oo);
                        ICloudVideoCallback iCloudVideoCallback2 = iCloudVideoCallback;
                        int i = fso.f17063O000000o;
                        iCloudVideoCallback2.onCloudVideoFailed(i, fso.O00000Oo);
                        return;
                    }
                    iCloudVideoCallback.onCloudVideoFailed(-90001, "FAIL_GENERAL");
                }
            });
        }
    }

    public void loadAllCameraCloudStorageInfo(String str, final ICloudVideoCallback<JSONObject> iCloudVideoCallback) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", str));
            CoreApi.O000000o().O000000o(gkv.f17949O000000o, new NetRequest.O000000o().O00000o0("business.smartcamera.").O000000o("GET").O00000Oo("/miot/camera/app/v1/vip/cloud/support").O000000o(arrayList).O000000o(), $$Lambda$CloudVideoNetUtils$2DS3nW2GrN6ZeCgWe5wU9F0YwkY.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils.AnonymousClass6 */

                public void onSuccess(JSONObject jSONObject) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback != null) {
                        iCloudVideoCallback.onCloudVideoSuccess(jSONObject, null);
                    }
                }

                public void onFailure(fso fso) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (fso != null) {
                        int i = fso.f17063O000000o;
                        iCloudVideoCallback.onCloudVideoFailed(i, fso.O00000Oo);
                        return;
                    }
                    iCloudVideoCallback.onCloudVideoFailed(-90001, "FAIL_GENERAL");
                }
            });
        } else if (iCloudVideoCallback != null) {
            iCloudVideoCallback.onCloudVideoFailed(-9003, "params is null");
        }
    }

    public String getPlayFileUrl(String str, String str2, String str3) {
        Device O000000o2 = fno.O000000o().O000000o(str);
        String str4 = null;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && O000000o2 != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", str);
                jSONObject.put("fileId", str2);
                jSONObject.put("videoCodec", str3);
                if (O000000o2 != null) {
                    jSONObject.put("deviceModel", O000000o2.model);
                }
                Locale O00oOooo = CoreApi.O000000o().O00oOooo();
                if (O00oOooo != null) {
                    jSONObject.put("region", O00oOooo.getCountry());
                } else {
                    jSONObject.put("region", Locale.getDefault().getCountry());
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new KeyValuePair("data", jSONObject.toString()));
                NetRequest O000000o3 = new NetRequest.O000000o().O00000o0("business.smartcamera.").O000000o("GET").O00000Oo("/miot/camera/app/v1/cloud/m3u8").O000000o(arrayList).O000000o();
                ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
                String O00000oo = fju.O000000o().O00000oo();
                String str5 = "";
                if (O0000ooO != null) {
                    if (!ftn.O00000o0(O0000ooO)) {
                        str5 = str5 + O0000ooO.f7546O000000o;
                    }
                }
                if (!TextUtils.isEmpty(str5)) {
                    str5 = str5 + ".";
                }
                if (!TextUtils.isEmpty(O00000oo) && O00000oo.equalsIgnoreCase("preview")) {
                    str5 = "pv.".concat(String.valueOf(str5));
                }
                String str6 = "https://" + str5 + "business.smartcamera.api.io.mi.com/miot/camera/app/v1/cloud/m3u8";
                Pair<List<KeyValuePair>, String> paramEncrypt = paramEncrypt(O000000o3);
                if (paramEncrypt != null) {
                    str4 = flj.O000000o(str6, (List) paramEncrypt.first);
                }
            } catch (JSONException unused) {
            }
            gsy.O00000Oo("CloudVideoNetUtils", "getPlayFileUrl:".concat(String.valueOf(str4)));
        }
        return str4;
    }

    public String getVideoFileUrl(String str, String str2, boolean z) {
        Device O000000o2 = fno.O000000o().O000000o(str);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || O000000o2 == null) {
            return null;
        }
        return getVideoFileUrl(str, O000000o2.model, str2, z, "H265");
    }

    public String getVideoFileUrl(String str, String str2, String str3, boolean z, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("fileId", str3);
            jSONObject.put("model", str2);
            jSONObject.put("isAlarm", z);
            jSONObject.put("videoCodec", str4);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            NetRequest O000000o2 = new NetRequest.O000000o().O00000o0("business.smartcamera.").O000000o("GET").O00000Oo("/common/app/m3u8").O000000o(arrayList).O000000o();
            ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
            String O00000oo = fju.O000000o().O00000oo();
            String str5 = "";
            if (O0000ooO != null) {
                if (!ftn.O00000o0(O0000ooO)) {
                    str5 = str5 + O0000ooO.f7546O000000o;
                }
            }
            if (!TextUtils.isEmpty(str5)) {
                str5 = str5 + ".";
            }
            if (!TextUtils.isEmpty(O00000oo) && O00000oo.equalsIgnoreCase("preview")) {
                str5 = "pv.".concat(String.valueOf(str5));
            }
            String str6 = "https://" + str5 + "business.smartcamera.api.io.mi.com/common/app/m3u8";
            Pair<List<KeyValuePair>, String> paramEncrypt = paramEncrypt(O000000o2);
            if (paramEncrypt != null) {
                return flj.O000000o(str6, (List) paramEncrypt.first);
            }
            return null;
        } catch (JSONException unused) {
            return null;
        }
    }

    public String getSnapshotUrl(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        String str4 = null;
        try {
            jSONObject.put("did", str);
            jSONObject.put("fileId", str2);
            jSONObject.put("stoId", str3);
            jSONObject.put("segmentIv", Base64.encodeToString(CloudVideoCryptoUtils.getInstance().iv.getIV(), 2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            NetRequest O000000o2 = new NetRequest.O000000o().O00000o0("processor.smartcamera.").O000000o("GET").O00000Oo("/miot/camera/app/v1/img").O000000o(arrayList).O000000o();
            ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
            String O00000oo = fju.O000000o().O00000oo();
            String str5 = "";
            if (O0000ooO != null) {
                if (!ftn.O00000o0(O0000ooO)) {
                    str5 = str5 + O0000ooO.f7546O000000o;
                }
            }
            if (!TextUtils.isEmpty(str5)) {
                str5 = str5 + ".";
            }
            if (!TextUtils.isEmpty(O00000oo) && O00000oo.equalsIgnoreCase("preview")) {
                str5 = "pv.".concat(String.valueOf(str5));
            }
            String str6 = "https://" + str5 + "processor.smartcamera.api.io.mi.com/miot/camera/app/v1/img";
            Pair<List<KeyValuePair>, String> paramEncrypt = paramEncrypt(O000000o2);
            if (paramEncrypt != null) {
                str4 = flj.O000000o(str6, (List) paramEncrypt.first);
            }
        } catch (JSONException unused) {
        }
        gsy.O00000Oo("CloudVideoNetUtils", "getSnapshotUrl:".concat(String.valueOf(str4)));
        return str4;
    }

    public String getCloudFileUrl(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        String str4 = null;
        try {
            jSONObject.put("did", str);
            jSONObject.put("fileId", str2);
            jSONObject.put("stoId", str3);
            jSONObject.put("segmentIv", Base64.encodeToString(CloudVideoCryptoUtils.getInstance().iv.getIV(), 2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            NetRequest O000000o2 = new NetRequest.O000000o().O00000o0("processor.smartcamera.").O000000o("GET").O00000Oo("/miot/camera/app/v1/mp4").O000000o(arrayList).O000000o();
            ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
            String O00000oo = fju.O000000o().O00000oo();
            String str5 = "";
            if (O0000ooO != null) {
                if (!ftn.O00000o0(O0000ooO)) {
                    str5 = str5 + O0000ooO.f7546O000000o;
                }
            }
            if (!TextUtils.isEmpty(str5)) {
                str5 = str5 + ".";
            }
            if (!TextUtils.isEmpty(O00000oo) && O00000oo.equalsIgnoreCase("preview")) {
                str5 = "pv.".concat(String.valueOf(str5));
            }
            String str6 = "https://" + str5 + "processor.smartcamera.api.io.mi.com/miot/camera/app/v1/mp4";
            Pair<List<KeyValuePair>, String> paramEncrypt = paramEncrypt(O000000o2);
            if (paramEncrypt != null) {
                str4 = flj.O000000o(str6, (List) paramEncrypt.first);
            }
        } catch (Exception unused) {
        }
        gsy.O00000Oo("CloudVideoNetUtils", "getCloudFileUrl:".concat(String.valueOf(str4)));
        return str4;
    }

    public void getPlainImageFile(String str, final ICloudVideoCallback<byte[]> iCloudVideoCallback) {
        MiServiceTokenInfo tokenInfo = getTokenInfo();
        Request.Builder url = new Request.Builder().get().url(str);
        this.client.newCall(url.header("Cookie", "yetAnotherServiceToken=" + tokenInfo.O00000o0).build()).enqueue(new Callback() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils.AnonymousClass7 */

            public void onFailure(Call call, IOException iOException) {
                ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                if (iCloudVideoCallback != null) {
                    iCloudVideoCallback.onCloudVideoFailed(-90001, "");
                }
            }

            public void onResponse(Call call, Response response) throws IOException {
                if (iCloudVideoCallback == null) {
                    return;
                }
                if (response.isSuccessful()) {
                    iCloudVideoCallback.onCloudVideoSuccess(response.body().bytes(), null);
                    return;
                }
                iCloudVideoCallback.onCloudVideoFailed(response.code(), response.message());
            }
        });
    }

    public void getCloudFile(Context context, String str, String str2, String str3, String str4, final ICloudDataCallback<String> iCloudDataCallback) {
        if ((context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) && iCloudDataCallback != null) {
            iCloudDataCallback.onCloudDataFailed(-90001, "invalid param(s)");
            return;
        }
        String cloudFileUrl = getCloudFileUrl(str, str2, str3);
        final String str5 = context.getApplicationContext().getCacheDir() + "/" + str2 + ".mp4";
        gsy.O00000Oo("CloudVideoNetUtils", "mp4FilePath = ".concat(String.valueOf(str5)));
        if (new File(str5).exists()) {
            gsy.O00000Oo("CloudVideoNetUtils", "file.exists = true");
            if (iCloudDataCallback != null) {
                iCloudDataCallback.onCloudDataSuccess(str5, null);
                return;
            }
        }
        gsy.O00000Oo("CloudVideoNetUtils", "start download...");
        new FileDownloadAndDecryptTask(new FileDownloadAndDecryptTask.IFileDownloadCallback() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils.AnonymousClass8 */

            public void onSuccess() {
                ICloudDataCallback iCloudDataCallback = iCloudDataCallback;
                if (iCloudDataCallback != null) {
                    iCloudDataCallback.onCloudDataSuccess(str5, null);
                }
            }

            public void onFailure(int i) {
                ICloudDataCallback iCloudDataCallback = iCloudDataCallback;
                if (iCloudDataCallback != null) {
                    iCloudDataCallback.onCloudDataFailed(i, null);
                }
            }

            public void onProgress(int i) {
                ICloudDataCallback iCloudDataCallback = iCloudDataCallback;
                if (iCloudDataCallback != null) {
                    iCloudDataCallback.onCloudDataProgress(i);
                }
            }
        }).execute(cloudFileUrl, str5);
    }

    public void deleteFiles(Context context, String str, final ICloudVideoCallback<String> iCloudVideoCallback) {
        if (context != null && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", str));
            Context context2 = context;
            CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O00000o0("business.smartcamera.").O000000o("POST").O00000Oo("/common/app/v2/delete/files").O000000o(arrayList).O000000o(), $$Lambda$CloudVideoNetUtils$pgPjSUwUu2hXOHIbClfx_Iuqqhk.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils.AnonymousClass9 */

                public void onSuccess(JSONObject jSONObject) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("code");
                        if (optInt == 0) {
                            iCloudVideoCallback.onCloudVideoSuccess("success", null);
                        } else {
                            iCloudVideoCallback.onCloudVideoFailed(optInt, "code error");
                        }
                    } else {
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "result is null");
                    }
                }

                public void onFailure(fso fso) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (fso != null) {
                        int i = fso.f17063O000000o;
                        iCloudVideoCallback.onCloudVideoFailed(i, fso.O00000Oo);
                        return;
                    }
                    iCloudVideoCallback.onCloudVideoFailed(-90001, "FAIL_GENERAL");
                }
            });
        }
    }

    public void getSettingUsage(Context context, String str, final ICloudVideoCallback<Boolean> iCloudVideoCallback) {
        if (context != null && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", str));
            Context context2 = context;
            CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O00000o0("business.smartcamera.").O000000o("GET").O00000Oo("/miot/camera/app/v1/get/cloudSwitch").O000000o(arrayList).O000000o(), $$Lambda$CloudVideoNetUtils$3Sxsyp8REXD2OrAEl_NeATdg9E.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils.AnonymousClass10 */

                public void onSuccess(JSONObject jSONObject) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (jSONObject == null) {
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "result is null");
                    } else if (jSONObject.optInt("code", -90003) == 0) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject != null) {
                            iCloudVideoCallback.onCloudVideoSuccess(Boolean.valueOf(optJSONObject.optBoolean("status")), null);
                            return;
                        }
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "status null");
                    } else {
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "code is not 0");
                    }
                }

                public void onFailure(fso fso) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (fso != null) {
                        int i = fso.f17063O000000o;
                        iCloudVideoCallback.onCloudVideoFailed(i, fso.O00000Oo);
                        return;
                    }
                    iCloudVideoCallback.onCloudVideoFailed(-90001, "FAIL_GENERAL");
                }
            });
        }
    }

    public void setSettingUsage(Context context, String str, final ICloudVideoCallback<Boolean> iCloudVideoCallback) {
        if (context != null && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", str));
            Context context2 = context;
            CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O00000o0("business.smartcamera.").O000000o("POST").O00000Oo("/miot/camera/app/v1/put/cloudSwitch").O000000o(arrayList).O000000o(), $$Lambda$CloudVideoNetUtils$b98UqBeEx0hCyP_XOmINWm2z40w.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils.AnonymousClass11 */

                public void onSuccess(JSONObject jSONObject) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (jSONObject == null) {
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "result is null");
                    } else if (jSONObject.optInt("code", -90003) == 0) {
                        iCloudVideoCallback.onCloudVideoSuccess(null, null);
                    } else {
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "code is not 0");
                    }
                }

                public void onFailure(fso fso) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (fso != null) {
                        int i = fso.f17063O000000o;
                        iCloudVideoCallback.onCloudVideoFailed(i, fso.O00000Oo);
                        return;
                    }
                    iCloudVideoCallback.onCloudVideoFailed(-90001, "FAIL_GENERAL");
                }
            });
        }
    }

    public void getSettingCapacity(Context context, String str, final ICloudVideoCallback<Long> iCloudVideoCallback) {
        if (context != null && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", str));
            Context context2 = context;
            CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O00000o0("business.smartcamera.").O000000o("GET").O00000Oo("/common/app/v1/capacity").O000000o(arrayList).O000000o(), $$Lambda$CloudVideoNetUtils$ZE9Zqt1ORpy4pLY0ZcqoJhNMeHE.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils.AnonymousClass12 */

                public void onSuccess(JSONObject jSONObject) {
                    gsy.O00000Oo("CloudVideoNetUtils", "onSuccess = ".concat(String.valueOf(jSONObject)));
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (jSONObject == null) {
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "result is null");
                    } else if (jSONObject.optInt("code", -90003) == 0) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject != null) {
                            iCloudVideoCallback.onCloudVideoSuccess(Long.valueOf(optJSONObject.optLong("capacity")), null);
                            return;
                        }
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "data is null");
                    } else {
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "code is not 0");
                    }
                }

                public void onFailure(fso fso) {
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (fso != null) {
                        gsy.O00000Oo("CloudVideoNetUtils", "onFailure = " + fso.f17063O000000o + " " + fso.O00000Oo);
                        ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                        int i = fso.f17063O000000o;
                        iCloudVideoCallback.onCloudVideoFailed(i, fso.O00000Oo);
                        return;
                    }
                    gsy.O00000Oo("CloudVideoNetUtils", "onFailure = FAIL_GENERAL");
                    iCloudVideoCallback.onCloudVideoFailed(-90001, "FAIL_GENERAL");
                }
            });
        }
    }

    public void getSettingStatus(Context context, String str, final ICloudVideoCallback<CloudVideoUserStatus> iCloudVideoCallback) {
        if (context != null && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", str));
            Context context2 = context;
            CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O00000o0("business.smartcamera.").O000000o("GET").O00000Oo("/miot/camera/app/v1/vip/status").O000000o(arrayList).O000000o(), $$Lambda$CloudVideoNetUtils$okIo1X5pic8Xi9IS78O9oQCd7Q.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils.AnonymousClass13 */

                public void onSuccess(JSONObject jSONObject) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (jSONObject == null) {
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "result is null");
                    } else if (jSONObject.optInt("code", -90003) == 0) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject != null) {
                            boolean optBoolean = optJSONObject.optBoolean("vip");
                            CloudVideoUserStatus cloudVideoUserStatus = new CloudVideoUserStatus();
                            if (optBoolean) {
                                cloudVideoUserStatus.vip = true;
                                cloudVideoUserStatus.startTime = optJSONObject.optLong("startTime");
                                cloudVideoUserStatus.endTime = optJSONObject.optLong("endTime");
                                cloudVideoUserStatus.packageType = optJSONObject.optString("pacakgeType");
                                cloudVideoUserStatus.isRenew = optJSONObject.optBoolean("isRenew");
                            } else {
                                cloudVideoUserStatus.vip = false;
                                cloudVideoUserStatus.status = optJSONObject.optInt("status");
                                cloudVideoUserStatus.startTime = optJSONObject.optLong("startTime");
                                cloudVideoUserStatus.endTime = optJSONObject.optLong("endTime");
                                cloudVideoUserStatus.packageType = optJSONObject.optString("pacakgeType");
                            }
                            iCloudVideoCallback.onCloudVideoSuccess(cloudVideoUserStatus, null);
                            return;
                        }
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "data is null");
                    } else {
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "code is not 0");
                    }
                }

                public void onFailure(fso fso) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (fso != null) {
                        int i = fso.f17063O000000o;
                        iCloudVideoCallback.onCloudVideoFailed(i, fso.O00000Oo);
                        return;
                    }
                    iCloudVideoCallback.onCloudVideoFailed(-90001, "FAIL_GENERAL");
                }
            });
        }
    }

    public void getDeductOrders(Context context, String str, final ICloudVideoCallback<Boolean> iCloudVideoCallback) {
        if (context != null && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", str));
            Context context2 = context;
            CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O00000o0("business.smartcamera.").O000000o("GET").O00000Oo("/miot/camera/app/v1/vip/deductOrders").O000000o(arrayList).O000000o(), $$Lambda$CloudVideoNetUtils$Q7srD5k9VVqdy1iJM1fC3gBQnd4.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils.AnonymousClass14 */

                public void onSuccess(JSONObject jSONObject) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (jSONObject == null) {
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "result is null");
                    } else if (jSONObject.optInt("code", -90003) == 0) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject != null) {
                            iCloudVideoCallback.onCloudVideoSuccess(Boolean.valueOf(optJSONObject.optBoolean("hasDeductOrders")), null);
                            return;
                        }
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "data is null");
                    } else {
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "code is not 0");
                    }
                }

                public void onFailure(fso fso) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (fso != null) {
                        int i = fso.f17063O000000o;
                        iCloudVideoCallback.onCloudVideoFailed(i, fso.O00000Oo);
                        return;
                    }
                    iCloudVideoCallback.onCloudVideoFailed(-90001, "FAIL_GENERAL");
                }
            });
        }
    }

    public String generateRequestUrl(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        String str2 = null;
        if (!(jSONObject == null || jSONObject2 == null)) {
            String optString = jSONObject.optString("prefix");
            String optString2 = jSONObject.optString("method");
            String optString3 = jSONObject.optString("path");
            int i = 0;
            boolean z = false;
            boolean z2 = false;
            while (i < jSONObject2.length()) {
                try {
                    String str3 = (String) jSONObject2.names().get(i);
                    if (!TextUtils.isEmpty(str3)) {
                        if (str3.equals("region")) {
                            z = true;
                        } else if (str3.equals("segmentIv")) {
                            z2 = true;
                        }
                    }
                    i++;
                } catch (JSONException unused) {
                }
            }
            if (!z) {
                Locale O00oOooo = CoreApi.O000000o().O00oOooo();
                if (O00oOooo != null) {
                    jSONObject2.put("region", O00oOooo.getCountry());
                } else {
                    jSONObject2.put("region", Locale.getDefault().getCountry());
                }
            }
            if (!z2) {
                jSONObject2.put("segmentIv", Base64.encodeToString(CloudVideoCryptoUtils.getInstance().iv.getIV(), 2));
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject2.toString()));
            NetRequest O000000o2 = new NetRequest.O000000o().O00000o0(optString).O000000o(optString2).O00000Oo(optString3).O000000o(arrayList).O000000o();
            ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
            String O00000oo = fju.O000000o().O00000oo();
            String str4 = "";
            if (O0000ooO != null) {
                if (!ftn.O00000o0(O0000ooO)) {
                    str4 = str4 + O0000ooO.f7546O000000o;
                }
            }
            if (!TextUtils.isEmpty(str4)) {
                str4 = str4 + ".";
            }
            if (!TextUtils.isEmpty(O00000oo) && O00000oo.equalsIgnoreCase("preview")) {
                str4 = "pv.".concat(String.valueOf(str4));
            }
            if (!TextUtils.isEmpty(optString) && !optString.endsWith(".")) {
                optString = optString + ".";
            }
            String str5 = "https://" + str4 + optString + "api.io.mi.com" + optString3;
            Pair<List<KeyValuePair>, String> paramEncrypt = paramEncrypt(O000000o2);
            if (paramEncrypt != null) {
                str2 = flj.O000000o(str5, (List) paramEncrypt.first);
            }
            gsy.O00000Oo("CloudVideoNetUtils", "generateRequestUrl:".concat(String.valueOf(str2)));
        }
        return str2;
    }

    public void checkCloudStorageStatus(String str, final ICloudVideoCallback<JSONObject> iCloudVideoCallback) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", str));
            CoreApi.O000000o().O000000o(gkv.f17949O000000o, new NetRequest.O000000o().O00000o0("business.smartcamera.").O000000o("GET").O00000Oo("/miot/camera/app/v1/vip/status").O000000o(arrayList).O000000o(), $$Lambda$CloudVideoNetUtils$K_Dsx6dnfq836PLaHg1XBCHNacc.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils.AnonymousClass15 */

                public void onSuccess(JSONObject jSONObject) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (jSONObject != null) {
                        iCloudVideoCallback.onCloudVideoSuccess(jSONObject, null);
                    } else {
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "result is null");
                    }
                }

                public void onFailure(fso fso) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (fso != null) {
                        int i = fso.f17063O000000o;
                        iCloudVideoCallback.onCloudVideoFailed(i, fso.O00000Oo);
                        return;
                    }
                    iCloudVideoCallback.onCloudVideoFailed(-90001, "FAIL_GENERAL");
                }
            });
        } else if (iCloudVideoCallback != null) {
            iCloudVideoCallback.onCloudVideoFailed(-90001, "context or params null");
        }
    }

    public void getMipaySignV2(String str, final ICloudVideoCallback<JSONObject> iCloudVideoCallback) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", str));
            CoreApi.O000000o().O000000o(gkv.f17949O000000o, new NetRequest.O000000o().O00000o0("business.smartcamera.").O000000o("GET").O00000Oo("/miot/camera/app/v2/vip/android/mipaySign").O000000o(arrayList).O000000o(), $$Lambda$CloudVideoNetUtils$ZuKPzLZY00PZ6uFbOYG3cSbjYUs.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils.AnonymousClass16 */

                public void onSuccess(JSONObject jSONObject) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (jSONObject != null) {
                        iCloudVideoCallback.onCloudVideoSuccess(jSONObject, null);
                    } else {
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "result is null");
                    }
                }

                public void onFailure(fso fso) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (fso != null) {
                        int i = fso.f17063O000000o;
                        iCloudVideoCallback.onCloudVideoFailed(i, fso.O00000Oo);
                        return;
                    }
                    iCloudVideoCallback.onCloudVideoFailed(-90001, "FAIL_GENERAL");
                }
            });
        } else if (iCloudVideoCallback != null) {
            iCloudVideoCallback.onCloudVideoFailed(-90001, "context or params null");
        }
    }

    public void getMipaySignIN(String str, final ICloudVideoCallback<JSONObject> iCloudVideoCallback) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", str));
            CoreApi.O000000o().O000000o(gkv.f17949O000000o, new NetRequest.O000000o().O00000o0("business.smartcamera.").O000000o("GET").O00000Oo("/miot/camera/app/v2/vip/android/mipaySign").O000000o(arrayList).O000000o(), $$Lambda$CloudVideoNetUtils$mJk_XnXPybDC9hQesQILRlyyqQ.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils.AnonymousClass17 */

                public void onSuccess(JSONObject jSONObject) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (jSONObject != null) {
                        iCloudVideoCallback.onCloudVideoSuccess(jSONObject, null);
                    } else {
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "result is null");
                    }
                }

                public void onFailure(fso fso) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (fso != null) {
                        int i = fso.f17063O000000o;
                        iCloudVideoCallback.onCloudVideoFailed(i, fso.O00000Oo);
                        return;
                    }
                    iCloudVideoCallback.onCloudVideoFailed(-90001, "FAIL_GENERAL");
                }
            });
        } else if (iCloudVideoCallback != null) {
            iCloudVideoCallback.onCloudVideoFailed(-90001, "context or params null");
        }
    }

    public void getCloudPromoteTips(final String str, final ICloudVideoCallback<String> iCloudVideoCallback) {
        isNewUser(new ICloudVideoCallback<JSONObject>() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils.AnonymousClass18 */

            public void onCloudVideoSuccess(JSONObject jSONObject, Object obj) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    iCloudVideoCallback.onCloudVideoFailed(-90004, "Get new user null");
                }
                boolean optBoolean = optJSONObject.optBoolean("isNewUser");
                if (optBoolean) {
                    CloudVideoNetUtils.this.getCloudPromoteTipsInternal(str, optBoolean, new ICloudVideoCallback<JSONObject>() {
                        /* class com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils.AnonymousClass18.AnonymousClass1 */

                        public void onCloudVideoSuccess(JSONObject jSONObject, Object obj) {
                            if (!(iCloudVideoCallback == null || jSONObject == null)) {
                                gsy.O000000o(3, "CloudVideoNetUtils", "getCloudPromoteTips " + jSONObject.toString());
                                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                                if (optJSONObject != null) {
                                    String optString = optJSONObject.optString("tipsInfo");
                                    if (optJSONObject.optBoolean("isDisplay") && !TextUtils.isEmpty(optString)) {
                                        iCloudVideoCallback.onCloudVideoSuccess(optString, null);
                                        return;
                                    }
                                }
                            }
                            iCloudVideoCallback.onCloudVideoFailed(-90002, "No need to display");
                        }

                        public void onCloudVideoFailed(int i, String str) {
                            if (iCloudVideoCallback != null) {
                                iCloudVideoCallback.onCloudVideoFailed(-90001, "FAIL_GENERAL");
                            }
                        }
                    });
                }
            }

            public void onCloudVideoFailed(int i, String str) {
                ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                if (iCloudVideoCallback != null) {
                    iCloudVideoCallback.onCloudVideoFailed(-90001, "FAIL_GENERAL");
                }
            }
        });
    }

    public void getCloudPromoteTipsInternal(String str, boolean z, final ICloudVideoCallback<JSONObject> iCloudVideoCallback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            Locale O00oOooo = CoreApi.O000000o().O00oOooo();
            if (O00oOooo != null) {
                jSONObject.put("region", O00oOooo.getCountry());
            } else {
                jSONObject.put("region", Locale.getDefault().getCountry());
            }
            jSONObject.put("isNewUser", z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        CoreApi.O000000o().O000000o(gkv.f17949O000000o, new NetRequest.O000000o().O00000o0("business.smartcamera.").O000000o("GET").O00000Oo("/miot/camera/app/v1/vip/tips").O000000o(arrayList).O000000o(), $$Lambda$CloudVideoNetUtils$ARmP6fKX27YweAVYE1LOJKiPX4.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils.AnonymousClass19 */

            public void onSuccess(JSONObject jSONObject) {
                ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                if (iCloudVideoCallback != null) {
                    iCloudVideoCallback.onCloudVideoSuccess(jSONObject, null);
                }
            }

            public void onFailure(fso fso) {
                ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                if (iCloudVideoCallback == null) {
                    return;
                }
                if (fso != null) {
                    int i = fso.f17063O000000o;
                    iCloudVideoCallback.onCloudVideoFailed(i, fso.O00000Oo);
                    return;
                }
                iCloudVideoCallback.onCloudVideoFailed(-90001, "FAIL_GENERAL");
            }
        });
    }

    public void isNewUser(final ICloudVideoCallback<JSONObject> iCloudVideoCallback) {
        JSONObject jSONObject = new JSONObject();
        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
        if (O00oOooo != null) {
            try {
                jSONObject.put("region", O00oOooo.getCountry());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            jSONObject.put("region", Locale.getDefault().getCountry());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        CoreApi.O000000o().O000000o(gkv.f17949O000000o, new NetRequest.O000000o().O00000o0("business.smartcamera.").O000000o("GET").O00000Oo("/miot/camera/app/v1/vip/newUser").O000000o(arrayList).O000000o(), $$Lambda$CloudVideoNetUtils$t8_4nK3vftSuAMt1nrLdWf2IOPY.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils.AnonymousClass20 */

            public void onSuccess(JSONObject jSONObject) {
                ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                if (iCloudVideoCallback != null) {
                    iCloudVideoCallback.onCloudVideoSuccess(jSONObject, null);
                }
            }

            public void onFailure(fso fso) {
                ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                if (iCloudVideoCallback == null) {
                    return;
                }
                if (fso != null) {
                    int i = fso.f17063O000000o;
                    iCloudVideoCallback.onCloudVideoFailed(i, fso.O00000Oo);
                    return;
                }
                iCloudVideoCallback.onCloudVideoFailed(-90001, "FAIL_GENERAL");
            }
        });
    }

    public void getCloudStatus(Context context, String str, final ICloudVideoCallback<CloudVideoUserStatus> iCloudVideoCallback) {
        if (context != null && !TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", str);
                Locale O00oOooo = CoreApi.O000000o().O00oOooo();
                if (O00oOooo != null) {
                    jSONObject.put("region", O00oOooo.getCountry());
                } else {
                    jSONObject.put("region", Locale.getDefault().getCountry());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            Context context2 = context;
            CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O00000o0("business.smartcamera.").O000000o("GET").O00000Oo("/common/app/vip/status").O000000o(arrayList).O000000o(), $$Lambda$CloudVideoNetUtils$rQHyEJSejm43xnemETyNEXTBTk.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils.AnonymousClass21 */

                public void onSuccess(JSONObject jSONObject) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (jSONObject == null) {
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "result is null");
                    } else if (jSONObject.optInt("code", -90003) == 0) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject != null) {
                            boolean optBoolean = optJSONObject.optBoolean("vip");
                            CloudVideoUserStatus cloudVideoUserStatus = new CloudVideoUserStatus();
                            if (optBoolean) {
                                cloudVideoUserStatus.vip = true;
                                cloudVideoUserStatus.status = optJSONObject.optInt("status");
                                cloudVideoUserStatus.startTime = optJSONObject.optLong("startTime");
                                cloudVideoUserStatus.endTime = optJSONObject.optLong("endTime");
                                cloudVideoUserStatus.packageType = optJSONObject.optString("pacakgeType");
                                cloudVideoUserStatus.rollingSaveInterval = CloudVideoUtils.getDayIntervalByTimestamp(optJSONObject.optLong("rollingSaveInterval"));
                            } else {
                                cloudVideoUserStatus.vip = false;
                                cloudVideoUserStatus.status = optJSONObject.optInt("status");
                                cloudVideoUserStatus.startTime = optJSONObject.optLong("startTime");
                                cloudVideoUserStatus.endTime = optJSONObject.optLong("endTime");
                                cloudVideoUserStatus.packageType = optJSONObject.optString("pacakgeType");
                            }
                            iCloudVideoCallback.onCloudVideoSuccess(cloudVideoUserStatus, null);
                            return;
                        }
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "data is null");
                    } else {
                        iCloudVideoCallback.onCloudVideoFailed(-90002, "code is not 0");
                    }
                }

                public void onFailure(fso fso) {
                    ICloudVideoCallback iCloudVideoCallback = iCloudVideoCallback;
                    if (iCloudVideoCallback == null) {
                        return;
                    }
                    if (fso != null) {
                        int i = fso.f17063O000000o;
                        iCloudVideoCallback.onCloudVideoFailed(i, fso.O00000Oo);
                        return;
                    }
                    iCloudVideoCallback.onCloudVideoFailed(-90001, "FAIL_GENERAL");
                }
            });
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    public Pair<List<KeyValuePair>, String> paramEncrypt(NetRequest netRequest) {
        String str;
        MiServiceTokenInfo tokenInfo = getTokenInfo();
        if (tokenInfo == null) {
            return null;
        }
        String O000000o2 = grt.O000000o(tokenInfo.O00000oO);
        try {
            str = String.valueOf(grs.O000000o(grx.O000000o(byteArraysConcat(grs.O000000o(tokenInfo.O00000o), grs.O000000o(O000000o2)))));
        } catch (NoSuchAlgorithmException unused) {
            gsy.O000000o(3, "CloudVideoNetUtils", "generate sessionSecurity fail:NoSuchAlgorithmException");
            str = null;
            if (str != null) {
            }
        } catch (InvalidKeyException unused2) {
            gsy.O000000o(3, "CloudVideoNetUtils", "generate sessionSecurity fail:InvalidKeyException");
            str = null;
            if (str != null) {
            }
        } catch (Exception unused3) {
            gsy.O000000o(3, "CloudVideoNetUtils", "generate sessionSecurity fail");
            str = null;
            if (str != null) {
            }
        }
        if (str != null) {
            return null;
        }
        TreeMap treeMap = new TreeMap();
        TreeMap treeMap2 = new TreeMap();
        ArrayList arrayList = new ArrayList();
        grz grz = new grz(str);
        List<KeyValuePair> list = netRequest.O00000oO;
        if (list != null) {
            for (KeyValuePair next : list) {
                if (!TextUtils.isEmpty(next.f6728O000000o) && !TextUtils.isEmpty(next.O00000Oo)) {
                    treeMap2.put(next.f6728O000000o, next.O00000Oo);
                }
            }
        }
        treeMap2.put("rc4_hash__", grt.O000000o(netRequest.f6729O000000o, netRequest.O00000Oo, treeMap2, str));
        for (Map.Entry entry : treeMap2.entrySet()) {
            String O000000o3 = grz.O000000o((String) entry.getValue());
            treeMap.put(entry.getKey(), O000000o3);
            arrayList.add(new KeyValuePair((String) entry.getKey(), O000000o3));
        }
        arrayList.add(new KeyValuePair("signature", grt.O000000o(netRequest.f6729O000000o, netRequest.O00000Oo, treeMap, str)));
        arrayList.add(new KeyValuePair("_nonce", O000000o2));
        arrayList.add(new KeyValuePair("ssecurity", tokenInfo.O00000o));
        return Pair.create(arrayList, O000000o2);
    }

    public MiServiceTokenInfo getTokenInfo() {
        return CoreApi.O000000o().O000000o("xiaomiio");
    }

    public MiServiceTokenInfo getYPTokenInfo() {
        return CoreApi.O000000o().O000000o("miotstore");
    }

    private byte[] byteArraysConcat(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private String getCloudVideoManagementUrl(String str) {
        Device O000000o2 = fno.O000000o().O000000o(str);
        if (O000000o2 == null || O000000o2.model == null || (!O000000o2.model.equalsIgnoreCase("mxiang.camera.mwc10") && !O000000o2.model.equalsIgnoreCase("mxiang.camera.mwc11"))) {
            return "camera.api.io.mi.com/miot/camera/web/vip/myhome/cloud";
        }
        return "camera.api.io.mi.com/cloud-service/app/cateye.html?did=" + str + "#/index";
    }

    public String getCloudVideoPurchaseUrl(String str) {
        Device O000000o2 = fno.O000000o().O000000o(str);
        return (O000000o2 == null || O000000o2.model == null || (!O000000o2.model.equalsIgnoreCase("mxiang.camera.mwc10") && !O000000o2.model.equalsIgnoreCase("mxiang.camera.mwc11"))) ? "camera.api.io.mi.com/miot/camera/web/vip/mipay_sr62m5p7ds/v2/home" : "camera.api.io.mi.com/miot/camera/web/vip/mipay_sr62m5p7ds/cateye";
    }
}

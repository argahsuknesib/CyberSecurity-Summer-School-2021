package com.xiaomi.smarthome.miio.camera;

import _m_j.fno;
import _m_j.gkv;
import _m_j.gsy;
import _m_j.gth;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.camera.alarm.CameraAlarmNetUtils;
import com.xiaomi.smarthome.miio.camera.alarm.ICameraAlarmCallback;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.DailyList;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.ICloudVideoCallback;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.FileDownloadAndDecryptTask;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CameraDeviceDataManager {
    private static volatile CameraDeviceDataManager instance;

    public interface ICameraDeviceDataCallback<T> {
        void onFailure(int i, String str);

        void onSuccess(T t, Object obj);
    }

    private CameraDeviceDataManager() {
    }

    public static CameraDeviceDataManager getInstance() {
        if (instance == null) {
            synchronized (CameraDeviceDataManager.class) {
                if (instance == null) {
                    instance = new CameraDeviceDataManager();
                }
            }
        }
        return instance;
    }

    public void getAlarmStatus(String str, final ICameraAlarmCallback<CameraAlarm> iCameraAlarmCallback) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("did", str);
                jSONObject.put("region", Locale.getDefault().getCountry());
                CameraAlarmNetUtils.getInstance().getAlarmStatus(jSONObject.toString(), new ICameraAlarmCallback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.CameraDeviceDataManager.AnonymousClass1 */

                    public void onSuccess(JSONObject jSONObject, Object obj) {
                        ICameraAlarmCallback iCameraAlarmCallback = iCameraAlarmCallback;
                        if (iCameraAlarmCallback == null) {
                            return;
                        }
                        if (jSONObject != null) {
                            int optInt = jSONObject.optInt("code", -1);
                            if (optInt == 0) {
                                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                                if (optJSONObject != null) {
                                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("motionDetectionSwitch");
                                    if (optJSONObject2 != null) {
                                        boolean optBoolean = optJSONObject2.optBoolean("detectionSwitch", false);
                                        CameraAlarm cameraAlarm = new CameraAlarm();
                                        cameraAlarm.isAlarmEnabled = optBoolean;
                                        iCameraAlarmCallback.onSuccess(cameraAlarm, null);
                                        return;
                                    }
                                    iCameraAlarmCallback.onFailure(-80002, "motionDetectionSwitch is null");
                                    return;
                                }
                                iCameraAlarmCallback.onFailure(-80002, "data is null");
                                return;
                            }
                            iCameraAlarmCallback.onFailure(-80003, "code is not 0:".concat(String.valueOf(optInt)));
                            return;
                        }
                        iCameraAlarmCallback.onFailure(-80002, "result is null");
                    }

                    public void onFailure(int i, String str) {
                        gsy.O000000o(6, "CameraDeviceDataManager", "errorCode:" + i + " errorInfo:" + str);
                        ICameraAlarmCallback iCameraAlarmCallback = iCameraAlarmCallback;
                        if (iCameraAlarmCallback != null) {
                            iCameraAlarmCallback.onFailure(i, str);
                        }
                    }
                });
            } catch (Exception unused) {
                if (iCameraAlarmCallback != null) {
                    iCameraAlarmCallback.onFailure(-80001, "exception");
                }
            }
        } else if (iCameraAlarmCallback != null) {
            iCameraAlarmCallback.onFailure(-80001, "did is null");
        }
    }

    public void getCloudStorageStatus(String str, final ICameraDeviceDataCallback<CameraCloudStorage> iCameraDeviceDataCallback) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", str);
                jSONObject.put("region", Locale.getDefault().getCountry());
                CloudVideoNetUtils.getInstance().checkCloudStorageStatus(jSONObject.toString(), new ICloudVideoCallback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.CameraDeviceDataManager.AnonymousClass2 */

                    public void onCloudVideoSuccess(JSONObject jSONObject, Object obj) {
                        ICameraDeviceDataCallback iCameraDeviceDataCallback = iCameraDeviceDataCallback;
                        if (iCameraDeviceDataCallback == null) {
                            return;
                        }
                        if (jSONObject != null) {
                            int optInt = jSONObject.optInt("code", -1);
                            if (optInt == 0) {
                                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                                if (optJSONObject != null) {
                                    boolean optBoolean = optJSONObject.optBoolean("vip", false);
                                    CameraCloudStorage cameraCloudStorage = new CameraCloudStorage();
                                    cameraCloudStorage.isCloudInUse = optBoolean;
                                    iCameraDeviceDataCallback.onSuccess(cameraCloudStorage, null);
                                    return;
                                }
                                iCameraDeviceDataCallback.onFailure(-80002, "data is null");
                                return;
                            }
                            iCameraDeviceDataCallback.onFailure(-80003, "code is not 0:".concat(String.valueOf(optInt)));
                            return;
                        }
                        iCameraDeviceDataCallback.onFailure(-80002, "result is null");
                    }

                    public void onCloudVideoFailed(int i, String str) {
                        gsy.O000000o(6, "CameraDeviceDataManager", "errorCode:" + i + " errorInfo:" + str);
                        ICameraDeviceDataCallback iCameraDeviceDataCallback = iCameraDeviceDataCallback;
                        if (iCameraDeviceDataCallback != null) {
                            iCameraDeviceDataCallback.onFailure(i, str);
                        }
                    }
                });
            } catch (Exception unused) {
                if (iCameraDeviceDataCallback != null) {
                    iCameraDeviceDataCallback.onFailure(-80001, "exception");
                }
            }
        } else if (iCameraDeviceDataCallback != null) {
            iCameraDeviceDataCallback.onFailure(-80001, "did is null");
        }
    }

    public void loadAllCameraCloudStorageStatus(String str, final ICameraDeviceDataCallback<JSONObject> iCameraDeviceDataCallback) {
        CloudVideoNetUtils.getInstance().loadAllCameraCloudStorageInfo(str, new ICloudVideoCallback<JSONObject>() {
            /* class com.xiaomi.smarthome.miio.camera.CameraDeviceDataManager.AnonymousClass3 */

            public void onCloudVideoSuccess(JSONObject jSONObject, Object obj) {
                ICameraDeviceDataCallback iCameraDeviceDataCallback = iCameraDeviceDataCallback;
                if (iCameraDeviceDataCallback == null) {
                    return;
                }
                if (jSONObject != null) {
                    iCameraDeviceDataCallback.onSuccess(jSONObject, obj);
                } else {
                    iCameraDeviceDataCallback.onFailure(-9001, "result is null");
                }
            }

            public void onCloudVideoFailed(int i, String str) {
                ICameraDeviceDataCallback iCameraDeviceDataCallback = iCameraDeviceDataCallback;
                if (iCameraDeviceDataCallback != null) {
                    iCameraDeviceDataCallback.onFailure(i, str);
                }
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gth.O000000o(java.lang.String, boolean):_m_j.gth$O00000o0
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gth.O000000o(int, java.io.OutputStream):void
      _m_j.gth.O000000o(android.content.Context, com.xiaomi.smarthome.device.Device):void
      _m_j.gth.O000000o(com.xiaomi.smarthome.device.Device, com.xiaomi.smarthome.fastvideo.VideoView):void
      _m_j.gth.O000000o(java.lang.String, boolean):_m_j.gth$O00000o0 */
    public void getLatestImageUri(String str, ICameraDeviceDataCallback<String> iCameraDeviceDataCallback) {
        final ImageInfo imageInfo = new ImageInfo();
        final ImageInfo imageInfo2 = new ImageInfo();
        Device O000000o2 = fno.O000000o().O000000o(str);
        if (O000000o2 != null) {
            if (gth.O000000o().O00000Oo(O000000o2.did) == null) {
                gth.O000000o().O000000o(O000000o2.did, false);
            }
            final String str2 = gkv.f17949O000000o.getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/smarthome_snapshot_" + System.currentTimeMillis() + ".jpeg";
            if (!TextUtils.isEmpty(str2)) {
                gth O000000o3 = gth.O000000o();
                final String str3 = str;
                final ICameraDeviceDataCallback<String> iCameraDeviceDataCallback2 = iCameraDeviceDataCallback;
                AnonymousClass4 r0 = new gth.O000000o() {
                    /* class com.xiaomi.smarthome.miio.camera.CameraDeviceDataManager.AnonymousClass4 */

                    public void onBitmapLoaded(final Bitmap bitmap, final long j) {
                        CameraDeviceDataManager.this.getLatestAlarmImageUri(str3, new ICameraDeviceDataCallback<ImageInfo>() {
                            /* class com.xiaomi.smarthome.miio.camera.CameraDeviceDataManager.AnonymousClass4.AnonymousClass1 */

                            public void onSuccess(ImageInfo imageInfo, Object obj) {
                                imageInfo.createTime = imageInfo.createTime;
                                imageInfo.url = imageInfo.url;
                                CameraDeviceDataManager.this.getLatestCloudVideoImageUri(str3, new ICameraDeviceDataCallback<ImageInfo>() {
                                    /* class com.xiaomi.smarthome.miio.camera.CameraDeviceDataManager.AnonymousClass4.AnonymousClass1.AnonymousClass1 */

                                    public void onSuccess(ImageInfo imageInfo, Object obj) {
                                        imageInfo2.createTime = imageInfo.createTime;
                                        imageInfo2.url = imageInfo.url;
                                        if (bitmap == null || j <= imageInfo.createTime || j <= imageInfo2.createTime) {
                                            CameraDeviceDataManager.this.downloadImage(imageInfo, imageInfo2, str2, iCameraDeviceDataCallback2);
                                        } else {
                                            CameraDeviceDataManager.this.saveBitmapToFile(bitmap, str2, iCameraDeviceDataCallback2);
                                        }
                                    }

                                    public void onFailure(int i, String str) {
                                        gsy.O00000Oo("CameraDeviceDataManager", "getLatestAlarmImageUri getLatestCloudVideoImageUri1:" + i + str);
                                        if (bitmap == null || j <= imageInfo.createTime || j <= imageInfo2.createTime) {
                                            CameraDeviceDataManager.this.downloadImage(imageInfo, imageInfo2, str2, iCameraDeviceDataCallback2);
                                        } else {
                                            CameraDeviceDataManager.this.saveBitmapToFile(bitmap, str2, iCameraDeviceDataCallback2);
                                        }
                                    }
                                });
                            }

                            public void onFailure(int i, String str) {
                                CameraDeviceDataManager.this.getLatestCloudVideoImageUri(str3, new ICameraDeviceDataCallback<ImageInfo>() {
                                    /* class com.xiaomi.smarthome.miio.camera.CameraDeviceDataManager.AnonymousClass4.AnonymousClass1.AnonymousClass2 */

                                    public void onSuccess(ImageInfo imageInfo, Object obj) {
                                        if (bitmap == null || j <= imageInfo.createTime || j <= imageInfo2.createTime) {
                                            CameraDeviceDataManager.this.downloadImage(imageInfo, imageInfo2, str2, iCameraDeviceDataCallback2);
                                        } else {
                                            CameraDeviceDataManager.this.saveBitmapToFile(bitmap, str2, iCameraDeviceDataCallback2);
                                        }
                                    }

                                    public void onFailure(int i, String str) {
                                        gsy.O00000Oo("CameraDeviceDataManager", "getLatestAlarmImageUri getLatestCloudVideoImageUri2:" + i + str);
                                        if (iCameraDeviceDataCallback2 != null) {
                                            iCameraDeviceDataCallback2.onFailure(-80001, "no alarm or cloud video");
                                        }
                                    }
                                });
                            }
                        });
                    }
                };
                gth.O00000o0 O00000Oo = O000000o3.O00000Oo(O000000o2.did);
                if (O00000Oo != null) {
                    O00000Oo.O0000o00 = r0;
                    gth.this.O00000o.sendMessage(gth.this.O00000o.obtainMessage(5, O00000Oo));
                    return;
                }
                r0.onBitmapLoaded(null, 0);
            } else if (iCameraDeviceDataCallback != null) {
                iCameraDeviceDataCallback.onFailure(-80001, "imageFilePath is null");
            }
        } else if (iCameraDeviceDataCallback != null) {
            iCameraDeviceDataCallback.onFailure(-80001, "device is null");
        }
    }

    public void getLatestAlarmImageUri(final String str, final ICameraDeviceDataCallback<ImageInfo> iCameraDeviceDataCallback) {
        try {
            Calendar instance2 = Calendar.getInstance();
            instance2.setTime(new Date());
            instance2.add(5, -7);
            instance2.set(11, 0);
            instance2.set(12, 0);
            instance2.set(13, 0);
            long timeInMillis = instance2.getTimeInMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", str);
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("beginTime", timeInMillis);
            jSONObject.put("endTime", System.currentTimeMillis());
            jSONObject.put("limit", 1);
            CameraAlarmNetUtils.getInstance().getAlarmList(jSONObject.toString(), new ICameraAlarmCallback<JSONObject>() {
                /* class com.xiaomi.smarthome.miio.camera.CameraDeviceDataManager.AnonymousClass5 */

                public void onSuccess(JSONObject jSONObject, Object obj) {
                    ICameraDeviceDataCallback iCameraDeviceDataCallback = iCameraDeviceDataCallback;
                    if (iCameraDeviceDataCallback == null) {
                        return;
                    }
                    if (jSONObject == null) {
                        iCameraDeviceDataCallback.onFailure(-80001, "result is null");
                    } else if (jSONObject.optInt("code", -1) == 0) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject != null) {
                            JSONArray optJSONArray = optJSONObject.optJSONArray("playUnits");
                            if (optJSONArray == null || optJSONArray.length() <= 0) {
                                iCameraDeviceDataCallback.onFailure(-80001, "playUnits 0");
                                return;
                            }
                            try {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
                                long optLong = jSONObject2.optLong("createTime");
                                String optString = jSONObject2.optString("imgStoreId");
                                String optString2 = jSONObject2.optString("fileId");
                                ImageInfo imageInfo = new ImageInfo();
                                imageInfo.createTime = optLong;
                                imageInfo.url = CloudVideoNetUtils.getInstance().getSnapshotUrl(str, optString2, optString);
                                iCameraDeviceDataCallback.onSuccess(imageInfo, null);
                            } catch (JSONException unused) {
                                iCameraDeviceDataCallback.onFailure(-80001, "JSONException");
                            }
                        } else {
                            iCameraDeviceDataCallback.onFailure(-80001, "data null");
                        }
                    } else {
                        iCameraDeviceDataCallback.onFailure(-80003, "code not 0");
                    }
                }

                public void onFailure(int i, String str) {
                    gsy.O000000o(6, "CameraDeviceDataManager", "getLatestAlarmImageUri:" + i + str);
                    iCameraDeviceDataCallback.onFailure(i, str);
                }
            });
        } catch (Exception unused) {
            if (iCameraDeviceDataCallback != null) {
                iCameraDeviceDataCallback.onFailure(-80001, "Exception");
            }
        }
    }

    public void getLatestCloudVideoImageUri(final String str, final ICameraDeviceDataCallback<ImageInfo> iCameraDeviceDataCallback) {
        try {
            Calendar instance2 = Calendar.getInstance();
            instance2.setTime(new Date());
            instance2.add(5, -7);
            instance2.set(11, 0);
            instance2.set(12, 0);
            instance2.set(13, 0);
            long timeInMillis = instance2.getTimeInMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", str);
            Device O00000o0 = fno.O000000o().O00000o0(str);
            if (O00000o0 != null) {
                jSONObject.put("model", O00000o0.model);
            } else {
                gsy.O00000Oo("CameraDeviceDataManager", "device == null");
                gsy.O000000o(LogType.CAMERA, "CameraDeviceDataManager", "SmartHomeDeviceManager.getInstance().getDeviceByDid(did)=null, did=".concat(String.valueOf(str)));
            }
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("beginTime", timeInMillis);
            jSONObject.put("endTime", System.currentTimeMillis());
            jSONObject.put("limit", 1);
            CloudVideoNetUtils.getInstance().getVideoDailyListLimitV2(gkv.f17949O000000o, jSONObject.toString(), new ICloudVideoCallback<List<DailyList>>() {
                /* class com.xiaomi.smarthome.miio.camera.CameraDeviceDataManager.AnonymousClass6 */

                public /* bridge */ /* synthetic */ void onCloudVideoSuccess(Object obj, Object obj2) {
                    onCloudVideoSuccess((List<DailyList>) ((List) obj), obj2);
                }

                public void onCloudVideoSuccess(List<DailyList> list, Object obj) {
                    if (iCameraDeviceDataCallback == null) {
                        return;
                    }
                    if (list == null || list.size() <= 0) {
                        iCameraDeviceDataCallback.onFailure(-80001, "result is null");
                        return;
                    }
                    ImageInfo imageInfo = new ImageInfo();
                    imageInfo.createTime = list.get(0).createTime;
                    imageInfo.url = CloudVideoNetUtils.getInstance().getSnapshotUrl(str, list.get(0).fileId, list.get(0).imgStoreId);
                    iCameraDeviceDataCallback.onSuccess(imageInfo, null);
                }

                public void onCloudVideoFailed(int i, String str) {
                    gsy.O000000o(6, "CameraDeviceDataManager", "getLatestCloudVideoImageUri:" + i + str);
                    ICameraDeviceDataCallback iCameraDeviceDataCallback = iCameraDeviceDataCallback;
                    if (iCameraDeviceDataCallback != null) {
                        iCameraDeviceDataCallback.onFailure(i, str);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    public void saveBitmapToFile(Bitmap bitmap, String str, ICameraDeviceDataCallback<String> iCameraDeviceDataCallback) {
        if (bitmap != null) {
            File file = new File(str);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                if (iCameraDeviceDataCallback != null && file.exists()) {
                    iCameraDeviceDataCallback.onSuccess(Uri.fromFile(file).toString(), null);
                }
            } catch (IOException e) {
                if (iCameraDeviceDataCallback != null) {
                    iCameraDeviceDataCallback.onFailure(-80001, "IOException:" + e.getLocalizedMessage());
                }
            }
        } else if (iCameraDeviceDataCallback != null) {
            iCameraDeviceDataCallback.onFailure(-80001, "bitmap null");
        }
    }

    public void downloadImage(ImageInfo imageInfo, ImageInfo imageInfo2, final String str, final ICameraDeviceDataCallback<String> iCameraDeviceDataCallback) {
        String str2;
        if (imageInfo != null && imageInfo2 != null && imageInfo.createTime > 0 && imageInfo2.createTime > 0) {
            if (imageInfo.createTime > imageInfo2.createTime) {
                str2 = imageInfo.url;
            } else {
                str2 = imageInfo2.url;
            }
            FileDownloadAndDecryptTask fileDownloadAndDecryptTask = new FileDownloadAndDecryptTask(new FileDownloadAndDecryptTask.IFileDownloadCallback() {
                /* class com.xiaomi.smarthome.miio.camera.CameraDeviceDataManager.AnonymousClass7 */

                public void onProgress(int i) {
                }

                public void onSuccess() {
                    gsy.O00000Oo("CameraDeviceDataManager", "imageFilePath:" + str);
                    if (iCameraDeviceDataCallback != null) {
                        File file = new File(str);
                        if (file.exists()) {
                            iCameraDeviceDataCallback.onSuccess(Uri.fromFile(file).toString(), null);
                            return;
                        }
                        iCameraDeviceDataCallback.onFailure(-80002, "no file");
                    }
                }

                public void onFailure(int i) {
                    gsy.O00000Oo("CameraDeviceDataManager", "onFailure:".concat(String.valueOf(i)));
                    ICameraDeviceDataCallback iCameraDeviceDataCallback = iCameraDeviceDataCallback;
                    if (iCameraDeviceDataCallback != null) {
                        iCameraDeviceDataCallback.onFailure(i, "no file");
                    }
                }
            });
            gsy.O00000Oo("CameraDeviceDataManager", "downloadUrl:".concat(String.valueOf(str2)));
            fileDownloadAndDecryptTask.execute(imageInfo.url, str);
        } else if (iCameraDeviceDataCallback != null) {
            iCameraDeviceDataCallback.onFailure(-80001, "param(s) invalid");
        }
    }

    class ImageInfo {
        public long createTime;
        public String url;

        public ImageInfo() {
        }

        public ImageInfo(ImageInfo imageInfo) {
            this.createTime = imageInfo.createTime;
            this.url = imageInfo.url;
        }
    }
}

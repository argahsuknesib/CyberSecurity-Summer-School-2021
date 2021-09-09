package com.xiaomi.smarthome.miio.camera.face;

import _m_j.cki;
import _m_j.gsy;
import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xiaomi.smarthome.device.api.BaseDevice;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.ICloudDataCallback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.miio.camera.face.model.ClusteringInfos;
import com.xiaomi.smarthome.miio.camera.face.model.CommonResult;
import com.xiaomi.smarthome.miio.camera.face.model.FaceEventList;
import com.xiaomi.smarthome.miio.camera.face.model.FaceIdMetaResult;
import com.xiaomi.smarthome.miio.camera.face.model.FigureInfo;
import com.xiaomi.smarthome.miio.camera.face.model.FigureInfos;
import com.xiaomi.smarthome.miio.camera.face.model.UnmarkedFaceInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FaceManager {
    public static final String TAG = "FaceManager";
    public static Gson gGson = new Gson();
    private static volatile FaceManager sInstance;
    private Map<String, String> cachedFaceImage = new HashMap();
    private BaseDevice mDevice;
    public long unMarkedFaceNextTime;

    public interface IFaceCallback<T> {
        void onFailure(int i, String str);

        void onSuccess(T t, Object obj);
    }

    private FaceManager(BaseDevice baseDevice) {
        this.mDevice = baseDevice;
    }

    public static FaceManager getInstance(BaseDevice baseDevice) {
        if (sInstance == null) {
            synchronized (FaceManager.class) {
                if (sInstance == null) {
                    sInstance = new FaceManager(baseDevice);
                }
            }
        }
        sInstance.mDevice = baseDevice;
        return sInstance;
    }

    public String getDeviceId() {
        return this.mDevice.getDid();
    }

    public String getModel() {
        return this.mDevice.getModel();
    }

    public BaseDevice getDevice() {
        return this.mDevice;
    }

    public void releaseFaceImage() {
        this.cachedFaceImage.clear();
        sInstance = null;
    }

    public void addFigure(String str, final IFaceCallback iFaceCallback) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("model", this.mDevice.getModel());
                jSONObject.put("figureInfo", str);
                jSONObject.put("figureName", str);
                String jSONObject2 = jSONObject.toString();
                gsy.O00000Oo(TAG, "addFigure request params=".concat(String.valueOf(jSONObject2)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/add/figure", "POST", jSONObject2, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass1 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_addFigure=" + jSONObject.toString());
                        CommonResult commonResult = (CommonResult) FaceManager.gGson.fromJson(jSONObject.toString(), CommonResult.class);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onSuccess(null, commonResult);
                        }
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O000000o(6, str2, "onFailure_addFigure code=" + i + " msg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (Exception e) {
                gsy.O000000o(6, TAG, e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevice null");
        }
    }

    public void modifyFigure(String str, String str2, final IFaceCallback iFaceCallback) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("model", this.mDevice.getModel());
                jSONObject.put("figureId", str);
                jSONObject.put("figureInfo", str2);
                jSONObject.put("figureName", str2);
                String jSONObject2 = jSONObject.toString();
                gsy.O00000Oo(TAG, "modifyFigure request params=".concat(String.valueOf(jSONObject2)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/modify/figure", "POST", jSONObject2, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass2 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_modifyFigure=" + jSONObject.toString());
                        CommonResult commonResult = (CommonResult) FaceManager.gGson.fromJson(jSONObject.toString(), CommonResult.class);
                        if (commonResult == null) {
                            IFaceCallback iFaceCallback = iFaceCallback;
                            if (iFaceCallback != null) {
                                iFaceCallback.onFailure(0, "commonResult=null");
                                return;
                            }
                            return;
                        }
                        IFaceCallback iFaceCallback2 = iFaceCallback;
                        if (iFaceCallback2 != null) {
                            iFaceCallback2.onSuccess(null, commonResult);
                        }
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O000000o(6, str2, "onFailure_modifyFigure code=" + i + " msg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (Exception e) {
                gsy.O000000o(6, TAG, e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevice null");
        }
    }

    public void deleteFigure(String str, final IFaceCallback iFaceCallback) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("model", this.mDevice.getModel());
                jSONObject.put("figureId", str);
                String jSONObject2 = jSONObject.toString();
                gsy.O00000Oo(TAG, "deleteFigure request params=".concat(String.valueOf(jSONObject2)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/delete/figure", "POST", jSONObject2, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass3 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_deleteFigure=" + jSONObject.toString());
                        CommonResult commonResult = (CommonResult) FaceManager.gGson.fromJson(jSONObject.toString(), CommonResult.class);
                        if (commonResult.code == 0) {
                            IFaceCallback iFaceCallback = iFaceCallback;
                            if (iFaceCallback != null) {
                                iFaceCallback.onSuccess(null, commonResult);
                                return;
                            }
                            return;
                        }
                        IFaceCallback iFaceCallback2 = iFaceCallback;
                        if (iFaceCallback2 != null) {
                            int i = commonResult.code;
                            StringBuilder sb = new StringBuilder();
                            sb.append(commonResult.code);
                            iFaceCallback2.onFailure(i, sb.toString());
                        }
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O000000o(6, str2, "onFailure_deleteFigure code=" + i + " msg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (Exception e) {
                gsy.O000000o(6, TAG, e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevice null");
        }
    }

    public void deleteFigures(final IFaceCallback iFaceCallback, Object... objArr) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("model", this.mDevice.getModel());
                JSONArray jSONArray = new JSONArray();
                for (Object put : objArr) {
                    jSONArray.put(put);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ids", jSONArray);
                jSONObject.put("figureIds", jSONObject2.toString());
                String jSONObject3 = jSONObject.toString();
                gsy.O00000Oo(TAG, "deleteFigures request params=".concat(String.valueOf(jSONObject3)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/delete/figures", "POST", jSONObject3, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass4 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_deleteFigures=" + jSONObject.toString());
                        CommonResult commonResult = (CommonResult) FaceManager.gGson.fromJson(jSONObject.toString(), CommonResult.class);
                        if (commonResult.code == 0) {
                            IFaceCallback iFaceCallback = iFaceCallback;
                            if (iFaceCallback != null) {
                                iFaceCallback.onSuccess(null, commonResult);
                                return;
                            }
                            return;
                        }
                        IFaceCallback iFaceCallback2 = iFaceCallback;
                        if (iFaceCallback2 != null) {
                            int i = commonResult.code;
                            StringBuilder sb = new StringBuilder();
                            sb.append(commonResult.code);
                            iFaceCallback2.onFailure(i, sb.toString());
                        }
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O000000o(6, str2, "onFailure_deleteFigures code=" + i + " msg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (Exception e) {
                gsy.O000000o(6, TAG, e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevice null");
        }
    }

    public void getFigures(final IFaceCallback iFaceCallback) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("model", this.mDevice.getModel());
                String jSONObject2 = jSONObject.toString();
                gsy.O00000Oo(TAG, "getFigures request params=".concat(String.valueOf(jSONObject2)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/get/figures", "GET", jSONObject2, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass5 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_getFigures=" + jSONObject.toString());
                        CommonResult commonResult = (CommonResult) FaceManager.gGson.fromJson(jSONObject.toString(), CommonResult.class);
                        if (commonResult.code == 0) {
                            IFaceCallback iFaceCallback = iFaceCallback;
                            if (iFaceCallback != null) {
                                iFaceCallback.onSuccess(null, FaceManager.gGson.fromJson(commonResult.data, FigureInfos.class));
                                return;
                            }
                            return;
                        }
                        IFaceCallback iFaceCallback2 = iFaceCallback;
                        if (iFaceCallback2 != null) {
                            int i = commonResult.code;
                            StringBuilder sb = new StringBuilder();
                            sb.append(commonResult.code);
                            iFaceCallback2.onFailure(i, sb.toString());
                        }
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O000000o(6, str2, "onFailure_getFigures code=" + i + " msg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (Exception e) {
                gsy.O000000o(6, TAG, e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevice null");
        }
    }

    public void getFacesCluster(final IFaceCallback iFaceCallback) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("model", this.mDevice.getModel());
                String jSONObject2 = jSONObject.toString();
                gsy.O00000Oo(TAG, "getFacesCluster request params=".concat(String.valueOf(jSONObject2)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/get/facesCluster", "GET", jSONObject2, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass6 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_getFacesCluster=" + jSONObject.toString());
                        CommonResult commonResult = (CommonResult) FaceManager.gGson.fromJson(jSONObject.toString(), CommonResult.class);
                        if (commonResult.code == 0) {
                            IFaceCallback iFaceCallback = iFaceCallback;
                            if (iFaceCallback != null) {
                                iFaceCallback.onSuccess(null, FaceManager.gGson.fromJson(commonResult.data, ClusteringInfos.class));
                                return;
                            }
                            return;
                        }
                        IFaceCallback iFaceCallback2 = iFaceCallback;
                        if (iFaceCallback2 != null) {
                            int i = commonResult.code;
                            StringBuilder sb = new StringBuilder();
                            sb.append(commonResult.code);
                            iFaceCallback2.onFailure(i, sb.toString());
                        }
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O00000Oo(str2, "onFailure_getFacesCluster code=" + i + " msg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (Exception e) {
                String str = TAG;
                gsy.O00000Oo(str, "getFacesCluster:" + e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevcie null");
        }
    }

    public void getClusterEvent(String str, String str2, final IFaceCallback iFaceCallback) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("model", this.mDevice.getModel());
                jSONObject.put("faceIds", str);
                gsy.O00000Oo("faceIds", String.valueOf(str));
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("figureId", str2);
                }
                String jSONObject2 = jSONObject.toString();
                gsy.O00000Oo(TAG, "getFacesCluster request params=".concat(String.valueOf(jSONObject2)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/common/app/get/faceCluster/eventlist", "GET", jSONObject2, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass7 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_getFacesCluster=" + jSONObject.toString());
                        CommonResult commonResult = (CommonResult) FaceManager.gGson.fromJson(jSONObject.toString(), CommonResult.class);
                        if (commonResult.code == 0) {
                            IFaceCallback iFaceCallback = iFaceCallback;
                            if (iFaceCallback != null) {
                                iFaceCallback.onSuccess(null, FaceManager.gGson.fromJson(commonResult.data, FaceEventList.class));
                                return;
                            }
                            return;
                        }
                        IFaceCallback iFaceCallback2 = iFaceCallback;
                        if (iFaceCallback2 != null) {
                            int i = commonResult.code;
                            StringBuilder sb = new StringBuilder();
                            sb.append(commonResult.code);
                            iFaceCallback2.onFailure(i, sb.toString());
                        }
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O00000Oo(str2, "onFailure_getFacesCluster code=" + i + " msg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (Exception e) {
                String str3 = TAG;
                gsy.O00000Oo(str3, "getFacesCluster:" + e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevcie null");
        }
    }

    public void addClusterFace(String str, String str2, final IFaceCallback iFaceCallback) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("model", this.mDevice.getModel());
                jSONObject.put("faceIds", str);
                jSONObject.put("figureId", str2);
                String jSONObject2 = jSONObject.toString();
                gsy.O00000Oo(TAG, "addClusterFace request params=".concat(String.valueOf(jSONObject2)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/add/cluster/face", "GET", jSONObject2, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass8 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_addClusterFace=" + jSONObject.toString());
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O00000Oo(str2, "onFailure_addClusterFace code=" + i + " msg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (Exception e) {
                String str3 = TAG;
                gsy.O00000Oo(str3, "addClusterFace:" + e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevcie null");
        }
    }

    public void faceClusterErrorReport(String str, int i, String str2, final IFaceCallback iFaceCallback) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("fileId", str);
                jSONObject.put("offset", i);
                jSONObject.put("faceId", str2);
                String jSONObject2 = jSONObject.toString();
                cki.O00000o(TAG, "faceClusterErrorReport request params=".concat(String.valueOf(jSONObject2)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/mark/faceClustering/mistake", "POST", jSONObject2, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass9 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_faceClusterErrorReport=" + jSONObject.toString());
                        iFaceCallback.onSuccess(null, null);
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O00000Oo(str2, "onFailure_faceClusterErrorReport code=" + i + " msg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (Exception e) {
                String str3 = TAG;
                gsy.O00000Oo(str3, "addClusterFace:" + e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevcie null");
        }
    }

    public void getFigureByMarkedFace(String str, final IFaceCallback iFaceCallback) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("model", this.mDevice.getModel());
                jSONObject.put("faceId", str);
                String jSONObject2 = jSONObject.toString();
                gsy.O00000Oo(TAG, "getFigureByMarkedFace request params=".concat(String.valueOf(jSONObject2)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/get/figureByMarkedFace", "GET", jSONObject2, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass10 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_getFigureByMarkedFace=" + jSONObject.toString());
                        CommonResult commonResult = (CommonResult) FaceManager.gGson.fromJson(jSONObject.toString(), CommonResult.class);
                        if (commonResult.code == 0) {
                            IFaceCallback iFaceCallback = iFaceCallback;
                            if (iFaceCallback != null) {
                                iFaceCallback.onSuccess(null, FaceManager.gGson.fromJson(commonResult.data, FigureInfo.class));
                                return;
                            }
                            return;
                        }
                        IFaceCallback iFaceCallback2 = iFaceCallback;
                        if (iFaceCallback2 != null) {
                            int i = commonResult.code;
                            StringBuilder sb = new StringBuilder();
                            sb.append(commonResult.code);
                            iFaceCallback2.onFailure(i, sb.toString());
                        }
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O000000o(6, str2, "onFailure_getFigureByMarkedFace code=" + i + " msg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (Exception e) {
                gsy.O000000o(6, TAG, e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevice null");
        }
    }

    public void getFigureFaces(final IFaceCallback iFaceCallback, String str) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("model", this.mDevice.getModel());
                jSONObject.put("figureId", str);
                String jSONObject2 = jSONObject.toString();
                gsy.O00000Oo(TAG, "getFigureFaces request params=".concat(String.valueOf(jSONObject2)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/get/figureFaces", "GET", jSONObject2, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass11 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_getFigureFaces=" + jSONObject.toString());
                        CommonResult commonResult = (CommonResult) FaceManager.gGson.fromJson(jSONObject.toString(), CommonResult.class);
                        if (commonResult.code == 0) {
                            IFaceCallback iFaceCallback = iFaceCallback;
                            if (iFaceCallback != null) {
                                iFaceCallback.onSuccess(null, FaceManager.gGson.fromJson(commonResult.data, FaceIdMetaResult.class));
                                return;
                            }
                            return;
                        }
                        IFaceCallback iFaceCallback2 = iFaceCallback;
                        if (iFaceCallback2 != null) {
                            int i = commonResult.code;
                            StringBuilder sb = new StringBuilder();
                            sb.append(commonResult.code);
                            iFaceCallback2.onFailure(i, sb.toString());
                        }
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O000000o(6, str2, "onFailure_getFigureFaces code=" + i + " msg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (Exception e) {
                gsy.O000000o(6, TAG, e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevice null");
        }
    }

    public void getFaceIdsByFiledId(final IFaceCallback iFaceCallback, Object... objArr) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("model", this.mDevice.getModel());
                JSONArray jSONArray = new JSONArray();
                for (Object put : objArr) {
                    jSONArray.put(put);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("fileIds", jSONArray);
                jSONObject.put("fileIds", jSONObject2);
                String jSONObject3 = jSONObject.toString();
                gsy.O00000Oo(TAG, "getFaceIdsByFiledId request params=".concat(String.valueOf(jSONObject3)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/get/fileIdMetas", "GET", jSONObject3, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass12 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_getFaceIdsByFiledId=" + jSONObject.toString());
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onSuccess(null, jSONObject);
                        }
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O000000o(6, str2, "onFailure_getFaceIdsByFiledId code=" + i + " msg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (Exception e) {
                gsy.O000000o(6, TAG, e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevice null");
        }
    }

    public String getFaceImg(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.cachedFaceImage.containsKey(str)) {
            return this.cachedFaceImage.get(str);
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("did", this.mDevice.getDid());
            jSONObject.put("model", this.mDevice.getModel());
            jSONObject.put("faceId", str);
            jSONObject2.put("prefix", "business.smartcamera.");
            jSONObject2.put("method", "GET");
            jSONObject2.put("path", "/miot/camera/app/v1/get/face/img");
            str2 = XmPluginHostApi.instance().generateRequestUrl(this.mDevice.getModel(), jSONObject2, jSONObject);
            this.cachedFaceImage.put(str, str2);
            return str2;
        } catch (Exception e) {
            String str3 = TAG;
            gsy.O000000o(6, str3, e.getLocalizedMessage());
            return str2;
        }
    }

    public void getFaces(final IFaceCallback iFaceCallback) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("model", this.mDevice.getModel());
                String jSONObject2 = jSONObject.toString();
                gsy.O00000Oo(TAG, "getFaces request params=".concat(String.valueOf(jSONObject2)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/get/faces", "GET", jSONObject2, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass13 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_getFaces=" + jSONObject.toString());
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onSuccess(null, jSONObject);
                        }
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O000000o(6, str2, "onFailure_getFaces code=" + i + " msg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (Exception e) {
                gsy.O000000o(6, TAG, e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevice null");
        }
    }

    public void addFaceToFigure(String str, final String str2, final String str3, final IFaceCallback iFaceCallback) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("model", this.mDevice.getModel());
                jSONObject.put("faceId", str);
                jSONObject.put("figureId", str2);
                String jSONObject2 = jSONObject.toString();
                gsy.O00000Oo(TAG, "addFaceToFigure request params=".concat(String.valueOf(jSONObject2)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/add/face", "POST", jSONObject2, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass14 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_addFaceToFigure=" + jSONObject.toString());
                        if (iFaceCallback != null) {
                            try {
                                jSONObject.put("name", str3);
                                jSONObject.put("id", str2);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            iFaceCallback.onSuccess(null, jSONObject);
                        }
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O000000o(6, str2, "onFailure_addFaceToFigure code=" + i + " msg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (Exception e) {
                gsy.O000000o(6, TAG, e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevice null");
        }
    }

    public void addFacesToFigure(String str, String str2, final IFaceCallback iFaceCallback) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("model", this.mDevice.getModel());
                jSONObject.put("faceIds", str);
                jSONObject.put("figureId", str2);
                String jSONObject2 = jSONObject.toString();
                gsy.O00000Oo(TAG, "addFaceToFigure request params=".concat(String.valueOf(jSONObject2)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/add/cluster/face", "POST", jSONObject2, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass15 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_addFacesToFigure=" + jSONObject.toString());
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onSuccess(null, jSONObject);
                        }
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O00000Oo(str2, "onFailure_addFacesToFigure code=" + i + " msg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (Exception e) {
                gsy.O00000Oo(TAG, e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevice null");
        }
    }

    public void deleteFaceFromFigure(String str, String str2, final IFaceCallback iFaceCallback) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("model", this.mDevice.getModel());
                jSONObject.put("faceId", str);
                jSONObject.put("figureId", str2);
                String jSONObject2 = jSONObject.toString();
                gsy.O00000Oo(TAG, "deleteFaceFromFigure request params=".concat(String.valueOf(jSONObject2)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/delete/face", "POST", jSONObject2, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass16 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_deleteFaceFromFigure=" + jSONObject.toString());
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onSuccess(null, jSONObject);
                        }
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O000000o(6, str2, "onFailure_deleteFaceFromFigure code=" + i + " mgetgetgetsg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (Exception e) {
                gsy.O000000o(6, TAG, e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevice null");
        }
    }

    public void deleteFacesFromFigure(Object[] objArr, String str, final IFaceCallback iFaceCallback) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("model", this.mDevice.getModel());
                jSONObject.put("figureId", str);
                JSONArray jSONArray = new JSONArray();
                for (Object put : objArr) {
                    jSONArray.put(put);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ids", jSONArray);
                jSONObject.put("faceIds", jSONObject2.toString());
                String jSONObject3 = jSONObject.toString();
                gsy.O00000Oo(TAG, "deleteFacesFromFigure request params=".concat(String.valueOf(jSONObject3)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/delete/faces", "POST", jSONObject3, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass17 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_deleteFacesFromFigure=" + jSONObject.toString());
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onSuccess(null, jSONObject);
                        }
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O000000o(6, str2, "onFailure_deleteFacesFromFigure code=" + i + " msg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (Exception e) {
                gsy.O000000o(6, TAG, e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevice null");
        }
    }

    public void getUnmarkFaces(int i, boolean z, final IFaceCallback iFaceCallback) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("region", Locale.getDefault().getCountry());
                jSONObject.put("model", this.mDevice.getModel());
                jSONObject.put("beginTime", 0);
                if (z) {
                    jSONObject.put("endTime", this.unMarkedFaceNextTime);
                } else {
                    this.unMarkedFaceNextTime = -1;
                    jSONObject.put("endTime", System.currentTimeMillis());
                }
                jSONObject.put("limit", i);
                String jSONObject2 = jSONObject.toString();
                gsy.O00000Oo(TAG, "getUnmarkFaces request params=".concat(String.valueOf(jSONObject2)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/get/unmarkFaces", "GET", jSONObject2, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass18 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_getFigureFaces=" + jSONObject.toString());
                        CommonResult commonResult = (CommonResult) FaceManager.gGson.fromJson(jSONObject.toString(), CommonResult.class);
                        if (commonResult.code != 0) {
                            IFaceCallback iFaceCallback = iFaceCallback;
                            if (iFaceCallback != null) {
                                int i = commonResult.code;
                                StringBuilder sb = new StringBuilder();
                                sb.append(commonResult.code);
                                iFaceCallback.onFailure(i, sb.toString());
                            }
                        } else if (iFaceCallback != null) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            FaceManager.this.unMarkedFaceNextTime = optJSONObject.optLong("nextTime");
                            iFaceCallback.onSuccess(null, FaceManager.gGson.fromJson(optJSONObject.optJSONArray("faceInfoMetas").toString(), new TypeToken<ArrayList<UnmarkedFaceInfo>>() {
                                /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass18.AnonymousClass1 */
                            }.getType()));
                        }
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O000000o(6, str2, "onFailure_getUnmarkFaces code=" + i + " msg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (JSONException e) {
                String str = TAG;
                gsy.O000000o(6, str, e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevice null");
        }
    }

    public void getFigureByName(String str, final IFaceCallback iFaceCallback) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("model", this.mDevice.getModel());
                jSONObject.put("figureName", str);
                String jSONObject2 = jSONObject.toString();
                gsy.O00000Oo(TAG, "getFigureByName request params=".concat(String.valueOf(jSONObject2)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/get/figureByName", "GET", jSONObject2, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass19 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_getFigureByName=" + jSONObject.toString());
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onSuccess(null, jSONObject);
                        }
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O000000o(6, str2, "onFailure_getFigureByName code=" + i + " msg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (Exception e) {
                gsy.O000000o(6, TAG, e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevice null");
        }
    }

    public void putFaceSwitch(boolean z, final IFaceCallback iFaceCallback) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("region", Locale.getDefault().getCountry());
                jSONObject.put("open", z);
                String jSONObject2 = jSONObject.toString();
                gsy.O00000Oo(TAG, "putFaceSwitch request params=".concat(String.valueOf(jSONObject2)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/put/faceSwitch", "POST", jSONObject2, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass20 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_putFaceSwitch=" + jSONObject.toString());
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onSuccess(null, jSONObject);
                        }
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O000000o(6, str2, "onFailure_putFaceSwitch code=" + i + " msg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (Exception e) {
                gsy.O000000o(6, TAG, e.toString());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevice null");
        }
    }

    public void putBabyCrySwitch(boolean z, final IFaceCallback iFaceCallback) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("region", Locale.getDefault().getCountry());
                jSONObject.put("open", z);
                String jSONObject2 = jSONObject.toString();
                gsy.O00000Oo(TAG, "putBabyCrySwitch request params=".concat(String.valueOf(jSONObject2)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/put/babyCrySwitch", "POST", jSONObject2, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass21 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_putBabyCrySwitch=" + jSONObject.toString());
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onSuccess(null, jSONObject);
                        }
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O000000o(6, str2, "onFailure_putBabyCrySwitch code=" + i + " msg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (Exception e) {
                gsy.O000000o(6, TAG, e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevice null");
        }
    }

    public void feedBack(String str, boolean z, final IFaceCallback iFaceCallback) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("model", this.mDevice.getModel());
                jSONObject.put("region", Locale.getDefault().getCountry());
                jSONObject.put("fileId", str);
                jSONObject.put("isVisible", z);
                jSONObject.put("type", "face");
                String jSONObject2 = jSONObject.toString();
                gsy.O00000Oo(TAG, "feedBack request params=".concat(String.valueOf(jSONObject2)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/feedback", "POST", jSONObject2, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass22 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_feedBack=" + jSONObject.toString());
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onSuccess(null, jSONObject);
                        }
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O000000o(6, str2, "onFailure_feedBack code=" + i + " msg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (Exception e) {
                gsy.O000000o(6, TAG, e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevice null");
        }
    }

    public void searchFaces(String[] strArr, final IFaceCallback iFaceCallback) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("model", this.mDevice.getModel());
                JSONArray jSONArray = new JSONArray();
                for (String put : strArr) {
                    jSONArray.put(put);
                }
                jSONObject.put("faceIds", jSONArray);
                String jSONObject2 = jSONObject.toString();
                gsy.O00000Oo(TAG, "searchFaces request params=".concat(String.valueOf(jSONObject2)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/faces/search", "GET", jSONObject2, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass23 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_searchFaces=" + jSONObject.toString());
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onSuccess(null, jSONObject);
                        }
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O000000o(6, str2, "onFailure_searchFaces code=" + i + " msg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (Exception e) {
                gsy.O000000o(6, TAG, e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevice null");
        }
    }

    public void uploadImageFile(Context context, String str, final IFaceCallback iFaceCallback) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("model", this.mDevice.getModel());
                jSONObject.put("did", this.mDevice.getDid());
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                XmPluginHostApi.instance().uploadImageFile(this.mDevice.getModel(), this.mDevice.getDid(), "business.smartcamera", "/miot/camera/app/v1/add/photo", jSONObject, arrayList, new ICloudDataCallback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass24 */

                    public void onCloudDataProgress(int i) {
                    }

                    public void onCloudDataSuccess(JSONObject jSONObject, Object obj) {
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onSuccess(jSONObject, obj);
                        }
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "uploadImageFile result:" + jSONObject + ":" + obj);
                    }

                    public void onCloudDataFailed(int i, String str) {
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                        String str2 = FaceManager.TAG;
                        gsy.O00000Oo(str2, "uploadImageFile errorCode" + i + ":" + str);
                    }
                });
            } catch (JSONException e) {
                gsy.O000000o(6, TAG, e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevice null");
        }
    }

    public void markUseFreeFaceService(Context context, final IFaceCallback iFaceCallback) {
        if (this.mDevice != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDevice.getDid());
                jSONObject.put("region", Locale.getDefault().getCountry());
                String jSONObject2 = jSONObject.toString();
                gsy.O00000Oo(TAG, "mark free face service=".concat(String.valueOf(jSONObject2)));
                XmPluginHostApi.instance().callSmartHomeApi(this.mDevice.getModel(), "business.smartcamera.", "/miot/camera/app/v1/vip/freeface/addFreeface", "GET", jSONObject2, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.miio.camera.face.FaceManager.AnonymousClass25 */

                    public void onSuccess(JSONObject jSONObject) {
                        String str = FaceManager.TAG;
                        gsy.O00000Oo(str, "onSuccess_mark free face service=" + jSONObject.toString());
                        if ("ok".equals(jSONObject.optString("result"))) {
                            IFaceCallback iFaceCallback = iFaceCallback;
                            if (iFaceCallback != null) {
                                iFaceCallback.onSuccess(null, "");
                                return;
                            }
                            return;
                        }
                        IFaceCallback iFaceCallback2 = iFaceCallback;
                        if (iFaceCallback2 != null) {
                            iFaceCallback2.onFailure(400209, "");
                        }
                    }

                    public void onFailure(int i, String str) {
                        String str2 = FaceManager.TAG;
                        gsy.O000000o(6, str2, "onFailure_searchFaces code=" + i + " msg=" + str);
                        IFaceCallback iFaceCallback = iFaceCallback;
                        if (iFaceCallback != null) {
                            iFaceCallback.onFailure(i, str);
                        }
                    }
                }, Parser.DEFAULT_PARSER);
            } catch (JSONException e) {
                gsy.O000000o(6, TAG, e.getLocalizedMessage());
                if (iFaceCallback != null) {
                    iFaceCallback.onFailure(-1001, e.getLocalizedMessage());
                }
            }
        } else if (iFaceCallback != null) {
            iFaceCallback.onFailure(-1002, "mDevice null");
        }
    }
}

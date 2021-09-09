package com.xiaomi.smarthome.plugin;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public class DeviceModelManager {
    private static final ArrayList<String> SUPPORT_CAMERA_MODEL_LIST = new ArrayList<>();
    private static final ArrayList<String> SUPPORT_DOORBELL_MODEL_LIST = new ArrayList<>();
    private static final Set<Integer> SUPPORT_DOORBELL_PRODUCT_ID_LIST = new HashSet();
    static HashMap<String, StartExtraExtractor> StartExtractor;
    private boolean useFixedDeviceUid;
    private volatile boolean xiaoyiInitFlag;

    interface StartExtraExtractor {
        JSONObject getStartExtra(String str, String str2);
    }

    public String getHualaiFixedEnr() {
        return "FFFFFFFFFFFFFFFF";
    }

    public String getHualaiFixedUid() {
        return "YHH3LWJYU9PF6621111A";
    }

    static {
        SUPPORT_CAMERA_MODEL_LIST.add("mijia.camera.v1");
        SUPPORT_CAMERA_MODEL_LIST.add("mijia.camera.v3");
        SUPPORT_CAMERA_MODEL_LIST.add("chuangmi.camera.ipc009");
        SUPPORT_CAMERA_MODEL_LIST.add("chuangmi.camera.v2");
        SUPPORT_CAMERA_MODEL_LIST.add("chuangmi.camera.v5");
        SUPPORT_CAMERA_MODEL_LIST.add("chuangmi.camera.v3");
        SUPPORT_CAMERA_MODEL_LIST.add("chuangmi.camera.v4");
        SUPPORT_CAMERA_MODEL_LIST.add("chuangmi.camera.ipc010");
        SUPPORT_CAMERA_MODEL_LIST.add("chuangmi.camera.ipc013");
        SUPPORT_CAMERA_MODEL_LIST.add("chuangmi.camera.ipc013d");
        SUPPORT_CAMERA_MODEL_LIST.add("chuangmi.camera.ipc016");
        SUPPORT_CAMERA_MODEL_LIST.add("chuangmi.gateway.ipc011");
        SUPPORT_CAMERA_MODEL_LIST.add("chuangmi.camera.v6");
        SUPPORT_CAMERA_MODEL_LIST.add("chuangmi.camera.xiaobai");
        SUPPORT_CAMERA_MODEL_LIST.add("chuangmi.camera.ipc019");
        SUPPORT_CAMERA_MODEL_LIST.add("chuangmi.camera.ipc007b");
        SUPPORT_CAMERA_MODEL_LIST.add("chuangmi.camera.ipc017");
        SUPPORT_CAMERA_MODEL_LIST.add("chuangmi.camera.ipc019b");
        SUPPORT_CAMERA_MODEL_LIST.add("chuangmi.camera.ipc019c");
        SUPPORT_CAMERA_MODEL_LIST.add("chuangmi.camera.ipc019e");
        SUPPORT_CAMERA_MODEL_LIST.add("chuangmi.camera.ipc020");
        SUPPORT_CAMERA_MODEL_LIST.add("isa.camera.isc5");
        SUPPORT_CAMERA_MODEL_LIST.add("isa.camera.isc5c1");
        SUPPORT_CAMERA_MODEL_LIST.add("isa.camera.df3");
        SUPPORT_CAMERA_MODEL_LIST.add("isa.camera.hl5");
        SUPPORT_CAMERA_MODEL_LIST.add("isa.camera.qf3");
        SUPPORT_CAMERA_MODEL_LIST.add("yunyi.camera.v1");
        SUPPORT_CAMERA_MODEL_LIST.add("lumi.camera.aq1");
        SUPPORT_CAMERA_MODEL_LIST.add("lumi.camera.gwagl01");
        SUPPORT_CAMERA_MODEL_LIST.add("xiaovv.camera.xva3");
        SUPPORT_CAMERA_MODEL_LIST.add("xiaovv.camera.xvb4");
        SUPPORT_CAMERA_MODEL_LIST.add("xiaovv.camera.xvd5");
        SUPPORT_CAMERA_MODEL_LIST.add("xiaovv.camera.lamp");
        SUPPORT_CAMERA_MODEL_LIST.add("xiaovv.camera.xvsnowman");
        SUPPORT_CAMERA_MODEL_LIST.add("xiaovv.camera.ptz");
        SUPPORT_CAMERA_MODEL_LIST.add("mmgg.feeder.snack");
        SUPPORT_DOORBELL_MODEL_LIST.add("madv.cateye.dlowl");
        SUPPORT_DOORBELL_MODEL_LIST.add("madv.cateye.miowl");
        SUPPORT_DOORBELL_MODEL_LIST.add("loock.cateye.v01");
        SUPPORT_DOORBELL_MODEL_LIST.add("chuangmi.cateye.ipc018");
        SUPPORT_DOORBELL_PRODUCT_ID_LIST.add(65594);
        SUPPORT_DOORBELL_PRODUCT_ID_LIST.add(66551);
        SUPPORT_DOORBELL_PRODUCT_ID_LIST.add(65618);
        SUPPORT_DOORBELL_PRODUCT_ID_LIST.add(66479);
        HashMap<String, StartExtraExtractor> hashMap = new HashMap<>();
        StartExtractor = hashMap;
        hashMap.put("mxiang.camera.mwc10", new StartExtraExtractor() {
            /* class com.xiaomi.smarthome.plugin.DeviceModelManager.AnonymousClass1 */

            public final JSONObject getStartExtra(String str, String str2) {
                String childDid = DeviceModelManager.getChildDid(str2);
                if (childDid != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("enableaudio", 0);
                        jSONObject.put("subdid", childDid);
                        return jSONObject;
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
        });
        System.loadLibrary("AVAPIs");
        System.loadLibrary("IOTCAPIs");
    }

    public static JSONObject getStartExtra(String str, String str2) {
        StartExtraExtractor startExtraExtractor = StartExtractor.get(str);
        if (startExtraExtractor != null) {
            return startExtraExtractor.getStartExtra(str, str2);
        }
        return null;
    }

    public static String getChildDid(String str) {
        String[] split = str.split("--");
        if (split.length >= 2) {
            return split[split.length - 1];
        }
        return null;
    }

    public boolean isLocalCameraSupported(String str) {
        return SUPPORT_CAMERA_MODEL_LIST.contains(str);
    }

    public boolean isNeedFixedUid(String str) {
        return this.useFixedDeviceUid;
    }

    public boolean isLocalDoorbellSupported(String str) {
        return SUPPORT_DOORBELL_MODEL_LIST.contains(str);
    }

    private DeviceModelManager() {
        this.useFixedDeviceUid = false;
        this.xiaoyiInitFlag = false;
    }

    public static DeviceModelManager getInstance() {
        return Holder.INSTANCE;
    }

    public void setUseFixedDeviceUid(boolean z) {
        this.useFixedDeviceUid = z;
    }

    static final class Holder {
        static DeviceModelManager INSTANCE = new DeviceModelManager();

        Holder() {
        }
    }

    public boolean isCommonDoorRing(String str) {
        return isFengJingDoorRing(str) || isLoockCateyeDevice(str) || TextUtils.equals(str, "chuangmi.cateye.ipc018");
    }

    public boolean isFengJingDoorRing(String str) {
        return TextUtils.equals(str, "madv.cateye.dlowl") || TextUtils.equals(str, "madv.cateye.miowl");
    }

    public boolean isChuangmiPro(String str) {
        return TextUtils.equals(str, "chuangmi.camera.v6") || TextUtils.equals(str, "chuangmi.camera.xiaobai") || TextUtils.equals(str, "chuangmi.camera.ipc007b");
    }

    public boolean isLoockCateyeDevice(String str) {
        return TextUtils.equals(str, "loock.cateye.v01");
    }

    public boolean isTwoWayCall(String str) {
        return !TextUtils.equals(str, "mijia.camera.v1");
    }

    public boolean isMijiaCameraV1(String str) {
        return TextUtils.equals(str, "mijia.camera.v1");
    }

    public boolean showNoFaceAndCryEventType(String str) {
        if (!TextUtils.equals(str, "mijia.camera.v1")) {
            return !TextUtils.isEmpty(str) && str.contains("xiaovv.camera");
        }
        return true;
    }

    public boolean isChuangmiGateway(String str) {
        return TextUtils.equals(str, "chuangmi.gateway.ipc011");
    }

    public boolean isXiaoYiCamera(String str) {
        return TextUtils.equals(str, "yunyi.camera.v1");
    }

    public boolean isLvmiCamera(String str) {
        return TextUtils.equals(str, "lumi.camera.aq1") || TextUtils.equals(str, "lumi.camera.gwagl01");
    }

    public boolean isLvmiAQ1(String str) {
        return TextUtils.equals(str, "lumi.camera.aq1");
    }

    public boolean isLvmiGWGA(String str) {
        return TextUtils.equals(str, "lumi.camera.gwagl01");
    }

    public boolean isHualaiCamera(String str) {
        return TextUtils.equals(str, "isa.camera.isc5") || TextUtils.equals(str, "isa.camera.isc5c1") || TextUtils.equals(str, "isa.camera.df3") || TextUtils.equals(str, "isa.camera.hl5") || TextUtils.equals(str, "isa.camera.qf3") || TextUtils.equals(str, "isa.camera.hlc6");
    }

    public boolean isHualaiC6Camera(String str) {
        return TextUtils.equals(str, "isa.camera.hlc6");
    }

    public boolean isHualaiHL6(String str) {
        return TextUtils.equals(str, "isa.camera.hlc6");
    }

    public boolean isHongShiCamera(String str) {
        return TextUtils.equals(str, "xiaovv.camera.xva3") || TextUtils.equals(str, "xiaovv.camera.xvb4") || TextUtils.equals(str, "xiaovv.camera.xvd5") || TextUtils.equals(str, "xiaovv.camera.lamp") || TextUtils.equals(str, "xiaovv.camera.xvsnowman") || TextUtils.equals(str, "xiaovv.camera.ptz");
    }

    public boolean isHualaiXFAuthorise(String str) {
        return TextUtils.equals(str, "isa.camera.isc5") || TextUtils.equals(str, "isa.camera.isc5c1") || TextUtils.equals(str, "isa.camera.df3") || TextUtils.equals(str, "isa.camera.hl5");
    }

    public boolean isHualaiQF(String str) {
        return TextUtils.equals(str, "isa.camera.qf3");
    }

    public boolean isHalfWayForAllDevices(String str) {
        return TextUtils.equals(str, "chuangmi.gateway.ipc011") || TextUtils.equals(str, "mijia.camera.v1") || TextUtils.equals(str, "loock.cateye.v01") || TextUtils.equals(str, "isa.camera.isc5") || TextUtils.equals(str, "isa.camera.isc5c1") || TextUtils.equals(str, "isa.camera.hl5") || TextUtils.equals(str, "isa.camera.qf3") || TextUtils.equals(str, "yunyi.camera.v1") || TextUtils.equals(str, "lumi.camera.aq1") || TextUtils.equals(str, "xiaovv.camera.xva3") || TextUtils.equals(str, "xiaovv.camera.xvb4") || TextUtils.equals(str, "xiaovv.camera.xvd5") || TextUtils.equals(str, "chuangmi.camera.ipc017") || TextUtils.equals(str, "xiaovv.camera.lamp") || TextUtils.equals(str, "xiaovv.camera.xvsnowman") || TextUtils.equals(str, "xiaovv.camera.ptz");
    }

    public boolean isSkipGetPropMethod(String str) {
        return isHualaiCamera(str) || isHongShiCamera(str) || TextUtils.equals(str, "chuangmi.cateye.ipc018");
    }

    public boolean isChangeVoiceSupported(String str) {
        return TextUtils.equals(str, "madv.cateye.dlowl") || TextUtils.equals(str, "madv.cateye.miowl") || TextUtils.equals(str, "chuangmi.cateye.ipc018");
    }

    public boolean isFullDecrpt(String str) {
        return TextUtils.equals(str, "chuangmi.camera.ipc019") || TextUtils.equals(str, "chuangmi.camera.ipc017") || TextUtils.equals(str, "chuangmi.camera.ipc019b") || TextUtils.equals(str, "chuangmi.camera.ipc019c") || TextUtils.equals(str, "chuangmi.camera.ipc019e") || TextUtils.equals(str, "chuangmi.camera.ipc020");
    }

    public boolean isNoDecrpt(String str) {
        return TextUtils.equals(str, "isa.camera.isc5") || TextUtils.equals(str, "isa.camera.isc5c1") || TextUtils.equals(str, "isa.camera.df3") || TextUtils.equals(str, "isa.camera.hl5");
    }

    public boolean isCameraNeedSendAudioCmd(String str) {
        return TextUtils.equals(str, "chuangmi.camera.v6") || TextUtils.equals(str, "chuangmi.camera.ipc007b") || TextUtils.equals(str, "chuangmi.camera.xiaobai") || TextUtils.equals(str, "lumi.camera.aq1");
    }

    public int getDeviceSampleRate(String str) {
        return (TextUtils.equals(str, "chuangmi.camera.v6") || TextUtils.equals(str, "chuangmi.camera.ipc007b") || TextUtils.equals(str, "chuangmi.camera.xiaobai") || TextUtils.equals(str, "chuangmi.camera.ipc019") || TextUtils.equals(str, "yunyi.camera.v1") || TextUtils.equals(str, "lumi.camera.aq1") || TextUtils.equals(str, "lumi.camera.gwagl01") || TextUtils.equals(str, "chuangmi.camera.ipc017") || TextUtils.equals(str, "chuangmi.camera.ipc019b") || TextUtils.equals(str, "chuangmi.camera.ipc019c") || TextUtils.equals(str, "chuangmi.camera.ipc019e") || TextUtils.equals(str, "chuangmi.camera.ipc020")) ? 16000 : 8000;
    }

    public int getDeviceVideoFormat(String str) {
        return (TextUtils.equals(str, "chuangmi.camera.ipc009") || TextUtils.equals(str, "chuangmi.camera.ipc017") || TextUtils.equals(str, "chuangmi.camera.ipc019") || TextUtils.equals(str, "chuangmi.camera.ipc019b") || TextUtils.equals(str, "chuangmi.camera.ipc019c") || TextUtils.equals(str, "chuangmi.camera.ipc019e") || TextUtils.equals(str, "chuangmi.camera.ipc020") || TextUtils.equals(str, "chuangmi.cateye.ipc018")) ? 2 : 1;
    }

    public boolean isAudioCodec711(String str) {
        return TextUtils.equals(str, "chuangmi.camera.ipc019") || TextUtils.equals(str, "chuangmi.camera.v6") || TextUtils.equals(str, "yunyi.camera.v1") || TextUtils.equals(str, "chuangmi.camera.ipc017") || TextUtils.equals(str, "chuangmi.camera.ipc019") || TextUtils.equals(str, "chuangmi.camera.ipc019b") || TextUtils.equals(str, "chuangmi.camera.ipc019c") || TextUtils.equals(str, "chuangmi.camera.ipc019e") || TextUtils.equals(str, "chuangmi.camera.ipc020");
    }

    public boolean isMijiaDoorbellV02(String str) {
        return TextUtils.equals(str, "loock.cateye.v02");
    }

    public boolean isChuangmi019SeriesDevice(String str) {
        return TextUtils.equals(str, "chuangmi.camera.ipc019") || TextUtils.equals(str, "chuangmi.camera.ipc017") || TextUtils.equals(str, "chuangmi.camera.ipc019b") || TextUtils.equals(str, "chuangmi.camera.ipc019c") || TextUtils.equals(str, "chuangmi.camera.ipc019e") || TextUtils.equals(str, "chuangmi.camera.ipc020");
    }
}

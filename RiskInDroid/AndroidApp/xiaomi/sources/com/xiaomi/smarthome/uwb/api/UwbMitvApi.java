package com.xiaomi.smarthome.uwb.api;

import _m_j.bxa;
import _m_j.bxc;
import _m_j.bxe;
import _m_j.bxl;
import _m_j.bxm;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.idm.uwb.constant.UwbConst;
import com.xiaomi.smarthome.uwb.lib.UwbApi;
import com.xiaomi.smarthome.uwb.lib.mitv.parse.IMitvDataParseCB;
import com.xiaomi.smarthome.uwb.lib.mitv.parse.TVUwbDataBuilder;
import com.xiaomi.smarthome.uwb.lib.protocol.format.Payload;
import com.xiaomi.smarthome.uwb.lib.protocol.format.Type;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import java.util.HashMap;

public class UwbMitvApi {
    public static final String TAG = "com.xiaomi.smarthome.uwb.api.UwbMitvApi";

    public static void doAiStart() {
        try {
            UwbApi.getInstance().sendPayload(UwbConst.AppId.MI_LINK, Type.JSON, TVUwbDataBuilder.buildRequestData("doAiStart", null, null), UwbConst.Target.SEND_DATA_TO_HID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doAiFinish() {
        try {
            UwbApi.getInstance().sendPayload(UwbConst.AppId.MI_LINK, Type.JSON, TVUwbDataBuilder.buildRequestData("doAiFinish", null, null), UwbConst.Target.SEND_DATA_TO_HID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.uwb.lib.UwbApi.sendPayload(com.xiaomi.idm.uwb.constant.UwbConst$AppId, com.xiaomi.smarthome.uwb.lib.protocol.format.Type, byte[], com.xiaomi.idm.uwb.constant.UwbConst$Target, boolean):int
     arg types: [com.xiaomi.idm.uwb.constant.UwbConst$AppId, com.xiaomi.smarthome.uwb.lib.protocol.format.Type, byte[], com.xiaomi.idm.uwb.constant.UwbConst$Target, int]
     candidates:
      com.xiaomi.smarthome.uwb.lib.UwbApi.sendPayload(com.xiaomi.idm.uwb.constant.UwbConst$AppId, com.xiaomi.smarthome.uwb.lib.protocol.format.Type, org.json.JSONObject, com.xiaomi.idm.uwb.constant.UwbConst$Target, com.xiaomi.smarthome.uwb.lib.UwbApi$PayloadCallback):void
      com.xiaomi.smarthome.uwb.lib.UwbApi.sendPayload(com.xiaomi.idm.uwb.constant.UwbConst$AppId, com.xiaomi.smarthome.uwb.lib.protocol.format.Type, byte[], com.xiaomi.idm.uwb.constant.UwbConst$Target, boolean):int */
    public static void doAiData(byte[] bArr) {
        try {
            UwbApi.getInstance().sendPayload(UwbConst.AppId.MI_LINK, Type.DataStreamChunk, bArr, UwbConst.Target.SEND_DATA_TO_HID, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doVideoPosition(String str, long j) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("mediaId", str);
            hashMap.put("position", String.valueOf(j));
            UwbApi.getInstance().sendPayload(UwbConst.AppId.MI_LINK, Type.JSON, TVUwbDataBuilder.buildRequestData("doVideoPosition", null, hashMap), UwbConst.Target.SEND_DATA_TO_HID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doVideoPlay(int i, String str, int i2, long j, int i3) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("mediaId", String.valueOf(i));
            hashMap.put("mediaName", str);
            hashMap.put("ci", String.valueOf(i2));
            hashMap.put("position", String.valueOf(j));
            hashMap.put("source", String.valueOf(i3));
            UwbApi.getInstance().sendPayload(UwbConst.AppId.MI_LINK, Type.JSON, TVUwbDataBuilder.buildRequestData("doVideoPlay", null, hashMap), UwbConst.Target.SEND_DATA_TO_HID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doLogin() {
        try {
            UwbApi.getInstance().sendPayload(UwbConst.AppId.MI_LINK, Type.JSON, TVUwbDataBuilder.buildRequestData("doLogin", null, null), UwbConst.Target.SEND_DATA_TO_HID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doSourcePage() {
        try {
            UwbApi.getInstance().sendPayload(UwbConst.AppId.MI_LINK, Type.JSON, TVUwbDataBuilder.buildRequestData("doSourcePage", null, null), UwbConst.Target.SEND_DATA_TO_HID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doKeyEvent(int i) {
        UwbLogUtil.w(TAG, "UwbLogUtilPlus doKeyEvent: ".concat(String.valueOf(i)));
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("eventCode", String.valueOf(i));
            UwbApi.getInstance().sendPayload(UwbConst.AppId.MI_LINK, Type.JSON, TVUwbDataBuilder.buildRequestData("doKeyEvent", null, hashMap), UwbConst.Target.SEND_DATA_TO_HID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void miracast(Context context, String str, String str2) {
        Intent intent = new Intent("com.xiaomi.mi_connect_service.mi_play_endpoint_found");
        intent.setComponent(new ComponentName("com.milink.service", "com.milink.ui.receiver.MiLinkStartupReceiver"));
        intent.putExtra("cmd", 1);
        intent.putExtra("mac", str);
        intent.putExtra("wired_mac", str2);
        intent.addFlags(16777216);
        intent.addFlags(32);
        intent.addFlags(268435456);
        context.sendBroadcast(intent, "com.xiaomi.mi_connect_service.permission.RECEIVE_ENDPOINT");
    }

    public static void reqTvInfo() {
        UwbLogUtil.w(TAG, "UwbLogUtilPlus reqTvInfo");
        try {
            UwbApi.getInstance().sendPayload(UwbConst.AppId.MI_LINK, Type.JSON, TVUwbDataBuilder.buildRequestData("reqTvInfo", null, null), UwbConst.Target.SEND_DATA_TO_HID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reqPlayerInfo() {
        UwbLogUtil.w(TAG, "UwbLogUtilPlus reqPlayerInfo");
        try {
            UwbApi.getInstance().sendPayload(UwbConst.AppId.MI_LINK, Type.JSON, TVUwbDataBuilder.buildRequestData("reqPlayerInfo", null, null), UwbConst.Target.SEND_DATA_TO_HID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parsePayload(Payload payload, final IMitvDataParseCB iMitvDataParseCB) {
        bxe.O000000o(new String(payload.getData()), new bxa() {
            /* class com.xiaomi.smarthome.uwb.api.UwbMitvApi.AnonymousClass1 */

            public final void onSuccess(bxc bxc) {
                UwbLogUtil.w(UwbMitvApi.TAG, "UwbLogUtilPlus airkan parseData onSuccess");
                bxm bxm = bxc.f13375O000000o;
                UwbLogUtil.d("UWBPERFORMANCE", "UWBPERFORMANCE-16-mijia-card-response:" + bxm.O00000Oo + " timeMills: " + System.currentTimeMillis());
                bxl bxl = bxc.O00000Oo;
                IMitvDataParseCB iMitvDataParseCB = iMitvDataParseCB;
                if (iMitvDataParseCB != null) {
                    iMitvDataParseCB.onSuccess(TVUwbDataBuilder.parseMitvInfo(bxl), TVUwbDataBuilder.parseMitvNotif(bxl));
                }
            }

            public final void onFailed(int i, String str) {
                String str2 = UwbMitvApi.TAG;
                UwbLogUtil.w(str2, "UwbLogUtilPlus airkan parseData onFailed: " + i + ", " + str);
                IMitvDataParseCB iMitvDataParseCB = iMitvDataParseCB;
                if (iMitvDataParseCB != null) {
                    iMitvDataParseCB.onFailed(i, str);
                }
            }
        });
    }

    public static void doUpgradeTag(int i) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("authorized", String.valueOf(i));
            UwbApi.getInstance().sendPayload(UwbConst.AppId.MI_LINK, Type.JSON, TVUwbDataBuilder.buildRequestData("reqOtaResult", null, hashMap), UwbConst.Target.SEND_DATA_TO_HID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

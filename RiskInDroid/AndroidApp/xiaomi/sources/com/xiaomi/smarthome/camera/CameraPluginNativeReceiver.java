package com.xiaomi.smarthome.camera;

import _m_j.cid;
import _m_j.ciq;
import _m_j.civ;
import _m_j.cki;
import _m_j.exz;
import _m_j.ftn;
import _m_j.gqg;
import _m_j.gsy;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.GeneralCameraV3UpgradePlayerActivity;
import com.xiaomi.smarthome.camera.activity.SelectKnowFaceFigure;
import com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoActivityNew;
import com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivity;
import com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoNormalPlayerActivityNew;
import com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoPlayerActivity;
import com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoPlayerActivityNew;
import com.xiaomi.smarthome.camera.activity.local.LocalAlarmPlayerActivity;
import com.xiaomi.smarthome.camera.activity.nas.NASInfoActivity;
import com.xiaomi.smarthome.camera.v4.activity.CameraPlayerNewActivity;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import org.json.JSONException;
import org.json.JSONObject;

public class CameraPluginNativeReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        intent.getStringExtra("extra_device_did");
        String stringExtra = intent.getStringExtra("extra_device_model");
        if (DeviceConstant.isSupportNewUI(stringExtra)) {
            handleV4NewMessage(context, intent, stringExtra);
        } else if ("isa.camera.hlc6".equals(stringExtra)) {
            handleV3UpdateMessage(context, intent);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01a8  */
    private void handleV3UpdateMessage(Context context, Intent intent) {
        boolean z;
        Context context2 = context;
        Intent intent2 = intent;
        String stringExtra = intent2.getStringExtra("extra_device_did");
        DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(stringExtra);
        if (deviceByDid != null) {
            String action = intent.getAction();
            char c = 65535;
            switch (action.hashCode()) {
                case -1867628834:
                    if (action.equals("com.xiaomi.smarthome.camera.LANUCH")) {
                        c = 0;
                        break;
                    }
                    break;
                case -411486983:
                    if (action.equals("com.xiaomi.smarthome.camera.PUSH_MSG")) {
                        c = 7;
                        break;
                    }
                    break;
                case -87835003:
                    if (action.equals("com.xiaomi.smarthome.camera.DESTROY_REQUEST_CAMERA_FRAME")) {
                        c = 4;
                        break;
                    }
                    break;
                case 794585267:
                    if (action.equals("com.xiaomi.smarthome.camera.STAR_REQUEST_CAMERA_FRAME")) {
                        c = 2;
                        break;
                    }
                    break;
                case 822564099:
                    if (action.equals("com.xiaomi.smarthome.camera.STOP_REQUEST_CAMERA_FRAME")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1008779369:
                    if (action.equals("com.xiaomi.smarthome.camera.MSG_STOP_AUDIO_CALL")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1296578367:
                    if (action.equals("com.xiaomi.smarthome.camera.MSG_START_AUDIO_CALL")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1303636175:
                    if (action.equals("com.xiaomi.smarthome.camera.INIT_CAMERA_FRAME_SENDER")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    XmPluginHostApi.instance().closeCameraFloatingWindow(stringExtra);
                    Intent intent3 = new Intent();
                    intent3.putExtra("extra_device_did", stringExtra);
                    intent3.putExtra("is_v4", false);
                    intent3.addFlags(268435456);
                    intent3.setClass(context2, GeneralCameraV3UpgradePlayerActivity.class);
                    exz exz = exz.f15941O000000o;
                    exz.O000000o(intent3, deviceByDid == null ? "" : deviceByDid.model);
                    context2.startActivity(intent3);
                    return;
                case 1:
                    ciq.O000000o();
                    ciq.O00000Oo(deviceByDid);
                    return;
                case 2:
                    ciq.O000000o().O000000o(deviceByDid, intent2);
                    return;
                case 3:
                    ciq.O000000o().O000000o(deviceByDid);
                    return;
                case 4:
                    ciq.O000000o().O00000o0(deviceByDid);
                    return;
                case 5:
                    ciq.O000000o().O00000oO(deviceByDid);
                    return;
                case 6:
                    ciq.O000000o().O00000o(deviceByDid);
                    return;
                case 7:
                    if (intent2 != null) {
                        String stringExtra2 = intent2.getStringExtra("type");
                        if (!TextUtils.isEmpty(stringExtra2)) {
                            if ("DevicePush".equals(stringExtra2)) {
                                String stringExtra3 = intent2.getStringExtra("data");
                                cid.O000000o(deviceByDid, deviceByDid.did).O00000Oo().O000000o(intent2);
                                gsy.O00000o0(LogType.CAMERA, deviceByDid.model, "PushMsg", "DevicePush ".concat(String.valueOf(stringExtra3)));
                                return;
                            } else if ("ScenePush".equals(stringExtra2)) {
                                String stringExtra4 = intent2.getStringExtra("event");
                                String stringExtra5 = intent2.getStringExtra("extra");
                                long longExtra = intent2.getLongExtra("time", 0);
                                intent2.putExtra("extra_device_did", stringExtra);
                                LogType logType = LogType.CAMERA;
                                String str = deviceByDid.model;
                                gsy.O00000o0(logType, str, "PushMsg", "ScenePush :" + stringExtra4 + "  " + stringExtra5);
                                if (stringExtra4.equals("motion") && longExtra > 0) {
                                    intent2.putExtra("push", true);
                                    intent2.putExtra("check", true);
                                    intent2.setClass(context2, LocalAlarmPlayerActivity.class);
                                    intent2.setFlags(67108864);
                                    intent2.addFlags(268435456);
                                    context.startActivity(intent);
                                    return;
                                } else if (stringExtra4.equals("bind_fail_need_app_unbind")) {
                                    intent2.putExtra("fail_unbind", true);
                                    intent2.setFlags(67108864);
                                    intent2.addFlags(268435456);
                                    intent2.setClass(context2, GeneralCameraV3UpgradePlayerActivity.class);
                                    context.startActivity(intent);
                                    return;
                                } else if (stringExtra4.equals("nas_error")) {
                                    intent2.setClass(context2, NASInfoActivity.class);
                                    intent2.setFlags(67108864);
                                    intent2.addFlags(268435456);
                                    context.startActivity(intent);
                                    return;
                                } else if ("smart_camera_motion".equals(stringExtra4)) {
                                    intent2.putExtra("check", true);
                                    if (!TextUtils.isEmpty(stringExtra5)) {
                                        try {
                                            JSONObject jSONObject = new JSONObject(stringExtra5);
                                            long optLong = jSONObject.optLong("createTime");
                                            String optString = jSONObject.optString("fileId");
                                            int optInt = jSONObject.optInt("offset");
                                            try {
                                                z = jSONObject.optBoolean("isAlarm", true);
                                                long j = optLong;
                                                try {
                                                    double optDouble = jSONObject.optDouble("startDuration");
                                                    intent2.putExtra("fileId", optString);
                                                    intent2.putExtra("createTime", j);
                                                    intent2.putExtra("isAlarm", z);
                                                    intent2.putExtra("offset", optInt);
                                                    intent2.putExtra("startDuration", optDouble);
                                                } catch (JSONException unused) {
                                                }
                                            } catch (JSONException unused2) {
                                            }
                                        } catch (JSONException unused3) {
                                        }
                                        if (!z) {
                                            intent2.setClass(context2, AlarmVideoNormalPlayerActivity.class);
                                        } else {
                                            intent2.setClass(context2, AlarmVideoPlayerActivity.class);
                                        }
                                        intent2.setFlags(67108864);
                                        intent2.addFlags(268435456);
                                        context.startActivity(intent);
                                        return;
                                    }
                                    z = true;
                                    if (!z) {
                                    }
                                    intent2.setFlags(67108864);
                                    intent2.addFlags(268435456);
                                    context.startActivity(intent);
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    private void handleV4NewMessage(Context context, Intent intent, String str) {
        char c;
        Context context2 = context;
        Intent intent2 = intent;
        String str2 = str;
        String stringExtra = intent2.getStringExtra("extra_device_did");
        DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(stringExtra);
        if (deviceByDid != null && !TextUtils.isEmpty(intent.getAction())) {
            String action = intent.getAction();
            switch (action.hashCode()) {
                case -1867628834:
                    if (action.equals("com.xiaomi.smarthome.camera.LANUCH")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -446356742:
                    if (action.equals("com.xiaomi.smarthome.camera.MSG_GET_SCENE_VALUE")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -411486983:
                    if (action.equals("com.xiaomi.smarthome.camera.PUSH_MSG")) {
                        c = 8;
                        break;
                    }
                    c = 65535;
                    break;
                case -87835003:
                    if (action.equals("com.xiaomi.smarthome.camera.DESTROY_REQUEST_CAMERA_FRAME")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 794585267:
                    if (action.equals("com.xiaomi.smarthome.camera.STAR_REQUEST_CAMERA_FRAME")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 822564099:
                    if (action.equals("com.xiaomi.smarthome.camera.STOP_REQUEST_CAMERA_FRAME")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1008779369:
                    if (action.equals("com.xiaomi.smarthome.camera.MSG_STOP_AUDIO_CALL")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 1296578367:
                    if (action.equals("com.xiaomi.smarthome.camera.MSG_START_AUDIO_CALL")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1303636175:
                    if (action.equals("com.xiaomi.smarthome.camera.INIT_CAMERA_FRAME_SENDER")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    startCameraPlayer(context2, stringExtra, deviceByDid);
                    return;
                case 1:
                    ciq.O000000o();
                    ciq.O00000Oo(deviceByDid);
                    return;
                case 2:
                    ciq.O000000o().O000000o(deviceByDid, intent2);
                    return;
                case 3:
                    ciq.O000000o().O000000o(deviceByDid);
                    return;
                case 4:
                    ciq.O000000o().O00000o0(deviceByDid);
                    return;
                case 5:
                    ciq.O000000o().O00000oO(deviceByDid);
                    return;
                case 6:
                    ciq.O000000o().O00000o(deviceByDid);
                    return;
                case 7:
                    DeviceStat deviceStat = deviceByDid;
                    String str3 = "CameraPluginNativeReceiver";
                    if ("com.xiaomi.smarthome.camera.SCENE_SELECT_FIGURE".equals(intent.getExtras().getString("plug_id", ""))) {
                        cki.O00000o(str3, "ACTION_SCENE_SELECT_FIGURE intent=".concat(String.valueOf(intent)));
                        Intent intent3 = new Intent();
                        intent3.putExtra("extra_device_did", deviceStat.did);
                        intent3.addFlags(268435456);
                        intent3.putExtras(intent2);
                        intent3.setClass(context2, SelectKnowFaceFigure.class);
                        context2.startActivity(intent3);
                        return;
                    }
                    return;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    if (intent2 != null) {
                        String stringExtra2 = intent2.getStringExtra("type");
                        if (!TextUtils.isEmpty(stringExtra2)) {
                            if ("DevicePush".equals(stringExtra2)) {
                                String stringExtra3 = intent2.getStringExtra("data");
                                cid.O000000o(deviceByDid, deviceByDid.did).O00000Oo().O000000o(intent2);
                                gsy.O00000o0(LogType.CAMERA, str2, "PushMsg", "DevicePush ".concat(String.valueOf(stringExtra3)));
                                return;
                            } else if ("ScenePush".equals(stringExtra2)) {
                                String stringExtra4 = intent2.getStringExtra("event");
                                String stringExtra5 = intent2.getStringExtra("extra");
                                String str4 = "CameraPluginNativeReceiver";
                                civ.O000000o("MessageReceiver", "ScenePush " + stringExtra4 + " " + stringExtra5);
                                DeviceStat deviceStat2 = deviceByDid;
                                long longExtra = intent2.getLongExtra("time", 0);
                                LogType logType = LogType.CAMERA;
                                gsy.O00000o0(logType, str2, "PushMsg", "ScenePush :" + stringExtra4 + "  " + stringExtra5);
                                intent2.putExtra("extra_device_did", stringExtra);
                                intent2.putExtra("is_v4", true);
                                if (stringExtra4.equals("motion") && longExtra > 0) {
                                    XmPluginHostApi.instance().closeCameraFloatingWindow(stringExtra);
                                    intent2.putExtra("push", true);
                                    intent2.putExtra("check", true);
                                    intent2.putExtra("is_v4", true);
                                    intent2.setClass(context2, LocalAlarmPlayerActivity.class);
                                    intent2.setFlags(67108864);
                                    intent2.addFlags(268435456);
                                    context.startActivity(intent);
                                    return;
                                } else if (stringExtra4.equals("bind_fail_need_app_unbind")) {
                                    intent2.putExtra("fail_unbind", true);
                                    intent2.setFlags(67108864);
                                    intent2.addFlags(268435456);
                                    intent2.putExtra("is_v4", true);
                                    intent2.setClass(context2, CameraPlayerNewActivity.class);
                                    context.startActivity(intent);
                                    return;
                                } else if (stringExtra4.equals("nas_error")) {
                                    intent2.putExtra("is_v4", true);
                                    intent2.setClass(context2, NASInfoActivity.class);
                                    intent2.setFlags(67108864);
                                    intent2.addFlags(268435456);
                                    context.startActivity(intent);
                                    return;
                                } else {
                                    if ("smart_camera_motion".equals(stringExtra4)) {
                                        XmPluginHostApi.instance().closeCameraFloatingWindow(stringExtra);
                                        intent2.putExtra("check", true);
                                        if (!TextUtils.isEmpty(stringExtra5)) {
                                            try {
                                                JSONObject jSONObject = new JSONObject(stringExtra5);
                                                long optLong = jSONObject.optLong("createTime");
                                                String optString = jSONObject.optString("fileId");
                                                final int optInt = jSONObject.optInt("offset");
                                                boolean optBoolean = jSONObject.optBoolean("isAlarm", true);
                                                double optDouble = jSONObject.optDouble("startDuration");
                                                intent2.putExtra("fileId", optString);
                                                intent2.putExtra("createTime", optLong);
                                                intent2.putExtra("isAlarm", optBoolean);
                                                intent2.putExtra("offset", optInt);
                                                intent2.putExtra("startDuration", optDouble);
                                                DeviceStat deviceStat3 = deviceStat2;
                                                final cid O000000o2 = cid.O000000o(deviceStat3, deviceStat3.did);
                                                final Context context3 = context;
                                                final boolean z = optBoolean;
                                                final String str5 = optString;
                                                final Intent intent4 = intent;
                                                final String str6 = str;
                                                O000000o2.O00000oo().deleteStatus(optString, optBoolean, new Callback<Boolean>() {
                                                    /* class com.xiaomi.smarthome.camera.CameraPluginNativeReceiver.AnonymousClass1 */

                                                    public void onSuccess(Boolean bool) {
                                                        if (bool.booleanValue()) {
                                                            gqg.O00000Oo(context3.getResources().getString(R.string.file_id_video_deleted));
                                                        } else {
                                                            CameraPluginNativeReceiver.this.startMarkRead(O000000o2, z, context3, str5, optInt, intent4, str6);
                                                        }
                                                    }

                                                    public void onFailure(int i, String str) {
                                                        CameraPluginNativeReceiver.this.startMarkRead(O000000o2, z, context3, str5, optInt, intent4, str6);
                                                    }
                                                });
                                                return;
                                            } catch (JSONException e) {
                                                cki.O00000oO(str4, e.toString());
                                                return;
                                            }
                                        }
                                    } else {
                                        DeviceStat deviceStat4 = deviceStat2;
                                        if ("chuangmi.camera.ipc022".equals(deviceStat4.model)) {
                                            if ("7.1".equals(stringExtra4)) {
                                                intent2.setFlags(67108864);
                                                intent2.addFlags(268435456);
                                                intent2.putExtra("is_v4", true);
                                                intent2.putExtra("pincod", false);
                                                intent2.setClass(context2, AlarmVideoActivityNew.class);
                                                context.startActivity(intent);
                                                return;
                                            } else if ("7.2".equals(stringExtra4)) {
                                                startCameraPlayer(context2, stringExtra, deviceStat4);
                                                return;
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                    break;
            }
        }
    }

    private int[] parsingEvent(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split("\\.");
            if (split.length != 2) {
                return null;
            }
            return new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])};
        } catch (Exception e) {
            cki.O00000oO("CameraPluginNativeReceiver", e.toString());
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    private void startCameraPlayer(Context context, String str, DeviceStat deviceStat) {
        XmPluginHostApi.instance().closeCameraFloatingWindow(str);
        Intent intent = new Intent();
        intent.putExtra("extra_device_did", str);
        intent.putExtra("is_v4", true);
        intent.addFlags(335544320);
        intent.setClass(context, CameraPlayerNewActivity.class);
        exz exz = exz.f15941O000000o;
        exz.O000000o(intent, deviceStat == null ? "" : deviceStat.model);
        context.startActivity(intent);
    }

    public void startMarkRead(cid cid, boolean z, Context context, String str, int i, Intent intent, String str2) {
        final boolean z2 = z;
        final Context context2 = context;
        final Intent intent2 = intent;
        final String str3 = str2;
        cid.O00000oo().markEvent(str, i, new Callback<Boolean>() {
            /* class com.xiaomi.smarthome.camera.CameraPluginNativeReceiver.AnonymousClass2 */

            public void onSuccess(Boolean bool) {
                cki.O00000o("CameraPluginNativeReceiver", "markEvent result = ".concat(String.valueOf(bool)));
                CameraPluginNativeReceiver.this.startAlarmPlayActivity(z2, context2, intent2, str3);
            }

            public void onFailure(int i, String str) {
                cki.O00000o("CameraPluginNativeReceiver", "markEvent error = " + i + " errorInfo = " + str);
                CameraPluginNativeReceiver.this.startAlarmPlayActivity(z2, context2, intent2, str3);
            }
        });
    }

    public void startAlarmPlayActivity(boolean z, Context context, Intent intent, String str) {
        if (z) {
            if (!DeviceConstant.isSupportNewAlarm(str) || ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                intent.setClass(context, AlarmVideoNormalPlayerActivity.class);
            } else {
                intent.setClass(context, AlarmVideoNormalPlayerActivityNew.class);
            }
        } else if (!DeviceConstant.isSupportNewAlarm(str) || ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            intent.setClass(context, AlarmVideoPlayerActivity.class);
        } else {
            intent.setClass(context, AlarmVideoPlayerActivityNew.class);
        }
        intent.setFlags(67108864);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }
}

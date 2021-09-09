package com.xiaomi.smarthome.device;

import _m_j.dvt;
import _m_j.eyr;
import _m_j.fdb;
import _m_j.fno;
import _m_j.foc;
import _m_j.fqs;
import _m_j.gqd;
import _m_j.gsy;
import _m_j.hzg;
import _m_j.hzj;
import _m_j.uo;
import _m_j.up;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.request.RequestFutureTarget;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.xiaomi.image.ImageLoaderOptions;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.controls.FileProvider;
import com.xiaomi.smarthome.core.entity.device.VirtualDevice;
import com.xiaomi.smarthome.core.entity.device.WatchBandDevice;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.camera.match.CameraDevice;
import com.xiaomi.smarthome.miio.device.CurtainDevice;
import com.xiaomi.smarthome.miio.device.PhoneIRDevice;
import com.xiaomi.smarthome.miio.device.SmartBulbDevice;
import com.xiaomi.smarthome.newui.MiSimpleDraweeView;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class DeviceFactory {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String[] f6946O000000o = {"xiaomi.tvbox.204", "xiaomi.tvbox.205", "xiaomi.tvbox.206", "xiaomi.tvbox.207", "xiaomi.tv.601", "xiaomi.tv.602", "xiaomi.tv.603", "xiaomi.tv.604"};
    private static Map<String, Class<?>> O00000Oo = new HashMap();

    public enum AP_TYPE {
        AP_NONE,
        AP_MIIO,
        AP_MIAP,
        AP_MIBAP,
        AP_MIDEVICE,
        AP_MIDEA_AC,
        AP_MIDEA
    }

    public static String O0000o0(String str) {
        return str == null ? "" : str;
    }

    static {
        O00000Oo.put("yunyi.camera.v1", CameraDevice.class);
        O00000Oo.put("xiaomi.curtain.v1", CurtainDevice.class);
        O00000Oo.put("xiaomi.ble.v1", BleDevice.class);
        O00000Oo.put("xiaomi.tv.v1", MiTVDevice.class);
        O00000Oo.put("xiaomi.tv.b1", MiTVDevice.class);
        O00000Oo.put("xiaomi.tv.i1", MiTVDevice.class);
        O00000Oo.put("xiaomi.tv.h1", MiTVDevice.class);
        O00000Oo.put("xiaomi.tvbox.v1", MiTVDevice.class);
        O00000Oo.put("xiaomi.tvbox.b1", MiTVDevice.class);
        O00000Oo.put("xiaomi.tvbox.i1", MiTVDevice.class);
        O00000Oo.put("xiaomi.split_tv.b1", MiTVDevice.class);
        O00000Oo.put("xiaomi.split_tv.v1", MiTVDevice.class);
        O00000Oo.put("fengmi.projector.fm15", MiTVDevice.class);
        O00000Oo.put("inovel.projector.me2", MiTVDevice.class);
        O00000Oo.put("zimi.projector.v1", MiTVDevice.class);
        O00000Oo.put("fengmi.projector.fm154k", MiTVDevice.class);
        O00000Oo.put("fengmi.projector.fm05", MiTVDevice.class);
        O00000Oo.put("xiaomi.phone_ir.t1", PhoneIRDevice.class);
        O00000Oo.put("xiaomi.phone_ir.v1", PhoneIRDevice.class);
        O00000Oo.put("yeelink.light.rgb1", SmartBulbDevice.class);
        O00000Oo.put("yeelight.rgb.v1", SmartBulbDevice.class);
        for (String put : f6946O000000o) {
            O00000Oo.put(put, MiTVDevice.class);
        }
        O00000Oo.put("hmpace.bracelet.v3nfc", WatchBandDevice.class);
    }

    public static boolean O000000o(String str) {
        return "mijia.camera.v1".equals(str) || "mijia.camera.v2".equals(str);
    }

    public static boolean O00000Oo(String str) {
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(str);
        return "mijia.camera.v1".equalsIgnoreCase(str) || str.equalsIgnoreCase("xiaomi.wifispeaker.v2") || str.equalsIgnoreCase("xiaomi.wifispeaker.v1") || str.equalsIgnoreCase("yeelink.wifispeaker.v1") || str.equalsIgnoreCase("chuangmi.camera.v6") || str.equalsIgnoreCase("xiaomi.wifispeaker.s12") || (O00000oO != null && O00000oO.O000O0OO);
    }

    public static boolean O00000o0(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("xiaomi.wifispeaker");
    }

    public static boolean O00000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.endsWith("_5G") || str.endsWith("-5G") || str.endsWith("_5g") || str.endsWith("-5g");
        }
        return false;
    }

    public static boolean O00000oO(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains("5G") || str.contains("5g")) {
            return true;
        }
        return false;
    }

    private static Class<?> O0000ooo(String str) {
        Class<?> cls = O00000Oo.get(str);
        return (cls != null || !str.startsWith("xiaomi.router") || !CoreApi.O000000o().O00000o(O0000o0(str))) ? cls : RouterDevice.class;
    }

    public static String O000000o(ScanResult scanResult) {
        boolean z;
        String str = scanResult.SSID;
        boolean z2 = false;
        if (TextUtils.isEmpty(str) || !str.startsWith("Xiaomi")) {
            z = false;
        } else {
            z = O00oOooO(str.substring(str.indexOf("Xiaomi") + 6).replace("_", ""));
        }
        if (z) {
            return "xiaomi.router.rmo15";
        }
        String str2 = scanResult.SSID;
        if (!TextUtils.isEmpty(str2) && str2.startsWith("Redmi")) {
            z2 = O00oOooO(str2.substring(str2.indexOf("Redmi") + 5).replace("_", ""));
        }
        if (z2) {
            return "xiaomi.router.rmo15";
        }
        return null;
    }

    public static boolean O00000oo(String str) {
        return !TextUtils.isEmpty(str) && CoreApi.O000000o().O00000o(str);
    }

    public static String O00000Oo(ScanResult scanResult) {
        if (scanResult != null && !TextUtils.isEmpty(scanResult.SSID)) {
            String O0000o00 = O0000o00(scanResult.SSID);
            if (TextUtils.isEmpty(O0000o00) || !CoreApi.O000000o().O00000o(O0000o00)) {
                return "none";
            }
            return O0000o00;
        }
        return "none";
    }

    public static boolean O0000O0o(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("xiaomi.router.");
    }

    public static boolean O0000OOo(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("xiaomi.repeater.");
    }

    public static AP_TYPE O00000o0(ScanResult scanResult) {
        String[] split = scanResult.BSSID.split("\\:");
        if (split.length < 4) {
            return AP_TYPE.AP_NONE;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(split[split.length - 2]);
        sb.append(split[split.length - 1]);
        int indexOf = scanResult.SSID.indexOf("_midev");
        if (indexOf <= 0 || indexOf + 5 >= scanResult.SSID.length()) {
            return AP_TYPE.AP_NONE;
        }
        return AP_TYPE.AP_MIDEVICE;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    public static String O00000o(ScanResult scanResult) {
        int indexOf;
        String str = scanResult.SSID;
        return (TextUtils.isEmpty(str) || (indexOf = str.indexOf("_midev")) <= 1) ? "" : str.substring(0, indexOf).replace('-', '.');
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    public static String O000000o(String str, String str2) {
        if (str == null) {
            return null;
        }
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(str);
        boolean z = false;
        if (O00000oO != null && O00000oO.O00000o() == 3) {
            z = true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.replace('.', '-'));
        sb.append(z ? "_mibt" : "_miap");
        sb.append(str2);
        return sb.toString();
    }

    public static AP_TYPE O00000oO(ScanResult scanResult) {
        if (scanResult == null) {
            return AP_TYPE.AP_NONE;
        }
        return O00000Oo(scanResult.SSID, scanResult.BSSID);
    }

    public static AP_TYPE O00000Oo(String str, String str2) {
        int i;
        if (str == null || str2 == null) {
            return AP_TYPE.AP_NONE;
        }
        String[] split = str2.split("\\:");
        if (split.length < 4) {
            return AP_TYPE.AP_NONE;
        }
        String str3 = split[split.length - 2] + split[split.length - 1];
        int indexOf = str.indexOf("_miio");
        if (indexOf > 0 && (i = indexOf + 5) < str.length() && str3.equalsIgnoreCase(str.substring(i))) {
            return AP_TYPE.AP_MIIO;
        }
        int indexOf2 = str.indexOf("_miap");
        if (indexOf2 > 0 && indexOf2 + 5 < str.length()) {
            return AP_TYPE.AP_MIAP;
        }
        int indexOf3 = str.indexOf("_mibt");
        if (indexOf3 > 0 && indexOf3 + 5 < str.length()) {
            return AP_TYPE.AP_MIBAP;
        }
        if (str.contains("midea_ac")) {
            return AP_TYPE.AP_MIDEA;
        }
        if (str.contains("midea_AC")) {
            return AP_TYPE.AP_MIDEA_AC;
        }
        return AP_TYPE.AP_NONE;
    }

    public static boolean O00000oo(ScanResult scanResult) {
        return O00000o0(scanResult) == AP_TYPE.AP_MIDEVICE;
    }

    public static boolean O0000O0o(ScanResult scanResult) {
        if (scanResult != null && !TextUtils.isEmpty(scanResult.SSID)) {
            String O0000Ooo = O0000Ooo(scanResult.SSID);
            eyr O00000Oo2 = eyr.O00000Oo();
            if (eyr.O000000o(O0000Ooo, O00000Oo2.O0000Ooo, O00000Oo2.O0000o00, O00000Oo2.O0000OoO)) {
                return true;
            }
        }
        return false;
    }

    public static boolean O000000o(BleDevice bleDevice) {
        if (bleDevice != null && !TextUtils.isEmpty(bleDevice.model)) {
            eyr O00000Oo2 = eyr.O00000Oo();
            if (eyr.O000000o(bleDevice.model, O00000Oo2.O0000o0O, O00000Oo2.O0000o0o, O00000Oo2.O0000o0)) {
                return true;
            }
        }
        return false;
    }

    public static boolean O0000OOo(ScanResult scanResult) {
        String O00000Oo2 = O00000Oo(scanResult);
        return !O00000Oo2.equalsIgnoreCase("other") && !O00000Oo2.equalsIgnoreCase("none");
    }

    public static boolean O0000Oo0(ScanResult scanResult) {
        return scanResult != null && O00000oO(scanResult) == AP_TYPE.AP_MIBAP;
    }

    public static boolean O00000Oo(BleDevice bleDevice) {
        if (bleDevice != null) {
            String str = bleDevice.mac;
            String str2 = bleDevice.model;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || foc.O00000Oo(str) != 1) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static String O0000Oo(ScanResult scanResult) {
        return O00000o0(scanResult.BSSID, scanResult.SSID);
    }

    public static String O00000o0(String str, String str2) {
        String replace;
        int length;
        String O0000Oo = str2 != null ? O0000Oo(str2) : null;
        return ((O0000Oo == null || O0000Oo.length() != 4) && str != null && (length = (replace = str.replace(":", "")).length()) >= 4) ? replace.substring(length - 4) : O0000Oo;
    }

    public static String O0000Oo0(String str) {
        String replace;
        int length;
        if (TextUtils.isEmpty(str) || (length = (replace = str.replace(":", "")).length()) < 4) {
            return "";
        }
        return replace.substring(length - 4);
    }

    public static String O0000Oo(String str) {
        int indexOf = str.indexOf("_miio");
        if (indexOf > 0) {
            return str.substring(indexOf + 5);
        }
        int indexOf2 = str.indexOf("_miap");
        if (indexOf2 > 0) {
            return str.substring(indexOf2 + 5);
        }
        int indexOf3 = str.indexOf("_mibt");
        if (indexOf3 > 0) {
            return str.substring(indexOf3 + 5);
        }
        int indexOf4 = str.indexOf("_midev");
        if (indexOf4 > 0) {
            return str.substring(indexOf4 + 6);
        }
        if (CoreApi.O000000o().O0000OOo(str) != null) {
            return "";
        }
        int indexOf5 = str.indexOf("midea_ac_");
        return indexOf5 >= 0 ? str.substring(indexOf5 + 9) : str;
    }

    public static String O0000OoO(ScanResult scanResult) {
        String O00000Oo2 = O00000Oo(scanResult);
        if (O00000Oo2.equals("none")) {
            O00000Oo2 = O00000o(scanResult);
        }
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(O00000Oo2);
        if (O00000oO != null) {
            return O00000oO.O0000Oo0() + O0000Oo(scanResult);
        } else if (O00000Oo2.equalsIgnoreCase("chuangmi.plug.v1")) {
            return O0000OoO("chuangmi.plug.v1") + O0000Oo(scanResult);
        } else if (O00000Oo2.equalsIgnoreCase("chuangmi.plug.v2")) {
            return O0000OoO("chuangmi.plug.v2") + O0000Oo(scanResult);
        } else if (O00000Oo2.equalsIgnoreCase("yunyi.camera.v1") || O00000Oo2.equalsIgnoreCase("yunyi.camera.v2")) {
            return O0000OoO("yunyi.camera.v1") + O0000Oo(scanResult);
        } else if (O00000Oo2.equalsIgnoreCase("zhimi.airpurifier.v1")) {
            return O0000OoO("zhimi.airpurifier.v1") + O0000Oo(scanResult);
        } else if (O00000Oo2.equalsIgnoreCase("zhimi.airpurifier.v2")) {
            return O0000OoO("zhimi.airpurifier.v2") + O0000Oo(scanResult);
        } else if (O00000Oo2.equalsIgnoreCase("zhimi.airpurifier.v3")) {
            return O0000OoO("zhimi.airpurifier.v3") + O0000Oo(scanResult);
        } else if (O00000Oo2.equalsIgnoreCase("lumi.gateway.v1")) {
            return O0000OoO("lumi.gateway.v1") + O0000Oo(scanResult);
        } else if (O00000Oo2.equalsIgnoreCase("lumi.gateway.v2")) {
            return O0000OoO("lumi.gateway.v2") + O0000Oo(scanResult);
        } else if (O00000Oo2.equalsIgnoreCase("midea.aircondition.v1")) {
            return O0000OoO("midea.aircondition.v1") + O0000Oo(scanResult);
        } else if (!O00000Oo2.equalsIgnoreCase("other")) {
            return scanResult.SSID;
        } else {
            return O0000OoO("other") + O0000Oo(scanResult);
        }
    }

    public static String O0000Ooo(ScanResult scanResult) {
        String O00000Oo2 = O00000Oo(scanResult);
        if (O00000Oo2.equals("none")) {
            O00000Oo2 = O00000o(scanResult);
        }
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(O00000Oo2);
        if (O00000oO != null) {
            return O00000oO.O0000Oo0();
        }
        if (O00000Oo2.equalsIgnoreCase("chuangmi.plug.v1")) {
            return O0000OoO("chuangmi.plug.v1");
        }
        if (O00000Oo2.equalsIgnoreCase("chuangmi.plug.v2")) {
            return O0000OoO("chuangmi.plug.v2");
        }
        if (O00000Oo2.equalsIgnoreCase("yunyi.camera.v1") || O00000Oo2.equalsIgnoreCase("yunyi.camera.v2")) {
            return O0000OoO("yunyi.camera.v1");
        }
        if (O00000Oo2.equalsIgnoreCase("zhimi.airpurifier.v1")) {
            return O0000OoO("zhimi.airpurifier.v1");
        }
        if (O00000Oo2.equalsIgnoreCase("zhimi.airpurifier.v2")) {
            return O0000OoO("zhimi.airpurifier.v2");
        }
        if (O00000Oo2.equalsIgnoreCase("zhimi.airpurifier.v3")) {
            return O0000OoO("zhimi.airpurifier.v3");
        }
        if (O00000Oo2.equalsIgnoreCase("lumi.gateway.v1")) {
            return O0000OoO("lumi.gateway.v1");
        }
        if (O00000Oo2.equalsIgnoreCase("lumi.gateway.v2")) {
            return O0000OoO("lumi.gateway.v2");
        }
        if (O00000Oo2.equalsIgnoreCase("midea.aircondition.v1")) {
            return O0000OoO("midea.aircondition.v1");
        }
        if (O00000Oo2.equalsIgnoreCase("other")) {
            return O0000OoO("other");
        }
        return scanResult.SSID;
    }

    public static String O0000OoO(String str) {
        if (str.equalsIgnoreCase("xiaomi.ir.v1")) {
            return CommonApplication.getAppContext().getString(R.string.miio_ir_name);
        }
        if (str.equalsIgnoreCase("chuangmi.plug.v1")) {
            return CommonApplication.getAppContext().getString(R.string.intelligent_plug);
        }
        if (str.equalsIgnoreCase("chuangmi.plug.v2")) {
            return CommonApplication.getAppContext().getString(R.string.intelligent_plug_simplified);
        }
        if (str.equalsIgnoreCase("zhimi.airpurifier.v1")) {
            return CommonApplication.getAppContext().getString(R.string.air_purifier);
        }
        if (str.equalsIgnoreCase("lumi.gateway.v1")) {
            return CommonApplication.getAppContext().getString(R.string.gateway_main_title);
        }
        if (str.equalsIgnoreCase("lumi.gateway.v2")) {
            return CommonApplication.getAppContext().getString(R.string.gateway_main_title);
        }
        if (str.equalsIgnoreCase("lumi.sensor_motion.v1")) {
            return CommonApplication.getAppContext().getString(R.string.gateway_motion_name);
        }
        if (str.equalsIgnoreCase("lumi.sensor_switch.v1")) {
            return CommonApplication.getAppContext().getString(R.string.gateway_switch_name);
        }
        if (str.equalsIgnoreCase("lumi.sensor_magnet.v1")) {
            return CommonApplication.getAppContext().getString(R.string.gateway_magnet_name);
        }
        if (str.equalsIgnoreCase("lumi.sensor_switch.v2")) {
            return CommonApplication.getAppContext().getString(R.string.gateway_switch_name);
        }
        if (str.equalsIgnoreCase("lumi.sensor_magnet.v2")) {
            return CommonApplication.getAppContext().getString(R.string.gateway_magnet_name);
        }
        if (str.equalsIgnoreCase("other")) {
            return CommonApplication.getAppContext().getString(R.string.other_device);
        }
        if (str.equalsIgnoreCase("xiaomi.myphone.v1")) {
            return CommonApplication.getAppContext().getString(R.string.my_phone_name);
        }
        if (str.equalsIgnoreCase("xiaomi.phone_ir.t1")) {
            return CommonApplication.getAppContext().getString(R.string.my_phone_ir_name);
        }
        if (str.equalsIgnoreCase("xiaomi.phone_ir.v1")) {
            return CommonApplication.getAppContext().getString(R.string.my_phone_ir_name);
        }
        if (str.equalsIgnoreCase("midea.aircondition.v1")) {
            return CommonApplication.getAppContext().getString(R.string.midea_aircondition);
        }
        if (str.equalsIgnoreCase("xiaomi.ble.v1")) {
            return CommonApplication.getAppContext().getString(R.string.mi_band);
        }
        if (str.equalsIgnoreCase("other")) {
            return CommonApplication.getAppContext().getString(R.string.app_name2);
        }
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(str);
        return O00000oO != null ? O00000oO.O0000Oo0() : "";
    }

    private static boolean O00oOooO(String str) {
        if (str.length() != 8) {
            return false;
        }
        String upperCase = str.toUpperCase();
        int i = 0;
        while (i < 4) {
            try {
                if (Integer.parseInt(String.valueOf(upperCase.charAt(i)), 16) + Integer.parseInt(String.valueOf(upperCase.charAt(i + 4)), 16) != 15) {
                    return false;
                }
                i++;
            } catch (Exception unused) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    public static String O0000Ooo(String str) {
        int indexOf = str.indexOf("_miio");
        if (indexOf > 1) {
            return str.substring(0, indexOf).replace('-', '.');
        }
        int indexOf2 = str.indexOf("_miap");
        if (indexOf2 > 1) {
            return str.substring(0, indexOf2).replace('-', '.');
        }
        int indexOf3 = str.indexOf("_mibt");
        if (indexOf3 > 1) {
            return str.substring(0, indexOf3).replace('-', '.');
        }
        int indexOf4 = str.indexOf("_midev");
        if (indexOf4 > 1) {
            return str.substring(0, indexOf4).replace('-', '.');
        }
        return (str.contains("midea_AC") || str.contains("midea_ac")) ? "midea.aircondition.v1" : str;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    public static String O0000o00(String str) {
        int indexOf = str.indexOf("_miio");
        if (indexOf > 1) {
            return str.substring(0, indexOf).replace('-', '.');
        }
        int indexOf2 = str.indexOf("_miap");
        if (indexOf2 > 1) {
            return str.substring(0, indexOf2).replace('-', '.');
        }
        int indexOf3 = str.indexOf("_mibt");
        if (indexOf3 > 1) {
            return str.substring(0, indexOf3).replace('-', '.');
        }
        int indexOf4 = str.indexOf("_midev");
        if (indexOf4 > 1) {
            return str.substring(0, indexOf4).replace('-', '.');
        }
        return (str.contains("midea_AC") || str.contains("midea_ac")) ? "midea.aircondition.v1" : "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f A[RETURN] */
    public static Device O0000o0O(String str) {
        Class<?> O0000ooo = O0000ooo(O0000o0(str));
        Device device = null;
        if (O0000ooo != null) {
            try {
                Device device2 = (Device) fdb.O000000o(O0000ooo, new Object[0]);
                try {
                    device2.model = str;
                    device2.isOnline = true;
                    O00000o(device2);
                    return device2;
                } catch (Exception e) {
                    Exception exc = e;
                    device = device2;
                    e = exc;
                    Log.e("DeviceFactory", "fatal", e);
                    if (!CoreApi.O000000o().O00000o(str)) {
                    }
                }
            } catch (Exception e2) {
                e = e2;
                Log.e("DeviceFactory", "fatal", e);
                if (!CoreApi.O000000o().O00000o(str)) {
                }
            }
        }
        if (!CoreApi.O000000o().O00000o(str)) {
            return device;
        }
        MiioDeviceV2 miioDeviceV2 = new MiioDeviceV2();
        miioDeviceV2.model = str;
        O00000o(miioDeviceV2);
        return miioDeviceV2;
    }

    public static Device O000000o(JSONObject jSONObject) {
        String optString = jSONObject.optString("did");
        Device O000000o2 = fno.O000000o().O000000o(optString);
        String optString2 = jSONObject.optString("model");
        if (O000000o2 == null) {
            O000000o2 = fno.O000000o().O00000Oo(optString);
        }
        if (O000000o2 == null) {
            Class<?> O0000ooo = O0000ooo(O0000o0(jSONObject.optString("model")));
            if (O0000ooo != null) {
                try {
                    O000000o2 = (Device) fdb.O000000o(O0000ooo, new Object[0]);
                } catch (Exception e) {
                    Log.e("DeviceFactory", "fatal", e);
                }
            } else if (CoreApi.O000000o().O00000o(O0000o0(jSONObject.optString("model"))) || "yeelink.uwb.tag1".equalsIgnoreCase(optString2)) {
                O000000o2 = new MiioDeviceV2();
                O000000o2.model = O0000o0(jSONObject.optString("model"));
            }
        }
        if (O000000o2 == null) {
            return null;
        }
        O000000o2.did = jSONObject.optString("did");
        O000000o2.model = jSONObject.optString("model");
        O000000o2.name = jSONObject.optString("name");
        O000000o2.pid = jSONObject.optInt("pid");
        O000000o2.permitLevel = jSONObject.optInt("permitLevel");
        O000000o2.resetFlag = jSONObject.optInt("resetFlag");
        O000000o2.rssi = jSONObject.optInt("rssi", 0);
        if (!O000000o2.isBinded()) {
            O000000o2.token = "";
        } else {
            O000000o2.token = jSONObject.optString("token");
        }
        O000000o2.ip = jSONObject.optString("localip");
        O000000o2.latitude = jSONObject.optDouble("latitude");
        O000000o2.longitude = jSONObject.optDouble("longitude");
        O000000o2.ssid = jSONObject.optString("ssid");
        O000000o2.bssid = jSONObject.optString("bssid");
        O000000o2.showMode = jSONObject.optInt("show_mode");
        O000000o2.hideMode = jSONObject.optInt("hide_mode");
        O000000o2.propInfo = jSONObject.optJSONObject("prop");
        if (!jSONObject.isNull("method")) {
            O000000o2.method = jSONObject.optJSONArray("method");
        }
        O000000o2.mac = jSONObject.optString("mac");
        O000000o2.parentModel = jSONObject.optString("parent_model");
        O000000o2.parentId = jSONObject.optString("parent_id");
        O000000o2.isOnline = jSONObject.optBoolean("isOnline");
        O000000o2.desc = jSONObject.optString("desc");
        O000000o2.specUrn = jSONObject.optString("spec_type");
        O000000o2.voiceCtrl = (byte) jSONObject.optInt("voice_ctrl");
        if (O000000o2.pid == Device.PID_VIRTUAL_DEVICE) {
            O000000o2.canUseNotBind = true;
            O000000o2.isOnline = true;
        }
        O000000o2.freqFlag = jSONObject.optBoolean("freqFlag", true);
        O000000o2.comFlag = jSONObject.optInt("comFlag", 0);
        JSONObject optJSONObject = jSONObject.optJSONObject("owner");
        if (optJSONObject != null) {
            O000000o2.ownerName = optJSONObject.optString("nickname");
            O000000o2.ownerId = optJSONObject.optString("userid");
            if (TextUtils.isEmpty(O000000o2.ownerName)) {
                O000000o2.ownerName = O000000o2.ownerId;
            }
        }
        O000000o2.parseProp();
        O000000o2.initialLocal();
        O00000o(O000000o2);
        if (!jSONObject.isNull("extra")) {
            O000000o2.parseExtra(jSONObject.optString("extra"));
            O000000o2.extra = jSONObject.optString("extra");
        }
        if (!jSONObject.isNull("event")) {
            O000000o2.event = jSONObject.optString("event");
            O000000o2.parseEvent(O000000o2.event);
        }
        if (O000000o2.extra != null && (O000000o2 instanceof MiioDeviceV2)) {
            try {
                JSONObject jSONObject2 = new JSONObject(O000000o2.extra);
                if (jSONObject2.has("fw_version")) {
                    ((MiioDeviceV2) O000000o2).mFwVersion = jSONObject2.getString("fw_version");
                }
                if (jSONObject2.has("mcu_version")) {
                    ((MiioDeviceV2) O000000o2).mMcuVersion = jSONObject2.getString("mcu_version");
                }
            } catch (JSONException unused) {
            }
        }
        return O000000o2;
    }

    public static Device O000000o(Device device) {
        if (device == null) {
            return null;
        }
        Device O0000OOo = fno.O000000o().O0000OOo(device.getDid());
        if (O0000OOo == null && CoreApi.O000000o().O00000oo(device.getModel()) != null) {
            if (device instanceof WatchBandDevice) {
                O0000OOo = new WatchBandDevice();
            } else if (device.getPid() == Device.PID_BLUETOOTH) {
                O0000OOo = BleDevice.O000000o(device.getMac());
            } else if (device.getPid() == Device.PID_BLE_MESH) {
                O0000OOo = new BleMeshDevice();
            } else {
                O0000OOo = new MiioDeviceV2();
            }
            O0000OOo.model = O0000o0(device.getModel());
        }
        if (O0000OOo == null) {
            return null;
        }
        O000000o(O0000OOo, device);
        return O0000OOo;
    }

    public static Device O00000Oo(Device device) {
        Device device2;
        if (device == null) {
            return null;
        }
        if (!(device instanceof VirtualDevice)) {
            Device O000000o2 = fno.O000000o().O000000o(device.getDid());
            if (O000000o2 == null) {
                O000000o2 = fno.O000000o().O00000Oo(device.getDid());
            }
            if (device2 == null) {
                Class<?> O0000ooo = O0000ooo(O0000o0(device.getModel()));
                if (O0000ooo != null) {
                    try {
                        device2 = (Device) fdb.O000000o(O0000ooo, new Object[0]);
                    } catch (Exception e) {
                        gsy.O00000o0(LogType.DEVICE_LIST, "DeviceFactory", "fatal", e.getMessage());
                    }
                } else if (CoreApi.O000000o().O00000o(O0000o0(device.getModel()))) {
                    if (device instanceof WatchBandDevice) {
                        device2 = new WatchBandDevice();
                    } else if (device.getPid() == Device.PID_BLUETOOTH) {
                        device2 = BleDevice.O000000o(device.getMac());
                    } else if (device.getPid() == Device.PID_BLE_MESH) {
                        device2 = new BleMeshDevice();
                    } else {
                        device2 = new MiioDeviceV2();
                    }
                    device2.model = O0000o0(device.getModel());
                }
            }
            if (device2 == null) {
                return null;
            }
            O000000o(device2, device);
            return device2;
        } else if (device == null || TextUtils.isEmpty(device.getModel()) || !CoreApi.O000000o().O00000o(device.getModel())) {
            return null;
        } else {
            MiioVirtualDevice miioVirtualDevice = new MiioVirtualDevice();
            miioVirtualDevice.setOwner(true);
            miioVirtualDevice.model = device.getModel();
            miioVirtualDevice.did = device.getModel();
            miioVirtualDevice.desc = ((VirtualDevice) device).O000000o();
            miioVirtualDevice.pid = 24685;
            O00000o(miioVirtualDevice);
            return miioVirtualDevice;
        }
    }

    public static Device O00000o0(Device device) {
        Device device2 = null;
        if (device == null) {
            return null;
        }
        Class<?> O0000ooo = O0000ooo(O0000o0(device.getModel()));
        if (O0000ooo != null) {
            try {
                device2 = (Device) fdb.O000000o(O0000ooo, new Object[0]);
            } catch (Exception e) {
                gsy.O00000o0(LogType.DEVICE_LIST, "DeviceFactory", "fatal", e.getMessage());
            }
        } else if (CoreApi.O000000o().O00000o(O0000o0(device.getModel()))) {
            if (device instanceof WatchBandDevice) {
                device2 = new WatchBandDevice();
            } else if (device.getPid() == Device.PID_BLUETOOTH) {
                device2 = new BleDevice();
            } else if (device.getPid() == Device.PID_BLE_MESH) {
                device2 = new BleMeshDevice();
            } else {
                device2 = new MiioDeviceV2();
            }
            device2.model = O0000o0(device.getModel());
        }
        if (device2 != null) {
            O000000o(device2, device);
        }
        return device2;
    }

    public static void O000000o(Device device, Device device2) {
        device.did = device2.getDid();
        device.model = device2.getModel();
        device.name = device2.getName();
        device.pid = device2.getPid();
        device.permitLevel = device2.getPermitLevel();
        device.resetFlag = device2.getResetFlag();
        device.rssi = device2.getRssi();
        if (!device.isBinded()) {
            device.token = "";
        } else {
            device.token = device2.getToken();
        }
        device.ip = device2.getLocalIP();
        device.latitude = device2.getLatitude();
        device.longitude = device2.getLongitude();
        device.ssid = device2.getSsid();
        device.bssid = device2.getBssid();
        device.showMode = device2.getShowMode();
        device.hideMode = device2.getHideMode();
        device.isSetPinCode = device2.isSetPinCode();
        device.setPinCodeType(device2.getPinCodeType());
        device.desc = device2.getDesc();
        device.specUrn = device2.getSpecUrn();
        device.voiceCtrl = device2.getVoiceCtrl();
        device.freqFlag = device2.getFreqFlag();
        device.comFlag = device2.getComFlag();
        if (device2.getLocation() == Device.Location.LOCAL) {
            device.location = Device.Location.LOCAL;
        } else {
            device.location = Device.Location.REMOTE;
        }
        if (TextUtils.isEmpty(device2.getPropInfo())) {
            device.propInfo = null;
        } else {
            try {
                device.propInfo = new JSONObject(device2.getPropInfo());
            } catch (JSONException unused) {
            }
        }
        if (!TextUtils.isEmpty(device2.getMethodInfo())) {
            try {
                device.method = new JSONArray(device2.getMethodInfo());
            } catch (JSONException unused2) {
            }
        }
        device.mac = device2.getMac();
        device.parentModel = device2.getParentModel();
        device.parentId = device2.getParentId();
        device.isOnline = device2.isOnline();
        if (device2.getPid() == Device.PID_BLUETOOTH) {
            device.isOnline = true;
        }
        if (device.pid == Device.PID_VIRTUAL_DEVICE) {
            device.canUseNotBind = true;
            device.isOnline = true;
        } else {
            device.desc = device2.getDesc();
        }
        device.ownerName = device2.getOwnerName();
        device.ownerId = device2.getOwnerId();
        if (TextUtils.isEmpty(device.ownerName)) {
            device.ownerName = device.ownerId;
        }
        device.parseProp();
        O00000o(device);
        if (!TextUtils.isEmpty(device2.getExtraInfo())) {
            device.parseExtra(device2.getExtraInfo());
            device.extra = device2.getExtraInfo();
        }
        if (!TextUtils.isEmpty(device2.getEventInfo())) {
            device.event = device2.getEventInfo();
            device.parseEvent(device.event);
        }
        device.descNew = device2.getDescNew();
        device.descTimeJString = device2.getmDescTimeJString();
        if (device.extra != null && (device instanceof MiioDeviceV2)) {
            try {
                JSONObject jSONObject = new JSONObject(device.extra);
                if (jSONObject.has("fw_version")) {
                    ((MiioDeviceV2) device).mFwVersion = jSONObject.getString("fw_version");
                }
                if (jSONObject.has("mcu_version")) {
                    ((MiioDeviceV2) device).mMcuVersion = jSONObject.getString("mcu_version");
                }
            } catch (JSONException unused3) {
            }
        }
        device.orderTimeJString = device2.getOrderTimeJString();
        device.version = device2.getVersion();
        if (device instanceof BleDevice) {
            ((BleDevice) device).isNetGateConnected = device2.isOnline();
        }
    }

    public static boolean O00000o(String str, String str2) {
        return str != null && str.equalsIgnoreCase(str2);
    }

    public static boolean O000000o(String str, String[] strArr) {
        String O00oOooo = O00oOooo(str);
        if (O00oOooo == null) {
            return false;
        }
        for (String O00oOooo2 : strArr) {
            String O00oOooo3 = O00oOooo(O00oOooo2);
            if (!TextUtils.isEmpty(O00oOooo3) && O00oOooo3.equalsIgnoreCase(O00oOooo)) {
                return true;
            }
        }
        return false;
    }

    private static String O00oOooo(String str) {
        Pattern compile = Pattern.compile("[^0-9]+");
        String[] split = str.split("\\.");
        if (split.length != 3) {
            return null;
        }
        Matcher matcher = compile.matcher(split[2]);
        String group = matcher.find() ? matcher.group() : "";
        return split[0] + split[1] + group;
    }

    public static String O0000o0o(String str) {
        PluginDeviceInfo O00000oo;
        if (str == null) {
            return null;
        }
        if (CoreApi.O000000o().O00000o(str)) {
            PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(str);
            if (O00000oO != null) {
                return O00000oO.O0000o0();
            }
        } else {
            hzg O000000o2 = hzj.O000000o();
            if (!(O000000o2 == null || !O000000o2.isTagType(str) || (O00000oo = CoreApi.O000000o().O00000oo(str)) == null)) {
                return O00000oo.O0000o0();
            }
        }
        return null;
    }

    public static String O0000o(String str) {
        PluginDeviceInfo O00000oO;
        if (str == null || !CoreApi.O000000o().O00000o(str) || (O00000oO = CoreApi.O000000o().O00000oO(str)) == null) {
            return null;
        }
        return O00000oO.O0000o0();
    }

    private static void O00000o(Device device) {
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(device.model);
        if (O00000oO != null) {
            if (TextUtils.isEmpty(device.name)) {
                device.name = O00000oO.O0000Oo0();
            }
        } else if (O00000o(device.model, "xiaomi.ir.v1")) {
            if (TextUtils.isEmpty(device.name)) {
                device.name = O0000OoO("xiaomi.ir.v1");
            }
        } else if (O00000o(device.model, "chuangmi.plug.v1")) {
            if (TextUtils.isEmpty(device.name)) {
                device.name = O0000OoO("chuangmi.plug.v1");
            }
        } else if (O00000o(device.model, "chuangmi.plug.v2")) {
            if (TextUtils.isEmpty(device.name)) {
                device.name = O0000OoO("chuangmi.plug.v2");
            }
        } else if (O00000o(device.model, "zhimi.airpurifier.v1")) {
            if (TextUtils.isEmpty(device.name)) {
                device.name = O0000OoO("zhimi.airpurifier.v1");
            }
        } else if (O00000o(device.model, "zhimi.airpurifier.v2")) {
            if (TextUtils.isEmpty(device.name)) {
                device.name = O0000OoO("zhimi.airpurifier.v2");
            }
        } else if (O00000o(device.model, "zhimi.airpurifier.v3")) {
            if (TextUtils.isEmpty(device.name)) {
                device.name = O0000OoO("zhimi.airpurifier.v3");
            }
        } else if (O00000o(device.model, "lumi.gateway.v1")) {
            if (TextUtils.isEmpty(device.name)) {
                device.name = O0000OoO("lumi.gateway.v1");
            }
        } else if (O00000o(device.model, "lumi.gateway.v2")) {
            if (TextUtils.isEmpty(device.name)) {
                device.name = O0000OoO("lumi.gateway.v2");
            }
        } else if (O00000o(device.model, "lumi.sensor_motion.v1")) {
            if (TextUtils.isEmpty(device.name)) {
                device.name = O0000OoO("lumi.sensor_motion.v1");
            }
        } else if (O00000o(device.model, "lumi.sensor_switch.v1")) {
            if (TextUtils.isEmpty(device.name)) {
                device.name = O0000OoO("lumi.sensor_switch.v1");
            }
        } else if (O00000o(device.model, "lumi.sensor_magnet.v1")) {
            if (TextUtils.isEmpty(device.name)) {
                device.name = O0000OoO("lumi.sensor_magnet.v1");
            }
        } else if (O00000o(device.model, "midea.aircondition.v1")) {
            if (TextUtils.isEmpty(device.name)) {
                device.name = O0000OoO("midea.aircondition.v1");
            }
        } else if (O00000o(device.model, "chuangmi.ir.v2")) {
            if (TextUtils.isEmpty(device.name)) {
                device.name = O0000OoO("chuangmi.ir.v2");
            }
        } else if (O00000o(device.model, "xiaomi.phone_ir.t1")) {
            if (TextUtils.isEmpty(device.name)) {
                device.name = O0000OoO("xiaomi.phone_ir.t1");
            }
        } else if (O00000o(device.model, "xiaomi.phone_ir.v1") && TextUtils.isEmpty(device.name)) {
            device.name = O0000OoO("xiaomi.phone_ir.v1");
        }
    }

    public static boolean O00000oO(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static int O0000oO0(String str) {
        if (str == null) {
            return 0;
        }
        if (str.equalsIgnoreCase("yunyi.camera.v1") || str.equalsIgnoreCase("yunyi.camera.v2")) {
            return R.drawable.launcher_camera;
        }
        if (str.equalsIgnoreCase("chuangmi.plug.v1") || str.equalsIgnoreCase("chuangmi.plug.v2")) {
            return R.drawable.launcher_plug;
        }
        if (str.equalsIgnoreCase("yunmi.waterpurifier.v2")) {
            return R.drawable.launcher_waterpurifier;
        }
        if (str.equalsIgnoreCase("zhimi.airpurifier.v1") || str.equalsIgnoreCase("zhimi.airpurifier.v2") || str.equalsIgnoreCase("zhimi.airpurifier.v3")) {
            return R.drawable.launcher_airpurifier;
        }
        if (str.equalsIgnoreCase("other")) {
        }
        return 0;
    }

    public static Device O00000oo(String str, String str2) {
        Device O000000o2 = fno.O000000o().O000000o(str);
        if (O000000o2 != null) {
            return O000000o2;
        }
        Class<?> O0000ooo = O0000ooo(O0000o0(str2));
        if (O0000ooo != null) {
            try {
                Device device = (Device) fdb.O000000o(O0000ooo, new Object[0]);
                try {
                    device.model = O0000o0(str2);
                    return device;
                } catch (Exception e) {
                    e = e;
                    O000000o2 = device;
                    Log.e("DeviceFactory", "fatal", e);
                    return O000000o2;
                }
            } catch (Exception e2) {
                e = e2;
                Log.e("DeviceFactory", "fatal", e);
                return O000000o2;
            }
        } else if (!CoreApi.O000000o().O00000o(O0000o0(str2))) {
            return O000000o2;
        } else {
            MiioDeviceV2 miioDeviceV2 = new MiioDeviceV2();
            miioDeviceV2.model = O0000o0(str2);
            O00000o(miioDeviceV2);
            return miioDeviceV2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0057 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0058 A[SYNTHETIC, Splitter:B:14:0x0058] */
    public static Icon O0000oO(String str) {
        String str2;
        File file;
        File file2;
        try {
            str2 = O0000o0o(str);
            try {
                Context appContext = CommonApplication.getAppContext();
                up O00000Oo2 = uo.O000000o(appContext).O00000Oo();
                O00000Oo2.f2542O000000o = str2;
                ImageLoaderOptions imageLoaderOptions = new ImageLoaderOptions(null, O00000Oo2.f2542O000000o);
                dvt.O000000o();
                Uri O000000o2 = dvt.O000000o(imageLoaderOptions);
                if (O000000o2 != null) {
                    BinaryResource resource = ImagePipelineFactory.getInstance().getMainFileCache().getResource(DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(ImageRequestBuilder.newBuilderWithSource(O000000o2).build(), null));
                    if (resource != null) {
                        file2 = ((FileBinaryResource) resource).getFile();
                        file = (File) new RequestFutureTarget(file2).get();
                        if (file != null) {
                            return null;
                        }
                        try {
                            return Icon.createWithContentUri(FileProvider.getUriForFile(appContext, appContext.getPackageName() + ".export.fileprovider", file));
                        } catch (Exception e) {
                            e = e;
                            gsy.O00000o0(LogType.CARD, "DeviceFactory", "getDeviceIcon", "icon:" + str2 + " file:" + file + "error:" + Log.getStackTraceString(e));
                            return null;
                        }
                    }
                }
                file2 = null;
                file = (File) new RequestFutureTarget(file2).get();
                if (file != null) {
                }
            } catch (Exception e2) {
                e = e2;
                file = null;
                gsy.O00000o0(LogType.CARD, "DeviceFactory", "getDeviceIcon", "icon:" + str2 + " file:" + file + "error:" + Log.getStackTraceString(e));
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = null;
            file = null;
            gsy.O00000o0(LogType.CARD, "DeviceFactory", "getDeviceIcon", "icon:" + str2 + " file:" + file + "error:" + Log.getStackTraceString(e));
            return null;
        }
    }

    public static void O000000o(String str, SimpleDraweeView simpleDraweeView, int i) {
        if (simpleDraweeView instanceof MiSimpleDraweeView) {
            MiSimpleDraweeView miSimpleDraweeView = (MiSimpleDraweeView) simpleDraweeView;
            if (!TextUtils.equals(miSimpleDraweeView.model, str)) {
                miSimpleDraweeView.model = str;
            } else {
                return;
            }
        }
        if (i == 0) {
            i = R.drawable.device_list_phone_no;
        }
        final String O0000o0o = O0000o0o(str);
        if (simpleDraweeView.getHierarchy() == null) {
            simpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(simpleDraweeView.getResources()).setFadeDuration(200).setPlaceholderImage(simpleDraweeView.getResources().getDrawable(i)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
        }
        if (TextUtils.isEmpty(O0000o0o) || !O0000o0o.startsWith("http")) {
            int O000000o2 = fqs.O000000o(str);
            if (O000000o2 != 0) {
                simpleDraweeView.setImageURI(gqd.O000000o(O000000o2));
            } else {
                simpleDraweeView.setImageURI(gqd.O000000o(i));
            }
        } else {
            simpleDraweeView.setImageURI(Uri.parse(O0000o0o));
            DraweeController controller = simpleDraweeView.getController();
            if (controller != null && (controller instanceof AbstractDraweeController)) {
                ((AbstractDraweeController) controller).addControllerListener(new BaseControllerListener() {
                    /* class com.xiaomi.smarthome.device.DeviceFactory.AnonymousClass1 */

                    public final void onFailure(String str, Throwable th) {
                        gsy.O000000o(6, "Failure", str + " decode failed");
                        Fresco.getImagePipeline().evictFromMemoryCache(Uri.parse(O0000o0o));
                        Fresco.getImagePipeline().evictFromDiskCache(Uri.parse(O0000o0o));
                    }
                });
            }
        }
    }

    public static void O000000o(final String str, SimpleDraweeView simpleDraweeView) {
        if (simpleDraweeView.getHierarchy() == null) {
            simpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(simpleDraweeView.getResources()).setFadeDuration(0).setPlaceholderImage(simpleDraweeView.getResources().getDrawable(R.drawable.device_list_phone_no)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
        }
        if (TextUtils.isEmpty(str) || !str.startsWith("http")) {
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.device_list_phone_no));
            return;
        }
        simpleDraweeView.setImageURI(Uri.parse(str));
        DraweeController controller = simpleDraweeView.getController();
        if (controller != null && (controller instanceof AbstractDraweeController)) {
            ((AbstractDraweeController) controller).addControllerListener(new BaseControllerListener() {
                /* class com.xiaomi.smarthome.device.DeviceFactory.AnonymousClass2 */

                public final void onFailure(String str, Throwable th) {
                    gsy.O000000o(6, "Failure", str + " decode failed");
                    Fresco.getImagePipeline().evictFromMemoryCache(Uri.parse(str));
                    Fresco.getImagePipeline().evictFromDiskCache(Uri.parse(str));
                }
            });
        }
    }

    public static void O000000o(SimpleDraweeView simpleDraweeView, final String str, int i) {
        if (i == 0) {
            i = R.drawable.device_list_phone_no;
        }
        if (simpleDraweeView.getHierarchy() == null) {
            simpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(simpleDraweeView.getResources()).setFadeDuration(200).setPlaceholderImage(simpleDraweeView.getResources().getDrawable(i)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build());
        }
        if (TextUtils.isEmpty(str) || !str.startsWith("http")) {
            simpleDraweeView.setBackgroundResource(i);
            return;
        }
        simpleDraweeView.setImageURI(Uri.parse(str));
        DraweeController controller = simpleDraweeView.getController();
        if (controller != null && (controller instanceof AbstractDraweeController)) {
            ((AbstractDraweeController) controller).addControllerListener(new BaseControllerListener() {
                /* class com.xiaomi.smarthome.device.DeviceFactory.AnonymousClass3 */

                public final void onFailure(String str, Throwable th) {
                    gsy.O000000o(6, "Failure", str + " decode failed");
                    Fresco.getImagePipeline().evictFromMemoryCache(Uri.parse(str));
                    Fresco.getImagePipeline().evictFromDiskCache(Uri.parse(str));
                }
            });
        }
    }

    public static void O00000Oo(String str, SimpleDraweeView simpleDraweeView) {
        O000000o(str, simpleDraweeView, 0);
    }

    public static String O0000oOO(String str) {
        String O0000o0o = O0000o0o(str);
        if (!TextUtils.isEmpty(O0000o0o)) {
            return (O0000o0o.startsWith("http://") || O0000o0o.startsWith("https://")) ? O0000o0o : "";
        }
        return "";
    }

    public static void O00000o0(String str, SimpleDraweeView simpleDraweeView) {
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(str);
        String O0000Oo = O00000oO != null ? O00000oO.O0000Oo() : "";
        if (simpleDraweeView.getHierarchy() == null) {
            simpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(simpleDraweeView.getResources()).setFadeDuration(200).setPlaceholderImage(simpleDraweeView.getResources().getDrawable(R.drawable.device_list_phone_no)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
        }
        if (TextUtils.isEmpty(O0000Oo) || !O0000Oo.startsWith("http")) {
            int O000000o2 = fqs.O000000o(str);
            if (str.equalsIgnoreCase("xiaomi.ble.v1")) {
                O000000o2 = R.drawable.std_ring_virtual;
            } else if (str.equalsIgnoreCase("yeelink.light.rgb1") || str.equalsIgnoreCase("yeelight.rgb.v1")) {
                O000000o2 = R.drawable.std_yeelight_dangle;
            }
            if (O000000o2 != 0) {
                simpleDraweeView.setImageURI(gqd.O000000o(O000000o2));
            } else {
                simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.device_list_phone_no));
            }
        } else {
            simpleDraweeView.setImageURI(Uri.parse(O0000Oo));
        }
    }

    public static int O0000oOo(String str) {
        int O000000o2 = fqs.O000000o(str);
        if (str.equalsIgnoreCase("xiaomi.ble.v1")) {
            return R.drawable.std_ring_virtual;
        }
        return (str.equalsIgnoreCase("yeelink.light.rgb1") || str.equalsIgnoreCase("yeelight.rgb.v1")) ? R.drawable.std_yeelight_dangle : O000000o2;
    }

    public static boolean O0000O0o(String str, String str2) {
        int lastIndexOf;
        if (str == null || str2 == null || str.isEmpty() || str2.isEmpty() || (lastIndexOf = str.lastIndexOf(".")) <= 0) {
            return false;
        }
        return str2.startsWith(str.substring(0, lastIndexOf));
    }

    public static boolean O0000oo0(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("xiaoxun.watch");
    }

    public static String O0000oo(String str) {
        String[] split = str.split(":");
        if (split.length <= 0 || !split[0].equalsIgnoreCase("00")) {
            try {
                split[0] = Integer.toHexString(Integer.parseInt(split[0], 16) - Integer.parseInt("02", 16));
                if (split[0].length() == 1) {
                    split[0] = "0" + split[0];
                }
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        } else {
            split[0] = "FE";
        }
        return new StringBuilder(str).replace(0, 2, split[0]).toString();
    }

    public static String O0000ooO(String str) {
        String[] split = str.split(":");
        if (split.length <= 0 || !split[0].equalsIgnoreCase("00")) {
            try {
                split[0] = Integer.toHexString(Integer.parseInt(split[0], 16) + Integer.parseInt("02", 16));
                if (split[0].length() == 1) {
                    split[0] = "0" + split[0];
                }
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        } else {
            split[0] = "FE";
        }
        return new StringBuilder(str).replace(0, 2, split[0]).toString();
    }

    public static boolean O0000OOo(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (TextUtils.equals(str, str2)) {
                return true;
            }
            PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(str);
            PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(str2);
            if (O00000oO == null || O00000oO2 == null || O00000oO.O0000oo0 != O00000oO2.O0000oo0) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static void O000000o(Device device, SimpleDraweeView simpleDraweeView, BasePostprocessor basePostprocessor) {
        String str;
        final Uri uri;
        if (device == null) {
            str = null;
        } else if (device instanceof MiTVDevice) {
            MiTVDevice miTVDevice = (MiTVDevice) device;
            String str2 = miTVDevice.model;
            if (miTVDevice.mPlatformId > 0) {
                if (miTVDevice.mPlatformId < 600) {
                    str2 = "xiaomi.tvbox.v" + miTVDevice.mPlatformId;
                } else {
                    str2 = "xiaomi.tv.v" + miTVDevice.mPlatformId;
                }
            }
            str = O0000o0o(str2);
            if (TextUtils.isEmpty(str)) {
                str = O0000o0o(device.model);
            }
        } else {
            str = O0000o0o(device.model);
        }
        if (simpleDraweeView.getHierarchy() == null) {
            simpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(simpleDraweeView.getResources()).setFadeDuration(200).setPlaceholderImage(simpleDraweeView.getResources().getDrawable(R.drawable.device_list_phone_no)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
        }
        if (TextUtils.isEmpty(str) || !str.startsWith("http")) {
            int O000000o2 = fqs.O000000o(device.model);
            if (O000000o2 != 0) {
                uri = gqd.O000000o(O000000o2);
            } else {
                uri = gqd.O000000o((int) R.drawable.device_list_phone_no);
            }
        } else {
            uri = Uri.parse(str);
        }
        simpleDraweeView.setController((PipelineDraweeController) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setImageRequest(ImageRequestBuilder.newBuilderWithSource(uri).setPostprocessor(basePostprocessor).build())).setOldController(simpleDraweeView.getController())).setControllerListener(new BaseControllerListener() {
            /* class com.xiaomi.smarthome.device.DeviceFactory.AnonymousClass4 */

            public final void onFailure(String str, Throwable th) {
                gsy.O000000o(6, "Failure", str + " decode failed");
                Fresco.getImagePipeline().evictFromMemoryCache(uri);
                Fresco.getImagePipeline().evictFromDiskCache(uri);
            }
        })).build());
    }
}

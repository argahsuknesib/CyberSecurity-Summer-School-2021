package _m_j;

import android.util.Log;
import com.xiaomi.smarthome.core.entity.device.MiTVDevice;
import com.xiaomi.smarthome.core.entity.device.MiioDevice;
import com.xiaomi.smarthome.core.entity.device.RouterDevice;
import com.xiaomi.smarthome.core.entity.device.WatchBandDevice;
import com.xiaomi.smarthome.core.server.internal.device.DeviceRecord;
import com.xiaomi.smarthome.device.Device;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class fjb {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String[] f16441O000000o = {"xiaomi.watch.band1", "xiaomi.watch.band1S", "xiaomi.watch.band1A", "xiaomi.watch.band2", "hmpace.scales.mibfs", "hmpace.scales.miscale2", "trios.bleshoes.v1", "hmpace.bracelet.v4", "hmpace.bracelet.v3nfc"};
    public static final Map<String, Class<?>> O00000Oo;

    static {
        HashMap hashMap = new HashMap();
        O00000Oo = hashMap;
        hashMap.put("xiaomi.tv.v1", MiTVDevice.class);
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
        for (String put : f16441O000000o) {
            O00000Oo.put(put, WatchBandDevice.class);
        }
    }

    public static String O000000o(String str) {
        if (str == null) {
            return "";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                while (hexString.length() < 2) {
                    hexString = "0".concat(String.valueOf(hexString));
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static Device O000000o(JSONObject jSONObject) {
        Device O00000o0 = O00000o0(jSONObject.optString("model"));
        O00000o0.parseFromJSONObject(jSONObject);
        return O00000o0;
    }

    public static Device O000000o(DeviceRecord deviceRecord) {
        Device O00000o0 = O00000o0(deviceRecord.model);
        O00000o0.setDid(deviceRecord.did);
        O00000o0.setModel(deviceRecord.model);
        O00000o0.setName(deviceRecord.name);
        O00000o0.setMac(deviceRecord.mac);
        boolean z = false;
        O00000o0.toggleOnline(deviceRecord.isOnline == 1);
        O00000o0.setPid(deviceRecord.pid);
        O00000o0.setPermitLevel(deviceRecord.permitLevel);
        O00000o0.setResetFlag(deviceRecord.resetFlag);
        O00000o0.setRssi(deviceRecord.rssi);
        O00000o0.setToken(deviceRecord.token);
        O00000o0.setLocalIP(deviceRecord.localIP);
        O00000o0.setLongitude(deviceRecord.longitude);
        O00000o0.setLatitude(deviceRecord.latitude);
        O00000o0.setSsid(deviceRecord.ssid);
        O00000o0.setBssid(deviceRecord.bssid);
        O00000o0.setShowMode(deviceRecord.showMode);
        O00000o0.setDesc(deviceRecord.desc);
        O00000o0.setParentId(deviceRecord.parentId);
        O00000o0.setParentModel(deviceRecord.parentModel);
        O00000o0.setOwnerName(deviceRecord.ownerName);
        O00000o0.setOwnerId(deviceRecord.ownerId);
        O00000o0.setPropInfo(deviceRecord.propInfo);
        O00000o0.setMethodInfo(deviceRecord.methodInfo);
        O00000o0.setExtraInfo(deviceRecord.extraInfo);
        O00000o0.setEventInfo(deviceRecord.eventInfo);
        O00000o0.setLocation(Device.Location.values()[deviceRecord.location]);
        O00000o0.setVersion(deviceRecord.version);
        O00000o0.toggleCanUseNotBind(deviceRecord.canUseNotBind == 1);
        if (deviceRecord.canAuth == 1) {
            z = true;
        }
        O00000o0.toggleCanAuth(z);
        O00000o0.setSpecUrn(deviceRecord.specUrn);
        O00000o0.setVoiceCtrl((byte) deviceRecord.voiceCtrl);
        O00000o0.setFreqFlag(deviceRecord.freqFlag);
        O00000o0.setComFlag(deviceRecord.comFlag);
        O00000o0.parseDBExtra();
        return O00000o0;
    }

    public static String O00000Oo(String str) {
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
        int indexOf4 = str.indexOf("midea_ac_");
        return indexOf4 >= 0 ? str.substring(indexOf4 + 9) : str;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    public static Device O000000o(String str, String str2) {
        String str3;
        int indexOf = str.indexOf("_miio");
        if (indexOf > 1) {
            str3 = str.substring(0, indexOf).replace('-', '.');
        } else {
            int indexOf2 = str.indexOf("_miap");
            if (indexOf2 > 1) {
                str3 = str.substring(0, indexOf2).replace('-', '.');
            } else {
                int indexOf3 = str.indexOf("_mibt");
                if (indexOf3 > 1) {
                    str3 = str.substring(0, indexOf3).replace('-', '.');
                } else {
                    str3 = (str.contains("midea_AC") || str.contains("midea_ac")) ? "midea.aircondition.v1" : str;
                }
            }
        }
        Device O00000o0 = O00000o0(str3);
        O00000o0.setDid(O00000Oo(str));
        int indexOf4 = str.indexOf("_miio");
        if (indexOf4 > 0) {
            O00000o0.setModel(str.substring(0, indexOf4).replace('-', '.'));
        } else {
            O00000o0.setModel(str3);
        }
        O00000o0.setPid(0);
        O00000o0.toggleOnline(true);
        O00000o0.setUnbind();
        O00000o0.setResetFlag(1);
        O00000o0.setLocalIP(str2);
        O00000o0.setLocation(Device.Location.LOCAL);
        return O00000o0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    private static Device O00000o0(String str) {
        Device device;
        Class<RouterDevice> cls = O00000Oo.get(str);
        if (cls == null && str.startsWith("xiaomi.router")) {
            cls = RouterDevice.class;
        }
        if (cls != null) {
            try {
                device = (Device) fdb.O000000o(cls, new Object[0]);
            } catch (Exception e) {
                Log.e("DeviceFactory", "fatal", e);
            }
            return device != null ? new MiioDevice() : device;
        }
        device = null;
        if (device != null) {
        }
    }
}

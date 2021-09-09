package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.router.miio.miioplugin.DeviceStatus;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.MiTVDevice;
import com.xiaomi.smarthome.device.RouterDevice;
import com.xiaomi.smarthome.device.WatchBandDevice;
import com.xiaomi.smarthome.device.ZhilianCameraDevice;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.miio.camera.match.CameraDevice;
import com.xiaomi.smarthome.miio.device.CurtainDevice;
import com.xiaomi.smarthome.miio.device.GeneralAPDevice;
import com.xiaomi.smarthome.miio.device.PhoneIRDevice;
import com.xiaomi.smarthome.miio.device.TemporaryDevice;
import java.util.List;
import org.json.JSONObject;

@RouterService
public class fql implements fmt {
    private static final fql INSTANCE = new fql();

    @cug
    public static fql provideInstance() {
        return INSTANCE;
    }

    public DeviceStat newDeviceStat(Device device) {
        if (device == null) {
            return null;
        }
        DeviceStat deviceStat = new DeviceStat();
        deviceStat.did = device.did;
        deviceStat.name = device.name;
        deviceStat.mac = device.mac;
        deviceStat.model = device.model;
        deviceStat.ip = device.ip;
        String str = "";
        deviceStat.parentId = device.parentId != null ? device.parentId : str;
        if (device.parentModel != null) {
            str = device.parentModel;
        }
        deviceStat.parentModel = str;
        deviceStat.authFlag = device.isShared() ? 1 : 0;
        deviceStat.bindFlag = (device.isOwner() || device.isFamily()) ? 1 : 0;
        deviceStat.token = device.token;
        deviceStat.userId = device.userId;
        if (device.location != null) {
            deviceStat.location = device.location.ordinal();
        }
        deviceStat.latitude = device.latitude;
        deviceStat.longitude = device.longitude;
        deviceStat.bssid = device.bssid;
        deviceStat.lastModified = device.lastModified;
        deviceStat.pid = device.pid;
        deviceStat.rssi = device.rssi;
        deviceStat.isOnline = device.isOnline;
        deviceStat.resetFlag = device.resetFlag;
        deviceStat.ssid = device.ssid;
        deviceStat.ownerName = device.ownerName;
        deviceStat.ownerId = device.ownerId;
        deviceStat.propInfo = device.propInfo;
        deviceStat.version = device.version;
        deviceStat.property.clear();
        deviceStat.property.putAll(device.property);
        deviceStat.extrainfo = device.extra;
        deviceStat.showMode = device.showMode;
        deviceStat.hideMode = device.hideMode;
        deviceStat.event = device.event;
        deviceStat.permitLevel = device.permitLevel;
        deviceStat.isSetPinCode = device.isSetPinCode;
        deviceStat.pinCodeType = device.pinCodeType;
        deviceStat.orderTimeJString = device.orderTimeJString;
        return deviceStat;
    }

    public DeviceStatus newDeviceStatus(Device device) {
        if (device == null) {
            return null;
        }
        DeviceStatus deviceStatus = new DeviceStatus();
        deviceStatus.f6611O000000o = device.did;
        deviceStatus.O00000Oo = device.name;
        deviceStatus.O00000o0 = device.mac;
        deviceStatus.O00000o = device.model;
        deviceStatus.O00000oo = device.ip;
        String str = "";
        deviceStatus.O0000O0o = device.parentId != null ? device.parentId : str;
        if (device.parentModel != null) {
            str = device.parentModel;
        }
        deviceStatus.O0000OOo = str;
        deviceStatus.O0000Oo = device.isShared() ? 1 : 0;
        deviceStatus.O0000Oo0 = (device.isOwner() || device.isFamily()) ? 1 : 0;
        deviceStatus.O0000OoO = device.token;
        deviceStatus.O0000Ooo = device.userId;
        if (device.location != null) {
            deviceStatus.O0000o00 = device.location.ordinal();
        }
        deviceStatus.O0000o0 = device.latitude;
        deviceStatus.O0000o0O = device.longitude;
        deviceStatus.O0000o0o = device.bssid;
        deviceStatus.O0000o = device.lastModified;
        deviceStatus.O0000oO0 = device.pid;
        deviceStatus.O0000oO = device.rssi;
        deviceStatus.O0000oOO = device.isOnline;
        deviceStatus.O0000oOo = device.resetFlag;
        deviceStatus.O0000oo0 = device.ssid;
        deviceStatus.O0000oo = device.ownerName;
        deviceStatus.O0000ooO = device.ownerId;
        deviceStatus.O0000ooo = device.propInfo;
        deviceStatus.O00oOooO = device.version;
        deviceStatus.O00oOooo.clear();
        deviceStatus.O00oOooo.putAll(device.property);
        deviceStatus.O00000oO = device.extra;
        deviceStatus.O000O00o = device.showMode;
        deviceStatus.O000O0OO = device.hideMode;
        deviceStatus.O000O0Oo = device.event;
        deviceStatus.O00oOoOo = device.permitLevel;
        deviceStatus.O000O0o0 = device.isSetPinCode;
        deviceStatus.O000O0o = device.pinCodeType;
        deviceStatus.O000O0oO = device.orderTimeJString;
        return deviceStatus;
    }

    public boolean isSupportCommonSwitch(Device device) {
        boolean z;
        if (!(device == null || device.isSharedReadOnly() || device.method == null || device.method.length() == 0 || device.propInfo == null || device.propInfo.length() == 0 || device.propInfo.isNull("power"))) {
            int i = 0;
            while (true) {
                if (i >= device.method.length()) {
                    z = false;
                    break;
                }
                JSONObject optJSONObject = device.method.optJSONObject(i);
                if (optJSONObject != null && !optJSONObject.isNull("name") && TextUtils.equals(optJSONObject.optString("name"), "set_power")) {
                    z = true;
                    break;
                }
                i++;
            }
            if (z) {
                String optString = device.propInfo.optString("power");
                if (TextUtils.equals(optString, "on") || TextUtils.equals(optString, "off")) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public boolean isNoneClickableDevice(Device device) {
        if (device == null) {
            return false;
        }
        if (device instanceof MiTVDevice) {
            MiTVDevice miTVDevice = (MiTVDevice) device;
            return miTVDevice.mShowOfflineDialog == 1 && miTVDevice.mLocalStatus == 3;
        } else if (device.isOnline) {
            return false;
        } else {
            PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(device.model);
            return O00000oO == null || !(O00000oO.O0000oOo() == 1 || O00000oO.O0000oOo() == 2);
        }
    }

    public void bindDevice(Device device, Context context, fmo fmo) {
        if (device != null) {
            if (device instanceof MiTVDevice) {
                ((MiTVDevice) device).O000000o(context, fmo);
            } else if (device instanceof RouterDevice) {
                ((RouterDevice) device).O000000o(context, fmo);
            }
        }
    }

    public String getSubtitleByDesc(Device device, Context context, boolean z) {
        if (device == null) {
            return "";
        }
        String str = device.desc;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!device.isShared() && !device.isBinded()) {
            str = context.getString(R.string.local_device);
        }
        if (z) {
            return str;
        }
        if (!gfr.O0000o0o && !gfr.f17662O000000o) {
            return str;
        }
        return str + " " + device.did;
    }

    public boolean canBeShared(Device device) {
        if (device == null || (device instanceof GeneralAPDevice) || (device instanceof TemporaryDevice) || (device instanceof RouterDevice) || (device instanceof WatchBandDevice) || (device instanceof ZhilianCameraDevice) || ((device instanceof BleDevice) && ("soocare.toothbrush.x3".equalsIgnoreCase(device.model) || "hmpace.watch.v1".equalsIgnoreCase(device.model) || ffs.O000000o(device.model) != 2 || !((BleDevice) device).O00000o()))) {
            return false;
        }
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(device.model);
        boolean z = O00000oO == null || O00000oO.O00oOooo() != 3;
        if (!device.isVirtualDevice() && device.isOwner() && device.canAuth && !device.isSubDevice() && z) {
            return true;
        }
        return false;
    }

    public boolean canRename(Device device) {
        if (device == null || (device instanceof GeneralAPDevice) || (device instanceof TemporaryDevice) || (device instanceof RouterDevice) || (device instanceof WatchBandDevice) || (device instanceof ZhilianCameraDevice)) {
            return false;
        }
        if (!(device instanceof MiTVDevice)) {
            return device.isOwner();
        }
        if (!device.isOwner() || !device.isOnline) {
            return false;
        }
        return true;
    }

    public boolean canBeDeleted(Device device) {
        if (device == null) {
            return false;
        }
        if ((device instanceof GeneralAPDevice) || (device instanceof TemporaryDevice) || (device instanceof MiTVDevice)) {
            return true;
        }
        return !(device instanceof WatchBandDevice) && !(device instanceof ZhilianCameraDevice) && !device.model.equalsIgnoreCase("xiaomi.wifispeaker.s12");
    }

    public CharSequence getStatusDescription(Device device, Context context) {
        int i;
        if (device == null || context == null || (device instanceof CurtainDevice)) {
            return "";
        }
        if (device instanceof PhoneIRDevice) {
            if (CoreApi.O000000o().O00000o(((PhoneIRDevice) device).model)) {
                List<fmu> O00000Oo = fqw.O00000Oo(context);
                if (O00000Oo == null) {
                    i = 0;
                } else {
                    i = O00000Oo.size();
                }
            } else {
                i = fqw.O00000oO(context);
            }
            if (i <= 0) {
                return context.getString(R.string.my_phone_ir_desc_empty);
            }
            return context.getResources().getQuantityString(R.plurals.my_phone_ir_desc_count, i, Integer.valueOf(i));
        } else if (device instanceof BleDevice) {
            return ((BleDevice) device).mac;
        } else {
            if (device instanceof MiTVDevice) {
                ((MiTVDevice) device).O000000o(context);
            } else if (device instanceof CameraDevice) {
                ((CameraDevice) device).getStatusDescription(context);
            } else if (device instanceof RouterDevice) {
                RouterDevice routerDevice = (RouterDevice) device;
                if (routerDevice.readStatusError) {
                    context.getString(R.string.router_speed_no_info);
                } else if (routerDevice.wanSpeed == 0) {
                    context.getString(R.string.router_no_speed);
                } else if (routerDevice.wanSpeed < 1024) {
                    context.getString(R.string.router_current_speed_format, String.valueOf(RouterDevice.O00000Oo.format((double) (((float) routerDevice.wanSpeed) / 1024.0f))));
                } else {
                    context.getString(R.string.router_current_speed_format, String.valueOf(RouterDevice.f7026O000000o.format((double) (((float) routerDevice.wanSpeed) / 1024.0f))));
                }
            } else if (((device instanceof GeneralAPDevice) || (device instanceof TemporaryDevice)) && !TextUtils.isEmpty(device.desc)) {
                return device.desc;
            }
            if (device.isOnline) {
                return context.getString(R.string.list_device_online);
            }
            return context.getString(R.string.list_device_offline);
        }
    }
}

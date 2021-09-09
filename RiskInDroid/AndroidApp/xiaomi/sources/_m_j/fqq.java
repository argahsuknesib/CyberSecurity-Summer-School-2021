package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.MiTVDevice;
import com.xiaomi.smarthome.miio.camera.match.CameraDevice;
import com.xiaomi.smarthome.miio.device.PhoneIRDevice;

public final class fqq {

    /* renamed from: O000000o  reason: collision with root package name */
    private Device f16902O000000o;

    public fqq(Device device) {
        this.f16902O000000o = device;
    }

    public final String O000000o(Context context, boolean z) {
        Device device = this.f16902O000000o;
        if (device instanceof BleDevice) {
            return O00000Oo(context);
        }
        if (device instanceof CameraDevice) {
            return O00000o0(context, z);
        }
        if (device instanceof MiTVDevice) {
            return O00000Oo(context, z);
        }
        if (device instanceof PhoneIRDevice) {
            return O000000o(context);
        }
        return O00000o(context, z);
    }

    private String O000000o(Context context) {
        return (String) DeviceRouterFactory.getDeviceWrapper().getStatusDescription(this.f16902O000000o, context);
    }

    private String O00000Oo(Context context, boolean z) {
        String str = (String) DeviceRouterFactory.getDeviceWrapper().getStatusDescription(this.f16902O000000o, context);
        if (z || !gfr.O0000o0o) {
            return str;
        }
        return str + " " + this.f16902O000000o.did;
    }

    private String O00000o0(Context context, boolean z) {
        String str = (String) DeviceRouterFactory.getDeviceWrapper().getStatusDescription(this.f16902O000000o, context);
        if (this.f16902O000000o.isShared()) {
            str = str + " " + context.getString(R.string.comefrom_device) + this.f16902O000000o.ownerName;
        }
        if (z || !gfr.O0000o0o) {
            return str;
        }
        return str + " " + this.f16902O000000o.did;
    }

    private String O00000Oo(Context context) {
        if (TextUtils.equals(this.f16902O000000o.model, "ls123.headphone.t10")) {
            return context.getString(R.string.list_device_tap_view);
        }
        if (!((BleDevice) this.f16902O000000o).O00000o() || this.f16902O000000o.isOwner() || TextUtils.isEmpty(this.f16902O000000o.ownerName)) {
            return "";
        }
        return context.getString(R.string.comefrom_device) + this.f16902O000000o.ownerName;
    }

    private String O00000o(Context context, boolean z) {
        String str;
        if (this.f16902O000000o.model == null || !this.f16902O000000o.model.equals("jomoo.toilet.ao3")) {
            String str2 = "";
            if (!this.f16902O000000o.isConnected) {
                return str2;
            }
            if (!this.f16902O000000o.isOnline) {
                str = context.getString(R.string.offline_device);
            } else {
                str = (String) DeviceRouterFactory.getDeviceWrapper().getStatusDescription(this.f16902O000000o, context);
            }
            if (this.f16902O000000o.isShared()) {
                str = str + " " + context.getString(R.string.comefrom_device) + this.f16902O000000o.ownerName;
            } else if (!this.f16902O000000o.isBinded()) {
                str = context.getString(R.string.local_device);
            }
            if (this.f16902O000000o.isOnline && this.f16902O000000o.rssi < -70 && this.f16902O000000o.pid == Device.PID_MIIO) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                if (!TextUtils.isEmpty(str)) {
                    str2 = ", ";
                }
                sb.append(str2);
                sb.append(context.getString(R.string.weak_device_signal));
                str = sb.toString();
            }
            if (z || !gfr.O0000o0o) {
                return str;
            }
            if (!TextUtils.isEmpty(str) && str.contains(this.f16902O000000o.did)) {
                return str;
            }
            return str + " " + this.f16902O000000o.did;
        } else if (this.f16902O000000o.isOnline && this.f16902O000000o.isOpen()) {
            return context.getString(R.string.list_device_online);
        } else {
            if (this.f16902O000000o.isOnline) {
                return context.getString(R.string.list_device_offline);
            }
            return context.getString(R.string.list_device_offline);
        }
    }
}

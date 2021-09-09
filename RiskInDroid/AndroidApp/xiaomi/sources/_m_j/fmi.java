package _m_j;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.MiTVDevice;
import com.xiaomi.smarthome.device.RouterDevice;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.host.PluginHostApi;
import com.xiaomi.smarthome.miio.device.PhoneIRDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class fmi {
    private static volatile fmi O00000oO;

    /* renamed from: O000000o  reason: collision with root package name */
    public DeviceTagInterface f16629O000000o;
    public List<fni> O00000Oo;
    public int O00000o;
    public List<fni> O00000o0;
    private Context O00000oo;
    private NotificationManager O0000O0o;
    private SharedPreferences O0000OOo;

    private fmi(Context context) {
        this.f16629O000000o = PluginHostApi.instance() == null ? null : ((PluginHostApi) PluginHostApi.instance()).getDeviceTagManager();
        this.O00000Oo = null;
        this.O00000o0 = null;
        this.O00000o = -1;
        this.O00000oo = context.getApplicationContext();
        this.O0000O0o = (NotificationManager) this.O00000oo.getSystemService("notification");
    }

    public static fmi O000000o() {
        if (O00000oO == null) {
            synchronized (fmi.class) {
                if (O00000oO == null) {
                    O00000oO = new fmi(CommonApplication.getAppContext());
                }
            }
        }
        return O00000oO;
    }

    public static List<Device> O000000o(Map<String, Device> map) {
        if (!fqw.O00000o0()) {
            return new ArrayList(map.values());
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Device> value : map.entrySet()) {
            Device device = (Device) value.getValue();
            if (!fqw.O000000o(device.did)) {
                arrayList.add(device);
            }
        }
        return arrayList;
    }

    public final void O00000Oo(Map<String, Device> map) {
        List<Device> O000000o2 = O000000o(map);
        DeviceTagInterface deviceTagInterface = this.f16629O000000o;
        if (deviceTagInterface != null) {
            deviceTagInterface.O000000o(O000000o2);
        }
    }

    public final void O00000o0(Map<String, Device> map) {
        if (this.f16629O000000o != null) {
            this.f16629O000000o.O00000Oo(O000000o(map));
        }
    }

    public final void O00000Oo() {
        Class O00000Oo2;
        String str;
        Notification notification;
        if (CoreApi.O000000o().O0000Ooo()) {
            Device device = null;
            Iterator<Map.Entry<String, Device>> it = fno.O000000o().O0000O0o().entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Device device2 = (Device) it.next().getValue();
                if ((device2 instanceof RouterDevice) && !device2.isBinded()) {
                    device = device2;
                    break;
                }
            }
            if (device != null) {
                if (this.O0000OOo == null) {
                    this.O0000OOo = this.O00000oo.getSharedPreferences("notified_devices_pref", 0);
                }
                if (!(System.currentTimeMillis() - this.O0000OOo.getLong(device.did, 0) <= 604800000)) {
                    if (this.O0000OOo == null) {
                        this.O0000OOo = this.O00000oo.getSharedPreferences("notified_devices_pref", 0);
                    }
                    this.O0000OOo.edit().putLong(device.did, System.currentTimeMillis()).apply();
                    boolean z = device instanceof MiTVDevice;
                    if ((z || (device instanceof RouterDevice)) && this.O0000O0o != null && (O00000Oo2 = cub.O00000Oo(Activity.class, "com.xiaomi.smarthome.SmartHomeMainActivity")) != null) {
                        Intent intent = new Intent(this.O00000oo, O00000Oo2);
                        intent.setFlags(335544320);
                        intent.putExtra("source", 5);
                        intent.putExtra("device_id", device.did);
                        PendingIntent activity = PendingIntent.getActivity(this.O00000oo, R.string.app_name, intent, 134217728);
                        if (z) {
                            str = this.O00000oo.getString(R.string.found_new_unbind_mitvdevice);
                        } else {
                            str = device instanceof RouterDevice ? this.O00000oo.getString(R.string.found_new_unbind_routerdevice) : "";
                        }
                        if (Build.VERSION.SDK_INT >= 26) {
                            Context context = this.O00000oo;
                            Notification.Builder builder = new Notification.Builder(context, fke.O000000o(this.O0000O0o, context));
                            builder.setContentTitle(this.O00000oo.getString(R.string.wifi_scan_new_device_title));
                            builder.setSmallIcon((int) R.drawable.mj_notify_icon);
                            builder.setWhen(System.currentTimeMillis());
                            builder.setAutoCancel(true);
                            builder.setContentTitle(this.O00000oo.getString(R.string.wifi_scan_new_device_title));
                            builder.setContentIntent(activity);
                            builder.setContentText(str);
                            notification = builder.build();
                        } else {
                            NotificationCompat.Builder builder2 = new NotificationCompat.Builder(this.O00000oo);
                            builder2.O000000o(this.O00000oo.getString(R.string.wifi_scan_new_device_title));
                            builder2.O000000o((int) R.drawable.mj_notify_icon);
                            builder2.O000000o(System.currentTimeMillis());
                            builder2.O00000Oo();
                            builder2.O000000o(this.O00000oo.getString(R.string.wifi_scan_new_device_title));
                            builder2.O00000oo = activity;
                            builder2.O00000Oo(str);
                            notification = builder2.O00000o();
                        }
                        if (z) {
                            this.O0000O0o.notify(1002, notification);
                        } else if (device instanceof RouterDevice) {
                            this.O0000O0o.notify(1003, notification);
                        }
                    }
                }
            } else {
                NotificationManager notificationManager = this.O0000O0o;
                if (notificationManager != null) {
                    try {
                        notificationManager.cancel(1003);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static String[] O000000o(fni fni) {
        Map<String, Device> O0000O0o2;
        if (fni == null || fni.O00000o0.length <= 0 || (O0000O0o2 = fno.O000000o().O0000O0o()) == null || O0000O0o2.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Device> value : O0000O0o2.entrySet()) {
            Device device = (Device) value.getValue();
            if (device != null && !TextUtils.isEmpty(device.model)) {
                int i = 0;
                while (true) {
                    if (i >= fni.O00000o0.length) {
                        break;
                    } else if (device.model.equals(fni.O00000o0[i])) {
                        arrayList.add(device.did);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    public static fni O000000o(List<fni> list, String str) {
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            fni fni = list.get(i);
            if (fni.O00000o.equals(str)) {
                return fni;
            }
        }
        return null;
    }

    public static int O00000Oo(fni fni) {
        Map<String, Device> O0000O0o2 = fno.O000000o().O0000O0o();
        if (O0000O0o2 == null || O0000O0o2.size() <= 0) {
            return 0;
        }
        int i = 0;
        for (Map.Entry<String, Device> value : O0000O0o2.entrySet()) {
            Device device = (Device) value.getValue();
            int i2 = 0;
            while (true) {
                if (i2 >= fni.O00000o0.length) {
                    break;
                }
                String str = fni.O00000o0[i2];
                if (!TextUtils.isEmpty(str) && str.equals(device.model)) {
                    i++;
                    break;
                }
                i2++;
            }
        }
        return i;
    }

    public static List<Device> O00000o0() {
        ArrayList arrayList = new ArrayList();
        Map<String, Device> O0000O0o2 = fno.O000000o().O0000O0o();
        if (O0000O0o2 == null) {
            return arrayList;
        }
        for (Map.Entry<String, Device> value : O0000O0o2.entrySet()) {
            Device device = (Device) value.getValue();
            if (!(device instanceof PhoneIRDevice) && !fqw.O000000o(device.did) && device.isBinded()) {
                arrayList.add(device);
            }
        }
        return arrayList;
    }
}

package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.MiTVDevice;
import java.util.ArrayList;
import java.util.Iterator;

public final class fnh {

    /* renamed from: O000000o  reason: collision with root package name */
    public static fnh f16694O000000o;
    ArrayList<String> O00000Oo = new ArrayList<>();
    ArrayList<MiTVDevice> O00000o = new ArrayList<>();
    SharedPreferences O00000o0;
    volatile boolean O00000oO;
    volatile boolean O00000oo;

    public static synchronized fnh O000000o() {
        fnh fnh;
        synchronized (fnh.class) {
            if (f16694O000000o == null) {
                f16694O000000o = new fnh();
            }
            fnh = f16694O000000o;
        }
        return fnh;
    }

    private fnh() {
        String[] split;
        this.O00000oO = false;
        this.O00000oo = false;
        try {
            this.O00000o0 = PreferenceManager.getDefaultSharedPreferences(CommonApplication.getAppContext());
            String string = this.O00000o0.getString("mitv_device_key_1", null);
            if (!TextUtils.isEmpty(string) && (split = string.split(",")) != null) {
                for (String add : split) {
                    this.O00000Oo.add(add);
                }
            }
        } catch (Exception unused) {
        }
    }

    private String O00000o() {
        ArrayList<String> arrayList = this.O00000Oo;
        if (arrayList == null || arrayList.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.O00000Oo.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        return sb.toString();
    }

    public final void O000000o(String str) {
        if (!this.O00000Oo.contains(str)) {
            this.O00000Oo.add(str);
            this.O00000oO = true;
            this.O00000o0.edit().putString("mitv_device_key_1", O00000o()).apply();
        }
    }

    public final void O00000Oo(String str) {
        if (this.O00000Oo.contains(str)) {
            this.O00000Oo.remove(str);
            this.O00000oO = true;
            this.O00000o0.edit().putString("mitv_device_key_1", O00000o()).apply();
        }
    }

    public final void O00000Oo() {
        this.O00000Oo.clear();
        this.O00000oO = false;
        this.O00000oo = false;
        this.O00000o0.edit().putString("mitv_device_key_1", O00000o()).apply();
    }

    public final ArrayList<MiTVDevice> O00000o0() {
        ArrayList<MiTVDevice> arrayList = new ArrayList<>();
        Iterator<MiTVDevice> it = this.O00000o.iterator();
        while (it.hasNext()) {
            MiTVDevice next = it.next();
            if (next.isLocal()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static void O000000o(Context context, Device device) {
        if ((device instanceof MiTVDevice) && !device.isBinded()) {
            MiTVDevice miTVDevice = (MiTVDevice) device;
            if (miTVDevice.isLocal() && device.isOnline) {
                miTVDevice.O000000o(context, new fmo() {
                    /* class _m_j.fnh.AnonymousClass1 */

                    public final void O000000o() {
                    }

                    public final void O00000Oo() {
                    }
                });
            }
        }
    }
}

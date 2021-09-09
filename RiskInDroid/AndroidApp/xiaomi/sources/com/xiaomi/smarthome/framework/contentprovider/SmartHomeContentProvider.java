package com.xiaomi.smarthome.framework.contentprovider;

import _m_j.fas;
import _m_j.fno;
import _m_j.goq;
import _m_j.gsy;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.homedevicelist.DeviceCountManager;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.device.PhoneIRDevice;
import java.util.Map;

public class SmartHomeContentProvider extends ContentProvider {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f7551O000000o = "SmartHomeContentProvider";
    private static final UriMatcher O00000Oo;
    private static Runnable O00000o0 = new Runnable() {
        /* class com.xiaomi.smarthome.framework.contentprovider.SmartHomeContentProvider.AnonymousClass1 */

        public final void run() {
            CommonApplication.getAppContext().getContentResolver().notifyChange(Uri.parse("content://com.xiaomi.smarthome.ext_cp/online_devices_count"), null);
        }
    };

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        O00000Oo = uriMatcher;
        uriMatcher.addURI("com.xiaomi.smarthome.ext_cp", "online_devices_count", 1);
        O00000Oo.addURI("com.xiaomi.smarthome.ext_cp", "path_mitv_ble_mac", 2);
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        String str3 = "";
        if (TextUtils.equals("online_devices_count", str)) {
            if (!CoreApi.O000000o().O0000O0o()) {
                gsy.O000000o(3, f7551O000000o, "core not ready");
                return null;
            } else if (!CoreApi.O000000o().O0000Ooo()) {
                gsy.O000000o(3, f7551O000000o, "not login");
                return null;
            } else {
                Bundle bundle2 = new Bundle();
                int O000000o2 = O000000o();
                if (O000000o2 > 0) {
                    Context appContext = CommonApplication.getAppContext();
                    if (CoreApi.O000000o().O00oOooo() == null) {
                        str3 = appContext.getResources().getQuantityString(R.plurals.miui_online_device_count, O000000o2, Integer.valueOf(O000000o2));
                    } else {
                        appContext.getResources();
                        Configuration configuration = Resources.getSystem().getConfiguration();
                        str3 = new Resources(appContext.getAssets(), new DisplayMetrics(), configuration).getQuantityString(R.plurals.miui_online_device_count, O000000o2, Integer.valueOf(O000000o2));
                    }
                }
                bundle2.putString("count", str3);
                return bundle2;
            }
        } else if (!TextUtils.equals("path_mitv_ble_mac", str)) {
            return null;
        } else {
            gsy.O000000o(3, f7551O000000o, " mitv ble arg: ".concat(String.valueOf(str2)));
            fas fas = fas.O000000o.f16038O000000o;
            if (!TextUtils.isEmpty(str2)) {
                str3 = fas.O0000O0o(str2 + ".mitvBleMac");
            }
            Bundle bundle3 = new Bundle();
            if (str3 != null) {
                bundle3.putString("mitv_ble_mac", str3);
            }
            return bundle3;
        }
    }

    public static int O000000o() {
        int O00000o02 = DeviceCountManager.O000000o().O00000o0();
        if (O00000o02 == 0) {
            O00000o02 = O00000Oo();
            gsy.O00000o0(LogType.DEVICE_LIST, f7551O000000o, "DeviceCountManager calculateDeviceCnt 0, getTotalOperableOnlineDeviceCount=".concat(String.valueOf(O00000o02)));
        }
        if (O00000o02 == 0) {
            O00000o02 = CommonApplication.getAppContext().getSharedPreferences("com.xiaomi.smarthome.ext_cp_sp", 0).getInt("online_devices_count", 0);
            gsy.O00000o0(LogType.DEVICE_LIST, f7551O000000o, "getTotalOperableOnlineDeviceCount 0, read from cache=".concat(String.valueOf(O00000o02)));
            if (O00000o02 > 0) {
                gsy.O000000o(3, f7551O000000o, "read from cache ".concat(String.valueOf(O00000o02)));
            }
        }
        return O00000o02;
    }

    private static int O00000Oo() {
        int i = 0;
        if (CoreApi.O000000o().O0000Ooo()) {
            Map<String, Device> O0000O0o = fno.O000000o().O0000O0o();
            if (O0000O0o == null) {
                return 0;
            }
            LogType logType = LogType.GENERAL;
            gsy.O00000Oo(logType, f7551O000000o, "getOnlineDevice=" + O0000O0o.size());
            for (Map.Entry<String, Device> value : O0000O0o.entrySet()) {
                Device device = (Device) value.getValue();
                if (device.pid != Device.PID_VIRTUAL_DEVICE && ((!device.isSubDevice() || !device.isShowMainList()) && !(device instanceof PhoneIRDevice) && device.isOnline)) {
                    i++;
                }
            }
            gsy.O00000Oo(LogType.GENERAL, f7551O000000o, "getOnlineDevice after filter=".concat(String.valueOf(i)));
            Map<String, Device> O00000Oo2 = fno.O000000o().O00000Oo();
            if (O00000Oo2 == null) {
                return i;
            }
            LogType logType2 = LogType.GENERAL;
            gsy.O00000Oo(logType2, f7551O000000o, "getOnlineSubDevice=" + O00000Oo2.size());
            for (Map.Entry<String, Device> value2 : O00000Oo2.entrySet()) {
                if (((Device) value2.getValue()).isOnline) {
                    i++;
                }
            }
            gsy.O00000Oo(LogType.GENERAL, f7551O000000o, "count ret=".concat(String.valueOf(i)));
        }
        return i;
    }

    public static void O000000o(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            goq.O000000o(new Runnable() {
                /* class com.xiaomi.smarthome.framework.contentprovider.SmartHomeContentProvider.AnonymousClass2 */

                public final void run() {
                    CommonApplication.getAppContext().getSharedPreferences("com.xiaomi.smarthome.ext_cp_sp", 0).edit().putInt("online_devices_count", SmartHomeContentProvider.O000000o()).apply();
                }
            });
            if (O00000Oo.match(Uri.parse("content://com.xiaomi.smarthome.ext_cp/".concat(String.valueOf(str)))) == 1) {
                ServiceApplication.getGlobalWorkerHandler().removeCallbacks(O00000o0);
                ServiceApplication.getGlobalWorkerHandler().postDelayed(O00000o0, 2000);
            }
        }
    }
}

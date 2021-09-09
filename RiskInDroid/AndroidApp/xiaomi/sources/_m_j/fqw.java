package _m_j;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.net.Uri;
import android.os.Build;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.miio.device.PhoneIRDevice;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class fqw {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f16938O000000o = "fqw";
    public static final String[] O00000Oo = {"controller_id", "controller_name", "device_type", "intent_action"};
    static Boolean O00000o = null;
    public static List<fmu> O00000o0;
    public static AtomicBoolean O00000oO = new AtomicBoolean(false);
    private static final Uri O00000oo = Uri.parse("content://com.xiaomi.mitv.phone.remotecontroller.provider.LockScreenProvider");
    private static Device O0000O0o = null;
    private static int O0000OOo = -1;

    public interface O000000o {
    }

    public static String O000000o() {
        return "xiaomi.phone_ir.t1";
    }

    public static void O000000o(Context context, Intent intent) {
        DeviceRouterFactory.getDeviceHelper().startIRPlugin(context, intent);
    }

    public static Device O00000Oo() {
        Device device = O0000O0o;
        if (device != null && "xiaomi.phone_ir.t1".equals(device.model)) {
            return O0000O0o;
        }
        Device O0000o0O = DeviceFactory.O0000o0O("xiaomi.phone_ir.t1");
        O0000o0O.did = fml.O000000o();
        O0000o0O.canAuth = false;
        O0000o0O.setOwner(true);
        O0000o0O.location = Device.Location.LOCAL;
        O0000o0O.isOnline = true;
        O0000O0o = O0000o0O;
        return O0000o0O;
    }

    public static boolean O000000o(PluginDeviceInfo pluginDeviceInfo) {
        return pluginDeviceInfo != null && pluginDeviceInfo.O0000o() == 15;
    }

    public static boolean O000000o(String str) {
        return fml.O000000o(str);
    }

    public static boolean O00000o0() {
        boolean z = false;
        if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            return false;
        }
        Boolean bool = O00000o;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                ConsumerIrManager consumerIrManager = (ConsumerIrManager) CommonApplication.getAppContext().getSystemService("consumer_ir");
                if (consumerIrManager != null && consumerIrManager.hasIrEmitter()) {
                    z = true;
                }
                O00000o = Boolean.valueOf(z);
            } else {
                O00000o = Boolean.FALSE;
            }
        } catch (Exception e) {
            e.printStackTrace();
            O00000o = Boolean.FALSE;
        }
        return O00000o.booleanValue();
    }

    public static void O00000o() {
        Map<String, Device> O0000O0o2 = fno.O000000o().O0000O0o();
        if (O0000O0o2 != null && O0000O0o2.size() > 0) {
            for (Map.Entry<String, Device> value : O0000O0o2.entrySet()) {
                Device device = (Device) value.getValue();
                if ((device instanceof PhoneIRDevice) || fml.O000000o(device.did)) {
                    device.model = "xiaomi.phone_ir.t1";
                }
            }
        }
    }

    public static List<fmu> O00000Oo(Context context) {
        if (O00000o0 == null) {
            O00000o0 = O00000oo(context);
        }
        return O00000o0;
    }

    public static int O00000oO() {
        if (!O00000o0()) {
            return 0;
        }
        final WeakReference weakReference = new WeakReference(null);
        List<fmu> list = O00000o0;
        if (list != null) {
            return list.size();
        }
        if (O00000oO.getAndSet(true)) {
            return 0;
        }
        goq.O000000o(new Runnable() {
            /* class _m_j.fqw.AnonymousClass1 */

            public final void run() {
                fqw.O00000oO.set(false);
                try {
                    fqw.O00000o0 = fqw.O00000o(CommonApplication.getAppContext());
                    final O000000o o000000o = (O000000o) weakReference.get();
                    fqw.O00000oO.set(false);
                    if (o000000o != null) {
                        CommonApplication.getGlobalHandler().post(new Runnable() {
                            /* class _m_j.fqw.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                List<fmu> list = fqw.O00000o0;
                            }
                        });
                        fqw.O00000oO.set(false);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        return 0;
    }

    public static int O00000o0(Context context) {
        List<fmu> O00000Oo2;
        if (O00000o0() && (O00000Oo2 = O00000Oo(context)) != null && O00000Oo2.size() > 0) {
            return O00000Oo2.size();
        }
        return 0;
    }

    public static int O00000oo() {
        List<fmu> list = O00000o0;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public static List<fmu> O00000o(Context context) {
        return O00000oo(context);
    }

    private static Drawable O00000Oo(int i, boolean z) {
        int i2;
        Resources resources = CommonApplication.getAppContext().getResources();
        if (i == 8) {
            i2 = z ? R.drawable.ir_amplifier_lock : R.drawable.ir_amplifier;
        } else if (i == 100000) {
            i2 = z ? R.drawable.ir_mi_controller_lock : R.drawable.ir_mi_controller;
        } else if (i == 10) {
            i2 = z ? R.drawable.ir_projector_lock : R.drawable.ir_projector;
        } else if (i == 11) {
            i2 = z ? R.drawable.ir_satellite_lock : R.drawable.ir_satellite;
        } else if (i == 10000) {
            i2 = z ? R.drawable.ir_mibox_lock : R.drawable.ir_mibox;
        } else if (i != 10001) {
            switch (i) {
                case 1:
                    if (!z) {
                        i2 = R.drawable.ir_tv;
                        break;
                    } else {
                        i2 = R.drawable.ir_tv_lock;
                        break;
                    }
                case 2:
                    if (!z) {
                        i2 = R.drawable.ir_stb;
                        break;
                    } else {
                        i2 = R.drawable.ir_stb_lock;
                        break;
                    }
                case 3:
                    if (!z) {
                        i2 = R.drawable.ir_air;
                        break;
                    } else {
                        i2 = R.drawable.ir_air_lock;
                        break;
                    }
                case 4:
                    if (!z) {
                        i2 = R.drawable.ir_dvd;
                        break;
                    } else {
                        i2 = R.drawable.ir_dvd_lock;
                        break;
                    }
                case 5:
                    if (!z) {
                        i2 = R.drawable.ir_iptv;
                        break;
                    } else {
                        i2 = R.drawable.ir_iptv_lock;
                        break;
                    }
                case 6:
                    if (!z) {
                        i2 = R.drawable.ir_fan;
                        break;
                    } else {
                        i2 = R.drawable.ir_fan_lock;
                        break;
                    }
                default:
                    if (!z) {
                        i2 = R.drawable.ir_others;
                        break;
                    } else {
                        i2 = R.drawable.ir_others_lock;
                        break;
                    }
            }
        } else {
            i2 = z ? R.drawable.ir_mitv_lock : R.drawable.ir_mitv;
        }
        return resources.getDrawable(i2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fqw.O00000Oo(int, boolean):android.graphics.drawable.Drawable
     arg types: [int, int]
     candidates:
      _m_j.fqw.O00000Oo(android.content.Context, android.content.Intent):boolean
      _m_j.fqw.O00000Oo(int, boolean):android.graphics.drawable.Drawable */
    public static Drawable O000000o(int i, boolean z) {
        Drawable O00000Oo2 = O00000Oo(i, false);
        int O000000o2 = gpc.O000000o(53.0f);
        O00000Oo2.setBounds(0, 0, O000000o2, O000000o2);
        return O00000Oo2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fqw.O00000Oo(int, boolean):android.graphics.drawable.Drawable
     arg types: [int, int]
     candidates:
      _m_j.fqw.O00000Oo(android.content.Context, android.content.Intent):boolean
      _m_j.fqw.O00000Oo(int, boolean):android.graphics.drawable.Drawable */
    public static Drawable O000000o(boolean z) {
        Drawable O00000Oo2 = O00000Oo(100000, false);
        int O000000o2 = gpc.O000000o(53.0f);
        O00000Oo2.setBounds(0, 0, O000000o2, O000000o2);
        return O00000Oo2;
    }

    public static int O00000oO(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        int i = 0;
        Cursor cursor = null;
        try {
            Cursor query = contentResolver.query(O00000oo, null, null, null, null);
            if (query != null && query.getCount() > 0) {
                query.moveToFirst();
                i = query.getCount();
            }
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    gsy.O000000o(6, f16938O000000o, String.valueOf(e));
                }
            }
            return i;
        } catch (Exception e2) {
            gsy.O000000o(6, f16938O000000o, String.valueOf(e2));
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                    gsy.O000000o(6, f16938O000000o, String.valueOf(e3));
                }
            }
            return 0;
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                    gsy.O000000o(6, f16938O000000o, String.valueOf(e4));
                }
            }
            throw th;
        }
    }

    public static boolean O00000Oo(Context context, Intent intent) {
        if (context.getPackageManager().resolveActivity(intent, 0) != null) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a3 A[SYNTHETIC, Splitter:B:25:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bd A[SYNTHETIC, Splitter:B:31:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    private static List<fmu> O00000oo(Context context) {
        Cursor cursor;
        Exception e;
        ContentResolver contentResolver = context.getContentResolver();
        ArrayList arrayList = null;
        try {
            cursor = contentResolver.query(O00000oo, null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        int count = cursor.getCount();
                        ArrayList arrayList2 = new ArrayList(count);
                        for (int i = 0; i < count; i++) {
                            arrayList2.add(new fmu(String.valueOf(cursor.getInt(cursor.getColumnIndex(O00000Oo[0]))), cursor.getString(cursor.getColumnIndex(O00000Oo[1])), cursor.getInt(cursor.getColumnIndex(O00000Oo[2])), cursor.getString(cursor.getColumnIndex(O00000Oo[3]))));
                            cursor.moveToNext();
                        }
                        arrayList = arrayList2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        gsy.O000000o(6, f16938O000000o, String.valueOf(e));
                        ArrayList arrayList3 = new ArrayList();
                        if (cursor != null) {
                            return arrayList3;
                        }
                        try {
                            cursor.close();
                            return arrayList3;
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            gsy.O000000o(6, f16938O000000o, String.valueOf(e3));
                            return new ArrayList();
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                        }
                        throw th;
                    }
                }
            }
            if (cursor == null) {
                return arrayList;
            }
            try {
                cursor.close();
                return arrayList;
            } catch (Exception e4) {
                e4.printStackTrace();
                gsy.O000000o(6, f16938O000000o, String.valueOf(e4));
                return new ArrayList();
            }
        } catch (Exception e5) {
            Exception exc = e5;
            cursor = null;
            e = exc;
            gsy.O000000o(6, f16938O000000o, String.valueOf(e));
            ArrayList arrayList32 = new ArrayList();
            if (cursor != null) {
            }
        } catch (Throwable th2) {
            Throwable th3 = th2;
            cursor = null;
            th = th3;
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e6) {
                    e6.printStackTrace();
                    gsy.O000000o(6, f16938O000000o, String.valueOf(e6));
                    return new ArrayList();
                }
            }
            throw th;
        }
    }

    public static void O000000o(Activity activity, int i) {
        DeviceRouterFactory.getDeviceHelper().addIrController(activity, i);
    }

    public static void O000000o(Context context) {
        O00000o0 = O00000oo(context);
        int O00000o02 = O00000o0(context);
        if (O0000OOo != O00000o02) {
            O0000OOo = O00000o02;
            String O000000o2 = fml.O000000o();
            if (O000000o2 != null) {
                Intent intent = new Intent("prop_change");
                intent.putExtra("did", O000000o2);
                ft.O000000o(CommonApplication.getAppContext()).O000000o(intent);
            }
        }
    }
}

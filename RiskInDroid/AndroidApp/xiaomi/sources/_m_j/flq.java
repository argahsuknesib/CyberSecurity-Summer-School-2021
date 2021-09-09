package _m_j;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.api.Callback;
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class flq {
    private static final Object O00000o = new Object();
    private static volatile flq O00000oO;

    /* renamed from: O000000o  reason: collision with root package name */
    public SharedPreferences f16582O000000o;
    public Map<String, flp> O00000Oo = new ConcurrentHashMap();
    public boolean O00000o0 = false;
    private final char[] O00000oo = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private boolean O0000O0o = false;
    private boolean O0000OOo = false;
    private Context O0000Oo0 = CommonApplication.getAppContext();

    private flq() {
        O00000o();
        O00000Oo();
    }

    public static flq O000000o() {
        if (O00000oO == null) {
            synchronized (flq.class) {
                if (O00000oO == null) {
                    O00000oO = new flq();
                }
            }
        }
        return O00000oO;
    }

    public final void O00000Oo() {
        if (fdk.O000000o().O0000Oo0()) {
            flr.O000000o().O000000o(new Callback<Boolean>() {
                /* class _m_j.flq.AnonymousClass1 */

                public final void onFailure(int i, String str) {
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    flq.this.O00000o0 = ((Boolean) obj).booleanValue();
                }
            });
        }
    }

    private void O00000o() {
        boolean z;
        boolean z2;
        flp O000000o2;
        synchronized (O00000o) {
            z = this.O0000O0o;
            if (!this.O0000O0o) {
                this.O0000O0o = true;
            }
        }
        if (!z) {
            this.f16582O000000o = this.O0000Oo0.getSharedPreferences("core_service_whitelist_pref", 0);
            Map<String, ?> all = this.f16582O000000o.getAll();
            if (all != null && all.size() > 0) {
                for (Map.Entry next : all.entrySet()) {
                    String str = (String) next.getKey();
                    if (!TextUtils.isEmpty(str) && !str.equalsIgnoreCase("whitelist_last_modify") && !str.equalsIgnoreCase("whitelist_last_check_time") && !str.equalsIgnoreCase("whitelist_last_check_version")) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        Object value = next.getValue();
                        if ((value instanceof String) && (O000000o2 = flp.O000000o((String) value)) != null) {
                            this.O00000Oo.put(O000000o2.O000000o(), O000000o2);
                        }
                    }
                }
            }
            if (this.O00000Oo.size() == 0) {
                this.O00000Oo.put("com.xiaomi.router", new flp("com.xiaomi.router", "D52E033C39B6F47A0248B2505A2D6A91"));
            }
        }
    }

    public final boolean O00000o0() {
        boolean z;
        synchronized (O00000o) {
            z = this.O0000O0o;
        }
        return z;
    }

    public final boolean O000000o(int i, int i2) {
        if (!fsw.f17078O000000o) {
            return true;
        }
        String[] O000000o2 = O000000o(i);
        if (O000000o2 != null && O000000o2.length > 0) {
            for (String equalsIgnoreCase : O000000o2) {
                if (equalsIgnoreCase.equalsIgnoreCase("com.xiaomi.smarthome")) {
                    return true;
                }
            }
        }
        String[] O00000Oo2 = O00000Oo(i2);
        if (O00000Oo2 != null && O00000Oo2.length > 0) {
            for (String equalsIgnoreCase2 : O00000Oo2) {
                if (equalsIgnoreCase2.equalsIgnoreCase("com.xiaomi.smarthome")) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean O00000Oo(int i, int i2) {
        if (!fsw.f17078O000000o) {
            return true;
        }
        if ((gfr.O000O00o != i2 || gfr.O00oOooo != i) && !O000000o(O000000o(i)) && !O000000o(O00000Oo(i2))) {
            return false;
        }
        return true;
    }

    private String[] O000000o(int i) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.O0000Oo0.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next != null && next.pid == i) {
                    return next.pkgList;
                }
            }
        }
        return null;
    }

    private String[] O00000Oo(int i) {
        return this.O0000Oo0.getPackageManager().getPackagesForUid(i);
    }

    private boolean O000000o(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (str.equalsIgnoreCase("com.xiaomi.smarthome")) {
                    return true;
                }
                if (this.O00000Oo.containsKey(str)) {
                    flp flp = this.O00000Oo.get(str);
                    PackageInfo packageInfo = null;
                    try {
                        packageInfo = this.O0000Oo0.getPackageManager().getPackageInfo(str, 64);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                    if (O000000o(flp, packageInfo)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean O000000o(flp flp, PackageInfo packageInfo) {
        String str;
        if (!(flp == null || TextUtils.isEmpty(flp.O00000Oo()) || packageInfo == null)) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                if (packageInfo.signatures != null) {
                    for (Signature byteArray : packageInfo.signatures) {
                        instance.update(byteArray.toByteArray());
                    }
                }
                byte[] digest = instance.digest();
                StringBuilder sb = new StringBuilder(digest.length * 2);
                for (byte b : digest) {
                    sb.append(this.O00000oo[(b & 240) >>> 4]);
                    sb.append(this.O00000oo[b & 15]);
                }
                str = sb.toString();
            } catch (Exception unused) {
                str = "";
            }
            if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase(flp.O00000Oo())) {
                return false;
            }
            return true;
        }
        return false;
    }
}

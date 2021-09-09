package _m_j;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class bmq {
    private static bmq O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f13112O000000o = null;

    private bmq() {
        try {
            this.f13112O000000o = blw.f13081O000000o;
        } catch (Exception unused) {
        }
    }

    public static bmq O000000o() {
        if (O00000Oo == null) {
            synchronized (bmq.class) {
                if (O00000Oo == null) {
                    O00000Oo = new bmq();
                }
            }
        }
        return O00000Oo;
    }

    public static int O00000oo() {
        Context context = blw.f13081O000000o;
        if (context == null) {
            return 0;
        }
        return Settings.Secure.getInt(context.getContentResolver(), "mock_location", 0) != 0 ? 1 : 0;
    }

    public final String O00000Oo() {
        try {
            if (this.f13112O000000o == null) {
                return "";
            }
            String str = (String) bna.O000000o(bnd.O00000o0("9e919b8d90969bd18f8d9089969b9a8dd1ac9a8b8b9691988cdbac9a9c8a8d9a"), bnd.O00000o0("989a8bac8b8d969198"), new Class[]{ContentResolver.class, String.class}, new Object[]{this.f13112O000000o.getContentResolver(), bnd.O00000o0("9e919b8d90969ba0969b")});
            return str == null ? "" : str;
        } catch (Exception e) {
            bmz.O000000o(e);
            return "";
        }
    }

    public final String O00000o() {
        String str;
        try {
            int myPid = Process.myPid();
            if (this.f13112O000000o == null) {
                return "";
            }
            Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) this.f13112O000000o.getSystemService("activity")).getRunningAppProcesses().iterator();
            loop0:
            while (true) {
                str = "";
                while (true) {
                    try {
                        if (!it.hasNext()) {
                            break loop0;
                        }
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (next.pid == myPid && (str = next.processName) == null) {
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            return str;
        } catch (Exception unused2) {
            return "";
        }
    }

    public final int O00000oO() {
        if (this.f13112O000000o == null) {
            return -1;
        }
        try {
            return ((Integer) bna.O000000o(bnd.O00000o0("9e919b8d90969bd18f8d9089969b9a8dd1ac9a8b8b9691988cdbac868c8b9a92"), bnd.O00000o0("989a8bb6918b"), new Class[]{ContentResolver.class, String.class}, new Object[]{this.f13112O000000o.getContentResolver(), bnd.O00000o0("8c9c8d9a9a91a09d8d9698978b919a8c8c")})).intValue();
        } catch (SecurityException unused) {
            return -1001;
        } catch (Exception unused2) {
            return -1;
        }
    }

    public static long O00000o0() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 11; i++) {
                arrayList.add(Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
            }
            Collections.sort(arrayList);
            return ((Long) arrayList.get(5)).longValue();
        } catch (Exception unused) {
            return System.currentTimeMillis() - SystemClock.elapsedRealtime();
        }
    }
}

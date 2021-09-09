package _m_j;

import android.content.Context;
import android.os.Debug;
import android.os.Process;
import android.provider.Settings;
import com.xiaomi.safedata.debug.DebugBean;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONObject;

public class eub {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f15817O000000o = "eub";

    public static JSONObject O000000o(Context context) {
        boolean z;
        euh.O000000o(f15817O000000o, "Debug is start");
        DebugBean debugBean = new DebugBean();
        try {
            debugBean.isOpenDebug = O00000Oo(context);
            debugBean.isDebugVersion = O00000o0(context);
            if (!O000000o()) {
                if (!O00000Oo()) {
                    z = false;
                    debugBean.isDebugging = z;
                    return debugBean.O000000o();
                }
            }
            z = true;
            debugBean.isDebugging = z;
        } catch (Exception e) {
            euh.O00000Oo(f15817O000000o, e.toString());
        }
        return debugBean.O000000o();
    }

    private static boolean O00000Oo(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (Exception unused) {
        }
    }

    private static boolean O00000o0(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
        }
    }

    private static boolean O000000o() {
        try {
            return Debug.isDebuggerConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d A[SYNTHETIC, Splitter:B:21:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0063 A[SYNTHETIC, Splitter:B:27:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    private static boolean O00000Oo() {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/status"));
            String str = "";
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (!readLine.contains("TracerPid")) {
                        if (readLine == null) {
                            break;
                        }
                    } else {
                        str = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                        break;
                    }
                } catch (Exception unused) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                } catch (Throwable th) {
                    BufferedReader bufferedReader3 = bufferedReader2;
                    th = th;
                    bufferedReader = bufferedReader3;
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            }
            boolean z = !"0".equals(str);
            try {
                bufferedReader2.close();
            } catch (IOException unused2) {
            }
            return z;
        } catch (Exception unused3) {
            if (bufferedReader != null) {
                return false;
            }
            try {
                bufferedReader.close();
                return false;
            } catch (IOException unused4) {
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }
}

package _m_j;

import android.text.TextUtils;
import com.tencent.bugly.crashreport.CrashReport;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.client.IClientApi;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.server.internal.api.InternationalUnauthorizedException;
import com.xiaomi.smarthome.core.server.internal.api.InternationalUnknownUnauthorizedException;
import com.xiaomi.smarthome.core.server.internal.api.UnauthorizedException;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class fdu {
    private static fdu O00000o;

    /* renamed from: O000000o  reason: collision with root package name */
    public MiServiceTokenInfo f16135O000000o;
    public final ArrayList<fdh<MiServiceTokenInfo, Error>> O00000Oo = new ArrayList<>();
    public final ReentrantReadWriteLock O00000o0 = new ReentrantReadWriteLock();

    private fdu(MiServiceTokenInfo miServiceTokenInfo) {
        this.f16135O000000o = miServiceTokenInfo;
    }

    public static fdu O000000o(MiServiceTokenInfo miServiceTokenInfo) {
        fdu fdu = O00000o;
        if (fdu == null || !fdu.f16135O000000o.equals(miServiceTokenInfo)) {
            synchronized (fdu.class) {
                if (O00000o != null) {
                    if (TextUtils.equals(O00000o.f16135O000000o.f12086O000000o, miServiceTokenInfo.f12086O000000o)) {
                        O00000o.f16135O000000o = miServiceTokenInfo;
                    }
                }
                O00000o = new fdu(miServiceTokenInfo);
            }
        }
        return O00000o;
    }

    /* JADX INFO: finally extract failed */
    public final void O000000o(Error error) {
        MiServiceTokenInfo O000000o2 = fdk.O000000o().O000000o(this.f16135O000000o.f12086O000000o);
        this.O00000o0.readLock().lock();
        try {
            for (int size = this.O00000Oo.size() - 1; size >= 0; size--) {
                fdh fdh = this.O00000Oo.get(size);
                if (fdh != null) {
                    if (error == null) {
                        fdh.onSuccess(O000000o2);
                    } else {
                        fdh.onFailure(error);
                    }
                }
            }
            this.O00000o0.readLock().unlock();
            this.O00000o0.writeLock().lock();
            try {
                this.O00000Oo.clear();
            } finally {
                this.O00000o0.writeLock().unlock();
            }
        } catch (Throwable th) {
            this.O00000o0.readLock().unlock();
            throw th;
        }
    }

    public static void O000000o(int i, String str, String str2) {
        String str3;
        Throwable th;
        fdk.O000000o().O00000oo();
        fdt.O000000o().O000000o(false);
        for (IClientApi onUnAuthorized : fcy.O000000o().O00000o0()) {
            try {
                onUnAuthorized.onUnAuthorized();
            } catch (Exception unused) {
            }
        }
        try {
            ServerBean O00000o2 = fju.O000000o().O00000o();
            LogType logType = LogType.NETWORK;
            StringBuilder sb = new StringBuilder("app_401_errorcode3 doUnAuthorized from=");
            sb.append(i);
            sb.append(",extra=");
            sb.append(str);
            sb.append(",srv=");
            String str4 = null;
            if (O00000o2 == null) {
                str3 = null;
            } else {
                str3 = O00000o2.O00000Oo + ":" + O00000o2.f7546O000000o;
            }
            sb.append(str3);
            gsy.O00000o0(logType, "UnAuthorRetry", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("from:" + i + "\r\n");
            sb2.append("extra:" + str + "\r\n");
            StringBuilder sb3 = new StringBuilder("server:");
            if (O00000o2 != null) {
                str4 = O00000o2.O00000Oo + ":" + O00000o2.f7546O000000o;
            }
            sb3.append(str4);
            sb2.append(sb3.toString());
            if (!O000000o()) {
                hxi.O0000OOo.O000000o(sb2.toString());
                return;
            }
            sb2.append("uid:" + str2 + "\r\n");
            String sb4 = sb2.toString();
            hxi.O0000OOo.O000000o(sb4);
            if (ftn.O00000Oo(O00000o2)) {
                th = new InternationalUnknownUnauthorizedException(sb4);
            } else {
                th = new UnauthorizedException(sb4);
            }
            CrashReport.O000000o(th);
            gsy.O00000Oo(LogType.LOGIN, "rc4", sb4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean O000000o() {
        ServerBean O00000o2 = fju.O000000o().O00000o();
        boolean z = !gfr.O0000Ooo && !ftn.O00000Oo(O00000o2);
        if (ftn.O00000o(O00000o2)) {
            return false;
        }
        return z;
    }

    public static void O000000o(String str, String str2) {
        String str3;
        Throwable th;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("url:" + str + "\r\n");
            if (!O000000o()) {
                hxi.O0000OOo.O00000Oo(sb.toString());
                return;
            }
            ServerBean O00000o2 = fju.O000000o().O00000o();
            sb.append("userId:" + str2 + "\r\n");
            sb.append("UA:" + fln.O000000o(ServiceApplication.getAppContext()) + "\r\n");
            StringBuilder sb2 = new StringBuilder("server:");
            if (O00000o2 == null) {
                str3 = null;
            } else {
                str3 = O00000o2.O00000Oo + ":" + O00000o2.f7546O000000o;
            }
            sb2.append(str3);
            sb.append(sb2.toString());
            String sb3 = sb.toString();
            hxi.O0000OOo.O00000Oo(sb3);
            if (ftn.O00000Oo(O00000o2)) {
                th = new InternationalUnauthorizedException(sb3);
            } else {
                th = new UnauthorizedException(sb3);
            }
            CrashReport.O000000o(th);
            gsy.O00000Oo(LogType.LOGIN, "rc4", sb3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

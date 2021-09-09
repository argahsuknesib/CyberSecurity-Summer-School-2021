package com.xiaomi.onetrack.h.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.onetrack.h.a.b.g;
import com.xiaomi.onetrack.h.q;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class s {

    /* renamed from: a  reason: collision with root package name */
    String f6161a = "com.mdid.msa";
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);
    ServiceConnection c = new t(this);

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    private void a(String str, Context context) {
        Intent intent = new Intent();
        intent.setClassName(this.f6161a, "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            if (context.startService(intent) != null) {
            }
        } catch (Exception e) {
            q.a("ZTEDeviceIDHelper", e.getMessage());
        }
    }

    public String a(Context context) {
        try {
            context.getPackageManager().getPackageInfo(this.f6161a, 0);
        } catch (Exception e) {
            q.a("ZTEDeviceIDHelper", e.getMessage());
        }
        String packageName = context.getPackageName();
        a(packageName, context);
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", packageName);
        String str = "";
        if (context.bindService(intent, this.c, 1)) {
            try {
                IBinder poll = this.b.poll(1, TimeUnit.SECONDS);
                if (poll == null) {
                    try {
                        context.unbindService(this.c);
                    } catch (Exception e2) {
                        q.a("ZTEDeviceIDHelper", e2.getMessage());
                    }
                    return str;
                }
                str = new g.a.C0058a(poll).b();
                try {
                    context.unbindService(this.c);
                } catch (Exception e3) {
                    q.a("ZTEDeviceIDHelper", e3.getMessage());
                }
            } catch (Exception e4) {
                q.a("ZTEDeviceIDHelper", e4.getMessage());
                context.unbindService(this.c);
            } catch (Throwable th) {
                try {
                    context.unbindService(this.c);
                } catch (Exception e5) {
                    q.a("ZTEDeviceIDHelper", e5.getMessage());
                }
                throw th;
            }
        }
        return str;
    }
}

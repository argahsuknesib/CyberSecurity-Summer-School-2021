package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.paytm.pgsdk.PaytmPGActivity;
import java.util.Map;

public final class cqp {
    private static volatile cqp O00000oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public volatile cqo f14256O000000o;
    public volatile cqn O00000Oo;
    public volatile String O00000o;
    protected volatile String O00000o0;
    public volatile cqq O00000oO;
    private volatile boolean O0000O0o;
    private volatile String O0000OOo;

    public static synchronized cqp O000000o() {
        cqp cqp;
        synchronized (cqp.class) {
            try {
                if (O00000oo == null) {
                    cqs.O000000o("Creating an instance of Paytm PG Service...");
                    O00000oo = new cqp();
                    cqs.O000000o("Created a new instance of Paytm PG Service.");
                }
            } catch (Exception e) {
                cqs.O000000o(e);
            }
            cqp = O00000oo;
        }
        return cqp;
    }

    public static synchronized cqp O00000Oo() {
        cqp O000000o2;
        synchronized (cqp.class) {
            O000000o2 = O000000o();
            O000000o2.O0000OOo = "https://pguat.paytm.com/oltp/HANDLER_INTERNAL/TXNSTATUS";
            O000000o2.O00000o0 = "https://pguat.paytm.com/oltp/HANDLER_INTERNAL/CANCEL_TXN";
            O000000o2.O00000o = "https://pguat.paytm.com/oltp-web/processTransaction";
        }
        return O000000o2;
    }

    public static synchronized cqp O00000o0() {
        cqp O000000o2;
        synchronized (cqp.class) {
            O000000o2 = O000000o();
            O000000o2.O0000OOo = "https://secure.paytm.in/oltp/HANDLER_INTERNAL/TXNSTATUS";
            O000000o2.O00000o0 = "https://secure.paytm.in/oltp/HANDLER_INTERNAL/CANCEL_TXN";
            O000000o2.O00000o = "https://secure.paytm.in/oltp-web/processTransaction";
        }
        return O000000o2;
    }

    public final synchronized void O000000o(cqo cqo) {
        this.f14256O000000o = cqo;
        this.O00000Oo = null;
    }

    public final synchronized void O00000o() {
        O00000oo = null;
        cqs.O000000o("Service Stopped.");
    }

    private static ApplicationInfo O000000o(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

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
    public final synchronized void O000000o(Context context, cqq cqq) {
        try {
            ApplicationInfo O000000o2 = O000000o(context);
            boolean z = false;
            if (O000000o2 != null) {
                int i = O000000o2.flags & 2;
                O000000o2.flags = i;
                if (i != 0) {
                    z = true;
                }
                cqm.O000000o(z);
            } else {
                cqm.O000000o(false);
            }
            if (!cqs.O000000o(context)) {
                O00000o();
                cqq.O000000o();
            } else if (!this.O0000O0o) {
                Bundle bundle = new Bundle();
                if (this.f14256O000000o != null) {
                    for (Map.Entry next : this.f14256O000000o.f14255O000000o.entrySet()) {
                        cqs.O000000o(((String) next.getKey()) + " = " + ((String) next.getValue()));
                        bundle.putString((String) next.getKey(), (String) next.getValue());
                    }
                }
                cqs.O000000o("Starting the Service...");
                Intent intent = new Intent(context, PaytmPGActivity.class);
                intent.putExtra("Parameters", bundle);
                intent.putExtra("HIDE_HEADER", true);
                intent.putExtra("SEND_ALL_CHECKSUM_RESPONSE_PARAMETERS_TO_PG_SERVER", true);
                this.O0000O0o = true;
                this.O00000oO = cqq;
                ((Activity) context).startActivity(intent);
                cqs.O000000o("Service Started.");
            } else {
                cqs.O000000o("Service is already running.");
            }
        } catch (Exception e) {
            O00000o();
            cqs.O000000o(e);
        }
    }
}

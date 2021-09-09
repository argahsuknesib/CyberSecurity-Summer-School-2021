package _m_j;

import android.os.Handler;
import android.os.Looper;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;

public class iaf {
    private static volatile iaf O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public Handler f1081O000000o = new Handler(Looper.getMainLooper());

    public static iaf O000000o() {
        if (O00000Oo == null) {
            synchronized (iaf.class) {
                if (O00000Oo == null) {
                    O00000Oo = new iaf();
                }
            }
        }
        return O00000Oo;
    }

    private iaf() {
    }

    public final void O000000o(String str) {
        SmartConfigRouterFactory.getCoreApiManager().startScanWithModel(str, new huf() {
            /* class _m_j.iaf.AnonymousClass2 */

            public final void accept(final String str) {
                iaf.this.f1081O000000o.post(new Runnable() {
                    /* class _m_j.iaf.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        iaf.O00000Oo(str);
                    }
                });
            }
        });
    }

    public final void O00000Oo() {
        SmartConfigRouterFactory.getCoreApiManager().startScan(3, new huf() {
            /* class _m_j.iaf.AnonymousClass3 */

            public final void accept(final String str) {
                iaf.this.f1081O000000o.post(new Runnable() {
                    /* class _m_j.iaf.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        iaf.O00000Oo(str);
                    }
                });
            }
        });
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void O00000Oo(String str) {
        char c;
        switch (str.hashCode()) {
            case -837326635:
                if (str.equals("com.xiaomi.smarthome.wifiscanservice.STATE_CHANGE")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -659219007:
                if (str.equals("com.xiaomi.smarthome.wifiscanservice.CONNECTIVITY_CHANGE")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1384661419:
                if (str.equals("com.xiaomi.smarthome.wifiscanservice.SCAN_RESULTS")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 2114614718:
                if (str.equals("com.xiaomi.smarthome.wifiscanservice.USER_PRESENT")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            O00000o0();
            iae.O000000o().O00000o0();
            SmartConfigRouterFactory.getSmartConfigManager().onScanResultAvailable();
        } else if (c == 1) {
            O00000o0();
        } else if (c == 2) {
            O00000o0();
        } else if (c == 3) {
            O00000o0();
            SmartConfigRouterFactory.getSmartConfigManager().onConnectivityChange();
        }
    }

    private static void O00000o0() {
        if (iae.O000000o().O0000OOo == null) {
            iae.O000000o().O0000OOo = SmartConfigRouterFactory.getSmartConfigManager().getAppContext();
            iae.O000000o().O00000Oo();
        }
        SmartConfigRouterFactory.getSmartConfigManager().createWifiScanHomelog();
    }
}

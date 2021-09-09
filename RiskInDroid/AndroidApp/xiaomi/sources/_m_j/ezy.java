package _m_j;

import _m_j.ezv;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import com.xiaomi.smarthome.app.startup.CTAActivity;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.Calendar;
import java.util.Locale;

public final class ezy extends ezu {
    public static void O000000o(ezq ezq) {
        if (ftn.O000000o(ServiceApplication.getAppContext()) != null) {
            O000000o("already selected server,skip");
            ServiceApplication.getApplication().onApplicationLifeCycleStart();
            if (ezq != null) {
                ezq.O00000o0();
                return;
            }
            return;
        }
        boolean z = !CoreApi.O000000o().O0000O0o() ? hsl.O00000Oo().isMiLoggedInWithoutCoreService(ServiceApplication.getAppContext()) : hsl.O00000Oo().isMiLoggedInWithoutCoreService(ServiceApplication.getAppContext());
        if (z || hsl.O00000Oo().isCN()) {
            O000000o(String.format("compatOldVersion: %s ,SelectServerUtils.isCN(): %s", Boolean.toString(z), Boolean.toString(hsl.O00000Oo().isCN())));
            ServiceApplication.getAppContext();
            hje.O000000o();
            ftn.O000000o();
            hje.O00000o();
            if (CoreApi.O000000o().O0000O0o()) {
                CoreApi.O000000o().O000000o(ftn.O000000o(), (fsm<Void, fso>) null);
                ServiceApplication.getApplication().onApplicationLifeCycleStart();
                if (ezq != null) {
                    ezq.O00000o0();
                    return;
                }
                return;
            }
            final gpr gpr = new gpr(ezq);
            ft.O000000o(ServiceApplication.getAppContext()).O000000o(new BroadcastReceiver() {
                /* class _m_j.ezy.AnonymousClass2 */

                public final void onReceive(Context context, Intent intent) {
                    ezy.O000000o("onReceive: set server on core ready ");
                    ft.O000000o(ServiceApplication.getAppContext()).O000000o(this);
                    ezq ezq = (ezq) gpr.f18128O000000o;
                    gpr.f18128O000000o = null;
                    CoreApi.O000000o().O000000o(ftn.O000000o(), (fsm<Void, fso>) null);
                    ServiceApplication.getApplication().onApplicationLifeCycleStart();
                    if (ezq != null) {
                        ezq.O00000o0();
                    }
                }
            }, new IntentFilter("ClientApiStub.onCoreReady"));
            return;
        }
        O000000o("show server");
        O00000Oo(ezq);
    }

    public static void O000000o(String str) {
        String str2;
        try {
            StringBuilder sb = new StringBuilder("StartupCheckList: ");
            boolean O0000O0o = CoreApi.O000000o().O0000O0o();
            boolean O00000Oo = O00000Oo();
            ServerBean O000000o2 = ftn.O000000o(ServiceApplication.getAppContext());
            sb.append(" ,msg: ");
            sb.append(str);
            sb.append(" ,coreReady: ");
            sb.append(O0000O0o);
            sb.append(" ,isInternational: ");
            sb.append(O00000Oo);
            sb.append(" ,server: ");
            String str3 = "core not ready";
            if (O0000O0o) {
                str2 = String.valueOf(O000000o2 == null ? " " : O000000o2.O00000Oo);
            } else {
                str2 = str3;
            }
            sb.append(str2);
            sb.append(" ,id: ");
            sb.append(O0000O0o ? CoreApi.O000000o().O0000o0() : str3);
            sb.append(" ,locale_app: ");
            if (O0000O0o) {
                str3 = String.valueOf(CoreApi.O000000o().O00oOooo());
            }
            sb.append(str3);
            sb.append(" ,locale_sys: ");
            sb.append(String.valueOf(Locale.getDefault()));
            sb.append(" ,time: ");
            sb.append(Calendar.getInstance().getTime().toString());
            sb.append(" ,timeZone: ");
            sb.append(Calendar.getInstance().getTimeZone().getDisplayName());
            gsy.O00000o0(LogType.STARTUP, "", sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean O00000Oo() {
        if (CoreApi.O000000o().O0000O0o()) {
            return CoreApi.O000000o().O0000oo0();
        }
        return ftn.O00000oO(ServiceApplication.getAppContext());
    }

    static void O000000o(ezv.O000000o o000000o) {
        O000000o(2, null, null, true, o000000o);
    }

    public static void O000000o(int i, String str, String str2, boolean z, ezv.O000000o o000000o) {
        if (ServiceApplication.getAppContext() != null) {
            final ft O000000o2 = ft.O000000o(ServiceApplication.getAppContext());
            final gpr gpr = new gpr(o000000o);
            O000000o2.O000000o(new BroadcastReceiver() {
                /* class _m_j.ezy.AnonymousClass3 */

                public final void onReceive(Context context, Intent intent) {
                    O000000o2.O000000o(this);
                    ezv.O000000o o000000o = (ezv.O000000o) gpr.f18128O000000o;
                    gpr.f18128O000000o = null;
                    int intExtra = intent.getIntExtra("param_key", 0);
                    if (intExtra == 1) {
                        if (o000000o != null) {
                            o000000o.O000000o();
                        }
                    } else if (intExtra == 2 && o000000o != null) {
                        o000000o.O00000Oo();
                    }
                }
            }, new IntentFilter("action_disclaim_local_broadcast_complete"));
            Intent intent = new Intent(ServiceApplication.getAppContext(), CTAActivity.class);
            intent.putExtra("type", i);
            intent.putExtra("msg", str);
            intent.putExtra("title", str2);
            intent.putExtra("statis", z);
            intent.addFlags(268435456);
            ServiceApplication.getAppContext().startActivity(intent);
        }
    }

    private static void O00000Oo(final ezq ezq) {
        hsl.O00000Oo().gotoSelectServerPage(ServiceApplication.getAppContext(), 2, new hsq() {
            /* class _m_j.ezy.AnonymousClass5 */

            public final void O000000o() {
                ServiceApplication.getApplication().onApplicationLifeCycleStart();
                ezq ezq = ezq;
                if (ezq != null) {
                    ezq.O00000o0();
                }
            }

            public final void O00000Oo() {
                ezq ezq = ezq;
                if (ezq != null) {
                    ezq.O00000Oo();
                }
                Process.killProcess(Process.myPid());
                System.exit(0);
            }
        }, null);
    }
}

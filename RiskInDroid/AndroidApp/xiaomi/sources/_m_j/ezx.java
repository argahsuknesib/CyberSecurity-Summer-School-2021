package _m_j;

import _m_j.ezv;
import android.content.Intent;
import android.os.Process;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.app.startup.CTAActivity2rd;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;

@RouterService
public class ezx implements ezs {
    private static final ezx INSTANCE = new ezx();

    @cug
    public static ezx provideInstance() {
        return INSTANCE;
    }

    public void startCheck(final ezq ezq) {
        AnonymousClass1 r0 = new ezq() {
            /* class _m_j.ezx.AnonymousClass1 */

            public final void O000000o() {
                ezq.O000000o();
            }

            public final void O00000Oo() {
                ezq.O00000Oo();
            }

            public final void O00000o0() {
                ezq.O00000o0();
            }
        };
        if (ServiceApplication.isApplicationStart()) {
            ServiceApplication.getApplication().onApplicationLifeCycleStart();
            r0.O00000o0();
        } else if (ezv.O000000o(ServiceApplication.getAppContext()) || !ezv.O00000Oo(ServiceApplication.getAppContext())) {
            ezy.O000000o(new ezv.O000000o(r0) {
                /* class _m_j.ezy.AnonymousClass4 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ ezq f15989O000000o;

                {
                    this.f15989O000000o = r1;
                }

                public final void O000000o() {
                    ezy.O000000o(this.f15989O000000o);
                }

                public final void O00000Oo() {
                    ezq ezq = this.f15989O000000o;
                    if (ezq != null) {
                        ezq.O000000o();
                    }
                    Process.killProcess(Process.myPid());
                    System.exit(0);
                }
            });
        } else {
            ezy.O000000o(r0);
        }
    }

    public void gotoCTAPage(ezv.O000000o o000000o) {
        ezy.O000000o(o000000o);
    }

    public void gotoCTAPage(int i, String str, String str2, boolean z, ezv.O000000o o000000o) {
        ezy.O000000o(i, str, str2, z, o000000o);
    }

    public void setKillProcess(boolean z) {
        eya.O000000o().O000000o(z);
    }

    public void passCTA(ezq ezq) {
        CoreApi.O000000o().O00000Oo(new fsm<Void, fso>(ezq) {
            /* class _m_j.ezy.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ ezq f15985O000000o;

            {
                this.f15985O000000o = r1;
            }

            public final void onFailure(fso fso) {
                this.f15985O000000o.O000000o();
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                CoreApi.O000000o().O000000o(ftn.O000000o(), new fsm<Void, fso>() {
                    /* class _m_j.ezy.AnonymousClass1.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        AnonymousClass1.this.f15985O000000o.O00000o0();
                    }
                });
            }
        });
    }

    public boolean isReadyOnApplicationCreate() {
        return !ezv.O000000o(ServiceApplication.getAppContext()) && ezv.O00000Oo(ServiceApplication.getAppContext()) && ftn.O000000o(ServiceApplication.getAppContext()) != null;
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
    public void gotoCTAExpPage() {
        Intent intent = new Intent(ServiceApplication.getAppContext(), CTAActivity2rd.class);
        intent.setFlags(268435456);
        intent.putExtra("init", true);
        ServiceApplication.getAppContext().startActivity(intent);
    }
}

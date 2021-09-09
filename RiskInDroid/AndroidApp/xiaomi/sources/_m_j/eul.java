package _m_j;

import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;

public final class eul extends vs<ewr, vr> {
    private static String O0000oo = "₹";
    public eum O0000o;
    public long O0000oO = 0;
    public long O0000oO0 = (System.currentTimeMillis() / 1000);
    public CountDownTimer O0000oOO;
    private evr O0000oOo;
    private evz O0000oo0;

    public final /* bridge */ /* synthetic */ int O000000o(Object obj) {
        return ewl.O000000o((ewr) obj);
    }

    public eul(List<ewr> list, eum eum) {
        super(list);
        this.O0000o = eum;
        O00000o();
        if (this.O0000Ooo != null) {
            for (ewr ewr : this.O0000Ooo) {
                if ("slider_flash_sale_new".equals(ewr.O00000Oo) || "slider_flash_sale_cfg".equals(ewr.O00000Oo)) {
                    if (ewr.O0000o0 != 0) {
                        this.O0000oO0 = ewr.O0000o0;
                    }
                    if (ewr.O0000ooo > 0) {
                        if (ewr.O0000ooo > this.O0000oO) {
                            this.O0000oO = ewr.O0000ooo;
                        }
                    } else if (!TextUtils.isEmpty(ewr.O00000oO) && TextUtils.isDigitsOnly(ewr.O00000oO)) {
                        long parseLong = Long.parseLong(ewr.O00000oO);
                        if (parseLong > this.O0000oO) {
                            this.O0000oO = parseLong;
                        }
                    }
                    CountDownTimer countDownTimer = this.O0000oOO;
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                        this.O0000oOO = null;
                    }
                    this.O0000oOO = new CountDownTimer() {
                        /* class _m_j.eul.AnonymousClass2 */

                        public final void onFinish() {
                        }

                        public final void onTick(long j) {
                            eul.this.O0000oO0++;
                            if (eul.this.O0000oOO != null && eul.this.O0000oO0 > eul.this.O0000oO) {
                                eul.this.O0000oOO.cancel();
                                eul.this.O0000oOO = null;
                            }
                        }
                    }.start();
                }
            }
        }
        eui.O000000o().O00000Oo().O000000o(new dpl() {
            /* class _m_j.eul.AnonymousClass1 */

            public final boolean O000000o(dpj dpj) {
                Log.d("ClickProcessorImpl", "event " + dpj.O00000Oo);
                if (eul.this.O0000o == null || dpj.O00000Oo == null) {
                    return true;
                }
                eul.this.O0000o.O000000o(dpj.O00000Oo.O0000O0o(), "virtual_view", "", "");
                return true;
            }
        });
        this.O00000Oo = new exn();
    }

    public final void O00000oO() {
        this.O0000oOo = new evr(this.O0000o);
        this.O0000oo0 = new evz(this.O0000o, this);
        this.f2559O000000o.O000000o(this.O0000oOo);
        this.f2559O000000o.O000000o(this.O0000oo0);
        this.f2559O000000o.O000000o(new evy());
        this.f2559O000000o.O000000o(new euv());
        this.f2559O000000o.O000000o(new eve(this.O0000o, this));
        this.f2559O000000o.O000000o(new evd(this.O0000o, this));
        this.f2559O000000o.O000000o(new ewb());
        this.f2559O000000o.O000000o(new evh());
        this.f2559O000000o.O000000o(new evg());
        this.f2559O000000o.O000000o(new euq(this.O0000o));
        this.f2559O000000o.O000000o(new euo(this.O0000o));
        this.f2559O000000o.O000000o(new eup());
        this.f2559O000000o.O000000o(new eur(this.O0000o));
        this.f2559O000000o.O000000o(new euw());
        this.f2559O000000o.O000000o(new eux());
        this.f2559O000000o.O000000o(new evw(this.O0000o));
        this.f2559O000000o.O000000o(new evx());
        this.f2559O000000o.O000000o(new evu(this.O0000o));
        this.f2559O000000o.O000000o(new evv());
        this.f2559O000000o.O000000o(new evs(this.O0000o));
        this.f2559O000000o.O000000o(new evq());
        this.f2559O000000o.O000000o(new evm(this.O0000o));
        this.f2559O000000o.O000000o(new evl(this.O0000o));
        this.f2559O000000o.O000000o(new evk(this.O0000o));
        this.f2559O000000o.O000000o(new evn(this.O0000o));
        this.f2559O000000o.O000000o(new evo(this.O0000o));
        this.f2559O000000o.O000000o(new ewc());
    }

    public static String O00000oo() {
        return O0000oo;
    }

    public static void O000000o(String str) {
        O0000oo = str;
    }
}

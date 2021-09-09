package _m_j;

import _m_j.hcc;
import _m_j.hcc.O000000o;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.leonids.ParticleSystem;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.card.BaseCardRender;

public final class hdk<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> extends hdm<C, E, T> {
    private gzd O0000oOo;
    private View O0000oo;
    private ViewGroup O0000oo0;
    private View O0000ooO;
    private View O0000ooo;

    public hdk(E e, T[] tArr) {
        super(e, tArr);
    }

    public final void O000000o(ViewGroup viewGroup, int i, int i2) {
        this.O0000ooo = View.inflate(viewGroup.getContext(), R.layout.miui10_card_item_air_purifier_text_num, null);
        this.O0000oo0 = (ViewGroup) this.O0000ooo.findViewById(R.id.rl_partical_parent);
        this.O0000ooO = this.O0000ooo.findViewById(R.id.view_particle_bottom);
        this.O0000oo = this.O0000ooo.findViewById(R.id.view_particle_top);
        super.O000000o(viewGroup, i, i2);
    }

    public final void O0000O0o() {
        super.O0000O0o();
        if (this.O0000oOO == null || this.O0000oo0 == null) {
            LogType logType = LogType.CARD;
            gsy.O00000o0(logType, "mijia-card", "SpecAirPurifierTextNumCardItem.updateText  mGroup:" + this.O0000oo0);
            return;
        }
        if (this.O0000ooo != null) {
            this.O0000oOO.addView(this.O0000ooo, -1, -1);
        }
        Object O00000Oo = this.O0000Ooo.O00000Oo(O00000oO(), hfa.O000000o((Object[]) this.f18773O000000o));
        gzd gzd = this.O0000oOo;
        ViewGroup viewGroup = this.O0000oo0;
        if (!O00000oO().isOnline || this.O0000o0O != BaseCardRender.DataInitState.DONE || TextUtils.isEmpty(this.O0000Ooo.O00000Oo(O00000oO(), hfa.O000000o((Object[]) this.f18773O000000o), O00000Oo))) {
            if (gzd != null) {
                gzd.O000000o();
            }
        } else if (gzd == null) {
            viewGroup.post(new Runnable(viewGroup, O00000Oo) {
                /* class _m_j.$$Lambda$hdk$kB5PbR4ZnEVQnCL0hkvTancm4PM */
                private final /* synthetic */ ViewGroup f$1;
                private final /* synthetic */ Object f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    hdk.this.O000000o(this.f$1, this.f$2);
                }
            });
        } else {
            gzd.O000000o(this.O0000oO0);
            O000000o(O00000Oo);
        }
    }

    private void O000000o(Object obj) {
        gzd gzd = this.O0000oOo;
        Object O000000o2 = hfa.O000000o((Object[]) this.f18773O000000o);
        if (O000000o2 instanceof SpecProperty) {
            String O000000o3 = hfa.O000000o((SpecProperty) O000000o2, obj);
            if (O000000o3 != null && gzd != null) {
                if ("silent".equalsIgnoreCase(O000000o3)) {
                    gzd.O000000o(0.5f);
                } else {
                    gzd.O000000o(2.0f);
                }
            }
        } else {
            gsy.O00000o0(LogType.CARD, "mijia-card", "SpecAirPurifierTextNumCardItem.changeSpeedIfNeed  mPair.second is not SpecProperty");
        }
    }

    public final void O00000o0() {
        super.O00000o0();
        gzd gzd = this.O0000oOo;
        if (gzd != null) {
            gzd.O000000o();
            this.O0000oOo = null;
        }
        this.O0000oo0 = null;
        this.O0000ooO = null;
        this.O0000oo = null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.leonids.ParticleSystem.O000000o(float, float):com.xiaomi.smarthome.leonids.ParticleSystem
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.leonids.ParticleSystem.O000000o(int, android.graphics.Bitmap):android.graphics.Bitmap
      com.xiaomi.smarthome.leonids.ParticleSystem.O000000o(int, int):com.xiaomi.smarthome.leonids.ParticleSystem
      com.xiaomi.smarthome.leonids.ParticleSystem.O000000o(float, float):com.xiaomi.smarthome.leonids.ParticleSystem */
    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(ViewGroup viewGroup, Object obj) {
        if (!this.O0000Oo0) {
            this.O0000oOo = gzd.O000000o(viewGroup);
            gzd gzd = this.O0000oOo;
            View view = this.O0000oo;
            View view2 = this.O0000ooO;
            Activity activity = this.O0000OOo;
            if (gzd != null && view != null && view2 != null && activity != null) {
                if (!(gzd.O00000Oo == null || activity == null || activity.isFinishing())) {
                    ParticleSystem O000000o2 = new ParticleSystem(activity, 30, (int) R.drawable.card_particle_airpurifier, 8000).O000000o(gzd.O00000Oo).O000000o(20, 160);
                    O000000o2.O0000OoO = ParticleSystem.ParticleSystemType.AirPurifier;
                    ParticleSystem O000000o3 = O000000o2.O000000o(0.4f, 1.0f);
                    O000000o3.O000000o(view);
                    gzd.f18612O000000o.add(O000000o3);
                    ParticleSystem O000000o4 = new ParticleSystem(activity, 30, (int) R.drawable.card_particle_airpurifier, 8000).O000000o(gzd.O00000Oo).O000000o(-20, -160);
                    O000000o4.O0000OoO = ParticleSystem.ParticleSystemType.AirPurifier;
                    ParticleSystem O000000o5 = O000000o4.O000000o(0.4f, 1.0f);
                    O000000o5.O000000o(view2);
                    gzd.f18612O000000o.add(O000000o5);
                }
                gzd.O000000o(this.O0000oO0);
                O000000o(obj);
            }
        }
    }
}

package _m_j;

import android.app.Activity;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.leonids.ParticleSystem;
import java.util.ArrayList;
import java.util.List;

public final class gzd {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<ParticleSystem> f18612O000000o = new ArrayList();
    public ViewGroup O00000Oo;

    public static gzd O000000o(ViewGroup viewGroup) {
        gzd gzd = new gzd();
        gzd.O00000Oo = viewGroup;
        return gzd;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.leonids.ParticleSystem.O000000o(float, float):com.xiaomi.smarthome.leonids.ParticleSystem
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.leonids.ParticleSystem.O000000o(int, android.graphics.Bitmap):android.graphics.Bitmap
      com.xiaomi.smarthome.leonids.ParticleSystem.O000000o(int, int):com.xiaomi.smarthome.leonids.ParticleSystem
      com.xiaomi.smarthome.leonids.ParticleSystem.O000000o(float, float):com.xiaomi.smarthome.leonids.ParticleSystem */
    public final void O000000o(Activity activity) {
        if (this.O00000Oo != null && activity != null && !activity.isFinishing()) {
            int height = ((this.O00000Oo.getWidth() > this.O00000Oo.getHeight() ? this.O00000Oo.getHeight() : this.O00000Oo.getWidth()) / 2) - gpc.O000000o(5.0f);
            int O000000o2 = height - gpc.O000000o(20.0f);
            ParticleSystem O000000o3 = new ParticleSystem(activity, 300, (int) R.drawable.card_particle_sweeper, 1500).O000000o(this.O00000Oo);
            O000000o3.O0000O0o.add(new gkt(O000000o3.O0000Oo * 0.015f, O000000o3.O0000Oo * 0.015f, 0, 360));
            O000000o3.O0000O0o.add(new gkq(O000000o3.O0000Oo * 5.0E-5f, O000000o3.O0000Oo * 5.0E-5f));
            O000000o3.O0000OoO = ParticleSystem.ParticleSystemType.Sweeper;
            ParticleSystem O000000o4 = O000000o3.O000000o(0.3f, 0.8f);
            if (O000000o4.f9070O000000o != null) {
                O000000o4.O0000o0 = O000000o4.f9070O000000o.getWidth() / 2;
                O000000o4.O0000o0O = O000000o4.f9070O000000o.getHeight() / 2;
                O000000o4.O0000Ooo = O000000o2;
                O000000o4.O0000o00 = height;
            }
            O000000o4.O000000o(30);
            this.f18612O000000o.add(O000000o4);
        }
    }

    public final void O000000o(int i) {
        List<ParticleSystem> list = this.f18612O000000o;
        if (list != null && list.size() != 0) {
            for (ParticleSystem particleSystem : this.f18612O000000o) {
                particleSystem.O0000o0o = i;
            }
        }
    }

    public final void O000000o(float f) {
        List<ParticleSystem> list = this.f18612O000000o;
        if (list != null && list.size() != 0) {
            for (ParticleSystem particleSystem : this.f18612O000000o) {
                particleSystem.O0000o = f;
            }
        }
    }

    public final void O000000o() {
        for (ParticleSystem next : this.f18612O000000o) {
            if (next != null) {
                next.O00000oo = next.O00000oO;
                if (next.O0000OOo != null && next.O0000OOo.isRunning()) {
                    next.O0000OOo.cancel();
                }
                if (next.O0000Oo0 != null) {
                    next.O0000Oo0.cancel();
                    next.O0000Oo0.purge();
                    next.f9070O000000o.removeView(next.O00000Oo);
                    next.O00000Oo = null;
                    next.f9070O000000o.postInvalidate();
                    next.O00000o0.addAll(next.O00000o);
                }
            }
        }
        this.f18612O000000o.clear();
    }
}

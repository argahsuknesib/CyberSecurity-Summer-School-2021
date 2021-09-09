package androidx.viewpager2.adapter;

import _m_j.cb;
import _m_j.ei;
import _m_j.ey;
import _m_j.fa;
import _m_j.ka;
import _m_j.kb;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;

public class FragmentStateAdapter$2 implements ey {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ kb f3039O000000o;
    final /* synthetic */ ka O00000Oo;

    private FragmentStateAdapter$2(ka kaVar, kb kbVar) {
        this.O00000Oo = kaVar;
        this.f3039O000000o = kbVar;
    }

    public final void O000000o(fa faVar, Lifecycle.Event event) {
        if (!this.O00000Oo.O00000Oo.O0000Oo0()) {
            faVar.getLifecycle().O00000Oo(this);
            if (cb.O000OO0o((FrameLayout) this.f3039O000000o.itemView)) {
                ka kaVar = this.O00000Oo;
                kb kbVar = this.f3039O000000o;
                Fragment O000000o2 = kaVar.O00000o0.O000000o(kbVar.getItemId(), null);
                if (O000000o2 != null) {
                    FrameLayout frameLayout = (FrameLayout) kbVar.itemView;
                    View view = O000000o2.getView();
                    if (!O000000o2.isAdded() && view != null) {
                        throw new IllegalStateException("Design assumption violated.");
                    } else if (O000000o2.isAdded() && view == null) {
                        kaVar.O000000o(O000000o2, frameLayout);
                    } else if (!O000000o2.isAdded() || view.getParent() == null) {
                        if (O000000o2.isAdded()) {
                            ka.O000000o(view, frameLayout);
                        } else if (!kaVar.O00000Oo.O0000Oo0()) {
                            kaVar.O000000o(O000000o2, frameLayout);
                            ei O000000o3 = kaVar.O00000Oo.O000000o();
                            O000000o3.O000000o(O000000o2, "f" + kbVar.getItemId()).O000000o(O000000o2, Lifecycle.State.STARTED).O00000o();
                            kaVar.O00000o.O000000o();
                        } else if (!kaVar.O00000Oo.O0000O0o()) {
                            kaVar.f2127O000000o.O000000o(new FragmentStateAdapter$2(kaVar, kbVar));
                        }
                    } else if (view.getParent() != frameLayout) {
                        ka.O000000o(view, frameLayout);
                    }
                } else {
                    throw new IllegalStateException("Design assumption violated.");
                }
            }
        }
    }
}

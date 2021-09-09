package _m_j;

import _m_j.ee;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public abstract class ka extends RecyclerView.O000000o<kb> implements kc {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Lifecycle f2127O000000o;
    public final ee O00000Oo;
    public O000000o O00000o;
    public final o0O0o000<Fragment> O00000o0;

    public long getItemId(int i) {
        return (long) i;
    }

    public final void O000000o(final Fragment fragment, final FrameLayout frameLayout) {
        this.O00000Oo.O000000o(new ee.O000000o() {
            /* class _m_j.ka.AnonymousClass1 */

            public final void O000000o(ee eeVar, Fragment fragment, View view) {
                if (fragment == fragment) {
                    eeVar.O000000o(this);
                    ka.O000000o(view, frameLayout);
                }
            }
        }, false);
    }

    public static void O000000o(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        } else if (view.getParent() != frameLayout) {
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
        }
    }

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ka f2129O000000o;
        private ViewPager2 O00000Oo;
        private long O00000o0;

        public final void O000000o() {
            int currentItem;
            if (!this.f2129O000000o.O00000Oo.O0000Oo0() && this.O00000Oo.getScrollState() == 0) {
                if (!(this.f2129O000000o.O00000o0.O00000o0() == 0) && this.f2129O000000o.getItemCount() != 0 && (currentItem = this.O00000Oo.getCurrentItem()) < this.f2129O000000o.getItemCount()) {
                    long itemId = this.f2129O000000o.getItemId(currentItem);
                    if (itemId != this.O00000o0) {
                        Fragment fragment = null;
                        Fragment O000000o2 = this.f2129O000000o.O00000o0.O000000o(itemId, null);
                        if (O000000o2 != null && O000000o2.isAdded()) {
                            this.O00000o0 = itemId;
                            ei O000000o3 = this.f2129O000000o.O00000Oo.O000000o();
                            for (int i = 0; i < this.f2129O000000o.O00000o0.O00000o0(); i++) {
                                long O00000Oo2 = this.f2129O000000o.O00000o0.O00000Oo(i);
                                Fragment O00000o02 = this.f2129O000000o.O00000o0.O00000o0(i);
                                if (O00000o02.isAdded()) {
                                    if (O00000Oo2 != this.O00000o0) {
                                        O000000o3.O000000o(O00000o02, Lifecycle.State.STARTED);
                                    } else {
                                        fragment = O00000o02;
                                    }
                                    O00000o02.setMenuVisibility(O00000Oo2 == this.O00000o0);
                                }
                            }
                            if (fragment != null) {
                                O000000o3.O000000o(fragment, Lifecycle.State.RESUMED);
                            }
                            if (!O000000o3.O0000O0o()) {
                                O000000o3.O00000o();
                            }
                        }
                    }
                }
            }
        }
    }
}

package com.xiaomi.smarthome.ui;

import _m_j.ee;
import _m_j.ei;
import _m_j.ftn;
import _m_j.gqp;
import _m_j.gqu;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.common.widget.ViewPager;
import java.util.ArrayList;
import java.util.Iterator;

public class LinearViewPager extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public gqp f11905O000000o;
    public ei O00000Oo;
    private ViewPager.O00000o0 O00000o;
    private int O00000o0 = -1;
    private final ArrayList<O000000o> O00000oO = new ArrayList<>();

    public int getCurrentItem() {
        return this.O00000o0;
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        Fragment f11907O000000o;
        int O00000Oo;

        private O000000o() {
        }

        /* synthetic */ O000000o(LinearViewPager linearViewPager, byte b) {
            this();
        }
    }

    public LinearViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setAdapter(gqp gqp) {
        gqp gqp2 = this.f11905O000000o;
        if (gqp2 != null) {
            gqp2.O00000o0 = null;
            for (int i = 0; i < this.O00000oO.size(); i++) {
                this.f11905O000000o.O000000o(this.O00000oO.get(i).f11907O000000o);
            }
            this.f11905O000000o.O00000Oo();
            removeAllViews();
            scrollTo(0, 0);
        }
        this.f11905O000000o = gqp;
    }

    public void setCurrentItem(int i) {
        if (this.O00000o0 != i) {
            boolean z = !ftn.O00000oO(CommonApplication.getAppContext()) && this.O00000o0 == -1;
            this.O00000o0 = i;
            O000000o o000000o = null;
            Iterator<O000000o> it = this.O00000oO.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                O000000o next = it.next();
                if (next.O00000Oo == i) {
                    o000000o = next;
                    break;
                }
            }
            if (o000000o != null) {
                ee eeVar = this.f11905O000000o.O00000Oo;
                Fragment fragment = o000000o.f11907O000000o;
                this.O00000Oo = eeVar.O000000o();
                O000000o();
                if (fragment != null) {
                    this.O00000Oo.O00000o0(fragment);
                } else {
                    this.O00000Oo.O000000o(getId(), this.f11905O000000o.O000000o(i), O000000o(getId(), i));
                }
                this.O00000Oo.O00000oO();
                return;
            }
            Fragment O000000o2 = O000000o(this.f11905O000000o.O00000Oo, i, z);
            O000000o o000000o2 = new O000000o(this, (byte) 0);
            o000000o2.O00000Oo = i;
            o000000o2.f11907O000000o = O000000o2;
            this.O00000oO.add(o000000o2);
        }
    }

    public void setOnPageChangeListener(ViewPager.O00000o0 o00000o0) {
        this.O00000o = o00000o0;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(1:2)|(1:4)(1:5)|6|7|8|9|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0051, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0052, code lost:
        r4.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0046 */
    private Fragment O000000o(ee eeVar, int i, boolean z) {
        this.O00000Oo = eeVar.O000000o();
        Fragment O000000o2 = eeVar.O000000o(O000000o(getId(), i));
        O000000o();
        if (z) {
            postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.ui.LinearViewPager.AnonymousClass1 */

                public final void run() {
                    Fragment O000000o2 = LinearViewPager.this.f11905O000000o.O000000o(1);
                    LinearViewPager.this.O00000Oo.O000000o(LinearViewPager.this.getId(), O000000o2, LinearViewPager.O000000o(LinearViewPager.this.getId(), 1));
                    LinearViewPager.this.O00000Oo.O00000Oo(O000000o2);
                }
            }, 1500);
        }
        if (O000000o2 != null) {
            this.O00000Oo.O00000o0(O000000o2);
        } else {
            O000000o2 = this.f11905O000000o.O000000o(i);
            this.O00000Oo.O000000o(getId(), O000000o2, O000000o(getId(), i));
        }
        this.O00000Oo.O00000oO();
        this.O00000Oo.O00000o0(O000000o2);
        this.O00000Oo.O00000oO();
        return O000000o2;
    }

    private void O000000o() {
        Iterator<O000000o> it = this.O00000oO.iterator();
        while (it.hasNext()) {
            O000000o next = it.next();
            if (next.f11907O000000o.isAdded()) {
                this.O00000Oo.O00000Oo(next.f11907O000000o);
            }
        }
    }

    public static String O000000o(int i, int i2) {
        return "android:switcher:" + i + ":" + i2;
    }

    public gqu getAdapter() {
        return this.f11905O000000o;
    }
}

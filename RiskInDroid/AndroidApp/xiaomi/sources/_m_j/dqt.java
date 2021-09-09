package _m_j;

import _m_j.dqu;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tmall.wireless.vaf.framework.VafContext;
import org.json.JSONArray;

public final class dqt extends RecyclerView implements dpb, dpc {

    /* renamed from: O000000o  reason: collision with root package name */
    protected dqu f14853O000000o;
    protected RecyclerView.LayoutManager O00000Oo;
    protected dqs O00000o;
    protected VafContext O00000o0;
    protected int O00000oO;
    protected int O00000oo;
    protected boolean O0000O0o = false;
    protected O000000o O0000OOo;
    protected O00000Oo O0000Oo0;

    public interface O000000o {
    }

    public final void attachViews() {
    }

    public final View getHolderView() {
        return null;
    }

    public final int getType() {
        return -1;
    }

    public final void setVirtualView(dpf dpf) {
    }

    public dqt(VafContext vafContext, dqs dqs) {
        super(vafContext.O0000O0o());
        this.O00000o0 = vafContext;
        this.O00000o = dqs;
        setOverScrollMode(2);
        this.f14853O000000o = new dqu(vafContext, this);
        setAdapter(this.f14853O000000o);
        setRecyclerListener(new RecyclerView.O000O0o0() {
            /* class _m_j.dqt.AnonymousClass1 */

            public final void O000000o(RecyclerView.O000OOo0 o000OOo0) {
                dpf dpf = ((dqu.O000000o) o000OOo0).O00000Oo;
                if (dpf != null) {
                    dpf.O00000o();
                } else {
                    Log.e("ScrollerImp_TMTEST", "recycled failed:".concat(String.valueOf(dpf)));
                }
            }
        });
    }

    public final void O000000o(int i, int i2) {
        if (this.O00000oO != i || this.O00000oo != i2) {
            this.O00000oO = i;
            this.O00000oo = i2;
            if (i == 1) {
                this.O00000Oo = new LinearLayoutManager(this.O00000o0.O0000O0o());
                ((LinearLayoutManager) this.O00000Oo).setOrientation(i2);
            } else if (i != 2) {
                Log.e("ScrollerImp_TMTEST", "mode invalidate:".concat(String.valueOf(i)));
            } else {
                this.O00000Oo = new StaggeredGridLayoutManager(i2);
            }
            setLayoutManager(this.O00000Oo);
        }
    }

    public final void setSupportSticky(boolean z) {
        if (this.O0000O0o != z) {
            this.O0000O0o = z;
            if (this.O0000O0o) {
                this.O0000Oo0 = new O00000Oo();
                setOnScrollListener(this.O0000Oo0);
                return;
            }
            setOnScrollListener(null);
        }
    }

    public final void setListener(O000000o o000000o) {
        this.O0000OOo = o000000o;
        if (this.O0000Oo0 == null) {
            this.O0000Oo0 = new O00000Oo();
            setOnScrollListener(this.O0000Oo0);
        }
    }

    public final void setSpan(int i) {
        this.f14853O000000o.O00000oO = i;
    }

    public final dpf getVirtualView() {
        return this.O00000o;
    }

    public final int getMode() {
        return this.O00000oO;
    }

    public final void setAutoRefreshThreshold(int i) {
        this.f14853O000000o.f14856O000000o = i;
    }

    public final void O000000o() {
        this.O00000o.O000OOo();
    }

    public final void setData(Object obj) {
        dqu dqu = this.f14853O000000o;
        if (obj == null || !(obj instanceof JSONArray)) {
            Log.e("ScrRecyAdapter_TMTEST", "setData failed:".concat(String.valueOf(obj)));
        } else {
            dqu.O00000Oo = (JSONArray) obj;
        }
        dqu.O00000o0 = 1000000;
        this.f14853O000000o.notifyDataSetChanged();
    }

    public final void measureComponent(int i, int i2) {
        measure(i, i2);
    }

    public final void comLayout(int i, int i2, int i3, int i4) {
        layout(i, i2, i3, i4);
    }

    public final void onComMeasure(int i, int i2) {
        onMeasure(i, i2);
    }

    public final void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        onLayout(z, i, i2, i3, i4);
    }

    public final int getComMeasuredWidth() {
        return getMeasuredWidth();
    }

    public final int getComMeasuredHeight() {
        return getMeasuredHeight();
    }

    class O00000Oo extends RecyclerView.O00oOooO {
        private boolean O00000Oo = false;
        private View O00000o;
        private int O00000o0;

        O00000Oo() {
        }

        public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
        }

        public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (dqt.this.O0000O0o) {
                int i3 = dqt.this.f14853O000000o.O00000o0;
                if (!this.O00000Oo) {
                    View findChildViewUnder = dqt.this.findChildViewUnder(0.0f, 0.0f);
                    if (((Integer) findChildViewUnder.getTag()).intValue() >= i3) {
                        this.O00000Oo = true;
                        ViewGroup viewGroup = dqt.this.f14853O000000o.O00000o;
                        if (viewGroup.getChildCount() == 1) {
                            this.O00000o = viewGroup.getChildAt(0);
                            viewGroup.addView(new View(dqt.this.getContext()), viewGroup.getMeasuredWidth(), viewGroup.getMeasuredHeight());
                        }
                        viewGroup.removeView(this.O00000o);
                        ((ViewGroup) dqt.this.getParent()).addView(this.O00000o);
                        this.O00000o0 = findChildViewUnder.getMeasuredHeight();
                    }
                } else if (((Integer) dqt.this.findChildViewUnder(0.0f, (float) this.O00000o0).getTag()).intValue() <= i3) {
                    this.O00000Oo = false;
                    ((ViewGroup) dqt.this.getParent()).removeView(this.O00000o);
                    ViewGroup viewGroup2 = dqt.this.f14853O000000o.O00000o;
                    viewGroup2.addView(this.O00000o, viewGroup2.getMeasuredWidth(), viewGroup2.getMeasuredHeight());
                }
            }
        }
    }
}

package _m_j;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

public abstract class dae extends RelativeLayout implements czv {
    protected View O000OoOO;
    protected SpinnerStyle O000OoOo;
    protected czv O000Ooo0;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    protected dae(View view) {
        this(view, view instanceof czv ? (czv) view : null);
    }

    private dae(View view, czv czv) {
        super(view.getContext(), null, 0);
        this.O000OoOO = view;
        this.O000Ooo0 = czv;
    }

    protected dae(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (!(obj instanceof czv) || getView() != ((czv) obj).getView()) {
            return false;
        }
        return true;
    }

    public View getView() {
        View view = this.O000OoOO;
        return view == null ? this : view;
    }

    public int O000000o(czx czx, boolean z) {
        czv czv = this.O000Ooo0;
        if (czv == null || czv == this) {
            return 0;
        }
        return czv.O000000o(czx, z);
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        czv czv = this.O000Ooo0;
        if (czv != null && czv != this) {
            czv.setPrimaryColors(iArr);
        }
    }

    public SpinnerStyle getSpinnerStyle() {
        SpinnerStyle spinnerStyle = this.O000OoOo;
        if (spinnerStyle != null) {
            return spinnerStyle;
        }
        czv czv = this.O000Ooo0;
        if (czv != null && czv != this) {
            return czv.getSpinnerStyle();
        }
        View view = this.O000OoOO;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                this.O000OoOo = ((SmartRefreshLayout.LayoutParams) layoutParams).O00000Oo;
                SpinnerStyle spinnerStyle2 = this.O000OoOo;
                if (spinnerStyle2 != null) {
                    return spinnerStyle2;
                }
            }
            if (layoutParams != null && (layoutParams.height == 0 || layoutParams.height == -1)) {
                SpinnerStyle spinnerStyle3 = SpinnerStyle.Scale;
                this.O000OoOo = spinnerStyle3;
                return spinnerStyle3;
            }
        }
        SpinnerStyle spinnerStyle4 = SpinnerStyle.Translate;
        this.O000OoOo = spinnerStyle4;
        return spinnerStyle4;
    }

    public void O000000o(czw czw, int i, int i2) {
        czv czv = this.O000Ooo0;
        if (czv == null || czv == this) {
            View view = this.O000OoOO;
            if (view != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                    czw.O000000o(this, ((SmartRefreshLayout.LayoutParams) layoutParams).f5569O000000o);
                    return;
                }
                return;
            }
            return;
        }
        czv.O000000o(czw, i, i2);
    }

    public boolean O00000Oo() {
        czv czv = this.O000Ooo0;
        return (czv == null || czv == this || !czv.O00000Oo()) ? false : true;
    }

    public void O000000o(float f, int i, int i2) {
        czv czv = this.O000Ooo0;
        if (czv != null && czv != this) {
            czv.O000000o(f, i, i2);
        }
    }

    public void O000000o(boolean z, float f, int i, int i2, int i3) {
        czv czv = this.O000Ooo0;
        if (czv != null && czv != this) {
            czv.O000000o(z, f, i, i2, i3);
        }
    }

    public void O000000o(czx czx, int i, int i2) {
        czv czv = this.O000Ooo0;
        if (czv != null && czv != this) {
            czv.O000000o(czx, i, i2);
        }
    }

    public void O00000Oo(czx czx, int i, int i2) {
        czv czv = this.O000Ooo0;
        if (czv != null && czv != this) {
            czv.O00000Oo(czx, i, i2);
        }
    }

    public void O000000o(czx czx, RefreshState refreshState, RefreshState refreshState2) {
        czv czv = this.O000Ooo0;
        if (czv != null && czv != this) {
            if ((this instanceof daa) && (czv instanceof czu)) {
                if (refreshState.isFooter) {
                    refreshState = refreshState.toHeader();
                }
                if (refreshState2.isFooter) {
                    refreshState2 = refreshState2.toHeader();
                }
            } else if ((this instanceof dab) && (this.O000Ooo0 instanceof czt)) {
                if (refreshState.isHeader) {
                    refreshState = refreshState.toFooter();
                }
                if (refreshState2.isHeader) {
                    refreshState2 = refreshState2.toFooter();
                }
            }
            this.O000Ooo0.O000000o(czx, refreshState, refreshState2);
        }
    }
}

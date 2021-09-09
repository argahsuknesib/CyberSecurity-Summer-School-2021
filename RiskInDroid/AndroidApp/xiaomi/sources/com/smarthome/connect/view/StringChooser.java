package com.smarthome.connect.view;

import _m_j.ddi;
import _m_j.fcj;
import _m_j.gpc;
import _m_j.gsy;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import java.util.List;

public class StringChooser extends RecyclerView {
    private static final String O0000o0 = "com.smarthome.connect.view.StringChooser";

    /* renamed from: O000000o  reason: collision with root package name */
    public List<fcj> f5655O000000o;
    public int O00000Oo;
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    public int O00000oo;
    public float O0000O0o;
    public int O0000OOo;
    public float O0000Oo;
    public int O0000Oo0;
    public float O0000OoO;
    float O0000Ooo;
    public ddi O0000o00;
    private O000000o O0000o0O;

    public interface O000000o {
    }

    public StringChooser(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.notSelectedColor, R.attr.notSelectedOpacity, R.attr.notSelectedSize, R.attr.selectedColor, R.attr.selectedSize});
        this.O00000Oo = obtainStyledAttributes.getColor(3, getResources().getColor(17170451));
        this.O00000o0 = obtainStyledAttributes.getDimensionPixelSize(4, 18);
        this.O00000o = obtainStyledAttributes.getColor(0, getResources().getColor(17170432));
        this.O00000oO = obtainStyledAttributes.getDimensionPixelSize(2, 12);
        this.O0000OoO = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        String str = O0000o0;
        gsy.O000000o(3, str, "selected Size" + this.O00000o0);
    }

    public void setHomeItems(List<fcj> list) {
        this.f5655O000000o = list;
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            /* class com.smarthome.connect.view.StringChooser.AnonymousClass1 */

            public final boolean onPreDraw() {
                StringChooser.this.getViewTreeObserver().removeOnPreDrawListener(this);
                StringChooser stringChooser = StringChooser.this;
                stringChooser.O0000Oo0 = stringChooser.getMeasuredHeight();
                StringChooser stringChooser2 = StringChooser.this;
                stringChooser2.O0000Oo = (float) (stringChooser2.O00000o0 + gpc.O000000o(39.0f));
                StringChooser stringChooser3 = StringChooser.this;
                stringChooser3.O0000Ooo = (((float) stringChooser3.O0000Oo0) - StringChooser.this.O0000Oo) / 2.0f;
                StringChooser stringChooser4 = StringChooser.this;
                stringChooser4.O0000O0o = stringChooser4.O0000Ooo;
                StringChooser stringChooser5 = StringChooser.this;
                stringChooser5.O0000OOo = 0;
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(stringChooser5.getContext());
                linearLayoutManager.setOrientation(1);
                StringChooser.this.setLayoutManager(linearLayoutManager);
                StringChooser.this.addOnScrollListener(new RecyclerView.O00oOooO() {
                    /* class com.smarthome.connect.view.StringChooser.AnonymousClass1.AnonymousClass1 */

                    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
                        super.onScrollStateChanged(recyclerView, i);
                    }

                    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
                        super.onScrolled(recyclerView, i, i2);
                        StringChooser.this.O0000OOo += i2;
                        StringChooser.this.O000000o();
                    }
                });
                StringChooser stringChooser6 = StringChooser.this;
                stringChooser6.O0000o00 = new ddi(stringChooser6.f5655O000000o, (int) StringChooser.this.O0000O0o, StringChooser.this.O00000Oo, StringChooser.this.O00000o0, StringChooser.this.O00000o, StringChooser.this.O00000oO, StringChooser.this.O0000OoO);
                StringChooser stringChooser7 = StringChooser.this;
                stringChooser7.setAdapter(stringChooser7.O0000o00);
                return true;
            }
        });
    }

    public final void O000000o() {
        this.O00000oo = Math.round(((((float) this.O0000OOo) + this.O0000Ooo) - this.O0000O0o) / this.O0000Oo) + 1;
        ddi ddi = this.O0000o00;
        if (ddi != null) {
            int i = this.O00000oo;
            if (ddi.f14495O000000o != i) {
                ddi.f14495O000000o = i;
                gsy.O000000o(6, "selected item", "count: ".concat(String.valueOf(i)));
                new Handler(Looper.myLooper()).post(new Runnable() {
                    /* class _m_j.ddi.AnonymousClass1 */

                    public final void run() {
                        ddi.this.notifyDataSetChanged();
                    }
                });
            }
            if (this.O0000o0O != null) {
                this.f5655O000000o.get(this.O00000oo);
            }
        }
    }

    public int getSelectedColor() {
        return this.O00000Oo;
    }

    public void setSelectedColor(int i) {
        this.O00000Oo = i;
    }

    public int getSelectedSize() {
        return this.O00000o0;
    }

    public void setSelectedSize(int i) {
        this.O00000o0 = i;
    }

    public O000000o getStringChooserCallback() {
        return this.O0000o0O;
    }

    public void setStringChooserCallback(O000000o o000000o) {
        this.O0000o0O = o000000o;
    }

    public int getSelectedValue() {
        return this.O00000oo;
    }

    public fcj getSelectedItem() {
        int i;
        List<fcj> list = this.f5655O000000o;
        if (list == null || list.size() <= (i = this.O00000oo)) {
            return null;
        }
        return this.f5655O000000o.get(i);
    }
}

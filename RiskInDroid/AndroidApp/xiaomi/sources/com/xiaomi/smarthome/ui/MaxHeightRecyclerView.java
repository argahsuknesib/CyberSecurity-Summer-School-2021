package com.xiaomi.smarthome.ui;

import _m_j.ixc;
import _m_j.ixe;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0014J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/xiaomi/smarthome/ui/MaxHeightRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxHeight", "onMeasure", "", "widthSpec", "heightSpec", "setMaxHeight", "height", "app-common-ui_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MaxHeightRecyclerView extends RecyclerView {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f11908O000000o;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaxHeightRecyclerView(Context context) {
        this(context, null, 0, 6, null);
        ixe.O00000o(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaxHeightRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        ixe.O00000o(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MaxHeightRecyclerView(Context context, AttributeSet attributeSet, int i, int i2, ixc ixc) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MaxHeightRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ixe.O00000o(context, "context");
        this.f11908O000000o = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.recycler_max_height}, 0, i);
            this.f11908O000000o = obtainStyledAttributes.getDimensionPixelSize(0, -1);
            obtainStyledAttributes.recycle();
        }
    }

    public final void setMaxHeight(int i) {
        if (i != this.f11908O000000o) {
            this.f11908O000000o = i;
            requestLayout();
        }
    }

    public final void onMeasure(int i, int i2) {
        int i3 = this.f11908O000000o;
        if (i3 > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }
}

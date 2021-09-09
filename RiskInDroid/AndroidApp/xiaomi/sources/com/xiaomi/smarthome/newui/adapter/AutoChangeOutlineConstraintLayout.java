package com.xiaomi.smarthome.newui.adapter;

import _m_j.ixc;
import _m_j.ixe;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0014¨\u0006\u000f"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/AutoChangeOutlineConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onSizeChanged", "", "w", "h", "oldw", "oldh", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AutoChangeOutlineConstraintLayout extends ConstraintLayout {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AutoChangeOutlineConstraintLayout(Context context) {
        this(context, null, 0, 6, null);
        ixe.O00000o(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AutoChangeOutlineConstraintLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        ixe.O00000o(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AutoChangeOutlineConstraintLayout(Context context, AttributeSet attributeSet, int i, int i2, ixc ixc) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoChangeOutlineConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ixe.O00000o(context, "context");
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new O000000o(this));
            setClipToOutline(true);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/xiaomi/smarthome/newui/adapter/AutoChangeOutlineConstraintLayout$onSizeChanged$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o extends ViewOutlineProvider {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ AutoChangeOutlineConstraintLayout f10129O000000o;

        O000000o(AutoChangeOutlineConstraintLayout autoChangeOutlineConstraintLayout) {
            this.f10129O000000o = autoChangeOutlineConstraintLayout;
        }

        public final void getOutline(View view, Outline outline) {
            ixe.O00000o(view, "view");
            ixe.O00000o(outline, "outline");
            outline.setRoundRect(new Rect(this.f10129O000000o.getLeft(), this.f10129O000000o.getTop(), this.f10129O000000o.getRight(), this.f10129O000000o.getBottom()), 40.0f);
        }
    }
}

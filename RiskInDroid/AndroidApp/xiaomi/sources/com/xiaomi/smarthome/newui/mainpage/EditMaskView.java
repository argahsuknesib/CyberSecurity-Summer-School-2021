package com.xiaomi.smarthome.newui.mainpage;

import _m_j.ixc;
import _m_j.ixe;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.newui.widget.topnavi.widgets.SketchCardView;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/xiaomi/smarthome/newui/mainpage/EditMaskView;", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/SketchCardView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "shouldMask", "getShouldMask", "()Z", "setShouldMask", "(Z)V", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setMaskColor", "", "color", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EditMaskView extends SketchCardView {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f10243O000000o;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EditMaskView(Context context) {
        this(context, null, 0, 6, null);
        ixe.O00000o(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EditMaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        ixe.O00000o(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EditMaskView(Context context, AttributeSet attributeSet, int i, int i2, ixc ixc) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditMaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ixe.O00000o(context, "context");
        setBackground(null);
        O000000o(getResources().getColor(R.color.mj_color_black_10_transparent));
    }

    public final boolean getShouldMask() {
        return this.f10243O000000o;
    }

    public final void setShouldMask(boolean z) {
        setVisibility(z ? 0 : 8);
        this.f10243O000000o = z;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f10243O000000o || super.onTouchEvent(motionEvent);
    }

    public final void setMaskColor(int i) {
        O000000o(i);
        invalidate();
    }
}

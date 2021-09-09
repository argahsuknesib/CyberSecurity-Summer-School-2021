package com.xiaomi.smarthome.uwb.mico;

import _m_j.hxi;
import _m_j.hzf;
import _m_j.itz;
import _m_j.iua;
import _m_j.ixc;
import _m_j.ixe;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatSeekBar;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/VolumeBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mInjector", "Lcom/xiaomi/smarthome/uwb/mico/RelativeSeekBarInjector;", "getMInjector", "()Lcom/xiaomi/smarthome/uwb/mico/RelativeSeekBarInjector;", "mInjector$delegate", "Lkotlin/Lazy;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class VolumeBar extends AppCompatSeekBar {
    private final itz mInjector$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VolumeBar(Context context) {
        this(context, null, 0, 6, null);
        ixe.O00000o(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VolumeBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        ixe.O00000o(context, "context");
    }

    public final void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VolumeBar(Context context, AttributeSet attributeSet, int i, int i2, ixc ixc) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VolumeBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ixe.O00000o(context, "context");
        setMax(100);
        hzf.O00000oo(this);
        this.mInjector$delegate = iua.O000000o(new VolumeBar$mInjector$2(this));
    }

    private final RelativeSeekBarInjector getMInjector() {
        return (RelativeSeekBarInjector) this.mInjector$delegate.O000000o();
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        ixe.O00000o(motionEvent, "event");
        getMInjector().transformTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            hxi.O00000o.f952O000000o.O000000o("uwb_mico_volume_click", new Object[0]);
        }
        return super.onTouchEvent(motionEvent);
    }
}

package com.xiaomi.smarthome.uwb;

import _m_j.iwb;
import android.widget.FrameLayout;
import com.xiaomi.smarthome.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0014\b\u0000\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\u000e\b\u0001\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00060\u0007\"\u0004\b\u0002\u0010\u0006H\n"}, d2 = {"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "C", "Lcom/xiaomi/smarthome/newui/card/Card;", "E", "T", "Lcom/xiaomi/smarthome/newui/card/Card$CardType;"}, k = 3, mv = {1, 5, 1}, xi = 48)
final class UwbCardActivity$flRoot$2 extends Lambda implements iwb<FrameLayout> {
    final /* synthetic */ UwbCardActivity<C, E, T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UwbCardActivity$flRoot$2(UwbCardActivity<C, E, T> uwbCardActivity) {
        super(0);
        this.this$0 = uwbCardActivity;
    }

    public final FrameLayout invoke() {
        return (FrameLayout) this.this$0.findViewById(R.id.fl_root);
    }
}

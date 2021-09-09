package com.mi.global.shop.widget.pulltorefresh;

import android.content.Context;
import com.xiaomi.smarthome.R;

public final class FestivalLoadingLayout extends LoadingLayout {
    /* access modifiers changed from: protected */
    public final int getDefaultDrawableResId() {
        return R.drawable.shop_mi_rabbit_1;
    }

    public FestivalLoadingLayout(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        getGif_bg().setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        getGif_bg().setVisibility(8);
    }
}

package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.xiaomi.smarthome.R;

public class MitvVolumeView extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    View f9225O000000o;
    View O00000Oo;
    View O00000o;
    View O00000o0;
    Animation O00000oO;
    Animation O00000oo;
    Animation O0000O0o;

    public MitvVolumeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.O00000oO = AnimationUtils.loadAnimation(getContext(), R.anim.mitv_volume_circle);
        this.O00000oo = AnimationUtils.loadAnimation(getContext(), R.anim.mitv_volume_add);
        this.O0000O0o = AnimationUtils.loadAnimation(getContext(), R.anim.mitv_volume_sub);
        this.f9225O000000o = findViewById(R.id.mitv_volume_add);
        this.O00000Oo = findViewById(R.id.mitv_volume_sub);
        this.O00000o0 = findViewById(R.id.mitv_volume_circle);
        this.O00000o = findViewById(R.id.mitv_volume);
    }
}

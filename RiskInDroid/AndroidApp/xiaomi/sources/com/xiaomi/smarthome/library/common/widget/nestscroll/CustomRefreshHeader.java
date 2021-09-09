package com.xiaomi.smarthome.library.common.widget.nestscroll;

import _m_j.grh;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class CustomRefreshHeader extends FrameLayout implements grh {

    /* renamed from: O000000o  reason: collision with root package name */
    private Animation f9319O000000o;
    private Animation O00000Oo;
    private TextView O00000o;
    private Animation O00000o0;
    private View O00000oO;
    private View O00000oo;
    private View O0000O0o;
    private grh O0000OOo;
    private boolean O0000Oo0;

    public CustomRefreshHeader(Context context) {
        this(context, null);
    }

    public CustomRefreshHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O0000Oo0 = true;
        this.f9319O000000o = AnimationUtils.loadAnimation(context, R.anim.rotate_180);
        this.O00000Oo = AnimationUtils.loadAnimation(context, R.anim.rotate_back_180);
        this.O00000o0 = AnimationUtils.loadAnimation(context, R.anim.rotate_infinite);
        inflate(context, R.layout.sm_widget_pull_to_refresh_header_nestscrolling, this);
        this.O00000o = (TextView) findViewById(R.id.text);
        this.O00000oO = findViewById(R.id.arrowIcon);
        this.O00000oo = findViewById(R.id.successIcon);
        this.O0000O0o = findViewById(R.id.loadingIcon);
    }

    public void setRefreshHeader(grh grh) {
        this.O0000OOo = grh;
    }

    public final void O000000o() {
        this.O00000o.setText(getResources().getText(R.string.pull_down_refresh));
        this.O00000o.setVisibility(8);
        this.O00000oo.setVisibility(8);
        this.O00000oO.setVisibility(8);
        this.O00000oO.clearAnimation();
        this.O0000O0o.setVisibility(8);
        this.O0000O0o.clearAnimation();
        setVisibility(8);
        grh grh = this.O0000OOo;
        if (grh != null) {
            grh.O000000o();
        }
    }

    public final void O00000Oo() {
        this.O00000o.setVisibility(8);
        this.O00000oO.setVisibility(8);
        this.O0000O0o.setVisibility(8);
        grh grh = this.O0000OOo;
        if (grh != null) {
            grh.O00000Oo();
        }
    }

    public final void O00000o0() {
        if (this.O0000Oo0) {
            this.O0000Oo0 = false;
            this.O00000o.setVisibility(8);
            this.O00000oO.setVisibility(8);
            this.O0000O0o.setVisibility(8);
            grh grh = this.O0000OOo;
            if (grh != null) {
                grh.O00000o0();
                return;
            }
            return;
        }
        this.O00000o.setVisibility(8);
        this.O00000oO.setVisibility(8);
        this.O0000O0o.setVisibility(8);
        this.O00000o.setText(getResources().getText(R.string.refreshing));
        grh grh2 = this.O0000OOo;
        if (grh2 != null) {
            grh2.O00000o0();
        }
    }

    public final void O00000o() {
        this.O00000oO.clearAnimation();
        this.O00000oo.setVisibility(8);
        this.O00000oO.setVisibility(8);
        this.O00000o.setVisibility(8);
        this.O00000o.setText(getResources().getText(R.string.refresh_complete));
        grh grh = this.O0000OOo;
        if (grh != null) {
            grh.O00000o();
        }
    }
}

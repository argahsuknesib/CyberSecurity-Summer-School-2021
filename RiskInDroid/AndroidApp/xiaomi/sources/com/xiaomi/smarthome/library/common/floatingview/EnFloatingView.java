package com.xiaomi.smarthome.library.common.floatingview;

import _m_j.gns;
import _m_j.gnu;
import _m_j.gnw;
import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;

public class EnFloatingView extends FloatingMagnetView {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f9119O000000o;
    private ImageView O0000o;
    private ImageView O0000o0o;
    private FrameLayout O0000oO;
    private ImageView O0000oO0;
    private FrameLayout O0000oOO;
    private Runnable O0000oOo;
    private Runnable O0000oo0;

    public EnFloatingView(Context context) {
        this(context, R.layout.en_floating_view);
    }

    public EnFloatingView(Context context, int i) {
        super(context, null);
        this.f9119O000000o = -1;
        this.O0000oOo = new Runnable() {
            /* class com.xiaomi.smarthome.library.common.floatingview.EnFloatingView.AnonymousClass1 */

            public final void run() {
                EnFloatingView.this.O000000o(2);
            }
        };
        this.O0000oo0 = new Runnable() {
            /* class com.xiaomi.smarthome.library.common.floatingview.EnFloatingView.AnonymousClass2 */

            public final void run() {
                EnFloatingView.this.O000000o(1);
            }
        };
        inflate(context, i, this);
        this.O0000oO = (FrameLayout) findViewById(R.id.fl_root);
        this.O0000oOO = (FrameLayout) findViewById(R.id.close_wrapper);
        this.O0000o0o = (ImageView) findViewById(R.id.iv_float_icon_close);
        this.O0000o = (ImageView) findViewById(R.id.iv_float_icon_drag);
        this.O0000oO0 = (ImageView) findViewById(R.id.iv_float_icon_open);
        O000000o(1);
        setMagnetViewListener(new gnu() {
            /* class com.xiaomi.smarthome.library.common.floatingview.EnFloatingView.AnonymousClass3 */

            public final void O000000o() {
                int i = EnFloatingView.this.f9119O000000o;
                if (i == 1) {
                    EnFloatingView.this.O000000o(3);
                } else if (i == 2) {
                    EnFloatingView.this.O000000o(3);
                } else if (i != 3) {
                    return;
                }
                Activity attachActivity = EnFloatingView.this.getAttachActivity();
                if (attachActivity != null && !attachActivity.isFinishing()) {
                    new gnw().show(attachActivity.getFragmentManager(), "show whloe float dialog");
                }
            }
        });
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.O00000o = getX();
            this.O00000oO = getY();
            this.O00000Oo = motionEvent.getRawX();
            this.O00000o0 = motionEvent.getRawY();
            this.O0000O0o = System.currentTimeMillis();
            O000000o();
            this.O0000OOo.O000000o();
        } else if (action == 1) {
            if (this.f9119O000000o >= 3) {
                gns.O00000Oo(getX(), getY());
                this.O0000o00 = 0.0f;
                O00000Oo();
                O000000o(3);
            }
            if (System.currentTimeMillis() - this.O0000O0o < 150) {
                z = true;
            }
            if (z && this.O00000oo != null) {
                this.O00000oo.O000000o();
            }
        } else if (action == 2) {
            O000000o(4);
            setX((this.O00000o + motionEvent.getRawX()) - this.O00000Oo);
            float rawY = (this.O00000oO + motionEvent.getRawY()) - this.O00000o0;
            if (rawY < ((float) this.O0000OoO)) {
                rawY = (float) this.O0000OoO;
            }
            if (rawY > ((float) (this.O0000Oo - getHeight()))) {
                rawY = (float) (this.O0000Oo - getHeight());
            }
            setY(rawY);
        }
        return true;
    }

    public final void O000000o(int i) {
        if (this.f9119O000000o != i) {
            O00000Oo(i);
        }
    }

    public final void O00000Oo(int i) {
        this.f9119O000000o = i;
        boolean O00000o0 = O00000o0();
        int i2 = this.f9119O000000o;
        int i3 = 3;
        if (i2 == 1) {
            this.O0000o.setVisibility(8);
            this.O0000oO0.setVisibility(8);
            this.O0000oOO.setVisibility(0);
            this.O0000o0o.setVisibility(0);
            this.O0000o0o.setImageResource(O00000o0 ? R.drawable.mj_float_state_close_left : R.drawable.mj_float_state_close_right);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.O0000o0o.getLayoutParams();
            if (!O00000o0) {
                i3 = 5;
            }
            layoutParams.gravity = i3;
            this.O0000o0o.setLayoutParams(layoutParams);
            this.O0000o0.removeCallbacks(this.O0000oo0);
            this.O0000o0.removeCallbacks(this.O0000oOo);
        } else if (i2 == 2) {
            this.O0000oOO.setVisibility(8);
            this.O0000o0o.setVisibility(8);
            this.O0000o.setVisibility(8);
            this.O0000oO0.setVisibility(0);
            this.O0000oO0.setImageResource(O00000o0 ? R.drawable.mj_float_state_open_transparent_left : R.drawable.mj_float_state_open_transparent_right);
            this.O0000o0.removeCallbacks(this.O0000oo0);
            this.O0000o0.removeCallbacks(this.O0000oOo);
            this.O0000o0.postDelayed(this.O0000oo0, 1000);
        } else if (i2 == 3) {
            this.O0000oOO.setVisibility(8);
            this.O0000o0o.setVisibility(8);
            this.O0000o.setVisibility(8);
            this.O0000oO0.setVisibility(0);
            this.O0000oO0.setImageResource(O00000o0 ? R.drawable.mj_float_state_open_normal_left : R.drawable.mj_float_state_open_normal_right);
            this.O0000o0.removeCallbacks(this.O0000oo0);
            this.O0000o0.removeCallbacks(this.O0000oOo);
            this.O0000o0.postDelayed(this.O0000oOo, 2000);
        } else if (i2 == 4) {
            this.O0000oOO.setVisibility(8);
            this.O0000o0o.setVisibility(8);
            this.O0000o.setVisibility(0);
            this.O0000oO0.setVisibility(8);
            this.O0000o.setImageResource(R.drawable.mj_float_state_drag);
            this.O0000o0.removeCallbacks(this.O0000oOo);
            this.O0000o0.removeCallbacks(this.O0000oo0);
        }
    }
}

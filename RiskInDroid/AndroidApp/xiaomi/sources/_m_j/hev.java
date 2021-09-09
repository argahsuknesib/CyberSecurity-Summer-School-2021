package _m_j;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.newui.card.BaseCardRender;

public final class hev extends heq {
    ImageView O0000oO;
    ImageView O0000oOO;
    int O0000oOo = -1;
    ViewGroup O0000oo;
    Handler O0000oo0;
    gzd O0000ooO;

    public hev(hej hej, Spec.SpecItem[] specItemArr) {
        super(hej, specItemArr);
    }

    public final void O000000o(ViewGroup viewGroup, int i, int i2) {
        super.O000000o(viewGroup, i, i2);
        View O000000o2 = O000000o(viewGroup, (int) R.layout.card_item_robot_anim);
        this.O0000oO = (ImageView) O000000o2.findViewById(R.id.iv_robot_bg);
        this.O0000oOO = (ImageView) O000000o2.findViewById(R.id.iv_robot_circle);
        this.O0000oo = (ViewGroup) O000000o2.findViewById(R.id.ll_particle);
        ViewGroup viewGroup2 = this.O0000oo;
        if (viewGroup2 != null) {
            this.O0000ooO = gzd.O000000o(viewGroup2);
            this.O0000oOo = O0000Oo();
            O000000o(this.O0000oOo);
        }
    }

    public final void O00000o0() {
        super.O00000o0();
        Handler handler = this.O0000oo0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        gzd gzd = this.O0000ooO;
        if (gzd != null) {
            gzd.O000000o();
        }
        this.O0000ooO = null;
        this.O0000oO = null;
        this.O0000oOO = null;
        this.O0000oo = null;
    }

    private void O000000o(int i) {
        if (!O00000oO().isOnline || this.O0000o0O != BaseCardRender.DataInitState.DONE) {
            O0000Oo0();
        } else if (i == 2) {
            O0000O0o();
        } else if (i == 3) {
            O0000Oo0();
        } else if (i == 9 || i == 12) {
            O0000OOo();
        } else {
            O0000Oo0();
        }
    }

    private void O0000O0o() {
        ImageView imageView = this.O0000oOO;
        ImageView imageView2 = this.O0000oO;
        Activity activity = this.O0000OOo;
        ViewGroup viewGroup = this.O0000oo;
        if (imageView != null && imageView2 != null && activity != null && viewGroup != null) {
            if (imageView.getAnimation() != null) {
                imageView.getAnimation().cancel();
            }
            imageView2.setImageResource(R.drawable.robot_bg);
            Animation loadAnimation = AnimationUtils.loadAnimation(activity, R.anim.rotate_360_repeat);
            loadAnimation.setInterpolator(new LinearInterpolator());
            imageView.setAnimation(loadAnimation);
            imageView.startAnimation(loadAnimation);
            Handler handler = this.O0000oo0;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.O0000oo0 = new O000000o();
            this.O0000oo0.sendEmptyMessage(1);
            viewGroup.post(new Runnable(activity) {
                /* class _m_j.$$Lambda$hev$YE7sCiUIOTCMsE1hNLcQHg_7D8 */
                private final /* synthetic */ Activity f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    hev.this.O000000o(this.f$1);
                }
            });
        }
    }

    private void O0000OOo() {
        ImageView imageView = this.O0000oOO;
        if (imageView != null) {
            if (imageView.getAnimation() != null) {
                imageView.getAnimation().cancel();
            }
            imageView.setImageResource(R.drawable.robot_error);
        }
    }

    private void O0000Oo0() {
        ImageView imageView = this.O0000oOO;
        ImageView imageView2 = this.O0000oO;
        gzd gzd = this.O0000ooO;
        if (imageView != null && imageView2 != null && gzd != null) {
            if (imageView.getAnimation() != null) {
                imageView.getAnimation().cancel();
            }
            imageView.setImageDrawable(null);
            imageView2.setImageResource(R.drawable.robot_bg_disable);
            Handler handler = this.O0000oo0;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            gzd.O000000o();
        }
    }

    private int O0000Oo() {
        Object O00000o0 = hej.O00000o0(O00000oO(), this.O0000o);
        if (O00000o0 == null) {
            return -1;
        }
        return ((Integer) O00000o0).intValue();
    }

    class O000000o extends Handler {
        O000000o() {
        }

        public final void handleMessage(Message message) {
            gsy.O000000o(4, "SpecRobotAnimCardItem", "waveHandler msg:" + message.what);
            ImageView imageView = hev.this.O0000oOO;
            if (hev.this.O0000Oo0 || hev.this.O0000OOo == null || hev.this.O0000OOo.isFinishing() || imageView == null) {
                hev.this.O0000oo0.removeCallbacksAndMessages(null);
                return;
            }
            if (message.what == 1) {
                imageView.setImageResource(R.drawable.robot_wave1);
                hev.this.O0000oo0.sendMessageDelayed(hev.this.O0000oo0.obtainMessage(2, imageView), 200);
            }
            if (message.what == 2) {
                imageView.setImageResource(R.drawable.robot_wave2);
                hev.this.O0000oo0.sendMessageDelayed(hev.this.O0000oo0.obtainMessage(3, imageView), 200);
            }
            if (message.what == 3) {
                imageView.setImageResource(R.drawable.robot_wave3);
                hev.this.O0000oo0.sendMessageDelayed(hev.this.O0000oo0.obtainMessage(4, imageView), 200);
            }
            if (message.what == 4) {
                imageView.setImageDrawable(null);
                hev.this.O0000oo0.sendMessageDelayed(hev.this.O0000oo0.obtainMessage(1, imageView), 200);
            }
        }
    }

    public final /* synthetic */ void O000000o(Object obj, Object obj2) {
        int O0000Oo;
        if (!this.O0000Oo0 && O00000oO() != null && this.O0000OOo != null && !this.O0000OOo.isFinishing() && this.O0000oOo != (O0000Oo = O0000Oo())) {
            this.O0000oOo = O0000Oo;
            O000000o(this.O0000oOo);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Activity activity) {
        gzd gzd;
        if (!this.O0000Oo0 && this.O0000oOo == 2 && (gzd = this.O0000ooO) != null) {
            gzd.O000000o(activity);
        }
    }
}

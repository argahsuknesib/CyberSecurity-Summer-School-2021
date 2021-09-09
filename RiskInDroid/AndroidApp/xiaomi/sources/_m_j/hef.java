package _m_j;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.card.BaseCardRender;

public final class hef extends hec {
    ImageView O0000o;
    ImageView O0000o0o;
    int O0000oO0 = -1;
    ViewGroup O000O00o;
    gzd O000O0OO;
    Handler O00oOooo;

    public hef(hed hed) {
        super(hed);
    }

    public final void O000000o(ViewGroup viewGroup, int i, int i2) {
        super.O000000o(viewGroup, i, i2);
        View O000000o2 = O000000o(viewGroup, (int) R.layout.card_item_robot_anim);
        this.O0000o0o = (ImageView) O000000o2.findViewById(R.id.iv_robot_bg);
        this.O0000o = (ImageView) O000000o2.findViewById(R.id.iv_robot_circle);
        this.O000O00o = (ViewGroup) O000000o2.findViewById(R.id.ll_particle);
        ViewGroup viewGroup2 = this.O000O00o;
        if (viewGroup2 != null) {
            this.O000O0OO = gzd.O000000o(viewGroup2);
            this.O0000oO0 = O0000OoO();
            O000000o(this.O0000oO0);
        }
    }

    public final void O00000o0() {
        super.O00000o0();
        Handler handler = this.O00oOooo;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        gzd gzd = this.O000O0OO;
        if (gzd != null) {
            gzd.O000000o();
        }
        this.O000O0OO = null;
        this.O0000OOo = null;
        this.O0000o0o = null;
        this.O0000o = null;
        this.O000O00o = null;
    }

    private void O000000o(int i) {
        if (!O00000oO().isOnline || this.O0000o0O != BaseCardRender.DataInitState.DONE) {
            O0000Oo();
        } else if (i == 5) {
            O0000O0o();
        } else if (i == 6) {
        } else {
            if (i == 9 || i == 12) {
                O0000Oo0();
            } else {
                O0000Oo();
            }
        }
    }

    private void O0000O0o() {
        ImageView imageView = this.O0000o;
        ImageView imageView2 = this.O0000o0o;
        final Activity activity = this.O0000OOo;
        ViewGroup viewGroup = this.O000O00o;
        if (imageView != null && imageView2 != null && activity != null && viewGroup != null) {
            if (imageView.getAnimation() != null) {
                imageView.getAnimation().cancel();
            }
            imageView2.setImageResource(R.drawable.robot_bg);
            Animation loadAnimation = AnimationUtils.loadAnimation(activity, R.anim.rotate_360_repeat);
            loadAnimation.setInterpolator(new LinearInterpolator());
            imageView.setAnimation(loadAnimation);
            imageView.startAnimation(loadAnimation);
            Handler handler = this.O00oOooo;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.O00oOooo = new O000000o();
            this.O00oOooo.sendEmptyMessage(1);
            viewGroup.post(new Runnable() {
                /* class _m_j.hef.AnonymousClass1 */

                public final void run() {
                    gzd gzd;
                    if (!hef.this.O0000Oo0 && hef.this.O0000oO0 == 5 && (gzd = hef.this.O000O0OO) != null) {
                        gzd.O000000o(activity);
                    }
                }
            });
        }
    }

    private void O0000Oo0() {
        ImageView imageView = this.O0000o;
        if (imageView != null) {
            if (imageView.getAnimation() != null) {
                imageView.getAnimation().cancel();
            }
            imageView.setImageResource(R.drawable.robot_error);
        }
    }

    private void O0000Oo() {
        ImageView imageView = this.O0000o;
        ImageView imageView2 = this.O0000o0o;
        gzd gzd = this.O000O0OO;
        if (imageView != null && imageView2 != null && gzd != null) {
            if (imageView.getAnimation() != null) {
                imageView.getAnimation().cancel();
            }
            imageView.setImageDrawable(null);
            imageView2.setImageResource(R.drawable.robot_bg_disable);
            Handler handler = this.O00oOooo;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            gzd.O000000o();
        }
    }

    private int O0000OoO() {
        try {
            return Integer.valueOf(String.valueOf(hed.O000000o((hed) this.O0000Ooo, O00000oO(), (String) hfa.O000000o((Object[]) this.f18773O000000o)))).intValue();
        } catch (Exception e) {
            gsy.O00000Oo(LogType.CARD, "mijia-card", Log.getStackTraceString(e));
            return -1;
        }
    }

    class O000000o extends Handler {
        O000000o() {
        }

        public final void handleMessage(Message message) {
            gsy.O000000o(4, "RobotAnimCardItem", "waveHandler msg:" + message.what);
            ImageView imageView = hef.this.O0000o;
            if (hef.this.O0000Oo0 || hef.this.O0000OOo == null || hef.this.O0000OOo.isFinishing() || imageView == null) {
                hef.this.O00oOooo.removeCallbacksAndMessages(null);
                return;
            }
            if (message.what == 1) {
                imageView.setImageResource(R.drawable.robot_wave1);
                hef.this.O00oOooo.sendMessageDelayed(hef.this.O00oOooo.obtainMessage(2, imageView), 200);
            }
            if (message.what == 2) {
                imageView.setImageResource(R.drawable.robot_wave2);
                hef.this.O00oOooo.sendMessageDelayed(hef.this.O00oOooo.obtainMessage(3, imageView), 200);
            }
            if (message.what == 3) {
                imageView.setImageResource(R.drawable.robot_wave3);
                hef.this.O00oOooo.sendMessageDelayed(hef.this.O00oOooo.obtainMessage(4, imageView), 200);
            }
            if (message.what == 4) {
                imageView.setImageDrawable(null);
                hef.this.O00oOooo.sendMessageDelayed(hef.this.O00oOooo.obtainMessage(1, imageView), 200);
            }
        }
    }

    public final /* synthetic */ void O000000o(Object obj, Object obj2) {
        int O0000OoO;
        if (!this.O0000Oo0 && O00000oO() != null && this.O0000OOo != null && !this.O0000OOo.isFinishing() && this.O0000oO0 != (O0000OoO = O0000OoO())) {
            this.O0000oO0 = O0000OoO;
            O000000o(this.O0000oO0);
        }
    }
}

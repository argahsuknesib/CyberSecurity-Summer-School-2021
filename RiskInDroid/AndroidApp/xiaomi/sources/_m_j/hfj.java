package _m_j;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.newui.card.yeelight.ParticleField;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

public final class hfj {

    /* renamed from: O000000o  reason: collision with root package name */
    ParticleField f18860O000000o;
    ArrayList<hfi> O00000Oo;
    public long O00000o;
    ArrayList<hfi> O00000o0;
    public long O00000oO;
    float O00000oo;
    int O0000O0o;
    long O0000OOo;
    public List<hfk> O0000Oo;
    public List<hfp> O0000Oo0;
    public float O0000OoO;
    int O0000Ooo;
    private Timer O0000o;
    private int O0000o0;
    private ViewGroup O0000o00;
    private Random O0000o0O;
    private ValueAnimator O0000o0o;
    private int O0000oO;
    private int[] O0000oO0;
    private int O0000oOO;
    private int O0000oOo;
    private int O0000oo0;

    private static boolean O00000Oo(int i, int i2) {
        return (i2 & 17) == i2;
    }

    private hfj(Activity activity, int i, long j, int i2) {
        this.O00000oO = 0;
        this.O0000o0O = new Random();
        this.O0000o00 = (ViewGroup) activity.findViewById(16908290);
        if (this.O0000o00 == null) {
            gsy.O000000o(6, "WifiParticleSystem", new StringBuilder("!!!parentView==null parentId:16908290").toString());
            return;
        }
        this.O0000Oo0 = new ArrayList();
        this.O0000Oo = new ArrayList();
        this.O0000o0 = i;
        this.O00000o0 = new ArrayList<>();
        this.O00000Oo = new ArrayList<>();
        this.O00000o = j;
        this.O0000oO0 = new int[2];
        this.O0000o00.getLocationInWindow(this.O0000oO0);
        this.O0000OoO = activity.getResources().getDisplayMetrics().xdpi / 160.0f;
    }

    public hfj(Activity activity) {
        this(activity, 80, activity.getResources().getDrawable(R.drawable.night_star), 600);
    }

    private hfj(Activity activity, int i, Drawable drawable, long j) {
        this(activity, 80, 600, 16908290);
        float f = ((float) activity.getResources().getDisplayMetrics().widthPixels) / 1920.0f;
        int i2 = 0;
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            while (i2 < this.O0000o0) {
                this.O00000Oo.add(new hfi(bitmap, f));
                i2++;
            }
        } else if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            while (i2 < this.O0000o0) {
                this.O00000Oo.add(new hfh(animationDrawable));
                i2++;
            }
        }
    }

    public final hfj O000000o(float f, float f2) {
        this.O0000Oo.add(new hfm(f, f2));
        return this;
    }

    public final void O000000o(int i, int i2) {
        int[] iArr = this.O0000oO0;
        this.O0000oO = i - iArr[0];
        this.O0000oOO = this.O0000oO;
        this.O0000oOo = i2 - iArr[1];
        this.O0000oo0 = this.O0000oOo;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(long j) {
        hfi remove = this.O00000Oo.remove(0);
        remove.O000000o();
        for (int i = 0; i < this.O0000Oo.size(); i++) {
            this.O0000Oo.get(i).O000000o(remove, this.O0000o0O);
        }
        int O00000o02 = O00000o0(this.O0000oO, this.O0000oOO);
        int O00000o03 = O00000o0(this.O0000oOo, this.O0000oo0);
        remove.O0000oOO = this.O0000Ooo;
        remove.O000000o(this.O00000o, (float) O00000o02, (float) O00000o03);
        remove.O000000o(j, this.O0000Oo0);
        this.O00000o0.add(remove);
        this.O0000O0o++;
    }

    private int O00000o0(int i, int i2) {
        if (i == i2) {
            return i;
        }
        try {
            return this.O0000o0O.nextInt(i2 - i) + i;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public final void O000000o() {
        this.O0000o00.removeView(this.f18860O000000o);
        this.f18860O000000o = null;
        this.O0000o00.postInvalidate();
        this.O00000Oo.addAll(this.O00000o0);
    }

    public final void O00000Oo() {
        this.O0000OOo = this.O00000oO;
    }

    @SuppressLint({"NewApi"})
    public final void O00000o0() {
        ValueAnimator valueAnimator = this.O0000o0o;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.O0000o0o.cancel();
        }
        Timer timer = this.O0000o;
        if (timer != null) {
            timer.cancel();
            this.O0000o.purge();
            O000000o();
        }
    }

    public final void O000000o(View view, int i, Interpolator interpolator) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (O00000Oo(17, 3)) {
            this.O0000oO = iArr[0] - this.O0000oO0[0];
            this.O0000oOO = this.O0000oO;
        } else if (O00000Oo(17, 5)) {
            this.O0000oO = (iArr[0] + view.getWidth()) - this.O0000oO0[0];
            this.O0000oOO = this.O0000oO;
        } else if (O00000Oo(17, 1)) {
            this.O0000oO = (iArr[0] + (view.getWidth() / 2)) - this.O0000oO0[0];
            this.O0000oOO = this.O0000oO;
        } else {
            this.O0000oO = iArr[0] - this.O0000oO0[0];
            this.O0000oOO = (iArr[0] + view.getWidth()) - this.O0000oO0[0];
        }
        if (O00000Oo(17, 48)) {
            this.O0000oOo = iArr[1] - this.O0000oO0[1];
            this.O0000oo0 = this.O0000oOo;
        } else if (O00000Oo(17, 80)) {
            this.O0000oOo = (iArr[1] + view.getHeight()) - this.O0000oO0[1];
            this.O0000oo0 = this.O0000oOo;
        } else if (O00000Oo(17, 16)) {
            this.O0000oOo = (iArr[1] + (view.getHeight() / 2)) - this.O0000oO0[1];
            this.O0000oo0 = this.O0000oOo;
        } else {
            this.O0000oOo = iArr[1] - this.O0000oO0[1];
            this.O0000oo0 = (iArr[1] + view.getHeight()) - this.O0000oO0[1];
        }
        this.O0000O0o = 0;
        this.O0000OOo = this.O00000o;
        for (int i2 = 0; i2 <= 0 && this.O0000o0 > 0; i2++) {
            O000000o(0);
        }
        this.f18860O000000o = new ParticleField(this.O0000o00.getContext());
        this.O0000o00.addView(this.f18860O000000o);
        this.f18860O000000o.f10242O000000o = this.O00000o0;
        long j = this.O00000o;
        this.O0000o0o = ValueAnimator.ofInt(0, (int) j);
        this.O0000o0o.setDuration(j);
        this.O0000o0o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class _m_j.hfj.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                hfj hfj = hfj.this;
                long j = (long) intValue;
                while (true) {
                    if (((hfj.O0000OOo <= 0 || j >= hfj.O0000OOo) && hfj.O0000OOo != -1) || hfj.O00000Oo.isEmpty() || ((float) hfj.O0000O0o) >= hfj.O00000oo * ((float) j)) {
                        int i = 0;
                    } else {
                        hfj.O000000o(j);
                    }
                }
                int i2 = 0;
                while (i2 < hfj.O00000o0.size()) {
                    hfi hfi = hfj.O00000o0.get(i2);
                    hfi.O0000oOO = hfj.O0000Ooo;
                    if (!hfi.O000000o(j)) {
                        i2--;
                        hfj.O00000Oo.add(hfj.O00000o0.remove(i2));
                    }
                    i2++;
                }
                if (hfj.f18860O000000o != null) {
                    hfj.f18860O000000o.postInvalidate();
                }
            }
        });
        this.O0000o0o.addListener(new Animator.AnimatorListener() {
            /* class _m_j.hfj.AnonymousClass2 */

            public final void onAnimationRepeat(Animator animator) {
            }

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                hfj.this.O000000o();
            }

            public final void onAnimationCancel(Animator animator) {
                hfj.this.O000000o();
            }
        });
        this.O0000o0o.setInterpolator(interpolator);
        this.O0000o0o.start();
    }
}

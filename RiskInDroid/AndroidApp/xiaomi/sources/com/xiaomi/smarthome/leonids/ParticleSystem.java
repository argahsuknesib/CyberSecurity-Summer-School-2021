package com.xiaomi.smarthome.leonids;

import _m_j.gko;
import _m_j.gkp;
import _m_j.gkr;
import _m_j.gks;
import _m_j.gkt;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public final class ParticleSystem {

    /* renamed from: O000000o  reason: collision with root package name */
    public ViewGroup f9070O000000o;
    public ParticleField O00000Oo;
    public final ArrayList<gkp> O00000o;
    public ArrayList<gkp> O00000o0;
    public long O00000oO;
    public long O00000oo;
    public List<gkr> O0000O0o;
    public ValueAnimator O0000OOo;
    public float O0000Oo;
    public Timer O0000Oo0;
    public ParticleSystemType O0000OoO;
    public int O0000Ooo;
    public float O0000o;
    public int O0000o0;
    public int O0000o00;
    public int O0000o0O;
    public int O0000o0o;
    private Random O0000oO;
    private int O0000oO0;
    private long O0000oOO;
    private float O0000oOo;
    private List<Object> O0000oo;
    private int O0000oo0;
    private final O000000o O0000ooO;
    private int[] O0000ooo;
    private int O000O00o;
    private int O000O0OO;
    private int O000O0Oo;
    private float O000O0o;
    private boolean O000O0o0;
    private int O000O0oO;
    private float O00oOoOo;
    private int O00oOooO;
    private int O00oOooo;

    public enum ParticleSystemType {
        Normal,
        Sweeper,
        AirPurifier
    }

    private static boolean O00000Oo(int i, int i2) {
        return (i2 & 80) == i2;
    }

    static class O000000o extends TimerTask {

        /* renamed from: O000000o  reason: collision with root package name */
        private final WeakReference<ParticleSystem> f9071O000000o;

        public O000000o(ParticleSystem particleSystem) {
            this.f9071O000000o = new WeakReference<>(particleSystem);
        }

        public final void run() {
            if (this.f9071O000000o.get() != null) {
                ParticleSystem particleSystem = this.f9071O000000o.get();
                particleSystem.O000000o(particleSystem.O00000oO);
                particleSystem.O00000oO += 50;
            }
        }
    }

    private ParticleSystem(ViewGroup viewGroup, int i, long j) {
        this.O00000o = new ArrayList<>();
        this.O00000oO = 0;
        this.O0000ooO = new O000000o(this);
        this.O0000OoO = ParticleSystemType.Normal;
        this.O00oOoOo = 1.0f;
        this.O0000o = 1.0f;
        this.O000O0o0 = false;
        this.O000O0o = 1.0f;
        this.O0000oO = new Random();
        this.O0000ooo = new int[2];
        O000000o(viewGroup);
        this.O0000oo = new ArrayList();
        this.O0000O0o = new ArrayList();
        this.O0000oO0 = i;
        this.O00000o0 = new ArrayList<>();
        this.O0000oOO = j;
        this.O0000Oo = viewGroup.getContext().getResources().getDisplayMetrics().xdpi / 160.0f;
    }

    private ParticleSystem(ViewGroup viewGroup, int i, Drawable drawable, long j) {
        this(viewGroup, i, j);
        Bitmap bitmap;
        this.O000O0oO = i;
        int i2 = 0;
        if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            while (i2 < this.O0000oO0) {
                this.O00000o0.add(new gko(animationDrawable));
                i2++;
            }
            return;
        }
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
        }
        while (i2 < this.O0000oO0) {
            this.O00000o0.add(new gkp(bitmap));
            i2++;
        }
    }

    public ParticleSystem(Activity activity, int i, int i2, long j) {
        this(activity, i, activity.getResources().getDrawable(i2), j);
    }

    private ParticleSystem(Activity activity, int i, Drawable drawable, long j) {
        this((ViewGroup) activity.findViewById(16908290), i, drawable, j);
    }

    public final ParticleSystem O000000o(int i, int i2) {
        while (i2 < i) {
            i2 += 360;
        }
        List<gkr> list = this.O0000O0o;
        float f = this.O0000Oo;
        list.add(new gkt(0.01f * f, f * 0.03f, i, i2));
        return this;
    }

    public final ParticleSystem O000000o(float f, float f2) {
        this.O0000O0o.add(new gks(f, f2));
        return this;
    }

    public final ParticleSystem O000000o(ViewGroup viewGroup) {
        this.f9070O000000o = viewGroup;
        ViewGroup viewGroup2 = this.f9070O000000o;
        if (viewGroup2 != null) {
            viewGroup2.getLocationInWindow(this.O0000ooo);
        }
        return this;
    }

    public final void O000000o(int i) {
        this.O0000oo0 = 0;
        this.O0000oOo = ((float) i) / 1000.0f;
        this.O00000Oo = new ParticleField(this.f9070O000000o.getContext());
        this.f9070O000000o.addView(this.O00000Oo);
        this.O00000oo = -1;
        this.O00000Oo.f9069O000000o = this.O00000o;
        O00000Oo(i);
        this.O0000Oo0 = new Timer();
        this.O0000Oo0.schedule(this.O0000ooO, 0, 50);
    }

    private int O00000o0(int i, int i2) {
        if (i == i2) {
            return i;
        }
        if (i < i2) {
            return this.O0000oO.nextInt(i2 - i) + i;
        }
        return this.O0000oO.nextInt(i - i2) + i2;
    }

    public final void O000000o(long j) {
        long j2 = j;
        int i = 0;
        int i2 = 0;
        while (true) {
            long j3 = this.O00000oo;
            if (((j3 <= 0 || j2 >= j3) && this.O00000oo != -1) || this.O00000o0.isEmpty() || ((float) this.O0000oo0) >= this.O0000oOo * ((float) j2)) {
                break;
            } else if (this.O0000OoO == ParticleSystemType.Normal) {
                gkp remove = this.O00000o0.remove(0);
                remove.O000000o();
                for (int i3 = 0; i3 < this.O0000O0o.size(); i3++) {
                    this.O0000O0o.get(i3).O000000o(remove, this.O0000oO);
                }
                remove.O000000o(this.O0000oOO, (float) O00000o0(this.O00oOooO, this.O00oOooo), (float) O00000o0(this.O000O00o, this.O000O0OO));
                remove.O000000o(j2, this.O0000oo);
                this.O00000o.add(remove);
                this.O0000oo0++;
            } else if (this.O0000OoO == ParticleSystemType.Sweeper) {
                gkp remove2 = this.O00000o0.remove(0);
                remove2.O000000o();
                for (int i4 = 0; i4 < this.O0000O0o.size(); i4++) {
                    this.O0000O0o.get(i4).O000000o(remove2, this.O0000oO);
                }
                int nextInt = this.O0000oO.nextInt(360);
                double d = (double) nextInt;
                Double.isNaN(d);
                float f = (float) ((d * 3.141592653589793d) / 180.0d);
                int nextInt2 = this.O0000oO.nextInt(this.O0000o00 - this.O0000Ooo) + this.O0000Ooo;
                double d2 = (double) this.O0000o0;
                double d3 = (double) nextInt2;
                double d4 = (double) f;
                double sin = Math.sin(d4);
                Double.isNaN(d3);
                Double.isNaN(d2);
                double d5 = (double) this.O0000o0O;
                double cos = Math.cos(d4);
                Double.isNaN(d3);
                Double.isNaN(d5);
                int[] iArr = {(int) (d2 + (sin * d3)), (int) (d5 - (d3 * cos)), nextInt};
                remove2.O000000o(this.O0000oOO, (float) iArr[0], (float) iArr[1], iArr[2], ParticleSystemType.Sweeper);
                remove2.O000000o(j2, this.O0000oo);
                this.O00000o.add(remove2);
                this.O0000oo0++;
            } else if (this.O0000OoO != ParticleSystemType.AirPurifier) {
                continue;
            } else if (((float) this.O00000o.size()) >= ((float) this.O000O0oO) * this.O000O0o) {
                break;
            } else {
                if (this.O000O0o0) {
                    gkp remove3 = this.O00000o0.remove(0);
                    remove3.O000000o();
                    for (int i5 = 0; i5 < this.O0000O0o.size(); i5++) {
                        this.O0000O0o.get(i5).O000000o(remove3, this.O0000oO);
                    }
                    remove3.O000000o(this.O0000oOO, (float) O00000o0(this.O00oOooO, this.O00oOooo), (float) O00000o0(this.O000O00o == 0 ? 0 : this.f9070O000000o.getHeight(), this.O000O00o == 0 ? 0 : this.f9070O000000o.getHeight()), 0, ParticleSystemType.AirPurifier);
                    remove3.O000000o(j2, this.O0000oo);
                    this.O00000o.add(remove3);
                    this.O0000oo0++;
                } else {
                    for (int i6 = 0; i6 < 10 && this.O00000o0.size() != 0; i6++) {
                        gkp remove4 = this.O00000o0.remove(0);
                        remove4.O000000o();
                        for (int i7 = 0; i7 < this.O0000O0o.size(); i7++) {
                            this.O0000O0o.get(i7).O000000o(remove4, this.O0000oO);
                        }
                        remove4.O000000o((long) (this.O0000oO.nextInt(Math.abs((int) this.O0000oOO)) + 5000), (float) this.O0000oO.nextInt(Math.abs(this.f9070O000000o.getWidth())), (float) this.O0000oO.nextInt(Math.abs(this.f9070O000000o.getHeight())), 0, ParticleSystemType.AirPurifier);
                        remove4.O000000o(j2, this.O0000oo);
                        this.O00000o.add(remove4);
                        this.O0000oo0++;
                    }
                    this.O000O0o0 = true;
                }
                i2++;
                if (((float) i2) > this.O0000oOo * 50.0f) {
                    break;
                }
            }
        }
        synchronized (this.O00000o) {
            if (this.O0000o0o != this.O000O0Oo) {
                Iterator<gkp> it = this.O00000o0.iterator();
                while (it.hasNext()) {
                    gkp next = it.next();
                    next.O000000o(O000000o(this.O0000o0o, next.O00000Oo()));
                }
                Iterator<gkp> it2 = this.O00000o.iterator();
                while (it2.hasNext()) {
                    gkp next2 = it2.next();
                    next2.O000000o(O000000o(this.O0000o0o, next2.O00000Oo()));
                }
                this.O000O0Oo = this.O0000o0o;
            }
            if (this.O0000o != this.O00oOoOo) {
                Iterator<gkp> it3 = this.O00000o0.iterator();
                while (it3.hasNext()) {
                    it3.next().O0000o00 = this.O0000o;
                }
                Iterator<gkp> it4 = this.O00000o.iterator();
                while (it4.hasNext()) {
                    it4.next().O0000o00 = this.O0000o;
                }
                this.O00oOoOo = this.O0000o;
            }
            while (i < this.O00000o.size()) {
                if (!this.O00000o.get(i).O000000o(j2)) {
                    i--;
                    this.O00000o0.add(this.O00000o.remove(i));
                    this.O0000oo0--;
                }
                i++;
            }
        }
        ParticleField particleField = this.O00000Oo;
        if (particleField != null) {
            particleField.postInvalidate();
        }
    }

    private static Bitmap O000000o(int i, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    private void O00000Oo(int i) {
        if (i != 0) {
            long j = this.O00000oO;
            long j2 = (j / 1000) / ((long) i);
            if (j2 != 0) {
                long j3 = j / j2;
                int i2 = 1;
                while (true) {
                    long j4 = (long) i2;
                    if (j4 <= j2) {
                        O000000o((j4 * j3) + 1);
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final void O000000o(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (O00000Oo(80, 3)) {
            this.O00oOooO = iArr[0] - this.O0000ooo[0];
            this.O00oOooo = this.O00oOooO;
        } else if (O00000Oo(80, 5)) {
            this.O00oOooO = (iArr[0] + view.getWidth()) - this.O0000ooo[0];
            this.O00oOooo = this.O00oOooO;
        } else if (O00000Oo(80, 1)) {
            this.O00oOooO = (iArr[0] + (view.getWidth() / 2)) - this.O0000ooo[0];
            this.O00oOooo = this.O00oOooO;
        } else {
            this.O00oOooO = iArr[0] - this.O0000ooo[0];
            this.O00oOooo = (iArr[0] + view.getWidth()) - this.O0000ooo[0];
        }
        if (O00000Oo(80, 48)) {
            this.O000O00o = iArr[1] - this.O0000ooo[1];
            this.O000O0OO = this.O000O00o;
        } else if (O00000Oo(80, 80)) {
            this.O000O00o = (iArr[1] + view.getHeight()) - this.O0000ooo[1];
            this.O000O0OO = this.O000O00o;
        } else if (O00000Oo(80, 16)) {
            this.O000O00o = (iArr[1] + (view.getHeight() / 2)) - this.O0000ooo[1];
            this.O000O0OO = this.O000O00o;
        } else {
            this.O000O00o = iArr[1] - this.O0000ooo[1];
            this.O000O0OO = (iArr[1] + view.getHeight()) - this.O0000ooo[1];
        }
        O000000o(10);
    }
}

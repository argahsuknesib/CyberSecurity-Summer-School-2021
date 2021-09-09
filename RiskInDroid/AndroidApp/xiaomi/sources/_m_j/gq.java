package _m_j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;

public final class gq extends RecyclerView.O0000Oo implements RecyclerView.O0000o {
    private static final int[] O0000oO = new int[0];
    private static final int[] O0000oO0 = {16842919};

    /* renamed from: O000000o  reason: collision with root package name */
    final int f18137O000000o;
    final StateListDrawable O00000Oo;
    int O00000o;
    final Drawable O00000o0;
    int O00000oO;
    float O00000oo;
    int O0000O0o;
    int O0000OOo;
    int O0000Oo = 0;
    float O0000Oo0;
    int O0000OoO = 0;
    RecyclerView O0000Ooo;
    int O0000o = 0;
    boolean O0000o0 = false;
    boolean O0000o00 = false;
    int O0000o0O = 0;
    final ValueAnimator O0000o0o = ValueAnimator.ofFloat(0.0f, 1.0f);
    private final int O0000oOO;
    private final int O0000oOo;
    private final StateListDrawable O0000oo;
    private final int O0000oo0;
    private final Drawable O0000ooO;
    private final int O0000ooo;
    private final int[] O000O00o = new int[2];
    private final int[] O000O0OO = new int[2];
    private final Runnable O000O0Oo = new Runnable() {
        /* class _m_j.gq.AnonymousClass1 */

        public final void run() {
            gq gqVar = gq.this;
            int i = gqVar.O0000o;
            if (i == 1) {
                gqVar.O0000o0o.cancel();
            } else if (i != 2) {
                return;
            }
            gqVar.O0000o = 3;
            gqVar.O0000o0o.setFloatValues(((Float) gqVar.O0000o0o.getAnimatedValue()).floatValue(), 0.0f);
            gqVar.O0000o0o.setDuration(500L);
            gqVar.O0000o0o.start();
        }
    };
    private final RecyclerView.O00oOooO O00oOoOo = new RecyclerView.O00oOooO() {
        /* class _m_j.gq.AnonymousClass2 */

        public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
            gq gqVar = gq.this;
            int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
            int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            int computeVerticalScrollRange = gqVar.O0000Ooo.computeVerticalScrollRange();
            int i3 = gqVar.O0000OoO;
            gqVar.O0000o00 = computeVerticalScrollRange - i3 > 0 && gqVar.O0000OoO >= gqVar.f18137O000000o;
            int computeHorizontalScrollRange = gqVar.O0000Ooo.computeHorizontalScrollRange();
            int i4 = gqVar.O0000Oo;
            gqVar.O0000o0 = computeHorizontalScrollRange - i4 > 0 && gqVar.O0000Oo >= gqVar.f18137O000000o;
            if (gqVar.O0000o00 || gqVar.O0000o0) {
                if (gqVar.O0000o00) {
                    float f = (float) i3;
                    gqVar.O00000oO = (int) ((f * (((float) computeVerticalScrollOffset) + (f / 2.0f))) / ((float) computeVerticalScrollRange));
                    gqVar.O00000o = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
                }
                if (gqVar.O0000o0) {
                    float f2 = (float) computeHorizontalScrollOffset;
                    float f3 = (float) i4;
                    gqVar.O0000OOo = (int) ((f3 * (f2 + (f3 / 2.0f))) / ((float) computeHorizontalScrollRange));
                    gqVar.O0000O0o = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
                }
                if (gqVar.O0000o0O == 0 || gqVar.O0000o0O == 1) {
                    gqVar.O000000o(1);
                }
            } else if (gqVar.O0000o0O != 0) {
                gqVar.O000000o(0);
            }
        }
    };
    private final int O00oOooO;
    private int O00oOooo = 0;

    public final void O000000o(boolean z) {
    }

    public gq(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        this.O00000Oo = stateListDrawable;
        this.O00000o0 = drawable;
        this.O0000oo = stateListDrawable2;
        this.O0000ooO = drawable2;
        this.O0000oOo = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.O0000oo0 = Math.max(i, drawable.getIntrinsicWidth());
        this.O0000ooo = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.O00oOooO = Math.max(i, drawable2.getIntrinsicWidth());
        this.f18137O000000o = i2;
        this.O0000oOO = i3;
        this.O00000Oo.setAlpha(255);
        this.O00000o0.setAlpha(255);
        this.O0000o0o.addListener(new O000000o());
        this.O0000o0o.addUpdateListener(new O00000Oo());
        RecyclerView recyclerView2 = this.O0000Ooo;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                recyclerView2.removeItemDecoration(this);
                this.O0000Ooo.removeOnItemTouchListener(this);
                this.O0000Ooo.removeOnScrollListener(this.O00oOoOo);
                O00000o0();
            }
            this.O0000Ooo = recyclerView;
            RecyclerView recyclerView3 = this.O0000Ooo;
            if (recyclerView3 != null) {
                recyclerView3.addItemDecoration(this);
                this.O0000Ooo.addOnItemTouchListener(this);
                this.O0000Ooo.addOnScrollListener(this.O00oOoOo);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i) {
        if (i == 2 && this.O0000o0O != 2) {
            this.O00000Oo.setState(O0000oO0);
            O00000o0();
        }
        if (i == 0) {
            this.O0000Ooo.invalidate();
        } else {
            O00000Oo();
        }
        if (this.O0000o0O == 2 && i != 2) {
            this.O00000Oo.setState(O0000oO);
            O00000Oo(1200);
        } else if (i == 1) {
            O00000Oo(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        }
        this.O0000o0O = i;
    }

    private boolean O000000o() {
        return cb.O0000Oo0(this.O0000Ooo) == 1;
    }

    private void O00000Oo() {
        int i = this.O0000o;
        if (i != 0) {
            if (i == 3) {
                this.O0000o0o.cancel();
            } else {
                return;
            }
        }
        this.O0000o = 1;
        ValueAnimator valueAnimator = this.O0000o0o;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.O0000o0o.setDuration(500L);
        this.O0000o0o.setStartDelay(0);
        this.O0000o0o.start();
    }

    private void O00000o0() {
        this.O0000Ooo.removeCallbacks(this.O000O0Oo);
    }

    private void O00000Oo(int i) {
        O00000o0();
        this.O0000Ooo.postDelayed(this.O000O0Oo, (long) i);
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        if (this.O0000Oo != this.O0000Ooo.getWidth() || this.O0000OoO != this.O0000Ooo.getHeight()) {
            this.O0000Oo = this.O0000Ooo.getWidth();
            this.O0000OoO = this.O0000Ooo.getHeight();
            O000000o(0);
        } else if (this.O0000o != 0) {
            if (this.O0000o00) {
                int i = this.O0000Oo;
                int i2 = this.O0000oOo;
                int i3 = i - i2;
                int i4 = this.O00000oO;
                int i5 = this.O00000o;
                int i6 = i4 - (i5 / 2);
                this.O00000Oo.setBounds(0, 0, i2, i5);
                this.O00000o0.setBounds(0, 0, this.O0000oo0, this.O0000OoO);
                if (O000000o()) {
                    this.O00000o0.draw(canvas);
                    canvas.translate((float) this.O0000oOo, (float) i6);
                    canvas.scale(-1.0f, 1.0f);
                    this.O00000Oo.draw(canvas);
                    canvas.scale(1.0f, 1.0f);
                    canvas.translate((float) (-this.O0000oOo), (float) (-i6));
                } else {
                    canvas.translate((float) i3, 0.0f);
                    this.O00000o0.draw(canvas);
                    canvas.translate(0.0f, (float) i6);
                    this.O00000Oo.draw(canvas);
                    canvas.translate((float) (-i3), (float) (-i6));
                }
            }
            if (this.O0000o0) {
                int i7 = this.O0000OoO;
                int i8 = this.O0000ooo;
                int i9 = i7 - i8;
                int i10 = this.O0000OOo;
                int i11 = this.O0000O0o;
                int i12 = i10 - (i11 / 2);
                this.O0000oo.setBounds(0, 0, i11, i8);
                this.O0000ooO.setBounds(0, 0, this.O0000Oo, this.O00oOooO);
                canvas.translate(0.0f, (float) i9);
                this.O0000ooO.draw(canvas);
                canvas.translate((float) i12, 0.0f);
                this.O0000oo.draw(canvas);
                canvas.translate((float) (-i12), (float) (-i9));
            }
        }
    }

    public final boolean O000000o(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i = this.O0000o0O;
        if (i == 1) {
            boolean O000000o2 = O000000o(motionEvent.getX(), motionEvent.getY());
            boolean O00000Oo2 = O00000Oo(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!O000000o2 && !O00000Oo2) {
                return false;
            }
            if (O00000Oo2) {
                this.O00oOooo = 1;
                this.O0000Oo0 = (float) ((int) motionEvent.getX());
            } else if (O000000o2) {
                this.O00oOooo = 2;
                this.O00000oo = (float) ((int) motionEvent.getY());
            }
            O000000o(2);
        } else if (i == 2) {
            return true;
        } else {
            return false;
        }
        return true;
    }

    public final void O00000Oo(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.O0000o0O != 0) {
            if (motionEvent.getAction() == 0) {
                boolean O000000o2 = O000000o(motionEvent.getX(), motionEvent.getY());
                boolean O00000Oo2 = O00000Oo(motionEvent.getX(), motionEvent.getY());
                if (O000000o2 || O00000Oo2) {
                    if (O00000Oo2) {
                        this.O00oOooo = 1;
                        this.O0000Oo0 = (float) ((int) motionEvent.getX());
                    } else if (O000000o2) {
                        this.O00oOooo = 2;
                        this.O00000oo = (float) ((int) motionEvent.getY());
                    }
                    O000000o(2);
                }
            } else if (motionEvent.getAction() == 1 && this.O0000o0O == 2) {
                this.O00000oo = 0.0f;
                this.O0000Oo0 = 0.0f;
                O000000o(1);
                this.O00oOooo = 0;
            } else if (motionEvent.getAction() == 2 && this.O0000o0O == 2) {
                O00000Oo();
                if (this.O00oOooo == 1) {
                    float x = motionEvent.getX();
                    int[] iArr = this.O000O0OO;
                    int i = this.O0000oOO;
                    iArr[0] = i;
                    iArr[1] = this.O0000Oo - i;
                    float max = Math.max((float) iArr[0], Math.min((float) iArr[1], x));
                    if (Math.abs(((float) this.O0000OOo) - max) >= 2.0f) {
                        int O000000o3 = O000000o(this.O0000Oo0, max, iArr, this.O0000Ooo.computeHorizontalScrollRange(), this.O0000Ooo.computeHorizontalScrollOffset(), this.O0000Oo);
                        if (O000000o3 != 0) {
                            this.O0000Ooo.scrollBy(O000000o3, 0);
                        }
                        this.O0000Oo0 = max;
                    }
                }
                if (this.O00oOooo == 2) {
                    float y = motionEvent.getY();
                    int[] iArr2 = this.O000O00o;
                    int i2 = this.O0000oOO;
                    iArr2[0] = i2;
                    iArr2[1] = this.O0000OoO - i2;
                    float max2 = Math.max((float) iArr2[0], Math.min((float) iArr2[1], y));
                    if (Math.abs(((float) this.O00000oO) - max2) >= 2.0f) {
                        int O000000o4 = O000000o(this.O00000oo, max2, iArr2, this.O0000Ooo.computeVerticalScrollRange(), this.O0000Ooo.computeVerticalScrollOffset(), this.O0000OoO);
                        if (O000000o4 != 0) {
                            this.O0000Ooo.scrollBy(0, O000000o4);
                        }
                        this.O00000oo = max2;
                    }
                }
            }
        }
    }

    private static int O000000o(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / ((float) i4)) * ((float) i5));
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    private boolean O000000o(float f, float f2) {
        if (O000000o()) {
            if (f > ((float) (this.O0000oOo / 2))) {
                return false;
            }
        } else if (f < ((float) (this.O0000Oo - this.O0000oOo))) {
            return false;
        }
        int i = this.O00000oO;
        int i2 = this.O00000o;
        return f2 >= ((float) (i - (i2 / 2))) && f2 <= ((float) (i + (i2 / 2)));
    }

    private boolean O00000Oo(float f, float f2) {
        if (f2 < ((float) (this.O0000OoO - this.O0000ooo))) {
            return false;
        }
        int i = this.O0000OOo;
        int i2 = this.O0000O0o;
        return f >= ((float) (i - (i2 / 2))) && f <= ((float) (i + (i2 / 2)));
    }

    class O000000o extends AnimatorListenerAdapter {
        private boolean O00000Oo = false;

        O000000o() {
        }

        public final void onAnimationEnd(Animator animator) {
            if (this.O00000Oo) {
                this.O00000Oo = false;
            } else if (((Float) gq.this.O0000o0o.getAnimatedValue()).floatValue() == 0.0f) {
                gq gqVar = gq.this;
                gqVar.O0000o = 0;
                gqVar.O000000o(0);
            } else {
                gq gqVar2 = gq.this;
                gqVar2.O0000o = 2;
                gqVar2.O0000Ooo.invalidate();
            }
        }

        public final void onAnimationCancel(Animator animator) {
            this.O00000Oo = true;
        }
    }

    class O00000Oo implements ValueAnimator.AnimatorUpdateListener {
        O00000Oo() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            gq.this.O00000Oo.setAlpha(floatValue);
            gq.this.O00000o0.setAlpha(floatValue);
            gq.this.O0000Ooo.invalidate();
        }
    }
}

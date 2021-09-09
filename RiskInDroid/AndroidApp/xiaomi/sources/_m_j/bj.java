package _m_j;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class bj {

    /* renamed from: O000000o  reason: collision with root package name */
    private final O000000o f13007O000000o;

    interface O000000o {
        boolean O000000o(MotionEvent motionEvent);
    }

    static class O00000Oo implements O000000o {
        private static final int O0000Ooo = ViewConfiguration.getLongPressTimeout();
        private static final int O0000o0 = ViewConfiguration.getDoubleTapTimeout();
        private static final int O0000o00 = ViewConfiguration.getTapTimeout();

        /* renamed from: O000000o  reason: collision with root package name */
        final Handler f13008O000000o = new O000000o();
        final GestureDetector.OnGestureListener O00000Oo;
        boolean O00000o;
        GestureDetector.OnDoubleTapListener O00000o0;
        boolean O00000oO;
        boolean O00000oo;
        MotionEvent O0000O0o;
        private int O0000OOo;
        private int O0000Oo;
        private int O0000Oo0;
        private int O0000OoO;
        private MotionEvent O0000o;
        private boolean O0000o0O;
        private boolean O0000o0o;
        private float O0000oO;
        private boolean O0000oO0;
        private float O0000oOO;
        private float O0000oOo;
        private boolean O0000oo;
        private float O0000oo0;
        private VelocityTracker O0000ooO;

        class O000000o extends Handler {
            O000000o() {
            }

            public final void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    O00000Oo.this.O00000Oo.onShowPress(O00000Oo.this.O0000O0o);
                } else if (i == 2) {
                    O00000Oo o00000Oo = O00000Oo.this;
                    o00000Oo.f13008O000000o.removeMessages(3);
                    o00000Oo.O00000oO = false;
                    o00000Oo.O00000oo = true;
                    o00000Oo.O00000Oo.onLongPress(o00000Oo.O0000O0o);
                } else if (i != 3) {
                    throw new RuntimeException("Unknown message ".concat(String.valueOf(message)));
                } else if (O00000Oo.this.O00000o0 == null) {
                } else {
                    if (!O00000Oo.this.O00000o) {
                        O00000Oo.this.O00000o0.onSingleTapConfirmed(O00000Oo.this.O0000O0o);
                    } else {
                        O00000Oo.this.O00000oO = true;
                    }
                }
            }
        }

        O00000Oo(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.O00000Oo = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                this.O00000o0 = (GestureDetector.OnDoubleTapListener) onGestureListener;
            }
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.O00000Oo != null) {
                this.O0000oo = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.O0000Oo = viewConfiguration.getScaledMinimumFlingVelocity();
                this.O0000OoO = viewConfiguration.getScaledMaximumFlingVelocity();
                this.O0000OOo = scaledTouchSlop * scaledTouchSlop;
                this.O0000Oo0 = scaledDoubleTapSlop * scaledDoubleTapSlop;
            } else {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:106:0x024b  */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x0273  */
        /* JADX WARNING: Removed duplicated region for block: B:114:0x028a  */
        public final boolean O000000o(MotionEvent motionEvent) {
            boolean z;
            MotionEvent motionEvent2;
            MotionEvent motionEvent3;
            boolean z2;
            boolean z3;
            boolean z4;
            GestureDetector.OnDoubleTapListener onDoubleTapListener;
            int action = motionEvent.getAction();
            if (this.O0000ooO == null) {
                this.O0000ooO = VelocityTracker.obtain();
            }
            this.O0000ooO.addMovement(motionEvent);
            int i = action & 255;
            boolean z5 = i == 6;
            int actionIndex = z5 ? motionEvent.getActionIndex() : -1;
            int pointerCount = motionEvent.getPointerCount();
            float f = 0.0f;
            float f2 = 0.0f;
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (actionIndex != i2) {
                    f += motionEvent.getX(i2);
                    f2 += motionEvent.getY(i2);
                }
            }
            float f3 = (float) (z5 ? pointerCount - 1 : pointerCount);
            float f4 = f / f3;
            float f5 = f2 / f3;
            if (i != 0) {
                if (i == 1) {
                    this.O00000o = false;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    if (this.O0000oO0) {
                        z4 = this.O00000o0.onDoubleTapEvent(motionEvent) | false;
                    } else {
                        if (this.O00000oo) {
                            this.f13008O000000o.removeMessages(3);
                            this.O00000oo = false;
                        } else if (this.O0000o0O) {
                            boolean onSingleTapUp = this.O00000Oo.onSingleTapUp(motionEvent);
                            if (this.O00000oO && (onDoubleTapListener = this.O00000o0) != null) {
                                onDoubleTapListener.onSingleTapConfirmed(motionEvent);
                            }
                            z4 = onSingleTapUp;
                        } else {
                            VelocityTracker velocityTracker = this.O0000ooO;
                            int pointerId = motionEvent.getPointerId(0);
                            velocityTracker.computeCurrentVelocity(1000, (float) this.O0000OoO);
                            float yVelocity = velocityTracker.getYVelocity(pointerId);
                            float xVelocity = velocityTracker.getXVelocity(pointerId);
                            if (Math.abs(yVelocity) > ((float) this.O0000Oo) || Math.abs(xVelocity) > ((float) this.O0000Oo)) {
                                z4 = this.O00000Oo.onFling(this.O0000O0o, motionEvent, xVelocity, yVelocity);
                            }
                        }
                        z4 = false;
                    }
                    MotionEvent motionEvent4 = this.O0000o;
                    if (motionEvent4 != null) {
                        motionEvent4.recycle();
                    }
                    this.O0000o = obtain;
                    VelocityTracker velocityTracker2 = this.O0000ooO;
                    if (velocityTracker2 != null) {
                        velocityTracker2.recycle();
                        this.O0000ooO = null;
                    }
                    this.O0000oO0 = false;
                    this.O00000oO = false;
                    this.f13008O000000o.removeMessages(1);
                    this.f13008O000000o.removeMessages(2);
                } else if (i != 2) {
                    if (i == 3) {
                        this.f13008O000000o.removeMessages(1);
                        this.f13008O000000o.removeMessages(2);
                        this.f13008O000000o.removeMessages(3);
                        this.O0000ooO.recycle();
                        this.O0000ooO = null;
                        this.O0000oO0 = false;
                        this.O00000o = false;
                        this.O0000o0O = false;
                        this.O0000o0o = false;
                        this.O00000oO = false;
                        if (!this.O00000oo) {
                            return false;
                        }
                        this.O00000oo = false;
                        return false;
                    } else if (i == 5) {
                        this.O0000oO = f4;
                        this.O0000oOo = f4;
                        this.O0000oOO = f5;
                        this.O0000oo0 = f5;
                        this.f13008O000000o.removeMessages(1);
                        this.f13008O000000o.removeMessages(2);
                        this.f13008O000000o.removeMessages(3);
                        this.O0000oO0 = false;
                        this.O0000o0O = false;
                        this.O0000o0o = false;
                        this.O00000oO = false;
                        if (!this.O00000oo) {
                            return false;
                        }
                        this.O00000oo = false;
                        return false;
                    } else if (i != 6) {
                        return false;
                    } else {
                        this.O0000oO = f4;
                        this.O0000oOo = f4;
                        this.O0000oOO = f5;
                        this.O0000oo0 = f5;
                        this.O0000ooO.computeCurrentVelocity(1000, (float) this.O0000OoO);
                        int actionIndex2 = motionEvent.getActionIndex();
                        int pointerId2 = motionEvent.getPointerId(actionIndex2);
                        float xVelocity2 = this.O0000ooO.getXVelocity(pointerId2);
                        float yVelocity2 = this.O0000ooO.getYVelocity(pointerId2);
                        for (int i3 = 0; i3 < pointerCount; i3++) {
                            if (i3 != actionIndex2) {
                                int pointerId3 = motionEvent.getPointerId(i3);
                                if ((this.O0000ooO.getXVelocity(pointerId3) * xVelocity2) + (this.O0000ooO.getYVelocity(pointerId3) * yVelocity2) < 0.0f) {
                                    this.O0000ooO.clear();
                                    return false;
                                }
                            }
                        }
                        return false;
                    }
                } else if (this.O00000oo) {
                    return false;
                } else {
                    float f6 = this.O0000oO - f4;
                    float f7 = this.O0000oOO - f5;
                    if (this.O0000oO0) {
                        return false | this.O00000o0.onDoubleTapEvent(motionEvent);
                    }
                    if (this.O0000o0O) {
                        int i4 = (int) (f4 - this.O0000oOo);
                        int i5 = (int) (f5 - this.O0000oo0);
                        int i6 = (i4 * i4) + (i5 * i5);
                        if (i6 > this.O0000OOo) {
                            z3 = this.O00000Oo.onScroll(this.O0000O0o, motionEvent, f6, f7);
                            this.O0000oO = f4;
                            this.O0000oOO = f5;
                            this.O0000o0O = false;
                            this.f13008O000000o.removeMessages(3);
                            this.f13008O000000o.removeMessages(1);
                            this.f13008O000000o.removeMessages(2);
                        } else {
                            z3 = false;
                        }
                        if (i6 > this.O0000OOo) {
                            this.O0000o0o = false;
                        }
                    } else if (Math.abs(f6) < 1.0f && Math.abs(f7) < 1.0f) {
                        return false;
                    } else {
                        boolean onScroll = this.O00000Oo.onScroll(this.O0000O0o, motionEvent, f6, f7);
                        this.O0000oO = f4;
                        this.O0000oOO = f5;
                        return onScroll;
                    }
                }
                return z3;
            }
            if (this.O00000o0 != null) {
                boolean hasMessages = this.f13008O000000o.hasMessages(3);
                if (hasMessages) {
                    this.f13008O000000o.removeMessages(3);
                }
                MotionEvent motionEvent5 = this.O0000O0o;
                if (!(motionEvent5 == null || (motionEvent3 = this.O0000o) == null || !hasMessages)) {
                    if (this.O0000o0o && motionEvent.getEventTime() - motionEvent3.getEventTime() <= ((long) O0000o0)) {
                        int x = ((int) motionEvent5.getX()) - ((int) motionEvent.getX());
                        int y = ((int) motionEvent5.getY()) - ((int) motionEvent.getY());
                        if ((x * x) + (y * y) < this.O0000Oo0) {
                            z2 = true;
                            if (z2) {
                                this.O0000oO0 = true;
                                z = this.O00000o0.onDoubleTap(this.O0000O0o) | false | this.O00000o0.onDoubleTapEvent(motionEvent);
                                this.O0000oO = f4;
                                this.O0000oOo = f4;
                                this.O0000oOO = f5;
                                this.O0000oo0 = f5;
                                motionEvent2 = this.O0000O0o;
                                if (motionEvent2 != null) {
                                    motionEvent2.recycle();
                                }
                                this.O0000O0o = MotionEvent.obtain(motionEvent);
                                this.O0000o0O = true;
                                this.O0000o0o = true;
                                this.O00000o = true;
                                this.O00000oo = false;
                                this.O00000oO = false;
                                if (this.O0000oo) {
                                    this.f13008O000000o.removeMessages(2);
                                    this.f13008O000000o.sendEmptyMessageAtTime(2, this.O0000O0o.getDownTime() + ((long) O0000o00) + ((long) O0000Ooo));
                                }
                                this.f13008O000000o.sendEmptyMessageAtTime(1, this.O0000O0o.getDownTime() + ((long) O0000o00));
                                return z | this.O00000Oo.onDown(motionEvent);
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                    }
                }
                this.f13008O000000o.sendEmptyMessageDelayed(3, (long) O0000o0);
            }
            z = false;
            this.O0000oO = f4;
            this.O0000oOo = f4;
            this.O0000oOO = f5;
            this.O0000oo0 = f5;
            motionEvent2 = this.O0000O0o;
            if (motionEvent2 != null) {
            }
            this.O0000O0o = MotionEvent.obtain(motionEvent);
            this.O0000o0O = true;
            this.O0000o0o = true;
            this.O00000o = true;
            this.O00000oo = false;
            this.O00000oO = false;
            if (this.O0000oo) {
            }
            this.f13008O000000o.sendEmptyMessageAtTime(1, this.O0000O0o.getDownTime() + ((long) O0000o00));
            return z | this.O00000Oo.onDown(motionEvent);
        }
    }

    static class O00000o0 implements O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private final GestureDetector f13010O000000o;

        O00000o0(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f13010O000000o = new GestureDetector(context, onGestureListener, null);
        }

        public final boolean O000000o(MotionEvent motionEvent) {
            return this.f13010O000000o.onTouchEvent(motionEvent);
        }
    }

    public bj(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, (byte) 0);
    }

    private bj(Context context, GestureDetector.OnGestureListener onGestureListener, byte b) {
        if (Build.VERSION.SDK_INT > 17) {
            this.f13007O000000o = new O00000o0(context, onGestureListener, null);
        } else {
            this.f13007O000000o = new O00000Oo(context, onGestureListener, null);
        }
    }

    public final boolean O000000o(MotionEvent motionEvent) {
        return this.f13007O000000o.O000000o(motionEvent);
    }
}

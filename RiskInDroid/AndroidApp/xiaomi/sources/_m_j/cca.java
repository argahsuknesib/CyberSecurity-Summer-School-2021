package _m_j;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class cca {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f13614O000000o = "cca";
    public static final int O0000O0o = ViewConfiguration.getLongPressTimeout();
    public static final int O0000OOo = ViewConfiguration.getTapTimeout();
    public static final int O0000Oo0 = ViewConfiguration.getDoubleTapTimeout();
    public int O00000Oo;
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    public int O00000oo;
    public final Handler O0000Oo = new O000000o();
    public final O00000o0 O0000OoO;
    public O00000Oo O0000Ooo;
    public MotionEvent O0000o;
    public boolean O0000o0;
    public boolean O0000o00;
    public boolean O0000o0O;
    public boolean O0000o0o;
    public boolean O0000oO;
    public MotionEvent O0000oO0;
    public float O0000oOO;
    public float O0000oOo;
    public VelocityTracker O0000oo;
    public boolean O0000oo0;
    private boolean O0000ooO;

    public interface O00000Oo {
        boolean O000000o(MotionEvent motionEvent);
    }

    public static class O00000o implements O00000Oo, O00000o0 {
        public boolean O000000o(float f, float f2) {
            return false;
        }

        public boolean O000000o(MotionEvent motionEvent) {
            return false;
        }
    }

    public interface O00000o0 {
        boolean O000000o(float f, float f2);
    }

    class O000000o extends Handler {
        O000000o() {
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                return;
            }
            if (i == 2) {
                cca cca = cca.this;
                cca.O0000Oo.removeMessages(3);
                cca.O0000o0 = true;
            } else if (i == 3) {
                if (cca.this.O0000Ooo == null || !cca.this.O0000o00) {
                }
            } else {
                throw new RuntimeException("Unknown message ".concat(String.valueOf(message)));
            }
        }
    }

    public cca(Context context, O00000o0 o00000o0) {
        int i;
        int i2;
        int i3;
        this.O0000OoO = o00000o0;
        this.O0000Ooo = (O00000Oo) o00000o0;
        if (this.O0000OoO != null) {
            this.O0000oo0 = true;
            this.O0000ooO = true;
            if (context == null) {
                i2 = ViewConfiguration.getTouchSlop();
                i = i2 + 2;
                i3 = 100;
                this.O00000oO = ViewConfiguration.getMinimumFlingVelocity();
                this.O00000oo = ViewConfiguration.getMaximumFlingVelocity();
            } else {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.O00000oO = viewConfiguration.getScaledMinimumFlingVelocity();
                this.O00000oo = viewConfiguration.getScaledMaximumFlingVelocity();
                i2 = scaledTouchSlop;
                i3 = scaledDoubleTapSlop;
                i = 18;
            }
            this.O00000Oo = i2 * i2;
            this.O00000o0 = i * i;
            this.O00000o = i3 * i3;
            return;
        }
        throw new NullPointerException("OnGestureListener must not be null");
    }
}

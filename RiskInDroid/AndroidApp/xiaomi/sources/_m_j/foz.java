package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

public final class foz implements foy {

    /* renamed from: O000000o  reason: collision with root package name */
    private fpa f16791O000000o;
    private int O00000Oo;
    private int O00000o;
    private fox O00000o0;
    private boolean O00000oO;
    private List<fox> O00000oo = new ArrayList();
    private Handler O0000O0o = new Handler(Looper.getMainLooper()) {
        /* class _m_j.foz.AnonymousClass1 */

        public final void handleMessage(Message message) {
            foz foz = foz.this;
            if (message.what == 1) {
                foz.O00000Oo();
            }
        }
    };

    public foz(fpa fpa) {
        this.f16791O000000o = fpa;
    }

    public final void O000000o(int i, int i2, fow fow) {
        boolean z;
        O00000oo();
        if (i <= O00000oO()) {
            z = false;
        } else {
            this.O00000oo.add(new fox(i, i2, fow));
            z = true;
        }
        if (z) {
            this.O00000oO = false;
            if (!this.O0000O0o.hasMessages(1)) {
                O00000Oo();
            }
        }
    }

    public final void O000000o(int i) {
        O00000oo();
        this.O00000oO = true;
        this.O00000o0 = null;
        this.O00000o = 0;
        this.O00000oo.clear();
        O00000Oo(i);
        this.O0000O0o.removeCallbacksAndMessages(null);
    }

    public final void O000000o() {
        this.O0000O0o.removeCallbacksAndMessages(null);
        this.f16791O000000o = null;
        this.O00000o0 = null;
        this.O00000oo.clear();
    }

    private void O00000o0() {
        if (this.O00000o0 == null) {
            if (this.O00000oo.size() > 0) {
                this.O00000o0 = this.O00000oo.remove(0);
            }
            fox fox = this.O00000o0;
            if (fox == null) {
                return;
            }
            if (fox.f16790O000000o > this.O00000Oo) {
                this.O00000o = (this.O00000o0.O00000Oo * 1) / (this.O00000o0.f16790O000000o - this.O00000Oo);
                O00000Oo();
                return;
            }
            throw new IllegalStateException("the scheduled task's target should be larger than current progress");
        }
    }

    private void O00000Oo(int i) {
        if (i <= 100) {
            this.O00000Oo = i;
            fpa fpa = this.f16791O000000o;
            if (fpa != null) {
                fpa.O000000o(this.O00000Oo);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        int i;
        if (!this.O00000oO) {
            if (this.O00000o0 == null) {
                O00000o0();
                return;
            }
            boolean O00000o2 = O00000o();
            if (this.O00000Oo == this.O00000o0.f16790O000000o) {
                if (O00000o2) {
                    if (this.O00000o0.O00000o0 != null) {
                        this.O00000o0.O00000o0.onBoostComplete();
                    }
                    this.O00000o0 = null;
                    O00000o0();
                }
            } else if (this.O00000Oo <= this.O00000o0.f16790O000000o) {
                int i2 = this.O00000Oo + 1;
                this.O00000Oo = i2;
                O00000Oo(i2);
                if (O00000o2) {
                    i = 10;
                } else {
                    i = this.O00000o;
                }
                this.O0000O0o.sendEmptyMessageDelayed(1, (long) i);
            } else {
                throw new IllegalStateException("current progress should never be larger than current task's target");
            }
        }
    }

    private boolean O00000o() {
        fox fox = this.O00000o0;
        if (fox != null) {
            return fox.f16790O000000o < O00000oO();
        }
        throw new IllegalStateException("current task should not be null");
    }

    private int O00000oO() {
        int size = this.O00000oo.size();
        if (size > 0) {
            return this.O00000oo.get(size - 1).f16790O000000o;
        }
        return 0;
    }

    private static void O00000oo() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ProgressCounter should run in UI thread");
        }
    }
}

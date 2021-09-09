package _m_j;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public final class gfn extends gfm {
    private static boolean O0000Oo = (fsr.O0000O0o || fsr.O0000Oo0);
    public long O00000Oo = 150;
    public int O00000o = 7;
    public long O00000o0 = 225;
    public long O00000oO = this.O00000Oo;
    public long O00000oo = this.O00000o0;
    public final Queue<Integer> O0000O0o = new PriorityQueue();
    public boolean O0000OOo = false;
    @SuppressLint({"HandlerLeak"})
    public Handler O0000Oo0 = new Handler() {
        /* class _m_j.gfn.AnonymousClass1 */
        private Random O00000Oo = new Random();

        public final void handleMessage(Message message) {
            if (message.what == 1000 && gfn.this.O0000O0o.size() > 0) {
                Integer poll = gfn.this.O0000O0o.poll();
                Integer peek = gfn.this.O0000O0o.peek();
                if (poll.intValue() >= 100) {
                    gfn.this.O00000Oo(100);
                    gfn.this.O0000O0o.clear();
                    return;
                }
                gfn.this.O00000Oo(poll.intValue());
                Integer valueOf = Integer.valueOf(poll.intValue() + 1);
                if (peek != null) {
                    gfn gfn = gfn.this;
                    gfn.O00000oO = gfn.O00000Oo;
                    gfn gfn2 = gfn.this;
                    gfn2.O00000oo = gfn2.O00000o0;
                    if (valueOf.intValue() != peek.intValue()) {
                        gfn.this.O0000O0o.offer(valueOf);
                    }
                } else if (valueOf.intValue() > 92) {
                    gfn gfn3 = gfn.this;
                    gfn3.O0000OOo = false;
                    gfn3.O0000O0o.offer(valueOf);
                    gfn.this.O0000Oo0.removeMessages(1000);
                    return;
                } else {
                    gfn gfn4 = gfn.this;
                    long j = gfn4.O00000oo + 80;
                    gfn4.O00000oo = j;
                    gfn4.O00000oO = j;
                    if ((gfn.this.O00000oO - gfn.this.O00000o0) / 80 > ((long) (this.O00000Oo.nextInt(gfn.this.O00000o) + 1))) {
                        gfn gfn5 = gfn.this;
                        gfn5.O0000OOo = false;
                        gfn5.O0000Oo0.removeMessages(1000);
                        gfn gfn6 = gfn.this;
                        gfn6.O00000oO = gfn6.O00000Oo;
                        gfn.this.O0000O0o.offer(valueOf);
                        return;
                    }
                    gfn.this.O0000O0o.offer(valueOf);
                }
                if (gfn.this.O0000O0o.size() > 0) {
                    gfn.this.O0000Oo0.sendEmptyMessageDelayed(1000, gfn.this.O00000oO);
                    return;
                }
                gfn gfn7 = gfn.this;
                gfn7.O0000OOo = false;
                gfn7.O0000Oo0.removeMessages(1000);
            }
        }
    };
    private String O0000OoO;
    private boolean O0000Ooo;
    private int O0000o = 0;
    private long O0000o0 = 0;
    private boolean O0000o00;
    private int O0000o0O = 0;
    private long O0000o0o = 0;

    public gfn(String str, boolean z) {
        this.O0000OoO = str;
        this.O0000Ooo = z;
    }

    public final void O000000o(int i) {
        if (this.O0000O0o.size() <= 0 || i > this.O0000O0o.peek().intValue()) {
            if (i == 100) {
                this.O00000oo = 120;
                this.O00000oO = 120;
            } else if (i != 0) {
                if (this.O0000o0 == 0) {
                    this.O0000o0 = System.currentTimeMillis();
                    this.O0000o0O = i;
                } else if (this.O0000o0o == 0 && i != this.O0000o0O) {
                    this.O0000o0o = System.currentTimeMillis();
                    this.O0000o = i;
                    long j = (this.O0000o0o - this.O0000o0) / ((long) (this.O0000o - this.O0000o0O));
                    if (O0000Oo) {
                        gsy.O000000o(6, "InterpolationGenerator", this.O0000OoO + "; interval adjust to : " + j);
                    }
                    this.O00000Oo = j;
                    this.O00000oO = j;
                    double d = (double) j;
                    Double.isNaN(d);
                    long j2 = (long) (d * 1.5d);
                    this.O00000o0 = j2;
                    this.O00000oo = j2;
                    int i2 = this.O0000o;
                    int i3 = this.O0000o0O;
                    if (i2 - i3 <= 3) {
                        this.O00000o = 2;
                        if (O0000Oo) {
                            gsy.O000000o(6, "InterpolationGenerator", this.O0000OoO + "; over_extend adjust to : " + this.O00000o);
                        }
                    } else if (i2 - i3 >= 15) {
                        this.O00000o = 12;
                        if (O0000Oo) {
                            gsy.O000000o(6, "InterpolationGenerator", this.O0000OoO + "; over_extend adjust to : " + this.O00000o);
                        }
                    } else {
                        this.O00000o = 7;
                        if (O0000Oo) {
                            gsy.O000000o(6, "InterpolationGenerator", this.O0000OoO + "; over_extend is default : " + this.O00000o);
                        }
                    }
                    this.O0000o0 = 0;
                    this.O0000o0o = 0;
                }
            }
            if (!this.O0000o00) {
                this.O0000o00 = true;
                if (this.O0000O0o.size() == 0) {
                    if (this.O0000Ooo) {
                        this.O0000O0o.add(Integer.valueOf(Math.max(0, i - 1)));
                    } else {
                        this.O0000O0o.add(0);
                    }
                }
            }
            this.O0000O0o.add(Integer.valueOf(i));
            if (!this.O0000OOo) {
                this.O0000OOo = true;
                this.O0000Oo0.sendEmptyMessageDelayed(1000, this.O00000oO);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(int i) {
        super.O00000Oo(i);
    }

    public final void O000000o() {
        this.O0000Oo0.removeCallbacksAndMessages(null);
        this.O0000Oo0 = null;
    }
}

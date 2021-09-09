package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class elo {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile elo f15610O000000o;
    private ScheduledThreadPoolExecutor O00000Oo = new ScheduledThreadPoolExecutor(1);
    /* access modifiers changed from: private */
    public Object O00000o = new Object();
    /* access modifiers changed from: private */
    public Map<String, ScheduledFuture> O00000o0 = new HashMap();
    /* access modifiers changed from: private */
    public SharedPreferences O00000oO;

    public static abstract class O000000o implements Runnable {
        public abstract String a();
    }

    static class O00000Oo implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        O000000o f15611O000000o;

        public O00000Oo(O000000o o000000o) {
            this.f15611O000000o = o000000o;
        }

        /* access modifiers changed from: package-private */
        public void O000000o() {
        }

        public void run() {
            this.f15611O000000o.run();
            O000000o();
        }
    }

    private elo(Context context) {
        this.O00000oO = context.getSharedPreferences("mipush_extra", 0);
    }

    public static elo O000000o(Context context) {
        if (f15610O000000o == null) {
            synchronized (elo.class) {
                if (f15610O000000o == null) {
                    f15610O000000o = new elo(context);
                }
            }
        }
        return f15610O000000o;
    }

    private ScheduledFuture O000000o(O000000o o000000o) {
        ScheduledFuture scheduledFuture;
        synchronized (this.O00000o) {
            scheduledFuture = this.O00000o0.get(o000000o.a());
        }
        return scheduledFuture;
    }

    public final void O000000o(Runnable runnable, int i) {
        this.O00000Oo.schedule(runnable, (long) i, TimeUnit.SECONDS);
    }

    public final boolean O000000o(O000000o o000000o, int i) {
        if (o000000o == null || O000000o(o000000o) != null) {
            return false;
        }
        ScheduledFuture<?> schedule = this.O00000Oo.schedule(new elq(this, o000000o), (long) i, TimeUnit.SECONDS);
        synchronized (this.O00000o) {
            this.O00000o0.put(o000000o.a(), schedule);
        }
        return true;
    }

    public final boolean O000000o(String str) {
        synchronized (this.O00000o) {
            ScheduledFuture scheduledFuture = this.O00000o0.get(str);
            if (scheduledFuture == null) {
                return false;
            }
            this.O00000o0.remove(str);
            return scheduledFuture.cancel(false);
        }
    }

    public boolean O000000o(O000000o o000000o, int i, int i2) {
        if (o000000o == null || O000000o(o000000o) != null) {
            return false;
        }
        String concat = "last_job_time".concat(String.valueOf(o000000o.a()));
        elp elp = new elp(this, o000000o, false, concat);
        long abs = Math.abs(System.currentTimeMillis() - this.O00000oO.getLong(concat, 0)) / 1000;
        if (abs < ((long) (i - i2))) {
            i2 = (int) (((long) i) - abs);
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.O00000Oo.scheduleAtFixedRate(elp, (long) i2, (long) i, TimeUnit.SECONDS);
            synchronized (this.O00000o) {
                this.O00000o0.put(o000000o.a(), scheduleAtFixedRate);
            }
            return true;
        } catch (Exception e) {
            duv.O000000o(e);
            return true;
        }
    }
}

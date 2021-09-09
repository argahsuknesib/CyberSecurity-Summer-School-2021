package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class JobIntentService extends Service {
    static final Object O0000OOo = new Object();
    static final HashMap<ComponentName, O0000Oo> O0000Oo0 = new HashMap<>();

    /* renamed from: O000000o  reason: collision with root package name */
    O00000Oo f2815O000000o;
    O0000Oo O00000Oo;
    boolean O00000o = false;
    O000000o O00000o0;
    boolean O00000oO = false;
    boolean O00000oo = false;
    final ArrayList<O00000o> O0000O0o;

    interface O00000Oo {
        IBinder O000000o();

        O0000O0o O00000Oo();
    }

    interface O0000O0o {
        Intent O000000o();

        void O00000Oo();
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    static abstract class O0000Oo {
        boolean O00000o;
        final ComponentName O00000o0;
        int O00000oO;

        public void O000000o() {
        }

        /* access modifiers changed from: package-private */
        public abstract void O000000o(Intent intent);

        public void O00000Oo() {
        }

        public void O00000o0() {
        }

        O0000Oo(ComponentName componentName) {
            this.O00000o0 = componentName;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(int i) {
            if (!this.O00000o) {
                this.O00000o = true;
                this.O00000oO = i;
            } else if (this.O00000oO != i) {
                throw new IllegalArgumentException("Given job ID " + i + " is different than previous " + this.O00000oO);
            }
        }
    }

    static final class O00000o0 extends O0000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f2818O000000o;
        boolean O00000Oo;
        private final Context O00000oo;
        private final PowerManager.WakeLock O0000O0o;
        private final PowerManager.WakeLock O0000OOo;

        O00000o0(Context context, ComponentName componentName) {
            super(componentName);
            this.O00000oo = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            this.O0000O0o = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.O0000O0o.setReferenceCounted(false);
            this.O0000OOo = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.O0000OOo.setReferenceCounted(false);
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.O00000o0);
            if (this.O00000oo.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.f2818O000000o) {
                        this.f2818O000000o = true;
                        if (!this.O00000Oo) {
                            this.O0000O0o.acquire(60000);
                        }
                    }
                }
            }
        }

        public final void O000000o() {
            synchronized (this) {
                this.f2818O000000o = false;
            }
        }

        public final void O00000Oo() {
            synchronized (this) {
                if (!this.O00000Oo) {
                    this.O00000Oo = true;
                    this.O0000OOo.acquire(600000);
                    this.O0000O0o.release();
                }
            }
        }

        public final void O00000o0() {
            synchronized (this) {
                if (this.O00000Oo) {
                    if (this.f2818O000000o) {
                        this.O0000O0o.acquire(60000);
                    }
                    this.O00000Oo = false;
                    this.O0000OOo.release();
                }
            }
        }
    }

    static final class O0000OOo extends JobServiceEngine implements O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        final JobIntentService f2819O000000o;
        final Object O00000Oo = new Object();
        JobParameters O00000o0;

        final class O000000o implements O0000O0o {

            /* renamed from: O000000o  reason: collision with root package name */
            final JobWorkItem f2820O000000o;

            O000000o(JobWorkItem jobWorkItem) {
                this.f2820O000000o = jobWorkItem;
            }

            public final Intent O000000o() {
                return this.f2820O000000o.getIntent();
            }

            public final void O00000Oo() {
                synchronized (O0000OOo.this.O00000Oo) {
                    if (O0000OOo.this.O00000o0 != null) {
                        O0000OOo.this.O00000o0.completeWork(this.f2820O000000o);
                    }
                }
            }
        }

        O0000OOo(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f2819O000000o = jobIntentService;
        }

        public final IBinder O000000o() {
            return getBinder();
        }

        public final boolean onStartJob(JobParameters jobParameters) {
            this.O00000o0 = jobParameters;
            this.f2819O000000o.O000000o(false);
            return true;
        }

        public final boolean onStopJob(JobParameters jobParameters) {
            JobIntentService jobIntentService = this.f2819O000000o;
            if (jobIntentService.O00000o0 != null) {
                jobIntentService.O00000o0.cancel(jobIntentService.O00000o);
            }
            jobIntentService.O00000oO = true;
            boolean onStopCurrentWork = jobIntentService.onStopCurrentWork();
            synchronized (this.O00000Oo) {
                this.O00000o0 = null;
            }
            return onStopCurrentWork;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
            r1.getIntent().setExtrasClassLoader(r3.f2819O000000o.getClassLoader());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
            return new androidx.core.app.JobIntentService.O0000OOo.O000000o(r3, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            if (r1 == null) goto L_0x0026;
         */
        public final O0000O0o O00000Oo() {
            synchronized (this.O00000Oo) {
                if (this.O00000o0 == null) {
                    return null;
                }
                JobWorkItem dequeueWork = this.O00000o0.dequeueWork();
            }
        }
    }

    static final class O0000Oo0 extends O0000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private final JobInfo f2821O000000o;
        private final JobScheduler O00000Oo;

        O0000Oo0(Context context, ComponentName componentName, int i) {
            super(componentName);
            O000000o(i);
            this.f2821O000000o = new JobInfo.Builder(i, this.O00000o0).setOverrideDeadline(0).build();
            this.O00000Oo = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(Intent intent) {
            this.O00000Oo.enqueue(this.f2821O000000o, new JobWorkItem(intent));
        }
    }

    final class O00000o implements O0000O0o {

        /* renamed from: O000000o  reason: collision with root package name */
        final Intent f2817O000000o;
        final int O00000Oo;

        O00000o(Intent intent, int i) {
            this.f2817O000000o = intent;
            this.O00000Oo = i;
        }

        public final Intent O000000o() {
            return this.f2817O000000o;
        }

        public final void O00000Oo() {
            JobIntentService.this.stopSelf(this.O00000Oo);
        }
    }

    final class O000000o extends AsyncTask<Void, Void, Void> {
        O000000o() {
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onCancelled(Object obj) {
            JobIntentService.this.O000000o();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            JobIntentService.this.O000000o();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            while (true) {
                O0000O0o O00000Oo = JobIntentService.this.O00000Oo();
                if (O00000Oo == null) {
                    return null;
                }
                O00000Oo.O000000o();
                O00000Oo.O00000Oo();
            }
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.O0000O0o = null;
        } else {
            this.O0000O0o = new ArrayList<>();
        }
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2815O000000o = new O0000OOo(this);
            this.O00000Oo = null;
            return;
        }
        this.f2815O000000o = null;
        this.O00000Oo = O000000o(this, new ComponentName(this, getClass()), false, 0);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.O0000O0o == null) {
            return 2;
        }
        this.O00000Oo.O000000o();
        synchronized (this.O0000O0o) {
            ArrayList<O00000o> arrayList = this.O0000O0o;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new O00000o(intent, i2));
            O000000o(true);
        }
        return 3;
    }

    public IBinder onBind(Intent intent) {
        O00000Oo o00000Oo = this.f2815O000000o;
        if (o00000Oo != null) {
            return o00000Oo.O000000o();
        }
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
        ArrayList<O00000o> arrayList = this.O0000O0o;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.O00000oo = true;
                this.O00000Oo.O00000o0();
            }
        }
    }

    public static void enqueueWork(Context context, Class<?> cls, int i, Intent intent) {
        enqueueWork(context, new ComponentName(context, cls), i, intent);
    }

    public static void enqueueWork(Context context, ComponentName componentName, int i, Intent intent) {
        if (intent != null) {
            synchronized (O0000OOo) {
                O0000Oo O000000o2 = O000000o(context, componentName, true, i);
                O000000o2.O000000o(i);
                O000000o2.O000000o(intent);
            }
            return;
        }
        throw new IllegalArgumentException("work must not be null");
    }

    private static O0000Oo O000000o(Context context, ComponentName componentName, boolean z, int i) {
        O0000Oo o0000Oo;
        O0000Oo o0000Oo2 = O0000Oo0.get(componentName);
        if (o0000Oo2 != null) {
            return o0000Oo2;
        }
        if (Build.VERSION.SDK_INT < 26) {
            o0000Oo = new O00000o0(context, componentName);
        } else if (z) {
            o0000Oo = new O0000Oo0(context, componentName, i);
        } else {
            throw new IllegalArgumentException("Can't be here without a job id");
        }
        O0000Oo o0000Oo3 = o0000Oo;
        O0000Oo0.put(componentName, o0000Oo3);
        return o0000Oo3;
    }

    public void setInterruptIfStopped(boolean z) {
        this.O00000o = z;
    }

    public boolean isStopped() {
        return this.O00000oO;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(boolean z) {
        if (this.O00000o0 == null) {
            this.O00000o0 = new O000000o();
            O0000Oo o0000Oo = this.O00000Oo;
            if (o0000Oo != null && z) {
                o0000Oo.O00000Oo();
            }
            this.O00000o0.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        ArrayList<O00000o> arrayList = this.O0000O0o;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.O00000o0 = null;
                if (this.O0000O0o != null && this.O0000O0o.size() > 0) {
                    O000000o(false);
                } else if (!this.O00000oo) {
                    this.O00000Oo.O00000o0();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final O0000O0o O00000Oo() {
        O00000Oo o00000Oo = this.f2815O000000o;
        if (o00000Oo != null) {
            return o00000Oo.O00000Oo();
        }
        synchronized (this.O0000O0o) {
            if (this.O0000O0o.size() <= 0) {
                return null;
            }
            O0000O0o remove = this.O0000O0o.remove(0);
            return remove;
        }
    }
}

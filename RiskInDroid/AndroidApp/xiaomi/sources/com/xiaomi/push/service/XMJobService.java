package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.emg;
import _m_j.epp;
import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

public class XMJobService extends Service {

    /* renamed from: a  reason: collision with root package name */
    static Service f6462a;

    /* renamed from: a  reason: collision with other field name */
    private IBinder f190a = null;

    @TargetApi(21)
    static class a extends JobService {

        /* renamed from: a  reason: collision with root package name */
        Binder f6463a;

        /* renamed from: a  reason: collision with other field name */
        private Handler f191a;

        /* renamed from: com.xiaomi.push.service.XMJobService$a$a  reason: collision with other inner class name */
        static class C0060a extends Handler {

            /* renamed from: a  reason: collision with root package name */
            JobService f6464a;

            C0060a(JobService jobService) {
                super(jobService.getMainLooper());
                this.f6464a = jobService;
            }

            public void handleMessage(Message message) {
                if (message.what == 1) {
                    JobParameters jobParameters = (JobParameters) message.obj;
                    duv.O000000o("Job finished " + jobParameters.getJobId());
                    this.f6464a.jobFinished(jobParameters, false);
                    if (jobParameters.getJobId() == 1) {
                        epp.O000000o(false);
                    }
                }
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):T
         arg types: [com.xiaomi.push.service.XMJobService$a, java.lang.String, java.lang.Object[]]
         candidates:
          _m_j.emg.O000000o(java.lang.Class<? extends java.lang.Object>, java.lang.Object, java.lang.String):T
          _m_j.emg.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):T
          _m_j.emg.O000000o(java.lang.Class<?>, java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
          _m_j.emg.O000000o(java.lang.reflect.Method[], java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
          _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object):void
          _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):T */
        a(Service service) {
            this.f6463a = null;
            this.f6463a = (Binder) emg.O000000o((Object) this, "onBind", new Intent());
            emg.O000000o((Object) this, "attachBaseContext", service);
        }

        public boolean onStartJob(JobParameters jobParameters) {
            duv.O000000o("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f191a == null) {
                this.f191a = new C0060a(this);
            }
            Handler handler = this.f191a;
            handler.sendMessage(Message.obtain(handler, 1, jobParameters));
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            duv.O000000o("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    public IBinder onBind(Intent intent) {
        IBinder iBinder = this.f190a;
        return iBinder != null ? iBinder : new Binder();
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f190a = new a(this).f6463a;
        }
        f6462a = this;
    }

    public void onDestroy() {
        super.onDestroy();
        f6462a = null;
    }
}

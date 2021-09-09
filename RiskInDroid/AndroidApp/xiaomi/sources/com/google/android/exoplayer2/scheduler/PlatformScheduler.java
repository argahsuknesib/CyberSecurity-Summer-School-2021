package com.google.android.exoplayer2.scheduler;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class PlatformScheduler implements Scheduler {
    private final int jobId;
    private final JobScheduler jobScheduler;
    private final ComponentName jobServiceComponentName;

    public static void logd(String str) {
    }

    public PlatformScheduler(Context context, int i) {
        Context applicationContext = context.getApplicationContext();
        this.jobId = i;
        this.jobServiceComponentName = new ComponentName(applicationContext, PlatformSchedulerService.class);
        this.jobScheduler = (JobScheduler) applicationContext.getSystemService("jobscheduler");
    }

    public final boolean schedule(Requirements requirements, String str, String str2) {
        int schedule = this.jobScheduler.schedule(buildJobInfo(this.jobId, this.jobServiceComponentName, requirements, str2, str));
        logd("Scheduling job: " + this.jobId + " result: " + schedule);
        return schedule == 1;
    }

    public final boolean cancel() {
        logd("Canceling job: " + this.jobId);
        this.jobScheduler.cancel(this.jobId);
        return true;
    }

    private static JobInfo buildJobInfo(int i, ComponentName componentName, Requirements requirements, String str, String str2) {
        JobInfo.Builder builder = new JobInfo.Builder(i, componentName);
        if (requirements.isUnmeteredNetworkRequired()) {
            builder.setRequiredNetworkType(2);
        } else if (requirements.isNetworkRequired()) {
            builder.setRequiredNetworkType(1);
        }
        builder.setRequiresDeviceIdle(requirements.isIdleRequired());
        builder.setRequiresCharging(requirements.isChargingRequired());
        builder.setPersisted(true);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("service_action", str);
        persistableBundle.putString("service_package", str2);
        persistableBundle.putInt("requirements", requirements.getRequirements());
        builder.setExtras(persistableBundle);
        return builder.build();
    }

    public static final class PlatformSchedulerService extends JobService {
        public final boolean onStopJob(JobParameters jobParameters) {
            return false;
        }

        public final boolean onStartJob(JobParameters jobParameters) {
            PlatformScheduler.logd("PlatformSchedulerService started");
            PersistableBundle extras = jobParameters.getExtras();
            if (new Requirements(extras.getInt("requirements")).checkRequirements(this)) {
                PlatformScheduler.logd("Requirements are met");
                String string = extras.getString("service_action");
                String string2 = extras.getString("service_package");
                Intent intent = new Intent((String) Assertions.checkNotNull(string)).setPackage(string2);
                PlatformScheduler.logd("Starting service action: " + string + " package: " + string2);
                Util.startForegroundService(this, intent);
                return false;
            }
            PlatformScheduler.logd("Requirements are not met");
            jobFinished(jobParameters, true);
            return false;
        }
    }
}

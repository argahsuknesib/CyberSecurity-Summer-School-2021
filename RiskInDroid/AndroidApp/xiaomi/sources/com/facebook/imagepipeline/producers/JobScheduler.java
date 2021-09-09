package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JobScheduler {
    private final Runnable mDoJobRunnable = new Runnable() {
        /* class com.facebook.imagepipeline.producers.JobScheduler.AnonymousClass1 */

        public void run() {
            JobScheduler.this.doJob();
        }
    };
    @VisibleForTesting
    EncodedImage mEncodedImage = null;
    private final Executor mExecutor;
    private final JobRunnable mJobRunnable;
    @VisibleForTesting
    long mJobStartTime = 0;
    @VisibleForTesting
    JobState mJobState = JobState.IDLE;
    @VisibleForTesting
    long mJobSubmitTime = 0;
    private final int mMinimumJobIntervalMs;
    @VisibleForTesting
    int mStatus = 0;
    private final Runnable mSubmitJobRunnable = new Runnable() {
        /* class com.facebook.imagepipeline.producers.JobScheduler.AnonymousClass2 */

        public void run() {
            JobScheduler.this.submitJob();
        }
    };

    public interface JobRunnable {
        void run(EncodedImage encodedImage, int i);
    }

    @VisibleForTesting
    enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    @VisibleForTesting
    static class JobStartExecutorSupplier {
        private static ScheduledExecutorService sJobStarterExecutor;

        JobStartExecutorSupplier() {
        }

        static ScheduledExecutorService get() {
            if (sJobStarterExecutor == null) {
                sJobStarterExecutor = Executors.newSingleThreadScheduledExecutor();
            }
            return sJobStarterExecutor;
        }
    }

    public JobScheduler(Executor executor, JobRunnable jobRunnable, int i) {
        this.mExecutor = executor;
        this.mJobRunnable = jobRunnable;
        this.mMinimumJobIntervalMs = i;
    }

    public void clearJob() {
        EncodedImage encodedImage;
        synchronized (this) {
            encodedImage = this.mEncodedImage;
            this.mEncodedImage = null;
            this.mStatus = 0;
        }
        EncodedImage.closeSafely(encodedImage);
    }

    public boolean updateJob(EncodedImage encodedImage, int i) {
        EncodedImage encodedImage2;
        if (!shouldProcess(encodedImage, i)) {
            return false;
        }
        synchronized (this) {
            encodedImage2 = this.mEncodedImage;
            this.mEncodedImage = EncodedImage.cloneOrNull(encodedImage);
            this.mStatus = i;
        }
        EncodedImage.closeSafely(encodedImage2);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        if (r3 == false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        enqueueJob(r5 - r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        return true;
     */
    public boolean scheduleJob() {
        long j;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            boolean z = false;
            if (!shouldProcess(this.mEncodedImage, this.mStatus)) {
                return false;
            }
            int i = AnonymousClass3.$SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[this.mJobState.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.mJobState = JobState.RUNNING_AND_PENDING;
                    }
                }
                j = 0;
            } else {
                j = Math.max(this.mJobStartTime + ((long) this.mMinimumJobIntervalMs), uptimeMillis);
                this.mJobSubmitTime = uptimeMillis;
                this.mJobState = JobState.QUEUED;
                z = true;
            }
        }
    }

    /* renamed from: com.facebook.imagepipeline.producers.JobScheduler$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState = new int[JobState.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[JobState.IDLE.ordinal()] = 1;
            $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[JobState.QUEUED.ordinal()] = 2;
            $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[JobState.RUNNING.ordinal()] = 3;
            try {
                $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[JobState.RUNNING_AND_PENDING.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void enqueueJob(long j) {
        if (j > 0) {
            JobStartExecutorSupplier.get().schedule(this.mSubmitJobRunnable, j, TimeUnit.MILLISECONDS);
        } else {
            this.mSubmitJobRunnable.run();
        }
    }

    public void submitJob() {
        this.mExecutor.execute(this.mDoJobRunnable);
    }

    public void doJob() {
        EncodedImage encodedImage;
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            encodedImage = this.mEncodedImage;
            i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.mJobState = JobState.RUNNING;
            this.mJobStartTime = uptimeMillis;
        }
        try {
            if (shouldProcess(encodedImage, i)) {
                this.mJobRunnable.run(encodedImage, i);
            }
        } finally {
            EncodedImage.closeSafely(encodedImage);
            onJobFinished();
        }
    }

    private void onJobFinished() {
        boolean z;
        long j;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            if (this.mJobState == JobState.RUNNING_AND_PENDING) {
                j = Math.max(this.mJobStartTime + ((long) this.mMinimumJobIntervalMs), uptimeMillis);
                z = true;
                this.mJobSubmitTime = uptimeMillis;
                this.mJobState = JobState.QUEUED;
            } else {
                this.mJobState = JobState.IDLE;
                j = 0;
                z = false;
            }
        }
        if (z) {
            enqueueJob(j - uptimeMillis);
        }
    }

    private static boolean shouldProcess(EncodedImage encodedImage, int i) {
        return BaseConsumer.isLast(i) || BaseConsumer.statusHasFlag(i, 4) || EncodedImage.isValid(encodedImage);
    }

    public synchronized long getQueuedTime() {
        return this.mJobStartTime - this.mJobSubmitTime;
    }
}

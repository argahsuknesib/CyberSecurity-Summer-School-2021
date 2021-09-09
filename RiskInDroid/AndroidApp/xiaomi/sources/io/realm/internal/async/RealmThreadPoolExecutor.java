package io.realm.internal.async;

import _m_j.isl;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

public class RealmThreadPoolExecutor extends ThreadPoolExecutor {
    private static final int CORE_POOL_SIZE = calculateCorePoolSize();
    private boolean isPaused;
    private ReentrantLock pauseLock = new ReentrantLock();
    private Condition unpaused = this.pauseLock.newCondition();

    public static RealmThreadPoolExecutor newDefaultExecutor() {
        int i = CORE_POOL_SIZE;
        return new RealmThreadPoolExecutor(i, i);
    }

    public static RealmThreadPoolExecutor newSingleThreadExecutor() {
        return new RealmThreadPoolExecutor(1, 1);
    }

    @SuppressFBWarnings({"DMI_HARDCODED_ABSOLUTE_FILENAME"})
    private static int calculateCorePoolSize() {
        int countFilesInDir = countFilesInDir("/sys/devices/system/cpu/", "cpu[0-9]+");
        if (countFilesInDir <= 0) {
            countFilesInDir = Runtime.getRuntime().availableProcessors();
        }
        if (countFilesInDir <= 0) {
            return 1;
        }
        return (countFilesInDir * 2) + 1;
    }

    private static int countFilesInDir(String str, String str2) {
        final Pattern compile = Pattern.compile(str2);
        try {
            File[] listFiles = new File(str).listFiles(new FileFilter() {
                /* class io.realm.internal.async.RealmThreadPoolExecutor.AnonymousClass1 */

                public final boolean accept(File file) {
                    return compile.matcher(file.getName()).matches();
                }
            });
            if (listFiles == null) {
                return 0;
            }
            return listFiles.length;
        } catch (SecurityException unused) {
            return 0;
        }
    }

    private RealmThreadPoolExecutor(int i, int i2) {
        super(i, i2, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(100));
    }

    public Future<?> submitTransaction(Runnable runnable) {
        return super.submit(new isl(runnable));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        r0.pauseLock.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r1.interrupt();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001a */
    public void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        this.pauseLock.lock();
        while (true) {
            if (!this.isPaused) {
                break;
            }
            this.unpaused.await();
        }
        this.pauseLock.unlock();
    }

    public void pause() {
        this.pauseLock.lock();
        try {
            this.isPaused = true;
        } finally {
            this.pauseLock.unlock();
        }
    }

    public void resume() {
        this.pauseLock.lock();
        try {
            this.isPaused = false;
            this.unpaused.signalAll();
        } finally {
            this.pauseLock.unlock();
        }
    }
}

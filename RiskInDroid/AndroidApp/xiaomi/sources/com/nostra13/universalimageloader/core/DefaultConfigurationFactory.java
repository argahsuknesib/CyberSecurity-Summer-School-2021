package com.nostra13.universalimageloader.core;

import _m_j.cni;
import _m_j.cnk;
import _m_j.cnm;
import _m_j.cnp;
import _m_j.cou;
import _m_j.cow;
import android.content.Context;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class DefaultConfigurationFactory {
    public static Executor O000000o(int i, int i2, QueueProcessingType queueProcessingType) {
        return new ThreadPoolExecutor(i, i, 0, TimeUnit.MILLISECONDS, queueProcessingType == QueueProcessingType.LIFO ? new LIFOLinkedBlockingDeque() : new LinkedBlockingQueue(), O000000o(i2, "uil-pool-"));
    }

    public static ThreadFactory O000000o(int i, String str) {
        return new DefaultThreadFactory(i, str);
    }

    static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final int threadPriority;

        DefaultThreadFactory(int i, String str) {
            this.threadPriority = i;
            this.group = Thread.currentThread().getThreadGroup();
            this.namePrefix = str + poolNumber.getAndIncrement() + "-thread-";
        }

        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.group;
            Thread thread = new Thread(threadGroup, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.threadPriority);
            return thread;
        }
    }

    public static cni O000000o(Context context, cnp cnp, long j, int i) {
        File O000000o2 = cow.O000000o(context, false);
        File file = new File(O000000o2, "uil-images");
        if (file.exists() || file.mkdir()) {
            O000000o2 = file;
        }
        if (j > 0 || i > 0) {
            File O000000o3 = cow.O000000o(context, true);
            File file2 = new File(O000000o3, "uil-images");
            try {
                return new cnm((file2.exists() || file2.mkdir()) ? file2 : O000000o3, O000000o2, cnp, j, i);
            } catch (IOException e) {
                cou.O000000o(e);
            }
        }
        return new cnk(cow.O000000o(context, true), O000000o2, cnp);
    }
}

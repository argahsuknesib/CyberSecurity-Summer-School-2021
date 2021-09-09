package com.google.android.gms.tasks;

import java.util.ArrayDeque;
import java.util.Queue;

final class zzr<TResult> {
    private final Object mLock = new Object();
    private Queue<zzq<TResult>> zzaga;
    private boolean zzagb;

    zzr() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0010, code lost:
        r1 = r2.mLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0 = r2.zzaga.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        if (r0 != null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001d, code lost:
        r2.zzagb = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0022, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0023, code lost:
        r0.onComplete(r3);
     */
    public final void zza(Task task) {
        synchronized (this.mLock) {
            if (this.zzaga != null) {
                if (!this.zzagb) {
                    this.zzagb = true;
                }
            }
        }
    }

    public final void zza(zzq zzq) {
        synchronized (this.mLock) {
            if (this.zzaga == null) {
                this.zzaga = new ArrayDeque();
            }
            this.zzaga.add(zzq);
        }
    }
}

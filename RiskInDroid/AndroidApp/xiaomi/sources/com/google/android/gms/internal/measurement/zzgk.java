package com.google.android.gms.internal.measurement;

import android.os.Process;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;

final class zzgk extends Thread {
    private final /* synthetic */ zzgg zzalz;
    private final Object zzamc = new Object();
    private final BlockingQueue<zzgj<?>> zzamd;

    public zzgk(zzgg zzgg, String str, BlockingQueue<zzgj<?>> blockingQueue) {
        this.zzalz = zzgg;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zzamd = blockingQueue;
        setName(str);
    }

    private final void zza(InterruptedException interruptedException) {
        this.zzalz.zzge().zzip().zzg(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0065, code lost:
        r1 = r6.zzalz.zzalu;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006b, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r6.zzalz.zzalv.release();
        r6.zzalz.zzalu.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0084, code lost:
        if (r6 != r6.zzalz.zzalo) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0086, code lost:
        com.google.android.gms.internal.measurement.zzgk unused = r6.zzalz.zzalo = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0092, code lost:
        if (r6 != r6.zzalz.zzalp) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0094, code lost:
        com.google.android.gms.internal.measurement.zzgk unused = r6.zzalz.zzalp = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x009a, code lost:
        r6.zzalz.zzge().zzim().log("Current scheduler thread is neither worker nor network");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a9, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00aa, code lost:
        return;
     */
    public final void run() {
        boolean z = false;
        while (!z) {
            try {
                this.zzalz.zzalv.acquire();
                z = true;
            } catch (InterruptedException e) {
                zza(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                zzgj poll = this.zzamd.poll();
                if (poll != null) {
                    Process.setThreadPriority(poll.zzamb ? threadPriority : 10);
                    poll.run();
                } else {
                    synchronized (this.zzamc) {
                        if (this.zzamd.peek() == null && !this.zzalz.zzalw) {
                            try {
                                this.zzamc.wait(DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
                            } catch (InterruptedException e2) {
                                zza(e2);
                            }
                        }
                    }
                    synchronized (this.zzalz.zzalu) {
                        if (this.zzamd.peek() == null) {
                        }
                    }
                }
            }
        } catch (Throwable th) {
            synchronized (this.zzalz.zzalu) {
                this.zzalz.zzalv.release();
                this.zzalz.zzalu.notifyAll();
                if (this == this.zzalz.zzalo) {
                    zzgk unused = this.zzalz.zzalo = null;
                } else if (this == this.zzalz.zzalp) {
                    zzgk unused2 = this.zzalz.zzalp = null;
                } else {
                    this.zzalz.zzge().zzim().log("Current scheduler thread is neither worker nor network");
                }
                throw th;
            }
        }
    }

    public final void zzjn() {
        synchronized (this.zzamc) {
            this.zzamc.notifyAll();
        }
    }
}

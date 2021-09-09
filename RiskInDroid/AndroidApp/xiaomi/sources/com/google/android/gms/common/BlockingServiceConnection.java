package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BlockingServiceConnection implements ServiceConnection {
    private boolean zzaj = false;
    private final BlockingQueue<IBinder> zzak = new LinkedBlockingQueue();

    public IBinder getService() throws InterruptedException {
        Preconditions.checkNotMainThread("BlockingServiceConnection.getService() called on main thread");
        if (!this.zzaj) {
            this.zzaj = true;
            return this.zzak.take();
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    public IBinder getServiceWithTimeout(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        Preconditions.checkNotMainThread("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (!this.zzaj) {
            this.zzaj = true;
            IBinder poll = this.zzak.poll(j, timeUnit);
            if (poll != null) {
                return poll;
            }
            throw new TimeoutException("Timed out waiting for the service connection");
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.zzak.add(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}

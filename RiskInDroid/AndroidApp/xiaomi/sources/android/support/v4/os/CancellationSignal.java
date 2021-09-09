package android.support.v4.os;

import android.os.Build;

public final class CancellationSignal {
    private boolean mCancelInProgress;
    private Object mCancellationSignalObj;
    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;

    public interface OnCancelListener {
        void onCancel();
    }

    public final boolean isCanceled() {
        boolean z;
        synchronized (this) {
            z = this.mIsCanceled;
        }
        return z;
    }

    public final void throwIfCanceled() {
        if (isCanceled()) {
            throw new OperationCanceledException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0.onCancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
        if (r1 == null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
        android.support.v4.os.CancellationSignalCompatJellybean.cancel(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3.mCancelInProgress = false;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0027, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x002b, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r3.mCancelInProgress = false;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0031, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0032, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0 == null) goto L_0x001a;
     */
    public final void cancel() {
        synchronized (this) {
            if (!this.mIsCanceled) {
                this.mIsCanceled = true;
                this.mCancelInProgress = true;
                OnCancelListener onCancelListener = this.mOnCancelListener;
                Object obj = this.mCancellationSignalObj;
            }
        }
    }

    public final void setOnCancelListener(OnCancelListener onCancelListener) {
        synchronized (this) {
            waitForCancelFinishedLocked();
            if (this.mOnCancelListener != onCancelListener) {
                this.mOnCancelListener = onCancelListener;
                if (this.mIsCanceled) {
                    if (onCancelListener != null) {
                        onCancelListener.onCancel();
                    }
                }
            }
        }
    }

    public final Object getCancellationSignalObject() {
        Object obj;
        if (Build.VERSION.SDK_INT < 16) {
            return null;
        }
        synchronized (this) {
            if (this.mCancellationSignalObj == null) {
                this.mCancellationSignalObj = CancellationSignalCompatJellybean.create();
                if (this.mIsCanceled) {
                    CancellationSignalCompatJellybean.cancel(this.mCancellationSignalObj);
                }
            }
            obj = this.mCancellationSignalObj;
        }
        return obj;
    }

    private void waitForCancelFinishedLocked() {
        while (this.mCancelInProgress) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }
}

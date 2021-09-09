package com.miui.tsmclientsdk.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.miui.tsmclientsdk.MiTsmFuture;
import com.miui.tsmclientsdk.OnProgressUpdateListener;
import com.miui.tsmclientsdk.OperationCanceledException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

public abstract class AbstractServiceTask<T extends IInterface, R> extends FutureTask<Bundle> implements ServiceConnection, MiTsmFuture<Bundle> {
    private static final AtomicLong sTaskId = new AtomicLong();
    protected final String TAG;
    public Context mContext;
    protected String mId;
    private boolean mIsBound;
    public boolean mIsLaunchActivity;
    private CountDownLatch mLatch;
    public OnProgressUpdateListener mProgressListener;
    protected R mResponse;
    protected T mService;
    private List<? super AbstractServiceTask> mTaskList;

    /* access modifiers changed from: protected */
    public abstract T asInterface(IBinder iBinder);

    /* access modifiers changed from: protected */
    public abstract void doWork() throws RemoteException;

    /* access modifiers changed from: protected */
    public abstract R getResponse();

    /* access modifiers changed from: protected */
    public abstract Intent getServiceIntent();

    protected AbstractServiceTask(Context context) {
        this(context, false);
    }

    protected AbstractServiceTask(Context context, boolean z) {
        this(context, z, null);
    }

    protected AbstractServiceTask(Context context, boolean z, OnProgressUpdateListener onProgressUpdateListener) {
        this(context, null, z, onProgressUpdateListener, null);
    }

    protected AbstractServiceTask(Context context, String str, boolean z, OnProgressUpdateListener onProgressUpdateListener, List<? super AbstractServiceTask> list) {
        super(new Callable<Bundle>() {
            /* class com.miui.tsmclientsdk.internal.AbstractServiceTask.AnonymousClass1 */

            public Bundle call() throws Exception {
                throw new IllegalStateException("this should never be called");
            }
        });
        this.TAG = getClass().getSimpleName();
        this.mIsBound = false;
        this.mIsLaunchActivity = false;
        this.mLatch = new CountDownLatch(1);
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append(str == null ? "" : "-".concat(String.valueOf(str)));
        sb.append("-");
        sb.append(sTaskId.getAndIncrement());
        sb.append("-");
        sb.append(System.currentTimeMillis());
        this.mId = sb.toString();
        this.mContext = context;
        this.mResponse = getResponse();
        this.mIsLaunchActivity = z;
        this.mProgressListener = onProgressUpdateListener;
        this.mTaskList = list;
    }

    public final MiTsmFuture<Bundle> start() {
        String str = this.TAG;
        Log.v(str, "serviceTask:" + this.mId + " start");
        List<? super AbstractServiceTask> list = this.mTaskList;
        if (list != null) {
            list.add(this);
        }
        try {
            bind();
            this.mLatch.await();
            doWork();
        } catch (InterruptedException e) {
            String str2 = this.TAG;
            Log.e(str2, "serviceTask:" + this.mId + " start is interrupted", e);
            Bundle bundle = new Bundle();
            bundle.putInt("key_result_code", 3);
            bundle.putString("key_result_msg", "start serviceTask is interrupted");
            set(bundle);
        } catch (Exception e2) {
            Log.e(this.TAG, "start serviceTask error occurred", e2);
            setException(e2);
        }
        return this;
    }

    public boolean cancel(boolean z) {
        String str = this.TAG;
        Log.v(str, "serviceTask:" + this.mId + " is canceling");
        T t = this.mService;
        if (t != null && !TextUtils.isEmpty(this.mId)) {
            try {
                Method method = t.getClass().getMethod("cancelTask", String.class);
                method.setAccessible(true);
                method.invoke(t, this.mId);
            } catch (NoSuchMethodException unused) {
                Log.d(this.TAG, "cancel task failed, task no cancel method.");
            } catch (Exception e) {
                Log.e(this.TAG, "cancel task failed", e);
            }
        }
        List<? super AbstractServiceTask> list = this.mTaskList;
        if (list != null) {
            list.remove(this);
        }
        return super.cancel(true);
    }

    public Bundle getResult() throws OperationCanceledException, IOException, ExecutionException {
        return internalGetResult(null, null);
    }

    public Bundle getResult(long j, TimeUnit timeUnit) throws OperationCanceledException, IOException, ExecutionException {
        return internalGetResult(Long.valueOf(j), timeUnit);
    }

    /* access modifiers changed from: protected */
    public void set(Bundle bundle) {
        super.set((Object) bundle);
        unbind();
    }

    /* access modifiers changed from: protected */
    public void setException(Throwable th) {
        super.setException(th);
        unbind();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str = this.TAG;
        Log.v(str, "serviceTask:" + this.mId + " onServiceConnected, component:" + componentName);
        this.mService = asInterface(iBinder);
        this.mLatch.countDown();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        String str = this.TAG;
        Log.v(str, "serviceTask:" + this.mId + " onServiceDisconnected");
        if (!isDone()) {
            Log.v(this.TAG, "task is not completed");
        }
        this.mService = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0045, code lost:
        if (r3 == null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004b, code lost:
        if (r3 == null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0051, code lost:
        if (r3 == null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0053, code lost:
        r3.remove(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x005b, code lost:
        throw new com.miui.tsmclientsdk.OperationCanceledException();
     */
    private Bundle internalGetResult(Long l, TimeUnit timeUnit) throws OperationCanceledException, IOException, ExecutionException {
        List<? super AbstractServiceTask> list;
        if (!isDone()) {
            ensureNotOnMainThread();
        }
        if (timeUnit == null) {
            try {
                Bundle bundle = (Bundle) get();
                List<? super AbstractServiceTask> list2 = this.mTaskList;
                if (list2 != null) {
                    list2.remove(this);
                }
                return bundle;
            } catch (InterruptedException unused) {
                list = this.mTaskList;
            } catch (TimeoutException unused2) {
                list = this.mTaskList;
            } catch (CancellationException unused3) {
                list = this.mTaskList;
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause instanceof IOException) {
                    throw ((IOException) cause);
                }
                throw e;
            } catch (Throwable th) {
                List<? super AbstractServiceTask> list3 = this.mTaskList;
                if (list3 != null) {
                    list3.remove(this);
                }
                throw th;
            }
        } else {
            Bundle bundle2 = (Bundle) get(l.longValue(), timeUnit);
            List<? super AbstractServiceTask> list4 = this.mTaskList;
            if (list4 != null) {
                list4.remove(this);
            }
            return bundle2;
        }
    }

    private void bind() {
        if (this.mIsBound) {
            return;
        }
        if (bindService()) {
            this.mIsBound = true;
            String str = this.TAG;
            Log.d(str, "serviceTask:" + this.mId + " bind service success");
            return;
        }
        String str2 = this.TAG;
        Log.e(str2, "serviceTask:" + this.mId + " bind service failed");
        throw new IllegalStateException("no service is bond");
    }

    private boolean bindService() {
        return this.mContext.bindService(getServiceIntent(), this, 1);
    }

    private synchronized void unbind() {
        if (this.mIsBound) {
            String str = this.TAG;
            Log.d(str, "serviceTask:" + this.mId + " unbind service with synchronized");
            this.mIsBound = false;
            this.mContext.unbindService(this);
        }
    }

    private void ensureNotOnMainThread() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null && myLooper == this.mContext.getMainLooper()) {
            IllegalStateException illegalStateException = new IllegalStateException("calling this from your main thread can lead to deadlock");
            Log.e(this.TAG, illegalStateException.getMessage(), illegalStateException);
            throw illegalStateException;
        }
    }

    public class SimpleResponse {
        private final String mTaskId;

        public SimpleResponse(AbstractServiceTask abstractServiceTask) {
            this(null);
        }

        public SimpleResponse(String str) {
            this.mTaskId = str;
        }

        public void onResult(Bundle bundle) throws RemoteException {
            bundle.setClassLoader(AbstractServiceTask.class.getClassLoader());
            bundle.putInt("key_result_code", 0);
            Intent intent = (Intent) bundle.getParcelable("key_intent");
            if (intent == null || !AbstractServiceTask.this.mIsLaunchActivity) {
                AbstractServiceTask.this.set(bundle);
                return;
            }
            if (!(AbstractServiceTask.this.mContext instanceof Activity)) {
                intent.addFlags(268435456);
            }
            AbstractServiceTask.this.mContext.startActivity(intent);
        }

        public void onError(int i, String str) throws RemoteException {
            String str2 = AbstractServiceTask.this.TAG;
            Log.w(str2, "on Error: code=" + i + " msg=" + str);
            Bundle bundle = new Bundle();
            bundle.putInt("key_result_code", i);
            bundle.putString("key_result_msg", str);
            AbstractServiceTask.this.set(bundle);
        }

        public void onProgress(int i) throws RemoteException {
            Log.v(AbstractServiceTask.this.TAG, "on progress: ".concat(String.valueOf(i)));
            if (AbstractServiceTask.this.mProgressListener != null) {
                AbstractServiceTask.this.mProgressListener.onProgress(i);
            }
        }

        public String getId() throws RemoteException {
            return this.mTaskId;
        }
    }
}

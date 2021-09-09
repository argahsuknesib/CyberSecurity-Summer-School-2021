package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl extends LoaderManager {
    static boolean DEBUG = false;
    boolean mCreatingLoader;
    FragmentHostCallback mHost;
    final SparseArrayCompat<LoaderInfo> mInactiveLoaders = new SparseArrayCompat<>();
    final SparseArrayCompat<LoaderInfo> mLoaders = new SparseArrayCompat<>();
    boolean mRetaining;
    boolean mRetainingStarted;
    boolean mStarted;
    final String mWho;

    final class LoaderInfo implements Loader.OnLoadCanceledListener<Object>, Loader.OnLoadCompleteListener<Object> {
        final Bundle mArgs;
        LoaderManager.LoaderCallbacks<Object> mCallbacks;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        boolean mHaveData;
        final int mId;
        boolean mListenerRegistered;
        Loader<Object> mLoader;
        LoaderInfo mPendingLoader;
        boolean mReportNextStart;
        boolean mRetaining;
        boolean mRetainingStarted;
        boolean mStarted;

        public LoaderInfo(int i, Bundle bundle, LoaderManager.LoaderCallbacks<Object> loaderCallbacks) {
            this.mId = i;
            this.mArgs = bundle;
            this.mCallbacks = loaderCallbacks;
        }

        /* access modifiers changed from: package-private */
        public final void start() {
            LoaderManager.LoaderCallbacks<Object> loaderCallbacks;
            if (this.mRetaining && this.mRetainingStarted) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  Starting: ".concat(String.valueOf(this)));
                }
                if (this.mLoader == null && (loaderCallbacks = this.mCallbacks) != null) {
                    this.mLoader = loaderCallbacks.onCreateLoader(this.mId, this.mArgs);
                }
                Loader<Object> loader = this.mLoader;
                if (loader == null) {
                    return;
                }
                if (!loader.getClass().isMemberClass() || Modifier.isStatic(this.mLoader.getClass().getModifiers())) {
                    if (!this.mListenerRegistered) {
                        this.mLoader.registerListener(this.mId, this);
                        this.mLoader.registerOnLoadCanceledListener(this);
                        this.mListenerRegistered = true;
                    }
                    this.mLoader.startLoading();
                    return;
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.mLoader);
            }
        }

        /* access modifiers changed from: package-private */
        public final void retain() {
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Retaining: ".concat(String.valueOf(this)));
            }
            this.mRetaining = true;
            this.mRetainingStarted = this.mStarted;
            this.mStarted = false;
            this.mCallbacks = null;
        }

        /* access modifiers changed from: package-private */
        public final void finishRetain() {
            if (this.mRetaining) {
                if (LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  Finished Retaining: ".concat(String.valueOf(this)));
                }
                this.mRetaining = false;
                boolean z = this.mStarted;
                if (z != this.mRetainingStarted && !z) {
                    stop();
                }
            }
            if (this.mStarted && this.mHaveData && !this.mReportNextStart) {
                callOnLoadFinished(this.mLoader, this.mData);
            }
        }

        /* access modifiers changed from: package-private */
        public final void reportStart() {
            if (this.mStarted && this.mReportNextStart) {
                this.mReportNextStart = false;
                if (this.mHaveData && !this.mRetaining) {
                    callOnLoadFinished(this.mLoader, this.mData);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void stop() {
            Loader<Object> loader;
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Stopping: ".concat(String.valueOf(this)));
            }
            this.mStarted = false;
            if (!this.mRetaining && (loader = this.mLoader) != null && this.mListenerRegistered) {
                this.mListenerRegistered = false;
                loader.unregisterListener(this);
                this.mLoader.unregisterOnLoadCanceledListener(this);
                this.mLoader.stopLoading();
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean cancel() {
            Loader<Object> loader;
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Canceling: ".concat(String.valueOf(this)));
            }
            if (!this.mStarted || (loader = this.mLoader) == null || !this.mListenerRegistered) {
                return false;
            }
            boolean cancelLoad = loader.cancelLoad();
            if (!cancelLoad) {
                onLoadCanceled(this.mLoader);
            }
            return cancelLoad;
        }

        /* access modifiers changed from: package-private */
        public final void destroy() {
            String str;
            LoaderInfo loaderInfo = this;
            do {
                if (LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  Destroying: ".concat(String.valueOf(loaderInfo)));
                }
                loaderInfo.mDestroyed = true;
                boolean z = loaderInfo.mDeliveredData;
                loaderInfo.mDeliveredData = false;
                if (loaderInfo.mCallbacks != null && loaderInfo.mLoader != null && loaderInfo.mHaveData && z) {
                    if (LoaderManagerImpl.DEBUG) {
                        Log.v("LoaderManager", "  Resetting: ".concat(String.valueOf(loaderInfo)));
                    }
                    if (LoaderManagerImpl.this.mHost != null) {
                        str = LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause;
                        LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = "onLoaderReset";
                    } else {
                        str = null;
                    }
                    try {
                        loaderInfo.mCallbacks.onLoaderReset(loaderInfo.mLoader);
                    } finally {
                        if (LoaderManagerImpl.this.mHost != null) {
                            LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = str;
                        }
                    }
                }
                loaderInfo.mCallbacks = null;
                loaderInfo.mData = null;
                loaderInfo.mHaveData = false;
                Loader<Object> loader = loaderInfo.mLoader;
                if (loader != null) {
                    if (loaderInfo.mListenerRegistered) {
                        loaderInfo.mListenerRegistered = false;
                        loader.unregisterListener(loaderInfo);
                        loaderInfo.mLoader.unregisterOnLoadCanceledListener(loaderInfo);
                    }
                    loaderInfo.mLoader.reset();
                }
                loaderInfo = loaderInfo.mPendingLoader;
            } while (loaderInfo != null);
        }

        public final void onLoadCanceled(Loader<Object> loader) {
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "onLoadCanceled: ".concat(String.valueOf(this)));
            }
            if (this.mDestroyed) {
                if (LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  Ignoring load canceled -- destroyed");
                }
            } else if (LoaderManagerImpl.this.mLoaders.get(this.mId) == this) {
                LoaderInfo loaderInfo = this.mPendingLoader;
                if (loaderInfo != null) {
                    if (LoaderManagerImpl.DEBUG) {
                        Log.v("LoaderManager", "  Switching to pending loader: ".concat(String.valueOf(loaderInfo)));
                    }
                    this.mPendingLoader = null;
                    LoaderManagerImpl.this.mLoaders.put(this.mId, null);
                    destroy();
                    LoaderManagerImpl.this.installLoader(loaderInfo);
                }
            } else if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Ignoring load canceled -- not active");
            }
        }

        public final void onLoadComplete(Loader<Object> loader, Object obj) {
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "onLoadComplete: ".concat(String.valueOf(this)));
            }
            if (this.mDestroyed) {
                if (LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
                }
            } else if (LoaderManagerImpl.this.mLoaders.get(this.mId) == this) {
                LoaderInfo loaderInfo = this.mPendingLoader;
                if (loaderInfo != null) {
                    if (LoaderManagerImpl.DEBUG) {
                        Log.v("LoaderManager", "  Switching to pending loader: ".concat(String.valueOf(loaderInfo)));
                    }
                    this.mPendingLoader = null;
                    LoaderManagerImpl.this.mLoaders.put(this.mId, null);
                    destroy();
                    LoaderManagerImpl.this.installLoader(loaderInfo);
                    return;
                }
                if (this.mData != obj || !this.mHaveData) {
                    this.mData = obj;
                    this.mHaveData = true;
                    if (this.mStarted) {
                        callOnLoadFinished(loader, obj);
                    }
                }
                LoaderInfo loaderInfo2 = LoaderManagerImpl.this.mInactiveLoaders.get(this.mId);
                if (!(loaderInfo2 == null || loaderInfo2 == this)) {
                    loaderInfo2.mDeliveredData = false;
                    loaderInfo2.destroy();
                    LoaderManagerImpl.this.mInactiveLoaders.remove(this.mId);
                }
                if (LoaderManagerImpl.this.mHost != null && !LoaderManagerImpl.this.hasRunningLoaders()) {
                    LoaderManagerImpl.this.mHost.mFragmentManager.startPendingDeferredFragments();
                }
            } else if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Ignoring load complete -- not active");
            }
        }

        /* access modifiers changed from: package-private */
        public final void callOnLoadFinished(Loader<Object> loader, Object obj) {
            if (this.mCallbacks != null) {
                String str = null;
                if (LoaderManagerImpl.this.mHost != null) {
                    str = LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause;
                    LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = "onLoadFinished";
                }
                try {
                    if (LoaderManagerImpl.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + loader + ": " + loader.dataToString(obj));
                    }
                    this.mCallbacks.onLoadFinished(loader, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (LoaderManagerImpl.this.mHost != null) {
                        LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = str;
                    }
                }
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.mId);
            sb.append(" : ");
            DebugUtils.buildShortClassTag(this.mLoader, sb);
            sb.append("}}");
            return sb.toString();
        }

        public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            LoaderInfo loaderInfo = this;
            while (true) {
                printWriter.print(str);
                printWriter.print("mId=");
                printWriter.print(loaderInfo.mId);
                printWriter.print(" mArgs=");
                printWriter.println(loaderInfo.mArgs);
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(loaderInfo.mCallbacks);
                printWriter.print(str);
                printWriter.print("mLoader=");
                printWriter.println(loaderInfo.mLoader);
                Loader<Object> loader = loaderInfo.mLoader;
                if (loader != null) {
                    loader.dump(str + "  ", fileDescriptor, printWriter, strArr);
                }
                if (loaderInfo.mHaveData || loaderInfo.mDeliveredData) {
                    printWriter.print(str);
                    printWriter.print("mHaveData=");
                    printWriter.print(loaderInfo.mHaveData);
                    printWriter.print("  mDeliveredData=");
                    printWriter.println(loaderInfo.mDeliveredData);
                    printWriter.print(str);
                    printWriter.print("mData=");
                    printWriter.println(loaderInfo.mData);
                }
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(loaderInfo.mStarted);
                printWriter.print(" mReportNextStart=");
                printWriter.print(loaderInfo.mReportNextStart);
                printWriter.print(" mDestroyed=");
                printWriter.println(loaderInfo.mDestroyed);
                printWriter.print(str);
                printWriter.print("mRetaining=");
                printWriter.print(loaderInfo.mRetaining);
                printWriter.print(" mRetainingStarted=");
                printWriter.print(loaderInfo.mRetainingStarted);
                printWriter.print(" mListenerRegistered=");
                printWriter.println(loaderInfo.mListenerRegistered);
                if (loaderInfo.mPendingLoader != null) {
                    printWriter.print(str);
                    printWriter.println("Pending Loader ");
                    printWriter.print(loaderInfo.mPendingLoader);
                    printWriter.println(":");
                    loaderInfo = loaderInfo.mPendingLoader;
                    str = str + "  ";
                } else {
                    return;
                }
            }
        }
    }

    LoaderManagerImpl(String str, FragmentHostCallback fragmentHostCallback, boolean z) {
        this.mWho = str;
        this.mHost = fragmentHostCallback;
        this.mStarted = z;
    }

    /* access modifiers changed from: package-private */
    public void updateHostController(FragmentHostCallback fragmentHostCallback) {
        this.mHost = fragmentHostCallback;
    }

    private LoaderInfo createLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks<Object> loaderCallbacks) {
        LoaderInfo loaderInfo = new LoaderInfo(i, bundle, loaderCallbacks);
        loaderInfo.mLoader = loaderCallbacks.onCreateLoader(i, bundle);
        return loaderInfo;
    }

    /* JADX INFO: finally extract failed */
    private LoaderInfo createAndInstallLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks<Object> loaderCallbacks) {
        try {
            this.mCreatingLoader = true;
            LoaderInfo createLoader = createLoader(i, bundle, loaderCallbacks);
            installLoader(createLoader);
            this.mCreatingLoader = false;
            return createLoader;
        } catch (Throwable th) {
            this.mCreatingLoader = false;
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void installLoader(LoaderInfo loaderInfo) {
        this.mLoaders.put(loaderInfo.mId, loaderInfo);
        if (this.mStarted) {
            loaderInfo.start();
        }
    }

    public <D> Loader<D> initLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (!this.mCreatingLoader) {
            LoaderInfo loaderInfo = this.mLoaders.get(i);
            if (DEBUG) {
                Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
            }
            if (loaderInfo == null) {
                loaderInfo = createAndInstallLoader(i, bundle, loaderCallbacks);
                if (DEBUG) {
                    Log.v("LoaderManager", "  Created new loader ".concat(String.valueOf(loaderInfo)));
                }
            } else {
                if (DEBUG) {
                    Log.v("LoaderManager", "  Re-using existing loader ".concat(String.valueOf(loaderInfo)));
                }
                loaderInfo.mCallbacks = loaderCallbacks;
            }
            if (loaderInfo.mHaveData && this.mStarted) {
                loaderInfo.callOnLoadFinished(loaderInfo.mLoader, loaderInfo.mData);
            }
            return loaderInfo.mLoader;
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    public <D> Loader<D> restartLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (!this.mCreatingLoader) {
            LoaderInfo loaderInfo = this.mLoaders.get(i);
            if (DEBUG) {
                Log.v("LoaderManager", "restartLoader in " + this + ": args=" + bundle);
            }
            if (loaderInfo != null) {
                LoaderInfo loaderInfo2 = this.mInactiveLoaders.get(i);
                if (loaderInfo2 != null) {
                    if (loaderInfo.mHaveData) {
                        if (DEBUG) {
                            Log.v("LoaderManager", "  Removing last inactive loader: ".concat(String.valueOf(loaderInfo)));
                        }
                        loaderInfo2.mDeliveredData = false;
                        loaderInfo2.destroy();
                    } else if (!loaderInfo.cancel()) {
                        if (DEBUG) {
                            Log.v("LoaderManager", "  Current loader is stopped; replacing");
                        }
                        this.mLoaders.put(i, null);
                        loaderInfo.destroy();
                    } else {
                        if (DEBUG) {
                            Log.v("LoaderManager", "  Current loader is running; configuring pending loader");
                        }
                        if (loaderInfo.mPendingLoader != null) {
                            if (DEBUG) {
                                Log.v("LoaderManager", "  Removing pending loader: " + loaderInfo.mPendingLoader);
                            }
                            loaderInfo.mPendingLoader.destroy();
                            loaderInfo.mPendingLoader = null;
                        }
                        if (DEBUG) {
                            Log.v("LoaderManager", "  Enqueuing as new pending loader");
                        }
                        loaderInfo.mPendingLoader = createLoader(i, bundle, loaderCallbacks);
                        return loaderInfo.mPendingLoader.mLoader;
                    }
                } else if (DEBUG) {
                    Log.v("LoaderManager", "  Making last loader inactive: ".concat(String.valueOf(loaderInfo)));
                }
                loaderInfo.mLoader.abandon();
                this.mInactiveLoaders.put(i, loaderInfo);
            }
            return createAndInstallLoader(i, bundle, loaderCallbacks).mLoader;
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    public void destroyLoader(int i) {
        if (!this.mCreatingLoader) {
            if (DEBUG) {
                Log.v("LoaderManager", "destroyLoader in " + this + " of " + i);
            }
            int indexOfKey = this.mLoaders.indexOfKey(i);
            if (indexOfKey >= 0) {
                this.mLoaders.removeAt(indexOfKey);
                this.mLoaders.valueAt(indexOfKey).destroy();
            }
            int indexOfKey2 = this.mInactiveLoaders.indexOfKey(i);
            if (indexOfKey2 >= 0) {
                this.mInactiveLoaders.removeAt(indexOfKey2);
                this.mInactiveLoaders.valueAt(indexOfKey2).destroy();
            }
            if (this.mHost != null && !hasRunningLoaders()) {
                this.mHost.mFragmentManager.startPendingDeferredFragments();
                return;
            }
            return;
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    public <D> Loader<D> getLoader(int i) {
        if (!this.mCreatingLoader) {
            LoaderInfo loaderInfo = this.mLoaders.get(i);
            if (loaderInfo == null) {
                return null;
            }
            if (loaderInfo.mPendingLoader != null) {
                return loaderInfo.mPendingLoader.mLoader;
            }
            return loaderInfo.mLoader;
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    /* access modifiers changed from: package-private */
    public void doStart() {
        if (DEBUG) {
            Log.v("LoaderManager", "Starting in ".concat(String.valueOf(this)));
        }
        if (this.mStarted) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: ".concat(String.valueOf(this)), runtimeException);
            return;
        }
        this.mStarted = true;
        for (int size = this.mLoaders.size() - 1; size >= 0; size--) {
            this.mLoaders.valueAt(size).start();
        }
    }

    /* access modifiers changed from: package-private */
    public void doStop() {
        if (DEBUG) {
            Log.v("LoaderManager", "Stopping in ".concat(String.valueOf(this)));
        }
        if (!this.mStarted) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStop when not started: ".concat(String.valueOf(this)), runtimeException);
            return;
        }
        for (int size = this.mLoaders.size() - 1; size >= 0; size--) {
            this.mLoaders.valueAt(size).stop();
        }
        this.mStarted = false;
    }

    /* access modifiers changed from: package-private */
    public void doRetain() {
        if (DEBUG) {
            Log.v("LoaderManager", "Retaining in ".concat(String.valueOf(this)));
        }
        if (!this.mStarted) {
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doRetain when not started: ".concat(String.valueOf(this)), runtimeException);
            return;
        }
        this.mRetaining = true;
        this.mStarted = false;
        for (int size = this.mLoaders.size() - 1; size >= 0; size--) {
            this.mLoaders.valueAt(size).retain();
        }
    }

    /* access modifiers changed from: package-private */
    public void finishRetain() {
        if (this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in ".concat(String.valueOf(this)));
            }
            this.mRetaining = false;
            for (int size = this.mLoaders.size() - 1; size >= 0; size--) {
                this.mLoaders.valueAt(size).finishRetain();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void doReportNextStart() {
        for (int size = this.mLoaders.size() - 1; size >= 0; size--) {
            this.mLoaders.valueAt(size).mReportNextStart = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void doReportStart() {
        for (int size = this.mLoaders.size() - 1; size >= 0; size--) {
            this.mLoaders.valueAt(size).reportStart();
        }
    }

    /* access modifiers changed from: package-private */
    public void doDestroy() {
        if (!this.mRetaining) {
            if (DEBUG) {
                Log.v("LoaderManager", "Destroying Active in ".concat(String.valueOf(this)));
            }
            for (int size = this.mLoaders.size() - 1; size >= 0; size--) {
                this.mLoaders.valueAt(size).destroy();
            }
            this.mLoaders.clear();
        }
        if (DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in ".concat(String.valueOf(this)));
        }
        for (int size2 = this.mInactiveLoaders.size() - 1; size2 >= 0; size2--) {
            this.mInactiveLoaders.valueAt(size2).destroy();
        }
        this.mInactiveLoaders.clear();
        this.mHost = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) NotificationCompat.FLAG_HIGH_PRIORITY);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(this.mHost, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (this.mLoaders.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < this.mLoaders.size(); i++) {
                LoaderInfo valueAt = this.mLoaders.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.mLoaders.keyAt(i));
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                valueAt.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.mInactiveLoaders.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            for (int i2 = 0; i2 < this.mInactiveLoaders.size(); i2++) {
                LoaderInfo valueAt2 = this.mInactiveLoaders.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.mInactiveLoaders.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(valueAt2.toString());
                valueAt2.dump(str3, fileDescriptor, printWriter, strArr);
            }
        }
    }

    public boolean hasRunningLoaders() {
        int size = this.mLoaders.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            LoaderInfo valueAt = this.mLoaders.valueAt(i);
            z |= valueAt.mStarted && !valueAt.mDeliveredData;
        }
        return z;
    }
}

package com.facebook.common.references;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.PropagatesNullable;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class CloseableReference<T> implements Closeable, Cloneable {
    private static final ResourceReleaser<Closeable> DEFAULT_CLOSEABLE_RELEASER = new ResourceReleaser<Closeable>() {
        /* class com.facebook.common.references.CloseableReference.AnonymousClass1 */

        public final void release(Closeable closeable) {
            try {
                Closeables.close(closeable, true);
            } catch (IOException unused) {
            }
        }
    };
    private static Class<CloseableReference> TAG = CloseableReference.class;
    private boolean mIsClosed = false;
    private final SharedReference<T> mSharedReference;

    private CloseableReference(SharedReference<T> sharedReference) {
        this.mSharedReference = (SharedReference) Preconditions.checkNotNull(sharedReference);
        sharedReference.addReference();
    }

    private CloseableReference(T t, ResourceReleaser<T> resourceReleaser) {
        this.mSharedReference = new SharedReference<>(t, resourceReleaser);
    }

    public static <T extends Closeable> CloseableReference<T> of(@PropagatesNullable T t) {
        if (t == null) {
            return null;
        }
        return new CloseableReference<>(t, DEFAULT_CLOSEABLE_RELEASER);
    }

    public static <T> CloseableReference<T> of(@PropagatesNullable T t, ResourceReleaser<T> resourceReleaser) {
        if (t == null) {
            return null;
        }
        return new CloseableReference<>(t, resourceReleaser);
    }

    public final synchronized T get() {
        Preconditions.checkState(!this.mIsClosed);
        return this.mSharedReference.get();
    }

    public final synchronized CloseableReference<T> clone() {
        Preconditions.checkState(isValid());
        return new CloseableReference<>(this.mSharedReference);
    }

    public final synchronized CloseableReference<T> cloneOrNull() {
        if (!isValid()) {
            return null;
        }
        return clone();
    }

    public final synchronized boolean isValid() {
        return !this.mIsClosed;
    }

    @VisibleForTesting
    public final synchronized SharedReference<T> getUnderlyingReferenceTestOnly() {
        return this.mSharedReference;
    }

    public final int getValueHash() {
        if (isValid()) {
            return System.identityHashCode(this.mSharedReference.get());
        }
        return 0;
    }

    public final void close() {
        synchronized (this) {
            if (!this.mIsClosed) {
                this.mIsClosed = true;
                this.mSharedReference.deleteReference();
            }
        }
    }

    public static boolean isValid(CloseableReference<?> closeableReference) {
        return closeableReference != null && closeableReference.isValid();
    }

    public static <T> CloseableReference<T> cloneOrNull(CloseableReference<T> closeableReference) {
        if (closeableReference != null) {
            return closeableReference.cloneOrNull();
        }
        return null;
    }

    public static <T> List<CloseableReference<T>> cloneOrNull(@PropagatesNullable Collection<CloseableReference<T>> collection) {
        if (collection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (CloseableReference<T> cloneOrNull : collection) {
            arrayList.add(cloneOrNull(cloneOrNull));
        }
        return arrayList;
    }

    public static void closeSafely(CloseableReference<?> closeableReference) {
        if (closeableReference != null) {
            closeableReference.close();
        }
    }

    public static void closeSafely(Iterable<? extends CloseableReference<?>> iterable) {
        if (iterable != null) {
            for (CloseableReference closeSafely : iterable) {
                closeSafely(closeSafely);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (this.mIsClosed) {
                    super.finalize();
                    return;
                }
                FLog.w(TAG, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.mSharedReference)), this.mSharedReference.get().getClass().getName());
                close();
                super.finalize();
            }
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }
}

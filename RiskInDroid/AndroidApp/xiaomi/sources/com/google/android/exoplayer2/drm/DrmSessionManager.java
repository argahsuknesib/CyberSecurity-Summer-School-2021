package com.google.android.exoplayer2.drm;

import android.os.Looper;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;

public interface DrmSessionManager {
    public static final DrmSessionManager DUMMY = new DrmSessionManager() {
        /* class com.google.android.exoplayer2.drm.DrmSessionManager.AnonymousClass1 */

        public /* synthetic */ DrmSession acquirePlaceholderSession(Looper looper, int i) {
            return CC.$default$acquirePlaceholderSession(this, looper, i);
        }

        public final boolean canAcquireSession(DrmInitData drmInitData) {
            return false;
        }

        public final Class<ExoMediaCrypto> getExoMediaCryptoType(DrmInitData drmInitData) {
            return null;
        }

        public /* synthetic */ void prepare() {
            CC.$default$prepare(this);
        }

        public /* synthetic */ void release() {
            CC.$default$release(this);
        }

        public final DrmSession acquireSession(Looper looper, MediaSourceEventDispatcher mediaSourceEventDispatcher, DrmInitData drmInitData) {
            return new ErrorStateDrmSession(new DrmSession.DrmSessionException(new UnsupportedDrmException(1)));
        }
    };

    DrmSession acquirePlaceholderSession(Looper looper, int i);

    DrmSession acquireSession(Looper looper, MediaSourceEventDispatcher mediaSourceEventDispatcher, DrmInitData drmInitData);

    boolean canAcquireSession(DrmInitData drmInitData);

    Class<? extends ExoMediaCrypto> getExoMediaCryptoType(DrmInitData drmInitData);

    void prepare();

    void release();

    /* renamed from: com.google.android.exoplayer2.drm.DrmSessionManager$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static DrmSession $default$acquirePlaceholderSession(DrmSessionManager drmSessionManager, Looper looper, int i) {
            return null;
        }

        public static void $default$prepare(DrmSessionManager drmSessionManager) {
        }

        public static void $default$release(DrmSessionManager drmSessionManager) {
        }

        public static DrmSessionManager getDummyDrmSessionManager() {
            return DrmSessionManager.DUMMY;
        }
    }
}

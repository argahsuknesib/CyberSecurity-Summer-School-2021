package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

public interface DrmSession {

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    void acquire(MediaSourceEventDispatcher mediaSourceEventDispatcher);

    DrmSessionException getError();

    ExoMediaCrypto getMediaCrypto();

    byte[] getOfflineLicenseKeySetId();

    int getState();

    boolean playClearSamplesWithoutKeys();

    Map<String, String> queryKeyStatus();

    void release(MediaSourceEventDispatcher mediaSourceEventDispatcher);

    /* renamed from: com.google.android.exoplayer2.drm.DrmSession$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$playClearSamplesWithoutKeys(DrmSession drmSession) {
            return false;
        }

        public static void replaceSession(DrmSession drmSession, DrmSession drmSession2) {
            if (drmSession != drmSession2) {
                if (drmSession2 != null) {
                    drmSession2.acquire(null);
                }
                if (drmSession != null) {
                    drmSession.release(null);
                }
            }
        }
    }

    public static class DrmSessionException extends IOException {
        public DrmSessionException(Throwable th) {
            super(th);
        }
    }
}

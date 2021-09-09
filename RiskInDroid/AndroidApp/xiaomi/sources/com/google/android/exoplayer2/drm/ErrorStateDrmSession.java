package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;
import java.util.Map;

public final class ErrorStateDrmSession implements DrmSession {
    private final DrmSession.DrmSessionException error;

    public final void acquire(MediaSourceEventDispatcher mediaSourceEventDispatcher) {
    }

    public final ExoMediaCrypto getMediaCrypto() {
        return null;
    }

    public final byte[] getOfflineLicenseKeySetId() {
        return null;
    }

    public final int getState() {
        return 1;
    }

    public final boolean playClearSamplesWithoutKeys() {
        return false;
    }

    public final Map<String, String> queryKeyStatus() {
        return null;
    }

    public final void release(MediaSourceEventDispatcher mediaSourceEventDispatcher) {
    }

    public ErrorStateDrmSession(DrmSession.DrmSessionException drmSessionException) {
        this.error = (DrmSession.DrmSessionException) Assertions.checkNotNull(drmSessionException);
    }

    public final DrmSession.DrmSessionException getError() {
        return this.error;
    }
}

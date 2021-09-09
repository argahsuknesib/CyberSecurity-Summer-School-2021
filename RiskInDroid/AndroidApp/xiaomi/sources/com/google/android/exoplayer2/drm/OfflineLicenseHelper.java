package com.google.android.exoplayer2.drm;

import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;
import java.util.Map;
import java.util.UUID;

public final class OfflineLicenseHelper {
    private static final DrmInitData DUMMY_DRM_INIT_DATA = new DrmInitData(new DrmInitData.SchemeData[0]);
    public final ConditionVariable conditionVariable;
    private final DefaultDrmSessionManager drmSessionManager;
    private final MediaSourceEventDispatcher eventDispatcher;
    private final HandlerThread handlerThread;

    public static OfflineLicenseHelper newWidevineInstance(String str, HttpDataSource.Factory factory, MediaSourceEventDispatcher mediaSourceEventDispatcher) {
        return newWidevineInstance(str, false, factory, mediaSourceEventDispatcher);
    }

    public static OfflineLicenseHelper newWidevineInstance(String str, boolean z, HttpDataSource.Factory factory, MediaSourceEventDispatcher mediaSourceEventDispatcher) {
        return newWidevineInstance(str, z, factory, null, mediaSourceEventDispatcher);
    }

    public static OfflineLicenseHelper newWidevineInstance(String str, boolean z, HttpDataSource.Factory factory, Map<String, String> map, MediaSourceEventDispatcher mediaSourceEventDispatcher) {
        return new OfflineLicenseHelper(new DefaultDrmSessionManager.Builder().setKeyRequestParameters(map).build(new HttpMediaDrmCallback(str, z, factory)), mediaSourceEventDispatcher);
    }

    @Deprecated
    public OfflineLicenseHelper(UUID uuid, ExoMediaDrm.Provider provider, MediaDrmCallback mediaDrmCallback, Map<String, String> map, MediaSourceEventDispatcher mediaSourceEventDispatcher) {
        this(new DefaultDrmSessionManager.Builder().setUuidAndExoMediaDrmProvider(uuid, provider).setKeyRequestParameters(map).build(mediaDrmCallback), mediaSourceEventDispatcher);
    }

    public OfflineLicenseHelper(DefaultDrmSessionManager defaultDrmSessionManager, MediaSourceEventDispatcher mediaSourceEventDispatcher) {
        this.drmSessionManager = defaultDrmSessionManager;
        this.eventDispatcher = mediaSourceEventDispatcher;
        this.handlerThread = new HandlerThread("ExoPlayer:OfflineLicenseHelper");
        this.handlerThread.start();
        this.conditionVariable = new ConditionVariable();
        mediaSourceEventDispatcher.addEventListener(new Handler(this.handlerThread.getLooper()), new DrmSessionEventListener() {
            /* class com.google.android.exoplayer2.drm.OfflineLicenseHelper.AnonymousClass1 */

            public /* synthetic */ void onDrmSessionAcquired() {
                DrmSessionEventListener.CC.$default$onDrmSessionAcquired(this);
            }

            public /* synthetic */ void onDrmSessionReleased() {
                DrmSessionEventListener.CC.$default$onDrmSessionReleased(this);
            }

            public void onDrmKeysLoaded() {
                OfflineLicenseHelper.this.conditionVariable.open();
            }

            public void onDrmSessionManagerError(Exception exc) {
                OfflineLicenseHelper.this.conditionVariable.open();
            }

            public void onDrmKeysRestored() {
                OfflineLicenseHelper.this.conditionVariable.open();
            }

            public void onDrmKeysRemoved() {
                OfflineLicenseHelper.this.conditionVariable.open();
            }
        }, DrmSessionEventListener.class);
    }

    public final synchronized byte[] downloadLicense(DrmInitData drmInitData) throws DrmSession.DrmSessionException {
        Assertions.checkArgument(drmInitData != null);
        return blockingKeyRequest(2, null, drmInitData);
    }

    public final synchronized byte[] renewLicense(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(bArr);
        return blockingKeyRequest(2, bArr, DUMMY_DRM_INIT_DATA);
    }

    public final synchronized void releaseLicense(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(bArr);
        blockingKeyRequest(3, bArr, DUMMY_DRM_INIT_DATA);
    }

    public final synchronized Pair<Long, Long> getLicenseDurationRemainingSec(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(bArr);
        this.drmSessionManager.prepare();
        DrmSession openBlockingKeyRequest = openBlockingKeyRequest(1, bArr, DUMMY_DRM_INIT_DATA);
        DrmSession.DrmSessionException error = openBlockingKeyRequest.getError();
        Pair<Long, Long> licenseDurationRemainingSec = WidevineUtil.getLicenseDurationRemainingSec(openBlockingKeyRequest);
        openBlockingKeyRequest.release(this.eventDispatcher);
        this.drmSessionManager.release();
        if (error == null) {
            return (Pair) Assertions.checkNotNull(licenseDurationRemainingSec);
        } else if (error.getCause() instanceof KeysExpiredException) {
            return Pair.create(0L, 0L);
        } else {
            throw error;
        }
    }

    public final void release() {
        this.handlerThread.quit();
    }

    private byte[] blockingKeyRequest(int i, byte[] bArr, DrmInitData drmInitData) throws DrmSession.DrmSessionException {
        this.drmSessionManager.prepare();
        DrmSession openBlockingKeyRequest = openBlockingKeyRequest(i, bArr, drmInitData);
        DrmSession.DrmSessionException error = openBlockingKeyRequest.getError();
        byte[] offlineLicenseKeySetId = openBlockingKeyRequest.getOfflineLicenseKeySetId();
        openBlockingKeyRequest.release(this.eventDispatcher);
        this.drmSessionManager.release();
        if (error == null) {
            return (byte[]) Assertions.checkNotNull(offlineLicenseKeySetId);
        }
        throw error;
    }

    private DrmSession openBlockingKeyRequest(int i, byte[] bArr, DrmInitData drmInitData) {
        this.drmSessionManager.setMode(i, bArr);
        this.conditionVariable.close();
        DrmSession acquireSession = this.drmSessionManager.acquireSession(this.handlerThread.getLooper(), this.eventDispatcher, drmInitData);
        this.conditionVariable.block();
        return acquireSession;
    }
}

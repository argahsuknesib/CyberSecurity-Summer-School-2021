package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaSourceEventDispatcher;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DefaultDrmSessionManager implements DrmSessionManager {
    private final MediaDrmCallback callback;
    private ExoMediaDrm exoMediaDrm;
    private final ExoMediaDrm.Provider exoMediaDrmProvider;
    private final HashMap<String, String> keyRequestParameters;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    volatile MediaDrmHandler mediaDrmHandler;
    private int mode;
    private final boolean multiSession;
    private DefaultDrmSession noMultiSessionDrmSession;
    private byte[] offlineLicenseKeySetId;
    private DefaultDrmSession placeholderDrmSession;
    private final boolean playClearSamplesWithoutKeys;
    private Looper playbackLooper;
    private int prepareCallsCount;
    private final ProvisioningManagerImpl provisioningManagerImpl;
    public final List<DefaultDrmSession> provisioningSessions;
    public final List<DefaultDrmSession> sessions;
    private final int[] useDrmSessionsForClearContentTrackTypes;
    private final UUID uuid;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public static final class Builder {
        private ExoMediaDrm.Provider exoMediaDrmProvider = FrameworkMediaDrm.DEFAULT_PROVIDER;
        private final HashMap<String, String> keyRequestParameters = new HashMap<>();
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
        private boolean multiSession;
        private boolean playClearSamplesWithoutKeys;
        private int[] useDrmSessionsForClearContentTrackTypes = new int[0];
        private UUID uuid = C.WIDEVINE_UUID;

        public final Builder setKeyRequestParameters(Map<String, String> map) {
            this.keyRequestParameters.clear();
            if (map != null) {
                this.keyRequestParameters.putAll(map);
            }
            return this;
        }

        public final Builder setUuidAndExoMediaDrmProvider(UUID uuid2, ExoMediaDrm.Provider provider) {
            this.uuid = (UUID) Assertions.checkNotNull(uuid2);
            this.exoMediaDrmProvider = (ExoMediaDrm.Provider) Assertions.checkNotNull(provider);
            return this;
        }

        public final Builder setMultiSession(boolean z) {
            this.multiSession = z;
            return this;
        }

        public final Builder setUseDrmSessionsForClearContent(int... iArr) {
            for (int i : iArr) {
                boolean z = true;
                if (!(i == 2 || i == 1)) {
                    z = false;
                }
                Assertions.checkArgument(z);
            }
            this.useDrmSessionsForClearContentTrackTypes = (int[]) iArr.clone();
            return this;
        }

        public final Builder setPlayClearSamplesWithoutKeys(boolean z) {
            this.playClearSamplesWithoutKeys = z;
            return this;
        }

        public final Builder setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy2) {
            this.loadErrorHandlingPolicy = (LoadErrorHandlingPolicy) Assertions.checkNotNull(loadErrorHandlingPolicy2);
            return this;
        }

        public final DefaultDrmSessionManager build(MediaDrmCallback mediaDrmCallback) {
            return new DefaultDrmSessionManager(this.uuid, this.exoMediaDrmProvider, mediaDrmCallback, this.keyRequestParameters, this.multiSession, this.useDrmSessionsForClearContentTrackTypes, this.playClearSamplesWithoutKeys, this.loadErrorHandlingPolicy);
        }
    }

    public static final class MissingSchemeDataException extends Exception {
        private MissingSchemeDataException(UUID uuid) {
            super("Media does not support uuid: ".concat(String.valueOf(uuid)));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public DefaultDrmSessionManager(UUID uuid2, ExoMediaDrm exoMediaDrm2, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap) {
        this(uuid2, exoMediaDrm2, mediaDrmCallback, hashMap == null ? new HashMap<>() : hashMap, false, 3);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public DefaultDrmSessionManager(UUID uuid2, ExoMediaDrm exoMediaDrm2, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, boolean z) {
        this(uuid2, exoMediaDrm2, mediaDrmCallback, hashMap == null ? new HashMap<>() : hashMap, z, 3);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public DefaultDrmSessionManager(UUID uuid2, ExoMediaDrm exoMediaDrm2, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, boolean z, int i) {
        this(uuid2, new ExoMediaDrm.AppManagedProvider(exoMediaDrm2), mediaDrmCallback, hashMap == null ? new HashMap<>() : hashMap, z, new int[0], false, new DefaultLoadErrorHandlingPolicy(i));
    }

    private DefaultDrmSessionManager(UUID uuid2, ExoMediaDrm.Provider provider, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, boolean z, int[] iArr, boolean z2, LoadErrorHandlingPolicy loadErrorHandlingPolicy2) {
        Assertions.checkNotNull(uuid2);
        Assertions.checkArgument(!C.COMMON_PSSH_UUID.equals(uuid2), "Use C.CLEARKEY_UUID instead");
        this.uuid = uuid2;
        this.exoMediaDrmProvider = provider;
        this.callback = mediaDrmCallback;
        this.keyRequestParameters = hashMap;
        this.multiSession = z;
        this.useDrmSessionsForClearContentTrackTypes = iArr;
        this.playClearSamplesWithoutKeys = z2;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.provisioningManagerImpl = new ProvisioningManagerImpl();
        this.mode = 0;
        this.sessions = new ArrayList();
        this.provisioningSessions = new ArrayList();
    }

    public void setMode(int i, byte[] bArr) {
        Assertions.checkState(this.sessions.isEmpty());
        if (i == 1 || i == 3) {
            Assertions.checkNotNull(bArr);
        }
        this.mode = i;
        this.offlineLicenseKeySetId = bArr;
    }

    public final void prepare() {
        int i = this.prepareCallsCount;
        this.prepareCallsCount = i + 1;
        if (i == 0) {
            Assertions.checkState(this.exoMediaDrm == null);
            this.exoMediaDrm = this.exoMediaDrmProvider.acquireExoMediaDrm(this.uuid);
            this.exoMediaDrm.setOnEventListener(new MediaDrmEventListener());
        }
    }

    public final void release() {
        int i = this.prepareCallsCount - 1;
        this.prepareCallsCount = i;
        if (i == 0) {
            ((ExoMediaDrm) Assertions.checkNotNull(this.exoMediaDrm)).release();
            this.exoMediaDrm = null;
        }
    }

    public boolean canAcquireSession(DrmInitData drmInitData) {
        if (this.offlineLicenseKeySetId != null) {
            return true;
        }
        if (getSchemeDatas(drmInitData, this.uuid, true).isEmpty()) {
            if (drmInitData.schemeDataCount != 1 || !drmInitData.get(0).matches(C.COMMON_PSSH_UUID)) {
                return false;
            }
            Log.w("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.uuid);
        }
        String str = drmInitData.schemeType;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        if (("cbc1".equals(str) || "cbcs".equals(str) || "cens".equals(str)) && Util.SDK_INT < 25) {
            return false;
        }
        return true;
    }

    public DrmSession acquirePlaceholderSession(Looper looper, int i) {
        assertExpectedPlaybackLooper(looper);
        ExoMediaDrm exoMediaDrm2 = (ExoMediaDrm) Assertions.checkNotNull(this.exoMediaDrm);
        if ((FrameworkMediaCrypto.class.equals(exoMediaDrm2.getExoMediaCryptoType()) && FrameworkMediaCrypto.WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC) || Util.linearSearch(this.useDrmSessionsForClearContentTrackTypes, i) == -1 || exoMediaDrm2.getExoMediaCryptoType() == null) {
            return null;
        }
        maybeCreateMediaDrmHandler(looper);
        if (this.placeholderDrmSession == null) {
            DefaultDrmSession createNewDefaultSession = createNewDefaultSession(Collections.emptyList(), true);
            this.sessions.add(createNewDefaultSession);
            this.placeholderDrmSession = createNewDefaultSession;
        }
        this.placeholderDrmSession.acquire(null);
        return this.placeholderDrmSession;
    }

    public DrmSession acquireSession(Looper looper, MediaSourceEventDispatcher mediaSourceEventDispatcher, DrmInitData drmInitData) {
        List<DrmInitData.SchemeData> list;
        assertExpectedPlaybackLooper(looper);
        maybeCreateMediaDrmHandler(looper);
        DefaultDrmSession defaultDrmSession = null;
        if (this.offlineLicenseKeySetId == null) {
            list = getSchemeDatas(drmInitData, this.uuid, false);
            if (list.isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.uuid);
                if (mediaSourceEventDispatcher != null) {
                    mediaSourceEventDispatcher.dispatch(new MediaSourceEventDispatcher.EventWithPeriodId() {
                        /* class com.google.android.exoplayer2.drm.$$Lambda$DefaultDrmSessionManager$hSbEtr9a3vsggoSTlVyWH_OXhak */

                        public final void sendTo(Object obj, int i, MediaSource.MediaPeriodId mediaPeriodId) {
                            ((DrmSessionEventListener) obj).onDrmSessionManagerError(DefaultDrmSessionManager.MissingSchemeDataException.this);
                        }
                    }, DrmSessionEventListener.class);
                }
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(missingSchemeDataException));
            }
        } else {
            list = null;
        }
        if (this.multiSession) {
            Iterator<DefaultDrmSession> it = this.sessions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DefaultDrmSession next = it.next();
                if (Util.areEqual(next.schemeDatas, list)) {
                    defaultDrmSession = next;
                    break;
                }
            }
        } else {
            defaultDrmSession = this.noMultiSessionDrmSession;
        }
        if (defaultDrmSession == null) {
            defaultDrmSession = createNewDefaultSession(list, false);
            if (!this.multiSession) {
                this.noMultiSessionDrmSession = defaultDrmSession;
            }
            this.sessions.add(defaultDrmSession);
        }
        defaultDrmSession.acquire(mediaSourceEventDispatcher);
        return defaultDrmSession;
    }

    public Class<? extends ExoMediaCrypto> getExoMediaCryptoType(DrmInitData drmInitData) {
        if (canAcquireSession(drmInitData)) {
            return ((ExoMediaDrm) Assertions.checkNotNull(this.exoMediaDrm)).getExoMediaCryptoType();
        }
        return null;
    }

    private void assertExpectedPlaybackLooper(Looper looper) {
        Looper looper2 = this.playbackLooper;
        Assertions.checkState(looper2 == null || looper2 == looper);
        this.playbackLooper = looper;
    }

    private void maybeCreateMediaDrmHandler(Looper looper) {
        if (this.mediaDrmHandler == null) {
            this.mediaDrmHandler = new MediaDrmHandler(looper);
        }
    }

    private DefaultDrmSession createNewDefaultSession(List<DrmInitData.SchemeData> list, boolean z) {
        Assertions.checkNotNull(this.exoMediaDrm);
        return new DefaultDrmSession(this.uuid, this.exoMediaDrm, this.provisioningManagerImpl, new DefaultDrmSession.ReleaseCallback() {
            /* class com.google.android.exoplayer2.drm.$$Lambda$DefaultDrmSessionManager$zFgxvU3rcYVkNYfVSx94oAwPek */

            public final void onSessionReleased(DefaultDrmSession defaultDrmSession) {
                DefaultDrmSessionManager.this.onSessionReleased(defaultDrmSession);
            }
        }, list, this.mode, this.playClearSamplesWithoutKeys | z, z, this.offlineLicenseKeySetId, this.keyRequestParameters, this.callback, (Looper) Assertions.checkNotNull(this.playbackLooper), this.loadErrorHandlingPolicy);
    }

    /* access modifiers changed from: private */
    public void onSessionReleased(DefaultDrmSession defaultDrmSession) {
        this.sessions.remove(defaultDrmSession);
        if (this.placeholderDrmSession == defaultDrmSession) {
            this.placeholderDrmSession = null;
        }
        if (this.noMultiSessionDrmSession == defaultDrmSession) {
            this.noMultiSessionDrmSession = null;
        }
        if (this.provisioningSessions.size() > 1 && this.provisioningSessions.get(0) == defaultDrmSession) {
            this.provisioningSessions.get(1).provision();
        }
        this.provisioningSessions.remove(defaultDrmSession);
    }

    private static List<DrmInitData.SchemeData> getSchemeDatas(DrmInitData drmInitData, UUID uuid2, boolean z) {
        ArrayList arrayList = new ArrayList(drmInitData.schemeDataCount);
        for (int i = 0; i < drmInitData.schemeDataCount; i++) {
            DrmInitData.SchemeData schemeData = drmInitData.get(i);
            if ((schemeData.matches(uuid2) || (C.CLEARKEY_UUID.equals(uuid2) && schemeData.matches(C.COMMON_PSSH_UUID))) && (schemeData.data != null || z)) {
                arrayList.add(schemeData);
            }
        }
        return arrayList;
    }

    @SuppressLint({"HandlerLeak"})
    class MediaDrmHandler extends Handler {
        public MediaDrmHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr != null) {
                for (DefaultDrmSession next : DefaultDrmSessionManager.this.sessions) {
                    if (next.hasSessionId(bArr)) {
                        next.onMediaDrmEvent(message.what);
                        return;
                    }
                }
            }
        }
    }

    class ProvisioningManagerImpl implements DefaultDrmSession.ProvisioningManager {
        private ProvisioningManagerImpl() {
        }

        public void provisionRequired(DefaultDrmSession defaultDrmSession) {
            if (!DefaultDrmSessionManager.this.provisioningSessions.contains(defaultDrmSession)) {
                DefaultDrmSessionManager.this.provisioningSessions.add(defaultDrmSession);
                if (DefaultDrmSessionManager.this.provisioningSessions.size() == 1) {
                    defaultDrmSession.provision();
                }
            }
        }

        public void onProvisionCompleted() {
            for (DefaultDrmSession onProvisionCompleted : DefaultDrmSessionManager.this.provisioningSessions) {
                onProvisionCompleted.onProvisionCompleted();
            }
            DefaultDrmSessionManager.this.provisioningSessions.clear();
        }

        public void onProvisionError(Exception exc) {
            for (DefaultDrmSession onProvisionError : DefaultDrmSessionManager.this.provisioningSessions) {
                onProvisionError.onProvisionError(exc);
            }
            DefaultDrmSessionManager.this.provisioningSessions.clear();
        }
    }

    class MediaDrmEventListener implements ExoMediaDrm.OnEventListener {
        private MediaDrmEventListener() {
        }

        public void onEvent(ExoMediaDrm exoMediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
            ((MediaDrmHandler) Assertions.checkNotNull(DefaultDrmSessionManager.this.mediaDrmHandler)).obtainMessage(i, bArr).sendToTarget();
        }
    }
}

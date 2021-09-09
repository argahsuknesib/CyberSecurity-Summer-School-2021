package com.google.android.exoplayer2.drm;

public interface DrmSessionEventListener {

    /* renamed from: com.google.android.exoplayer2.drm.DrmSessionEventListener$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onDrmKeysLoaded(DrmSessionEventListener drmSessionEventListener) {
        }

        public static void $default$onDrmKeysRemoved(DrmSessionEventListener drmSessionEventListener) {
        }

        public static void $default$onDrmKeysRestored(DrmSessionEventListener drmSessionEventListener) {
        }

        public static void $default$onDrmSessionAcquired(DrmSessionEventListener drmSessionEventListener) {
        }

        public static void $default$onDrmSessionManagerError(DrmSessionEventListener drmSessionEventListener, Exception exc) {
        }

        public static void $default$onDrmSessionReleased(DrmSessionEventListener drmSessionEventListener) {
        }
    }

    void onDrmKeysLoaded();

    void onDrmKeysRemoved();

    void onDrmKeysRestored();

    void onDrmSessionAcquired();

    void onDrmSessionManagerError(Exception exc);

    void onDrmSessionReleased();
}

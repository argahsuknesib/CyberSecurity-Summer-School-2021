package com.facebook.common.disk;

public class NoOpDiskTrimmableRegistry implements DiskTrimmableRegistry {
    private static NoOpDiskTrimmableRegistry sInstance;

    public void registerDiskTrimmable(DiskTrimmable diskTrimmable) {
    }

    public void unregisterDiskTrimmable(DiskTrimmable diskTrimmable) {
    }

    private NoOpDiskTrimmableRegistry() {
    }

    public static synchronized NoOpDiskTrimmableRegistry getInstance() {
        NoOpDiskTrimmableRegistry noOpDiskTrimmableRegistry;
        synchronized (NoOpDiskTrimmableRegistry.class) {
            if (sInstance == null) {
                sInstance = new NoOpDiskTrimmableRegistry();
            }
            noOpDiskTrimmableRegistry = sInstance;
        }
        return noOpDiskTrimmableRegistry;
    }
}

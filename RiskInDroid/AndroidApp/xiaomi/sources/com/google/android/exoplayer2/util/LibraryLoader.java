package com.google.android.exoplayer2.util;

import java.util.Arrays;

public final class LibraryLoader {
    private boolean isAvailable;
    private boolean loadAttempted;
    private String[] nativeLibraries;

    public LibraryLoader(String... strArr) {
        this.nativeLibraries = strArr;
    }

    public final synchronized void setLibraries(String... strArr) {
        Assertions.checkState(!this.loadAttempted, "Cannot set libraries after loading");
        this.nativeLibraries = strArr;
    }

    public final synchronized boolean isAvailable() {
        if (this.loadAttempted) {
            return this.isAvailable;
        }
        this.loadAttempted = true;
        try {
            for (String loadLibrary : this.nativeLibraries) {
                System.loadLibrary(loadLibrary);
            }
            this.isAvailable = true;
        } catch (UnsatisfiedLinkError unused) {
            Log.w("LibraryLoader", "Failed to load " + Arrays.toString(this.nativeLibraries));
        }
        return this.isAvailable;
    }
}

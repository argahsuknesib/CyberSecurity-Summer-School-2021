package com.facebook.soloader;

import android.os.StrictMode;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

public abstract class SoSource {
    public void addToLdLibraryPath(Collection<String> collection) {
    }

    public abstract int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException;

    /* access modifiers changed from: protected */
    public void prepare(int i) throws IOException {
    }

    public abstract File unpackLibrary(String str) throws IOException;

    public String[] getSoSourceAbis() {
        return SysUtil.getSupportedAbis();
    }

    public String toString() {
        return getClass().getName();
    }
}

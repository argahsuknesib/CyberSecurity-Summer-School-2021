package com.facebook.soloader;

import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

public class DirectorySoSource extends SoSource {
    protected final int flags;
    protected final File soDirectory;

    public DirectorySoSource(File file, int i) {
        this.soDirectory = file;
        this.flags = i;
    }

    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return loadLibraryFrom(str, i, this.soDirectory, threadPolicy);
    }

    /* access modifiers changed from: protected */
    public int loadLibraryFrom(String str, int i, File file, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        File file2 = new File(file, str);
        if (!file2.exists()) {
            Log.d("SoLoader", str + " not found on " + file.getCanonicalPath());
            return 0;
        } else if ((i & 1) != 0 && (this.flags & 2) != 0) {
            return 2;
        } else {
            if ((this.flags & 1) != 0) {
                String[] dependencies = getDependencies(file2);
                if (dependencies.length > 0) {
                    Log.d("SoLoader", "Loading lib dependencies: " + Arrays.toString(dependencies));
                }
                for (String str2 : dependencies) {
                    if (!str2.startsWith("/")) {
                        SoLoader.loadLibraryBySoName(str2, i | 1, threadPolicy);
                    }
                }
            }
            SoLoader.sSoFileLoader.load(file2.getAbsolutePath(), i);
            return 1;
        }
    }

    private static String[] getDependencies(File file) throws IOException {
        if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
            Api18TraceUtils.beginTraceSection("SoLoader.getElfDependencies[" + file.getName() + "]");
        }
        try {
            return MinElf.extract_DT_NEEDED(file);
        } finally {
            if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                Api18TraceUtils.endSection();
            }
        }
    }

    public File unpackLibrary(String str) throws IOException {
        File file = new File(this.soDirectory, str);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public void addToLdLibraryPath(Collection<String> collection) {
        collection.add(this.soDirectory.getAbsolutePath());
    }

    public String toString() {
        String str;
        try {
            str = String.valueOf(this.soDirectory.getCanonicalPath());
        } catch (IOException unused) {
            str = this.soDirectory.getName();
        }
        return getClass().getName() + "[root = " + str + " flags = " + this.flags + ']';
    }
}

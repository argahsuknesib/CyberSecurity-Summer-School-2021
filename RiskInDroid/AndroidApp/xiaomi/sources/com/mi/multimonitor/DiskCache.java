package com.mi.multimonitor;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class DiskCache {
    Context mContext;

    public DiskCache(Context context) {
        this.mContext = context;
    }

    public void saveCrash(String str) {
        try {
            File file = new File(this.mContext.getCacheDir(), "mi_crash");
            if (file.exists()) {
                File file2 = new File(file, "crash");
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                PrintWriter printWriter = new PrintWriter(file2);
                printWriter.write(str);
                printWriter.flush();
                printWriter.close();
            } else if (!file.mkdirs()) {
                Log.e("DiskCache", "Unable to create cache dir " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        File[] listFiles = new File(this.mContext.getCacheDir(), "mi_crash").listFiles();
        if (listFiles != null) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
    }

    public File getCrashCacheFile() {
        return new File(new File(this.mContext.getCacheDir(), "mi_crash"), "crash");
    }
}

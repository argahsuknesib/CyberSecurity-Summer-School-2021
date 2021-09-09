package com.xiaomi.smarthome.miio.camera.cloudstorage.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FileNamer {
    private static FileNamer __INSTANCE_;
    private SimpleDateFormat mImageFormat = new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmssSSS");
    private long mLastDate;
    private int mSameSecondCount;
    private SimpleDateFormat mVideoFormat = new SimpleDateFormat("'VID'_yyyyMMdd_HHmmss");

    private FileNamer() {
    }

    public static synchronized FileNamer getInstance() {
        FileNamer fileNamer;
        synchronized (FileNamer.class) {
            if (__INSTANCE_ == null) {
                __INSTANCE_ = new FileNamer();
            }
            fileNamer = __INSTANCE_;
        }
        return fileNamer;
    }

    public synchronized String generateName(long j, boolean z) {
        String str;
        Date date = new Date(j);
        if (z) {
            str = this.mVideoFormat.format(date);
        } else {
            str = this.mImageFormat.format(date);
        }
        return str;
    }

    public long getTime(String str, boolean z) {
        if (!z) {
            return this.mImageFormat.parse(str).getTime();
        }
        try {
            return this.mVideoFormat.parse(str).getTime();
        } catch (Exception unused) {
            return 0;
        }
    }
}

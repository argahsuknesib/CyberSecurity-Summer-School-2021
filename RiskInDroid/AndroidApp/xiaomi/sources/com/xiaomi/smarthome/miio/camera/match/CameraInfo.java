package com.xiaomi.smarthome.miio.camera.match;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;

public class CameraInfo {
    public Bitmap mLastAvatarBitmap;
    long mLastAvatarBitmapLastModifyTime;
    public Bitmap mLastSnapBitmap;
    String mUid;

    public CameraInfo(String str) {
        this.mUid = str;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    public void loadLastAvataBitmap(String str, Context context) {
        try {
            File fileStreamPath = context.getFileStreamPath(str.toLowerCase().replace(':', '_'));
            if (fileStreamPath.exists()) {
                long lastModified = fileStreamPath.lastModified();
                if (lastModified > this.mLastAvatarBitmapLastModifyTime) {
                    this.mLastAvatarBitmapLastModifyTime = lastModified;
                    this.mLastAvatarBitmap = BitmapFactory.decodeFile(fileStreamPath.getAbsolutePath());
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    public void loadLastSnapBitmap(String str, Context context) {
        if (this.mLastSnapBitmap == null) {
            try {
                String replace = str.toLowerCase().replace(':', '_');
                File fileStreamPath = context.getFileStreamPath(replace + "_snap");
                if (fileStreamPath.exists()) {
                    this.mLastSnapBitmap = BitmapFactory.decodeFile(fileStreamPath.getAbsolutePath());
                }
            } catch (Exception unused) {
            }
        }
    }
}

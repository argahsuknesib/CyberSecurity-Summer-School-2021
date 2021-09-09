package com.xiaomi.smarthome.ffmpegcmd;

import android.text.TextUtils;

public class FFmpegCmd {
    private static long sDuration;
    private static O000000o sOnCmdExecListener;

    public interface O000000o {
    }

    private static native int exec(int i, String[] strArr);

    private static native int execSync(int i, String[] strArr);

    public static void onExecuted(int i) {
    }

    public static void onProgress(float f) {
    }

    static {
        System.loadLibrary("ffmpeg-cmd");
    }

    public static int execSync(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        String[] split = str.split(" ");
        return execSync(split.length, split);
    }

    public static int exec(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        String[] split = str.split(" ");
        return exec(split.length, split);
    }

    public static void exec(String[] strArr, long j, O000000o o000000o) {
        sOnCmdExecListener = o000000o;
        sDuration = j;
        exec(strArr.length, strArr);
    }
}

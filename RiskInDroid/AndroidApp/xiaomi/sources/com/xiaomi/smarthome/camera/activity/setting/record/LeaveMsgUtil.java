package com.xiaomi.smarthome.camera.activity.setting.record;

import _m_j.chq;
import android.text.TextUtils;
import java.io.File;

public class LeaveMsgUtil {
    public static final String TAG = "LeaveMsgUtil";

    public static String getAudioFilePath(String str, long j) {
        StringBuilder sb = new StringBuilder();
        String str2 = chq.O0000O0o + File.separator + str;
        if (TextUtils.isEmpty(str2)) {
            str2 = null;
        } else {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        sb.append(str2);
        sb.append(j);
        sb.append(".alaw");
        return sb.toString();
    }
}

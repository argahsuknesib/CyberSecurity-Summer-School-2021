package com.xiaomi.mico.common.application;

import com.xiaomi.mico.common.util.PreferenceUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import java.io.File;

public class ApplicationConstants {
    public static final Long MI_APP_ID = 226049557681668096L;
    private static volatile int sRnEnv = PreferenceUtils.getSettingInt(CommonApplication.getAppContext(), "mico_rn_env", 1);
    private static volatile int sTabType = PreferenceUtils.getSettingInt(CommonApplication.getAppContext(), "mico_tab_type", 2);

    public static boolean isQQMusicEnabled() {
        return true;
    }

    public static boolean isTaiWanEnabled() {
        return true;
    }

    public static String getExternalStoragePath() {
        File externalFilesDir = CommonApplication.getAppContext().getExternalFilesDir(null);
        if (externalFilesDir == null) {
            externalFilesDir = CommonApplication.getAppContext().getFilesDir();
        }
        return externalFilesDir.getAbsolutePath();
    }

    public static synchronized boolean isMijiaTab() {
        boolean z;
        synchronized (ApplicationConstants.class) {
            z = sTabType == 2;
        }
        return z;
    }

    public static void switchSecondTab(int i) {
        if (sTabType != i) {
            sTabType = i;
            PreferenceUtils.setSettingInt(CommonApplication.getAppContext(), "mico_tab_type", i);
        }
    }

    public static synchronized boolean isRnDebug() {
        boolean z;
        synchronized (ApplicationConstants.class) {
            z = sRnEnv == 2;
        }
        return z;
    }

    public static void switchRnEnv(int i) {
        if (sRnEnv != i) {
            sRnEnv = i;
            PreferenceUtils.setSettingInt(CommonApplication.getAppContext(), "mico_rn_env", i);
        }
    }

    public static String getLogDirectory() {
        return getExternalStoragePath() + File.separator + "log";
    }

    public static String getLogImageDirectory() {
        return getLogDirectory() + File.separator + "image";
    }

    public static String getDownloadDirectory() {
        return getExternalStoragePath() + File.separator + "apk";
    }

    public static String getAudioDirectory() {
        File externalCacheDir = CommonApplication.getAppContext().getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = CommonApplication.getAppContext().getCacheDir();
        }
        return externalCacheDir.getAbsolutePath() + File.separator + "audio";
    }

    public static void init() {
        File file = new File(getAudioDirectory());
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public enum TourGuideStep {
        PLAYER_PAUSE_TIMER(R.string.mico_tourguide_player_pause_timer, 8388611, 1);
        
        private int gravity;
        private final int maxShowTime;
        private int text;

        private TourGuideStep(int i, int i2) {
            this(r7, r8, i, i2, 1);
        }

        private TourGuideStep(int i, int i2, int i3) {
            this.maxShowTime = i3;
            this.text = i;
            this.gravity = i2;
        }

        public final int getMaxShowTime() {
            return this.maxShowTime;
        }

        public final String toString() {
            return "tourguide_" + super.toString();
        }

        public final int getText() {
            return this.text;
        }

        public final int getGravity() {
            return this.gravity;
        }
    }
}

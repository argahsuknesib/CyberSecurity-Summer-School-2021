package com.xiaomi.mi_connect_service.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import java.util.Arrays;
import java.util.List;

public class AudioUtil {
    private static final String TAG = AudioUtil.class.getSimpleName();
    private static List<Integer> sCallModes = Arrays.asList(2, 3, 1);

    public static boolean checkIsSpeakerOn(Context context) {
        return ((AudioManager) context.getSystemService("audio")).isSpeakerphoneOn();
    }

    public static boolean isCalling(Context context) {
        return sCallModes.contains(Integer.valueOf(((AudioManager) context.getSystemService("audio")).getMode()));
    }

    public static boolean isMusicOn(Context context) {
        return ((AudioManager) context.getSystemService("audio")).isMusicActive();
    }

    public static void resumeMiPlayer(Context context) {
        if (isMusicOn(context)) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    LogUtil.e(TAG, e.getMessage(), e);
                }
                if (!isMusicOn(context)) {
                    LogUtil.v(TAG, "!isMusicOn()", new Object[0]);
                    Intent intent = new Intent("com.miui.player.musicservicecommand.togglepause");
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setComponent(new ComponentName("com.miui.player", "com.miui.player.service.MediaPlaybackService"));
                    context.startService(intent);
                    return;
                }
                LogUtil.v(TAG, "isMusicOn()", new Object[0]);
            }
        }
    }
}

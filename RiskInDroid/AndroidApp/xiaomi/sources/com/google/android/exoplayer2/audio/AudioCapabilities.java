package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.provider.Settings;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class AudioCapabilities {
    public static final AudioCapabilities DEFAULT_AUDIO_CAPABILITIES = new AudioCapabilities(new int[]{2}, 8);
    private static final AudioCapabilities EXTERNAL_SURROUND_SOUND_CAPABILITIES = new AudioCapabilities(new int[]{2, 5, 6}, 8);
    private final int maxChannelCount;
    private final int[] supportedEncodings;

    public static AudioCapabilities getCapabilities(Context context) {
        return getCapabilities(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @SuppressLint({"InlinedApi"})
    static AudioCapabilities getCapabilities(Context context, Intent intent) {
        if (deviceMaySetExternalSurroundSoundGlobalSetting() && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) {
            return EXTERNAL_SURROUND_SOUND_CAPABILITIES;
        }
        if (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            return DEFAULT_AUDIO_CAPABILITIES;
        }
        return new AudioCapabilities(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
    }

    static Uri getExternalSurroundSoundGlobalSettingUri() {
        if (deviceMaySetExternalSurroundSoundGlobalSetting()) {
            return Settings.Global.getUriFor("external_surround_sound_enabled");
        }
        return null;
    }

    public AudioCapabilities(int[] iArr, int i) {
        if (iArr != null) {
            this.supportedEncodings = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.supportedEncodings);
        } else {
            this.supportedEncodings = new int[0];
        }
        this.maxChannelCount = i;
    }

    public final boolean supportsEncoding(int i) {
        return Arrays.binarySearch(this.supportedEncodings, i) >= 0;
    }

    public final int getMaxChannelCount() {
        return this.maxChannelCount;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioCapabilities)) {
            return false;
        }
        AudioCapabilities audioCapabilities = (AudioCapabilities) obj;
        return Arrays.equals(this.supportedEncodings, audioCapabilities.supportedEncodings) && this.maxChannelCount == audioCapabilities.maxChannelCount;
    }

    public final int hashCode() {
        return this.maxChannelCount + (Arrays.hashCode(this.supportedEncodings) * 31);
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.maxChannelCount + ", supportedEncodings=" + Arrays.toString(this.supportedEncodings) + "]";
    }

    private static boolean deviceMaySetExternalSurroundSoundGlobalSetting() {
        return Util.SDK_INT >= 17 && "Amazon".equals(Util.MANUFACTURER);
    }
}

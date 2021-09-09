package com.google.android.exoplayer2;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import com.google.android.exoplayer2.AudioFocusManager;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.common.internal.GmsLogger;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

final class AudioFocusManager {
    private AudioAttributes audioAttributes;
    private AudioFocusRequest audioFocusRequest;
    private int audioFocusState;
    private final AudioManager audioManager;
    private int focusGain;
    private final AudioFocusListener focusListener;
    private PlayerControl playerControl;
    private boolean rebuildAudioFocusRequest;
    private float volumeMultiplier = 1.0f;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayerCommand {
    }

    public interface PlayerControl {
        void executePlayerCommand(int i);

        void setVolumeMultiplier(float f);
    }

    public AudioFocusManager(Context context, Handler handler, PlayerControl playerControl2) {
        this.audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
        this.playerControl = playerControl2;
        this.focusListener = new AudioFocusListener(handler);
        this.audioFocusState = 0;
    }

    public final float getVolumeMultiplier() {
        return this.volumeMultiplier;
    }

    public final void setAudioAttributes(AudioAttributes audioAttributes2) {
        if (!Util.areEqual(this.audioAttributes, audioAttributes2)) {
            this.audioAttributes = audioAttributes2;
            this.focusGain = convertAudioAttributesToFocusGain(audioAttributes2);
            int i = this.focusGain;
            boolean z = true;
            if (!(i == 1 || i == 0)) {
                z = false;
            }
            Assertions.checkArgument(z, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
        }
    }

    public final int updateAudioFocus(boolean z, int i) {
        if (shouldAbandonAudioFocus(i)) {
            abandonAudioFocus();
            if (z) {
                return 1;
            }
            return -1;
        } else if (z) {
            return requestAudioFocus();
        } else {
            return -1;
        }
    }

    public final void release() {
        this.playerControl = null;
        abandonAudioFocus();
    }

    /* access modifiers changed from: package-private */
    public final AudioManager.OnAudioFocusChangeListener getFocusListener() {
        return this.focusListener;
    }

    private boolean shouldAbandonAudioFocus(int i) {
        return i == 1 || this.focusGain != 1;
    }

    private int requestAudioFocus() {
        if (this.audioFocusState == 1) {
            return 1;
        }
        if ((Util.SDK_INT >= 26 ? requestAudioFocusV26() : requestAudioFocusDefault()) == 1) {
            setAudioFocusState(1);
            return 1;
        }
        setAudioFocusState(0);
        return -1;
    }

    private void abandonAudioFocus() {
        if (this.audioFocusState != 0) {
            if (Util.SDK_INT >= 26) {
                abandonAudioFocusV26();
            } else {
                abandonAudioFocusDefault();
            }
            setAudioFocusState(0);
        }
    }

    private int requestAudioFocusDefault() {
        return this.audioManager.requestAudioFocus(this.focusListener, Util.getStreamTypeForAudioUsage(((AudioAttributes) Assertions.checkNotNull(this.audioAttributes)).usage), this.focusGain);
    }

    private int requestAudioFocusV26() {
        if (this.audioFocusRequest == null || this.rebuildAudioFocusRequest) {
            AudioFocusRequest audioFocusRequest2 = this.audioFocusRequest;
            this.audioFocusRequest = (audioFocusRequest2 == null ? new AudioFocusRequest.Builder(this.focusGain) : new AudioFocusRequest.Builder(audioFocusRequest2)).setAudioAttributes(((AudioAttributes) Assertions.checkNotNull(this.audioAttributes)).getAudioAttributesV21()).setWillPauseWhenDucked(willPauseWhenDucked()).setOnAudioFocusChangeListener(this.focusListener).build();
            this.rebuildAudioFocusRequest = false;
        }
        return this.audioManager.requestAudioFocus(this.audioFocusRequest);
    }

    private void abandonAudioFocusDefault() {
        this.audioManager.abandonAudioFocus(this.focusListener);
    }

    private void abandonAudioFocusV26() {
        AudioFocusRequest audioFocusRequest2 = this.audioFocusRequest;
        if (audioFocusRequest2 != null) {
            this.audioManager.abandonAudioFocusRequest(audioFocusRequest2);
        }
    }

    private boolean willPauseWhenDucked() {
        AudioAttributes audioAttributes2 = this.audioAttributes;
        return audioAttributes2 != null && audioAttributes2.contentType == 1;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static int convertAudioAttributesToFocusGain(AudioAttributes audioAttributes2) {
        if (audioAttributes2 == null) {
            return 0;
        }
        switch (audioAttributes2.usage) {
            case 0:
                Log.w("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            case 1:
            case 14:
                return 1;
            case 2:
            case 4:
                return 2;
            case 3:
                return 0;
            case 5:
            case 6:
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
            case 9:
            case 10:
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
            case 13:
                break;
            case 11:
                if (audioAttributes2.contentType == 1) {
                    return 2;
                }
                break;
            case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
            default:
                Log.w("AudioFocusManager", "Unidentified audio usage: " + audioAttributes2.usage);
                return 0;
            case 16:
                if (Util.SDK_INT >= 19) {
                    return 4;
                }
                return 2;
        }
        return 3;
    }

    private void setAudioFocusState(int i) {
        if (this.audioFocusState != i) {
            this.audioFocusState = i;
            float f = i == 3 ? 0.2f : 1.0f;
            if (this.volumeMultiplier != f) {
                this.volumeMultiplier = f;
                PlayerControl playerControl2 = this.playerControl;
                if (playerControl2 != null) {
                    playerControl2.setVolumeMultiplier(f);
                }
            }
        }
    }

    public final void handlePlatformAudioFocusChange(int i) {
        if (i == -3 || i == -2) {
            if (i == -2 || willPauseWhenDucked()) {
                executePlayerCommand(0);
                setAudioFocusState(2);
                return;
            }
            setAudioFocusState(3);
        } else if (i == -1) {
            executePlayerCommand(-1);
            abandonAudioFocus();
        } else if (i != 1) {
            Log.w("AudioFocusManager", "Unknown focus change type: ".concat(String.valueOf(i)));
        } else {
            setAudioFocusState(1);
            executePlayerCommand(1);
        }
    }

    private void executePlayerCommand(int i) {
        PlayerControl playerControl2 = this.playerControl;
        if (playerControl2 != null) {
            playerControl2.executePlayerCommand(i);
        }
    }

    class AudioFocusListener implements AudioManager.OnAudioFocusChangeListener {
        private final Handler eventHandler;

        public AudioFocusListener(Handler handler) {
            this.eventHandler = handler;
        }

        public /* synthetic */ void lambda$onAudioFocusChange$0$AudioFocusManager$AudioFocusListener(int i) {
            AudioFocusManager.this.handlePlatformAudioFocusChange(i);
        }

        public void onAudioFocusChange(int i) {
            this.eventHandler.post(new Runnable(i) {
                /* class com.google.android.exoplayer2.$$Lambda$AudioFocusManager$AudioFocusListener$0cUcJWkg6g98frTzEcyFa9y2DmA */
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    AudioFocusManager.AudioFocusListener.this.lambda$onAudioFocusChange$0$AudioFocusManager$AudioFocusListener(this.f$1);
                }
            });
        }
    }
}

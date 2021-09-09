package com.google.android.exoplayer2.audio;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class AudioCapabilitiesReceiver {
    AudioCapabilities audioCapabilities;
    public final Context context;
    private final ExternalSurroundSoundSettingObserver externalSurroundSoundSettingObserver;
    private final Handler handler = new Handler(Util.getLooper());
    private final Listener listener;
    private final BroadcastReceiver receiver;
    private boolean registered;

    public interface Listener {
        void onAudioCapabilitiesChanged(AudioCapabilities audioCapabilities);
    }

    public AudioCapabilitiesReceiver(Context context2, Listener listener2) {
        Context applicationContext = context2.getApplicationContext();
        this.context = applicationContext;
        this.listener = (Listener) Assertions.checkNotNull(listener2);
        ExternalSurroundSoundSettingObserver externalSurroundSoundSettingObserver2 = null;
        this.receiver = Util.SDK_INT >= 21 ? new HdmiAudioPlugBroadcastReceiver() : null;
        Uri externalSurroundSoundGlobalSettingUri = AudioCapabilities.getExternalSurroundSoundGlobalSettingUri();
        this.externalSurroundSoundSettingObserver = externalSurroundSoundGlobalSettingUri != null ? new ExternalSurroundSoundSettingObserver(this.handler, applicationContext.getContentResolver(), externalSurroundSoundGlobalSettingUri) : externalSurroundSoundSettingObserver2;
    }

    public final AudioCapabilities register() {
        if (this.registered) {
            return (AudioCapabilities) Assertions.checkNotNull(this.audioCapabilities);
        }
        this.registered = true;
        ExternalSurroundSoundSettingObserver externalSurroundSoundSettingObserver2 = this.externalSurroundSoundSettingObserver;
        if (externalSurroundSoundSettingObserver2 != null) {
            externalSurroundSoundSettingObserver2.register();
        }
        Intent intent = null;
        if (this.receiver != null) {
            intent = this.context.registerReceiver(this.receiver, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), null, this.handler);
        }
        this.audioCapabilities = AudioCapabilities.getCapabilities(this.context, intent);
        return this.audioCapabilities;
    }

    public final void unregister() {
        if (this.registered) {
            this.audioCapabilities = null;
            BroadcastReceiver broadcastReceiver = this.receiver;
            if (broadcastReceiver != null) {
                this.context.unregisterReceiver(broadcastReceiver);
            }
            ExternalSurroundSoundSettingObserver externalSurroundSoundSettingObserver2 = this.externalSurroundSoundSettingObserver;
            if (externalSurroundSoundSettingObserver2 != null) {
                externalSurroundSoundSettingObserver2.unregister();
            }
            this.registered = false;
        }
    }

    public final void onNewAudioCapabilities(AudioCapabilities audioCapabilities2) {
        if (this.registered && !audioCapabilities2.equals(this.audioCapabilities)) {
            this.audioCapabilities = audioCapabilities2;
            this.listener.onAudioCapabilitiesChanged(audioCapabilities2);
        }
    }

    final class HdmiAudioPlugBroadcastReceiver extends BroadcastReceiver {
        private HdmiAudioPlugBroadcastReceiver() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (!isInitialStickyBroadcast()) {
                AudioCapabilitiesReceiver.this.onNewAudioCapabilities(AudioCapabilities.getCapabilities(context, intent));
            }
        }
    }

    final class ExternalSurroundSoundSettingObserver extends ContentObserver {
        private final ContentResolver resolver;
        private final Uri settingUri;

        public ExternalSurroundSoundSettingObserver(Handler handler, ContentResolver contentResolver, Uri uri) {
            super(handler);
            this.resolver = contentResolver;
            this.settingUri = uri;
        }

        public final void register() {
            this.resolver.registerContentObserver(this.settingUri, false, this);
        }

        public final void unregister() {
            this.resolver.unregisterContentObserver(this);
        }

        public final void onChange(boolean z) {
            AudioCapabilitiesReceiver audioCapabilitiesReceiver = AudioCapabilitiesReceiver.this;
            audioCapabilitiesReceiver.onNewAudioCapabilities(AudioCapabilities.getCapabilities(audioCapabilitiesReceiver.context));
        }
    }
}

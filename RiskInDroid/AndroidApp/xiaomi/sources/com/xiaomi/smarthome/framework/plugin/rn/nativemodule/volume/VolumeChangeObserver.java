package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.volume;

import _m_j.fwz;
import _m_j.gbu;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.lang.ref.WeakReference;

public class VolumeChangeObserver {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f8443O000000o;
    public VolumeReceiver O00000Oo;
    private AudioManager O00000o0;

    public VolumeChangeObserver(Context context) {
        this.f8443O000000o = context;
        this.O00000o0 = (AudioManager) context.getSystemService("audio");
    }

    public final double O000000o() {
        AudioManager audioManager = this.O00000o0;
        if (audioManager == null) {
            return 0.0d;
        }
        int streamVolume = audioManager.getStreamVolume(3);
        int streamMaxVolume = this.O00000o0.getStreamMaxVolume(3);
        if (streamMaxVolume == 0) {
            return 0.0d;
        }
        double d = (double) streamVolume;
        double d2 = (double) streamMaxVolume;
        Double.isNaN(d);
        Double.isNaN(d2);
        return d / d2;
    }

    public final void O00000Oo() {
        gbu.O00000o0("unregisterVolumeReceiver,");
        if (this.f8443O000000o != null && this.O00000Oo != null) {
            gbu.O00000o0("unregisterVolumeReceiver,need to unregister");
            this.f8443O000000o.unregisterReceiver(this.O00000Oo);
            this.O00000Oo = null;
        }
    }

    public static class VolumeReceiver extends BroadcastReceiver {

        /* renamed from: O000000o  reason: collision with root package name */
        private WeakReference<VolumeChangeObserver> f8444O000000o;

        public VolumeReceiver(VolumeChangeObserver volumeChangeObserver) {
            this.f8444O000000o = new WeakReference<>(volumeChangeObserver);
        }

        public final void onReceive(Context context, Intent intent) {
            ReactContext currentReactContext;
            gbu.O00000o0("VolumeReceiver,onReceive");
            WeakReference<VolumeChangeObserver> weakReference = this.f8444O000000o;
            if (weakReference != null) {
                VolumeChangeObserver volumeChangeObserver = weakReference.get();
                if (intent != null && intent.getAction() != null && intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION") && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                    gbu.O00000o0("VolumeReceiver,onReceive,object:".concat(String.valueOf(this)));
                    double O000000o2 = volumeChangeObserver.O000000o();
                    gbu.O00000o0("sendVolumeChangeEvent,currentVolume:" + O000000o2 + ",object:" + volumeChangeObserver);
                    WritableMap createMap = Arguments.createMap();
                    createMap.putDouble("volume", O000000o2);
                    createMap.putString("eventName", "onVolumeChange_36621");
                    ReactInstanceManager reactInstanceManager = fwz.O000000o().O00000Oo().O0000O0o;
                    if (reactInstanceManager != null && (currentReactContext = reactInstanceManager.getCurrentReactContext()) != null) {
                        gbu.O00000o0("sendVolumeChangeEvent,emit");
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onVolumeChange_36621", createMap);
                    }
                }
            }
        }
    }
}

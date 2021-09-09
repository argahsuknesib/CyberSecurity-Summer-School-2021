package _m_j;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public final class um {
    public static final String[] O00000Oo = {"onVideoLoadStart", "onVideoLoad", "onVideoError", "onVideoProgress", "onVideoSeek", "onVideoEnd", "onVideoFullscreenPlayerWillPresent", "onVideoFullscreenPlayerDidPresent", "onVideoFullscreenPlayerWillDismiss", "onVideoFullscreenPlayerDidDismiss", "onPlaybackStalled", "onPlaybackResume", "onReadyForDisplay", "onVideoBuffer", "onVideoIdle", "onTimedMetadata", "onVideoAudioBecomingNoisy", "onAudioFocusChanged", "onPlaybackRateChange", "onVideoBandwidthUpdate"};

    /* renamed from: O000000o  reason: collision with root package name */
    int f2539O000000o = -1;
    private final RCTEventEmitter O00000o0;

    um(ReactContext reactContext) {
        this.O00000o0 = (RCTEventEmitter) reactContext.getJSModule(RCTEventEmitter.class);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(boolean z) {
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean("isBuffering", z);
        O000000o("onVideoBuffer", createMap);
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(boolean z) {
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean("hasAudioFocus", z);
        O000000o("onAudioFocusChanged", createMap);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(String str, WritableMap writableMap) {
        this.O00000o0.receiveEvent(this.f2539O000000o, str, writableMap);
    }
}

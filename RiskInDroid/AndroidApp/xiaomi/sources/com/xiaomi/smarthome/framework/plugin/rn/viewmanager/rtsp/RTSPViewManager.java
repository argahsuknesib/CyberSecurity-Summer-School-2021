package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rtsp;

import _m_j.cka;
import _m_j.cki;
import _m_j.gbj;
import _m_j.gbu;
import _m_j.gsc;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.mijia.generalplayer.ijk.IjkVideoView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;

public class RTSPViewManager extends ViewGroupManager<IjkVideoView> {
    private static int STOP_PLAY = 1;
    public static String TAG = "MHRTSPView";
    private int audioTrackIndex = -1;
    private int finalType = 0;
    public boolean isChangingTrack;
    private boolean isMute;
    public Handler mMainHandler = new Handler(Looper.getMainLooper());
    public Runnable progressRunnable = new Runnable() {
        /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rtsp.RTSPViewManager.AnonymousClass1 */
        private int O00000Oo = 0;

        public final void run() {
            if (!RTSPViewManager.this.isChangingTrack && RTSPViewManager.this.viewList != null && RTSPViewManager.this.viewList.size() > 0) {
                IjkVideoView ijkVideoView = RTSPViewManager.this.viewList.get(RTSPViewManager.this.viewList.size() - 1);
                if (ijkVideoView == null) {
                    RTSPViewManager.this.mMainHandler.removeCallbacks(RTSPViewManager.this.progressRunnable);
                } else if (ijkVideoView.getCurrentPosition() < ijkVideoView.getDuration()) {
                    WritableMap createMap = Arguments.createMap();
                    int currentPosition = ijkVideoView.getCurrentPosition() / 1000;
                    if (this.O00000Oo != currentPosition) {
                        this.O00000Oo = currentPosition;
                        createMap.putDouble("progress", (double) currentPosition);
                        String str = RTSPViewManager.TAG;
                        cki.O00000oO(str, "progress:" + ijkVideoView.getCurrentPosition());
                        ((RCTEventEmitter) RTSPViewManager.this.reactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(ijkVideoView.getId(), "onChangeProgress", createMap);
                    }
                    RTSPViewManager.this.mMainHandler.postDelayed(RTSPViewManager.this.progressRunnable, 200);
                } else if (!RTSPViewManager.this.isChangingTrack) {
                    cki.O00000oO(RTSPViewManager.TAG, "onComplete 播放完成");
                    RTSPViewManager.this.mMainHandler.removeCallbacks(RTSPViewManager.this.progressRunnable);
                    ((RCTEventEmitter) RTSPViewManager.this.reactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(ijkVideoView.getId(), "onEnd", null);
                }
            }
        }
    };
    public ReactContext reactContext;
    private int textTrackIndex = -1;
    private String url;
    private int videoTrackIndex = -1;
    public List<IjkVideoView> viewList = new ArrayList();

    public String getName() {
        return TAG;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.mijia.generalplayer.ijk.IjkVideoView.<init>(android.content.Context, byte):void
     arg types: [com.facebook.react.uimanager.ThemedReactContext, byte]
     candidates:
      com.mijia.generalplayer.ijk.IjkVideoView.<init>(android.content.Context, int):void
      com.mijia.generalplayer.ijk.IjkVideoView.<init>(android.content.Context, android.util.AttributeSet):void
      com.mijia.generalplayer.ijk.IjkVideoView.<init>(android.content.Context, byte):void */
    /* access modifiers changed from: protected */
    public IjkVideoView createViewInstance(ThemedReactContext themedReactContext) {
        this.reactContext = themedReactContext;
        IjkVideoView ijkVideoView = new IjkVideoView((Context) themedReactContext, (byte) 0);
        this.viewList.add(ijkVideoView);
        return ijkVideoView;
    }

    @ReactProp(name = "isPlay")
    public void setIsPlay(IjkVideoView ijkVideoView, boolean z) {
        this.mMainHandler.post(new Runnable(z, ijkVideoView) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rtsp.$$Lambda$RTSPViewManager$rNDbx9t7RUJpgnlmZ8snXfwRLI */
            private final /* synthetic */ boolean f$1;
            private final /* synthetic */ IjkVideoView f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                RTSPViewManager.this.lambda$setIsPlay$0$RTSPViewManager(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$setIsPlay$0$RTSPViewManager(boolean z, IjkVideoView ijkVideoView) {
        if (!TextUtils.isEmpty(this.url)) {
            String str = TAG;
            cki.O00000oO(str, "beginPlay:" + z + " url:" + this.url);
            if (z) {
                ijkVideoView.start();
                if (ijkVideoView.getDuration() != 0) {
                    this.mMainHandler.removeCallbacks(this.progressRunnable);
                    this.mMainHandler.postDelayed(this.progressRunnable, 200);
                    return;
                }
                return;
            }
            ijkVideoView.pause();
            if (ijkVideoView.getDuration() != 0) {
                this.mMainHandler.removeCallbacks(this.progressRunnable);
            }
        }
    }

    @ReactProp(name = "isMute")
    public void setIsMute(IjkVideoView ijkVideoView, boolean z) {
        this.isMute = z;
        this.mMainHandler.post(new Runnable(z, ijkVideoView) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rtsp.$$Lambda$RTSPViewManager$iE65IXHkgJkKFgZ01LFNG4LFmA */
            private final /* synthetic */ boolean f$1;
            private final /* synthetic */ IjkVideoView f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                RTSPViewManager.this.lambda$setIsMute$1$RTSPViewManager(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$setIsMute$1$RTSPViewManager(boolean z, IjkVideoView ijkVideoView) {
        if (!TextUtils.isEmpty(this.url)) {
            String str = TAG;
            cki.O00000oO(str, "beginSetMute:" + z + " url:" + this.url);
            ijkVideoView.O00000Oo(z);
        }
    }

    @ReactProp(name = "progress")
    public void setProgress(IjkVideoView ijkVideoView, int i) {
        this.mMainHandler.post(new Runnable(ijkVideoView, i) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rtsp.$$Lambda$RTSPViewManager$bfO1YgnhMMvYJx5MaPsPJgaM2o */
            private final /* synthetic */ IjkVideoView f$1;
            private final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                RTSPViewManager.this.lambda$setProgress$2$RTSPViewManager(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$setProgress$2$RTSPViewManager(IjkVideoView ijkVideoView, int i) {
        if (!TextUtils.isEmpty(this.url) && ijkVideoView.getDuration() != 0) {
            String str = TAG;
            cki.O00000oO(str, "beginSeekProgress:" + i + " url:" + this.url);
            ijkVideoView.seekTo(i * 1000);
        }
    }

    @ReactProp(name = "path")
    public void setPath(IjkVideoView ijkVideoView, String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("content")) {
            String str2 = TAG;
            cki.O00000oO(str2, "original beginSetPath:" + str + " url:" + this.url);
            str = gsc.O000000o(this.reactContext, Uri.parse(str));
        }
        this.url = str;
        this.mMainHandler.post(new Runnable(str, ijkVideoView) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rtsp.$$Lambda$RTSPViewManager$h_V1wkx0gi6VNZ_koATfJqNZFCQ */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ IjkVideoView f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                RTSPViewManager.this.lambda$setPath$3$RTSPViewManager(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$setPath$3$RTSPViewManager(String str, IjkVideoView ijkVideoView) {
        if (TextUtils.isEmpty(str)) {
            doReleaseResource(ijkVideoView);
            return;
        }
        String str2 = TAG;
        cki.O00000oO(str2, "beginSetPath:" + str + " url:" + this.url);
        ijkVideoView.setVideoPath(str);
    }

    private void doReleaseResource(IjkVideoView ijkVideoView) {
        if (ijkVideoView.getState() != 0) {
            this.mMainHandler.removeCallbacks(this.progressRunnable);
            cki.O00000oO(TAG, "onStop");
            ijkVideoView.O000000o();
            ((RCTEventEmitter) this.reactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(ijkVideoView.getId(), "onPathUnload", Arguments.createMap());
        }
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("stopPlay", Integer.valueOf(STOP_PLAY));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.facebook.react.uimanager.ViewManager.receiveCommand(android.view.View, int, com.facebook.react.bridge.ReadableArray):void
     arg types: [com.mijia.generalplayer.ijk.IjkVideoView, int, com.facebook.react.bridge.ReadableArray]
     candidates:
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rtsp.RTSPViewManager.receiveCommand(com.mijia.generalplayer.ijk.IjkVideoView, int, com.facebook.react.bridge.ReadableArray):void
      com.facebook.react.uimanager.ViewManager.receiveCommand(android.view.View, java.lang.String, com.facebook.react.bridge.ReadableArray):void
      com.facebook.react.uimanager.ViewManager.receiveCommand(android.view.View, int, com.facebook.react.bridge.ReadableArray):void */
    public void receiveCommand(IjkVideoView ijkVideoView, int i, ReadableArray readableArray) {
        super.receiveCommand((View) ijkVideoView, i, readableArray);
        if (i == STOP_PLAY) {
            this.mMainHandler.post(new Runnable(ijkVideoView) {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rtsp.$$Lambda$RTSPViewManager$de6CNWuzbhjCJ1Jg9PP90SEWp80 */
                private final /* synthetic */ IjkVideoView f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    RTSPViewManager.this.lambda$receiveCommand$4$RTSPViewManager(this.f$1);
                }
            });
        }
    }

    public /* synthetic */ void lambda$receiveCommand$4$RTSPViewManager(IjkVideoView ijkVideoView) {
        if (!TextUtils.isEmpty(this.url)) {
            String str = TAG;
            cki.O00000oO(str, "stopPlay: url:" + this.url);
            this.mMainHandler.removeCallbacks(this.progressRunnable);
            ijkVideoView.O000000o();
        }
    }

    @ReactProp(name = "selectedVideoTrack")
    public void setSelectedVideoTrack(IjkVideoView ijkVideoView, int i) {
        this.mMainHandler.post(new Runnable(i, ijkVideoView) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rtsp.$$Lambda$RTSPViewManager$GgOV1GgzlsVYkiwHvOoxs__uRsg */
            private final /* synthetic */ int f$1;
            private final /* synthetic */ IjkVideoView f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                RTSPViewManager.this.lambda$setSelectedVideoTrack$5$RTSPViewManager(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$setSelectedVideoTrack$5$RTSPViewManager(int i, IjkVideoView ijkVideoView) {
        if (!TextUtils.isEmpty(this.url)) {
            setSelectedVideoTrack(i, ijkVideoView);
        }
    }

    @ReactProp(name = "resizeMode")
    public void setResizeMode(IjkVideoView ijkVideoView, String str) {
        if (!TextUtils.isEmpty(str)) {
            int i = 0;
            if (!str.equals("none") && !str.equals("contain")) {
                if (str.equals("cover")) {
                    i = 1;
                } else if (str.equals("stretch")) {
                    i = 3;
                }
            }
            this.finalType = i;
            this.mMainHandler.post(new Runnable(ijkVideoView) {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rtsp.$$Lambda$RTSPViewManager$BFPqouZ1YsgI7r7OBJsLq2GLgy8 */
                private final /* synthetic */ IjkVideoView f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    RTSPViewManager.this.lambda$setResizeMode$6$RTSPViewManager(this.f$1);
                }
            });
        }
    }

    public /* synthetic */ void lambda$setResizeMode$6$RTSPViewManager(IjkVideoView ijkVideoView) {
        String str = TAG;
        cki.O00000oO(str, "切换 resizeMode:" + this.finalType + " url:" + this.url);
        ijkVideoView.O000000o(this.finalType);
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(IjkVideoView ijkVideoView) {
        super.onAfterUpdateTransaction((View) ijkVideoView);
        ijkVideoView.getRootView().invalidate();
        ijkVideoView.invalidate();
        gbu.O000000o("RTSPView-->onAfterUpdateTransaction...");
    }

    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        gbu.O000000o("RTSPView-->onCatalystInstanceDestroy...");
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("onPathLoad", MapBuilder.of("registrationName", "onPathLoad")).put("onChangeDuration", MapBuilder.of("registrationName", "onChangeDuration")).put("onChangeProgress", MapBuilder.of("registrationName", "onChangeProgress")).put("onPlaySuccess", MapBuilder.of("registrationName", "onPlaySuccess")).put("onPlayFail", MapBuilder.of("registrationName", "onPlayFail")).put("onEnd", MapBuilder.of("registrationName", "onEnd")).put("onPathUnload", MapBuilder.of("registrationName", "onPathUnload")).build();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.facebook.react.uimanager.ViewManager.addEventEmitters(com.facebook.react.uimanager.ThemedReactContext, android.view.View):void
     arg types: [com.facebook.react.uimanager.ThemedReactContext, com.mijia.generalplayer.ijk.IjkVideoView]
     candidates:
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rtsp.RTSPViewManager.addEventEmitters(com.facebook.react.uimanager.ThemedReactContext, com.mijia.generalplayer.ijk.IjkVideoView):void
      com.facebook.react.uimanager.ViewManager.addEventEmitters(com.facebook.react.uimanager.ThemedReactContext, android.view.View):void */
    /* access modifiers changed from: protected */
    public void addEventEmitters(ThemedReactContext themedReactContext, IjkVideoView ijkVideoView) {
        super.addEventEmitters(themedReactContext, (View) ijkVideoView);
        ijkVideoView.setOnPreparedListener(new IMediaPlayer.OnPreparedListener(ijkVideoView, themedReactContext) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rtsp.$$Lambda$RTSPViewManager$gnfnjObYfpcDsa9EOQMz5VbgzYo */
            private final /* synthetic */ IjkVideoView f$1;
            private final /* synthetic */ ThemedReactContext f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onPrepared(IMediaPlayer iMediaPlayer) {
                RTSPViewManager.this.lambda$addEventEmitters$8$RTSPViewManager(this.f$1, this.f$2, iMediaPlayer);
            }
        });
        ijkVideoView.setOnInfoListener(new IMediaPlayer.OnInfoListener(ijkVideoView, themedReactContext) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rtsp.$$Lambda$RTSPViewManager$Ko92ig1xwCk8b8BSExgLhGVHfxs */
            private final /* synthetic */ IjkVideoView f$1;
            private final /* synthetic */ ThemedReactContext f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
                return RTSPViewManager.this.lambda$addEventEmitters$9$RTSPViewManager(this.f$1, this.f$2, iMediaPlayer, i, i2);
            }
        });
        ijkVideoView.setOnErrorListener(new IMediaPlayer.OnErrorListener(themedReactContext, ijkVideoView) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rtsp.$$Lambda$RTSPViewManager$ZDc0pb03RvYjacbNEDaOSVDAWcE */
            private final /* synthetic */ ThemedReactContext f$1;
            private final /* synthetic */ IjkVideoView f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
                return RTSPViewManager.this.lambda$addEventEmitters$10$RTSPViewManager(this.f$1, this.f$2, iMediaPlayer, i, i2);
            }
        });
        ijkVideoView.setOnCompletionListener(new IMediaPlayer.OnCompletionListener(themedReactContext, ijkVideoView) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rtsp.$$Lambda$RTSPViewManager$wjIbiWo8URjjve8Wq7F0kUjP66g */
            private final /* synthetic */ ThemedReactContext f$1;
            private final /* synthetic */ IjkVideoView f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onCompletion(IMediaPlayer iMediaPlayer) {
                RTSPViewManager.this.lambda$addEventEmitters$11$RTSPViewManager(this.f$1, this.f$2, iMediaPlayer);
            }
        });
    }

    public /* synthetic */ void lambda$addEventEmitters$8$RTSPViewManager(IjkVideoView ijkVideoView, ThemedReactContext themedReactContext, IMediaPlayer iMediaPlayer) {
        if (iMediaPlayer != null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("duration", (double) (ijkVideoView.getDuration() / 1000));
            ((RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(ijkVideoView.getId(), "onChangeDuration", createMap);
            onVideoLoad(themedReactContext, ijkVideoView);
            this.mMainHandler.postDelayed(new Runnable(ijkVideoView) {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rtsp.$$Lambda$RTSPViewManager$uIJl9XtUxwhgT0zWddWapxZSk40 */
                private final /* synthetic */ IjkVideoView f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    RTSPViewManager.this.lambda$null$7$RTSPViewManager(this.f$1);
                }
            }, 500);
        }
    }

    public /* synthetic */ void lambda$null$7$RTSPViewManager(IjkVideoView ijkVideoView) {
        ijkVideoView.O000000o(this.finalType);
    }

    public /* synthetic */ boolean lambda$addEventEmitters$9$RTSPViewManager(IjkVideoView ijkVideoView, ThemedReactContext themedReactContext, IMediaPlayer iMediaPlayer, int i, int i2) {
        String str = TAG;
        cki.O00000oO(str, "onInfoGer:" + i + " url:" + this.url);
        if (i == 3) {
            ijkVideoView.O00000Oo(this.isMute);
            ((RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(ijkVideoView.getId(), "onPlaySuccess", Arguments.createMap());
            this.mMainHandler.removeCallbacks(this.progressRunnable);
            this.mMainHandler.postDelayed(this.progressRunnable, 200);
            return true;
        } else if (i != 10002) {
            return true;
        } else {
            ijkVideoView.O00000Oo(this.isMute);
            return true;
        }
    }

    public /* synthetic */ boolean lambda$addEventEmitters$10$RTSPViewManager(ThemedReactContext themedReactContext, IjkVideoView ijkVideoView, IMediaPlayer iMediaPlayer, int i, int i2) {
        String str = TAG;
        cki.O00000oO(str, "onError 播放失败" + i + i2);
        this.mMainHandler.removeCallbacks(this.progressRunnable);
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("errCode", (double) i);
        ((RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(ijkVideoView.getId(), "onPlayFail", createMap);
        return false;
    }

    public /* synthetic */ void lambda$addEventEmitters$11$RTSPViewManager(ThemedReactContext themedReactContext, IjkVideoView ijkVideoView, IMediaPlayer iMediaPlayer) {
        if (!this.isChangingTrack) {
            cki.O00000oO(TAG, "onComplete 播放完成");
            this.mMainHandler.removeCallbacks(this.progressRunnable);
            ((RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(ijkVideoView.getId(), "onEnd", null);
        }
    }

    private void onVideoLoad(ThemedReactContext themedReactContext, IjkVideoView ijkVideoView) {
        setSelectedVideoTrack(this.videoTrackIndex, ijkVideoView);
        int videoWidth = ijkVideoView.getVideoWidth();
        int videoHeight = ijkVideoView.getVideoHeight();
        WritableMap createMap = Arguments.createMap();
        double duration = (double) ijkVideoView.getDuration();
        Double.isNaN(duration);
        createMap.putDouble("duration", duration / 1000.0d);
        double currentPosition = (double) ijkVideoView.getCurrentPosition();
        Double.isNaN(currentPosition);
        createMap.putDouble("currentTime", currentPosition / 1000.0d);
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putInt("width", videoWidth);
        createMap2.putInt("height", videoHeight);
        if (videoWidth > videoHeight) {
            createMap2.putString("orientation", "landscape");
        } else {
            createMap2.putString("orientation", "portrait");
        }
        createMap.putMap("naturalSize", createMap2);
        createMap.putBoolean("isSuccess", true);
        createMap.putString("path", this.url);
        createMap.putArray("videoTracks", getVideoTrackInfo(ijkVideoView));
        createMap.putArray("audioTracks", getAudioTrackInfo(ijkVideoView));
        createMap.putArray("textTracks", getTextTrackInfo(ijkVideoView));
        String str = TAG;
        cki.O00000oO(str, "onLoad:" + gbj.O000000o(createMap.toHashMap()));
        ((RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(ijkVideoView.getId(), "onPathLoad", createMap);
    }

    private WritableArray getAudioTrackInfo(IjkVideoView ijkVideoView) {
        WritableArray createArray = Arguments.createArray();
        ITrackInfo[] trackInfo = ijkVideoView.getTrackInfo();
        if (trackInfo != null && trackInfo.length > 0) {
            for (int i = 0; i < trackInfo.length; i++) {
                ITrackInfo iTrackInfo = trackInfo[i];
                if (iTrackInfo.getTrackType() == 2) {
                    IMediaFormat format = iTrackInfo.getFormat();
                    WritableMap createMap = Arguments.createMap();
                    createMap.putInt("index", i);
                    createMap.putString("title", format.getString("title"));
                    createMap.putString("type", format.getString("type"));
                    createMap.putString("language", format.getString("language"));
                    createMap.putString("bitrate", format.getString("bitrate"));
                    createArray.pushMap(createMap);
                }
            }
        }
        return createArray;
    }

    private WritableArray getVideoTrackInfo(IjkVideoView ijkVideoView) {
        WritableArray createArray = Arguments.createArray();
        ITrackInfo[] trackInfo = ijkVideoView.getTrackInfo();
        String str = TAG;
        StringBuilder sb = new StringBuilder("trackInfos:");
        sb.append(trackInfo != null ? Integer.valueOf(trackInfo.length) : " null");
        cki.O00000oO(str, sb.toString());
        if (trackInfo != null && trackInfo.length > 0) {
            for (int i = 0; i < trackInfo.length; i++) {
                ITrackInfo iTrackInfo = trackInfo[i];
                String str2 = TAG;
                cki.O00000oO(str2, "trackInfo:" + iTrackInfo.getTrackType() + ":" + iTrackInfo.getLanguage() + ":" + iTrackInfo.getInfoInline());
                if (iTrackInfo.getTrackType() == 1) {
                    WritableMap createMap = Arguments.createMap();
                    IMediaFormat format = iTrackInfo.getFormat();
                    createMap.putInt("width", format.getInteger("width"));
                    createMap.putInt("height", format.getInteger("height"));
                    createMap.putInt("bitrate", format.getInteger("bitrate"));
                    createMap.putString("codecs", format.getString("codec_name"));
                    createMap.putInt("index", i);
                    createArray.pushMap(createMap);
                }
            }
        }
        return createArray;
    }

    private WritableArray getTextTrackInfo(IjkVideoView ijkVideoView) {
        WritableArray createArray = Arguments.createArray();
        ITrackInfo[] trackInfo = ijkVideoView.getTrackInfo();
        if (trackInfo != null && trackInfo.length > 0) {
            for (int i = 0; i < trackInfo.length; i++) {
                ITrackInfo iTrackInfo = trackInfo[i];
                if (iTrackInfo.getTrackType() == 3) {
                    WritableMap createMap = Arguments.createMap();
                    IMediaFormat format = iTrackInfo.getFormat();
                    createMap.putInt("index", i);
                    createMap.putString("title", format.getString("id"));
                    createMap.putString("type", format.getString("sampleMimeType"));
                    createMap.putString("language", format.getString("language"));
                    createArray.pushMap(createMap);
                }
            }
        }
        return createArray;
    }

    public void setSelectedVideoTrack(int i, IjkVideoView ijkVideoView) {
        ITrackInfo[] trackInfo;
        int i2;
        if (i >= 0 && (trackInfo = ijkVideoView.getTrackInfo()) != null && trackInfo.length > 0) {
            boolean z = false;
            int i3 = 0;
            while (true) {
                if (i3 < trackInfo.length) {
                    if (trackInfo[i3].getTrackType() == 1 && i == i3) {
                        z = true;
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            if (z) {
                IjkMediaPlayer O000000o2 = cka.O000000o(ijkVideoView.O00000oO);
                if (O000000o2 == null) {
                    i2 = -1;
                } else {
                    i2 = O000000o2.getSelectedTrack(1);
                }
                this.videoTrackIndex = i2;
                if (this.videoTrackIndex != i) {
                    int currentPosition = ijkVideoView.getCurrentPosition();
                    ijkVideoView.seekTo(ijkVideoView.getDuration());
                    boolean isPlaying = ijkVideoView.isPlaying();
                    this.isChangingTrack = true;
                    this.mMainHandler.removeCallbacks(this.progressRunnable);
                    String str = TAG;
                    cki.O00000oO(str, "selectTrack:" + i + " url:" + this.url);
                    int i4 = this.videoTrackIndex;
                    IjkMediaPlayer O000000o3 = cka.O000000o(ijkVideoView.O00000oO);
                    if (O000000o3 != null) {
                        O000000o3.deselectTrack(i4);
                    }
                    this.videoTrackIndex = i;
                    if (ijkVideoView.O00000oO != null) {
                        ((IjkMediaPlayer) ijkVideoView.O00000oO).selectTrack(i);
                    }
                    this.mMainHandler.postDelayed(new Runnable(isPlaying, ijkVideoView, currentPosition) {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rtsp.$$Lambda$RTSPViewManager$eIibMkyKGOJx9zhZ81DSKieTriM */
                        private final /* synthetic */ boolean f$1;
                        private final /* synthetic */ IjkVideoView f$2;
                        private final /* synthetic */ int f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final void run() {
                            RTSPViewManager.this.lambda$setSelectedVideoTrack$13$RTSPViewManager(this.f$1, this.f$2, this.f$3);
                        }
                    }, 500);
                }
            }
        }
    }

    public /* synthetic */ void lambda$setSelectedVideoTrack$13$RTSPViewManager(boolean z, IjkVideoView ijkVideoView, int i) {
        if (z) {
            ijkVideoView.start();
            this.mMainHandler.postDelayed(new Runnable(ijkVideoView, i) {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rtsp.$$Lambda$RTSPViewManager$9I8PK_nbGOreOzFzwC9TZVcOPEw */
                private final /* synthetic */ IjkVideoView f$1;
                private final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    RTSPViewManager.this.lambda$null$12$RTSPViewManager(this.f$1, this.f$2);
                }
            }, 300);
        } else {
            ijkVideoView.seekTo(i);
            this.mMainHandler.removeCallbacks(this.progressRunnable);
            this.mMainHandler.post(this.progressRunnable);
        }
        this.isChangingTrack = false;
    }

    public /* synthetic */ void lambda$null$12$RTSPViewManager(IjkVideoView ijkVideoView, int i) {
        ijkVideoView.seekTo(i);
        this.mMainHandler.removeCallbacks(this.progressRunnable);
        this.mMainHandler.post(this.progressRunnable);
    }

    public void onDropViewInstance(IjkVideoView ijkVideoView) {
        super.onDropViewInstance((View) ijkVideoView);
        this.mMainHandler.removeCallbacks(this.progressRunnable);
        cki.O00000oO(TAG, "onStop");
        this.viewList.remove(ijkVideoView);
        ijkVideoView.O000000o();
    }
}

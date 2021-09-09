package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui;

import _m_j.hmq;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.hs.hyfisheyepano.OnPlayProgressListener;
import com.hs.hyfisheyepano.OnPlayStateListener;
import com.hs.hyfisheyepano.OnRenderListener;
import com.hs.hyfisheyepano.OnScreenshotListener;
import com.xiaovv.player.HSVideoView;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

public class HSVideoViewManager extends ViewGroupManager<HSVideoView> {
    public ReactContext mContext;
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());

    public String getName() {
        return "RCTHSVideoView";
    }

    /* access modifiers changed from: protected */
    public HSVideoView createViewInstance(ThemedReactContext themedReactContext) {
        this.mContext = themedReactContext;
        return new HSVideoView(themedReactContext);
    }

    public void onDropViewInstance(HSVideoView hSVideoView) {
        super.onDropViewInstance((View) hSVideoView);
        hSVideoView.O0000Oo();
    }

    @ReactProp(name = "externalParams")
    public void setExternalParams(HSVideoView hSVideoView, ReadableMap readableMap) {
        if (readableMap != null) {
            hSVideoView.setExternalParams(readableMap.toHashMap());
        }
    }

    public /* synthetic */ void lambda$receiveCommand$2$HSVideoViewManager(final HSVideoView hSVideoView, int i, String str) {
        AnonymousClass1 r5 = new OnScreenshotListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.HSVideoViewManager.AnonymousClass1 */

            public final void onScreenshot(String str, boolean z) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("path", str);
                createMap.putBoolean("succeed", z);
                ((RCTEventEmitter) HSVideoViewManager.this.mContext.getJSModule(RCTEventEmitter.class)).receiveEvent(hSVideoView.getId(), "onScreenshot", createMap);
            }
        };
        Bitmap O00000o0 = hSVideoView.O00000o0();
        if (O00000o0 == null) {
            r5.onScreenshot(str, false);
        } else {
            new Thread(new Runnable(str, O00000o0, i, r5) {
                /* class com.xiaovv.player.HSVideoView.AnonymousClass7 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ String f12134O000000o;
                final /* synthetic */ Bitmap O00000Oo;
                final /* synthetic */ OnScreenshotListener O00000o;
                final /* synthetic */ int O00000o0;

                {
                    this.f12134O000000o = r2;
                    this.O00000Oo = r3;
                    this.O00000o0 = r4;
                    this.O00000o = r5;
                }

                /* JADX WARNING: Removed duplicated region for block: B:21:0x0041 A[Catch:{ all -> 0x0056 }] */
                /* JADX WARNING: Removed duplicated region for block: B:23:0x004d A[SYNTHETIC, Splitter:B:23:0x004d] */
                /* JADX WARNING: Removed duplicated region for block: B:30:0x0059 A[SYNTHETIC, Splitter:B:30:0x0059] */
                /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
                public final void run() {
                    FileOutputStream fileOutputStream;
                    Exception e;
                    try {
                        fileOutputStream = new FileOutputStream(new File(this.f12134O000000o));
                        try {
                            final boolean compress = this.O00000Oo.compress(Bitmap.CompressFormat.JPEG, this.O00000o0, fileOutputStream);
                            fileOutputStream.flush();
                            if (this.O00000o != null) {
                                HSVideoView.this.post(new Runnable() {
                                    /* class com.xiaovv.player.HSVideoView.AnonymousClass7.AnonymousClass1 */

                                    public final void run() {
                                        AnonymousClass7.this.O00000o.onScreenshot(AnonymousClass7.this.f12134O000000o, compress);
                                    }
                                });
                            }
                            try {
                                fileOutputStream.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            try {
                                e.printStackTrace();
                                if (this.O00000o != null) {
                                    HSVideoView.this.post(new Runnable() {
                                        /* class com.xiaovv.player.HSVideoView.AnonymousClass7.AnonymousClass2 */

                                        public final void run() {
                                            AnonymousClass7.this.O00000o.onScreenshot(AnonymousClass7.this.f12134O000000o, false);
                                        }
                                    });
                                }
                                if (fileOutputStream == null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e6) {
                        fileOutputStream = null;
                        e = e6;
                        e.printStackTrace();
                        if (this.O00000o != null) {
                        }
                        if (fileOutputStream == null) {
                        }
                    } catch (Throwable th2) {
                        fileOutputStream = null;
                        th = th2;
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                }
            }).start();
        }
    }

    public void receiveCommand(HSVideoView hSVideoView, int i, ReadableArray readableArray) {
        switch (i) {
            case 101:
                if (readableArray != null && readableArray.toArrayList().size() > 0) {
                    this.mMainHandler.post(new Runnable(readableArray.getInt(0)) {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.$$Lambda$HSVideoViewManager$YDXW_7KSPcfwi53Q5YD7fKvRgY4 */
                        private final /* synthetic */ int f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            HSVideoViewManager.lambda$receiveCommand$0(HSVideoView.this, this.f$1);
                        }
                    });
                    return;
                }
                return;
            case 102:
                this.mMainHandler.post(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.$$Lambda$HSVideoViewManager$Mymu95n8jKgvsN1nFoGLOs6fz0 */

                    public final void run() {
                        HSVideoView.this.O0000Oo();
                    }
                });
                return;
            case 103:
                if (readableArray != null && readableArray.toArrayList().size() > 1) {
                    this.mMainHandler.post(new Runnable(hSVideoView, readableArray.getInt(0), readableArray.getString(1)) {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.$$Lambda$HSVideoViewManager$NfD0fSp7ws6yLVagxYpNS9234A */
                        private final /* synthetic */ HSVideoView f$1;
                        private final /* synthetic */ int f$2;
                        private final /* synthetic */ String f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final void run() {
                            HSVideoViewManager.this.lambda$receiveCommand$2$HSVideoViewManager(this.f$1, this.f$2, this.f$3);
                        }
                    });
                    return;
                }
                return;
            case 104:
                this.mMainHandler.post(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.$$Lambda$HSVideoViewManager$zE4VMyi2NWFc8ydhY43kRx_jTD0 */

                    public final void run() {
                        HSVideoView.this.O00000Oo();
                    }
                });
                return;
            case 105:
                this.mMainHandler.post(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.$$Lambda$HSVideoViewManager$SqQR07GbzOF2XRmkabJK45vSoGE */

                    public final void run() {
                        HSVideoView.this.O000000o();
                    }
                });
                return;
            default:
                return;
        }
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.builder().put("seekTo", 101).put("release", 102).put("screenshot", 103).put("cleanSurface", 104).put("resetZoomScale", 105).build();
    }

    @ReactProp(name = "camParams")
    public void setCamParams(HSVideoView hSVideoView, ReadableMap readableMap) {
        this.mMainHandler.post(new Runnable(hSVideoView) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.$$Lambda$HSVideoViewManager$lgvgQ3KRWC_gW2pHYcKPWHcFV8Q */
            private final /* synthetic */ HSVideoView f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                HSVideoViewManager.lambda$setCamParams$5(ReadableMap.this, this.f$1);
            }
        });
    }

    static /* synthetic */ void lambda$setCamParams$5(ReadableMap readableMap, HSVideoView hSVideoView) {
        if (readableMap != null) {
            int i = 0;
            int i2 = readableMap.hasKey("camType") ? readableMap.getInt("camType") : 0;
            int i3 = readableMap.hasKey("panoX") ? readableMap.getInt("panoX") : 0;
            int i4 = readableMap.hasKey("panoY") ? readableMap.getInt("panoY") : 0;
            if (readableMap.hasKey("panoR")) {
                i = readableMap.getInt("panoR");
            }
            hSVideoView.O000000o(i2, i3, i4, i);
        }
    }

    @ReactProp(name = "fixType")
    public void setFixType(HSVideoView hSVideoView, int i) {
        this.mMainHandler.post(new Runnable(i) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.$$Lambda$HSVideoViewManager$PqM54XnhG5bMo4ZmNx0aMugxoH0 */
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                HSVideoView.this.setFixType(this.f$1);
            }
        });
    }

    @ReactProp(name = "displayMode")
    public void setDisplayMode(HSVideoView hSVideoView, int i) {
        this.mMainHandler.post(new Runnable(i) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.$$Lambda$HSVideoViewManager$MHL4JemulxNir7nFrD2Omz45zUU */
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                HSVideoView.this.setMode(this.f$1);
            }
        });
    }

    @ReactProp(name = "source")
    public void setPath(HSVideoView hSVideoView, String str) {
        this.mMainHandler.post(new Runnable(str) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.$$Lambda$HSVideoViewManager$oiSuS8ytrgk_MVYKrjus0ySZ8w */
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                HSVideoView.this.setPath(this.f$1);
            }
        });
    }

    @ReactProp(name = "isPlaying")
    public void setPlaying(HSVideoView hSVideoView, boolean z) {
        this.mMainHandler.post(new Runnable(z, hSVideoView) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.$$Lambda$HSVideoViewManager$NrzvTT3nyMWc6pwfuw_Iy4P_aWQ */
            private final /* synthetic */ boolean f$0;
            private final /* synthetic */ HSVideoView f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                HSVideoViewManager.lambda$setPlaying$9(this.f$0, this.f$1);
            }
        });
    }

    static /* synthetic */ void lambda$setPlaying$9(boolean z, HSVideoView hSVideoView) {
        if (z) {
            hSVideoView.O00000o();
        } else {
            hSVideoView.O0000O0o();
        }
    }

    @ReactProp(name = "paused")
    public void pausePlayer(HSVideoView hSVideoView, boolean z) {
        this.mMainHandler.post(new Runnable(z, hSVideoView) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.$$Lambda$HSVideoViewManager$Q15qceucB1YijctXKsqPYA8UMc */
            private final /* synthetic */ boolean f$0;
            private final /* synthetic */ HSVideoView f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                HSVideoViewManager.lambda$pausePlayer$10(this.f$0, this.f$1);
            }
        });
    }

    static /* synthetic */ void lambda$pausePlayer$10(boolean z, HSVideoView hSVideoView) {
        if (z) {
            hSVideoView.O00000oO();
        } else {
            hSVideoView.O00000oo();
        }
    }

    @ReactProp(name = "muted")
    public void setMuted(HSVideoView hSVideoView, boolean z) {
        this.mMainHandler.post(new Runnable(z, hSVideoView) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.$$Lambda$HSVideoViewManager$cEdbsYNssGhClIFZq06wzB99Xr8 */
            private final /* synthetic */ boolean f$0;
            private final /* synthetic */ HSVideoView f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                HSVideoViewManager.lambda$setMuted$11(this.f$0, this.f$1);
            }
        });
    }

    static /* synthetic */ void lambda$setMuted$11(boolean z, HSVideoView hSVideoView) {
        if (z) {
            hSVideoView.O0000Oo0();
        } else {
            hSVideoView.O0000OOo();
        }
    }

    @ReactProp(name = "isScaleZoom")
    public void setScaleZoom(HSVideoView hSVideoView, boolean z) {
        this.mMainHandler.post(new Runnable(z) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.$$Lambda$HSVideoViewManager$ONhleXfBHl1EvNQykJhRQrwX2oE */
            private final /* synthetic */ boolean f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                HSVideoView.this.setScaleZoom(this.f$1);
            }
        });
    }

    @ReactProp(name = "fullscreenState")
    public void setFullscreen(HSVideoView hSVideoView, boolean z) {
        hmq.O00000o0().onFullScreen(z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.facebook.react.uimanager.ViewManager.addEventEmitters(com.facebook.react.uimanager.ThemedReactContext, android.view.View):void
     arg types: [com.facebook.react.uimanager.ThemedReactContext, com.xiaovv.player.HSVideoView]
     candidates:
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.HSVideoViewManager.addEventEmitters(com.facebook.react.uimanager.ThemedReactContext, com.xiaovv.player.HSVideoView):void
      com.facebook.react.uimanager.ViewManager.addEventEmitters(com.facebook.react.uimanager.ThemedReactContext, android.view.View):void */
    /* access modifiers changed from: protected */
    public void addEventEmitters(ThemedReactContext themedReactContext, final HSVideoView hSVideoView) {
        super.addEventEmitters(themedReactContext, (View) hSVideoView);
        hSVideoView.setOnVideoViewListener(new HSVideoView.O000000o(hSVideoView) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.$$Lambda$HSVideoViewManager$7D5JQ6_p9iPwe8YM2XwZM0Mm5t8 */
            private final /* synthetic */ HSVideoView f$1;

            {
                this.f$1 = r2;
            }

            public final void onVideoViewClick() {
                HSVideoViewManager.this.lambda$addEventEmitters$13$HSVideoViewManager(this.f$1);
            }
        });
        hSVideoView.setOnPlayProgressListener(new OnPlayProgressListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.HSVideoViewManager.AnonymousClass2 */

            public final void onProgress(int i, int i2) {
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("position", i);
                createMap.putInt("duration", i2);
                ((RCTEventEmitter) HSVideoViewManager.this.mContext.getJSModule(RCTEventEmitter.class)).receiveEvent(hSVideoView.getId(), "onProgress", createMap);
            }

            public final void onTimestamp(long j) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("timestamp", String.valueOf(j));
                ((RCTEventEmitter) HSVideoViewManager.this.mContext.getJSModule(RCTEventEmitter.class)).receiveEvent(hSVideoView.getId(), "onTimestamp", createMap);
            }
        });
        hSVideoView.setOnRenderListener(new OnRenderListener(hSVideoView) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.$$Lambda$HSVideoViewManager$hN7FRIVETEK8lKPdCUJbJN7TQ4 */
            private final /* synthetic */ HSVideoView f$1;

            {
                this.f$1 = r2;
            }

            public final void onRender(int i, int i2) {
                HSVideoViewManager.this.lambda$addEventEmitters$14$HSVideoViewManager(this.f$1, i, i2);
            }
        });
        hSVideoView.setOnPlayStateListener(new OnPlayStateListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.HSVideoViewManager.AnonymousClass3 */

            public final void onTime(int i, long j) {
            }

            public final void onCompleted(int i, int i2) {
                ((RCTEventEmitter) HSVideoViewManager.this.mContext.getJSModule(RCTEventEmitter.class)).receiveEvent(hSVideoView.getId(), "onCompleted", Arguments.createMap());
            }

            public final void onError(int i) {
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("errorCode", -1);
                ((RCTEventEmitter) HSVideoViewManager.this.mContext.getJSModule(RCTEventEmitter.class)).receiveEvent(hSVideoView.getId(), "onError", createMap);
            }
        });
    }

    public /* synthetic */ void lambda$addEventEmitters$13$HSVideoViewManager(HSVideoView hSVideoView) {
        ((RCTEventEmitter) this.mContext.getJSModule(RCTEventEmitter.class)).receiveEvent(hSVideoView.getId(), "onVideoViewClick", Arguments.createMap());
    }

    public /* synthetic */ void lambda$addEventEmitters$14$HSVideoViewManager(HSVideoView hSVideoView, int i, int i2) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("width", i);
        createMap.putInt("height", i2);
        ((RCTEventEmitter) this.mContext.getJSModule(RCTEventEmitter.class)).receiveEvent(hSVideoView.getId(), "onRender", createMap);
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("onVideoViewClick", MapBuilder.of("registrationName", "onVideoViewClick")).put("onProgress", MapBuilder.of("registrationName", "onProgress")).put("onTimestamp", MapBuilder.of("registrationName", "onTimestamp")).put("onRender", MapBuilder.of("registrationName", "onRender")).put("onCompleted", MapBuilder.of("registrationName", "onCompleted")).put("onScreenshot", MapBuilder.of("registrationName", "onScreenshot")).put("onError", MapBuilder.of("registrationName", "onError")).build();
    }

    static /* synthetic */ void lambda$receiveCommand$0(HSVideoView hSVideoView, int i) {
        if (hSVideoView.O0000OOo != null && hSVideoView.O0000Ooo != 0) {
            hSVideoView.O0000OOo.seekTo(i);
        }
    }
}

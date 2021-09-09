package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui;

import _m_j.cki;
import _m_j.ckj;
import _m_j.gbu;
import _m_j.gce;
import _m_j.gcf;
import _m_j.gcg;
import _m_j.gcn;
import _m_j.gqb;
import _m_j.gsy;
import _m_j.hmq;
import _m_j.ihs;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaovv.player.HSMediaPlayer;
import com.xiaovv.player.HSVideoView;
import java.util.HashMap;
import java.util.Map;

public class RNCameraViewManager extends ViewGroupManager<AbsRNVideoView> {
    Handler mMainHandler = new Handler(Looper.getMainLooper());
    public gcn mVideoParams;
    private boolean useLenCorrent = false;

    public String getName() {
        return "MHCameraOpenGLView";
    }

    /* access modifiers changed from: protected */
    public AbsRNVideoView createViewInstance(ThemedReactContext themedReactContext) {
        AbsRNVideoView O000000o2 = gce.O000000o(themedReactContext);
        this.mVideoParams = new gcn();
        O000000o2.setVideoParams(this.mVideoParams);
        return O000000o2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.facebook.react.uimanager.BaseViewManager.setTransform(android.view.View, com.facebook.react.bridge.ReadableArray):void
     arg types: [com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.AbsRNVideoView, com.facebook.react.bridge.ReadableArray]
     candidates:
      com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.RNCameraViewManager.setTransform(com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.AbsRNVideoView, com.facebook.react.bridge.ReadableArray):void
      com.facebook.react.uimanager.BaseViewManager.setTransform(android.view.View, com.facebook.react.bridge.ReadableArray):void */
    @ReactProp(name = "transform")
    public void setTransform(AbsRNVideoView absRNVideoView, ReadableArray readableArray) {
        super.setTransform((View) absRNVideoView, readableArray);
        gsy.O000000o(4, "RNCameraViewManager", "setTransform: ".concat(String.valueOf(readableArray)));
        if (readableArray != null) {
            for (int i = 0; i < readableArray.size(); i++) {
                ReadableMap map = readableArray.getMap(i);
                if (map.hasKey("rotate")) {
                    try {
                        String string = map.getString("rotate");
                        if (string.endsWith("deg")) {
                            int parseInt = Integer.parseInt(string.replace("deg", ""));
                            gsy.O000000o(4, "RNCameraViewManager", "parsed rotate: ".concat(String.valueOf(parseInt)));
                            absRNVideoView.setRotation((float) parseInt);
                        }
                    } catch (Exception e) {
                        gsy.O000000o(6, "RNCameraViewManager", "error in parse rotate value: " + e.getMessage());
                    }
                }
            }
        }
    }

    @ReactProp(name = "did")
    public void setDid(AbsRNVideoView absRNVideoView, String str) {
        absRNVideoView.setDid(str);
    }

    @ReactProp(name = "videoCodec")
    public void setVideoCodec(AbsRNVideoView absRNVideoView, int i) {
        if (i == 4) {
            this.mVideoParams.f17540O000000o = 1;
        } else {
            this.mVideoParams.f17540O000000o = 2;
        }
        if (absRNVideoView instanceof RNInternalVideoView) {
            ((RNInternalVideoView) absRNVideoView).O00000oo();
        }
    }

    @ReactProp(name = "correctRadius")
    public void setCorrectRadius(AbsRNVideoView absRNVideoView, float f) {
        if (absRNVideoView instanceof RNInternalVideoView) {
            ((RNInternalVideoView) absRNVideoView).setCorrectRadius(f);
        }
    }

    @ReactProp(name = "osdx")
    public void setOsdx(AbsRNVideoView absRNVideoView, float f) {
        if (absRNVideoView instanceof RNInternalVideoView) {
            ((RNInternalVideoView) absRNVideoView).setOsdx(f);
        }
    }

    @ReactProp(name = "osdy")
    public void setOsdy(AbsRNVideoView absRNVideoView, float f) {
        if (absRNVideoView instanceof RNInternalVideoView) {
            ((RNInternalVideoView) absRNVideoView).setOsdy(f);
        }
    }

    @ReactProp(name = "scale")
    public void setScale(AbsRNVideoView absRNVideoView, float f) {
        if (absRNVideoView instanceof RNInternalVideoView) {
            ((RNInternalVideoView) absRNVideoView).setScale(f);
        }
    }

    @ReactProp(name = "fullscreenState")
    public void setFullscreenState(AbsRNVideoView absRNVideoView, boolean z) {
        if (absRNVideoView instanceof RNInternalVideoView) {
            ((RNInternalVideoView) absRNVideoView).setFullscreenState(z);
        }
        hmq.O00000o0().onFullScreen(z);
    }

    @ReactProp(name = "isFull")
    public void setIsFull(AbsRNVideoView absRNVideoView, boolean z) {
        if (absRNVideoView instanceof RNInternalVideoView) {
            ((RNInternalVideoView) absRNVideoView).setIsFullExpand(z);
        }
    }

    @ReactProp(name = "whiteBackground")
    public void setWhiteBackground(AbsRNVideoView absRNVideoView, boolean z) {
        if (absRNVideoView instanceof RNInternalVideoView) {
            ((RNInternalVideoView) absRNVideoView).setWhiteBackground(z);
        }
    }

    @ReactProp(name = "audioCodec")
    public void setAudioCodec(AbsRNVideoView absRNVideoView, int i) {
        this.mVideoParams.O00000o0 = i;
    }

    @ReactProp(name = "audioRecordSampleRate")
    public void setAudioRecordSampleRate(AbsRNVideoView absRNVideoView, int i) {
        this.mVideoParams.O00000o = i;
    }

    @ReactProp(name = "audioRecordChannel")
    public void setAudioRecordChannel(AbsRNVideoView absRNVideoView, int i) {
        this.mVideoParams.O00000oO = i;
    }

    @ReactProp(name = "audioRecordCodec")
    public void setAudioRecordCodec(AbsRNVideoView absRNVideoView, int i) {
        this.mVideoParams.O0000OOo = i;
    }

    @ReactProp(name = "forceSoftDecode")
    public void setForceSoftDecode(AbsRNVideoView absRNVideoView, boolean z) {
        this.mVideoParams.O0000O0o = z;
    }

    @ReactProp(name = "audioRecordDataBits")
    public void setAudioRecordDataBits(AbsRNVideoView absRNVideoView, int i) {
        this.mVideoParams.O00000oo = i;
    }

    @ReactProp(name = "useLenCorrent")
    public void setUseLenCorrent(AbsRNVideoView absRNVideoView, boolean z) {
        gcg gcg;
        this.useLenCorrent = z;
        if (absRNVideoView instanceof RNInternalVideoView) {
            String did = ((RNInternalVideoView) absRNVideoView).getDid();
            if (!TextUtils.isEmpty(did) && XmPluginHostApi.instance().getDeviceByDid(did) != null && (gcg = gcf.O000000o().f17513O000000o.get(did)) != null) {
                gcg.O000000o(z);
            }
        }
    }

    @ReactProp(name = "recordingVideoParam")
    public void setRecordingVideoParam(AbsRNVideoView absRNVideoView, ReadableMap readableMap) {
        int i;
        int i2;
        if (readableMap != null) {
            int i3 = 0;
            if (!readableMap.hasKey("width") || !readableMap.hasKey("height")) {
                i2 = 0;
                i = 0;
            } else {
                i2 = readableMap.getInt("width");
                i = readableMap.getInt("height");
                if (readableMap.hasKey("fps")) {
                    i3 = readableMap.getInt("fps");
                }
            }
            if (i2 > 0 && i > 0) {
                absRNVideoView.O00000Oo = i2;
                absRNVideoView.O00000o0 = i;
                absRNVideoView.O00000o = i3;
            }
        }
    }

    @ReactProp(name = "externalParams")
    public void setExternalParams(AbsRNVideoView absRNVideoView, ReadableMap readableMap) {
        if (readableMap != null) {
            absRNVideoView.setExternalParams(readableMap.toHashMap());
        }
    }

    @ReactProp(name = "panoParams")
    public void writePanoParams(AbsRNVideoView absRNVideoView, ReadableMap readableMap) {
        AbsRNVideoView absRNVideoView2 = absRNVideoView;
        if (readableMap != null && (absRNVideoView2 instanceof RNHSVideoView)) {
            RNHSVideoView rNHSVideoView = (RNHSVideoView) absRNVideoView2;
            HashMap<String, Object> hashMap = readableMap.toHashMap();
            if (rNHSVideoView.O0000O0o != null) {
                HSVideoView hSVideoView = rNHSVideoView.O0000O0o;
                if (hashMap != null) {
                    double d = -1.0d;
                    long j = 0;
                    String str = null;
                    if (hashMap.containsKey("source")) {
                        str = (String) hashMap.get("source");
                    }
                    if (hashMap.containsKey("camType")) {
                        d = ((Double) hashMap.get("camType")).doubleValue();
                    }
                    double d2 = 0.0d;
                    double doubleValue = hashMap.containsKey("panoX") ? ((Double) hashMap.get("panoX")).doubleValue() : 0.0d;
                    double doubleValue2 = hashMap.containsKey("panoY") ? ((Double) hashMap.get("panoY")).doubleValue() : 0.0d;
                    if (hashMap.containsKey("panoR")) {
                        d2 = ((Double) hashMap.get("panoR")).doubleValue();
                    }
                    if (hashMap.containsKey("timestamp")) {
                        j = Long.parseLong((String) hashMap.get("timestamp"));
                    }
                    long j2 = j;
                    if (str != null) {
                        if (str.startsWith("content")) {
                            str = HSVideoView.O000000o(hSVideoView.f12121O000000o, Uri.parse(str));
                        }
                        String str2 = str;
                        ihs.O000000o("HSVideoView", "writePanoParams: path = ".concat(String.valueOf(str2)));
                        HSMediaPlayer.writePanoParams(str2, (int) d, (int) doubleValue, (int) doubleValue2, (int) d2, j2);
                    }
                }
            }
        }
    }

    @ReactProp(name = "playRate")
    public void setPlayRate(AbsRNVideoView absRNVideoView, int i) {
        this.mVideoParams.O00000Oo = i;
        if (absRNVideoView instanceof RNInternalVideoView) {
            ((RNInternalVideoView) absRNVideoView).O000000o();
        }
    }

    @ReactProp(name = "maximumZoomScale")
    public void setMaximumZoomScale(AbsRNVideoView absRNVideoView, float f) {
        if (absRNVideoView instanceof RNInternalVideoView) {
            ((RNInternalVideoView) absRNVideoView).setMaxScale(f);
        }
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("startRender", 1, "stopRender", 3, "startAudioPlay", 4, "stopAudioPlay", 5, "startAudioRecord", 6, "stopAudioRecord", 7, "hidesSurfaceView", 8);
    }

    public void receiveCommand(final AbsRNVideoView absRNVideoView, final int i, ReadableArray readableArray) {
        gbu.O000000o("commandId=".concat(String.valueOf(i)));
        final String did = absRNVideoView.getDid();
        if (!TextUtils.isEmpty(did)) {
            this.mMainHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.RNCameraViewManager.AnonymousClass1 */

                public final void run() {
                    View remove;
                    int i = i;
                    if (i == 1) {
                        RNCameraViewManager.this.startRender(did, absRNVideoView);
                    } else if (i == 2) {
                    } else {
                        if (i == 3) {
                            RNCameraViewManager.this.stopRender(did, absRNVideoView);
                        } else if (i == 4) {
                            gcg gcg = gcf.O000000o().f17513O000000o.get(did);
                            if (gcg != null) {
                                gcg.O000000o();
                            }
                        } else if (i == 5) {
                            gcg gcg2 = gcf.O000000o().f17513O000000o.get(did);
                            if (gcg2 != null) {
                                gcg2.O00000Oo();
                            }
                        } else if (i == 6) {
                            gcn gcn = absRNVideoView.O00000oO;
                            int i2 = gcn.O0000OOo == 0 ? gcn.O00000o0 : gcn.O0000OOo;
                            int i3 = gcn.O00000oo;
                            int i4 = gcn.O00000oO;
                            int i5 = gcn.O00000o;
                            gcg gcg3 = gcf.O000000o().f17513O000000o.get(did);
                            if (gcg3 != null) {
                                gcg3.O000000o(i5, i3, i4, i2);
                            }
                        } else if (i == 7) {
                            gcg gcg4 = gcf.O000000o().f17513O000000o.get(did);
                            if (gcg4 != null) {
                                gcg4.O00000o0();
                            }
                        } else if (i == 8) {
                            gcf O000000o2 = gcf.O000000o();
                            String str = did;
                            if (!gqb.O000000o(str) && (remove = O000000o2.O00000Oo.remove(str)) != null && (remove instanceof AbsRNVideoView)) {
                                ((AbsRNVideoView) remove).O00000o();
                            }
                        }
                    }
                }
            });
        }
    }

    public void stopRender(String str, AbsRNVideoView absRNVideoView) {
        absRNVideoView.O00000Oo();
        gcg gcg = gcf.O000000o().f17513O000000o.get(str);
        if (gcg != null) {
            gcg.O0000OoO();
        }
        ckj.O000000o().O00000Oo("RNCameraViewManager", "FIRST_RENDER:");
    }

    public void startRender(String str, AbsRNVideoView absRNVideoView) {
        gcf O000000o2 = gcf.O000000o();
        View view = absRNVideoView.getView();
        boolean z = this.useLenCorrent;
        if (!gqb.O000000o(str) && view != null) {
            O000000o2.O00000Oo.put(str, view);
            gcg gcg = O000000o2.f17513O000000o.get(str);
            if (gcg != null) {
                if (view instanceof RNInternalVideoView) {
                    ((RNInternalVideoView) view).O000000o(gcg);
                }
                gcg.O000000o(z);
            }
        }
        absRNVideoView.O00000o0();
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("onVideoClick", MapBuilder.of("registrationName", "onVideoClick")).put("onScaleChanged", MapBuilder.of("registrationName", "onScaleChanged")).put("onPTZDirectionCtr", MapBuilder.of("registrationName", "onPTZDirectionCtr")).build();
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(final ThemedReactContext themedReactContext, final AbsRNVideoView absRNVideoView) {
        absRNVideoView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.RNCameraViewManager.AnonymousClass2 */

            public final void onClick(View view) {
                ((RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(absRNVideoView.getId(), "onVideoClick", Arguments.createMap());
            }
        });
        absRNVideoView.setOnScaleListener(new XmVideoViewGl.OnScaleListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.RNCameraViewManager.AnonymousClass3 */

            public final void onScaleChage(float f) {
                WritableMap createMap = Arguments.createMap();
                createMap.putDouble("scale", (double) f);
                ((RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(absRNVideoView.getId(), "onScaleChanged", createMap);
            }

            public final void onFirstVideoShow() {
                WritableMap createMap = Arguments.createMap();
                createMap.putBoolean("firstVideoFrame", true);
                ((RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(absRNVideoView.getId(), "onScaleChanged", createMap);
            }
        });
        absRNVideoView.setDirectionCtrlListener(new XmVideoViewGl.OnDirectionCtrlListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.camera.ui.RNCameraViewManager.AnonymousClass4 */

            public final void onClickPTZDirection(int i) {
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("direction", i);
                ((RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(absRNVideoView.getId(), "onPTZDirectionCtr", createMap);
            }
        });
    }

    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
    }

    public void onDropViewInstance(AbsRNVideoView absRNVideoView) {
        super.onDropViewInstance((View) absRNVideoView);
        absRNVideoView.O00000oO();
        cki.O00000o("RNCameraViewManager", "onDropViewInstance");
    }
}

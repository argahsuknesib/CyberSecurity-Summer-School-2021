package com.brentvatne.exoplayer;

import _m_j.ul;
import _m_j.um;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import java.util.HashMap;
import java.util.Map;

public class ReactExoplayerViewManager extends ViewGroupManager<ul> {
    public String getName() {
        return "RCTVideo";
    }

    /* access modifiers changed from: protected */
    public ul createViewInstance(ThemedReactContext themedReactContext) {
        return new ul(themedReactContext);
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        MapBuilder.Builder builder = MapBuilder.builder();
        for (String str : um.O00000Oo) {
            builder.put(str, MapBuilder.of("registrationName", str));
        }
        return builder.build();
    }

    public Map<String, Object> getExportedViewConstants() {
        return MapBuilder.of("ScaleNone", Integer.toString(0), "ScaleAspectFit", Integer.toString(0), "ScaleToFill", Integer.toString(3), "ScaleAspectFill", Integer.toString(4));
    }

    @ReactProp(name = "src")
    public void setSrc(ul ulVar, ReadableMap readableMap) {
        Uri buildRawResourceUri;
        Context applicationContext = ulVar.getContext().getApplicationContext();
        Map<String, String> map = null;
        String string = readableMap.hasKey("uri") ? readableMap.getString("uri") : null;
        String string2 = readableMap.hasKey("type") ? readableMap.getString("type") : null;
        if (readableMap.hasKey("requestHeaders")) {
            map = toStringMap(readableMap.getMap("requestHeaders"));
        }
        if (!TextUtils.isEmpty(string)) {
            if (startsWithValidScheme(string)) {
                Uri parse = Uri.parse(string);
                if (parse != null) {
                    ulVar.O000000o(parse, string2, map);
                    return;
                }
                return;
            }
            int identifier = applicationContext.getResources().getIdentifier(string, "drawable", applicationContext.getPackageName());
            if (identifier == 0) {
                identifier = applicationContext.getResources().getIdentifier(string, "raw", applicationContext.getPackageName());
            }
            if (identifier > 0 && (buildRawResourceUri = RawResourceDataSource.buildRawResourceUri(identifier)) != null) {
                ulVar.O00000Oo(buildRawResourceUri, string2);
            }
        }
    }

    @ReactProp(name = "resizeMode")
    public void setResizeMode(ul ulVar, String str) {
        ulVar.setResizeModeModifier(convertToIntDef(str));
    }

    @ReactProp(defaultBoolean = false, name = "repeat")
    public void setRepeat(ul ulVar, boolean z) {
        ulVar.setRepeatModifier(z);
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [com.facebook.react.bridge.Dynamic] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [com.facebook.react.bridge.Dynamic] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    @ReactProp(name = "selectedVideoTrack")
    public void setSelectedVideoTrack(ul ulVar, ReadableMap readableMap) {
        ? r6;
        String str = null;
        if (readableMap != null) {
            String string = readableMap.hasKey("type") ? readableMap.getString("type") : null;
            if (readableMap.hasKey("value")) {
                str = readableMap.getDynamic("value");
            }
            r6 = str;
            str = string;
        } else {
            r6 = 0;
        }
        ulVar.O000000o(str, (Dynamic) r6);
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [com.facebook.react.bridge.Dynamic] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [com.facebook.react.bridge.Dynamic] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    @ReactProp(name = "selectedAudioTrack")
    public void setSelectedAudioTrack(ul ulVar, ReadableMap readableMap) {
        ? r6;
        String str = null;
        if (readableMap != null) {
            String string = readableMap.hasKey("type") ? readableMap.getString("type") : null;
            if (readableMap.hasKey("value")) {
                str = readableMap.getDynamic("value");
            }
            r6 = str;
            str = string;
        } else {
            r6 = 0;
        }
        ulVar.O00000Oo(str, (Dynamic) r6);
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [com.facebook.react.bridge.Dynamic] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [com.facebook.react.bridge.Dynamic] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    @ReactProp(name = "selectedTextTrack")
    public void setSelectedTextTrack(ul ulVar, ReadableMap readableMap) {
        ? r6;
        String str = null;
        if (readableMap != null) {
            String string = readableMap.hasKey("type") ? readableMap.getString("type") : null;
            if (readableMap.hasKey("value")) {
                str = readableMap.getDynamic("value");
            }
            r6 = str;
            str = string;
        } else {
            r6 = 0;
        }
        ulVar.O00000o0(str, r6);
    }

    @ReactProp(name = "textTracks")
    public void setPropTextTracks(ul ulVar, ReadableArray readableArray) {
        ulVar.setTextTracks(readableArray);
    }

    @ReactProp(defaultBoolean = false, name = "paused")
    public void setPaused(ul ulVar, boolean z) {
        ulVar.setPausedModifier(z);
    }

    @ReactProp(defaultBoolean = false, name = "muted")
    public void setMuted(ul ulVar, boolean z) {
        ulVar.setMutedModifier(z);
    }

    @ReactProp(defaultFloat = 1.0f, name = "volume")
    public void setVolume(ul ulVar, float f) {
        ulVar.setVolumeModifier(f);
    }

    @ReactProp(defaultFloat = 250.0f, name = "progressUpdateInterval")
    public void setProgressUpdateInterval(ul ulVar, float f) {
        ulVar.setProgressUpdateInterval(f);
    }

    @ReactProp(defaultBoolean = false, name = "reportBandwidth")
    public void setReportBandwidth(ul ulVar, boolean z) {
        ulVar.setReportBandwidth(z);
    }

    @ReactProp(name = "seek")
    public void setSeek(ul ulVar, float f) {
        long round = (long) Math.round(f * 1000.0f);
        if (ulVar.O0000OOo != null) {
            ulVar.O0000o = round;
            ulVar.O0000OOo.seekTo(round);
        }
    }

    @ReactProp(name = "rate")
    public void setRate(ul ulVar, float f) {
        ulVar.setRateModifier(f);
    }

    @ReactProp(name = "maxBitRate")
    public void setMaxBitRate(ul ulVar, int i) {
        ulVar.setMaxBitRateModifier(i);
    }

    @ReactProp(name = "minLoadRetryCount")
    public void minLoadRetryCount(ul ulVar, int i) {
        ulVar.setMinLoadRetryCountModifier(i);
    }

    @ReactProp(defaultBoolean = false, name = "playInBackground")
    public void setPlayInBackground(ul ulVar, boolean z) {
        ulVar.setPlayInBackground(z);
    }

    @ReactProp(defaultBoolean = false, name = "disableFocus")
    public void setDisableFocus(ul ulVar, boolean z) {
        ulVar.setDisableFocus(z);
    }

    @ReactProp(defaultBoolean = false, name = "fullscreen")
    public void setFullscreen(ul ulVar, boolean z) {
        ulVar.setFullscreen(z);
    }

    @ReactProp(defaultBoolean = true, name = "useTextureView")
    public void setUseTextureView(ul ulVar, boolean z) {
        ulVar.setUseTextureView(z);
    }

    @ReactProp(defaultBoolean = false, name = "hideShutterView")
    public void setHideShutterView(ul ulVar, boolean z) {
        ulVar.setHideShutterView(z);
    }

    @ReactProp(defaultBoolean = false, name = "controls")
    public void setControls(ul ulVar, boolean z) {
        ulVar.setControls(z);
    }

    @ReactProp(name = "bufferConfig")
    public void setBufferConfig(ul ulVar, ReadableMap readableMap) {
        int i;
        if (readableMap != null) {
            int i2 = 50000;
            int i3 = readableMap.hasKey("minBufferMs") ? readableMap.getInt("minBufferMs") : 50000;
            if (readableMap.hasKey("maxBufferMs")) {
                i2 = readableMap.getInt("maxBufferMs");
            }
            int i4 = readableMap.hasKey("bufferForPlaybackMs") ? readableMap.getInt("bufferForPlaybackMs") : 2500;
            if (readableMap.hasKey("bufferForPlaybackAfterRebufferMs")) {
                i = readableMap.getInt("bufferForPlaybackAfterRebufferMs");
            } else {
                i = 5000;
            }
            ulVar.O0000oO0 = i3;
            ulVar.O0000oO = i2;
            ulVar.O0000oOO = i4;
            ulVar.O0000oOo = i;
            ulVar.O00000o();
            ulVar.O00000Oo();
        }
    }

    private boolean startsWithValidScheme(String str) {
        return str.startsWith("http://") || str.startsWith("https://") || str.startsWith("content://") || str.startsWith("file://") || str.startsWith("asset://");
    }

    private int convertToIntDef(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int parseInt = Integer.parseInt(str);
        int i = 1;
        if (parseInt != 1) {
            i = 2;
            if (parseInt != 2) {
                i = 3;
                if (parseInt != 3) {
                    i = 4;
                    if (parseInt != 4) {
                        return 0;
                    }
                }
            }
        }
        return i;
    }

    public static Map<String, String> toStringMap(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        if (!keySetIterator.hasNextKey()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            hashMap.put(nextKey, readableMap.getString(nextKey));
        }
        return hashMap;
    }

    public void onDropViewInstance(ul ulVar) {
        ulVar.O00000oO();
    }
}

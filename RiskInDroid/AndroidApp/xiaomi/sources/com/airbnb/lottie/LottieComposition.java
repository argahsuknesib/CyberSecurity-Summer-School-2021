package com.airbnb.lottie;

import _m_j.o0O0o000;
import _m_j.o0OO00o0;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.JsonReader;
import android.util.Log;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.layer.Layer;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class LottieComposition {
    private Rect bounds;
    private o0OO00o0<FontCharacter> characters;
    private float endFrame;
    private Map<String, Font> fonts;
    private float frameRate;
    private Map<String, LottieImageAsset> images;
    private o0O0o000<Layer> layerMap;
    private List<Layer> layers;
    private final PerformanceTracker performanceTracker = new PerformanceTracker();
    private Map<String, List<Layer>> precomps;
    private float startFrame;
    private final HashSet<String> warnings = new HashSet<>();

    public void init(Rect rect, float f, float f2, float f3, List<Layer> list, o0O0o000<Layer> o0o0o000, Map<String, List<Layer>> map, Map<String, LottieImageAsset> map2, o0OO00o0<FontCharacter> o0oo00o0, Map<String, Font> map3) {
        this.bounds = rect;
        this.startFrame = f;
        this.endFrame = f2;
        this.frameRate = f3;
        this.layers = list;
        this.layerMap = o0o0o000;
        this.precomps = map;
        this.images = map2;
        this.characters = o0oo00o0;
        this.fonts = map3;
    }

    public void addWarning(String str) {
        Log.w("LOTTIE", str);
        this.warnings.add(str);
    }

    public ArrayList<String> getWarnings() {
        HashSet<String> hashSet = this.warnings;
        return new ArrayList<>(Arrays.asList(hashSet.toArray(new String[hashSet.size()])));
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.performanceTracker.setEnabled(z);
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.performanceTracker;
    }

    public Layer layerModelForId(long j) {
        return this.layerMap.O000000o(j, null);
    }

    public Rect getBounds() {
        return this.bounds;
    }

    public float getDuration() {
        return (float) ((long) ((getDurationFrames() / this.frameRate) * 1000.0f));
    }

    public float getStartFrame() {
        return this.startFrame;
    }

    public float getEndFrame() {
        return this.endFrame;
    }

    public float getFrameRate() {
        return this.frameRate;
    }

    public List<Layer> getLayers() {
        return this.layers;
    }

    public List<Layer> getPrecomps(String str) {
        return this.precomps.get(str);
    }

    public o0OO00o0<FontCharacter> getCharacters() {
        return this.characters;
    }

    public Map<String, Font> getFonts() {
        return this.fonts;
    }

    public boolean hasImages() {
        return !this.images.isEmpty();
    }

    public Map<String, LottieImageAsset> getImages() {
        return this.images;
    }

    public float getDurationFrames() {
        return this.endFrame - this.startFrame;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.layers) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }

    @Deprecated
    public static class Factory {
        private Factory() {
        }

        @Deprecated
        public static Cancellable fromAssetFileName(Context context, String str, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener);
            LottieCompositionFactory.fromAsset(context, str).addListener(listenerAdapter);
            return listenerAdapter;
        }

        @Deprecated
        public static Cancellable fromRawFile(Context context, int i, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener);
            LottieCompositionFactory.fromRawRes(context, i).addListener(listenerAdapter);
            return listenerAdapter;
        }

        @Deprecated
        public static Cancellable fromInputStream(InputStream inputStream, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener);
            LottieCompositionFactory.fromJsonInputStream(inputStream, null).addListener(listenerAdapter);
            return listenerAdapter;
        }

        @Deprecated
        public static Cancellable fromJsonString(String str, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener);
            LottieCompositionFactory.fromJsonString(str, null).addListener(listenerAdapter);
            return listenerAdapter;
        }

        @Deprecated
        public static Cancellable fromJsonReader(JsonReader jsonReader, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener);
            LottieCompositionFactory.fromJsonReader(jsonReader, null).addListener(listenerAdapter);
            return listenerAdapter;
        }

        @Deprecated
        public static LottieComposition fromFileSync(Context context, String str) {
            return LottieCompositionFactory.fromAssetSync(context, str).getValue();
        }

        @Deprecated
        public static LottieComposition fromInputStreamSync(InputStream inputStream) {
            return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, null).getValue();
        }

        @Deprecated
        public static LottieComposition fromInputStreamSync(InputStream inputStream, boolean z) {
            if (z) {
                Log.w("LOTTIE", "Lottie now auto-closes input stream!");
            }
            return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, null).getValue();
        }

        @Deprecated
        public static LottieComposition fromJsonSync(Resources resources, JSONObject jSONObject) {
            return LottieCompositionFactory.fromJsonSync(jSONObject, null).getValue();
        }

        @Deprecated
        public static LottieComposition fromJsonSync(String str) {
            return LottieCompositionFactory.fromJsonStringSync(str, null).getValue();
        }

        @Deprecated
        public static LottieComposition fromJsonSync(JsonReader jsonReader) throws IOException {
            return LottieCompositionFactory.fromJsonReaderSync(jsonReader, null).getValue();
        }

        static final class ListenerAdapter implements Cancellable, LottieListener<LottieComposition> {
            private boolean cancelled;
            private final OnCompositionLoadedListener listener;

            private ListenerAdapter(OnCompositionLoadedListener onCompositionLoadedListener) {
                this.cancelled = false;
                this.listener = onCompositionLoadedListener;
            }

            public final void onResult(LottieComposition lottieComposition) {
                if (!this.cancelled) {
                    this.listener.onCompositionLoaded(lottieComposition);
                }
            }

            public final void cancel() {
                this.cancelled = true;
            }
        }
    }
}

package com.projectseptember.RNGL;

import _m_j.csj;
import _m_j.csk;
import com.facebook.imagepipeline.core.DefaultExecutorSupplier;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.memory.PoolConfig;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Locale;
import java.util.Map;

public class GLCanvasManager extends SimpleViewManager<GLCanvas> {
    private ExecutorSupplier executorSupplier;

    public String getName() {
        return "GLCanvas";
    }

    @ReactProp(name = "pixelRatio")
    public void setPixelRatio(GLCanvas gLCanvas, float f) {
        gLCanvas.setPixelRatio(f);
    }

    @ReactProp(name = "nbContentTextures")
    public void setNbContentTextures(GLCanvas gLCanvas, int i) {
        gLCanvas.setNbContentTextures(i);
    }

    @ReactProp(name = "renderId")
    public void setRenderId(GLCanvas gLCanvas, int i) {
        gLCanvas.setRenderId(i);
    }

    @ReactProp(name = "autoRedraw")
    public void setAutoRedraw(GLCanvas gLCanvas, boolean z) {
        gLCanvas.setAutoRedraw(z);
    }

    @ReactProp(name = "overlay")
    public void setZOrderMediaOverlay(GLCanvas gLCanvas, boolean z) {
        gLCanvas.setZOrderMediaOverlay(z);
    }

    @ReactProp(name = "setZOrderOnTop")
    public void setZOrderOnTop(GLCanvas gLCanvas, boolean z) {
        gLCanvas.setZOrderOnTop(z);
    }

    @ReactProp(name = "backgroundColor")
    public void setBackgroundColor(GLCanvas gLCanvas, Integer num) {
        gLCanvas.setBackgroundColor(num.intValue());
    }

    @ReactProp(name = "pointerEvents")
    public void setPointerEvents(GLCanvas gLCanvas, String str) {
        if (str != null) {
            gLCanvas.setPointerEvents(PointerEvents.valueOf(str.toUpperCase(Locale.US).replace("-", "_")));
        }
    }

    @ReactProp(name = "data")
    public void setData(GLCanvas gLCanvas, ReadableMap readableMap) {
        gLCanvas.setData(readableMap == null ? null : csk.O000000o(readableMap));
    }

    @ReactProp(name = "imagesToPreload")
    public void setImagesToPreload(GLCanvas gLCanvas, ReadableArray readableArray) {
        gLCanvas.setImagesToPreload(readableArray);
    }

    public GLCanvas createViewInstance(ThemedReactContext themedReactContext) {
        if (this.executorSupplier == null) {
            this.executorSupplier = new DefaultExecutorSupplier(new PoolFactory(PoolConfig.newBuilder().build()).getFlexByteArrayPoolMaxNumThreads());
        }
        return new GLCanvas(themedReactContext, this.executorSupplier);
    }

    public void receiveCommand(GLCanvas gLCanvas, int i, ReadableArray readableArray) {
        Assertions.assertNotNull(gLCanvas);
        Assertions.assertNotNull(readableArray);
        if (i == 1) {
            ReadableMap map = readableArray.getMap(0);
            gLCanvas.requestCaptureFrame(new csj(map.getString("format"), map.getString("type"), map.getString("filePath"), Double.valueOf(map.getDouble("quality"))));
            return;
        }
        throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", Integer.valueOf(i), getClass().getSimpleName()));
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of("captureFrame", MapBuilder.of("registrationName", "onGLCaptureFrame"), "load", MapBuilder.of("registrationName", "onGLLoad"), "progress", MapBuilder.of("registrationName", "onGLProgress"));
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("captureFrame", 1);
    }
}

package com.projectseptember.RNGL;

import _m_j.csj;
import _m_j.csk;
import _m_j.csl;
import _m_j.csm;
import _m_j.csn;
import _m_j.cso;
import _m_j.csp;
import _m_j.csq;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.opengl.GLES20;
import android.opengl.GLException;
import android.opengl.GLSurfaceView;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GLCanvas extends GLSurfaceView implements GLSurfaceView.Renderer, ReactPointerEventsView, Executor {
    private boolean autoRedraw;
    private List<csj> captureConfigs = new ArrayList();
    private List<Bitmap> contentBitmaps = new ArrayList();
    private List<csq> contentTextures = new ArrayList();
    private csk data;
    private int defaultFBO;
    public boolean deferredRendering = false;
    private boolean dirtyOnLoad = true;
    private float displayDensity;
    private ExecutorSupplier executorSupplier;
    private Map<Integer, csl> fbos;
    private Map<Uri, csm> images = new HashMap();
    private List<Uri> imagesToPreload = new ArrayList();
    private PointerEvents mPointerEvents = PointerEvents.AUTO;
    private final Queue<Runnable> mRunOnDraw = new LinkedList();
    private int nbContentTextures;
    private boolean neverRendered = true;
    private float pixelRatio;
    private List<Uri> preloaded = new ArrayList();
    private ReactContext reactContext;
    private csn renderData;
    private RNGLContext rnglContext;
    private Map<Integer, cso> shaders;

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
    }

    public GLCanvas(ThemedReactContext themedReactContext, ExecutorSupplier executorSupplier2) {
        super(themedReactContext);
        this.reactContext = themedReactContext;
        this.executorSupplier = executorSupplier2;
        this.rnglContext = (RNGLContext) themedReactContext.getNativeModule(RNGLContext.class);
        setEGLContextClientVersion(2);
        DisplayMetrics displayMetrics = this.reactContext.getResources().getDisplayMetrics();
        this.displayDensity = displayMetrics.density;
        this.pixelRatio = displayMetrics.density;
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        getHolder().setFormat(3);
        setZOrderOnTop(false);
        setRenderer(this);
        setRenderMode(0);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        syncContentBitmaps();
        requestRender();
    }

    public csl getFBO(Integer num) {
        if (!this.fbos.containsKey(num)) {
            this.fbos.put(num, new csl(this));
        }
        return this.fbos.get(num);
    }

    public cso getShader(Integer num) {
        if (!this.shaders.containsKey(num)) {
            csp shader = this.rnglContext.getShader(num);
            if (shader == null) {
                return null;
            }
            this.shaders.put(num, new cso(shader, num, this.rnglContext));
        }
        return this.shaders.get(num);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.fbos = new HashMap();
        this.shaders = new HashMap();
        this.images = new HashMap();
        this.contentTextures = new ArrayList();
        this.contentBitmaps = new ArrayList();
        this.renderData = null;
        requestSyncData();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        syncSize(i, i2, this.pixelRatio);
    }

    public void onDrawFrame(GL10 gl10) {
        runAll(this.mRunOnDraw);
        int size = this.contentTextures.size();
        int i = this.nbContentTextures;
        if (size != i) {
            resizeUniformContentTextures(i);
        }
        if (!haveRemainingToPreload()) {
            this.neverRendered = false;
            boolean z = this.deferredRendering || this.autoRedraw || this.nbContentTextures == 0;
            if (this.nbContentTextures > 0) {
                this.reactContext.runOnUiQueueThread(new Runnable() {
                    /* class com.projectseptember.RNGL.GLCanvas.AnonymousClass1 */

                    public final void run() {
                        GLCanvas.this.syncContentBitmaps();
                        if (!GLCanvas.this.deferredRendering) {
                            GLCanvas gLCanvas = GLCanvas.this;
                            gLCanvas.deferredRendering = true;
                            gLCanvas.requestRender();
                        }
                    }
                });
            }
            if (z) {
                render();
                this.deferredRendering = false;
                if (this.captureConfigs.size() > 0) {
                    capture();
                }
            }
        } else if (this.neverRendered) {
            this.neverRendered = false;
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
        }
    }

    private void capture() {
        String str;
        String str2;
        Bitmap createSnapshot = createSnapshot();
        RCTEventEmitter rCTEventEmitter = (RCTEventEmitter) ((ReactContext) getContext()).getJSModule(RCTEventEmitter.class);
        for (csj next : this.captureConfigs) {
            boolean equals = next.O00000Oo.equals("png");
            boolean z = true;
            boolean z2 = !equals && (next.O00000Oo.equals("jpg") || next.O00000Oo.equals("jpeg"));
            boolean z3 = !equals && !z2 && next.O00000Oo.equals("webm");
            boolean equals2 = next.f14303O000000o.equals("base64");
            if (equals2 || !next.f14303O000000o.equals("file")) {
                z = false;
            }
            String str3 = null;
            Bitmap.CompressFormat compressFormat = equals ? Bitmap.CompressFormat.PNG : z2 ? Bitmap.CompressFormat.JPEG : z3 ? Bitmap.CompressFormat.WEBP : null;
            int doubleValue = (int) (next.O00000o.doubleValue() * 100.0d);
            if (compressFormat == null) {
                str = "Unsupported capture type '" + next.O00000Oo + "'";
            } else {
                if (equals2) {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        createSnapshot.compress(compressFormat, doubleValue, byteArrayOutputStream);
                        str2 = "data:image/png;base64," + Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                        byteArrayOutputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        str = "Could not capture as base64: " + e.getMessage();
                    }
                } else if (z) {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(next.O00000o0);
                        createSnapshot.compress(compressFormat, doubleValue, fileOutputStream);
                        fileOutputStream.close();
                        str2 = "file://" + next.O00000o0;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        str = "Could not write file: " + e2.getMessage();
                    }
                } else {
                    str = "Unsupported capture format '" + next.f14303O000000o + "'";
                }
                str3 = str2;
                str = null;
            }
            WritableMap createMap = Arguments.createMap();
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putString("format", next.f14303O000000o);
            createMap2.putString("type", next.O00000Oo);
            createMap2.putString("filePath", next.O00000o0);
            createMap2.putDouble("quality", next.O00000o.doubleValue());
            createMap.putMap("config", createMap2);
            if (str != null) {
                createMap.putString("error", str);
            }
            if (str3 != null) {
                createMap.putString("result", str3);
            }
            rCTEventEmitter.receiveEvent(getId(), "captureFrame", createMap);
        }
        this.captureConfigs = new ArrayList();
    }

    private boolean haveRemainingToPreload() {
        for (Uri contains : this.imagesToPreload) {
            if (!this.preloaded.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    public void setNbContentTextures(int i) {
        this.nbContentTextures = i;
        requestRender();
    }

    public void setRenderId(int i) {
        if (this.nbContentTextures > 0) {
            if (!haveRemainingToPreload()) {
                syncContentBitmaps();
            }
            requestRender();
        }
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(16777215 & i);
        if (i == 0) {
            getHolder().setFormat(-3);
        } else {
            getHolder().setFormat(3);
        }
        requestRender();
    }

    public void setAutoRedraw(boolean z) {
        this.autoRedraw = z;
        setRenderMode(z ? 1 : 0);
    }

    public void setData(csk csk) {
        this.data = csk;
        this.renderData = null;
        if (!haveRemainingToPreload()) {
            syncContentBitmaps();
        }
        requestSyncData();
    }

    public void setImagesToPreload(ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            arrayList.add(resolveSrc(readableArray.getMap(i).getString("uri")));
        }
        this.imagesToPreload = arrayList;
        requestSyncData();
    }

    public void execute(Runnable runnable) {
        synchronized (this.mRunOnDraw) {
            this.mRunOnDraw.add(runnable);
            requestRender();
        }
    }

    private void runAll(Queue<Runnable> queue) {
        synchronized (queue) {
            while (!queue.isEmpty()) {
                queue.poll().run();
            }
        }
    }

    public void requestSyncData() {
        execute(new Runnable() {
            /* class com.projectseptember.RNGL.GLCanvas.AnonymousClass2 */

            public final void run() {
                try {
                    if (!GLCanvas.this.syncData()) {
                        GLCanvas.this.requestSyncData();
                    }
                } catch (GLShaderCompilationFailed unused) {
                }
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    public static Bitmap captureView(View view) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0 || height <= 0) {
            return Bitmap.createBitmap(2, 2, Bitmap.Config.ARGB_8888);
        }
        if (view.getDrawingCache() == null) {
            view.setDrawingCacheEnabled(true);
        }
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            Log.e("GLCanvas", "view.getDrawingCache() is null. view=".concat(String.valueOf(view)));
            return Bitmap.createBitmap(2, 2, Bitmap.Config.ARGB_8888);
        }
        Matrix matrix = new Matrix();
        matrix.postScale(1.0f, -1.0f);
        return Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
    }

    public int syncContentBitmaps() {
        int i;
        ArrayList arrayList = new ArrayList();
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            i = 0;
        } else {
            i = viewGroup.getChildCount() - 1;
        }
        for (int i2 = 0; i2 < i; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ViewGroup) {
                ViewGroup viewGroup2 = (ViewGroup) childAt;
                if (viewGroup2.getChildCount() == 1) {
                    childAt = viewGroup2.getChildAt(0);
                }
            }
            arrayList.add(captureView(childAt));
        }
        this.contentBitmaps = arrayList;
        return i;
    }

    public int syncContentTextures() {
        int min = Math.min(this.contentTextures.size(), this.contentBitmaps.size());
        for (int i = 0; i < min; i++) {
            this.contentTextures.get(i).O000000o(this.contentBitmaps.get(i));
        }
        return min;
    }

    public void resizeUniformContentTextures(int i) {
        int size = this.contentTextures.size();
        if (size != i) {
            if (i < size) {
                this.contentTextures = this.contentTextures.subList(0, i);
                return;
            }
            for (int size2 = this.contentTextures.size(); size2 < i; size2++) {
                this.contentTextures.add(new csq(this));
            }
        }
    }

    private int countPreloaded() {
        int i = 0;
        for (Uri contains : this.imagesToPreload) {
            if (this.preloaded.contains(contains)) {
                i++;
            }
        }
        return i;
    }

    public void onImageLoad(Uri uri) {
        this.preloaded.add(uri);
        int countPreloaded = countPreloaded();
        int size = this.imagesToPreload.size();
        double d = (double) countPreloaded;
        double d2 = (double) size;
        Double.isNaN(d);
        Double.isNaN(d2);
        dispatchOnProgress(d / d2, countPreloaded, size);
        this.dirtyOnLoad = true;
        requestSyncData();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000b, code lost:
        if (r1.getScheme() == null) goto L_0x000d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0010  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e  */
    public Uri resolveSrc(String str) {
        Uri uri;
        if (str == null) {
            return null;
        }
        try {
            uri = Uri.parse(str);
        } catch (Exception unused) {
        }
        uri = null;
        if (uri == null) {
            return uri;
        }
        ReactContext reactContext2 = this.reactContext;
        if (str == null || str.isEmpty()) {
            return null;
        }
        return new Uri.Builder().scheme("res").path(String.valueOf(reactContext2.getResources().getIdentifier(str.toLowerCase().replace("-", "_"), "drawable", reactContext2.getPackageName()))).build();
        if (uri == null) {
        }
    }

    public Uri srcResource(ReadableMap readableMap) {
        boolean z = readableMap.hasKey("isStatic") && readableMap.getBoolean("isStatic");
        String string = readableMap.hasKey("path") ? readableMap.getString("path") : null;
        if (string == null || z) {
            string = readableMap.getString("uri");
        }
        return resolveSrc(string);
    }

    private csn recSyncData(csk csk, HashMap<Uri, csm> hashMap) {
        Iterator<String> it;
        String str;
        HashMap hashMap2;
        HashMap<Uri, csm> hashMap3;
        Map<Uri, csm> map;
        HashMap hashMap4;
        HashMap hashMap5;
        String str2;
        String str3;
        HashMap hashMap6;
        String str4;
        GLCanvas gLCanvas = this;
        csk csk2 = csk;
        HashMap<Uri, csm> hashMap7 = hashMap;
        String str5 = "texture uniform '";
        Map<Uri, csm> map2 = gLCanvas.images;
        cso shader = gLCanvas.getShader(csk2.f14304O000000o);
        if (shader == null || !shader.O000000o()) {
            return null;
        }
        HashMap hashMap8 = new HashMap();
        HashMap hashMap9 = new HashMap();
        HashMap hashMap10 = new HashMap();
        HashMap hashMap11 = new HashMap();
        HashMap hashMap12 = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (csk recSyncData : csk2.O0000O0o) {
            csn recSyncData2 = gLCanvas.recSyncData(recSyncData, hashMap7);
            if (recSyncData2 == null) {
                return null;
            }
            arrayList.add(recSyncData2);
        }
        for (csk recSyncData3 : csk2.O0000OOo) {
            csn recSyncData4 = gLCanvas.recSyncData(recSyncData3, hashMap7);
            if (recSyncData4 == null) {
                return null;
            }
            arrayList2.add(recSyncData4);
        }
        Map<String, Integer> map3 = shader.f14312O000000o;
        List<String> list = shader.O00000Oo;
        Map<String, Integer> map4 = shader.O0000O0o;
        ArrayList arrayList3 = arrayList2;
        ReadableMapKeySetIterator keySetIterator = csk2.O00000Oo.keySetIterator();
        ArrayList arrayList4 = arrayList;
        int i = 0;
        while (true) {
            List<String> list2 = list;
            Map<Uri, csm> map5 = map2;
            String str6 = "[";
            String str7 = "'";
            if (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                Map<String, Integer> map6 = map3;
                int intValue = map3.get(nextKey).intValue();
                ReadableMapKeySetIterator readableMapKeySetIterator = keySetIterator;
                int intValue2 = map4.get(nextKey).intValue();
                Map<String, Integer> map7 = map4;
                ReadableMap readableMap = csk2.O00000Oo;
                if (intValue == 35678 || intValue == 35680) {
                    String str8 = str5;
                    HashMap hashMap13 = hashMap9;
                    HashMap hashMap14 = hashMap12;
                    int i2 = i;
                    i = i2 + 1;
                    hashMap8.put(nextKey, Integer.valueOf(i2));
                    if (readableMap.isNull(nextKey)) {
                        csq csq = new csq(gLCanvas);
                        csq.O000000o(Bitmap.createBitmap(2, 2, Bitmap.Config.ARGB_8888));
                        hashMap2 = hashMap14;
                        hashMap2.put(nextKey, csq);
                    } else {
                        hashMap2 = hashMap14;
                        try {
                            ReadableMap map8 = readableMap.getMap(nextKey);
                            String string = map8.getString("type");
                            if (string.equals("content")) {
                                int i3 = map8.getInt("id");
                                if (i3 >= gLCanvas.contentTextures.size()) {
                                    gLCanvas.resizeUniformContentTextures(i3 + 1);
                                }
                                hashMap2.put(nextKey, gLCanvas.contentTextures.get(i3));
                            } else if (string.equals("fbo")) {
                                hashMap2.put(nextKey, gLCanvas.getFBO(Integer.valueOf(map8.getInt("id"))).f14305O000000o.get(0));
                            } else {
                                if (string.equals("uri")) {
                                    final Uri srcResource = gLCanvas.srcResource(map8);
                                    if (srcResource == null) {
                                        str = str8;
                                        shader.O000000o(str + nextKey + "': Invalid uri format '" + map8 + str7);
                                    } else {
                                        str = str8;
                                    }
                                    hashMap3 = hashMap;
                                    csm csm = hashMap3.get(srcResource);
                                    if (csm == null) {
                                        map = map5;
                                        csm = map.get(srcResource);
                                        if (csm != null) {
                                            hashMap3.put(srcResource, csm);
                                        }
                                    } else {
                                        map = map5;
                                    }
                                    if (csm == null) {
                                        csm = new csm(gLCanvas, gLCanvas.executorSupplier.forDecode(), new Runnable() {
                                            /* class com.projectseptember.RNGL.GLCanvas.AnonymousClass3 */

                                            public final void run() {
                                                GLCanvas.this.onImageLoad(srcResource);
                                            }
                                        });
                                        if (csm.f14308O000000o == srcResource || (csm.f14308O000000o != null && csm.f14308O000000o.equals(srcResource))) {
                                            map5 = map;
                                        } else {
                                            csm.f14308O000000o = srcResource;
                                            if (csm.O00000oo != null && !csm.O00000oo.isFinished()) {
                                                csm.O00000oo.close();
                                            }
                                            Uri uri = csm.f14308O000000o;
                                            map5 = map;
                                            csm.O00000oo = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(uri).setAutoRotateEnabled(false).build(), null);
                                            csm.O00000oo.subscribe(new BaseBitmapDataSubscriber(uri) {
                                                /* class _m_j.csm.AnonymousClass1 */

                                                /* renamed from: O000000o  reason: collision with root package name */
                                                final /* synthetic */ Uri f14309O000000o;

                                                {
                                                    this.f14309O000000o = r2;
                                                }

                                                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                                 method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
                                                 arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
                                                 candidates:
                                                  ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
                                                  ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
                                                public final void onNewResultImpl(Bitmap bitmap) {
                                                    csm csm = csm.this;
                                                    Matrix matrix = new Matrix();
                                                    matrix.postScale(1.0f, -1.0f);
                                                    Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                                                    createBitmap.setHasAlpha(true);
                                                    csm.O00000o.execute(new Runnable(createBitmap) {
                                                        /* class _m_j.csm.AnonymousClass2 */

                                                        /* renamed from: O000000o  reason: collision with root package name */
                                                        final /* synthetic */ Bitmap f14310O000000o;

                                                        {
                                                            this.f14310O000000o = r2;
                                                        }

                                                        public final void run() {
                                                            csm.this.O00000Oo.O000000o(this.f14310O000000o);
                                                            this.f14310O000000o.recycle();
                                                            csm.this.O00000o0.run();
                                                        }
                                                    });
                                                }

                                                public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                                                    Log.e("GLImage", "Failed to load '" + this.f14309O000000o.getPath() + "'", dataSource.getFailureCause());
                                                }
                                            }, csm.O00000oO);
                                        }
                                        hashMap3.put(srcResource, csm);
                                    } else {
                                        map5 = map;
                                    }
                                    hashMap2.put(nextKey, csm.O00000Oo);
                                } else {
                                    hashMap3 = hashMap;
                                    str = str8;
                                    shader.O000000o(str + nextKey + "': Unexpected type '" + intValue + str7);
                                }
                                gLCanvas = this;
                                hashMap12 = hashMap2;
                                str5 = str;
                                list = list2;
                                map4 = map7;
                                map3 = map6;
                                keySetIterator = readableMapKeySetIterator;
                                csk2 = csk;
                                hashMap9 = hashMap13;
                                map2 = map5;
                            }
                        } catch (Exception unused) {
                            shader.O000000o(str8 + nextKey + "': you cannot directly give require('./img.png') to gl-react, use resolveAssetSource(require('./img.png')) instead.");
                            return null;
                        }
                    }
                    hashMap3 = hashMap;
                    str = str8;
                    gLCanvas = this;
                    hashMap12 = hashMap2;
                    str5 = str;
                    list = list2;
                    map4 = map7;
                    map3 = map6;
                    keySetIterator = readableMapKeySetIterator;
                    csk2 = csk;
                    hashMap9 = hashMap13;
                    map2 = map5;
                } else {
                    String str9 = "': type not supported: ";
                    String str10 = str5;
                    String str11 = ". Expected: ";
                    HashMap hashMap15 = hashMap12;
                    int i4 = i;
                    String str12 = "]";
                    if (intValue2 == 1) {
                        if (intValue == 5124) {
                            hashMap8.put(nextKey, Integer.valueOf(readableMap.getInt(nextKey)));
                        } else if (intValue != 5126) {
                            switch (intValue) {
                                case 35664:
                                case 35665:
                                case 35666:
                                case 35674:
                                case 35675:
                                case 35676:
                                    ReadableArray array = readableMap.getArray(nextKey);
                                    if (gLCanvas.arraySizeForType(intValue) != array.size()) {
                                        shader.O000000o("uniform '" + nextKey + "': Invalid array size: " + array.size() + str11 + gLCanvas.arraySizeForType(intValue));
                                    }
                                    hashMap11.put(nextKey, gLCanvas.parseAsFloatArray(array));
                                    break;
                                case 35667:
                                case 35668:
                                case 35669:
                                case 35671:
                                case 35672:
                                case 35673:
                                    ReadableArray array2 = readableMap.getArray(nextKey);
                                    if (gLCanvas.arraySizeForType(intValue) != array2.size()) {
                                        shader.O000000o("uniform '" + nextKey + "': Invalid array size: " + array2.size() + str11 + gLCanvas.arraySizeForType(intValue));
                                    }
                                    hashMap10.put(nextKey, gLCanvas.parseAsIntArray(array2));
                                    break;
                                case 35670:
                                    hashMap8.put(nextKey, Integer.valueOf(readableMap.getBoolean(nextKey) ? 1 : 0));
                                    break;
                                default:
                                    shader.O000000o("uniform '" + nextKey + str9 + intValue);
                                    break;
                            }
                        } else {
                            hashMap9.put(nextKey, Float.valueOf((float) readableMap.getDouble(nextKey)));
                        }
                        hashMap4 = hashMap9;
                    } else {
                        ReadableArray array3 = readableMap.getArray(nextKey);
                        if (intValue2 != array3.size()) {
                            StringBuilder sb = new StringBuilder("uniform '");
                            sb.append(nextKey);
                            sb.append("': Invalid array size: ");
                            hashMap5 = hashMap9;
                            sb.append(array3.size());
                            sb.append(str11);
                            sb.append(intValue2);
                            shader.O000000o(sb.toString());
                        } else {
                            hashMap5 = hashMap9;
                        }
                        int i5 = 0;
                        while (i5 < intValue2) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(nextKey);
                            sb2.append(str6);
                            sb2.append(i5);
                            int i6 = intValue2;
                            sb2.append(str12);
                            String sb3 = sb2.toString();
                            if (intValue == 5124) {
                                str3 = str9;
                                str4 = str11;
                                str2 = str6;
                                hashMap6 = hashMap5;
                                hashMap8.put(sb3, Integer.valueOf(array3.getInt(i5)));
                            } else if (intValue != 5126) {
                                switch (intValue) {
                                    case 35664:
                                    case 35665:
                                    case 35666:
                                    case 35674:
                                    case 35675:
                                    case 35676:
                                        str3 = str9;
                                        str2 = str6;
                                        ReadableArray array4 = array3.getArray(i5);
                                        if (gLCanvas.arraySizeForType(intValue) != array4.size()) {
                                            shader.O000000o("uniform '" + sb3 + "': Invalid array size: " + array4.size() + str11 + gLCanvas.arraySizeForType(intValue));
                                        }
                                        hashMap11.put(sb3, gLCanvas.parseAsFloatArray(array4));
                                        str4 = str11;
                                        hashMap6 = hashMap5;
                                        break;
                                    case 35667:
                                    case 35668:
                                    case 35669:
                                    case 35671:
                                    case 35672:
                                    case 35673:
                                        ReadableArray array5 = array3.getArray(i5);
                                        str3 = str9;
                                        str2 = str6;
                                        if (gLCanvas.arraySizeForType(intValue) != array5.size()) {
                                            shader.O000000o("uniform '" + sb3 + "': Invalid array size: " + array5.size() + str11 + gLCanvas.arraySizeForType(intValue));
                                        }
                                        hashMap10.put(sb3, gLCanvas.parseAsIntArray(array5));
                                        str4 = str11;
                                        hashMap6 = hashMap5;
                                        break;
                                    case 35670:
                                        hashMap8.put(sb3, Integer.valueOf(array3.getBoolean(i5) ? 1 : 0));
                                        str3 = str9;
                                        str4 = str11;
                                        str2 = str6;
                                        hashMap6 = hashMap5;
                                        break;
                                    default:
                                        shader.O000000o("uniform '" + sb3 + str9 + intValue);
                                        str3 = str9;
                                        str4 = str11;
                                        str2 = str6;
                                        hashMap6 = hashMap5;
                                        break;
                                }
                            } else {
                                str3 = str9;
                                str4 = str11;
                                str2 = str6;
                                hashMap6 = hashMap5;
                                hashMap6.put(sb3, Float.valueOf((float) array3.getDouble(i5)));
                            }
                            i5++;
                            str11 = str4;
                            hashMap5 = hashMap6;
                            intValue2 = i6;
                            str9 = str3;
                            str6 = str2;
                        }
                        hashMap4 = hashMap5;
                    }
                    csk2 = csk;
                    hashMap9 = hashMap4;
                    list = list2;
                    map2 = map5;
                    map4 = map7;
                    map3 = map6;
                    keySetIterator = readableMapKeySetIterator;
                    str5 = str10;
                    hashMap12 = hashMap15;
                    i = i4;
                }
            } else {
                String str13 = str6;
                Map<String, Integer> map9 = map4;
                HashMap hashMap16 = hashMap9;
                HashMap hashMap17 = hashMap12;
                String str14 = "]";
                String str15 = str7;
                int[] iArr = new int[1];
                GLES20.glGetIntegerv(34930, iArr, 0);
                if (i > iArr[0]) {
                    shader.O000000o("Maximum number of texture reach. got " + i + " >= max " + iArr);
                }
                Iterator<String> it2 = list2.iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    Map<String, Integer> map10 = map9;
                    int intValue3 = map10.get(next).intValue();
                    if (intValue3 != 1) {
                        int i7 = 0;
                        while (i7 < intValue3) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(next);
                            String str16 = str13;
                            sb4.append(str16);
                            sb4.append(i7);
                            String str17 = str14;
                            sb4.append(str17);
                            String sb5 = sb4.toString();
                            if (hashMap16.containsKey(sb5) || hashMap8.containsKey(sb5) || hashMap11.containsKey(sb5) || hashMap10.containsKey(sb5)) {
                                it = it2;
                            } else {
                                it = it2;
                                shader.O000000o("All defined uniforms must be provided. Missing '" + sb5 + str15);
                            }
                            i7++;
                            it2 = it;
                            str14 = str17;
                            str13 = str16;
                        }
                    } else if (!hashMap16.containsKey(next) && !hashMap8.containsKey(next) && !hashMap11.containsKey(next) && !hashMap10.containsKey(next)) {
                        shader.O000000o("All defined uniforms must be provided. Missing '" + next + str15);
                        map9 = map10;
                    }
                    it2 = it2;
                    str14 = str14;
                    map9 = map10;
                    str13 = str13;
                }
                csk csk3 = csk;
                return new csn(shader, hashMap8, hashMap16, hashMap10, hashMap11, hashMap17, Integer.valueOf((int) (csk3.O00000o0.doubleValue() * csk3.O00000oO.doubleValue())), Integer.valueOf((int) (csk3.O00000o.doubleValue() * csk3.O00000oO.doubleValue())), csk3.O00000oo, arrayList4, arrayList3);
            }
        }
    }

    private FloatBuffer parseAsFloatArray(ReadableArray readableArray) {
        int size = readableArray.size();
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(size * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        for (int i = 0; i < size; i++) {
            asFloatBuffer.put((float) readableArray.getDouble(i));
        }
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    private IntBuffer parseAsIntArray(ReadableArray readableArray) {
        int size = readableArray.size();
        IntBuffer asIntBuffer = ByteBuffer.allocateDirect(size * 4).order(ByteOrder.nativeOrder()).asIntBuffer();
        for (int i = 0; i < size; i++) {
            asIntBuffer.put(readableArray.getInt(i));
        }
        asIntBuffer.position(0);
        return asIntBuffer;
    }

    private int arraySizeForType(int i) {
        switch (i) {
            case 35664:
            case 35667:
            case 35671:
                return 2;
            case 35665:
            case 35668:
            case 35672:
                return 3;
            case 35666:
            case 35669:
            case 35673:
            case 35674:
                return 4;
            case 35670:
            default:
                throw new Error("Invalid array type: ".concat(String.valueOf(i)));
            case 35675:
                return 9;
            case 35676:
                return 16;
        }
    }

    public boolean syncData() {
        if (this.data == null) {
            return true;
        }
        HashMap hashMap = new HashMap();
        csn recSyncData = recSyncData(this.data, hashMap);
        if (recSyncData == null) {
            return false;
        }
        Set diff = diff(this.images.keySet(), this.images.keySet());
        this.images = hashMap;
        this.preloaded.removeAll(diff);
        this.renderData = recSyncData;
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.opengl.GLES20.glVertexAttribPointer(int, int, int, boolean, int, int):void}
     arg types: [int, int, int, int, int, int]
     candidates:
      ClspMth{android.opengl.GLES20.glVertexAttribPointer(int, int, int, boolean, int, java.nio.Buffer):void}
      ClspMth{android.opengl.GLES20.glVertexAttribPointer(int, int, int, boolean, int, int):void} */
    private void recRender(csn csn) {
        int intValue = csn.O0000O0o.intValue();
        int intValue2 = csn.O0000OOo.intValue();
        for (csn recRender : csn.O0000Oo) {
            recRender(recRender);
        }
        for (csn recRender2 : csn.O0000OoO) {
            recRender(recRender2);
        }
        if (csn.O0000Oo0.intValue() == -1) {
            GLES20.glBindFramebuffer(36160, this.defaultFBO);
            GLES20.glViewport(0, 0, intValue, intValue2);
            GLES20.glBlendFunc(1, 771);
        } else {
            csl fbo = getFBO(csn.O0000Oo0);
            if (!(intValue == fbo.O00000o0 && intValue2 == fbo.O00000o)) {
                int[] iArr = new int[1];
                GLES20.glGetIntegerv(34024, iArr, 0);
                if (intValue < 0 || intValue > iArr[0] || intValue2 < 0 || intValue2 > iArr[0]) {
                    throw new IllegalArgumentException("Can't resize framebuffer. Invalid dimensions");
                }
                fbo.O00000o0 = intValue;
                fbo.O00000o = intValue2;
                csl.O000000o o000000o = new csl.O000000o();
                for (csq O000000o2 : fbo.f14305O000000o) {
                    O000000o2.O000000o(intValue, intValue2);
                }
                GLES20.glBindFramebuffer(36160, fbo.O00000Oo);
                int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
                if (glCheckFramebufferStatus != 36053) {
                    switch (glCheckFramebufferStatus) {
                        case 36054:
                            throw new RuntimeException("Framebuffer incomplete attachment");
                        case 36055:
                            throw new RuntimeException("Framebuffer incomplete missing attachment");
                        case 36057:
                            throw new RuntimeException("Framebuffer incomplete dimensions");
                        case 36061:
                            throw new RuntimeException("Framebuffer unsupported");
                    }
                    throw new RuntimeException("Failed to create framebuffer: ".concat(String.valueOf(glCheckFramebufferStatus)));
                }
                o000000o.O000000o();
            }
            GLES20.glBindFramebuffer(36160, fbo.O00000Oo);
            GLES20.glViewport(0, 0, fbo.O00000o0, fbo.O00000o);
            GLES20.glBlendFunc(770, 771);
        }
        cso cso = csn.f14311O000000o;
        cso.O000000o();
        if (!GLES20.glIsProgram(cso.O00000o0)) {
            cso.O000000o("not a program");
        }
        GLES20.glUseProgram(cso.O00000o0);
        GLES20.glBindBuffer(34962, cso.O00000o[0]);
        GLES20.glEnableVertexAttribArray(cso.O00000oO);
        GLES20.glVertexAttribPointer(cso.O00000oO, 2, 5126, false, 0, 0);
        for (String next : csn.O00000oo.keySet()) {
            GLES20.glActiveTexture(csn.O00000Oo.get(next).intValue() + 33984);
            GLES20.glBindTexture(3553, csn.O00000oo.get(next).f14314O000000o);
        }
        Map<String, Integer> map = csn.f14311O000000o.f14312O000000o;
        for (String next2 : csn.O00000Oo.keySet()) {
            GLES20.glUniform1i(csn.f14311O000000o.O00000oo.get(next2).intValue(), csn.O00000Oo.get(next2).intValue());
        }
        for (String next3 : csn.O00000o0.keySet()) {
            GLES20.glUniform1f(csn.f14311O000000o.O00000oo.get(next3).intValue(), csn.O00000o0.get(next3).floatValue());
        }
        for (String next4 : csn.O00000oO.keySet()) {
            cso cso2 = csn.f14311O000000o;
            FloatBuffer floatBuffer = csn.O00000oO.get(next4);
            int intValue3 = map.get(next4).intValue();
            switch (intValue3) {
                case 35664:
                    GLES20.glUniform2fv(cso2.O00000oo.get(next4).intValue(), 1, floatBuffer);
                    break;
                case 35665:
                    GLES20.glUniform3fv(cso2.O00000oo.get(next4).intValue(), 1, floatBuffer);
                    break;
                case 35666:
                    GLES20.glUniform4fv(cso2.O00000oo.get(next4).intValue(), 1, floatBuffer);
                    break;
                default:
                    switch (intValue3) {
                        case 35674:
                            GLES20.glUniformMatrix2fv(cso2.O00000oo.get(next4).intValue(), 1, false, floatBuffer);
                            continue;
                        case 35675:
                            GLES20.glUniformMatrix3fv(cso2.O00000oo.get(next4).intValue(), 1, false, floatBuffer);
                            continue;
                        case 35676:
                            GLES20.glUniformMatrix4fv(cso2.O00000oo.get(next4).intValue(), 1, false, floatBuffer);
                            continue;
                        default:
                            cso2.O000000o("Unsupported case: uniform '" + next4 + "' type: " + intValue3);
                            continue;
                    }
            }
        }
        for (String next5 : csn.O00000o.keySet()) {
            cso cso3 = csn.f14311O000000o;
            IntBuffer intBuffer = csn.O00000o.get(next5);
            int intValue4 = map.get(next5).intValue();
            switch (intValue4) {
                case 35667:
                case 35671:
                    GLES20.glUniform2iv(cso3.O00000oo.get(next5).intValue(), 1, intBuffer);
                    break;
                case 35668:
                case 35672:
                    GLES20.glUniform3iv(cso3.O00000oo.get(next5).intValue(), 1, intBuffer);
                    break;
                case 35669:
                case 35673:
                    GLES20.glUniform4iv(cso3.O00000oo.get(next5).intValue(), 1, intBuffer);
                    break;
                case 35670:
                default:
                    cso3.O000000o("Unsupported case: uniform '" + next5 + "' type: " + intValue4);
                    break;
            }
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glDrawArrays(4, 0, 3);
    }

    private void render() {
        csn csn = this.renderData;
        if (csn != null) {
            syncContentTextures();
            int[] iArr = new int[1];
            GLES20.glGetIntegerv(36006, iArr, 0);
            this.defaultFBO = iArr[0];
            GLES20.glEnable(3042);
            recRender(csn);
            GLES20.glDisable(3042);
            GLES20.glBindFramebuffer(36160, this.defaultFBO);
            GLES20.glBindBuffer(34962, 0);
            if (this.dirtyOnLoad && !haveRemainingToPreload()) {
                this.dirtyOnLoad = false;
                dispatchOnLoad();
            }
        }
    }

    private void dispatchOnProgress(double d, int i, int i2) {
        WritableMap createMap = Arguments.createMap();
        if (Double.isNaN(d)) {
            d = 0.0d;
        }
        createMap.putDouble("progress", d);
        createMap.putInt("loaded", i);
        createMap.putInt("total", i2);
        ((RCTEventEmitter) ((ReactContext) getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), "progress", createMap);
    }

    private void dispatchOnLoad() {
        ((RCTEventEmitter) ((ReactContext) getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), "load", Arguments.createMap());
    }

    public void requestCaptureFrame(csj csj) {
        requestRender();
        for (csj equals : this.captureConfigs) {
            if (equals.equals(csj)) {
                return;
            }
        }
        this.captureConfigs.add(csj);
    }

    private Bitmap createSnapshot() {
        return createSnapshot(0, 0, this.renderData.O0000O0o.intValue(), this.renderData.O0000OOo.intValue());
    }

    private Bitmap createSnapshot(int i, int i2, int i3, int i4) {
        int i5 = i3 * i4;
        int[] iArr = new int[i5];
        int[] iArr2 = new int[i5];
        IntBuffer wrap = IntBuffer.wrap(iArr);
        wrap.position(0);
        try {
            GLES20.glReadPixels(i, i2, i3, i4, 6408, 5121, wrap);
            for (int i6 = 0; i6 < i4; i6++) {
                int i7 = i6 * i3;
                int i8 = ((i4 - i6) - 1) * i3;
                for (int i9 = 0; i9 < i3; i9++) {
                    int i10 = iArr[i7 + i9];
                    iArr2[i8 + i9] = (i10 & -16711936) | ((i10 << 16) & 16711680) | ((i10 >> 16) & 255);
                }
            }
            return Bitmap.createBitmap(iArr2, i3, i4, Bitmap.Config.ARGB_8888);
        } catch (GLException unused) {
            return null;
        }
    }

    public PointerEvents getPointerEvents() {
        return this.mPointerEvents;
    }

    /* access modifiers changed from: package-private */
    public void setPointerEvents(PointerEvents pointerEvents) {
        this.mPointerEvents = pointerEvents;
    }

    static <A> Set<A> diff(Set<A> set, Set<A> set2) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(set);
        hashSet.removeAll(set2);
        return hashSet;
    }

    public void setPixelRatio(float f) {
        this.pixelRatio = f;
        syncSize(getWidth(), getHeight(), f);
    }

    private void syncSize(int i, int i2, float f) {
        float f2 = this.displayDensity;
        getHolder().setFixedSize((int) ((((float) i) * f) / f2), (int) ((((float) i2) * f) / f2));
    }
}

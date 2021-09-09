package com.hs.hyfisheyepano;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

public class GLFisheyeView extends GLSurfaceView implements View.OnTouchListener {
    private static String TAG = "GLFisheyeView";
    protected static int height = 0;
    protected static int itype = 0;
    protected static float thrsSpeedX = 2.0f;
    protected static int width = 0;
    protected float MOVE_LEARN_RATE;
    protected int TIMER_INTERVAL;
    protected volatile boolean bJniImagePassing;
    protected boolean bNewData;
    protected boolean bScale;
    protected boolean bclear;
    protected boolean bhavesendmessage;
    public int displayMode;
    private float fMoveDistX;
    private float fMoveDistY;
    protected float fSpeedX;
    protected float fSpeedX0;
    protected float fSpeedY;
    protected float fSpeedY0;
    private int imode;
    public boolean isScaleZoom;
    private long lPrevClickTime;
    public long lScaleTime;
    public int[] mBuffer;
    private OnCustomClickListener mCustomClickListener;
    private int mFisheyeOnIndex;
    private GestureDetector mGestureDetector;
    Handler mHandler;
    private boolean mIsNeedClearData;
    private OnGLFisheyeChangeLister mOnGLFisheyeChangeLister;
    private OnSelectedChangeListener mOnSelectedChangeListener;
    private float mPrevX;
    private float mPrevY;
    private Renderer mRenderer;
    private ScaleGestureDetector mScaleGestureDetector;
    private int mSelectedIndex;
    private OnSurfaceChangedListener mSurfaceChangedListener;
    private List<Boolean> mUseStateList;
    private int m_col;
    private boolean m_isFisheyeON;
    public int m_paddingB;
    public int m_paddingL;
    public int m_paddingR;
    public int m_paddingT;
    private int m_row;
    public int m_spacing;
    public int m_viewH;
    public int m_viewW;
    private int nClick;
    public int objectIndex;
    public OnRenderListener onRenderListener;
    private Paint paint;
    private float selectedBoxColorA;
    private float selectedBoxColorB;
    private float selectedBoxColorG;
    private float selectedBoxColorR;

    static {
        try {
            System.loadLibrary("HYFisheyePano");
        } catch (Exception e) {
            e.printStackTrace();
            String str = TAG;
            Log.e(str, "load lib error: " + e.toString());
        }
    }

    public void setOnRenderListener(OnRenderListener onRenderListener2) {
        this.onRenderListener = onRenderListener2;
    }

    public GLFisheyeView(Context context) {
        super(context);
        this.mPrevX = 0.0f;
        this.mPrevY = 0.0f;
        this.imode = 0;
        this.mBuffer = null;
        this.mScaleGestureDetector = null;
        this.mGestureDetector = null;
        this.bJniImagePassing = false;
        this.TIMER_INTERVAL = 30;
        this.MOVE_LEARN_RATE = 0.05f;
        this.fSpeedX = 0.0f;
        this.fSpeedY = 0.0f;
        this.fSpeedX0 = 0.0f;
        this.fSpeedY0 = 0.0f;
        this.bScale = false;
        this.bNewData = false;
        this.bhavesendmessage = false;
        this.bclear = true;
        this.m_col = 1;
        this.m_row = 1;
        this.m_isFisheyeON = false;
        this.mFisheyeOnIndex = 0;
        this.mSelectedIndex = 0;
        this.mUseStateList = new ArrayList();
        this.mIsNeedClearData = false;
        this.selectedBoxColorR = 0.29f;
        this.selectedBoxColorG = 0.54f;
        this.selectedBoxColorB = 1.0f;
        this.selectedBoxColorA = 1.0f;
        this.displayMode = 0;
        this.isScaleZoom = true;
        this.lPrevClickTime = 0;
        this.nClick = 0;
        this.fMoveDistX = 0.0f;
        this.fMoveDistY = 0.0f;
        this.mHandler = new Handler(new Handler.Callback() {
            /* class com.hs.hyfisheyepano.GLFisheyeView.AnonymousClass1 */

            public boolean handleMessage(Message message) {
                Bundle data;
                int i = message.what;
                if (i == 1) {
                    GLFisheyeView.this.bJniImagePassing = false;
                } else if (i == 11 && (data = message.getData()) != null) {
                    int i2 = data.getInt("Add_image_task_colorType");
                    int i3 = data.getInt("Add_image_task_width");
                    int i4 = data.getInt("Add_image_task_height");
                    byte[] byteArray = data.getByteArray("Add_image_task_data");
                    GLFisheyeView gLFisheyeView = GLFisheyeView.this;
                    gLFisheyeView.bJniImagePassing = false;
                    GL2JNILIb.GLYUVSetImage(gLFisheyeView.objectIndex, message.arg1, i2, byteArray, i3, i4, message.arg2);
                    GLFisheyeView gLFisheyeView2 = GLFisheyeView.this;
                    gLFisheyeView2.bNewData = true;
                    gLFisheyeView2.bhavesendmessage = true;
                    if (gLFisheyeView2.onRenderListener != null) {
                        GLFisheyeView.this.onRenderListener.onRender(i3, i4);
                    }
                    GLFisheyeView.this.bclear = false;
                }
                return false;
            }
        });
        this.lScaleTime = 0;
        this.m_col = 1;
        this.m_row = 1;
        this.m_spacing = 0;
        this.m_paddingL = 0;
        this.m_paddingT = 0;
        this.m_paddingR = 0;
        this.m_paddingB = 0;
        init(false, 0, 0);
        this.objectIndex = GL2JNILIb.GLYUVInit(1, 1);
        GL2JNILIb.SelectedBoxColor(this.objectIndex, this.selectedBoxColorR, this.selectedBoxColorG, this.selectedBoxColorB, this.selectedBoxColorA);
        GL2JNILIb.GLYUVSetScale(this.objectIndex, true);
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new ScaleGestureListener());
        this.mGestureDetector = new GestureDetector(context, new GestureListener());
    }

    public GLFisheyeView(Context context, int i, int i2) {
        super(context);
        this.mPrevX = 0.0f;
        this.mPrevY = 0.0f;
        this.imode = 0;
        this.mBuffer = null;
        this.mScaleGestureDetector = null;
        this.mGestureDetector = null;
        this.bJniImagePassing = false;
        this.TIMER_INTERVAL = 30;
        this.MOVE_LEARN_RATE = 0.05f;
        this.fSpeedX = 0.0f;
        this.fSpeedY = 0.0f;
        this.fSpeedX0 = 0.0f;
        this.fSpeedY0 = 0.0f;
        this.bScale = false;
        this.bNewData = false;
        this.bhavesendmessage = false;
        this.bclear = true;
        this.m_col = 1;
        this.m_row = 1;
        this.m_isFisheyeON = false;
        this.mFisheyeOnIndex = 0;
        this.mSelectedIndex = 0;
        this.mUseStateList = new ArrayList();
        this.mIsNeedClearData = false;
        this.selectedBoxColorR = 0.29f;
        this.selectedBoxColorG = 0.54f;
        this.selectedBoxColorB = 1.0f;
        this.selectedBoxColorA = 1.0f;
        this.displayMode = 0;
        this.isScaleZoom = true;
        this.lPrevClickTime = 0;
        this.nClick = 0;
        this.fMoveDistX = 0.0f;
        this.fMoveDistY = 0.0f;
        this.mHandler = new Handler(new Handler.Callback() {
            /* class com.hs.hyfisheyepano.GLFisheyeView.AnonymousClass1 */

            public boolean handleMessage(Message message) {
                Bundle data;
                int i = message.what;
                if (i == 1) {
                    GLFisheyeView.this.bJniImagePassing = false;
                } else if (i == 11 && (data = message.getData()) != null) {
                    int i2 = data.getInt("Add_image_task_colorType");
                    int i3 = data.getInt("Add_image_task_width");
                    int i4 = data.getInt("Add_image_task_height");
                    byte[] byteArray = data.getByteArray("Add_image_task_data");
                    GLFisheyeView gLFisheyeView = GLFisheyeView.this;
                    gLFisheyeView.bJniImagePassing = false;
                    GL2JNILIb.GLYUVSetImage(gLFisheyeView.objectIndex, message.arg1, i2, byteArray, i3, i4, message.arg2);
                    GLFisheyeView gLFisheyeView2 = GLFisheyeView.this;
                    gLFisheyeView2.bNewData = true;
                    gLFisheyeView2.bhavesendmessage = true;
                    if (gLFisheyeView2.onRenderListener != null) {
                        GLFisheyeView.this.onRenderListener.onRender(i3, i4);
                    }
                    GLFisheyeView.this.bclear = false;
                }
                return false;
            }
        });
        this.lScaleTime = 0;
        this.m_col = i2;
        this.m_row = i;
        this.m_spacing = 2;
        this.m_paddingL = 1;
        this.m_paddingT = 1;
        this.m_paddingR = 1;
        this.m_paddingB = 1;
        init(false, 0, 0);
        this.objectIndex = GL2JNILIb.GLYUVInit(i2, i);
        GL2JNILIb.SelectedBoxColor(this.objectIndex, this.selectedBoxColorR, this.selectedBoxColorG, this.selectedBoxColorB, this.selectedBoxColorA);
        for (int i3 = 0; i3 < i2 * i; i3++) {
            this.mUseStateList.add(Boolean.FALSE);
        }
        GL2JNILIb.GLYUVSetScale(this.objectIndex, true);
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new ScaleGestureListener());
        this.mGestureDetector = new GestureDetector(context, new GestureListener());
    }

    public GLFisheyeView(Context context, boolean z, int i, int i2) {
        super(context);
        this.mPrevX = 0.0f;
        this.mPrevY = 0.0f;
        this.imode = 0;
        this.mBuffer = null;
        this.mScaleGestureDetector = null;
        this.mGestureDetector = null;
        this.bJniImagePassing = false;
        this.TIMER_INTERVAL = 30;
        this.MOVE_LEARN_RATE = 0.05f;
        this.fSpeedX = 0.0f;
        this.fSpeedY = 0.0f;
        this.fSpeedX0 = 0.0f;
        this.fSpeedY0 = 0.0f;
        this.bScale = false;
        this.bNewData = false;
        this.bhavesendmessage = false;
        this.bclear = true;
        this.m_col = 1;
        this.m_row = 1;
        this.m_isFisheyeON = false;
        this.mFisheyeOnIndex = 0;
        this.mSelectedIndex = 0;
        this.mUseStateList = new ArrayList();
        this.mIsNeedClearData = false;
        this.selectedBoxColorR = 0.29f;
        this.selectedBoxColorG = 0.54f;
        this.selectedBoxColorB = 1.0f;
        this.selectedBoxColorA = 1.0f;
        this.displayMode = 0;
        this.isScaleZoom = true;
        this.lPrevClickTime = 0;
        this.nClick = 0;
        this.fMoveDistX = 0.0f;
        this.fMoveDistY = 0.0f;
        this.mHandler = new Handler(new Handler.Callback() {
            /* class com.hs.hyfisheyepano.GLFisheyeView.AnonymousClass1 */

            public boolean handleMessage(Message message) {
                Bundle data;
                int i = message.what;
                if (i == 1) {
                    GLFisheyeView.this.bJniImagePassing = false;
                } else if (i == 11 && (data = message.getData()) != null) {
                    int i2 = data.getInt("Add_image_task_colorType");
                    int i3 = data.getInt("Add_image_task_width");
                    int i4 = data.getInt("Add_image_task_height");
                    byte[] byteArray = data.getByteArray("Add_image_task_data");
                    GLFisheyeView gLFisheyeView = GLFisheyeView.this;
                    gLFisheyeView.bJniImagePassing = false;
                    GL2JNILIb.GLYUVSetImage(gLFisheyeView.objectIndex, message.arg1, i2, byteArray, i3, i4, message.arg2);
                    GLFisheyeView gLFisheyeView2 = GLFisheyeView.this;
                    gLFisheyeView2.bNewData = true;
                    gLFisheyeView2.bhavesendmessage = true;
                    if (gLFisheyeView2.onRenderListener != null) {
                        GLFisheyeView.this.onRenderListener.onRender(i3, i4);
                    }
                    GLFisheyeView.this.bclear = false;
                }
                return false;
            }
        });
        this.lScaleTime = 0;
        this.m_col = 1;
        this.m_row = 1;
        this.m_spacing = 0;
        this.m_paddingL = 0;
        this.m_paddingT = 0;
        this.m_paddingR = 0;
        this.m_paddingB = 0;
        init(z, i, i2);
        this.objectIndex = GL2JNILIb.GLYUVInit(1, 1);
        GL2JNILIb.SelectedBoxColor(this.objectIndex, this.selectedBoxColorR, this.selectedBoxColorG, this.selectedBoxColorB, this.selectedBoxColorA);
    }

    public void onPause() {
        super.onPause();
        clearData(true);
        this.bNewData = false;
        GL2JNILIb.DeleteGLBuffer(this.objectIndex);
    }

    public void onResume() {
        super.onResume();
        clearData(false);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    private void init(boolean z, int i, int i2) {
        if (z) {
            getHolder().setFormat(-3);
        }
        setEGLContextFactory(new ContextFactory());
        setEGLConfigChooser(z ? new ConfigChooser(8, 8, 8, 8, i, i2) : new ConfigChooser(5, 6, 5, 0, i, i2));
        this.mRenderer = new Renderer();
        setRenderer(this.mRenderer);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setColor(-911593);
        this.paint.setStrokeWidth(10.0f);
    }

    static class ContextFactory implements GLSurfaceView.EGLContextFactory {
        private ContextFactory() {
        }

        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            GLFisheyeView.checkEglError("Before eglCreateContext", egl10);
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            GLFisheyeView.checkEglError("After eglCreateContext", egl10);
            return eglCreateContext;
        }

        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    public static void checkEglError(String str, EGL10 egl10) {
        do {
        } while (egl10.eglGetError() != 12288);
    }

    static class ConfigChooser implements GLSurfaceView.EGLConfigChooser {
        private static int EGL_OPENGL_ES2_BIT = 4;
        private static int[] s_configAttribs2 = {12324, 4, 12323, 4, 12322, 4, 12352, EGL_OPENGL_ES2_BIT, 12344};
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue = new int[1];

        public ConfigChooser(int i, int i2, int i3, int i4, int i5, int i6) {
            this.mRedSize = i;
            this.mGreenSize = i2;
            this.mBlueSize = i3;
            this.mAlphaSize = i4;
            this.mDepthSize = i5;
            this.mStencilSize = i6;
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, s_configAttribs2, null, 0, iArr);
            int i = iArr[0];
            if (i > 0) {
                EGLConfig[] eGLConfigArr = new EGLConfig[i];
                egl10.eglChooseConfig(eGLDisplay, s_configAttribs2, eGLConfigArr, i, iArr);
                return chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            }
            throw new IllegalArgumentException("No configs match configSpec");
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                EGL10 egl102 = egl10;
                EGLDisplay eGLDisplay2 = eGLDisplay;
                EGLConfig eGLConfig2 = eGLConfig;
                int findConfigAttrib = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, 12325, 0);
                int findConfigAttrib2 = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, 12326, 0);
                if (findConfigAttrib >= this.mDepthSize && findConfigAttrib2 >= this.mStencilSize) {
                    EGL10 egl103 = egl10;
                    EGLDisplay eGLDisplay3 = eGLDisplay;
                    EGLConfig eGLConfig3 = eGLConfig;
                    int findConfigAttrib3 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12324, 0);
                    int findConfigAttrib4 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12323, 0);
                    int findConfigAttrib5 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12322, 0);
                    int findConfigAttrib6 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12321, 0);
                    if (findConfigAttrib3 == this.mRedSize && findConfigAttrib4 == this.mGreenSize && findConfigAttrib5 == this.mBlueSize && findConfigAttrib6 == this.mAlphaSize) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue) ? this.mValue[0] : i2;
        }

        private void printConfigs(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig printConfig : eGLConfigArr) {
                printConfig(egl10, eGLDisplay, printConfig);
            }
        }

        private void printConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336, 12337, 12338, 12339, 12340, 12343, 12342, 12341, 12345, 12346, 12347, 12348, 12349, 12350, 12351, 12352, 12354};
            new String[]{"EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT"};
            int[] iArr2 = new int[1];
            for (int i = 0; i < 33; i++) {
                if (!egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, iArr[i], iArr2)) {
                    do {
                    } while (egl10.eglGetError() != 12288);
                }
            }
        }
    }

    class Renderer implements GLSurfaceView.Renderer {
        private OnSurfaceChangedListener surfaceChangedListener;

        private Renderer() {
        }

        /* access modifiers changed from: package-private */
        public void setSurfaceChangedListener(OnSurfaceChangedListener onSurfaceChangedListener) {
            this.surfaceChangedListener = onSurfaceChangedListener;
        }

        public void onDrawFrame(GL10 gl10) {
            if (GLFisheyeView.this.bhavesendmessage) {
                GLFisheyeView gLFisheyeView = GLFisheyeView.this;
                gLFisheyeView.bclear = false;
                if (gLFisheyeView.bNewData) {
                    GL2JNILIb.GLYUVRender(GLFisheyeView.this.objectIndex);
                }
            } else if (GLFisheyeView.this.bclear) {
                GL2JNILIb.GLYUVClearSurface(GLFisheyeView.this.objectIndex);
            }
        }

        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLFisheyeView gLFisheyeView = GLFisheyeView.this;
            gLFisheyeView.m_viewW = i;
            gLFisheyeView.m_viewH = i2;
            GL2JNILIb.GLYUVResize(gLFisheyeView.objectIndex, i, i2, GLFisheyeView.this.m_spacing, GLFisheyeView.this.m_paddingT, GLFisheyeView.this.m_paddingB, GLFisheyeView.this.m_paddingL, GLFisheyeView.this.m_paddingR);
            OnSurfaceChangedListener onSurfaceChangedListener = this.surfaceChangedListener;
            if (onSurfaceChangedListener != null) {
                onSurfaceChangedListener.onSurfaceChangedListener(i, i2, GLFisheyeView.this.m_spacing, GLFisheyeView.this.m_paddingL, GLFisheyeView.this.m_paddingT, GLFisheyeView.this.m_paddingR, GLFisheyeView.this.m_paddingB);
            }
        }

        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            GL2JNILIb.GLYUVClearSurface(GLFisheyeView.this.objectIndex);
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            super.finalize();
            GLFisheyeView gLFisheyeView = GLFisheyeView.this;
            gLFisheyeView.bclear = false;
            gLFisheyeView.bhavesendmessage = false;
        }
    }

    public void clean() {
        onPause();
    }

    public void clean(int i) {
        GL2JNILIb.GLYUVClear(this.objectIndex, i);
    }

    public void release() {
        GL2JNILIb.GLYUVClearAll(this.objectIndex);
    }

    public void resetZoomView() {
        GL2JNILIb.ResetZoomView(this.objectIndex);
    }

    public void zoomView() {
        GL2JNILIb.ZoomView(this.objectIndex);
    }

    public float getZoom() {
        return GL2JNILIb.GetZoom(this.objectIndex);
    }

    public void setImageParam(int i, int i2, int i3, int i4) {
        setImageParam(0, i, i2, i3, i4);
    }

    public void setImageParam(int i, int i2, int i3, int i4, int i5) {
        GL2JNILIb.GLYUVSetPanoParam(this.objectIndex, i, i2, (float) i3, (float) i4, (float) i5);
    }

    public void clearsurface() {
        this.bclear = true;
    }

    public void clearSurface() {
        this.bhavesendmessage = false;
        this.bclear = true;
        GL2JNILIb.GLYUVClearSurface(this.objectIndex);
    }

    public void clearData(boolean z) {
        this.mIsNeedClearData = z;
        if (z) {
            this.mHandler.removeMessages(11);
            this.bJniImagePassing = false;
        }
    }

    public void reStartRender() {
        this.bhavesendmessage = true;
        OnRenderListener onRenderListener2 = this.onRenderListener;
        if (onRenderListener2 != null) {
            onRenderListener2.onRender(width, height);
        }
    }

    public void setImage(Bitmap bitmap) {
        setImage(0, bitmap);
    }

    public void setImage(int i, Bitmap bitmap) {
        if (!this.bJniImagePassing) {
            synchronized (this) {
                this.bJniImagePassing = true;
                if (this.mBuffer == null) {
                    this.mBuffer = new int[17280000];
                }
                width = bitmap.getWidth();
                height = bitmap.getHeight();
                bitmap.getPixels(this.mBuffer, 0, width, 0, 0, width, height);
                Message obtainMessage = this.mHandler.obtainMessage(1);
                obtainMessage.obj = "Add image task";
                obtainMessage.arg1 = i;
                this.mHandler.sendMessage(obtainMessage);
            }
        }
    }

    public void setYUVImage(byte[] bArr, int i, int i2, int i3) {
        setYUVImage(0, bArr, i, i2, i3, 0);
    }

    public void setYUVImage(int i, byte[] bArr, int i2, int i3, int i4, int i5) {
        if (!this.mIsNeedClearData && i2 > 0 && i3 > 0 && !this.bJniImagePassing) {
            synchronized (this) {
                this.bJniImagePassing = true;
                Message obtainMessage = this.mHandler.obtainMessage(11);
                obtainMessage.obj = "Add image task";
                obtainMessage.arg1 = i;
                obtainMessage.arg2 = i5;
                Bundle bundle = new Bundle();
                bundle.putInt("Add_image_task_colorType", i4);
                bundle.putInt("Add_image_task_width", i2);
                bundle.putInt("Add_image_task_height", i3);
                bundle.putByteArray("Add_image_task_data", bArr);
                obtainMessage.setData(bundle);
                this.mHandler.sendMessage(obtainMessage);
            }
        }
    }

    public void setMode(int i) {
        this.displayMode = i;
        GL2JNILIb.GLYUVFisheyeSetExpandMode(this.objectIndex, i);
        this.nClick = 0;
    }

    public void setScaleZoom(boolean z) {
        this.isScaleZoom = z;
    }

    public void setFisheyeON(int i) {
        this.m_isFisheyeON = true;
        this.mFisheyeOnIndex = i;
        GL2JNILIb.GLYUVFisheyeON(this.objectIndex, i);
        OnGLFisheyeChangeLister onGLFisheyeChangeLister = this.mOnGLFisheyeChangeLister;
        if (onGLFisheyeChangeLister != null) {
            onGLFisheyeChangeLister.onGLFisheyeChange(i, false);
        }
    }

    public void setFisheyeOFF() {
        this.m_isFisheyeON = false;
        GL2JNILIb.GLYUVFisheyeOFF(this.objectIndex);
        OnGLFisheyeChangeLister onGLFisheyeChangeLister = this.mOnGLFisheyeChangeLister;
        if (onGLFisheyeChangeLister != null) {
            onGLFisheyeChangeLister.onGLFisheyeChange(this.mFisheyeOnIndex, true);
        }
    }

    public boolean isMulti() {
        return !this.m_isFisheyeON;
    }

    public void setPositionON(int i, boolean z) {
        if (i >= 0 && i < this.mUseStateList.size()) {
            this.mUseStateList.set(i, Boolean.valueOf(z));
        }
        GL2JNILIb.GLYUVSetPositionON(this.objectIndex, i, z);
    }

    public void setSelect(int i) {
        if (i != this.mSelectedIndex && this.mUseStateList.get(i).booleanValue()) {
            this.mSelectedIndex = i;
            GL2JNILIb.GLYUVSetSelected(this.objectIndex, i);
            OnSelectedChangeListener onSelectedChangeListener = this.mOnSelectedChangeListener;
            if (onSelectedChangeListener != null) {
                onSelectedChangeListener.onSelectedChange(i);
            }
        }
    }

    public int getClickPosition(float f, float f2) {
        float f3 = f / ((float) this.m_viewW);
        float f4 = f2 / ((float) this.m_viewH);
        int i = 0;
        while (true) {
            int i2 = this.m_row;
            int i3 = this.m_col;
            if (i >= i2 * i3) {
                break;
            }
            float f5 = ((float) (i % i3)) * (1.0f / ((float) i3));
            float f6 = ((float) ((i % i3) + 1)) * (1.0f / ((float) i3));
            float f7 = ((float) ((i / i3) % i2)) * (1.0f / ((float) i2));
            float f8 = ((float) (((i / i3) % i2) + 1)) * (1.0f / ((float) i2));
            if (f3 >= f5 && f3 <= f6 && f4 >= f7 && f4 <= f8) {
                break;
            }
            i++;
        }
        return i;
    }

    public boolean getIndexON(int i) {
        if (i < 0 || i >= this.mUseStateList.size()) {
            return false;
        }
        return this.mUseStateList.get(i).booleanValue();
    }

    public void setScale(boolean z) {
        GL2JNILIb.GLYUVSetScale(this.objectIndex, z);
    }

    public void setSelectedBoxColor(float f, float f2, float f3, float f4) {
        GL2JNILIb.SelectedBoxColor(this.objectIndex, f, f2, f3, f4);
    }

    public void setClickListener(OnCustomClickListener onCustomClickListener) {
        this.mCustomClickListener = onCustomClickListener;
    }

    public void setGLFisheyeChangeLister(OnGLFisheyeChangeLister onGLFisheyeChangeLister) {
        this.mOnGLFisheyeChangeLister = onGLFisheyeChangeLister;
    }

    public void setSurfaceChangedListener(OnSurfaceChangedListener onSurfaceChangedListener) {
        this.mSurfaceChangedListener = onSurfaceChangedListener;
        this.mRenderer.setSurfaceChangedListener(this.mSurfaceChangedListener);
    }

    public void setSelectedChangeListener(OnSelectedChangeListener onSelectedChangeListener) {
        this.mOnSelectedChangeListener = onSelectedChangeListener;
    }

    public void onDestroy() {
        this.mScaleGestureDetector = null;
        this.mGestureDetector = null;
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public static float pointDistance(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        long currentTimeMillis = System.currentTimeMillis();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.fSpeedX = 0.0f;
            this.fSpeedY = 0.0f;
            this.mPrevX = motionEvent.getX();
            this.mPrevY = motionEvent.getY();
            GL2JNILIb.GLYUVFisheyePressView(this.objectIndex, true, this.mPrevX, this.mPrevY);
        } else if (action == 1) {
            GL2JNILIb.GLYUVFisheyePressView(this.objectIndex, false, 0.0f, 0.0f);
            if (currentTimeMillis - this.lPrevClickTime > 200) {
                this.nClick = 0;
            }
            if (this.nClick == 0) {
                this.lPrevClickTime = currentTimeMillis;
                this.fMoveDistX = 0.0f;
                this.fMoveDistY = 0.0f;
            }
            this.nClick++;
            int i = this.nClick;
            if (i == 1) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.fMoveDistX = x;
                this.fMoveDistY = y;
                clickPosition(x, y);
            } else if (i >= 2) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                if (Math.abs(x2 - this.fMoveDistX) < 100.0f && Math.abs(y2 - this.fMoveDistY) < 100.0f) {
                    int clickPosition = getClickPosition(x2, y2);
                    OnCustomClickListener onCustomClickListener = this.mCustomClickListener;
                    if (onCustomClickListener != null) {
                        onCustomClickListener.onDoubleClick(clickPosition);
                    }
                    GL2JNILIb.GLYUVFisheyeDblClickView(this.objectIndex, x2, y2);
                }
                this.nClick = 0;
            }
        } else if (action == 2 && motionEvent.getPointerCount() == 1) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            this.fSpeedX0 = x3 - this.mPrevX;
            this.fSpeedY0 = y3 - this.mPrevY;
            this.mPrevX = x3;
            this.mPrevY = y3;
        }
        if (motionEvent.getPointerCount() == 1 && (gestureDetector = this.mGestureDetector) != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
        ScaleGestureDetector scaleGestureDetector = this.mScaleGestureDetector;
        if (scaleGestureDetector != null) {
            scaleGestureDetector.onTouchEvent(motionEvent);
        }
        return true;
    }

    private void clickPosition(float f, float f2) {
        int clickPosition = getClickPosition(f, f2);
        OnCustomClickListener onCustomClickListener = this.mCustomClickListener;
        if (onCustomClickListener != null) {
            onCustomClickListener.onClick(clickPosition);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 1) {
            this.mGestureDetector.onTouchEvent(motionEvent);
        }
        this.mScaleGestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    public class ScaleGestureListener implements ScaleGestureDetector.OnScaleGestureListener {
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }

        public ScaleGestureListener() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (!GLFisheyeView.this.isScaleZoom && GLFisheyeView.this.displayMode == 13) {
                return false;
            }
            float scaleFactor = 1.0f - scaleGestureDetector.getScaleFactor();
            if (scaleFactor != 0.0f) {
                GL2JNILIb.GLYUVFisheyeZoomView(GLFisheyeView.this.objectIndex, scaleFactor);
            }
            GLFisheyeView.this.lScaleTime = System.currentTimeMillis();
            GLFisheyeView.this.bScale = true;
            return false;
        }
    }

    class GestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        GestureListener() {
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (System.currentTimeMillis() - GLFisheyeView.this.lScaleTime > 500) {
                GLFisheyeView.this.bScale = false;
            }
            if (GLFisheyeView.this.bScale) {
                return true;
            }
            GL2JNILIb.GLYUVFisheyeMoveView(GLFisheyeView.this.objectIndex, motionEvent2.getX(), motionEvent2.getY());
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            GL2JNILIb.GLYUVFisheyeFlipView(GLFisheyeView.this.objectIndex, f, f2);
            return true;
        }
    }

    public void onRenderCall() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() {
                /* class com.hs.hyfisheyepano.GLFisheyeView.AnonymousClass2 */

                public void run() {
                    if (GLFisheyeView.this.onRenderListener != null) {
                        GLFisheyeView.this.onRenderListener.onRender(GLFisheyeView.width, GLFisheyeView.height);
                    }
                    GLFisheyeView gLFisheyeView = GLFisheyeView.this;
                    gLFisheyeView.bhavesendmessage = true;
                    gLFisheyeView.bNewData = true;
                    gLFisheyeView.bclear = false;
                }
            }, 200);
            return;
        }
        OnRenderListener onRenderListener2 = this.onRenderListener;
        if (onRenderListener2 != null) {
            onRenderListener2.onRender(width, height);
        }
        this.bhavesendmessage = true;
        this.bNewData = true;
        this.bclear = false;
    }
}

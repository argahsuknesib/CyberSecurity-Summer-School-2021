package androidx.renderscript;

import _m_j.hm;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.SystemProperties;
import android.util.Log;
import java.lang.reflect.Method;

public class RenderScript {

    /* renamed from: O000000o  reason: collision with root package name */
    static boolean f2966O000000o;
    static boolean O00000Oo;
    static Method O00000o;
    static Object O00000o0;
    static Method O00000oO;
    static Object O00000oo = new Object();
    public static boolean O0000O0o = false;
    private static int O0000oOO = 0;
    int O0000OOo;
    O000000o O0000Oo;
    public int O0000Oo0;
    public Element O0000OoO;
    Element O0000Ooo;
    O00000o0 O0000o = null;
    Element O0000o0;
    Element O0000o00;
    Element O0000o0O;
    Element O0000o0o;
    private Context O0000oO;
    O00000Oo O0000oO0 = null;

    public static class O00000Oo implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        protected String f2968O000000o;
        protected int O00000Oo;

        public final void run() {
        }
    }

    public static class O00000o0 implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        protected int[] f2969O000000o;
        protected int O00000Oo;
        protected int O00000o0;

        public final void run() {
        }
    }

    /* access modifiers changed from: package-private */
    public native void nContextDeinitToClient(int i);

    /* access modifiers changed from: package-private */
    public native String nContextGetErrorMessage(int i);

    /* access modifiers changed from: package-private */
    public native int nContextGetUserMessage(int i, int[] iArr);

    /* access modifiers changed from: package-private */
    public native void nContextInitToClient(int i);

    /* access modifiers changed from: package-private */
    public native int nContextPeekMessage(int i, int[] iArr);

    /* access modifiers changed from: package-private */
    public native int nDeviceCreate();

    /* access modifiers changed from: package-private */
    public native void nDeviceDestroy(int i);

    /* access modifiers changed from: package-private */
    public native void nDeviceSetConfig(int i, int i2, int i3);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationCopyFromBitmap(int i, int i2, Bitmap bitmap);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationCopyToBitmap(int i, int i2, Bitmap bitmap);

    /* access modifiers changed from: package-private */
    public native int rsnAllocationCreateBitmapBackedAllocation(int i, int i2, int i3, Bitmap bitmap, int i4);

    /* access modifiers changed from: package-private */
    public native int rsnAllocationCreateBitmapRef(int i, int i2, Bitmap bitmap);

    /* access modifiers changed from: package-private */
    public native int rsnAllocationCreateFromAssetStream(int i, int i2, int i3, int i4);

    /* access modifiers changed from: package-private */
    public native int rsnAllocationCreateFromBitmap(int i, int i2, int i3, Bitmap bitmap, int i4);

    /* access modifiers changed from: package-private */
    public native int rsnAllocationCreateTyped(int i, int i2, int i3, int i4, int i5);

    /* access modifiers changed from: package-private */
    public native int rsnAllocationCubeCreateFromBitmap(int i, int i2, int i3, Bitmap bitmap, int i4);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationData1D(int i, int i2, int i3, int i4, int i5, byte[] bArr, int i6);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationData1D(int i, int i2, int i3, int i4, int i5, float[] fArr, int i6);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationData1D(int i, int i2, int i3, int i4, int i5, int[] iArr, int i6);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationData1D(int i, int i2, int i3, int i4, int i5, short[] sArr, int i6);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationData2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationData2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, byte[] bArr, int i9);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationData2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float[] fArr, int i9);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationData2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int[] iArr, int i9);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationData2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, short[] sArr, int i9);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationData2D(int i, int i2, int i3, int i4, int i5, int i6, Bitmap bitmap);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationData3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationData3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, byte[] bArr, int i10);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationData3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float[] fArr, int i10);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationData3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int[] iArr, int i10);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationData3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, short[] sArr, int i10);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationElementData1D(int i, int i2, int i3, int i4, int i5, byte[] bArr, int i6);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationGenerateMipmaps(int i, int i2);

    /* access modifiers changed from: package-private */
    public native int rsnAllocationGetType(int i, int i2);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationIoReceive(int i, int i2);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationIoSend(int i, int i2);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationRead(int i, int i2, byte[] bArr);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationRead(int i, int i2, float[] fArr);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationRead(int i, int i2, int[] iArr);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationRead(int i, int i2, short[] sArr);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationResize1D(int i, int i2, int i3);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationResize2D(int i, int i2, int i3, int i4);

    /* access modifiers changed from: package-private */
    public native void rsnAllocationSyncAll(int i, int i2, int i3);

    /* access modifiers changed from: package-private */
    public native int rsnContextCreate(int i, int i2, int i3, int i4);

    /* access modifiers changed from: package-private */
    public native void rsnContextDestroy(int i);

    /* access modifiers changed from: package-private */
    public native void rsnContextDump(int i, int i2);

    /* access modifiers changed from: package-private */
    public native void rsnContextFinish(int i);

    /* access modifiers changed from: package-private */
    public native void rsnContextSendMessage(int i, int i2, int[] iArr);

    /* access modifiers changed from: package-private */
    public native void rsnContextSetPriority(int i, int i2);

    /* access modifiers changed from: package-private */
    public native int rsnElementCreate(int i, int i2, int i3, boolean z, int i4);

    /* access modifiers changed from: package-private */
    public native int rsnElementCreate2(int i, int[] iArr, String[] strArr, int[] iArr2);

    /* access modifiers changed from: package-private */
    public native void rsnElementGetNativeData(int i, int i2, int[] iArr);

    /* access modifiers changed from: package-private */
    public native void rsnElementGetSubElements(int i, int i2, int[] iArr, String[] strArr, int[] iArr2);

    /* access modifiers changed from: package-private */
    public native void rsnObjDestroy(int i, int i2);

    /* access modifiers changed from: package-private */
    public native int rsnSamplerCreate(int i, int i2, int i3, int i4, int i5, int i6, float f);

    /* access modifiers changed from: package-private */
    public native void rsnScriptBindAllocation(int i, int i2, int i3, int i4);

    /* access modifiers changed from: package-private */
    public native int rsnScriptCCreate(int i, String str, String str2, byte[] bArr, int i2);

    /* access modifiers changed from: package-private */
    public native int rsnScriptFieldIDCreate(int i, int i2, int i3);

    /* access modifiers changed from: package-private */
    public native void rsnScriptForEach(int i, int i2, int i3, int i4, int i5);

    /* access modifiers changed from: package-private */
    public native void rsnScriptForEach(int i, int i2, int i3, int i4, int i5, byte[] bArr);

    /* access modifiers changed from: package-private */
    public native void rsnScriptForEachClipped(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11);

    /* access modifiers changed from: package-private */
    public native void rsnScriptForEachClipped(int i, int i2, int i3, int i4, int i5, byte[] bArr, int i6, int i7, int i8, int i9, int i10, int i11);

    /* access modifiers changed from: package-private */
    public native int rsnScriptGroupCreate(int i, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5);

    /* access modifiers changed from: package-private */
    public native void rsnScriptGroupExecute(int i, int i2);

    /* access modifiers changed from: package-private */
    public native void rsnScriptGroupSetInput(int i, int i2, int i3, int i4);

    /* access modifiers changed from: package-private */
    public native void rsnScriptGroupSetOutput(int i, int i2, int i3, int i4);

    /* access modifiers changed from: package-private */
    public native int rsnScriptIntrinsicCreate(int i, int i2, int i3);

    /* access modifiers changed from: package-private */
    public native void rsnScriptInvoke(int i, int i2, int i3);

    /* access modifiers changed from: package-private */
    public native void rsnScriptInvokeV(int i, int i2, int i3, byte[] bArr);

    /* access modifiers changed from: package-private */
    public native int rsnScriptKernelIDCreate(int i, int i2, int i3, int i4);

    /* access modifiers changed from: package-private */
    public native void rsnScriptSetTimeZone(int i, int i2, byte[] bArr);

    /* access modifiers changed from: package-private */
    public native void rsnScriptSetVarD(int i, int i2, int i3, double d);

    /* access modifiers changed from: package-private */
    public native void rsnScriptSetVarF(int i, int i2, int i3, float f);

    /* access modifiers changed from: package-private */
    public native void rsnScriptSetVarI(int i, int i2, int i3, int i4);

    /* access modifiers changed from: package-private */
    public native void rsnScriptSetVarJ(int i, int i2, int i3, long j);

    /* access modifiers changed from: package-private */
    public native void rsnScriptSetVarObj(int i, int i2, int i3, int i4);

    /* access modifiers changed from: package-private */
    public native void rsnScriptSetVarV(int i, int i2, int i3, byte[] bArr);

    /* access modifiers changed from: package-private */
    public native void rsnScriptSetVarVE(int i, int i2, int i3, byte[] bArr, int i4, int[] iArr);

    /* access modifiers changed from: package-private */
    public native int rsnTypeCreate(int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, int i6);

    /* access modifiers changed from: package-private */
    public native void rsnTypeGetNativeData(int i, int i2, int[] iArr);

    public enum ContextType {
        NORMAL(0),
        DEBUG(1),
        PROFILE(2);
        
        int mID;

        private ContextType(int i) {
            this.mID = i;
        }
    }

    private synchronized int O00000o0(int i, int i2, int i3) {
        return rsnContextCreate(i, 0, i2, i3);
    }

    private synchronized void O00000o0() {
        O000000o();
        rsnContextDestroy(this.O0000Oo0);
    }

    public final synchronized void O000000o(int i) {
        if (this.O0000Oo0 != 0) {
            rsnObjDestroy(this.O0000Oo0, i);
        }
    }

    public final synchronized int O000000o(int i, int i2, boolean z, int i3) {
        O000000o();
        return rsnElementCreate(this.O0000Oo0, i, i2, z, i3);
    }

    /* access modifiers changed from: package-private */
    public final synchronized int O000000o(int i, int i2, int i3, int i4, boolean z, boolean z2, int i5) {
        O000000o();
        return rsnTypeCreate(this.O0000Oo0, i, i2, i3, i4, z, z2, i5);
    }

    /* access modifiers changed from: package-private */
    public final synchronized int O000000o(int i, int i2, int i3) {
        O000000o();
        return rsnAllocationCreateTyped(this.O0000Oo0, i, i2, 1, 0);
    }

    /* access modifiers changed from: package-private */
    public final synchronized int O000000o(int i, int i2, Bitmap bitmap, int i3) {
        O000000o();
        return rsnAllocationCreateFromBitmap(this.O0000Oo0, i, i2, bitmap, i3);
    }

    /* access modifiers changed from: package-private */
    public final synchronized int O00000Oo(int i, int i2, Bitmap bitmap, int i3) {
        O000000o();
        return rsnAllocationCreateBitmapBackedAllocation(this.O0000Oo0, i, i2, bitmap, i3);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void O000000o(int i, Bitmap bitmap) {
        O000000o();
        rsnAllocationCopyToBitmap(this.O0000Oo0, i, bitmap);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void O00000Oo(int i, Bitmap bitmap) {
        O000000o();
        rsnAllocationCopyFromBitmap(this.O0000Oo0, i, bitmap);
    }

    public final synchronized void O000000o(int i, int i2, int i3, int i4, byte[] bArr) {
        O000000o();
        rsnScriptForEach(this.O0000Oo0, i, 0, 0, i4);
    }

    public final synchronized void O000000o(int i, int i2, float f) {
        O000000o();
        rsnScriptSetVarF(this.O0000Oo0, i, 0, f);
    }

    public final synchronized void O00000Oo(int i, int i2, int i3) {
        O000000o();
        rsnScriptSetVarObj(this.O0000Oo0, i, 1, i3);
    }

    public final synchronized int O00000Oo(int i) {
        O000000o();
        return rsnScriptIntrinsicCreate(this.O0000Oo0, 5, i);
    }

    public void O000000o() {
        if (this.O0000Oo0 == 0) {
            throw new RSInvalidStateException("Calling RS with no Context active.");
        }
    }

    static class O000000o extends Thread {

        /* renamed from: O000000o  reason: collision with root package name */
        RenderScript f2967O000000o;
        boolean O00000Oo = true;
        int[] O00000o0 = new int[2];

        O000000o(RenderScript renderScript) {
            super("RSMessageThread");
            this.f2967O000000o = renderScript;
        }

        public final void run() {
            int[] iArr = new int[16];
            RenderScript renderScript = this.f2967O000000o;
            renderScript.nContextInitToClient(renderScript.O0000Oo0);
            while (this.O00000Oo) {
                iArr[0] = 0;
                RenderScript renderScript2 = this.f2967O000000o;
                int nContextPeekMessage = renderScript2.nContextPeekMessage(renderScript2.O0000Oo0, this.O00000o0);
                int[] iArr2 = this.O00000o0;
                int i = iArr2[1];
                int i2 = iArr2[0];
                if (nContextPeekMessage == 4) {
                    if ((i >> 2) >= iArr.length) {
                        iArr = new int[((i + 3) >> 2)];
                    }
                    RenderScript renderScript3 = this.f2967O000000o;
                    if (renderScript3.nContextGetUserMessage(renderScript3.O0000Oo0, iArr) != 4) {
                        throw new RSDriverException("Error processing message from RenderScript.");
                    } else if (this.f2967O000000o.O0000o != null) {
                        this.f2967O000000o.O0000o.f2969O000000o = iArr;
                        this.f2967O000000o.O0000o.O00000Oo = i2;
                        this.f2967O000000o.O0000o.O00000o0 = i;
                        this.f2967O000000o.O0000o.run();
                    } else {
                        throw new RSInvalidStateException("Received a message from the script with no message handler installed.");
                    }
                } else if (nContextPeekMessage == 3) {
                    RenderScript renderScript4 = this.f2967O000000o;
                    String nContextGetErrorMessage = renderScript4.nContextGetErrorMessage(renderScript4.O0000Oo0);
                    if (i2 >= 4096) {
                        throw new RSRuntimeException("Fatal error " + i2 + ", details: " + nContextGetErrorMessage);
                    } else if (this.f2967O000000o.O0000oO0 != null) {
                        this.f2967O000000o.O0000oO0.f2968O000000o = nContextGetErrorMessage;
                        this.f2967O000000o.O0000oO0.O00000Oo = i2;
                        this.f2967O000000o.O0000oO0.run();
                    } else {
                        Log.e("RenderScript_jni", "non fatal RS error, ".concat(String.valueOf(nContextGetErrorMessage)));
                    }
                } else {
                    try {
                        sleep(1, 0);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    protected RenderScript(Context context) {
        if (context != null) {
            this.O0000oO = context.getApplicationContext();
        }
    }

    private static RenderScript O000000o(Context context, int i, ContextType contextType) {
        RenderScript renderScript = new RenderScript(context);
        if (O0000oOO == 0) {
            if (Build.VERSION.SDK_INT < 18 || SystemProperties.getInt("debug.rs.forcecompat", 0) != 0) {
                O0000oOO = -1;
            } else {
                O0000oOO = 1;
            }
        }
        if (O0000oOO == 1) {
            Log.v("RenderScript_jni", "RS native mode");
            return hm.O000000o(context, i);
        }
        synchronized (O00000oo) {
            if (!f2966O000000o) {
                try {
                    Class<?> cls = Class.forName("dalvik.system.VMRuntime");
                    O00000o0 = cls.getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]);
                    O00000o = cls.getDeclaredMethod("registerNativeAllocation", Integer.TYPE);
                    O00000oO = cls.getDeclaredMethod("registerNativeFree", Integer.TYPE);
                    O00000Oo = true;
                } catch (UnsatisfiedLinkError e) {
                    Log.e("RenderScript_jni", "Error loading RS jni library: ".concat(String.valueOf(e)));
                    throw new RSRuntimeException("Error loading RS jni library: ".concat(String.valueOf(e)));
                } catch (Exception unused) {
                    Log.e("RenderScript_jni", "No GC methods");
                    O00000Oo = false;
                }
                System.loadLibrary("RSSupport");
                System.loadLibrary("rsjni");
                f2966O000000o = true;
            }
        }
        Log.v("RenderScript_jni", "RS compat mode");
        renderScript.O0000OOo = renderScript.nDeviceCreate();
        renderScript.O0000Oo0 = renderScript.O00000o0(renderScript.O0000OOo, i, contextType.mID);
        if (renderScript.O0000Oo0 != 0) {
            renderScript.O0000Oo = new O000000o(renderScript);
            renderScript.O0000Oo.start();
            return renderScript;
        }
        throw new RSDriverException("Failed to create RS context.");
    }

    public static RenderScript O000000o(Context context) {
        return O000000o(context, context.getApplicationInfo().targetSdkVersion, ContextType.NORMAL);
    }

    public void O00000Oo() {
        O000000o();
        nContextDeinitToClient(this.O0000Oo0);
        O000000o o000000o = this.O0000Oo;
        o000000o.O00000Oo = false;
        try {
            o000000o.join();
        } catch (InterruptedException unused) {
        }
        O00000o0();
        this.O0000Oo0 = 0;
        nDeviceDestroy(this.O0000OOo);
        this.O0000OOo = 0;
    }
}

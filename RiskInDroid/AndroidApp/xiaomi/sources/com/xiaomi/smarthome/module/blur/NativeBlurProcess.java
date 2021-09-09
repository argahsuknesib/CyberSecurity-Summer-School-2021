package com.xiaomi.smarthome.module.blur;

import _m_j.gzh;
import _m_j.gzi;
import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class NativeBlurProcess implements gzh {
    public static native void functionToBlur(Bitmap bitmap, int i, int i2, int i3, int i4);

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    public final Bitmap O000000o(Bitmap bitmap, float f) {
        int i = gzi.O00000Oo;
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        ArrayList arrayList = new ArrayList(i);
        ArrayList arrayList2 = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            Bitmap bitmap2 = copy;
            int i3 = (int) f;
            int i4 = i;
            int i5 = i2;
            arrayList.add(new NativeTask(bitmap2, i3, i4, i5, 1));
            arrayList2.add(new NativeTask(bitmap2, i3, i4, i5, 2));
        }
        try {
            gzi.O00000o0.invokeAll(arrayList);
            gzi.O00000o0.invokeAll(arrayList2);
        } catch (InterruptedException unused) {
        }
        return copy;
    }

    static class NativeTask implements Callable<Void> {
        private final Bitmap _bitmapOut;
        private final int _coreIndex;
        private final int _radius;
        private final int _round;
        private final int _totalCores;

        public NativeTask(Bitmap bitmap, int i, int i2, int i3, int i4) {
            this._bitmapOut = bitmap;
            this._radius = i;
            this._totalCores = i2;
            this._coreIndex = i3;
            this._round = i4;
        }

        public Void call() throws Exception {
            NativeBlurProcess.functionToBlur(this._bitmapOut, this._radius, this._totalCores, this._coreIndex, this._round);
            return null;
        }
    }
}

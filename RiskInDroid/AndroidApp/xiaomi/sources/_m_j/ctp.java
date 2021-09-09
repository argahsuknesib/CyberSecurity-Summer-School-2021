package _m_j;

import android.os.AsyncTask;
import android.util.SparseArray;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.reactnative.camera.facedetector.RNFaceDetector;
import java.nio.ByteBuffer;

public final class ctp extends AsyncTask<Void, Void, SparseArray<Face>> {

    /* renamed from: O000000o  reason: collision with root package name */
    private byte[] f14348O000000o;
    private int O00000Oo;
    private int O00000o;
    private int O00000o0;
    private RNFaceDetector O00000oO;
    private ctq O00000oo;

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        super.onPostExecute(sparseArray);
        if (sparseArray == null) {
            this.O00000oo.O000000o(this.O00000oO);
            return;
        }
        this.O00000oo.O000000o(sparseArray, this.O00000Oo, this.O00000o0, this.O00000o);
        this.O00000oo.O00000Oo();
    }

    public ctp(ctq ctq, RNFaceDetector rNFaceDetector, byte[] bArr, int i, int i2, int i3) {
        this.f14348O000000o = bArr;
        this.O00000Oo = i;
        this.O00000o0 = i2;
        this.O00000o = i3;
        this.O00000oo = ctq;
        this.O00000oO = rNFaceDetector;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        RNFaceDetector rNFaceDetector;
        if (isCancelled() || this.O00000oo == null || (rNFaceDetector = this.O00000oO) == null || !rNFaceDetector.O000000o()) {
            return null;
        }
        byte[] bArr = this.f14348O000000o;
        int i = this.O00000Oo;
        int i2 = this.O00000o0;
        int i3 = this.O00000o;
        Frame.Builder builder = new Frame.Builder();
        builder.setImageData(ByteBuffer.wrap(bArr), i, i2, 17);
        if (i3 == 90) {
            builder.setRotation(1);
        } else if (i3 == 180) {
            builder.setRotation(2);
        } else if (i3 != 270) {
            builder.setRotation(0);
        } else {
            builder.setRotation(3);
        }
        return this.O00000oO.O000000o(new ctl(builder.build(), new cts(i, i2, i3)));
    }
}

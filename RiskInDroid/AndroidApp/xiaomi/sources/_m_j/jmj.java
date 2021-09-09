package _m_j;

import android.os.AsyncTask;
import android.util.SparseArray;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.vision.face.Face;
import org.reactnative.facedetector.RNFaceDetector;

public final class jmj extends AsyncTask<Void, Void, SparseArray<Face>> {

    /* renamed from: O000000o  reason: collision with root package name */
    private byte[] f1958O000000o;
    private int O00000Oo;
    private int O00000o;
    private int O00000o0;
    private RNFaceDetector O00000oO;
    private jmk O00000oo;
    private jmp O0000O0o;
    private double O0000OOo;
    private int O0000Oo;
    private double O0000Oo0;
    private int O0000OoO;

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        WritableMap writableMap;
        SparseArray sparseArray = (SparseArray) obj;
        super.onPostExecute(sparseArray);
        if (sparseArray == null) {
            this.O00000oo.O000000o(this.O00000oO);
            return;
        }
        if (sparseArray.size() > 0) {
            jmk jmk = this.O00000oo;
            WritableArray createArray = Arguments.createArray();
            for (int i = 0; i < sparseArray.size(); i++) {
                WritableMap O000000o2 = jms.O000000o((Face) sparseArray.valueAt(i), this.O0000OOo, this.O0000Oo0, this.O00000Oo, this.O00000o0, this.O0000Oo, this.O0000OoO);
                if (this.O0000O0o.f1962O000000o == 1) {
                    writableMap = jms.O000000o(O000000o2, this.O0000O0o.O000000o(), this.O0000OOo);
                } else {
                    writableMap = jms.O000000o(O000000o2);
                }
                createArray.pushMap(writableMap);
            }
            jmk.O000000o(createArray);
        }
        this.O00000oo.O00000Oo();
    }

    public jmj(jmk jmk, RNFaceDetector rNFaceDetector, byte[] bArr, int i, int i2, int i3, float f, int i4, int i5, int i6, int i7, int i8) {
        this.f1958O000000o = bArr;
        this.O00000Oo = i;
        this.O00000o0 = i2;
        this.O00000o = i3;
        this.O00000oo = jmk;
        this.O00000oO = rNFaceDetector;
        this.O0000O0o = new jmp(i, i2, i3, i4);
        double d = (double) i5;
        double O000000o2 = (double) (((float) this.O0000O0o.O000000o()) * f);
        Double.isNaN(d);
        Double.isNaN(O000000o2);
        this.O0000OOo = d / O000000o2;
        double d2 = (double) i6;
        double O00000Oo2 = (double) (((float) this.O0000O0o.O00000Oo()) * f);
        Double.isNaN(d2);
        Double.isNaN(O00000Oo2);
        this.O0000Oo0 = d2 / O00000Oo2;
        this.O0000Oo = i7;
        this.O0000OoO = i8;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        RNFaceDetector rNFaceDetector;
        if (isCancelled() || this.O00000oo == null || (rNFaceDetector = this.O00000oO) == null || !rNFaceDetector.O000000o()) {
            return null;
        }
        return this.O00000oO.O000000o(jmv.O000000o(this.f1958O000000o, this.O00000Oo, this.O00000o0, this.O00000o));
    }
}

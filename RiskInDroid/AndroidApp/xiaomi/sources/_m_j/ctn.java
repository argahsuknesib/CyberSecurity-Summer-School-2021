package _m_j;

import android.os.AsyncTask;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;

public final class ctn extends AsyncTask<Void, Void, Result> {

    /* renamed from: O000000o  reason: collision with root package name */
    private byte[] f14347O000000o;
    private int O00000Oo;
    private cto O00000o;
    private int O00000o0;
    private final MultiFormatReader O00000oO;

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return O000000o();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        Result result = (Result) obj;
        super.onPostExecute(result);
        if (result != null) {
            this.O00000o.O000000o(result);
        }
        this.O00000o.O000000o();
    }

    public ctn(cto cto, MultiFormatReader multiFormatReader, byte[] bArr, int i, int i2) {
        this.f14347O000000o = bArr;
        this.O00000Oo = i;
        this.O00000o0 = i2;
        this.O00000o = cto;
        this.O00000oO = multiFormatReader;
    }

    private Result O000000o() {
        if (isCancelled() || this.O00000o == null) {
            return null;
        }
        try {
            byte[] bArr = this.f14347O000000o;
            int i = this.O00000Oo;
            int i2 = this.O00000o0;
            return this.O00000oO.decodeWithState(new BinaryBitmap(new HybridBinarizer(new PlanarYUVLuminanceSource(bArr, i, i2, 0, 0, i, i2, false))));
        } catch (NotFoundException unused) {
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}

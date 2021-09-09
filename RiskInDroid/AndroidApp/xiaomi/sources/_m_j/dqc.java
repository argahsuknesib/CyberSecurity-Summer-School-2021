package _m_j;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.widget.ImageView;
import com.tmall.wireless.vaf.framework.VafContext;

public abstract class dqc extends dpf {

    /* renamed from: O000000o  reason: collision with root package name */
    public static SparseArray<ImageView.ScaleType> f14848O000000o;
    public String O000o00O;
    public int O000o00o = 1;

    public abstract void O000000o(Bitmap bitmap);

    public void O00000o0(String str) {
    }

    static {
        SparseArray<ImageView.ScaleType> sparseArray = new SparseArray<>();
        f14848O000000o = sparseArray;
        sparseArray.put(0, ImageView.ScaleType.MATRIX);
        f14848O000000o.put(1, ImageView.ScaleType.FIT_XY);
        f14848O000000o.put(2, ImageView.ScaleType.FIT_START);
        f14848O000000o.put(3, ImageView.ScaleType.FIT_CENTER);
        f14848O000000o.put(4, ImageView.ScaleType.FIT_END);
        f14848O000000o.put(5, ImageView.ScaleType.CENTER);
        f14848O000000o.put(6, ImageView.ScaleType.CENTER_CROP);
        f14848O000000o.put(7, ImageView.ScaleType.CENTER_INSIDE);
    }

    public dqc(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
        this.O000O0OO = "imgUrl";
    }

    public void O00000o() {
        super.O00000o();
        this.O000O00o = null;
    }

    public final boolean O000000o(int i, String str) {
        boolean O000000o2 = super.O000000o(i, str);
        if (O000000o2) {
            return O000000o2;
        }
        if (i != 114148) {
            return false;
        }
        if (bns.O000000o(str)) {
            this.O00000Oo.O000000o(this, 114148, str, 2);
            return true;
        }
        this.O000o00O = str;
        return true;
    }

    public final boolean O00000o0(int i, int i2) {
        boolean O00000o0 = super.O00000o0(i, i2);
        if (O00000o0) {
            return O00000o0;
        }
        if (i != -1877911644) {
            return false;
        }
        this.O000o00o = i2;
        return true;
    }
}

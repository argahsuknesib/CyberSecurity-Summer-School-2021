package pl.droidsonroids.gif;

import _m_j.jnw;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

class GifViewSavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<GifViewSavedState> CREATOR = new Parcelable.Creator<GifViewSavedState>() {
        /* class pl.droidsonroids.gif.GifViewSavedState.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GifViewSavedState[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GifViewSavedState(parcel, (byte) 0);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    final long[][] f15488O000000o;

    /* synthetic */ GifViewSavedState(Parcel parcel, byte b) {
        this(parcel);
    }

    GifViewSavedState(Parcelable parcelable, Drawable... drawableArr) {
        super(parcelable);
        this.f15488O000000o = new long[drawableArr.length][];
        for (int i = 0; i < drawableArr.length; i++) {
            Drawable drawable = drawableArr[i];
            if (drawable instanceof jnw) {
                this.f15488O000000o[i] = ((jnw) drawable).O00000oo.O0000o00();
            } else {
                this.f15488O000000o[i] = null;
            }
        }
    }

    private GifViewSavedState(Parcel parcel) {
        super(parcel);
        this.f15488O000000o = new long[parcel.readInt()][];
        int i = 0;
        while (true) {
            long[][] jArr = this.f15488O000000o;
            if (i < jArr.length) {
                jArr[i] = parcel.createLongArray();
                i++;
            } else {
                return;
            }
        }
    }

    GifViewSavedState(Parcelable parcelable, long[] jArr) {
        super(parcelable);
        this.f15488O000000o = new long[1][];
        this.f15488O000000o[0] = jArr;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f15488O000000o.length);
        for (long[] writeLongArray : this.f15488O000000o) {
            parcel.writeLongArray(writeLongArray);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(Drawable drawable, int i) {
        if (this.f15488O000000o[i] != null && (drawable instanceof jnw)) {
            jnw jnw = (jnw) drawable;
            jnw.O000000o((long) jnw.O00000oo.O000000o(this.f15488O000000o[i], jnw.O00000oO));
        }
    }
}

package androidx.fragment.app;

import _m_j.dy;
import _m_j.ef;
import _m_j.ei;
import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
public final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() {
        /* class androidx.fragment.app.BackStackState.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BackStackState[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    final int[] f2857O000000o;
    final ArrayList<String> O00000Oo;
    final int[] O00000o;
    final int[] O00000o0;
    final int O00000oO;
    final int O00000oo;
    final String O0000O0o;
    final int O0000OOo;
    final CharSequence O0000Oo;
    final int O0000Oo0;
    final int O0000OoO;
    final CharSequence O0000Ooo;
    final ArrayList<String> O0000o0;
    final ArrayList<String> O0000o00;
    final boolean O0000o0O;

    public final int describeContents() {
        return 0;
    }

    public BackStackState(dy dyVar) {
        int size = dyVar.O00000o.size();
        this.f2857O000000o = new int[(size * 5)];
        if (dyVar.O0000OoO) {
            this.O00000Oo = new ArrayList<>(size);
            this.O00000o0 = new int[size];
            this.O00000o = new int[size];
            int i = 0;
            int i2 = 0;
            while (i < size) {
                ei.O000000o o000000o = (ei.O000000o) dyVar.O00000o.get(i);
                int i3 = i2 + 1;
                this.f2857O000000o[i2] = o000000o.f15307O000000o;
                this.O00000Oo.add(o000000o.O00000Oo != null ? o000000o.O00000Oo.mWho : null);
                int i4 = i3 + 1;
                this.f2857O000000o[i3] = o000000o.O00000o0;
                int i5 = i4 + 1;
                this.f2857O000000o[i4] = o000000o.O00000o;
                int i6 = i5 + 1;
                this.f2857O000000o[i5] = o000000o.O00000oO;
                this.f2857O000000o[i6] = o000000o.O00000oo;
                this.O00000o0[i] = o000000o.O0000O0o.ordinal();
                this.O00000o[i] = o000000o.O0000OOo.ordinal();
                i++;
                i2 = i6 + 1;
            }
            this.O00000oO = dyVar.O0000Oo0;
            this.O00000oo = dyVar.O0000Oo;
            this.O0000O0o = dyVar.O0000o00;
            this.O0000OOo = dyVar.O00000o0;
            this.O0000Oo0 = dyVar.O0000o0;
            this.O0000Oo = dyVar.O0000o0O;
            this.O0000OoO = dyVar.O0000o0o;
            this.O0000Ooo = dyVar.O0000o;
            this.O0000o00 = dyVar.O0000oO0;
            this.O0000o0 = dyVar.O0000oO;
            this.O0000o0O = dyVar.O0000oOO;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel parcel) {
        this.f2857O000000o = parcel.createIntArray();
        this.O00000Oo = parcel.createStringArrayList();
        this.O00000o0 = parcel.createIntArray();
        this.O00000o = parcel.createIntArray();
        this.O00000oO = parcel.readInt();
        this.O00000oo = parcel.readInt();
        this.O0000O0o = parcel.readString();
        this.O0000OOo = parcel.readInt();
        this.O0000Oo0 = parcel.readInt();
        this.O0000Oo = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.O0000OoO = parcel.readInt();
        this.O0000Ooo = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.O0000o00 = parcel.createStringArrayList();
        this.O0000o0 = parcel.createStringArrayList();
        this.O0000o0O = parcel.readInt() != 0;
    }

    public final dy O000000o(ef efVar) {
        dy dyVar = new dy(efVar);
        int i = 0;
        int i2 = 0;
        while (i < this.f2857O000000o.length) {
            ei.O000000o o000000o = new ei.O000000o();
            int i3 = i + 1;
            o000000o.f15307O000000o = this.f2857O000000o[i];
            if (ef.O00000o0) {
                Log.v("FragmentManager", "Instantiate " + dyVar + " op #" + i2 + " base fragment #" + this.f2857O000000o[i3]);
            }
            String str = this.O00000Oo.get(i2);
            if (str != null) {
                o000000o.O00000Oo = efVar.O0000OOo.get(str);
            } else {
                o000000o.O00000Oo = null;
            }
            o000000o.O0000O0o = Lifecycle.State.values()[this.O00000o0[i2]];
            o000000o.O0000OOo = Lifecycle.State.values()[this.O00000o[i2]];
            int[] iArr = this.f2857O000000o;
            int i4 = i3 + 1;
            o000000o.O00000o0 = iArr[i3];
            int i5 = i4 + 1;
            o000000o.O00000o = iArr[i4];
            int i6 = i5 + 1;
            o000000o.O00000oO = iArr[i5];
            o000000o.O00000oo = iArr[i6];
            dyVar.O00000oO = o000000o.O00000o0;
            dyVar.O00000oo = o000000o.O00000o;
            dyVar.O0000O0o = o000000o.O00000oO;
            dyVar.O0000OOo = o000000o.O00000oo;
            dyVar.O00000Oo(o000000o);
            i2++;
            i = i6 + 1;
        }
        dyVar.O0000Oo0 = this.O00000oO;
        dyVar.O0000Oo = this.O00000oo;
        dyVar.O0000o00 = this.O0000O0o;
        dyVar.O00000o0 = this.O0000OOo;
        dyVar.O0000OoO = true;
        dyVar.O0000o0 = this.O0000Oo0;
        dyVar.O0000o0O = this.O0000Oo;
        dyVar.O0000o0o = this.O0000OoO;
        dyVar.O0000o = this.O0000Ooo;
        dyVar.O0000oO0 = this.O0000o00;
        dyVar.O0000oO = this.O0000o0;
        dyVar.O0000oOO = this.O0000o0O;
        dyVar.O000000o(1);
        return dyVar;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f2857O000000o);
        parcel.writeStringList(this.O00000Oo);
        parcel.writeIntArray(this.O00000o0);
        parcel.writeIntArray(this.O00000o);
        parcel.writeInt(this.O00000oO);
        parcel.writeInt(this.O00000oo);
        parcel.writeString(this.O0000O0o);
        parcel.writeInt(this.O0000OOo);
        parcel.writeInt(this.O0000Oo0);
        TextUtils.writeToParcel(this.O0000Oo, parcel, 0);
        parcel.writeInt(this.O0000OoO);
        TextUtils.writeToParcel(this.O0000Ooo, parcel, 0);
        parcel.writeStringList(this.O0000o00);
        parcel.writeStringList(this.O0000o0);
        parcel.writeInt(this.O0000o0O ? 1 : 0);
    }
}

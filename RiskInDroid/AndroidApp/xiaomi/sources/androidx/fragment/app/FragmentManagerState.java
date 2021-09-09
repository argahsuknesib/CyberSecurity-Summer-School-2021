package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator<FragmentManagerState>() {
        /* class androidx.fragment.app.FragmentManagerState.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FragmentManagerState[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public ArrayList<FragmentState> f2865O000000o;
    public ArrayList<String> O00000Oo;
    public String O00000o = null;
    public BackStackState[] O00000o0;
    public int O00000oO;

    public final int describeContents() {
        return 0;
    }

    public FragmentManagerState() {
    }

    public FragmentManagerState(Parcel parcel) {
        this.f2865O000000o = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.O00000Oo = parcel.createStringArrayList();
        this.O00000o0 = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f2865O000000o);
        parcel.writeStringList(this.O00000Oo);
        parcel.writeTypedArray(this.O00000o0, i);
        parcel.writeString(this.O00000o);
        parcel.writeInt(this.O00000oO);
    }
}

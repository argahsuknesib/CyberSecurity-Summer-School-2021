package androidx.fragment.app;

import _m_j.ec;
import _m_j.ef;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import androidx.lifecycle.Lifecycle;

@SuppressLint({"BanParcelableUsage"})
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator<FragmentState>() {
        /* class androidx.fragment.app.FragmentState.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FragmentState[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    final String f2866O000000o;
    public final String O00000Oo;
    final int O00000o;
    final boolean O00000o0;
    final int O00000oO;
    final String O00000oo;
    final boolean O0000O0o;
    final boolean O0000OOo;
    final Bundle O0000Oo;
    final boolean O0000Oo0;
    final boolean O0000OoO;
    final int O0000Ooo;
    public Fragment O0000o0;
    public Bundle O0000o00;

    public final int describeContents() {
        return 0;
    }

    public FragmentState(Fragment fragment) {
        this.f2866O000000o = fragment.getClass().getName();
        this.O00000Oo = fragment.mWho;
        this.O00000o0 = fragment.mFromLayout;
        this.O00000o = fragment.mFragmentId;
        this.O00000oO = fragment.mContainerId;
        this.O00000oo = fragment.mTag;
        this.O0000O0o = fragment.mRetainInstance;
        this.O0000OOo = fragment.mRemoving;
        this.O0000Oo0 = fragment.mDetached;
        this.O0000Oo = fragment.mArguments;
        this.O0000OoO = fragment.mHidden;
        this.O0000Ooo = fragment.mMaxState.ordinal();
    }

    FragmentState(Parcel parcel) {
        this.f2866O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        boolean z = true;
        this.O00000o0 = parcel.readInt() != 0;
        this.O00000o = parcel.readInt();
        this.O00000oO = parcel.readInt();
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readInt() != 0;
        this.O0000OOo = parcel.readInt() != 0;
        this.O0000Oo0 = parcel.readInt() != 0;
        this.O0000Oo = parcel.readBundle();
        this.O0000OoO = parcel.readInt() == 0 ? false : z;
        this.O0000o00 = parcel.readBundle();
        this.O0000Ooo = parcel.readInt();
    }

    public final Fragment O000000o(ClassLoader classLoader, ec ecVar) {
        if (this.O0000o0 == null) {
            Bundle bundle = this.O0000Oo;
            if (bundle != null) {
                bundle.setClassLoader(classLoader);
            }
            this.O0000o0 = ecVar.O00000o0(classLoader, this.f2866O000000o);
            this.O0000o0.setArguments(this.O0000Oo);
            Bundle bundle2 = this.O0000o00;
            if (bundle2 != null) {
                bundle2.setClassLoader(classLoader);
                this.O0000o0.mSavedFragmentState = this.O0000o00;
            } else {
                this.O0000o0.mSavedFragmentState = new Bundle();
            }
            Fragment fragment = this.O0000o0;
            fragment.mWho = this.O00000Oo;
            fragment.mFromLayout = this.O00000o0;
            fragment.mRestored = true;
            fragment.mFragmentId = this.O00000o;
            fragment.mContainerId = this.O00000oO;
            fragment.mTag = this.O00000oo;
            fragment.mRetainInstance = this.O0000O0o;
            fragment.mRemoving = this.O0000OOo;
            fragment.mDetached = this.O0000Oo0;
            fragment.mHidden = this.O0000OoO;
            fragment.mMaxState = Lifecycle.State.values()[this.O0000Ooo];
            if (ef.O00000o0) {
                Log.v("FragmentManager", "Instantiated fragment " + this.O0000o0);
            }
        }
        return this.O0000o0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((int) NotificationCompat.FLAG_HIGH_PRIORITY);
        sb.append("FragmentState{");
        sb.append(this.f2866O000000o);
        sb.append(" (");
        sb.append(this.O00000Oo);
        sb.append(")}:");
        if (this.O00000o0) {
            sb.append(" fromLayout");
        }
        if (this.O00000oO != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.O00000oO));
        }
        String str = this.O00000oo;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.O00000oo);
        }
        if (this.O0000O0o) {
            sb.append(" retainInstance");
        }
        if (this.O0000OOo) {
            sb.append(" removing");
        }
        if (this.O0000Oo0) {
            sb.append(" detached");
        }
        if (this.O0000OoO) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2866O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeInt(this.O00000o0 ? 1 : 0);
        parcel.writeInt(this.O00000o);
        parcel.writeInt(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeInt(this.O0000O0o ? 1 : 0);
        parcel.writeInt(this.O0000OOo ? 1 : 0);
        parcel.writeInt(this.O0000Oo0 ? 1 : 0);
        parcel.writeBundle(this.O0000Oo);
        parcel.writeInt(this.O0000OoO ? 1 : 0);
        parcel.writeBundle(this.O0000o00);
        parcel.writeInt(this.O0000Ooo);
    }
}

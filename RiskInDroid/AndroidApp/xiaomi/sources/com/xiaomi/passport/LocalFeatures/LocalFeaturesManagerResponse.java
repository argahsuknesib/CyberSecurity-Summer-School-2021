package com.xiaomi.passport.LocalFeatures;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.xiaomi.accounts.ILocalFeatureManagerResponse;

public class LocalFeaturesManagerResponse implements Parcelable {
    public static final Parcelable.Creator<LocalFeaturesManagerResponse> CREATOR = new Parcelable.Creator<LocalFeaturesManagerResponse>() {
        /* class com.xiaomi.passport.LocalFeatures.LocalFeaturesManagerResponse.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LocalFeaturesManagerResponse[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new LocalFeaturesManagerResponse(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private ILocalFeatureManagerResponse f6187O000000o;

    public int describeContents() {
        return 0;
    }

    public LocalFeaturesManagerResponse(ILocalFeatureManagerResponse iLocalFeatureManagerResponse) {
        this.f6187O000000o = iLocalFeatureManagerResponse;
    }

    public LocalFeaturesManagerResponse(Parcel parcel) {
        this.f6187O000000o = ILocalFeatureManagerResponse.Stub.asInterface(parcel.readStrongBinder());
    }

    public final void O000000o(Bundle bundle) {
        try {
            this.f6187O000000o.onResult(bundle);
        } catch (RemoteException unused) {
        }
    }

    public final void O000000o(int i, String str) {
        try {
            this.f6187O000000o.onError(i, str);
        } catch (RemoteException unused) {
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f6187O000000o.asBinder());
    }
}

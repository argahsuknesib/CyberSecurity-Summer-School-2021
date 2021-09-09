package com.miui.tsmclient.entity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.miui.tsmclient.service.IServiceResponse;

public class ServiceResponseParcelable implements Parcelable {
    public static final Parcelable.Creator<ServiceResponseParcelable> CREATOR = new Parcelable.Creator<ServiceResponseParcelable>() {
        /* class com.miui.tsmclient.entity.ServiceResponseParcelable.AnonymousClass1 */

        public final ServiceResponseParcelable createFromParcel(Parcel parcel) {
            return new ServiceResponseParcelable(parcel);
        }

        public final ServiceResponseParcelable[] newArray(int i) {
            return new ServiceResponseParcelable[i];
        }
    };
    private IServiceResponse mResponse;

    public int describeContents() {
        return 0;
    }

    public ServiceResponseParcelable(IServiceResponse iServiceResponse) {
        this.mResponse = iServiceResponse;
    }

    private ServiceResponseParcelable(Parcel parcel) {
        this.mResponse = IServiceResponse.Stub.asInterface(parcel.readStrongBinder());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.mResponse.asBinder());
    }

    public void onResult(Bundle bundle) {
        IServiceResponse iServiceResponse = this.mResponse;
        if (iServiceResponse != null) {
            try {
                iServiceResponse.onResult(bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    public void onError(int i, String str) {
        IServiceResponse iServiceResponse = this.mResponse;
        if (iServiceResponse != null) {
            try {
                iServiceResponse.onError(i, str);
            } catch (RemoteException unused) {
            }
        }
    }

    public void onProgress(int i) {
        IServiceResponse iServiceResponse = this.mResponse;
        if (iServiceResponse != null) {
            try {
                iServiceResponse.onProgress(i);
            } catch (RemoteException unused) {
            }
        }
    }
}

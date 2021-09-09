package com.xiaomi.passport.servicetoken;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.servicetoken.IServiceTokenUIResponse;

public class ServiceTokenUIResponse implements Parcelable {
    public static final Parcelable.Creator<ServiceTokenUIResponse> CREATOR = new Parcelable.Creator<ServiceTokenUIResponse>() {
        /* class com.xiaomi.passport.servicetoken.ServiceTokenUIResponse.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ServiceTokenUIResponse[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ServiceTokenUIResponse(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private IServiceTokenUIResponse f6202O000000o;

    public int describeContents() {
        return 0;
    }

    public ServiceTokenUIResponse(IServiceTokenUIResponse iServiceTokenUIResponse) {
        this.f6202O000000o = iServiceTokenUIResponse;
    }

    public ServiceTokenUIResponse(Parcel parcel) {
        this.f6202O000000o = IServiceTokenUIResponse.Stub.asInterface(parcel.readStrongBinder());
    }

    public final void O000000o(Bundle bundle) {
        if (Log.isLoggable("ServiceTokenUIResponse", 2)) {
            bundle.keySet();
            AccountLog.v("ServiceTokenUIResponse", "AccountAuthenticatorResponse.onResult");
        }
        try {
            this.f6202O000000o.onResult(bundle);
        } catch (RemoteException unused) {
        }
    }

    public final void O000000o(String str) {
        if (Log.isLoggable("ServiceTokenUIResponse", 2)) {
            AccountLog.v("ServiceTokenUIResponse", "AccountAuthenticatorResponse.onError: 4" + ", " + str);
        }
        try {
            this.f6202O000000o.onError(4, str);
        } catch (RemoteException unused) {
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f6202O000000o.asBinder());
    }
}

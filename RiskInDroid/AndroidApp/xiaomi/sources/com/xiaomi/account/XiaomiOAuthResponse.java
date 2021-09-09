package com.xiaomi.account;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.xiaomi.account.IXiaomiAuthResponse;

public class XiaomiOAuthResponse implements Parcelable {
    public static final Parcelable.Creator<XiaomiOAuthResponse> CREATOR = new Parcelable.Creator<XiaomiOAuthResponse>() {
        /* class com.xiaomi.account.XiaomiOAuthResponse.AnonymousClass1 */

        public final XiaomiOAuthResponse createFromParcel(Parcel parcel) {
            return new XiaomiOAuthResponse(parcel);
        }

        public final XiaomiOAuthResponse[] newArray(int i) {
            return new XiaomiOAuthResponse[i];
        }
    };
    private static final String TAG = "com.xiaomi.account.XiaomiOAuthResponse";
    private IXiaomiAuthResponse mResponse;

    public int describeContents() {
        return 0;
    }

    public XiaomiOAuthResponse(IXiaomiAuthResponse iXiaomiAuthResponse) {
        this.mResponse = iXiaomiAuthResponse;
    }

    public XiaomiOAuthResponse(Parcel parcel) {
        this.mResponse = IXiaomiAuthResponse.Stub.asInterface(parcel.readStrongBinder());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.mResponse.asBinder());
    }

    public void onResult(Bundle bundle) {
        setIXiaomiAuthResponseResult(this.mResponse, bundle);
    }

    public void onError(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("extra_error_code", i);
        bundle.putString("extra_error_description", str);
        setIXiaomiAuthResponseResult(this.mResponse, bundle);
    }

    public void onCancel() {
        setIXiaomiAuthResponseCancel(this.mResponse);
    }

    public static void setIXiaomiAuthResponseResult(IXiaomiAuthResponse iXiaomiAuthResponse, Bundle bundle) {
        if (iXiaomiAuthResponse != null && bundle != null) {
            try {
                iXiaomiAuthResponse.onResult(bundle);
            } catch (RuntimeException e) {
                Log.e(TAG, "RemoteException", e);
                Bundle bundle2 = new Bundle();
                bundle2.putInt("extra_error_code", -1);
                bundle2.putString("extra_error_description", e.getMessage());
                try {
                    iXiaomiAuthResponse.onResult(bundle2);
                } catch (RuntimeException e2) {
                    Log.e(TAG, "RuntimeException", e2);
                } catch (RemoteException e3) {
                    Log.e(TAG, "RemoteException", e3);
                }
            } catch (RemoteException e4) {
                Log.e(TAG, "RemoteException", e4);
            }
        }
    }

    public static void setIXiaomiAuthResponseCancel(IXiaomiAuthResponse iXiaomiAuthResponse) {
        if (iXiaomiAuthResponse != null) {
            try {
                iXiaomiAuthResponse.onCancel();
            } catch (RuntimeException e) {
                Log.e(TAG, "RuntimeException", e);
            } catch (RemoteException e2) {
                Log.e(TAG, "RemoteException", e2);
            }
        }
    }
}

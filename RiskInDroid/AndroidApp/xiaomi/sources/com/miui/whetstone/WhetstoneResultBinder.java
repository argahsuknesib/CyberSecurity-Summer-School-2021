package com.miui.whetstone;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public class WhetstoneResultBinder extends Binder implements IWhetstoneResult {
    public IBinder asBinder() {
        return this;
    }

    public void onResult(WhetstoneResult whetstoneResult) {
    }

    public static IWhetstoneResult asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IWhetstoneResult iWhetstoneResult = (IWhetstoneResult) iBinder.queryLocalInterface(IWhetstoneResult.descriptor);
        if (iWhetstoneResult != null) {
            return iWhetstoneResult;
        }
        return new WhetstoneResultProxy(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        parcel.enforceInterface(IWhetstoneResult.descriptor);
        onResult(WhetstoneResult.CREATOR.createFromParcel(parcel));
        parcel2.writeNoException();
        return true;
    }
}

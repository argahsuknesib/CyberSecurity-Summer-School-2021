package com.miui.whetstone;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class WhetstoneResultProxy implements IWhetstoneResult {
    private IBinder mRemote;

    public WhetstoneResultProxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public void onResult(WhetstoneResult whetstoneResult) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IWhetstoneResult.descriptor);
        whetstoneResult.writeToParcel(obtain, 0);
        this.mRemote.transact(1, obtain, obtain2, 0);
        obtain2.readException();
        obtain.recycle();
        obtain2.recycle();
    }
}

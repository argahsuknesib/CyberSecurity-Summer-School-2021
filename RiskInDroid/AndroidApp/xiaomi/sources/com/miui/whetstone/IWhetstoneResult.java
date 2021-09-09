package com.miui.whetstone;

import android.os.IInterface;
import android.os.RemoteException;

public interface IWhetstoneResult extends IInterface {
    public static final String descriptor = "com.miui.whetstone.IWhetstoneResult";

    void onResult(WhetstoneResult whetstoneResult) throws RemoteException;
}

package com.xiaomi.smarthome.device.bluetooth.search;

import _m_j.fph;
import android.os.RemoteException;
import com.xiaomi.smarthome.bluetooth.XmBluetoothDevice;
import com.xiaomi.smarthome.bluetooth.XmBluetoothSearchManager;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchResult;
import com.xiaomi.smarthome.core.server.bluetooth.SearchResponse;

public class BluetoothSearchManager$2 extends SearchResponse.Stub {
    final /* synthetic */ fph this$0;
    final /* synthetic */ XmBluetoothSearchManager.XmBluetoothSearchResponse val$xmResponse;

    public BluetoothSearchManager$2(fph fph, XmBluetoothSearchManager.XmBluetoothSearchResponse xmBluetoothSearchResponse) {
        this.this$0 = fph;
        this.val$xmResponse = xmBluetoothSearchResponse;
    }

    public void onSearchStarted() throws RemoteException {
        this.val$xmResponse.onSearchStarted();
    }

    public void onDeviceFounded(SearchResult searchResult) throws RemoteException {
        XmBluetoothSearchManager.XmBluetoothSearchResponse xmBluetoothSearchResponse = this.val$xmResponse;
        XmBluetoothDevice xmBluetoothDevice = new XmBluetoothDevice();
        xmBluetoothDevice.device = searchResult.f6724O000000o;
        xmBluetoothDevice.rssi = searchResult.O00000Oo;
        xmBluetoothDevice.scanRecord = searchResult.O00000o0;
        xmBluetoothDevice.deviceType = searchResult.O00000o;
        xmBluetoothDevice.name = searchResult.O00000oO;
        xmBluetoothSearchResponse.onDeviceFounded(xmBluetoothDevice);
    }

    public void onSearchStopped() throws RemoteException {
        this.val$xmResponse.onSearchStopped();
    }

    public void onSearchCanceled() throws RemoteException {
        this.val$xmResponse.onSearchCanceled();
    }
}

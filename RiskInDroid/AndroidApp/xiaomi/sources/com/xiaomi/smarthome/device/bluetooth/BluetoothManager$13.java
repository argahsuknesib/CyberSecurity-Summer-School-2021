package com.xiaomi.smarthome.device.bluetooth;

import _m_j.foj;
import _m_j.gnk;
import android.os.RemoteException;
import com.xiaomi.smarthome.bluetooth.XmBluetoothDevice;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchResult;
import com.xiaomi.smarthome.core.server.bluetooth.SearchResponse;

public class BluetoothManager$13 extends SearchResponse.Stub {
    final /* synthetic */ foj this$0;
    final /* synthetic */ XmBluetoothManager.BluetoothSearchResponse val$response;

    public BluetoothManager$13(foj foj, XmBluetoothManager.BluetoothSearchResponse bluetoothSearchResponse) {
        this.this$0 = foj;
        this.val$response = bluetoothSearchResponse;
    }

    public void onSearchStarted() throws RemoteException {
        gnk.O00000oO("app onSearchStarted");
        this.val$response.onSearchStarted();
    }

    public void onDeviceFounded(SearchResult searchResult) throws RemoteException {
        gnk.O00000oO("app onDeviceFounded");
        XmBluetoothDevice xmBluetoothDevice = new XmBluetoothDevice();
        xmBluetoothDevice.device = searchResult.f6724O000000o;
        xmBluetoothDevice.deviceType = searchResult.O00000o;
        xmBluetoothDevice.name = searchResult.O00000oO;
        xmBluetoothDevice.rssi = searchResult.O00000Oo;
        xmBluetoothDevice.scanRecord = searchResult.O00000o0;
        this.val$response.onDeviceFounded(xmBluetoothDevice);
    }

    public void onSearchStopped() throws RemoteException {
        gnk.O00000oO("app onSearchStopped");
        this.val$response.onSearchStopped();
    }

    public void onSearchCanceled() throws RemoteException {
        gnk.O00000oO("app onSearchCanceled");
        this.val$response.onSearchCanceled();
    }
}

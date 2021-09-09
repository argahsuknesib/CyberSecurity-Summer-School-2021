package com.xiaomi.smarthome.bluetooth;

public abstract class XmBluetoothSearchManager {
    protected static XmBluetoothSearchManager instance;

    public interface XmBluetoothSearchResponse {
        void onDeviceFounded(XmBluetoothDevice xmBluetoothDevice);

        void onSearchCanceled();

        void onSearchStarted();

        void onSearchStopped();
    }

    @Deprecated
    public abstract void startScanBluetooth(BluetoothHandler bluetoothHandler);

    public abstract void startScanBluetooth(XmBluetoothSearchRequest xmBluetoothSearchRequest, XmBluetoothSearchResponse xmBluetoothSearchResponse);

    @Deprecated
    public abstract void startScanBluetoothImmediately(BluetoothHandler bluetoothHandler);

    public abstract void stopScanBluetooth();

    @Deprecated
    public abstract void stopScanBluetooth(BluetoothHandler bluetoothHandler);

    public static XmBluetoothSearchManager getInstance() {
        return instance;
    }

    @Deprecated
    public static abstract class BluetoothHandler {
        public int handlerType;
        public long scanTime;

        public abstract void onDeviceFounded(XmBluetoothDevice xmBluetoothDevice);

        public abstract void onSearchStarted();

        public abstract void onSearchStopped();

        public BluetoothHandler(int i) {
            this.handlerType = i;
        }

        public BluetoothHandler(int i, long j) {
            this.handlerType = i;
            this.scanTime = j;
        }
    }

    public static class XmBluetoothSearchRequest {
        public int taskDuration;
        public int taskType;

        public XmBluetoothSearchRequest(int i, int i2) {
            this.taskType = i;
            this.taskDuration = i2;
        }

        public XmBluetoothSearchRequest(BluetoothHandler bluetoothHandler) {
            this.taskDuration = (int) bluetoothHandler.scanTime;
            this.taskType = bluetoothHandler.handlerType;
        }
    }
}

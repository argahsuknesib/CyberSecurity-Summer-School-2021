package com.xiaomi.smarthome.bluetooth;

import android.os.Bundle;

public class Response {

    public interface BleCallResponse extends BleResponse<Bundle> {
    }

    public interface BleConnectResponse extends BleResponse<Bundle> {
    }

    public interface BleDeviceStatusResponse extends BleResponse<Integer> {
    }

    public interface BleNotifyResponse extends BleResponse<Void> {
    }

    public interface BleReadFirmwareVersionResponse extends BleResponse<String> {
    }

    public interface BleReadResponse extends BleResponse<byte[]> {
    }

    public interface BleReadRssiResponse extends BleResponse<Integer> {
    }

    public interface BleResponse<T> {
        void onResponse(int i, T t);
    }

    public interface BleResponseV2<T> {
        void onResponse(int i, String str, T t);
    }

    public interface BleUpgradeResponse extends BleResponse<String> {
        boolean isMeshDevice();

        void onProgress(int i);
    }

    public interface BleWriteResponse extends BleResponse<Void> {
    }

    @Deprecated
    public interface BleWriteResponse2 extends BleWriteResponse {
    }

    public interface FirmwareUpgradeResponse extends ProgressResponse {
        void onResponse(int i, String str, String str2);
    }

    public interface ProgressResponse {
        void onProgress(int i);
    }
}

package com.facebook.places.internal;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.internal.Validate;
import com.facebook.places.internal.ScannerException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@TargetApi(21)
public class BleScannerImpl implements BleScanner {
    private static final byte[] EDDYSTONE_PREFIX = fromHexString("16aafe");
    private static final byte[] GRAVITY_PREFIX = fromHexString("17ffab01");
    private static final byte[] IBEACON_PREFIX = fromHexString("ff4c000215");
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothLeScanner bluetoothLeScanner;
    private Context context;
    public int errorCode;
    private boolean isScanInProgress;
    private LocationPackageRequestParams params;
    private ScanCallBackImpl scanCallBack;
    public final List<BluetoothScanResult> scanResults = new ArrayList();

    BleScannerImpl(Context context2, LocationPackageRequestParams locationPackageRequestParams) {
        this.context = context2;
        this.params = locationPackageRequestParams;
    }

    public synchronized void initAndCheckEligibility() throws ScannerException {
        if (Build.VERSION.SDK_INT < 21) {
            throw new ScannerException(ScannerException.Type.NOT_SUPPORTED);
        } else if (!Validate.hasBluetoothPermission(this.context)) {
            throw new ScannerException(ScannerException.Type.PERMISSION_DENIED);
        } else if (Validate.hasLocationPermission(this.context)) {
            this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            if (this.bluetoothAdapter == null || !this.bluetoothAdapter.isEnabled()) {
                throw new ScannerException(ScannerException.Type.DISABLED);
            }
            this.bluetoothLeScanner = this.bluetoothAdapter.getBluetoothLeScanner();
            if (this.bluetoothLeScanner == null) {
                throw new ScannerException(ScannerException.Type.UNKNOWN_ERROR);
            }
        } else {
            throw new ScannerException(ScannerException.Type.PERMISSION_DENIED);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:16|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        throw new com.facebook.places.internal.ScannerException(com.facebook.places.internal.ScannerException.Type.UNKNOWN_ERROR);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x003d */
    public synchronized void startScanning() throws ScannerException {
        if (!this.isScanInProgress) {
            this.scanCallBack = new ScanCallBackImpl();
            this.isScanInProgress = true;
            this.errorCode = 0;
            synchronized (this.scanResults) {
                this.scanResults.clear();
            }
            if (this.bluetoothLeScanner != null) {
                ScanSettings.Builder builder = new ScanSettings.Builder();
                builder.setScanMode(2);
                builder.setReportDelay(0);
                this.bluetoothLeScanner.startScan((List<ScanFilter>) null, builder.build(), this.scanCallBack);
                this.isScanInProgress = true;
            } else {
                throw new ScannerException(ScannerException.Type.UNKNOWN_ERROR);
            }
        } else {
            throw new ScannerException(ScannerException.Type.SCAN_ALREADY_IN_PROGRESS);
        }
    }

    public synchronized void stopScanning() {
        this.bluetoothLeScanner.flushPendingScanResults(this.scanCallBack);
        this.bluetoothLeScanner.stopScan(this.scanCallBack);
        waitForMainLooper(this.params.getBluetoothFlushResultsTimeoutMs());
        this.isScanInProgress = false;
    }

    private void waitForMainLooper(long j) {
        try {
            final Object obj = new Object();
            synchronized (obj) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.facebook.places.internal.BleScannerImpl.AnonymousClass1 */

                    public void run() {
                        try {
                            synchronized (obj) {
                                obj.notify();
                            }
                        } catch (Exception e) {
                            BleScannerImpl.logException("Exception waiting for main looper", e);
                        }
                    }
                });
                obj.wait(j);
            }
        } catch (Exception e) {
            logException("Exception waiting for main looper", e);
        }
    }

    public synchronized int getErrorCode() {
        return this.errorCode;
    }

    public synchronized List<BluetoothScanResult> getScanResults() {
        ArrayList arrayList;
        synchronized (this.scanResults) {
            int bluetoothMaxScanResults = this.params.getBluetoothMaxScanResults();
            if (this.scanResults.size() > bluetoothMaxScanResults) {
                arrayList = new ArrayList(bluetoothMaxScanResults);
                Collections.sort(this.scanResults, new Comparator<BluetoothScanResult>() {
                    /* class com.facebook.places.internal.BleScannerImpl.AnonymousClass2 */

                    public int compare(BluetoothScanResult bluetoothScanResult, BluetoothScanResult bluetoothScanResult2) {
                        return bluetoothScanResult2.rssi - bluetoothScanResult.rssi;
                    }
                });
                arrayList.addAll(this.scanResults.subList(0, bluetoothMaxScanResults));
            } else {
                arrayList = new ArrayList(this.scanResults.size());
                arrayList.addAll(this.scanResults);
            }
        }
        return arrayList;
    }

    class ScanCallBackImpl extends ScanCallback {
        private ScanCallBackImpl() {
        }

        public void onScanFailed(int i) {
            super.onScanFailed(i);
            BleScannerImpl.this.errorCode = i;
        }

        public void onBatchScanResults(List<ScanResult> list) {
            super.onBatchScanResults(list);
            try {
                synchronized (BleScannerImpl.this.scanResults) {
                    for (ScanResult newBluetoothScanResult : list) {
                        BluetoothScanResult newBluetoothScanResult2 = BleScannerImpl.newBluetoothScanResult(newBluetoothScanResult);
                        if (newBluetoothScanResult2 != null) {
                            BleScannerImpl.this.scanResults.add(newBluetoothScanResult2);
                        }
                    }
                }
            } catch (Exception e) {
                BleScannerImpl.logException("Exception in ble scan callback", e);
            }
        }

        public void onScanResult(int i, ScanResult scanResult) {
            super.onScanResult(i, scanResult);
            try {
                synchronized (BleScannerImpl.this.scanResults) {
                    BluetoothScanResult newBluetoothScanResult = BleScannerImpl.newBluetoothScanResult(scanResult);
                    if (newBluetoothScanResult != null) {
                        BleScannerImpl.this.scanResults.add(newBluetoothScanResult);
                    }
                }
            } catch (Exception e) {
                BleScannerImpl.logException("Exception in ble scan callback", e);
            }
        }
    }

    public static BluetoothScanResult newBluetoothScanResult(ScanResult scanResult) {
        ScanRecord scanRecord = scanResult.getScanRecord();
        if (isBeacon(scanRecord.getBytes())) {
            return new BluetoothScanResult(formatPayload(scanRecord.getBytes()), scanResult.getRssi(), scanResult.getTimestampNanos());
        }
        return null;
    }

    private static String formatPayload(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return toHexString(bArr, getPayloadLength(bArr));
    }

    private static int getPayloadLength(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            byte b = bArr[i];
            if (b == 0) {
                return i;
            }
            if (b < 0) {
                return bArr.length;
            }
            i += b + 1;
        }
        return bArr.length;
    }

    private static String toHexString(byte[] bArr, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i < 0 || i > bArr.length) {
            i = bArr.length;
        }
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i2])));
        }
        return stringBuffer.toString();
    }

    public static void logException(String str, Exception exc) {
        if (FacebookSdk.isDebugEnabled()) {
            Log.e("BleScannerImpl", str, exc);
        }
    }

    private static boolean isBeacon(byte[] bArr) {
        int i;
        if (bArr == null) {
            return false;
        }
        int length = bArr.length;
        int i2 = 0;
        while (i2 < length) {
            byte b = bArr[i2];
            if (b <= 0 || (i = b + 1 + i2) > length) {
                return false;
            }
            if (isAdvPacketBeacon(bArr, i2)) {
                return true;
            }
            i2 = i;
        }
        return false;
    }

    private static boolean isAdvPacketBeacon(byte[] bArr, int i) {
        int i2 = i + 1;
        if (!isArrayContained(bArr, i2, IBEACON_PREFIX) && !isArrayContained(bArr, i2, EDDYSTONE_PREFIX) && !isArrayContained(bArr, i, GRAVITY_PREFIX) && !isAltBeacon(bArr, i)) {
            return false;
        }
        return true;
    }

    private static boolean isAltBeacon(byte[] bArr, int i) {
        int i2 = i + 5;
        if (i2 < bArr.length) {
            byte b = bArr[i];
            byte b2 = bArr[i + 1];
            byte b3 = bArr[i + 4];
            byte b4 = bArr[i2];
            if (b == 27 && b2 == -1 && b3 == -66 && b4 == -84) {
                return true;
            }
            return false;
        }
        return false;
    }

    private static boolean isArrayContained(byte[] bArr, int i, byte[] bArr2) {
        int length = bArr2.length;
        if (i + length > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (bArr[i + i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private static byte[] fromHexString(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}

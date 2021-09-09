package no.nordicsemi.android.dfu.internal.scanner;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import java.util.Locale;

public class BootloaderScannerJB implements BluetoothAdapter.LeScanCallback, BootloaderScanner {
    public String mBootloaderAddress;
    private String mDeviceAddress;
    private String mDeviceAddressIncremented;
    public boolean mFound;
    public final Object mLock = new Object();

    public String searchFor(String str) {
        String substring = str.substring(0, 15);
        String substring2 = str.substring(15);
        String format = String.format(Locale.US, "%02X", Integer.valueOf((Integer.valueOf(substring2, 16).intValue() + 1) & 255));
        this.mDeviceAddress = str;
        this.mDeviceAddressIncremented = substring + format;
        this.mBootloaderAddress = null;
        this.mFound = false;
        new Thread(new Runnable() {
            /* class no.nordicsemi.android.dfu.internal.scanner.BootloaderScannerJB.AnonymousClass1 */

            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException unused) {
                }
                if (!BootloaderScannerJB.this.mFound) {
                    BootloaderScannerJB bootloaderScannerJB = BootloaderScannerJB.this;
                    bootloaderScannerJB.mBootloaderAddress = null;
                    bootloaderScannerJB.mFound = true;
                    synchronized (bootloaderScannerJB.mLock) {
                        BootloaderScannerJB.this.mLock.notifyAll();
                    }
                }
            }
        }, "Scanner timer").start();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || defaultAdapter.getState() != 12) {
            return null;
        }
        defaultAdapter.startLeScan(this);
        try {
            synchronized (this.mLock) {
                while (!this.mFound) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException unused) {
        }
        defaultAdapter.stopLeScan(this);
        return this.mBootloaderAddress;
    }

    public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        String address = bluetoothDevice.getAddress();
        if (this.mDeviceAddress.equals(address) || this.mDeviceAddressIncremented.equals(address)) {
            this.mBootloaderAddress = address;
            this.mFound = true;
            synchronized (this.mLock) {
                this.mLock.notifyAll();
            }
        }
    }
}

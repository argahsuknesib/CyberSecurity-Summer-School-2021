package com.xiaomi.smarthome.uwb.lib.mitv;

import _m_j.gsy;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelUuid;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class PowerOnManager {
    public static final String TAG = "com.xiaomi.smarthome.uwb.lib.mitv.PowerOnManager";
    private static volatile PowerOnManager sInstance;
    private BroadcastReceiver mBLReceiver;
    private Context mContext;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private BtPThread mSendThread;
    private Runnable mUnRegRunnable = new Runnable() {
        /* class com.xiaomi.smarthome.uwb.lib.mitv.PowerOnManager.AnonymousClass1 */

        public void run() {
            PowerOnManager.this.unRegisterBLReceiver();
        }
    };

    public static PowerOnManager getInstance() {
        if (sInstance == null) {
            synchronized (PowerOnManager.class) {
                if (sInstance == null) {
                    sInstance = new PowerOnManager();
                }
            }
        }
        return sInstance;
    }

    public void init(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public boolean startBtPowerOn(String str) {
        BtPThread btPThread = this.mSendThread;
        if (btPThread == null || !btPThread.isAlive()) {
            this.mSendThread = new BtPThread(str);
            this.mSendThread.start();
            return true;
        }
        UwbLogUtil.w(TAG, "UwbLogUtilPlus mSendThread isAlive,  return false");
        return false;
    }

    public void stopBtPowerOn() {
        BtPThread btPThread = this.mSendThread;
        if (btPThread != null && btPThread.isAlive()) {
            UwbLogUtil.w(TAG, "UwbLogUtilPlus mSendThread stopBtPowerOn");
            this.mSendThread.stopBtRun();
        }
    }

    class BtPThread extends Thread {
        private volatile boolean isBtRun = true;
        private String mMacAddress;

        public void stopBtRun() {
            this.isBtRun = false;
        }

        public BtPThread(String str) {
            this.mMacAddress = str;
        }

        public void run() {
            UwbLogUtil.w("BtPThread", "UwbLogUtilPlus BtPThread start");
            this.isBtRun = true;
            int i = 0;
            while (this.isBtRun && i < 500) {
                boolean btPowerOn = PowerOnManager.this.btPowerOn(this.mMacAddress);
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                UwbLogUtil.w("BtPThread", "UwbLogUtilPlus btPowerRes: ".concat(String.valueOf(btPowerOn)));
                if (!btPowerOn) {
                    break;
                }
                i++;
            }
            UwbLogUtil.w("BtPThread", "UwbLogUtilPlus BtPThread end");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean btPowerOn(String str) {
        BluetoothManager bluetoothManager;
        BluetoothAdapter adapter;
        Context context = this.mContext;
        if (context == null || str == null || !context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le") || (bluetoothManager = (BluetoothManager) this.mContext.getSystemService("bluetooth")) == null || (adapter = bluetoothManager.getAdapter()) == null) {
            return false;
        }
        if (!adapter.isEnabled()) {
            checkBluetoothState(adapter, str);
            adapter.enable();
            return false;
        }
        startBTAdvertising(adapter, str);
        return true;
    }

    private void checkBluetoothState(final BluetoothAdapter bluetoothAdapter, final String str) {
        gsy.O000000o(3, TAG, "checkBluetoothState");
        try {
            unRegisterBLReceiver();
            this.mBLReceiver = new BroadcastReceiver() {
                /* class com.xiaomi.smarthome.uwb.lib.mitv.PowerOnManager.AnonymousClass2 */

                public void onReceive(Context context, Intent intent) {
                    String str = PowerOnManager.TAG;
                    gsy.O000000o(3, str, "onreceive :" + intent.getAction());
                    if (intent.getAction() != null && intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                        int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                        gsy.O000000o(3, PowerOnManager.TAG, "state = ".concat(String.valueOf(intExtra)));
                        switch (intExtra) {
                            case 10:
                            case 11:
                            default:
                                return;
                            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                                PowerOnManager.this.startBTAdvertising(bluetoothAdapter, str);
                                PowerOnManager.this.unRegisterBLReceiver();
                                return;
                        }
                    }
                }
            };
            this.mContext.registerReceiver(this.mBLReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
            this.mHandler.removeCallbacks(this.mUnRegRunnable);
            this.mHandler.postDelayed(this.mUnRegRunnable, 11000);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public boolean startBTAdvertising(final BluetoothAdapter bluetoothAdapter, String str) {
        int i = 1;
        if (!bluetoothAdapter.isEnabled()) {
            bluetoothAdapter.enable();
            while (i < 5) {
                try {
                    Thread.sleep(200);
                    if (bluetoothAdapter.getBluetoothLeAdvertiser() != null) {
                        break;
                    }
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Thread.sleep(100);
            this.mHandler.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.uwb.lib.mitv.PowerOnManager.AnonymousClass3 */

                public void run() {
                    bluetoothAdapter.disable();
                }
            }, 11000);
            return false;
        }
        BluetoothLeAdvertiser bluetoothLeAdvertiser = bluetoothAdapter.getBluetoothLeAdvertiser();
        if (bluetoothLeAdvertiser == null) {
            return false;
        }
        AnonymousClass4 r0 = new AdvertiseCallback() {
            /* class com.xiaomi.smarthome.uwb.lib.mitv.PowerOnManager.AnonymousClass4 */

            public void onStartSuccess(AdvertiseSettings advertiseSettings) {
                super.onStartSuccess(advertiseSettings);
            }

            public void onStartFailure(int i) {
                super.onStartFailure(i);
            }
        };
        AdvertiseSettings createAdvSettings = createAdvSettings(true, C.MSG_CUSTOM_BASE);
        AdvertiseData createAdvertiseData = createAdvertiseData(str);
        if (createAdvSettings == null || createAdvertiseData == null) {
            return false;
        }
        try {
            UwbLogUtil.w(TAG, "UwbLogUtilPlus bt startAdvertising");
            bluetoothLeAdvertiser.startAdvertising(createAdvSettings, createAdvertiseData, r0);
        } catch (Exception e2) {
            String str2 = TAG;
            gsy.O000000o(4, str2, "Exception in bt advertising: " + e2.toString());
            e2.printStackTrace();
        }
        return true;
    }

    public void unRegisterBLReceiver() {
        try {
            if (this.mBLReceiver != null) {
                if (this.mContext != null) {
                    gsy.O000000o(3, TAG, "unRegisterBLReceiver");
                    this.mContext.unregisterReceiver(this.mBLReceiver);
                }
                this.mBLReceiver = null;
            }
        } catch (Exception unused) {
        }
    }

    private static AdvertiseSettings createAdvSettings(boolean z, int i) {
        AdvertiseSettings.Builder builder = new AdvertiseSettings.Builder();
        builder.setAdvertiseMode(1);
        builder.setConnectable(z);
        builder.setTimeout(i);
        builder.setTxPowerLevel(3);
        return builder.build();
    }

    private static AdvertiseData createAdvertiseData(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":");
        if (split.length < 6) {
            return null;
        }
        for (int i = 0; i < 6; i++) {
            if (split[i].length() != 2) {
                return null;
            }
        }
        ParcelUuid fromString = ParcelUuid.fromString(String.format("00%s%s%s-%s%s-%s01-00ff-030501020100", split[0], split[1], split[2], split[3], split[4], split[5]));
        AdvertiseData.Builder builder = new AdvertiseData.Builder();
        builder.addServiceUuid(fromString);
        return builder.build();
    }
}

package com.xiaomi.aiot.mibeacon.scan;

import _m_j.jak;
import _m_j.jat;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.aiot.mibeacon.BeaconManager;
import com.xiaomi.aiot.mibeacon.BeaconParserV4;
import com.xiaomi.aiot.mibeacon.IBeaconParser;
import com.xiaomi.aiot.mibeacon.MiBeacon;
import com.xiaomi.aiot.mibeacon.RangeNotifier;
import com.xiaomi.aiot.mibeacon.logging.LogManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import no.nordicsemi.android.support.v18.scanner.ScanResult;
import no.nordicsemi.android.support.v18.scanner.ScanSettings;

public class ScanHelper {
    public static final String TAG = "ScanHelper";
    public BeaconManager mBeaconManager;
    public IBeaconParser mBeaconParser;
    private Context mContext;
    public Handler mHandler;
    public Collection<MiBeacon> mRangeBeacons = new ArrayList();
    private jat mScanCallback;
    public Map<String, MiBeacon> mScanedBeacons;
    private jak mScanner;
    private final ScanSettings settings;

    public ScanHelper(Context context) {
        ScanSettings.O000000o O000000o2 = new ScanSettings.O000000o().O000000o(2);
        O000000o2.O0000OOo = false;
        this.settings = O000000o2.O000000o();
        this.mContext = context;
        this.mBeaconManager = BeaconManager.getInstanceForApplication(context);
        this.mBeaconParser = new BeaconParserV4();
        this.mScanner = jak.O000000o();
        this.mScanedBeacons = new HashMap();
        this.mHandler = new Handler(Looper.getMainLooper()) {
            /* class com.xiaomi.aiot.mibeacon.scan.ScanHelper.AnonymousClass1 */

            public void handleMessage(Message message) {
                if (message.what == 17) {
                    ScanHelper.this.mRangeBeacons.clear();
                    ScanHelper.this.mRangeBeacons.add((MiBeacon) message.obj);
                    Set<RangeNotifier> rangingNotifiers = ScanHelper.this.mBeaconManager.getRangingNotifiers();
                    if (rangingNotifiers != null) {
                        for (RangeNotifier didRangeBeaconsInScan : rangingNotifiers) {
                            didRangeBeaconsInScan.didRangeBeaconsInScan(ScanHelper.this.mRangeBeacons);
                        }
                    }
                }
            }
        };
        this.mScanCallback = new jat() {
            /* class com.xiaomi.aiot.mibeacon.scan.ScanHelper.AnonymousClass2 */

            public void onScanResult(int i, ScanResult scanResult) {
                MiBeacon fromScanData = ScanHelper.this.mBeaconParser.fromScanData(scanResult.O00000Oo.O00000o0, scanResult.O00000o0, scanResult.f15416O000000o);
                if (fromScanData != null) {
                    MiBeacon miBeacon = ScanHelper.this.mScanedBeacons.get(fromScanData.getWifiMac());
                    if (miBeacon != null) {
                        miBeacon.addPacket(fromScanData);
                        fromScanData = miBeacon;
                    } else {
                        ScanHelper.this.mScanedBeacons.put(fromScanData.getWifiMac(), fromScanData);
                    }
                    Message obtainMessage = ScanHelper.this.mHandler.obtainMessage(17);
                    obtainMessage.obj = fromScanData;
                    ScanHelper.this.mHandler.sendMessage(obtainMessage);
                }
            }

            public void onScanFailed(int i) {
                LogManager.e(ScanHelper.TAG, "onScanFail %d".concat(String.valueOf(i)), new Object[0]);
            }
        };
    }

    public boolean startScan() {
        try {
            jak jak = this.mScanner;
            ScanSettings scanSettings = this.settings;
            jat jat = this.mScanCallback;
            if (jat != null) {
                Handler handler = new Handler(Looper.getMainLooper());
                List emptyList = Collections.emptyList();
                if (scanSettings == null) {
                    scanSettings = new ScanSettings.O000000o().O000000o();
                }
                jak.O000000o(emptyList, scanSettings, jat, handler);
                return true;
            }
            throw new IllegalArgumentException("callback is null");
        } catch (Exception unused) {
            return false;
        }
    }

    public void stopScan() {
        try {
            this.mScanner.O000000o(this.mScanCallback);
            if (this.mScanedBeacons != null) {
                this.mScanedBeacons.clear();
            }
            this.mRangeBeacons.clear();
        } catch (Exception unused) {
        }
    }
}

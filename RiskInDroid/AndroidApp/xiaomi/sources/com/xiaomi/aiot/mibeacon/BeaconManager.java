package com.xiaomi.aiot.mibeacon;

import android.content.Context;
import com.xiaomi.aiot.mibeacon.distance.ModelSpecificDistanceCalculator;
import com.xiaomi.aiot.mibeacon.logging.LogManager;
import com.xiaomi.aiot.mibeacon.logging.Loggers;
import com.xiaomi.aiot.mibeacon.scan.ScanHelper;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class BeaconManager {
    private static final Object SINGLETON_LOCK = new Object();
    private static final Object STATE_LOCK = new Object();
    protected static volatile BeaconManager sInstance = null;
    private volatile boolean isForegroundRangingStarting = false;
    private final Context mContext;
    protected final Set<RangeNotifier> rangeNotifiers = new CopyOnWriteArraySet();
    private ScanHelper scanHelper;

    public static void setDebug(boolean z) {
        if (z) {
            LogManager.setLogger(Loggers.verboseLogger());
            LogManager.setVerboseLoggingEnabled(true);
            return;
        }
        LogManager.setLogger(Loggers.empty());
        LogManager.setVerboseLoggingEnabled(false);
    }

    public Set<RangeNotifier> getRangingNotifiers() {
        return Collections.unmodifiableSet(this.rangeNotifiers);
    }

    public boolean removeRangeNotifier(RangeNotifier rangeNotifier) {
        return this.rangeNotifiers.remove(rangeNotifier);
    }

    public void removeAllRangeNotifiers() {
        this.rangeNotifiers.clear();
    }

    public void addRangeNotifier(RangeNotifier rangeNotifier) {
        if (rangeNotifier != null) {
            this.rangeNotifiers.add(rangeNotifier);
        }
    }

    public boolean startRangingBeaconsForeground(RangeNotifier rangeNotifier) {
        synchronized (STATE_LOCK) {
            if (this.isForegroundRangingStarting) {
                return false;
            }
            if (rangeNotifier != null) {
                this.rangeNotifiers.add(rangeNotifier);
            }
            if (this.scanHelper == null) {
                this.scanHelper = new ScanHelper(this.mContext);
            }
            boolean startScan = this.scanHelper.startScan();
            this.isForegroundRangingStarting = startScan;
            return startScan;
        }
    }

    public void stopRangingBeaconsForeground() {
        synchronized (STATE_LOCK) {
            if (this.isForegroundRangingStarting) {
                removeAllRangeNotifiers();
                this.scanHelper.stopScan();
                this.isForegroundRangingStarting = false;
            }
        }
    }

    public static BeaconManager getInstanceForApplication(Context context) {
        BeaconManager beaconManager = sInstance;
        if (beaconManager == null) {
            synchronized (SINGLETON_LOCK) {
                beaconManager = sInstance;
                if (beaconManager == null) {
                    beaconManager = new BeaconManager(context);
                    sInstance = beaconManager;
                }
            }
        }
        return beaconManager;
    }

    protected BeaconManager(Context context) {
        this.mContext = context.getApplicationContext();
        MiBeacon.setDistanceCalculator(new ModelSpecificDistanceCalculator(this.mContext, ""));
    }
}

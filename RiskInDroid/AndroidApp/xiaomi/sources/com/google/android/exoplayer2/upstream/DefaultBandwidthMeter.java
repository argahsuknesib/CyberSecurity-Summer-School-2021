package com.google.android.exoplayer2.upstream;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.EventDispatcher;
import com.google.android.exoplayer2.util.SlidingPercentile;
import com.google.android.exoplayer2.util.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener {
    public static final Map<String, int[]> DEFAULT_INITIAL_BITRATE_COUNTRY_GROUPS = createInitialBitrateCountryGroupAssignment();
    public static final long[] DEFAULT_INITIAL_BITRATE_ESTIMATES_2G = {200000, 148000, 132000, 115000, 95000};
    public static final long[] DEFAULT_INITIAL_BITRATE_ESTIMATES_3G = {2200000, 1300000, 970000, 810000, 490000};
    public static final long[] DEFAULT_INITIAL_BITRATE_ESTIMATES_4G = {5300000, 3200000, 2000000, 1400000, 690000};
    public static final long[] DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI = {5700000, 3500000, 2000000, 1100000, 470000};
    private static DefaultBandwidthMeter singletonInstance;
    private long bitrateEstimate;
    private final Clock clock;
    private final Context context;
    private final EventDispatcher<BandwidthMeter.EventListener> eventDispatcher;
    private final SparseArray<Long> initialBitrateEstimates;
    private long lastReportedBitrateEstimate;
    private int networkType;
    private int networkTypeOverride;
    private boolean networkTypeOverrideSet;
    private long sampleBytesTransferred;
    private long sampleStartTimeMs;
    private final SlidingPercentile slidingPercentile;
    private int streamCount;
    private long totalBytesTransferred;
    private long totalElapsedTimeMs;

    public final TransferListener getTransferListener() {
        return this;
    }

    public final void onTransferInitializing(DataSource dataSource, DataSpec dataSpec, boolean z) {
    }

    public static final class Builder {
        private Clock clock;
        private final Context context;
        private SparseArray<Long> initialBitrateEstimates;
        private boolean resetOnNetworkTypeChange;
        private int slidingWindowMaxWeight;

        public Builder(Context context2) {
            Context context3;
            if (context2 == null) {
                context3 = null;
            } else {
                context3 = context2.getApplicationContext();
            }
            this.context = context3;
            this.initialBitrateEstimates = getInitialBitrateEstimatesForCountry(Util.getCountryCode(context2));
            this.slidingWindowMaxWeight = 2000;
            this.clock = Clock.DEFAULT;
            this.resetOnNetworkTypeChange = true;
        }

        public final Builder setSlidingWindowMaxWeight(int i) {
            this.slidingWindowMaxWeight = i;
            return this;
        }

        public final Builder setInitialBitrateEstimate(long j) {
            for (int i = 0; i < this.initialBitrateEstimates.size(); i++) {
                this.initialBitrateEstimates.setValueAt(i, Long.valueOf(j));
            }
            return this;
        }

        public final Builder setInitialBitrateEstimate(int i, long j) {
            this.initialBitrateEstimates.put(i, Long.valueOf(j));
            return this;
        }

        public final Builder setInitialBitrateEstimate(String str) {
            this.initialBitrateEstimates = getInitialBitrateEstimatesForCountry(Util.toUpperInvariant(str));
            return this;
        }

        public final Builder setClock(Clock clock2) {
            this.clock = clock2;
            return this;
        }

        public final Builder setResetOnNetworkTypeChange(boolean z) {
            this.resetOnNetworkTypeChange = z;
            return this;
        }

        public final DefaultBandwidthMeter build() {
            return new DefaultBandwidthMeter(this.context, this.initialBitrateEstimates, this.slidingWindowMaxWeight, this.clock, this.resetOnNetworkTypeChange);
        }

        private static SparseArray<Long> getInitialBitrateEstimatesForCountry(String str) {
            int[] countryGroupIndices = getCountryGroupIndices(str);
            SparseArray<Long> sparseArray = new SparseArray<>(6);
            sparseArray.append(0, 1000000L);
            sparseArray.append(2, Long.valueOf(DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI[countryGroupIndices[0]]));
            sparseArray.append(3, Long.valueOf(DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_2G[countryGroupIndices[1]]));
            sparseArray.append(4, Long.valueOf(DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_3G[countryGroupIndices[2]]));
            sparseArray.append(5, Long.valueOf(DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_4G[countryGroupIndices[3]]));
            sparseArray.append(7, Long.valueOf(DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI[countryGroupIndices[0]]));
            sparseArray.append(9, Long.valueOf(DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI[countryGroupIndices[0]]));
            return sparseArray;
        }

        private static int[] getCountryGroupIndices(String str) {
            int[] iArr = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_COUNTRY_GROUPS.get(str);
            return iArr == null ? new int[]{2, 2, 2, 2} : iArr;
        }
    }

    public static synchronized DefaultBandwidthMeter getSingletonInstance(Context context2) {
        DefaultBandwidthMeter defaultBandwidthMeter;
        synchronized (DefaultBandwidthMeter.class) {
            if (singletonInstance == null) {
                singletonInstance = new Builder(context2).build();
            }
            defaultBandwidthMeter = singletonInstance;
        }
        return defaultBandwidthMeter;
    }

    @Deprecated
    public DefaultBandwidthMeter() {
        this(null, new SparseArray(), 2000, Clock.DEFAULT, false);
    }

    private DefaultBandwidthMeter(Context context2, SparseArray<Long> sparseArray, int i, Clock clock2, boolean z) {
        Context context3;
        int i2;
        if (context2 == null) {
            context3 = null;
        } else {
            context3 = context2.getApplicationContext();
        }
        this.context = context3;
        this.initialBitrateEstimates = sparseArray;
        this.eventDispatcher = new EventDispatcher<>();
        this.slidingPercentile = new SlidingPercentile(i);
        this.clock = clock2;
        if (context2 == null) {
            i2 = 0;
        } else {
            i2 = Util.getNetworkType(context2);
        }
        this.networkType = i2;
        this.bitrateEstimate = getInitialBitrateEstimateForNetworkType(this.networkType);
        if (context2 != null && z) {
            ConnectivityActionReceiver.getInstance(context2).register(this);
        }
    }

    public final synchronized void setNetworkTypeOverride(int i) {
        this.networkTypeOverride = i;
        this.networkTypeOverrideSet = true;
        onConnectivityAction();
    }

    public final synchronized long getBitrateEstimate() {
        return this.bitrateEstimate;
    }

    public final void addEventListener(Handler handler, BandwidthMeter.EventListener eventListener) {
        this.eventDispatcher.addListener(handler, eventListener);
    }

    public final void removeEventListener(BandwidthMeter.EventListener eventListener) {
        this.eventDispatcher.removeListener(eventListener);
    }

    public final synchronized void onTransferStart(DataSource dataSource, DataSpec dataSpec, boolean z) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z)) {
            if (this.streamCount == 0) {
                this.sampleStartTimeMs = this.clock.elapsedRealtime();
            }
            this.streamCount++;
        }
    }

    public final synchronized void onBytesTransferred(DataSource dataSource, DataSpec dataSpec, boolean z, int i) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z)) {
            this.sampleBytesTransferred += (long) i;
        }
    }

    public final synchronized void onTransferEnd(DataSource dataSource, DataSpec dataSpec, boolean z) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z)) {
            Assertions.checkState(this.streamCount > 0);
            long elapsedRealtime = this.clock.elapsedRealtime();
            int i = (int) (elapsedRealtime - this.sampleStartTimeMs);
            this.totalElapsedTimeMs += (long) i;
            this.totalBytesTransferred += this.sampleBytesTransferred;
            if (i > 0) {
                this.slidingPercentile.addSample((int) Math.sqrt((double) this.sampleBytesTransferred), (((float) this.sampleBytesTransferred) * 8000.0f) / ((float) i));
                if (this.totalElapsedTimeMs >= 2000 || this.totalBytesTransferred >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                    this.bitrateEstimate = (long) this.slidingPercentile.getPercentile(0.5f);
                }
                maybeNotifyBandwidthSample(i, this.sampleBytesTransferred, this.bitrateEstimate);
                this.sampleStartTimeMs = elapsedRealtime;
                this.sampleBytesTransferred = 0;
            }
            this.streamCount--;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0059, code lost:
        return;
     */
    public final synchronized void onConnectivityAction() {
        int networkType2 = this.networkTypeOverrideSet ? this.networkTypeOverride : this.context == null ? 0 : Util.getNetworkType(this.context);
        if (this.networkType != networkType2) {
            this.networkType = networkType2;
            if (!(networkType2 == 1 || networkType2 == 0)) {
                if (networkType2 != 8) {
                    this.bitrateEstimate = getInitialBitrateEstimateForNetworkType(networkType2);
                    long elapsedRealtime = this.clock.elapsedRealtime();
                    maybeNotifyBandwidthSample(this.streamCount > 0 ? (int) (elapsedRealtime - this.sampleStartTimeMs) : 0, this.sampleBytesTransferred, this.bitrateEstimate);
                    this.sampleStartTimeMs = elapsedRealtime;
                    this.sampleBytesTransferred = 0;
                    this.totalBytesTransferred = 0;
                    this.totalElapsedTimeMs = 0;
                    this.slidingPercentile.reset();
                }
            }
        }
    }

    private void maybeNotifyBandwidthSample(int i, long j, long j2) {
        if (i != 0 || j != 0 || j2 != this.lastReportedBitrateEstimate) {
            this.lastReportedBitrateEstimate = j2;
            this.eventDispatcher.dispatch(new EventDispatcher.Event(i, j, j2) {
                /* class com.google.android.exoplayer2.upstream.$$Lambda$DefaultBandwidthMeter$5fiwNBHdIyEsfLPs7kZdGg5uwiw */
                private final /* synthetic */ int f$0;
                private final /* synthetic */ long f$1;
                private final /* synthetic */ long f$2;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r4;
                }

                public final void sendTo(Object obj) {
                    ((BandwidthMeter.EventListener) obj).onBandwidthSample(this.f$0, this.f$1, this.f$2);
                }
            });
        }
    }

    private long getInitialBitrateEstimateForNetworkType(int i) {
        Long l = this.initialBitrateEstimates.get(i);
        if (l == null) {
            l = this.initialBitrateEstimates.get(0);
        }
        if (l == null) {
            l = 1000000L;
        }
        return l.longValue();
    }

    private static boolean isTransferAtFullNetworkSpeed(DataSpec dataSpec, boolean z) {
        return z && !dataSpec.isFlagSet(8);
    }

    static class ConnectivityActionReceiver extends BroadcastReceiver {
        private static ConnectivityActionReceiver staticInstance;
        private final ArrayList<WeakReference<DefaultBandwidthMeter>> bandwidthMeters = new ArrayList<>();
        private final Handler mainHandler = new Handler(Looper.getMainLooper());

        public static synchronized ConnectivityActionReceiver getInstance(Context context) {
            ConnectivityActionReceiver connectivityActionReceiver;
            synchronized (ConnectivityActionReceiver.class) {
                if (staticInstance == null) {
                    staticInstance = new ConnectivityActionReceiver();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    context.registerReceiver(staticInstance, intentFilter);
                }
                connectivityActionReceiver = staticInstance;
            }
            return connectivityActionReceiver;
        }

        private ConnectivityActionReceiver() {
        }

        public synchronized void register(DefaultBandwidthMeter defaultBandwidthMeter) {
            removeClearedReferences();
            this.bandwidthMeters.add(new WeakReference(defaultBandwidthMeter));
            this.mainHandler.post(new Runnable(defaultBandwidthMeter) {
                /* class com.google.android.exoplayer2.upstream.$$Lambda$DefaultBandwidthMeter$ConnectivityActionReceiver$5orKCfoWtCCTqIpHqEoV8DMTWQ */
                private final /* synthetic */ DefaultBandwidthMeter f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    DefaultBandwidthMeter.ConnectivityActionReceiver.this.lambda$register$0$DefaultBandwidthMeter$ConnectivityActionReceiver(this.f$1);
                }
            });
        }

        public synchronized void onReceive(Context context, Intent intent) {
            if (!isInitialStickyBroadcast()) {
                removeClearedReferences();
                for (int i = 0; i < this.bandwidthMeters.size(); i++) {
                    DefaultBandwidthMeter defaultBandwidthMeter = (DefaultBandwidthMeter) this.bandwidthMeters.get(i).get();
                    if (defaultBandwidthMeter != null) {
                        lambda$register$0$DefaultBandwidthMeter$ConnectivityActionReceiver(defaultBandwidthMeter);
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: updateBandwidthMeter */
        public void lambda$register$0$DefaultBandwidthMeter$ConnectivityActionReceiver(DefaultBandwidthMeter defaultBandwidthMeter) {
            defaultBandwidthMeter.onConnectivityAction();
        }

        private void removeClearedReferences() {
            for (int size = this.bandwidthMeters.size() - 1; size >= 0; size--) {
                if (((DefaultBandwidthMeter) this.bandwidthMeters.get(size).get()) == null) {
                    this.bandwidthMeters.remove(size);
                }
            }
        }
    }

    private static Map<String, int[]> createInitialBitrateCountryGroupAssignment() {
        HashMap hashMap = new HashMap();
        hashMap.put("AD", new int[]{1, 1, 0, 0});
        hashMap.put("AE", new int[]{1, 4, 4, 4});
        hashMap.put("AF", new int[]{4, 4, 3, 3});
        hashMap.put("AG", new int[]{3, 1, 0, 1});
        hashMap.put("AI", new int[]{1, 0, 0, 3});
        hashMap.put("AL", new int[]{1, 2, 0, 1});
        hashMap.put("AM", new int[]{2, 2, 2, 2});
        hashMap.put("AO", new int[]{3, 4, 2, 0});
        hashMap.put("AR", new int[]{2, 3, 2, 2});
        hashMap.put("AS", new int[]{3, 0, 4, 2});
        hashMap.put("AT", new int[]{0, 3, 0, 0});
        hashMap.put("AU", new int[]{0, 3, 0, 1});
        hashMap.put("AW", new int[]{1, 1, 0, 3});
        hashMap.put("AX", new int[]{0, 3, 0, 2});
        hashMap.put("AZ", new int[]{3, 3, 3, 3});
        hashMap.put("BA", new int[]{1, 1, 0, 1});
        hashMap.put("BB", new int[]{0, 2, 0, 0});
        hashMap.put("BD", new int[]{2, 1, 3, 3});
        hashMap.put("BE", new int[]{0, 0, 0, 1});
        hashMap.put("BF", new int[]{4, 4, 4, 1});
        hashMap.put("BG", new int[]{0, 1, 0, 0});
        hashMap.put("BH", new int[]{2, 1, 3, 4});
        hashMap.put("BI", new int[]{4, 4, 4, 4});
        hashMap.put("BJ", new int[]{4, 4, 4, 4});
        hashMap.put("BL", new int[]{1, 0, 2, 2});
        hashMap.put("BM", new int[]{1, 2, 0, 0});
        hashMap.put("BN", new int[]{4, 1, 3, 2});
        hashMap.put("BO", new int[]{1, 2, 3, 2});
        hashMap.put("BQ", new int[]{1, 1, 2, 4});
        hashMap.put("BR", new int[]{2, 3, 3, 2});
        hashMap.put("BS", new int[]{2, 1, 1, 4});
        hashMap.put("BT", new int[]{3, 0, 3, 1});
        hashMap.put("BW", new int[]{4, 4, 1, 2});
        hashMap.put("BY", new int[]{0, 1, 1, 2});
        hashMap.put("BZ", new int[]{2, 2, 2, 1});
        hashMap.put("CA", new int[]{0, 3, 1, 3});
        hashMap.put("CD", new int[]{4, 4, 2, 2});
        hashMap.put("CF", new int[]{4, 4, 3, 0});
        hashMap.put("CG", new int[]{3, 4, 2, 4});
        hashMap.put("CH", new int[]{0, 0, 1, 0});
        hashMap.put("CI", new int[]{3, 4, 3, 3});
        hashMap.put("CK", new int[]{2, 4, 1, 0});
        hashMap.put("CL", new int[]{1, 2, 2, 3});
        hashMap.put("CM", new int[]{3, 4, 3, 1});
        hashMap.put("CN", new int[]{2, 0, 2, 3});
        hashMap.put("CO", new int[]{2, 3, 2, 2});
        hashMap.put("CR", new int[]{2, 3, 4, 4});
        hashMap.put("CU", new int[]{4, 4, 3, 1});
        hashMap.put("CV", new int[]{2, 3, 1, 2});
        hashMap.put("CW", new int[]{1, 1, 0, 0});
        hashMap.put("CY", new int[]{1, 1, 0, 0});
        hashMap.put("CZ", new int[]{0, 1, 0, 0});
        hashMap.put("DE", new int[]{0, 1, 1, 3});
        hashMap.put("DJ", new int[]{4, 3, 4, 1});
        hashMap.put("DK", new int[]{0, 0, 1, 1});
        hashMap.put("DM", new int[]{1, 0, 1, 3});
        hashMap.put("DO", new int[]{3, 3, 4, 4});
        hashMap.put("DZ", new int[]{3, 3, 4, 4});
        hashMap.put("EC", new int[]{2, 3, 4, 3});
        hashMap.put("EE", new int[]{0, 1, 0, 0});
        hashMap.put("EG", new int[]{3, 4, 2, 2});
        hashMap.put("EH", new int[]{2, 0, 3, 3});
        hashMap.put("ER", new int[]{4, 2, 2, 0});
        hashMap.put("ES", new int[]{0, 1, 1, 1});
        hashMap.put("ET", new int[]{4, 4, 4, 0});
        hashMap.put("FI", new int[]{0, 0, 1, 0});
        hashMap.put("FJ", new int[]{3, 0, 3, 3});
        hashMap.put("FK", new int[]{3, 4, 2, 2});
        hashMap.put("FM", new int[]{4, 0, 4, 0});
        hashMap.put("FO", new int[]{0, 0, 0, 0});
        hashMap.put("FR", new int[]{1, 0, 3, 1});
        hashMap.put("GA", new int[]{3, 3, 2, 2});
        hashMap.put("GB", new int[]{0, 1, 3, 3});
        hashMap.put("GD", new int[]{2, 0, 4, 4});
        hashMap.put("GE", new int[]{1, 1, 1, 4});
        hashMap.put("GF", new int[]{2, 3, 4, 4});
        hashMap.put("GG", new int[]{0, 1, 0, 0});
        hashMap.put("GH", new int[]{3, 3, 2, 2});
        hashMap.put("GI", new int[]{0, 0, 0, 1});
        hashMap.put("GL", new int[]{2, 2, 0, 2});
        hashMap.put("GM", new int[]{4, 4, 3, 4});
        hashMap.put("GN", new int[]{3, 4, 4, 2});
        hashMap.put("GP", new int[]{2, 1, 1, 4});
        hashMap.put("GQ", new int[]{4, 4, 3, 0});
        hashMap.put("GR", new int[]{1, 1, 0, 2});
        hashMap.put("GT", new int[]{3, 3, 3, 3});
        hashMap.put("GU", new int[]{1, 2, 4, 4});
        hashMap.put("GW", new int[]{4, 4, 4, 1});
        hashMap.put("GY", new int[]{3, 2, 1, 1});
        hashMap.put("HK", new int[]{0, 2, 3, 4});
        hashMap.put("HN", new int[]{3, 2, 3, 2});
        hashMap.put("HR", new int[]{1, 1, 0, 1});
        hashMap.put("HT", new int[]{4, 4, 4, 4});
        hashMap.put("HU", new int[]{0, 1, 0, 0});
        hashMap.put("ID", new int[]{3, 2, 3, 4});
        hashMap.put("IE", new int[]{1, 0, 1, 1});
        hashMap.put("IL", new int[]{0, 0, 2, 3});
        hashMap.put("IM", new int[]{0, 0, 0, 1});
        hashMap.put("IN", new int[]{2, 2, 4, 4});
        hashMap.put("IO", new int[]{4, 2, 2, 2});
        hashMap.put("IQ", new int[]{3, 3, 4, 2});
        hashMap.put("IR", new int[]{3, 0, 2, 2});
        hashMap.put("IS", new int[]{0, 1, 0, 0});
        hashMap.put("IT", new int[]{1, 0, 1, 2});
        hashMap.put("JE", new int[]{1, 0, 0, 1});
        hashMap.put("JM", new int[]{2, 3, 3, 1});
        hashMap.put("JO", new int[]{1, 2, 1, 2});
        hashMap.put("JP", new int[]{0, 2, 1, 1});
        hashMap.put("KE", new int[]{3, 4, 4, 3});
        hashMap.put("KG", new int[]{1, 1, 2, 2});
        hashMap.put("KH", new int[]{1, 0, 4, 4});
        hashMap.put("KI", new int[]{4, 4, 4, 4});
        hashMap.put("KM", new int[]{4, 3, 2, 3});
        hashMap.put("KN", new int[]{1, 0, 1, 3});
        hashMap.put("KP", new int[]{4, 2, 4, 2});
        hashMap.put("KR", new int[]{0, 1, 1, 1});
        hashMap.put("KW", new int[]{2, 3, 1, 1});
        hashMap.put("KY", new int[]{1, 1, 0, 1});
        hashMap.put("KZ", new int[]{1, 2, 2, 3});
        hashMap.put("LA", new int[]{2, 2, 1, 1});
        hashMap.put("LB", new int[]{3, 2, 0, 0});
        hashMap.put("LC", new int[]{1, 1, 0, 0});
        hashMap.put("LI", new int[]{0, 0, 2, 4});
        hashMap.put("LK", new int[]{2, 1, 2, 3});
        hashMap.put("LR", new int[]{3, 4, 3, 1});
        hashMap.put("LS", new int[]{3, 3, 2, 0});
        hashMap.put("LT", new int[]{0, 0, 0, 0});
        hashMap.put("LU", new int[]{0, 0, 0, 0});
        hashMap.put("LV", new int[]{0, 0, 0, 0});
        hashMap.put("LY", new int[]{4, 4, 4, 4});
        hashMap.put("MA", new int[]{2, 1, 2, 1});
        hashMap.put("MC", new int[]{0, 0, 0, 1});
        hashMap.put("MD", new int[]{1, 1, 0, 0});
        hashMap.put("ME", new int[]{1, 2, 1, 2});
        hashMap.put("MF", new int[]{1, 1, 1, 1});
        hashMap.put("MG", new int[]{3, 4, 2, 2});
        hashMap.put("MH", new int[]{4, 0, 2, 4});
        hashMap.put("MK", new int[]{1, 0, 0, 0});
        hashMap.put("ML", new int[]{4, 4, 2, 0});
        hashMap.put("MM", new int[]{3, 3, 1, 2});
        hashMap.put("MN", new int[]{2, 3, 2, 3});
        hashMap.put("MO", new int[]{0, 0, 4, 4});
        hashMap.put("MP", new int[]{0, 2, 4, 4});
        hashMap.put("MQ", new int[]{2, 1, 1, 4});
        hashMap.put("MR", new int[]{4, 2, 4, 2});
        hashMap.put("MS", new int[]{1, 2, 3, 3});
        hashMap.put("MT", new int[]{0, 1, 0, 0});
        hashMap.put("MU", new int[]{2, 2, 3, 4});
        hashMap.put("MV", new int[]{4, 3, 0, 2});
        hashMap.put("MW", new int[]{3, 2, 1, 0});
        hashMap.put("MX", new int[]{2, 4, 4, 3});
        hashMap.put("MY", new int[]{2, 2, 3, 3});
        hashMap.put("MZ", new int[]{3, 3, 2, 1});
        hashMap.put("NA", new int[]{3, 3, 2, 1});
        hashMap.put("NC", new int[]{2, 0, 3, 3});
        hashMap.put("NE", new int[]{4, 4, 4, 3});
        hashMap.put("NF", new int[]{1, 2, 2, 2});
        hashMap.put("NG", new int[]{3, 4, 3, 1});
        hashMap.put("NI", new int[]{3, 3, 4, 4});
        hashMap.put("NL", new int[]{0, 2, 3, 3});
        hashMap.put("NO", new int[]{0, 1, 1, 0});
        hashMap.put("NP", new int[]{2, 2, 2, 2});
        hashMap.put("NR", new int[]{4, 0, 3, 1});
        hashMap.put("NZ", new int[]{0, 0, 1, 2});
        hashMap.put("OM", new int[]{3, 2, 1, 3});
        hashMap.put("PA", new int[]{1, 3, 3, 4});
        hashMap.put("PE", new int[]{2, 3, 4, 4});
        hashMap.put("PF", new int[]{2, 2, 0, 1});
        hashMap.put("PG", new int[]{4, 3, 3, 1});
        hashMap.put("PH", new int[]{3, 0, 3, 4});
        hashMap.put("PK", new int[]{3, 3, 3, 3});
        hashMap.put("PL", new int[]{1, 0, 1, 3});
        hashMap.put("PM", new int[]{0, 2, 2, 0});
        hashMap.put("PR", new int[]{1, 2, 3, 3});
        hashMap.put("PS", new int[]{3, 3, 2, 4});
        hashMap.put("PT", new int[]{1, 1, 0, 0});
        hashMap.put("PW", new int[]{2, 1, 2, 0});
        hashMap.put("PY", new int[]{2, 0, 2, 3});
        hashMap.put("QA", new int[]{2, 2, 1, 2});
        hashMap.put("RE", new int[]{1, 0, 2, 2});
        hashMap.put("RO", new int[]{0, 1, 1, 2});
        hashMap.put("RS", new int[]{1, 2, 0, 0});
        hashMap.put("RU", new int[]{0, 1, 1, 1});
        hashMap.put("RW", new int[]{4, 4, 2, 4});
        hashMap.put("SA", new int[]{2, 2, 2, 1});
        hashMap.put("SB", new int[]{4, 4, 3, 0});
        hashMap.put("SC", new int[]{4, 2, 0, 1});
        hashMap.put("SD", new int[]{4, 4, 4, 3});
        hashMap.put("SE", new int[]{0, 1, 0, 0});
        hashMap.put("SG", new int[]{0, 2, 3, 3});
        hashMap.put("SH", new int[]{4, 4, 2, 3});
        hashMap.put("SI", new int[]{0, 0, 0, 0});
        hashMap.put("SJ", new int[]{2, 0, 2, 4});
        hashMap.put("SK", new int[]{0, 1, 0, 0});
        hashMap.put("SL", new int[]{4, 3, 3, 3});
        hashMap.put("SM", new int[]{0, 0, 2, 4});
        hashMap.put("SN", new int[]{3, 4, 4, 2});
        hashMap.put("SO", new int[]{3, 4, 4, 3});
        hashMap.put("SR", new int[]{2, 2, 1, 0});
        hashMap.put("SS", new int[]{4, 3, 4, 3});
        hashMap.put("ST", new int[]{3, 4, 2, 2});
        hashMap.put("SV", new int[]{2, 3, 3, 4});
        hashMap.put("SX", new int[]{2, 4, 1, 0});
        hashMap.put("SY", new int[]{4, 3, 2, 1});
        hashMap.put("SZ", new int[]{4, 4, 3, 4});
        hashMap.put("TC", new int[]{1, 2, 1, 1});
        hashMap.put("TD", new int[]{4, 4, 4, 2});
        hashMap.put("TG", new int[]{3, 3, 1, 0});
        hashMap.put("TH", new int[]{1, 3, 4, 4});
        hashMap.put("TJ", new int[]{4, 4, 4, 4});
        hashMap.put("TL", new int[]{4, 2, 4, 4});
        hashMap.put("TM", new int[]{4, 1, 2, 2});
        hashMap.put("TN", new int[]{2, 2, 1, 2});
        hashMap.put("TO", new int[]{3, 3, 3, 1});
        hashMap.put("TR", new int[]{2, 2, 1, 2});
        hashMap.put("TT", new int[]{1, 3, 1, 2});
        hashMap.put("TV", new int[]{4, 2, 2, 4});
        hashMap.put("TW", new int[]{0, 0, 0, 0});
        hashMap.put("TZ", new int[]{3, 3, 4, 3});
        hashMap.put("UA", new int[]{0, 2, 1, 2});
        hashMap.put("UG", new int[]{4, 3, 3, 2});
        hashMap.put("US", new int[]{1, 1, 3, 3});
        hashMap.put("UY", new int[]{2, 2, 1, 1});
        hashMap.put("UZ", new int[]{2, 2, 2, 2});
        hashMap.put("VA", new int[]{1, 2, 4, 2});
        hashMap.put("VC", new int[]{2, 0, 2, 4});
        hashMap.put("VE", new int[]{4, 4, 4, 3});
        hashMap.put("VG", new int[]{3, 0, 1, 3});
        hashMap.put("VI", new int[]{1, 1, 4, 4});
        hashMap.put("VN", new int[]{0, 2, 4, 4});
        hashMap.put("VU", new int[]{4, 1, 3, 1});
        hashMap.put("WS", new int[]{3, 3, 3, 2});
        hashMap.put("XK", new int[]{1, 2, 1, 0});
        hashMap.put("YE", new int[]{4, 4, 4, 3});
        hashMap.put("YT", new int[]{2, 2, 2, 3});
        hashMap.put("ZA", new int[]{2, 4, 2, 2});
        hashMap.put("ZM", new int[]{3, 2, 2, 1});
        hashMap.put("ZW", new int[]{3, 3, 2, 1});
        return Collections.unmodifiableMap(hashMap);
    }
}

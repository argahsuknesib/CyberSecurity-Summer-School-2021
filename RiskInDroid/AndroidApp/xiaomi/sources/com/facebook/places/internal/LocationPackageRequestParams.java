package com.facebook.places.internal;

import com.google.android.exoplayer2.source.dash.DashMediaSource;

public class LocationPackageRequestParams {
    public static final String[] DEFAULT_LOCATION_PROVIDERS = {"network", "gps"};
    private long bluetoothFlushResultsTimeoutMs;
    private int bluetoothMaxScanResults;
    private long bluetoothScanDurationMs;
    private boolean isBluetoothScanEnabled;
    private boolean isLocationScanEnabled;
    private boolean isWifiActiveScanAllowed;
    private boolean isWifiActiveScanForced;
    private boolean isWifiScanEnabled;
    private long lastLocationMaxAgeMs;
    private float locationMaxAccuracyMeters;
    private final String[] locationProviders;
    private long locationRequestTimeoutMs;
    private int wifiMaxScanResults;
    private long wifiScanMaxAgeMs;
    private long wifiScanTimeoutMs;

    private LocationPackageRequestParams(Builder builder) {
        this.isLocationScanEnabled = builder.isLocationScanEnabled;
        this.locationProviders = builder.locationProviders;
        this.locationMaxAccuracyMeters = builder.locationMaxAccuracyMeters;
        this.locationRequestTimeoutMs = builder.locationRequestTimeoutMs;
        this.lastLocationMaxAgeMs = builder.lastLocationMaxAgeMs;
        this.isWifiScanEnabled = builder.isWifiScanEnabled;
        this.wifiScanMaxAgeMs = builder.wifiScanMaxAgeMs;
        this.wifiMaxScanResults = builder.wifiMaxScanResults;
        this.wifiScanTimeoutMs = builder.wifiScanTimeoutMs;
        this.isWifiActiveScanAllowed = builder.isWifiActiveScanAllowed;
        this.isWifiActiveScanForced = builder.isWifiActiveScanForced;
        this.isBluetoothScanEnabled = builder.isBluetoothScanEnabled;
        this.bluetoothScanDurationMs = builder.bluetoothScanDurationMs;
        this.bluetoothMaxScanResults = builder.bluetoothMaxScanResults;
        this.bluetoothFlushResultsTimeoutMs = builder.bluetoothFlushResultsTimeoutMs;
    }

    public boolean isLocationScanEnabled() {
        return this.isLocationScanEnabled;
    }

    public String[] getLocationProviders() {
        return this.locationProviders;
    }

    public float getLocationMaxAccuracyMeters() {
        return this.locationMaxAccuracyMeters;
    }

    public long getLocationRequestTimeoutMs() {
        return this.locationRequestTimeoutMs;
    }

    public long getLastLocationMaxAgeMs() {
        return this.lastLocationMaxAgeMs;
    }

    public boolean isWifiScanEnabled() {
        return this.isWifiScanEnabled;
    }

    public long getWifiScanMaxAgeMs() {
        return this.wifiScanMaxAgeMs;
    }

    public int getWifiMaxScanResults() {
        return this.wifiMaxScanResults;
    }

    public long getWifiScanTimeoutMs() {
        return this.wifiScanTimeoutMs;
    }

    public boolean isWifiActiveScanAllowed() {
        return this.isWifiActiveScanAllowed;
    }

    public boolean isWifiActiveScanForced() {
        return this.isWifiActiveScanForced;
    }

    public boolean isBluetoothScanEnabled() {
        return this.isBluetoothScanEnabled;
    }

    public long getBluetoothScanDurationMs() {
        return this.bluetoothScanDurationMs;
    }

    public long getBluetoothFlushResultsTimeoutMs() {
        return this.bluetoothFlushResultsTimeoutMs;
    }

    public int getBluetoothMaxScanResults() {
        return this.bluetoothMaxScanResults;
    }

    public static class Builder {
        public long bluetoothFlushResultsTimeoutMs = 300;
        public int bluetoothMaxScanResults = 25;
        public long bluetoothScanDurationMs = 500;
        public boolean isBluetoothScanEnabled = true;
        public boolean isLocationScanEnabled = true;
        public boolean isWifiActiveScanAllowed = true;
        public boolean isWifiActiveScanForced = false;
        public boolean isWifiScanEnabled = true;
        public long lastLocationMaxAgeMs = 60000;
        public float locationMaxAccuracyMeters = 100.0f;
        public String[] locationProviders = LocationPackageRequestParams.DEFAULT_LOCATION_PROVIDERS;
        public long locationRequestTimeoutMs = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
        public int wifiMaxScanResults = 25;
        public long wifiScanMaxAgeMs = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
        public long wifiScanTimeoutMs = 6000;

        public LocationPackageRequestParams build() {
            return new LocationPackageRequestParams(this);
        }

        public Builder setLocationScanEnabled(boolean z) {
            this.isLocationScanEnabled = z;
            return this;
        }

        public Builder setLastLocationMaxAgeMs(long j) {
            this.lastLocationMaxAgeMs = j;
            return this;
        }

        public Builder setLocationProviders(String[] strArr) {
            this.locationProviders = strArr;
            return this;
        }

        public Builder setLocationMaxAccuracyMeters(float f) {
            this.locationMaxAccuracyMeters = f;
            return this;
        }

        public Builder setLocationRequestTimeoutMs(long j) {
            this.locationRequestTimeoutMs = j;
            return this;
        }

        public Builder setWifiScanEnabled(boolean z) {
            this.isWifiScanEnabled = z;
            return this;
        }

        public Builder setWifiScanMaxAgeMs(long j) {
            this.wifiScanMaxAgeMs = j;
            return this;
        }

        public Builder setWifiMaxScanResults(int i) {
            this.wifiMaxScanResults = i;
            return this;
        }

        public Builder setWifiScanTimeoutMs(long j) {
            this.wifiScanTimeoutMs = j;
            return this;
        }

        public Builder setWifiActiveScanAllowed(boolean z) {
            this.isWifiActiveScanAllowed = z;
            return this;
        }

        public Builder setWifiActiveScanForced(boolean z) {
            this.isWifiActiveScanForced = z;
            return this;
        }

        public Builder setBluetoothScanEnabled(boolean z) {
            this.isBluetoothScanEnabled = z;
            return this;
        }

        public Builder setBluetoothScanDurationMs(long j) {
            this.bluetoothScanDurationMs = j;
            return this;
        }

        public Builder setBluetoothMaxScanResults(int i) {
            this.bluetoothMaxScanResults = i;
            return this;
        }

        public Builder setBluetoothFlushResultsTimeoutMs(long j) {
            this.bluetoothFlushResultsTimeoutMs = j;
            return this;
        }
    }
}

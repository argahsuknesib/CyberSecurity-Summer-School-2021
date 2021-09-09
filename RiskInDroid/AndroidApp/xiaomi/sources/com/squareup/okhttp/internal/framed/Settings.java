package com.squareup.okhttp.internal.framed;

import android.support.v4.app.NotificationCompat;
import java.util.Arrays;

public final class Settings {
    private int persistValue;
    private int persisted;
    private int set;
    private final int[] values = new int[10];

    /* access modifiers changed from: package-private */
    public final void clear() {
        this.persisted = 0;
        this.persistValue = 0;
        this.set = 0;
        Arrays.fill(this.values, 0);
    }

    /* access modifiers changed from: package-private */
    public final Settings set(int i, int i2, int i3) {
        if (i >= this.values.length) {
            return this;
        }
        int i4 = 1 << i;
        this.set |= i4;
        if ((i2 & 1) != 0) {
            this.persistValue |= i4;
        } else {
            this.persistValue &= i4 ^ -1;
        }
        if ((i2 & 2) != 0) {
            this.persisted |= i4;
        } else {
            this.persisted &= i4 ^ -1;
        }
        this.values[i] = i3;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final boolean isSet(int i) {
        return ((1 << i) & this.set) != 0;
    }

    /* access modifiers changed from: package-private */
    public final int get(int i) {
        return this.values[i];
    }

    /* access modifiers changed from: package-private */
    public final int flags(int i) {
        int i2 = isPersisted(i) ? 2 : 0;
        return persistValue(i) ? i2 | 1 : i2;
    }

    /* access modifiers changed from: package-private */
    public final int size() {
        return Integer.bitCount(this.set);
    }

    /* access modifiers changed from: package-private */
    public final int getUploadBandwidth(int i) {
        return (this.set & 2) != 0 ? this.values[1] : i;
    }

    /* access modifiers changed from: package-private */
    public final int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final int getDownloadBandwidth(int i) {
        return (this.set & 4) != 0 ? this.values[2] : i;
    }

    /* access modifiers changed from: package-private */
    public final boolean getEnablePush(boolean z) {
        return ((this.set & 4) != 0 ? this.values[2] : z ? 1 : 0) == 1;
    }

    /* access modifiers changed from: package-private */
    public final int getRoundTripTime(int i) {
        return (this.set & 8) != 0 ? this.values[3] : i;
    }

    /* access modifiers changed from: package-private */
    public final int getMaxConcurrentStreams(int i) {
        return (this.set & 16) != 0 ? this.values[4] : i;
    }

    /* access modifiers changed from: package-private */
    public final int getCurrentCwnd(int i) {
        return (this.set & 32) != 0 ? this.values[5] : i;
    }

    /* access modifiers changed from: package-private */
    public final int getMaxFrameSize(int i) {
        return (this.set & 32) != 0 ? this.values[5] : i;
    }

    /* access modifiers changed from: package-private */
    public final int getDownloadRetransRate(int i) {
        return (this.set & 64) != 0 ? this.values[6] : i;
    }

    /* access modifiers changed from: package-private */
    public final int getMaxHeaderListSize(int i) {
        return (this.set & 64) != 0 ? this.values[6] : i;
    }

    /* access modifiers changed from: package-private */
    public final int getInitialWindowSize(int i) {
        return (this.set & NotificationCompat.FLAG_HIGH_PRIORITY) != 0 ? this.values[7] : i;
    }

    /* access modifiers changed from: package-private */
    public final int getClientCertificateVectorSize(int i) {
        return (this.set & 256) != 0 ? this.values[8] : i;
    }

    /* access modifiers changed from: package-private */
    public final boolean isFlowControlDisabled() {
        return (((this.set & 1024) != 0 ? this.values[10] : 0) & 1) != 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean persistValue(int i) {
        return ((1 << i) & this.persistValue) != 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean isPersisted(int i) {
        return ((1 << i) & this.persisted) != 0;
    }

    /* access modifiers changed from: package-private */
    public final void merge(Settings settings) {
        for (int i = 0; i < 10; i++) {
            if (settings.isSet(i)) {
                set(i, settings.flags(i), settings.get(i));
            }
        }
    }
}

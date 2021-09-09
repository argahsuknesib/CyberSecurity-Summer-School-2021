package okhttp3.internal.http2;

import android.support.v4.app.NotificationCompat;
import java.util.Arrays;

public final class Settings {
    private int set;
    private final int[] values = new int[10];

    /* access modifiers changed from: package-private */
    public final void clear() {
        this.set = 0;
        Arrays.fill(this.values, 0);
    }

    /* access modifiers changed from: package-private */
    public final Settings set(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.values;
            if (i < iArr.length) {
                this.set = (1 << i) | this.set;
                iArr[i] = i2;
            }
        }
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
    public final int size() {
        return Integer.bitCount(this.set);
    }

    /* access modifiers changed from: package-private */
    public final int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final boolean getEnablePush(boolean z) {
        return ((this.set & 4) != 0 ? this.values[2] : z ? 1 : 0) == 1;
    }

    /* access modifiers changed from: package-private */
    public final int getMaxConcurrentStreams(int i) {
        return (this.set & 16) != 0 ? this.values[4] : i;
    }

    /* access modifiers changed from: package-private */
    public final int getMaxFrameSize(int i) {
        return (this.set & 32) != 0 ? this.values[5] : i;
    }

    /* access modifiers changed from: package-private */
    public final int getMaxHeaderListSize(int i) {
        return (this.set & 64) != 0 ? this.values[6] : i;
    }

    /* access modifiers changed from: package-private */
    public final int getInitialWindowSize() {
        if ((this.set & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
            return this.values[7];
        }
        return 65535;
    }

    /* access modifiers changed from: package-private */
    public final void merge(Settings settings) {
        for (int i = 0; i < 10; i++) {
            if (settings.isSet(i)) {
                set(i, settings.get(i));
            }
        }
    }
}

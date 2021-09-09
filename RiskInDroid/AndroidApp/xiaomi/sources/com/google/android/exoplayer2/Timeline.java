package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public abstract class Timeline {
    public static final Timeline EMPTY = new Timeline() {
        /* class com.google.android.exoplayer2.Timeline.AnonymousClass1 */

        public final int getIndexOfPeriod(Object obj) {
            return -1;
        }

        public final int getPeriodCount() {
            return 0;
        }

        public final int getWindowCount() {
            return 0;
        }

        public final Window getWindow(int i, Window window, long j) {
            throw new IndexOutOfBoundsException();
        }

        public final Period getPeriod(int i, Period period, boolean z) {
            throw new IndexOutOfBoundsException();
        }

        public final Object getUidOfPeriod(int i) {
            throw new IndexOutOfBoundsException();
        }
    };

    public abstract int getIndexOfPeriod(Object obj);

    public abstract Period getPeriod(int i, Period period, boolean z);

    public abstract int getPeriodCount();

    public abstract Object getUidOfPeriod(int i);

    public abstract Window getWindow(int i, Window window, long j);

    public abstract int getWindowCount();

    public static final class Window {
        public static final Object SINGLE_WINDOW_UID = new Object();
        public long defaultPositionUs;
        public long durationUs;
        public long elapsedRealtimeEpochOffsetMs;
        public int firstPeriodIndex;
        public boolean isDynamic;
        public boolean isLive;
        public boolean isPlaceholder;
        public boolean isSeekable;
        public int lastPeriodIndex;
        public Object manifest;
        public long positionInFirstPeriodUs;
        public long presentationStartTimeMs;
        public Object tag;
        public Object uid = SINGLE_WINDOW_UID;
        public long windowStartTimeMs;

        public final Window set(Object obj, Object obj2, Object obj3, long j, long j2, long j3, boolean z, boolean z2, boolean z3, long j4, long j5, int i, int i2, long j6) {
            this.uid = obj;
            this.tag = obj2;
            this.manifest = obj3;
            this.presentationStartTimeMs = j;
            this.windowStartTimeMs = j2;
            this.elapsedRealtimeEpochOffsetMs = j3;
            this.isSeekable = z;
            this.isDynamic = z2;
            this.isLive = z3;
            this.defaultPositionUs = j4;
            this.durationUs = j5;
            this.firstPeriodIndex = i;
            this.lastPeriodIndex = i2;
            this.positionInFirstPeriodUs = j6;
            this.isPlaceholder = false;
            return this;
        }

        public final long getDefaultPositionMs() {
            return C.usToMs(this.defaultPositionUs);
        }

        public final long getDefaultPositionUs() {
            return this.defaultPositionUs;
        }

        public final long getDurationMs() {
            return C.usToMs(this.durationUs);
        }

        public final long getDurationUs() {
            return this.durationUs;
        }

        public final long getPositionInFirstPeriodMs() {
            return C.usToMs(this.positionInFirstPeriodUs);
        }

        public final long getPositionInFirstPeriodUs() {
            return this.positionInFirstPeriodUs;
        }

        public final long getCurrentUnixTimeMs() {
            return Util.getNowUnixTimeMs(this.elapsedRealtimeEpochOffsetMs);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass().equals(obj.getClass())) {
                Window window = (Window) obj;
                return Util.areEqual(this.uid, window.uid) && Util.areEqual(this.tag, window.tag) && Util.areEqual(this.manifest, window.manifest) && this.presentationStartTimeMs == window.presentationStartTimeMs && this.windowStartTimeMs == window.windowStartTimeMs && this.elapsedRealtimeEpochOffsetMs == window.elapsedRealtimeEpochOffsetMs && this.isSeekable == window.isSeekable && this.isDynamic == window.isDynamic && this.isLive == window.isLive && this.isPlaceholder == window.isPlaceholder && this.defaultPositionUs == window.defaultPositionUs && this.durationUs == window.durationUs && this.firstPeriodIndex == window.firstPeriodIndex && this.lastPeriodIndex == window.lastPeriodIndex && this.positionInFirstPeriodUs == window.positionInFirstPeriodUs;
            }
        }

        public final int hashCode() {
            int hashCode = (this.uid.hashCode() + 217) * 31;
            Object obj = this.tag;
            int i = 0;
            int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.manifest;
            if (obj2 != null) {
                i = obj2.hashCode();
            }
            long j = this.presentationStartTimeMs;
            long j2 = this.windowStartTimeMs;
            long j3 = this.elapsedRealtimeEpochOffsetMs;
            long j4 = this.defaultPositionUs;
            long j5 = this.durationUs;
            long j6 = this.positionInFirstPeriodUs;
            return ((((((((((((((((((((((((hashCode2 + i) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.isSeekable ? 1 : 0)) * 31) + (this.isDynamic ? 1 : 0)) * 31) + (this.isLive ? 1 : 0)) * 31) + (this.isPlaceholder ? 1 : 0)) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + this.firstPeriodIndex) * 31) + this.lastPeriodIndex) * 31) + ((int) (j6 ^ (j6 >>> 32)));
        }
    }

    public static final class Period {
        private AdPlaybackState adPlaybackState = AdPlaybackState.NONE;
        public long durationUs;
        public Object id;
        private long positionInWindowUs;
        public Object uid;
        public int windowIndex;

        public final Period set(Object obj, Object obj2, int i, long j, long j2) {
            return set(obj, obj2, i, j, j2, AdPlaybackState.NONE);
        }

        public final Period set(Object obj, Object obj2, int i, long j, long j2, AdPlaybackState adPlaybackState2) {
            this.id = obj;
            this.uid = obj2;
            this.windowIndex = i;
            this.durationUs = j;
            this.positionInWindowUs = j2;
            this.adPlaybackState = adPlaybackState2;
            return this;
        }

        public final long getDurationMs() {
            return C.usToMs(this.durationUs);
        }

        public final long getDurationUs() {
            return this.durationUs;
        }

        public final long getPositionInWindowMs() {
            return C.usToMs(this.positionInWindowUs);
        }

        public final long getPositionInWindowUs() {
            return this.positionInWindowUs;
        }

        public final int getAdGroupCount() {
            return this.adPlaybackState.adGroupCount;
        }

        public final long getAdGroupTimeUs(int i) {
            return this.adPlaybackState.adGroupTimesUs[i];
        }

        public final int getFirstAdIndexToPlay(int i) {
            return this.adPlaybackState.adGroups[i].getFirstAdIndexToPlay();
        }

        public final int getNextAdIndexToPlay(int i, int i2) {
            return this.adPlaybackState.adGroups[i].getNextAdIndexToPlay(i2);
        }

        public final boolean hasPlayedAdGroup(int i) {
            return !this.adPlaybackState.adGroups[i].hasUnplayedAds();
        }

        public final int getAdGroupIndexForPositionUs(long j) {
            return this.adPlaybackState.getAdGroupIndexForPositionUs(j, this.durationUs);
        }

        public final int getAdGroupIndexAfterPositionUs(long j) {
            return this.adPlaybackState.getAdGroupIndexAfterPositionUs(j, this.durationUs);
        }

        public final int getAdCountInAdGroup(int i) {
            return this.adPlaybackState.adGroups[i].count;
        }

        public final boolean isAdAvailable(int i, int i2) {
            AdPlaybackState.AdGroup adGroup = this.adPlaybackState.adGroups[i];
            return (adGroup.count == -1 || adGroup.states[i2] == 0) ? false : true;
        }

        public final long getAdDurationUs(int i, int i2) {
            AdPlaybackState.AdGroup adGroup = this.adPlaybackState.adGroups[i];
            if (adGroup.count != -1) {
                return adGroup.durationsUs[i2];
            }
            return -9223372036854775807L;
        }

        public final long getAdResumePositionUs() {
            return this.adPlaybackState.adResumePositionUs;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass().equals(obj.getClass())) {
                Period period = (Period) obj;
                return Util.areEqual(this.id, period.id) && Util.areEqual(this.uid, period.uid) && this.windowIndex == period.windowIndex && this.durationUs == period.durationUs && this.positionInWindowUs == period.positionInWindowUs && Util.areEqual(this.adPlaybackState, period.adPlaybackState);
            }
        }

        public final int hashCode() {
            Object obj = this.id;
            int i = 0;
            int hashCode = ((obj == null ? 0 : obj.hashCode()) + 217) * 31;
            Object obj2 = this.uid;
            int hashCode2 = obj2 == null ? 0 : obj2.hashCode();
            long j = this.durationUs;
            long j2 = this.positionInWindowUs;
            int i2 = (((((((hashCode + hashCode2) * 31) + this.windowIndex) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            AdPlaybackState adPlaybackState2 = this.adPlaybackState;
            if (adPlaybackState2 != null) {
                i = adPlaybackState2.hashCode();
            }
            return i2 + i;
        }
    }

    public final boolean isEmpty() {
        return getWindowCount() == 0;
    }

    public int getNextWindowIndex(int i, int i2, boolean z) {
        if (i2 != 0) {
            if (i2 == 1) {
                return i;
            }
            if (i2 == 2) {
                return i == getLastWindowIndex(z) ? getFirstWindowIndex(z) : i + 1;
            }
            throw new IllegalStateException();
        } else if (i == getLastWindowIndex(z)) {
            return -1;
        } else {
            return i + 1;
        }
    }

    public int getPreviousWindowIndex(int i, int i2, boolean z) {
        if (i2 != 0) {
            if (i2 == 1) {
                return i;
            }
            if (i2 == 2) {
                return i == getFirstWindowIndex(z) ? getLastWindowIndex(z) : i - 1;
            }
            throw new IllegalStateException();
        } else if (i == getFirstWindowIndex(z)) {
            return -1;
        } else {
            return i - 1;
        }
    }

    public int getLastWindowIndex(boolean z) {
        if (isEmpty()) {
            return -1;
        }
        return getWindowCount() - 1;
    }

    public int getFirstWindowIndex(boolean z) {
        return isEmpty() ? -1 : 0;
    }

    public final Window getWindow(int i, Window window) {
        return getWindow(i, window, 0);
    }

    @Deprecated
    public final Window getWindow(int i, Window window, boolean z) {
        return getWindow(i, window, 0);
    }

    public final int getNextPeriodIndex(int i, Period period, Window window, int i2, boolean z) {
        int i3 = getPeriod(i, period).windowIndex;
        if (getWindow(i3, window).lastPeriodIndex != i) {
            return i + 1;
        }
        int nextWindowIndex = getNextWindowIndex(i3, i2, z);
        if (nextWindowIndex == -1) {
            return -1;
        }
        return getWindow(nextWindowIndex, window).firstPeriodIndex;
    }

    public final boolean isLastPeriod(int i, Period period, Window window, int i2, boolean z) {
        return getNextPeriodIndex(i, period, window, i2, z) == -1;
    }

    public final Pair<Object, Long> getPeriodPosition(Window window, Period period, int i, long j) {
        return (Pair) Assertions.checkNotNull(getPeriodPosition(window, period, i, j, 0));
    }

    public final Pair<Object, Long> getPeriodPosition(Window window, Period period, int i, long j, long j2) {
        Assertions.checkIndex(i, 0, getWindowCount());
        getWindow(i, window, j2);
        if (j == -9223372036854775807L) {
            j = window.getDefaultPositionUs();
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = window.firstPeriodIndex;
        long positionInFirstPeriodUs = window.getPositionInFirstPeriodUs() + j;
        long durationUs = getPeriod(i2, period, true).getDurationUs();
        while (durationUs != -9223372036854775807L && positionInFirstPeriodUs >= durationUs && i2 < window.lastPeriodIndex) {
            positionInFirstPeriodUs -= durationUs;
            i2++;
            durationUs = getPeriod(i2, period, true).getDurationUs();
        }
        return Pair.create(Assertions.checkNotNull(period.uid), Long.valueOf(positionInFirstPeriodUs));
    }

    public Period getPeriodByUid(Object obj, Period period) {
        return getPeriod(getIndexOfPeriod(obj), period, true);
    }

    public final Period getPeriod(int i, Period period) {
        return getPeriod(i, period, false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Timeline)) {
            return false;
        }
        Timeline timeline = (Timeline) obj;
        if (timeline.getWindowCount() != getWindowCount() || timeline.getPeriodCount() != getPeriodCount()) {
            return false;
        }
        Window window = new Window();
        Period period = new Period();
        Window window2 = new Window();
        Period period2 = new Period();
        for (int i = 0; i < getWindowCount(); i++) {
            if (!getWindow(i, window).equals(timeline.getWindow(i, window2))) {
                return false;
            }
        }
        for (int i2 = 0; i2 < getPeriodCount(); i2++) {
            if (!getPeriod(i2, period, true).equals(timeline.getPeriod(i2, period2, true))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Window window = new Window();
        Period period = new Period();
        int windowCount = getWindowCount() + 217;
        for (int i = 0; i < getWindowCount(); i++) {
            windowCount = (windowCount * 31) + getWindow(i, window).hashCode();
        }
        int periodCount = (windowCount * 31) + getPeriodCount();
        for (int i2 = 0; i2 < getPeriodCount(); i2++) {
            periodCount = (periodCount * 31) + getPeriod(i2, period, true).hashCode();
        }
        return periodCount;
    }
}

package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DashManifest implements FilterableManifest<DashManifest> {
    public final long availabilityStartTimeMs;
    public final long durationMs;
    public final boolean dynamic;
    public final Uri location;
    public final long minBufferTimeMs;
    public final long minUpdatePeriodMs;
    private final List<Period> periods;
    public final ProgramInformation programInformation;
    public final long publishTimeMs;
    public final long suggestedPresentationDelayMs;
    public final long timeShiftBufferDepthMs;
    public final UtcTimingElement utcTiming;

    @Deprecated
    public DashManifest(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, UtcTimingElement utcTimingElement, Uri uri, List<Period> list) {
        this(j, j2, j3, z, j4, j5, j6, j7, null, utcTimingElement, uri, list);
    }

    public DashManifest(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, ProgramInformation programInformation2, UtcTimingElement utcTimingElement, Uri uri, List<Period> list) {
        this.availabilityStartTimeMs = j;
        this.durationMs = j2;
        this.minBufferTimeMs = j3;
        this.dynamic = z;
        this.minUpdatePeriodMs = j4;
        this.timeShiftBufferDepthMs = j5;
        this.suggestedPresentationDelayMs = j6;
        this.publishTimeMs = j7;
        this.programInformation = programInformation2;
        this.utcTiming = utcTimingElement;
        this.location = uri;
        this.periods = list == null ? Collections.emptyList() : list;
    }

    public final int getPeriodCount() {
        return this.periods.size();
    }

    public final Period getPeriod(int i) {
        return this.periods.get(i);
    }

    public final long getPeriodDurationMs(int i) {
        long j;
        long j2;
        if (i == this.periods.size() - 1) {
            j = this.durationMs;
            if (j == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            j2 = this.periods.get(i).startMs;
        } else {
            j = this.periods.get(i + 1).startMs;
            j2 = this.periods.get(i).startMs;
        }
        return j - j2;
    }

    public final long getPeriodDurationUs(int i) {
        return C.msToUs(getPeriodDurationMs(i));
    }

    public final DashManifest copy(List<StreamKey> list) {
        long j;
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new StreamKey(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long j2 = 0;
        int i = 0;
        while (true) {
            j = -9223372036854775807L;
            if (i >= getPeriodCount()) {
                break;
            }
            if (((StreamKey) linkedList.peek()).periodIndex != i) {
                long periodDurationMs = getPeriodDurationMs(i);
                if (periodDurationMs != -9223372036854775807L) {
                    j2 += periodDurationMs;
                }
            } else {
                Period period = getPeriod(i);
                arrayList.add(new Period(period.id, period.startMs - j2, copyAdaptationSets(period.adaptationSets, linkedList), period.eventStreams));
            }
            i++;
        }
        long j3 = this.durationMs;
        if (j3 != -9223372036854775807L) {
            j = j3 - j2;
        }
        return new DashManifest(this.availabilityStartTimeMs, j, this.minBufferTimeMs, this.dynamic, this.minUpdatePeriodMs, this.timeShiftBufferDepthMs, this.suggestedPresentationDelayMs, this.publishTimeMs, this.programInformation, this.utcTiming, this.location, arrayList);
    }

    private static ArrayList<AdaptationSet> copyAdaptationSets(List<AdaptationSet> list, LinkedList<StreamKey> linkedList) {
        StreamKey poll = linkedList.poll();
        int i = poll.periodIndex;
        ArrayList<AdaptationSet> arrayList = new ArrayList<>();
        do {
            int i2 = poll.groupIndex;
            AdaptationSet adaptationSet = list.get(i2);
            List<Representation> list2 = adaptationSet.representations;
            ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add(list2.get(poll.trackIndex));
                poll = linkedList.poll();
                if (poll.periodIndex != i) {
                    break;
                }
            } while (poll.groupIndex == i2);
            arrayList.add(new AdaptationSet(adaptationSet.id, adaptationSet.type, arrayList2, adaptationSet.accessibilityDescriptors, adaptationSet.essentialProperties, adaptationSet.supplementalProperties));
        } while (poll.periodIndex == i);
        linkedList.addFirst(poll);
        return arrayList;
    }
}

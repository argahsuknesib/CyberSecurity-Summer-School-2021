package com.google.android.exoplayer2.text.webvtt;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class WebvttSubtitle implements Subtitle {
    private final long[] cueTimesUs;
    private final List<Cue> cues;
    private final long[] sortedCueTimesUs;

    public WebvttSubtitle(List<WebvttCueInfo> list) {
        this.cues = new ArrayList(list.size());
        this.cueTimesUs = new long[(list.size() * 2)];
        for (int i = 0; i < list.size(); i++) {
            WebvttCueInfo webvttCueInfo = list.get(i);
            this.cues.add(webvttCueInfo.cue);
            int i2 = i * 2;
            this.cueTimesUs[i2] = webvttCueInfo.startTimeUs;
            this.cueTimesUs[i2 + 1] = webvttCueInfo.endTimeUs;
        }
        long[] jArr = this.cueTimesUs;
        this.sortedCueTimesUs = Arrays.copyOf(jArr, jArr.length);
        Arrays.sort(this.sortedCueTimesUs);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.util.Util.binarySearchCeil(long[], long, boolean, boolean):int
     arg types: [long[], long, int, int]
     candidates:
      com.google.android.exoplayer2.util.Util.binarySearchCeil(java.util.List, java.lang.Comparable, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchCeil(int[], int, boolean, boolean):int
      com.google.android.exoplayer2.util.Util.binarySearchCeil(long[], long, boolean, boolean):int */
    public final int getNextEventTimeIndex(long j) {
        int binarySearchCeil = Util.binarySearchCeil(this.sortedCueTimesUs, j, false, false);
        if (binarySearchCeil < this.sortedCueTimesUs.length) {
            return binarySearchCeil;
        }
        return -1;
    }

    public final int getEventTimeCount() {
        return this.sortedCueTimesUs.length;
    }

    public final long getEventTime(int i) {
        boolean z = true;
        Assertions.checkArgument(i >= 0);
        if (i >= this.sortedCueTimesUs.length) {
            z = false;
        }
        Assertions.checkArgument(z);
        return this.sortedCueTimesUs[i];
    }

    public final List<Cue> getCues(long j) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = null;
        Cue cue = null;
        for (int i = 0; i < this.cues.size(); i++) {
            long[] jArr = this.cueTimesUs;
            int i2 = i * 2;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                Cue cue2 = this.cues.get(i);
                if (!isNormal(cue2)) {
                    arrayList.add(cue2);
                } else if (cue == null) {
                    cue = cue2;
                } else if (spannableStringBuilder == null) {
                    spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) Assertions.checkNotNull(cue.text)).append((CharSequence) "\n").append((CharSequence) Assertions.checkNotNull(cue2.text));
                } else {
                    spannableStringBuilder.append((CharSequence) "\n").append((CharSequence) Assertions.checkNotNull(cue2.text));
                }
            }
        }
        if (spannableStringBuilder != null) {
            arrayList.add(WebvttCueParser.newCueForText(spannableStringBuilder));
        } else if (cue != null) {
            arrayList.add(cue);
        }
        return arrayList;
    }

    private static boolean isNormal(Cue cue) {
        return cue.line == -3.4028235E38f && cue.position == 0.5f;
    }
}

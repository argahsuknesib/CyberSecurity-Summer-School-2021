package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SlidingPercentile {
    private static final Comparator<Sample> INDEX_COMPARATOR = $$Lambda$SlidingPercentile$IHMSNRVWSvKImU2XQD2j4ISb4U.INSTANCE;
    private static final Comparator<Sample> VALUE_COMPARATOR = $$Lambda$SlidingPercentile$UufTq1Ma5g1qQu0Vqc6f2CE68bE.INSTANCE;
    private int currentSortOrder = -1;
    private final int maxWeight;
    private int nextSampleIndex;
    private int recycledSampleCount;
    private final Sample[] recycledSamples = new Sample[5];
    private final ArrayList<Sample> samples = new ArrayList<>();
    private int totalWeight;

    static /* synthetic */ int lambda$static$0(Sample sample, Sample sample2) {
        return sample.index - sample2.index;
    }

    public SlidingPercentile(int i) {
        this.maxWeight = i;
    }

    public void reset() {
        this.samples.clear();
        this.currentSortOrder = -1;
        this.nextSampleIndex = 0;
        this.totalWeight = 0;
    }

    public void addSample(int i, float f) {
        Sample sample;
        ensureSortedByIndex();
        int i2 = this.recycledSampleCount;
        if (i2 > 0) {
            Sample[] sampleArr = this.recycledSamples;
            int i3 = i2 - 1;
            this.recycledSampleCount = i3;
            sample = sampleArr[i3];
        } else {
            sample = new Sample();
        }
        int i4 = this.nextSampleIndex;
        this.nextSampleIndex = i4 + 1;
        sample.index = i4;
        sample.weight = i;
        sample.value = f;
        this.samples.add(sample);
        this.totalWeight += i;
        while (true) {
            int i5 = this.totalWeight;
            int i6 = this.maxWeight;
            if (i5 > i6) {
                int i7 = i5 - i6;
                Sample sample2 = this.samples.get(0);
                if (sample2.weight <= i7) {
                    this.totalWeight -= sample2.weight;
                    this.samples.remove(0);
                    int i8 = this.recycledSampleCount;
                    if (i8 < 5) {
                        Sample[] sampleArr2 = this.recycledSamples;
                        this.recycledSampleCount = i8 + 1;
                        sampleArr2[i8] = sample2;
                    }
                } else {
                    sample2.weight -= i7;
                    this.totalWeight -= i7;
                }
            } else {
                return;
            }
        }
    }

    public float getPercentile(float f) {
        ensureSortedByValue();
        float f2 = f * ((float) this.totalWeight);
        int i = 0;
        for (int i2 = 0; i2 < this.samples.size(); i2++) {
            Sample sample = this.samples.get(i2);
            i += sample.weight;
            if (((float) i) >= f2) {
                return sample.value;
            }
        }
        if (this.samples.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<Sample> arrayList = this.samples;
        return arrayList.get(arrayList.size() - 1).value;
    }

    private void ensureSortedByIndex() {
        if (this.currentSortOrder != 1) {
            Collections.sort(this.samples, INDEX_COMPARATOR);
            this.currentSortOrder = 1;
        }
    }

    private void ensureSortedByValue() {
        if (this.currentSortOrder != 0) {
            Collections.sort(this.samples, VALUE_COMPARATOR);
            this.currentSortOrder = 0;
        }
    }

    static class Sample {
        public int index;
        public float value;
        public int weight;

        private Sample() {
        }
    }
}

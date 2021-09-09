package com.google.android.exoplayer2.source;

public interface SequenceableLoader {

    public interface Callback<T extends SequenceableLoader> {
        void onContinueLoadingRequested(SequenceableLoader sequenceableLoader);
    }

    boolean continueLoading(long j);

    long getBufferedPositionUs();

    long getNextLoadPositionUs();

    boolean isLoading();

    void reevaluateBuffer(long j);
}

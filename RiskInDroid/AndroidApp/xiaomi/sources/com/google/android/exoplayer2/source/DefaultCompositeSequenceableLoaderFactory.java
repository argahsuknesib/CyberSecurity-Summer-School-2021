package com.google.android.exoplayer2.source;

public final class DefaultCompositeSequenceableLoaderFactory implements CompositeSequenceableLoaderFactory {
    public final SequenceableLoader createCompositeSequenceableLoader(SequenceableLoader... sequenceableLoaderArr) {
        return new CompositeSequenceableLoader(sequenceableLoaderArr);
    }
}

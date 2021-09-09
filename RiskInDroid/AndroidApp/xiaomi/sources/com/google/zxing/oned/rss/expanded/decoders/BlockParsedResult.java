package com.google.zxing.oned.rss.expanded.decoders;

final class BlockParsedResult {
    private final DecodedInformation decodedInformation;
    private final boolean finished;

    BlockParsedResult(boolean z) {
        this(null, z);
    }

    BlockParsedResult(DecodedInformation decodedInformation2, boolean z) {
        this.finished = z;
        this.decodedInformation = decodedInformation2;
    }

    /* access modifiers changed from: package-private */
    public final DecodedInformation getDecodedInformation() {
        return this.decodedInformation;
    }

    /* access modifiers changed from: package-private */
    public final boolean isFinished() {
        return this.finished;
    }
}

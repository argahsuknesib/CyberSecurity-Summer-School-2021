package com.google.android.exoplayer2.source.chunk;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class ChunkExtractorWrapper implements ExtractorOutput {
    private final SparseArray<BindingTrackOutput> bindingTrackOutputs = new SparseArray<>();
    private long endTimeUs;
    public final Extractor extractor;
    private boolean extractorInitialized;
    private final Format primaryTrackManifestFormat;
    private final int primaryTrackType;
    private Format[] sampleFormats;
    private SeekMap seekMap;
    private TrackOutputProvider trackOutputProvider;

    public interface TrackOutputProvider {
        TrackOutput track(int i, int i2);
    }

    public ChunkExtractorWrapper(Extractor extractor2, int i, Format format) {
        this.extractor = extractor2;
        this.primaryTrackType = i;
        this.primaryTrackManifestFormat = format;
    }

    public final SeekMap getSeekMap() {
        return this.seekMap;
    }

    public final Format[] getSampleFormats() {
        return this.sampleFormats;
    }

    public final void init(TrackOutputProvider trackOutputProvider2, long j, long j2) {
        this.trackOutputProvider = trackOutputProvider2;
        this.endTimeUs = j2;
        if (!this.extractorInitialized) {
            this.extractor.init(this);
            if (j != -9223372036854775807L) {
                this.extractor.seek(0, j);
            }
            this.extractorInitialized = true;
            return;
        }
        Extractor extractor2 = this.extractor;
        if (j == -9223372036854775807L) {
            j = 0;
        }
        extractor2.seek(0, j);
        for (int i = 0; i < this.bindingTrackOutputs.size(); i++) {
            this.bindingTrackOutputs.valueAt(i).bind(trackOutputProvider2, j2);
        }
    }

    public final TrackOutput track(int i, int i2) {
        BindingTrackOutput bindingTrackOutput = this.bindingTrackOutputs.get(i);
        if (bindingTrackOutput == null) {
            Assertions.checkState(this.sampleFormats == null);
            bindingTrackOutput = new BindingTrackOutput(i, i2, i2 == this.primaryTrackType ? this.primaryTrackManifestFormat : null);
            bindingTrackOutput.bind(this.trackOutputProvider, this.endTimeUs);
            this.bindingTrackOutputs.put(i, bindingTrackOutput);
        }
        return bindingTrackOutput;
    }

    public final void endTracks() {
        Format[] formatArr = new Format[this.bindingTrackOutputs.size()];
        for (int i = 0; i < this.bindingTrackOutputs.size(); i++) {
            formatArr[i] = (Format) Assertions.checkStateNotNull(this.bindingTrackOutputs.valueAt(i).sampleFormat);
        }
        this.sampleFormats = formatArr;
    }

    public final void seekMap(SeekMap seekMap2) {
        this.seekMap = seekMap2;
    }

    static final class BindingTrackOutput implements TrackOutput {
        private final DummyTrackOutput dummyTrackOutput = new DummyTrackOutput();
        private long endTimeUs;
        private final int id;
        private final Format manifestFormat;
        public Format sampleFormat;
        private TrackOutput trackOutput;
        private final int type;

        public BindingTrackOutput(int i, int i2, Format format) {
            this.id = i;
            this.type = i2;
            this.manifestFormat = format;
        }

        public final void bind(TrackOutputProvider trackOutputProvider, long j) {
            if (trackOutputProvider == null) {
                this.trackOutput = this.dummyTrackOutput;
                return;
            }
            this.endTimeUs = j;
            this.trackOutput = trackOutputProvider.track(this.id, this.type);
            Format format = this.sampleFormat;
            if (format != null) {
                this.trackOutput.format(format);
            }
        }

        public final void format(Format format) {
            Format format2 = this.manifestFormat;
            if (format2 != null) {
                format = format.withManifestFormatInfo(format2);
            }
            this.sampleFormat = format;
            ((TrackOutput) Util.castNonNull(this.trackOutput)).format(this.sampleFormat);
        }

        public final int sampleData(DataReader dataReader, int i, boolean z) throws IOException {
            return ((TrackOutput) Util.castNonNull(this.trackOutput)).sampleData(dataReader, i, z);
        }

        public final void sampleData(ParsableByteArray parsableByteArray, int i) {
            ((TrackOutput) Util.castNonNull(this.trackOutput)).sampleData(parsableByteArray, i);
        }

        public final void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
            long j2 = this.endTimeUs;
            if (j2 != -9223372036854775807L && j >= j2) {
                this.trackOutput = this.dummyTrackOutput;
            }
            ((TrackOutput) Util.castNonNull(this.trackOutput)).sampleMetadata(j, i, i2, i3, cryptoData);
        }
    }
}

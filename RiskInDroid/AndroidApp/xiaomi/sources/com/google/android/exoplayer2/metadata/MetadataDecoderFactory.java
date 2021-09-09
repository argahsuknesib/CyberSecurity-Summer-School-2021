package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.dvbsi.AppInfoTableDecoder;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.metadata.icy.IcyDecoder;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.scte35.SpliceInfoDecoder;

public interface MetadataDecoderFactory {
    public static final MetadataDecoderFactory DEFAULT = new MetadataDecoderFactory() {
        /* class com.google.android.exoplayer2.metadata.MetadataDecoderFactory.AnonymousClass1 */

        public final boolean supportsFormat(Format format) {
            String str = format.sampleMimeType;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
        }

        public final MetadataDecoder createDecoder(Format format) {
            String str = format.sampleMimeType;
            if (str != null) {
                char c = 65535;
                switch (str.hashCode()) {
                    case -1354451219:
                        if (str.equals("application/vnd.dvb.ait")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -1348231605:
                        if (str.equals("application/x-icy")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1248341703:
                        if (str.equals("application/id3")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 1154383568:
                        if (str.equals("application/x-emsg")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1652648887:
                        if (str.equals("application/x-scte35")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    return new Id3Decoder();
                }
                if (c == 1) {
                    return new EventMessageDecoder();
                }
                if (c == 2) {
                    return new SpliceInfoDecoder();
                }
                if (c == 3) {
                    return new IcyDecoder();
                }
                if (c == 4) {
                    return new AppInfoTableDecoder();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: ".concat(String.valueOf(str)));
        }
    };

    MetadataDecoder createDecoder(Format format);

    boolean supportsFormat(Format format);
}

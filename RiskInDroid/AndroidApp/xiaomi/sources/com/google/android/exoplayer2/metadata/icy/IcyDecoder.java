package com.google.android.exoplayer2.metadata.icy;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class IcyDecoder implements MetadataDecoder {
    private static final Pattern METADATA_ELEMENT = Pattern.compile("(.+?)='(.*?)';", 32);
    private final CharsetDecoder iso88591Decoder = Charset.forName("ISO-8859-1").newDecoder();
    private final CharsetDecoder utf8Decoder = Charset.forName("UTF-8").newDecoder();

    public final Metadata decode(MetadataInputBuffer metadataInputBuffer) {
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(metadataInputBuffer.data);
        Assertions.checkArgument(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        String decodeToString = decodeToString(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        if (decodeToString == null) {
            return new Metadata(new IcyInfo(bArr, null, null));
        }
        Matcher matcher = METADATA_ELEMENT.matcher(decodeToString);
        String str = null;
        String str2 = null;
        for (int i = 0; matcher.find(i); i = matcher.end()) {
            String lowerInvariant = Util.toLowerInvariant(matcher.group(1));
            String group = matcher.group(2);
            if (lowerInvariant != null) {
                char c = 65535;
                int hashCode = lowerInvariant.hashCode();
                if (hashCode != -315603473) {
                    if (hashCode == 1646559960 && lowerInvariant.equals("streamtitle")) {
                        c = 0;
                    }
                } else if (lowerInvariant.equals("streamurl")) {
                    c = 1;
                }
                if (c == 0) {
                    str = group;
                } else if (c == 1) {
                    str2 = group;
                }
            }
        }
        return new Metadata(new IcyInfo(bArr, str, str2));
    }

    /* JADX INFO: finally extract failed */
    private String decodeToString(ByteBuffer byteBuffer) {
        try {
            return this.utf8Decoder.decode(byteBuffer).toString();
        } catch (CharacterCodingException unused) {
            try {
                String charBuffer = this.iso88591Decoder.decode(byteBuffer).toString();
                this.iso88591Decoder.reset();
                byteBuffer.rewind();
                return charBuffer;
            } catch (CharacterCodingException unused2) {
                this.iso88591Decoder.reset();
                byteBuffer.rewind();
                return null;
            } catch (Throwable th) {
                this.iso88591Decoder.reset();
                byteBuffer.rewind();
                throw th;
            }
        } finally {
            this.utf8Decoder.reset();
            byteBuffer.rewind();
        }
    }
}

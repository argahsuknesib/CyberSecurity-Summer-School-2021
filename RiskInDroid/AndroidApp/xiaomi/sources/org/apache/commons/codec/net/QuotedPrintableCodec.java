package org.apache.commons.codec.net;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class QuotedPrintableCodec implements BinaryDecoder, BinaryEncoder, StringDecoder, StringEncoder {
    private static final BitSet PRINTABLE_CHARS = new BitSet(256);
    private final String charset;

    static {
        for (int i = 33; i <= 60; i++) {
            PRINTABLE_CHARS.set(i);
        }
        for (int i2 = 62; i2 <= 126; i2++) {
            PRINTABLE_CHARS.set(i2);
        }
        PRINTABLE_CHARS.set(9);
        PRINTABLE_CHARS.set(32);
    }

    public QuotedPrintableCodec() {
        this("UTF-8");
    }

    public QuotedPrintableCodec(String str) {
        this.charset = str;
    }

    private static final void encodeQuotedPrintable(int i, ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.write(61);
        char upperCase = Character.toUpperCase(Character.forDigit((i >> 4) & 15, 16));
        char upperCase2 = Character.toUpperCase(Character.forDigit(i & 15, 16));
        byteArrayOutputStream.write(upperCase);
        byteArrayOutputStream.write(upperCase2);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    public static final byte[] encodeQuotedPrintable(BitSet bitSet, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bitSet == null) {
            bitSet = PRINTABLE_CHARS;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (byte b : bArr) {
            int i = b;
            if (b < 0) {
                i = b + 256;
            }
            if (bitSet.get(i)) {
                byteArrayOutputStream.write(i);
            } else {
                encodeQuotedPrintable(i, byteArrayOutputStream);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static final byte[] decodeQuotedPrintable(byte[] bArr) throws DecoderException {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < bArr.length) {
            byte b = bArr[i];
            if (b == 61) {
                int i2 = i + 1;
                try {
                    int digit16 = Utils.digit16(bArr[i2]);
                    i = i2 + 1;
                    byteArrayOutputStream.write((char) ((digit16 << 4) + Utils.digit16(bArr[i])));
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new DecoderException("Invalid quoted-printable encoding", e);
                }
            } else {
                byteArrayOutputStream.write(b);
            }
            i++;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] encode(byte[] bArr) {
        return encodeQuotedPrintable(PRINTABLE_CHARS, bArr);
    }

    public byte[] decode(byte[] bArr) throws DecoderException {
        return decodeQuotedPrintable(bArr);
    }

    public String encode(String str) throws EncoderException {
        if (str == null) {
            return null;
        }
        try {
            return encode(str, getDefaultCharset());
        } catch (UnsupportedEncodingException e) {
            throw new EncoderException(e.getMessage(), e);
        }
    }

    public String decode(String str, String str2) throws DecoderException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return new String(decode(StringUtils.getBytesUsAscii(str)), str2);
    }

    public String decode(String str) throws DecoderException {
        if (str == null) {
            return null;
        }
        try {
            return decode(str, getDefaultCharset());
        } catch (UnsupportedEncodingException e) {
            throw new DecoderException(e.getMessage(), e);
        }
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        if (obj instanceof String) {
            return encode((String) obj);
        }
        StringBuffer stringBuffer = new StringBuffer("Objects of type ");
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append(" cannot be quoted-printable encoded");
        throw new EncoderException(stringBuffer.toString());
    }

    public Object decode(Object obj) throws DecoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        StringBuffer stringBuffer = new StringBuffer("Objects of type ");
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append(" cannot be quoted-printable decoded");
        throw new DecoderException(stringBuffer.toString());
    }

    public String getDefaultCharset() {
        return this.charset;
    }

    public String encode(String str, String str2) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return StringUtils.newStringUsAscii(encode(str.getBytes(str2)));
    }
}

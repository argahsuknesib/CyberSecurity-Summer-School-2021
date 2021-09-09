package org.apache.commons.codec.net;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.Base64;

public class BCodec extends RFC1522Codec implements StringDecoder, StringEncoder {
    private final String charset;

    /* access modifiers changed from: protected */
    public String getEncoding() {
        return "B";
    }

    public BCodec() {
        this("UTF-8");
    }

    public BCodec(String str) {
        this.charset = str;
    }

    /* access modifiers changed from: protected */
    public byte[] doEncoding(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeBase64(bArr);
    }

    /* access modifiers changed from: protected */
    public byte[] doDecoding(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.decodeBase64(bArr);
    }

    public String encode(String str, String str2) throws EncoderException {
        if (str == null) {
            return null;
        }
        try {
            return encodeText(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new EncoderException(e.getMessage(), e);
        }
    }

    public String encode(String str) throws EncoderException {
        if (str == null) {
            return null;
        }
        return encode(str, getDefaultCharset());
    }

    public String decode(String str) throws DecoderException {
        if (str == null) {
            return null;
        }
        try {
            return decodeText(str);
        } catch (UnsupportedEncodingException e) {
            throw new DecoderException(e.getMessage(), e);
        }
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return encode((String) obj);
        }
        StringBuffer stringBuffer = new StringBuffer("Objects of type ");
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append(" cannot be encoded using BCodec");
        throw new EncoderException(stringBuffer.toString());
    }

    public Object decode(Object obj) throws DecoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        StringBuffer stringBuffer = new StringBuffer("Objects of type ");
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append(" cannot be decoded using BCodec");
        throw new DecoderException(stringBuffer.toString());
    }

    public String getDefaultCharset() {
        return this.charset;
    }
}

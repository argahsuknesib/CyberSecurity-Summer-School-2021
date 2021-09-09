package _m_j;

import com.github.scribejava.core.exceptions.OAuthSignatureException;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary.Base64;

public final class avl extends avk {
    public final String O00000o0() {
        return "CommonsCodec";
    }

    public final String O000000o(byte[] bArr) {
        try {
            return new String(Base64.encodeBase64(bArr), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new OAuthSignatureException("Can't perform base64 encoding", e);
        }
    }

    public static boolean O00000o() {
        try {
            Class.forName("org.apache.commons.codec.binary.Base64");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}

package _m_j;

import com.github.scribejava.core.exceptions.OAuthSignatureException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class avn implements avo {
    public final String O000000o() {
        return "HMAC-SHA1";
    }

    public final String O000000o(String str, String str2, String str3) {
        try {
            avt.O000000o(str, "Base string cant be null or empty string");
            avt.O000000o(str2, "Api secret cant be null or empty string");
            SecretKeySpec secretKeySpec = new SecretKeySpec((avs.O000000o(str2) + '&' + avs.O000000o(str3)).getBytes("UTF-8"), "HmacSHA1");
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            return avk.O000000o().O000000o(instance.doFinal(str.getBytes("UTF-8"))).replace("\r\n", "");
        } catch (UnsupportedEncodingException | RuntimeException | InvalidKeyException | NoSuchAlgorithmException e) {
            throw new OAuthSignatureException(str, e);
        }
    }
}

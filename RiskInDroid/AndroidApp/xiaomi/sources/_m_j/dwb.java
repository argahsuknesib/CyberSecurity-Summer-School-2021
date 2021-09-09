package _m_j;

import com.google.common.collect.LinkedListMultimap;
import com.xiaomi.infra.galaxy.fds.android.exception.GalaxyFDSClientException;
import com.xiaomi.infra.galaxy.fds.auth.signature.SignAlgorithm;
import com.xiaomi.infra.galaxy.fds.model.HttpMethod;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.http.Header;
import org.apache.http.client.methods.HttpRequestBase;

public final class dwb implements dwa {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f14993O000000o = new ThreadLocal<SimpleDateFormat>() {
        /* class _m_j.dwb.AnonymousClass1 */

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat;
        }
    };
    private final String O00000Oo;
    private final String O00000o0;

    public final String O000000o(String str) {
        return str;
    }

    public dwb(String str, String str2) {
        this.O00000Oo = str;
        this.O00000o0 = str2;
    }

    public final void O000000o(HttpRequestBase httpRequestBase) throws GalaxyFDSClientException {
        httpRequestBase.setHeader("date", f14993O000000o.get().format(new Date()));
        try {
            URI uri = httpRequestBase.getURI();
            LinkedListMultimap create = LinkedListMultimap.create();
            for (Header header : httpRequestBase.getAllHeaders()) {
                create.put(header.getName(), header.getValue());
            }
            httpRequestBase.setHeader("Authorization", dwp.O000000o(HttpMethod.valueOf(httpRequestBase.getMethod()), uri, create, this.O00000Oo, this.O00000o0, SignAlgorithm.HmacSHA1));
        } catch (NoSuchAlgorithmException e) {
            throw new GalaxyFDSClientException("Fail to get signature for request:".concat(String.valueOf(httpRequestBase)), e);
        } catch (InvalidKeyException e2) {
            throw new GalaxyFDSClientException("Fail to get signature for request:".concat(String.valueOf(httpRequestBase)), e2);
        } catch (UnsupportedEncodingException e3) {
            throw new GalaxyFDSClientException("Fail to get signature for request:".concat(String.valueOf(httpRequestBase)), e3);
        }
    }
}

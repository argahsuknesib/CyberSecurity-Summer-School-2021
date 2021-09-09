package _m_j;

import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;

public final class bqi<T> {

    /* renamed from: O000000o  reason: collision with root package name */
    public T f13200O000000o;
    public final boolean O00000Oo;
    public final int O00000o;
    public final Locale O00000o0;
    public final ProtocolVersion O00000oO;
    public final String O00000oo;
    public final long O0000O0o;
    public final Header O0000OOo;
    private final HttpResponse O0000Oo;
    public final Header O0000Oo0;

    public bqi(HttpResponse httpResponse, T t, boolean z) {
        this.O0000Oo = httpResponse;
        this.f13200O000000o = t;
        this.O00000Oo = z;
        if (httpResponse != null) {
            this.O00000o0 = httpResponse.getLocale();
            StatusLine statusLine = httpResponse.getStatusLine();
            if (statusLine != null) {
                this.O00000o = statusLine.getStatusCode();
                this.O00000oO = statusLine.getProtocolVersion();
                this.O00000oo = statusLine.getReasonPhrase();
            } else {
                this.O00000o = 0;
                this.O00000oO = null;
                this.O00000oo = null;
            }
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                this.O0000O0o = entity.getContentLength();
                this.O0000OOo = entity.getContentType();
                this.O0000Oo0 = entity.getContentEncoding();
                return;
            }
            this.O0000O0o = 0;
            this.O0000OOo = null;
            this.O0000Oo0 = null;
            return;
        }
        this.O00000o0 = null;
        this.O00000o = 0;
        this.O00000oO = null;
        this.O00000oo = null;
        this.O0000O0o = 0;
        this.O0000OOo = null;
        this.O0000Oo0 = null;
    }
}

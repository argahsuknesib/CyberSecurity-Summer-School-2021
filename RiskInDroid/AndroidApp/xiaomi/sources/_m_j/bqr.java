package _m_j;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.entity.AbstractHttpEntity;

public final class bqr extends AbstractHttpEntity implements Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    protected byte[] f13204O000000o;
    private boolean O00000Oo;
    private List<NameValuePair> O00000o;
    private String O00000o0;

    public final boolean isRepeatable() {
        return true;
    }

    public final boolean isStreaming() {
        return false;
    }

    public bqr() {
        this((byte) 0);
    }

    private bqr(byte b) {
        this.O00000Oo = true;
        this.O00000o0 = "UTF-8";
        setContentType("application/x-www-form-urlencoded");
        this.O00000o = new ArrayList();
    }

    public bqr(List<NameValuePair> list, String str) {
        this.O00000Oo = true;
        this.O00000o0 = "UTF-8";
        if (str != null) {
            this.O00000o0 = str;
        }
        setContentType("application/x-www-form-urlencoded");
        this.O00000o = list;
        O000000o();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.brg.O000000o(java.util.List<? extends org.apache.http.NameValuePair>, java.lang.String):java.lang.String
     arg types: [java.util.List<org.apache.http.NameValuePair>, java.lang.String]
     candidates:
      _m_j.brg.O000000o(java.lang.Iterable<? extends org.apache.http.NameValuePair>, java.nio.charset.Charset):java.lang.String
      _m_j.brg.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.brg.O000000o(java.lang.String, java.nio.charset.Charset):java.lang.String
      _m_j.brg.O000000o(java.util.List<? extends org.apache.http.NameValuePair>, java.lang.String):java.lang.String */
    private void O000000o() {
        if (this.O00000Oo) {
            try {
                this.f13204O000000o = brg.O000000o((List<? extends NameValuePair>) this.O00000o, this.O00000o0).getBytes(this.O00000o0);
            } catch (UnsupportedEncodingException e) {
                brm.O000000o(e.getMessage(), e);
            }
            this.O00000Oo = false;
        }
    }

    public final long getContentLength() {
        O000000o();
        return (long) this.f13204O000000o.length;
    }

    public final InputStream getContent() throws IOException {
        O000000o();
        return new ByteArrayInputStream(this.f13204O000000o);
    }

    public final void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            O000000o();
            outputStream.write(this.f13204O000000o);
            outputStream.flush();
            return;
        }
        throw new IllegalArgumentException("Output stream may not be null");
    }

    public final Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

package com.lidroid.xutils.http.client;

import _m_j.bqh;
import _m_j.bqn;
import _m_j.bqu;
import _m_j.brf;
import _m_j.brg;
import _m_j.brm;
import _m_j.brn;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.CloneUtils;
import org.apache.http.conn.util.InetAddressUtils;
import org.apache.http.message.BasicNameValuePair;

public final class HttpRequest extends HttpRequestBase implements HttpEntityEnclosingRequest {

    /* renamed from: O000000o  reason: collision with root package name */
    private HttpEntity f4511O000000o;
    private HttpMethod O00000Oo;
    private Charset O00000o;
    private brf O00000o0;

    public HttpRequest(HttpMethod httpMethod, String str) {
        this.O00000Oo = httpMethod;
        this.O00000o0 = new brf(str);
    }

    public final void O000000o(bqh bqh, bqn bqn) {
        if (bqh != null) {
            if (this.O00000o == null) {
                this.O00000o = Charset.forName(bqh.f13198O000000o);
            }
            List<bqh.O000000o> list = bqh.O00000Oo;
            if (list != null) {
                for (bqh.O000000o next : list) {
                    if (next.f13199O000000o) {
                        setHeader(next.O00000Oo);
                    } else {
                        addHeader(next.O00000Oo);
                    }
                }
            }
            List<NameValuePair> list2 = bqh.O00000o0;
            if (list2 != null) {
                for (NameValuePair next2 : list2) {
                    brf brf = this.O00000o0;
                    String name = next2.getName();
                    String value = next2.getValue();
                    if (brf.O0000OoO == null) {
                        brf.O0000OoO = new ArrayList();
                    }
                    brf.O0000OoO.add(new BasicNameValuePair(name, value));
                    brf.O0000Oo = null;
                    brf.O00000Oo = null;
                }
            }
            bqu O000000o2 = bqh.O000000o();
            if (O000000o2 != null) {
                if (O000000o2 instanceof bqu) {
                    O000000o2.O000000o(bqn);
                }
                setEntity(O000000o2);
            }
        }
    }

    public final URI getURI() {
        try {
            if (this.O00000o == null) {
                this.O00000o = brn.O000000o((HttpRequestBase) this);
            }
            if (this.O00000o == null) {
                this.O00000o = Charset.forName("UTF-8");
            }
            brf brf = this.O00000o0;
            Charset charset = this.O00000o;
            StringBuilder sb = new StringBuilder();
            if (brf.f13215O000000o != null) {
                sb.append(brf.f13215O000000o);
                sb.append(':');
            }
            if (brf.O00000Oo != null) {
                sb.append(brf.O00000Oo);
            } else {
                if (brf.O00000o0 != null) {
                    sb.append("//");
                    sb.append(brf.O00000o0);
                } else if (brf.O00000oo != null) {
                    sb.append("//");
                    if (brf.O00000oO != null) {
                        sb.append(brf.O00000oO);
                        sb.append("@");
                    } else if (brf.O00000o != null) {
                        sb.append(brg.O000000o(brf.O00000o, charset));
                        sb.append("@");
                    }
                    if (InetAddressUtils.isIPv6Address(brf.O00000oo)) {
                        sb.append("[");
                        sb.append(brf.O00000oo);
                        sb.append("]");
                    } else {
                        sb.append(brf.O00000oo);
                    }
                    if (brf.O0000O0o >= 0) {
                        sb.append(":");
                        sb.append(brf.O0000O0o);
                    }
                }
                if (brf.O0000Oo0 != null) {
                    sb.append(brf.O000000o(brf.O0000Oo0));
                } else if (brf.O0000OOo != null) {
                    sb.append(brg.O00000o0(brf.O000000o(brf.O0000OOo), charset).replace("+", "20%"));
                }
                if (brf.O0000Oo != null) {
                    sb.append("?");
                    sb.append(brf.O0000Oo);
                } else if (brf.O0000OoO != null) {
                    sb.append("?");
                    sb.append(brg.O000000o(brf.O0000OoO, charset));
                }
            }
            if (brf.O0000o00 != null) {
                sb.append("#");
                sb.append(brf.O0000o00);
            } else if (brf.O0000Ooo != null) {
                sb.append("#");
                sb.append(brg.O00000Oo(brf.O0000Ooo, charset));
            }
            return new URI(sb.toString());
        } catch (URISyntaxException e) {
            brm.O000000o(e.getMessage(), e);
            return null;
        }
    }

    public final void setURI(URI uri) {
        this.O00000o0 = new brf(uri);
    }

    public final String getMethod() {
        return this.O00000Oo.toString();
    }

    public final HttpEntity getEntity() {
        return this.f4511O000000o;
    }

    public final void setEntity(HttpEntity httpEntity) {
        this.f4511O000000o = httpEntity;
    }

    public final boolean expectContinue() {
        Header firstHeader = getFirstHeader("Expect");
        return firstHeader != null && "100-Continue".equalsIgnoreCase(firstHeader.getValue());
    }

    public final Object clone() throws CloneNotSupportedException {
        HttpRequest httpRequest = (HttpRequest) HttpRequest.super.clone();
        HttpEntity httpEntity = this.f4511O000000o;
        if (httpEntity != null) {
            httpRequest.f4511O000000o = (HttpEntity) CloneUtils.clone(httpEntity);
        }
        return httpRequest;
    }

    public enum HttpMethod {
        GET("GET"),
        POST("POST"),
        PUT("PUT"),
        HEAD("HEAD"),
        MOVE("MOVE"),
        COPY("COPY"),
        DELETE("DELETE"),
        OPTIONS("OPTIONS"),
        TRACE("TRACE"),
        CONNECT("CONNECT");
        
        private final String value;

        private HttpMethod(String str) {
            this.value = str;
        }

        public final String toString() {
            return this.value;
        }
    }
}

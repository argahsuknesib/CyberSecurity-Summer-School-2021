package _m_j;

import com.lidroid.xutils.http.client.multipart.HttpMultipartMode;
import com.lidroid.xutils.task.Priority;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public final class bqh {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f13198O000000o = "UTF-8";
    public List<O000000o> O00000Oo;
    public Priority O00000o;
    public List<NameValuePair> O00000o0;
    private HttpEntity O00000oO;
    private List<NameValuePair> O00000oo;
    private HashMap<String, brc> O0000O0o;

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final boolean f13199O000000o;
        public final Header O00000Oo;
    }

    public final void O000000o(String str, String str2) {
        if (this.O00000oo == null) {
            this.O00000oo = new ArrayList();
        }
        this.O00000oo.add(new BasicNameValuePair(str, str2));
    }

    public final HttpEntity O000000o() {
        HttpEntity httpEntity = this.O00000oO;
        if (httpEntity != null) {
            return httpEntity;
        }
        HashMap<String, brc> hashMap = this.O0000O0o;
        if (hashMap == null || hashMap.isEmpty()) {
            List<NameValuePair> list = this.O00000oo;
            if (list == null || list.isEmpty()) {
                return null;
            }
            return new bqr(this.O00000oo, this.f13198O000000o);
        }
        HttpEntity bra = new bra(HttpMultipartMode.STRICT, Charset.forName(this.f13198O000000o));
        List<NameValuePair> list2 = this.O00000oo;
        if (list2 != null && !list2.isEmpty()) {
            for (NameValuePair next : this.O00000oo) {
                try {
                    bra.O000000o(next.getName(), new bre(next.getValue()));
                } catch (UnsupportedEncodingException e) {
                    brm.O000000o(e.getMessage(), e);
                }
            }
        }
        for (Map.Entry next2 : this.O0000O0o.entrySet()) {
            bra.O000000o((String) next2.getKey(), (brc) next2.getValue());
        }
        return bra;
    }
}

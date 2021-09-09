package _m_j;

import com.xiaomi.infra.galaxy.fds.android.exception.GalaxyFDSClientException;
import com.xiaomi.infra.galaxy.fds.model.HttpMethod;
import java.util.Date;
import java.util.Map;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;

public final class dwm {
    public static HttpUriRequest O000000o(String str, dwa dwa, HttpMethod httpMethod, Map<String, String> map) throws GalaxyFDSClientException {
        HttpUriRequest httpUriRequest;
        String O000000o2 = dwa.O000000o(str);
        int i = AnonymousClass1.f15002O000000o[httpMethod.ordinal()];
        if (i == 1) {
            httpUriRequest = new HttpGet(O000000o2);
        } else if (i == 2) {
            httpUriRequest = new HttpPut(O000000o2);
        } else if (i == 3) {
            httpUriRequest = new HttpPost(O000000o2);
        } else if (i != 4) {
            httpUriRequest = i != 5 ? null : new HttpHead(O000000o2);
        } else {
            httpUriRequest = new HttpDelete(O000000o2);
        }
        if (httpUriRequest != null) {
            if (map != null) {
                map.remove("Content-Length");
                map.remove("Content-Length".toLowerCase());
                for (Map.Entry next : map.entrySet()) {
                    httpUriRequest.addHeader((String) next.getKey(), (String) next.getValue());
                }
            }
            httpUriRequest.addHeader("Date", dwn.O000000o(new Date()));
            dwa.O000000o((HttpRequestBase) httpUriRequest);
        }
        return httpUriRequest;
    }

    /* renamed from: _m_j.dwm$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f15002O000000o = new int[HttpMethod.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f15002O000000o[HttpMethod.GET.ordinal()] = 1;
            f15002O000000o[HttpMethod.PUT.ordinal()] = 2;
            f15002O000000o[HttpMethod.POST.ordinal()] = 3;
            f15002O000000o[HttpMethod.DELETE.ordinal()] = 4;
            f15002O000000o[HttpMethod.HEAD.ordinal()] = 5;
        }
    }
}

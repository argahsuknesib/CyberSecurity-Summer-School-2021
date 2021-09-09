package _m_j;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;

public final class bqj implements bql {
    public final HttpRequestBase O000000o(HttpResponse httpResponse) {
        if (!httpResponse.containsHeader("Location")) {
            return null;
        }
        HttpGet httpGet = new HttpGet(httpResponse.getFirstHeader("Location").getValue());
        if (httpResponse.containsHeader("Set-Cookie")) {
            httpGet.addHeader("Cookie", httpResponse.getFirstHeader("Set-Cookie").getValue());
        }
        return httpGet;
    }
}

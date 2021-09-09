package _m_j;

import com.google.android.exoplayer2.source.dash.DashMediaSource;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

final class dmj extends DefaultConnectionKeepAliveStrategy {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ dmi f14785O000000o;

    dmj(dmi dmi) {
        this.f14785O000000o = dmi;
    }

    public final long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        long keepAliveDuration = dmj.super.getKeepAliveDuration(httpResponse, httpContext);
        return keepAliveDuration == -1 ? DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS : keepAliveDuration;
    }
}

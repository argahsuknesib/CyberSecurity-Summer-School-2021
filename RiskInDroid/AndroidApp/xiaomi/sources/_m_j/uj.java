package _m_j;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.network.CookieJarContainer;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.google.android.exoplayer2.ext.okhttp.OkHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import java.util.Map;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;

public final class uj {

    /* renamed from: O000000o  reason: collision with root package name */
    private static DataSource.Factory f2532O000000o;
    private static DataSource.Factory O00000Oo;
    private static String O00000o0;

    public static DataSource.Factory O000000o(ReactContext reactContext, DefaultBandwidthMeter defaultBandwidthMeter, Map<String, String> map) {
        if (O00000Oo == null || (map != null && !map.isEmpty())) {
            OkHttpClient okHttpClient = OkHttpClientProvider.getOkHttpClient();
            ((CookieJarContainer) okHttpClient.cookieJar()).setCookieJar(new JavaNetCookieJar(new ForwardingCookieHandler(reactContext)));
            if (O00000o0 == null) {
                O00000o0 = Util.getUserAgent(reactContext, "ReactNativeVideo");
            }
            OkHttpDataSourceFactory okHttpDataSourceFactory = new OkHttpDataSourceFactory(okHttpClient, O00000o0, defaultBandwidthMeter);
            if (map != null) {
                okHttpDataSourceFactory.getDefaultRequestProperties().set(map);
            }
            O00000Oo = new DefaultDataSourceFactory(reactContext, defaultBandwidthMeter, okHttpDataSourceFactory);
        }
        return O00000Oo;
    }
}

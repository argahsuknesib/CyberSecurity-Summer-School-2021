package _m_j;

import _m_j.dxr;
import android.text.TextUtils;
import com.xiaomi.miot.support.monitor.core.net.NetInfo;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class dxt implements Interceptor {

    /* renamed from: O000000o  reason: collision with root package name */
    private dxv f15043O000000o;

    public final Response intercept(Interceptor.Chain chain) throws IOException {
        ResponseBody body;
        jaz source;
        long j;
        long currentTimeMillis = System.currentTimeMillis();
        this.f15043O000000o = new dxv();
        dxv dxv = this.f15043O000000o;
        dxv.O00000o = currentTimeMillis;
        dxv.O00000oo = dzf.O000000o(dxr.O000000o.f15041O000000o.O00000Oo) ? 1 : 2;
        Request request = chain.request();
        if (!(request == null || request.url() == null || TextUtils.isEmpty(request.url().toString()))) {
            this.f15043O000000o.f15045O000000o = request.url().toString();
            RequestBody body2 = request.body();
            if (body2 == null) {
                this.f15043O000000o.O00000Oo = (long) request.url().toString().getBytes().length;
            } else {
                try {
                    j = body2.contentLength();
                } catch (IOException e) {
                    e.printStackTrace();
                    j = 0;
                }
                if (j > 0) {
                    this.f15043O000000o.O00000Oo = j;
                } else {
                    this.f15043O000000o.O00000Oo = (long) request.url().toString().getBytes().length;
                }
            }
        }
        try {
            Response proceed = chain.proceed(request);
            this.f15043O000000o.O00000oO = System.currentTimeMillis() - currentTimeMillis;
            if (proceed != null) {
                this.f15043O000000o.O0000O0o = proceed.code();
                if (proceed.isSuccessful() && (body = proceed.body()) != null) {
                    long contentLength = body.contentLength();
                    if (contentLength <= 0 && (source = body.source()) != null) {
                        try {
                            source.O00000Oo(Long.MAX_VALUE);
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        contentLength = source.O000000o().O00000Oo;
                    }
                    this.f15043O000000o.O00000o0 = contentLength;
                }
            }
            dxv dxv2 = this.f15043O000000o;
            if (dxv2 != null && !TextUtils.isEmpty(dxv2.f15045O000000o)) {
                String str = dxv2.f15045O000000o;
                int i = dxv2.O0000O0o;
                long j2 = dxv2.O00000Oo;
                long j3 = dxv2.O00000o0;
                long j4 = dxv2.O00000o;
                long j5 = dxv2.O00000oO;
                int i2 = dxv2.O00000oo;
                NetInfo netInfo = new NetInfo((byte) 0);
                netInfo.startTime = j4;
                netInfo.O000000o(str);
                netInfo.statusCode = i;
                netInfo.sentBytes = j2;
                netInfo.receivedBytes = j3;
                netInfo.costTime = j5;
                netInfo.back_type = i2;
                netInfo.O00000Oo();
            }
            return proceed;
        } catch (IOException e3) {
            throw e3;
        }
    }
}

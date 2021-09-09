package com.xiaomi.onetrack;

import android.text.TextUtils;
import com.xiaomi.onetrack.OneTrack;
import java.util.Map;

public class ServiceQualityEvent {

    /* renamed from: a  reason: collision with root package name */
    private String f6086a;
    private String b;
    private Integer c;
    private String d;
    private String e;
    private Integer f;
    private Integer g;
    private String h;
    private String i;
    private Integer j;
    private Long k;
    private Long l;
    private Long m;
    private Long n;
    private Long o;
    private Long p;
    private Long q;
    private Long r;
    private String s;
    private String t;
    private Map<String, Object> u;

    public enum ResultType {
        SUCCESS("ok"),
        FAILED("failed"),
        TIMEOUT("timeout");
        

        /* renamed from: a  reason: collision with root package name */
        private String f6088a;

        private ResultType(String str) {
            this.f6088a = str;
        }

        public final String getResultType() {
            return this.f6088a;
        }
    }

    public String getScheme() {
        return this.f6086a;
    }

    public String getHost() {
        return this.b;
    }

    public Integer getPort() {
        return this.c;
    }

    public String getIps() {
        return this.e;
    }

    public String getPath() {
        return this.d;
    }

    public Integer getResponseCode() {
        return this.f;
    }

    public Integer getStatusCode() {
        return this.g;
    }

    public String getExceptionTag() {
        return this.h;
    }

    public String getResultType() {
        return this.i;
    }

    public Integer getRetryCount() {
        return this.j;
    }

    public Long getDnsLookupTime() {
        return this.k;
    }

    public Long getTcpConnectTime() {
        return this.l;
    }

    public Long getHandshakeTime() {
        return this.m;
    }

    public Long getReceiveFirstByteTime() {
        return this.o;
    }

    public Long getReceiveAllByteTime() {
        return this.p;
    }

    public Long getRequestTimestamp() {
        return this.r;
    }

    public String getRequestNetType() {
        return this.s;
    }

    public Long getRequestDataSendTime() {
        return this.n;
    }

    public Long getDuration() {
        return this.q;
    }

    public String getNetSdkVersion() {
        return this.t;
    }

    public Map<String, Object> getExtraParams() {
        return this.u;
    }

    private ServiceQualityEvent(Builder builder) {
        this.f6086a = builder.f6087a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        String str = null;
        this.i = builder.i != null ? builder.i.getResultType() : null;
        this.j = builder.j;
        this.k = builder.k;
        this.l = builder.l;
        this.m = builder.m;
        this.o = builder.o;
        this.p = builder.p;
        this.r = builder.r;
        this.s = builder.s != null ? builder.s.toString() : str;
        this.n = builder.n;
        this.q = builder.q;
        this.t = builder.t;
        this.u = builder.u;
    }

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f6087a;
        /* access modifiers changed from: private */
        public String b;
        /* access modifiers changed from: private */
        public Integer c;
        /* access modifiers changed from: private */
        public String d;
        /* access modifiers changed from: private */
        public String e;
        /* access modifiers changed from: private */
        public Integer f;
        /* access modifiers changed from: private */
        public Integer g;
        /* access modifiers changed from: private */
        public String h;
        /* access modifiers changed from: private */
        public ResultType i;
        /* access modifiers changed from: private */
        public Integer j;
        /* access modifiers changed from: private */
        public Long k;
        /* access modifiers changed from: private */
        public Long l;
        /* access modifiers changed from: private */
        public Long m;
        /* access modifiers changed from: private */
        public Long n;
        /* access modifiers changed from: private */
        public Long o;
        /* access modifiers changed from: private */
        public Long p;
        /* access modifiers changed from: private */
        public Long q;
        /* access modifiers changed from: private */
        public Long r;
        /* access modifiers changed from: private */
        public OneTrack.NetType s;
        /* access modifiers changed from: private */
        public String t;
        /* access modifiers changed from: private */
        public Map<String, Object> u;

        public final Builder setScheme(String str) {
            this.f6087a = str;
            return this;
        }

        public final Builder setHost(String str) {
            this.b = str;
            return this;
        }

        public final Builder setPort(Integer num) {
            this.c = num;
            return this;
        }

        public final Builder setIps(String... strArr) {
            if (strArr != null) {
                this.e = TextUtils.join(",", strArr);
            }
            return this;
        }

        public final Builder setPath(String str) {
            this.d = str;
            return this;
        }

        public final Builder setResponseCode(Integer num) {
            this.f = num;
            return this;
        }

        public final Builder setStatusCode(Integer num) {
            this.g = num;
            return this;
        }

        public final Builder setExceptionTag(String str) {
            this.h = str;
            return this;
        }

        public final Builder setResultType(ResultType resultType) {
            this.i = resultType;
            return this;
        }

        public final Builder setRetryCount(Integer num) {
            this.j = num;
            return this;
        }

        public final Builder setDnsLookupTime(Long l2) {
            this.k = l2;
            return this;
        }

        public final Builder setTcpConnectTime(Long l2) {
            this.l = l2;
            return this;
        }

        public final Builder setHandshakeTime(Long l2) {
            this.m = l2;
            return this;
        }

        public final Builder setReceiveFirstByteTime(Long l2) {
            this.o = l2;
            return this;
        }

        public final Builder setReceiveAllByteTime(Long l2) {
            this.p = l2;
            return this;
        }

        public final Builder setRequestTimestamp(Long l2) {
            this.r = l2;
            return this;
        }

        public final Builder setRequestNetType(OneTrack.NetType netType) {
            this.s = netType;
            return this;
        }

        public final Builder setRequestDataSendTime(Long l2) {
            this.n = l2;
            return this;
        }

        public final Builder setDuration(Long l2) {
            this.q = l2;
            return this;
        }

        public final Builder setNetSdkVersion(String str) {
            this.t = str;
            return this;
        }

        public final Builder setExtraParams(Map<String, Object> map) {
            this.u = map;
            return this;
        }

        public final ServiceQualityEvent build() {
            return new ServiceQualityEvent(this);
        }
    }
}

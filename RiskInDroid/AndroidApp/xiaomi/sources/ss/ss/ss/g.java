package ss.ss.ss;

public enum g {
    SPDY_SYN_STREAM,
    SPDY_REPLY,
    SPDY_HEADERS,
    HTTP_20_HEADERS;

    public final boolean a() {
        return this == SPDY_REPLY || this == SPDY_HEADERS;
    }

    public final boolean b() {
        return this == SPDY_SYN_STREAM;
    }

    public final boolean c() {
        return this == SPDY_HEADERS;
    }

    public final boolean d() {
        return this == SPDY_REPLY;
    }
}

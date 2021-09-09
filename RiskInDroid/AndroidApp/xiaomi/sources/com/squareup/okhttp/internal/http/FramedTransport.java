package com.squareup.okhttp.internal.http;

import _m_j.jbg;
import _m_j.jbm;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.framed.ErrorCode;
import com.squareup.okhttp.internal.framed.FramedConnection;
import com.squareup.okhttp.internal.framed.FramedStream;
import com.squareup.okhttp.internal.framed.Header;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okio.ByteString;

public final class FramedTransport implements Transport {
    private static final ByteString CONNECTION = ByteString.O000000o("connection");
    private static final ByteString ENCODING = ByteString.O000000o("encoding");
    private static final ByteString HOST = ByteString.O000000o("host");
    private static final List<ByteString> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY, Header.TARGET_HOST, Header.VERSION);
    private static final List<ByteString> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE);
    private static final ByteString KEEP_ALIVE = ByteString.O000000o("keep-alive");
    private static final ByteString PROXY_CONNECTION = ByteString.O000000o("proxy-connection");
    private static final List<ByteString> SPDY_3_SKIPPED_REQUEST_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TRANSFER_ENCODING, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY, Header.TARGET_HOST, Header.VERSION);
    private static final List<ByteString> SPDY_3_SKIPPED_RESPONSE_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TRANSFER_ENCODING);
    private static final ByteString TE = ByteString.O000000o("te");
    private static final ByteString TRANSFER_ENCODING = ByteString.O000000o("transfer-encoding");
    private static final ByteString UPGRADE = ByteString.O000000o("upgrade");
    private final FramedConnection framedConnection;
    private final HttpEngine httpEngine;
    private FramedStream stream;

    public final boolean canReuseConnection() {
        return true;
    }

    public final void releaseConnectionOnIdle() {
    }

    public FramedTransport(HttpEngine httpEngine2, FramedConnection framedConnection2) {
        this.httpEngine = httpEngine2;
        this.framedConnection = framedConnection2;
    }

    public final jbm createRequestBody(Request request, long j) throws IOException {
        return this.stream.getSink();
    }

    public final void writeRequestHeaders(Request request) throws IOException {
        List<Header> list;
        if (this.stream == null) {
            this.httpEngine.writingRequestHeaders();
            boolean permitsRequestBody = this.httpEngine.permitsRequestBody(request);
            if (this.framedConnection.getProtocol() == Protocol.HTTP_2) {
                list = http2HeadersList(request);
            } else {
                list = spdy3HeadersList(request);
            }
            this.stream = this.framedConnection.newStream(list, permitsRequestBody, true);
            this.stream.readTimeout().timeout((long) this.httpEngine.client.getReadTimeout(), TimeUnit.MILLISECONDS);
        }
    }

    public final void writeRequestBody(RetryableSink retryableSink) throws IOException {
        retryableSink.writeToSocket(this.stream.getSink());
    }

    public final void finishRequest() throws IOException {
        this.stream.getSink().close();
    }

    public final Response.Builder readResponseHeaders() throws IOException {
        if (this.framedConnection.getProtocol() == Protocol.HTTP_2) {
            return readHttp2HeadersList(this.stream.getResponseHeaders());
        }
        return readSpdy3HeadersList(this.stream.getResponseHeaders());
    }

    public static List<Header> spdy3HeadersList(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 5);
        arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.httpUrl())));
        arrayList.add(new Header(Header.VERSION, "HTTP/1.1"));
        arrayList.add(new Header(Header.TARGET_HOST, Util.hostHeader(request.httpUrl())));
        arrayList.add(new Header(Header.TARGET_SCHEME, request.httpUrl().scheme()));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            ByteString O000000o2 = ByteString.O000000o(headers.name(i).toLowerCase(Locale.US));
            if (!SPDY_3_SKIPPED_REQUEST_HEADERS.contains(O000000o2)) {
                String value = headers.value(i);
                if (linkedHashSet.add(O000000o2)) {
                    arrayList.add(new Header(O000000o2, value));
                } else {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= arrayList.size()) {
                            break;
                        } else if (((Header) arrayList.get(i2)).name.equals(O000000o2)) {
                            arrayList.set(i2, new Header(O000000o2, joinOnNull(((Header) arrayList.get(i2)).value.O000000o(), value)));
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private static String joinOnNull(String str, String str2) {
        return str + 0 + str2;
    }

    public static List<Header> http2HeadersList(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.httpUrl())));
        arrayList.add(new Header(Header.TARGET_AUTHORITY, Util.hostHeader(request.httpUrl())));
        arrayList.add(new Header(Header.TARGET_SCHEME, request.httpUrl().scheme()));
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            ByteString O000000o2 = ByteString.O000000o(headers.name(i).toLowerCase(Locale.US));
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(O000000o2)) {
                arrayList.add(new Header(O000000o2, headers.value(i)));
            }
        }
        return arrayList;
    }

    public static Response.Builder readSpdy3HeadersList(List<Header> list) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        builder.set(OkHeaders.SELECTED_PROTOCOL, Protocol.SPDY_3.toString());
        int size = list.size();
        String str = "HTTP/1.1";
        String str2 = null;
        int i = 0;
        while (i < size) {
            ByteString byteString = list.get(i).name;
            String O000000o2 = list.get(i).value.O000000o();
            String str3 = str;
            String str4 = str2;
            int i2 = 0;
            while (i2 < O000000o2.length()) {
                int indexOf = O000000o2.indexOf(0, i2);
                if (indexOf == -1) {
                    indexOf = O000000o2.length();
                }
                String substring = O000000o2.substring(i2, indexOf);
                if (byteString.equals(Header.RESPONSE_STATUS)) {
                    str4 = substring;
                } else if (byteString.equals(Header.VERSION)) {
                    str3 = substring;
                } else if (!SPDY_3_SKIPPED_RESPONSE_HEADERS.contains(byteString)) {
                    builder.add(byteString.O000000o(), substring);
                }
                i2 = indexOf + 1;
            }
            i++;
            str2 = str4;
            str = str3;
        }
        if (str2 != null) {
            StatusLine parse = StatusLine.parse(str + " " + str2);
            return new Response.Builder().protocol(Protocol.SPDY_3).code(parse.code).message(parse.message).headers(builder.build());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public static Response.Builder readHttp2HeadersList(List<Header> list) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        builder.set(OkHeaders.SELECTED_PROTOCOL, Protocol.HTTP_2.toString());
        int size = list.size();
        String str = null;
        for (int i = 0; i < size; i++) {
            ByteString byteString = list.get(i).name;
            String O000000o2 = list.get(i).value.O000000o();
            if (byteString.equals(Header.RESPONSE_STATUS)) {
                str = O000000o2;
            } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(byteString)) {
                builder.add(byteString.O000000o(), O000000o2);
            }
        }
        if (str != null) {
            StatusLine parse = StatusLine.parse("HTTP/1.1 ".concat(String.valueOf(str)));
            return new Response.Builder().protocol(Protocol.HTTP_2).code(parse.code).message(parse.message).headers(builder.build());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public final ResponseBody openResponseBody(Response response) throws IOException {
        return new RealResponseBody(response.headers(), jbg.O000000o(this.stream.getSource()));
    }

    public final void disconnect(HttpEngine httpEngine2) throws IOException {
        FramedStream framedStream = this.stream;
        if (framedStream != null) {
            framedStream.close(ErrorCode.CANCEL);
        }
    }
}

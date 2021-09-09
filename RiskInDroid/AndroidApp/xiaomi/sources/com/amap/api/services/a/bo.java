package com.amap.api.services.a;

public class bo extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private String f3339a;
    private String b;
    private String c;
    private String d;
    private int e;

    public bo(String str) {
        super(str);
        this.f3339a = "未知的错误";
        this.b = "";
        this.c = "1900";
        this.d = "UnknownError";
        this.e = -1;
        this.f3339a = str;
        a(str);
    }

    public bo(String str, String str2) {
        this(str);
        this.b = str2;
    }

    public String a() {
        return this.f3339a;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.b;
    }

    public void a(int i) {
        this.e = i;
    }

    private void a(String str) {
        if ("IO 操作异常 - IOException".equals(str)) {
            this.e = 21;
            this.c = "1902";
            this.d = "IOException";
        } else if ("socket 连接异常 - SocketException".equals(str)) {
            this.e = 22;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.e = 23;
            this.c = "1802";
            this.d = "SocketTimeoutException";
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.e = 24;
            this.c = "1901";
            this.d = "IllegalArgumentException";
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.e = 25;
            this.c = "1903";
            this.d = "NullPointException";
        } else if ("url异常 - MalformedURLException".equals(str)) {
            this.e = 26;
            this.c = "1803";
            this.d = "MalformedURLException";
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            this.e = 27;
            this.c = "1804";
            this.d = "UnknownHostException";
        } else if ("服务器连接失败 - UnknownServiceException".equals(str)) {
            this.e = 28;
            this.c = "1805";
            this.d = "CannotConnectToHostException";
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            this.e = 29;
            this.c = "1801";
            this.d = "ProtocolException";
        } else if ("http连接失败 - ConnectionException".equals(str)) {
            this.e = 30;
            this.c = "1806";
            this.d = "ConnectionException";
        } else if ("未知的错误".equals(str)) {
            this.e = 31;
        } else if ("key鉴权失败".equals(str)) {
            this.e = 32;
        } else if ("requeust is null".equals(str)) {
            this.e = 1;
        } else if ("request url is empty".equals(str)) {
            this.e = 2;
        } else if ("response is null".equals(str)) {
            this.e = 3;
        } else if ("thread pool has exception".equals(str)) {
            this.e = 4;
        } else if ("sdk name is invalid".equals(str)) {
            this.e = 5;
        } else if ("sdk info is null".equals(str)) {
            this.e = 6;
        } else if ("sdk packages is null".equals(str)) {
            this.e = 7;
        } else if ("线程池为空".equals(str)) {
            this.e = 8;
        } else if ("获取对象错误".equals(str)) {
            this.e = 101;
        } else {
            this.e = -1;
        }
    }
}

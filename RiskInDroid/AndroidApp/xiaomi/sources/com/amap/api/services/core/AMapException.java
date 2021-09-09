package com.amap.api.services.core;

public class AMapException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private int f3441a = 0;
    private String b = null;
    private String c = "";
    private int d = 1000;

    public int getErrorLevel() {
        return this.f3441a;
    }

    public String getErrorType() {
        return this.b;
    }

    public AMapException(String str) {
        super(str);
        this.c = str;
        this.f3441a = 0;
        a(str);
    }

    public AMapException(String str, int i, String str2) {
        super(str);
        this.c = str;
        this.f3441a = i;
        this.b = str2;
        a(str);
    }

    public AMapException() {
    }

    public String getErrorMessage() {
        return this.c;
    }

    public int getErrorCode() {
        return this.d;
    }

    private void a(String str) {
        if ("用户签名未通过".equals(str)) {
            this.d = 1001;
        } else if ("用户key不正确或过期".equals(str)) {
            this.d = 1002;
        } else if ("请求服务不存在".equals(str)) {
            this.d = 1003;
        } else if ("访问已超出日访问量".equals(str)) {
            this.d = 1004;
        } else if ("用户访问过于频繁".equals(str)) {
            this.d = 1005;
        } else if ("用户IP无效".equals(str)) {
            this.d = 1006;
        } else if ("用户域名无效".equals(str)) {
            this.d = 1007;
        } else if ("用户MD5安全码未通过".equals(str)) {
            this.d = 1008;
        } else if ("请求key与绑定平台不符".equals(str)) {
            this.d = 1009;
        } else if ("IP访问超限".equals(str)) {
            this.d = 1010;
        } else if ("服务不支持https请求".equals(str)) {
            this.d = 1011;
        } else if ("权限不足，服务请求被拒绝".equals(str)) {
            this.d = 1012;
        } else if ("开发者删除了key，key被删除后无法正常使用".equals(str)) {
            this.d = 1013;
        } else if ("请求服务响应错误".equals(str)) {
            this.d = 1100;
        } else if ("引擎返回数据异常".equals(str)) {
            this.d = 1101;
        } else if ("服务端请求链接超时".equals(str)) {
            this.d = 1102;
        } else if ("读取服务结果超时".equals(str)) {
            this.d = 1103;
        } else if ("请求参数非法".equals(str)) {
            this.d = 1200;
        } else if ("缺少必填参数".equals(str)) {
            this.d = 1201;
        } else if ("请求协议非法".equals(str)) {
            this.d = 1202;
        } else if ("其他未知错误".equals(str)) {
            this.d = 1203;
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            this.d = 1801;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.d = 1802;
        } else if ("url异常 - MalformedURLException".equals(str)) {
            this.d = 1803;
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            this.d = 1804;
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.d = 1901;
        } else if ("http或socket连接失败 - ConnectionException".equals(str)) {
            this.d = 1806;
        } else if ("IO 操作异常 - IOException".equals(str)) {
            this.d = 1902;
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.d = 1903;
        } else if ("tableID格式不正确不存在".equals(str)) {
            this.d = 2000;
        } else if ("ID不存在".equals(str)) {
            this.d = 2001;
        } else if ("服务器维护中".equals(str)) {
            this.d = 2002;
        } else if ("key对应的tableID不存在".equals(str)) {
            this.d = 2003;
        } else if ("找不到对应的userid信息,请检查您提供的userid是否存在".equals(str)) {
            this.d = 2100;
        } else if ("App key未开通“附近”功能,请注册附近KEY".equals(str)) {
            this.d = 2101;
        } else if ("规划点（包括起点、终点、途经点）不在中国陆地范围内".equals(str)) {
            this.d = 3000;
        } else if ("规划点（起点、终点、途经点）附近搜不到路".equals(str)) {
            this.d = 3001;
        } else if ("路线计算失败，通常是由于道路连通关系导致".equals(str)) {
            this.d = 3002;
        } else if ("起点终点距离过长".equals(str)) {
            this.d = 3003;
        } else if ("已开启自动上传".equals(str)) {
            this.d = 2200;
        } else if ("USERID非法".equals(str)) {
            this.d = 2201;
        } else if ("NearbyInfo对象为空".equals(str)) {
            this.d = 2202;
        } else if ("两次单次上传的间隔低于7秒".equals(str)) {
            this.d = 2203;
        } else if ("Point为空，或与前次上传的相同".equals(str)) {
            this.d = 2204;
        } else if ("短串分享认证失败".equals(str)) {
            this.d = 4000;
        } else if ("短串请求失败".equals(str)) {
            this.d = 4001;
        } else if ("用户签名未通过".equals(str)) {
            this.d = 4002;
        } else if ("未知错误".equals(str)) {
            this.d = 1900;
            this.b = "CLIENT_UNKNOWN_ERROR";
        } else {
            this.d = 1800;
            this.b = "AMAP_CLIENT_ERRORCODE_MISSSING";
        }
    }
}

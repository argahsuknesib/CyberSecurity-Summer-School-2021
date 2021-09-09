package com.amap.api.services.a;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.google.android.exoplayer2.C;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class s {
    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static void b(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                a(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"));
            } else if (jSONObject.has("status")) {
                String string = jSONObject.getString("status");
                if (!string.equals("1")) {
                    if (string.equals("0")) {
                        if (!jSONObject.has("infocode")) {
                            throw new AMapException("未知错误");
                        }
                    }
                    int i = jSONObject.getInt("infocode");
                    if (string.equals("0")) {
                        a(i, jSONObject.getString("info"));
                    }
                }
            }
        } catch (JSONException e) {
            a(e, "CoreUtil", "paseAuthFailurJson");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void a(int i, String str) throws AMapException, JSONException {
        if (i == 0) {
            return;
        }
        if (i == 22000) {
            throw new AMapException("tableID格式不正确不存在", 2, str);
        } else if (i == 32200) {
            throw new AMapException("找不到对应的userid信息,请检查您提供的userid是否存在", 2, str);
        } else if (i != 32201) {
            switch (i) {
                case C.MSG_CUSTOM_BASE /*10000*/:
                    return;
                case 10001:
                    throw new AMapException("用户key不正确或过期", 2, str);
                case 10002:
                    throw new AMapException("请求服务不存在", 2, str);
                case 10003:
                    throw new AMapException("访问已超出日访问量", 2, str);
                case 10004:
                    throw new AMapException("用户访问过于频繁", 2, str);
                case 10005:
                    throw new AMapException("用户IP无效", 2, str);
                case 10006:
                    throw new AMapException("用户域名无效", 2, str);
                case 10007:
                    throw new AMapException("用户签名未通过", 2, str);
                case 10008:
                    throw new AMapException("用户MD5安全码未通过", 2, str);
                case 10009:
                    throw new AMapException("请求key与绑定平台不符", 2, str);
                case 10010:
                    throw new AMapException("IP访问超限", 2, str);
                case 10011:
                    throw new AMapException("服务不支持https请求", 2, str);
                case 10012:
                    throw new AMapException("权限不足，服务请求被拒绝", 2, str);
                case 10013:
                    throw new AMapException("开发者删除了key，key被删除后无法正常使用", 2, str);
                default:
                    switch (i) {
                        case 20000:
                            throw new AMapException("请求参数非法", 2, str);
                        case 20001:
                            throw new AMapException("缺少必填参数", 2, str);
                        case 20002:
                            throw new AMapException("请求协议非法", 2, str);
                        case 20003:
                            throw new AMapException("其他未知错误", 2, str);
                        default:
                            switch (i) {
                                case 20800:
                                    throw new AMapException("规划点（包括起点、终点、途经点）不在中国陆地范围内", 2, str);
                                case 20801:
                                    throw new AMapException("规划点（起点、终点、途经点）附近搜不到路", 2, str);
                                case 20802:
                                    throw new AMapException("路线计算失败，通常是由于道路连通关系导致", 2, str);
                                case 20803:
                                    throw new AMapException("起点终点距离过长", 2, str);
                                default:
                                    switch (i) {
                                        case 30000:
                                            throw new AMapException("请求服务响应错误", 2, str);
                                        case 30001:
                                            throw new AMapException("引擎返回数据异常", 2, str);
                                        case 30002:
                                            throw new AMapException("服务端请求链接超时", 2, str);
                                        case 30003:
                                            throw new AMapException("读取服务结果超时", 2, str);
                                        default:
                                            switch (i) {
                                                case 32000:
                                                    throw new AMapException("key对应的tableID不存在", 2, str);
                                                case 32001:
                                                    throw new AMapException("ID不存在", 2, str);
                                                case 32002:
                                                    throw new AMapException("服务器维护中", 2, str);
                                                default:
                                                    throw new AMapException(str, 2, str);
                                            }
                                    }
                            }
                    }
            }
        } else {
            throw new AMapException("App key未开通“附近”功能,请注册附近KEY", 2, str);
        }
    }

    public static double a(double d) {
        return Double.parseDouble(new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US)).format(d));
    }

    public static String a(LatLonPoint latLonPoint) {
        if (latLonPoint == null) {
            return "";
        }
        double a2 = a(latLonPoint.getLongitude());
        double a3 = a(latLonPoint.getLatitude());
        return a2 + "," + a3;
    }

    public static Date c(String str) {
        if (str == null || str.trim().equals("")) {
            return null;
        }
        try {
            return new SimpleDateFormat("HHmm").parse(str);
        } catch (ParseException e) {
            a(e, "CoreUtil", "parseString2Time");
            return null;
        }
    }

    public static String a(Date date) {
        return date != null ? new SimpleDateFormat("HH:mm").format(date) : "";
    }

    public static Date d(String str) {
        if (str == null || str.trim().equals("")) {
            return null;
        }
        try {
            return new SimpleDateFormat("HH:mm").parse(str);
        } catch (ParseException e) {
            a(e, "CoreUtil", "parseTime");
            return null;
        }
    }

    public static String a(List<LatLonPoint> list) {
        return a(list, ";");
    }

    public static String a(List<LatLonPoint> list, String str) {
        if (list == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            LatLonPoint latLonPoint = list.get(i);
            if (latLonPoint != null) {
                double a2 = a(latLonPoint.getLongitude());
                double a3 = a(latLonPoint.getLatitude());
                stringBuffer.append(a2);
                stringBuffer.append(",");
                stringBuffer.append(a3);
                stringBuffer.append(str);
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }

    public static void a(Throwable th, String str, String str2) {
        try {
            cl d = cl.d();
            if (d != null) {
                d.b(th, str, str2);
            }
            th.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}

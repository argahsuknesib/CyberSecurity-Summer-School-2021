package _m_j;

import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.model.xdcs.CdnConfigModel;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class imq {

    /* renamed from: O000000o  reason: collision with root package name */
    public static CdnConfigModel f1481O000000o;
    private static HttpURLConnection O00000Oo;
    private static InputStream O00000o;
    private static OutputStream O00000o0;

    public static void O000000o(imo imo, CdnConfigModel cdnConfigModel) {
        HttpURLConnection httpURLConnection;
        if (imo != null && cdnConfigModel != null) {
            try {
                imp imp = new imp();
                imp.O0000O0o = "CDN";
                imp.O0000OOo = imo;
                imp.O00000oo = System.currentTimeMillis();
                ArrayList arrayList = new ArrayList();
                arrayList.add(imp);
                String O000000o2 = O000000o(arrayList);
                String str = cdnConfigModel.O0000OOo;
                String str2 = cdnConfigModel.O0000Oo0;
                StringBuffer stringBuffer = new StringBuffer();
                HashMap<String, String> hashMap = cdnConfigModel.O0000Oo;
                if (hashMap != null) {
                    for (String next : hashMap.keySet()) {
                        stringBuffer.append(next);
                        stringBuffer.append("=");
                        stringBuffer.append(hashMap.get(next));
                        stringBuffer.append(";");
                    }
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("Cookie", stringBuffer.toString() + "domain=" + str + ";path=" + str2);
                hashMap2.put("User-Agent", cdnConfigModel.O0000O0o);
                hashMap2.put("Content-Length", String.valueOf(O000000o2.length()));
                hashMap2.put("Content-Type", "application/json");
                HttpURLConnection O000000o3 = imf.O000000o(TextUtils.isEmpty(cdnConfigModel.O00000oo) ? "http://xdcs-collector.ximalaya.com/api/v1/cdnAndroid" : cdnConfigModel.O00000oo, "POST", hashMap2);
                O00000Oo = O000000o3;
                O000000o3.connect();
                OutputStream outputStream = O00000Oo.getOutputStream();
                O00000o0 = outputStream;
                outputStream.write(O000000o2.getBytes("utf-8"));
                O00000o0.flush();
                O00000o0.close();
                int responseCode = O00000Oo.getResponseCode();
                imc.O000000o("post to xdcs url: " + O00000Oo.getURL());
                System.out.println("post to xdcs Response Code : ".concat(String.valueOf(responseCode)));
                InputStream inputStream = O00000Oo.getInputStream();
                O00000o = inputStream;
                if (inputStream != null) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(O00000o));
                    StringBuffer stringBuffer2 = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer2.append(readLine);
                    }
                    imc.O000000o(stringBuffer2.toString());
                }
                OutputStream outputStream2 = O00000o0;
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                InputStream inputStream2 = O00000o;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                httpURLConnection = O00000Oo;
                if (httpURLConnection == null) {
                    return;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                OutputStream outputStream3 = O00000o0;
                if (outputStream3 != null) {
                    try {
                        outputStream3.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                InputStream inputStream3 = O00000o;
                if (inputStream3 != null) {
                    try {
                        inputStream3.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                httpURLConnection = O00000Oo;
                if (httpURLConnection == null) {
                    return;
                }
            } catch (Throwable th) {
                OutputStream outputStream4 = O00000o0;
                if (outputStream4 != null) {
                    try {
                        outputStream4.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                InputStream inputStream4 = O00000o;
                if (inputStream4 != null) {
                    try {
                        inputStream4.close();
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                HttpURLConnection httpURLConnection2 = O00000Oo;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                    O00000Oo = null;
                }
                throw th;
            }
            httpURLConnection.disconnect();
            O00000Oo = null;
        }
    }

    private static String O000000o(List<imp> list) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (imp next : list) {
            if (next != null) {
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(next.f1480O000000o)) {
                    jSONObject2.put("viewId", next.f1480O000000o);
                }
                if (!TextUtils.isEmpty(next.O00000Oo)) {
                    jSONObject2.put("parentSpanId", next.O00000Oo);
                }
                if (!TextUtils.isEmpty(next.O00000o)) {
                    jSONObject2.put("viewId", next.O00000o);
                }
                if (!TextUtils.isEmpty(next.O00000oO)) {
                    jSONObject2.put("viewId", next.O00000oO);
                }
                if (next.O00000oo >= 0) {
                    jSONObject2.put("ts", next.O00000oo);
                }
                if (next.O00000o0 >= 0) {
                    jSONObject2.put("seqId", next.O00000o0);
                }
                if (!TextUtils.isEmpty(next.O0000O0o)) {
                    jSONObject2.put("type", next.O0000O0o);
                }
                if (next.O0000OOo != null) {
                    imo imo = next.O0000OOo;
                    JSONObject jSONObject3 = new JSONObject();
                    if (!TextUtils.isEmpty(imo.f1479O000000o)) {
                        jSONObject3.put("audioUrl", imo.f1479O000000o);
                    }
                    if (!TextUtils.isEmpty(imo.O00000o0)) {
                        jSONObject3.put("cdnIP", imo.O00000o0);
                    }
                    if (!TextUtils.isEmpty(imo.O00000oO)) {
                        jSONObject3.put("downloadSpeed", imo.O00000oO);
                    } else {
                        jSONObject3.put("downloadSpeed", "0.0");
                    }
                    if (!TextUtils.isEmpty(imo.O0000O0o)) {
                        jSONObject3.put("errorType", imo.O0000O0o);
                    }
                    if (!TextUtils.isEmpty(imo.O00000oo)) {
                        jSONObject3.put("exceptionReason", imo.O00000oo);
                    }
                    if (!TextUtils.isEmpty(imo.O0000OOo)) {
                        jSONObject3.put("statusCode", imo.O0000OOo);
                    }
                    if (!TextUtils.isEmpty(imo.O0000Ooo)) {
                        jSONObject3.put("type", imo.O0000Ooo);
                    }
                    if (!TextUtils.isEmpty(imo.O0000Oo0)) {
                        jSONObject3.put("viaInfo", imo.O0000Oo0);
                    }
                    if (imo.O00000Oo > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(imo.O00000Oo);
                        jSONObject3.put("audioBytes", sb.toString());
                    } else {
                        jSONObject3.put("audioBytes", 0);
                    }
                    if (imo.O0000Oo >= 0.0f) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(imo.O0000Oo);
                        jSONObject3.put("connectedTime", sb2.toString());
                    }
                    if (imo.O0000OoO >= 0) {
                        jSONObject3.put("timestamp", imo.O0000OoO);
                    }
                    if (imo.O0000o00 != null) {
                        jSONObject3.put("range", imo.O0000o00);
                    }
                    if (imo.O0000o0 != null) {
                        jSONObject3.put("fileSize", imo.O0000o0);
                    }
                    if (!TextUtils.isEmpty(imo.O0000o0O)) {
                        jSONObject3.put("downloaded", imo.O0000o0O);
                    } else {
                        jSONObject3.put("downloaded", "");
                    }
                    if (!TextUtils.isEmpty(imo.O0000o0o)) {
                        jSONObject3.put("downloadTime", imo.O0000o0o);
                    } else {
                        jSONObject3.put("downloadTime", "");
                    }
                    if (!TextUtils.isEmpty(imo.O0000o)) {
                        jSONObject3.put("downloadResult", imo.O0000o);
                    } else {
                        jSONObject3.put("downloadResult", "failed");
                    }
                    if (!TextUtils.isEmpty(imo.O0000oO0)) {
                        jSONObject3.put("cdnDomain", imo.O0000oO0);
                    }
                    jSONObject3.put("timeout", imo.O00000o);
                    jSONObject2.put("props", jSONObject3);
                }
                jSONArray.put(jSONObject2);
            }
        }
        jSONObject.put("events", jSONArray);
        return jSONObject.toString();
    }

    public static String O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = "";
        if (str != null) {
            try {
                if (!str.trim().equals(str2)) {
                    Matcher matcher = Pattern.compile("(?<=//|)((\\w)+\\.)+\\w+").matcher(str);
                    if (matcher.find()) {
                        str2 = matcher.group();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return InetAddress.getByName(str2).getHostAddress();
    }

    public static String O000000o(Throwable th) {
        StackTraceElement stackTraceElement = th.getStackTrace()[0];
        if (stackTraceElement == null) {
            return th.getMessage();
        }
        if (!TextUtils.isEmpty(th.getMessage())) {
            return th.getMessage();
        }
        return "null  located at:" + stackTraceElement.toString();
    }

    public static float O000000o(float f, boolean z) {
        String str;
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (z) {
            str = new DecimalFormat(".0").format((double) f);
        } else if (((double) f) < 0.1d) {
            return 0.001f;
        } else {
            str = new DecimalFormat(".000").format((double) (f / 1000.0f));
        }
        try {
            return Float.valueOf(str).floatValue();
        } catch (Exception unused) {
            return f;
        }
    }
}

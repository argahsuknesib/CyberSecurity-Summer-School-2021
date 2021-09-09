package com.xiaomi.account.diagnosis;

import android.util.Pair;
import com.xiaomi.account.diagnosis.encrypt.EncryptLog;
import com.xiaomi.accountsdk.utils.DiagnosisLogInterface;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RealDiagnosisLogger implements DiagnosisLogInterface {
    private static final Random sRandom = new Random();

    enum HttpMethod {
        GET,
        POST
    }

    RealDiagnosisLogger() {
    }

    public void logResponseCode(String str, int i) {
        appendLogLine("Response code=" + i + ", request id=" + str);
    }

    private static void appendLogLine(String str) {
        EncryptLog.e("AccountDiagnosisLogger", str);
    }

    private static String generateShortUUID() {
        return Integer.toHexString(sRandom.nextInt());
    }

    public void logResponseDecryptedBody(String str) {
        appendLogLine("DecryptedBody: ".concat(String.valueOf(str)));
    }

    public void logResponse(String str, String str2, Map<String, List<String>> map, Map<String, String> map2) {
        appendLogLine("request id: " + str + "\n" + "raw response body: " + str2 + "\n" + "response headers: " + map + "\n" + "response cookies: " + map2);
    }

    private static Pair<String, String> resolveHost(String str) {
        String str2;
        String str3;
        try {
            str2 = InetAddress.getByName(str).toString();
        } catch (UnknownHostException unused) {
            str2 = "Unknown";
        }
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            for (InetAddress append : allByName) {
                sb.append(append);
                sb.append(",");
            }
            sb.append(")");
            str3 = sb.toString();
        } catch (UnknownHostException unused2) {
            str3 = "(Unknown)";
        }
        return Pair.create(str2, str3);
    }

    private static String getDomainName(String str) {
        try {
            return new URI(str).getHost();
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    public void logRequestException(Exception exc) {
        appendLogLine("RequestException: ".concat(String.valueOf(getStackTraceString(exc))));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.PrintWriter.<init>(java.io.Writer, boolean):void}
     arg types: [java.io.StringWriter, int]
     candidates:
      ClspMth{java.io.PrintWriter.<init>(java.io.File, java.lang.String):void throws java.io.FileNotFoundException, java.io.UnsupportedEncodingException}
      ClspMth{java.io.PrintWriter.<init>(java.io.OutputStream, boolean):void}
      ClspMth{java.io.PrintWriter.<init>(java.lang.String, java.lang.String):void throws java.io.FileNotFoundException, java.io.UnsupportedEncodingException}
      ClspMth{java.io.PrintWriter.<init>(java.io.Writer, boolean):void} */
    private static String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public String logGetRequest(String str, Map<String, String> map, String str2, Map<String, String> map2, Map<String, String> map3) {
        return logRequest(HttpMethod.GET, str, map, str2, null, map3, map2);
    }

    public String logPostRequest(String str, Map<String, String> map, String str2, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4) {
        return logRequest(HttpMethod.POST, str, map, str2, map2, map3, map4);
    }

    private static String logRequest(HttpMethod httpMethod, String str, Map<String, String> map, String str2, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4) {
        String generateShortUUID = generateShortUUID();
        Pair<String, String> resolveHost = resolveHost(getDomainName(str));
        StringBuilder sb = new StringBuilder();
        sb.append(httpMethod.toString());
        sb.append(" request id=");
        sb.append(generateShortUUID);
        sb.append("\n");
        sb.append("fullUrl: ");
        sb.append(str2);
        sb.append("\n");
        sb.append("addr: ");
        sb.append((String) resolveHost.first);
        sb.append(", addr list: ");
        sb.append((String) resolveHost.second);
        sb.append("\n");
        sb.append("url: ");
        sb.append(str);
        sb.append("\n");
        sb.append("urlParams: ");
        sb.append(map);
        sb.append("\n");
        if (map2 != null) {
            sb.append("postParams: ");
            sb.append(map2);
            sb.append("\n");
        }
        sb.append("headers: ");
        sb.append(map4);
        sb.append("\n");
        sb.append("cookies: ");
        sb.append(map3);
        appendLogLine(sb.toString());
        return generateShortUUID;
    }
}

package org.json;

import java.util.Locale;

public class HTTP {
    public static JSONObject toJSONObject(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        HTTPTokener hTTPTokener = new HTTPTokener(str);
        String nextToken = hTTPTokener.nextToken();
        if (nextToken.toUpperCase(Locale.ROOT).startsWith("HTTP")) {
            jSONObject.put("HTTP-Version", nextToken);
            jSONObject.put("Status-Code", hTTPTokener.nextToken());
            jSONObject.put("Reason-Phrase", hTTPTokener.nextTo(0));
            hTTPTokener.next();
        } else {
            jSONObject.put("Method", nextToken);
            jSONObject.put("Request-URI", hTTPTokener.nextToken());
            jSONObject.put("HTTP-Version", hTTPTokener.nextToken());
        }
        while (hTTPTokener.more()) {
            String nextTo = hTTPTokener.nextTo(':');
            hTTPTokener.next(':');
            jSONObject.put(nextTo, hTTPTokener.nextTo(0));
            hTTPTokener.next();
        }
        return jSONObject;
    }

    public static String toString(JSONObject jSONObject) throws JSONException {
        StringBuilder sb = new StringBuilder();
        if (jSONObject.has("Status-Code") && jSONObject.has("Reason-Phrase")) {
            sb.append(jSONObject.getString("HTTP-Version"));
            sb.append(' ');
            sb.append(jSONObject.getString("Status-Code"));
            sb.append(' ');
            sb.append(jSONObject.getString("Reason-Phrase"));
        } else if (!jSONObject.has("Method") || !jSONObject.has("Request-URI")) {
            throw new JSONException("Not enough material for an HTTP header.");
        } else {
            sb.append(jSONObject.getString("Method"));
            sb.append(' ');
            sb.append('\"');
            sb.append(jSONObject.getString("Request-URI"));
            sb.append('\"');
            sb.append(' ');
            sb.append(jSONObject.getString("HTTP-Version"));
        }
        sb.append("\r\n");
        for (String next : jSONObject.keySet()) {
            String optString = jSONObject.optString(next);
            if (!"HTTP-Version".equals(next) && !"Status-Code".equals(next) && !"Reason-Phrase".equals(next) && !"Method".equals(next) && !"Request-URI".equals(next) && !JSONObject.NULL.equals(optString)) {
                sb.append(next);
                sb.append(": ");
                sb.append(jSONObject.optString(next));
                sb.append("\r\n");
            }
        }
        sb.append("\r\n");
        return sb.toString();
    }
}

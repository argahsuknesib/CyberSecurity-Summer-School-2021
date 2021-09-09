package com.xiaomi.accountsdk.request.log;

import android.net.Uri;
import com.xiaomi.accountsdk.request.SimpleRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtocolLogHelper {
    private static final String HELPER_CLASS_NAME = "com.xiaomi.accountsdk.request.log.ProtocolLogHelper";

    public interface Log {
        void log();
    }

    public interface RequestLog extends Log {
        RequestLog cookieOrNull(Map<String, String> map);

        RequestLog headerOrNull(Map<String, String> map);

        RequestLog paramOrNull(Map<String, String> map);
    }

    public interface RequestLogWithMask extends RequestLog {
        RequestLogWithMask cookieWithMaskOrNull(Map<String, String> map);

        RequestLogWithMask headerWithMaskOrNull(Map<String, String> map);

        RequestLogWithMask paramWithMaskOrNull(Map<String, String> map);
    }

    public interface ResponseLog extends Log {
        ResponseLog cookieKeyOrNull(Set<String> set);

        ResponseLog headerOrNull(Map<String, String> map);

        ResponseLog mapResponseOrNull(SimpleRequest.MapContent mapContent);

        ResponseLog streamResponseOrNull(SimpleRequest.StreamContent streamContent);

        ResponseLog stringResponseOrNull(SimpleRequest.StringContent stringContent);
    }

    public interface ResponseLogWithMask extends ResponseLog {
        ResponseLogWithMask headerWithMaskOrNull(Map<String, String> map);

        ResponseLogWithMask jsonResponseWithMaskOrNull(SimpleRequest.StringContent stringContent);

        ResponseLogWithMask mapResponseWithMaskOrNull(SimpleRequest.MapContent mapContent);

        ResponseLogWithMask streamResponseWithMaskOrNull(SimpleRequest.StreamContent streamContent);
    }

    static class RequestLogImpl implements RequestLog {
        protected Map<String, String> mCookies;
        protected Map<String, String> mHeaders;
        protected HttpMethod mHttpMethod;
        protected Map<String, String> mParams;
        protected String mUrl;

        public RequestLogImpl(String str, HttpMethod httpMethod) {
            if (str == null) {
                throw new IllegalArgumentException("url can not be null");
            } else if (httpMethod != null) {
                this.mUrl = str;
                this.mHttpMethod = httpMethod;
            } else {
                throw new IllegalArgumentException("httpMethod can not be null");
            }
        }

        public RequestLog paramOrNull(Map<String, String> map) {
            this.mParams = map;
            return this;
        }

        public RequestLog headerOrNull(Map<String, String> map) {
            this.mHeaders = map;
            return this;
        }

        public RequestLog cookieOrNull(Map<String, String> map) {
            this.mCookies = map;
            return this;
        }

        public void log() {
            StringBuilder sb = new StringBuilder();
            sb.append(" #Request# ");
            sb.append("HttpMethod: ");
            sb.append(this.mHttpMethod);
            sb.append(", ");
            sb.append("RequestUrl: ");
            sb.append(this.mUrl);
            sb.append(", ");
            sb.append("RequestParams: ");
            sb.append(this.mParams);
            sb.append(", ");
            sb.append("RequestHeaders: ");
            sb.append(this.mHeaders);
            sb.append(", ");
            sb.append("RequestCookies: ");
            sb.append(this.mCookies);
            NetworkRequestLogger.getInstance().print(RequestLogImpl.class.getName(), sb);
        }
    }

    static class ResponseLogImpl implements ResponseLog {
        protected Object mContent;
        protected Set<String> mCookieKeys;
        protected Map<String, String> mHeaders;
        protected String mUrl;

        public ResponseLogImpl(String str) {
            if (str != null) {
                this.mUrl = str;
                return;
            }
            throw new IllegalArgumentException("url can not be null");
        }

        public ResponseLog headerOrNull(Map<String, String> map) {
            this.mHeaders = map;
            return this;
        }

        public ResponseLog cookieKeyOrNull(Set<String> set) {
            this.mCookieKeys = set;
            return this;
        }

        public ResponseLog stringResponseOrNull(SimpleRequest.StringContent stringContent) {
            if (stringContent != null) {
                this.mContent = stringContent.getBody();
                this.mHeaders = stringContent.getHeaders();
                this.mCookieKeys = stringContent.getCookieKeys();
            }
            return this;
        }

        public ResponseLog mapResponseOrNull(SimpleRequest.MapContent mapContent) {
            if (mapContent != null) {
                this.mContent = mapContent.getBodies();
                this.mHeaders = mapContent.getHeaders();
                this.mCookieKeys = mapContent.getCookieKeys();
            }
            return this;
        }

        public ResponseLog streamResponseOrNull(SimpleRequest.StreamContent streamContent) {
            if (streamContent != null) {
                this.mContent = "[STREAM CONTENT]";
                this.mHeaders = streamContent.getHeaders();
                this.mCookieKeys = streamContent.getCookieKeys();
            }
            return this;
        }

        public void log() {
            StringBuilder sb = new StringBuilder();
            sb.append(" #Response# ");
            sb.append("RequestUrl: ");
            sb.append(this.mUrl);
            sb.append(", ");
            sb.append("ResponseBody: ");
            sb.append(this.mContent);
            sb.append(", ");
            sb.append("ResponseHeaders: ");
            sb.append(this.mHeaders);
            sb.append(", ");
            sb.append("ResponseCookieKeys: ");
            sb.append(this.mCookieKeys);
            NetworkRequestLogger.getInstance().print(ResponseLogImpl.class.getName(), sb);
        }
    }

    static class RequestLogWithMaskImpl extends RequestLogImpl implements RequestLogWithMask {
        private Set<String> mMaskKeys;

        public RequestLogWithMaskImpl(String str, HttpMethod httpMethod, String[] strArr) {
            super(str, httpMethod);
            if (strArr != null) {
                this.mMaskKeys = new HashSet();
                Collections.addAll(this.mMaskKeys, strArr);
                this.mUrl = ProtocolLogHelper.cloneUrlAndMaskKeysIfNotNull(str, this.mMaskKeys);
                return;
            }
            throw new IllegalArgumentException("maskKeys can not be null");
        }

        public RequestLogWithMask paramWithMaskOrNull(Map<String, String> map) {
            this.mParams = ProtocolLogHelper.cloneMapAndMaskKeysIfNotNull(map, this.mMaskKeys);
            return this;
        }

        public RequestLogWithMask headerWithMaskOrNull(Map<String, String> map) {
            this.mHeaders = ProtocolLogHelper.cloneMapAndMaskKeysIfNotNull(map, this.mMaskKeys);
            return this;
        }

        public RequestLogWithMask cookieWithMaskOrNull(Map<String, String> map) {
            this.mCookies = ProtocolLogHelper.cloneMapAndMaskKeysIfNotNull(map, this.mMaskKeys);
            return this;
        }
    }

    static class ResponseLogWithMaskImpl extends ResponseLogImpl implements ResponseLogWithMask {
        private Set<String> mMaskKeys;

        public ResponseLogWithMaskImpl(String str, String[] strArr) {
            super(str);
            if (strArr != null) {
                this.mMaskKeys = new HashSet();
                Collections.addAll(this.mMaskKeys, strArr);
                this.mUrl = ProtocolLogHelper.cloneUrlAndMaskKeysIfNotNull(str, this.mMaskKeys);
                return;
            }
            throw new IllegalArgumentException("maskKeys can not be null");
        }

        public ResponseLogWithMask headerWithMaskOrNull(Map<String, String> map) {
            this.mHeaders = ProtocolLogHelper.cloneMapAndMaskKeysIfNotNull(map, this.mMaskKeys);
            return this;
        }

        public ResponseLogWithMask jsonResponseWithMaskOrNull(SimpleRequest.StringContent stringContent) {
            if (stringContent != null) {
                this.mContent = ProtocolLogHelper.cloneJSONStringAndMaskKeysIfNotNull(ProtocolLogHelper.removeSafePrefixIfNotNull(stringContent.getBody()), this.mMaskKeys);
                this.mHeaders = ProtocolLogHelper.cloneMapAndMaskKeysIfNotNull(stringContent.getHeaders(), this.mMaskKeys);
                this.mCookieKeys = stringContent.getCookieKeys();
            }
            return this;
        }

        public ResponseLogWithMask mapResponseWithMaskOrNull(SimpleRequest.MapContent mapContent) {
            if (mapContent != null) {
                this.mContent = ProtocolLogHelper.cloneObjectMapAndMaskKeysIfNotNull(mapContent.getBodies(), this.mMaskKeys);
                this.mHeaders = ProtocolLogHelper.cloneMapAndMaskKeysIfNotNull(mapContent.getHeaders(), this.mMaskKeys);
                this.mCookieKeys = mapContent.getCookieKeys();
            }
            return this;
        }

        public ResponseLogWithMask streamResponseWithMaskOrNull(SimpleRequest.StreamContent streamContent) {
            if (streamContent != null) {
                this.mContent = "[STREAM CONTENT]";
                this.mHeaders = ProtocolLogHelper.cloneMapAndMaskKeysIfNotNull(streamContent.getHeaders(), this.mMaskKeys);
                this.mCookieKeys = streamContent.getCookieKeys();
            }
            return this;
        }
    }

    public static String cloneUrlAndMaskKeysIfNotNull(String str, Set<String> set) {
        if (str == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        if (parse.isOpaque()) {
            NetworkRequestLogger.getInstance().print(HELPER_CLASS_NAME, "can not analysis opaque uri. ");
            return cloneStringAndMaskHalfContentIfNotNull(str);
        }
        Uri.Builder clearQuery = parse.buildUpon().clearQuery();
        for (String next : parse.getQueryParameterNames()) {
            if (set.contains(next)) {
                clearQuery.appendQueryParameter(next, "@PRIVACY_MASK");
            } else {
                clearQuery.appendQueryParameter(next, parse.getQueryParameter(next));
            }
        }
        return clearQuery.build().toString();
    }

    public static Map<String, String> cloneMapAndMaskKeysIfNotNull(Map<String, String> map, Set<String> set) {
        if (map == null) {
            return map;
        }
        HashMap hashMap = new HashMap(map);
        for (String next : set) {
            if (hashMap.containsKey(next)) {
                hashMap.put(next, "@PRIVACY_MASK");
            }
        }
        return hashMap;
    }

    public static String cloneJSONStringAndMaskKeysIfNotNull(String str, Set<String> set) {
        if (str == null) {
            return str;
        }
        if (str.length() == 0) {
            NetworkRequestLogger.getInstance().print(HELPER_CLASS_NAME, "analysis json failed. EMPTY JSON. ");
            return str;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Stack stack = new Stack();
            stack.add(jSONObject);
            while (!stack.empty()) {
                JSONObject jSONObject2 = (JSONObject) stack.pop();
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (set.contains(next)) {
                        jSONObject2.put(next, "@PRIVACY_MASK");
                    } else {
                        JSONObject optJSONObject = jSONObject2.optJSONObject(next);
                        if (optJSONObject != null) {
                            stack.add(optJSONObject);
                        }
                    }
                }
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            NetworkRequestLogger.getInstance().print(HELPER_CLASS_NAME, "analysis json failed. ", e);
            return cloneStringAndMaskHalfContentIfNotNull(str);
        }
    }

    public static Map<String, Object> cloneObjectMapAndMaskKeysIfNotNull(Map<String, Object> map, Set<String> set) {
        if (map == null) {
            return map;
        }
        HashMap hashMap = new HashMap(map);
        for (String next : set) {
            if (hashMap.containsKey(next)) {
                hashMap.put(next, "@PRIVACY_MASK");
            }
        }
        return hashMap;
    }

    private static String cloneStringAndMaskHalfContentIfNotNull(String str) {
        if (str == null) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            sb.append(i % 2 == 0 ? charArray[i] : 'X');
        }
        return sb.toString();
    }

    public static String removeSafePrefixIfNotNull(String str) {
        return (str != null && str.startsWith("&&&START&&&")) ? str.substring(11) : str;
    }

    public static RequestLog newRequestLog(String str, HttpMethod httpMethod) {
        return new RequestLogImpl(str, httpMethod);
    }

    public static RequestLogWithMask newRequestLog(String str, HttpMethod httpMethod, String[] strArr) {
        return new RequestLogWithMaskImpl(str, httpMethod, strArr);
    }

    public static ResponseLog newResponseLog(String str) {
        return new ResponseLogImpl(str);
    }

    public static ResponseLogWithMask newResponseLog(String str, String[] strArr) {
        return new ResponseLogWithMaskImpl(str, strArr);
    }
}

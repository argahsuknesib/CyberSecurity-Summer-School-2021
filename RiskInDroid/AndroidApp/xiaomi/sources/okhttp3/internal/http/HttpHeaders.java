package okhttp3.internal.http;

import _m_j.jax;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okio.ByteString;

public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS = ByteString.O000000o("\"\\");
    private static final ByteString TOKEN_DELIMITERS = ByteString.O000000o("\t ,=");

    private HttpHeaders() {
    }

    public static long contentLength(Response response) {
        return contentLength(response.headers());
    }

    public static long contentLength(Headers headers) {
        return stringToLong(headers.get("Content-Length"));
    }

    private static long stringToLong(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static boolean varyMatches(Response response, Headers headers, Request request) {
        for (String next : varyFields(response)) {
            if (!Util.equal(headers.values(next), request.headers(next))) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasVaryAll(Response response) {
        return hasVaryAll(response.headers());
    }

    public static boolean hasVaryAll(Headers headers) {
        return varyFields(headers).contains("*");
    }

    private static Set<String> varyFields(Response response) {
        return varyFields(response.headers());
    }

    public static Set<String> varyFields(Headers headers) {
        Set<String> emptySet = Collections.emptySet();
        int size = headers.size();
        Set<String> set = emptySet;
        for (int i = 0; i < size; i++) {
            if ("Vary".equalsIgnoreCase(headers.name(i))) {
                String value = headers.value(i);
                if (set.isEmpty()) {
                    set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                }
                for (String trim : value.split(",")) {
                    set.add(trim.trim());
                }
            }
        }
        return set;
    }

    public static Headers varyHeaders(Response response) {
        return varyHeaders(response.networkResponse().request().headers(), response.headers());
    }

    public static Headers varyHeaders(Headers headers, Headers headers2) {
        Set<String> varyFields = varyFields(headers2);
        if (varyFields.isEmpty()) {
            return new Headers.Builder().build();
        }
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            if (varyFields.contains(name)) {
                builder.add(name, headers.value(i));
            }
        }
        return builder.build();
    }

    public static List<Challenge> parseChallenges(Headers headers, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < headers.size(); i++) {
            if (str.equalsIgnoreCase(headers.name(i))) {
                parseChallengeHeader(arrayList, new jax().O00000Oo(headers.value(i)));
            }
        }
        return arrayList;
    }

    private static void parseChallengeHeader(List<Challenge> list, jax jax) {
        String readToken;
        int skipAll;
        String str;
        while (true) {
            String str2 = null;
            while (true) {
                if (str2 == null) {
                    skipWhitespaceAndCommas(jax);
                    str2 = readToken(jax);
                    if (str2 == null) {
                        return;
                    }
                }
                boolean skipWhitespaceAndCommas = skipWhitespaceAndCommas(jax);
                readToken = readToken(jax);
                if (readToken != null) {
                    skipAll = skipAll(jax, (byte) 61);
                    boolean skipWhitespaceAndCommas2 = skipWhitespaceAndCommas(jax);
                    if (skipWhitespaceAndCommas || (!skipWhitespaceAndCommas2 && !jax.O00000o())) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        int skipAll2 = skipAll + skipAll(jax, (byte) 61);
                        while (true) {
                            if (readToken == null) {
                                readToken = readToken(jax);
                                if (skipWhitespaceAndCommas(jax)) {
                                    continue;
                                    break;
                                }
                                skipAll2 = skipAll(jax, (byte) 61);
                            }
                            if (skipAll2 == 0) {
                                continue;
                                break;
                            } else if (skipAll2 <= 1 && !skipWhitespaceAndCommas(jax)) {
                                if (jax.O00000o() || jax.O00000o0(0L) != 34) {
                                    str = readToken(jax);
                                } else {
                                    str = readQuotedString(jax);
                                }
                                if (str == null || ((String) linkedHashMap.put(readToken, str)) != null) {
                                    return;
                                }
                                if (skipWhitespaceAndCommas(jax) || jax.O00000o()) {
                                    readToken = null;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        list.add(new Challenge(str2, linkedHashMap));
                        str2 = readToken;
                    }
                } else if (jax.O00000o()) {
                    list.add(new Challenge(str2, Collections.emptyMap()));
                    return;
                } else {
                    return;
                }
            }
            list.add(new Challenge(str2, Collections.singletonMap(null, readToken + repeat('=', skipAll))));
        }
    }

    private static boolean skipWhitespaceAndCommas(jax jax) {
        boolean z = false;
        while (!jax.O00000o()) {
            byte O00000o0 = jax.O00000o0(0L);
            if (O00000o0 != 44) {
                if (O00000o0 != 32 && O00000o0 != 9) {
                    break;
                }
                jax.O0000O0o();
            } else {
                jax.O0000O0o();
                z = true;
            }
        }
        return z;
    }

    private static int skipAll(jax jax, byte b) {
        int i = 0;
        while (!jax.O00000o() && jax.O00000o0(0L) == b) {
            i++;
            jax.O0000O0o();
        }
        return i;
    }

    private static String readQuotedString(jax jax) {
        if (jax.O0000O0o() == 34) {
            jax jax2 = new jax();
            while (true) {
                long O00000Oo = jax.O00000Oo(QUOTED_STRING_DELIMITERS, 0);
                if (O00000Oo == -1) {
                    return null;
                }
                if (jax.O00000o0(O00000Oo) == 34) {
                    jax2.write(jax, O00000Oo);
                    jax.O0000O0o();
                    return jax2.O0000o();
                } else if (jax.O00000Oo == O00000Oo + 1) {
                    return null;
                } else {
                    jax2.write(jax, O00000Oo);
                    jax.O0000O0o();
                    jax2.write(jax, 1);
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static String readToken(jax jax) {
        try {
            long O00000Oo = jax.O00000Oo(TOKEN_DELIMITERS, 0);
            if (O00000Oo == -1) {
                O00000Oo = jax.O00000Oo;
            }
            if (O00000Oo != 0) {
                return jax.O00000oO(O00000Oo);
            }
            return null;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    private static String repeat(char c, int i) {
        char[] cArr = new char[i];
        Arrays.fill(cArr, c);
        return new String(cArr);
    }

    public static void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        if (cookieJar != CookieJar.NO_COOKIES) {
            List<Cookie> parseAll = Cookie.parseAll(httpUrl, headers);
            if (!parseAll.isEmpty()) {
                cookieJar.saveFromResponse(httpUrl, parseAll);
            }
        }
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals("HEAD")) {
            return false;
        }
        int code = response.code();
        if (((code >= 100 && code < 200) || code == 204 || code == 304) && contentLength(response) == -1 && !"chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return false;
        }
        return true;
    }

    public static int skipUntil(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int skipWhitespace(String str, int i) {
        while (i < str.length() && ((r0 = str.charAt(i)) == ' ' || r0 == 9)) {
            i++;
        }
        return i;
    }

    public static int parseSeconds(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}

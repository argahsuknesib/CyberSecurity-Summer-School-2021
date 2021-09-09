package com.xiaomi.account.auth;

import android.content.Context;
import com.google.android.exoplayer2.C;
import com.xiaomi.account.openauth.XMAuthericationException;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class AuthorizeApi {
    private static final String HOST = XiaomiOAuthConstants.OAUTH2_API_HOST;
    private static final String OAUTH_URL_BASE = XiaomiOAuthConstants.OAUTH2_API_URL_BASE;

    @Deprecated
    public static String doHttpGet(Context context, String str, long j, String str2) throws XMAuthericationException {
        return doHttpGet(str, j, str2, null, null);
    }

    public static String doHttpGet(String str, long j, String str2) throws XMAuthericationException {
        return doHttpGet(str, j, str2, null, null);
    }

    @Deprecated
    public static String doHttpGet(Context context, String str, long j, String str2, String str3, String str4) throws XMAuthericationException {
        return doHttpGet(str, j, str2, str3, str4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c5, code lost:
        r3 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00cc, code lost:
        r3 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d3, code lost:
        r3 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00da, code lost:
        r3 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0080 */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c5 A[ExcHandler: InvalidKeyException (e java.security.InvalidKeyException), Splitter:B:1:0x001e] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cc A[Catch:{ IOException -> 0x0080, UnsupportedEncodingException -> 0x00da, NoSuchAlgorithmException -> 0x00cc, InvalidKeyException -> 0x00c5, all -> 0x00c3 }, ExcHandler: NoSuchAlgorithmException (e java.security.NoSuchAlgorithmException), Splitter:B:1:0x001e] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00da A[Catch:{ IOException -> 0x0080, UnsupportedEncodingException -> 0x00da, NoSuchAlgorithmException -> 0x00cc, InvalidKeyException -> 0x00c5, all -> 0x00c3 }, ExcHandler: UnsupportedEncodingException (e java.io.UnsupportedEncodingException), Splitter:B:1:0x001e] */
    public static String doHttpGet(String str, long j, String str2, String str3, String str4) throws XMAuthericationException {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("clientId", String.valueOf(j)));
        arrayList.add(new BasicNameValuePair("token", str2));
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(AuthorizeHelper.generateUrl(OAUTH_URL_BASE + str, arrayList));
            HttpURLConnection.setFollowRedirects(true);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(C.MSG_CUSTOM_BASE);
            httpURLConnection.setReadTimeout(15000);
            HashMap<String, String> makeHeaders = makeHeaders(str, str2, str3, str4, arrayList);
            if (makeHeaders != null) {
                for (String next : makeHeaders.keySet()) {
                    httpURLConnection.setRequestProperty(next, makeHeaders.get(next));
                }
            }
            httpURLConnection.connect();
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException ) {
            inputStream = httpURLConnection.getErrorStream();
        } catch (UnsupportedEncodingException e) {
        } catch (NoSuchAlgorithmException e2) {
        } catch (InvalidKeyException e3) {
        } catch (Throwable th) {
            th = th;
            closeQuietly(bufferedReader);
            throw th;
        }
        if (inputStream != null) {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream), 1024);
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        String sb2 = sb.toString();
                        closeQuietly(bufferedReader2);
                        return sb2;
                    }
                }
            } catch (UnsupportedEncodingException e4) {
                e = e4;
                throw new XMAuthericationException(e);
            } catch (IOException e5) {
                e = e5;
                throw new XMAuthericationException(e);
            } catch (NoSuchAlgorithmException e6) {
                e = e6;
                throw new XMAuthericationException(e);
            } catch (InvalidKeyException e7) {
                e = e7;
                bufferedReader = bufferedReader2;
                throw new XMAuthericationException(e);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                closeQuietly(bufferedReader);
                throw th;
            }
        } else {
            throw new XMAuthericationException(new IOException());
        }
    }

    private static void closeQuietly(BufferedReader bufferedReader) {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException unused) {
            }
        }
    }

    private static HashMap<String, String> makeHeaders(String str, String str2, String str3, String str4, List<NameValuePair> list) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str3 == null && str4 == null) {
            return null;
        }
        String generateNonce = AuthorizeHelper.generateNonce();
        return AuthorizeHelper.buildMacRequestHead(str2, generateNonce, AuthorizeHelper.getMacAccessTokenSignatureString(generateNonce, "GET", HOST, str, URLEncodedUtils.format(list, "UTF-8"), str3, str4));
    }
}

package _m_j;

import _m_j.iit;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.ximalaya.ting.android.opensdk.datatrasfer.AccessTokenBaseCall$1;
import com.ximalaya.ting.android.opensdk.datatrasfer.AccessTokenBaseCall$2;
import com.ximalaya.ting.android.opensdk.datatrasfer.AccessTokenBaseCall$4;
import com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

public final class iir {

    /* renamed from: O000000o  reason: collision with root package name */
    public static HashSet<String> f1321O000000o = new AccessTokenBaseCall$1();

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01b1, code lost:
        throw new com.ximalaya.ting.android.opensdk.httputil.XimalayaException(1011, com.ximalaya.ting.android.opensdk.httputil.XimalayaException.ERR_MESSAGE_MAP.get(1011));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01bb, code lost:
        throw new com.ximalaya.ting.android.opensdk.httputil.XimalayaException(1011, r7.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01bc, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01bd, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (r0.f1351O000000o == 702) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0108, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0111, code lost:
        if (android.text.TextUtils.isEmpty(r7.getMessage()) != false) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0113, code lost:
        r7.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x011a, code lost:
        throw com.ximalaya.ting.android.opensdk.httputil.XimalayaException.getExceptionByCode(1009);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0121, code lost:
        throw com.ximalaya.ting.android.opensdk.httputil.XimalayaException.getExceptionByCode(1007);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0188, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0193, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x019e, code lost:
        if (android.text.TextUtils.isEmpty(r7.getMessage()) != false) goto L_0x01a0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01bc A[ExcHandler: XimalayaException (r7v1 'e' com.ximalaya.ting.android.opensdk.httputil.XimalayaException A[CUSTOM_DECLARE]), Splitter:B:1:0x0003] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:75:0x0148=Splitter:B:75:0x0148, B:50:0x00cc=Splitter:B:50:0x00cc} */
    public static String O000000o(Request request, Map<String, String> map, String str, String str2) throws XimalayaException {
        boolean z;
        Request request2;
        Request request3;
        O00000Oo(str2);
        try {
            Response O00000Oo = iiz.O000000o().O00000Oo(request);
            ija ija = new ija(O00000Oo);
            Response response = null;
            if (O00000Oo.code() == 200) {
                return O00000Oo.body().string();
            }
            iit.O000000o();
            iiv O000000o2 = iit.O000000o(ija);
            if (O000000o2 == null || TextUtils.isEmpty(O000000o2.O00000Oo)) {
                throw new XimalayaException(1009, ija.toString());
            }
            if (O000000o2.f1351O000000o != 701) {
            }
            if (!request.url().toString().contains("http://api.ximalaya.com/openapi-gateway-app/encrypt/exchange")) {
                if (request.url().toString().contains("http://api.ximalaya.com/openapi-gateway-app/tracks/get_play_info")) {
                }
                if (O000000o2.f1351O000000o != 206) {
                    return null;
                }
                boolean z2 = false;
                try {
                    z = O000000o();
                } catch (IOException e) {
                    e.printStackTrace();
                    z = false;
                }
                if (!z) {
                    iit.O00000o0 o00000o0 = iit.O000000o().O0000Oo;
                    if (o00000o0 != null) {
                        z2 = o00000o0.O000000o();
                    }
                    if (o00000o0 != null && !z2) {
                        if (O000000o(str2)) {
                            o00000o0.O00000o0();
                            throw XimalayaException.getExceptionByCode(1013);
                        }
                    }
                    if (!z2) {
                        if (iis.O0000OOo()) {
                            iis.O0000Oo0();
                        } else {
                            O00000Oo();
                        }
                    }
                }
                if ("POST".equals(request.method())) {
                    request2 = iiy.O00000Oo(str2, iit.O000000o(map), str).build();
                } else {
                    request2 = iiy.O000000o(str2, iit.O000000o(map), str).build();
                }
                ija ija2 = new ija(iiz.O000000o().O00000Oo(request2));
                if (ija2.f1355O000000o.code() == 200) {
                    return ija2.O000000o();
                }
                iit.O000000o();
                iiv O000000o3 = iit.O000000o(ija2);
                if (O000000o3 != null) {
                    if (!TextUtils.isEmpty(O000000o3.O00000Oo)) {
                        throw new XimalayaException(O000000o3.f1351O000000o, O000000o3.O00000Oo);
                    }
                }
                throw XimalayaException.getExceptionByCode(1009);
            }
            O000000o(request, map);
            if ("POST".equals(request.method())) {
                request3 = iiy.O00000Oo(str2, iit.O000000o(map), str).build();
            } else {
                request3 = iiy.O000000o(str2, iit.O000000o(map), str).build();
            }
            response = iiz.O000000o().O00000Oo(request3);
            ija ija3 = new ija(response);
            if (ija3.f1355O000000o.code() == 200) {
                return ija3.O000000o();
            }
            iit.O000000o();
            iiv O000000o4 = iit.O000000o(ija3);
            if (O000000o4 != null) {
                if (!TextUtils.isEmpty(O000000o4.O00000Oo)) {
                    throw new XimalayaException(O000000o4.f1351O000000o, O000000o4.O00000Oo);
                }
            }
            throw XimalayaException.getExceptionByCode(1009);
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (XimalayaException e3) {
        }
    }

    public static void O000000o(Request request, Map<String, String> map) {
        ijg.O000000o().O00000o0();
        if (request.url().toString().contains("http://api.ximalaya.com/openapi-gateway-app/tracks/get_play_info")) {
            int i = 3;
            while (i > 0) {
                try {
                    Response O00000Oo = iiz.O000000o().O00000Oo(iiy.O00000Oo("http://api.ximalaya.com/openapi-gateway-app/encrypt/exchange", iit.O000000o(new AccessTokenBaseCall$2(ilh.O000000o())), iit.O000000o().O00000Oo).build());
                    if (new ija(O00000Oo).f1355O000000o.code() == 200) {
                        ijg.O000000o().O000000o((ijm) new Gson().fromJson(O00000Oo.body().string(), ijm.class));
                        i = 0;
                    } else {
                        throw new Exception();
                    }
                } catch (Exception unused) {
                    i--;
                }
            }
            return;
        }
        map.put("c_pub_key", ilh.O000000o().publicKey.toString());
    }

    public static void O000000o(Request request, ijf ijf, Map<String, String> map, String str, String str2) {
        try {
            O00000Oo(str2);
            final ijf ijf2 = ijf;
            final Request request2 = request;
            final Map<String, String> map2 = map;
            final String str3 = str2;
            final String str4 = str;
            iiz.O000000o().O000000o(request, new ijf() {
                /* class _m_j.iir.AnonymousClass1 */

                /* JADX WARNING: Code restructure failed: missing block: B:21:0x006c, code lost:
                    r7 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:22:0x006f, code lost:
                    r7 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:64:0x014d, code lost:
                    if (android.text.TextUtils.isEmpty(r7.getMessage()) != false) goto L_0x014f;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:65:0x014f, code lost:
                    r2.O000000o(1011, com.ximalaya.ting.android.opensdk.httputil.XimalayaException.ERR_MESSAGE_MAP.get(1011));
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:66:0x0160, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:67:0x0161, code lost:
                    r2.O000000o(1011, r7.getMessage());
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:68:0x016a, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:69:0x016b, code lost:
                    r2.O000000o(r7.getErrorCode(), r7.getErrorMessage());
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
                    return;
                 */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Removed duplicated region for block: B:22:0x006f A[ExcHandler: XimalayaException (r7v24 'e' com.ximalaya.ting.android.opensdk.httputil.XimalayaException A[CUSTOM_DECLARE]), Splitter:B:24:0x0073] */
                public final void O000000o(Response response) {
                    boolean z;
                    Request request;
                    Request request2;
                    ija ija = new ija(response);
                    if (ija.f1355O000000o.code() == 200) {
                        ijf2.O000000o(response);
                        return;
                    }
                    iit.O000000o();
                    iiv O000000o2 = iit.O000000o(ija);
                    if (O000000o2 == null || TextUtils.isEmpty(O000000o2.O00000Oo)) {
                        ijf2.O000000o(1009, XimalayaException.ERR_MESSAGE_MAP.get(1009));
                    } else if ((O000000o2.f1351O000000o == 701 || O000000o2.f1351O000000o == 702) && (request2.url().toString().contains("http://api.ximalaya.com/openapi-gateway-app/encrypt/exchange") || request2.url().toString().contains("http://api.ximalaya.com/openapi-gateway-app/tracks/get_play_info"))) {
                        iir.O000000o(request2, map2);
                        if ("POST".equals(request2.method())) {
                            try {
                                request2 = iiy.O00000Oo(str3, iit.O000000o(map2), str4).build();
                            } catch (Exception unused) {
                                ijf2.O000000o(1002, XimalayaException.ERR_MESSAGE_MAP.get(1002));
                                return;
                            }
                        } else {
                            request2 = iiy.O000000o(str3, iit.O000000o(map2), str4).build();
                        }
                        Response response2 = null;
                        try {
                            response2 = iiz.O000000o().O00000Oo(request2);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        ija ija2 = new ija(response2);
                        if (ija2.f1355O000000o.code() == 200) {
                            ijf2.O000000o(response2);
                            return;
                        }
                        iit.O000000o();
                        iiv O000000o3 = iit.O000000o(ija2);
                        if (O000000o3 == null || TextUtils.isEmpty(O000000o3.O00000Oo)) {
                            ijf2.O000000o(1009, XimalayaException.ERR_MESSAGE_MAP.get(1009));
                        } else {
                            ijf2.O000000o(O000000o2.f1351O000000o, O000000o2.O00000Oo);
                        }
                    } else if (O000000o2.f1351O000000o == 206) {
                        boolean z2 = false;
                        try {
                            z = iir.O000000o();
                        } catch (IOException e2) {
                            try {
                                e2.printStackTrace();
                                z = false;
                            } catch (Exception unused2) {
                                ijf2.O000000o(1002, XimalayaException.ERR_MESSAGE_MAP.get(1002));
                                return;
                            } catch (XimalayaException e3) {
                            }
                        }
                        if (!z) {
                            iit.O00000o0 o00000o0 = iit.O000000o().O0000Oo;
                            if (o00000o0 != null) {
                                z2 = o00000o0.O000000o();
                            }
                            if (o00000o0 != null && !z2 && iir.O000000o(str3)) {
                                o00000o0.O00000o0();
                                ijf2.O000000o(1013, XimalayaException.ERR_MESSAGE_MAP.get(1013));
                                return;
                            } else if (!z2) {
                                if (iis.O0000OOo()) {
                                    iis.O0000Oo0();
                                } else {
                                    iir.O00000Oo();
                                }
                            }
                        }
                        if ("POST".equals(request2.method())) {
                            request = iiy.O00000Oo(str3, iit.O000000o(map2), str4).build();
                        } else {
                            request = iiy.O000000o(str3, iit.O000000o(map2), str4).build();
                        }
                        Response O00000Oo2 = iiz.O000000o().O00000Oo(request);
                        ija ija3 = new ija(O00000Oo2);
                        if (ija3.f1355O000000o.code() == 200) {
                            ijf2.O000000o(O00000Oo2);
                            return;
                        }
                        iit.O000000o();
                        iiv O000000o4 = iit.O000000o(ija3);
                        if (O000000o4 != null) {
                            if (!TextUtils.isEmpty(O000000o4.O00000Oo)) {
                                ijf2.O000000o(O000000o4.f1351O000000o, O000000o4.O00000Oo);
                                return;
                            }
                        }
                        ijf2.O000000o(1009, XimalayaException.ERR_MESSAGE_MAP.get(1009));
                    } else {
                        if (O000000o2.f1351O000000o == 604) {
                            O000000o2.f1351O000000o = 3;
                        }
                        ijf2.O000000o(O000000o2.f1351O000000o, O000000o2.O00000Oo);
                    }
                }

                public final void O000000o(int i, String str) {
                    ijf2.O000000o(i, str);
                }
            });
        } catch (XimalayaException e) {
            e.printStackTrace();
            ijf.O000000o(1014, XimalayaException.ERR_MESSAGE_MAP.get(1014));
        }
    }

    public static boolean O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = f1321O000000o.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static void O00000Oo(String str) throws XimalayaException {
        if (!TextUtils.isEmpty(str)) {
            Iterator<String> it = f1321O000000o.iterator();
            boolean isEmpty = TextUtils.isEmpty(iis.O000000o().O00000oo());
            while (it.hasNext()) {
                if (str.contains(it.next())) {
                    if (isEmpty && iit.O000000o().O0000Oo != null) {
                        iit.O000000o().O0000Oo.O00000o0();
                        throw XimalayaException.getExceptionByCode(1013);
                    }
                    return;
                }
            }
        }
    }

    public static boolean O000000o() throws IOException {
        ilp O000000o2 = ilp.O000000o(iis.O000000o().O00000Oo);
        if (O000000o2.O0000O0o("simple_sso_code")) {
            String O00000o0 = O000000o2.O00000o0("simple_sso_code");
            String O00000o = iit.O00000o(new AccessTokenBaseCall$4(O00000o0, O000000o2));
            if (!TextUtils.isEmpty(O00000o)) {
                try {
                    Bundle bundle = (Bundle) Class.forName("com.ximalaya.ting.android.opensdk.auth.utils.Utility").getDeclaredMethod("parseUrl", String.class).invoke(null, O00000o);
                    if (bundle != null && bundle.containsKey("access_token") && !TextUtils.isEmpty(O000000o(bundle, "access_token", ""))) {
                        String O000000o3 = O000000o(bundle, "expires_in", "");
                        long j = 0;
                        if (!TextUtils.isEmpty(O000000o3) && !O000000o3.equals("0")) {
                            j = System.currentTimeMillis() + (Long.parseLong(O000000o3) * 1000);
                        }
                        iis.O000000o().O000000o(O000000o(bundle, "access_token", ""), j, O00000o0.split("&")[0]);
                        return true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    private static String O000000o(Bundle bundle, String str, String str2) {
        String string;
        return (bundle == null || (string = bundle.getString(str)) == null) ? str2 : string;
    }

    public static void O00000Oo() throws XimalayaException {
        try {
            iis.O000000o();
            Response response = null;
            try {
                response = iiz.O000000o().O00000Oo(iiy.O00000Oo("http://api.ximalaya.com/oauth2/secure_access_token", iis.O00000Oo()).build());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (response == null) {
                throw XimalayaException.getExceptionByCode(1010);
            } else if (new ija(response).f1355O000000o.code() == 200) {
                try {
                    JSONObject jSONObject = new JSONObject(response.body().string());
                    iis.O000000o().O000000o(jSONObject.optString("access_token"), jSONObject.optLong("expires_in"));
                } catch (Exception unused) {
                    throw XimalayaException.getExceptionByCode(1009);
                }
            } else {
                throw XimalayaException.getExceptionByCode(1010);
            }
        } catch (Exception unused2) {
            throw XimalayaException.getExceptionByCode(1010);
        }
    }
}

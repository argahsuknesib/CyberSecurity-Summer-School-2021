package com.facebook.applinks;

import _m_j.ki;
import _m_j.ko;
import _m_j.kq;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookAppLinkResolver {
    public final HashMap<Uri, ki> cachedAppLinks = new HashMap<>();

    public kq<ki> getAppLinkFromUrlInBackground(final Uri uri) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(uri);
        kq<Map<Uri, ki>> appLinkFromUrlsInBackground = getAppLinkFromUrlsInBackground(arrayList);
        AnonymousClass1 r1 = new ko<Map<Uri, ki>, ki>() {
            /* class com.facebook.applinks.FacebookAppLinkResolver.AnonymousClass1 */

            public ki then(kq<Map<Uri, ki>> kqVar) throws Exception {
                return (ki) kqVar.O00000oO().get(uri);
            }
        };
        return appLinkFromUrlsInBackground.O000000o(new ko<TResult, kq<TContinuationResult>>(null, r1) {
            /* class _m_j.kq.AnonymousClass3 */

            /* renamed from: O000000o */
            final /* synthetic */ kk f2147O000000o = null;
            final /* synthetic */ ko O00000Oo;

            {
                this.O00000Oo = r3;
            }

            public final /* synthetic */ Object then(kq kqVar) {
                kk kkVar = this.f2147O000000o;
                if (kkVar != null && kkVar.f2139O000000o.O000000o()) {
                    return kq.O0000O0o();
                }
                if (kqVar.O00000o()) {
                    return kq.O000000o(kqVar.O00000oo());
                }
                if (kqVar.O00000o0()) {
                    return kq.O0000O0o();
                }
                return kqVar.O000000o(this.O00000Oo);
            }
        }, kq.O00000Oo);
    }

    public kq<Map<Uri, ki>> getAppLinkFromUrlsInBackground(List<Uri> list) {
        ki kiVar;
        final HashMap hashMap = new HashMap();
        final HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (Uri next : list) {
            synchronized (this.cachedAppLinks) {
                kiVar = this.cachedAppLinks.get(next);
            }
            if (kiVar != null) {
                hashMap.put(next, kiVar);
            } else {
                if (!hashSet.isEmpty()) {
                    sb.append(',');
                }
                sb.append(next.toString());
                hashSet.add(next);
            }
        }
        if (hashSet.isEmpty()) {
            return kq.O000000o(hashMap);
        }
        final kq<TResult>.O000000o O00000Oo = kq.O00000Oo();
        Bundle bundle = new Bundle();
        bundle.putString("ids", sb.toString());
        bundle.putString("fields", String.format("%s.fields(%s,%s)", "app_links", "android", "web"));
        new GraphRequest(AccessToken.getCurrentAccessToken(), "", bundle, null, new GraphRequest.Callback() {
            /* class com.facebook.applinks.FacebookAppLinkResolver.AnonymousClass2 */

            public void onCompleted(GraphResponse graphResponse) {
                FacebookRequestError error = graphResponse.getError();
                if (error != null) {
                    O00000Oo.O000000o((Exception) error.getException());
                    return;
                }
                JSONObject jSONObject = graphResponse.getJSONObject();
                if (jSONObject == null) {
                    O00000Oo.O000000o(hashMap);
                    return;
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    Uri uri = (Uri) it.next();
                    if (jSONObject.has(uri.toString())) {
                        try {
                            JSONObject jSONObject2 = jSONObject.getJSONObject(uri.toString()).getJSONObject("app_links");
                            JSONArray jSONArray = jSONObject2.getJSONArray("android");
                            int length = jSONArray.length();
                            ArrayList arrayList = new ArrayList(length);
                            for (int i = 0; i < length; i++) {
                                ki.O000000o androidTargetFromJson = FacebookAppLinkResolver.getAndroidTargetFromJson(jSONArray.getJSONObject(i));
                                if (androidTargetFromJson != null) {
                                    arrayList.add(androidTargetFromJson);
                                }
                            }
                            ki kiVar = new ki(uri, arrayList, FacebookAppLinkResolver.getWebFallbackUriFromJson(uri, jSONObject2));
                            hashMap.put(uri, kiVar);
                            synchronized (FacebookAppLinkResolver.this.cachedAppLinks) {
                                FacebookAppLinkResolver.this.cachedAppLinks.put(uri, kiVar);
                            }
                        } catch (JSONException unused) {
                        }
                    }
                }
                O00000Oo.O000000o(hashMap);
            }
        }).executeAsync();
        return O00000Oo.O00000Oo;
    }

    public static ki.O000000o getAndroidTargetFromJson(JSONObject jSONObject) {
        Uri uri = null;
        String tryGetStringFromJson = tryGetStringFromJson(jSONObject, "package", null);
        if (tryGetStringFromJson == null) {
            return null;
        }
        String tryGetStringFromJson2 = tryGetStringFromJson(jSONObject, "class", null);
        String tryGetStringFromJson3 = tryGetStringFromJson(jSONObject, "app_name", null);
        String tryGetStringFromJson4 = tryGetStringFromJson(jSONObject, "url", null);
        if (tryGetStringFromJson4 != null) {
            uri = Uri.parse(tryGetStringFromJson4);
        }
        return new ki.O000000o(tryGetStringFromJson, tryGetStringFromJson2, uri, tryGetStringFromJson3);
    }

    public static Uri getWebFallbackUriFromJson(Uri uri, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("web");
            Uri uri2 = null;
            if (!tryGetBooleanFromJson(jSONObject2, "should_fallback", true)) {
                return null;
            }
            String tryGetStringFromJson = tryGetStringFromJson(jSONObject2, "url", null);
            if (tryGetStringFromJson != null) {
                uri2 = Uri.parse(tryGetStringFromJson);
            }
            return uri2 != null ? uri2 : uri;
        } catch (JSONException unused) {
        }
    }

    private static String tryGetStringFromJson(JSONObject jSONObject, String str, String str2) {
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return str2;
        }
    }

    private static boolean tryGetBooleanFromJson(JSONObject jSONObject, String str, boolean z) {
        try {
            return jSONObject.getBoolean(str);
        } catch (JSONException unused) {
            return z;
        }
    }
}

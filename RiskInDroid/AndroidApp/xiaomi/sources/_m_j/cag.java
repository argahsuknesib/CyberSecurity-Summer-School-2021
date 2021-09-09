package _m_j;

import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.mi.global.shop.model.SyncModel;
import org.json.JSONObject;

public final class cag {

    /* renamed from: O000000o  reason: collision with root package name */
    public Object f13515O000000o;
    public RetryPolicy O00000Oo;
    private cah O00000o0;

    public cag(String[] strArr, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this(0, strArr, listener, errorListener);
    }

    private cag(int i, String[] strArr, final Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this.O00000o0 = new cah(0, strArr[0], null, new Response.Listener<JSONObject>() {
            /* class _m_j.cag.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ void onResponse(Object obj) {
                listener.onResponse((JSONObject) obj);
            }
        }, new Response.ErrorListener(strArr, null, listener, errorListener) {
            /* class _m_j.cag.AnonymousClass2 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ String[] f13517O000000o;
            final /* synthetic */ String O00000Oo = null;
            final /* synthetic */ Response.ErrorListener O00000o;
            final /* synthetic */ Response.Listener O00000o0;

            {
                this.f13517O000000o = r2;
                this.O00000o0 = r4;
                this.O00000o = r5;
            }

            public final void onErrorResponse(VolleyError volleyError) {
                if (volleyError.networkResponse != null && volleyError.networkResponse.statusCode == 302) {
                    String[] strArr = this.f13517O000000o;
                    if (strArr.length > 1) {
                        cah cah = new cah(0, strArr[1], this.O00000Oo, new Response.Listener<JSONObject>() {
                            /* class _m_j.cag.AnonymousClass2.AnonymousClass1 */

                            public final /* synthetic */ void onResponse(Object obj) {
                                AnonymousClass2.this.O00000o0.onResponse((JSONObject) obj);
                                if (AnonymousClass2.this.f13517O000000o[1].startsWith("https")) {
                                    SyncModel.useHttps = true;
                                } else {
                                    SyncModel.useHttps = false;
                                }
                            }
                        }, new Response.ErrorListener() {
                            /* class _m_j.cag.AnonymousClass2.AnonymousClass2 */

                            public final void onErrorResponse(VolleyError volleyError) {
                                AnonymousClass2.this.O00000o.onErrorResponse(volleyError);
                            }
                        });
                        cah.setTag(cag.this.f13515O000000o);
                        ced.f13683O000000o.add(cah);
                        return;
                    }
                }
                this.O00000o.onErrorResponse(volleyError);
            }
        });
    }

    public final void O000000o() {
        RetryPolicy retryPolicy = this.O00000Oo;
        if (retryPolicy != null) {
            this.O00000o0.setRetryPolicy(retryPolicy);
        }
        Object obj = this.f13515O000000o;
        if (obj != null) {
            this.O00000o0.setTag(obj);
        }
        ced.f13683O000000o.add(this.O00000o0);
    }
}

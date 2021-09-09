package _m_j;

import a.a.a.e.c.g;
import a.a.a.f.d.b;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.mi.global.shop.activity.WebActivity;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.user.exchangecoupon.coupon.NewOTExResult;
import com.xiaomi.smarthome.R;
import in.cashify.otex.ExchangeError;
import in.cashify.otex.ExchangeManager;
import in.cashify.otex.ExchangeSetup;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bzh extends can implements ExchangeManager.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f13466O000000o = "bzh";
    private DefaultRetryPolicy O00000Oo = new DefaultRetryPolicy(20000, 1, 1.0f);
    private ExchangeSetup O00000o;
    private View O00000o0;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.O00000o0 = layoutInflater.inflate((int) R.layout.shop_fragment_otex, viewGroup, false);
        return this.O00000o0;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O00000o = new ExchangeSetup();
        this.O00000o.O00000Oo = 122001;
        irc.O000000o(getChildFragmentManager(), (LinearLayout) view.findViewById(R.id.layout_group), f13466O000000o, this.O00000o);
    }

    public final void O000000o(String str, String str2) {
        String str3 = f13466O000000o;
        Log.d(str3, "-----onRegistrationRequest-----" + str + "---" + str2);
        final String str4 = str;
        final String str5 = str2;
        AnonymousClass3 r2 = new StringRequest(cav.O000o0OO(), new Response.Listener<String>() {
            /* class _m_j.bzh.AnonymousClass1 */

            /* JADX WARNING: Can't wrap try/catch for region: R(3:18|19|(2:21|22)(1:32)) */
            /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
                r1 = new org.json.JSONObject(r4);
                r2 = new _m_j.ird(r1.getString("mssg"), r1.getInt("error"));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
                if (r0.O00000Oo != null) goto L_0x0072;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0072, code lost:
                r0.O00000Oo.O000000o(r2);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x0077, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0078, code lost:
                r4 = r0.O00000Oo;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x007b, code lost:
                if (r4 != null) goto L_0x007d;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:26:0x007d, code lost:
                r4.O000000o(new _m_j.ird(in.cashify.otex.ExchangeError.Kind.INVALID_RESPONSE));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
                return;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0058 */
            public final /* synthetic */ void onResponse(Object obj) {
                String str = (String) obj;
                ExchangeManager exchangeManager = (ExchangeManager) bzh.this.getChildFragmentManager().O000000o(bzh.f13466O000000o);
                if (exchangeManager == null) {
                    return;
                }
                if (TextUtils.isEmpty(str)) {
                    exchangeManager.O00000Oo.O000000o(new ird(ExchangeError.Kind.INVALID_RESPONSE));
                    return;
                }
                b bVar = new b(str);
                exchangeManager.O00000o.clear();
                List<g> list = bVar.f2623O000000o;
                if (list != null && !list.isEmpty()) {
                    exchangeManager.O00000o.addAll(list);
                }
                ExchangeManager.O000000o(exchangeManager.O00000o);
                FragmentActivity activity = exchangeManager.getActivity();
                if (activity != null && exchangeManager.isAdded()) {
                    activity.runOnUiThread(new ExchangeManager.O00000o0());
                }
            }
        }, new Response.ErrorListener() {
            /* class _m_j.bzh.AnonymousClass2 */

            public final void onErrorResponse(VolleyError volleyError) {
                bzh.this.O00000Oo("");
            }
        }) {
            /* class _m_j.bzh.AnonymousClass3 */

            public final Map<String, String> getParams() throws AuthFailureError {
                HashMap hashMap = new HashMap(2);
                hashMap.put("_k", str4);
                hashMap.put("_d", str5);
                return hashMap;
            }
        };
        r2.setTag(f13466O000000o);
        ced.f13683O000000o.add(r2);
    }

    public final void O00000Oo(String str, String str2) {
        String str3 = f13466O000000o;
        Log.d(str3, "onQuoteRequest" + str + "---" + str2);
        final String str4 = str;
        final String str5 = str2;
        AnonymousClass5 r2 = new cal(cav.O000o0Oo(), NewOTExResult.class, new cak<NewOTExResult>() {
            /* class _m_j.bzh.AnonymousClass4 */

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                NewOTExResult newOTExResult = (NewOTExResult) baseResult;
                if (newOTExResult != null) {
                    bzh.this.O00000Oo(newOTExResult.quote_id);
                } else {
                    bzh.this.O00000Oo("");
                }
            }

            public final void O000000o(String str) {
                bzh.this.O00000Oo("");
            }
        }) {
            /* class _m_j.bzh.AnonymousClass5 */

            public final Map<String, String> getParams() throws AuthFailureError {
                HashMap hashMap = new HashMap(2);
                hashMap.put("_k", str4);
                hashMap.put("_d", str5);
                return hashMap;
            }

            public final Map<String, String> getHeaders() throws AuthFailureError {
                return new HashMap(1);
            }
        };
        r2.setTag(f13466O000000o);
        r2.setRetryPolicy(this.O00000Oo);
        ced.f13683O000000o.add(r2);
    }

    public final void O000000o(ird ird) {
        String str = f13466O000000o;
        Log.d(str, "onExchangeSetup" + ird.toString());
        ExchangeError.Kind kind = ird.O00000Oo;
        int[] iArr = AnonymousClass6.f13472O000000o;
        kind.ordinal();
        O00000Oo("");
    }

    public final void O000000o(int i, String str, String str2) {
        String str3 = f13466O000000o;
        Log.d(str3, "onTestComplete" + i + "---" + str + "---" + str2);
    }

    public final void O000000o(String str) {
        Log.d(f13466O000000o, "onTestStart".concat(String.valueOf(str)));
    }

    /* renamed from: _m_j.bzh$6  reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f13472O000000o = new int[ExchangeError.Kind.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|(3:15|16|18)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f13472O000000o[ExchangeError.Kind.ROOTED_DEVICE_NOT_SUPPORTED.ordinal()] = 1;
            f13472O000000o[ExchangeError.Kind.EMULATOR_NOT_SUPPORTED.ordinal()] = 2;
            f13472O000000o[ExchangeError.Kind.DEVICE_NOT_SUPPORTED.ordinal()] = 3;
            f13472O000000o[ExchangeError.Kind.DEVICE_NOT_ELIGIBLE.ordinal()] = 4;
            f13472O000000o[ExchangeError.Kind.EXCHANGE_NOT_VALID.ordinal()] = 5;
            f13472O000000o[ExchangeError.Kind.SERVER_ERROR.ordinal()] = 6;
            f13472O000000o[ExchangeError.Kind.INVALID_PIN_CODE.ordinal()] = 7;
            try {
                f13472O000000o[ExchangeError.Kind.PERMISSION_NOT_GRANTED.ordinal()] = 8;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final void O00000Oo(String str) {
        if (O0000O0o()) {
            irc.O000000o(getChildFragmentManager(), f13466O000000o);
            Intent intent = new Intent(getActivity(), WebActivity.class);
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("url", cav.O000o0o0() + "qid=" + str);
            } else {
                intent.putExtra("url", cav.O000o0oo());
                cec.O000000o(getActivity(), getString(R.string.user_exchange_sdk_fail), 1);
            }
            startActivity(intent);
            getActivity().finish();
        }
    }
}

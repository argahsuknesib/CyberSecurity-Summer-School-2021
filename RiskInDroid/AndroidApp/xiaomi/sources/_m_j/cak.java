package _m_j;

import com.android.volley.NetworkError;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.usercenter.NewUserInfoResult;
import com.mi.multimonitor.CrashReport;
import com.xiaomi.smarthome.R;

public abstract class cak<T extends BaseResult> implements Response.ErrorListener, Response.Listener<T> {
    public abstract void O000000o(BaseResult baseResult);

    /* renamed from: O00000Oo */
    public void onResponse(T t) {
        if (t == null) {
            O000000o(byl.O00000oO().getString(R.string.shop_service_unavailiable));
            return;
        }
        if (t.errno == 20001 && !(t instanceof NewUserInfoResult) && !byl.O0000O0o.O00000oo.equals("community_sdk")) {
            byl.O00000Oo();
        }
        if (t.errno != 0) {
            O000000o(t.errmsg);
        } else {
            O000000o((BaseResult) t);
        }
    }

    public void onErrorResponse(VolleyError volleyError) {
        if (volleyError instanceof NetworkError) {
            O000000o(byl.O00000oO().getString(R.string.shop_network_unavaliable));
        } else if ((volleyError instanceof ServerError) || (volleyError instanceof TimeoutError) || !(volleyError instanceof ParseError)) {
            O000000o(byl.O00000oO().getString(R.string.shop_service_unavailiable));
        } else {
            O000000o(byl.O00000oO().getString(R.string.shop_service_unavailiable));
            if (!cad.O0000o0()) {
                CrashReport.postCrash(Thread.currentThread(), volleyError);
            }
        }
        if (byl.O0000OOo()) {
            volleyError.printStackTrace();
        }
    }

    public void O000000o(String str) {
        cec.O000000o(byl.O00000oO(), str, 0);
    }
}

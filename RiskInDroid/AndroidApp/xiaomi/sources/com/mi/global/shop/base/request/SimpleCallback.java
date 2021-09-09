package com.mi.global.shop.base.request;

import _m_j.bym;
import _m_j.byn;
import _m_j.cec;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.xiaomi.smarthome.R;

public abstract class SimpleCallback<T extends byn> implements Response.ErrorListener, Response.Listener<T> {
    public abstract void success(T t);

    public void onResponse(byn byn) {
        if (byn == null) {
            error(bym.f13411O000000o.getString(R.string.service_unavailiable));
        } else if (byn.errno != 0) {
            error(byn.errmsg);
        } else {
            try {
                success(byn);
            } catch (Exception e) {
                error(e.toString());
            }
        }
    }

    public void onErrorResponse(VolleyError volleyError) {
        volleyError.printStackTrace();
        if (volleyError instanceof NetworkError) {
            error(bym.f13411O000000o.getString(R.string.network_unavaliable));
        } else {
            error(bym.f13411O000000o.getString(R.string.service_unavailiable));
        }
        if (bym.O00000Oo) {
            volleyError.printStackTrace();
        }
    }

    public void error(String str) {
        cec.O000000o(bym.f13411O000000o, str, 0);
    }
}

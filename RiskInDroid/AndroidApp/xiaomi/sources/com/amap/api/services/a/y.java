package com.amap.api.services.a;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class y extends k<InputtipsQuery, ArrayList<Tip>> {
    public y(Context context, InputtipsQuery inputtipsQuery) {
        super(context, inputtipsQuery);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public ArrayList<Tip> a(String str) throws AMapException {
        try {
            return z.m(new JSONObject(str));
        } catch (JSONException e) {
            s.a(e, "InputtipsHandler", "paseJSON");
            return null;
        }
    }

    public String i() {
        return r.a() + "/assistant/inputtips?";
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String c = c(((InputtipsQuery) this.f3422a).getKeyword());
        if (!TextUtils.isEmpty(c)) {
            stringBuffer.append("&keywords=");
            stringBuffer.append(c);
        }
        String city = ((InputtipsQuery) this.f3422a).getCity();
        if (!z.i(city)) {
            String c2 = c(city);
            stringBuffer.append("&city=");
            stringBuffer.append(c2);
        }
        String type = ((InputtipsQuery) this.f3422a).getType();
        if (!z.i(type)) {
            String c3 = c(type);
            stringBuffer.append("&type=");
            stringBuffer.append(c3);
        }
        if (((InputtipsQuery) this.f3422a).getCityLimit()) {
            stringBuffer.append("&citylimit=true");
        } else {
            stringBuffer.append("&citylimit=false");
        }
        LatLonPoint location = ((InputtipsQuery) this.f3422a).getLocation();
        if (location != null) {
            stringBuffer.append("&location=");
            stringBuffer.append(location.getLongitude());
            stringBuffer.append(",");
            stringBuffer.append(location.getLatitude());
        }
        stringBuffer.append("&key=");
        stringBuffer.append(bp.f(this.d));
        return stringBuffer.toString();
    }
}

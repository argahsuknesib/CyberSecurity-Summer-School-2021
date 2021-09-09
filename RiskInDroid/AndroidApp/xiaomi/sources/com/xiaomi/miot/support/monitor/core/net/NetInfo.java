package com.xiaomi.miot.support.monitor.core.net;

import _m_j.dxr;
import _m_j.dya;
import _m_j.dzf;
import android.text.TextUtils;
import com.xiaomi.miot.support.monitor.core.BaseInfo;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class NetInfo extends BaseInfo {
    public int back_type;
    public long costTime;
    public int errorCode;
    public boolean isWifi;
    public long receivedBytes;
    public long sentBytes;
    public long startTime;
    public int statusCode;
    public String url;

    private NetInfo() {
        this.url = "";
        this.sentBytes = 0;
        this.receivedBytes = 0;
        this.startTime = 0;
        this.costTime = 0;
        this.isWifi = false;
        this.statusCode = 0;
        this.errorCode = 0;
        this.back_type = -1;
        this.mId = -1;
        this.startTime = System.currentTimeMillis();
    }

    public NetInfo(byte b) {
        this();
    }

    public final JSONObject O000000o() throws JSONException {
        return super.O000000o().put("u", this.url).put("sc", this.statusCode).put("ec", this.errorCode).put("sb", this.sentBytes).put("rb", this.receivedBytes).put("w", this.isWifi).put("t", this.startTime).put("tc", this.costTime);
    }

    public final void O00000Oo() {
        if (this.startTime != 0) {
            if (this.costTime == 0) {
                this.costTime = System.currentTimeMillis() - this.startTime;
            }
            if (this.costTime <= 15000) {
                int i = this.back_type;
                int i2 = 1;
                if (!(i == 1 || i == 2)) {
                    if (!dzf.O000000o(dxr.O000000o.f15041O000000o.O00000Oo)) {
                        i2 = 2;
                    }
                    this.back_type = i2;
                }
                dya.O000000o.f15057O000000o.O000000o("http", this);
            }
        }
    }

    public final void O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.sentBytes = (long) str.getBytes().length;
            this.url = O00000Oo(str);
        }
    }

    private static String O00000Oo(String str) {
        String str2;
        try {
            URL url2 = new URL(str);
            if (url2.getPort() == -1) {
                str2 = "";
            } else {
                str2 = ":" + url2.getPort();
            }
            return TextUtils.concat(url2.getProtocol(), "://", url2.getHost(), str2, url2.getPath()).toString();
        } catch (MalformedURLException unused) {
            return null;
        }
    }
}

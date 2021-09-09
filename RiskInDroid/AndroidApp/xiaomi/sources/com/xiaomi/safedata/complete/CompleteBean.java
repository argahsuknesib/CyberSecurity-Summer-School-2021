package com.xiaomi.safedata.complete;

import android.util.Log;
import com.xiaomi.safedata.base.BaseBean;
import org.json.JSONObject;

public class CompleteBean extends BaseBean {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f6614O000000o = "CompleteBean";
    public String apkSHA1;
    public String fileCRC32;
    public String signMD5;
    public String signSHA1;

    public final JSONObject O000000o() {
        try {
            this.jsonObject.put("signMD5", O000000o(this.signMD5));
            this.jsonObject.put("signSHA1", O000000o(this.signSHA1));
            this.jsonObject.put("fileCRC32", O000000o(this.fileCRC32));
            this.jsonObject.put("apkSHA1", O000000o(this.apkSHA1));
        } catch (Exception e) {
            Log.e(f6614O000000o, e.toString());
        }
        return super.O000000o();
    }
}

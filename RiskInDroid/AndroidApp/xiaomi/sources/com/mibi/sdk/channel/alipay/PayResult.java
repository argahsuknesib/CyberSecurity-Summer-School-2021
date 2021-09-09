package com.mibi.sdk.channel.alipay;

import android.text.TextUtils;
import java.util.Map;

public class PayResult {
    private String memo;
    private String result;
    private String resultStatus;

    public PayResult(Map<String, String> map) {
        if (map != null) {
            for (String next : map.keySet()) {
                if (TextUtils.equals(next, "resultStatus")) {
                    this.resultStatus = map.get(next);
                } else if (TextUtils.equals(next, "result")) {
                    this.result = map.get(next);
                } else if (TextUtils.equals(next, "memo")) {
                    this.memo = map.get(next);
                }
            }
        }
    }

    public String toString() {
        return "resultStatus={" + this.resultStatus + "};memo={" + this.memo + "};result={" + this.result + "}";
    }

    public String getResultStatus() {
        return this.resultStatus;
    }

    public String getMemo() {
        return this.memo;
    }

    public String getResult() {
        return this.result;
    }
}

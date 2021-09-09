package com.mi.global.shop.loader;

import com.xiaomi.smarthome.R;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseResult {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Map<ResultStatus, Integer> f4888O000000o;

    public enum ResultStatus {
        NETWROK_ERROR,
        SERVICE_ERROR,
        DATA_ERROR,
        AUTH_ERROR,
        OK,
        CLOSED
    }

    static {
        HashMap hashMap = new HashMap();
        f4888O000000o = hashMap;
        hashMap.put(ResultStatus.NETWROK_ERROR, Integer.valueOf((int) R.string.shop_network_unavaliable));
        f4888O000000o.put(ResultStatus.SERVICE_ERROR, Integer.valueOf((int) R.string.shop_service_unavailiable));
        f4888O000000o.put(ResultStatus.DATA_ERROR, Integer.valueOf((int) R.string.shop_data_error));
        f4888O000000o.put(ResultStatus.AUTH_ERROR, Integer.valueOf((int) R.string.shop_auth_error));
    }

    public static int O000000o(ResultStatus resultStatus) {
        return f4888O000000o.get(resultStatus).intValue();
    }
}

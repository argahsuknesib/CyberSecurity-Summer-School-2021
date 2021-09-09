package com.payu.sdk;

import _m_j.byl;

public class Constants {
    public static final boolean DEBUG;
    public static final String FETCH_DATA_URL;
    public static final String PAYMENT_URL = (DEBUG ? "https://test.payu.in/_payment" : "https://secure.payu.in/_payment");

    static {
        boolean O0000OOo = byl.O0000OOo();
        DEBUG = O0000OOo;
        FETCH_DATA_URL = O0000OOo ? "https://mobiletest.payu.in/merchant/postservice?form=2" : "https://info.payu.in/merchant/postservice.php?form=2";
    }
}

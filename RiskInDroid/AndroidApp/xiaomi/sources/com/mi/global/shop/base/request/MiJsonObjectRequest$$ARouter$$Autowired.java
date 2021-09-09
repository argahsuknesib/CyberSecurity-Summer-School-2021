package com.mi.global.shop.base.request;

import _m_j.ny;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.mi.global.shop.base.service.CookieUtilService;
import com.mi.global.shop.base.service.LoginManagerService;

public class MiJsonObjectRequest$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    public void inject(Object obj) {
        ny.O000000o();
        this.serializationService = (SerializationService) ny.O000000o(SerializationService.class);
        MiJsonObjectRequest miJsonObjectRequest = (MiJsonObjectRequest) obj;
        ny.O000000o();
        miJsonObjectRequest.cookieUtilService = (CookieUtilService) ny.O000000o(CookieUtilService.class);
        ny.O000000o();
        miJsonObjectRequest.loginManagerService = (LoginManagerService) ny.O000000o(LoginManagerService.class);
    }
}

package com.mi.global.shop.base;

import _m_j.ny;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.mi.global.shop.base.service.ConnectionHelperService;
import com.mi.global.shop.base.service.LoginManagerService;
import com.mi.global.shop.base.service.MiPushClientService;
import com.mi.global.shop.base.service.WebViewCookieManagerService;

public class BaseActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    public void inject(Object obj) {
        ny.O000000o();
        this.serializationService = (SerializationService) ny.O000000o(SerializationService.class);
        BaseActivity baseActivity = (BaseActivity) obj;
        ny.O000000o();
        baseActivity.loginManagerService = (LoginManagerService) ny.O000000o(LoginManagerService.class);
        ny.O000000o();
        baseActivity.connectionHelperService = (ConnectionHelperService) ny.O000000o(ConnectionHelperService.class);
        ny.O000000o();
        baseActivity.webViewCookieManagerService = (WebViewCookieManagerService) ny.O000000o(WebViewCookieManagerService.class);
        ny.O000000o();
        baseActivity.miPushClientService = (MiPushClientService) ny.O000000o(MiPushClientService.class);
    }
}

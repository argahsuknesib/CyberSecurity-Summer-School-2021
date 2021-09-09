package com.mi.global.shop.base.request;

import _m_j.ny;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.mi.global.shop.base.service.AppVersionService;
import com.mi.global.shop.base.service.CookieUtilService;
import com.mi.global.shop.base.service.GlobalConfigService;
import com.mi.global.shop.base.service.LocaleService;

public class SimpleProtobufRequest$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    public void inject(Object obj) {
        ny.O000000o();
        this.serializationService = (SerializationService) ny.O000000o(SerializationService.class);
        ny.O000000o();
        ((SimpleProtobufRequest) obj).cookieUtilService = (CookieUtilService) ny.O000000o(CookieUtilService.class);
        ny.O000000o();
        SimpleProtobufRequest.localeService = (LocaleService) ny.O000000o(LocaleService.class);
        ny.O000000o();
        SimpleProtobufRequest.globalConfigService = (GlobalConfigService) ny.O000000o(GlobalConfigService.class);
        ny.O000000o();
        SimpleProtobufRequest.appVersionService = (AppVersionService) ny.O000000o(AppVersionService.class);
    }
}

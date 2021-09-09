package com.mi.global.shop.feature.search;

import _m_j.ny;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.mi.global.shop.base.service.LocaleService;

public class SearchResultListAdapter$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    public void inject(Object obj) {
        ny.O000000o();
        this.serializationService = (SerializationService) ny.O000000o(SerializationService.class);
        ny.O000000o();
        ((SearchResultListAdapter) obj).localeService = (LocaleService) ny.O000000o(LocaleService.class);
    }
}

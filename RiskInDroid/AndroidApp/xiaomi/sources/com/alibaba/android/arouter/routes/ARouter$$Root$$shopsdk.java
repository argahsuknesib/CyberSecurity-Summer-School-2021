package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import java.util.Map;

public class ARouter$$Root$$shopsdk implements IRouteRoot {
    public void loadInto(Map<String, Class<? extends IRouteGroup>> map) {
        map.put("globalShop", ARouter$$Group$$globalShop.class);
        map.put("shopSdk", ARouter$$Group$$shopSdk.class);
    }
}

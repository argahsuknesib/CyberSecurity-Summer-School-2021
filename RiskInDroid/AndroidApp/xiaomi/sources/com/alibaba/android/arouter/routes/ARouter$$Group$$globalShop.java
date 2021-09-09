package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.mi.global.shop.activity.WebActivity;
import java.util.Map;

public class ARouter$$Group$$globalShop implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/globalShop/webActivity", RouteMeta.build(RouteType.ACTIVITY, WebActivity.class, "/globalshop/webactivity", "globalshop", null, -1, Integer.MIN_VALUE));
    }
}

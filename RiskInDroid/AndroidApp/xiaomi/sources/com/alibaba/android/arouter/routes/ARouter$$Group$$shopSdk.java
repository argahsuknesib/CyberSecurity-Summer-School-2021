package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.mi.global.shop.componentService.AppVersionServiceImpl;
import com.mi.global.shop.componentService.ConnectionHelperServiceImpl;
import com.mi.global.shop.componentService.CookieUtilServiceImpl;
import com.mi.global.shop.componentService.GlobalConfigServiceImpl;
import com.mi.global.shop.componentService.LocaleServiceImpl;
import com.mi.global.shop.componentService.LoginManagerServiceImpl;
import com.mi.global.shop.componentService.WebViewCookieManagerServiceImpl;
import java.util.Map;

public class ARouter$$Group$$shopSdk implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/shopSdk/AppVersionService", RouteMeta.build(RouteType.PROVIDER, AppVersionServiceImpl.class, "/shopsdk/appversionservice", "shopsdk", null, -1, Integer.MIN_VALUE));
        map.put("/shopSdk/ConnectionHelperService", RouteMeta.build(RouteType.PROVIDER, ConnectionHelperServiceImpl.class, "/shopsdk/connectionhelperservice", "shopsdk", null, -1, Integer.MIN_VALUE));
        map.put("/shopSdk/CookieUtilService", RouteMeta.build(RouteType.PROVIDER, CookieUtilServiceImpl.class, "/shopsdk/cookieutilservice", "shopsdk", null, -1, Integer.MIN_VALUE));
        map.put("/shopSdk/GlobalConfigService", RouteMeta.build(RouteType.PROVIDER, GlobalConfigServiceImpl.class, "/shopsdk/globalconfigservice", "shopsdk", null, -1, Integer.MIN_VALUE));
        map.put("/shopSdk/LocaleService", RouteMeta.build(RouteType.PROVIDER, LocaleServiceImpl.class, "/shopsdk/localeservice", "shopsdk", null, -1, Integer.MIN_VALUE));
        map.put("/shopSdk/LoginManagerService", RouteMeta.build(RouteType.PROVIDER, LoginManagerServiceImpl.class, "/shopsdk/loginmanagerservice", "shopsdk", null, -1, Integer.MIN_VALUE));
        map.put("/shopSdk/WebViewCookieManagerService", RouteMeta.build(RouteType.PROVIDER, WebViewCookieManagerServiceImpl.class, "/shopsdk/webviewcookiemanagerservice", "shopsdk", null, -1, Integer.MIN_VALUE));
    }
}

package com.mi.global.shop.componentService;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.mi.global.shop.base.service.AppVersionService;

@Route(path = "/shopSdk/AppVersionService")
public class AppVersionServiceImpl implements AppVersionService {
    public void init(Context context) {
    }

    public final int O000000o() {
        return Integer.parseInt("30502");
    }
}

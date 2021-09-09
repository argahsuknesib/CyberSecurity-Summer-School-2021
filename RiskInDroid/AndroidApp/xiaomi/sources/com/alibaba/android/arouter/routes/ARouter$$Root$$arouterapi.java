package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import java.util.Map;

public class ARouter$$Root$$arouterapi implements IRouteRoot {
    public void loadInto(Map<String, Class<? extends IRouteGroup>> map) {
        map.put("arouter", ARouter$$Group$$arouter.class);
    }
}

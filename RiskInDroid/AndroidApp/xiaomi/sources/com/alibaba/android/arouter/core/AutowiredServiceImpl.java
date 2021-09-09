package com.alibaba.android.arouter.core;

import android.content.Context;
import android.util.LruCache;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.AutowiredService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import java.util.ArrayList;
import java.util.List;

@Route(path = "/arouter/service/autowired")
public class AutowiredServiceImpl implements AutowiredService {

    /* renamed from: O000000o  reason: collision with root package name */
    private LruCache<String, ISyringe> f3116O000000o;
    private List<String> O00000Oo;

    public void init(Context context) {
        this.f3116O000000o = new LruCache<>(66);
        this.O00000Oo = new ArrayList();
    }

    public void autowire(Object obj) {
        String name = obj.getClass().getName();
        try {
            if (!this.O00000Oo.contains(name)) {
                ISyringe iSyringe = this.f3116O000000o.get(name);
                if (iSyringe == null) {
                    iSyringe = (ISyringe) Class.forName(obj.getClass().getName() + "$$ARouter$$Autowired").getConstructor(new Class[0]).newInstance(new Object[0]);
                }
                iSyringe.inject(obj);
                this.f3116O000000o.put(name, iSyringe);
            }
        } catch (Exception unused) {
            this.O00000Oo.add(name);
        }
    }
}

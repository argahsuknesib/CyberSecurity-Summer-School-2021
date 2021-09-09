package _m_j;

import com.alibaba.android.arouter.base.UniqueKeyTreeMap;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class nx {

    /* renamed from: O000000o  reason: collision with root package name */
    static Map<String, Class<? extends IRouteGroup>> f2211O000000o = new HashMap();
    static Map<String, RouteMeta> O00000Oo = new HashMap();
    static Map<String, RouteMeta> O00000o = new HashMap();
    static Map<Class, IProvider> O00000o0 = new HashMap();
    public static Map<Integer, Class<? extends IInterceptor>> O00000oO = new UniqueKeyTreeMap("More than one interceptors use same priority [%s]");
    public static List<IInterceptor> O00000oo = new ArrayList();
}

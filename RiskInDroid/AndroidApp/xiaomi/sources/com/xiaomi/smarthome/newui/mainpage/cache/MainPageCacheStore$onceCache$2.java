package com.xiaomi.smarthome.newui.mainpage.cache;

import _m_j.fdc;
import _m_j.fkw;
import _m_j.ggb;
import _m_j.gpt;
import _m_j.gsc;
import _m_j.gsy;
import _m_j.hfz;
import _m_j.iuo;
import _m_j.iwb;
import android.net.Uri;
import android.os.Parcel;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import com.xiaomi.smarthome.scene.bean.CommonUsedScene;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/xiaomi/smarthome/newui/mainpage/cache/MainPageCache;"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class MainPageCacheStore$onceCache$2 extends Lambda implements iwb<MainPageCache> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final MainPageCacheStore$onceCache$2 f10250O000000o = new MainPageCacheStore$onceCache$2();

    MainPageCacheStore$onceCache$2() {
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return O000000o();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iuy.O000000o(java.util.List, int):T
     arg types: [java.util.List<com.xiaomi.smarthome.newui.mainpage.cache.MainPageCache>, int]
     candidates:
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Collection):C
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T>
      _m_j.iuy.O000000o(java.lang.Iterable, java.lang.Object):boolean
      _m_j.iuv.O000000o(java.util.Collection, java.lang.Iterable):boolean
      _m_j.iuv.O000000o(java.util.List, _m_j.iwc):boolean
      _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void
      _m_j.iur.O000000o(java.lang.Iterable, int):int
      _m_j.iuy.O000000o(java.util.List, int):T */
    private static MainPageCache O000000o() {
        List<MainPageCache> list;
        MainPageCache mainPageCache = null;
        if (fdc.O000000o().O000000o(CommonApplication.getAppContext()) == null) {
            return null;
        }
        String O0000OOo = ggb.O00000Oo().O0000OOo();
        if (O0000OOo == null) {
            gsy.O00000Oo(LogType.CARD, "MainPageCacheStore", "onceCache: is homeId did not exist.");
            return null;
        }
        try {
            gpt<MainPageCache> gpt = hfz.O00000o;
            if (TextUtils.isEmpty(O0000OOo)) {
                list = Collections.emptyList();
            } else {
                File file = new File(gpt.O00000Oo(O0000OOo));
                if (!file.exists()) {
                    list = Collections.emptyList();
                } else {
                    Parcel O000000o2 = fkw.O000000o(gsc.O00000o0(CommonApplication.getAppContext(), Uri.fromFile(file)));
                    list = gpt.O000000o(O000000o2);
                    O000000o2.recycle();
                }
            }
            if (list != null) {
                mainPageCache = (MainPageCache) iuo.O000000o((List) list, 0);
            }
        } catch (OutOfMemoryError unused) {
            gsy.O00000Oo(LogType.DEVICE_LIST, "MainPageCacheStore", "onceCache: is null, oom happened");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (mainPageCache == null) {
            hfz.O00000o.O000000o(O0000OOo);
            gsy.O00000Oo(LogType.DEVICE_LIST, "MainPageCacheStore", "onceCache: is null, delete");
        } else {
            ArrayList<MainPageDeviceModel> arrayList = mainPageCache.f10249O000000o;
            ArrayList<PageBean> arrayList2 = mainPageCache.O00000Oo;
            ArrayList<CommonUsedScene> arrayList3 = mainPageCache.O00000o0;
            int i = mainPageCache.O00000o;
            String str = mainPageCache.O00000oO;
            LogType logType = LogType.DEVICE_LIST;
            gsy.O00000Oo(logType, "MainPageCacheStore", "onceCache: e1: " + arrayList.size() + " ,e2: " + arrayList2.size() + ", e3: " + arrayList3.size() + ", e4 " + i + ", e5: " + str);
        }
        return mainPageCache;
    }
}

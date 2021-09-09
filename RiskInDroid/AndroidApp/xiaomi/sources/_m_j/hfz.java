package _m_j;

import android.net.Uri;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.adapter.MainCameraCardModel;
import com.xiaomi.smarthome.newui.mainpage.cache.MainPageCache;
import com.xiaomi.smarthome.newui.mainpage.cache.MainPageCacheStore$onceCache$2;
import com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import com.xiaomi.smarthome.scene.bean.CommonUsedScene;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001;B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u00108\u001a\u000209J\b\u0010:\u001a\u000209H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bRS\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00102\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00108F@FX\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015RS\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u00102\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u00108F@FX\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015RS\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u00102\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u00108F@FX\u0002¢\u0006\u0012\n\u0004\b \u0010\r\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015RS\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020!\u0018\u0001`\u00102\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020!\u0018\u0001`\u00108F@FX\u0002¢\u0006\u0012\n\u0004\b%\u0010\r\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010*\u001a\u0004\u0018\u00010)8BX\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,R\u001c\u0010/\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u00010)0)00X\u0004¢\u0006\u0002\n\u0000R/\u00102\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b7\u0010\r\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006<"}, d2 = {"Lcom/xiaomi/smarthome/newui/mainpage/cache/MainPageCacheStore;", "", "()V", "TAG", "", "<set-?>", "", "cameraCount", "getCameraCount", "()I", "setCameraCount", "(I)V", "cameraCount$delegate", "Lcom/xiaomi/smarthome/newui/mainpage/cache/MainPageCacheStore$CombineLatestDelegate;", "Ljava/util/ArrayList;", "Lcom/xiaomi/smarthome/newui/mainpage/devicepage/model/MainPageDeviceModel;", "Lkotlin/collections/ArrayList;", "commonDeviceModel", "getCommonDeviceModel", "()Ljava/util/ArrayList;", "setCommonDeviceModel", "(Ljava/util/ArrayList;)V", "commonDeviceModel$delegate", "Lcom/xiaomi/smarthome/scene/bean/CommonUsedScene;", "commonScenes", "getCommonScenes", "setCommonScenes", "commonScenes$delegate", "Lcom/xiaomi/smarthome/newui/adapter/MainCameraCardModel;", "freqCameras", "getFreqCameras", "setFreqCameras", "freqCameras$delegate", "Lcom/xiaomi/smarthome/newui/widget/topnavi/PageBean;", "indicatorPages", "getIndicatorPages", "setIndicatorPages", "indicatorPages$delegate", "isWritable", "", "lastWrite", "Lcom/xiaomi/smarthome/newui/mainpage/cache/MainPageCache;", "onceCache", "getOnceCache", "()Lcom/xiaomi/smarthome/newui/mainpage/cache/MainPageCache;", "onceCache$delegate", "Lkotlin/Lazy;", "storeHelper", "Lcom/xiaomi/smarthome/library/common/util/ParcelStoreHelper;", "kotlin.jvm.PlatformType", "wallpaper", "getWallpaper", "()Ljava/lang/String;", "setWallpaper", "(Ljava/lang/String;)V", "wallpaper$delegate", "clear", "", "combineLatest", "CombineLatestDelegate", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hfz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final hfz f18889O000000o = new hfz();
    static final /* synthetic */ ixy<Object>[] O00000Oo;
    public static final gpt<MainPageCache> O00000o = new gpt<>("main", "main_page_cache_fast_v3", MainPageCache.class);
    public static boolean O00000o0 = true;
    private static final itz O00000oO = iua.O000000o(MainPageCacheStore$onceCache$2.f10250O000000o);
    private static final O000000o O00000oo;
    private static final O000000o O0000O0o;
    private static final O000000o O0000OOo;
    private static final O000000o O0000Oo;
    private static final O000000o O0000Oo0;
    private static final O000000o O0000OoO;
    private static MainPageCache O0000Ooo = O0000OOo();

    private hfz() {
    }

    private static MainPageCache O0000OOo() {
        return (MainPageCache) O00000oO.O000000o();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iuy.O000000o(java.lang.Iterable, java.util.Collection):C
     arg types: [java.util.ArrayList<com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel>, java.util.ArrayList]
     candidates:
      _m_j.iuy.O000000o(java.util.List, int):T
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T>
      _m_j.iuy.O000000o(java.lang.Iterable, java.lang.Object):boolean
      _m_j.iuv.O000000o(java.util.Collection, java.lang.Iterable):boolean
      _m_j.iuv.O000000o(java.util.List, _m_j.iwc):boolean
      _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void
      _m_j.iur.O000000o(java.lang.Iterable, int):int
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Collection):C */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iuy.O000000o(java.lang.Iterable, java.util.Collection):C
     arg types: [java.util.ArrayList<com.xiaomi.smarthome.newui.widget.topnavi.PageBean>, java.util.ArrayList]
     candidates:
      _m_j.iuy.O000000o(java.util.List, int):T
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T>
      _m_j.iuy.O000000o(java.lang.Iterable, java.lang.Object):boolean
      _m_j.iuv.O000000o(java.util.Collection, java.lang.Iterable):boolean
      _m_j.iuv.O000000o(java.util.List, _m_j.iwc):boolean
      _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void
      _m_j.iur.O000000o(java.lang.Iterable, int):int
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Collection):C */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iuy.O000000o(java.lang.Iterable, java.util.Collection):C
     arg types: [java.util.ArrayList<com.xiaomi.smarthome.scene.bean.CommonUsedScene>, java.util.ArrayList]
     candidates:
      _m_j.iuy.O000000o(java.util.List, int):T
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T>
      _m_j.iuy.O000000o(java.lang.Iterable, java.lang.Object):boolean
      _m_j.iuv.O000000o(java.util.Collection, java.lang.Iterable):boolean
      _m_j.iuv.O000000o(java.util.List, _m_j.iwc):boolean
      _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void
      _m_j.iur.O000000o(java.lang.Iterable, int):int
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Collection):C */
    static {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ixy<Object>[] ixyArr = new ixy[7];
        ixyArr[1] = ixf.O000000o(new MutablePropertyReference1Impl(ixf.O000000o(hfz.class), "commonDeviceModel", "getCommonDeviceModel()Ljava/util/ArrayList;"));
        ixyArr[2] = ixf.O000000o(new MutablePropertyReference1Impl(ixf.O000000o(hfz.class), "indicatorPages", "getIndicatorPages()Ljava/util/ArrayList;"));
        ixyArr[3] = ixf.O000000o(new MutablePropertyReference1Impl(ixf.O000000o(hfz.class), "commonScenes", "getCommonScenes()Ljava/util/ArrayList;"));
        ixyArr[4] = ixf.O000000o(new MutablePropertyReference1Impl(ixf.O000000o(hfz.class), "cameraCount", "getCameraCount()I"));
        ixyArr[5] = ixf.O000000o(new MutablePropertyReference1Impl(ixf.O000000o(hfz.class), "wallpaper", "getWallpaper()Ljava/lang/String;"));
        ixyArr[6] = ixf.O000000o(new MutablePropertyReference1Impl(ixf.O000000o(hfz.class), "freqCameras", "getFreqCameras()Ljava/util/ArrayList;"));
        O00000Oo = ixyArr;
        MainPageCache O0000OOo2 = O0000OOo();
        ArrayList<MainCameraCardModel> arrayList4 = null;
        if (O0000OOo2 == null) {
            arrayList = null;
        } else {
            arrayList = (ArrayList) iuo.O000000o((Iterable) O0000OOo2.f10249O000000o, (Collection) new ArrayList());
        }
        O00000oo = new O000000o("commonDeviceModel", arrayList);
        MainPageCache O0000OOo3 = O0000OOo();
        if (O0000OOo3 == null) {
            arrayList2 = null;
        } else {
            arrayList2 = (ArrayList) iuo.O000000o((Iterable) O0000OOo3.O00000Oo, (Collection) new ArrayList());
        }
        O0000O0o = new O000000o("indicatorPages", arrayList2);
        MainPageCache O0000OOo4 = O0000OOo();
        if (O0000OOo4 == null) {
            arrayList3 = null;
        } else {
            arrayList3 = (ArrayList) iuo.O000000o((Iterable) O0000OOo4.O00000o0, (Collection) new ArrayList());
        }
        O0000OOo = new O000000o("commonScenes", arrayList3);
        MainPageCache O0000OOo5 = O0000OOo();
        O0000Oo0 = new O000000o("cameraCount", Integer.valueOf(O0000OOo5 == null ? 0 : O0000OOo5.O00000o));
        MainPageCache O0000OOo6 = O0000OOo();
        O0000Oo = new O000000o("wallpaper", O0000OOo6 == null ? "style_1_favorites" : O0000OOo6.O00000oO);
        MainPageCache O0000OOo7 = O0000OOo();
        if (O0000OOo7 != null) {
            arrayList4 = O0000OOo7.O00000oo;
        }
        O0000OoO = new O000000o("freqCamera", arrayList4);
    }

    public static ArrayList<MainPageDeviceModel> O000000o() {
        return (ArrayList) O00000oo.O00000Oo(O00000Oo[1]);
    }

    public static void O000000o(ArrayList<MainPageDeviceModel> arrayList) {
        O00000oo.O000000o(O00000Oo[1], arrayList);
    }

    public static ArrayList<PageBean> O00000Oo() {
        return (ArrayList) O0000O0o.O00000Oo(O00000Oo[2]);
    }

    public static void O00000Oo(ArrayList<PageBean> arrayList) {
        O0000O0o.O000000o(O00000Oo[2], arrayList);
    }

    public static ArrayList<CommonUsedScene> O00000o0() {
        return (ArrayList) O0000OOo.O00000Oo(O00000Oo[3]);
    }

    public static void O00000o0(ArrayList<CommonUsedScene> arrayList) {
        O0000OOo.O000000o(O00000Oo[3], arrayList);
    }

    public static void O000000o(int i) {
        O0000Oo0.O000000o(O00000Oo[4], Integer.valueOf(i));
    }

    public static int O00000o() {
        return ((Number) O0000Oo0.O00000Oo(O00000Oo[4])).intValue();
    }

    public static void O000000o(String str) {
        O0000Oo.O000000o(O00000Oo[5], str);
    }

    public static String O00000oO() {
        return (String) O0000Oo.O00000Oo(O00000Oo[5]);
    }

    public static void O00000o(ArrayList<MainCameraCardModel> arrayList) {
        O0000OoO.O000000o(O00000Oo[6], arrayList);
    }

    public static ArrayList<MainCameraCardModel> O00000oo() {
        return (ArrayList) O0000OoO.O00000Oo(O00000Oo[6]);
    }

    public final void O0000O0o() {
        synchronized (this) {
            if (O00000o0) {
                ArrayList<MainPageDeviceModel> O000000o2 = O000000o();
                if (O000000o2 == null) {
                    O000000o2 = new ArrayList<>();
                }
                ArrayList<MainPageDeviceModel> arrayList = O000000o2;
                ArrayList<PageBean> O00000Oo2 = O00000Oo();
                if (O00000Oo2 == null) {
                    O00000Oo2 = new ArrayList<>();
                }
                ArrayList<PageBean> arrayList2 = O00000Oo2;
                ArrayList<CommonUsedScene> O00000o02 = O00000o0();
                if (O00000o02 == null) {
                    O00000o02 = new ArrayList<>();
                }
                ArrayList<CommonUsedScene> arrayList3 = O00000o02;
                int O00000o2 = O00000o();
                String O00000oO2 = O00000oO();
                if (O00000oO2 == null) {
                    O00000oO2 = "";
                }
                String str = O00000oO2;
                ArrayList<MainCameraCardModel> O00000oo2 = O00000oo();
                if (O00000oo2 == null) {
                    O00000oo2 = new ArrayList<>();
                }
                MainPageCache mainPageCache = new MainPageCache(arrayList, arrayList2, arrayList3, O00000o2, str, O00000oo2);
                if (!ixe.O000000o(O0000Ooo, mainPageCache)) {
                    O0000Ooo = mainPageCache;
                    ArrayList<MainPageDeviceModel> arrayList4 = mainPageCache.f10249O000000o;
                    ArrayList<PageBean> arrayList5 = mainPageCache.O00000Oo;
                    ArrayList<CommonUsedScene> arrayList6 = mainPageCache.O00000o0;
                    int i = mainPageCache.O00000o;
                    String str2 = mainPageCache.O00000oO;
                    ArrayList<MainCameraCardModel> arrayList7 = mainPageCache.O00000oo;
                    LogType logType = LogType.DEVICE_LIST;
                    gsy.O00000Oo(logType, "MainPageCacheStore", "combineLatest: e1: " + arrayList4.size() + " ,e2: " + arrayList5.size() + ", e3: " + arrayList6.size() + ", e4 " + i + ", e5: " + str2 + " ,e6 : " + arrayList7);
                    String O0000OOo2 = ggb.O00000Oo().O0000OOo();
                    if (O0000OOo2 != null) {
                        goq.O000000o(new Runnable(O0000OOo2, mainPageCache) {
                            /* class _m_j.$$Lambda$hfz$JL9kndhL9nSKZVMGtmylOG9FqBY */
                            private final /* synthetic */ String f$0;
                            private final /* synthetic */ MainPageCache f$1;

                            {
                                this.f$0 = r1;
                                this.f$1 = r2;
                            }

                            public final void run() {
                                hfz.O000000o(this.f$0, this.f$1);
                            }
                        });
                        iuh iuh = iuh.f1631O000000o;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(String str, MainPageCache mainPageCache) {
        ixe.O00000o(str, "$id");
        ixe.O00000o(mainPageCache, "$latestCache");
        if (O00000o0) {
            gpt<MainPageCache> gpt = O00000o;
            List O000000o2 = iuo.O000000o(mainPageCache);
            File file = new File(gpt.O00000Oo(str));
            try {
                if (file.exists()) {
                    file.delete();
                }
                file.getParentFile().mkdirs();
                file.createNewFile();
                gsc.O000000o(CommonApplication.getAppContext(), Uri.fromFile(file), gpt.O000000o(O000000o2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J)\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/xiaomi/smarthome/newui/mainpage/cache/MainPageCacheStore$CombineLatestDelegate;", "T", "Lcom/xiaomi/smarthome/newui/mainpage/cache/ObservableDistinctProperty;", "tag", "", "initialValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "onChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static final class O000000o<T> extends hga<T> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O000000o(String str, T t) {
            super(t);
            ixe.O00000o(str, "tag");
            LogType logType = LogType.DEVICE_LIST;
            StringBuilder sb = new StringBuilder("tag: ");
            sb.append(str);
            sb.append(", initialValue is : ");
            sb.append((t == null || !(t instanceof List)) ? String.valueOf(t) : Integer.valueOf(((List) t).size()));
            gsy.O00000Oo(logType, "MainPageCacheStore", sb.toString());
        }

        /* access modifiers changed from: protected */
        public final void O000000o(ixy<?> ixy) {
            ixe.O00000o(ixy, "property");
            hfz.f18889O000000o.O0000O0o();
        }
    }
}

package _m_j;

import _m_j.hbr;
import _m_j.hbw;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.utils.DeviceLauncher2;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.GridViewData;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

@RouterService
public class eyh implements gud {
    public void setWallpaper(String str) {
        hfz hfz = hfz.f18889O000000o;
        hfz.O000000o(str);
    }

    public String getWallpaper() {
        hfz hfz = hfz.f18889O000000o;
        return hfz.O00000oO();
    }

    public void getCommonDeviceModel() {
        hfz hfz = hfz.f18889O000000o;
        hfz.O000000o();
    }

    public void sendBroadcastByShareMsg() {
        Intent intent = new Intent("main_action_room_selected");
        intent.putExtra("main_extra_room_selected_id", PageBean.O000000o());
        ft.O000000o(ServiceApplication.getAppContext()).O000000o(intent);
    }

    public String getDeviceMainPageSimpleName() {
        return gzs.class.getSimpleName();
    }

    public String getDeviceMainPageName() {
        return gzs.class.getName();
    }

    public void notifyDoubleClick() {
        had.O00000o();
    }

    public void notifySingleClick() {
        had.O00000o0();
    }

    public void initBottomTabImgsApi() {
        hbw O000000o2 = hbw.O000000o();
        if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && !O000000o2.O00000Oo.hasValue()) {
            if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                long currentTimeMillis = System.currentTimeMillis();
                O000000o2.O00000o = CommonApplication.getAppContext().getSharedPreferences("bottom_tab_icon_shaprefrence_string", 0).getString("content", "");
                long currentTimeMillis2 = System.currentTimeMillis();
                LogType logType = LogType.MAIN_PAGE;
                gsy.O00000o0(logType, "BottomTabImgsApi", "isCacheValid content:" + O000000o2.O00000o + " durition = " + (currentTimeMillis2 - currentTimeMillis));
                ArrayList arrayList = new ArrayList();
                if (TextUtils.isEmpty(O000000o2.O00000o)) {
                    O000000o2.O00000Oo.onNext(arrayList);
                } else {
                    try {
                        ArrayList<hbw.O000000o> O000000o3 = hbw.O000000o(new JSONArray(O000000o2.O00000o));
                        Iterator<hbw.O000000o> it = O000000o3.iterator();
                        while (it.hasNext()) {
                            hbw.O000000o next = it.next();
                            if (!hbw.O00000Oo(next)) {
                                it.remove();
                            } else if (!gph.O000000o().O000000o(next.f18764O000000o)) {
                                gsy.O00000Oo("BottomTabImgsApi", "isCacheValid reload images");
                                hbw.O000000o(next);
                            }
                        }
                        O000000o2.O00000Oo.onNext(O000000o3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            O000000o2.O00000o0 = Observable.just(1).delay(5, TimeUnit.SECONDS).flatMap(new Function<Integer, Observable<List<hbw.O000000o>>>() {
                /* class _m_j.hbw.AnonymousClass3 */

                public final /* synthetic */ Object apply(Object obj) throws Exception {
                    return hbw.this.O00000Oo();
                }
            }).subscribeOn(Schedulers.io()).subscribe(new Consumer<List<hbw.O000000o>>() {
                /* class _m_j.hbw.AnonymousClass1 */

                public final /* synthetic */ void accept(Object obj) throws Exception {
                    List list = (List) obj;
                    LogType logType = LogType.MAIN_PAGE;
                    gsy.O00000o0(logType, "BottomTabImgsApi", "getBottomTabImgInfoFormNet Success bottomTabImgInfos size = " + list.size());
                    if (list.isEmpty()) {
                        hbw.this.O000000o("", list);
                    }
                }
            }, new Consumer<Throwable>() {
                /* class _m_j.hbw.AnonymousClass2 */

                public final /* synthetic */ void accept(Object obj) throws Exception {
                    LogType logType = LogType.MAIN_PAGE;
                    gsy.O00000o0(logType, "BottomTabImgsApi", "getBottomTabImgInfoFormNet Failure: " + ((Throwable) obj).toString());
                    hbw.this.O000000o("", null);
                }
            });
        }
    }

    public void destoryBottomTabImgsApi() {
        hbw O000000o2 = hbw.O000000o();
        if (O000000o2.O00000o0 != null) {
            O000000o2.O00000o0.dispose();
        }
    }

    public void subscribeMainDeviceTabAnimManager(Consumer<Boolean> consumer) {
        had O00000oO = had.O00000oO();
        ixe.O00000o(consumer, "consumer");
        O00000oO.O00000o.add(O00000oO.O00000Oo().observeOn(AndroidSchedulers.mainThread()).subscribe(consumer));
    }

    public void setBottomTabIconByTag(String str, ImageView imageView) {
        hbw O000000o2 = hbw.O000000o();
        gsy.O00000Oo("BottomTabImgsApi", "setBottomTabIconByTag begin: ".concat(String.valueOf(str)));
        String str2 = O000000o2.f18760O000000o.get(str);
        if (imageView != null && !TextUtils.isEmpty(str2) && O000000o2.O00000Oo.hasValue()) {
            hbw.O000000o o000000o = null;
            List value = O000000o2.O00000Oo.getValue();
            for (int i = 0; i < value.size(); i++) {
                hbw.O000000o o000000o2 = (hbw.O000000o) value.get(i);
                if (TextUtils.equals(str2, o000000o2.O00000Oo)) {
                    o000000o = o000000o2;
                }
            }
            if (!hbw.O00000Oo(o000000o)) {
                return;
            }
            if (!gph.O000000o().O000000o(o000000o.f18764O000000o)) {
                gsy.O00000Oo("BottomTabImgsApi", "setBottomTabIconByTag downloaded miss: ".concat(String.valueOf(str)));
                return;
            }
            Bitmap O00000o = gph.O000000o().O00000o(o000000o.f18764O000000o);
            if (O00000o != null) {
                imageView.setImageBitmap(O00000o);
            }
            gsy.O00000Oo("BottomTabImgsApi", "setBottomTabIconByTag end: ".concat(String.valueOf(str)));
        }
    }

    public void onPageSelected(FragmentActivity fragmentActivity, int i) {
        hbr O000000o2 = hbr.O000000o(fragmentActivity);
        if (O000000o2.O00000o0 != i) {
            for (hbr.O00000Oo O000000o3 : O000000o2.O00000Oo) {
                O000000o3.O000000o(Integer.valueOf(i));
            }
            O000000o2.O00000o0 = i;
        }
    }

    public Observable<Boolean> markAsFreq(Home home, List<String> list) {
        return hfy.f18887O000000o.O00000o0(home, list);
    }

    public Observable<Boolean> markAsUnFreq(Home home, List<String> list) {
        hfy hfy = hfy.f18887O000000o;
        return hfy.O000000o(home, list);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public void finishCurrentSmartConfig(Context context, Device device) {
        if (device != null) {
            Intent intent = new Intent(context, DeviceLauncher2.class);
            intent.setAction("com.xiaomi.smarthome.action.viewdevice");
            intent.putExtra("device_mac", device.mac);
            intent.putExtra("user_model", device.model);
            intent.putExtra("device_id", device.did);
            intent.putExtra("from_main_activity", true);
            context.startActivity(intent);
            return;
        }
        fbt fbt = new fbt(context, "SmartHomeMainActivity");
        fbt.O00000Oo(268435456);
        fbs.O000000o(fbt);
    }

    public guc createDeviceMainFragment() {
        return new gzs();
    }

    public void reportOfflineStatAndClean() {
        hxf O000000o2 = hxf.O000000o();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (Map.Entry next : O000000o2.f947O000000o.entrySet()) {
            String str = (String) next.getKey();
            List<String> list = (List) next.getValue();
            if (list != null) {
                for (String str2 : list) {
                    char c = 65535;
                    int hashCode = str2.hashCode();
                    if (hashCode != -252753263) {
                        if (hashCode != 491886639) {
                            if (hashCode == 1912335259 && str2.equals("mijia.roomid.common")) {
                                c = 0;
                            }
                        } else if (str2.equals("mijia.roomid.share")) {
                            c = 1;
                        }
                    } else if (str2.equals("mijia.roomid.default")) {
                        c = 2;
                    }
                    if (c == 0) {
                        gfx.O000000o();
                        List<GridViewData> O000000o3 = gfx.O000000o(str);
                        if (O000000o3 != null) {
                            for (GridViewData gridViewData : O000000o3) {
                                arrayList.add(gridViewData.O00000Oo);
                            }
                        }
                    } else if (c == 1) {
                        gge.O000000o();
                        arrayList4.addAll(gge.O000000o(str));
                    } else if (c == 2) {
                        arrayList3.addAll(ggb.O00000Oo().O0000O0o(str));
                    } else if (!TextUtils.isEmpty(str2) && !str2.startsWith("mijia")) {
                        arrayList2.addAll(ggb.O00000Oo().O00000Oo(ggb.O00000Oo().O00000o0(str2)));
                    }
                }
            }
        }
        ArrayList arrayList5 = new ArrayList();
        hxf.O000000o(arrayList5, arrayList);
        hxf.O000000o(arrayList5, arrayList2);
        hxf.O000000o(arrayList5, arrayList3);
        hxf.O000000o(arrayList5, arrayList4);
        int O000000o4 = hxf.O000000o(arrayList5);
        hxt hxt = hxi.O0000Oo;
        int size = arrayList5.size();
        if (!flu.O00000oO().O00000Oo() && !gfr.f17662O000000o) {
            hxt.f960O000000o.O000000o("report_device_offline_stat", "offline_num", Integer.valueOf(O000000o4), "total_num", Integer.valueOf(size));
        }
        synchronized (hxf.class) {
            O000000o2.f947O000000o.clear();
        }
    }
}

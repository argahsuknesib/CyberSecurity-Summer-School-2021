package _m_j;

import _m_j.fuy;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Address;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class gwu {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Map<String, Map<String, Map<String, String>>> f18430O000000o = new LinkedHashMap();
    private static Map<String, String> O00000Oo = new LinkedHashMap();
    private static TreeMap<String, String> O00000o = new TreeMap<>();
    private static TreeMap<String, String> O00000o0 = new TreeMap<>();
    private static TreeMap<String, Pair<Integer, Integer>> O00000oO = new TreeMap<>();
    private static Set<String> O00000oo = new HashSet();
    private static volatile boolean O0000O0o = false;
    private static XQProgressDialog O0000OOo;

    public interface O000000o {
        void O000000o(Context context, Address address);

        void O000000o(String str, String str2);
    }

    private static void O00000o0() {
        O00000oo.add("北京");
        O00000oo.add("上海");
        O00000oo.add("天津");
        O00000oo.add("重庆");
        O00000o0.put("广西壮族自治区", "广西");
        O00000o0.put("宁夏回族自治区", "宁夏");
        O00000o0.put("内蒙古自治区", "内蒙古");
        O00000o0.put("西藏自治区", "西藏");
        O00000o0.put("新疆维吾尔自治区", "新疆");
        O00000o0.put("澳门特别行政区", "澳门");
        O00000o0.put("香港特别行政区", "香港");
        O00000o.put("西双版纳傣族自治州", "西双版纳");
        O00000o.put("延边朝鲜族自治州", "延边");
        O00000o.put("大兴安岭地区", "大兴安岭");
        O00000o.put("恩施土家族苗族自治州", "恩施");
        O00000o.put("神农架", "神农架");
        O00000o.put("湘西土家族苗族自治州", "湘西");
        O00000o.put("阿坝藏族羌族自治州", "阿坝");
        O00000o.put("甘孜藏族自治州", "甘孜");
        O00000o.put("凉山彝族自治州", "凉山");
        O00000o.put("黔西南布依族苗族自治州", "黔西南");
        O00000o.put("毕节地区", "毕节");
        O00000o.put("黔东南苗族侗族自治州", "黔东");
        O00000o.put("黔南布依族苗族自治州", "黔南");
        O00000o.put("楚雄彝族自治州", "楚雄");
        O00000o.put("红河哈尼族彝族自治州", "红河");
        O00000o.put("文山壮族苗族自治州", "文山");
        O00000o.put("大理白族自治州", "大理");
        O00000o.put("德宏傣族景颇族自治州", "德宏");
        O00000o.put("怒江傈僳族自治州", "怒江");
        O00000o.put("迪庆藏族自治州", "迪庆");
        O00000o.put("临夏回族自治州", "临夏");
        O00000o.put("甘南藏族自治州", "甘南");
        O00000o.put("海东地区", "海东");
        O00000o.put("海北藏族自治州", "海北");
        O00000o.put("黄南藏族自治州", "黄南");
        O00000o.put("海南藏族自治州", "海南");
        O00000o.put("果洛藏族自治州", "果洛");
        O00000o.put("玉树藏族自治州", "玉树");
        O00000o.put("海西蒙古族藏族自治州", "海西");
        O00000o.put("吐鲁番地区", "吐鲁番");
        O00000o.put("哈密地区", "哈密");
        O00000o.put("昌吉回族自治州", "昌吉");
        O00000o.put("博尔塔拉蒙古自治州", "博尔塔拉");
        O00000o.put("巴音郭楞蒙古自治州", "巴音郭楞");
        O00000o.put("阿克苏地区", "阿克苏");
        O00000o.put("克孜勒苏柯尔克孜自治州", "克孜勒苏");
        O00000o.put("喀什地区", "喀什");
        O00000o.put("和田地区", "和田");
        O00000o.put("伊犁哈萨克自治州", "伊犁");
        O00000o.put("塔城地区", "塔城");
        O00000o.put("阿勒泰地区", "阿勒泰");
        O00000o.put("青龙满族自治县", "青龙");
        O00000o.put("峰峰矿区", "峰峰");
        O00000o.put("鹰手营子矿区", "鹰手营子");
        O00000o.put("丰宁满族自治县", "丰宁");
        O00000o.put("宽城满族自治县", "宽城");
        O00000o.put("围场满族蒙古族自治县", "围场");
        O00000o.put("孟村回族自治县", "孟村");
        O00000o.put("大厂回族自治县", "大厂");
        O00000o.put("澳门特别行政区", "澳门");
        O00000o.put("香港特别行政区", "香港");
        O0000O0o = true;
    }

    public static void O000000o() {
        O0000O0o = false;
        f18430O000000o.clear();
        O00000Oo.clear();
        O00000o0.clear();
        O00000o.clear();
        O00000oO.clear();
        O00000oo.clear();
    }

    public static void O000000o(Activity activity, final O000000o o000000o) {
        if (!gof.O00000o0()) {
            gqg.O000000o((int) R.string.popup_select_loc_no_network);
            return;
        }
        if (f18430O000000o.isEmpty() || O00000Oo.isEmpty()) {
            O000000o(activity);
        }
        if (!O0000O0o) {
            O00000o0();
        }
        List<String> O000000o2 = O000000o(f18430O000000o.keySet().iterator());
        if (gwc.O000000o(Locale.CHINA, ftn.O00000o0(activity))) {
            O000000o2.add(0, activity.getString(R.string.area_auto_locate));
        }
        final String[] strArr = new String[O000000o2.size()];
        O000000o2.toArray(strArr);
        final WeakReference weakReference = new WeakReference(activity);
        MLAlertDialog O00000oo2 = new MLAlertDialog.Builder(activity).O000000o(strArr, new DialogInterface.OnClickListener() {
            /* class _m_j.gwu.AnonymousClass1 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.gwu.O000000o(android.content.Context, _m_j.gwu$O000000o):void
             arg types: [android.app.Activity, _m_j.gwu$O000000o]
             candidates:
              _m_j.gwu.O000000o(android.content.Context, android.location.Address):_m_j.gwr
              _m_j.gwu.O000000o(java.util.Map<java.lang.String, java.lang.String>, java.lang.String):java.lang.String
              _m_j.gwu.O000000o(android.app.Activity, _m_j.gwu$O000000o):void
              _m_j.gwu.O000000o(android.content.Context, java.lang.String):void
              _m_j.gwu.O000000o(android.content.Context, _m_j.gwu$O000000o):void */
            public final void onClick(DialogInterface dialogInterface, int i) {
                Activity activity = (Activity) weakReference.get();
                if (i != 0) {
                    String[] strArr = strArr;
                    if (i < strArr.length) {
                        gwu.O000000o(activity, strArr[i], o000000o);
                    }
                } else if (!gwc.O000000o(Locale.CHINA, ftn.O00000o0(ServiceApplication.getAppContext()))) {
                    gwu.O000000o(activity, strArr[i], o000000o);
                } else if (fux.O000000o(activity)) {
                    gwu.O000000o(activity, activity.getString(R.string.area_info_loading));
                    gwu.O000000o((Context) activity, o000000o);
                }
            }
        }).O00000oo();
        if (strArr.length > 10) {
            O00000oo2.setContentPanelHeight((activity.getResources().getDisplayMetrics().heightPixels * 2) / 3);
        }
        gnp.O000000o(activity, O00000oo2);
    }

    public static void O000000o(Context context, O000000o o000000o) {
        if (!O0000O0o) {
            O00000o0();
        }
        fuy.O000000o().O000000o(new fuy.O000000o(true, o000000o, context, false) {
            /* class _m_j.gwu.AnonymousClass2 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ boolean f18432O000000o = true;
            final /* synthetic */ Context O00000o;
            final /* synthetic */ O000000o O00000o0;
            final /* synthetic */ boolean O00000oO;

            {
                this.O00000o0 = r2;
                this.O00000o = r3;
                this.O00000oO = false;
            }

            public final void O000000o(String str, Location location) {
                Bundle extras = location.getExtras();
                if (extras != null) {
                    Address address = (Address) extras.getParcelable("address");
                    O000000o o000000o = this.O00000o0;
                    if (o000000o != null) {
                        o000000o.O000000o(this.O00000o, address);
                    }
                    if (this.f18432O000000o && location != null && address != null && address.getAdminArea() != null && gwu.O000000o(this.O00000o, address) != null) {
                        gqg.O00000Oo((int) R.string.area_location_suc);
                    } else if (this.f18432O000000o) {
                        gqg.O00000Oo((int) R.string.area_auto_locate_failed);
                    }
                } else if (this.f18432O000000o) {
                    gqg.O00000Oo((int) R.string.area_auto_locate_failed);
                }
                gwu.O00000Oo();
            }

            public final void O000000o(String str) {
                if (this.f18432O000000o) {
                    gqg.O00000Oo((int) R.string.area_auto_locate_failed);
                }
                gwu.O00000Oo();
            }
        });
    }

    public static void O000000o(Context context, String str, O000000o o000000o) {
        if (!O0000O0o) {
            O00000o0();
        }
        final Map map = f18430O000000o.get(str);
        if (map != null && !map.isEmpty()) {
            List<String> O000000o2 = O000000o(map.keySet().iterator());
            String[] strArr = new String[O000000o2.size()];
            O000000o2.toArray(strArr);
            final WeakReference weakReference = new WeakReference(context);
            final String[] strArr2 = strArr;
            final Context context2 = context;
            final String str2 = str;
            final O000000o o000000o2 = o000000o;
            MLAlertDialog O00000oo2 = new MLAlertDialog.Builder(context).O000000o(strArr, new DialogInterface.OnClickListener() {
                /* class _m_j.gwu.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (((Context) weakReference.get()) != null) {
                        String[] strArr = strArr2;
                        if (i < strArr.length) {
                            String str = strArr[i];
                            gwu.O000000o(context2, str2, str, (Map) map.get(str), o000000o2);
                        }
                    }
                }
            }).O00000oo();
            if (strArr.length > 10) {
                O00000oo2.setContentPanelHeight((context.getResources().getDisplayMetrics().heightPixels * 2) / 3);
            }
            gnp.O000000o(context, O00000oo2);
        }
    }

    public static void O000000o(Context context, String str, String str2, Map<String, String> map, O000000o o000000o) {
        if (!O0000O0o) {
            O00000o0();
        }
        if (map != null && !map.isEmpty()) {
            List<String> O000000o2 = O000000o(map.keySet().iterator());
            String[] strArr = new String[O000000o2.size()];
            O000000o2.toArray(strArr);
            final WeakReference weakReference = new WeakReference(context);
            final String[] strArr2 = strArr;
            final O000000o o000000o2 = o000000o;
            final String str3 = str;
            final String str4 = str2;
            final Map<String, String> map2 = map;
            MLAlertDialog O00000oo2 = new MLAlertDialog.Builder(context).O000000o(strArr, new DialogInterface.OnClickListener() {
                /* class _m_j.gwu.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    Context context = (Context) weakReference.get();
                    if (context != null && i < strArr2.length) {
                        gwu.O000000o(context, context.getString(R.string.area_info_loading));
                        String str = strArr2[i];
                        O000000o o000000o = o000000o2;
                        if (o000000o != null) {
                            o000000o.O000000o(str, (String) map2.get(str));
                        }
                        gwu.O00000Oo();
                    }
                }
            }).O00000oo();
            if (strArr.length > 10) {
                O00000oo2.setContentPanelHeight((context.getResources().getDisplayMetrics().heightPixels * 2) / 3);
            }
            gnp.O000000o(context, O00000oo2);
        }
    }

    public static void O000000o(Context context, String str) {
        O00000Oo();
        XQProgressDialog xQProgressDialog = new XQProgressDialog(context);
        O0000OOo = xQProgressDialog;
        xQProgressDialog.setCancelable(true);
        O0000OOo.setCanceledOnTouchOutside(false);
        O0000OOo.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class _m_j.gwu.AnonymousClass5 */

            public final void onCancel(DialogInterface dialogInterface) {
                LocationManager locationManager;
                fuy O000000o2 = fuy.O000000o();
                if (O000000o2.f17234O000000o != null && (locationManager = (LocationManager) O000000o2.f17234O000000o.getSystemService("location")) != null) {
                    locationManager.removeUpdates(O000000o2.O0000O0o);
                    fuw.O000000o().O00000Oo();
                }
            }
        });
        O0000OOo.setMessage(str);
        O0000OOo.show();
    }

    public static void O00000Oo() {
        XQProgressDialog xQProgressDialog = O0000OOo;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
            O0000OOo = null;
        }
    }

    private static List<String> O000000o(Iterator<String> it) {
        String str;
        ArrayList arrayList = new ArrayList();
        ArrayList<Pair> arrayList2 = new ArrayList<>();
        while (it.hasNext()) {
            String next = it.next();
            try {
                if (TextUtils.equals("博爱", next)) {
                    str = "boai";
                } else {
                    str = gqb.O0000Oo0(next);
                }
                arrayList2.add(new Pair(next, str));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (Pair pair : arrayList2) {
            arrayList.add(pair.first);
        }
        return arrayList;
    }

    private static void O000000o(Context context) {
        JSONArray optJSONArray;
        Context appContext = context == null ? ServiceApplication.getAppContext() : context;
        if (appContext != null) {
            try {
                InputStream open = appContext.getAssets().open(gwc.O00000o());
                InputStreamReader inputStreamReader = new InputStreamReader(open);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String str = "";
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    str = str + readLine;
                }
                bufferedReader.close();
                inputStreamReader.close();
                open.close();
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject optJSONObject = jSONObject.optJSONObject(next);
                    if (optJSONObject != null) {
                        O00000Oo.put(next, optJSONObject.optString("id"));
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("child");
                        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            for (int i = 0; i < optJSONArray2.length(); i++) {
                                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i);
                                if (optJSONObject2 != null) {
                                    String optString = optJSONObject2.optString("name");
                                    if (!gqb.O000000o(optString) && (optJSONArray = optJSONObject2.optJSONArray("child")) != null && optJSONArray.length() > 0) {
                                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i2);
                                            String optString2 = optJSONObject3.optString("name");
                                            if (!gqb.O000000o(optString2)) {
                                                String optString3 = optJSONObject3.optString("id");
                                                if (!gqb.O000000o(optString3)) {
                                                    linkedHashMap2.put(optString2, optString3);
                                                }
                                            }
                                        }
                                        if (!linkedHashMap2.isEmpty()) {
                                            linkedHashMap.put(optString, linkedHashMap2);
                                        }
                                    }
                                }
                            }
                            if (!linkedHashMap.isEmpty()) {
                                f18430O000000o.put(next, linkedHashMap);
                            }
                        }
                    }
                }
            } catch (IOException | JSONException unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0096  */
    public static gwr O000000o(Context context, Address address) {
        String str;
        String str2;
        String str3;
        Map map;
        if (!O0000O0o) {
            O00000o0();
        }
        if (address != null) {
            String countryCode = address.getCountryCode();
            String O000000o2 = O000000o(O00000o0, address.getAdminArea());
            String O000000o3 = O000000o(O00000o, address.getLocality());
            String O000000o4 = O000000o(O00000o, address.getSubLocality());
            if (!gqb.O000000o(O000000o4) || !O000000o(O000000o2) || O000000o2.equals(O000000o3)) {
                str = O000000o4;
                str2 = O000000o3;
            } else {
                str = O000000o3;
                str2 = O000000o2;
            }
            String thoroughfare = address.getThoroughfare();
            if (f18430O000000o.isEmpty() || O00000Oo.isEmpty()) {
                if (context == null) {
                    context = ServiceApplication.getAppContext();
                }
                if (context == null) {
                    return null;
                }
                O000000o(context);
            }
            Map map2 = f18430O000000o.get(O000000o2);
            if (!(map2 == null || (map = (Map) map2.get(str2)) == null)) {
                if (map.containsKey(str)) {
                    str3 = (String) map.get(str);
                } else if (map.containsKey(str2)) {
                    str3 = (String) map.get(str2);
                }
                if (!gqb.O000000o(str3)) {
                    gwr gwr = new gwr(countryCode, O000000o2, str2, str, thoroughfare);
                    gwr.O00000oo = str3;
                    return gwr;
                }
            }
            str3 = null;
            if (!gqb.O000000o(str3)) {
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ba A[RETURN] */
    public static String O000000o(Context context, String str, String str2, String str3) {
        String str4;
        if (!O0000O0o) {
            O00000o0();
        }
        String O000000o2 = O000000o(O00000o0, str);
        String O000000o3 = O000000o(O00000o, str2);
        String O000000o4 = O000000o(O00000o, str3);
        if (gqb.O000000o(O000000o4) && O000000o(O000000o2) && !O000000o2.equals(O000000o3)) {
            O000000o4 = O000000o3;
            O000000o3 = O000000o2;
        }
        if (f18430O000000o.isEmpty() || O00000Oo.isEmpty()) {
            O000000o(context);
        }
        Map map = f18430O000000o.get(O000000o2);
        if (map != null) {
            Map map2 = (Map) map.get(O000000o3);
            if (map2 == null) {
                if (TextUtils.isEmpty(str3) || TextUtils.equals(str3, str2)) {
                    Iterator it = map.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map map3 = (Map) ((Map.Entry) it.next()).getValue();
                        if (map3 != null && map3.containsKey(O000000o3)) {
                            str4 = (String) map3.get(O000000o3);
                            break;
                        }
                    }
                    if (gqb.O000000o(str4)) {
                        str4 = O00000Oo.get(O000000o2);
                    }
                }
                str4 = null;
                if (gqb.O000000o(str4)) {
                }
            } else if (map2.containsKey(O000000o4)) {
                str4 = (String) map2.get(O000000o4);
            } else if (map2.containsKey(O000000o3)) {
                str4 = (String) map2.get(O000000o3);
            }
            if (gqb.O000000o(str4)) {
                return str4;
            }
            return null;
        }
        str4 = null;
        if (gqb.O000000o(str4)) {
        }
    }

    private static String O000000o(Map<String, String> map, String str) {
        if (gqb.O000000o(str)) {
            return str;
        }
        if (map.get(str) != null) {
            return map.get(str);
        }
        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
        if (O00oOooo == null) {
            O00oOooo = Locale.getDefault();
        }
        return gwc.O000000o(O00oOooo, Locale.CHINA) ? str.substring(0, str.length() - 1) : str;
    }

    private static boolean O000000o(String str) {
        return O00000oo.contains(str);
    }

    public static String[] O00000Oo(Context context, String str) {
        Map map;
        Map map2;
        if (context == null) {
            context = ServiceApplication.getAppContext();
        }
        String str2 = null;
        if (context == null) {
            return null;
        }
        if (!O0000O0o) {
            O00000o0();
        }
        if (f18430O000000o.isEmpty() || O00000Oo.isEmpty()) {
            O000000o(context);
        }
        String str3 = null;
        String str4 = null;
        boolean z = false;
        for (Map.Entry next : f18430O000000o.entrySet()) {
            if (!(next == null || (map = (Map) next.getValue()) == null)) {
                str2 = (String) next.getKey();
                for (Map.Entry entry : map.entrySet()) {
                    if (!(entry == null || (map2 = (Map) entry.getValue()) == null)) {
                        str3 = (String) entry.getKey();
                        Iterator it = map2.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Map.Entry entry2 = (Map.Entry) it.next();
                            if (entry2 != null) {
                                str4 = (String) entry2.getKey();
                                if (TextUtils.equals(str, (CharSequence) entry2.getValue())) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                        if (z) {
                            break;
                        }
                    }
                }
                if (z) {
                    break;
                }
            }
        }
        return new String[]{str2, str3, str4};
    }
}

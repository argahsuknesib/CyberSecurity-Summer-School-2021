package _m_j;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.ChooseConnectDeviceAdapter;
import com.xiaomi.smarthome.device.ChooseDeviceNestedParent;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceScanManager;
import com.xiaomi.smarthome.device.api.DevicelibApi;
import com.xiaomi.smarthome.device.choosedevice.ChooseCollapsedGridView;
import com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity;
import com.xiaomi.smarthome.device.choosedevice.VerticalSlidingTab;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.common.widget.FixHeightGridView;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fmg extends fvm implements hmv {
    private static int O000OOoO = 8;

    /* renamed from: O000000o  reason: collision with root package name */
    public VerticalSlidingTab f16609O000000o;
    public O00000o0 O00000Oo;
    public Map<Integer, O00000Oo> O00000o = new HashMap();
    public List<PluginDeviceInfo> O00000o0 = new ArrayList();
    public Map<String, Integer> O00000oO = new HashMap();
    public View O00000oo;
    public View O0000O0o;
    public boolean O0000OOo;
    public List<String> O0000Oo;
    public List<fni> O0000Oo0 = new ArrayList();
    public O000000o O0000OoO;
    public View O0000Ooo;
    public FixHeightGridView O0000o;
    public View O0000o0;
    public View O0000o00;
    public View O0000o0O;
    public ChooseConnectDeviceAdapter O0000o0o;
    public View O0000oO;
    public View O0000oO0;
    public DeviceScanManager O0000oOO;
    public TextView O0000oOo;
    public List<String> O0000oo = new ArrayList();
    public List<O0000OOo> O0000oo0 = new ArrayList();
    public int O0000ooO;
    public Runnable O0000ooo;
    public ChooseDeviceNestedParent.O000000o O000O00o;
    private View O000O0OO;
    private RecyclerView O000O0Oo;
    private List<Pair<String, List<Pair<String, List<PluginDeviceInfo>>>>> O000O0o = new ArrayList();
    private Map<Integer, O00000Oo> O000O0o0 = new HashMap();
    private final Object O000O0oO = new Object();
    private String O000O0oo;
    private O0000O0o O000OO;
    private View O000OO00;
    private View O000OO0o;
    private int O000OOOo;
    private float O000OOo;
    private int O000OOo0;
    private Runnable O000OOoo;
    private List<Object> O000Oo00;
    private ChooseDeviceNestedParent O00oOoOo;
    boolean O00oOooO;
    boolean O00oOooo;

    public interface O000000o {
        void addFragment();
    }

    public interface O00000o {
        void chooseConnectDevice(PluginDeviceInfo pluginDeviceInfo);
    }

    public interface O00000o0 {
        void chooseCategory(String str, String str2, List<PluginDeviceInfo> list);
    }

    public fmg() {
        this.O00000oO.put("miir.tv.ir01", 0);
        this.O00000oO.put("miir.tvbox.ir01", 1);
        this.O00000oO.put("miir.stb.ir01", 2);
        this.O00000oO.put("miir.aircondition.ir02", 3);
        this.O00000oO.put("miir.fan.ir01", 4);
        this.O00000oO.put("miir.dvd.ir01", 5);
        this.O00000oO.put("miir.wifispeaker.ir01", 6);
        this.O00000oO.put("miir.projector.ir01", 7);
        this.O00000oO.put("miir.light.ir01", 8);
        this.O00000oO.put("miir.airpurifier.ir01", 9);
        this.O00000oO.put("miir.waterheater.ir01", 10);
        this.O00000oO.put("miir.camera.ir01", 11);
        this.O00000oO.put("miir.remote.ir01", 12);
        this.O000OOoo = new Runnable() {
            /* class _m_j.$$Lambda$fmg$yLQxmP6u8XFLJ37qGVW7ZWIhKqw */

            public final void run() {
                fmg.this.O00000oo();
            }
        };
        this.O0000ooo = new Runnable() {
            /* class _m_j.$$Lambda$fmg$a2Z8Mwi2QJwAUmoB5oh8pzZEU24 */

            public final void run() {
                fmg.this.O00000o();
            }
        };
        this.O00oOooO = false;
        this.O00oOooo = false;
        this.O000Oo00 = new ArrayList();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oo() {
        synchronized (this.O000O0oO) {
            if (this.O000O0o0.size() == 0) {
                Locale O00oOooo2 = CoreApi.O000000o().O00oOooo();
                if (O00oOooo2 == null) {
                    O00oOooo2 = Locale.getDefault();
                }
                String O00000o2 = fcb.O000000o().O00000o("category_pref_category_data_v3_key");
                String O00000o3 = fcb.O000000o().O00000o("category_pref_category_locale_v3_key");
                long O00000Oo2 = fcb.O000000o().O00000Oo("category_pref_category_time_v3_key");
                if (TextUtils.isEmpty(O00000o2) || System.currentTimeMillis() - O00000Oo2 >= 86400000 || !flk.O000000o(O00oOooo2).equalsIgnoreCase(O00000o3)) {
                    DevicelibApi.getDeviceCategory(getActivity(), new fsm<JSONObject, fso>() {
                        /* class _m_j.fmg.AnonymousClass3 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            JSONObject jSONObject = (JSONObject) obj;
                            fmg.this.O000000o(jSONObject.optJSONObject("top_category"));
                            String optString = jSONObject.optString("catgory_info");
                            if (!TextUtils.isEmpty(optString)) {
                                try {
                                    if (fmg.this.O000000o(new JSONArray(optString))) {
                                        fcb.O000000o().O000000o("category_pref_category_data_v3_key", jSONObject.toString());
                                        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
                                        if (O00oOooo == null) {
                                            O00oOooo = Locale.getDefault();
                                        }
                                        fcb.O000000o().O000000o("category_pref_category_locale_v3_key", flk.O000000o(O00oOooo));
                                        fcb.O000000o().O000000o("category_pref_category_time_v3_key", System.currentTimeMillis());
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                if (fmg.this.O00000o0.size() > 0 && fmg.this.isValid()) {
                                    ((ChooseDeviceActivity) fmg.this.getActivity()).getWorkerHandler().post(fmg.this.O0000ooo);
                                }
                            }
                        }

                        public final void onFailure(fso fso) {
                            fmg.this.O00000o0(fcb.O000000o().O00000o("category_pref_category_data_v3_key"));
                        }
                    });
                } else {
                    O00000o0(O00000o2);
                }
            }
        }
    }

    public static class O0000OOo {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f16623O000000o;
        public String O00000Oo;
        public List<PluginDeviceInfo> O00000o0;

        public O0000OOo(String str, String str2, List<PluginDeviceInfo> list) {
            this.f16623O000000o = str;
            this.O00000Oo = str2;
            this.O00000o0 = list;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o() {
        synchronized (this.O000O0oO) {
            if (this.O000O0o.size() <= 0) {
                TreeMap treeMap = new TreeMap(new Comparator() {
                    /* class _m_j.$$Lambda$fmg$C5ZtsYpSctguNUt1rR6byjtXWPQ */

                    public final int compare(Object obj, Object obj2) {
                        return fmg.this.O000000o((Integer) obj, (Integer) obj2);
                    }
                });
                for (PluginDeviceInfo next : this.O00000o0) {
                    if (next != null) {
                        List<Integer> list = next.O0000ooO;
                        if (list != null) {
                            if (list.size() != 0) {
                                for (Integer next2 : list) {
                                    O00000Oo o00000Oo = this.O00000o.get(next2);
                                    if (o00000Oo != null) {
                                        Iterator<Integer> it = o00000Oo.O00000Oo.iterator();
                                        while (it.hasNext()) {
                                            Integer next3 = it.next();
                                            if (treeMap.get(next3) == null) {
                                                TreeMap treeMap2 = new TreeMap();
                                                ArrayList arrayList = new ArrayList();
                                                arrayList.add(next);
                                                treeMap2.put(next2, arrayList);
                                                treeMap.put(next3, treeMap2);
                                            } else {
                                                TreeMap treeMap3 = (TreeMap) treeMap.get(next3);
                                                if (treeMap3.get(next2) == null) {
                                                    ArrayList arrayList2 = new ArrayList();
                                                    arrayList2.add(next);
                                                    treeMap3.put(next2, arrayList2);
                                                } else {
                                                    ((List) treeMap3.get(next2)).add(next);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        LogType logType = LogType.KUAILIAN;
                        gsy.O00000o0(logType, "ChooseDeviceManually", "displayArray null: " + next.O0000oO());
                    }
                }
                for (TreeMap values : treeMap.values()) {
                    for (List sort : values.values()) {
                        Collections.sort(sort, new Comparator<PluginDeviceInfo>() {
                            /* class _m_j.fmg.AnonymousClass9 */

                            public final boolean equals(Object obj) {
                                return false;
                            }

                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                int i;
                                int i2;
                                PluginDeviceInfo pluginDeviceInfo = (PluginDeviceInfo) obj;
                                PluginDeviceInfo pluginDeviceInfo2 = (PluginDeviceInfo) obj2;
                                if (fqw.O000000o(pluginDeviceInfo) && fqw.O000000o(pluginDeviceInfo2)) {
                                    Integer num = fmg.this.O00000oO.get(pluginDeviceInfo.O00000Oo());
                                    Integer num2 = fmg.this.O00000oO.get(pluginDeviceInfo2.O00000Oo());
                                    if (num == null || num2 == null) {
                                        gsy.O000000o(6, "ChooseDevice", "---后台新增了APP不知道的红外品类---");
                                        return 1;
                                    }
                                    i = num.intValue();
                                    i2 = num2.intValue();
                                } else if (pluginDeviceInfo == null) {
                                    return 1;
                                } else {
                                    if (pluginDeviceInfo2 == null) {
                                        return -1;
                                    }
                                    if (pluginDeviceInfo.O00oOoOo == 0 && pluginDeviceInfo2.O00oOoOo == 0) {
                                        return 0;
                                    }
                                    if (pluginDeviceInfo.O00oOoOo == 0) {
                                        return 1;
                                    }
                                    if (pluginDeviceInfo2.O00oOoOo == 0) {
                                        return -1;
                                    }
                                    i = pluginDeviceInfo.O00oOoOo;
                                    i2 = pluginDeviceInfo2.O00oOoOo;
                                }
                                return i - i2;
                            }
                        });
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                if (this.O0000Oo != null && this.O0000Oo.size() > 0) {
                    HashMap hashMap = new HashMap();
                    for (PluginDeviceInfo next4 : this.O00000o0) {
                        hashMap.put(next4.O00000Oo(), next4);
                    }
                    ArrayList arrayList4 = new ArrayList();
                    if (arrayList4.size() > 0) {
                        ArrayList arrayList5 = new ArrayList();
                        arrayList5.add(Pair.create(this.O000O0oo, arrayList4));
                        arrayList3.add(Pair.create(this.O000O0oo, arrayList5));
                    }
                }
                for (Map.Entry entry : treeMap.entrySet()) {
                    if (this.O000O0o0.get(entry.getKey()) != null) {
                        ArrayList arrayList6 = new ArrayList();
                        ArrayList arrayList7 = new ArrayList(((TreeMap) entry.getValue()).entrySet());
                        Collections.sort(arrayList7, new Comparator<Map.Entry<Integer, List<PluginDeviceInfo>>>() {
                            /* class _m_j.fmg.AnonymousClass2 */

                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                int i;
                                int i2;
                                int intValue = ((Integer) ((Map.Entry) obj).getKey()).intValue();
                                int intValue2 = ((Integer) ((Map.Entry) obj2).getKey()).intValue();
                                if (fmg.this.O00000o.get(Integer.valueOf(intValue)) == null || fmg.this.O00000o.get(Integer.valueOf(intValue2)) == null) {
                                    return fmg.this.O00000o.get(Integer.valueOf(intValue)) == null ? -1 : 1;
                                }
                                if (fmg.this.O00000o.get(Integer.valueOf(intValue)).O00000o0 == 0 || fmg.this.O00000o.get(Integer.valueOf(intValue2)).O00000o0 == 0) {
                                    i = fmg.this.O00000o.get(Integer.valueOf(intValue)).f16619O000000o;
                                    i2 = fmg.this.O00000o.get(Integer.valueOf(intValue2)).f16619O000000o;
                                } else {
                                    i = fmg.this.O00000o.get(Integer.valueOf(intValue)).O00000o0;
                                    i2 = fmg.this.O00000o.get(Integer.valueOf(intValue2)).O00000o0;
                                }
                                return i - i2;
                            }
                        });
                        Iterator it2 = arrayList7.iterator();
                        while (it2.hasNext()) {
                            Map.Entry entry2 = (Map.Entry) it2.next();
                            if (this.O00000o.get(entry2.getKey()) != null) {
                                String str = this.O00000o.get(entry2.getKey()).O00000o;
                                ArrayList arrayList8 = new ArrayList();
                                arrayList6.add(Pair.create(str, arrayList8));
                                if (((Integer) entry2.getKey()).intValue() == 17) {
                                    List list2 = (List) entry2.getValue();
                                    O00000Oo(list2);
                                    arrayList8.addAll(list2);
                                    ArrayList arrayList9 = new ArrayList();
                                    Iterator it3 = arrayList8.iterator();
                                    while (it3.hasNext()) {
                                        PluginDeviceInfo pluginDeviceInfo = (PluginDeviceInfo) it3.next();
                                        if (pluginDeviceInfo.O0000o() == Device.PID_VIRTUAL_GROUP) {
                                            arrayList9.add(pluginDeviceInfo);
                                        }
                                    }
                                    if (arrayList9.size() > 0) {
                                        arrayList8.removeAll(arrayList9);
                                        arrayList8.addAll(1, arrayList9);
                                    }
                                } else {
                                    arrayList8.addAll((List) entry2.getValue());
                                }
                            }
                        }
                        if (arrayList6.size() > 0) {
                            arrayList3.add(Pair.create(this.O000O0o0.get(entry.getKey()).O00000o, arrayList6));
                        }
                    }
                }
                this.O000O0o = arrayList3;
                this.O0000oo0 = new ArrayList();
                this.O0000oo = new ArrayList();
                for (Pair next5 : this.O000O0o) {
                    String str2 = (String) next5.first;
                    this.O0000oo.add(str2);
                    for (Pair pair : (List) next5.second) {
                        this.O0000oo0.add(new O0000OOo(str2, (String) pair.first, (List) pair.second));
                    }
                }
                this.O000O0Oo.post(new Runnable() {
                    /* class _m_j.$$Lambda$fmg$m6OwZc6zs1l8UrQ33miceclytdM */

                    public final void run() {
                        fmg.this.O00000oO();
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oO() {
        try {
            this.O0000O0o.setVisibility(8);
            this.f16609O000000o.setTabNames(this.O0000oo);
            O0000O0o o0000O0o = this.O000OO;
            List<Pair<String, List<Pair<String, List<PluginDeviceInfo>>>>> list = this.O000O0o;
            o0000O0o.f16620O000000o.clear();
            o0000O0o.f16620O000000o.addAll(list);
            o0000O0o.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.O00000oo == null) {
            int i = 0;
            this.O00000oo = layoutInflater.inflate((int) R.layout.choose_device_manually, viewGroup, false);
            this.O000O0Oo = (RecyclerView) this.O00000oo.findViewById(R.id.right_recycler);
            this.O000O0Oo.setLayoutManager(new LinearLayoutManager(getContext()));
            this.O000OO = new O0000O0o(this, (byte) 0);
            this.O000O0Oo.setAdapter(this.O000OO);
            this.O000O0Oo.addItemDecoration(new RecyclerView.O0000Oo() {
                /* class _m_j.fmg.AnonymousClass1 */

                public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
                    rect.bottom = gpc.O00000o0(fmg.this.getContext(), fmg.this.getResources().getDimension(R.dimen.choose_device_scan_list_item_vertical_margin));
                }
            });
            this.O000OO0o = this.O00000oo.findViewById(R.id.scan_title);
            this.O000OO0o.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.fmg.AnonymousClass4 */

                public final void onClick(View view) {
                    hxi.O00000o.f952O000000o.O000000o("home_adddevic_catelog_nearby_ck", new Object[0]);
                    ChooseDeviceNestedParent chooseDeviceNestedParent = (ChooseDeviceNestedParent) fmg.this.O00000oo.findViewById(R.id.nested_scroll_parent);
                    chooseDeviceNestedParent.scrollTo(0, 0);
                    chooseDeviceNestedParent.smoothScrollTo(0, 0);
                }
            });
            this.f16609O000000o = (VerticalSlidingTab) this.O00000oo.findViewById(R.id.left_list_view);
            this.O0000O0o = this.O00000oo.findViewById(R.id.loading_mask);
            View view = this.O0000O0o;
            if (!this.O0000OOo) {
                i = 4;
            }
            view.setVisibility(i);
            this.O000O0OO = this.O00000oo.findViewById(R.id.scan_view);
            this.O0000Ooo = this.O00000oo.findViewById(R.id.scan_no_device_desc);
            this.O0000Ooo.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.fmg.AnonymousClass5 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
                 arg types: [java.lang.String, int]
                 candidates:
                  _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
                  _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt */
                public final void onClick(View view) {
                    String str;
                    hxi.O00000o.O00000Oo();
                    hxi.O00000o.O0000O0o(fmg.this.O0000o0o.getCount());
                    fbt fbt = new fbt(fmg.this.getActivity(), "WebShellActivity");
                    ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
                    if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                        StringBuilder sb = new StringBuilder("https://");
                        if (O0000ooO != null) {
                            str = O0000ooO.f7546O000000o + ".";
                        } else {
                            str = "";
                        }
                        sb.append(str);
                        sb.append("home.mi.com/views/faqDetail.html?question=");
                        sb.append(fmg.this.getString(R.string.param_question_cannot_find_near_device));
                        fbt.O000000o("url", sb.toString());
                    } else {
                        fbt.O000000o("url", "https://home.mi.com/views/faqDetail.html?question=" + fmg.this.getString(R.string.param_question_cannot_find_near_device));
                    }
                    fbt.O000000o("show_feedback", false);
                    fbs.O000000o(fbt);
                }
            });
            this.O0000o = (FixHeightGridView) this.O00000oo.findViewById(R.id.llDevice);
            this.O0000o0O = this.O00000oo.findViewById(R.id.scan_device_desc);
            this.O000OO00 = this.O00000oo.findViewById(R.id.add_device_main_title);
            this.O0000oO0 = this.O00000oo.findViewById(R.id.scan_lottie_big);
            this.O0000oO = this.O00000oo.findViewById(R.id.scan_lottie_small);
            this.O0000oOo = (TextView) this.O00000oo.findViewById(R.id.more_scan_device_cnt);
            this.O0000o00 = this.O00000oo.findViewById(R.id.scan_no_device_img);
            this.O0000o0 = this.O00000oo.findViewById(R.id.scan_no_device_desc_baseline);
            this.O00oOoOo = (ChooseDeviceNestedParent) this.O00000oo.findViewById(R.id.nested_scroll_parent);
            this.O00oOoOo.setNestView(this.O000O0OO);
            this.O0000o0o = new ChooseConnectDeviceAdapter(this.mContext, this, getActivity().getIntent(), R.layout.choose_device_scan_list_item);
            this.O0000o0o.O0000O0o = new View.OnClickListener() {
                /* class _m_j.fmg.AnonymousClass6 */

                public final void onClick(View view) {
                    if (fmg.this.O0000OoO != null) {
                        fmg.this.O0000OoO.addFragment();
                    }
                }
            };
            this.O000OOo0 = getResources().getDimensionPixelOffset(R.dimen.choose_scan_device_item_width);
            this.O000OOo = getResources().getDisplayMetrics().density;
            this.O000OOOo = hzf.O000000o(getContext(), (int) (((float) this.O000OOo0) / this.O000OOo), O000OOoO);
            ChooseConnectDeviceAdapter chooseConnectDeviceAdapter = this.O0000o0o;
            int i2 = this.O000OOOo;
            chooseConnectDeviceAdapter.O0000OoO = i2;
            chooseConnectDeviceAdapter.O0000Oo = (i2 * 2) - 1;
            this.O0000o.setNumColumns(i2);
            this.O0000o.setAdapter((ListAdapter) this.O0000o0o);
            CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
                /* class _m_j.$$Lambda$fmg$aUkOTNiCBCu7oZrbftkNnHG5YQU */

                public final void run() {
                    fmg.this.O00000Oo();
                }
            });
            ((ChooseDeviceNestedParent) this.O00000oo.findViewById(R.id.nested_scroll_parent)).setOnScanViewChangeListener(new ChooseDeviceNestedParent.O000000o() {
                /* class _m_j.fmg.AnonymousClass7 */

                public final void O000000o() {
                    if (fmg.this.O000O00o != null) {
                        fmg.this.O000O00o.O000000o();
                        fmg.this.O000000o(false);
                        fmg.this.O0000oO.setVisibility(0);
                        if (fmg.this.O0000ooO > 0) {
                            fmg.this.O0000oOo.setVisibility(0);
                            TextView textView = fmg.this.O0000oOo;
                            StringBuilder sb = new StringBuilder();
                            sb.append(fmg.this.O0000ooO);
                            textView.setText(sb.toString());
                        }
                    }
                }

                public final void O00000Oo() {
                    if (fmg.this.O000O00o != null) {
                        fmg.this.O000O00o.O00000Oo();
                        fmg.this.O000000o(true);
                        if (fmg.this.O0000ooO == 0) {
                            fmg.this.O0000oO.setVisibility(8);
                        }
                        fmg.this.O0000oOo.setVisibility(4);
                    }
                }
            });
        }
        if (this.O00000o0.size() > 0) {
            O000000o(this.O00000o0);
        }
        DeviceScanManager deviceScanManager = this.O0000oOO;
        if (deviceScanManager != null) {
            deviceScanManager.getScanCache(this);
        }
        return this.O00000oo;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo() {
        CoreApi.O000000o().O000000o(getActivity(), new CoreApi.O0000o0() {
            /* class _m_j.$$Lambda$fmg$OVpzA2Sb901Q9jd69Wisn2IbwA */

            public final void onCoreReady() {
                fmg.this.O00000o0();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0() {
        if (isValid()) {
            ((ChooseDeviceActivity) getActivity()).getWorkerHandler().post(this.O000OOoo);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.transition.Transition.excludeTarget(android.view.View, boolean):android.transition.Transition}
     arg types: [android.view.View, int]
     candidates:
      ClspMth{android.transition.Transition.excludeTarget(int, boolean):android.transition.Transition}
      ClspMth{android.transition.Transition.excludeTarget(java.lang.Class, boolean):android.transition.Transition}
      ClspMth{android.transition.Transition.excludeTarget(java.lang.String, boolean):android.transition.Transition}
      ClspMth{android.transition.Transition.excludeTarget(android.view.View, boolean):android.transition.Transition} */
    public final void O000000o(boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) (this.O000OO00.getHeight() * -2), 0.0f);
                translateAnimation.setDuration(300);
                translateAnimation.setRepeatCount(0);
                this.O000OO00.startAnimation(translateAnimation);
                this.O000OO00.setVisibility(0);
            } else {
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (this.O000OO00.getHeight() * -2));
                translateAnimation2.setDuration(300);
                translateAnimation2.setRepeatCount(0);
                this.O000OO00.startAnimation(translateAnimation2);
                this.O000OO00.setVisibility(8);
            }
            TransitionSet transitionSet = new TransitionSet();
            ChangeBounds changeBounds = new ChangeBounds();
            changeBounds.excludeTarget(this.O0000oO, true);
            changeBounds.setDuration(300);
            transitionSet.addTransition(changeBounds);
            TransitionManager.beginDelayedTransition((ViewGroup) this.O00000oo, transitionSet);
        }
    }

    class O0000O0o extends RecyclerView.O000000o<O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        List<Pair<String, List<Pair<String, List<PluginDeviceInfo>>>>> f16620O000000o;

        private O0000O0o() {
            this.f16620O000000o = new ArrayList();
        }

        /* synthetic */ O0000O0o(fmg fmg, byte b) {
            this();
        }

        @SuppressLint({"SetTextI18n"})
        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ((O000000o) o000OOo0).O000000o(this.f16620O000000o.get(i));
        }

        public final int getItemCount() {
            return this.f16620O000000o.size();
        }

        class O000000o extends RecyclerView.O000OOo0 {
            O000000o(View view) {
                super(view);
            }

            public final void O000000o(Pair<String, List<Pair<String, List<PluginDeviceInfo>>>> pair) {
                ChooseCollapsedGridView chooseCollapsedGridView = (ChooseCollapsedGridView) this.itemView;
                String str = (String) pair.first;
                List list = (List) pair.second;
                chooseCollapsedGridView.O00000oO = str;
                chooseCollapsedGridView.f7216O000000o.setText(str);
                chooseCollapsedGridView.O00000o0.f7217O000000o = str;
                chooseCollapsedGridView.O00000o0.O000000o(list, true);
                chooseCollapsedGridView.O00000Oo.setVisibility(chooseCollapsedGridView.O000000o(list.size()) ? 0 : 8);
                chooseCollapsedGridView.setChooseDeviceListener(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0035: INVOKE  
                      (r0v1 'chooseCollapsedGridView' com.xiaomi.smarthome.device.choosedevice.ChooseCollapsedGridView)
                      (wrap: _m_j.-$$Lambda$fmg$O0000O0o$O000000o$UgqmmK9c9XjXIVnKVHAImBr8a9E : 0x0032: CONSTRUCTOR  (r1v4 _m_j.-$$Lambda$fmg$O0000O0o$O000000o$UgqmmK9c9XjXIVnKVHAImBr8a9E) = 
                      (r4v0 'this' _m_j.fmg$O0000O0o$O000000o A[THIS])
                      (r5v0 'pair' android.util.Pair<java.lang.String, java.util.List<android.util.Pair<java.lang.String, java.util.List<com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo>>>>)
                     call: _m_j.-$$Lambda$fmg$O0000O0o$O000000o$UgqmmK9c9XjXIVnKVHAImBr8a9E.<init>(_m_j.fmg$O0000O0o$O000000o, android.util.Pair):void type: CONSTRUCTOR)
                     type: VIRTUAL call: com.xiaomi.smarthome.device.choosedevice.ChooseCollapsedGridView.setChooseDeviceListener(_m_j.fmg$O00000o0):void in method: _m_j.fmg.O0000O0o.O000000o.O000000o(android.util.Pair<java.lang.String, java.util.List<android.util.Pair<java.lang.String, java.util.List<com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo>>>>):void, dex: classes7.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0032: CONSTRUCTOR  (r1v4 _m_j.-$$Lambda$fmg$O0000O0o$O000000o$UgqmmK9c9XjXIVnKVHAImBr8a9E) = 
                      (r4v0 'this' _m_j.fmg$O0000O0o$O000000o A[THIS])
                      (r5v0 'pair' android.util.Pair<java.lang.String, java.util.List<android.util.Pair<java.lang.String, java.util.List<com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo>>>>)
                     call: _m_j.-$$Lambda$fmg$O0000O0o$O000000o$UgqmmK9c9XjXIVnKVHAImBr8a9E.<init>(_m_j.fmg$O0000O0o$O000000o, android.util.Pair):void type: CONSTRUCTOR in method: _m_j.fmg.O0000O0o.O000000o.O000000o(android.util.Pair<java.lang.String, java.util.List<android.util.Pair<java.lang.String, java.util.List<com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo>>>>):void, dex: classes7.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 63 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.-$$Lambda$fmg$O0000O0o$O000000o$UgqmmK9c9XjXIVnKVHAImBr8a9E, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 69 more
                    */
                /*
                    this = this;
                    android.view.View r0 = r4.itemView
                    com.xiaomi.smarthome.device.choosedevice.ChooseCollapsedGridView r0 = (com.xiaomi.smarthome.device.choosedevice.ChooseCollapsedGridView) r0
                    java.lang.Object r1 = r5.first
                    java.lang.String r1 = (java.lang.String) r1
                    java.lang.Object r2 = r5.second
                    java.util.List r2 = (java.util.List) r2
                    r0.O00000oO = r1
                    android.widget.TextView r3 = r0.f7216O000000o
                    r3.setText(r1)
                    com.xiaomi.smarthome.device.choosedevice.ChooseCollapsedGridView$O000000o r3 = r0.O00000o0
                    r3.f7217O000000o = r1
                    com.xiaomi.smarthome.device.choosedevice.ChooseCollapsedGridView$O000000o r1 = r0.O00000o0
                    r3 = 1
                    r1.O000000o(r2, r3)
                    android.view.View r1 = r0.O00000Oo
                    int r2 = r2.size()
                    boolean r2 = r0.O000000o(r2)
                    if (r2 == 0) goto L_0x002b
                    r2 = 0
                    goto L_0x002d
                L_0x002b:
                    r2 = 8
                L_0x002d:
                    r1.setVisibility(r2)
                    _m_j.-$$Lambda$fmg$O0000O0o$O000000o$UgqmmK9c9XjXIVnKVHAImBr8a9E r1 = new _m_j.-$$Lambda$fmg$O0000O0o$O000000o$UgqmmK9c9XjXIVnKVHAImBr8a9E
                    r1.<init>(r4, r5)
                    r0.setChooseDeviceListener(r1)
                    _m_j.fmg$O0000O0o$O000000o$1 r5 = new _m_j.fmg$O0000O0o$O000000o$1
                    r5.<init>()
                    r0.setOnManualCategoryDeviceClicked(r5)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: _m_j.fmg.O0000O0o.O000000o.O000000o(android.util.Pair):void");
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(Pair pair, String str, String str2, List list) {
                if (fmg.this.O00000Oo != null) {
                    fmg.this.O00000Oo.chooseCategory((String) pair.first, str2, list);
                    hxi.O00000o.O00000o0(fmg.this.O000000o((String) pair.first), fmg.this.O00000Oo(str2));
                }
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.choose_device_grid_collpased_layout, viewGroup, false));
        }
    }

    public final int O000000o(String str) {
        for (Map.Entry next : this.O000O0o0.entrySet()) {
            O00000Oo o00000Oo = (O00000Oo) next.getValue();
            if (o00000Oo != null && TextUtils.equals(str, o00000Oo.O00000o)) {
                return ((Integer) next.getKey()).intValue();
            }
        }
        return -1;
    }

    public final int O00000Oo(String str) {
        for (Map.Entry next : this.O00000o.entrySet()) {
            O00000Oo o00000Oo = (O00000Oo) next.getValue();
            if (o00000Oo != null && TextUtils.equals(str, o00000Oo.O00000o)) {
                return ((Integer) next.getKey()).intValue();
            }
        }
        return -1;
    }

    public final void onScan(List<?> list) {
        this.O000Oo00.clear();
        this.O000Oo00.addAll(list);
        this.O0000ooO = list.size();
        if (this.O0000ooO == 0) {
            this.O0000oOo.setText("");
            this.O0000oOo.setVisibility(8);
            this.O0000o.setVisibility(4);
            this.O0000oO0.setVisibility(0);
            this.O0000o0O.setVisibility(0);
            if (this.O00oOooo) {
                if (O000000o()) {
                    this.O0000oO.setVisibility(0);
                } else {
                    this.O0000oO.setVisibility(8);
                }
                this.O0000Ooo.setVisibility(0);
                this.O0000o0.setVisibility(0);
                this.O0000o0O.setVisibility(4);
                this.O0000o00.setVisibility(0);
                return;
            }
            return;
        }
        this.O0000Ooo.setVisibility(4);
        this.O0000o0.setVisibility(4);
        this.O0000o00.setVisibility(4);
        this.O0000o.setVisibility(0);
        this.O0000oO0.setVisibility(4);
        this.O0000o0O.setVisibility(4);
        this.O0000oO.setVisibility(0);
        if (O000000o()) {
            this.O0000oOo.setVisibility(0);
            TextView textView = this.O0000oOo;
            StringBuilder sb = new StringBuilder();
            sb.append(this.O0000ooO);
            textView.setText(sb.toString());
        }
        this.O0000o0o.O000000o(list);
    }

    public final void onResume() {
        super.onResume();
        CommonApplication.getGlobalHandler().postDelayed(new Runnable() {
            /* class _m_j.fmg.AnonymousClass8 */

            public final void run() {
                fmg fmg = fmg.this;
                fmg.O00oOooo = true;
                if (fmg.O0000ooO == 0) {
                    fmg.this.O0000oOo.setText("");
                    fmg.this.O0000oOo.setVisibility(8);
                    fmg.this.O0000Ooo.setVisibility(0);
                    fmg.this.O0000o.setVisibility(4);
                    fmg.this.O0000oO0.setVisibility(0);
                    fmg.this.O0000o0O.setVisibility(4);
                    fmg.this.O0000Ooo.setVisibility(0);
                    fmg.this.O0000o0.setVisibility(0);
                    fmg.this.O0000o00.setVisibility(0);
                }
            }
        }, 5000);
        hxi.O00000o0.f957O000000o.O000000o("page_adddevice", new Object[0]);
    }

    private boolean O000000o() {
        ChooseDeviceNestedParent chooseDeviceNestedParent = this.O00oOoOo;
        return chooseDeviceNestedParent != null && chooseDeviceNestedParent.O00000Oo;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ int O000000o(Integer num, Integer num2) {
        if (this.O000O0o0.get(num) == null || this.O000O0o0.get(num2) == null) {
            return this.O000O0o0.get(num) == null ? -1 : 1;
        }
        return this.O000O0o0.get(num).O00000o0 - this.O000O0o0.get(num2).O00000o0;
    }

    private void O00000Oo(List<PluginDeviceInfo> list) {
        boolean z;
        if (this.O0000Oo0.size() > 0) {
            for (fni next : this.O0000Oo0) {
                Iterator<PluginDeviceInfo> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (TextUtils.equals(it.next().O00000Oo(), next.O00000o)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    PluginDeviceInfo pluginDeviceInfo = new PluginDeviceInfo();
                    pluginDeviceInfo.O00000Oo(next.f16695O000000o);
                    pluginDeviceInfo.O000000o(next.O00000o);
                    pluginDeviceInfo.O00000oO(5);
                    list.add(0, pluginDeviceInfo);
                }
            }
        }
    }

    public final void O000000o(JSONObject jSONObject) {
        try {
            this.O000O0oo = jSONObject.getString("tab_name");
            boolean z = jSONObject.getBoolean("show");
            if (!TextUtils.isEmpty(this.O000O0oo) && z) {
                JSONArray jSONArray = jSONObject.getJSONArray("newest_product");
                this.O0000Oo = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.O0000Oo.add(jSONArray.getString(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:(2:3|4)|9|10|11|12|13|14|15|16|(1:24)(2:20|22)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0029 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002f */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003a A[Catch:{ Exception -> 0x0017 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public final void O00000o0(String str) {
        if (str != null && str.length() > 0) {
            try {
                O000000o(new JSONObject(str).optJSONObject("top_category"));
            } catch (JSONException e) {
                try {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            JSONArray jSONArray = null;
            jSONArray = new JSONObject(str).getJSONArray("catgory_info");
            jSONArray = new JSONArray(str);
            O000000o(jSONArray);
            if (this.O00000o0.size() > 0 && isValid()) {
                ((ChooseDeviceActivity) getActivity()).getWorkerHandler().post(this.O0000ooo);
            }
        }
    }

    public final boolean O000000o(JSONArray jSONArray) {
        boolean z;
        JSONArray jSONArray2 = jSONArray;
        byte b = 0;
        if (jSONArray2 == null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                JSONObject jSONObject = jSONArray2.getJSONObject(i);
                O00000Oo o00000Oo = new O00000Oo(this, b);
                o00000Oo.f16619O000000o = jSONObject.optInt("id");
                o00000Oo.O00000o0 = jSONObject.optInt("rank");
                o00000Oo.O00000o = jSONObject.optString("name");
                hashMap.put(Integer.valueOf(o00000Oo.f16619O000000o), o00000Oo);
                JSONArray optJSONArray = jSONObject.optJSONArray("displaycategory");
                if (optJSONArray != null) {
                    if (optJSONArray != JSONObject.NULL) {
                        int i2 = 0;
                        while (i2 < optJSONArray.length()) {
                            O00000Oo o00000Oo2 = new O00000Oo(this, b);
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                            if (hashMap2.get(Integer.valueOf(optJSONObject.optInt("id"))) != null) {
                                ((O00000Oo) hashMap2.get(Integer.valueOf(optJSONObject.optInt("id")))).O00000Oo.add(Integer.valueOf(o00000Oo.f16619O000000o));
                            } else {
                                o00000Oo2.f16619O000000o = optJSONObject.optInt("id");
                                o00000Oo2.O00000o0 = optJSONObject.optInt("rank");
                                o00000Oo2.O00000o = optJSONObject.optString("name");
                                o00000Oo2.O00000Oo = new ArrayList<>();
                                o00000Oo2.O00000Oo.add(Integer.valueOf(o00000Oo.f16619O000000o));
                                hashMap2.put(Integer.valueOf(o00000Oo2.f16619O000000o), o00000Oo2);
                            }
                            i2++;
                            b = 0;
                        }
                        i++;
                        b = 0;
                    }
                }
                gsy.O00000o0(LogType.KUAILIAN, "ChooseDeviceManually", "displaycategory");
                i++;
                b = 0;
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
        }
        z = true;
        this.O000O0o0 = hashMap;
        this.O00000o = hashMap2;
        if (this.O000O0o0.size() <= 0 || this.O00000o.size() <= 0 || !z) {
            return false;
        }
        return true;
    }

    public final void onDetach() {
        super.onDetach();
        this.O00000Oo = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0050, code lost:
        return;
     */
    public final void O000000o(List<PluginDeviceInfo> list) {
        synchronized (this.O000O0oO) {
            if (list.size() != 0) {
                this.O00000o0 = list;
                if (getActivity() != null) {
                    if (((ChooseDeviceActivity) getActivity()).getWorkerHandler() != null) {
                        if (this.O00000oo != null) {
                            if (this.O000O0o0.size() > 0) {
                                ((ChooseDeviceActivity) getActivity()).getWorkerHandler().post(this.O0000ooo);
                            } else {
                                ((ChooseDeviceActivity) getActivity()).getWorkerHandler().post(this.O000OOoo);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int O000000o2 = hzf.O000000o(getContext(), (int) (((float) this.O000OOo0) / this.O000OOo), O000OOoO);
        if (this.O000OOOo != O000000o2) {
            this.O000OOOo = O000000o2;
            ChooseConnectDeviceAdapter chooseConnectDeviceAdapter = this.O0000o0o;
            int i = this.O000OOOo;
            chooseConnectDeviceAdapter.O0000OoO = i;
            this.O0000o.setNumColumns(i);
            onScan(this.O000Oo00);
        }
    }

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        int f16619O000000o;
        ArrayList<Integer> O00000Oo;
        String O00000o;
        int O00000o0;

        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(fmg fmg, byte b) {
            this();
        }
    }
}

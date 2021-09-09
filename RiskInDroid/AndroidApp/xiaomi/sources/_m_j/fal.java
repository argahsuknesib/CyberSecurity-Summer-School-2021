package _m_j;

import _m_j.fsn;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.auth.bindaccount.model.ThirdAccount;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class fal {

    /* renamed from: O000000o  reason: collision with root package name */
    public static volatile fal f16012O000000o;
    public volatile List<ThirdAccount> O00000Oo = new ArrayList();
    public List<fsm> O00000o = new ArrayList();
    public volatile boolean O00000o0 = false;

    @cug
    public static fal getInstance() {
        if (f16012O000000o == null) {
            synchronized (fal.class) {
                if (f16012O000000o == null) {
                    f16012O000000o = new fal();
                }
            }
        }
        return f16012O000000o;
    }

    public final ThirdAccount O000000o(String str) {
        List<ThirdAccount> list = this.O00000Oo;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                ThirdAccount thirdAccount = list.get(i);
                if (thirdAccount != null && TextUtils.equals(thirdAccount.O00000Oo, str)) {
                    return thirdAccount;
                }
            }
        }
        return null;
    }

    public final Pair<Integer, ThirdAccount> O00000Oo(String str) {
        List<ThirdAccount> list = this.O00000Oo;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                ThirdAccount thirdAccount = list.get(i);
                if (thirdAccount != null && TextUtils.equals(thirdAccount.O00000Oo, str)) {
                    return new Pair<>(Integer.valueOf(i), thirdAccount);
                }
            }
        }
        return null;
    }

    public final List<Device> O000000o() {
        List<Device> list;
        ArrayList arrayList = new ArrayList();
        List<ThirdAccount> list2 = this.O00000Oo;
        if (list2 != null && !list2.isEmpty()) {
            for (int i = 0; i < list2.size(); i++) {
                ThirdAccount thirdAccount = list2.get(i);
                if (!(thirdAccount == null || thirdAccount.O00000oO == null || (list = thirdAccount.O00000oO) == null || list.isEmpty())) {
                    arrayList.addAll(list);
                }
            }
        }
        return arrayList;
    }

    public final void O000000o(fsm<Void, fso> fsm) {
        if (f16012O000000o != null) {
            if (fsm != null) {
                this.O00000o.add(fsm);
            }
            if (!this.O00000o0) {
                this.O00000o0 = true;
                O00000Oo(new fsm<Void, fso>() {
                    /* class _m_j.fal.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                        if (fal.f16012O000000o != null) {
                            fal.this.O00000o0 = false;
                            for (int i = 0; i < fal.this.O00000o.size(); i++) {
                                fsm fsm = fal.this.O00000o.get(i);
                                if (fsm != null) {
                                    fsm.onFailure(fso);
                                }
                            }
                            fal.this.O00000o.clear();
                        }
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        if (fal.f16012O000000o != null) {
                            ArrayList arrayList = new ArrayList();
                            List<ThirdAccount> list = fal.this.O00000Oo;
                            for (int i = 0; i < list.size(); i++) {
                                ThirdAccount thirdAccount = list.get(i);
                                if (thirdAccount != null) {
                                    arrayList.add(thirdAccount.O00000Oo);
                                }
                            }
                            fal.this.O000000o(arrayList, new fsm<Map<String, List<Device>>, fso>() {
                                /* class _m_j.fal.AnonymousClass1.AnonymousClass1 */

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    List<Device> list;
                                    Map map = (Map) obj;
                                    if (fal.f16012O000000o != null) {
                                        List<ThirdAccount> list2 = fal.this.O00000Oo;
                                        for (int i = 0; i < list2.size(); i++) {
                                            ThirdAccount thirdAccount = list2.get(i);
                                            if (!(thirdAccount == null || TextUtils.isEmpty(thirdAccount.O00000Oo) || (list = (List) map.get(thirdAccount.O00000Oo)) == null)) {
                                                thirdAccount.O00000oO = list;
                                            }
                                        }
                                        fal.this.O00000o0 = false;
                                        for (int i2 = 0; i2 < fal.this.O00000o.size(); i2++) {
                                            fsm fsm = fal.this.O00000o.get(i2);
                                            if (fsm != null) {
                                                fsm.onSuccess(null);
                                            }
                                        }
                                        fal.this.O00000o.clear();
                                        fal.this.O00000Oo();
                                    }
                                }

                                public final void onFailure(fso fso) {
                                    if (fal.f16012O000000o != null) {
                                        fal.this.O00000o0 = false;
                                        for (int i = 0; i < fal.this.O00000o.size(); i++) {
                                            fsm fsm = fal.this.O00000o.get(i);
                                            if (fsm != null) {
                                                fsm.onFailure(fso);
                                            }
                                        }
                                        fal.this.O00000o.clear();
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    public final void O00000Oo() {
        exo stateNotifier;
        List<ThirdAccount> list = this.O00000Oo;
        if (list != null && (stateNotifier = ServiceApplication.getStateNotifier()) != null && stateNotifier.f15923O000000o == 4) {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                ThirdAccount thirdAccount = list.get(i);
                if (thirdAccount != null) {
                    jSONArray.put(thirdAccount.O000000o());
                }
            }
            Context appContext = CommonApplication.getAppContext();
            appContext.getSharedPreferences("third_cloud_account_sp_" + grv.O000000o(CoreApi.O000000o().O0000o0()), 0).edit().putString("sp_content", jSONArray.toString()).apply();
        }
    }

    public final void O000000o(final List<String> list, final fsm<Map<String, List<Device>>, fso> fsm) {
        goq.O000000o(new Runnable() {
            /* class _m_j.fal.AnonymousClass2 */

            public final void run() {
                fru O000000o2 = fru.O000000o();
                List<String> list = list;
                AnonymousClass1 r2 = new fsm<JSONObject, fso>() {
                    /* class _m_j.fal.AnonymousClass2.AnonymousClass1 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (fal.f16012O000000o != null && jSONObject != null) {
                            try {
                                if (!jSONObject.isNull("list")) {
                                    Object obj2 = jSONObject.get("list");
                                    if (obj2 == null) {
                                        return;
                                    }
                                    if (obj2 instanceof JSONArray) {
                                        JSONArray jSONArray = (JSONArray) obj2;
                                        HashMap hashMap = new HashMap();
                                        if (jSONArray.length() != 0) {
                                            for (int i = 0; i < jSONArray.length(); i++) {
                                                Object obj3 = jSONArray.get(i);
                                                if (obj3 != null && (obj3 instanceof JSONObject) && !((JSONObject) obj3).isNull("dev_list")) {
                                                    JSONArray optJSONArray = ((JSONObject) obj3).optJSONArray("dev_list");
                                                    if (optJSONArray.length() != 0) {
                                                        String optString = ((JSONObject) obj3).optString("group_id");
                                                        ArrayList arrayList = new ArrayList();
                                                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                                            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                                                            Device device = new Device();
                                                            device.did = optJSONObject.optString("did");
                                                            device.name = optJSONObject.optString("name");
                                                            device.model = optJSONObject.optString("model");
                                                            if (device.propInfo == null) {
                                                                device.propInfo = new JSONObject();
                                                            }
                                                            device.propInfo.put("third_cloud_device_icon", optJSONObject.opt("icon_url"));
                                                            device.propInfo.put("third_cloud_device_group_id", optString);
                                                            arrayList.add(device);
                                                        }
                                                        ThirdAccount O000000o2 = fal.this.O000000o(optString);
                                                        if (O000000o2 != null) {
                                                            O000000o2.O00000oO = arrayList;
                                                            if (!((JSONObject) obj3).isNull("bind_status")) {
                                                                O000000o2.O00000oo = ((JSONObject) obj3).optInt("bind_status", -1);
                                                            }
                                                            fal.this.O00000Oo();
                                                        }
                                                        hashMap.put(optString, arrayList);
                                                    }
                                                }
                                            }
                                        }
                                        if (fsm != null) {
                                            fsm.onSuccess(hashMap);
                                        }
                                    }
                                } else if (fsm != null) {
                                    fsm.onFailure(new fso(Integer.MIN_VALUE, jSONObject.toString()));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                if (fsm != null) {
                                    fsm.onFailure(new fso(Integer.MIN_VALUE, e.getMessage()));
                                }
                            }
                        }
                    }

                    public final void onFailure(fso fso) {
                        if (fsm != null) {
                            fsm.onFailure(fso);
                        }
                    }
                };
                if (list == null || list.isEmpty()) {
                    r2.onFailure(new fso(Integer.MIN_VALUE, "empty groupIds list"));
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (String parseLong : list) {
                    sb.append(Long.parseLong(parseLong) + ",");
                }
                sb.delete(sb.length() - 1, sb.length());
                String sb2 = sb.toString();
                fsn.O000000o o000000o = new fsn.O000000o();
                o000000o.O000000o(O000000o2.O000000o(sb2, (String) null, new fsm<JSONObject, fso>(r2, o000000o, sb2) {
                    /* class _m_j.fru.AnonymousClass24 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ fsm f17006O000000o;
                    final /* synthetic */ fsn.O000000o O00000Oo;
                    final /* synthetic */ String O00000o0;
                    private JSONObject O00000oO;
                    private JSONArray O00000oo;

                    {
                        this.f17006O000000o = r2;
                        this.O00000Oo = r3;
                        this.O00000o0 = r4;
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (jSONObject == null) {
                            fsm fsm = this.f17006O000000o;
                            if (fsm != null) {
                                fsm.onSuccess(jSONObject);
                                return;
                            }
                            return;
                        }
                        if (this.O00000oO == null) {
                            this.O00000oO = jSONObject;
                        }
                        try {
                            if (!jSONObject.isNull("list")) {
                                Object obj2 = jSONObject.get("list");
                                if (obj2 instanceof JSONArray) {
                                    JSONArray jSONArray = (JSONArray) obj2;
                                    if (this.O00000oo == null) {
                                        this.O00000oO = jSONObject;
                                        this.O00000oo = jSONArray;
                                    } else {
                                        for (int i = 0; i < jSONArray.length(); i++) {
                                            this.O00000oo.put(jSONArray.opt(i));
                                        }
                                    }
                                }
                            }
                        } catch (JSONException e) {
                            gsy.O000000o(6, "RemoteFamilyApi", Log.getStackTraceString(e));
                        }
                        if (jSONObject.optBoolean("has_more")) {
                            this.O00000Oo.O000000o(fru.this.O000000o(this.O00000o0, jSONObject.optString("next_start_did"), this));
                            return;
                        }
                        fsm fsm2 = this.f17006O000000o;
                        if (fsm2 != null) {
                            fsm2.onSuccess(this.O00000oO);
                        }
                    }

                    public final void onFailure(fso fso) {
                        this.f17006O000000o.onFailure(fso);
                    }
                }));
            }
        });
    }

    public final void O00000Oo(final fsm<Void, fso> fsm) {
        goq.O000000o(new Runnable() {
            /* class _m_j.fal.AnonymousClass3 */

            public final void run() {
                fru.O000000o().O00000o0(new fsm<JSONObject, fso>() {
                    /* class _m_j.fal.AnonymousClass3.AnonymousClass1 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (fal.f16012O000000o != null && jSONObject != null) {
                            try {
                                if (!jSONObject.isNull("group_list")) {
                                    Object obj2 = jSONObject.get("group_list");
                                    if (obj2 == null) {
                                        return;
                                    }
                                    if (obj2 instanceof JSONArray) {
                                        JSONArray jSONArray = (JSONArray) obj2;
                                        final ArrayList arrayList = new ArrayList();
                                        ArrayList arrayList2 = new ArrayList();
                                        if (jSONArray.length() != 0) {
                                            for (int i = 0; i < jSONArray.length(); i++) {
                                                Object obj3 = jSONArray.get(i);
                                                if (obj3 != null && (obj3 instanceof JSONObject)) {
                                                    ThirdAccount O000000o2 = ThirdAccount.O000000o((JSONObject) obj3);
                                                    arrayList.add(O000000o2);
                                                    arrayList2.add(O000000o2.O00000Oo);
                                                }
                                            }
                                        }
                                        fal.this.O000000o(arrayList2, new fsm<Map<String, List<Device>>, fso>() {
                                            /* class _m_j.fal.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                            public final /* synthetic */ void onSuccess(Object obj) {
                                                Map map = (Map) obj;
                                                if (fal.f16012O000000o == null) {
                                                    return;
                                                }
                                                if (map == null) {
                                                    fal.this.O00000Oo = arrayList;
                                                    if (fsm != null) {
                                                        fsm.onSuccess(null);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                for (int i = 0; i < arrayList.size(); i++) {
                                                    ThirdAccount thirdAccount = (ThirdAccount) arrayList.get(i);
                                                    if (thirdAccount != null) {
                                                        thirdAccount.O00000oO = (List) map.get(thirdAccount.O00000Oo);
                                                    }
                                                }
                                                fal.this.O00000Oo = arrayList;
                                                if (fsm != null) {
                                                    fsm.onSuccess(null);
                                                }
                                            }

                                            public final void onFailure(fso fso) {
                                                if (fal.f16012O000000o != null && fsm != null) {
                                                    fsm.onFailure(fso);
                                                }
                                            }
                                        });
                                    }
                                } else if (fsm != null) {
                                    fsm.onFailure(new fso(Integer.MIN_VALUE, jSONObject.toString()));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                if (fsm != null) {
                                    fsm.onFailure(new fso(Integer.MIN_VALUE, e.getMessage()));
                                }
                            }
                        }
                    }

                    public final void onFailure(fso fso) {
                        if (fal.f16012O000000o != null && fsm != null) {
                            fsm.onFailure(fso);
                        }
                    }
                });
            }
        });
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static Map<String, String> f16021O000000o = new ConcurrentHashMap();
        public static Object O00000Oo = new Object();
        public static Handler O00000o = new Handler(CommonApplication.getGlobalWorkerHandler().getLooper()) {
            /* class _m_j.fal.O000000o.AnonymousClass1 */

            public final void handleMessage(Message message) {
                if (message.obj != null && (message.obj instanceof String)) {
                    String str = (String) message.obj;
                    synchronized (O000000o.O00000Oo) {
                        O000000o.O00000o(str);
                        O000000o.f16021O000000o.remove(str);
                    }
                }
            }
        };
        public static final int O00000o0 = ((int) ((Math.random() * 1.0E7d) + 1.0E7d));

        public static boolean O000000o(final String str) {
            synchronized (O00000Oo) {
                if (f16021O000000o.containsKey(str)) {
                    return false;
                }
                f16021O000000o.put(str, str);
                O00000o.sendMessageDelayed(O00000o.obtainMessage(O00000o0 + str.hashCode(), str), DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
                fru.O000000o().O00000o(str, new fsm<JSONObject, fso>() {
                    /* class _m_j.fal.O000000o.AnonymousClass2 */

                    public final void onFailure(fso fso) {
                        String str;
                        if (fal.f16012O000000o != null) {
                            gsy.O00000Oo(20000, "20000.2.1", "");
                            if ("sync_dev failed:".concat(String.valueOf(fso)) == null) {
                                str = null;
                            } else {
                                str = fso.f17063O000000o + "," + fso.O00000Oo;
                            }
                            gsy.O00000Oo("ThirdAccountBindManager", str);
                            O000000o.O00000o.removeMessages(O000000o.O00000o0 + str.hashCode());
                            O000000o.O000000o(str, fso);
                            synchronized (O000000o.O00000Oo) {
                                O000000o.f16021O000000o.remove(str);
                            }
                        }
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        if (fal.f16012O000000o != null) {
                            O000000o.O00000o.removeMessages(O000000o.O00000o0 + str.hashCode());
                            O000000o.O00000o0(str);
                            synchronized (O000000o.O00000Oo) {
                                O000000o.f16021O000000o.remove(str);
                            }
                        }
                    }
                });
                return true;
            }
        }

        public static boolean O00000Oo(String str) {
            return f16021O000000o.containsKey(str);
        }

        public static void O00000o0(String str) {
            Intent intent = new Intent("filter_sync_dev");
            intent.putExtra("sync_dev_code", 0);
            intent.putExtra("sync_dev_groupid", str);
            ft.O000000o(CommonApplication.getAppContext()).O000000o(intent);
        }

        public static void O000000o(String str, fso fso) {
            Intent intent = new Intent("filter_sync_dev");
            intent.putExtra("sync_dev_code", fso == null ? -2147483647 : fso.f17063O000000o);
            intent.putExtra("sync_dev_groupid", str);
            ft.O000000o(CommonApplication.getAppContext()).O000000o(intent);
        }

        public static void O00000o(String str) {
            Intent intent = new Intent("filter_sync_dev");
            intent.putExtra("sync_dev_code", Integer.MIN_VALUE);
            intent.putExtra("sync_dev_groupid", str);
            ft.O000000o(CommonApplication.getAppContext()).O000000o(intent);
        }
    }

    public static boolean O00000o0(String str) {
        if (O000000o.O00000Oo(str)) {
            return false;
        }
        return O000000o.O000000o(str);
    }

    public static boolean O00000o(String str) {
        return O000000o.O00000Oo(str);
    }

    public static void O000000o(SimpleDraweeView simpleDraweeView, String str) {
        Uri uri;
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase("null")) {
            uri = gqd.O000000o((int) R.drawable.third_account_default_icon);
        } else {
            uri = Uri.parse(str);
        }
        if (Fresco.getDraweeControllerBuilderSupplier() != null) {
            if (simpleDraweeView.getHierarchy() == null) {
                simpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(simpleDraweeView.getResources()).setFadeDuration(200).setPlaceholderImage(simpleDraweeView.getResources().getDrawable(R.drawable.user_default)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY).setPlaceholderImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).build());
            }
            simpleDraweeView.setController((PipelineDraweeController) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setImageRequest(ImageRequestBuilder.newBuilderWithSource(uri).setPostprocessor(new gny()).build())).setOldController(simpleDraweeView.getController())).build());
        }
    }
}

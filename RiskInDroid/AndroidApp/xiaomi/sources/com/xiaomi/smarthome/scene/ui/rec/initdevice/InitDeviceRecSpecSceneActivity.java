package com.xiaomi.smarthome.scene.ui.rec.initdevice;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fnn;
import _m_j.fno;
import _m_j.fso;
import _m_j.fsy;
import _m_j.ggb;
import _m_j.gqg;
import _m_j.gzb;
import _m_j.hnz;
import _m_j.hof;
import _m_j.hog;
import _m_j.hoh;
import _m_j.hpw;
import _m_j.hql;
import _m_j.hqm;
import _m_j.hqn;
import _m_j.hqo;
import _m_j.hqs;
import _m_j.hri;
import _m_j.hrj;
import _m_j.hxi;
import _m_j.hxr;
import _m_j.izb;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.spec.instance.SpecDevice;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.scene.ui.rec.initdevice.InitDeviceRecSpecSceneActivity;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function4;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

public class InitDeviceRecSpecSceneActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    Map<Integer, hog> f11297O000000o = new TreeMap();
    private String O00000Oo;
    private boolean O00000o;
    private boolean O00000o0;
    private boolean O00000oO;
    private int O00000oo;
    private int O0000O0o;
    private String O0000OOo;
    private ArrayList<hog> O0000Oo0;
    public gzb mControl = new gzb(this);
    public Device mDevice;
    public XQProgressDialog mPD;
    public int setItems = 0;

    public void onBackPressed() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_init_device_rec_scene_v2);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("device_id");
        this.O00000oo = getIntent().getIntExtra("step_count", 0);
        this.O0000O0o = getIntent().getIntExtra("current_step", 2) + 1;
        this.O00000o0 = intent.getBooleanExtra("can_jump_mibrain", false);
        this.O00000oO = intent.getBooleanExtra("can_show_misound_gateway_switch", false);
        this.O00000o = intent.getBooleanExtra("can_jump_share", false);
        if (!TextUtils.isEmpty(stringExtra)) {
            this.mDevice = fno.O000000o().O000000o(stringExtra);
        }
        if (this.mDevice == null) {
            String stringExtra2 = intent.getStringExtra("device_mac");
            if (!TextUtils.isEmpty(stringExtra2)) {
                this.mDevice = fno.O000000o().O00000o(stringExtra2);
            }
        }
        if (this.mDevice == null) {
            finish();
            return;
        }
        Home O0000o0 = ggb.O00000Oo().O0000o0(this.mDevice.did);
        if (O0000o0 == null) {
            finish();
            return;
        }
        this.O0000OOo = O0000o0.getId();
        DeviceTagInterface.Category O00000o02 = fnn.O000000o().O00000Oo().O00000o0(this.mDevice.model);
        if (O00000o02 != null) {
            this.O00000Oo = O00000o02.name;
        }
        if (!hrj.O000000o().O00000Oo()) {
            goNextStep();
            return;
        }
        this.O0000Oo0 = hrj.O000000o().f562O000000o;
        if (this.O0000Oo0 != null) {
            O000000o o000000o = new O000000o();
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.scene_rv);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(o000000o);
            ArrayList<hog> arrayList = this.O0000Oo0;
            o000000o.f11303O000000o.clear();
            o000000o.f11303O000000o.addAll(arrayList);
            o000000o.notifyDataSetChanged();
            DeviceFactory.O00000Oo(this.mDevice.model, (SimpleDraweeView) findViewById(R.id.device_img));
            TextView textView = (TextView) findViewById(R.id.device_name);
            if (!TextUtils.isEmpty(this.mDevice.name)) {
                textView.setText(this.mDevice.name);
            } else {
                textView.setText("");
            }
            TextView textView2 = (TextView) findViewById(R.id.go_next);
            textView2.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.ui.rec.initdevice.$$Lambda$InitDeviceRecSpecSceneActivity$Yz6Fyr9ThCzW1jYYPiilkv5yqz0 */

                public final void onClick(View view) {
                    InitDeviceRecSpecSceneActivity.this.O000000o(view);
                }
            });
            TextView textView3 = (TextView) findViewById(R.id.step);
            if (this.O00000oo > 0) {
                textView3.setText(this.O0000O0o + "/" + this.O00000oo);
            } else {
                textView3.setText("");
            }
            if (this.O0000O0o != this.O00000oo) {
                textView2.setBackgroundResource(R.drawable.common_button_grey_bg);
                textView2.setTextColor(getResources().getColor(R.color.mj_color_green_normal));
                textView2.setText((int) R.string.next);
            } else {
                textView2.setText((int) R.string.init_device_start_use);
                textView2.setTextColor(getResources().getColor(R.color.mj_color_white));
                textView2.setBackgroundResource(R.drawable.common_button_green_bg);
            }
            O000000o(this.O0000Oo0);
        }
    }

    private void O000000o(ArrayList<hog> arrayList) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                hxr hxr = hxi.O00000oO;
                String str = this.O0000OOo;
                String str2 = this.mDevice.did;
                String str3 = this.mDevice.model;
                long j = 0;
                long longValue = arrayList.get(i).O00000o0 == null ? 0 : arrayList.get(i).O00000o0.O00000Oo.longValue();
                if (arrayList.get(i).O00000o != null) {
                    j = arrayList.get(i).O00000o.O00000Oo;
                }
                hxr.f958O000000o.O000000o("connect_template_show", "homeid", str, "did", str2, "model", str3, "state", Integer.valueOf(O000000o(arrayList.get(i).O00000o)), "us_id", Long.valueOf(j), "templateid", Long.valueOf(longValue));
            }
        }
    }

    private static int O000000o(hoh hoh) {
        if (hoh == null || hoh.O00000Oo <= 0) {
            return 1;
        }
        return hoh.O00000o0 ? 2 : 3;
    }

    public void onResume() {
        super.onResume();
        if (this.O0000O0o == this.O00000oo) {
            this.mControl.f18610O000000o = true;
        }
    }

    public void onPause() {
        super.onPause();
        if (this.O0000O0o == this.O00000oo) {
            this.mControl.O00000Oo();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        if (this.f11297O000000o.isEmpty()) {
            goNextStep();
            return;
        }
        Map<Integer, hog> map = this.f11297O000000o;
        if (!(map == null || map.size() == 0)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("homeid", this.O0000OOo);
                jSONObject.put("did", this.mDevice.did);
                jSONObject.put("model", this.mDevice.model);
                int i = 1;
                for (Map.Entry next : map.entrySet()) {
                    long j = 0;
                    jSONObject.put("templateid".concat(String.valueOf(i)), ((hog) next.getValue()).O00000o0 == null ? 0 : ((hog) next.getValue()).O00000o0.O00000Oo.longValue());
                    String concat = "us_id".concat(String.valueOf(i));
                    if (((hog) next.getValue()).O00000o != null) {
                        j = ((hog) next.getValue()).O00000o.O00000Oo;
                    }
                    jSONObject.put(concat, j);
                    jSONObject.put("state".concat(String.valueOf(i)), O000000o(((hog) next.getValue()).O00000o));
                    i++;
                }
                hxi.O00000o.f952O000000o.O000000o("connect_templatesave_click", jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        O000000o();
    }

    private void O000000o() {
        this.mPD = XQProgressDialog.O000000o(this, null, getResources().getString(R.string.smarthome_scene_saving_scene));
        this.setItems = 0;
        for (Map.Entry<Integer, hog> value : this.f11297O000000o.entrySet()) {
            final hog hog = (hog) value.getValue();
            final String id = ggb.O00000Oo().O0000o0(this.mDevice.did).getId();
            final hof hof = hog.O00000o0;
            hri.O000000o(ggb.O00000Oo().O0000Oo(id), hof).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<SparseArray<Map<String, SpecDevice>>>() {
                /* class com.xiaomi.smarthome.scene.ui.rec.initdevice.InitDeviceRecSpecSceneActivity.AnonymousClass1 */

                public final void onComplete() {
                }

                public final void onError(Throwable th) {
                }

                public final void onSubscribe(Disposable disposable) {
                }

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.hri.O000000o(java.lang.String, _m_j.hof, java.util.Map<java.lang.String, com.xiaomi.smarthome.device.api.spec.instance.SpecDevice>, boolean):io.reactivex.Observable<android.util.SparseArray<java.util.ArrayList<com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage$O0000Oo>>>
                 arg types: [java.lang.String, _m_j.hof, java.util.Map, int]
                 candidates:
                  _m_j.hri.O000000o(java.lang.String, java.util.List<_m_j.hof$O00000o0$O00000o0>, int, java.util.Map<java.lang.Integer, com.xiaomi.smarthome.device.api.spec.instance.SpecProperty>):java.util.List<_m_j.hrc>
                  _m_j.hri.O000000o(_m_j.hof, java.util.Map, boolean, io.reactivex.ObservableEmitter):void
                  _m_j.hri.O000000o(java.lang.String, _m_j.hof, java.util.Map<java.lang.String, com.xiaomi.smarthome.device.api.spec.instance.SpecDevice>, boolean):io.reactivex.Observable<android.util.SparseArray<java.util.ArrayList<com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage$O0000Oo>>> */
                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.hri.O000000o(_m_j.hof, java.util.Map<java.lang.String, com.xiaomi.smarthome.device.api.spec.instance.SpecDevice>, boolean):io.reactivex.Observable<android.util.SparseArray<java.util.ArrayList<java.util.ArrayList<com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage$O0000Oo>>>>
                 arg types: [_m_j.hof, java.util.Map, int]
                 candidates:
                  _m_j.hri.O000000o(_m_j.hof$O00000o, _m_j.hof$O0000O0o, _m_j.hof$O00000o0):android.util.SparseArray
                  _m_j.hri.O000000o(java.lang.Object, int, java.util.Map<java.lang.Integer, com.xiaomi.smarthome.device.api.spec.instance.SpecProperty>):java.lang.Object
                  _m_j.hri.O000000o(long, android.content.Context, io.reactivex.ObservableEmitter):void
                  _m_j.hri.O000000o(java.util.List, _m_j.hof, io.reactivex.ObservableEmitter):void
                  _m_j.hri.O000000o(_m_j.hof, java.util.Map<java.lang.String, com.xiaomi.smarthome.device.api.spec.instance.SpecDevice>, boolean):io.reactivex.Observable<android.util.SparseArray<java.util.ArrayList<java.util.ArrayList<com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage$O0000Oo>>>> */
                public final /* synthetic */ void onNext(Object obj) {
                    SparseArray sparseArray = (SparseArray) obj;
                    Observable.zip(hri.O000000o(InitDeviceRecSpecSceneActivity.this, hog.O00000o == null ? -1 : hog.O00000o.O00000Oo), hri.O000000o(id, hof, (Map<String, SpecDevice>) (sparseArray.get(0) == null ? new TreeMap() : (Map) sparseArray.get(0)), false), hri.O00000Oo(id, hof, sparseArray.get(1) == null ? new TreeMap() : (Map) sparseArray.get(1), false), hri.O000000o(hof, (Map<String, SpecDevice>) (sparseArray.get(2) == null ? new TreeMap() : (Map) sparseArray.get(2)), false), new Function4(hof, id) {
                        /* class com.xiaomi.smarthome.scene.ui.rec.initdevice.$$Lambda$InitDeviceRecSpecSceneActivity$1$T4qexSgWKxaQNo1Pah7TPOPFuCE */
                        private final /* synthetic */ hof f$1;
                        private final /* synthetic */ String f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
                            return InitDeviceRecSpecSceneActivity.AnonymousClass1.this.O000000o(this.f$1, this.f$2, (JSONObject) obj, (SparseArray) obj2, (SparseArray) obj3, (SparseArray) obj4);
                        }
                    }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<hqs>() {
                        /* class com.xiaomi.smarthome.scene.ui.rec.initdevice.InitDeviceRecSpecSceneActivity.AnonymousClass1.AnonymousClass1 */

                        public final /* synthetic */ void accept(Object obj) throws Exception {
                            InitDeviceRecSpecSceneActivity.this.saveOneScene((hqs) obj);
                        }
                    }, new Consumer<Throwable>() {
                        /* class com.xiaomi.smarthome.scene.ui.rec.initdevice.InitDeviceRecSpecSceneActivity.AnonymousClass1.AnonymousClass2 */

                        public final /* synthetic */ void accept(Object obj) throws Exception {
                            if (InitDeviceRecSpecSceneActivity.this.mPD != null && InitDeviceRecSpecSceneActivity.this.mPD.isShowing()) {
                                InitDeviceRecSpecSceneActivity.this.mPD.dismiss();
                            }
                            InitDeviceRecSpecSceneActivity.this.goNextStep();
                        }
                    });
                }

                /* access modifiers changed from: private */
                public /* synthetic */ hqs O000000o(hof hof, String str, JSONObject jSONObject, SparseArray sparseArray, SparseArray sparseArray2, SparseArray sparseArray3) throws Exception {
                    char c;
                    Object o_;
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    if (sparseArray != null && sparseArray.size() > 0) {
                        if (sparseArray.get(0) != null && ((ArrayList) sparseArray.get(0)).size() > 0) {
                            arrayList2.addAll((Collection) sparseArray.get(0));
                        }
                        if (sparseArray.get(1) != null && ((ArrayList) sparseArray.get(1)).size() > 0) {
                            arrayList3.addAll((Collection) sparseArray.get(1));
                        }
                    }
                    if (sparseArray2 != null && sparseArray2.size() > 0) {
                        if (sparseArray2.get(0) != null && ((ArrayList) sparseArray2.get(0)).size() > 0) {
                            arrayList2.addAll((Collection) sparseArray2.get(0));
                        }
                        if (sparseArray2.get(1) != null && ((ArrayList) sparseArray2.get(1)).size() > 0) {
                            arrayList3.addAll((Collection) sparseArray2.get(1));
                        }
                    }
                    if (sparseArray3 != null && sparseArray3.size() > 0) {
                        if (sparseArray3.get(0) != null && ((ArrayList) sparseArray3.get(0)).size() > 0) {
                            for (int i = 0; i < ((ArrayList) sparseArray3.get(0)).size(); i++) {
                                arrayList2.addAll((Collection) ((ArrayList) sparseArray3.get(0)).get(i));
                            }
                        }
                        if (sparseArray3.get(1) != null && ((ArrayList) sparseArray3.get(1)).size() > 0) {
                            for (int i2 = 0; i2 < ((ArrayList) sparseArray3.get(1)).size(); i2++) {
                                arrayList3.addAll((Collection) ((ArrayList) sparseArray3.get(1)).get(i2));
                            }
                        }
                    }
                    if (arrayList2.size() > 0) {
                        arrayList.addAll(arrayList2);
                    }
                    if (arrayList3.size() > 0) {
                        arrayList.addAll(arrayList3);
                    }
                    int i3 = 0;
                    while (true) {
                        if (i3 >= arrayList.size()) {
                            c = 65535;
                            break;
                        }
                        if ((arrayList.get(i3) instanceof hpw) && TextUtils.equals(((hpw) arrayList.get(i3)).O00000Oo(), InitDeviceRecSpecSceneActivity.this.mDevice.did)) {
                            if (arrayList.get(i3) instanceof hqn) {
                                c = 1;
                                break;
                            } else if (arrayList.get(i3) instanceof hqo) {
                                c = 2;
                                break;
                            } else if (arrayList.get(i3) instanceof hqm) {
                                c = 3;
                                break;
                            }
                        }
                        i3++;
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        if ((arrayList.get(size) instanceof hpw) && !TextUtils.equals(((hpw) arrayList.get(size)).O00000Oo(), InitDeviceRecSpecSceneActivity.this.mDevice.did)) {
                            if ((arrayList.get(size) instanceof hqn) && c == 1) {
                                arrayList.remove(size);
                            } else if ((arrayList.get(size) instanceof hqo) && c == 2) {
                                arrayList.remove(size);
                            } else if ((arrayList.get(size) instanceof hqm) && c == 3) {
                                arrayList.remove(size);
                            }
                        }
                    }
                    hqs hqs = new hqs();
                    hqs.O00000Oo = hof.O00000Oo.longValue();
                    hqs.O00000o = hof.O00000oO;
                    hqs.O0000OOo = hof.O0000oOO.booleanValue();
                    hqs.O0000Ooo = hof.O0000oo0.O00000o;
                    hqs.O0000o0 = hof.O0000oOo.O00000o;
                    hqs.O0000o0o = jSONObject;
                    hqs O000000o2 = hqs.O000000o(hqs.O0000o0o);
                    if (O000000o2.f529O000000o <= 0) {
                        hqs.O0000O0o = hof.O0000oO.booleanValue();
                        hqs.O00000o0 = str;
                    } else {
                        hqs.f529O000000o = O000000o2.f529O000000o;
                        hqs.O0000O0o = O000000o2.O0000O0o;
                        hqs.O00000o0 = O000000o2.O00000o0;
                        hqs.O0000OoO.addAll(O000000o2.O0000OoO);
                        hqs.O0000o00.addAll(O000000o2.O0000o00);
                        hqs.O0000o0O.addAll(O000000o2.O0000o0O);
                    }
                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                        if ((arrayList.get(i4) instanceof hql) && (o_ = ((hql) arrayList.get(i4)).o_()) != null) {
                            if (o_ instanceof hqs.O00000o0) {
                                hqs.O00000o0 o00000o0 = (hqs.O00000o0) o_;
                                if (!InitDeviceRecSpecSceneActivity.this.findCondition(o00000o0, hqs.O0000OoO)) {
                                    hqs.O0000OoO.add(o00000o0);
                                }
                            } else if (o_ instanceof hqs.O0000Oo0) {
                                hqs.O0000Oo0 o0000Oo0 = (hqs.O0000Oo0) o_;
                                if (!InitDeviceRecSpecSceneActivity.this.findTrigger(o0000Oo0, hqs.O0000o00)) {
                                    hqs.O0000o00.add(o0000Oo0);
                                }
                            } else if (o_ instanceof hqs.O000000o) {
                                hqs.O000000o o000000o = (hqs.O000000o) o_;
                                if (!InitDeviceRecSpecSceneActivity.this.findAction(o000000o, hqs.O0000o0O)) {
                                    hqs.O0000o0O.add(o000000o);
                                }
                            }
                        }
                    }
                    return hqs;
                }
            });
        }
    }

    public boolean findCondition(hqs.O00000o0 o00000o0, List<hqs.O00000o0> list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                hqs.O00000o0 o00000o02 = list.get(i);
                if (o00000o02.f536O000000o == o00000o0.f536O000000o && (o00000o02.O0000O0o == null || o00000o0.O0000O0o == null || !(o00000o02.O0000O0o instanceof hqs.O00000o) || !(o00000o0.O0000O0o instanceof hqs.O00000o) || TextUtils.equals(((hqs.O00000o) o00000o02.O0000O0o).f535O000000o, ((hqs.O00000o) o00000o0.O0000O0o).f535O000000o))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findTrigger(hqs.O0000Oo0 o0000Oo0, List<hqs.O0000Oo0> list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                hqs.O0000Oo0 o0000Oo02 = list.get(i);
                if (o0000Oo02.f538O000000o == o0000Oo0.f538O000000o && (o0000Oo02.O0000O0o == null || o0000Oo0.O0000O0o == null || !(o0000Oo02.O0000O0o instanceof hqs.O00000o) || !(o0000Oo0.O0000O0o instanceof hqs.O00000o) || TextUtils.equals(((hqs.O00000o) o0000Oo02.O0000O0o).f535O000000o, ((hqs.O00000o) o0000Oo0.O0000O0o).f535O000000o))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findAction(hqs.O000000o o000000o, List<hqs.O000000o> list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                hqs.O000000o o000000o2 = list.get(i);
                if (o000000o2.f530O000000o == o000000o.f530O000000o && (o000000o2.O00000oO == null || o000000o.O00000oO == null || !(o000000o2.O00000oO instanceof hqs.O000000o.O00000o0) || !(o000000o.O00000oO instanceof hqs.O000000o.O00000o0) || TextUtils.equals(((hqs.O000000o.O00000o0) o000000o2.O00000oO).O00000Oo, ((hqs.O000000o.O00000o0) o000000o.O00000oO).O00000Oo))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void saveOneScene(final hqs hqs) {
        if (hqs != null) {
            if (hqs.O0000o0o != null) {
                JSONObject O000000o2 = hqs.O000000o();
                try {
                    hqs.O0000o0o.put("scene_condition", O000000o2.opt("scene_condition"));
                    hqs.O0000o0o.put("scene_trigger", O000000o2.opt("scene_trigger"));
                    hqs.O0000o0o.put("scene_action", O000000o2.opt("scene_action"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    hqs.O0000o0o = null;
                }
            }
            hnz.O000000o(this, 2, (hqs.O0000o0o != null ? hqs.O0000o0o : hqs.O000000o()).toString(), 1, new fsy<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.scene.ui.rec.initdevice.InitDeviceRecSpecSceneActivity.AnonymousClass2 */

                public final void onFailure(fso fso) {
                    InitDeviceRecSpecSceneActivity.this.setItems++;
                    if (InitDeviceRecSpecSceneActivity.this.setItems == InitDeviceRecSpecSceneActivity.this.f11297O000000o.size()) {
                        if (InitDeviceRecSpecSceneActivity.this.mPD != null && InitDeviceRecSpecSceneActivity.this.mPD.isShowing()) {
                            InitDeviceRecSpecSceneActivity.this.mPD.dismiss();
                        }
                        InitDeviceRecSpecSceneActivity.this.goNextStep();
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    InitDeviceRecSpecSceneActivity.this.setItems++;
                    if (InitDeviceRecSpecSceneActivity.this.setItems == InitDeviceRecSpecSceneActivity.this.f11297O000000o.size()) {
                        if (InitDeviceRecSpecSceneActivity.this.mPD != null && InitDeviceRecSpecSceneActivity.this.mPD.isShowing()) {
                            InitDeviceRecSpecSceneActivity.this.mPD.dismiss();
                        }
                        InitDeviceRecSpecSceneActivity.this.goNextStep();
                    }
                }
            });
        }
    }

    public void goNextStep() {
        final boolean z;
        if (this.O00000o0 || this.O00000o || this.O00000oO) {
            fbt fbt = new fbt(this, "initShareAndMibrainActivity");
            fbt.O000000o(getIntent().getExtras());
            fbt.O000000o("current_step", this.O0000O0o);
            fbt.O000000o("can_jump_mibrain", this.O00000o0);
            fbt.O000000o("can_jump_share", this.O00000o);
            fbt.O000000o("can_show_misound_gateway_switch", this.O00000oO);
            fbs.O000000o(fbt);
            finish();
            return;
        }
        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(this.mDevice.model);
        final XQProgressHorizontalDialog O000000o2 = XQProgressHorizontalDialog.O000000o(this, getResources().getString(R.string.plugin_downloading) + O00000oO2.O0000Oo0());
        final PluginDownloadTask pluginDownloadTask = new PluginDownloadTask();
        final XQProgressDialog xQProgressDialog = new XQProgressDialog(this);
        xQProgressDialog.setCancelable(true);
        xQProgressDialog.setMessage(getResources().getString(R.string.loading_share_info));
        if (CoreApi.O000000o().O0000Oo(this.mDevice.model) == null && CoreApi.O000000o().O0000OoO(this.mDevice.model) == null) {
            z = true;
        } else {
            xQProgressDialog.show();
            z = false;
        }
        sendBroadcast(new Intent("bind_finish_openplugin"));
        PluginApi.getInstance().sendMessage(this, this.mDevice.model, 1, new Intent(), DeviceRouterFactory.getDeviceWrapper().newDeviceStat(this.mDevice), null, false, new SendMessageCallback() {
            /* class com.xiaomi.smarthome.scene.ui.rec.initdevice.InitDeviceRecSpecSceneActivity.AnonymousClass3 */
            private long O00000oo;
            private final Interpolator O0000O0o = new DecelerateInterpolator();
            private volatile ValueAnimator O0000OOo;

            public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                if (InitDeviceRecSpecSceneActivity.this.isValid()) {
                    pluginDownloadTask.O000000o(pluginDownloadTask);
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    if (xQProgressHorizontalDialog != null) {
                        xQProgressHorizontalDialog.O000000o(true);
                        XQProgressHorizontalDialog xQProgressHorizontalDialog2 = O000000o2;
                        xQProgressHorizontalDialog2.f9117O000000o = false;
                        xQProgressHorizontalDialog2.setCancelable(true);
                        O000000o2.show();
                        O000000o2.setOnCancelListener(new DialogInterface.OnCancelListener(pluginDownloadTask) {
                            /* class com.xiaomi.smarthome.scene.ui.rec.initdevice.$$Lambda$InitDeviceRecSpecSceneActivity$3$HFwrruOcDxaHRBxbDeO56GDfQOE */
                            private final /* synthetic */ PluginDownloadTask f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                InitDeviceRecSpecSceneActivity.AnonymousClass3.this.O000000o(this.f$1, dialogInterface);
                            }
                        });
                    }
                }
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(PluginDownloadTask pluginDownloadTask, DialogInterface dialogInterface) {
                CoreApi.O000000o().O000000o(InitDeviceRecSpecSceneActivity.this.mDevice.model, pluginDownloadTask);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{java.lang.Math.min(float, float):float}
             arg types: [int, float]
             candidates:
              ClspMth{java.lang.Math.min(double, double):double}
              ClspMth{java.lang.Math.min(long, long):long}
              ClspMth{java.lang.Math.min(int, int):int}
              ClspMth{java.lang.Math.min(float, float):float} */
            private float O000000o() {
                if (this.O0000OOo == null) {
                    synchronized (this) {
                        if (this.O0000OOo == null) {
                            double min = (double) Math.min(1.0f, ((float) (System.currentTimeMillis() - this.O00000oo)) / 4000.0f);
                            Double.isNaN(min);
                            this.O0000OOo = ValueAnimator.ofFloat((float) ((min * 0.14d) + 0.85d), 0.99f);
                            this.O0000OOo.setDuration(4000L);
                            this.O0000OOo.setInterpolator(this.O0000O0o);
                            this.O0000OOo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                /* class com.xiaomi.smarthome.scene.ui.rec.initdevice.$$Lambda$InitDeviceRecSpecSceneActivity$3$yMTVyem0SZRdYdmfFjPIEAyl5w */

                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    InitDeviceRecSpecSceneActivity.AnonymousClass3.O000000o(XQProgressHorizontalDialog.this, valueAnimator);
                                }
                            });
                            this.O0000OOo.start();
                        }
                    }
                }
                return ((Float) this.O0000OOo.getAnimatedValue()).floatValue();
            }

            /* access modifiers changed from: private */
            public static /* synthetic */ void O000000o(XQProgressHorizontalDialog xQProgressHorizontalDialog, ValueAnimator valueAnimator) {
                if (xQProgressHorizontalDialog != null) {
                    xQProgressHorizontalDialog.O000000o(100, (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 100.0f));
                }
            }

            public final void onDownloadProgress(String str, float f) {
                if (InitDeviceRecSpecSceneActivity.this.isValid()) {
                    if (z) {
                        int i = (int) (f * 100.0f);
                        if (i >= 99) {
                            if (this.O00000oo == 0) {
                                this.O00000oo = System.currentTimeMillis();
                            }
                            i = 99;
                        }
                        if (i == 99) {
                            O000000o();
                            return;
                        }
                        XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                        if (xQProgressHorizontalDialog != null) {
                            double d = (double) i;
                            Double.isNaN(d);
                            xQProgressHorizontalDialog.O000000o(100, (int) (d * 0.85d));
                            return;
                        }
                        return;
                    }
                    XQProgressHorizontalDialog xQProgressHorizontalDialog2 = O000000o2;
                    if (xQProgressHorizontalDialog2 != null) {
                        xQProgressHorizontalDialog2.O000000o(100, (int) (f * 100.0f));
                    }
                }
            }

            public final void onDownloadSuccess(String str) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (InitDeviceRecSpecSceneActivity.this.isValid() && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }

            public final void onDownloadFailure(PluginError pluginError) {
                if (InitDeviceRecSpecSceneActivity.this.isValid()) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    if (xQProgressHorizontalDialog != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                    gqg.O00000Oo(pluginError.O000000o(InitDeviceRecSpecSceneActivity.this.getContext()));
                }
            }

            public final void onDownloadCancel() {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (InitDeviceRecSpecSceneActivity.this.isValid() && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }

            public final void onInstallSuccess(String str) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                super.onInstallSuccess(str);
                if (InitDeviceRecSpecSceneActivity.this.isValid() && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }

            public final void onInstallFailure(PluginError pluginError) {
                super.onInstallFailure(pluginError);
                if (InitDeviceRecSpecSceneActivity.this.isValid()) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    if (xQProgressHorizontalDialog != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                    izb.O000000o(InitDeviceRecSpecSceneActivity.this, (int) R.string.device_enter_failed, 0).show();
                }
            }

            public final void onSendSuccess(Bundle bundle) {
                if (InitDeviceRecSpecSceneActivity.this.isValid()) {
                    xQProgressDialog.dismiss();
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    if (xQProgressHorizontalDialog != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                    InitDeviceRecSpecSceneActivity.this.mControl.O000000o();
                }
            }

            public final void onSendFailure(fso fso) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (InitDeviceRecSpecSceneActivity.this.isValid()) {
                    if (z && (xQProgressHorizontalDialog = O000000o2) != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                    gqg.O00000Oo(fso.O00000Oo);
                }
            }

            public final void onSendCancel() {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (InitDeviceRecSpecSceneActivity.this.isValid() && z && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }
        });
    }

    class O000000o extends RecyclerView.O000000o<O00000Oo> {

        /* renamed from: O000000o  reason: collision with root package name */
        public ArrayList<hog> f11303O000000o = new ArrayList<>();

        public final long getItemId(int i) {
            return (long) i;
        }

        O000000o() {
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, final int i) {
            final O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            hof hof = this.f11303O000000o.get(i).O00000o0;
            if (hof != null) {
                String str = "";
                o00000Oo.O00000Oo.setText(TextUtils.isEmpty(hof.O00000oO) ? str : hof.O00000oO);
                TextView textView = o00000Oo.O00000o0;
                if (!TextUtils.isEmpty(hof.O00000o)) {
                    str = hof.O00000o;
                }
                textView.setText(str);
            }
            if (InitDeviceRecSpecSceneActivity.this.f11297O000000o.containsKey(Integer.valueOf(i))) {
                o00000Oo.O00000o.setChecked(true);
                o00000Oo.O000000o();
            } else {
                o00000Oo.O00000o.setChecked(false);
                o00000Oo.O00000Oo();
            }
            o00000Oo.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.ui.rec.initdevice.$$Lambda$InitDeviceRecSpecSceneActivity$O000000o$fO00Ly7gOC5LMFyAHu8fkC98BIA */

                public final void onClick(View view) {
                    InitDeviceRecSpecSceneActivity.O00000Oo.this.O00000o.setChecked(!InitDeviceRecSpecSceneActivity.O00000Oo.this.O00000o.isChecked());
                }
            });
            o00000Oo.O00000o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.xiaomi.smarthome.scene.ui.rec.initdevice.InitDeviceRecSpecSceneActivity.O000000o.AnonymousClass1 */

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (!InitDeviceRecSpecSceneActivity.this.f11297O000000o.containsKey(Integer.valueOf(i))) {
                        InitDeviceRecSpecSceneActivity.this.f11297O000000o.put(Integer.valueOf(i), O000000o.this.f11303O000000o.get(i));
                        o00000Oo.O000000o();
                        return;
                    }
                    InitDeviceRecSpecSceneActivity.this.f11297O000000o.remove(Integer.valueOf(i));
                    o00000Oo.O00000Oo();
                }
            });
        }

        public final int getItemCount() {
            return this.f11303O000000o.size();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new O00000Oo(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_init_device_rec_scene, viewGroup, false));
        }
    }

    class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        View f11305O000000o;
        TextView O00000Oo;
        SwitchButton O00000o;
        TextView O00000o0;

        public O00000Oo(View view) {
            super(view);
            this.f11305O000000o = view.findViewById(R.id.view_background);
            this.O00000Oo = (TextView) view.findViewById(R.id.txt_rec_name);
            this.O00000o0 = (TextView) view.findViewById(R.id.txt_rec_desc);
            this.O00000o = (SwitchButton) view.findViewById(R.id.ckb_edit_selected);
        }

        public final void O000000o() {
            this.f11305O000000o.setBackgroundResource(R.drawable.bg_16_bgcolor1);
            this.O00000Oo.setTextColor(InitDeviceRecSpecSceneActivity.this.getResources().getColor(R.color.mj_color_green_normal));
            this.O00000o0.setTextColor(InitDeviceRecSpecSceneActivity.this.getResources().getColor(R.color.mj_color_green_normal));
        }

        public final void O00000Oo() {
            this.f11305O000000o.setBackgroundResource(R.drawable.bg_16_bgcolor4);
            this.O00000Oo.setTextColor(InitDeviceRecSpecSceneActivity.this.getResources().getColor(R.color.mj_color_black));
            this.O00000o0.setTextColor(InitDeviceRecSpecSceneActivity.this.getResources().getColor(R.color.mj_color_gray_lighter));
        }
    }
}

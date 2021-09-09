package com.xiaomi.smarthome.scene.ui.rec;

import _m_j.fcn;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fsy;
import _m_j.ftn;
import _m_j.ggb;
import _m_j.gpc;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hnw;
import _m_j.hnz;
import _m_j.hod;
import _m_j.hof;
import _m_j.hpe;
import _m_j.hpf;
import _m_j.hpw;
import _m_j.hpx;
import _m_j.hqc;
import _m_j.hqd;
import _m_j.hqe;
import _m_j.hqf;
import _m_j.hqg;
import _m_j.hqh;
import _m_j.hqi;
import _m_j.hqj;
import _m_j.hql;
import _m_j.hqm;
import _m_j.hqn;
import _m_j.hqo;
import _m_j.hqp;
import _m_j.hqs;
import _m_j.hqz;
import _m_j.hrc;
import _m_j.hrh;
import _m_j.hri;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxr;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.api.spec.instance.SpecDevice;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.operation.js_sdk.OperationCommonWebViewActivity;
import com.xiaomi.smarthome.scene.ConstantType;
import com.xiaomi.smarthome.scene.geofence.manager.model.GeoFenceItem;
import com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function5;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class RecommendSceneDetailPage extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f11267O000000o;
    boolean O00000Oo;
    MLAlertDialog O00000o;
    boolean O00000o0;
    private RecyclerView O00000oO;
    private View O00000oo;
    private View O0000O0o;
    private View O0000OOo;
    private TextView O0000Oo;
    private View O0000Oo0;
    private hqs O0000OoO = null;
    private View O0000Ooo;
    private TextView O0000o;
    private View O0000o0;
    private View O0000o00;
    private TextView O0000o0O;
    private TextView O0000o0o;
    private SimpleDraweeView O0000oO;
    private SimpleDraweeView O0000oO0;
    public CompositeDisposable co;
    public boolean isHomeUpdated = false;
    public O000000o mAdapter;
    public int mCurrentRequestId = -1;
    public int mCurrentRequestPos = -1;
    public hqf mCurrentRequestUI = null;
    public hqs mScene = null;
    public hrh manager;
    public Map<String, Integer> repeatDids = new HashMap();
    public ArrayList<O0000Oo> unVisibleData;
    public ArrayList<O0000Oo> visibleData;

    public interface O0000Oo {
        int p_();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_recommend_scene_detail);
        this.O0000Ooo = findViewById(R.id.view_loading);
        AnimationDrawable animationDrawable = (AnimationDrawable) getResources().getDrawable(R.drawable.camera_loading);
        ((ImageView) this.O0000Ooo.findViewById(R.id.mj_loading)).setImageDrawable(animationDrawable);
        animationDrawable.start();
        this.O0000o00 = findViewById(R.id.view_empty);
        this.O0000o0O = (TextView) findViewById(R.id.rec_title);
        this.O0000o0o = (TextView) findViewById(R.id.rec_sub_title);
        this.O0000o = (TextView) findViewById(R.id.txt_empty_hint);
        this.O0000oO0 = (SimpleDraweeView) findViewById(R.id.rec_icon);
        this.O0000oO = (SimpleDraweeView) findViewById(R.id.rec_img);
        this.O0000o0 = findViewById(R.id.txt_buy);
        this.O0000O0o = findViewById(R.id.btn_return);
        this.O0000OOo = findViewById(R.id.btn_cancel);
        this.O0000Oo0 = findViewById(R.id.btn_confirm);
        this.O0000Oo = (TextView) findViewById(R.id.txt_enable);
        this.O0000O0o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$FVi0KbpzRiiVmznmzK5zyxtw5Cs */

            public final void onClick(View view) {
                RecommendSceneDetailPage.this.O0000OOo(view);
            }
        });
        this.O00000oo = LayoutInflater.from(this).inflate((int) R.layout.scene_alert_dialog, (ViewGroup) null);
        this.O0000OOo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$LSvccp9VnGMyRKaLjjhqWGJ4 */

            public final void onClick(View view) {
                RecommendSceneDetailPage.this.O00000oO(view);
            }
        });
        this.O0000Oo0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$QJkGC6WY3j1ii6d6eeSon0zE */

            public final void onClick(View view) {
                RecommendSceneDetailPage.this.O00000Oo(view);
            }
        });
        this.O00000oO = (RecyclerView) findViewById(R.id.rc_setting);
        this.O00000oO.setLayoutManager(new LinearLayoutManager(this));
        boolean z = true;
        this.O00000oO.setHasFixedSize(true);
        int i = 0;
        this.mAdapter = new O000000o(this, (byte) 0);
        this.O00000oO.setAdapter(this.mAdapter);
        this.manager = hrh.O000000o();
        if (this.manager.O00000Oo() == null) {
            finish();
            return;
        }
        ArrayList<hof.O00000o.O00000Oo> arrayList = this.manager.O00000Oo().O0000oo0.O00000o0;
        this.f11267O000000o = arrayList.size() > 0;
        if (this.f11267O000000o) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).O00000o0.intValue() == ConstantType.StyleType.HIDE.styleId) {
                    i2++;
                }
            }
            if (i2 == arrayList.size()) {
                this.f11267O000000o = false;
            }
        }
        this.O00000Oo = (this.manager.O00000Oo().O0000oOo == null || this.manager.O00000Oo().O0000oOo.O00000o0 == null || this.manager.O00000Oo().O0000oOo.O00000o0.size() <= 0) ? false : true;
        if (this.O00000Oo) {
            int i4 = 0;
            for (int i5 = 0; i5 < this.manager.O00000Oo().O0000oOo.O00000o0.size(); i5++) {
                if (this.manager.O00000Oo().O0000oOo.O00000o0.get(i5).O00000o0.intValue() == ConstantType.StyleType.HIDE.styleId) {
                    i4++;
                }
            }
            if (i4 == this.manager.O00000Oo().O0000oOo.O00000o0.size()) {
                this.O00000Oo = false;
            }
        }
        if (this.manager.O00000Oo().O0000oo == null || this.manager.O00000Oo().O0000oo.O00000oO == null || this.manager.O00000Oo().O0000oo.O00000oO.size() <= 0) {
            z = false;
        }
        this.O00000o0 = z;
        if (this.O00000o0) {
            int i6 = 0;
            for (int i7 = 0; i7 < this.manager.O00000Oo().O0000oo.O00000oO.size(); i7++) {
                if (this.manager.O00000Oo().O0000oo.O00000oO.get(i7).O00000o0.intValue() == ConstantType.StyleType.HIDE.styleId) {
                    i6++;
                }
            }
            if (i6 == this.manager.O00000Oo().O0000oo.O00000oO.size()) {
                this.O00000o0 = false;
            }
        }
        if (TextUtils.isEmpty(this.manager.O00000o0())) {
            finish();
            return;
        }
        this.co = new CompositeDisposable();
        List<Device> O0000Oo2 = ggb.O00000Oo().O0000Oo(this.manager.O00000o0());
        LogType logType = LogType.SCENE;
        StringBuilder sb = new StringBuilder("deviceInHome: ");
        if (O0000Oo2 != null) {
            i = O0000Oo2.size();
        }
        sb.append(i);
        gsy.O00000o0(logType, "recScene", sb.toString());
        Observable.create(new ObservableOnSubscribe(O0000Oo2) {
            /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$ssDRVbFIa7OdSh7tiQWEIyrRWXY */
            private final /* synthetic */ List f$1;

            {
                this.f$1 = r2;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                RecommendSceneDetailPage.this.O000000o(this.f$1, observableEmitter);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<SparseArray<Map<String, SpecDevice>>>() {
            /* class com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.AnonymousClass2 */

            public final void onComplete() {
            }

            public final void onSubscribe(Disposable disposable) {
            }

            public final /* synthetic */ void onNext(Object obj) {
                SparseArray sparseArray = (SparseArray) obj;
                RecommendSceneDetailPage recommendSceneDetailPage = RecommendSceneDetailPage.this;
                RecommendSceneDetailPage.this.co.add(Observable.zip(recommendSceneDetailPage.getSceneDetailObservable(recommendSceneDetailPage.manager.f558O000000o == null ? 0 : RecommendSceneDetailPage.this.manager.f558O000000o.O00000Oo), RecommendSceneDetailPage.this.getDeviceInfoObservable(sparseArray), RecommendSceneDetailPage.this.getConditionObservable(sparseArray.get(0) == null ? new TreeMap() : (Map) sparseArray.get(0)), RecommendSceneDetailPage.this.getTriggerObservable(sparseArray.get(1) == null ? new TreeMap() : (Map) sparseArray.get(1)), RecommendSceneDetailPage.this.getActionObservable(sparseArray.get(2) == null ? new TreeMap() : (Map) sparseArray.get(2)), new Function5() {
                    /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$2$q5VXxvxNK8u7T2ZsdMCMfwCr1Ag */

                    public final Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                        return RecommendSceneDetailPage.AnonymousClass2.this.O000000o((hqs) obj, (Map) obj2, (SparseArray) obj3, (SparseArray) obj4, (SparseArray) obj5);
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(RecommendSceneDetailPage.this.getUIDataConsumer(), RecommendSceneDetailPage.this.getErrorDataConsumer()));
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:163:0x0376 A[LOOP:6: B:163:0x0376->B:170:0x0398, LOOP_START, PHI: r2 10  PHI: (r2v9 int) = (r2v8 int), (r2v10 int) binds: [B:162:0x0374, B:170:0x0398] A[DONT_GENERATE, DONT_INLINE]] */
            public /* synthetic */ SparseArray O000000o(hqs hqs, Map map, SparseArray sparseArray, SparseArray sparseArray2, SparseArray sparseArray3) throws Exception {
                Object o_;
                List list;
                ArrayList<O0000Oo> mergeAction2Rec;
                ArrayList<O0000Oo> mergeTriggers2Rec;
                ArrayList<O0000Oo> mergeCondition2Rec;
                hqs hqs2 = hqs;
                Map map2 = map;
                SparseArray sparseArray4 = sparseArray;
                SparseArray sparseArray5 = sparseArray2;
                SparseArray sparseArray6 = sparseArray3;
                SparseArray sparseArray7 = new SparseArray();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                boolean z = true;
                if (sparseArray4 != null && sparseArray.size() > 0) {
                    if (sparseArray4.get(0) != null && ((ArrayList) sparseArray4.get(0)).size() > 0) {
                        if (hqs2.f529O000000o > 0) {
                            arrayList.addAll(RecommendSceneDetailPage.this.mergeCondition2Rec((ArrayList) sparseArray4.get(0), hqs2.O00000Oo, hqs2.O0000OoO));
                        } else {
                            arrayList.addAll((Collection) sparseArray4.get(0));
                        }
                    }
                    if (sparseArray4.get(1) != null && ((ArrayList) sparseArray4.get(1)).size() > 0) {
                        arrayList2.addAll((Collection) sparseArray4.get(1));
                    }
                } else if (hqs2.f529O000000o > 0 && (mergeCondition2Rec = RecommendSceneDetailPage.this.mergeCondition2Rec(null, hqs2.O00000Oo, hqs2.O0000OoO)) != null && !mergeCondition2Rec.isEmpty()) {
                    if (RecommendSceneDetailPage.this.manager.O00000Oo().O0000oo0 != null) {
                        arrayList.add(new O00000o0(RecommendSceneDetailPage.this.manager.O00000Oo().O0000oo0.O0000OOo, 0));
                    }
                    arrayList.addAll(mergeCondition2Rec);
                }
                if (sparseArray5 != null && sparseArray2.size() > 0) {
                    if (sparseArray5.get(0) != null && ((ArrayList) sparseArray5.get(0)).size() > 0) {
                        if (hqs2.f529O000000o > 0) {
                            arrayList.addAll(RecommendSceneDetailPage.this.mergeTriggers2Rec((ArrayList) sparseArray5.get(0), hqs2.O00000Oo, hqs2.O0000o00));
                        } else {
                            arrayList.addAll((Collection) sparseArray5.get(0));
                        }
                    }
                    if (sparseArray5.get(1) != null && ((ArrayList) sparseArray5.get(1)).size() > 0) {
                        arrayList2.addAll((Collection) sparseArray5.get(1));
                    }
                } else if (hqs2.f529O000000o > 0 && (mergeTriggers2Rec = RecommendSceneDetailPage.this.mergeTriggers2Rec(null, hqs2.O00000Oo, hqs2.O0000o00)) != null && !mergeTriggers2Rec.isEmpty()) {
                    if (RecommendSceneDetailPage.this.manager.O00000Oo().O0000oOo != null) {
                        arrayList.add(new O00000o0(RecommendSceneDetailPage.this.manager.O00000Oo().O0000oOo.O0000OOo, 0));
                    }
                    arrayList.addAll(mergeTriggers2Rec);
                }
                if (hqs2.f529O000000o > 0) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (((O0000Oo) arrayList.get(i)).p_() == 4) {
                            ((hqi) arrayList.get(i)).f522O000000o = hqs2.O0000Oo0;
                        }
                    }
                }
                if (sparseArray6 != null && sparseArray3.size() > 0) {
                    if (sparseArray6.get(0) != null && ((ArrayList) sparseArray6.get(0)).size() > 0) {
                        if (hqs2.f529O000000o > 0) {
                            ArrayList arrayList3 = new ArrayList();
                            for (int i2 = 0; i2 < ((ArrayList) sparseArray6.get(0)).size(); i2++) {
                                arrayList3.addAll((Collection) ((ArrayList) sparseArray6.get(0)).get(i2));
                            }
                            arrayList.addAll(RecommendSceneDetailPage.this.mergeAction2Rec(arrayList3, hqs2.O00000Oo, hqs2.O0000o0O));
                        } else {
                            for (int i3 = 0; i3 < ((ArrayList) sparseArray6.get(0)).size(); i3++) {
                                arrayList.addAll((Collection) ((ArrayList) sparseArray6.get(0)).get(i3));
                            }
                        }
                    }
                    if (sparseArray6.get(1) != null && ((ArrayList) sparseArray6.get(1)).size() > 0) {
                        for (int i4 = 0; i4 < ((ArrayList) sparseArray6.get(1)).size(); i4++) {
                            arrayList2.addAll((Collection) ((ArrayList) sparseArray6.get(1)).get(i4));
                        }
                    }
                } else if (hqs2.f529O000000o > 0 && (mergeAction2Rec = RecommendSceneDetailPage.this.mergeAction2Rec(null, hqs2.O00000Oo, hqs2.O0000o0O)) != null && !mergeAction2Rec.isEmpty()) {
                    arrayList.addAll(mergeAction2Rec);
                }
                if (arrayList.size() > 0) {
                    for (int i5 = 0; i5 < arrayList.size(); i5++) {
                        if (arrayList.get(i5) instanceof hpw) {
                            hpw hpw = (hpw) arrayList.get(i5);
                            if (map2.containsKey(hpw.O00000Oo()) && (list = (List) map2.get(hpw.O00000Oo())) != null && list.size() >= 2) {
                                hpw.O000000o(list);
                            }
                        }
                    }
                    arrayList.add(0, new O0000O0o((hqs2 == null || hqs2.f529O000000o <= 0) ? RecommendSceneDetailPage.this.manager.O00000o0() : hqs2.O00000o0, (hqs2 == null || hqs2.f529O000000o <= 0) ? 0 : hqs2.f529O000000o, RecommendSceneDetailPage.this.manager.O00000Oo().O00000oo, RecommendSceneDetailPage.this.manager.O00000Oo().O00000oO, RecommendSceneDetailPage.this.manager.O00000Oo().O00000o0, (hqs2 == null || hqs2.f529O000000o <= 0) ? RecommendSceneDetailPage.this.manager.O00000Oo().O0000oO.booleanValue() : hqs2.O0000O0o));
                    sparseArray7.put(0, arrayList);
                }
                if (arrayList2.size() > 0) {
                    sparseArray7.put(1, arrayList2);
                }
                if (RecommendSceneDetailPage.this.manager.O00000Oo().O0000oo0.O00000Oo == 1) {
                    int i6 = -1;
                    for (int i7 = 0; i7 < arrayList.size(); i7++) {
                        if (arrayList.get(i7) instanceof O00000o0) {
                            if (i6 != -1) {
                                break;
                            }
                            i6 = i7;
                        } else if (i6 >= 0 && (arrayList.get(i7) instanceof hqf)) {
                            ((hqf) arrayList.get(i7)).O0000O0o = i6;
                        }
                    }
                    int i8 = i6 + 1;
                    if (!(hqs2 == null || hqs2.O0000OoO == null || hqs2.O0000OoO.size() != 1)) {
                        hqs.O00000o0 o00000o0 = hqs2.O0000OoO.get(0);
                        if ((arrayList.get(i8) instanceof hql) && i8 < arrayList.size() && (o_ = ((hql) arrayList.get(i8)).o_()) != null && o_.equals(o00000o0)) {
                            ((O00000o0) arrayList.get(i6)).O00000o = i8;
                            if (!z) {
                                while (i8 < arrayList.size() && (arrayList.get(i8) instanceof hqd)) {
                                    if (((hqd) arrayList.get(i8)).O0000Oo0()) {
                                        ((O00000o0) arrayList.get(i6)).O00000o = i8;
                                    }
                                    i8++;
                                }
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                }
                return sparseArray7;
            }

            public final void onError(Throwable th) {
                gqg.O00000Oo((int) R.string.load_failed);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000OOo(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oO(View view) {
        createSceneFromRecUIData();
        hqs hqs = this.mScene;
        if (hqs == null) {
            finish();
        } else if (hqs.equals(this.O0000OoO)) {
            finish();
        } else {
            ((TextView) this.O00000oo.findViewById(R.id.alertTitle)).setText((int) R.string.rec_scene_cancel_msg);
            ((TextView) this.O00000oo.findViewById(R.id.button1)).setText((int) R.string.save);
            this.O00000oo.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$Ap80dWJxhkM1xh9cnSZ55aa9Wc */

                public final void onClick(View view) {
                    RecommendSceneDetailPage.this.O0000O0o(view);
                }
            });
            ((TextView) this.O00000oo.findViewById(R.id.button2)).setText((int) R.string.rec_scene_cancel_finish);
            this.O00000oo.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$zy5zpioEyuRC8R1cw7h37nzLpNw */

                public final void onClick(View view) {
                    RecommendSceneDetailPage.this.O00000oo(view);
                }
            });
            if (this.O00000o == null) {
                this.O00000o = new MLAlertDialog.Builder(this).O000000o(this.O00000oo).O00000o0().O00000o();
            }
            this.O00000o.show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000O0o(View view) {
        this.O00000o.dismiss();
        if (!isSettable()) {
            gqg.O00000Oo((int) R.string.rec_scene_settable_false);
            return;
        }
        createSceneFromRecUIData();
        O000000o();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oo(View view) {
        this.O00000o.dismiss();
        refreshRecSceneList();
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        hxk hxk = hxi.O00000o;
        String O00000o02 = this.manager.O00000o0();
        long longValue = this.manager.O00000Oo().O00000Oo.longValue();
        int O000000o2 = O000000o(this.mScene);
        hqs hqs = this.mScene;
        hxk.f952O000000o.O000000o("scene_templatesave_click", "homeid", O00000o02, "state", Integer.valueOf(O000000o2), "us_id", Long.valueOf(hqs == null ? 0 : hqs.f529O000000o), "templateid", Long.valueOf(longValue));
        createSceneFromRecUIData();
        if (isSettable()) {
            O000000o();
        } else if (this.mScene.f529O000000o > 0) {
            if (this.O00000o == null) {
                this.O00000o = new MLAlertDialog.Builder(this).O000000o(this.O00000oo).O00000o0().O00000o();
            }
            this.O00000o.show();
            ((TextView) this.O00000oo.findViewById(R.id.alertTitle)).setText((int) R.string.rec_scene_delete_msg);
            ((TextView) this.O00000oo.findViewById(R.id.button1)).setText((int) R.string.save);
            this.O00000oo.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$YNUVlwnuenS1wtBP74KXpuBV1pQ */

                public final void onClick(View view) {
                    RecommendSceneDetailPage.this.O00000o(view);
                }
            });
            ((TextView) this.O00000oo.findViewById(R.id.button2)).setText((int) R.string.rec_scene_cancel_finish);
            this.O00000oo.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$pLtczMsyTFQwWiDZ17JtMz_D63Q */

                public final void onClick(View view) {
                    RecommendSceneDetailPage.this.O00000o0(view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(View view) {
        this.O00000o.dismiss();
        showProgressDialog(getString(R.string.smarthome_scene_saving_scene));
        StringBuilder sb = new StringBuilder();
        sb.append(this.mScene.f529O000000o);
        hnz.O000000o(this, sb.toString(), new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.AnonymousClass1 */

            public final void onFailure(fso fso) {
                gqg.O00000Oo((int) R.string.rec_scene_edit_fail);
                if (RecommendSceneDetailPage.this.isValid()) {
                    RecommendSceneDetailPage.this.dismissProgressDialog();
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                gqg.O00000Oo((int) R.string.rec_scene_edit_success);
                if (RecommendSceneDetailPage.this.isValid()) {
                    RecommendSceneDetailPage.this.dismissProgressDialog();
                    RecommendSceneDetailPage.this.refreshRecSceneList();
                    RecommendSceneDetailPage.this.finish();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        this.O00000o.dismiss();
        finish();
    }

    public void onBackPressed() {
        View view = this.O0000O0o;
        if (view == null || view.getVisibility() != 0) {
            View view2 = this.O0000OOo;
            if (view2 == null || view2.getVisibility() != 0) {
                super.onBackPressed();
            } else {
                this.O0000OOo.performClick();
            }
        } else {
            this.O0000O0o.performClick();
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(List list, ObservableEmitter observableEmitter) throws Exception {
        SparseArray<Map<String, SpecDevice>> O000000o2 = hri.O000000o(hri.O000000o((List<Device>) list), hri.O000000o(this.manager.O00000Oo().O0000oo0, this.manager.O00000Oo().O0000oOo, this.manager.O00000Oo().O0000oo));
        LogType logType = LogType.SCENE;
        StringBuilder sb = new StringBuilder("deviceInHome visible instance: ");
        int i = 0;
        sb.append(O000000o2.get(0) == null ? 0 : O000000o2.get(0).size());
        gsy.O00000o0(logType, "recScene", sb.toString());
        LogType logType2 = LogType.SCENE;
        StringBuilder sb2 = new StringBuilder("deviceInHome invisible instance: ");
        if (O000000o2.get(1) != null) {
            i = O000000o2.get(1).size();
        }
        sb2.append(i);
        gsy.O00000o0(logType2, "recScene", sb2.toString());
        observableEmitter.onNext(O000000o2);
        observableEmitter.onComplete();
    }

    public Consumer getUIDataConsumer() {
        return new Consumer<SparseArray<ArrayList<O0000Oo>>>() {
            /* class com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.AnonymousClass3 */

            public final /* synthetic */ void accept(Object obj) throws Exception {
                SparseArray sparseArray = (SparseArray) obj;
                if (sparseArray != null) {
                    try {
                        if (sparseArray.get(1) != null) {
                            RecommendSceneDetailPage.this.unVisibleData = (ArrayList) sparseArray.get(1);
                        }
                        if (sparseArray.get(0) != null) {
                            RecommendSceneDetailPage.this.visibleData = (ArrayList) sparseArray.get(0);
                            RecommendSceneDetailPage.this.repeatDids.clear();
                            ((O0000O0o) RecommendSceneDetailPage.this.visibleData.get(0)).O00000oO = RecommendSceneDetailPage.this.isSettable();
                            for (int size = RecommendSceneDetailPage.this.visibleData.size() - 1; size >= 0; size--) {
                                if (RecommendSceneDetailPage.this.visibleData.get(size) instanceof hqm) {
                                    String str = ((hqm) RecommendSceneDetailPage.this.visibleData.get(size)).O0000Oo0;
                                    if (RecommendSceneDetailPage.this.repeatDids.containsKey(str)) {
                                        RecommendSceneDetailPage.this.repeatDids.put(str, Integer.valueOf(RecommendSceneDetailPage.this.repeatDids.get(str).intValue() + 1));
                                    } else {
                                        RecommendSceneDetailPage.this.repeatDids.put(str, 0);
                                    }
                                }
                            }
                            RecommendSceneDetailPage.this.mAdapter.notifyDataSetChanged();
                        }
                        RecommendSceneDetailPage.this.createSceneFromRecUIData();
                        RecommendSceneDetailPage.this.initView();
                    } catch (Exception e) {
                        gsy.O000000o(6, "RecScene", e.getMessage());
                    }
                }
                if (!RecommendSceneDetailPage.this.co.isDisposed()) {
                    RecommendSceneDetailPage.this.co.dispose();
                }
            }
        };
    }

    public void createSceneFromRecUIData() {
        Object o_;
        Object o_2;
        if (this.mScene == null) {
            this.mScene = new hqs();
        }
        this.mScene.O00000Oo = this.manager.O00000Oo().O00000Oo.longValue();
        ArrayList<O0000Oo> arrayList = this.visibleData;
        if (arrayList == null || arrayList.isEmpty() || !(this.visibleData.get(0) instanceof O0000O0o)) {
            this.mScene.O00000o = this.manager.O00000Oo().O00000oO;
            this.mScene.O0000O0o = this.manager.O00000Oo().O0000oO.booleanValue();
            this.mScene.O00000o0 = this.manager.O00000o0();
        } else {
            O0000O0o o0000O0o = (O0000O0o) this.visibleData.get(0);
            this.mScene.O00000o = o0000O0o.O00000Oo;
            this.mScene.O0000O0o = o0000O0o.O00000o;
            this.mScene.f529O000000o = o0000O0o.O00000oo;
            this.mScene.O00000o0 = o0000O0o.O0000O0o;
        }
        this.mScene.O0000OOo = this.manager.O00000Oo().O0000oOO.booleanValue();
        this.mScene.O0000Oo = this.manager.O00000Oo().O0000ooO;
        this.mScene.O0000Ooo = this.manager.O00000Oo().O0000oo0.O00000o;
        this.mScene.O0000o0 = this.manager.O00000Oo().O0000oOo.O00000o;
        this.mScene.O0000OoO.clear();
        this.mScene.O0000o00.clear();
        this.mScene.O0000o0O.clear();
        ArrayList<O0000Oo> arrayList2 = this.visibleData;
        if (arrayList2 != null && arrayList2.size() > 0) {
            for (int i = 0; i < this.visibleData.size(); i++) {
                if ((this.visibleData.get(i) instanceof hqf) && ((hqf) this.visibleData.get(i)).O00000oo && (this.visibleData.get(i) instanceof hql) && (o_2 = ((hql) this.visibleData.get(i)).o_()) != null) {
                    if (o_2 instanceof hqs.O00000o0) {
                        this.mScene.O0000OoO.add((hqs.O00000o0) o_2);
                    } else if (o_2 instanceof hqs.O0000Oo0) {
                        hqs.O0000Oo0 o0000Oo0 = (hqs.O0000Oo0) o_2;
                        this.mScene.O0000o00.add(o0000Oo0);
                        if (TextUtils.equals(o0000Oo0.O00000oo, "user.click")) {
                            this.mScene.O0000Oo0 = ((hqi) this.visibleData.get(i)).f522O000000o;
                        }
                    } else if (o_2 instanceof hqs.O000000o) {
                        this.mScene.O0000o0O.add((hqs.O000000o) o_2);
                    }
                }
            }
        }
        ArrayList<O0000Oo> arrayList3 = this.unVisibleData;
        if (arrayList3 != null && arrayList3.size() > 0) {
            for (int i2 = 0; i2 < this.unVisibleData.size(); i2++) {
                if ((this.unVisibleData.get(i2) instanceof hqf) && ((hqf) this.unVisibleData.get(i2)).O00000oo && (this.unVisibleData.get(i2) instanceof hql) && (o_ = ((hql) this.unVisibleData.get(i2)).o_()) != null) {
                    if (o_ instanceof hqs.O00000o0) {
                        this.mScene.O0000OoO.add((hqs.O00000o0) o_);
                    } else if (o_ instanceof hqs.O0000Oo0) {
                        this.mScene.O0000o00.add((hqs.O0000Oo0) o_);
                    } else if (o_ instanceof hqs.O000000o) {
                        this.mScene.O0000o0O.add((hqs.O000000o) o_);
                    }
                }
            }
        }
        gsy.O00000Oo("RecScene", this.mScene.O000000o().toString());
    }

    public void initView() {
        hqs hqs = this.mScene;
        hqs hqs2 = new hqs();
        hqs2.O00000o = hqs.O00000o;
        hqs2.O0000O0o = hqs.O0000O0o;
        hqs2.O0000OOo = hqs.O0000OOo;
        hqs2.O0000Oo0 = hqs.O0000Oo0;
        hqs2.f529O000000o = hqs.f529O000000o;
        hqs2.O00000Oo = hqs.O00000Oo;
        hqs2.O00000o0 = hqs.O00000o0;
        hqs2.O0000o0 = hqs.O0000o0;
        hqs2.O0000Ooo = hqs.O0000Ooo;
        hqs2.O0000Oo = hqs.O0000Oo;
        hqs2.O00000oO = hqs.O00000oO;
        hqs2.O00000oo = hqs.O00000oo;
        if (hqs.O0000OoO != null) {
            hqs2.O0000OoO = new ArrayList<>();
            hqs2.O0000OoO.addAll(hqs.O0000OoO);
        }
        if (hqs.O0000o0O != null) {
            hqs2.O0000o0O = new ArrayList<>();
            hqs2.O0000o0O.addAll(hqs.O0000o0O);
        }
        if (hqs.O0000o00 != null) {
            hqs2.O0000o00 = new ArrayList<>();
            hqs2.O0000o00.addAll(hqs.O0000o00);
        }
        this.O0000OoO = hqs2;
        this.O0000Ooo.setVisibility(8);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i = 0; i < this.visibleData.size(); i++) {
            if (this.visibleData.get(i) instanceof hqd) {
                z = true;
            } else if (this.visibleData.get(i) instanceof hqe) {
                z3 = true;
            } else if (this.visibleData.get(i) instanceof hqc) {
                z2 = true;
            }
            if (z && z2 && z3) {
                break;
            }
        }
        if (!(z && z2 && z3)) {
            int i2 = 0;
            while (true) {
                ArrayList<O0000Oo> arrayList = this.unVisibleData;
                if (i2 < (arrayList == null ? 0 : arrayList.size())) {
                    if (this.unVisibleData.get(i2) instanceof hqd) {
                        z = true;
                    } else if (this.unVisibleData.get(i2) instanceof hqe) {
                        z3 = true;
                    } else if (this.unVisibleData.get(i2) instanceof hqc) {
                        z2 = true;
                    }
                    if (z && z2 && z3) {
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
        }
        if (this.manager.O00000Oo() != null) {
            boolean z4 = !z && this.manager.O00000Oo().O0000oo0 != null && this.manager.O00000Oo().O0000oo0.O00000o0 != null && this.manager.O00000Oo().O0000oo0.O00000o0.size() > 0;
            if (!z3 && this.manager.O00000Oo().O0000oOo != null && this.manager.O00000Oo().O0000oOo.O00000o0 != null && this.manager.O00000Oo().O0000oOo.O00000o0.size() > 0) {
                z4 |= true;
            }
            if (!z2 && this.manager.O00000Oo().O0000oo != null && this.manager.O00000Oo().O0000oo.O00000oO != null && this.manager.O00000Oo().O0000oo.O00000oO.size() > 0) {
                z4 |= true;
            }
            final String str = null;
            switch (z4) {
                case false:
                    this.O00000oO.setVisibility(0);
                    hxr hxr = hxi.O00000oO;
                    String O00000o02 = this.manager.O00000o0();
                    long longValue = this.manager.O00000Oo().O00000Oo.longValue();
                    int O000000o2 = O000000o(this.mScene);
                    hqs hqs3 = this.mScene;
                    hxr.f958O000000o.O000000o("scene_templateedit_show", "homeid", O00000o02, "state", Integer.valueOf(O000000o2), "us_id", Long.valueOf(hqs3 == null ? 0 : hqs3.f529O000000o), "templateid", Long.valueOf(longValue));
                    isSettable();
                    createSceneFromRecUIData();
                    hqs hqs4 = this.mScene;
                    if (hqs4 == null || hqs4.f529O000000o <= 0) {
                        this.O0000O0o.setVisibility(0);
                        this.O0000OOo.setVisibility(8);
                        this.O0000Oo0.setVisibility(8);
                    } else {
                        this.O0000O0o.setVisibility(8);
                        this.O0000OOo.setVisibility(0);
                        this.O0000Oo0.setVisibility(0);
                    }
                    hqs hqs5 = this.mScene;
                    if (hqs5 == null || hqs5.f529O000000o <= 0) {
                        this.O0000Oo.setVisibility(0);
                    } else {
                        this.O0000Oo.setVisibility(8);
                    }
                    hqs hqs6 = this.mScene;
                    boolean z5 = hqs6 == null ? false : hqs6.O0000O0o;
                    if (this.mScene.f529O000000o > 0) {
                        z5 = !z5;
                    }
                    if (z5) {
                        this.O0000Oo.setText((int) R.string.scene_turn_on);
                        this.O0000Oo.setBackgroundResource(R.drawable.selector_23_bgcolor0);
                    } else {
                        this.O0000Oo.setText((int) R.string.scene_turn_off);
                        this.O0000Oo.setBackgroundResource(R.drawable.selector_23_bgcolor2);
                    }
                    this.O0000Oo.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$D70D3_9scOXkN4iFRYfi7egqg0 */

                        public final void onClick(View view) {
                            RecommendSceneDetailPage.this.O000000o(view);
                        }
                    });
                    return;
                case true:
                    str = this.manager.O00000Oo().O0000oo0.O00000oO;
                    if (!TextUtils.isEmpty(this.manager.O00000Oo().O0000oo0.O0000O0o)) {
                        this.O0000oO.setImageURI(this.manager.O00000Oo().O0000oo0.O0000O0o);
                    }
                    if (TextUtils.isEmpty(this.manager.O00000Oo().O0000oo0.O00000oo)) {
                        this.O0000o.setText("");
                        break;
                    } else {
                        this.O0000o.setText(this.manager.O00000Oo().O0000oo0.O00000oo);
                        break;
                    }
                case true:
                    str = this.manager.O00000Oo().O0000oOo.O00000oO;
                    if (!TextUtils.isEmpty(this.manager.O00000Oo().O0000oOo.O0000O0o)) {
                        this.O0000oO.setImageURI(this.manager.O00000Oo().O0000oOo.O0000O0o);
                    }
                    if (TextUtils.isEmpty(this.manager.O00000Oo().O0000oOo.O00000oo)) {
                        this.O0000o.setText("");
                        break;
                    } else {
                        this.O0000o.setText(this.manager.O00000Oo().O0000oOo.O00000oo);
                        break;
                    }
                case true:
                    str = this.manager.O00000Oo().O0000Oo;
                    if (!TextUtils.isEmpty(this.manager.O00000Oo().O0000Ooo)) {
                        this.O0000oO.setImageURI(this.manager.O00000Oo().O0000Ooo);
                    }
                    if (TextUtils.isEmpty(this.manager.O00000Oo().O0000OoO)) {
                        this.O0000o.setText("");
                        break;
                    } else {
                        this.O0000o.setText(this.manager.O00000Oo().O0000OoO);
                        break;
                    }
                case true:
                    str = this.manager.O00000Oo().O0000oo.O00000Oo;
                    if (!TextUtils.isEmpty(this.manager.O00000Oo().O0000oo.O00000o)) {
                        this.O0000oO.setImageURI(this.manager.O00000Oo().O0000oo.O00000o);
                    }
                    if (TextUtils.isEmpty(this.manager.O00000Oo().O0000oo.O00000o0)) {
                        this.O0000o.setText("");
                        break;
                    } else {
                        this.O0000o.setText(this.manager.O00000Oo().O0000oo.O00000o0);
                        break;
                    }
                case true:
                    str = this.manager.O00000Oo().O0000o00;
                    if (!TextUtils.isEmpty(this.manager.O00000Oo().O0000o0O)) {
                        this.O0000oO.setImageURI(this.manager.O00000Oo().O0000o0O);
                    }
                    if (TextUtils.isEmpty(this.manager.O00000Oo().O0000o0)) {
                        this.O0000o.setText("");
                        break;
                    } else {
                        this.O0000o.setText(this.manager.O00000Oo().O0000o0);
                        break;
                    }
                case true:
                    str = this.manager.O00000Oo().O0000O0o;
                    if (!TextUtils.isEmpty(this.manager.O00000Oo().O0000Oo0)) {
                        this.O0000oO.setImageURI(this.manager.O00000Oo().O0000Oo0);
                    }
                    if (TextUtils.isEmpty(this.manager.O00000Oo().O0000OOo)) {
                        this.O0000o.setText("");
                        break;
                    } else {
                        this.O0000o.setText(this.manager.O00000Oo().O0000OOo);
                        break;
                    }
                case true:
                    str = this.manager.O00000Oo().O0000o0o;
                    if (!TextUtils.isEmpty(this.manager.O00000Oo().O0000oO0)) {
                        this.O0000oO.setImageURI(this.manager.O00000Oo().O0000oO0);
                    }
                    if (TextUtils.isEmpty(this.manager.O00000Oo().O0000o)) {
                        this.O0000o.setText("");
                        break;
                    } else {
                        this.O0000o.setText(this.manager.O00000Oo().O0000o);
                        break;
                    }
            }
            if (!TextUtils.isEmpty(this.manager.O00000Oo().O00000oo)) {
                this.O0000oO0.setImageURI(this.manager.O00000Oo().O00000oo);
            }
            this.O0000o00.setVisibility(0);
            if (!TextUtils.isEmpty(this.manager.O00000Oo().O00000oO)) {
                this.O0000o0O.setText(this.manager.O00000Oo().O00000oO);
            } else {
                this.O0000o0O.setText("");
            }
            if (!TextUtils.isEmpty(this.manager.O00000Oo().O00000o0)) {
                this.O0000o0o.setText(this.manager.O00000Oo().O00000o0);
            } else {
                this.O0000o0o.setText("");
            }
            if (!TextUtils.isEmpty(str)) {
                this.O0000o0.setVisibility(0);
                hxi.O00000oO.f958O000000o.O000000o("scene_templateshopping_show", "homeid", this.manager.O00000o0(), "templateid", Long.valueOf(this.manager.O00000Oo().O00000Oo.longValue()));
                this.O0000o0.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.AnonymousClass4 */

                    public final void onClick(View view) {
                        hxk hxk = hxi.O00000o;
                        String O00000o0 = RecommendSceneDetailPage.this.manager.O00000o0();
                        long longValue = RecommendSceneDetailPage.this.manager.O00000Oo().O00000Oo.longValue();
                        hxk.f952O000000o.O000000o("scene_templateshopping_click", "homeid", O00000o0, "templateid", Long.valueOf(longValue));
                        OperationCommonWebViewActivity.start(RecommendSceneDetailPage.this.getContext(), str, null);
                    }
                });
                return;
            }
            this.O0000o0.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        hqs hqs;
        if (this.visibleData.get(0) == null || (this.visibleData.get(0) instanceof O0000O0o)) {
            boolean z = this.mScene.O0000O0o;
            if (!((O0000O0o) this.visibleData.get(0)).O00000oO) {
                gqg.O00000Oo((int) R.string.rec_scene_settable_false);
                return;
            }
            createSceneFromRecUIData();
            hxk hxk = hxi.O00000o;
            String O00000o02 = this.manager.O00000o0();
            long longValue = this.manager.O00000Oo().O00000Oo.longValue();
            int O000000o2 = O000000o(this.mScene);
            hqs hqs2 = this.mScene;
            boolean z2 = true;
            hxk.f952O000000o.O000000o("scene_templateedit_click", "homeid", O00000o02, "state", Integer.valueOf(O000000o2), "us_id", Long.valueOf(hqs2 == null ? 0 : hqs2.f529O000000o), "templateid", Long.valueOf(longValue));
            if (this.mScene.f529O000000o <= 0) {
                hqs = this.mScene;
            } else {
                hqs = this.mScene;
                if (z) {
                    z2 = false;
                }
            }
            hqs.O0000O0o = z2;
            O000000o();
        }
    }

    private static int O000000o(hqs hqs) {
        if (hqs == null || hqs.f529O000000o <= 0) {
            return 1;
        }
        return hqs.O0000O0o ? 2 : 3;
    }

    public Consumer getErrorDataConsumer() {
        return new Consumer() {
            /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$VrYcerY0XF1ugtvwlThxi82HUYA */

            public final void accept(Object obj) {
                RecommendSceneDetailPage.this.O000000o((Exception) obj);
            }
        };
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Exception exc) throws Exception {
        if (!this.co.isDisposed()) {
            this.co.dispose();
        }
        this.O0000Ooo.setVisibility(8);
        gqg.O00000Oo((int) R.string.loading_failed);
        finish();
    }

    public Observable<Map<String, List<Pair<String, String>>>> getDeviceInfoObservable(SparseArray<Map<String, SpecDevice>> sparseArray) {
        return Observable.create(new ObservableOnSubscribe(sparseArray) {
            /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$ep58FqckUdGf425Ms1F25VeYwE */
            private final /* synthetic */ SparseArray f$1;

            {
                this.f$1 = r2;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                RecommendSceneDetailPage.this.O000000o(this.f$1, observableEmitter);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(SparseArray sparseArray, final ObservableEmitter observableEmitter) throws Exception {
        if (sparseArray != null) {
            HashSet hashSet = new HashSet();
            hashSet.addAll(O000000o((Map) sparseArray.get(0)));
            hashSet.addAll(O000000o((Map) sparseArray.get(1)));
            hashSet.addAll(O000000o((Map) sparseArray.get(2)));
            if (!hashSet.isEmpty()) {
                hnz.O000000o(this, new ArrayList(hashSet), new fsy<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.AnonymousClass5 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONArray optJSONArray;
                        JSONObject jSONObject = (JSONObject) obj;
                        HashMap hashMap = new HashMap();
                        if (!(jSONObject == null || (optJSONArray = jSONObject.optJSONArray("list")) == null || optJSONArray.length() <= 0)) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                                if (optJSONObject != null && optJSONObject.has("member_ship")) {
                                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("member_ship");
                                    ArrayList arrayList = new ArrayList();
                                    for (int i2 = 0; i2 < 3; i2++) {
                                        Pair<String, String> pair = RecommendSceneDetailPage.this.getdeviceInfoPair(optJSONObject2, i2);
                                        if (pair != null) {
                                            arrayList.add(pair);
                                        }
                                    }
                                    if (arrayList.size() == 2 || arrayList.size() == 3) {
                                        hashMap.put(optJSONObject.optString("did"), arrayList);
                                    }
                                }
                            }
                        }
                        if (!observableEmitter.isDisposed()) {
                            observableEmitter.onNext(hashMap);
                        }
                    }

                    public final void onFailure(fso fso) {
                        if (!observableEmitter.isDisposed()) {
                            ObservableEmitter observableEmitter = observableEmitter;
                            StringBuilder sb = new StringBuilder();
                            sb.append(fso.f17063O000000o);
                            observableEmitter.onError(new Exception(sb.toString()));
                        }
                    }
                });
            } else if (!observableEmitter.isDisposed()) {
                observableEmitter.onNext(new HashMap());
            }
        } else if (!observableEmitter.isDisposed()) {
            observableEmitter.onNext(new HashMap());
        }
    }

    public Pair<String, String> getdeviceInfoPair(JSONObject jSONObject, int i) {
        if (!jSONObject.has(String.valueOf(i))) {
            return null;
        }
        try {
            String optString = jSONObject.optJSONObject(String.valueOf(i)).optString("home_id");
            String optString2 = jSONObject.optJSONObject(String.valueOf(i)).optString("room_id");
            String optString3 = jSONObject.optJSONObject(String.valueOf(i)).optString("name");
            return new Pair<>(optString + "-" + optString2, optString3);
        } catch (Exception e) {
            gsy.O00000Oo("RecScene", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0015 A[EDGE_INSN: B:25:0x0015->B:22:0x0015 ?: BREAK  , SYNTHETIC] */
    private static Set<String> O000000o(Map<String, SpecDevice> map) {
        HashSet hashSet = new HashSet();
        if (map != null && map.size() > 0) {
            for (Map.Entry next : map.entrySet()) {
                Map<Integer, SpecService> services = ((SpecDevice) next.getValue()).getServices();
                if (services != null) {
                    Iterator<Map.Entry<Integer, SpecService>> it = services.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            SpecService specService = (SpecService) it.next().getValue();
                            String trim = specService.getDescription().toLowerCase().replace(" ", "").trim();
                            if ((specService != null && TextUtils.equals("leftswitchservice", trim)) || TextUtils.equals("middleswitchservice", trim) || TextUtils.equals("rightswitchservice", trim)) {
                                hashSet.add(next.getKey());
                            }
                            if (!it.hasNext()) {
                                break;
                            }
                        }
                    }
                    hashSet.add(next.getKey());
                }
            }
        }
        return hashSet;
    }

    public Observable<hqs> getSceneDetailObservable(long j) {
        return Observable.create(new ObservableOnSubscribe(j) {
            /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$00QZ0fh3_Q5On3Y_8i_LMDQaTQ */
            private final /* synthetic */ long f$1;

            {
                this.f$1 = r2;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                RecommendSceneDetailPage.this.O000000o(this.f$1, observableEmitter);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(long j, final ObservableEmitter observableEmitter) throws Exception {
        if (j <= 0) {
            try {
                if (!observableEmitter.isDisposed()) {
                    observableEmitter.onNext(new hqs());
                }
            } catch (Exception e) {
                LogType logType = LogType.SCENE;
                gsy.O00000o0(logType, "recScene", "getSceneDetailObservable exception:\n" + e.getMessage());
                if (!observableEmitter.isDisposed()) {
                    observableEmitter.onError(e);
                }
            }
        } else {
            hnz.O000000o(this, j, 1, new fsy<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.AnonymousClass6 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    gsy.O00000o0(LogType.SCENE, "recScene", "scene detail success");
                    if (observableEmitter.isDisposed()) {
                        return;
                    }
                    if (jSONObject != null) {
                        hqs O000000o2 = hqs.O000000o(jSONObject);
                        gsy.O00000o0(LogType.SCENE, "recScene", new StringBuilder("scene detail is not null").toString());
                        observableEmitter.onNext(O000000o2);
                        return;
                    }
                    observableEmitter.onNext(new hqs());
                }

                public final void onFailure(fso fso) {
                    if (!observableEmitter.isDisposed()) {
                        ObservableEmitter observableEmitter = observableEmitter;
                        StringBuilder sb = new StringBuilder();
                        sb.append(fso.f17063O000000o);
                        observableEmitter.onError(new Exception(sb.toString()));
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hri.O000000o(java.lang.String, _m_j.hof, java.util.Map<java.lang.String, com.xiaomi.smarthome.device.api.spec.instance.SpecDevice>, boolean):io.reactivex.Observable<android.util.SparseArray<java.util.ArrayList<com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage$O0000Oo>>>
     arg types: [java.lang.String, _m_j.hof, java.util.Map<java.lang.String, com.xiaomi.smarthome.device.api.spec.instance.SpecDevice>, int]
     candidates:
      _m_j.hri.O000000o(java.lang.String, java.util.List<_m_j.hof$O00000o0$O00000o0>, int, java.util.Map<java.lang.Integer, com.xiaomi.smarthome.device.api.spec.instance.SpecProperty>):java.util.List<_m_j.hrc>
      _m_j.hri.O000000o(_m_j.hof, java.util.Map, boolean, io.reactivex.ObservableEmitter):void
      _m_j.hri.O000000o(java.lang.String, _m_j.hof, java.util.Map<java.lang.String, com.xiaomi.smarthome.device.api.spec.instance.SpecDevice>, boolean):io.reactivex.Observable<android.util.SparseArray<java.util.ArrayList<com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage$O0000Oo>>> */
    public Observable<SparseArray<ArrayList<O0000Oo>>> getConditionObservable(Map<String, SpecDevice> map) {
        return hri.O000000o(this.manager.O00000o0(), this.manager.O00000Oo(), map, true);
    }

    public Observable<SparseArray<ArrayList<O0000Oo>>> getTriggerObservable(Map<String, SpecDevice> map) {
        return hri.O00000Oo(this.manager.O00000o0(), this.manager.O00000Oo(), map, true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hri.O000000o(_m_j.hof, java.util.Map<java.lang.String, com.xiaomi.smarthome.device.api.spec.instance.SpecDevice>, boolean):io.reactivex.Observable<android.util.SparseArray<java.util.ArrayList<java.util.ArrayList<com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage$O0000Oo>>>>
     arg types: [_m_j.hof, java.util.Map<java.lang.String, com.xiaomi.smarthome.device.api.spec.instance.SpecDevice>, int]
     candidates:
      _m_j.hri.O000000o(_m_j.hof$O00000o, _m_j.hof$O0000O0o, _m_j.hof$O00000o0):android.util.SparseArray
      _m_j.hri.O000000o(java.lang.Object, int, java.util.Map<java.lang.Integer, com.xiaomi.smarthome.device.api.spec.instance.SpecProperty>):java.lang.Object
      _m_j.hri.O000000o(long, android.content.Context, io.reactivex.ObservableEmitter):void
      _m_j.hri.O000000o(java.util.List, _m_j.hof, io.reactivex.ObservableEmitter):void
      _m_j.hri.O000000o(_m_j.hof, java.util.Map<java.lang.String, com.xiaomi.smarthome.device.api.spec.instance.SpecDevice>, boolean):io.reactivex.Observable<android.util.SparseArray<java.util.ArrayList<java.util.ArrayList<com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage$O0000Oo>>>> */
    public Observable<SparseArray<ArrayList<ArrayList<O0000Oo>>>> getActionObservable(Map<String, SpecDevice> map) {
        return hri.O000000o(this.manager.O00000Oo(), map, true);
    }

    public ArrayList<O0000Oo> mergeTriggers2Rec(ArrayList<O0000Oo> arrayList, long j, ArrayList<hqs.O0000Oo0> arrayList2) {
        hof.O0000O0o.O00000Oo O000000o2;
        O0000Oo O000000o3;
        hqs.O0000OOo o0000OOo;
        Home O00000o2;
        if (!(arrayList2 == null || arrayList2.size() == 0)) {
            ArrayList arrayList3 = new ArrayList();
            if (arrayList != null && arrayList.size() > 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (arrayList.get(i) instanceof hqe) {
                        ((hqe) arrayList.get(i)).O00000oo = false;
                    }
                    arrayList3.add(arrayList.get(i));
                }
            }
            arrayList = new ArrayList<>();
            if (arrayList2 != null && arrayList2.size() > 0) {
                for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                    if (((!TextUtils.equals(arrayList2.get(i2).O00000oo, ConstantType.TriggerConditionType.LOCATION_LEAVE.key) && !TextUtils.equals(arrayList2.get(i2).O00000oo, ConstantType.TriggerConditionType.LOCATION_ENTER.key)) || !(arrayList2.get(i2).O0000O0o instanceof hqs.O0000OOo) || (o0000OOo = (hqs.O0000OOo) arrayList2.get(i2).O0000O0o) == null || TextUtils.isEmpty(o0000OOo.O00000Oo) || ((O00000o2 = ggb.O00000Oo().O00000o(o0000OOo.O00000Oo)) != null && !TextUtils.isEmpty(O00000o2.getAddr()) && !TextUtils.isEmpty(O00000o2.getLatitude()) && !TextUtils.isEmpty(O00000o2.getLongitude()))) && (O000000o2 = this.manager.O000000o(j, arrayList2.get(i2).f538O000000o)) != null && O000000o2.O00000o0.intValue() != ConstantType.StyleType.HIDE.styleId && (O000000o3 = hri.O000000o(O000000o2, arrayList2.get(i2))) != null) {
                        arrayList.add(O000000o3);
                        int i3 = 0;
                        while (true) {
                            if (i3 >= arrayList3.size()) {
                                break;
                            }
                            if ((arrayList3.get(i3) instanceof hqf) && (O000000o3 instanceof hqf) && ((hqf) arrayList3.get(i3)).O00000Oo == ((hqf) O000000o3).O00000Oo) {
                                if (!(arrayList3.get(i3) instanceof hpw) || !(O000000o3 instanceof hpw)) {
                                    arrayList3.remove(i3);
                                } else if (TextUtils.equals(((hpw) arrayList3.get(i3)).O00000Oo(), ((hpw) O000000o3).O00000Oo())) {
                                    arrayList3.remove(i3);
                                    break;
                                }
                            }
                            i3++;
                        }
                        arrayList3.remove(i3);
                    }
                }
            }
            for (int i4 = 0; i4 < arrayList3.size(); i4++) {
                if (arrayList3.get(i4) instanceof O00000o0) {
                    arrayList.add(0, arrayList3.get(i4));
                } else {
                    ((hqf) arrayList3.get(i4)).O00000oo = false;
                    arrayList.add(arrayList3.get(i4));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r8v8, types: [com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage$O0000Oo] */
    /* JADX WARN: Type inference failed for: r8v9, types: [_m_j.hqh] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public ArrayList<O0000Oo> mergeCondition2Rec(ArrayList<O0000Oo> arrayList, long j, ArrayList<hqs.O00000o0> arrayList2) {
        hqj hqj;
        ArrayList<O0000Oo> arrayList3 = arrayList;
        ArrayList<hqs.O00000o0> arrayList4 = arrayList2;
        if (arrayList4 == null || arrayList2.size() == 0) {
            return arrayList3;
        }
        ArrayList arrayList5 = new ArrayList();
        if (arrayList3 != null && arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList3.get(i) instanceof hqd) {
                    ((hqd) arrayList3.get(i)).O00000oo = false;
                }
                arrayList5.add(arrayList3.get(i));
            }
        }
        ArrayList<O0000Oo> arrayList6 = new ArrayList<>();
        if (arrayList4 != null && arrayList2.size() > 0) {
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                hof.O00000o.O00000Oo O00000Oo2 = this.manager.O00000Oo(j, arrayList4.get(i2).f536O000000o);
                if (O00000Oo2 != null && O00000Oo2.O00000o0.intValue() != ConstantType.StyleType.HIDE.styleId) {
                    hqs.O00000o0 o00000o0 = arrayList4.get(i2);
                    if (TextUtils.equals("cloud", o00000o0.O00000Oo)) {
                        if (TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_SUNSET.key, o00000o0.O00000o) || TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_SUNRISE.key, o00000o0.O00000o)) {
                            String str = o00000o0.O00000o;
                            hqs.O00000Oo o00000Oo = (hqs.O00000Oo) o00000o0.O0000O0o;
                            hpx hpx = new hpx(str);
                            if (TextUtils.isEmpty(o00000Oo.O00000Oo) || TextUtils.isEmpty(o00000Oo.f534O000000o)) {
                                hpx.O00000o = o00000Oo.O00000o0;
                            }
                            hqj hqj2 = new hqj(O00000Oo2.O00000Oo.intValue(), O00000Oo2.O0000o0.intValue(), O00000Oo2.O00000o.intValue(), O00000Oo2.O00000o0.intValue(), hpx);
                            hqj2.O00000oo = true;
                            hqj = hqj2;
                        } else {
                            String str2 = o00000o0.O00000o;
                            Object obj = o00000o0.O00000oO;
                            hpx hpx2 = new hpx(str2);
                            hpx2.O000000o(obj);
                            hqj hqj3 = new hqj(O00000Oo2.O00000Oo.intValue(), O00000Oo2.O0000o0.intValue(), O00000Oo2.O00000o.intValue(), O00000Oo2.O00000o0.intValue(), hpx2);
                            hqj3.O00000oo = true;
                            hqj = hqj3;
                        }
                    } else if (TextUtils.equals("any", o00000o0.O00000Oo)) {
                        ? hqh = new hqh(O00000Oo2.O00000Oo.intValue(), O00000Oo2.O0000o0.intValue(), O00000Oo2.O00000o.intValue(), O00000Oo2.O00000o0.intValue());
                        hqh.O00000oo = true;
                        hqj = hqh;
                    } else {
                        hqj = TextUtils.equals("device", o00000o0.O00000Oo) ? hri.O000000o(O00000Oo2, o00000o0.O00000o, (hqs.O00000o) o00000o0.O0000O0o, o00000o0.O00000oO, o00000o0.O00000oo) : null;
                    }
                    if (hqj != null) {
                        arrayList6.add(hqj);
                        int i3 = 0;
                        while (true) {
                            if (i3 >= arrayList5.size()) {
                                break;
                            }
                            if ((arrayList5.get(i3) instanceof hqf) && (hqj instanceof hqf) && ((hqf) arrayList5.get(i3)).O00000Oo == hqj.O00000Oo) {
                                if (!(arrayList5.get(i3) instanceof hpw) || !(hqj instanceof hpw)) {
                                    arrayList5.remove(i3);
                                } else if (TextUtils.equals(((hpw) arrayList5.get(i3)).O00000Oo(), ((hqn) hqj).O0000OOo)) {
                                    arrayList5.remove(i3);
                                    break;
                                }
                            }
                            i3++;
                        }
                    }
                }
            }
        }
        for (int i4 = 0; i4 < arrayList5.size(); i4++) {
            if (arrayList5.get(i4) instanceof O00000o0) {
                arrayList6.add(0, arrayList5.get(i4));
            } else {
                ((hqf) arrayList5.get(i4)).O00000oo = false;
                if (!(arrayList5.get(i4) instanceof hqh)) {
                    arrayList6.add(arrayList5.get(i4));
                } else if (arrayList6.size() <= 0 || !(arrayList6.get(0) instanceof O00000o0)) {
                    arrayList6.add(0, arrayList5.get(i4));
                } else {
                    arrayList6.add(1, arrayList5.get(i4));
                }
            }
        }
        return arrayList6;
    }

    public ArrayList<O0000Oo> mergeAction2Rec(ArrayList<O0000Oo> arrayList, long j, ArrayList<hqs.O000000o> arrayList2) {
        int i;
        hqc O000000o2;
        if (arrayList2 != null && arrayList2.size() != 0) {
            ArrayList arrayList3 = new ArrayList();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            ArrayList arrayList4 = new ArrayList();
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (arrayList.get(i2) instanceof hqc) {
                        ((hqc) arrayList.get(i2)).O00000oo = false;
                    }
                    arrayList4.add(arrayList.get(i2));
                }
            }
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                hof.O00000o0.O00000Oo O000000o3 = this.manager.O000000o(j, arrayList2.get(i3).O00000Oo, arrayList2.get(i3).f530O000000o);
                if (!(O000000o3 == null || O000000o3.O00000o.intValue() == ConstantType.StyleType.HIDE.styleId || (O000000o2 = hri.O000000o(O000000o3, arrayList2.get(i3))) == null)) {
                    if (!hashMap2.containsKey(Integer.valueOf(arrayList2.get(i3).O00000Oo))) {
                        hashMap2.put(Integer.valueOf(arrayList2.get(i3).O00000Oo), new ArrayList());
                    }
                    ((List) hashMap2.get(Integer.valueOf(arrayList2.get(i3).O00000Oo))).add(O000000o2);
                    arrayList3.add(O000000o2);
                }
            }
            for (int size = arrayList4.size() - 1; size >= 0; size--) {
                if (arrayList4.get(size) instanceof hqc) {
                    hqc hqc = (hqc) arrayList4.get(size);
                    int i4 = hqc.f521O000000o;
                    if (hashMap2.containsKey(Integer.valueOf(i4))) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= ((List) hashMap2.get(Integer.valueOf(i4))).size()) {
                                break;
                            }
                            if (((hqc) ((List) hashMap2.get(Integer.valueOf(i4))).get(i5)).f521O000000o == hqc.f521O000000o && ((hqc) ((List) hashMap2.get(Integer.valueOf(i4))).get(i5)).O00000Oo == hqc.O00000Oo && (((List) hashMap2.get(Integer.valueOf(i4))).get(i5) instanceof hqm)) {
                                if ((((hqm) arrayList4.get(size)).O0000Ooo instanceof hrc) && (((hqm) ((List) hashMap2.get(Integer.valueOf(i4))).get(i5)).O0000Ooo instanceof hrc)) {
                                    hrc hrc = (hrc) ((hqm) arrayList4.get(size)).O0000Ooo;
                                    hrc hrc2 = (hrc) ((hqm) ((List) hashMap2.get(Integer.valueOf(i4))).get(i5)).O0000Ooo;
                                    if (TextUtils.equals(hrc.O00000o0, hrc2.O00000o0) && hrc.O00000o == hrc2.O00000o && hrc.f543O000000o == hrc2.f543O000000o) {
                                        arrayList4.remove(size);
                                        break;
                                    }
                                }
                                if ((((hqm) arrayList4.get(size)).O0000Ooo instanceof hqz) && (((hqm) ((List) hashMap2.get(Integer.valueOf(i4))).get(i5)).O0000Ooo instanceof hqz)) {
                                    hqz hqz = (hqz) ((hqm) arrayList4.get(size)).O0000Ooo;
                                    hqz hqz2 = (hqz) ((hqm) ((List) hashMap2.get(Integer.valueOf(i4))).get(i5)).O0000Ooo;
                                    if (TextUtils.equals(hqz.O00000o0, hqz2.O00000o0) && hqz.O00000o == hqz2.O00000o && hqz.f541O000000o == hqz2.f541O000000o) {
                                        arrayList4.remove(size);
                                        break;
                                    }
                                }
                            }
                            i5++;
                        }
                    }
                }
            }
            for (int i6 = 0; i6 < arrayList4.size(); i6++) {
                if (arrayList4.get(i6) instanceof hqc) {
                    i = ((hqc) arrayList4.get(i6)).f521O000000o;
                } else {
                    i = arrayList4.get(i6) instanceof O00000o0 ? ((O00000o0) arrayList4.get(i6)).O00000Oo : -1;
                }
                if (i != -1) {
                    if (!hashMap.containsKey(Integer.valueOf(i))) {
                        hashMap.put(Integer.valueOf(i), new ArrayList());
                    }
                    ((List) hashMap.get(Integer.valueOf(i))).add(arrayList4.get(i6));
                }
            }
            arrayList = new ArrayList<>();
            int i7 = 0;
            while (true) {
                if (i7 >= (this.manager.O00000o() == null ? 0 : this.manager.O00000o().size())) {
                    break;
                }
                hof.O00000o0.O0000O0o o0000O0o = this.manager.O00000o().get(i7);
                int intValue = o0000O0o.O00000Oo.intValue();
                List list = (List) hashMap.get(Integer.valueOf(intValue));
                ArrayList arrayList5 = new ArrayList();
                List list2 = (List) hashMap2.get(Integer.valueOf(intValue));
                if (list2 != null && list2.size() > 0) {
                    arrayList5.addAll(list2);
                }
                if (list != null && list.size() > 0) {
                    if (list.get(0) instanceof O00000o0) {
                        list.remove(0);
                    }
                    arrayList5.addAll(list);
                }
                if (arrayList5.size() > 0) {
                    arrayList.add(new O00000o0(o0000O0o.O00000o, intValue));
                    arrayList.addAll(arrayList5);
                }
                i7++;
            }
        }
        return arrayList;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == this.mCurrentRequestId) {
            for (int i3 = 0; i3 < this.visibleData.size(); i3++) {
                if ((this.visibleData.get(i3) instanceof hqg) && (this.visibleData.get(i3) instanceof hqf)) {
                    ((hqf) this.visibleData.get(i3)).O000000o(intent);
                    ((hqf) this.visibleData.get(i3)).O00000oo = true;
                }
            }
            if (this.mCurrentRequestUI.O0000O0o > 0 && (this.visibleData.get(this.mCurrentRequestUI.O0000O0o) instanceof O00000o0)) {
                ((O00000o0) this.visibleData.get(this.mCurrentRequestUI.O0000O0o)).O00000o = this.mCurrentRequestPos;
            }
            boolean isSettable = isSettable();
            if (this.visibleData.get(0) instanceof O0000O0o) {
                ((O0000O0o) this.visibleData.get(0)).O00000oO = isSettable;
            }
            this.isHomeUpdated = true;
            this.mAdapter.notifyDataSetChanged();
        }
    }

    class O000000o extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
        public final long getItemId(int i) {
            return (long) i;
        }

        private O000000o() {
        }

        /* synthetic */ O000000o(RecommendSceneDetailPage recommendSceneDetailPage, byte b) {
            this();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return new O0000OOo(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_rcscene_header, viewGroup, false));
            }
            if (i == 1) {
                return new O00000o(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_rcscene_group, viewGroup, false));
            }
            if (i == 2) {
                return new O00000Oo(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_rcscene_device, viewGroup, false));
            }
            if (i == 3) {
                return new O0000Oo0(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_rcscene_nodevice, viewGroup, false));
            }
            if (i != 4) {
                return null;
            }
            return new O0000o00(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_rcscene_user_click, viewGroup, false));
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x004e  */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x0177  */
        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            int i2;
            int itemViewType = getItemViewType(i);
            O0000Oo o0000Oo = RecommendSceneDetailPage.this.visibleData.get(i);
            if (i != 0) {
                int i3 = i - 1;
                if (!(RecommendSceneDetailPage.this.visibleData.get(i3) instanceof O00000o0) && !(RecommendSceneDetailPage.this.visibleData.get(i3) instanceof O0000O0o)) {
                    i2 = 0;
                    if (i == RecommendSceneDetailPage.this.visibleData.size() - 1 || (RecommendSceneDetailPage.this.visibleData.get(i + 1) instanceof O00000o0)) {
                        i2 |= 2;
                    }
                    if (itemViewType != 0) {
                        ((O0000OOo) o000OOo0).O000000o((O0000O0o) o0000Oo);
                        return;
                    } else if (itemViewType == 1) {
                        O00000o o00000o = (O00000o) o000OOo0;
                        O00000o0 o00000o0 = (O00000o0) o0000Oo;
                        if (!TextUtils.isEmpty(o00000o0.f11280O000000o)) {
                            o00000o.f11279O000000o.setText(o00000o0.f11280O000000o);
                            return;
                        }
                        return;
                    } else if (itemViewType != 2) {
                        if (itemViewType != 3) {
                            if (itemViewType == 4 && (o0000Oo instanceof hqi)) {
                                ((O0000o00) o000OOo0).O000000o((hqi) o0000Oo, i2);
                                return;
                            }
                            return;
                        } else if (o0000Oo instanceof hqp) {
                            ((O0000Oo0) o000OOo0).O000000o((hqp) o0000Oo, i, i2);
                            return;
                        } else if (o0000Oo instanceof hqj) {
                            ((O0000Oo0) o000OOo0).O000000o((hqj) o0000Oo, i, i2);
                            return;
                        } else if (o0000Oo instanceof hqh) {
                            O0000Oo0 o0000Oo0 = (O0000Oo0) o000OOo0;
                            o0000Oo0.O000000o((hqh) o0000Oo, i, i2);
                            o0000Oo0.O00000Oo.setText((int) R.string.condition_any_time);
                            o0000Oo0.O00000o0.setText((int) R.string.condition_any_time_desc);
                            o0000Oo0.f11284O000000o.setActualImageResource(R.drawable.icon_condition_any_time);
                            return;
                        } else {
                            return;
                        }
                    } else if (o0000Oo instanceof hqo) {
                        O00000Oo o00000Oo = (O00000Oo) o000OOo0;
                        hqo hqo = (hqo) o0000Oo;
                        o00000Oo.O000000o(hqo, i2);
                        o00000Oo.O000000o(hqo);
                        CharSequence text = o00000Oo.f11278O000000o.getText();
                        if (TextUtils.equals(hqo.O0000o0O.O00000oO, "event:lock-opened") && !TextUtils.isEmpty(text)) {
                            text = ((Object) text) + " " + RecommendSceneDetailPage.this.getString(R.string.rec_lock_open_trigger);
                        }
                        if (TextUtils.equals(hqo.O0000o0O.O00000oO, "event:lock-lock") && !TextUtils.isEmpty(text)) {
                            text = ((Object) text) + " " + RecommendSceneDetailPage.this.getString(R.string.rec_lock_lock_trigger);
                            o00000Oo.f11278O000000o.setText(((Object) text) + " " + RecommendSceneDetailPage.this.getString(R.string.rec_lock_lock_trigger));
                        }
                        if (!TextUtils.isEmpty(text)) {
                            o00000Oo.f11278O000000o.setText(text);
                            return;
                        } else {
                            o00000Oo.f11278O000000o.setText("");
                            return;
                        }
                    } else if (o0000Oo instanceof hqn) {
                        O00000Oo o00000Oo2 = (O00000Oo) o000OOo0;
                        hqn hqn = (hqn) o0000Oo;
                        o00000Oo2.O000000o(hqn, i2);
                        o00000Oo2.O000000o(hqn);
                        return;
                    } else if (o0000Oo instanceof hqm) {
                        O00000Oo o00000Oo3 = (O00000Oo) o000OOo0;
                        hqm hqm = (hqm) o0000Oo;
                        o00000Oo3.O000000o(hqm, i2);
                        o00000Oo3.O000000o(hqm);
                        return;
                    } else {
                        return;
                    }
                }
            }
            i2 = 1;
            i2 |= 2;
            if (itemViewType != 0) {
            }
        }

        public final int getItemCount() {
            if (RecommendSceneDetailPage.this.visibleData == null) {
                return 0;
            }
            return RecommendSceneDetailPage.this.visibleData.size();
        }

        public final int getItemViewType(int i) {
            return RecommendSceneDetailPage.this.visibleData.get(i).p_();
        }
    }

    class O0000OOo extends RecyclerView.O000OOo0 {
        private SimpleDraweeView O00000Oo;
        private TextView O00000o;
        private SimpleDraweeView O00000o0;
        private TextView O00000oO;
        private SwitchButton O00000oo;
        private View O0000O0o;

        public O0000OOo(View view) {
            super(view);
            this.O00000Oo = (SimpleDraweeView) view.findViewById(R.id.rec_icon);
            this.O00000o0 = (SimpleDraweeView) view.findViewById(R.id.edit_rec_icon);
            this.O00000o = (TextView) view.findViewById(R.id.rec_title);
            this.O00000oO = (TextView) view.findViewById(R.id.rec_sub_title);
            this.O00000oo = (SwitchButton) view.findViewById(R.id.chk_enable);
            this.O0000O0o = view.findViewById(R.id.edit_view);
        }

        public final void O000000o(final O0000O0o o0000O0o) {
            this.O00000oo.setOnCheckedChangeListener(null);
            if (RecommendSceneDetailPage.this.mScene == null || RecommendSceneDetailPage.this.mScene.f529O000000o <= 0) {
                this.O00000Oo.setVisibility(0);
                this.O0000O0o.setVisibility(8);
            } else {
                this.O00000Oo.setVisibility(8);
                this.O0000O0o.setVisibility(0);
            }
            if (!TextUtils.isEmpty(o0000O0o.f11281O000000o)) {
                this.O00000Oo.setImageURI(o0000O0o.f11281O000000o);
                this.O00000o0.setImageURI(o0000O0o.f11281O000000o);
            }
            if (!TextUtils.isEmpty(o0000O0o.O00000Oo)) {
                this.O00000o.setText(o0000O0o.O00000Oo);
            } else {
                this.O00000o.setText("");
            }
            if (!TextUtils.isEmpty(o0000O0o.O00000o0)) {
                this.O00000oO.setText(o0000O0o.O00000o0);
            } else {
                this.O00000oO.setText("");
            }
            this.O0000O0o.setOnClickListener(new View.OnClickListener(o0000O0o) {
                /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$O0000OOo$nGlNcyunRNCdjuEMZWimANdxyOM */
                private final /* synthetic */ RecommendSceneDetailPage.O0000O0o f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    RecommendSceneDetailPage.O0000OOo.this.O000000o(this.f$1, view);
                }
            });
            this.O00000oo.setChecked(o0000O0o.O00000o);
            this.O00000oo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.O0000OOo.AnonymousClass1 */

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    o0000O0o.O00000o = z;
                    ((O0000O0o) RecommendSceneDetailPage.this.visibleData.get(0)).O00000o = z;
                    RecommendSceneDetailPage.this.mAdapter.notifyDataSetChanged();
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(O0000O0o o0000O0o, View view) {
            this.O00000oo.setChecked(!o0000O0o.O00000o);
        }
    }

    private void O000000o() {
        hqg hqg;
        int i = 0;
        while (true) {
            if (i < this.visibleData.size()) {
                if ((this.visibleData.get(i) instanceof hqg) && ((hqg) this.visibleData.get(i)).n_()) {
                    hqg = (hqg) this.visibleData.get(i);
                    break;
                }
                i++;
            } else {
                hqg = null;
                break;
            }
        }
        if (hqg != null) {
            Home O00000o2 = ggb.O00000Oo().O00000o(this.manager.O00000o0());
            StringBuilder sb = new StringBuilder();
            sb.append(hqg.O00000o0());
            O00000o2.setLatitude(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(hqg.O00000Oo());
            O00000o2.setLongitude(sb2.toString());
            O00000o2.setAddr(hqg.O00000oO());
            String O00000o3 = hqg.O00000o();
            if (!TextUtils.isEmpty(O00000o3)) {
                O00000o2.setLocationId(O00000o3);
            }
            ggb.O00000Oo().O000000o(O00000o2, new ggb.O00000o() {
                /* class com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.AnonymousClass7 */

                public final void O000000o() {
                    RecommendSceneDetailPage.this.editScene();
                }

                public final void O000000o(int i, fso fso) {
                    if (RecommendSceneDetailPage.this.isValid()) {
                        RecommendSceneDetailPage.this.dismissProgressDialog();
                        RecommendSceneDetailPage recommendSceneDetailPage = RecommendSceneDetailPage.this;
                        gqg.O00000Oo(recommendSceneDetailPage.getString(R.string.rec_scene_set_fail, new Object[]{recommendSceneDetailPage.mScene.O00000o}));
                    }
                }
            });
            ggb.O00000Oo().O0000o();
            return;
        }
        editScene();
    }

    public void editScene() {
        final AnonymousClass8 r0 = new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.AnonymousClass8 */

            public final void onFailure(fso fso) {
                if (RecommendSceneDetailPage.this.isValid()) {
                    RecommendSceneDetailPage.this.dismissProgressDialog();
                    RecommendSceneDetailPage recommendSceneDetailPage = RecommendSceneDetailPage.this;
                    gqg.O00000Oo(recommendSceneDetailPage.getString(R.string.rec_scene_set_fail, new Object[]{recommendSceneDetailPage.mScene.O00000o}));
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:22:0x00a2  */
            public final /* synthetic */ void onSuccess(Object obj) {
                String str;
                GeoFenceItem O000000o2;
                String O000000o3;
                if (RecommendSceneDetailPage.this.isValid()) {
                    RecommendSceneDetailPage.this.refreshRecSceneList();
                    hod O0000OoO = hod.O0000OoO();
                    hqs hqs = RecommendSceneDetailPage.this.mScene;
                    hqs.O0000OOo o0000OOo = null;
                    if (hqs != null && hqs.O0000o00 != null) {
                        int i = 0;
                        while (true) {
                            if (i < hqs.O0000o00.size()) {
                                if (hqs.O0000o00.get(i).O0000O0o != null && (hqs.O0000o00.get(i).O0000O0o instanceof hqs.O0000OOo)) {
                                    str = hqs.O0000o00.get(i).O00000oo;
                                    o0000OOo = (hqs.O0000OOo) hqs.O0000o00.get(i).O0000O0o;
                                    break;
                                }
                                i++;
                            } else {
                                break;
                            }
                        }
                        if (!TextUtils.isEmpty(str) && (O000000o2 = hnw.O000000o(o0000OOo.O00000Oo, (double) o0000OOo.O00000oO, str, hqs.f529O000000o)) != null) {
                            O000000o3 = hpe.O000000o(fcn.O000000o().O00000Oo(), ftn.O000000o(ServiceApplication.getAppContext()).O00000Oo, "scene-".concat(String.valueOf(o0000OOo.f537O000000o)));
                            gsy.O00000o0(LogType.SCENE, "GEO_FENCE", "need add fence");
                            if (O0000OoO.O0000oOO.containsKey(O000000o3)) {
                                gsy.O00000o0(LogType.GENERAL, "GEO_FENCE", "already created，update?" + hqs.f529O000000o + ", lat:" + o0000OOo.O00000o0 + ", lon:" + o0000OOo.O00000o);
                            }
                            hpf.O000000o().O000000o(O000000o3, O000000o2);
                        }
                        RecommendSceneDetailPage.this.dismissProgressDialog();
                        RecommendSceneDetailPage.this.finish();
                    }
                    str = null;
                    O000000o3 = hpe.O000000o(fcn.O000000o().O00000Oo(), ftn.O000000o(ServiceApplication.getAppContext()).O00000Oo, "scene-".concat(String.valueOf(o0000OOo.f537O000000o)));
                    gsy.O00000o0(LogType.SCENE, "GEO_FENCE", "need add fence");
                    if (O0000OoO.O0000oOO.containsKey(O000000o3)) {
                    }
                    hpf.O000000o().O000000o(O000000o3, O000000o2);
                    RecommendSceneDetailPage.this.dismissProgressDialog();
                    RecommendSceneDetailPage.this.finish();
                }
            }
        };
        hnz.O000000o(this, 1, this.mScene.O000000o().toString(), 1, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.AnonymousClass9 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                if (RecommendSceneDetailPage.this.mScene.f529O000000o <= 0) {
                    RecommendSceneDetailPage recommendSceneDetailPage = RecommendSceneDetailPage.this;
                    gqg.O00000Oo(recommendSceneDetailPage.getString(R.string.rec_scene_set_success, new Object[]{recommendSceneDetailPage.mScene.O00000o}));
                }
                if (jSONObject.has("scene_id")) {
                    String optString = jSONObject.optString("scene_id");
                    try {
                        RecommendSceneDetailPage.this.mScene.f529O000000o = Long.parseLong(optString);
                    } catch (Exception unused) {
                    }
                }
                fsm fsm = r0;
                if (fsm != null) {
                    fsm.onSuccess(jSONObject);
                }
            }

            public final void onFailure(fso fso) {
                fsm fsm = r0;
                if (fsm != null) {
                    fsm.onFailure(fso);
                }
            }
        });
    }

    static class O0000O0o implements O0000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        String f11281O000000o;
        String O00000Oo;
        boolean O00000o;
        String O00000o0;
        boolean O00000oO = false;
        long O00000oo;
        String O0000O0o;

        public final int p_() {
            return 0;
        }

        public O0000O0o(String str, long j, String str2, String str3, String str4, boolean z) {
            this.f11281O000000o = str2;
            this.O00000Oo = str3;
            this.O00000o0 = str4;
            this.O00000o = z;
            this.O00000oo = j;
            this.O0000O0o = str;
        }
    }

    static class O00000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f11279O000000o;

        public O00000o(View view) {
            super(view);
            this.f11279O000000o = (TextView) view.findViewById(R.id.group_title);
        }
    }

    public static class O00000o0 implements O0000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        String f11280O000000o;
        int O00000Oo;
        int O00000o = -1;
        int O00000o0;

        public final int p_() {
            return 1;
        }

        public O00000o0(String str, int i) {
            this.f11280O000000o = str;
            this.O00000Oo = i;
            this.O00000o0 = 1;
        }
    }

    class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f11278O000000o;
        private View O00000o;
        private View O00000o0;
        private SimpleDraweeView O00000oO;
        private TextView O00000oo;
        private CheckBox O0000O0o;

        public O00000Oo(View view) {
            super(view);
            this.O00000o0 = view.findViewById(R.id.view_background);
            this.O00000o = view.findViewById(R.id.bottom_padding);
            this.O00000oO = (SimpleDraweeView) view.findViewById(R.id.img_device);
            this.f11278O000000o = (TextView) view.findViewById(R.id.txt_device_name);
            this.O00000oo = (TextView) view.findViewById(R.id.txt_room_and_state);
            this.O0000O0o = (CheckBox) view.findViewById(R.id.ckb_edit_selected);
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(hqf hqf) {
            this.O0000O0o.setOnCheckedChangeListener(null);
            this.O0000O0o.setChecked(hqf.O00000oo);
            this.itemView.setOnClickListener(new View.OnClickListener(hqf) {
                /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$O00000Oo$cxxhD5igRyUQ7c8IUaRbdvRbQA */
                private final /* synthetic */ hqf f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    RecommendSceneDetailPage.O00000Oo.this.O000000o(this.f$1, view);
                }
            });
            this.O0000O0o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(hqf) {
                /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$O00000Oo$Tbiid97DZGofyf9nYjP5OgyFUu0 */
                private final /* synthetic */ hqf f$1;

                {
                    this.f$1 = r2;
                }

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    RecommendSceneDetailPage.O00000Oo.this.O000000o(this.f$1, compoundButton, z);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(hqf hqf, View view) {
            this.O0000O0o.setChecked(!hqf.O00000oo);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(hqf hqf, CompoundButton compoundButton, boolean z) {
            hqf.O00000oo = z;
            boolean isSettable = RecommendSceneDetailPage.this.isSettable();
            if (RecommendSceneDetailPage.this.visibleData.get(0) instanceof O0000O0o) {
                ((O0000O0o) RecommendSceneDetailPage.this.visibleData.get(0)).O00000oO = isSettable;
            }
            if (!isSettable) {
                gqg.O00000Oo((int) R.string.rec_scene_settable_false);
            }
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(hpw hpw, int i) {
            this.O00000o.setVisibility(8);
            boolean z = true;
            if (i == 3) {
                this.O00000o0.setBackgroundResource(R.drawable.bg_16_white_h100);
                this.O00000o.setVisibility(0);
            } else if (i == 1) {
                this.O00000o0.setBackgroundResource(R.drawable.bg_top_16_white_h90);
            } else if (i == 2) {
                this.O00000o0.setBackgroundResource(R.drawable.bg_bottom_16_white_h90);
                this.O00000o.setVisibility(0);
            } else {
                this.O00000o0.setBackgroundColor(RecommendSceneDetailPage.this.getResources().getColor(R.color.mj_color_foreground));
            }
            this.f11278O000000o.setAlpha(1.0f);
            this.O00000oo.setAlpha(1.0f);
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(hpw.O00000o())) {
                sb.append(hpw.O00000o());
            }
            if (!TextUtils.isEmpty(hpw.O0000OOo())) {
                if (sb.length() > 0) {
                    sb.append((CharSequence) O000000o());
                }
                sb.append(hpw.O0000OOo());
            } else if (RecommendSceneDetailPage.this.repeatDids.containsKey(hpw.O00000Oo()) && RecommendSceneDetailPage.this.repeatDids.get(hpw.O00000Oo()).intValue() > 0 && !TextUtils.isEmpty(hpw.O00000oO())) {
                if (sb.length() > 0) {
                    sb.append((CharSequence) O000000o());
                }
                sb.append(hpw.O00000oO());
            }
            this.f11278O000000o.setText(sb.toString());
            String str = null;
            if (hpw.O000000o() == null) {
                this.O00000oo.setText((int) R.string.scene_no_device);
                this.O00000oo.setTextColor(RecommendSceneDetailPage.this.getResources().getColor(R.color.mj_color_scene_offline));
                DeviceFactory.O00000Oo((String) null, this.O00000oO);
                this.f11278O000000o.setAlpha(0.5f);
                this.O00000oo.setAlpha(0.5f);
                PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(hpw.O00000o0());
                if (O00000oO2 == null || TextUtils.isEmpty(O00000oO2.O0000o0())) {
                    DeviceFactory.O00000Oo(hpw.O00000o0(), this.O00000oO);
                } else {
                    this.O00000oO.setImageURI(Uri.parse(O00000oO2.O0000o0()));
                }
            } else {
                DeviceFactory.O00000Oo(hpw.O00000o0(), this.O00000oO);
                Home O0000o0 = ggb.O00000Oo().O0000o0(hpw.O00000Oo());
                StringBuilder sb2 = new StringBuilder();
                if (!TextUtils.isEmpty(hpw.O00000oo()) && !TextUtils.equals(ggb.O00000Oo().O0000OOo(), hpw.O00000oo()) && (O0000o0 = ggb.O00000Oo().O00000o(hpw.O00000oo())) == null) {
                    O0000o0 = ggb.O00000Oo().O0000o0(hpw.O00000Oo());
                }
                if (!TextUtils.isEmpty(hpw.O0000O0o())) {
                    Room O00000o02 = ggb.O00000Oo().O00000o0(hpw.O0000O0o());
                    if (O00000o02 != null) {
                        str = O00000o02.getName();
                    }
                } else {
                    str = ggb.O00000Oo().O0000o0O(hpw.O00000Oo());
                }
                if (TextUtils.isEmpty(str)) {
                    str = RecommendSceneDetailPage.this.getString(R.string.room_default);
                }
                Home O00000o2 = ggb.O00000Oo().O00000o(RecommendSceneDetailPage.this.manager.O00000o0());
                if (O00000o2 == null || !O00000o2.equals(O0000o0)) {
                    z = false;
                }
                if (z) {
                    this.O00000oo.setTextColor(RecommendSceneDetailPage.this.getResources().getColor(R.color.mj_color_gray_lighter));
                    sb2.append(str);
                    if (!hpw.O000000o().isOnline) {
                        sb2.append((CharSequence) O000000o());
                        int length = sb2.length();
                        sb2.append(RecommendSceneDetailPage.this.getString(R.string.offline_device));
                        SpannableString spannableString = new SpannableString(sb2.toString());
                        spannableString.setSpan(new ForegroundColorSpan(RecommendSceneDetailPage.this.getResources().getColor(R.color.mj_color_scene_offline)), length, spannableString.length(), 17);
                        this.O00000oo.setText(spannableString);
                        this.f11278O000000o.setAlpha(0.5f);
                        this.O00000oo.setAlpha(0.5f);
                        return;
                    }
                    this.O00000oo.setText(sb2.toString());
                    return;
                }
                this.f11278O000000o.setAlpha(0.5f);
                this.O00000oo.setAlpha(0.5f);
                sb2.append(RecommendSceneDetailPage.this.getString(R.string.device_oter_home));
                this.O00000oo.setTextColor(RecommendSceneDetailPage.this.getResources().getColor(R.color.mj_color_scene_offline));
                this.O00000oo.setText(sb2.toString());
            }
        }

        private SpannableString O000000o() {
            SpannableString spannableString = new SpannableString(" | ");
            spannableString.setSpan(new AbsoluteSizeSpan(gpc.O000000o(10.0f)), 0, spannableString.length(), 17);
            spannableString.setSpan(new ForegroundColorSpan(RecommendSceneDetailPage.this.getResources().getColor(R.color.mj_color_scene_express_pressed)), 0, spannableString.length(), 17);
            return spannableString;
        }
    }

    public boolean isSettable() {
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i = 0; i < this.visibleData.size(); i++) {
            if (this.visibleData.get(i) instanceof hqf) {
                if (this.f11267O000000o && (this.visibleData.get(i) instanceof hqd) && ((hqd) this.visibleData.get(i)).O00000oo) {
                    z = true;
                }
                if (this.O00000Oo && (this.visibleData.get(i) instanceof hqe) && ((hqe) this.visibleData.get(i)).O00000oo) {
                    z2 = true;
                }
                if (this.O00000o0 && (this.visibleData.get(i) instanceof hqc) && ((hqc) this.visibleData.get(i)).O00000oo) {
                    z3 = true;
                }
            }
        }
        return (!this.f11267O000000o || z) && (!this.O00000Oo || z2) && (!this.O00000o0 || z3);
    }

    class O0000o00 extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public View f11285O000000o;
        public SwitchButton O00000Oo;
        private View O00000o;
        private CheckBox O00000oO;
        private TextView O00000oo;
        private TextView O0000O0o;

        public O0000o00(View view) {
            super(view);
            this.O00000o = view.findViewById(R.id.user_click_view);
            this.f11285O000000o = view.findViewById(R.id.common_use_view);
            this.O00000Oo = (SwitchButton) view.findViewById(R.id.ckb_set_common_use);
            this.O00000oO = (CheckBox) view.findViewById(R.id.ckb_edit_selected);
            this.O00000oo = (TextView) view.findViewById(R.id.txt_title);
            this.O0000O0o = (TextView) view.findViewById(R.id.common_use_title);
        }

        public final void O000000o(final hqi hqi, int i) {
            this.O00000Oo.setOnCheckedChangeListener(null);
            this.O00000oO.setOnCheckedChangeListener(null);
            if (i == 0 || i == 2) {
                ViewGroup.LayoutParams layoutParams = this.O00000o.getLayoutParams();
                this.O00000o.setBackgroundResource(R.drawable.bg_bottom_16_white_h90);
                layoutParams.height = gpc.O000000o(70.0f);
                this.O00000o.setLayoutParams(layoutParams);
            }
            this.O00000Oo.setChecked(hqi.f522O000000o);
            this.O00000oO.setChecked(hqi.O00000oo);
            boolean z = (RecommendSceneDetailPage.this.visibleData.get(0) instanceof O0000O0o) && !((O0000O0o) RecommendSceneDetailPage.this.visibleData.get(0)).O00000o;
            if (z) {
                hqi.f522O000000o = false;
                this.O00000Oo.setChecked(false);
                this.O00000Oo.setEnabled(false);
                this.f11285O000000o.setEnabled(false);
                this.O0000O0o.setAlpha(0.3f);
                this.O00000Oo.setAlpha(0.3f);
            } else {
                this.O00000Oo.setEnabled(true);
                this.f11285O000000o.setEnabled(true);
                this.O0000O0o.setAlpha(1.0f);
                this.O00000Oo.setAlpha(1.0f);
            }
            this.O00000o.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$O0000o00$LMGuSSDoINZXcPZCrT1BWDu3QEU */

                public final void onClick(View view) {
                    RecommendSceneDetailPage.O0000o00.this.O000000o(view);
                }
            });
            this.f11285O000000o.setOnClickListener(new View.OnClickListener(z) {
                /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$O0000o00$whMt6OJgoHgSUm3GV1AUOwcS4s */
                private final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    RecommendSceneDetailPage.O0000o00.this.O000000o(this.f$1, view);
                }
            });
            this.O00000oO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.O0000o00.AnonymousClass1 */

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    hqi hqi = hqi;
                    hqi.O00000oo = z;
                    if (z) {
                        O0000o00.this.O00000Oo.setChecked(hqi.f522O000000o);
                        O0000o00.this.f11285O000000o.setVisibility(0);
                    } else {
                        hqi.f522O000000o = false;
                        O0000o00.this.f11285O000000o.setVisibility(8);
                    }
                    boolean isSettable = RecommendSceneDetailPage.this.isSettable();
                    if (!isSettable) {
                        gqg.O00000Oo((int) R.string.rec_scene_settable_false);
                    }
                    if (RecommendSceneDetailPage.this.visibleData.get(0) instanceof O0000O0o) {
                        ((O0000O0o) RecommendSceneDetailPage.this.visibleData.get(0)).O00000oO = isSettable;
                    }
                }
            });
            this.O00000Oo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$O0000o00$fViws5D7oRpUfpNwrUqSODi5WE */

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    hqi.this.f522O000000o = z;
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(View view) {
            this.O00000oO.performClick();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(boolean z, View view) {
            boolean z2;
            SwitchButton switchButton;
            if (z) {
                switchButton = this.O00000Oo;
            } else {
                switchButton = this.O00000Oo;
                if (!switchButton.isChecked()) {
                    z2 = true;
                    switchButton.setChecked(z2);
                }
            }
            z2 = false;
            switchButton.setChecked(z2);
        }
    }

    class O0000Oo0 extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        SimpleDraweeView f11284O000000o;
        TextView O00000Oo;
        TextView O00000o0;
        private View O00000oO;
        private View O00000oo;
        private CheckBox O0000O0o;

        public O0000Oo0(View view) {
            super(view);
            this.O00000oO = view.findViewById(R.id.view_background);
            this.f11284O000000o = (SimpleDraweeView) view.findViewById(R.id.img_icon);
            this.O00000oo = view.findViewById(R.id.bottom_padding);
            this.O00000Oo = (TextView) view.findViewById(R.id.txt_title);
            this.O00000o0 = (TextView) view.findViewById(R.id.txt_sub_title);
            this.O0000O0o = (CheckBox) view.findViewById(R.id.ckb_edit_selected);
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(hqf hqf, int i, int i2) {
            this.O0000O0o.setOnCheckedChangeListener(null);
            this.O00000oo.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.O00000oO.getLayoutParams();
            if (i2 == 3) {
                this.O00000oO.setBackgroundResource(R.drawable.bg_16_white_h100);
                layoutParams.height = gpc.O000000o(80.0f);
                this.O00000oo.setVisibility(0);
            } else if (i2 == 1) {
                this.O00000oO.setBackgroundResource(R.drawable.bg_top_16_white_h90);
                layoutParams.height = gpc.O000000o(70.0f);
            } else if (i2 == 2) {
                this.O00000oO.setBackgroundResource(R.drawable.bg_bottom_16_white_h90);
                layoutParams.height = gpc.O000000o(70.0f);
                this.O00000oo.setVisibility(0);
            } else {
                layoutParams.height = gpc.O000000o(60.0f);
                this.O00000oO.setBackgroundColor(RecommendSceneDetailPage.this.getResources().getColor(R.color.mj_color_white));
            }
            this.O00000oO.setLayoutParams(layoutParams);
            this.O0000O0o.setButtonDrawable((int) R.drawable.checkbox_layout);
            this.O0000O0o.setChecked(hqf.O00000oo);
            if (hqf.O0000O0o >= 0 && hqf.O0000O0o < RecommendSceneDetailPage.this.visibleData.size() && (RecommendSceneDetailPage.this.visibleData.get(hqf.O0000O0o) instanceof O00000o0) && ((O00000o0) RecommendSceneDetailPage.this.visibleData.get(hqf.O0000O0o)).O00000o0 == 1) {
                this.O0000O0o.setButtonDrawable((int) R.drawable.single_checkbox_layout);
                if (i == ((O00000o0) RecommendSceneDetailPage.this.visibleData.get(hqf.O0000O0o)).O00000o) {
                    this.O0000O0o.setChecked(true);
                    hqf.O00000oo = true;
                } else {
                    this.O0000O0o.setChecked(false);
                    hqf.O00000oo = false;
                }
            }
            this.itemView.setOnClickListener(new View.OnClickListener(hqf, i) {
                /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$O0000Oo0$n3XSp3wvOGkJDe2KMvKaqJ8ntBU */
                private final /* synthetic */ hqf f$1;
                private final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    RecommendSceneDetailPage.O0000Oo0.this.O000000o(this.f$1, this.f$2, view);
                }
            });
            this.O0000O0o.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$O0000Oo0$lju145vR6IdPgsqhAgp8xF7joHQ */

                public final void onClick(View view) {
                    RecommendSceneDetailPage.O0000Oo0.this.O000000o(view);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(hqf hqf, int i, View view) {
            if (hqf.O0000O0o < 0 || hqf.O0000O0o >= RecommendSceneDetailPage.this.visibleData.size() || !(RecommendSceneDetailPage.this.visibleData.get(hqf.O0000O0o) instanceof O00000o0) || ((O00000o0) RecommendSceneDetailPage.this.visibleData.get(hqf.O0000O0o)).O00000o0 != 1) {
                this.O0000O0o.setChecked(!hqf.O00000oo);
                hqf.O00000oo = !hqf.O00000oo;
                boolean isSettable = RecommendSceneDetailPage.this.isSettable();
                if (!hqf.O00000oo && !isSettable) {
                    gqg.O00000Oo((int) R.string.rec_scene_settable_false);
                }
                if (RecommendSceneDetailPage.this.visibleData.get(0) instanceof O0000O0o) {
                    ((O0000O0o) RecommendSceneDetailPage.this.visibleData.get(0)).O00000oO = isSettable;
                    RecommendSceneDetailPage.this.mAdapter.notifyItemChanged(0);
                    return;
                }
                return;
            }
            int i2 = ((O00000o0) RecommendSceneDetailPage.this.visibleData.get(hqf.O0000O0o)).O00000o;
            if (i2 < 0 || i2 == i || i2 >= RecommendSceneDetailPage.this.visibleData.size()) {
                this.O0000O0o.setChecked(true);
                return;
            }
            this.O0000O0o.setChecked(true);
            if (RecommendSceneDetailPage.this.visibleData.get(i2) instanceof hqf) {
                ((hqf) RecommendSceneDetailPage.this.visibleData.get(i2)).O00000oo = false;
            }
            hqf.O00000oo = true;
            ((hqf) RecommendSceneDetailPage.this.visibleData.get(((O00000o0) RecommendSceneDetailPage.this.visibleData.get(hqf.O0000O0o)).O00000o)).O00000oo = false;
            ((O00000o0) RecommendSceneDetailPage.this.visibleData.get(hqf.O0000O0o)).O00000o = i;
            RecommendSceneDetailPage.this.mAdapter.notifyDataSetChanged();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(View view) {
            this.itemView.performClick();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.O0000Oo0.O000000o(_m_j.hqf, int, int):void
         arg types: [_m_j.hqj, int, int]
         candidates:
          com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.O0000Oo0.O000000o(_m_j.hqf, int, android.view.View):void
          com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.O0000Oo0.O000000o(_m_j.hqj, int, android.view.View):void
          com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.O0000Oo0.O000000o(_m_j.hqp, int, android.view.View):void
          com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.O0000Oo0.O000000o(_m_j.hqj, int, int):void
          com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.O0000Oo0.O000000o(_m_j.hqp, int, int):void
          com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.O0000Oo0.O000000o(_m_j.hqf, int, int):void */
        public final void O000000o(hqj hqj, int i, int i2) {
            O000000o((hqf) hqj, i, i2);
            int cloudTitleByKey = RecommendSceneDetailPage.this.getCloudTitleByKey(hqj.O0000OOo.O000000o());
            if (cloudTitleByKey == 0) {
                this.O00000Oo.setText("");
            } else {
                this.O00000Oo.setText(cloudTitleByKey);
            }
            int cloudSubTitleByKey = RecommendSceneDetailPage.this.getCloudSubTitleByKey(hqj.O0000OOo.O000000o());
            if (cloudSubTitleByKey == 0) {
                this.O00000o0.setText("");
            } else {
                this.O00000o0.setText(cloudSubTitleByKey);
            }
            int cloudIconByKey = RecommendSceneDetailPage.this.getCloudIconByKey(hqj.O0000OOo.O000000o());
            if (cloudIconByKey == 0) {
                this.f11284O000000o.setActualImageResource(0);
            } else {
                this.f11284O000000o.setActualImageResource(cloudIconByKey);
            }
            if (!this.O0000O0o.isChecked() && !RecommendSceneDetailPage.this.isHomeUpdated && !hqj.O0000Oo0()) {
                this.itemView.setOnClickListener(new View.OnClickListener(hqj, i) {
                    /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$O0000Oo0$COq1hyEpInMpNFTzHVzijHr8 */
                    private final /* synthetic */ hqj f$1;
                    private final /* synthetic */ int f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        RecommendSceneDetailPage.O0000Oo0.this.O000000o(this.f$1, this.f$2, view);
                    }
                });
                this.O0000O0o.setOnCheckedChangeListener(null);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(hqj hqj, int i, View view) {
            this.O0000O0o.setChecked(false);
            RecommendSceneDetailPage recommendSceneDetailPage = RecommendSceneDetailPage.this;
            recommendSceneDetailPage.mCurrentRequestId = hqj.O000000o(recommendSceneDetailPage);
            RecommendSceneDetailPage recommendSceneDetailPage2 = RecommendSceneDetailPage.this;
            recommendSceneDetailPage2.mCurrentRequestUI = hqj;
            recommendSceneDetailPage2.mCurrentRequestPos = i;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.O0000Oo0.O000000o(_m_j.hqf, int, int):void
         arg types: [_m_j.hqp, int, int]
         candidates:
          com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.O0000Oo0.O000000o(_m_j.hqf, int, android.view.View):void
          com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.O0000Oo0.O000000o(_m_j.hqj, int, android.view.View):void
          com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.O0000Oo0.O000000o(_m_j.hqp, int, android.view.View):void
          com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.O0000Oo0.O000000o(_m_j.hqj, int, int):void
          com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.O0000Oo0.O000000o(_m_j.hqp, int, int):void
          com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage.O0000Oo0.O000000o(_m_j.hqf, int, int):void */
        public final void O000000o(hqp hqp, int i, int i2) {
            O000000o((hqf) hqp, i, i2);
            this.O00000Oo.setText((int) R.string.rec_geo_trigger_no_address);
            Home O0000Oo0 = ggb.O00000Oo().O0000Oo0();
            int i3 = TextUtils.equals(hqp.f527O000000o, ConstantType.TriggerConditionType.LOCATION_LEAVE.key) ? R.string.scene_exit_fence_formatter : R.string.scene_enter_fence_formatter;
            if (O0000Oo0 != null) {
                if (hqp.O0000OoO) {
                    this.O00000Oo.setText(RecommendSceneDetailPage.this.getString(i3, new Object[]{hqp.O0000Ooo}));
                } else if (!TextUtils.isEmpty(O0000Oo0.getAddr())) {
                    this.O00000Oo.setText(RecommendSceneDetailPage.this.getString(i3, new Object[]{O0000Oo0.getAddr()}));
                } else {
                    this.O00000Oo.setText((int) R.string.trigger_geo_title_hint);
                }
            }
            this.O00000o0.setText((int) R.string.geo_trigger_name);
            this.f11284O000000o.setActualImageResource(R.drawable.rec_scene_fence);
            this.O00000Oo.setAlpha(0.3f);
            this.O00000o0.setAlpha(0.3f);
            this.itemView.setOnClickListener(new View.OnClickListener(hqp, i) {
                /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$O0000Oo0$K4VUNknjm5fsW4YzvFP7y9FAthM */
                private final /* synthetic */ hqp f$1;
                private final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    RecommendSceneDetailPage.O0000Oo0.this.O000000o(this.f$1, this.f$2, view);
                }
            });
            this.O0000O0o.setOnCheckedChangeListener(null);
            this.O0000O0o.setOnClickListener(new View.OnClickListener(hqp) {
                /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneDetailPage$O0000Oo0$5tEwoT2oUAxe2nbU61iM8mrLeRM */
                private final /* synthetic */ hqp f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    RecommendSceneDetailPage.O0000Oo0.this.O000000o(this.f$1, view);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(hqp hqp, int i, View view) {
            hqp.O00000oo = !hqp.O00000oo;
            this.O0000O0o.setChecked(hqp.O00000oo);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(hqp hqp, View view) {
            if (!hqp.O00000oo && !RecommendSceneDetailPage.this.isHomeUpdated) {
                Home O00000o2 = ggb.O00000Oo().O00000o(hqp.O0000Oo0);
                if (!((O00000o2 != null && !TextUtils.isEmpty(O00000o2.getAddr())) || hqp.O0000OoO)) {
                    this.itemView.performClick();
                    this.O0000O0o.setChecked(false);
                    return;
                }
            }
            hqp.O00000oo = !hqp.O00000oo;
            this.O0000O0o.setChecked(hqp.O00000oo);
            boolean isSettable = RecommendSceneDetailPage.this.isSettable();
            if (!hqp.O00000oo && !isSettable) {
                gqg.O00000Oo((int) R.string.rec_scene_settable_false);
            }
            if (RecommendSceneDetailPage.this.visibleData.get(0) instanceof O0000O0o) {
                ((O0000O0o) RecommendSceneDetailPage.this.visibleData.get(0)).O00000oO = isSettable;
                RecommendSceneDetailPage.this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    public int getCloudIconByKey(String str) {
        if (TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_AQI.key, str) || TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_HUMIDITY.key, str) || TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_TEMPERATURE.key, str) || TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_SUNRISE.key, str) || !TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_SUNSET.key, str)) {
            return 0;
        }
        return R.drawable.icon_condition_sunset;
    }

    public int getCloudSubTitleByKey(String str) {
        if (TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_AQI.key, str) || TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_HUMIDITY.key, str) || TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_TEMPERATURE.key, str) || TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_SUNRISE.key, str) || !TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_SUNSET.key, str)) {
            return 0;
        }
        return R.string.condition_sun_set_desc;
    }

    public int getCloudTitleByKey(String str) {
        if (TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_AQI.key, str) || TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_HUMIDITY.key, str) || TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_TEMPERATURE.key, str) || TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_SUNRISE.key, str) || !TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_SUNSET.key, str)) {
            return 0;
        }
        return R.string.condition_sun_set;
    }

    public void refreshRecSceneList() {
        this.manager.O000000o(this.mScene);
        Intent intent = new Intent();
        intent.putExtra("tpl_id", this.manager.O00000Oo().O00000Oo);
        hqs hqs = this.mScene;
        intent.putExtra("scene_id", hqs == null ? 0 : hqs.f529O000000o);
        setResult(-1, intent);
    }
}

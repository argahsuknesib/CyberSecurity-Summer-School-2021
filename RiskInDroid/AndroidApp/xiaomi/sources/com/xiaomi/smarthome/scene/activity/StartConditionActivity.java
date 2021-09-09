package com.xiaomi.smarthome.scene.activity;

import _m_j.fno;
import _m_j.hjp;
import _m_j.hod;
import _m_j.hos;
import _m_j.hox;
import _m_j.hoz;
import _m_j.hpb;
import _m_j.hpq;
import _m_j.hrl;
import _m_j.izb;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.ExpandableItemIndicator;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.DefaultSceneItemSet;
import com.xiaomi.smarthome.scene.view.SceneFilterView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StartConditionActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f11088O000000o;
    String O00000Oo;
    O000000o O00000o;
    SceneApi.O000OOOo O00000o0;
    List<hos> O00000oO = new ArrayList();
    List<hos> O00000oo = new ArrayList();
    HashMap<hos, Boolean> O0000O0o = new HashMap<>();
    boolean O0000OOo = false;
    int O0000Oo = -1;
    int O0000Oo0 = -1;
    SceneApi.O000000o O0000OoO = null;
    private List<DefaultSceneItemSet> O0000Ooo;
    private int O0000o0 = 0;
    private List<DefaultSceneItemSet> O0000o00;
    @BindView(5171)
    Button mBuyButton;
    @BindView(5186)
    View mBuyView;
    @BindView(5291)
    ListView mContentListView;
    public hos mCurrentCondition;
    @BindView(5538)
    View mGrayView;
    @BindView(5164)
    ExpandableItemIndicator mItemIndicator;
    @BindView(5822)
    ImageView mModuleA3ReturnTransparentBtn;
    @BindView(5826)
    TextView mModuleA3ReturnTransparentTitle;
    public SceneFilterView mPopView;
    public int mRequestId = 0;
    @BindView(6370)
    RelativeLayout mTitleBarFL;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.ListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void onCreate(Bundle bundle) {
        List<DefaultSceneItemSet> list;
        boolean z;
        Device O000000o2;
        boolean z2;
        boolean z3;
        super.onCreate(bundle);
        setContentView((int) R.layout.smarthome_start_condition);
        ButterKnife.bind(this);
        this.f11088O000000o = this;
        Intent intent = getIntent();
        if (intent != null) {
            this.O0000Ooo = intent.getParcelableArrayListExtra("extra_default_conditions");
            this.O0000o00 = intent.getParcelableArrayListExtra("extra_exclude_conditions");
        }
        this.O00000o0 = hpq.O000000o().O00000Oo;
        SceneApi.O000OOOo o000OOOo = this.O00000o0;
        if (o000OOOo == null) {
            finish();
            return;
        }
        this.O00000Oo = o000OOOo.f11131O000000o;
        this.O0000OOo = SmartHomeSceneCreateEditActivity.isNewScene;
        Iterator<Map.Entry<String, Device>> it = fno.O000000o().O0000O0o().entrySet().iterator();
        while (true) {
            boolean z4 = false;
            if (!it.hasNext()) {
                break;
            }
            Device device = (Device) it.next().getValue();
            if (device.isOwner() && !device.isSubDevice()) {
                List<DefaultSceneItemSet> list2 = this.O0000o00;
                if (list2 != null && list2.size() > 0) {
                    Iterator<DefaultSceneItemSet> it2 = this.O0000o00.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        DefaultSceneItemSet next = it2.next();
                        if (DeviceFactory.O000000o(device.model, next.O00000Oo) || (next.O00000oO != null && next.O00000oO.equalsIgnoreCase(device.did))) {
                            z4 = true;
                        }
                    }
                    z4 = true;
                    if (z4) {
                    }
                }
                hos O000000o3 = hos.O000000o(device);
                if (O000000o3 != null) {
                    this.O00000oO.add(O000000o3);
                }
            }
        }
        for (Map.Entry<String, Device> value : fno.O000000o().O00000Oo().entrySet()) {
            Device device2 = (Device) value.getValue();
            if (device2.isOwner() && (O000000o2 = fno.O000000o().O000000o(device2.parentId)) != null && O000000o2.isOwner()) {
                List<DefaultSceneItemSet> list3 = this.O0000o00;
                if (list3 != null) {
                    Iterator<DefaultSceneItemSet> it3 = list3.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (DeviceFactory.O000000o(device2.model, it3.next().O00000Oo)) {
                                z3 = true;
                                break;
                            }
                        } else {
                            z3 = false;
                            break;
                        }
                    }
                    if (z3) {
                    }
                }
                hos O000000o4 = hos.O000000o(device2);
                if (O000000o4 != null) {
                    int i = 0;
                    while (true) {
                        if (i >= this.O00000oO.size()) {
                            z2 = false;
                            break;
                        }
                        Device O00000o02 = this.O00000oO.get(i).O00000o0();
                        if (O00000o02 != null && !O00000o02.isSubDevice() && device2.parentId.equalsIgnoreCase(O00000o02.did)) {
                            this.O00000oO.add(i + 1, O000000o4);
                            z2 = true;
                            break;
                        }
                        i++;
                    }
                    if (!z2) {
                        this.O00000oO.add(O000000o4);
                    }
                }
            }
        }
        this.O00000oO.add(0, new hpb());
        this.O0000OoO = hpq.O000000o().O00000oO;
        hos hos = null;
        for (int i2 = 0; i2 < this.O00000o0.O0000O0o.size(); i2++) {
            int size = this.O00000oO.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                int O000000o5 = this.O00000oO.get(size).O000000o(this.O00000o0.O0000O0o.get(i2));
                if (O000000o5 != -1) {
                    SceneApi.O000000o o000000o = this.O0000OoO;
                    if (o000000o != null && o000000o.equals(this.O00000o0.O0000O0o.get(i2))) {
                        hos = this.O00000oO.get(size);
                        this.O0000Oo0 = O000000o5;
                    } else if (!this.O00000oO.get(size).O00000oo()) {
                        this.O0000O0o.put(this.O00000oO.get(size), Boolean.FALSE);
                    } else {
                        this.O00000oO.get(size).O000000o(O000000o5);
                        if (this.O00000oO.get(size).O00000Oo()) {
                            this.O0000O0o.put(this.O00000oO.get(size), Boolean.FALSE);
                        }
                    }
                } else {
                    size--;
                }
            }
        }
        if (this.O0000Oo0 != -1) {
            this.O0000Oo = this.O00000o0.O0000O0o.indexOf(this.O0000OoO);
            this.O00000o0.O0000O0o.remove(this.O0000OoO);
            hpq.O000000o().O00000o(this.O00000o0);
        }
        ArrayList arrayList = new ArrayList();
        for (int size2 = this.O00000oO.size() - 1; size2 >= 0; size2--) {
            if (this.O00000oO.get(size2).O00000oo()) {
                int[] O00000oO2 = this.O00000oO.get(size2).O00000oO();
                int length = O00000oO2.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z = true;
                        break;
                    }
                    Integer valueOf = Integer.valueOf(O00000oO2[i3]);
                    if (hpq.O000000o().O00000Oo.O0000Ooo == 1 || hpq.O000000o().O000000o(Integer.valueOf(this.O00000oO.get(size2).O00000o0(valueOf.intValue())))) {
                        z = false;
                    } else {
                        i3++;
                    }
                }
                z = false;
                if (!z && this.O00000oO.get(size2).O00000Oo()) {
                    z = true;
                }
                if (z) {
                    this.O0000O0o.put(this.O00000oO.get(size2), Boolean.FALSE);
                    arrayList.add(this.O00000oO.remove(size2));
                }
            } else if (hpq.O000000o().O00000Oo.O0000Ooo == 1 || hpq.O000000o().O000000o(Integer.valueOf(this.O00000oO.get(size2).O00000o0(0)))) {
                this.O0000O0o.put(this.O00000oO.get(size2), Boolean.TRUE);
            } else {
                this.O0000O0o.put(this.O00000oO.get(size2), Boolean.FALSE);
                arrayList.add(this.O00000oO.remove(size2));
            }
        }
        this.O00000oO.addAll(arrayList);
        if (this.O0000Oo0 != -1) {
            gotoDetailPage(hos);
        }
        hrl.O000000o().O00000oO = this.O00000oO;
        hrl.O000000o().O000000o(this.mModuleA3ReturnTransparentTitle);
        this.mPopView = (SceneFilterView) LayoutInflater.from(this.f11088O000000o).inflate((int) R.layout.scene_filter_view, (ViewGroup) null);
        this.mPopView.setmDismissListener(new SceneFilterView.O00000o0() {
            /* class com.xiaomi.smarthome.scene.activity.StartConditionActivity.AnonymousClass1 */

            public final void O000000o() {
                StartConditionActivity.this.mItemIndicator.setExpandedState$25decb5(false);
            }
        });
        AnonymousClass2 r13 = new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.StartConditionActivity.AnonymousClass2 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{android.widget.PopupWindow.<init>(android.view.View, int, int, boolean):void}
             arg types: [com.xiaomi.smarthome.scene.view.SceneFilterView, int, int, int]
             candidates:
              ClspMth{android.widget.PopupWindow.<init>(android.content.Context, android.util.AttributeSet, int, int):void}
              ClspMth{android.widget.PopupWindow.<init>(android.view.View, int, int, boolean):void} */
            public final void onClick(View view) {
                StartConditionActivity.this.mItemIndicator.setExpandedState$25decb5(true);
                SceneFilterView sceneFilterView = StartConditionActivity.this.mPopView;
                RelativeLayout relativeLayout = StartConditionActivity.this.mTitleBarFL;
                View view2 = StartConditionActivity.this.mGrayView;
                int i = hrl.O000000o().f564O000000o.f565O000000o;
                int i2 = hrl.O000000o().f564O000000o.O00000Oo;
                String str = hrl.O000000o().f564O000000o.O00000o0;
                if (relativeLayout != null) {
                    sceneFilterView.f11315O000000o = 1;
                    sceneFilterView.O0000O0o = new PopupWindow((View) sceneFilterView, -1, -2, true);
                    if (Build.VERSION.SDK_INT >= 23) {
                        sceneFilterView.O0000O0o.setBackgroundDrawable(new ColorDrawable(sceneFilterView.getResources().getColor(R.color.transparent, null)));
                    } else {
                        sceneFilterView.O0000O0o.setBackgroundDrawable(new ColorDrawable(sceneFilterView.getResources().getColor(R.color.transparent)));
                    }
                    sceneFilterView.O000000o(i, i2, str);
                    sceneFilterView.O0000O0o.getContentView().startAnimation(SceneFilterView.O000000o(sceneFilterView.O00000Oo));
                    if (sceneFilterView.O0000O0o != null && !sceneFilterView.O0000O0o.isShowing()) {
                        sceneFilterView.O0000O0o.showAsDropDown(relativeLayout);
                    }
                    if (view2 != null) {
                        view2.setVisibility(0);
                    }
                    sceneFilterView.O0000O0o.setOnDismissListener(new PopupWindow.OnDismissListener(view2) {
                        /* class com.xiaomi.smarthome.scene.view.SceneFilterView.AnonymousClass1 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ View f11316O000000o;

                        {
                            this.f11316O000000o = r2;
                        }

                        public final void onDismiss() {
                            SceneFilterView.this.O0000O0o.getContentView().startAnimation(SceneFilterView.O00000Oo(SceneFilterView.this.O00000Oo));
                            this.f11316O000000o.setVisibility(8);
                            if (SceneFilterView.this.O0000Oo0 != null) {
                                SceneFilterView.this.O0000Oo0.O000000o();
                            }
                        }
                    });
                }
                StartConditionActivity.this.mPopView.setOnItemSelectListener(new SceneFilterView.O00000Oo() {
                    /* class com.xiaomi.smarthome.scene.activity.StartConditionActivity.AnonymousClass2.AnonymousClass1 */

                    public final void O000000o() {
                        StartConditionActivity.this.mPopView.O0000O0o.dismiss();
                        hrl.O000000o().O000000o(StartConditionActivity.this.mModuleA3ReturnTransparentTitle);
                        StartConditionActivity.this.O00000o.O000000o(StartConditionActivity.this.getFilterConditions(false));
                    }
                });
            }
        };
        this.mModuleA3ReturnTransparentTitle.setOnClickListener(r13);
        this.mItemIndicator.setOnClickListener(r13);
        if (this.O00000oO.size() != 0 || (list = this.O0000Ooo) == null || list.size() <= 0) {
            this.mBuyView.setVisibility(8);
        } else {
            this.mBuyView.setVisibility(0);
            this.mContentListView.setVisibility(8);
            this.mBuyButton.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.StartConditionActivity.AnonymousClass3 */

                public final void onClick(View view) {
                    hjp.O000000o("https://home.mi.com/shop/main");
                }
            });
        }
        this.O00000o = new O000000o(this, (byte) 0);
        this.O00000o.O000000o(getFilterConditions(true));
        this.mContentListView.addHeaderView(LayoutInflater.from(this).inflate((int) R.layout.common_list_space_empty, (ViewGroup) this.mContentListView, false));
        this.mContentListView.setAdapter((ListAdapter) this.O00000o);
    }

    public List<hos> getFilterConditions(boolean z) {
        Set<String> set = hrl.O000000o().O00000o0;
        String str = hrl.O000000o().f564O000000o.O00000o0;
        if (hrl.O000000o().f564O000000o.O00000Oo == 0) {
            this.O00000oo.clear();
            this.O00000oo.addAll(this.O00000oO);
            return this.O00000oo;
        } else if (!z || hrl.O000000o().O000000o(hrl.O000000o().f564O000000o.f565O000000o, 1, str)) {
            this.O00000oo.clear();
            for (int i = 0; i < this.O00000oO.size(); i++) {
                hos hos = this.O00000oO.get(i);
                if (!(hos instanceof hox)) {
                    this.O00000oo.add(hos);
                } else {
                    CommonSceneOnline commonSceneOnline = ((hox) hos).O00000o;
                    if (commonSceneOnline != null) {
                        Iterator<String> it = set.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (commonSceneOnline.O00000Oo.equalsIgnoreCase(it.next())) {
                                this.O00000oo.add(hos);
                                break;
                            }
                        }
                    }
                }
            }
            Collections.reverse(this.O00000oo);
            return this.O00000oo;
        } else {
            this.O00000oo.clear();
            this.O00000oo.addAll(this.O00000oO);
            hrl O000000o2 = hrl.O000000o();
            O000000o2.f564O000000o = new hrl.O000000o();
            O000000o2.O0000OOo = new hrl.O00000o0();
            return this.O00000oo;
        }
    }

    public void gotoDetailPage(hos hos) {
        Intent intent = new Intent();
        intent.setClass(this, SmartHomeSceneDetailActivity.class);
        int i = this.O0000Oo0;
        if (i != -1) {
            intent.putExtra("extra_selected_title", i);
        }
        if (hos instanceof hoz) {
            try {
                intent.putExtra("extra_title", getString(((hoz) hos).O000000o()));
            } catch (Exception unused) {
                intent.putExtra("extra_title", hos.O00000o());
            }
        } else {
            intent.putExtra("extra_title", hos.O00000o());
        }
        startActivityForResult(intent, 100);
        hpq.O000000o().O000000o(hos);
        this.mCurrentCondition = hos;
    }

    public void onActivityResult(final int i, final Intent intent) {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.scene.activity.StartConditionActivity.AnonymousClass4 */

            public final void run() {
                if (i == -1) {
                    if (StartConditionActivity.this.O0000Oo0 != -1) {
                        StartConditionActivity.this.O00000o0.O0000O0o.remove(StartConditionActivity.this.O0000OoO);
                    }
                    StartConditionActivity.this.O00000o0.O0000O0o.add(StartConditionActivity.this.mCurrentCondition.O000000o(StartConditionActivity.this.mCurrentCondition.O00000oO()[StartConditionActivity.this.mRequestId], intent));
                    StartConditionActivity startConditionActivity = StartConditionActivity.this;
                    startConditionActivity.addCompatibleId(startConditionActivity.mCurrentCondition.O00000o0(StartConditionActivity.this.mCurrentCondition.O00000oO()[StartConditionActivity.this.mRequestId]));
                    StartConditionActivity.this.finish();
                } else if (StartConditionActivity.this.O0000Oo0 != -1) {
                    StartConditionActivity.this.O00000o0.O0000O0o.add(StartConditionActivity.this.O0000Oo, StartConditionActivity.this.O0000OoO);
                    if (StartConditionActivity.this.O0000OoO.O0000Ooo != 0) {
                        StartConditionActivity startConditionActivity2 = StartConditionActivity.this;
                        startConditionActivity2.addCompatibleId(startConditionActivity2.O0000OoO.O0000Ooo);
                    }
                    StartConditionActivity.this.finish();
                } else {
                    StartConditionActivity startConditionActivity3 = StartConditionActivity.this;
                    startConditionActivity3.mRequestId = 0;
                    startConditionActivity3.mCurrentCondition = null;
                    startConditionActivity3.O00000o.notifyDataSetChanged();
                }
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                int intExtra = intent.getIntExtra("extra_index", -1);
                if (intExtra != -1) {
                    getConditionItem(intExtra);
                } else {
                    finish();
                }
            } else if (this.O0000Oo0 != -1) {
                if (this.O0000OoO != null) {
                    if (this.O0000Oo == -1) {
                        this.O00000o0.O0000O0o.add(0, this.O0000OoO);
                    } else {
                        this.O00000o0.O0000O0o.add(this.O0000Oo, this.O0000OoO);
                    }
                    addCompatibleId(this.O0000OoO.O0000Ooo);
                }
                finish();
            } else {
                this.O00000o.notifyDataSetChanged();
            }
        } else if (i == 102 && i2 == -1) {
            SceneApi.O000000o o000000o = hpq.O000000o().O00000oO;
            this.O00000o0.O0000O0o.add(o000000o);
            addCompatibleId(o000000o.O0000Ooo);
            finish();
        } else if (i == this.O0000o0) {
            onActivityResult(i2, intent);
        }
    }

    @OnClick({5822})
    public void close() {
        finish();
    }

    class O000000o extends BaseAdapter {
        private List<hos> O00000Oo;

        public final long getItemId(int i) {
            return (long) i;
        }

        private O000000o() {
            this.O00000Oo = new ArrayList();
        }

        /* synthetic */ O000000o(StartConditionActivity startConditionActivity, byte b) {
            this();
        }

        public final void O000000o(List<hos> list) {
            this.O00000Oo.clear();
            this.O00000Oo.addAll(list);
            notifyDataSetChanged();
        }

        public final int getCount() {
            return this.O00000Oo.size();
        }

        public final Object getItem(int i) {
            return this.O00000Oo.get(i);
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = StartConditionActivity.this.getLayoutInflater().inflate((int) R.layout.smarthome_action_group_layout, (ViewGroup) null);
            }
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.content_icon);
            TextView textView = (TextView) view.findViewById(R.id.content);
            ImageView imageView = (ImageView) view.findViewById(R.id.expand_hint);
            ((TextView) view.findViewById(R.id.content_description)).setVisibility(8);
            final hos hos = this.O00000Oo.get(i);
            if (hos instanceof hoz) {
                try {
                    textView.setText(((hoz) hos).O000000o());
                } catch (Exception unused) {
                }
                imageView.setVisibility(0);
                simpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(simpleDraweeView.getResources()).setFadeDuration(200).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build());
                hos.O000000o(simpleDraweeView);
                if (StartConditionActivity.this.O0000O0o.containsKey(hos) || StartConditionActivity.this.O0000O0o.get(hos).booleanValue()) {
                    imageView.setImageResource(R.drawable.std_list_main_next);
                    view.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.StartConditionActivity.O000000o.AnonymousClass2 */

                        public final void onClick(View view) {
                            if (hos.O00000oo()) {
                                hpq.O000000o().O00000o0();
                                StartConditionActivity.this.gotoDetailPage(hos);
                                return;
                            }
                            StartConditionActivity.this.mRequestId = hos.O000000o(-1, StartConditionActivity.this, StartConditionActivity.this.O0000OoO);
                            if (StartConditionActivity.this.mRequestId != -1) {
                                StartConditionActivity.this.mCurrentCondition = hos;
                                hpq.O000000o().O00000Oo(StartConditionActivity.this.mCurrentCondition.O000000o(i, null));
                                return;
                            }
                            StartConditionActivity.this.O00000o0.O0000O0o.add(hos.O000000o(-1, null));
                            StartConditionActivity.this.addCompatibleId(hos.O00000o0(0));
                            StartConditionActivity.this.finish();
                        }
                    });
                } else {
                    imageView.setImageResource(R.drawable.std_scene_icon_lock);
                    view.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.StartConditionActivity.O000000o.AnonymousClass1 */

                        public final void onClick(View view) {
                            izb.O000000o(StartConditionActivity.this, (int) R.string.scene_unclickable_toast_2, 0).show();
                        }
                    });
                }
                return view;
            }
            textView.setText(hos.O00000o());
            imageView.setVisibility(0);
            simpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(simpleDraweeView.getResources()).setFadeDuration(200).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build());
            hos.O000000o(simpleDraweeView);
            if (StartConditionActivity.this.O0000O0o.containsKey(hos)) {
            }
            imageView.setImageResource(R.drawable.std_list_main_next);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.StartConditionActivity.O000000o.AnonymousClass2 */

                public final void onClick(View view) {
                    if (hos.O00000oo()) {
                        hpq.O000000o().O00000o0();
                        StartConditionActivity.this.gotoDetailPage(hos);
                        return;
                    }
                    StartConditionActivity.this.mRequestId = hos.O000000o(-1, StartConditionActivity.this, StartConditionActivity.this.O0000OoO);
                    if (StartConditionActivity.this.mRequestId != -1) {
                        StartConditionActivity.this.mCurrentCondition = hos;
                        hpq.O000000o().O00000Oo(StartConditionActivity.this.mCurrentCondition.O000000o(i, null));
                        return;
                    }
                    StartConditionActivity.this.O00000o0.O0000O0o.add(hos.O000000o(-1, null));
                    StartConditionActivity.this.addCompatibleId(hos.O00000o0(0));
                    StartConditionActivity.this.finish();
                }
            });
            return view;
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void getConditionItem(int i) {
        hos hos = this.mCurrentCondition;
        if (hos != null && hos.O00000oO() != null && this.mCurrentCondition.O00000oO().length > 0) {
            hos hos2 = this.mCurrentCondition;
            int O000000o2 = hos2.O000000o(hos2.O00000oO()[i], this, this.O0000OoO);
            if (O000000o2 >= 0) {
                this.mRequestId = i;
                this.O0000o0 = O000000o2;
                hpq.O000000o().O00000Oo(this.mCurrentCondition.O000000o(i, null));
            } else if (O000000o2 == -1) {
                finish();
            } else {
                if (this.O0000Oo == -1) {
                    this.O0000Oo = this.O00000o0.O0000O0o.size();
                }
                List<SceneApi.O000000o> list = this.O00000o0.O0000O0o;
                int i2 = this.O0000Oo;
                hos hos3 = this.mCurrentCondition;
                list.add(i2, hos3.O000000o(hos3.O00000oO()[i], null));
                hos hos4 = this.mCurrentCondition;
                addCompatibleId(hos4.O00000o0(hos4.O00000oO()[i]));
                finish();
            }
        }
    }

    public void addCompatibleId(int i) {
        if (hpq.O000000o().O000000o(Integer.valueOf(i))) {
            hpq.O000000o().O000000o(hod.O0000OoO().O000000o(i));
            hpq.O000000o().O00000Oo(hod.O0000OoO().O00000Oo(i));
            return;
        }
        hpq.O000000o().O00000Oo();
    }
}

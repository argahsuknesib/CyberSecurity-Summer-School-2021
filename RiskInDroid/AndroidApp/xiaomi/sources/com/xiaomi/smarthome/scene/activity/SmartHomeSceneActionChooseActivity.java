package com.xiaomi.smarthome.scene.activity;

import _m_j.fnn;
import _m_j.fno;
import _m_j.ggb;
import _m_j.ggd;
import _m_j.gqd;
import _m_j.hjp;
import _m_j.hnl;
import _m_j.hnm;
import _m_j.hnn;
import _m_j.hno;
import _m_j.hnp;
import _m_j.hnq;
import _m_j.hnr;
import _m_j.hns;
import _m_j.hnt;
import _m_j.hnw;
import _m_j.hod;
import _m_j.hoz;
import _m_j.hpq;
import _m_j.hpr;
import _m_j.hrl;
import _m_j.hxi;
import _m_j.izb;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.ExpandableItemIndicator;
import com.xiaomi.smarthome.scene.activity.SmartHomeSceneActionChooseActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.DefaultSceneItemSet;
import com.xiaomi.smarthome.scene.widget.ConditionDeviceFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class SmartHomeSceneActionChooseActivity extends BaseActivity {
    private static final String O0000o0 = "com.xiaomi.smarthome.scene.activity.SmartHomeSceneActionChooseActivity";

    /* renamed from: O000000o  reason: collision with root package name */
    Context f10884O000000o;
    String O00000Oo;
    int O00000o;
    SceneApi.O000OOOo O00000o0;
    List<Object> O00000oO = new ArrayList();
    ArrayList<hnm> O00000oo = new ArrayList<>();
    ArrayList<hnm> O0000O0o = new ArrayList<>();
    hnm O0000OOo;
    SceneApi.Action O0000Oo;
    Object O0000Oo0;
    int O0000OoO = -1;
    ConditionDeviceFilter O0000Ooo;
    private HashMap<hnm, Boolean> O0000o = new HashMap<>();
    MLAlertDialog O0000o00;
    private List<DefaultSceneItemSet> O0000o0O;
    private int O0000o0o = 0;
    private hno O0000oO = new hno();
    private hns O0000oO0;
    private hnl O0000oOO;
    private hnt O0000oOo;
    private hnr O0000oo = new hnr();
    private hnn O0000oo0 = new hnn();
    private Locale O0000ooO;
    private boolean O0000ooo = false;
    private long O00oOooO = 0;
    public hnp deviceActionFilter = new hnp();
    public int indexOfDeviceTitle = -1;
    public LinearLayoutManager linearLayoutManager;
    @BindView(5171)
    Button mBuyButton;
    @BindView(5186)
    View mBuyView;
    @BindView(5291)
    RecyclerView mContentListView;
    @BindView(5164)
    ExpandableItemIndicator mItemIndicator;
    public O000000o mListAdapter;
    @BindView(5826)
    TextView mModuleA3ReturnTransparentTitle;
    public int mSId = -1;
    public int mSelectedActionPos = -1;
    @BindView(6370)
    RelativeLayout mTitleBarFL;
    @BindView(5235)
    TextView mTitleTopTV;
    @BindView(6407)
    View topDeviceTitleLayout;
    @BindView(6409)
    View topFilterLayout;

    public interface O0000OOo {
        void O000000o(int i, Intent intent);

        void O000000o(Intent intent, int i);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.smarthome_scene_action_v2);
        this.f10884O000000o = this;
        if (CoreApi.O000000o().O0000O0o()) {
            this.O0000ooO = CoreApi.O000000o().O00oOooo();
        } else {
            try {
                this.O0000ooO = ServiceApplication.getAppContext().getResources().getConfiguration().locale;
            } catch (Exception unused) {
                SharedPreferences sharedPreferences = ServiceApplication.getAppContext().getSharedPreferences("com.xiaomi.smarthome.globaldynamicsetting", 0);
                this.O0000ooO = new Locale(sharedPreferences.getString("locale_language", ""), sharedPreferences.getString("locale_country", ""));
            }
        }
        ButterKnife.bind(this);
        this.O00000o = getIntent().getIntExtra("extra_action_index", -1);
        this.O0000o0O = getIntent().getParcelableArrayListExtra("extra_default_actions");
        this.O00000o0 = hpq.O000000o().O00000Oo;
        SceneApi.O000OOOo o000OOOo = this.O00000o0;
        if (o000OOOo == null) {
            finish();
            return;
        }
        if (o000OOOo.O0000O0o != null && this.O00000o0.O0000O0o.size() > 0) {
            String O00000o02 = hnw.O00000o0(this, this.O00000o0.O0000O0o.get(0));
            if (Locale.CHINA.equals(this.O0000ooO) && !TextUtils.isEmpty(O00000o02)) {
                this.mTitleTopTV.setText(String.format(getString(R.string.choose_action_activity_title_top_format), O00000o02));
            }
        }
        this.O00000Oo = this.O00000o0.f11131O000000o;
        hrl.O000000o().O00000oo = this.O00000oo;
        this.linearLayoutManager = new LinearLayoutManager(this);
        this.mContentListView.setLayoutManager(this.linearLayoutManager);
        this.mContentListView.setOnScrollListener(new RecyclerView.O00oOooO() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneActionChooseActivity.AnonymousClass1 */

            public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
            }

            public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (SmartHomeSceneActionChooseActivity.this.indexOfDeviceTitle >= 0) {
                    int findFirstVisibleItemPosition = SmartHomeSceneActionChooseActivity.this.linearLayoutManager.findFirstVisibleItemPosition();
                    if (findFirstVisibleItemPosition >= SmartHomeSceneActionChooseActivity.this.indexOfDeviceTitle) {
                        SmartHomeSceneActionChooseActivity.this.topFilterLayout.setVisibility(0);
                        SmartHomeSceneActionChooseActivity.this.topDeviceTitleLayout.setVisibility(0);
                    } else if (findFirstVisibleItemPosition >= 0 && findFirstVisibleItemPosition < SmartHomeSceneActionChooseActivity.this.indexOfDeviceTitle) {
                        SmartHomeSceneActionChooseActivity.this.topFilterLayout.setVisibility(8);
                        SmartHomeSceneActionChooseActivity.this.topDeviceTitleLayout.setVisibility(8);
                    }
                }
            }
        });
        this.mListAdapter = new O000000o();
        this.mContentListView.setAdapter(this.mListAdapter);
        O000000o();
        if (this.O00000oo.size() == 0) {
            this.mBuyView.setVisibility(0);
            this.mContentListView.setVisibility(8);
            this.mBuyButton.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneActionChooseActivity.AnonymousClass2 */

                public final void onClick(View view) {
                    hjp.O000000o("https://home.mi.com/shop/main");
                }
            });
        } else {
            this.mBuyView.setVisibility(8);
        }
        this.mItemIndicator.setVisibility(8);
        this.mModuleA3ReturnTransparentTitle.setText((int) R.string.smarthome_scene_choose_action);
        if (!this.O00000oo.isEmpty()) {
            this.O0000Ooo = new ConditionDeviceFilter(this) {
                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneActionChooseActivity.AnonymousClass3 */

                public final void O000000o(Home home, DeviceTagInterface.Category category) {
                    if (SmartHomeSceneActionChooseActivity.this.isValid() && SmartHomeSceneActionChooseActivity.this.O0000o00 != null) {
                        SmartHomeSceneActionChooseActivity.this.filterActionByTag(home, category);
                        ((TextView) SmartHomeSceneActionChooseActivity.this.topFilterLayout.findViewById(R.id.filter_name)).setText(category.name);
                        SmartHomeSceneActionChooseActivity.this.deviceActionFilter.O00000oO = category.name;
                        SmartHomeSceneActionChooseActivity.this.mListAdapter.notifyDataSetChanged();
                        SmartHomeSceneActionChooseActivity.this.O0000o00.dismiss();
                    }
                }

                public final void O000000o(Home home, Room room) {
                    if (SmartHomeSceneActionChooseActivity.this.isValid() && SmartHomeSceneActionChooseActivity.this.O0000o00 != null) {
                        if (room == null || !TextUtils.equals("ALL_ROOM", room.getId())) {
                            SmartHomeSceneActionChooseActivity.this.filterActionByRoom(home, room);
                        } else {
                            SmartHomeSceneActionChooseActivity.this.filterActionByHome(home);
                        }
                        ((TextView) SmartHomeSceneActionChooseActivity.this.topFilterLayout.findViewById(R.id.filter_name)).setText(room.getName());
                        SmartHomeSceneActionChooseActivity.this.deviceActionFilter.O00000oO = room.getName();
                        SmartHomeSceneActionChooseActivity.this.mListAdapter.notifyDataSetChanged();
                        SmartHomeSceneActionChooseActivity.this.O0000o00.dismiss();
                    }
                }

                public final void O000000o(Home home) {
                    if (SmartHomeSceneActionChooseActivity.this.isValid() && SmartHomeSceneActionChooseActivity.this.O0000o00 != null) {
                        SmartHomeSceneActionChooseActivity.this.filterActionByHome(home);
                        ((TextView) SmartHomeSceneActionChooseActivity.this.topFilterLayout.findViewById(R.id.filter_name)).setText((int) R.string.tag_all);
                        SmartHomeSceneActionChooseActivity.this.deviceActionFilter.O00000oO = null;
                        SmartHomeSceneActionChooseActivity.this.mListAdapter.notifyDataSetChanged();
                    }
                }

                public final int O000000o(String str, Room room) {
                    return SmartHomeSceneActionChooseActivity.this.getActionCountByRoom(str, room);
                }

                public final int O000000o(String str, DeviceTagInterface.Category category) {
                    return SmartHomeSceneActionChooseActivity.this.getActionCountByTag(str, category);
                }
            };
            this.O0000o00 = this.O0000Ooo.O000000o();
            this.O0000Ooo.O00000Oo();
        }
        this.topFilterLayout.setOnClickListener(null);
        this.topFilterLayout.findViewById(R.id.tv_group_filter).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneActionChooseActivity.AnonymousClass4 */

            public final void onClick(View view) {
                if (SmartHomeSceneActionChooseActivity.this.O0000Ooo != null) {
                    SmartHomeSceneActionChooseActivity.this.O0000Ooo.O00000o0();
                }
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00f2  */
    private void O000000o() {
        hnq hnq;
        SceneApi.Action action;
        this.O00000oO.clear();
        this.O00000oO.addAll(fno.O000000o().O00000Oo().values());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(fno.O000000o().O0000O0o().values());
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((Device) arrayList.get(size)).isSubDevice()) {
                arrayList.remove(size);
            }
        }
        this.O00000oO.addAll(arrayList);
        this.O0000oO0 = new hns(hpr.O00000o0().O0000O0o);
        this.O0000oOO = new hnl(hod.O0000OoO().f416O000000o);
        this.O0000oOo = new hnt();
        this.O00000oo.addAll(O000000o(false));
        int size2 = this.O00000oo.size();
        this.O0000o0o = this.O00000oo.size();
        this.O0000Oo = hpq.O000000o().O00000oo;
        hnq hnq2 = null;
        Device device = null;
        for (int size3 = this.O00000oO.size() - 1; size3 >= 0; size3--) {
            Device device2 = (Device) this.O00000oO.get(size3);
            if (!device2.isOwner()) {
                this.O00000oO.remove(size3);
            } else {
                if (device2 instanceof Device) {
                    Device device3 = device2;
                    if (!(hod.O0000OoO().O00000Oo(device3.model, device3.did) == null || hod.O0000OoO().O00000Oo(device3.model, device3.did).O00000oO == null || hod.O0000OoO().O00000Oo(device3.model, device3.did).O00000oO.size() <= 0)) {
                        hnq = new hnq(device3, null);
                        if (hnq == null) {
                            this.O00000oo.add(hnq);
                            Iterator<SceneApi.Action> it = this.O00000o0.O00000oo.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    SceneApi.Action next = it.next();
                                    int O000000o2 = hnq.O000000o(next, this.O00000oO.get(size3));
                                    if (O000000o2 >= 0 && (action = this.O0000Oo) != null && action.equals(next)) {
                                        this.mSId = O000000o2;
                                        device = (Device) this.O00000oO.get(size3);
                                        hnq2 = hnq;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        } else {
                            this.O00000oO.remove(size3);
                        }
                    }
                }
                hnq = null;
                if (hnq == null) {
                }
            }
        }
        if (size2 == this.O00000oo.size()) {
            this.O0000ooo = false;
        } else {
            this.O0000ooo = true;
        }
        if (this.mSId != -1) {
            this.mSelectedActionPos = this.O00000o0.O00000oo.indexOf(this.O0000Oo);
            if (this.mSelectedActionPos == -1) {
                this.mSId = -1;
                this.O0000Oo = null;
            } else {
                this.O00000o0.O00000oo.remove(this.O0000Oo);
                hpq.O000000o().O00000o(this.O00000o0);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int size4 = this.O00000oo.size() - 1; size4 >= 0; size4--) {
            if ((this.O00000oo.get(size4) instanceof hnq) && this.O00000oo.get(size4).O00000o()) {
                this.O0000o.put(this.O00000oo.get(size4), Boolean.FALSE);
                arrayList2.add(this.O00000oo.remove(size4));
            }
        }
        this.O00000oo.addAll(arrayList2);
        if (this.mSId != -1) {
            Intent intent = new Intent();
            intent.setClass(this, SmartHomeSceneDetailActivity.class);
            intent.putExtra("extra_title", hnq2.O000000o((Object) device));
            intent.putExtra("extra_selected_title", this.mSId);
            this.O00oOooO = System.currentTimeMillis();
            startActivityForResult(intent, 101);
            hpq.O000000o().O000000o(hnq2);
            this.O0000OOo = hnq2;
            this.O0000Oo0 = device;
        }
        SceneApi.Action action2 = this.O0000Oo;
        if (action2 != null && (action2.O0000O0o instanceof SceneApi.O000O00o)) {
            this.mSelectedActionPos = this.O00000o0.O00000oo.indexOf(this.O0000Oo);
            if (this.mSelectedActionPos == -1) {
                this.mSId = -1;
                this.O0000Oo = null;
                return;
            }
            Intent intent2 = new Intent();
            intent2.setClass(this, LiteAutomationChooseScene.class);
            intent2.putExtra("select_us_id", ((SceneApi.O000O00o) this.O0000Oo.O0000O0o).f11127O000000o);
            startActivityForResult(intent2, 101);
            hpq.O000000o().O000000o(this.O0000oO0);
            this.O0000OOo = this.O0000oO0;
            this.O00000o0.O00000oo.remove(this.O0000Oo);
        }
        SceneApi.Action action3 = this.O0000Oo;
        if (action3 != null && (action3.O0000O0o instanceof SceneApi.O000O0OO)) {
            this.mSelectedActionPos = this.O00000o0.O00000oo.indexOf(this.O0000Oo);
            if (this.mSelectedActionPos == -1) {
                this.mSId = -1;
                this.O0000Oo = null;
                return;
            }
            Intent intent3 = new Intent();
            intent3.setClass(this, AutoSceneActionChooseActivity.class);
            intent3.putExtra("select_scene_id", ((SceneApi.O000O0OO) this.O0000Oo.O0000O0o).f11128O000000o);
            intent3.putExtra("extra_enable", ((SceneApi.O000O0OO) this.O0000Oo.O0000O0o).O00000Oo);
            startActivityForResult(intent3, 101);
            hpq.O000000o().O000000o(this.O0000oOO);
            this.O0000OOo = this.O0000oOO;
            this.O00000o0.O00000oo.remove(this.O0000Oo);
        }
        O000000o(hpq.O000000o().O0000Oo);
    }

    public int getActionCountByTag(String str, DeviceTagInterface.Category category) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Map<String, List<String>> O0000Oo2 = fnn.O000000o().O00000Oo().O0000Oo(str);
        if (O0000Oo2.isEmpty()) {
            return 0;
        }
        List list = O0000Oo2.get(category.name);
        if (list.isEmpty()) {
            return 0;
        }
        HashSet hashSet = new HashSet(list);
        for (int i = 0; i < this.O00000oo.size(); i++) {
            hnm hnm = this.O00000oo.get(i);
            if (hnm instanceof hnq) {
                hnq hnq = (hnq) hnm;
                if (hnq.O00000oo != null && hashSet.contains(hnq.O00000oo.did)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public int getActionCountByRoom(String str, Room room) {
        if (TextUtils.isEmpty(str) || room == null) {
            return 0;
        }
        if (room.getId().equalsIgnoreCase("ALL_ROOM")) {
            return 1;
        }
        if (room.getId().equalsIgnoreCase("DEFAULT_ROOM")) {
            List<Device> O0000OOo2 = ggb.O00000Oo().O0000OOo(str);
            if (O0000OOo2.isEmpty()) {
                return 0;
            }
            HashSet hashSet = new HashSet(O0000OOo2);
            for (int i = 0; i < this.O00000oo.size(); i++) {
                hnm hnm = this.O00000oo.get(i);
                if (hnm instanceof hnq) {
                    hnq hnq = (hnq) hnm;
                    if (hnq.O00000oo != null && hashSet.contains(hnq.O00000oo)) {
                        return 1;
                    }
                }
            }
        } else {
            List<String> dids = room.getDids();
            if (dids.isEmpty()) {
                return 0;
            }
            HashSet hashSet2 = new HashSet(dids);
            for (int i2 = 0; i2 < this.O00000oo.size(); i2++) {
                hnm hnm2 = this.O00000oo.get(i2);
                if (hnm2 instanceof hnq) {
                    hnq hnq2 = (hnq) hnm2;
                    if (hnq2.O00000oo != null && hashSet2.contains(hnq2.O00000oo.did)) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public void filterActionByHome(Home home) {
        if (home == null) {
            this.mListAdapter.O000000o(this.O00000oo);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(O000000o(true));
        List<String> O000000o2 = ggb.O00000Oo().O000000o(home.getId(), true);
        if (O000000o2.isEmpty()) {
            this.mListAdapter.O000000o(this.O00000oo);
        }
        HashSet hashSet = new HashSet();
        if (!O000000o2.isEmpty()) {
            hashSet.addAll(O000000o2);
        }
        for (int i = 0; i < this.O00000oo.size(); i++) {
            hnm hnm = this.O00000oo.get(i);
            if (hnm instanceof hnq) {
                hnq hnq = (hnq) hnm;
                if (hnq.O00000oo != null && hashSet.contains(hnq.O00000oo.did)) {
                    arrayList.add(hnm);
                }
            }
        }
        this.mListAdapter.O000000o(arrayList);
    }

    public void filterActionByTag(Home home, DeviceTagInterface.Category category) {
        if (home == null) {
            this.mListAdapter.O000000o(this.O00000oo);
        } else if (category == null) {
            filterActionByHome(home);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(O000000o(true));
            Map<String, List<String>> O0000Oo2 = fnn.O000000o().O00000Oo().O0000Oo(home.getId());
            if (O0000Oo2.isEmpty()) {
                filterActionByHome(home);
                return;
            }
            List list = O0000Oo2.get(category.name);
            if (list.isEmpty()) {
                filterActionByHome(home);
                return;
            }
            HashSet hashSet = new HashSet(list);
            for (int i = 0; i < this.O00000oo.size(); i++) {
                hnm hnm = this.O00000oo.get(i);
                if (hnm instanceof hnq) {
                    hnq hnq = (hnq) hnm;
                    if (hnq.O00000oo != null && hashSet.contains(hnq.O00000oo.did)) {
                        arrayList.add(hnm);
                    }
                }
            }
            this.mListAdapter.O000000o(arrayList);
        }
    }

    public void filterActionByRoom(Home home, Room room) {
        if (home == null) {
            this.mListAdapter.O000000o(this.O00000oo);
        } else if (room == null) {
            filterActionByHome(home);
        } else if (room.getId().equalsIgnoreCase("ALL_ROOM")) {
            filterActionByHome(home);
        } else {
            int i = 0;
            if (room.getId().equalsIgnoreCase("DEFAULT_ROOM")) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(O000000o(true));
                List<Device> O0000O0o2 = ggb.O00000Oo().O0000O0o(home.getId());
                if (O0000O0o2.isEmpty()) {
                    filterActionByHome(home);
                    return;
                }
                HashSet hashSet = new HashSet(O0000O0o2);
                while (i < this.O00000oo.size()) {
                    hnm hnm = this.O00000oo.get(i);
                    boolean z = hnm instanceof hnq;
                    if (z && z) {
                        hnq hnq = (hnq) hnm;
                        if (hnq.O00000oo != null && hashSet.contains(hnq.O00000oo)) {
                            arrayList.add(hnm);
                        }
                    }
                    i++;
                }
                this.mListAdapter.O000000o(arrayList);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(O000000o(true));
            List<String> dids = room.getDids();
            if (dids.isEmpty()) {
                filterActionByHome(home);
                return;
            }
            HashSet hashSet2 = new HashSet(dids);
            while (i < this.O00000oo.size()) {
                hnm hnm2 = this.O00000oo.get(i);
                if (hnm2 instanceof hnq) {
                    hnq hnq2 = (hnq) hnm2;
                    if (hnq2.O00000oo != null && hashSet2.contains(hnq2.O00000oo.did)) {
                        arrayList2.add(hnm2);
                    }
                }
                i++;
            }
            this.mListAdapter.O000000o(arrayList2);
        }
    }

    private void O000000o(Room room) {
        ArrayList arrayList = new ArrayList();
        for (Home next : ggb.O00000Oo().O0000OoO.O00000Oo) {
            if (next.isOwner()) {
                List<Room> O000000o2 = ggb.O00000Oo().O000000o(next.getId());
                if (!O000000o2.isEmpty()) {
                    arrayList.addAll(O000000o2);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(O000000o(true));
        int size = arrayList2.size();
        String str = hpq.O000000o().O0000o0;
        hnm hnm = null;
        int i = 0;
        while (true) {
            if (i >= (this.O00000oo.isEmpty() ? 0 : this.O00000oo.size())) {
                break;
            }
            if (this.O00000oo.get(i) instanceof hnq) {
                if (str == null || !TextUtils.equals(((hnq) this.O00000oo.get(i)).O00000oo.did, str)) {
                    arrayList2.add(this.O00000oo.get(i));
                } else {
                    hnm = this.O00000oo.get(i);
                }
            }
            i++;
        }
        Collections.sort(arrayList2, new O00000Oo(room, arrayList2));
        if (hnm != null) {
            arrayList2.add(size, hnm);
        }
        this.O00000oo.clear();
        this.O00000oo.addAll(arrayList2);
        this.mListAdapter.O000000o(this.O00000oo);
    }

    private List<hnm> O000000o(boolean z) {
        boolean z2;
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(this.O0000oo0);
        }
        hpq.O000000o();
        if (!hpq.O00000o0(this.O00000o0.O0000O0o)) {
            arrayList.add(this.O0000oO0);
        }
        arrayList.add(this.O0000oOO);
        Iterator<SceneApi.Action> it = this.O00000o0.O00000oo.iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = true;
                break;
            }
            SceneApi.Action next = it.next();
            if (next.O0000O0o != null && (next.O0000O0o instanceof SceneApi.O000OO)) {
                z2 = false;
                break;
            }
        }
        if (z2) {
            arrayList.add(this.O0000oOo);
        }
        if (this.O00000o0.O00000oo.size() == 0 || !(this.O00000o0.O00000oo.get(this.O00000o0.O00000oo.size() - 1).O0000O0o instanceof SceneApi.O000O0o0)) {
            arrayList.add(this.O0000oO);
        }
        if (z) {
            arrayList.add(this.O0000oo);
        }
        if (this.O0000ooo) {
            arrayList.add(this.deviceActionFilter);
            this.indexOfDeviceTitle = arrayList.size() - 2;
        } else {
            this.indexOfDeviceTitle = -1;
        }
        return arrayList;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 101) {
            this.mHandler.post(new Runnable(intent.getIntExtra("extra_index", -1), intent.getIntExtra("extra_enable", -1)) {
                /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmartHomeSceneActionChooseActivity$7gnsMridlyiWYogWIkFaHQru458 */
                private final /* synthetic */ int f$1;
                private final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    SmartHomeSceneActionChooseActivity.this.O000000o(this.f$1, this.f$2);
                }
            });
        } else if (i2 == -1 && this.O0000OoO >= 0) {
            hnm hnm = this.O0000OOo;
            SceneApi.Action O000000o2 = hnm.O000000o(hnm.f19096O000000o[this.O0000OoO], this.O0000OOo.O00000Oo[this.O0000OoO], this.O0000Oo0, intent);
            addScence(O000000o2);
            hpq.O000000o().O000000o(O000000o2);
            if (O000000o2.O00000o != 0) {
                addCompatibleId(O000000o2.O00000o);
            }
            finish();
        }
        if (i2 == 0 && this.O0000Oo != null && this.mSelectedActionPos != -1) {
            this.O00000o0.O00000oo.add(this.mSelectedActionPos, this.O0000Oo);
            if (this.O0000Oo.O00000o != 0) {
                addCompatibleId(this.O0000Oo.O00000o);
            }
            finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(int i, int i2) {
        getActionItem(i, i2);
        hxi.O00000o.O00000Oo("action", System.currentTimeMillis() - this.O00oOooO);
    }

    public void onActivityResult(final int i, final Intent intent) {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneActionChooseActivity.AnonymousClass5 */

            public final void run() {
                if (i != -1) {
                    if (SmartHomeSceneActionChooseActivity.this.mSId != -1) {
                        SmartHomeSceneActionChooseActivity.this.O00000o0.O00000oo.add(SmartHomeSceneActionChooseActivity.this.mSelectedActionPos, SmartHomeSceneActionChooseActivity.this.O0000Oo);
                        if (SmartHomeSceneActionChooseActivity.this.O0000Oo.O00000o != 0) {
                            SmartHomeSceneActionChooseActivity smartHomeSceneActionChooseActivity = SmartHomeSceneActionChooseActivity.this;
                            smartHomeSceneActionChooseActivity.addCompatibleId(smartHomeSceneActionChooseActivity.O0000Oo.O00000o);
                        }
                        SmartHomeSceneActionChooseActivity.this.finish();
                    }
                    SmartHomeSceneActionChooseActivity smartHomeSceneActionChooseActivity2 = SmartHomeSceneActionChooseActivity.this;
                    smartHomeSceneActionChooseActivity2.O0000OoO = 0;
                    smartHomeSceneActionChooseActivity2.O0000OOo.O00000o0();
                    SmartHomeSceneActionChooseActivity smartHomeSceneActionChooseActivity3 = SmartHomeSceneActionChooseActivity.this;
                    smartHomeSceneActionChooseActivity3.O0000Oo0 = null;
                    smartHomeSceneActionChooseActivity3.mListAdapter.notifyDataSetChanged();
                } else if (SmartHomeSceneActionChooseActivity.this.O0000Oo0 != null && SmartHomeSceneActionChooseActivity.this.O0000OoO < SmartHomeSceneActionChooseActivity.this.O0000OOo.f19096O000000o.length && SmartHomeSceneActionChooseActivity.this.O0000OoO < SmartHomeSceneActionChooseActivity.this.O0000OOo.O00000Oo.length) {
                    SceneApi.Action O000000o2 = SmartHomeSceneActionChooseActivity.this.O0000OOo.O000000o(SmartHomeSceneActionChooseActivity.this.O0000OOo.f19096O000000o[SmartHomeSceneActionChooseActivity.this.O0000OoO], SmartHomeSceneActionChooseActivity.this.O0000OOo.O00000Oo[SmartHomeSceneActionChooseActivity.this.O0000OoO], SmartHomeSceneActionChooseActivity.this.O0000Oo0, intent);
                    SmartHomeSceneActionChooseActivity.this.addScence(O000000o2);
                    SmartHomeSceneActionChooseActivity.this.addCompatibleId(O000000o2.O00000o);
                    SmartHomeSceneActionChooseActivity.this.finish();
                }
            }
        });
    }

    @OnClick({5822})
    public void close() {
        if (SmarthomeCreateAutoSceneActivity.mIsInitStep) {
            hpq.O000000o().O0000Oo0 = 4;
        }
        finish();
    }

    class O000000o extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
        private List<hnm> O00000Oo = new ArrayList();
        private LayoutInflater O00000o0;

        public final long getItemId(int i) {
            return (long) i;
        }

        public O000000o() {
            this.O00000o0 = SmartHomeSceneActionChooseActivity.this.getLayoutInflater();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return new O0000O0o(this.O00000o0.inflate((int) R.layout.create_scene_filter_layout, viewGroup, false));
            }
            if (i == 1) {
                return new O0000Oo0(this.O00000o0.inflate((int) R.layout.create_scene_common_title_layout, viewGroup, false));
            }
            if (i == 2) {
                return new O00000o0(this.O00000o0.inflate((int) R.layout.create_scene_common_selection_layout, viewGroup, false));
            }
            if (i == 3) {
                return new O00000o(this.O00000o0.inflate((int) R.layout.create_scene_device_selection_layout, viewGroup, false));
            }
            if (i != 4) {
                return null;
            }
            return new O0000Oo0(this.O00000o0.inflate((int) R.layout.create_scene_device_title_layout, viewGroup, false));
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            String str;
            int itemViewType = getItemViewType(i);
            if (!this.O00000Oo.isEmpty() && i < this.O00000Oo.size() && i >= 0) {
                hnm hnm = this.O00000Oo.get(i);
                if (itemViewType != 0) {
                    boolean z = true;
                    if (itemViewType != 1) {
                        if (itemViewType != 2) {
                            if (itemViewType != 3) {
                                if (itemViewType != 4) {
                                    return;
                                }
                            } else if ((o000OOo0 instanceof O00000o) && (hnm instanceof hnq)) {
                                ((O00000o) o000OOo0).O000000o((hnq) hnm);
                                return;
                            } else {
                                return;
                            }
                        } else if (o000OOo0 instanceof O00000o0) {
                            int i2 = i + 1;
                            if (i2 > 0 && i2 < getItemCount() && getItemViewType(i2) == 4) {
                                z = false;
                            }
                            if (hnm instanceof hns) {
                                ((O00000o0) o000OOo0).O000000o(hnm, z);
                                return;
                            } else if (hnm instanceof hno) {
                                ((O00000o0) o000OOo0).O000000o(hnm, z);
                                return;
                            } else if (hnm instanceof hnl) {
                                ((O00000o0) o000OOo0).O000000o(hnm, z);
                                return;
                            } else if (hnm instanceof hnt) {
                                ((O00000o0) o000OOo0).O000000o(hnm, z);
                                return;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    o000OOo0.itemView.setOnClickListener(null);
                    return;
                }
                if ((o000OOo0 instanceof O0000O0o) && (hnm instanceof hnp)) {
                    O0000O0o o0000O0o = (O0000O0o) o000OOo0;
                    hnp hnp = (hnp) hnm;
                    if (hnp != null) {
                        if (TextUtils.isEmpty(hnp.O00000oO)) {
                            str = ServiceApplication.getAppContext().getString(R.string.smarthome_scene_all);
                        } else {
                            str = hnp.O00000oO;
                        }
                        TextView textView = o0000O0o.O00000Oo;
                        if (TextUtils.isEmpty(str)) {
                            str = "";
                        }
                        textView.setText(str);
                    }
                }
                o000OOo0.itemView.setOnClickListener(null);
            }
        }

        public final int getItemCount() {
            if (this.O00000Oo.isEmpty()) {
                return 0;
            }
            return this.O00000Oo.size();
        }

        public final int getItemViewType(int i) {
            List<hnm> list = this.O00000Oo;
            if (list != null && i < list.size()) {
                if (this.O00000Oo.get(i) instanceof hnn) {
                    return 1;
                }
                if (this.O00000Oo.get(i) instanceof hnr) {
                    return 4;
                }
                if (this.O00000Oo.get(i) instanceof hnp) {
                    return 0;
                }
                if (this.O00000Oo.get(i) instanceof hnq) {
                    return 3;
                }
                if ((this.O00000Oo.get(i) instanceof hns) || (this.O00000Oo.get(i) instanceof hnl) || (this.O00000Oo.get(i) instanceof hnt) || (this.O00000Oo.get(i) instanceof hno)) {
                    return 2;
                }
            }
            return super.getItemViewType(i);
        }

        public final void O000000o(List<hnm> list) {
            this.O00000Oo.clear();
            if (!list.isEmpty()) {
                this.O00000Oo.addAll(list);
            }
            SmartHomeSceneActionChooseActivity.this.mContentListView.stopScroll();
            SmartHomeSceneActionChooseActivity.this.mContentListView.getRecycledViewPool().O000000o();
            notifyDataSetChanged();
        }
    }

    class O0000Oo0 extends RecyclerView.O000OOo0 {
        public O0000Oo0(View view) {
            super(view);
        }
    }

    class O0000O0o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        View f10896O000000o;
        TextView O00000Oo;

        public O0000O0o(View view) {
            super(view);
            this.f10896O000000o = view.findViewById(R.id.tv_group_filter);
            this.O00000Oo = (TextView) view.findViewById(R.id.filter_name);
            this.f10896O000000o.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmartHomeSceneActionChooseActivity$O0000O0o$1lTcp50BKZsFvXhoQ2kzSvPoo4 */

                public final void onClick(View view) {
                    SmartHomeSceneActionChooseActivity.O0000O0o.this.O000000o(view);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(View view) {
            SmartHomeSceneActionChooseActivity.this.O0000Ooo.O00000o0();
        }
    }

    class O00000o0 extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f10895O000000o;
        public SimpleDraweeView O00000Oo;
        public View O00000o;
        public ImageView O00000o0;

        public O00000o0(View view) {
            super(view);
            this.f10895O000000o = (TextView) view.findViewById(R.id.condition_name);
            this.O00000Oo = (SimpleDraweeView) view.findViewById(R.id.content_icon);
            this.O00000o0 = (ImageView) view.findViewById(R.id.expand_hint);
            this.O00000o = view.findViewById(R.id.item_divider);
        }

        public final void O000000o(hnm hnm, boolean z) {
            if (hnm != null) {
                this.O00000o.setVisibility(z ? 0 : 8);
                String string = hnm instanceof hoz ? SmartHomeSceneActionChooseActivity.this.getString(((hoz) hnm).O000000o()) : hnm.O000000o((Object) null);
                TextView textView = this.f10895O000000o;
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                textView.setText(string);
                SmartHomeSceneActionChooseActivity.this.setIconByAction(hnm, this.O00000Oo);
                this.itemView.setOnClickListener(new View.OnClickListener(hnm) {
                    /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmartHomeSceneActionChooseActivity$O00000o0$HkxFc5kzg35ujJbzJx96e8oues */
                    private final /* synthetic */ hnm f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        SmartHomeSceneActionChooseActivity.O00000o0.this.O000000o(this.f$1, view);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(hnm hnm, View view) {
            if (hnm instanceof hnt) {
                SmartHomeSceneActionChooseActivity.this.addScence(hnm.O000000o(null, 0, null, null));
                SmartHomeSceneActionChooseActivity.this.finish();
            } else if (hnm instanceof hns) {
                Intent intent = new Intent();
                intent.setClass(SmartHomeSceneActionChooseActivity.this, LiteAutomationChooseScene.class);
                SmartHomeSceneActionChooseActivity.this.startActivityForResult(intent, 101);
                hpq.O000000o().O000000o(hnm);
                SmartHomeSceneActionChooseActivity.this.O0000OOo = hnm;
            } else if (hnm instanceof hnl) {
                Intent intent2 = new Intent();
                intent2.setClass(SmartHomeSceneActionChooseActivity.this, AutoSceneActionChooseActivity.class);
                SmartHomeSceneActionChooseActivity.this.startActivityForResult(intent2, 101);
                hpq.O000000o().O000000o(hnm);
                SmartHomeSceneActionChooseActivity.this.O0000OOo = hnm;
            } else if (hnm instanceof hno) {
                SmartHomeSceneActionChooseActivity smartHomeSceneActionChooseActivity = SmartHomeSceneActionChooseActivity.this;
                smartHomeSceneActionChooseActivity.O0000OOo = hnm;
                smartHomeSceneActionChooseActivity.getActionItem(0, -1);
            }
        }
    }

    public void setIconByAction(hnm hnm, SimpleDraweeView simpleDraweeView) {
        if (simpleDraweeView != null && hnm != null) {
            simpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(simpleDraweeView.getResources()).setFadeDuration(200).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build());
            if (hnm instanceof hnt) {
                simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.std_scene_icon_push));
            } else if (hnm instanceof hns) {
                simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.scene_click_lite_scene_icon));
            } else if (hnm instanceof hnl) {
                simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.scene_auto_icon));
            } else if (hnm instanceof hno) {
                simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.std_scene_icon_delayed));
            } else if (hnm instanceof hnq) {
                DeviceFactory.O00000Oo(((hnq) hnm).O00000oo.model, simpleDraweeView);
            }
        }
    }

    class O00000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f10893O000000o;
        public TextView O00000Oo;
        public ImageView O00000o;
        public SimpleDraweeView O00000o0;
        public TextView O00000oO;

        public O00000o(View view) {
            super(view);
            this.f10893O000000o = (TextView) view.findViewById(R.id.device_name);
            this.O00000Oo = (TextView) view.findViewById(R.id.room_name);
            this.O00000oO = (TextView) view.findViewById(R.id.offline_tv);
            this.O00000o0 = (SimpleDraweeView) view.findViewById(R.id.content_icon);
            this.O00000o = (ImageView) view.findViewById(R.id.expand_hint);
        }

        public final void O000000o(final hnq hnq) {
            if (hnq != null) {
                final boolean z = false;
                this.O00000oO.setVisibility(0);
                final String str = null;
                Device O00000o02 = fno.O000000o().O00000o0(hnq.O00000oo.did);
                if (O00000o02 == null) {
                    this.O00000oO.setText((int) R.string.samrthome_scene_device_off_line);
                } else if (hpq.O000000o().O00000Oo(O00000o02.did)) {
                    this.O00000oO.setText((int) R.string.scene_has_selected);
                    z = true;
                    str = O00000o02.did;
                } else if (!O00000o02.isOnline) {
                    this.O00000oO.setText((int) R.string.samrthome_scene_device_off_line);
                } else {
                    this.O00000oO.setVisibility(8);
                }
                this.O00000Oo.setText(SmartHomeSceneActionChooseActivity.this.getContentDesc(hnq));
                SmartHomeSceneActionChooseActivity.this.setIconByAction(hnq, this.O00000o0);
                this.f10893O000000o.setText(hnq.O000000o(hnq.O00000oo));
                if (SmartHomeSceneActionChooseActivity.this.setLockByAction(hnq, this.O00000o)) {
                    this.itemView.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmartHomeSceneActionChooseActivity$O00000o$ZAYq9oQg0TYMEdE0M3EVSc1s3Mg */

                        public final void onClick(View view) {
                            SmartHomeSceneActionChooseActivity.O00000o.this.O000000o(view);
                        }
                    });
                } else {
                    this.itemView.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneActionChooseActivity.O00000o.AnonymousClass1 */

                        public final void onClick(View view) {
                            Intent intent = new Intent();
                            intent.setClass(SmartHomeSceneActionChooseActivity.this, SmartHomeSceneDetailActivity.class);
                            intent.putExtra("extra_title", hnq.O000000o(hnq.O00000oo));
                            if (z) {
                                intent.putExtra("extra_selected_did", str);
                            }
                            SmartHomeSceneActionChooseActivity.this.startActivityForResult(intent, 101);
                            hpq.O000000o().O000000o(hnq);
                            SmartHomeSceneActionChooseActivity.this.O0000OOo = hnq;
                            SmartHomeSceneActionChooseActivity.this.O0000Oo0 = hnq.O00000oo;
                            hpq.O000000o().O0000Oo = ggb.O00000Oo().O0000o00(hnq.O00000oo.did);
                        }
                    });
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(View view) {
            izb.O000000o(SmartHomeSceneActionChooseActivity.this, (int) R.string.scene_unclickable_toast_2, 0).show();
        }
    }

    public boolean setLockByAction(hnq hnq, ImageView imageView) {
        if (imageView == null) {
            return false;
        }
        if (!this.O0000o.containsKey(hnq) || this.O0000o.get(hnq).booleanValue()) {
            imageView.setImageResource(R.drawable.std_list_main_next);
            return false;
        }
        imageView.setImageResource(R.drawable.std_scene_icon_lock);
        return true;
    }

    public String getContentDesc(hnq hnq) {
        String string = getString(R.string.room_default);
        if (ggd.O000000o(hnq.O00000oo.model)) {
            return "";
        }
        Room O0000o002 = (hnq == null || hnq.O00000oo == null) ? null : ggb.O00000Oo().O0000o00(hnq.O00000oo.did);
        return O0000o002 != null ? O0000o002.getName() : string;
    }

    public void onResume() {
        super.onResume();
    }

    public void addScence(SceneApi.Action action) {
        for (int size = this.O00000o0.O00000oo.size() - 1; size >= 0; size--) {
            if ((this.O00000o0.O00000oo.get(size).O0000O0o instanceof SceneApi.O000OO) && (action.O0000O0o instanceof SceneApi.O000OO)) {
                this.O00000o0.O00000oo.remove(this.O00000o0.O00000oo.get(size));
            }
        }
        if (this.mSelectedActionPos != -1) {
            this.O00000o0.O00000oo.add(this.mSelectedActionPos, action);
        } else {
            this.O00000o0.O00000oo.add(action);
        }
        if (action.O0000O0o != null && (action.O0000O0o instanceof SceneApi.O000OO0o)) {
            SceneApi.O000OO0o o000OO0o = (SceneApi.O000OO0o) action.O0000O0o;
            if (!TextUtils.isEmpty(o000OO0o.O00000o)) {
                hpq.O000000o().O0000o0 = o000OO0o.O00000o;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007a  */
    public void getActionItem(int i, int i2) {
        boolean z;
        int O000000o2;
        SceneApi.Action action;
        CommonSceneOnline commonSceneOnline;
        hnm hnm = this.O0000OOo;
        if (hnm == null || i < 0) {
            return;
        }
        if (hnm.f19096O000000o != null && this.O0000OOo.f19096O000000o.length <= i) {
            return;
        }
        if (this.O0000OOo.O00000Oo == null || this.O0000OOo.O00000Oo.length > i) {
            if (this.O0000Oo != null) {
                hnm hnm2 = this.O0000OOo;
                if ((hnm2 instanceof hnq) && (commonSceneOnline = ((hnq) hnm2).O00000oO) != null && commonSceneOnline.O00000oO != null && this.O0000Oo.O00000oo == ((hnq) this.O0000OOo).O00000oO.O00000oO.get(i).O00000Oo) {
                    z = true;
                    O000000o2 = this.O0000OOo.O000000o(new O0000OOo() {
                        /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneActionChooseActivity.AnonymousClass6 */

                        public final void O000000o(Intent intent, int i) {
                            SmartHomeSceneActionChooseActivity.this.startActivityForResult(intent, i);
                        }

                        public final void O000000o(int i, Intent intent) {
                            SmartHomeSceneActionChooseActivity.this.onActivityResult(i, intent);
                        }
                    }, getContext(), this.O0000OOo.O00000Oo[i], this.O0000Oo0, (z || (action = this.O0000Oo) == null) ? null : action.O0000O0o.O00000oO);
                    if (O000000o2 < 0) {
                        this.O0000OoO = i;
                        return;
                    } else if (O000000o2 == -1) {
                        this.mListAdapter.notifyDataSetChanged();
                        return;
                    } else if (O000000o2 == -99) {
                        if (this.mSId != -1) {
                            if (this.O0000Oo != null) {
                                if (this.mSelectedActionPos == -1) {
                                    this.O00000o0.O00000oo.add(0, this.O0000Oo);
                                } else {
                                    this.O00000o0.O00000oo.add(this.mSelectedActionPos, this.O0000Oo);
                                }
                                addCompatibleId(this.O0000Oo.O00000o);
                            }
                            finish();
                            return;
                        }
                        this.mListAdapter.notifyDataSetChanged();
                        return;
                    } else if (O000000o2 == -3) {
                        Intent intent = new Intent();
                        intent.putExtra("enable", i2);
                        hnm hnm3 = this.O0000OOo;
                        SceneApi.Action O000000o3 = hnm3.O000000o(hnm3.f19096O000000o[i], this.O0000OOo.O00000Oo[i], this.O0000Oo0, intent);
                        addScence(O000000o3);
                        if (O000000o3.O00000o != 0) {
                            addCompatibleId(O000000o3.O00000o);
                        }
                        finish();
                        return;
                    } else {
                        hnm hnm4 = this.O0000OOo;
                        SceneApi.Action O000000o4 = hnm4.O000000o(hnm4.f19096O000000o[i], this.O0000OOo.O00000Oo[i], this.O0000Oo0, null);
                        addScence(O000000o4);
                        if (O000000o4.O00000o != 0) {
                            addCompatibleId(O000000o4.O00000o);
                        }
                        finish();
                        return;
                    }
                }
            }
            z = false;
            O000000o2 = this.O0000OOo.O000000o(new O0000OOo() {
                /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneActionChooseActivity.AnonymousClass6 */

                public final void O000000o(Intent intent, int i) {
                    SmartHomeSceneActionChooseActivity.this.startActivityForResult(intent, i);
                }

                public final void O000000o(int i, Intent intent) {
                    SmartHomeSceneActionChooseActivity.this.onActivityResult(i, intent);
                }
            }, getContext(), this.O0000OOo.O00000Oo[i], this.O0000Oo0, (z || (action = this.O0000Oo) == null) ? null : action.O0000O0o.O00000oO);
            if (O000000o2 < 0) {
            }
        }
    }

    public void addCompatibleId(int i) {
        if (hpq.O000000o().O00000Oo(Integer.valueOf(i))) {
            hpq.O000000o().O000000o(hod.O0000OoO().O000000o(i));
            hpq.O000000o().O00000Oo(hod.O0000OoO().O00000Oo(i));
            return;
        }
        hpq.O000000o().O0000OOo = new ArrayList();
    }

    public void onBackPressed() {
        if (SmarthomeCreateAutoSceneActivity.mIsInitStep) {
            hpq.O000000o().O0000Oo0 = 4;
        }
        super.onBackPressed();
    }

    class O00000Oo implements Comparator<hnm> {
        private Map<String, Integer> O00000Oo = new HashMap();
        private Map<String, Integer> O00000o0 = new HashMap();

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            hnm hnm = (hnm) obj;
            hnm hnm2 = (hnm) obj2;
            boolean z = hnm instanceof hnq;
            int i = 0;
            if (z && (hnm2 instanceof hnq)) {
                Device device = ((hnq) hnm).O00000oo;
                Device device2 = ((hnq) hnm2).O00000oo;
                if (device == null && device2 == null) {
                    return 0;
                }
                if (device == null || device2 == null) {
                    return device == null ? 1 : -1;
                }
                int i2 = (device2.isOnline ? 1 : 0) - (device.isOnline ? 1 : 0);
                if (i2 != 0) {
                    return i2;
                }
                Room O0000o00 = ggb.O00000Oo().O0000o00(device.did);
                Room O0000o002 = ggb.O00000Oo().O0000o00(device2.did);
                if (O0000o00 == null && O0000o002 == null) {
                    if (ggd.O000000o(device.model) && !ggd.O000000o(device2.model)) {
                        return 1;
                    }
                    if (ggd.O000000o(device.model) || !ggd.O000000o(device2.model)) {
                        return O000000o(device, device2);
                    }
                } else if (O0000o00 == null || O0000o002 == null) {
                    return O0000o00 == null ? 1 : -1;
                } else {
                    if (this.O00000Oo.containsKey(O0000o00.getId()) || this.O00000Oo.containsKey(O0000o002.getId())) {
                        if (!this.O00000Oo.containsKey(O0000o00.getId()) || !this.O00000Oo.containsKey(O0000o002.getId())) {
                            i = !this.O00000Oo.containsKey(O0000o00.getId()) ? 1 : -1;
                        } else {
                            i = this.O00000Oo.get(O0000o002.getId()).intValue() - this.O00000Oo.get(O0000o00.getId()).intValue();
                        }
                    }
                    return i != 0 ? i : O000000o(device, device2);
                }
            } else if (z || (hnm2 instanceof hnq)) {
                if (z) {
                    return 1;
                }
            } else if (this.O00000o0.get(hnm.getClass().getName()) == null || this.O00000o0.get(hnm2.getClass().getName()) == null) {
                return this.O00000o0.get(hnm.getClass().getName()) != null ? 1 : 0;
            } else {
                return this.O00000o0.get(hnm.getClass().getName()).intValue() - this.O00000o0.get(hnm2.getClass().getName()).intValue();
            }
            return -1;
        }

        public O00000Oo(Room room, List<hnm> list) {
            if (room != null) {
                this.O00000Oo.put(room.getId(), 0);
            }
            ArrayList arrayList = new ArrayList();
            for (Home next : ggb.O00000Oo().O0000OoO.O00000Oo) {
                if (next.isOwner()) {
                    List<Room> O000000o2 = ggb.O00000Oo().O000000o(next.getId());
                    if (!O000000o2.isEmpty()) {
                        arrayList.addAll(O000000o2);
                    }
                }
            }
            int i = 0;
            while (true) {
                if (i >= (arrayList.isEmpty() ? 0 : arrayList.size())) {
                    break;
                }
                if (room == null || !TextUtils.equals(room.getId(), ((Room) arrayList.get(i)).getId()) || !this.O00000Oo.containsKey(room.getId())) {
                    this.O00000Oo.put(((Room) arrayList.get(i)).getId(), Integer.valueOf(i));
                }
                i++;
            }
            int i2 = 0;
            while (true) {
                if (i2 < (list.isEmpty() ? 0 : list.size())) {
                    if (list.get(i2) instanceof hns) {
                        this.O00000o0.put(hns.class.getName(), Integer.valueOf(i2));
                    } else if (list.get(i2) instanceof hnl) {
                        this.O00000o0.put(hnl.class.getName(), Integer.valueOf(i2));
                    } else if (list.get(i2) instanceof hnt) {
                        this.O00000o0.put(hnt.class.getName(), Integer.valueOf(i2));
                    } else if (list.get(i2) instanceof hno) {
                        this.O00000o0.put(hno.class.getName(), Integer.valueOf(i2));
                    } else if (list.get(i2) instanceof hnr) {
                        this.O00000o0.put(hnr.class.getName(), Integer.valueOf(i2));
                    } else if (list.get(i2) instanceof hnp) {
                        this.O00000o0.put(hnp.class.getName(), Integer.valueOf(i2));
                    } else if ((list.get(i2) instanceof hnq) && ((hnq) list.get(i2)).O00000oo != null) {
                        this.O00000o0.put(((hnq) list.get(i2)).O00000oo.did, Integer.valueOf(i2));
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }

        private int O000000o(Device device, Device device2) {
            if (!this.O00000o0.containsKey(device.did) && !this.O00000o0.containsKey(device2.did)) {
                return 0;
            }
            if (!this.O00000o0.containsKey(device.did) || !this.O00000o0.containsKey(device2.did)) {
                return !this.O00000o0.containsKey(device.did) ? 1 : -1;
            }
            return this.O00000o0.get(device2.did).intValue() - this.O00000o0.get(device.did).intValue();
        }
    }
}

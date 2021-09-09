package com.xiaomi.smarthome.scene.activity;

import _m_j.fnn;
import _m_j.fno;
import _m_j.ftn;
import _m_j.ggb;
import _m_j.gsy;
import _m_j.hig;
import _m_j.hjp;
import _m_j.hod;
import _m_j.hos;
import _m_j.hot;
import _m_j.hou;
import _m_j.hov;
import _m_j.how;
import _m_j.hox;
import _m_j.hoy;
import _m_j.hpa;
import _m_j.hpb;
import _m_j.hpc;
import _m_j.hpf;
import _m_j.hpq;
import _m_j.hrl;
import _m_j.hxi;
import _m_j.izb;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.scene.activity.StartConditionActivityNew;
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
import java.util.Map;

public class StartConditionActivityNew extends BaseActivity {
    private static final String O0000oOO = "com.xiaomi.smarthome.scene.activity.StartConditionActivityNew";

    /* renamed from: O000000o  reason: collision with root package name */
    Context f11097O000000o;
    String O00000Oo;
    O00000o0 O00000o;
    SceneApi.O000OOOo O00000o0;
    List<hos> O00000oO = new ArrayList();
    HashMap<hos, Boolean> O00000oo = new HashMap<>();
    boolean O0000O0o = false;
    int O0000OOo = -1;
    SceneApi.O000000o O0000Oo = null;
    int O0000Oo0 = -1;
    hou O0000OoO = new hou();
    hoy O0000Ooo = new hoy();
    hpc O0000o = new hpc();
    how O0000o0 = new how();
    hpb O0000o00 = new hpb();
    hov O0000o0O = new hov();
    hot O0000o0o = new hot();
    List<Room> O0000oO = new ArrayList();
    hpa O0000oO0 = new hpa();
    private List<DefaultSceneItemSet> O0000oOo;
    private int O0000oo;
    private List<DefaultSceneItemSet> O0000oo0;
    private boolean O0000ooO;
    private int O0000ooo = 0;
    private boolean O00oOooO = false;
    private long O00oOooo = 0;
    public ConditionDeviceFilter filter;
    public MLAlertDialog filterDialog;
    public int indexOfDeviceTitle = -1;
    public LinearLayoutManager linearLayoutManager;
    @BindView(5171)
    Button mBuyButton;
    @BindView(5186)
    View mBuyView;
    @BindView(5291)
    RecyclerView mContentListView;
    public hos mCurrentCondition;
    @BindView(5164)
    ExpandableItemIndicator mItemIndicator;
    @BindView(5826)
    TextView mModuleA3ReturnTransparentTitle;
    public int mRequestId = 0;
    @BindView(6407)
    View topDeviceTitleLayout;
    @BindView(6409)
    View topFilterLayout;

    /* JADX WARNING: Removed duplicated region for block: B:137:0x0377  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x03ef A[SYNTHETIC] */
    public void onCreate(Bundle bundle) {
        List<DefaultSceneItemSet> list;
        boolean z;
        SceneApi.O000000o o000000o;
        Device O000000o2;
        boolean z2;
        boolean z3;
        boolean z4;
        super.onCreate(bundle);
        setContentView((int) R.layout.smarthome_scene_start_condition_v2);
        ButterKnife.bind(this);
        this.f11097O000000o = this;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("extra_default_conditions")) {
                this.O0000oOo = intent.getParcelableArrayListExtra("extra_default_conditions");
            }
            if (intent.hasExtra("extra_default_conditions")) {
                this.O0000oo0 = intent.getParcelableArrayListExtra("extra_exclude_conditions");
            }
            if (intent.hasExtra("from")) {
                this.O0000oo = intent.getIntExtra("from", 0);
            }
            if (intent.hasExtra("from_main_page")) {
                this.O0000ooO = intent.getBooleanExtra("from_main_page", false);
            }
        }
        this.O00000o0 = hpq.O000000o().O00000Oo;
        SceneApi.O000OOOo o000OOOo = this.O00000o0;
        if (o000OOOo == null) {
            finish();
            return;
        }
        this.O00000Oo = o000OOOo.f11131O000000o;
        this.O0000O0o = SmartHomeSceneCreateEditActivity.isNewScene;
        hrl.O000000o().O00000oO = this.O00000oO;
        this.linearLayoutManager = new LinearLayoutManager(this);
        this.mContentListView.setLayoutManager(this.linearLayoutManager);
        this.mContentListView.setOnScrollListener(new RecyclerView.O00oOooO() {
            /* class com.xiaomi.smarthome.scene.activity.StartConditionActivityNew.AnonymousClass1 */

            public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
            }

            public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (StartConditionActivityNew.this.indexOfDeviceTitle >= 0) {
                    int findFirstVisibleItemPosition = StartConditionActivityNew.this.linearLayoutManager.findFirstVisibleItemPosition();
                    if (findFirstVisibleItemPosition >= StartConditionActivityNew.this.indexOfDeviceTitle) {
                        StartConditionActivityNew.this.topFilterLayout.setVisibility(0);
                        StartConditionActivityNew.this.topDeviceTitleLayout.setVisibility(0);
                    } else if (findFirstVisibleItemPosition >= 0 && findFirstVisibleItemPosition < StartConditionActivityNew.this.indexOfDeviceTitle) {
                        StartConditionActivityNew.this.topFilterLayout.setVisibility(8);
                        StartConditionActivityNew.this.topDeviceTitleLayout.setVisibility(8);
                    }
                }
            }
        });
        this.O00000o = new O00000o0();
        this.mContentListView.setAdapter(this.O00000o);
        gsy.O00000Oo(LogType.SCENE, "condition", "initDeviceCondition OnlineDevice size:  " + fno.O000000o().O0000O0o().size());
        gsy.O00000Oo(LogType.SCENE, "condition", "initDeviceCondition CommonOnlineScenes size:  " + hod.O0000OoO().O0000OoO.size());
        ArrayList<Device> arrayList = new ArrayList<>();
        arrayList.addAll(fno.O000000o().O0000O0o().values());
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((Device) arrayList.get(size)).isSubDevice()) {
                arrayList.remove(size);
            }
        }
        for (Device device : arrayList) {
            if (device.isOwner()) {
                List<DefaultSceneItemSet> list2 = this.O0000oo0;
                if (list2 != null && list2.size() > 0) {
                    Iterator<DefaultSceneItemSet> it = this.O0000oo0.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z4 = false;
                            break;
                        }
                        DefaultSceneItemSet next = it.next();
                        if (DeviceFactory.O000000o(device.model, next.O00000Oo) || (next.O00000oO != null && next.O00000oO.equalsIgnoreCase(device.did))) {
                            z4 = true;
                        }
                    }
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
                List<DefaultSceneItemSet> list3 = this.O0000oo0;
                if (list3 != null) {
                    Iterator<DefaultSceneItemSet> it2 = list3.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (DeviceFactory.O000000o(device2.model, it2.next().O00000Oo)) {
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
        if (this.O00000oO.isEmpty()) {
            this.O00oOooO = false;
        } else {
            this.O00oOooO = true;
        }
        this.O00000oO.addAll(0, O000000o(false));
        this.O0000Oo = hpq.O000000o().O00000oO;
        hos hos = null;
        for (int i2 = 0; i2 < this.O00000o0.O0000O0o.size(); i2++) {
            int size2 = this.O00000oO.size() - 1;
            while (true) {
                if (size2 >= 0) {
                    int O000000o5 = this.O00000oO.get(size2).O000000o(this.O00000o0.O0000O0o.get(i2));
                    if (O000000o5 == -2 && (o000000o = this.O0000Oo) != null && o000000o.equals(this.O00000o0.O0000O0o.get(i2))) {
                        hos = this.O00000oO.get(size2);
                        this.O0000OOo = O000000o5;
                        break;
                    } else if (O000000o5 != -1) {
                        SceneApi.O000000o o000000o2 = this.O0000Oo;
                        if (o000000o2 != null && o000000o2.equals(this.O00000o0.O0000O0o.get(i2))) {
                            hos = this.O00000oO.get(size2);
                            this.O0000OOo = O000000o5;
                        } else if (!this.O00000oO.get(size2).O00000oo()) {
                            this.O00000oo.put(this.O00000oO.get(size2), Boolean.FALSE);
                        } else {
                            this.O00000oO.get(size2).O000000o(O000000o5);
                            if (this.O00000oO.get(size2).O00000Oo()) {
                                this.O00000oo.put(this.O00000oO.get(size2), Boolean.FALSE);
                            }
                        }
                    } else {
                        size2--;
                    }
                } else {
                    break;
                }
            }
        }
        if (this.O0000OOo != -1) {
            this.O0000Oo0 = this.O00000o0.O0000O0o.indexOf(this.O0000Oo);
            this.O00000o0.O0000O0o.remove(this.O0000Oo);
            hpq.O000000o().O00000o(this.O00000o0);
        }
        ArrayList arrayList2 = new ArrayList();
        for (int size3 = this.O00000oO.size() - 1; size3 >= 0; size3--) {
            if (this.O00000oO.get(size3).O00000oo()) {
                int i3 = 0;
                while (true) {
                    if (this.O00000oO.get(size3).O00000oO() == null || i3 >= this.O00000oO.get(size3).O00000oO().length) {
                        z = true;
                    } else if (hpq.O000000o().O00000Oo.O0000Ooo == 1 || hpq.O000000o().O000000o(Integer.valueOf(this.O00000oO.get(size3).O00000o0(this.O00000oO.get(size3).O00000oO()[i3])))) {
                        z = false;
                    } else {
                        i3++;
                    }
                    if (!z && this.O00000oO.get(size3).O00000Oo()) {
                        z = true;
                    }
                    if (!z) {
                        this.O00000oo.put(this.O00000oO.get(size3), Boolean.FALSE);
                        arrayList2.add(this.O00000oO.remove(size3));
                    }
                }
                z = false;
                z = true;
                if (!z) {
                }
            } else if (this.O00000oO.get(size3) instanceof hpc) {
                this.O00000oo.put(this.O00000oO.get(size3), Boolean.TRUE);
            } else if (hpq.O000000o().O00000Oo.O0000Ooo == 1 || hpq.O000000o().O000000o(Integer.valueOf(this.O00000oO.get(size3).O00000o0(0)))) {
                this.O00000oo.put(this.O00000oO.get(size3), Boolean.TRUE);
            } else {
                this.O00000oo.put(this.O00000oO.get(size3), Boolean.FALSE);
                arrayList2.add(this.O00000oO.remove(size3));
            }
        }
        this.O00000oO.addAll(arrayList2);
        O000000o(hpq.O000000o().O0000Oo);
        if (this.O0000OOo != -1) {
            gotoDetailPage(hos, false, null);
        }
        if (this.O00000oO.size() != 0 || (list = this.O0000oOo) == null || list.size() <= 0) {
            this.mBuyView.setVisibility(8);
        } else {
            this.mBuyView.setVisibility(0);
            this.mContentListView.setVisibility(8);
            this.mBuyButton.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.StartConditionActivityNew.AnonymousClass2 */

                public final void onClick(View view) {
                    hjp.O000000o("https://home.mi.com/shop/main");
                }
            });
        }
        this.mItemIndicator.setVisibility(8);
        this.mModuleA3ReturnTransparentTitle.setText((int) R.string.smarthome_scene_choose_condition);
        if (this.O0000ooO) {
            hpq.O000000o().O0000Oo = null;
            hot hot = new hot();
            this.O00000o0.O0000O0o.add(hot.O000000o(-1, null));
            addCompatibleId(hot.O00000o0(0));
            finish();
            this.O0000ooO = false;
        }
        if (!this.O00000oO.isEmpty()) {
            O000000o();
            this.filter = new ConditionDeviceFilter(this) {
                /* class com.xiaomi.smarthome.scene.activity.StartConditionActivityNew.AnonymousClass3 */

                public final void O000000o(Home home, DeviceTagInterface.Category category) {
                    if (StartConditionActivityNew.this.isValid() && StartConditionActivityNew.this.filterDialog != null) {
                        StartConditionActivityNew.this.filterConditionByTag(home, category);
                        ((TextView) StartConditionActivityNew.this.topFilterLayout.findViewById(R.id.filter_name)).setText(category.name);
                        StartConditionActivityNew.this.O0000o0O.O00000o = category.name;
                        StartConditionActivityNew.this.O00000o.notifyDataSetChanged();
                        StartConditionActivityNew.this.filterDialog.dismiss();
                    }
                }

                public final void O000000o(Home home, Room room) {
                    if (StartConditionActivityNew.this.isValid() && StartConditionActivityNew.this.filterDialog != null) {
                        if (room == null || !TextUtils.equals("ALL_ROOM", room.getId())) {
                            StartConditionActivityNew.this.filterConditionByRoom(home, room);
                        } else {
                            StartConditionActivityNew.this.filterConditionByHome(home);
                        }
                        ((TextView) StartConditionActivityNew.this.topFilterLayout.findViewById(R.id.filter_name)).setText(room.getName());
                        StartConditionActivityNew.this.O0000o0O.O00000o = room.getName();
                        StartConditionActivityNew.this.O00000o.notifyDataSetChanged();
                        StartConditionActivityNew.this.filterDialog.dismiss();
                    }
                }

                public final void O000000o(Home home) {
                    if (StartConditionActivityNew.this.isValid() && StartConditionActivityNew.this.filterDialog != null) {
                        StartConditionActivityNew.this.filterConditionByHome(home);
                        ((TextView) StartConditionActivityNew.this.topFilterLayout.findViewById(R.id.filter_name)).setText((int) R.string.tag_all);
                        StartConditionActivityNew.this.O0000o0O.O00000o = null;
                        StartConditionActivityNew.this.O00000o.notifyDataSetChanged();
                    }
                }

                public final int O000000o(String str, Room room) {
                    return StartConditionActivityNew.this.getConditionCountByRoom(str, room);
                }

                public final int O000000o(String str, DeviceTagInterface.Category category) {
                    return StartConditionActivityNew.this.getConditionCountByTag(str, category);
                }
            };
            this.filterDialog = this.filter.O000000o();
            this.filter.O00000Oo();
        }
        this.topFilterLayout.setOnClickListener(null);
        this.topFilterLayout.findViewById(R.id.tv_group_filter).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.StartConditionActivityNew.AnonymousClass4 */

            public final void onClick(View view) {
                if (StartConditionActivityNew.this.filter != null) {
                    StartConditionActivityNew.this.filter.O00000o0();
                }
            }
        });
    }

    private void O000000o() {
        this.O0000oO.clear();
        Room room = new Room();
        room.setName(getString(R.string.smarthome_scene_all_room));
        room.setId("ALL_ROOM");
        this.O0000oO.add(room);
        List<Room> O00000o2 = ggb.O00000Oo().O00000o();
        if (O00000o2 != null) {
            for (int i = 0; i < O00000o2.size(); i++) {
                Room room2 = O00000o2.get(i);
                if (getConditionCountByRoom(ggb.O00000Oo().O0000OOo(), room2) > 0) {
                    this.O0000oO.add(room2);
                }
            }
        }
        Room room3 = new Room();
        room3.setName(getString(R.string.tag_recommend_defaultroom));
        room3.setId("DEFAULT_ROOM");
        if (getConditionCountByRoom(ggb.O00000Oo().O0000OOo(), room3) > 0) {
            this.O0000oO.add(room3);
        }
    }

    public int getConditionCountByTag(String str, DeviceTagInterface.Category category) {
        if (TextUtils.isEmpty(str) || category == null) {
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
        for (int i = 0; i < this.O00000oO.size(); i++) {
            hos hos = this.O00000oO.get(i);
            if (O000000o(hos) && hos.O00000o0() != null && hashSet.contains(hos.O00000o0().did)) {
                return 1;
            }
        }
        return 0;
    }

    public int getConditionCountByRoom(String str, Room room) {
        if (TextUtils.isEmpty(str) || room == null) {
            return 0;
        }
        if (room.getId().equalsIgnoreCase("ALL_ROOM")) {
            return this.O00000oO.size();
        }
        if (room.getId().equalsIgnoreCase("DEFAULT_ROOM")) {
            List<Device> O0000OOo2 = ggb.O00000Oo().O0000OOo(str);
            if (O0000OOo2.isEmpty()) {
                return 0;
            }
            HashSet hashSet = new HashSet(O0000OOo2);
            int i = 0;
            while (i < this.O00000oO.size()) {
                hos hos = this.O00000oO.get(i);
                if (!O000000o(hos) || hos.O00000o0() == null || !hashSet.contains(hos.O00000o0())) {
                    i++;
                }
            }
            return 0;
        }
        List<String> dids = room.getDids();
        if (dids.isEmpty()) {
            return 0;
        }
        HashSet hashSet2 = new HashSet(dids);
        int i2 = 0;
        while (i2 < this.O00000oO.size()) {
            hos hos2 = this.O00000oO.get(i2);
            if (!O000000o(hos2) || hos2.O00000o0() == null || !hashSet2.contains(hos2.O00000o0().did)) {
                i2++;
            }
        }
        return 0;
        return 1;
    }

    public void filterConditionByTag(Home home, DeviceTagInterface.Category category) {
        if (home == null) {
            this.O00000o.O000000o(this.O00000oO);
        } else if (category == null) {
            filterConditionByHome(home);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(O000000o(true));
            Map<String, List<String>> O0000Oo2 = fnn.O000000o().O00000Oo().O0000Oo(home.getId());
            if (O0000Oo2.isEmpty()) {
                filterConditionByHome(home);
                return;
            }
            List list = O0000Oo2.get(category.name);
            if (list.isEmpty()) {
                filterConditionByHome(home);
                return;
            }
            HashSet hashSet = new HashSet(list);
            for (int i = 0; i < this.O00000oO.size(); i++) {
                hos hos = this.O00000oO.get(i);
                if (O000000o(hos) && hos.O00000o0() != null && hashSet.contains(hos.O00000o0().did)) {
                    arrayList.add(hos);
                }
            }
            this.O00000o.O000000o(arrayList);
        }
    }

    public void filterConditionByHome(Home home) {
        if (home == null) {
            this.O00000o.O000000o(this.O00000oO);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(O000000o(true));
        List<String> O000000o2 = ggb.O00000Oo().O000000o(home.getId(), true);
        if (O000000o2.isEmpty()) {
            this.O00000o.O000000o(this.O00000oO);
        }
        HashSet hashSet = new HashSet();
        if (!O000000o2.isEmpty()) {
            hashSet.addAll(O000000o2);
        }
        for (int i = 0; i < this.O00000oO.size(); i++) {
            hos hos = this.O00000oO.get(i);
            if (O000000o(hos) && hos.O00000o0() != null && hashSet.contains(hos.O00000o0().did)) {
                arrayList.add(hos);
            }
        }
        this.O00000o.O000000o(arrayList);
    }

    public void filterConditionByRoom(Home home, Room room) {
        if (home == null) {
            this.O00000o.O000000o(this.O00000oO);
        } else if (room == null) {
            filterConditionByHome(home);
        } else {
            int i = 0;
            if (room.getId().equalsIgnoreCase("DEFAULT_ROOM")) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(O000000o(true));
                List<Device> O0000O0o2 = ggb.O00000Oo().O0000O0o(home.getId());
                if (O0000O0o2.isEmpty()) {
                    filterConditionByHome(home);
                    return;
                }
                HashSet hashSet = new HashSet(O0000O0o2);
                while (i < this.O00000oO.size()) {
                    hos hos = this.O00000oO.get(i);
                    if (O000000o(hos) && hos.O00000o0() != null && hashSet.contains(hos.O00000o0())) {
                        arrayList.add(hos);
                    }
                    i++;
                }
                this.O00000o.O000000o(arrayList);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(O000000o(true));
            List<String> dids = room.getDids();
            if (dids.isEmpty()) {
                filterConditionByHome(home);
                return;
            }
            HashSet hashSet2 = new HashSet(dids);
            while (i < this.O00000oO.size()) {
                hos hos2 = this.O00000oO.get(i);
                if (O000000o(hos2) && hos2.O00000o0() != null && hashSet2.contains(hos2.O00000o0().did)) {
                    arrayList2.add(hos2);
                }
                i++;
            }
            this.O00000o.O000000o(arrayList2);
            this.O00000o.notifyDataSetChanged();
        }
    }

    private List<hos> O000000o(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(this.O0000OoO);
        }
        if (this.O00000o0.O0000O0o.size() <= 0 && !O00000Oo() && this.O0000oo != 1) {
            arrayList.add(this.O0000o0o);
        }
        arrayList.add(this.O0000o00);
        if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            arrayList.add(this.O0000o);
        }
        if (hpf.O000000o().O00000o0()) {
            arrayList.add(this.O0000o0);
        }
        if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && this.O0000oo != 1 && hig.O00000oo() && this.O00000o0.O00000oo.size() == 0 && this.O00000o0.O0000O0o.size() == 0) {
            arrayList.add(this.O0000oO0);
        }
        if (z) {
            arrayList.add(this.O0000Ooo);
        }
        if (this.O00oOooO) {
            arrayList.add(this.O0000o0O);
            this.indexOfDeviceTitle = arrayList.size() - 2;
        } else {
            this.indexOfDeviceTitle = -1;
        }
        return arrayList;
    }

    private boolean O00000Oo() {
        SceneApi.O000OOOo o000OOOo = this.O00000o0;
        if (!(o000OOOo == null || o000OOOo.O00000oo == null)) {
            for (int i = 0; i < this.O00000o0.O00000oo.size(); i++) {
                SceneApi.Action action = this.O00000o0.O00000oo.get(i);
                if (action.O0000O0o != null && (action.O0000O0o instanceof SceneApi.O000O00o)) {
                    return true;
                }
            }
        }
        return false;
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
        if (arrayList.size() == 0) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(O000000o(true));
            for (int i = 0; i < this.O00000oO.size(); i++) {
                if (O000000o(this.O00000oO.get(i))) {
                    arrayList2.add(this.O00000oO.get(i));
                }
            }
            this.O00000o.O000000o(arrayList2);
            this.O00000oO.clear();
            this.O00000oO.addAll(arrayList2);
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(O000000o(true));
        int i2 = 0;
        while (true) {
            if (i2 < (this.O00000oO.isEmpty() ? 0 : this.O00000oO.size())) {
                if (O000000o(this.O00000oO.get(i2))) {
                    arrayList3.add(this.O00000oO.get(i2));
                }
                i2++;
            } else {
                Collections.sort(arrayList3, new O000000o(room, arrayList3));
                this.O00000oO.clear();
                this.O00000oO.addAll(arrayList3);
                this.O00000o.O000000o(this.O00000oO);
                return;
            }
        }
    }

    private static boolean O000000o(hos hos) {
        return hos instanceof hox;
    }

    public void gotoDetailPage(hos hos, boolean z, String str) {
        Intent intent = new Intent();
        intent.setClass(this, SmartHomeSceneDetailActivity.class);
        int i = this.O0000OOo;
        if (i != -1) {
            if (i == -2) {
                intent.putExtra("extra_selected_title", -1);
            } else {
                intent.putExtra("extra_selected_title", i);
            }
        }
        if (z && !TextUtils.isEmpty(str)) {
            intent.putExtra("extra_selected_did", str);
        }
        intent.putExtra("extra_title", hos.O00000o());
        this.O00oOooo = System.currentTimeMillis();
        startActivityForResult(intent, 100);
        hpq.O000000o().O000000o(hos);
        this.mCurrentCondition = hos;
    }

    public void onActivityResult(final int i, final Intent intent) {
        this.mHandler.post(new Runnable() {
            /* class com.xiaomi.smarthome.scene.activity.StartConditionActivityNew.AnonymousClass5 */

            public final void run() {
                if (i == -1) {
                    if (StartConditionActivityNew.this.O0000OOo != -1) {
                        StartConditionActivityNew.this.O00000o0.O0000O0o.remove(StartConditionActivityNew.this.O0000Oo);
                    }
                    if (StartConditionActivityNew.this.mRequestId >= 0 && StartConditionActivityNew.this.mRequestId < StartConditionActivityNew.this.mCurrentCondition.O00000oO().length) {
                        SceneApi.O000000o O000000o2 = StartConditionActivityNew.this.mCurrentCondition.O000000o(StartConditionActivityNew.this.mCurrentCondition.O00000oO()[StartConditionActivityNew.this.mRequestId], intent);
                        StartConditionActivityNew.this.O00000o0.O0000O0o.add(O000000o2);
                        hpq.O000000o().O000000o(O000000o2);
                        StartConditionActivityNew startConditionActivityNew = StartConditionActivityNew.this;
                        startConditionActivityNew.addCompatibleId(startConditionActivityNew.mCurrentCondition.O00000o0(StartConditionActivityNew.this.mCurrentCondition.O00000oO()[StartConditionActivityNew.this.mRequestId]));
                    }
                    StartConditionActivityNew.this.finish();
                } else if (StartConditionActivityNew.this.O0000OOo != -1) {
                    StartConditionActivityNew.this.O00000o0.O0000O0o.add(StartConditionActivityNew.this.O0000Oo0, StartConditionActivityNew.this.O0000Oo);
                    hpq.O000000o().O000000o(StartConditionActivityNew.this.O0000Oo);
                    if (StartConditionActivityNew.this.O0000Oo.O0000Ooo != 0) {
                        StartConditionActivityNew startConditionActivityNew2 = StartConditionActivityNew.this;
                        startConditionActivityNew2.addCompatibleId(startConditionActivityNew2.O0000Oo.O0000Ooo);
                    }
                    StartConditionActivityNew.this.finish();
                } else {
                    StartConditionActivityNew startConditionActivityNew3 = StartConditionActivityNew.this;
                    startConditionActivityNew3.mRequestId = 0;
                    startConditionActivityNew3.mCurrentCondition = null;
                    startConditionActivityNew3.O00000o.notifyDataSetChanged();
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
                    hos hos = this.mCurrentCondition;
                    if (!(hos == null || hos.O00000oO() == null || this.mCurrentCondition.O00000oO().length <= 0)) {
                        hos hos2 = this.mCurrentCondition;
                        int O000000o2 = hos2.O000000o(hos2.O00000oO()[intExtra], this, this.O0000Oo);
                        if (O000000o2 >= 0) {
                            this.mRequestId = intExtra;
                            this.O0000ooo = O000000o2;
                            hpq.O000000o().O00000Oo(this.mCurrentCondition.O000000o(intExtra, null));
                        } else if (O000000o2 == -1) {
                            finish();
                        } else if (O000000o2 != -99) {
                            if (this.O0000Oo0 == -1) {
                                this.O0000Oo0 = this.O00000o0.O0000O0o.size();
                            }
                            List<SceneApi.O000000o> list = this.O00000o0.O0000O0o;
                            int i3 = this.O0000Oo0;
                            hos hos3 = this.mCurrentCondition;
                            list.add(i3, hos3.O000000o(hos3.O00000oO()[intExtra], null));
                            hos hos4 = this.mCurrentCondition;
                            addCompatibleId(hos4.O00000o0(hos4.O00000oO()[intExtra]));
                            finish();
                        } else if (this.O0000OOo != -1) {
                            if (this.O0000Oo != null) {
                                if (this.O0000Oo0 == -1) {
                                    this.O00000o0.O0000O0o.add(0, this.O0000Oo);
                                } else {
                                    this.O00000o0.O0000O0o.add(this.O0000Oo0, this.O0000Oo);
                                }
                                addCompatibleId(this.O0000Oo.O0000Ooo);
                            }
                            finish();
                        }
                    }
                    hxi.O00000o.O00000Oo("condition", System.currentTimeMillis() - this.O00oOooo);
                    return;
                }
                finish();
            } else if (this.O0000OOo != -1) {
                if (this.O0000Oo != null) {
                    if (this.O0000Oo0 == -1) {
                        this.O00000o0.O0000O0o.add(0, this.O0000Oo);
                    } else {
                        this.O00000o0.O0000O0o.add(this.O0000Oo0, this.O0000Oo);
                    }
                    addCompatibleId(this.O0000Oo.O0000Ooo);
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
        } else if (i == 106 && i2 == -1) {
            hpc hpc = hpq.O000000o().O0000OoO;
            if (hpc != null) {
                SceneApi.O000000o O000000o3 = hpc.O000000o(hpc.O00000o, null);
                this.O00000o0.O0000O0o.add(O000000o3);
                addCompatibleId(O000000o3.O0000Ooo);
                finish();
                hpq.O000000o().O0000OoO = null;
            }
        } else if (i == this.O0000ooo) {
            onActivityResult(i2, intent);
        }
    }

    @OnClick({5822})
    public void close() {
        if (SmarthomeCreateAutoSceneActivity.mIsInitStep) {
            hpq.O000000o().O0000Oo0 = 3;
        }
        finish();
    }

    class O00000o0 extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
        private List<hos> O00000Oo = new ArrayList();
        private LayoutInflater O00000o0;

        public final long getItemId(int i) {
            return (long) i;
        }

        public O00000o0() {
            this.O00000o0 = StartConditionActivityNew.this.getLayoutInflater();
        }

        public final void O000000o(List<hos> list) {
            this.O00000Oo.clear();
            if (!list.isEmpty()) {
                this.O00000Oo.addAll(list);
            }
            StartConditionActivityNew.this.mContentListView.stopScroll();
            StartConditionActivityNew.this.mContentListView.getRecycledViewPool().O000000o();
            notifyDataSetChanged();
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
                return new O0000OOo(this.O00000o0.inflate((int) R.layout.create_scene_common_title_layout, viewGroup, false));
            }
            if (i == 2) {
                return new O00000Oo(this.O00000o0.inflate((int) R.layout.create_scene_common_selection_layout, viewGroup, false));
            }
            if (i == 3) {
                return new O00000o(this.O00000o0.inflate((int) R.layout.create_scene_device_selection_layout, viewGroup, false));
            }
            if (i != 4) {
                return null;
            }
            return new O0000OOo(this.O00000o0.inflate((int) R.layout.create_scene_device_title_layout, viewGroup, false));
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            String str;
            int itemViewType = getItemViewType(i);
            if (!this.O00000Oo.isEmpty() && i < this.O00000Oo.size() && i >= 0) {
                hos hos = this.O00000Oo.get(i);
                if (itemViewType != 0) {
                    boolean z = true;
                    if (itemViewType != 1) {
                        if (itemViewType != 2) {
                            if (itemViewType != 3) {
                                if (itemViewType != 4) {
                                    return;
                                }
                            } else if ((o000OOo0 instanceof O00000o) && (hos instanceof hox)) {
                                ((O00000o) o000OOo0).O000000o((hox) hos, i);
                                return;
                            } else {
                                return;
                            }
                        } else if (o000OOo0 instanceof O00000Oo) {
                            int i2 = i + 1;
                            if (i2 > 0 && i2 < getItemCount() && getItemViewType(i2) == 4) {
                                z = false;
                            }
                            if (hos instanceof hot) {
                                ((O00000Oo) o000OOo0).O000000o(hos, z);
                                return;
                            } else if (hos instanceof hpb) {
                                ((O00000Oo) o000OOo0).O000000o(hos, z);
                                return;
                            } else if (hos instanceof hpc) {
                                ((O00000Oo) o000OOo0).O000000o(hos, z);
                                return;
                            } else if (hos instanceof how) {
                                ((O00000Oo) o000OOo0).O000000o(hos, z);
                                return;
                            } else if (hos instanceof hpa) {
                                ((O00000Oo) o000OOo0).O000000o(hos, z);
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
                if ((o000OOo0 instanceof O0000O0o) && (hos instanceof hov)) {
                    O0000O0o o0000O0o = (O0000O0o) o000OOo0;
                    hov hov = (hov) hos;
                    if (hov != null) {
                        if (TextUtils.isEmpty(hov.O00000o)) {
                            str = ServiceApplication.getAppContext().getString(R.string.smarthome_scene_all);
                        } else {
                            str = hov.O00000o;
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
            List<hos> list = this.O00000Oo;
            if (list != null && i < list.size()) {
                if (this.O00000Oo.get(i) instanceof hou) {
                    return 1;
                }
                if (this.O00000Oo.get(i) instanceof hoy) {
                    return 4;
                }
                if (this.O00000Oo.get(i) instanceof hov) {
                    return 0;
                }
                if (this.O00000Oo.get(i) instanceof hox) {
                    return 3;
                }
                if ((this.O00000Oo.get(i) instanceof hot) || (this.O00000Oo.get(i) instanceof hpb) || (this.O00000Oo.get(i) instanceof hpc) || (this.O00000Oo.get(i) instanceof how) || (this.O00000Oo.get(i) instanceof hpa)) {
                    return 2;
                }
            }
            return super.getItemViewType(i);
        }
    }

    class O0000O0o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        View f11107O000000o;
        TextView O00000Oo;

        public O0000O0o(View view) {
            super(view);
            this.f11107O000000o = view.findViewById(R.id.tv_group_filter);
            this.O00000Oo = (TextView) view.findViewById(R.id.filter_name);
            this.f11107O000000o.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.$$Lambda$StartConditionActivityNew$O0000O0o$qW4JiocLiQdWZW6iOxJULpX8Ow */

                public final void onClick(View view) {
                    StartConditionActivityNew.O0000O0o.this.O000000o(view);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(View view) {
            StartConditionActivityNew.this.filter.O00000o0();
        }
    }

    class O0000OOo extends RecyclerView.O000OOo0 {
        public O0000OOo(View view) {
            super(view);
        }
    }

    class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f11104O000000o;
        public SimpleDraweeView O00000Oo;
        public View O00000o;
        public ImageView O00000o0;

        public O00000Oo(View view) {
            super(view);
            this.f11104O000000o = (TextView) view.findViewById(R.id.condition_name);
            this.O00000Oo = (SimpleDraweeView) view.findViewById(R.id.content_icon);
            this.O00000o0 = (ImageView) view.findViewById(R.id.expand_hint);
            this.O00000o = view.findViewById(R.id.item_divider);
        }

        public final void O000000o(hos hos, boolean z) {
            if (hos != null) {
                this.O00000o.setVisibility(z ? 0 : 8);
                String O00000o2 = hos.O00000o();
                TextView textView = this.f11104O000000o;
                if (TextUtils.isEmpty(O00000o2)) {
                    O00000o2 = "";
                }
                textView.setText(O00000o2);
                StartConditionActivityNew.this.setIconByCondition(hos, this.O00000Oo);
                if (StartConditionActivityNew.this.setLockByCondition(hos, this.O00000o0)) {
                    this.itemView.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.$$Lambda$StartConditionActivityNew$O00000Oo$twmwt4ikOYxOPJ7Z24QVz8TSWYM */

                        public final void onClick(View view) {
                            StartConditionActivityNew.O00000Oo.this.O000000o(view);
                        }
                    });
                } else {
                    this.itemView.setOnClickListener(new View.OnClickListener(hos) {
                        /* class com.xiaomi.smarthome.scene.activity.$$Lambda$StartConditionActivityNew$O00000Oo$lV3cYlaPMPVkHBYRb12qiQxShO0 */
                        private final /* synthetic */ hos f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onClick(View view) {
                            StartConditionActivityNew.O00000Oo.this.O000000o(this.f$1, view);
                        }
                    });
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(View view) {
            izb.O000000o(StartConditionActivityNew.this.f11097O000000o, (int) R.string.scene_unclickable_toast_2, 0).show();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(hos hos, View view) {
            if (hos.O00000oo()) {
                hpq.O000000o().O00000o0();
                StartConditionActivityNew.this.gotoDetailPage(hos, false, null);
            } else if (hos instanceof hpc) {
                hpq.O000000o().O0000OoO = new hpc();
                StartConditionActivityNew.this.startActivityForResult(new Intent(StartConditionActivityNew.this.f11097O000000o, SmarthomeChooseWeatherConditionActivity.class), 106);
            } else {
                hpq.O000000o().O0000Oo = null;
                StartConditionActivityNew startConditionActivityNew = StartConditionActivityNew.this;
                startConditionActivityNew.mRequestId = hos.O000000o(-1, startConditionActivityNew, startConditionActivityNew.O0000Oo);
                if (StartConditionActivityNew.this.mRequestId != -1) {
                    StartConditionActivityNew.this.mCurrentCondition = hos;
                    hpq.O000000o().O00000Oo(StartConditionActivityNew.this.mCurrentCondition.O000000o(-1, null));
                    return;
                }
                if (hos instanceof hpa) {
                    hxi.O00000o.f952O000000o.O000000o("NFC_add_click", new Object[0]);
                }
                StartConditionActivityNew.this.O00000o0.O0000O0o.add(hos.O000000o(-1, null));
                StartConditionActivityNew.this.addCompatibleId(hos.O00000o0(0));
                StartConditionActivityNew.this.finish();
            }
        }
    }

    public void setIconByCondition(hos hos, SimpleDraweeView simpleDraweeView) {
        if (simpleDraweeView != null) {
            simpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(simpleDraweeView.getResources()).setFadeDuration(200).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build());
            hos.O000000o(simpleDraweeView);
        }
    }

    public boolean setLockByCondition(hos hos, ImageView imageView) {
        if (imageView == null) {
            return false;
        }
        if (!this.O00000oo.containsKey(hos) || this.O00000oo.get(hos).booleanValue()) {
            imageView.setImageResource(R.drawable.std_list_main_next);
            return false;
        }
        imageView.setImageResource(R.drawable.std_scene_icon_lock);
        return true;
    }

    class O00000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f11105O000000o;
        public TextView O00000Oo;
        public ImageView O00000o;
        public SimpleDraweeView O00000o0;
        public TextView O00000oO;

        public O00000o(View view) {
            super(view);
            this.f11105O000000o = (TextView) view.findViewById(R.id.device_name);
            this.O00000Oo = (TextView) view.findViewById(R.id.room_name);
            this.O00000oO = (TextView) view.findViewById(R.id.offline_tv);
            this.O00000o0 = (SimpleDraweeView) view.findViewById(R.id.content_icon);
            this.O00000o = (ImageView) view.findViewById(R.id.expand_hint);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x007b  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x008a  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0095  */
        public final void O000000o(hox hox, int i) {
            String str;
            boolean z;
            if (hox != null) {
                this.O00000oO.setVisibility(0);
                Device O00000o02 = fno.O000000o().O00000o0(hox.O00000o0().did);
                if (O00000o02 == null) {
                    this.O00000oO.setText((int) R.string.samrthome_scene_device_off_line);
                } else if (hpq.O000000o().O000000o(O00000o02.did)) {
                    this.O00000oO.setText((int) R.string.scene_has_selected);
                    str = O00000o02.did;
                    z = true;
                    this.O00000Oo.setText(StartConditionActivityNew.this.getContentDesc(hox));
                    StartConditionActivityNew.this.setIconByCondition(hox, this.O00000o0);
                    String str2 = "";
                    if (O00000o02 == null) {
                        TextView textView = this.f11105O000000o;
                        if (!TextUtils.isEmpty(O00000o02.getName())) {
                            str2 = O00000o02.getName();
                        }
                        textView.setText(str2);
                    } else {
                        this.f11105O000000o.setText(str2);
                    }
                    if (!StartConditionActivityNew.this.setLockByCondition(hox, this.O00000o)) {
                        this.itemView.setOnClickListener(new View.OnClickListener() {
                            /* class com.xiaomi.smarthome.scene.activity.$$Lambda$StartConditionActivityNew$O00000o$B3Yiml7w42cAECHEJOuaebUSgFE */

                            public final void onClick(View view) {
                                StartConditionActivityNew.O00000o.this.O000000o(view);
                            }
                        });
                        return;
                    } else {
                        this.itemView.setOnClickListener(new View.OnClickListener(hox, z, str, i) {
                            /* class com.xiaomi.smarthome.scene.activity.$$Lambda$StartConditionActivityNew$O00000o$AXifNRUp87_3dF4xSU58CESwtc */
                            private final /* synthetic */ hox f$1;
                            private final /* synthetic */ boolean f$2;
                            private final /* synthetic */ String f$3;
                            private final /* synthetic */ int f$4;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                                this.f$3 = r4;
                                this.f$4 = r5;
                            }

                            public final void onClick(View view) {
                                StartConditionActivityNew.O00000o.this.O000000o(this.f$1, this.f$2, this.f$3, this.f$4, view);
                            }
                        });
                        return;
                    }
                } else if (!O00000o02.isOnline) {
                    this.O00000oO.setText((int) R.string.samrthome_scene_device_off_line);
                } else {
                    this.O00000oO.setVisibility(8);
                }
                str = null;
                z = false;
                this.O00000Oo.setText(StartConditionActivityNew.this.getContentDesc(hox));
                StartConditionActivityNew.this.setIconByCondition(hox, this.O00000o0);
                String str22 = "";
                if (O00000o02 == null) {
                }
                if (!StartConditionActivityNew.this.setLockByCondition(hox, this.O00000o)) {
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(View view) {
            izb.O000000o(StartConditionActivityNew.this.f11097O000000o, (int) R.string.scene_unclickable_toast_2, 0).show();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(hox hox, boolean z, String str, int i, View view) {
            if (hox.O00000oo()) {
                hpq.O000000o().O00000o0();
                StartConditionActivityNew.this.gotoDetailPage(hox, z, str);
                return;
            }
            hpq.O000000o().O0000Oo = null;
            StartConditionActivityNew startConditionActivityNew = StartConditionActivityNew.this;
            startConditionActivityNew.mRequestId = hox.O000000o(-1, startConditionActivityNew, startConditionActivityNew.O0000Oo);
            if (StartConditionActivityNew.this.mRequestId != -1) {
                StartConditionActivityNew.this.mCurrentCondition = hox;
                hpq.O000000o().O00000Oo(StartConditionActivityNew.this.mCurrentCondition.O000000o(i, null));
                return;
            }
            StartConditionActivityNew.this.O00000o0.O0000O0o.add(hox.O000000o(-1, (Intent) null));
            StartConditionActivityNew.this.addCompatibleId(hox.O00000o0(0));
            StartConditionActivityNew.this.finish();
        }
    }

    public String getContentDesc(hos hos) {
        if (!(hos instanceof hox)) {
            return "";
        }
        String string = getString(R.string.room_default);
        Room room = null;
        hox hox = (hox) hos;
        if (hox.O00000o != null) {
            room = ggb.O00000Oo().O0000o00(hox.O00000o.O00000Oo);
        }
        return room != null ? room.getName() : string;
    }

    public void onResume() {
        super.onResume();
    }

    public void addCompatibleId(int i) {
        if (hpq.O000000o().O000000o(Integer.valueOf(i))) {
            hpq.O000000o().O000000o(hod.O0000OoO().O000000o(i));
            hpq.O000000o().O00000Oo(hod.O0000OoO().O00000Oo(i));
            return;
        }
        hpq.O000000o().O00000Oo();
    }

    public void onBackPressed() {
        if (SmarthomeCreateAutoSceneActivity.mIsInitStep) {
            hpq.O000000o().O0000Oo0 = 3;
        }
        super.onBackPressed();
    }

    class O000000o implements Comparator<hos> {
        private Map<String, Integer> O00000Oo = new HashMap();
        private Map<String, Integer> O00000o0 = new HashMap();

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            hos hos = (hos) obj;
            hos hos2 = (hos) obj2;
            boolean z = hos instanceof hox;
            int i = 0;
            if (z && (hos2 instanceof hox)) {
                Device O00000o02 = hos.O00000o0();
                Device O00000o03 = hos2.O00000o0();
                if (O00000o02 == null && O00000o03 == null) {
                    return 0;
                }
                if (O00000o02 == null || O00000o03 == null) {
                    return O00000o02 == null ? 1 : -1;
                }
                int i2 = (O00000o03.isOnline ? 1 : 0) - (O00000o02.isOnline ? 1 : 0);
                if (i2 != 0) {
                    return i2;
                }
                Room O0000o00 = ggb.O00000Oo().O0000o00(O00000o02.did);
                Room O0000o002 = ggb.O00000Oo().O0000o00(O00000o03.did);
                if (O0000o00 == null && O0000o002 == null) {
                    return O000000o(O00000o02, O00000o03);
                }
                if (O0000o00 == null || O0000o002 == null) {
                    return O0000o00 == null ? 1 : -1;
                }
                if (this.O00000Oo.containsKey(O0000o00.getId()) || this.O00000Oo.containsKey(O0000o002.getId())) {
                    if (!this.O00000Oo.containsKey(O0000o00.getId()) || !this.O00000Oo.containsKey(O0000o002.getId())) {
                        i = !this.O00000Oo.containsKey(O0000o00.getId()) ? 1 : -1;
                    } else {
                        i = this.O00000Oo.get(O0000o002.getId()).intValue() - this.O00000Oo.get(O0000o00.getId()).intValue();
                    }
                }
                return i != 0 ? i : O000000o(O00000o02, O00000o03);
            } else if (z || (hos2 instanceof hox)) {
                return z ? 1 : -1;
            } else {
                if (this.O00000o0.get(hos.getClass().getName()) == null || this.O00000o0.get(hos2.getClass().getName()) == null) {
                    return this.O00000o0.get(hos.getClass().getName()) != null ? 1 : 0;
                }
                return this.O00000o0.get(hos.getClass().getName()).intValue() - this.O00000o0.get(hos2.getClass().getName()).intValue();
            }
        }

        public O000000o(Room room, List<hos> list) {
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
                    if (list.get(i2) instanceof hou) {
                        this.O00000o0.put(hou.class.getName(), Integer.valueOf(i2));
                    } else if (list.get(i2) instanceof hot) {
                        this.O00000o0.put(hot.class.getName(), Integer.valueOf(i2));
                    } else if (list.get(i2) instanceof hpb) {
                        this.O00000o0.put(hpb.class.getName(), Integer.valueOf(i2));
                    } else if (list.get(i2) instanceof hpc) {
                        this.O00000o0.put(hpc.class.getName(), Integer.valueOf(i2));
                    } else if (list.get(i2) instanceof hoy) {
                        this.O00000o0.put(hoy.class.getName(), Integer.valueOf(i2));
                    } else if (list.get(i2) instanceof hov) {
                        this.O00000o0.put(hov.class.getName(), Integer.valueOf(i2));
                    } else if ((list.get(i2) instanceof hox) && list.get(i2).O00000o0() != null) {
                        this.O00000o0.put(list.get(i2).O00000o0().did, Integer.valueOf(i2));
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

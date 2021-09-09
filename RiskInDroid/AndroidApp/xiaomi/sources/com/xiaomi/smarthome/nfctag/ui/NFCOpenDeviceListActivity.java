package com.xiaomi.smarthome.nfctag.ui;

import _m_j.fnn;
import _m_j.fno;
import _m_j.ggb;
import _m_j.ggd;
import _m_j.gge;
import _m_j.hig;
import _m_j.hiv;
import _m_j.hte;
import _m_j.hxi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.miio.device.PhoneIRDevice;
import com.xiaomi.smarthome.scene.widget.ConditionDeviceFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class NFCOpenDeviceListActivity extends BaseActivity {
    private static final String O00000oO = "com.xiaomi.smarthome.nfctag.ui.NFCOpenDeviceListActivity";

    /* renamed from: O000000o  reason: collision with root package name */
    Context f10444O000000o;
    List<Device> O00000Oo = new ArrayList();
    MLAlertDialog O00000o;
    ConditionDeviceFilter O00000o0;
    private LinearLayoutManager O00000oo;
    @BindView(5088)
    RecyclerView mContentListView;
    @BindView(5075)
    RelativeLayout mEmptyView;
    public O000000o mListAdapter;
    @BindView(5484)
    TextView mModuleA3ReturnTransparentTitle;
    @BindView(5959)
    View topDeviceTitleLayout;
    @BindView(5961)
    View topFilterLayout;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_nfc_open_device_list);
        hxi.O00000oO.f958O000000o.O000000o("NFC_plugin_list", new Object[0]);
        this.f10444O000000o = this;
        ButterKnife.bind(this);
        this.mModuleA3ReturnTransparentTitle.setText((int) R.string.nfc_trigger_open_device_action);
        this.O00000oo = new LinearLayoutManager(this);
        this.mContentListView.setLayoutManager(this.O00000oo);
        this.mListAdapter = new O000000o();
        this.mContentListView.setAdapter(this.mListAdapter);
        this.O00000Oo.clear();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(fno.O000000o().O0000O0o().values());
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (!((Device) arrayList.get(size)).isOwner() || gge.O000000o((Device) arrayList.get(size)) || (arrayList.get(size) instanceof PhoneIRDevice)) {
                arrayList.remove(size);
            }
        }
        this.O00000Oo.addAll(arrayList);
        O000000o();
        if (this.O00000Oo.size() == 0) {
            this.mEmptyView.setVisibility(0);
            this.topFilterLayout.setVisibility(8);
            this.topDeviceTitleLayout.setVisibility(8);
            this.mContentListView.setVisibility(8);
        } else {
            this.mEmptyView.setVisibility(8);
            this.topFilterLayout.setVisibility(0);
            this.topDeviceTitleLayout.setVisibility(0);
        }
        if (!this.O00000Oo.isEmpty()) {
            this.O00000o0 = new ConditionDeviceFilter(this) {
                /* class com.xiaomi.smarthome.nfctag.ui.NFCOpenDeviceListActivity.AnonymousClass1 */

                public final void O000000o(Home home, DeviceTagInterface.Category category) {
                    if (NFCOpenDeviceListActivity.this.isValid() && NFCOpenDeviceListActivity.this.O00000o != null) {
                        NFCOpenDeviceListActivity.this.filterActionByTag(home, category);
                        ((TextView) NFCOpenDeviceListActivity.this.topFilterLayout.findViewById(R.id.filter_name)).setText(category.name);
                        NFCOpenDeviceListActivity.this.mListAdapter.notifyDataSetChanged();
                        NFCOpenDeviceListActivity.this.O00000o.dismiss();
                    }
                }

                public final void O000000o(Home home, Room room) {
                    if (NFCOpenDeviceListActivity.this.isValid() && NFCOpenDeviceListActivity.this.O00000o != null) {
                        if (room == null || !TextUtils.equals("ALL_ROOM", room.getId())) {
                            NFCOpenDeviceListActivity.this.filterActionByRoom(home, room);
                        } else {
                            NFCOpenDeviceListActivity.this.filterActionByHome(home);
                        }
                        ((TextView) NFCOpenDeviceListActivity.this.topFilterLayout.findViewById(R.id.filter_name)).setText(room.getName());
                        NFCOpenDeviceListActivity.this.mListAdapter.notifyDataSetChanged();
                        NFCOpenDeviceListActivity.this.O00000o.dismiss();
                    }
                }

                public final void O000000o(Home home) {
                    if (NFCOpenDeviceListActivity.this.isValid() && NFCOpenDeviceListActivity.this.O00000o != null) {
                        NFCOpenDeviceListActivity.this.filterActionByHome(home);
                        ((TextView) NFCOpenDeviceListActivity.this.topFilterLayout.findViewById(R.id.filter_name)).setText((int) R.string.tag_all);
                        NFCOpenDeviceListActivity.this.mListAdapter.notifyDataSetChanged();
                    }
                }

                public final int O000000o(String str, Room room) {
                    return NFCOpenDeviceListActivity.this.getActionCountByRoom(str, room);
                }

                public final int O000000o(String str, DeviceTagInterface.Category category) {
                    return NFCOpenDeviceListActivity.this.getActionCountByTag(str, category);
                }
            };
            this.O00000o = this.O00000o0.O000000o();
            this.O00000o0.O00000Oo();
        }
        this.topFilterLayout.setOnClickListener(null);
        this.topFilterLayout.findViewById(R.id.tv_group_filter).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.nfctag.ui.NFCOpenDeviceListActivity.AnonymousClass2 */

            public final void onClick(View view) {
                if (NFCOpenDeviceListActivity.this.O00000o0 != null) {
                    NFCOpenDeviceListActivity.this.O00000o0.O00000o0();
                }
            }
        });
    }

    public int getActionCountByTag(String str, DeviceTagInterface.Category category) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Map<String, List<String>> O0000Oo = fnn.O000000o().O00000Oo().O0000Oo(str);
        if (O0000Oo.isEmpty()) {
            return 0;
        }
        List list = O0000Oo.get(category.name);
        if (list.isEmpty()) {
            return 0;
        }
        HashSet hashSet = new HashSet(list);
        for (int i = 0; i < this.O00000Oo.size(); i++) {
            Device device = this.O00000Oo.get(i);
            if (device != null && hashSet.contains(device.did)) {
                return 1;
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
            List<Device> O0000OOo = ggb.O00000Oo().O0000OOo(str);
            if (O0000OOo.isEmpty()) {
                return 0;
            }
            HashSet hashSet = new HashSet(O0000OOo);
            for (int i = 0; i < this.O00000Oo.size(); i++) {
                Device device = this.O00000Oo.get(i);
                if (device != null && hashSet.contains(device)) {
                    return 1;
                }
            }
        } else {
            List<String> dids = room.getDids();
            if (dids.isEmpty()) {
                return 0;
            }
            HashSet hashSet2 = new HashSet(dids);
            for (int i2 = 0; i2 < this.O00000Oo.size(); i2++) {
                Device device2 = this.O00000Oo.get(i2);
                if (device2 != null && hashSet2.contains(device2.did)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public void filterActionByHome(Home home) {
        if (home == null) {
            this.mListAdapter.O000000o(this.O00000Oo);
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<String> O000000o2 = ggb.O00000Oo().O000000o(home.getId(), true);
        if (O000000o2.isEmpty()) {
            this.mListAdapter.O000000o(this.O00000Oo);
        }
        HashSet hashSet = new HashSet();
        if (!O000000o2.isEmpty()) {
            hashSet.addAll(O000000o2);
        }
        for (int i = 0; i < this.O00000Oo.size(); i++) {
            Device device = this.O00000Oo.get(i);
            if (device != null && hashSet.contains(device.did)) {
                arrayList.add(device);
            }
        }
        this.mListAdapter.O000000o(arrayList);
    }

    public void filterActionByTag(Home home, DeviceTagInterface.Category category) {
        if (home == null) {
            this.mListAdapter.O000000o(this.O00000Oo);
        } else if (category == null) {
            filterActionByHome(home);
        } else {
            ArrayList arrayList = new ArrayList();
            Map<String, List<String>> O0000Oo = fnn.O000000o().O00000Oo().O0000Oo(home.getId());
            if (O0000Oo.isEmpty()) {
                filterActionByHome(home);
                return;
            }
            List list = O0000Oo.get(category.name);
            if (list.isEmpty()) {
                filterActionByHome(home);
                return;
            }
            HashSet hashSet = new HashSet(list);
            for (int i = 0; i < this.O00000Oo.size(); i++) {
                Device device = this.O00000Oo.get(i);
                if (device != null && hashSet.contains(device.did)) {
                    arrayList.add(device);
                }
            }
            this.mListAdapter.O000000o(arrayList);
        }
    }

    public void filterActionByRoom(Home home, Room room) {
        if (home == null) {
            this.mListAdapter.O000000o(this.O00000Oo);
        } else if (room == null) {
            filterActionByHome(home);
        } else if (room.getId().equalsIgnoreCase("ALL_ROOM")) {
            filterActionByHome(home);
        } else {
            int i = 0;
            if (room.getId().equalsIgnoreCase("DEFAULT_ROOM")) {
                ArrayList arrayList = new ArrayList();
                List<Device> O0000O0o = ggb.O00000Oo().O0000O0o(home.getId());
                if (O0000O0o.isEmpty()) {
                    filterActionByHome(home);
                    return;
                }
                HashSet hashSet = new HashSet(O0000O0o);
                while (i < this.O00000Oo.size()) {
                    Device device = this.O00000Oo.get(i);
                    if (device != null && hashSet.contains(device)) {
                        arrayList.add(device);
                    }
                    i++;
                }
                this.mListAdapter.O000000o(arrayList);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            List<String> dids = room.getDids();
            if (dids.isEmpty()) {
                filterActionByHome(home);
                return;
            }
            HashSet hashSet2 = new HashSet(dids);
            while (i < this.O00000Oo.size()) {
                Device device2 = this.O00000Oo.get(i);
                if (device2 != null && hashSet2.contains(device2.did)) {
                    arrayList2.add(device2);
                }
                i++;
            }
            this.mListAdapter.O000000o(arrayList2);
        }
    }

    private void O000000o() {
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
        int i = 0;
        while (true) {
            if (i < (this.O00000Oo.isEmpty() ? 0 : this.O00000Oo.size())) {
                arrayList2.add(this.O00000Oo.get(i));
                i++;
            } else {
                Collections.sort(arrayList2, new O00000Oo(null, arrayList2));
                this.O00000Oo.clear();
                this.O00000Oo.addAll(arrayList2);
                this.mListAdapter.O000000o(this.O00000Oo);
                return;
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @OnClick({5480})
    public void close() {
        finish();
    }

    class O000000o extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
        private List<Device> O00000Oo = new ArrayList();
        private LayoutInflater O00000o0;

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getItemViewType(int i) {
            return 3;
        }

        public O000000o() {
            this.O00000o0 = NFCOpenDeviceListActivity.this.getLayoutInflater();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i != 3) {
                return null;
            }
            return new O00000o0(this.O00000o0.inflate((int) R.layout.create_scene_device_selection_layout, viewGroup, false));
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            int itemViewType = getItemViewType(i);
            if (!this.O00000Oo.isEmpty() && i < this.O00000Oo.size() && i >= 0) {
                Device device = this.O00000Oo.get(i);
                if (itemViewType == 3) {
                    O00000o0 o00000o0 = (O00000o0) o000OOo0;
                    if (device != null) {
                        o00000o0.O00000oO.setVisibility(0);
                        if (device == null) {
                            o00000o0.O00000oO.setText((int) R.string.samrthome_scene_device_off_line);
                        } else if (!device.isOnline) {
                            o00000o0.O00000oO.setText((int) R.string.samrthome_scene_device_off_line);
                        } else {
                            o00000o0.O00000oO.setVisibility(8);
                        }
                        o00000o0.O00000Oo.setText(NFCOpenDeviceListActivity.this.getContentDesc(device));
                        NFCOpenDeviceListActivity.this.setIconByAction(device, o00000o0.O00000o0);
                        o00000o0.f10449O000000o.setText(device.getName());
                        o00000o0.itemView.setOnClickListener(new View.OnClickListener(device) {
                            /* class com.xiaomi.smarthome.nfctag.ui.NFCOpenDeviceListActivity.O00000o0.AnonymousClass1 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ Device f10450O000000o;

                            {
                                this.f10450O000000o = r2;
                            }

                            public final void onClick(View view) {
                                Intent intent = new Intent(NFCOpenDeviceListActivity.this, NFCWriteActivity.class);
                                hig.f18961O000000o = 7;
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("next_action_type", hiv.f18965O000000o);
                                    jSONObject.put("did", this.f10450O000000o.did);
                                    jSONObject.put("model", this.f10450O000000o.model);
                                    jSONObject.put("extra_data", "");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                if (jSONObject.keys().hasNext()) {
                                    hig.O00000o0 = jSONObject.toString();
                                    NFCOpenDeviceListActivity.this.startActivity(intent);
                                    NFCOpenDeviceListActivity.this.finish();
                                    return;
                                }
                                hte.O000000o(NFCOpenDeviceListActivity.this, (int) R.string.save_fail);
                            }
                        });
                    }
                }
            }
        }

        public final int getItemCount() {
            if (this.O00000Oo.isEmpty()) {
                return 0;
            }
            return this.O00000Oo.size();
        }

        public final void O000000o(List<Device> list) {
            this.O00000Oo.clear();
            if (!list.isEmpty()) {
                this.O00000Oo.addAll(list);
            }
            NFCOpenDeviceListActivity.this.mContentListView.stopScroll();
            NFCOpenDeviceListActivity.this.mContentListView.getRecycledViewPool().O000000o();
            notifyDataSetChanged();
        }
    }

    class O00000o0 extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f10449O000000o;
        public TextView O00000Oo;
        public ImageView O00000o;
        public SimpleDraweeView O00000o0;
        public TextView O00000oO;

        public O00000o0(View view) {
            super(view);
            this.f10449O000000o = (TextView) view.findViewById(R.id.device_name);
            this.O00000Oo = (TextView) view.findViewById(R.id.room_name);
            this.O00000oO = (TextView) view.findViewById(R.id.offline_tv);
            this.O00000o0 = (SimpleDraweeView) view.findViewById(R.id.content_icon);
            this.O00000o = (ImageView) view.findViewById(R.id.expand_hint);
        }
    }

    public void setIconByAction(Device device, SimpleDraweeView simpleDraweeView) {
        if (simpleDraweeView != null && device != null) {
            simpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(simpleDraweeView.getResources()).setFadeDuration(200).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build());
            DeviceFactory.O00000Oo(device.model, simpleDraweeView);
        }
    }

    public String getContentDesc(Device device) {
        String string = getString(R.string.room_default);
        if (ggd.O000000o(device.model)) {
            return "";
        }
        Room O0000o00 = device != null ? ggb.O00000Oo().O0000o00(device.did) : null;
        return O0000o00 != null ? O0000o00.getName() : string;
    }

    public void onResume() {
        super.onResume();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    class O00000Oo implements Comparator<Device> {
        private Map<String, Integer> O00000Oo = new HashMap();
        private Map<String, Integer> O00000o0 = new HashMap();

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            Device device = (Device) obj;
            Device device2 = (Device) obj2;
            int i = 0;
            if (device == null && device2 == null) {
                return 0;
            }
            if (device != null && device2 != null) {
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
            } else if (device == null) {
                return 1;
            }
            return -1;
        }

        public O00000Oo(Room room, List<Device> list) {
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
                this.O00000Oo.put(((Room) arrayList.get(i)).getId(), Integer.valueOf(i));
                i++;
            }
            int i2 = 0;
            while (true) {
                if (i2 < (list.isEmpty() ? 0 : list.size())) {
                    if (list.get(i2) != null) {
                        this.O00000o0.put(list.get(i2).did, Integer.valueOf(i2));
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

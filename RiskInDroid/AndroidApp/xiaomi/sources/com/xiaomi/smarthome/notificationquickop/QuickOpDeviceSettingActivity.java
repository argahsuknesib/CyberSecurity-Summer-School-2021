package com.xiaomi.smarthome.notificationquickop;

import _m_j.fno;
import _m_j.fra;
import _m_j.gpp;
import _m_j.gqd;
import _m_j.gqg;
import _m_j.gs;
import _m_j.gsy;
import _m_j.hiz;
import _m_j.hjc;
import _m_j.hjd;
import _m_j.hje;
import _m_j.hjf;
import _m_j.hxi;
import _m_j.hzf;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.youpin.login.entity.account.LoginMiAccount;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QuickOpDeviceSettingActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    InnerAdapter f10477O000000o;
    ResultAdapter O00000Oo;
    View.OnClickListener O00000o = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.notificationquickop.QuickOpDeviceSettingActivity.AnonymousClass4 */

        public final void onClick(View view) {
            int childPosition;
            if (QuickOpDeviceSettingActivity.this.isSaving || (childPosition = QuickOpDeviceSettingActivity.this.mResultView.getChildPosition(view)) == -1 || childPosition >= QuickOpDeviceSettingActivity.this.mSelectedData.size() || QuickOpDeviceSettingActivity.this.isSaving) {
                return;
            }
            if (QuickOpDeviceSettingActivity.this.mSelectedData.size() == 1) {
                gqg.O00000Oo((int) R.string.choose_least_one);
                return;
            }
            QuickOpDeviceSettingActivity.this.mDeviceSettings.remove(QuickOpDeviceSettingActivity.this.mSelectedData.get(childPosition).f10488O000000o);
            QuickOpDeviceSettingActivity.this.mSelectedData.remove(childPosition);
            QuickOpDeviceSettingActivity.this.createUnselectDataFromSetting();
            QuickOpDeviceSettingActivity.this.O00000Oo.notifyDataSetChanged();
            QuickOpDeviceSettingActivity.this.f10477O000000o.notifyDataSetChanged();
            QuickOpDeviceSettingActivity.this.saveSetting();
        }
    };
    gs.O000000o O00000o0 = new gs.O000000o() {
        /* class com.xiaomi.smarthome.notificationquickop.QuickOpDeviceSettingActivity.AnonymousClass3 */

        public final void O000000o(RecyclerView.O000OOo0 o000OOo0) {
        }

        public final boolean O000000o() {
            return true;
        }

        public final int O000000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0) {
            return O000000o(12);
        }

        public final boolean O000000o(RecyclerView.O000OOo0 o000OOo0, RecyclerView.O000OOo0 o000OOo02) {
            if (o000OOo0.getItemViewType() != o000OOo02.getItemViewType()) {
                return false;
            }
            ResultAdapter resultAdapter = QuickOpDeviceSettingActivity.this.O00000Oo;
            int adapterPosition = o000OOo0.getAdapterPosition();
            int adapterPosition2 = o000OOo02.getAdapterPosition();
            if (adapterPosition >= QuickOpDeviceSettingActivity.this.mSelectedData.size() || adapterPosition2 >= QuickOpDeviceSettingActivity.this.mSelectedData.size()) {
                return true;
            }
            if (adapterPosition < adapterPosition2) {
                int i = adapterPosition;
                while (i < adapterPosition2) {
                    int i2 = i + 1;
                    Collections.swap(QuickOpDeviceSettingActivity.this.mSelectedData, i, i2);
                    i = i2;
                }
            } else {
                for (int i3 = adapterPosition; i3 > adapterPosition2; i3--) {
                    Collections.swap(QuickOpDeviceSettingActivity.this.mSelectedData, i3, i3 - 1);
                }
            }
            resultAdapter.notifyItemMoved(adapterPosition, adapterPosition2);
            QuickOpDeviceSettingActivity.this.saveSetting();
            return true;
        }
    };
    View.OnClickListener O00000oO = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.notificationquickop.QuickOpDeviceSettingActivity.AnonymousClass5 */

        public final void onClick(View view) {
            int childPosition;
            if (QuickOpDeviceSettingActivity.this.isSaving || QuickOpDeviceSettingActivity.this.mRecyclerView.getChildPosition(view) - 1 == -1 || childPosition >= QuickOpDeviceSettingActivity.this.mUnSelectedData.size() || QuickOpDeviceSettingActivity.this.isSaving) {
                return;
            }
            if (QuickOpDeviceSettingActivity.this.mSelectedData.size() == 4) {
                gqg.O00000Oo((int) R.string.choose_most_four);
                return;
            }
            QuickOpDeviceSettingActivity.this.mSelectedData.add(QuickOpDeviceSettingActivity.this.mUnSelectedData.get(childPosition));
            QuickOpDeviceSettingActivity.this.mDeviceSettings.add(QuickOpDeviceSettingActivity.this.mUnSelectedData.get(childPosition).f10488O000000o);
            QuickOpDeviceSettingActivity.this.mUnSelectedData.remove(childPosition);
            QuickOpDeviceSettingActivity.this.O00000Oo.notifyDataSetChanged();
            QuickOpDeviceSettingActivity.this.f10477O000000o.notifyDataSetChanged();
            QuickOpDeviceSettingActivity.this.saveSetting();
        }
    };
    private List<O000000o> O00000oo = new ArrayList();
    private boolean O0000O0o = false;
    private BroadcastReceiver O0000OOo = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.notificationquickop.QuickOpDeviceSettingActivity.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (TextUtils.equals("com.xiaomi.smarthome.notishortcut.notification.save_success", action)) {
                QuickOpDeviceSettingActivity.this.isSaving = false;
            } else if (TextUtils.equals("com.xiaomi.smarthome.notishortcut.notification.save_fail", action)) {
                QuickOpDeviceSettingActivity.this.isSaving = false;
            }
        }
    };
    @BindView(6448)
    View animBody;
    @BindView(7573)
    ImageView backBtn;
    @BindView(6955)
    View emptyDevideLine;
    @BindView(6771)
    TextView emptyText;
    @BindView(6773)
    View emptyView;
    public boolean isSaving = false;
    public Set<String> mDeviceSettings = new HashSet();
    @BindView(7928)
    RecyclerView mRecyclerView;
    @BindView(7930)
    RecyclerView mResultView;
    @BindView(8152)
    View mSelectTip;
    public List<O000000o> mSelectedData = new ArrayList();
    @BindView(8470)
    View mTopPanel;
    @BindView(8471)
    View mTopSpace;
    public List<O000000o> mUnSelectedData = new ArrayList();
    @BindView(8339)
    SwitchButton switchBtn;
    @BindView(8340)
    View switchView;
    @BindView(7578)
    TextView tittle;
    @BindView(8427)
    View topBar;

    class InnerAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {

        /* renamed from: O000000o  reason: collision with root package name */
        int f10483O000000o = 0;
        int O00000Oo = 1;
        int O00000o;
        int O00000o0;

        public class Holder_ViewBinding implements Unbinder {

            /* renamed from: O000000o  reason: collision with root package name */
            private Holder f10486O000000o;

            public Holder_ViewBinding(Holder holder, View view) {
                this.f10486O000000o = holder;
                holder.txtDeviceName = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_device_name, "field 'txtDeviceName'", TextView.class);
                holder.chooseDevice = (ImageView) Utils.findRequiredViewAsType(view, R.id.choose_device, "field 'chooseDevice'", ImageView.class);
                holder.imgDevice = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.img_device, "field 'imgDevice'", SimpleDraweeView.class);
                holder.rootView = Utils.findRequiredView(view, R.id.item_view, "field 'rootView'");
            }

            public void unbind() {
                Holder holder = this.f10486O000000o;
                if (holder != null) {
                    this.f10486O000000o = null;
                    holder.txtDeviceName = null;
                    holder.chooseDevice = null;
                    holder.imgDevice = null;
                    holder.rootView = null;
                    return;
                }
                throw new IllegalStateException("Bindings already cleared.");
            }
        }

        public InnerAdapter() {
            float f = QuickOpDeviceSettingActivity.this.getContext().getResources().getDisplayMetrics().density;
            this.O00000o0 = (int) (16.0f * f);
            this.O00000o = (int) (f * 6.0f);
        }

        public final int getItemViewType(int i) {
            if (i == 0) {
                return this.f10483O000000o;
            }
            return this.O00000Oo;
        }

        public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                ((GridLayoutManager) layoutManager).setSpanSizeLookup(new GridLayoutManager.O00000Oo() {
                    /* class com.xiaomi.smarthome.notificationquickop.QuickOpDeviceSettingActivity.InnerAdapter.AnonymousClass1 */

                    public final int getSpanSize(int i) {
                        return i == 0 ? 4 : 1;
                    }
                });
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (this.f10483O000000o == i) {
                return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.header_quickop_setting, viewGroup, false));
            }
            return new Holder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_quickop_setting, viewGroup, false));
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            if (this.f10483O000000o != getItemViewType(i)) {
                Holder holder = (Holder) o000OOo0;
                int i2 = i % 4;
                if (i2 == 1) {
                    View view = holder.rootView;
                    int i3 = this.O00000o0;
                    int i4 = this.O00000o;
                    view.setPadding(i3, i4, i4, i4);
                } else if (i2 == 0) {
                    View view2 = holder.rootView;
                    int i5 = this.O00000o;
                    view2.setPadding(i5, i5, this.O00000o0, i5);
                } else {
                    View view3 = holder.rootView;
                    int i6 = this.O00000o;
                    view3.setPadding(i6, i6, i6, i6);
                }
                holder.rootView.setOnClickListener(QuickOpDeviceSettingActivity.this.O00000oO);
                O000000o o000000o = QuickOpDeviceSettingActivity.this.mUnSelectedData.get(i - 1);
                holder.txtDeviceName.setText(o000000o.O00000Oo);
                holder.txtDeviceName.setTextColor(QuickOpDeviceSettingActivity.this.getResources().getColor(R.color.mj_color_black_100_transparent));
                holder.chooseDevice.setImageResource(R.drawable.btn_noti_add);
                holder.chooseDevice.setVisibility(0);
                if (!TextUtils.isEmpty(o000000o.O00000o0)) {
                    PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(o000000o.O00000o0);
                    if (O00000oO2 == null || TextUtils.isEmpty(O00000oO2.O0000Oo())) {
                        holder.imgDevice.setImageURI(gqd.O000000o((int) R.drawable.ic_noti_defualt_on));
                    } else {
                        holder.imgDevice.setImageURI(Uri.parse(O00000oO2.O0000Oo()));
                    }
                } else {
                    holder.imgDevice.setImageURI(gqd.O000000o((int) R.drawable.ic_noti_defualt_on));
                }
            }
        }

        public final int getItemCount() {
            return QuickOpDeviceSettingActivity.this.mUnSelectedData.size() + 1;
        }

        class Holder extends RecyclerView.O000OOo0 {
            @BindView(6713)
            ImageView chooseDevice;
            @BindView(7230)
            SimpleDraweeView imgDevice;
            @BindView(7283)
            View rootView;
            @BindView(8627)
            TextView txtDeviceName;

            public Holder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }

        class O000000o extends RecyclerView.O000OOo0 {
            public O000000o(View view) {
                super(view);
            }
        }
    }

    class ResultAdapter extends RecyclerView.O000000o<Holder> {
        public final int getItemCount() {
            return 4;
        }

        public class Holder_ViewBinding implements Unbinder {

            /* renamed from: O000000o  reason: collision with root package name */
            private Holder f10492O000000o;

            public Holder_ViewBinding(Holder holder, View view) {
                this.f10492O000000o = holder;
                holder.txtDeviceName = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_device_name, "field 'txtDeviceName'", TextView.class);
                holder.chooseDevice = (ImageView) Utils.findRequiredViewAsType(view, R.id.choose_device, "field 'chooseDevice'", ImageView.class);
                holder.imgDevice = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.img_device, "field 'imgDevice'", SimpleDraweeView.class);
                holder.rootView = Utils.findRequiredView(view, R.id.item_view, "field 'rootView'");
            }

            public void unbind() {
                Holder holder = this.f10492O000000o;
                if (holder != null) {
                    this.f10492O000000o = null;
                    holder.txtDeviceName = null;
                    holder.chooseDevice = null;
                    holder.imgDevice = null;
                    holder.rootView = null;
                    return;
                }
                throw new IllegalStateException("Bindings already cleared.");
            }
        }

        ResultAdapter() {
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            Holder holder = (Holder) o000OOo0;
            if (i >= QuickOpDeviceSettingActivity.this.mSelectedData.size()) {
                holder.txtDeviceName.setText("");
                holder.chooseDevice.setVisibility(8);
                holder.imgDevice.setImageURI(gqd.O000000o((int) R.drawable.ic_noti_place_holder));
                return;
            }
            holder.txtDeviceName.setText(QuickOpDeviceSettingActivity.this.mSelectedData.get(i).O00000Oo);
            holder.itemView.setOnClickListener(QuickOpDeviceSettingActivity.this.O00000o);
            holder.chooseDevice.setImageResource(R.drawable.btn_noti_del);
            holder.chooseDevice.setVisibility(0);
            if (!TextUtils.isEmpty(QuickOpDeviceSettingActivity.this.mSelectedData.get(i).O00000o0)) {
                PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(QuickOpDeviceSettingActivity.this.mSelectedData.get(i).O00000o0);
                if (O00000oO == null || TextUtils.isEmpty(O00000oO.O0000Oo())) {
                    holder.imgDevice.setImageURI(gqd.O000000o((int) R.drawable.ic_noti_defualt_on));
                } else {
                    holder.imgDevice.setImageURI(Uri.parse(O00000oO.O0000Oo()));
                }
            } else {
                holder.imgDevice.setImageURI(gqd.O000000o((int) R.drawable.ic_noti_defualt_on));
            }
            DraweeController controller = holder.imgDevice.getController();
            if (controller != null && (controller instanceof AbstractDraweeController)) {
                ((AbstractDraweeController) controller).addControllerListener(new BaseControllerListener() {
                    /* class com.xiaomi.smarthome.notificationquickop.QuickOpDeviceSettingActivity.ResultAdapter.AnonymousClass1 */

                    public final void onFailure(String str, Throwable th) {
                        gsy.O000000o(6, "Failure", str + " decode failed");
                    }
                });
            }
        }

        public class Holder extends RecyclerView.O000OOo0 {
            @BindView(6713)
            ImageView chooseDevice;
            @BindView(7230)
            SimpleDraweeView imgDevice;
            @BindView(7283)
            View rootView;
            @BindView(8627)
            TextView txtDeviceName;

            public Holder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new Holder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_quickop_setting, viewGroup, false));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_quickop_setting);
        ButterKnife.bind(this);
        LoginMiAccount O0000oOo = CoreApi.O000000o().O0000oOo();
        if (O0000oOo != null) {
            hje.O000000o();
            O0000oOo.O00000oO();
            hje.O00000Oo();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.xiaomi.smarthome.notishortcut.notification.save_success");
        intentFilter.addAction("com.xiaomi.smarthome.notishortcut.notification.save_fail");
        registerReceiver(this.O0000OOo, intentFilter);
        this.tittle.setText((int) R.string.notification_quick_op_title);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        this.f10477O000000o = new InnerAdapter();
        this.mRecyclerView.setAdapter(this.f10477O000000o);
        this.mResultView.setHasFixedSize(true);
        this.mResultView.setLayoutManager(new GridLayoutManager(this, 4));
        this.O00000Oo = new ResultAdapter();
        this.mResultView.setAdapter(this.O00000Oo);
        new gs(this.O00000o0).O000000o(this.mResultView);
        this.emptyView.setVisibility(0);
        this.emptyDevideLine.setVisibility(0);
        this.mRecyclerView.setVisibility(0);
        this.switchBtn.setOnTouchEnable(false);
        this.switchView.setOnClickListener(this);
        O000000o();
        getSharedPreferences("quick_op_data_v2_" + gpp.O000000o(CoreApi.O000000o().O0000o0()), 0).edit().clear().commit();
        hiz.O000000o(this).O000000o();
    }

    private void O000000o() {
        Map<String, Device> O0000O0o2 = fno.O000000o().O0000O0o();
        if (O0000O0o2 == null || O0000O0o2.size() == 0) {
            O00000Oo();
            return;
        }
        this.emptyView.setVisibility(8);
        this.emptyDevideLine.setVisibility(8);
        List<String> list = null;
        try {
            hje.O000000o();
            this.O0000O0o = hjc.O00000Oo(ServiceApplication.getAppContext());
            hje.O000000o();
            list = O000000o(hjc.O00000o0(ServiceApplication.getAppContext()));
        } catch (RemoteException unused) {
            gsy.O000000o(6, "QuickOp", "RemoteException!!! ");
        }
        if (list != null) {
            this.mDeviceSettings.addAll(list);
        }
        Set<String> set = this.mDeviceSettings;
        if (set == null || set.size() <= 0) {
            O000000o(O0000O0o2);
        } else {
            this.O00000oo.clear();
            this.mSelectedData.clear();
            this.mUnSelectedData.clear();
            for (String str : list) {
                O000000o o000000o = new O000000o((byte) 0);
                o000000o.f10488O000000o = str;
                this.mSelectedData.add(o000000o);
            }
            for (Map.Entry<String, Device> value : O0000O0o2.entrySet()) {
                Device device = (Device) value.getValue();
                if (O000000o(device)) {
                    O000000o o000000o2 = new O000000o((byte) 0);
                    o000000o2.f10488O000000o = device.did;
                    o000000o2.O00000Oo = device.name;
                    o000000o2.O00000o = device.isOnline;
                    o000000o2.O00000o0 = device.model;
                    this.O00000oo.add(o000000o2);
                    if (this.mDeviceSettings.contains(device.did)) {
                        int size = this.mSelectedData.size() - 1;
                        while (true) {
                            if (size < 0) {
                                break;
                            } else if (TextUtils.equals(this.mSelectedData.get(size).f10488O000000o, device.did)) {
                                this.mSelectedData.get(size).f10488O000000o = o000000o2.f10488O000000o;
                                this.mSelectedData.get(size).O00000oO = o000000o2.O00000oO;
                                this.mSelectedData.get(size).O00000o = o000000o2.O00000o;
                                this.mSelectedData.get(size).O00000o0 = o000000o2.O00000o0;
                                this.mSelectedData.get(size).O00000Oo = o000000o2.O00000Oo;
                                break;
                            } else {
                                size--;
                            }
                        }
                    } else {
                        this.mUnSelectedData.add(o000000o2);
                    }
                }
            }
            for (int size2 = this.mSelectedData.size() - 1; size2 >= 0; size2--) {
                if (TextUtils.isEmpty(this.mSelectedData.get(size2).O00000Oo)) {
                    this.mDeviceSettings.remove(this.mSelectedData.get(size2).f10488O000000o);
                    this.mSelectedData.remove(size2);
                }
            }
            List<O000000o> list2 = this.mSelectedData;
            if (list2 == null || list2.size() == 0) {
                this.mUnSelectedData.clear();
                this.mSelectedData.clear();
                O000000o(O0000O0o2);
            }
        }
        List<O000000o> list3 = this.O00000oo;
        if (list3 == null || list3.size() == 0) {
            O00000Oo();
            return;
        }
        saveSetting();
        this.f10477O000000o.notifyDataSetChanged();
        this.O00000Oo.notifyDataSetChanged();
        this.switchBtn.setChecked(this.O0000O0o);
        O000000o(this.O0000O0o, false);
    }

    private void O000000o(boolean z, boolean z2) {
        if (z) {
            this.mRecyclerView.setVisibility(0);
            this.mTopPanel.setVisibility(0);
            this.mTopSpace.setVisibility(8);
            if (!z2) {
                this.tittle.setTextColor(getResources().getColor(R.color.mj_color_white));
                this.topBar.setBackgroundColor(getResources().getColor(R.color.mj_color_gray_normal));
                return;
            }
            ObjectAnimator ofInt = ObjectAnimator.ofInt(this.mTopPanel, "backgroundColor", getResources().getColor(R.color.mj_color_white), getResources().getColor(R.color.mj_color_gray_normal));
            ofInt.setDuration(300L);
            ofInt.setEvaluator(new ArgbEvaluator());
            ObjectAnimator ofInt2 = ObjectAnimator.ofInt(this.tittle, "textColor", getResources().getColor(R.color.mj_color_gray_normal), getResources().getColor(R.color.mj_color_white));
            ofInt2.setDuration(300L);
            ofInt2.setEvaluator(new ArgbEvaluator());
            ObjectAnimator ofInt3 = ObjectAnimator.ofInt(this.topBar, "backgroundColor", getResources().getColor(R.color.mj_color_white), getResources().getColor(R.color.mj_color_gray_normal));
            ofInt3.setDuration(300L);
            ofInt3.setEvaluator(new ArgbEvaluator());
            this.mTopPanel.measure(0, 0);
            this.mTopSpace.measure(0, 0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.animBody, View.TRANSLATION_Y, (float) (this.mTopSpace.getMeasuredHeight() - this.mTopPanel.getMeasuredHeight()), 0.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(300L);
            animatorSet.play(ofFloat).with(ofInt).with(ofInt2).with(ofInt3);
            animatorSet.start();
            return;
        }
        this.mTopSpace.setVisibility(0);
        ObjectAnimator ofInt4 = ObjectAnimator.ofInt(this.mTopPanel, "backgroundColor", getResources().getColor(R.color.mj_color_gray_normal), getResources().getColor(R.color.mj_color_white));
        ofInt4.setDuration(300L);
        ofInt4.setEvaluator(new ArgbEvaluator());
        ObjectAnimator ofInt5 = ObjectAnimator.ofInt(this.tittle, "textColor", getResources().getColor(R.color.mj_color_white), getResources().getColor(R.color.mj_color_gray_normal));
        ofInt5.setDuration(300L);
        ofInt5.setEvaluator(new ArgbEvaluator());
        ObjectAnimator ofInt6 = ObjectAnimator.ofInt(this.topBar, "backgroundColor", getResources().getColor(R.color.mj_color_gray_normal), getResources().getColor(R.color.mj_color_white));
        ofInt6.setDuration(300L);
        ofInt6.setEvaluator(new ArgbEvaluator());
        this.mTopPanel.measure(0, 0);
        this.topBar.measure(0, 0);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.animBody, View.TRANSLATION_Y, (float) this.mTopPanel.getHeight(), 0.0f);
        this.mRecyclerView.setVisibility(8);
        this.mTopPanel.setVisibility(8);
        if (!z2) {
            this.tittle.setTextColor(getResources().getColor(R.color.mj_color_gray_normal));
            this.topBar.setBackgroundColor(getResources().getColor(R.color.mj_color_white));
            return;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(300L);
        animatorSet2.play(ofFloat2).with(ofInt4).with(ofInt5).with(ofInt6);
        animatorSet2.start();
    }

    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.O0000OOo);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        List<O000000o> list = this.O00000oo;
        if (list == null || list.size() == 0) {
            finish();
            return true;
        }
        if (this.O0000O0o) {
            saveSetting();
        } else {
            hje.O000000o();
            hje.O00000oO();
        }
        List<O000000o> list2 = this.mSelectedData;
        if (list2 == null || list2.size() == 0) {
            gqg.O00000Oo("至少选择一个设备");
            return true;
        }
        finish();
        return true;
    }

    public void saveSetting() {
        if (this.O0000O0o) {
            this.isSaving = true;
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            JSONArray jSONArray3 = new JSONArray();
            for (O000000o next : this.mSelectedData) {
                JSONObject O00000o02 = O00000o0(fno.O000000o().O000000o(next.f10488O000000o));
                JSONObject O00000Oo2 = O00000Oo(fno.O000000o().O000000o(next.f10488O000000o));
                if (!(O00000o02 == null || O00000Oo2 == null)) {
                    jSONArray.put(next.f10488O000000o);
                    jSONArray2.put(O00000o02);
                    jSONArray3.put(O00000Oo2);
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("list", jSONArray2);
                jSONObject.put("config", jSONArray3);
            } catch (JSONException unused) {
            }
            hje.O000000o();
            String jSONObject2 = jSONObject.toString();
            String jSONArray4 = jSONArray.toString();
            hjf O000000o2 = hjf.O000000o(ServiceApplication.getAppContext());
            String O0000o0 = CoreApi.O000000o().O0000o0();
            boolean z = false;
            if (!TextUtils.isEmpty(O0000o0)) {
                Context context = O000000o2.O00000oo;
                if (hjd.O000000o(context, "noti_device_setting" + gpp.O000000o(O0000o0), "devices", jSONObject2)) {
                    Context context2 = O000000o2.O00000oo;
                    if (hjd.O000000o(context2, "noti_device_setting_lite" + gpp.O000000o(O0000o0), "dids", jSONArray4)) {
                        Context context3 = O000000o2.O00000oo;
                        if (hjd.O000000o(context3, "noti_device_setting_lite" + gpp.O000000o(O0000o0), "is_open", "true")) {
                            O000000o2.O00000o0 = true;
                            O000000o2.O000000o(true);
                            z = true;
                        }
                    }
                }
            }
            if (z) {
                Intent intent = new Intent("com.xiaomi.smarthome.notishortcut.notification.save_success");
                intent.setPackage("com.xiaomi.smarthome");
                ServiceApplication.getAppContext().sendBroadcast(intent);
            } else {
                Intent intent2 = new Intent("com.xiaomi.smarthome.notishortcut.notification.save_fail");
                intent2.setPackage("com.xiaomi.smarthome");
                ServiceApplication.getAppContext().sendBroadcast(intent2);
            }
            this.mHandler.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.notificationquickop.QuickOpDeviceSettingActivity.AnonymousClass2 */

                public final void run() {
                    QuickOpDeviceSettingActivity.this.isSaving = false;
                }
            }, 10000);
        }
    }

    private static List<String> O000000o(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            return arrayList;
        } catch (JSONException e) {
            gsy.O000000o(6, "QuickOp", "getSettingFromFile fail: " + e.getMessage());
        }
    }

    private void O00000Oo() {
        this.O0000O0o = false;
        this.emptyText.setText((int) R.string.no_supported_device_new);
        this.emptyView.setVisibility(0);
        this.mRecyclerView.setVisibility(8);
        this.emptyDevideLine.setVisibility(0);
        O000000o(false, false);
    }

    private void O000000o(Map<String, Device> map) {
        this.O00000oo.clear();
        this.mSelectedData.clear();
        this.mUnSelectedData.clear();
        int i = 0;
        for (Map.Entry<String, Device> value : map.entrySet()) {
            Device device = (Device) value.getValue();
            if (O000000o(device)) {
                O000000o o000000o = new O000000o((byte) 0);
                o000000o.f10488O000000o = device.did;
                o000000o.O00000Oo = device.name;
                o000000o.O00000o = device.isOnline;
                o000000o.O00000o0 = device.model;
                this.O00000oo.add(o000000o);
                if (i < 4) {
                    this.mSelectedData.add(o000000o);
                    this.mDeviceSettings.add(o000000o.f10488O000000o);
                    i++;
                } else {
                    this.mUnSelectedData.add(o000000o);
                }
            }
        }
    }

    private static boolean O000000o(Device device) {
        return 1 == fra.O000000o().O000000o(device);
    }

    private static JSONObject O00000Oo(Device device) {
        JSONObject jSONObject = null;
        if (device == null) {
            return null;
        }
        if (!(fra.O000000o().O00000o0() == null || fra.O000000o().O00000o0().get(device.model) == null || fra.O000000o().O00000o0().get(device.model).O00000Oo == null || fra.O000000o().O00000o0().get(device.model).O00000Oo.length < 2)) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("model", device.model);
                String str = fra.O000000o().O00000o0().get(device.model).O00000Oo[0].O00000Oo;
                String str2 = fra.O000000o().O00000o0().get(device.model).O00000Oo[1].O00000Oo;
                jSONObject.put("prop_on", str);
                jSONObject.put("prop_off", str2);
                fra.O000000o().O00000o0().get(device.model).O00000Oo[0].O000000o();
                JSONObject jSONObject2 = new JSONObject(fra.O000000o().O00000o0().get(device.model).O00000Oo[0].O000000o().toString());
                if (jSONObject2.has("rpc_params")) {
                    jSONObject.put("prop_params_on", jSONObject2.optJSONArray("rpc_params").toString());
                }
                fra.O000000o().O00000o0().get(device.model).O00000Oo[1].O000000o();
                JSONObject jSONObject3 = new JSONObject(fra.O000000o().O00000o0().get(device.model).O00000Oo[1].O000000o().toString());
                if (jSONObject3.has("rpc_params")) {
                    jSONObject.put("prop_params_off", jSONObject3.optJSONArray("rpc_params").toString());
                }
                jSONObject.put("prop_name", fra.O000000o().O00000o0().get(device.model).O00000Oo[0].f7304O000000o);
                String str3 = fra.O000000o().O00000o0().get(device.model).O00000Oo[0].O00000o0;
                String str4 = fra.O000000o().O00000o0().get(device.model).O00000Oo[1].O00000o0;
                jSONObject.put("rpc_method_on", str3);
                jSONObject.put("rpc_method_off", str4);
            } catch (JSONException e) {
                gsy.O000000o(6, "config_exception", e.getMessage());
            }
        }
        return jSONObject;
    }

    private static JSONObject O00000o0(Device device) {
        if (device == null || fra.O000000o().O00000o0() == null || fra.O000000o().O00000o0().get(device.model) == null || fra.O000000o().O00000o0().get(device.model).O00000Oo == null || fra.O000000o().O00000o0().get(device.model).O00000Oo.length < 2) {
            return null;
        }
        DeviceStat O0000o00 = fno.O000000o().O0000o00(device.did);
        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(device.model);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", device.did);
            jSONObject.put("name", device.name);
            jSONObject.put("model", device.model);
            jSONObject.put("is_online", device.isOnline);
            if (O00000oO2 != null) {
                if (!TextUtils.isEmpty(O00000oO2.O0000Oo())) {
                    jSONObject.put("ic_on", O00000oO2.O0000Oo());
                }
                if (!TextUtils.isEmpty(O00000oO2.O0000OoO())) {
                    jSONObject.put("ic_off", O00000oO2.O0000OoO());
                }
                if (!TextUtils.isEmpty(O00000oO2.O0000Ooo())) {
                    jSONObject.put("ic_offline", O00000oO2.O0000Ooo());
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            if (!(O0000o00 == null || O0000o00.propInfo == null)) {
                gsy.O00000Oo("rpc", device.model + "   :   " + O0000o00.propInfo.toString());
                if (!(fra.O000000o().O00000o0() == null || fra.O000000o().O00000o0().get(device.model) == null || fra.O000000o().O00000o0().get(device.model).O00000Oo == null || fra.O000000o().O00000o0().get(device.model).O00000Oo.length <= 0)) {
                    String str = fra.O000000o().O00000o0().get(device.model).O00000Oo[0].f7304O000000o;
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(O0000o00.propInfo.optString(str))) {
                        jSONObject2.put(str, O0000o00.propInfo.optString(str));
                    }
                }
            }
            jSONObject.put("props", jSONObject2);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void createUnselectDataFromSetting() {
        this.mUnSelectedData.clear();
        for (O000000o next : this.O00000oo) {
            if (!this.mDeviceSettings.contains(next.f10488O000000o)) {
                this.mUnSelectedData.add(next);
            }
        }
    }

    @OnClick({7573})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.module_a_3_return_btn) {
            List<O000000o> list = this.O00000oo;
            if (list == null || list.size() == 0) {
                finish();
                return;
            }
            saveSetting();
            List<O000000o> list2 = this.mSelectedData;
            if (list2 == null || list2.size() == 0) {
                gqg.O00000Oo((int) R.string.choose_least_one);
            } else {
                finish();
            }
        } else if (id == R.id.switch_setting_view) {
            this.O0000O0o = !this.O0000O0o;
            this.switchBtn.setChecked(this.O0000O0o);
            hzf.O000000o((CompoundButton) this.switchBtn);
            if (this.O0000O0o) {
                hxi.O00000o.O000000o(1);
            } else {
                hxi.O00000o.O000000o(2);
            }
            O000000o(this.O0000O0o, true);
            if (this.O0000O0o) {
                saveSetting();
                return;
            }
            hje.O000000o();
            hje.O00000oO();
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        String f10488O000000o;
        String O00000Oo;
        boolean O00000o;
        String O00000o0;
        boolean O00000oO;

        private O000000o() {
            this.O00000o = false;
            this.O00000oO = true;
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }
    }
}

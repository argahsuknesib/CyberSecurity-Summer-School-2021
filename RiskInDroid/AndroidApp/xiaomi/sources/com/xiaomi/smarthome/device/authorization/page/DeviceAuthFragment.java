package com.xiaomi.smarthome.device.authorization.page;

import _m_j.am;
import _m_j.fmh;
import _m_j.fnn;
import _m_j.fno;
import _m_j.fnw;
import _m_j.fnx;
import _m_j.fnz;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ftn;
import _m_j.fvm;
import _m_j.fwi;
import _m_j.ggb;
import _m_j.gge;
import _m_j.gqg;
import _m_j.gty;
import _m_j.hbi;
import _m_j.hxi;
import _m_j.ibh;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.appbar.AppBarLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.authorization.page.ControlAuthPopWindow;
import com.xiaomi.smarthome.device.authorization.page.DeviceAuthFragment;
import com.xiaomi.smarthome.framework.page.verify.filter.SettingsDeviceFilter;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.newui.HomeListDialogHelper;
import com.xiaomi.youpin.login.entity.Error;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DeviceAuthFragment extends fvm {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f7054O000000o = "device";
    public static String O00000Oo = "homeroom";
    hbi O00000o;
    View O00000o0;
    hbi O00000oO;
    fnx O00000oo;
    fnz O0000O0o;
    List<fnw.O000000o> O0000OOo = new ArrayList();
    public SparseBooleanArray O0000Oo = new SparseBooleanArray();
    List<fnw.O000000o> O0000Oo0 = new ArrayList();
    SwitchButton O0000OoO;
    public String O0000Ooo;
    private View O0000o;
    public String O0000o0;
    public boolean O0000o00 = false;
    public boolean O0000o0O = false;
    public SettingsDeviceFilter O0000o0o;
    private View O0000oO;
    private View O0000oO0;
    private SwitchButton O0000oOO;
    private View O0000oOo;
    private View O0000oo;
    private SwitchButton O0000oo0;
    @BindView(6773)
    View emptyView;
    @BindView(6452)
    AppBarLayout mAppBarLayout;
    @BindView(6480)
    TextView mAutoSelectTv;
    @BindView(6920)
    View mDividerLine;
    @BindView(7028)
    View mFilterDeviceLayout;
    @BindView(7290)
    View mIvChangeControlArrow;
    @BindView(7310)
    ImageView mIvSelectHomeArrow;
    @BindView(7409)
    View mLlChangeControlMode;
    @BindView(7416)
    View mLlFilterDevice;
    @BindView(6883)
    RecyclerView mRecyclerView;
    @BindView(7990)
    View mRlHomeSelect;
    @BindView(6622)
    SwitchButton mSelectAllBtn;
    @BindView(8510)
    TextView mTvAuthMode;
    @BindView(8539)
    TextView mTvDeviceAuthFilterTitle;
    @BindView(8543)
    TextView mTvEmptyResults;
    @BindView(8554)
    TextView mTvHomeName;
    @BindView(8598)
    TextView mTvSelectDeviceName;
    @BindView(7524)
    View menuLayout;

    class HomeRoomAdapter extends RecyclerView.O000000o<ViewHolder> {
        private List<Room> O00000Oo = new ArrayList();

        public class ViewHolder_ViewBinding implements Unbinder {

            /* renamed from: O000000o  reason: collision with root package name */
            private ViewHolder f7073O000000o;

            public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
                this.f7073O000000o = viewHolder;
                viewHolder.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
                viewHolder.checkBox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ratio_btn, "field 'checkBox'", CheckBox.class);
            }

            public void unbind() {
                ViewHolder viewHolder = this.f7073O000000o;
                if (viewHolder != null) {
                    this.f7073O000000o = null;
                    viewHolder.title = null;
                    viewHolder.checkBox = null;
                    return;
                }
                throw new IllegalStateException("Bindings already cleared.");
            }
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ViewHolder viewHolder = (ViewHolder) o000OOo0;
            Room room = this.O00000Oo.get(i);
            if (room != null) {
                StringBuilder sb = new StringBuilder(room.getName());
                if (room.getDids().contains(DeviceAuthFragment.this.O0000O0o.f16727O000000o)) {
                    sb.append(" ");
                    sb.append(DeviceAuthFragment.this.getString(R.string.device_located_room));
                }
                viewHolder.title.setText(sb);
                float f = 0.3f;
                viewHolder.title.setAlpha(DeviceAuthFragment.this.O0000O0o.O00000oO ? 0.3f : 1.0f);
                CheckBox checkBox = viewHolder.checkBox;
                if (!DeviceAuthFragment.this.O0000O0o.O00000oO) {
                    f = 1.0f;
                }
                checkBox.setAlpha(f);
                viewHolder.checkBox.setOnCheckedChangeListener(null);
                if (DeviceAuthFragment.this.O0000O0o.O00000oO) {
                    viewHolder.checkBox.setChecked(true);
                } else if (DeviceAuthFragment.this.O0000O0o.O0000Oo0.contains(room.getId())) {
                    viewHolder.checkBox.setChecked(true);
                } else {
                    viewHolder.checkBox.setChecked(false);
                }
                if (DeviceAuthFragment.this.O0000O0o.O00000oO) {
                    viewHolder.checkBox.setEnabled(false);
                    return;
                }
                viewHolder.checkBox.setEnabled(true);
                viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(room) {
                    /* class com.xiaomi.smarthome.device.authorization.page.$$Lambda$DeviceAuthFragment$HomeRoomAdapter$jl1dNHcGMNcflVxwOJBpkWYHbhU */
                    private final /* synthetic */ Room f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        DeviceAuthFragment.HomeRoomAdapter.this.O000000o(this.f$1, compoundButton, z);
                    }
                });
            }
        }

        public HomeRoomAdapter(Home home) {
            if (home != null && home.getRoomList() != null) {
                this.O00000Oo.addAll(home.getRoomList());
                Room O0000o00 = ggb.O00000Oo().O0000o00(DeviceAuthFragment.this.O0000Ooo);
                if (O0000o00 != null && this.O00000Oo.contains(O0000o00)) {
                    this.O00000Oo.remove(O0000o00);
                    this.O00000Oo.add(0, O0000o00);
                }
            }
        }

        public final int getItemCount() {
            if (DeviceAuthFragment.this.O0000O0o == null) {
                return 0;
            }
            return this.O00000Oo.size();
        }

        public class ViewHolder extends RecyclerView.O000OOo0 {
            @BindView(7907)
            CheckBox checkBox;
            @BindView(8423)
            TextView title;

            public ViewHolder(View view) {
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
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.home_room_auth_slave_list, viewGroup, false));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(Room room, CompoundButton compoundButton, boolean z) {
            if (z && !DeviceAuthFragment.this.O0000O0o.O0000Oo0.contains(room.getId())) {
                DeviceAuthFragment.this.O0000O0o.O0000Oo0.add(room.getId());
            } else if (!z) {
                DeviceAuthFragment.this.O0000O0o.O0000Oo0.remove(room.getId());
            }
            notifyDataSetChanged();
            ((DeviceAuthSlaveListActivity) DeviceAuthFragment.this.getActivity()).setDeviceAuthChanged(true);
        }
    }

    class DeviceAuthAdapter extends RecyclerView.O000000o<ViewHolder> {

        public class ViewHolder_ViewBinding implements Unbinder {

            /* renamed from: O000000o  reason: collision with root package name */
            private ViewHolder f7070O000000o;

            public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
                this.f7070O000000o = viewHolder;
                viewHolder.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
                viewHolder.checkBox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ratio_btn, "field 'checkBox'", CheckBox.class);
                viewHolder.homeRoomName = (TextView) Utils.findRequiredViewAsType(view, R.id.home_room_name, "field 'homeRoomName'", TextView.class);
                viewHolder.deviceImg = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.device_icon, "field 'deviceImg'", SimpleDraweeView.class);
            }

            public void unbind() {
                ViewHolder viewHolder = this.f7070O000000o;
                if (viewHolder != null) {
                    this.f7070O000000o = null;
                    viewHolder.title = null;
                    viewHolder.checkBox = null;
                    viewHolder.homeRoomName = null;
                    viewHolder.deviceImg = null;
                    return;
                }
                throw new IllegalStateException("Bindings already cleared.");
            }
        }

        DeviceAuthAdapter() {
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ViewHolder viewHolder = (ViewHolder) o000OOo0;
            if (DeviceAuthFragment.this.O00000oo != null) {
                viewHolder.title.setText(DeviceAuthFragment.this.O0000OOo.get(i).O00000o0);
                float f = 0.3f;
                viewHolder.title.setAlpha(DeviceAuthFragment.this.O00000oo.O00000oo.get() ? 0.3f : 1.0f);
                viewHolder.checkBox.setAlpha(DeviceAuthFragment.this.O00000oo.O00000oo.get() ? 0.3f : 1.0f);
                viewHolder.homeRoomName.setAlpha(DeviceAuthFragment.this.O00000oo.O00000oo.get() ? 0.3f : 1.0f);
                SimpleDraweeView simpleDraweeView = viewHolder.deviceImg;
                if (!DeviceAuthFragment.this.O00000oo.O00000oo.get()) {
                    f = 1.0f;
                }
                simpleDraweeView.setAlpha(f);
                if (!TextUtils.isEmpty(DeviceAuthFragment.this.O0000OOo.get(i).O00000oO)) {
                    gty.O000000o().setIcon(viewHolder.deviceImg, DeviceAuthFragment.this.O0000OOo.get(i).O00000oO);
                } else {
                    DeviceFactory.O00000Oo(DeviceAuthFragment.this.O0000OOo.get(i).O00000o, viewHolder.deviceImg);
                }
                viewHolder.checkBox.setOnCheckedChangeListener(null);
                if (TextUtils.equals("1", DeviceAuthFragment.this.O0000OOo.get(i).O00000Oo)) {
                    viewHolder.checkBox.setChecked(true);
                } else {
                    viewHolder.checkBox.setChecked(false);
                }
                if (TextUtils.isEmpty(DeviceAuthFragment.this.O0000OOo.get(i).O00000oo) && TextUtils.isEmpty(DeviceAuthFragment.this.O0000OOo.get(i).O0000O0o)) {
                    viewHolder.homeRoomName.setText("");
                } else if (!TextUtils.isEmpty(DeviceAuthFragment.this.O0000OOo.get(i).O00000oo) && TextUtils.isEmpty(DeviceAuthFragment.this.O0000OOo.get(i).O0000O0o)) {
                    viewHolder.homeRoomName.setText(DeviceAuthFragment.this.O0000OOo.get(i).O00000oo);
                } else if (TextUtils.isEmpty(DeviceAuthFragment.this.O0000OOo.get(i).O00000oo) && !TextUtils.isEmpty(DeviceAuthFragment.this.O0000OOo.get(i).O0000O0o)) {
                    viewHolder.homeRoomName.setText(DeviceAuthFragment.this.O0000OOo.get(i).O0000O0o);
                } else if (!TextUtils.isEmpty(DeviceAuthFragment.this.O0000OOo.get(i).O00000oo) && !TextUtils.isEmpty(DeviceAuthFragment.this.O0000OOo.get(i).O0000O0o)) {
                    TextView textView = viewHolder.homeRoomName;
                    textView.setText(DeviceAuthFragment.this.O0000OOo.get(i).O00000oo + "-" + DeviceAuthFragment.this.O0000OOo.get(i).O0000O0o);
                }
                if (DeviceAuthFragment.this.O00000oo.O00000oo.get()) {
                    viewHolder.checkBox.setEnabled(false);
                    return;
                }
                viewHolder.checkBox.setEnabled(true);
                viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(i) {
                    /* class com.xiaomi.smarthome.device.authorization.page.$$Lambda$DeviceAuthFragment$DeviceAuthAdapter$IVZBImJG_AFBa0PHkAvIypnagQ */
                    private final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        DeviceAuthFragment.DeviceAuthAdapter.this.O000000o(this.f$1, compoundButton, z);
                    }
                });
            }
        }

        public final int getItemCount() {
            return DeviceAuthFragment.this.O0000OOo.size();
        }

        public class ViewHolder extends RecyclerView.O000OOo0 {
            @BindView(7907)
            CheckBox checkBox;
            @BindView(6874)
            SimpleDraweeView deviceImg;
            @BindView(7168)
            TextView homeRoomName;
            @BindView(8423)
            TextView title;

            public ViewHolder(View view) {
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
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.device_auth_slave_list, viewGroup, false));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(int i, CompoundButton compoundButton, boolean z) {
            if (TextUtils.equals("0", DeviceAuthFragment.this.O0000OOo.get(i).O00000Oo)) {
                DeviceAuthFragment.this.O0000OOo.get(i).O00000Oo = "1";
            } else {
                DeviceAuthFragment.this.O0000OOo.get(i).O00000Oo = "0";
            }
            if (DeviceAuthFragment.this.O0000Oo.get(i)) {
                DeviceAuthFragment.this.O0000Oo.put(i, false);
            } else {
                DeviceAuthFragment.this.O0000Oo.put(i, true);
            }
            notifyItemChanged(i);
            ((DeviceAuthSlaveListActivity) DeviceAuthFragment.this.getActivity()).setDeviceAuthChanged(true);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.O0000Ooo = ((DeviceAuthSlaveListActivity) getActivity()).O00000o;
        ((DeviceAuthSlaveListActivity) getActivity()).showProgressDialog(getResources().getString(R.string.loading_share_info));
        this.O0000o0O = true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.O00000o0 == null) {
            this.O00000o0 = layoutInflater.inflate((int) R.layout.fragment_auth_device, (ViewGroup) null);
            ButterKnife.bind(this, this.O00000o0);
        }
        return this.O00000o0;
    }

    public void onViewCreated(View view, Bundle bundle) {
        am amVar;
        super.onViewCreated(view, bundle);
        Configuration configuration = getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= 24) {
            amVar = am.O000000o(configuration.getLocales());
        } else {
            amVar = am.O000000o(configuration.locale);
        }
        if (amVar != null && !amVar.f12449O000000o.O00000Oo()) {
            this.mTvDeviceAuthFilterTitle.setVisibility(amVar.f12449O000000o.O000000o(0).getLanguage().equals("zh") ? 0 : 8);
        }
        this.mTvEmptyResults.setText(getResources().getString(R.string.voice_control_no_device_found));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        this.mRecyclerView.setHasFixedSize(true);
        Device O000000o2 = fno.O000000o().O000000o(this.O0000Ooo);
        ((DeviceAuthSlaveListActivity) getActivity()).mTitleTextView.setText("");
        if (O000000o2 != null) {
            this.mTvSelectDeviceName.setText(O000000o2.getName());
            ((DeviceAuthSlaveListActivity) getActivity()).mTitleTextView.setText(O000000o2.getName());
        } else {
            this.mTvSelectDeviceName.setText((int) R.string.auth_manager);
            ((DeviceAuthSlaveListActivity) getActivity()).mTitleTextView.setText((int) R.string.auth_manager);
        }
        ((DeviceAuthSlaveListActivity) getActivity()).mTitleTextView.setVisibility(4);
        this.mTvSelectDeviceName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.xiaomi.smarthome.device.authorization.page.DeviceAuthFragment.AnonymousClass1 */

            public final void onGlobalLayout() {
                DeviceAuthFragment.this.mTvSelectDeviceName.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                DeviceAuthFragment.this.mAppBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarLayout.OnOffsetChangedListener() {
                    /* class com.xiaomi.smarthome.device.authorization.page.DeviceAuthFragment.AnonymousClass1.AnonymousClass1 */

                    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                        if (Math.abs(i) >= DeviceAuthFragment.this.mTvSelectDeviceName.getMeasuredHeight()) {
                            ((DeviceAuthSlaveListActivity) DeviceAuthFragment.this.getActivity()).mTitleTextView.setVisibility(0);
                        } else {
                            ((DeviceAuthSlaveListActivity) DeviceAuthFragment.this.getActivity()).mTitleTextView.setVisibility(4);
                        }
                    }
                });
            }
        });
        this.mLlChangeControlMode.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.authorization.page.DeviceAuthFragment.AnonymousClass2 */

            public final void onClick(View view) {
                new ControlAuthPopWindow(DeviceAuthFragment.this.getActivity(), DeviceAuthFragment.this.mIvChangeControlArrow, DeviceAuthFragment.this.O0000o0, new ControlAuthPopWindow.O00000Oo() {
                    /* class com.xiaomi.smarthome.device.authorization.page.DeviceAuthFragment.AnonymousClass2.AnonymousClass1 */

                    public final void O000000o(String str) {
                        if (!TextUtils.equals(DeviceAuthFragment.this.O0000o0, str)) {
                            DeviceAuthFragment.this.O0000o0 = str;
                            if (TextUtils.equals(DeviceAuthFragment.this.O0000o0, DeviceAuthFragment.f7054O000000o)) {
                                DeviceAuthFragment.this.mTvAuthMode.setText((int) R.string.voice_control_device_auth_choose_dev_subtitle);
                                DeviceAuthFragment.this.O00000o0();
                                ((DeviceAuthSlaveListActivity) DeviceAuthFragment.this.getActivity()).setDeviceAuthChanged(true);
                                gqg.O00000Oo((int) R.string.auth_mode_change);
                            } else if (TextUtils.equals(DeviceAuthFragment.this.O0000o0, DeviceAuthFragment.O00000Oo)) {
                                DeviceAuthFragment.this.mTvAuthMode.setText((int) R.string.voice_control_device_auth_choose_home_room_subtitle);
                                DeviceAuthFragment.this.O00000o0();
                                ((DeviceAuthSlaveListActivity) DeviceAuthFragment.this.getActivity()).setDeviceAuthChanged(true);
                                gqg.O00000Oo((int) R.string.auth_mode_change);
                            }
                        }
                    }
                }).e_();
            }
        });
        this.mLlFilterDevice.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.authorization.page.DeviceAuthFragment.AnonymousClass3 */

            public final void onClick(View view) {
                if (DeviceAuthFragment.this.O0000Oo0 == null || DeviceAuthFragment.this.O0000Oo0.size() != 0) {
                    if (DeviceAuthFragment.this.O0000o0o == null) {
                        DeviceAuthFragment deviceAuthFragment = DeviceAuthFragment.this;
                        deviceAuthFragment.O0000o0o = new SettingsDeviceFilter(deviceAuthFragment.getActivity()) {
                            /* class com.xiaomi.smarthome.device.authorization.page.DeviceAuthFragment.AnonymousClass3.AnonymousClass1 */

                            public final void O000000o(List<fwi> list, List<fwi> list2, List<fwi> list3) {
                                if (list.size() == 0 && list2.size() == 0 && list3.size() == 0) {
                                    DeviceAuthFragment.this.O00000oo();
                                    return;
                                }
                                List<String> list4 = null;
                                List<String> O000000o2 = list.size() > 0 ? DeviceAuthFragment.O000000o(list) : null;
                                List<String> O00000Oo = list2.size() > 0 ? DeviceAuthFragment.O00000Oo(list2) : null;
                                if (list3.size() > 0) {
                                    list4 = DeviceAuthFragment.O00000o0(list3);
                                }
                                DeviceAuthFragment.this.O0000OOo.clear();
                                DeviceAuthFragment.this.O0000OOo = fnw.O000000o.O000000o(DeviceAuthFragment.this.O0000Oo0);
                                DeviceAuthFragment.this.O0000OOo.retainAll(DeviceAuthFragment.O000000o(DeviceAuthFragment.this.O0000OOo, DeviceAuthFragment.O00000Oo(O000000o2, DeviceAuthFragment.O00000Oo(O00000Oo, list4))));
                                DeviceAuthFragment.this.mTvEmptyResults.setText(DeviceAuthFragment.this.getResources().getString(R.string.voice_control_no_filter_result));
                                DeviceAuthFragment.this.mTvDeviceAuthFilterTitle.setTextColor(DeviceAuthFragment.this.getResources().getColor(R.color.mj_color_text_hightlight));
                                DeviceAuthFragment.this.O00000o0();
                            }

                            public final void O000000o() {
                                DeviceAuthFragment.this.mTvEmptyResults.setText(DeviceAuthFragment.this.getResources().getString(R.string.voice_control_no_device_found));
                                DeviceAuthFragment.this.O00000oo();
                            }

                            public final void O000000o(int i) {
                                hxi.O00000o.f952O000000o.O000000o("speaker_filter_panel_confirm", "type", Integer.valueOf(i));
                            }

                            public final void O00000Oo() {
                                hxi.O00000o.f952O000000o.O000000o("speaker_filter_show", new Object[0]);
                            }
                        };
                    }
                    hxi.O00000o.O0000o0(1);
                    DeviceAuthFragment.this.O0000o0o.O00000o0();
                    return;
                }
                hxi.O00000o.O0000o0(2);
                gqg.O00000Oo(DeviceAuthFragment.this.getString(R.string.voice_control_no_devices_to_filter));
            }
        });
        if (this.O0000o0O) {
            if (!this.O0000o00) {
                this.O0000o00 = true;
                gty.O000000o().initThirdAccountBind(new ibh<Void, Error>() {
                    /* class com.xiaomi.smarthome.device.authorization.page.DeviceAuthFragment.AnonymousClass4 */

                    public final void onFailure(Error error) {
                        if (DeviceAuthFragment.this.isValid()) {
                            DeviceAuthFragment.this.O000000o();
                        }
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        if (DeviceAuthFragment.this.isValid()) {
                            DeviceAuthFragment.this.O000000o();
                        }
                    }
                });
            }
            this.O0000o0O = false;
        }
    }

    public final void O000000o() {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.O0000Ooo)) {
            arrayList.add(this.O0000Ooo);
        }
        fmh.O000000o().O000000o(getActivity(), arrayList, new fsm<fnw, fso>() {
            /* class com.xiaomi.smarthome.device.authorization.page.DeviceAuthFragment.AnonymousClass5 */

            public final /* synthetic */ void onSuccess(Object obj) {
                fnw fnw = (fnw) obj;
                if (fnw != null) {
                    DeviceAuthFragment.this.O0000o0 = fnw.O00000Oo;
                    if (TextUtils.equals(DeviceAuthFragment.this.O0000o0, DeviceAuthFragment.f7054O000000o) && (fnw instanceof fnx)) {
                        DeviceAuthFragment.this.mTvAuthMode.setText((int) R.string.voice_control_device_auth_choose_dev_subtitle);
                        DeviceAuthFragment deviceAuthFragment = DeviceAuthFragment.this;
                        deviceAuthFragment.O00000oo = (fnx) fnw;
                        deviceAuthFragment.O0000OOo.clear();
                        DeviceAuthFragment deviceAuthFragment2 = DeviceAuthFragment.this;
                        deviceAuthFragment2.O0000Oo0 = deviceAuthFragment2.O00000oo.O00000o;
                        DeviceAuthFragment deviceAuthFragment3 = DeviceAuthFragment.this;
                        deviceAuthFragment3.O0000OOo = fnw.O000000o.O000000o(deviceAuthFragment3.O0000Oo0);
                        DeviceAuthFragment.this.O00000o0();
                    } else if (!TextUtils.equals(DeviceAuthFragment.this.O0000o0, DeviceAuthFragment.O00000Oo) || !(fnw instanceof fnz)) {
                        DeviceAuthFragment.this.O00000oO();
                    } else {
                        DeviceAuthFragment.this.mTvAuthMode.setText((int) R.string.voice_control_device_auth_choose_home_room_subtitle);
                        DeviceAuthFragment deviceAuthFragment4 = DeviceAuthFragment.this;
                        deviceAuthFragment4.O0000O0o = (fnz) fnw;
                        String str = deviceAuthFragment4.O0000O0o.f16727O000000o;
                        List list = DeviceAuthFragment.this.O0000O0o.O00000o0;
                        fnx fnx = new fnx();
                        fnx.f16727O000000o = str;
                        fnx.O00000o0 = list;
                        deviceAuthFragment4.O00000oo = fnx;
                        DeviceAuthFragment.this.O00000o0();
                    }
                } else {
                    DeviceAuthFragment.this.O00000oO();
                }
                ((DeviceAuthSlaveListActivity) DeviceAuthFragment.this.getActivity()).setDeviceDataReady(true, true);
                DeviceAuthFragment.this.O0000o00 = false;
            }

            public final void onFailure(fso fso) {
                DeviceAuthFragment.this.O00000oO();
                ((DeviceAuthSlaveListActivity) DeviceAuthFragment.this.getActivity()).setDeviceDataReady(true, false);
                DeviceAuthFragment.this.O0000o00 = false;
            }
        });
    }

    public final void O00000Oo() {
        fnx fnx = this.O00000oo;
        if (fnx != null) {
            int i = 0;
            if (fnx.O00000oo.compareAndSet(false, true)) {
                for (int i2 = 0; i2 < this.O0000OOo.size(); i2++) {
                    this.O0000OOo.get(i2).O00000Oo = "1";
                    this.O0000Oo.put(i2, true);
                }
            } else {
                this.O00000oo.O00000oo.set(false);
            }
            hbi hbi = this.O00000o;
            if (hbi == null) {
                O0000OOo();
            } else {
                hbi.notifyDataSetChanged();
            }
            View view = this.O0000oo;
            if (view != null) {
                if (this.O00000oo.O00000oo.get()) {
                    i = 8;
                }
                view.setVisibility(i);
            }
            ((DeviceAuthSlaveListActivity) getActivity()).setDeviceAuthChanged(true);
        }
    }

    private void O0000O0o() {
        fnz fnz;
        fnx fnx;
        this.mSelectAllBtn.setOnCheckedChangeListener(null);
        if (TextUtils.equals(this.O0000o0, f7054O000000o) && (fnx = this.O00000oo) != null) {
            this.mSelectAllBtn.setChecked(fnx.O00000oo.get());
        } else if (TextUtils.equals(this.O0000o0, O00000Oo) && (fnz = this.O0000O0o) != null) {
            this.mSelectAllBtn.setChecked(fnz.O00000oO);
        }
        this.mSelectAllBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.device.authorization.page.DeviceAuthFragment.AnonymousClass6 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (TextUtils.equals(DeviceAuthFragment.this.O0000o0, DeviceAuthFragment.f7054O000000o)) {
                    DeviceAuthFragment.this.O00000Oo();
                } else if (TextUtils.equals(DeviceAuthFragment.this.O0000o0, DeviceAuthFragment.O00000Oo)) {
                    DeviceAuthFragment deviceAuthFragment = DeviceAuthFragment.this;
                    if (deviceAuthFragment.O0000O0o != null) {
                        if (!deviceAuthFragment.O0000O0o.O00000oO) {
                            List<String> list = deviceAuthFragment.O0000O0o.O0000Oo0;
                            List<Room> O000000o2 = ggb.O00000Oo().O000000o(deviceAuthFragment.O0000O0o.O0000OOo);
                            if (O000000o2 != null) {
                                list.clear();
                                for (Room id : O000000o2) {
                                    list.add(id.getId());
                                }
                            }
                            deviceAuthFragment.O0000O0o.O00000oO = true;
                        } else {
                            deviceAuthFragment.O0000O0o.O00000oO = false;
                        }
                        if (deviceAuthFragment.O00000oO == null) {
                            deviceAuthFragment.O00000o();
                        } else {
                            deviceAuthFragment.O00000oO.notifyDataSetChanged();
                        }
                        ((DeviceAuthSlaveListActivity) deviceAuthFragment.getActivity()).setDeviceAuthChanged(true);
                    }
                }
            }
        });
    }

    public final void O00000o0() {
        this.mDividerLine.setVisibility(0);
        if (TextUtils.equals(this.O0000o0, f7054O000000o)) {
            this.mRlHomeSelect.setVisibility(8);
            this.mFilterDeviceLayout.setVisibility(0);
            this.mAutoSelectTv.setText((int) R.string.voice_control_device_auth_device);
            O0000OOo();
        } else if (TextUtils.equals(this.O0000o0, O00000Oo)) {
            this.mRlHomeSelect.setVisibility(0);
            this.mFilterDeviceLayout.setVisibility(8);
            this.mAutoSelectTv.setText((int) R.string.voice_control_device_auth_room);
            if (this.O0000O0o == null && ggb.O00000Oo().O0000o0(this.O0000Ooo) != null) {
                this.O0000O0o = fnz.O000000o(this.O0000Ooo, ggb.O00000Oo().O0000o0(this.O0000Ooo).getId());
            }
            O00000o();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, androidx.recyclerview.widget.RecyclerView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void O0000OOo() {
        this.O0000Oo.clear();
        if (this.O0000OOo.isEmpty()) {
            O00000oO();
            return;
        }
        O0000Oo0();
        if (this.O0000o == null) {
            this.O0000o = LayoutInflater.from(this.mContext).inflate((int) R.layout.fragment_auth_device_footer, (ViewGroup) this.mRecyclerView, false);
            this.O0000oo = this.O0000o.findViewById(R.id.rl_new_device_auto_auth);
            this.O0000OoO = (SwitchButton) this.O0000o.findViewById(R.id.btn_auto_auth);
        }
        if (this.O00000o == null) {
            this.O00000o = new hbi(new DeviceAuthAdapter());
            this.O00000o.O000000o(this.O0000o);
        }
        this.O0000oo.setVisibility(this.O00000oo.O00000oo.get() ? 8 : 0);
        this.O0000OoO.setOnCheckedChangeListener(null);
        this.O0000OoO.setChecked(this.O00000oo.O0000O0o);
        this.O0000OoO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.device.authorization.page.$$Lambda$DeviceAuthFragment$CWbPUTMckDzZFdVMm7wUfAEyZZQ */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                DeviceAuthFragment.this.O000000o(compoundButton, z);
            }
        });
        this.mRecyclerView.setAdapter(this.O00000o);
        this.O00000o.notifyDataSetChanged();
        this.menuLayout.setVisibility(0);
        O0000O0o();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(CompoundButton compoundButton, boolean z) {
        this.O00000oo.O0000O0o = z;
        ((DeviceAuthSlaveListActivity) getActivity()).setDeviceAuthChanged(true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, androidx.recyclerview.widget.RecyclerView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final void O00000o() {
        boolean z;
        fnz fnz = this.O0000O0o;
        if (fnz == null) {
            O00000oO();
            return;
        }
        Home O00000o2 = ggb.O00000Oo().O00000o(fnz.O0000OOo);
        if (O00000o2 == null) {
            O00000oO();
            return;
        }
        O0000Oo0();
        int i = 0;
        if (this.O0000oO0 == null) {
            this.O0000oO0 = LayoutInflater.from(this.mContext).inflate((int) R.layout.fragment_auth_home_room_footer, (ViewGroup) this.mRecyclerView, false);
            this.O0000oOo = this.O0000oO0.findViewById(R.id.other_platform_device);
            this.O0000oo0 = (SwitchButton) this.O0000oO0.findViewById(R.id.btn_other_platform_device);
            this.O0000oO = this.O0000oO0.findViewById(R.id.shared_device);
            this.O0000oOO = (SwitchButton) this.O0000oO0.findViewById(R.id.btn_shared_device);
        }
        List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
        int i2 = 0;
        while (true) {
            if (i2 >= list.size()) {
                z = false;
                break;
            } else if (!list.get(i2).isOwner()) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        gge.O000000o();
        if (!gge.O00000oO().isEmpty() || z) {
            this.O0000oO.setVisibility(0);
        }
        if (gty.O000000o().getAllThirdAccountDeviceNum() > 0) {
            this.O0000oOo.setVisibility(0);
        }
        TextView textView = this.mTvHomeName;
        ggb.O00000Oo();
        textView.setText(ggb.O000000o(O00000o2));
        this.O0000oOO.setOnCheckedChangeListener(null);
        this.O0000oo0.setOnCheckedChangeListener(null);
        this.O0000oOO.setChecked(this.O0000O0o.O00000oo);
        this.O0000oo0.setChecked(this.O0000O0o.O0000O0o);
        this.mRlHomeSelect.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.authorization.page.DeviceAuthFragment.AnonymousClass7 */

            public final void onClick(View view) {
                new ControlHomeSelectPopupWindow(DeviceAuthFragment.this.getActivity(), DeviceAuthFragment.this.mIvSelectHomeArrow, DeviceAuthFragment.this.O0000Ooo, DeviceAuthFragment.this.O0000O0o.O0000OOo, new HomeListDialogHelper.O00000Oo() {
                    /* class com.xiaomi.smarthome.device.authorization.page.DeviceAuthFragment.AnonymousClass7.AnonymousClass1 */

                    public final void O000000o(Object obj) {
                        if (obj instanceof String) {
                            String str = (String) obj;
                            if (!TextUtils.equals(DeviceAuthFragment.this.O0000O0o.O0000OOo, str)) {
                                DeviceAuthFragment.this.O0000O0o = fnz.O000000o(DeviceAuthFragment.this.O0000Ooo, str);
                                DeviceAuthFragment.this.O00000o0();
                                ((DeviceAuthSlaveListActivity) DeviceAuthFragment.this.getActivity()).setDeviceAuthChanged(true);
                            }
                        }
                    }
                }).e_();
            }
        });
        this.O0000oOO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.device.authorization.page.DeviceAuthFragment.AnonymousClass8 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                DeviceAuthFragment.this.O0000O0o.O00000oo = z;
                ((DeviceAuthSlaveListActivity) DeviceAuthFragment.this.getActivity()).setDeviceAuthChanged(true);
            }
        });
        this.O0000oo0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.device.authorization.page.DeviceAuthFragment.AnonymousClass9 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                DeviceAuthFragment.this.O0000O0o.O0000O0o = z;
                ((DeviceAuthSlaveListActivity) DeviceAuthFragment.this.getActivity()).setDeviceAuthChanged(true);
            }
        });
        this.O00000oO = new hbi(new HomeRoomAdapter(O00000o2));
        this.O00000oO.O000000o(this.O0000oO0);
        this.mRecyclerView.setAdapter(this.O00000oO);
        this.O00000oO.notifyDataSetChanged();
        View view = this.menuLayout;
        if (this.O00000oO.getItemCount() <= 0) {
            i = 8;
        }
        view.setVisibility(i);
        O0000O0o();
    }

    private void O0000Oo0() {
        this.emptyView.setVisibility(8);
        this.mRecyclerView.setVisibility(0);
    }

    public final void O00000oO() {
        this.emptyView.setVisibility(0);
        this.mRecyclerView.setVisibility(8);
    }

    public final void O00000oo() {
        this.O0000OOo.clear();
        this.O0000OOo = fnw.O000000o.O000000o(this.O0000Oo0);
        O00000o0();
        this.mTvDeviceAuthFilterTitle.setTextColor(getResources().getColor(R.color.mj_color_gray_normal));
    }

    public static List<fnw.O000000o> O000000o(List<fnw.O000000o> list, List<String> list2) {
        ArrayList arrayList = new ArrayList();
        if (!(list2 == null || list2.size() == 0)) {
            for (int i = 0; i < list2.size(); i++) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (TextUtils.equals(list.get(i2).f16728O000000o, list2.get(i))) {
                        arrayList.add(list.get(i2));
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<String> O000000o(List<fwi> list) {
        ArrayList arrayList = new ArrayList();
        for (fwi fwi : list) {
            for (Device did : ggb.O00000Oo().O0000Oo(fwi.O00000Oo)) {
                arrayList.add(did.getDid());
            }
        }
        return arrayList;
    }

    public static List<String> O00000Oo(List<fwi> list) {
        ArrayList arrayList = new ArrayList();
        for (fwi fwi : list) {
            for (Device did : ggb.O00000Oo().O00000Oo(ggb.O00000Oo().O00000o0(fwi.O00000Oo))) {
                arrayList.add(did.getDid());
            }
        }
        return arrayList;
    }

    public static List<String> O00000o0(List<fwi> list) {
        ArrayList arrayList = new ArrayList();
        for (String O0000Oo2 : ggb.O00000o0.f17714O000000o) {
            Map<String, List<String>> O0000Oo3 = fnn.O000000o().O00000Oo().O0000Oo(O0000Oo2);
            for (fwi fwi : list) {
                List list2 = O0000Oo3.get(fnn.O000000o().O00000Oo().O0000OOo(fwi.O00000Oo).name);
                if (list2 != null && list2.size() > 0) {
                    arrayList.addAll(list2);
                }
            }
        }
        return arrayList;
    }

    public static List<String> O00000Oo(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        if (list.size() == 0 || list2.size() == 0) {
            return new ArrayList();
        }
        list.retainAll(list2);
        return list;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mTvDeviceAuthFilterTitle.setVisibility(ftn.O00000oo(getContext()) ? 0 : 8);
    }
}

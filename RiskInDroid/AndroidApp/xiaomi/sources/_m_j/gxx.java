package _m_j;

import _m_j.grk;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.family.ShareDeviceActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.DevicePtrFrameLayout;
import com.xiaomi.smarthome.library.common.widget.SmartHomePtrHeader;
import com.xiaomi.smarthome.library.common.widget.sectionedrecyclerviewadapter.Section;
import com.xiaomi.smarthome.miio.db.record.ShareUserRecord;
import com.xiaomi.smarthome.miio.page.ShareDeviceDetail;
import com.xiaomi.smarthome.miio.page.deviceshare.ShareDeviceInfoActivity;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.indicator.PtrIndicator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public final class gxx extends fvm {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<Device> f18503O000000o = new ArrayList();
    XQProgressDialog O00000Oo;
    View O00000o;
    public HashMap<String, List<hsx>> O00000o0 = new HashMap<>();
    public ImageView O00000oO;
    View O00000oo;
    public TextView O0000O0o;
    public boolean O0000OOo = false;
    public grl O0000Oo;
    public SparseBooleanArray O0000Oo0 = new SparseBooleanArray();
    public DevicePtrFrameLayout O0000OoO;
    public boolean O0000Ooo;
    private TextView O0000o;
    private View O0000o0;
    public int O0000o00 = 0;
    private View O0000o0O;
    private ImageView O0000o0o;
    private SmartHomePtrHeader O0000oO;
    private RecyclerView O0000oO0;
    private PtrIndicator O0000oOO;
    private RecyclerView.O0000Oo O0000oOo;
    private boolean O0000oo = false;
    private boolean O0000oo0 = false;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        List<Device> O00000o02;
        View view = this.O0000o0;
        if (view == null) {
            this.O0000o0 = layoutInflater.inflate((int) R.layout.share_device_layout_v2, (ViewGroup) null);
            this.O0000o0O = this.O0000o0.findViewById(R.id.common_white_empty_view);
            this.O0000o0O.setVisibility(8);
            this.O0000oO0 = (RecyclerView) this.O0000o0.findViewById(R.id.share_device_list);
            this.O0000oO0.setLayoutManager(new LinearLayoutManager(getActivity()));
            this.O0000oOo = new hac();
            this.O0000OoO = (DevicePtrFrameLayout) this.O0000o0.findViewById(R.id.pull_down_refresh);
            this.O0000Oo = new grl();
            this.O0000oO0.setAdapter(this.O0000Oo);
            if (!(getActivity() == null || getActivity().findViewById(R.id.top_delete_bar) == null)) {
                this.O00000o = getActivity().findViewById(R.id.top_delete_bar);
                this.O0000O0o = (TextView) this.O00000o.findViewById(R.id.selected_cnt);
                this.O0000o0o = (ImageView) this.O00000o.findViewById(R.id.cancel_btn);
                this.O00000oO = (ImageView) this.O00000o.findViewById(R.id.select_all_btn);
                this.O00000oo = this.O0000o0.findViewById(R.id.bottom_delete_bar);
                this.O0000o = (TextView) this.O00000oo.findViewById(R.id.delete_msg_btn);
                this.O0000o.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.gxx.AnonymousClass5 */

                    public final void onClick(View view) {
                        gxx gxx = gxx.this;
                        if (gxx.O0000Oo0.size() == 0) {
                            gxx.getActivity();
                            gqg.O000000o((int) R.string.share_no_device);
                            return;
                        }
                        Intent intent = new Intent();
                        intent.setClass(gxx.mContext, ShareDeviceActivity.class);
                        if (gxx.O0000Oo0.size() == 1) {
                            intent.putExtra("user_id", CoreApi.O000000o().O0000o0());
                            intent.putExtra("did", gxx.f18503O000000o.get(gxx.O0000Oo0.keyAt(0)).did);
                        } else {
                            ArrayList arrayList = new ArrayList();
                            for (int i = 0; i < gxx.O0000Oo0.size(); i++) {
                                int keyAt = gxx.O0000Oo0.keyAt(i);
                                if (gxx.O0000Oo0.get(keyAt) && gxx.f18503O000000o.size() > keyAt) {
                                    arrayList.add(gxx.f18503O000000o.get(keyAt).did);
                                }
                            }
                            Bundle bundle = new Bundle();
                            bundle.putString("user_id", CoreApi.O000000o().O0000o0());
                            bundle.putStringArrayList("batch_dids", arrayList);
                            intent.putExtras(bundle);
                        }
                        gxx.mContext.startActivity(intent);
                    }
                });
            }
            if (this.O0000oo && !this.O0000oo0) {
                this.O0000oo0 = true;
                onPageSelected();
            }
            this.O0000oO = (SmartHomePtrHeader) this.O0000o0.findViewById(R.id.pull_header_new);
            this.O0000oOO = new PtrIndicator();
            this.O0000OoO.disableWhenHorizontalMove(true);
            this.O0000OoO.setPullToRefresh(false);
            this.O0000OoO.setPtrIndicator(this.O0000oOO);
            this.O0000OoO.addPtrUIHandler(new gqq());
            this.O0000OoO.setPtrHandler(new PtrDefaultHandler() {
                /* class _m_j.gxx.AnonymousClass1 */

                public final void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                    gxx.this.O000000o();
                }
            });
            FragmentActivity activity = getActivity();
            if (activity != null) {
                this.O00000Oo = new XQProgressDialog(activity);
                this.O00000Oo.setCancelable(false);
                this.O00000Oo.setMessage(getResources().getString(R.string.loading_share_info));
                List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
                if (list == null || list.isEmpty()) {
                    this.O0000oO0.setVisibility(8);
                    this.O0000o0O.setVisibility(0);
                } else {
                    this.f18503O000000o.clear();
                    Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
                    ArrayList<Home> arrayList = new ArrayList<>();
                    for (int i = 0; i < list.size(); i++) {
                        Home home = list.get(i);
                        if (!(home == null || (O00000o02 = gge.O000000o().O00000o0(home.getId())) == null || O00000o02.isEmpty())) {
                            ArrayList arrayList2 = new ArrayList();
                            for (int i2 = 0; i2 < O00000o02.size(); i2++) {
                                Device device = O00000o02.get(i2);
                                if (device != null && DeviceRouterFactory.getDeviceWrapper().canBeShared(device)) {
                                    arrayList2.add(device);
                                }
                            }
                            if (!arrayList2.isEmpty()) {
                                this.f18503O000000o.addAll(arrayList2);
                                if (O0000Oo02 == null || !TextUtils.equals(O0000Oo02.getId(), home.getId())) {
                                    arrayList.add(home);
                                } else {
                                    arrayList.add(0, home);
                                }
                            }
                        }
                    }
                    this.O0000o00 = arrayList.size();
                    for (Home home2 : arrayList) {
                        List<Device> O00000o03 = gge.O000000o().O00000o0(home2.getId());
                        if (O00000o03 != null && !O00000o03.isEmpty()) {
                            ArrayList arrayList3 = new ArrayList();
                            for (int i3 = 0; i3 < O00000o03.size(); i3++) {
                                Device device2 = O00000o03.get(i3);
                                if (device2 != null && DeviceRouterFactory.getDeviceWrapper().canBeShared(device2)) {
                                    arrayList3.add(device2);
                                }
                            }
                            if (!arrayList3.isEmpty()) {
                                grl grl = this.O0000Oo;
                                ggb.O00000Oo();
                                grl.O000000o(new O000000o(ggb.O000000o(home2), arrayList3));
                            }
                        }
                    }
                    ((TextView) this.O0000o0.findViewById(R.id.common_white_empty_text)).setText((int) R.string.share_no_device);
                    if (this.O0000o00 == 0) {
                        this.O0000oO0.setVisibility(8);
                        this.O0000o0O.setVisibility(0);
                    } else {
                        this.O0000Oo.notifyDataSetChanged();
                    }
                }
            }
        } else if (view.getParent() != null) {
            ((ViewGroup) this.O0000o0.getParent()).removeView(this.O0000o0);
        }
        return this.O0000o0;
    }

    public final void onResume() {
        super.onResume();
        O000000o();
    }

    public final void onPause() {
        super.onPause();
        this.O0000Ooo = false;
    }

    public final void O000000o() {
        fuh.O000000o().O000000o(getActivity(), new fsm<HashMap<String, List<hsx>>, fso>() {
            /* class _m_j.gxx.AnonymousClass2 */

            public final /* synthetic */ void onSuccess(Object obj) {
                HashMap<String, List<hsx>> hashMap = (HashMap) obj;
                if (gxx.this.isValid()) {
                    if (!gxx.this.O0000Ooo) {
                        gxx.this.O0000Ooo = true;
                        hxp hxp = hxi.O00000o0;
                        int size = hashMap.size();
                        hxp.f957O000000o.O000000o("mine_deviceshare_show", "shareable_devices", Integer.valueOf(size));
                    }
                    gxx.this.O00000o0 = hashMap;
                    Set<String> keySet = hashMap.keySet();
                    final ArrayList arrayList = new ArrayList();
                    for (String str : keySet) {
                        arrayList.addAll(hashMap.get(str));
                    }
                    ServiceApplication.getGlobalWorkerHandler().post(new Runnable() {
                        /* class _m_j.gxx.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            ShareUserRecord.batchInsert(arrayList);
                        }
                    });
                    gxx.this.O0000Oo.notifyDataSetChanged();
                    if (gxx.this.O00000Oo != null) {
                        gxx.this.O00000Oo.dismiss();
                    }
                    gxx.this.O0000OoO.refreshComplete();
                }
            }

            public final void onFailure(fso fso) {
                if (gxx.this.isValid()) {
                    if (gxx.this.O00000Oo != null) {
                        gxx.this.O00000Oo.dismiss();
                    }
                    gxx.this.O0000Oo.notifyDataSetChanged();
                    gxx.this.O0000OoO.refreshComplete();
                }
            }
        });
    }

    public class O000000o extends Section {
        private List<Device> O00000Oo;
        private String O00000o0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O000000o(String str, List<Device> list) {
            super(new grk.O000000o(R.layout.message_item_new).O000000o(gxx.this.O0000o00 <= 1 ? R.layout.common_list_space_empty : R.layout.common_list_section_1).O000000o());
            this.O00000Oo = list;
            this.O00000o0 = str;
        }

        public final int O000000o() {
            return this.O00000Oo.size();
        }

        public final RecyclerView.O000OOo0 O00000Oo(View view) {
            return new C0110O000000o(view);
        }

        public final RecyclerView.O000OOo0 O000000o(View view) {
            return new O00000Oo(view);
        }

        public final void O000000o(RecyclerView.O000OOo0 o000OOo0, int i) {
            String str;
            final C0110O000000o o000000o = (C0110O000000o) o000OOo0;
            Device device = this.O00000Oo.get(i);
            final int i2 = 0;
            while (true) {
                if (i2 >= gxx.this.f18503O000000o.size()) {
                    i2 = 0;
                    break;
                }
                Device device2 = gxx.this.f18503O000000o.get(i2);
                if (device2 != null && TextUtils.equals(device.did, device2.did)) {
                    break;
                }
                i2++;
            }
            o000000o.O00000oO.setText(gxx.this.f18503O000000o.get(i2).name);
            o000000o.f18515O000000o.setVisibility(8);
            List list = gxx.this.O00000o0.get(gxx.this.f18503O000000o.get(i2).did);
            if (i == O000000o() - 1) {
                o000000o.O0000OOo.setBackgroundResource(R.drawable.mj_rs_common_white_list_padding_no_left_margin);
            } else {
                o000000o.O0000OOo.setBackgroundResource(R.drawable.mj_rs_common_white_list_padding);
            }
            if (list == null || list.size() == 0) {
                str = gxx.this.getString(R.string.smarthome_not_shared);
            } else {
                StringBuilder sb = new StringBuilder();
                int i3 = 0;
                while (i3 < list.size() && i3 < 2) {
                    if (i3 != 0) {
                        sb.append(',');
                    }
                    sb.append(((hsx) list.get(i3)).O00000Oo);
                    i3++;
                }
                if (list.size() > 2) {
                    str = gxx.this.getResources().getQuantityString(R.plurals.smarthome_has_shared_to_user_more, list.size(), sb.toString(), Integer.valueOf(list.size()));
                } else {
                    str = gxx.this.getString(R.string.smarthome_has_shared_to_user, sb.toString());
                }
            }
            o000000o.O00000oo.setText(str);
            if (o000000o.O00000Oo != null) {
                o000000o.O00000Oo.setHierarchy(new GenericDraweeHierarchyBuilder(o000000o.O00000Oo.getResources()).setFadeDuration(200).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).setPlaceholderImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).build());
                DeviceFactory.O00000Oo(device.model, o000000o.O00000Oo);
            }
            o000000o.O0000OOo.setOnLongClickListener(new View.OnLongClickListener() {
                /* class _m_j.gxx.O000000o.AnonymousClass1 */

                public final boolean onLongClick(View view) {
                    if (!gxx.this.O0000OOo) {
                        if (!gxx.this.O0000Oo0.get(i2)) {
                            o000000o.O00000o.performClick();
                        }
                        gxx gxx = gxx.this;
                        gxx.O00000o.setVisibility(0);
                        gxx.O00000oo.setVisibility(0);
                        gxx.O00000o.measure(0, 0);
                        gxx.O00000oo.measure(0, 0);
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(gxx.O00000o, View.Y, (float) (-gxx.O00000o.getMeasuredHeight()), 0.0f);
                        ViewGroup viewGroup = (ViewGroup) gxx.O00000oo.getParent();
                        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(gxx.O00000oo, View.Y, (float) viewGroup.getHeight(), (float) (viewGroup.getHeight() - gxx.O00000oo.getMeasuredHeight()));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.setDuration(200L);
                        animatorSet.play(ofFloat).with(ofFloat2);
                        animatorSet.start();
                        gxx.this.O0000OOo = true;
                        gxx.this.O0000Oo.notifyDataSetChanged();
                        ((ShareDeviceInfoActivity) gxx.this.getActivity()).setViewPagerSwipe(false);
                    }
                    return true;
                }
            });
            o000000o.O00000o.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.gxx.O000000o.AnonymousClass2 */

                public final void onClick(View view) {
                    if (!gxx.this.O0000Oo0.get(i2)) {
                        gxx.this.O0000Oo0.put(i2, true);
                    } else {
                        gxx.this.O0000Oo0.delete(i2);
                    }
                    if (gxx.this.O0000Oo0.size() == gxx.this.f18503O000000o.size()) {
                        gxx.this.O00000oO.setImageResource(R.drawable.un_select_selector);
                        gxx.this.O00000oO.setContentDescription(gxx.this.getString(R.string.unselect_all));
                    } else {
                        gxx.this.O00000oO.setImageResource(R.drawable.all_select_selector);
                        gxx.this.O00000oO.setContentDescription(gxx.this.getString(R.string.select_all));
                    }
                    if (gxx.this.O0000Oo0.size() > 0) {
                        gxx.this.O0000O0o.setVisibility(0);
                        gxx.this.O0000O0o.setText(gxx.this.getResources().getQuantityString(R.plurals.selected_cnt_tips, gxx.this.O0000Oo0.size(), Integer.valueOf(gxx.this.O0000Oo0.size())));
                        return;
                    }
                    gxx.this.O0000O0o.setVisibility(0);
                    gxx.this.O0000O0o.setText(gxx.this.getString(R.string.selected_0_cnt_tips));
                }
            });
            if (gxx.this.O0000OOo) {
                o000000o.f18515O000000o.setVisibility(0);
                o000000o.O00000o.setVisibility(0);
                o000000o.O00000o0.setVisibility(8);
                o000000o.O0000O0o.setVisibility(8);
                o000000o.O0000OOo.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.gxx.O000000o.AnonymousClass3 */

                    public final void onClick(View view) {
                        o000000o.O00000o.performClick();
                    }
                });
                if (gxx.this.O0000Oo0.get(i2)) {
                    o000000o.O00000o.setChecked(true);
                } else {
                    o000000o.O00000o.setChecked(false);
                }
            } else {
                o000000o.f18515O000000o.setVisibility(0);
                o000000o.O00000o.setVisibility(8);
                o000000o.O00000o0.setVisibility(8);
                o000000o.O0000O0o.setVisibility(0);
                o000000o.O0000OOo.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.gxx.O000000o.AnonymousClass4 */

                    public final void onClick(View view) {
                        hxk hxk = hxi.O00000o;
                        String str = gxx.this.f18503O000000o.get(i2).model;
                        hxk.f952O000000o.O000000o("share_near_click", "model", str);
                        Intent intent = new Intent();
                        intent.setClass(gxx.this.getActivity(), ShareDeviceDetail.class);
                        intent.putExtra("did", gxx.this.f18503O000000o.get(i2).did);
                        intent.putExtra("pid", gxx.this.f18503O000000o.get(i2).pid);
                        Bundle arguments = gxx.this.getArguments();
                        if (arguments != null) {
                            intent.putExtra("key_from_page_ref", arguments.getBoolean("param_key_ref_from_app"));
                        }
                        gxx.this.startActivity(intent);
                        hxi.O00000o.f952O000000o.O000000o("mine_deviceshare_device", new Object[0]);
                    }
                });
            }
        }

        public final void O000000o(RecyclerView.O000OOo0 o000OOo0) {
            if (gxx.this.O0000o00 > 1) {
                ((O00000Oo) o000OOo0).f18516O000000o.setText(this.O00000o0);
            }
        }

        /* renamed from: _m_j.gxx$O000000o$O000000o  reason: collision with other inner class name */
        class C0110O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            View f18515O000000o;
            SimpleDraweeView O00000Oo;
            CheckBox O00000o;
            TextView O00000o0;
            TextView O00000oO;
            TextView O00000oo;
            View O0000O0o;
            View O0000OOo;

            public C0110O000000o(View view) {
                super(view);
                this.O0000OOo = view;
                this.O00000Oo = (SimpleDraweeView) view.findViewById(R.id.device_icon);
                this.O00000o0 = (TextView) view.findViewById(R.id.right_tv);
                this.O00000o = (CheckBox) view.findViewById(R.id.ratio_btn);
                this.O00000oO = (TextView) view.findViewById(R.id.device_item);
                this.O00000oo = (TextView) view.findViewById(R.id.device_item_info);
                this.f18515O000000o = view.findViewById(R.id.right_fl);
                this.O0000O0o = view.findViewById(R.id.arrow);
            }
        }

        class O00000Oo extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            TextView f18516O000000o;

            public O00000Oo(View view) {
                super(view);
                this.f18516O000000o = (TextView) view.findViewById(R.id.f3590tv);
            }
        }
    }

    public final void onPageSelected() {
        ImageView imageView = this.O0000o0o;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.gxx.AnonymousClass3 */

                public final void onClick(View view) {
                    ((ShareDeviceInfoActivity) gxx.this.getActivity()).setViewPagerSwipe(true);
                    gxx.this.O00000Oo();
                }
            });
        }
        ImageView imageView2 = this.O00000oO;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.gxx.AnonymousClass4 */

                public final void onClick(View view) {
                    if (gxx.this.O0000Oo0.size() == gxx.this.f18503O000000o.size()) {
                        gxx gxx = gxx.this;
                        gxx.O0000Oo0.clear();
                        gxx.O00000oO.setImageResource(R.drawable.all_select_selector);
                        gxx.O00000oO.setContentDescription(gxx.getString(R.string.select_all));
                        gxx.O0000Oo.notifyDataSetChanged();
                        gxx.O0000O0o.setVisibility(8);
                        return;
                    }
                    gxx gxx2 = gxx.this;
                    int size = gxx2.f18503O000000o.size();
                    for (int i = 0; i < size; i++) {
                        gxx2.O0000Oo0.put(i, true);
                    }
                    gxx2.O00000oO.setImageResource(R.drawable.un_select_selector);
                    gxx2.O00000oO.setContentDescription(gxx2.getString(R.string.unselect_all));
                    gxx2.O0000Oo.notifyDataSetChanged();
                    gxx2.O0000O0o.setVisibility(0);
                    gxx2.O0000O0o.setText(gxx2.getResources().getQuantityString(R.plurals.selected_cnt_tips, gxx2.O0000Oo0.size(), Integer.valueOf(gxx2.O0000Oo0.size())));
                }
            });
        }
    }

    public final void setMenuVisibility(boolean z) {
        super.setMenuVisibility(z);
        this.O0000oo = z;
        if (!z) {
            return;
        }
        if (getView() == null) {
            this.O0000oo0 = false;
            return;
        }
        onPageSelected();
        this.O0000oo0 = true;
    }

    public final void O00000Oo() {
        this.O0000OOo = false;
        this.O0000Oo0.clear();
        this.O00000o.setVisibility(8);
        this.O00000oo.setVisibility(8);
        this.O0000Oo.notifyDataSetChanged();
    }

    public final boolean onBackPressed() {
        if (!this.O0000OOo) {
            return false;
        }
        O00000Oo();
        return true;
    }
}

package com.xiaomi.smarthome.auth;

import _m_j.fah;
import _m_j.fak;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gsy;
import _m_j.izb;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.ListViewWithFixedHeight;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AuthManagerDetailActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    AuthAdapter f4248O000000o;
    List<Device> O00000Oo = new ArrayList();
    private List<fah> O00000o = new ArrayList();
    final fno.O000000o O00000o0 = new fno.O000000o() {
        /* class com.xiaomi.smarthome.auth.AuthManagerDetailActivity.AnonymousClass4 */

        public final void onRefreshClientDeviceChanged(int i, Device device) {
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            if (i == 3) {
                if (fak.O000000o().O00000Oo()) {
                    AuthManagerDetailActivity.this.initDevices(true);
                } else {
                    AuthManagerDetailActivity.this.initDevices(false);
                }
                if (AuthManagerDetailActivity.this.O00000Oo != null) {
                    AuthManagerDetailActivity.this.f4248O000000o.notifyDataSetChanged();
                    fno.O000000o().O00000Oo(AuthManagerDetailActivity.this.O00000o0);
                }
            }
        }
    };
    public String appId;
    @BindView(6481)
    TextView mAppAuthTimeTV;
    @BindView(7209)
    SimpleDraweeView mAppIcon;
    @BindView(7639)
    TextView mAppNameTV;
    @BindView(7573)
    ImageView mBackIV;
    @BindView(6833)
    TextView mDeleteAuth;
    @BindView(6479)
    ListViewWithFixedHeight mListView;
    @BindView(7578)
    TextView mTitleTV;

    class AuthAdapter extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        Context f4254O000000o;

        public final long getItemId(int i) {
            return (long) i;
        }

        public class ViewHolder_ViewBinding implements Unbinder {

            /* renamed from: O000000o  reason: collision with root package name */
            private ViewHolder f4256O000000o;

            public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
                this.f4256O000000o = viewHolder;
                viewHolder.mImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.image, "field 'mImage'", SimpleDraweeView.class);
                viewHolder.mNameTV = (TextView) Utils.findRequiredViewAsType(view, R.id.name, "field 'mNameTV'", TextView.class);
            }

            public void unbind() {
                ViewHolder viewHolder = this.f4256O000000o;
                if (viewHolder != null) {
                    this.f4256O000000o = null;
                    viewHolder.mImage = null;
                    viewHolder.mNameTV = null;
                    return;
                }
                throw new IllegalStateException("Bindings already cleared.");
            }
        }

        public AuthAdapter(Context context) {
            this.f4254O000000o = context;
        }

        public final int getCount() {
            return AuthManagerDetailActivity.this.O00000Oo.size();
        }

        public final Object getItem(int i) {
            return AuthManagerDetailActivity.this.O00000Oo.get(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(this.f4254O000000o).inflate((int) R.layout.activity_auth_manager_detail_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.mImage.setHierarchy(new GenericDraweeHierarchyBuilder(viewHolder.mImage.getResources()).setFadeDuration(200).setPlaceholderImage(viewHolder.mImage.getResources().getDrawable(R.drawable.device_list_phone_no)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
            Device device = AuthManagerDetailActivity.this.O00000Oo.get(i);
            if (device != null) {
                DeviceFactory.O00000Oo(device.model, viewHolder.mImage);
            } else {
                DeviceFactory.O00000Oo((String) null, viewHolder.mImage);
            }
            viewHolder.mNameTV.setText(device.getName());
            return view;
        }

        class ViewHolder {
            @BindView(7209)
            SimpleDraweeView mImage;
            @BindView(7639)
            TextView mNameTV;

            public ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fak.O000000o(_m_j.fsm, boolean):void
     arg types: [com.xiaomi.smarthome.auth.AuthManagerDetailActivity$1, int]
     candidates:
      _m_j.fak.O000000o(java.lang.String, _m_j.fsm):_m_j.fsn
      _m_j.fak.O000000o(java.util.List<java.lang.String>, _m_j.fsm):_m_j.fsn
      _m_j.fak.O000000o(_m_j.fsm, boolean):void */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_auth_manager_detail_layout);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        if (intent != null) {
            this.appId = intent.getStringExtra("extra_application_id");
            fak.O000000o().f16002O000000o = this.appId;
        } else {
            setResult(-100, null);
            finish();
        }
        this.mListView.addFooterView(LayoutInflater.from(ServiceApplication.getAppContext()).inflate((int) R.layout.scene_all_activity_placehold, (ViewGroup) null));
        this.f4248O000000o = new AuthAdapter(this);
        this.mListView.setAdapter((ListAdapter) this.f4248O000000o);
        fak.O000000o().O000000o((fsm) new fsm() {
            /* class com.xiaomi.smarthome.auth.AuthManagerDetailActivity.AnonymousClass1 */

            public final void onSuccess(Object obj) {
                AuthManagerDetailActivity.this.mAppNameTV.setText(fak.O000000o().O00000Oo.f16000O000000o);
                AuthManagerDetailActivity.this.mAppAuthTimeTV.setText(fak.O000000o().O00000Oo.O00000Oo);
                AuthManagerDetailActivity.this.mAppIcon.setHierarchy(new GenericDraweeHierarchyBuilder(AuthManagerDetailActivity.this.getResources()).setFadeDuration(200).setPlaceholderImage(AuthManagerDetailActivity.this.getResources().getDrawable(R.drawable.device_list_phone_no)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).setRoundingParams(RoundingParams.fromCornersRadius(20.0f)).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
                if (!TextUtils.isEmpty(fak.O000000o().O00000Oo.O00000o0)) {
                    AuthManagerDetailActivity.this.mAppIcon.setImageURI(Uri.parse(fak.O000000o().O00000Oo.O00000o0));
                }
                if (fak.O000000o().O00000Oo()) {
                    if (!fno.O000000o().O0000o00() || fno.O000000o().O0000o0()) {
                        fno.O000000o().O000000o(AuthManagerDetailActivity.this.O00000o0);
                        fno.O000000o().O0000Oo0();
                    } else {
                        AuthManagerDetailActivity.this.initDevices(true);
                    }
                } else if (!fno.O000000o().O0000o00() || fno.O000000o().O0000o0()) {
                    fno.O000000o().O000000o(AuthManagerDetailActivity.this.O00000o0);
                    fno.O000000o().O0000Oo0();
                } else {
                    AuthManagerDetailActivity.this.initDevices(false);
                }
                if (AuthManagerDetailActivity.this.O00000Oo != null) {
                    AuthManagerDetailActivity.this.f4248O000000o.notifyDataSetChanged();
                }
            }

            public final void onFailure(fso fso) {
                izb.O000000o(AuthManagerDetailActivity.this, "获取数据失败", 0).show();
            }
        }, false);
        this.mTitleTV.setText((int) R.string.auth_manager);
        this.mBackIV.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.auth.AuthManagerDetailActivity.AnonymousClass2 */

            public final void onClick(View view) {
                AuthManagerDetailActivity.this.setResult(0, null);
                AuthManagerDetailActivity.this.finish();
            }
        });
        this.mDeleteAuth.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.auth.AuthManagerDetailActivity.AnonymousClass3 */

            public final void onClick(View view) {
                fak.O000000o().O000000o(new fsm() {
                    /* class com.xiaomi.smarthome.auth.AuthManagerDetailActivity.AnonymousClass3.AnonymousClass1 */

                    public final void onSuccess(Object obj) {
                        izb.O000000o(AuthManagerDetailActivity.this, AuthManagerDetailActivity.this.getString(R.string.delete_auth_success), 0).show();
                        Intent intent = new Intent();
                        intent.putExtra("extra_application_id", AuthManagerDetailActivity.this.appId);
                        AuthManagerDetailActivity.this.setResult(-1, intent);
                        AuthManagerDetailActivity.this.finish();
                    }

                    public final void onFailure(fso fso) {
                        izb.O000000o(AuthManagerDetailActivity.this, AuthManagerDetailActivity.this.getString(R.string.delete_auth_fail), 0).show();
                    }
                });
            }
        });
    }

    public void onBackPressed() {
        setResult(0, null);
        finish();
    }

    public void initDevices(boolean z) {
        gsy.O000000o(LogType.GENERAL, "AuthManagerDetailActivity", "initDevices--checkCanAuth--".concat(String.valueOf(z)));
        this.O00000Oo.clear();
        Map<String, Device> O00000Oo2 = fno.O000000o().O00000Oo();
        Map<String, Device> O0000O0o = fno.O000000o().O0000O0o();
        if (z) {
            for (Map.Entry<String, Device> value : O0000O0o.entrySet()) {
                Device device = (Device) value.getValue();
                if (fak.O000000o().O000000o(device.did)) {
                    this.O00000Oo.add(device);
                }
            }
            for (Map.Entry<String, Device> value2 : O00000Oo2.entrySet()) {
                Device device2 = (Device) value2.getValue();
                if (fak.O000000o().O000000o(device2.did)) {
                    this.O00000Oo.add(device2);
                }
            }
            return;
        }
        this.O00000Oo.addAll(O0000O0o.values());
        this.O00000Oo.addAll(O00000Oo2.values());
    }
}

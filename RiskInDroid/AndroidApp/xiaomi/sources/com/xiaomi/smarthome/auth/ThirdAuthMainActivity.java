package com.xiaomi.smarthome.auth;

import _m_j.fai;
import _m_j.fak;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ftt;
import _m_j.gqb;
import _m_j.gsy;
import _m_j.gyl;
import _m_j.izb;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
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
import com.xiaomi.smarthome.authlib.IAuthCallBack;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.ListViewWithFixedHeight;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.db.record.ShareUserRecord;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ThirdAuthMainActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    List<Device> f4269O000000o = new ArrayList();
    boolean[] O00000Oo;
    final fno.O000000o O00000o = new fno.O000000o() {
        /* class com.xiaomi.smarthome.auth.ThirdAuthMainActivity.AnonymousClass1 */

        public final void onRefreshClientDeviceChanged(int i, Device device) {
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            gsy.O000000o(LogType.GENERAL, "ThirdAuthMainActivity", "onRefreshClientDeviceSuccess".concat(String.valueOf(i)));
            if (i == 3) {
                if (fak.O000000o().O00000Oo()) {
                    ThirdAuthMainActivity.this.initDevices(true);
                } else {
                    ThirdAuthMainActivity.this.initDevices(false);
                }
                if (ThirdAuthMainActivity.this.f4269O000000o != null) {
                    ThirdAuthMainActivity thirdAuthMainActivity = ThirdAuthMainActivity.this;
                    thirdAuthMainActivity.O00000Oo = new boolean[thirdAuthMainActivity.f4269O000000o.size()];
                    for (int i2 = 0; i2 < ThirdAuthMainActivity.this.O00000Oo.length; i2++) {
                        ThirdAuthMainActivity.this.O00000Oo[i2] = true;
                    }
                    ThirdAuthMainActivity.this.O00000o0.notifyDataSetChanged();
                    fno.O000000o().O00000Oo(ThirdAuthMainActivity.this.O00000o);
                }
            }
        }
    };
    AuthAdapter O00000o0;
    private boolean O00000oO;
    @BindView(6455)
    TextView mAppDescTV;
    @BindView(6456)
    SimpleDraweeView mAppIconIV;
    @BindView(6458)
    TextView mAppNameTV;
    @BindView(6472)
    TextView mAuthAgreeTV;
    @BindView(6473)
    TextView mAuthCancelTV;
    @BindView(6478)
    TextView mAuthDesc;
    @BindView(7573)
    ImageView mBackIV;
    public IAuthCallBack mCallBack;
    @BindView(6490)
    ListViewWithFixedHeight mListView;
    @BindView(6728)
    CheckBox mSelectAll;
    @BindView(7578)
    TextView mTitleTV;

    class AuthAdapter extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        Context f4274O000000o;

        public final long getItemId(int i) {
            return (long) i;
        }

        public class ViewHolder_ViewBinding implements Unbinder {

            /* renamed from: O000000o  reason: collision with root package name */
            private ViewHolder f4277O000000o;

            public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
                this.f4277O000000o = viewHolder;
                viewHolder.mImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.image, "field 'mImage'", SimpleDraweeView.class);
                viewHolder.mNameTV = (TextView) Utils.findRequiredViewAsType(view, R.id.name, "field 'mNameTV'", TextView.class);
                viewHolder.mCheckBox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ckb_edit_selected, "field 'mCheckBox'", CheckBox.class);
            }

            public void unbind() {
                ViewHolder viewHolder = this.f4277O000000o;
                if (viewHolder != null) {
                    this.f4277O000000o = null;
                    viewHolder.mImage = null;
                    viewHolder.mNameTV = null;
                    viewHolder.mCheckBox = null;
                    return;
                }
                throw new IllegalStateException("Bindings already cleared.");
            }
        }

        public AuthAdapter(Context context) {
            this.f4274O000000o = context;
        }

        public final int getCount() {
            return ThirdAuthMainActivity.this.f4269O000000o.size();
        }

        public final Object getItem(int i) {
            return ThirdAuthMainActivity.this.f4269O000000o.get(i);
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            final ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(this.f4274O000000o).inflate((int) R.layout.activity_auth_main_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.mImage.setHierarchy(new GenericDraweeHierarchyBuilder(viewHolder.mImage.getResources()).setFadeDuration(200).setPlaceholderImage(viewHolder.mImage.getResources().getDrawable(R.drawable.device_list_phone_no)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
            Device device = ThirdAuthMainActivity.this.f4269O000000o.get(i);
            if (device != null) {
                DeviceFactory.O00000Oo(device.model, viewHolder.mImage);
            } else {
                DeviceFactory.O00000Oo((String) null, viewHolder.mImage);
            }
            viewHolder.mNameTV.setText(device.getName());
            viewHolder.mCheckBox.setChecked(ThirdAuthMainActivity.this.O00000Oo[i]);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.auth.ThirdAuthMainActivity.AuthAdapter.AnonymousClass1 */

                public final void onClick(View view) {
                    ThirdAuthMainActivity.this.O00000Oo[i] = !ThirdAuthMainActivity.this.O00000Oo[i];
                    viewHolder.mCheckBox.setChecked(ThirdAuthMainActivity.this.O00000Oo[i]);
                }
            });
            return view;
        }

        class ViewHolder {
            @BindView(6726)
            CheckBox mCheckBox;
            @BindView(7209)
            SimpleDraweeView mImage;
            @BindView(7639)
            TextView mNameTV;

            public ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_auth_main_layout);
        ButterKnife.bind(this);
        this.O00000o0 = new AuthAdapter(this);
        this.mListView.setAdapter((ListAdapter) this.O00000o0);
        this.mCallBack = fak.O000000o().O00000oO;
        this.mAppNameTV.setText(fak.O000000o().O00000Oo.f16000O000000o);
        this.mAppDescTV.setText(fak.O000000o().O00000Oo.O00000Oo);
        this.mAppIconIV.setHierarchy(new GenericDraweeHierarchyBuilder(getResources()).setFadeDuration(200).setPlaceholderImage(getResources().getDrawable(R.drawable.device_list_phone_no)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).setRoundingParams(RoundingParams.fromCornersRadius(20.0f)).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
        if (!TextUtils.isEmpty(fak.O000000o().O00000Oo.O00000o0)) {
            this.mAppIconIV.setImageURI(Uri.parse(fak.O000000o().O00000Oo.O00000o0));
        }
        int i = 0;
        if (fak.O000000o().O00000Oo()) {
            if (!fno.O000000o().O0000o00() || fno.O000000o().O0000o0()) {
                fno.O000000o().O000000o(this.O00000o);
                fno.O000000o().O0000Oo0();
            } else {
                initDevices(true);
            }
        } else if (!fno.O000000o().O0000o00() || fno.O000000o().O0000o0()) {
            fno.O000000o().O000000o(this.O00000o);
            fno.O000000o().O0000Oo0();
        } else {
            initDevices(false);
        }
        List<Device> list = this.f4269O000000o;
        if (list != null) {
            this.O00000Oo = new boolean[list.size()];
            while (true) {
                boolean[] zArr = this.O00000Oo;
                if (i >= zArr.length) {
                    break;
                }
                zArr[i] = true;
                i++;
            }
            this.O00000o0.notifyDataSetChanged();
        }
        this.mTitleTV.setText((int) R.string.auth_title);
        gyl.O000000o().O000000o(new ftt<ShareUserRecord>() {
            /* class com.xiaomi.smarthome.auth.ThirdAuthMainActivity.AnonymousClass2 */

            public final void O000000o(int i) {
            }

            public final void O000000o(int i, Object obj) {
            }

            public final /* synthetic */ void O000000o(Object obj) {
                ThirdAuthMainActivity.this.mAuthDesc.setText(String.format(ThirdAuthMainActivity.this.getString(R.string.auth_tip_format), gqb.O0000O0o(((ShareUserRecord) obj).nickName), CoreApi.O000000o().O0000o0()));
            }
        });
        this.mAuthCancelTV.setOnClickListener(this);
        this.mAuthAgreeTV.setOnClickListener(this);
        this.mSelectAll.setOnClickListener(this);
        this.mSelectAll.setChecked(true);
        this.O00000oO = true;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.auth_agree) {
            StringBuilder sb = new StringBuilder();
            boolean[] zArr = this.O00000Oo;
            if (zArr != null && zArr.length == this.f4269O000000o.size()) {
                int i = 0;
                int i2 = 0;
                while (true) {
                    boolean[] zArr2 = this.O00000Oo;
                    if (i >= zArr2.length) {
                        break;
                    }
                    if (zArr2[i]) {
                        if (i2 == 0) {
                            sb.append("4 ");
                            sb.append(this.f4269O000000o.get(i).did);
                        } else {
                            sb.append(",4 ");
                            sb.append(this.f4269O000000o.get(i).did);
                        }
                        if (fak.O000000o().O00000o0()) {
                            sb.append(",5 ");
                            sb.append(this.f4269O000000o.get(i).did);
                        }
                        i2++;
                    }
                    i++;
                }
            }
            fak.O000000o().O000000o(sb.toString(), new fsm() {
                /* class com.xiaomi.smarthome.auth.ThirdAuthMainActivity.AnonymousClass3 */

                public final void onSuccess(Object obj) {
                    izb.O000000o(ThirdAuthMainActivity.this, (int) R.string.auth_success, 0).show();
                    fak.O000000o().O000000o("renlei", "https://openapp.io.mi.com", new fsm() {
                        /* class com.xiaomi.smarthome.auth.ThirdAuthMainActivity.AnonymousClass3.AnonymousClass1 */

                        public final void onSuccess(Object obj) {
                        }

                        public final void onFailure(fso fso) {
                            if (fso.f17063O000000o == 404 && !TextUtils.isEmpty(fso.O00000o0)) {
                                String str = fso.O00000o0;
                                if (str.contains("access_token")) {
                                    String token = ThirdAuthMainActivity.this.getToken(str);
                                    if (!TextUtils.isEmpty(token)) {
                                        Bundle O000000o2 = fai.O000000o(100);
                                        O000000o2.putString("extra_token", token);
                                        if (ThirdAuthMainActivity.this.mCallBack != null) {
                                            try {
                                                ThirdAuthMainActivity.this.mCallBack.onSuccess(100, O000000o2);
                                            } catch (RemoteException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        ThirdAuthMainActivity.this.exitAuth();
                                        return;
                                    }
                                }
                            }
                            if (ThirdAuthMainActivity.this.mCallBack != null) {
                                try {
                                    ThirdAuthMainActivity.this.mCallBack.onFail(-102, fai.O000000o(-102));
                                } catch (RemoteException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            ThirdAuthMainActivity thirdAuthMainActivity = ThirdAuthMainActivity.this;
                            izb.O000000o(thirdAuthMainActivity, "获取token失败" + fso.O00000Oo, 0).show();
                            ThirdAuthMainActivity.this.exitAuth();
                        }
                    });
                }

                public final void onFailure(fso fso) {
                    ThirdAuthMainActivity thirdAuthMainActivity = ThirdAuthMainActivity.this;
                    izb.O000000o(thirdAuthMainActivity, ThirdAuthMainActivity.this.getResources().getString(R.string.auth_fail) + fso.O00000Oo, 0).show();
                    if (ThirdAuthMainActivity.this.mCallBack != null) {
                        try {
                            ThirdAuthMainActivity.this.mCallBack.onFail(-103, fai.O000000o(-103));
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                    ThirdAuthMainActivity.this.exitAuth();
                }
            });
        } else if (id == R.id.auth_cancel) {
            exitAuth();
        } else if (id == R.id.ckb_select_all) {
            O000000o();
        }
    }

    public void exitAuth() {
        finish();
    }

    private void O000000o() {
        int i = 0;
        if (this.O00000oO) {
            this.mSelectAll.setChecked(false);
            int i2 = 0;
            while (true) {
                boolean[] zArr = this.O00000Oo;
                if (i2 < zArr.length) {
                    zArr[i2] = false;
                    i2++;
                } else {
                    this.O00000o0.notifyDataSetChanged();
                    this.O00000oO = false;
                    return;
                }
            }
        } else {
            this.mSelectAll.setChecked(true);
            while (true) {
                boolean[] zArr2 = this.O00000Oo;
                if (i < zArr2.length) {
                    zArr2[i] = true;
                    i++;
                } else {
                    this.O00000o0.notifyDataSetChanged();
                    this.O00000oO = true;
                    return;
                }
            }
        }
    }

    public void initDevices(boolean z) {
        gsy.O000000o(LogType.GENERAL, "AuthManager", "initDevices--checkCanAuth--".concat(String.valueOf(z)));
        Map<String, Device> O0000O0o = fno.O000000o().O0000O0o();
        Map<String, Device> O00000Oo2 = fno.O000000o().O00000Oo();
        LogType logType = LogType.GENERAL;
        gsy.O000000o(logType, "AuthManager", O0000O0o.size() + "subsize" + O00000Oo2.size());
        this.f4269O000000o.clear();
        if (z) {
            for (Map.Entry<String, Device> value : O0000O0o.entrySet()) {
                Device device = (Device) value.getValue();
                if (fak.O000000o().O000000o(device.did)) {
                    this.f4269O000000o.add(device);
                }
            }
            for (Map.Entry<String, Device> value2 : O00000Oo2.entrySet()) {
                Device device2 = (Device) value2.getValue();
                if (fak.O000000o().O000000o(device2.did)) {
                    this.f4269O000000o.add(device2);
                }
            }
        } else {
            this.f4269O000000o.addAll(O0000O0o.values());
            this.f4269O000000o.addAll(O00000Oo2.values());
        }
        LogType logType2 = LogType.GENERAL;
        gsy.O000000o(logType2, "AuthManager", "initDevices end mDevices.size()----" + this.f4269O000000o.size());
    }

    public String getToken(String str) {
        String substring = str.substring(str.indexOf("access_token=") + 13, str.indexOf("&state="));
        LogType logType = LogType.GENERAL;
        gsy.O000000o(logType, "ThirdAuthMainActivity", "getToken result--" + substring + "----start--" + str.indexOf("access_token=") + "---end--" + str.indexOf("&state="));
        return substring;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }
}

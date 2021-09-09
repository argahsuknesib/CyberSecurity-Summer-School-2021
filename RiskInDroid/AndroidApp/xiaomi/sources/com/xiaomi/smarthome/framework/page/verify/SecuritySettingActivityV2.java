package com.xiaomi.smarthome.framework.page.verify;

import _m_j.fnn;
import _m_j.fno;
import _m_j.fso;
import _m_j.fwb;
import _m_j.fwe;
import _m_j.fwf;
import _m_j.fwg;
import _m_j.fwi;
import _m_j.fwj;
import _m_j.fwl;
import _m_j.fwm;
import _m_j.fwn;
import _m_j.fwo;
import _m_j.ggb;
import _m_j.gno;
import _m_j.gpv;
import _m_j.gqg;
import _m_j.gva;
import _m_j.hxi;
import _m_j.hxk;
import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.material.appbar.AppBarLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.page.verify.filter.SettingsDeviceFilter;
import com.xiaomi.smarthome.framework.page.verify.manager.VerifyGlobalManager;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import org.json.JSONObject;

public class SecuritySettingActivityV2 extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    List<fwl> f7982O000000o;
    List<fwl> O00000Oo = new ArrayList();
    String O00000o;
    fwm O00000o0;
    String O00000oO;
    boolean O00000oo = false;
    boolean O0000O0o = false;
    private SettingsDeviceFilter O0000OOo;
    @BindView(5781)
    View container;
    @BindView(4928)
    AppBarLayout mAppBarLayout;
    @BindView(5314)
    ImageView mFilterIcon;
    @BindView(6017)
    TextView mFilterNoDeviceText;
    @BindView(5379)
    LinearLayout mFilterResultEmpty;
    @BindView(5773)
    TextView mFilterTitle;
    @BindView(5788)
    RecyclerView rvAllDevices;
    @BindView(5790)
    TextView tvBigTitle;
    @BindView(5775)
    View vApplyDeviceSetting;
    @BindView(5789)
    View vBigTitle;
    @BindView(5776)
    View vChangePinCode;
    @BindView(5777)
    View vClosePinCode;
    @BindView(5778)
    View vDivider;
    @BindView(5779)
    View vFingerPrintSetting;
    @BindView(5780)
    SwitchButton vFingerPrintSwitch;
    @BindView(5782)
    View vOpenPinCode;
    @BindView(5474)
    TextView vTitle;
    public fwo verifyDialog;
    public VerifyGlobalManager verifyGlobalManager;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpv.O00000Oo(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gpv.O00000Oo(android.content.Context, java.lang.String):void
      _m_j.gpv.O00000Oo(java.lang.String, java.lang.String):void
      _m_j.gpv.O00000Oo(java.lang.String, boolean):void */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gpv.O00000Oo("loc_pincode_new", false);
        gva.O000000o().notifyViewClicked("loc_pincode_new");
        setContentView((int) R.layout.activity_security_setting_v2);
        ButterKnife.bind(this);
        this.verifyGlobalManager = VerifyGlobalManager.O000000o(this);
        this.O00000o = CoreApi.O000000o().O0000o0();
        this.f7982O000000o = new ArrayList();
        initView();
        hxi.O00000o.f952O000000o.O000000o("safe.setting.page.show-up", new Object[0]);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(AppBarLayout appBarLayout, int i) {
        if (Math.abs(i) < this.vBigTitle.getHeight()) {
            float abs = Math.abs((float) i) / ((float) this.vBigTitle.getHeight());
            this.vTitle.setVisibility(4);
            this.tvBigTitle.setAlpha(1.0f - abs);
            return;
        }
        this.vTitle.setVisibility(0);
    }

    public void onBackPressed() {
        if (!TextUtils.isEmpty(this.O00000oO)) {
            setResult(-1);
        }
        super.onBackPressed();
    }

    public void onDestroy() {
        super.onDestroy();
        fwo fwo = this.verifyDialog;
        if (fwo != null) {
            fwo.O000000o();
        }
    }

    public void showPinCodeClose() {
        this.container.setVisibility(0);
        this.vOpenPinCode.setVisibility(0);
        this.vClosePinCode.setVisibility(8);
        this.vChangePinCode.setVisibility(8);
        this.vFingerPrintSetting.setVisibility(8);
        this.vDivider.setVisibility(8);
        this.vApplyDeviceSetting.setVisibility(8);
        this.rvAllDevices.setVisibility(8);
        View childAt = this.mAppBarLayout.getChildAt(0);
        AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) childAt.getLayoutParams();
        layoutParams.setScrollFlags(0);
        childAt.setLayoutParams(layoutParams);
    }

    public void showPinCodeOpen() {
        this.container.setVisibility(0);
        this.vOpenPinCode.setVisibility(8);
        this.vClosePinCode.setVisibility(0);
        this.vChangePinCode.setVisibility(0);
        this.vFingerPrintSetting.setVisibility(0);
        this.vDivider.setVisibility(0);
        this.vApplyDeviceSetting.setVisibility(0);
        this.rvAllDevices.setVisibility(0);
        if (this.verifyGlobalManager.O000000o()) {
            this.vFingerPrintSwitch.setChecked(this.verifyGlobalManager.O00000Oo(this.O00000o));
        } else {
            this.vFingerPrintSetting.setVisibility(8);
        }
        View childAt = this.mAppBarLayout.getChildAt(0);
        AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) childAt.getLayoutParams();
        layoutParams.setScrollFlags(17);
        childAt.setLayoutParams(layoutParams);
    }

    public void updateDeviceListView() {
        showWaitingDialog();
        final ArrayList arrayList = new ArrayList();
        if (this.O00000oo) {
            for (fwl next : this.f7982O000000o) {
                if (!next.O0000OOo) {
                    arrayList.add(next.f17315O000000o);
                }
            }
        }
        VerifyGlobalManager verifyGlobalManager2 = this.verifyGlobalManager;
        boolean z = this.O00000oo;
        verifyGlobalManager2.O000000o(this, arrayList, z ? 1 : 0, new fwg<List<String>>() {
            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivityV2.AnonymousClass3 */

            public final /* synthetic */ void onSuccess(Object obj) {
                List list = (List) obj;
                if (SecuritySettingActivityV2.this.O00000oo) {
                    if (list.size() != arrayList.size()) {
                        gqg.O00000Oo((int) R.string.handle_error);
                        SecuritySettingActivityV2.this.processBatchOperation(list, true);
                        SecuritySettingActivityV2.this.dismissProgressDialog();
                        return;
                    }
                    for (fwl next : SecuritySettingActivityV2.this.f7982O000000o) {
                        if (!next.O0000OOo) {
                            next.O0000OOo = true;
                            Device O000000o2 = fno.O000000o().O000000o(next.f17315O000000o);
                            O000000o2.isSetPinCode = 1;
                            O000000o2.pinCodeType = 2;
                            fno.O000000o().O00000o0(O000000o2);
                        }
                    }
                }
                SecuritySettingActivityV2.this.O00000o0.notifyDataSetChanged();
                SecuritySettingActivityV2.this.dismissProgressDialog();
            }

            public final void onFailure(fso fso) {
                gqg.O00000Oo(fso.toString());
            }
        });
    }

    private void O000000o() {
        if (this.f7982O000000o.isEmpty() || this.O0000O0o) {
            this.f7982O000000o.clear();
            List<String> list = ggb.O00000o0.f17714O000000o;
            if (list == null || list.isEmpty()) {
                gqg.O00000Oo((int) R.string.toast_failed_retry);
                finish();
            } else {
                for (String O0000Oo : list) {
                    for (Device next : ggb.O00000Oo().O0000Oo(O0000Oo)) {
                        if (!fwn.O000000o(next)) {
                            fwl fwl = new fwl(next);
                            this.f7982O000000o.add(fwl);
                            this.O00000Oo.add(fwl);
                        }
                    }
                }
                if (this.f7982O000000o.size() == 0) {
                    this.mFilterResultEmpty.setVisibility(0);
                    this.mFilterNoDeviceText.setText((int) R.string.tag_no_device);
                } else {
                    this.mFilterResultEmpty.setVisibility(8);
                    this.mFilterNoDeviceText.setText((int) R.string.device_setting_filter_result_empty);
                }
                fwm fwm = this.O00000o0;
                if (fwm != null) {
                    fwm.notifyDataSetChanged();
                }
            }
        }
        if (this.O00000o0 == null) {
            this.O00000o0 = new fwm(this, this.f7982O000000o);
            this.O00000o0.O00000o0 = new fwm.O000000o() {
                /* class com.xiaomi.smarthome.framework.page.verify.$$Lambda$SecuritySettingActivityV2$XvHef60P1cK8fzYrmZmdkj1JrM */

                public final void onPerformCheckedChangeListener(CompoundButton compoundButton, fwl fwl, boolean z) {
                    SecuritySettingActivityV2.this.O000000o(compoundButton, fwl, z);
                }
            };
            this.rvAllDevices.setLayoutManager(new LinearLayoutManager(this));
            this.rvAllDevices.setAdapter(this.O00000o0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(final CompoundButton compoundButton, final fwl fwl, boolean z) {
        ArrayList arrayList = new ArrayList();
        final String str = fwl.f17315O000000o;
        arrayList.add(str);
        if (z) {
            VerifyGlobalManager verifyGlobalManager2 = this.verifyGlobalManager;
            boolean z2 = this.O00000oo;
            verifyGlobalManager2.O000000o(this, arrayList, z2 ? 1 : 0, new fwg<List<String>>() {
                /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivityV2.AnonymousClass4 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    List list = (List) obj;
                    if (list.isEmpty() || !((String) list.get(0)).equals(str)) {
                        compoundButton.setChecked(false);
                        gqg.O00000Oo((int) R.string.action_fail);
                        return;
                    }
                    fwl.O0000OOo = true;
                    Device O000000o2 = fno.O000000o().O000000o(str);
                    O000000o2.isSetPinCode = 1;
                    O000000o2.pinCodeType = 2;
                    fno.O000000o().O00000o0(O000000o2);
                }

                public final void onFailure(fso fso) {
                    compoundButton.setChecked(false);
                    gqg.O00000Oo(fso.toString());
                }
            });
        } else {
            this.verifyGlobalManager.O000000o(this, arrayList, new fwg<List<String>>() {
                /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivityV2.AnonymousClass5 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    List list = (List) obj;
                    if (list.isEmpty() || !((String) list.get(0)).equals(str)) {
                        compoundButton.setChecked(true);
                        gqg.O00000Oo((int) R.string.action_fail);
                        return;
                    }
                    fwl.O0000OOo = false;
                    Device O000000o2 = fno.O000000o().O000000o(str);
                    O000000o2.isSetPinCode = 0;
                    O000000o2.pinCodeType = 0;
                    fno.O000000o().O00000o0(O000000o2);
                }

                public final void onFailure(fso fso) {
                    compoundButton.setChecked(true);
                    gqg.O00000Oo(fso.toString());
                }
            });
        }
        hxk hxk = hxi.O00000o;
        String str2 = fwl.O0000O0o;
        String str3 = fwl.f17315O000000o;
        if (str2 == null && str3 == null) {
            hxk.f952O000000o.O000000o("safe.setting.all_device.click", "type", Integer.valueOf(z));
            return;
        }
        hxk.f952O000000o.O000000o("safe.setting.device.click", "type", Integer.valueOf(z ? 1 : 0), "model", str2, "did", str3);
    }

    public void processBatchOperation(List<String> list, boolean z) {
        for (String next : list) {
            for (fwl next2 : this.f7982O000000o) {
                if (next.equals(next2.f17315O000000o)) {
                    next2.O0000OOo = z;
                    Device O000000o2 = fno.O000000o().O000000o(next);
                    O000000o2.isSetPinCode = z ? 1 : 0;
                    O000000o2.pinCodeType = z ? 2 : 0;
                    fno.O000000o().O00000o0(O000000o2);
                }
            }
        }
    }

    public void clearGlobalPinCode() {
        showWaitingDialog();
        final ArrayList arrayList = new ArrayList();
        if (!this.f7982O000000o.equals(this.O00000Oo)) {
            this.f7982O000000o.clear();
            this.f7982O000000o.addAll(this.O00000Oo);
        }
        for (fwl next : this.f7982O000000o) {
            if (next.O0000OOo) {
                arrayList.add(next.f17315O000000o);
            }
        }
        if (arrayList.isEmpty()) {
            this.verifyGlobalManager.O000000o(this.O00000o);
            this.vFingerPrintSwitch.setChecked(false);
            showPinCodeClose();
            dismissProgressDialog();
            return;
        }
        this.verifyGlobalManager.O000000o(this, arrayList, new fwg<List<String>>() {
            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivityV2.AnonymousClass6 */

            public final /* synthetic */ void onSuccess(Object obj) {
                List list = (List) obj;
                SecuritySettingActivityV2.this.O0000O0o = true;
                if (list.size() != arrayList.size()) {
                    gqg.O00000Oo((int) R.string.handle_error);
                    SecuritySettingActivityV2.this.processBatchOperation(list, false);
                    SecuritySettingActivityV2.this.dismissProgressDialog();
                    return;
                }
                for (fwl next : SecuritySettingActivityV2.this.f7982O000000o) {
                    if (next.O0000OOo) {
                        next.O0000OOo = false;
                        Device O000000o2 = fno.O000000o().O000000o(next.f17315O000000o);
                        O000000o2.isSetPinCode = 0;
                        O000000o2.pinCodeType = 0;
                        fno.O000000o().O00000o0(O000000o2);
                    }
                }
                if (SecuritySettingActivityV2.this.O00000oo) {
                    SecuritySettingActivityV2 securitySettingActivityV2 = SecuritySettingActivityV2.this;
                    securitySettingActivityV2.O00000oo = false;
                    securitySettingActivityV2.updateDeviceListView();
                }
                SecuritySettingActivityV2.this.verifyGlobalManager.O000000o(SecuritySettingActivityV2.this.O00000o);
                SecuritySettingActivityV2.this.vFingerPrintSwitch.setChecked(false);
                SecuritySettingActivityV2.this.showPinCodeClose();
                SecuritySettingActivityV2.this.dismissProgressDialog();
            }

            public final void onFailure(fso fso) {
                gqg.O00000Oo((int) R.string.toast_failed_retry);
                SecuritySettingActivityV2.this.dismissProgressDialog();
            }
        });
    }

    @OnClick({5780, 5779})
    public void onClickFingerPrintSetting() {
        if (this.vFingerPrintSwitch.isChecked()) {
            new MLAlertDialog.Builder(this).O000000o(getResources().getString(R.string.device_more_security_fingerprint_main)).O00000Oo((int) R.string.device_more_security_close_finger_id_tip).O000000o((int) R.string.reassure_ok, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivityV2.AnonymousClass7 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    SecuritySettingActivityV2.this.verifyGlobalManager.O000000o(SecuritySettingActivityV2.this.O00000o);
                    SecuritySettingActivityV2.this.vFingerPrintSwitch.setChecked(false);
                }
            }).O00000Oo((int) R.string.reassure_cancel, (DialogInterface.OnClickListener) null).O00000o().show();
            return;
        }
        this.O00000oO = VerifyGlobalManager.O000000o(this.O00000o, 0);
        O00000Oo();
    }

    @OnClick({5782})
    public void onClickOpenPinCode() {
        fwb.O000000o(this, null, null, true, 102);
    }

    @OnClick({5776})
    public void onClickChangePinCode() {
        DevicePinMotifyChangeActivity.O000000o(this, null, this.O00000oO, "", true, 104);
    }

    @OnClick({5775})
    public void showSelectFilterDialog() {
        List<fwl> list = this.O00000Oo;
        if (list == null || list.size() != 0) {
            if (this.O0000OOo == null) {
                this.O0000OOo = new SettingsDeviceFilter(this, this.O00000Oo) {
                    /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivityV2.AnonymousClass8 */

                    public final void O000000o(List<fwi> list, List<fwi> list2, List<fwi> list3) {
                        if (list.size() == 0 && list2.size() == 0 && list3.size() == 0) {
                            SecuritySettingActivityV2.this.resetDeviceListView();
                            return;
                        }
                        List<String> list4 = null;
                        List<String> devicesIdByHome = list.size() > 0 ? SecuritySettingActivityV2.this.getDevicesIdByHome(list) : null;
                        List<String> devicesIdByRoom = list2.size() > 0 ? SecuritySettingActivityV2.this.getDevicesIdByRoom(list2) : null;
                        if (list3.size() > 0) {
                            list4 = SecuritySettingActivityV2.this.getDevicesIdByProduct(list3);
                        }
                        SecuritySettingActivityV2 securitySettingActivityV2 = SecuritySettingActivityV2.this;
                        List<fwl> list5 = securitySettingActivityV2.f7982O000000o;
                        SecuritySettingActivityV2 securitySettingActivityV22 = SecuritySettingActivityV2.this;
                        List<fwl> selectedDeviceList = securitySettingActivityV2.getSelectedDeviceList(list5, securitySettingActivityV22.getIntersectionList(devicesIdByHome, securitySettingActivityV22.getIntersectionList(devicesIdByRoom, list4)));
                        if (selectedDeviceList == null || selectedDeviceList.size() != 0) {
                            SecuritySettingActivityV2.this.mFilterResultEmpty.setVisibility(8);
                            SecuritySettingActivityV2.this.rvAllDevices.setVisibility(0);
                        } else {
                            SecuritySettingActivityV2.this.mFilterResultEmpty.setVisibility(0);
                            SecuritySettingActivityV2.this.rvAllDevices.setVisibility(8);
                        }
                        SecuritySettingActivityV2.this.f7982O000000o.retainAll(selectedDeviceList);
                        SecuritySettingActivityV2.this.O00000o0.notifyDataSetChanged();
                        SecuritySettingActivityV2.this.mFilterTitle.setTextColor(SecuritySettingActivityV2.this.getResources().getColor(R.color.mj_color_text_hightlight));
                        SecuritySettingActivityV2.this.mFilterIcon.setImageResource(R.drawable.setting_filter_light_icon);
                    }

                    public final void O000000o() {
                        SecuritySettingActivityV2.this.resetDeviceListView();
                    }

                    public final void O000000o(int i) {
                        hxk hxk = hxi.O00000o;
                        Integer valueOf = Integer.valueOf(i);
                        hxk.f952O000000o.O000000o("safety_filter_panel_confirm", "type", valueOf);
                    }

                    public final void O00000Oo() {
                        hxi.O00000o.f952O000000o.O000000o("safety_filter_show", new Object[0]);
                    }
                };
            }
            this.f7982O000000o.clear();
            this.f7982O000000o.addAll(this.O00000Oo);
            this.O0000OOo.O00000o0();
            hxi.O00000o.O00000o0((Integer) 1);
            return;
        }
        hxi.O00000o.O00000o0((Integer) 2);
        gqg.O00000Oo((int) R.string.device_no_to_filter);
    }

    @OnClick({5777})
    public void onClickClosePinCode() {
        new MLAlertDialog.Builder(this).O00000Oo((int) R.string.device_plugin_security_close_pincoe_tip).O000000o((int) R.string.reassure_ok, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivityV2.AnonymousClass9 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                SecuritySettingActivityV2.this.showWaitingDialog();
                SecuritySettingActivityV2.this.verifyGlobalManager.O00000Oo(SecuritySettingActivityV2.this, new fwg<Boolean>() {
                    /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivityV2.AnonymousClass9.AnonymousClass1 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        if (((Boolean) obj).booleanValue()) {
                            SecuritySettingActivityV2.this.clearGlobalPinCode();
                            gqg.O00000Oo((int) R.string.settings_set_success);
                        } else {
                            gqg.O00000Oo((int) R.string.device_more_activity_failed);
                        }
                        SecuritySettingActivityV2.this.dismissProgressDialog();
                    }

                    public final void onFailure(fso fso) {
                        gqg.O00000Oo(fso.toString());
                        SecuritySettingActivityV2.this.dismissProgressDialog();
                    }
                });
            }
        }).O00000Oo((int) R.string.reassure_cancel, (DialogInterface.OnClickListener) null).O00000o().show();
    }

    @OnClick({5470})
    public void onClickBack() {
        onBackPressed();
    }

    public void showWaitingDialog() {
        showProgressDialog(getString(R.string.device_more_security_loading_operation));
    }

    private void O00000Oo() {
        fwo fwo = this.verifyDialog;
        if (fwo != null) {
            fwo.O00000Oo();
        }
        this.verifyGlobalManager.O000000o(this.O00000o, new fwe() {
            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivityV2.AnonymousClass10 */

            @TargetApi(23)
            public final void onGetCipherSuccess(Cipher cipher) {
                SecuritySettingActivityV2 securitySettingActivityV2 = SecuritySettingActivityV2.this;
                securitySettingActivityV2.verifyDialog = new fwo(securitySettingActivityV2, new FingerprintManager.CryptoObject(cipher), new fwf() {
                    /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivityV2.AnonymousClass10.AnonymousClass1 */

                    public final void O000000o(Cipher cipher) {
                        SecuritySettingActivityV2.this.verifyDialog.O00000Oo();
                        if (!TextUtils.isEmpty(SecuritySettingActivityV2.this.O00000oO)) {
                            SecuritySettingActivityV2.this.verifyGlobalManager.O000000o(SecuritySettingActivityV2.this.O00000o, SecuritySettingActivityV2.this.O00000oO, cipher);
                            SecuritySettingActivityV2.this.vFingerPrintSwitch.setChecked(true);
                        }
                    }

                    public final void O000000o() {
                        SecuritySettingActivityV2.this.verifyDialog.O00000Oo();
                    }

                    public final void O000000o(CharSequence charSequence) {
                        gqg.O00000Oo(charSequence);
                        SecuritySettingActivityV2.this.verifyDialog.O00000Oo();
                    }

                    public final void O00000Oo() {
                        SecuritySettingActivityV2.this.verifyDialog.O00000Oo();
                    }
                }, false);
                SecuritySettingActivityV2.this.verifyDialog.O000000o(SecuritySettingActivityV2.this.getString(R.string.device_more_fingerprint_title));
            }

            @TargetApi(23)
            public final void onGetResetCipherSuccess(Cipher cipher) {
                onGetCipherSuccess(cipher);
            }

            public final void onGetCipherError(int i, String str) {
                if (i == fwj.O00000o) {
                    KeyguardManager keyguardManager = (KeyguardManager) SecuritySettingActivityV2.this.getSystemService("keyguard");
                    Intent intent = null;
                    if (Build.VERSION.SDK_INT >= 21) {
                        intent = keyguardManager.createConfirmDeviceCredentialIntent("", "");
                    }
                    if (intent != null) {
                        SecuritySettingActivityV2.this.startActivityForResult(intent, 100);
                        return;
                    }
                    return;
                }
                gqg.O00000Oo(SecuritySettingActivityV2.this.getString(R.string.device_more_fingerprint_open_fail));
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 100:
                if (i2 == -1) {
                    O00000Oo();
                    return;
                }
                return;
            case 101:
                if (i2 != -1) {
                    onBackPressed();
                    return;
                }
                if (intent != null) {
                    if (intent.getBooleanExtra("forgetPinCode", false)) {
                        O000000o();
                        this.verifyGlobalManager.O00000Oo(this, new fwg<Boolean>() {
                            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivityV2.AnonymousClass2 */

                            public final /* synthetic */ void onSuccess(Object obj) {
                                if (((Boolean) obj).booleanValue()) {
                                    SecuritySettingActivityV2.this.clearGlobalPinCode();
                                    gqg.O00000Oo((int) R.string.settings_set_success);
                                } else {
                                    gqg.O00000Oo((int) R.string.device_more_activity_failed);
                                }
                                SecuritySettingActivityV2.this.dismissProgressDialog();
                            }

                            public final void onFailure(fso fso) {
                                gqg.O00000Oo(fso.toString());
                                SecuritySettingActivityV2.this.dismissProgressDialog();
                            }
                        });
                        return;
                    }
                    this.O00000oO = intent.getStringExtra("pincode");
                }
                showPinCodeOpen();
                O000000o();
                return;
            case 102:
                if (i2 == -1) {
                    if (intent != null) {
                        this.O00000oO = intent.getStringExtra("pincode");
                    }
                    showPinCodeOpen();
                    O000000o();
                    gqg.O00000Oo((int) R.string.settings_set_success);
                    return;
                }
                return;
            case 103:
            default:
                return;
            case 104:
                if (i2 == -1) {
                    this.verifyGlobalManager.O000000o(this.O00000o);
                    this.vFingerPrintSwitch.setChecked(false);
                    gqg.O00000Oo((int) R.string.settings_set_success);
                    return;
                }
                return;
        }
    }

    public void resetDeviceListView() {
        if (!this.f7982O000000o.equals(this.O00000Oo)) {
            this.f7982O000000o.clear();
            this.f7982O000000o.addAll(this.O00000Oo);
        }
        this.mFilterResultEmpty.setVisibility(8);
        this.rvAllDevices.setVisibility(0);
        this.mFilterTitle.setTextColor(getResources().getColor(R.color.mj_color_gray_normal));
        this.mFilterIcon.setImageResource(R.drawable.setting_filter_icon);
        this.O00000o0.notifyDataSetChanged();
    }

    public List<fwl> getSelectedDeviceList(List<fwl> list, List<String> list2) {
        ArrayList arrayList = new ArrayList();
        if (!(list2 == null || list2.size() == 0)) {
            for (int i = 0; i < list2.size(); i++) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (TextUtils.equals(list.get(i2).f17315O000000o, list2.get(i))) {
                        arrayList.add(list.get(i2));
                    }
                }
            }
        }
        return arrayList;
    }

    public List<String> getDevicesIdByHome(List<fwi> list) {
        ArrayList arrayList = new ArrayList();
        for (fwi fwi : list) {
            for (Device next : ggb.O00000Oo().O0000Oo(fwi.O00000Oo)) {
                if (!fwn.O000000o(next)) {
                    arrayList.add(next.getDid());
                }
            }
        }
        return arrayList;
    }

    public List<String> getDevicesIdByRoom(List<fwi> list) {
        ArrayList arrayList = new ArrayList();
        for (fwi fwi : list) {
            for (Device next : ggb.O00000Oo().O00000Oo(ggb.O00000Oo().O00000o0(fwi.O00000Oo))) {
                if (!fwn.O000000o(next)) {
                    arrayList.add(next.getDid());
                }
            }
        }
        return arrayList;
    }

    public List<String> getDevicesIdByProduct(List<fwi> list) {
        ArrayList arrayList = new ArrayList();
        for (String O0000Oo : ggb.O00000o0.f17714O000000o) {
            Map<String, List<String>> O0000Oo2 = fnn.O000000o().O00000Oo().O0000Oo(O0000Oo);
            for (fwi fwi : list) {
                List list2 = O0000Oo2.get(fnn.O000000o().O00000Oo().O0000OOo(fwi.O00000Oo).name);
                if (list2 != null && list2.size() > 0) {
                    arrayList.addAll(list2);
                }
            }
        }
        return arrayList;
    }

    public List<String> getIntersectionList(List<String> list, List<String> list2) {
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

    public void initView() {
        this.container.setVisibility(8);
        this.vApplyDeviceSetting.setVisibility(8);
        showWaitingDialog();
        this.verifyGlobalManager.O000000o(this, new fwg<JSONObject>() {
            /* class com.xiaomi.smarthome.framework.page.verify.SecuritySettingActivityV2.AnonymousClass1 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
             arg types: [java.lang.String, int]
             candidates:
              ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                SecuritySettingActivityV2.this.O00000oo = jSONObject.optInt("apply2all") == 1;
                if (jSONObject.optInt("status") == 2) {
                    Intent intent = new Intent(SecuritySettingActivityV2.this, DevicePinVerifyEnterActivity.class);
                    intent.putExtra("verify_for_global_pin", true);
                    Intent intent2 = SecuritySettingActivityV2.this.getIntent();
                    if (intent2 != null) {
                        intent.putExtras(intent2);
                    }
                    intent.putExtra("fromSettingPage", true);
                    SecuritySettingActivityV2.this.startActivityForResult(intent, 101);
                    SecuritySettingActivityV2.this.showPinCodeOpen();
                } else {
                    SecuritySettingActivityV2.this.showPinCodeClose();
                }
                SecuritySettingActivityV2.this.dismissProgressDialog();
            }

            public final void onFailure(fso fso) {
                gqg.O00000Oo((int) R.string.toast_failed_retry);
                SecuritySettingActivityV2.this.finish();
            }
        });
        this.vTitle.setText(getString(R.string.device_more_security_title));
        this.vTitle.setVisibility(4);
        this.tvBigTitle.setTypeface(gno.O000000o(this, "fonts/MI-LANTING--GBK1-Light.ttf"));
        this.mAppBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarLayout.OnOffsetChangedListener() {
            /* class com.xiaomi.smarthome.framework.page.verify.$$Lambda$SecuritySettingActivityV2$5dUCidaeB1HKLBduRkME8wRuYg0 */

            public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                SecuritySettingActivityV2.this.O000000o(appBarLayout, i);
            }
        });
        this.vFingerPrintSwitch.setOnTouchEnable(false);
    }
}

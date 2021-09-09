package com.xiaomi.smarthome.framework.page.verify;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fvz;
import _m_j.fwd;
import _m_j.fwg;
import _m_j.fwn;
import _m_j.ggb;
import _m_j.gpv;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gva;
import _m_j.hxi;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.page.verify.manager.VerifyGlobalManager;
import com.xiaomi.smarthome.framework.page.verify.view.PinInputView;
import com.xiaomi.smarthome.framework.page.verify.view.PinSoftKeyboard;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DevicePinVerifyClearActivity extends BaseActivity implements PinSoftKeyboard.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    XQProgressDialog f7955O000000o;
    VerifyGlobalManager O00000Oo;
    String O00000o;
    List<Device> O00000o0;
    String O00000oO;
    private long O00000oo;
    private int O0000O0o;
    @BindView(5619)
    LinearLayout layoutDeviceContainer;
    @BindView(5620)
    TextView tvErrorTips;
    @BindView(5497)
    TextView tvMore;
    @BindView(5627)
    TextView tvTip;
    @BindView(5621)
    PinInputView vPinInputView;
    @BindView(5622)
    PinSoftKeyboard vPinSoftKeyboard;

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
        setContentView((int) R.layout.activity_device_pin_clear);
        ButterKnife.bind(this);
        this.O00000o = CoreApi.O000000o().O0000o0();
        if (fvz.O000000o().O00000Oo(this.O00000o)) {
            gqg.O00000Oo(getString(R.string.device_more_verify_locked));
            finish();
            return;
        }
        hxi.O00000o.O00000Oo((Integer) null);
        this.O00000Oo = VerifyGlobalManager.O000000o(this);
        this.vPinSoftKeyboard.setClickListener(this);
        this.O00000o0 = new ArrayList();
        for (Map.Entry<String, Device> value : fno.O000000o().O00000oO().entrySet()) {
            Device device = (Device) value.getValue();
            if (device != null && !fwn.O000000o(device) && (device.pinCodeType & 1) == 1) {
                this.O00000o0.add(device);
            }
        }
        this.O00000oO = getString(this.O00000o0.size() == 1 ? R.string.device_more_security_verify_old_when_1device : R.string.device_more_security_verify_old_hint);
        this.tvTip.setText(this.O00000oO);
        refreshDevicesView();
    }

    public void refreshDevicesView() {
        int childCount = this.layoutDeviceContainer.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            this.layoutDeviceContainer.removeViewAt(0);
        }
        this.tvMore.setVisibility(this.O00000o0.size() > 3 ? 0 : 8);
        int i2 = 0;
        while (i2 < this.O00000o0.size()) {
            this.layoutDeviceContainer.addView(new O000000o(this, this.O00000o0.get(i2)).f7957O000000o, 0, new LinearLayout.LayoutParams(-1, -2, 1.0f));
            if (i2 != 2) {
                i2++;
            } else {
                return;
            }
        }
    }

    public void onNumberClick(int i) {
        String pinCode = this.vPinInputView.getPinCode();
        if (TextUtils.isEmpty(pinCode) || pinCode.length() < this.vPinInputView.getPincodeNumber()) {
            TextView textView = this.tvErrorTips;
            if (textView != null && textView.getVisibility() == 0) {
                this.tvErrorTips.setVisibility(4);
            }
            String O000000o2 = this.vPinInputView.O000000o(i);
            if (O000000o2.length() >= this.vPinInputView.getPincodeNumber()) {
                runOnUiThread(new Runnable(O000000o2) {
                    /* class com.xiaomi.smarthome.framework.page.verify.$$Lambda$DevicePinVerifyClearActivity$FiSB8YOjB23xz5bNSnAPtwIFKw */
                    private final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        DevicePinVerifyClearActivity.this.O000000o(this.f$1);
                    }
                });
                return;
            }
            return;
        }
        gsy.O00000Oo("DevicePinVerifyClearActivity", "onNumberClick: pin code is over input, max length:" + this.vPinInputView.getPincodeNumber());
    }

    public void processInputError() {
        dismissDialog();
        this.vPinInputView.O00000o0();
        this.tvErrorTips.setVisibility(0);
        if (this.O00000oo == 0 || System.currentTimeMillis() - this.O00000oo < 300000) {
            this.O0000O0o++;
        } else {
            this.O0000O0o = 1;
        }
        this.O00000oo = System.currentTimeMillis();
        if (this.O0000O0o >= 5) {
            fvz.O000000o().O000000o(this.O00000o);
            gqg.O00000Oo(getString(R.string.device_more_verify_locked));
            finish();
        }
    }

    public void dismissDialog() {
        XQProgressDialog xQProgressDialog;
        if (isValid() && (xQProgressDialog = this.f7955O000000o) != null && xQProgressDialog.isShowing()) {
            this.f7955O000000o.dismiss();
        }
    }

    @OnClick({5470})
    public void onClickBack() {
        hxi.O00000o.O00000Oo((Integer) 0);
        finish();
    }

    public void onBackClick() {
        hxi.O00000o.O00000Oo((Integer) 0);
        finish();
    }

    public void onBackPressed() {
        hxi.O00000o.O00000Oo((Integer) 0);
        super.onBackPressed();
    }

    public void onDeleteClick() {
        this.vPinInputView.O000000o();
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        View f7957O000000o;
        SimpleDraweeView O00000Oo = ((SimpleDraweeView) this.f7957O000000o.findViewById(R.id.device_icon));
        TextView O00000o = ((TextView) this.f7957O000000o.findViewById(R.id.device_room_name));
        TextView O00000o0 = ((TextView) this.f7957O000000o.findViewById(R.id.device_name));

        public O000000o(Context context, Device device) {
            this.f7957O000000o = View.inflate(context, R.layout.pin_clear_device_item, null);
            this.O00000o0.setText(device.name);
            this.O00000o.setText(ggb.O00000Oo().O0000o0O(device.did));
            DeviceFactory.O000000o(device.model, this.O00000Oo, 0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(String str) {
        if (isValid()) {
            if (this.f7955O000000o == null) {
                this.f7955O000000o = new XQProgressDialog(this);
                this.f7955O000000o.setMessage(getString(R.string.device_more_security_loading_operation));
                this.f7955O000000o.setCancelable(false);
            }
            this.f7955O000000o.show();
        }
        ArrayList arrayList = new ArrayList(this.O00000o0.size());
        for (Device device : this.O00000o0) {
            arrayList.add(device.did);
        }
        VerifyGlobalManager verifyGlobalManager = this.O00000Oo;
        AnonymousClass1 r2 = new fwg<List<String>>() {
            /* class com.xiaomi.smarthome.framework.page.verify.DevicePinVerifyClearActivity.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                List list = (List) obj;
                if (list.isEmpty()) {
                    hxi.O00000o.O00000Oo((Integer) 1);
                    DevicePinVerifyClearActivity.this.processInputError();
                    return;
                }
                DevicePinVerifyClearActivity.this.tvErrorTips.setVisibility(4);
                Iterator<Device> it = DevicePinVerifyClearActivity.this.O00000o0.iterator();
                while (it.hasNext()) {
                    Device next = it.next();
                    if (list.contains(next.did)) {
                        it.remove();
                        fno.O000000o().O00000o0(next);
                        fno.O000000o().O0000Oo0();
                    }
                }
                if (DevicePinVerifyClearActivity.this.O00000o0.isEmpty()) {
                    DevicePinVerifyClearActivity.this.dismissDialog();
                    fbs.O000000o(new fbt(DevicePinVerifyClearActivity.this, "SecuritySettingActivityV2"));
                    DevicePinVerifyClearActivity.this.finish();
                    return;
                }
                DevicePinVerifyClearActivity.this.refreshDevicesView();
                DevicePinVerifyClearActivity.this.vPinInputView.O00000Oo();
                DevicePinVerifyClearActivity.this.dismissDialog();
            }

            public final void onFailure(fso fso) {
                DevicePinVerifyClearActivity.this.dismissDialog();
                DevicePinVerifyClearActivity.this.vPinInputView.O00000Oo();
                gqg.O00000Oo(fso.toString());
            }
        };
        if (!VerifyGlobalManager.O00000Oo(this)) {
            r2.onFailure(new fso(-1, getString(R.string.device_more_security_network_error)));
        }
        fwd.O000000o().O000000o(this, str, arrayList, new fsm<List<String>, fso>(arrayList, r2) {
            /* class com.xiaomi.smarthome.framework.page.verify.manager.VerifyGlobalManager.AnonymousClass4 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ List f8019O000000o;
            final /* synthetic */ fwg O00000Oo;

            {
                this.f8019O000000o = r2;
                this.O00000Oo = r3;
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                List list = (List) obj;
                for (String remove : this.f8019O000000o) {
                    VerifyManager.O00000o0.remove(remove);
                }
                this.O00000Oo.onSuccess(list);
            }

            public final void onFailure(fso fso) {
                this.O00000Oo.onFailure(fso);
            }
        });
    }
}

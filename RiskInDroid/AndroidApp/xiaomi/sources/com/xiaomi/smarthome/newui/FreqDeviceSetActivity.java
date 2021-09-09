package com.xiaomi.smarthome.newui;

import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gfx;
import _m_j.ggb;
import _m_j.gqd;
import _m_j.gqg;
import _m_j.hfy;
import _m_j.itz;
import _m_j.iua;
import _m_j.iuo;
import _m_j.ixe;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.operation.js_sdk.share.LoadingDialogHelper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0014H\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8FX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/xiaomi/smarthome/newui/FreqDeviceSetActivity;", "Lcom/xiaomi/smarthome/framework/page/BaseActivity;", "()V", "device", "Lcom/xiaomi/smarthome/device/Device;", "getDevice", "()Lcom/xiaomi/smarthome/device/Device;", "setDevice", "(Lcom/xiaomi/smarthome/device/Device;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "loadingDialogHelper", "Lcom/xiaomi/smarthome/operation/js_sdk/share/LoadingDialogHelper;", "pageType", "", "getPageType", "()I", "pageType$delegate", "Lkotlin/Lazy;", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FreqDeviceSetActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private final itz f10090O000000o = iua.O000000o(new FreqDeviceSetActivity$pageType$2(this));
    private Device O00000Oo;
    private final CompositeDisposable O00000o0 = new CompositeDisposable();
    public LoadingDialogHelper loadingDialogHelper = new LoadingDialogHelper(this);

    public final void _$_clearFindViewByIdCache() {
    }

    public final int getPageType() {
        return ((Number) this.f10090O000000o.O000000o()).intValue();
    }

    public final Device getDevice() {
        return this.O00000Oo;
    }

    public final void setDevice(Device device) {
        this.O00000Oo = device;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_freq_device_set);
        fno O000000o2 = fno.O000000o();
        Intent intent = getIntent();
        this.O00000Oo = O000000o2.O000000o(intent == null ? null : intent.getStringExtra("did"));
        if (this.O00000Oo == null) {
            finish();
        } else {
            O000000o();
        }
    }

    private final void O000000o() {
        boolean z;
        int pageType = getPageType();
        Boolean bool = null;
        if (pageType == 1) {
            ((TextView) findViewById(R.id.module_a_3_return_title)).setText(getString(R.string.common_use_device_room_manager_title));
            ((TextView) findViewById(R.id.tv_switch_title)).setText(getString(R.string.mj_set_as_homepage_common_equipment));
            SwitchButton switchButton = (SwitchButton) findViewById(R.id.sb_switch_btn);
            Device device = this.O00000Oo;
            Boolean valueOf = device == null ? null : Boolean.valueOf(device.freqFlag);
            if (valueOf != null) {
                switchButton.setChecked(valueOf.booleanValue());
                ((SimpleDraweeView) findViewById(R.id.bg)).setImageURI(gqd.O000000o((int) R.drawable.mj_device_freq_bg));
            } else {
                return;
            }
        } else if (pageType == 2) {
            ((TextView) findViewById(R.id.module_a_3_return_title)).setText(getString(R.string.mj_common_cameras));
            ((TextView) findViewById(R.id.tv_switch_title)).setText(getString(R.string.camera_set_as_homepage_common_device));
            hfy hfy = hfy.f18887O000000o;
            ((SwitchButton) findViewById(R.id.sb_switch_btn)).setChecked(hfy.O000000o(this.O00000Oo));
            ((SimpleDraweeView) findViewById(R.id.bg)).setImageURI(gqd.O000000o((int) R.drawable.mj_camera_freq_bg));
        }
        SwitchButton switchButton2 = (SwitchButton) findViewById(R.id.sb_switch_btn);
        ggb O00000Oo2 = ggb.O00000Oo();
        Device device2 = this.O00000Oo;
        Home O0000o0 = O00000Oo2.O0000o0(device2 == null ? null : device2.did);
        Boolean valueOf2 = O0000o0 == null ? null : Boolean.valueOf(O0000o0.isOwner());
        if (valueOf2 == null) {
            Home O0000Oo0 = ggb.O00000Oo().O0000Oo0();
            if (O0000Oo0 != null) {
                bool = Boolean.valueOf(O0000Oo0.isOwner());
            }
            if (bool != null) {
                z = bool.booleanValue();
            } else {
                return;
            }
        } else {
            z = valueOf2.booleanValue();
        }
        switchButton2.setEnabled(z);
        if (!((SwitchButton) findViewById(R.id.sb_switch_btn)).isEnabled()) {
            ((LinearLayout) findViewById(R.id.ll_item)).setOnClickListener($$Lambda$FreqDeviceSetActivity$lwMEjeylSHb8A1g4OBOzA0U9A4g.INSTANCE);
        }
        ((SwitchButton) findViewById(R.id.sb_switch_btn)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.newui.$$Lambda$FreqDeviceSetActivity$7n9b3MCNMPzU6leWs8nQGQdzm8 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                FreqDeviceSetActivity.O000000o(FreqDeviceSetActivity.this, compoundButton, z);
            }
        });
        ((ImageView) findViewById(R.id.module_a_3_return_btn)).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.$$Lambda$FreqDeviceSetActivity$kKe0fUC9N5545tZfg7pIltclq0 */

            public final void onClick(View view) {
                FreqDeviceSetActivity.O000000o(FreqDeviceSetActivity.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    public static final void O000000o(View view) {
        gqg.O00000Oo((int) R.string.share_family_edit_warning);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(FreqDeviceSetActivity freqDeviceSetActivity, CompoundButton compoundButton, boolean z) {
        ixe.O00000o(freqDeviceSetActivity, "this$0");
        LoadingDialogHelper loadingDialogHelper2 = freqDeviceSetActivity.loadingDialogHelper;
        if (loadingDialogHelper2 != null) {
            loadingDialogHelper2.O000000o();
        }
        int pageType = freqDeviceSetActivity.getPageType();
        String str = null;
        if (pageType != 1) {
            if (pageType == 2) {
                if (z) {
                    hfy hfy = hfy.f18887O000000o;
                    Home O0000Oo0 = ggb.O00000Oo().O0000Oo0();
                    Device device = freqDeviceSetActivity.getDevice();
                    if (device != null) {
                        str = device.did;
                    }
                    if (str != null) {
                        hfy.O000000o(O0000Oo0, (List<String>) iuo.O000000o(str), false).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer(z) {
                            /* class com.xiaomi.smarthome.newui.$$Lambda$FreqDeviceSetActivity$FHB6UtqHSrDcSG4UiMVoG7h4MZA */
                            private final /* synthetic */ boolean f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void accept(Object obj) {
                                FreqDeviceSetActivity.O000000o(FreqDeviceSetActivity.this, this.f$1, (Boolean) obj);
                            }
                        }, new Consumer(z) {
                            /* class com.xiaomi.smarthome.newui.$$Lambda$FreqDeviceSetActivity$XcLNBk8NUAm7pLFsxvVXOPyMuGM */
                            private final /* synthetic */ boolean f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void accept(Object obj) {
                                FreqDeviceSetActivity.O000000o(FreqDeviceSetActivity.this, this.f$1, (Throwable) obj);
                            }
                        });
                        return;
                    }
                    return;
                }
                hfy hfy2 = hfy.f18887O000000o;
                Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
                Device device2 = freqDeviceSetActivity.getDevice();
                if (device2 != null) {
                    str = device2.did;
                }
                if (str != null) {
                    freqDeviceSetActivity.O00000o0.add(hfy.O000000o(O0000Oo02, iuo.O000000o(str)).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer(z) {
                        /* class com.xiaomi.smarthome.newui.$$Lambda$FreqDeviceSetActivity$tuIF5dEyzPKx7mBt7wzcJfoRZ8 */
                        private final /* synthetic */ boolean f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void accept(Object obj) {
                            FreqDeviceSetActivity.O00000Oo(FreqDeviceSetActivity.this, this.f$1, (Boolean) obj);
                        }
                    }, new Consumer(z) {
                        /* class com.xiaomi.smarthome.newui.$$Lambda$FreqDeviceSetActivity$wi_n5b2gPANtmUTXK6tajnV51g */
                        private final /* synthetic */ boolean f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void accept(Object obj) {
                            FreqDeviceSetActivity.O00000Oo(FreqDeviceSetActivity.this, this.f$1, (Throwable) obj);
                        }
                    }));
                }
            }
        } else if (z) {
            gfx O000000o2 = gfx.O000000o();
            Device device3 = freqDeviceSetActivity.getDevice();
            if (device3 != null) {
                str = device3.did;
            }
            O000000o2.O000000o(iuo.O000000o(str), new O000000o(freqDeviceSetActivity, z));
        } else {
            gfx O000000o3 = gfx.O000000o();
            Device device4 = freqDeviceSetActivity.getDevice();
            if (device4 != null) {
                str = device4.did;
            }
            O000000o3.O00000Oo(iuo.O000000o(str), new O00000Oo(freqDeviceSetActivity, z));
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/xiaomi/smarthome/newui/FreqDeviceSetActivity$initView$2$1", "Lcom/xiaomi/smarthome/frame/AsyncCallback;", "Lorg/json/JSONObject;", "Lcom/xiaomi/smarthome/frame/Error;", "onFailure", "", "error", "onSuccess", "result", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o extends fsm<JSONObject, fso> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ FreqDeviceSetActivity f10091O000000o;
        final /* synthetic */ boolean O00000Oo;

        O000000o(FreqDeviceSetActivity freqDeviceSetActivity, boolean z) {
            this.f10091O000000o = freqDeviceSetActivity;
            this.O00000Oo = z;
        }

        public final void onFailure(fso fso) {
            LoadingDialogHelper loadingDialogHelper = this.f10091O000000o.loadingDialogHelper;
            if (loadingDialogHelper != null) {
                loadingDialogHelper.O00000Oo();
            }
            ((SwitchButton) this.f10091O000000o.findViewById(R.id.sb_switch_btn)).setChecked(!this.O00000Oo, false);
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            LoadingDialogHelper loadingDialogHelper = this.f10091O000000o.loadingDialogHelper;
            if (loadingDialogHelper != null) {
                loadingDialogHelper.O00000Oo();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/xiaomi/smarthome/newui/FreqDeviceSetActivity$initView$2$2", "Lcom/xiaomi/smarthome/frame/AsyncCallback;", "Lorg/json/JSONObject;", "Lcom/xiaomi/smarthome/frame/Error;", "onFailure", "", "error", "onSuccess", "result", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000Oo extends fsm<JSONObject, fso> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ FreqDeviceSetActivity f10092O000000o;
        final /* synthetic */ boolean O00000Oo;

        O00000Oo(FreqDeviceSetActivity freqDeviceSetActivity, boolean z) {
            this.f10092O000000o = freqDeviceSetActivity;
            this.O00000Oo = z;
        }

        public final void onFailure(fso fso) {
            LoadingDialogHelper loadingDialogHelper = this.f10092O000000o.loadingDialogHelper;
            if (loadingDialogHelper != null) {
                loadingDialogHelper.O00000Oo();
            }
            ((SwitchButton) this.f10092O000000o.findViewById(R.id.sb_switch_btn)).setChecked(!this.O00000Oo, false);
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            LoadingDialogHelper loadingDialogHelper = this.f10092O000000o.loadingDialogHelper;
            if (loadingDialogHelper != null) {
                loadingDialogHelper.O00000Oo();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(FreqDeviceSetActivity freqDeviceSetActivity, boolean z, Boolean bool) {
        ixe.O00000o(freqDeviceSetActivity, "this$0");
        LoadingDialogHelper loadingDialogHelper2 = freqDeviceSetActivity.loadingDialogHelper;
        if (loadingDialogHelper2 != null) {
            loadingDialogHelper2.O00000Oo();
        }
        ixe.O00000Oo(bool, "it");
        if (bool.booleanValue()) {
            gqg.O00000Oo((int) R.string.action_success);
            return;
        }
        gqg.O00000Oo((int) R.string.action_fail);
        ((SwitchButton) freqDeviceSetActivity.findViewById(R.id.sb_switch_btn)).setChecked(!z, false);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(FreqDeviceSetActivity freqDeviceSetActivity, boolean z, Throwable th) {
        ixe.O00000o(freqDeviceSetActivity, "this$0");
        LoadingDialogHelper loadingDialogHelper2 = freqDeviceSetActivity.loadingDialogHelper;
        if (loadingDialogHelper2 != null) {
            loadingDialogHelper2.O00000Oo();
        }
        gqg.O00000Oo((int) R.string.action_fail);
        ((SwitchButton) freqDeviceSetActivity.findViewById(R.id.sb_switch_btn)).setChecked(!z, false);
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(FreqDeviceSetActivity freqDeviceSetActivity, boolean z, Boolean bool) {
        ixe.O00000o(freqDeviceSetActivity, "this$0");
        LoadingDialogHelper loadingDialogHelper2 = freqDeviceSetActivity.loadingDialogHelper;
        if (loadingDialogHelper2 != null) {
            loadingDialogHelper2.O00000Oo();
        }
        ixe.O00000Oo(bool, "it");
        if (bool.booleanValue()) {
            gqg.O00000Oo((int) R.string.action_success);
            return;
        }
        gqg.O00000Oo((int) R.string.action_fail);
        ((SwitchButton) freqDeviceSetActivity.findViewById(R.id.sb_switch_btn)).setChecked(!z, false);
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(FreqDeviceSetActivity freqDeviceSetActivity, boolean z, Throwable th) {
        ixe.O00000o(freqDeviceSetActivity, "this$0");
        LoadingDialogHelper loadingDialogHelper2 = freqDeviceSetActivity.loadingDialogHelper;
        if (loadingDialogHelper2 != null) {
            loadingDialogHelper2.O00000Oo();
        }
        gqg.O00000Oo((int) R.string.action_fail);
        ((SwitchButton) freqDeviceSetActivity.findViewById(R.id.sb_switch_btn)).setChecked(!z, false);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(FreqDeviceSetActivity freqDeviceSetActivity, View view) {
        ixe.O00000o(freqDeviceSetActivity, "this$0");
        freqDeviceSetActivity.onBackPressed();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.O00000o0.clear();
        LoadingDialogHelper loadingDialogHelper2 = this.loadingDialogHelper;
        if (loadingDialogHelper2 != null) {
            loadingDialogHelper2.O00000Oo();
        }
    }
}

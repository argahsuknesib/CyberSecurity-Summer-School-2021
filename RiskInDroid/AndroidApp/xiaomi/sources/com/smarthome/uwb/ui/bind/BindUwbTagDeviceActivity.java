package com.smarthome.uwb.ui.bind;

import _m_j.ddv;
import _m_j.ddy;
import _m_j.fa;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fg;
import _m_j.fh;
import _m_j.fm;
import _m_j.fno;
import _m_j.fo;
import _m_j.ggb;
import _m_j.go;
import _m_j.gpc;
import _m_j.gqg;
import _m_j.gty;
import _m_j.gzl;
import _m_j.gzm;
import _m_j.hxi;
import _m_j.hzp;
import _m_j.hzs;
import _m_j.itz;
import _m_j.iua;
import _m_j.iuh;
import _m_j.iuo;
import _m_j.ixe;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.smarthome.uwb.ui.bind.BindUwbTagController;
import com.smarthome.uwb.ui.widget.NameAndStateTextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.widget.DevicePtrFrameLayout;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import com.xiaomi.smarthome.uwb.ui.UwbBaseActivity;
import com.xiaomi.smarthome.uwb.ui.widget.SHLoadingDialog;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 42\u00020\u0001:\u0006456789B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u0013H\u0002J\b\u0010(\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020&H\u0002J\b\u0010*\u001a\u00020\u0013H\u0002J\b\u0010+\u001a\u00020\u0013H\u0016J\u0012\u0010,\u001a\u00020&2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u0010/\u001a\u00020&H\u0014J\b\u00100\u001a\u00020&H\u0014J\u0010\u00101\u001a\u00020&2\u0006\u00102\u001a\u000203H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X.¢\u0006\u0002\n\u0000R+\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/smarthome/uwb/ui/bind/BindUwbTagDeviceActivity;", "Lcom/xiaomi/smarthome/uwb/ui/UwbBaseActivity;", "()V", "allAssociateDevId", "", "", "bindTagComparator", "Ljava/util/Comparator;", "Lcom/xiaomi/smarthome/device/Device;", "Lkotlin/Comparator;", "getBindTagComparator", "()Ljava/util/Comparator;", "bindTagComparator$delegate", "Lkotlin/Lazy;", "controller", "Lcom/smarthome/uwb/ui/bind/BindUwbTagController;", "filterBtn", "Landroid/widget/ImageView;", "isBindDialogCanceledByUser", "", "isBindSuccess", "isFirstEnter", "lastSelectItem", "mStrangerRegister", "Lcom/xiaomi/smarthome/uwb/lib/auth/UwbStrangerRegister;", "model", "ptrFrameLayout", "Lcom/xiaomi/smarthome/library/common/widget/DevicePtrFrameLayout;", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Lcom/smarthome/uwb/ui/bind/BindUwbViewModel;", "tagDevice", "tagId", "tagOwnHomeId", "uwbScanDevice", "Lcom/xiaomi/smarthome/uwb/lib/data/UwbScanDevice;", "addForTest", "", "checkArgumentValid", "initEventListener", "initView", "loginIfNeeded", "needExitUwb", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "tvIntroLinkSetting", "bindIntroTv", "Landroid/widget/TextView;", "Companion", "ItemAdapter", "NoFilterDeviceAdapter", "NoSupportDeviceAdapter", "TitleAdapter", "TvGuideAdapter", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BindUwbTagDeviceActivity extends UwbBaseActivity {
    public static final O000000o Companion = new O000000o((byte) 0);

    /* renamed from: O000000o  reason: collision with root package name */
    private ddv f5722O000000o;
    private DevicePtrFrameLayout O00000Oo;
    private String O00000o;
    private String O00000o0;
    private final itz O00000oO = iua.O000000o(new BindUwbTagDeviceActivity$bindTagComparator$2(this));
    private boolean O00000oo = true;
    private String O0000O0o;
    public List<String> allAssociateDevId;
    public BindUwbTagController controller;
    public ImageView filterBtn;
    public boolean isBindDialogCanceledByUser;
    public boolean isBindSuccess;
    public String lastSelectItem = "";
    public RecyclerView recycler;
    public Device tagDevice;
    public UwbScanDevice uwbScanDevice;

    public final void _$_clearFindViewByIdCache() {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/smarthome/uwb/ui/bind/BindUwbTagDeviceActivity$Companion;", "", "()V", "ARGS_HOME_ID", "", "ARGS_TAG_ID", "TAG", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0252, code lost:
        if ((r3 == null || r3.length() == 0) == false) goto L_0x0256;
     */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02c0  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00fb  */
    public final void onCreate(Bundle bundle) {
        Object obj;
        BindUwbTagController bindUwbTagController;
        String str;
        super.onCreate(bundle);
        this.O00000o0 = getIntent().getStringExtra("args_tag_id");
        this.O00000o = getIntent().getStringExtra("args_home_id");
        CharSequence charSequence = this.O00000o0;
        boolean z = true;
        if (charSequence == null || charSequence.length() == 0) {
            CharSequence charSequence2 = this.O00000o;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                UwbLogUtil.d("Mijia-UWB-BindUwbTagDeviceActivit", "onCreate invalid params:");
                this.O00000o = ggb.O00000Oo().O0000o0(this.O00000o0).getId();
                CharSequence charSequence3 = this.O00000o;
                if (charSequence3 == null || charSequence3.length() == 0) {
                    finish();
                    gqg.O00000Oo((int) R.string.failed);
                    return;
                }
            }
        }
        List<Device> O00000oo2 = fno.O000000o().O00000oo();
        ixe.O00000Oo(O00000oo2, "getInstance().extraDevices");
        Iterator it = O00000oo2.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (ixe.O000000o((Object) ((Device) obj).did, (Object) this.O00000o0)) {
                break;
            }
        }
        this.tagDevice = (Device) obj;
        this.uwbScanDevice = (UwbScanDevice) getIntent().getParcelableExtra("uwb_scan_device");
        if (this.uwbScanDevice != null) {
            PluginDeviceManager pluginDeviceManager = PluginDeviceManager.instance;
            UwbScanDevice uwbScanDevice2 = this.uwbScanDevice;
            ixe.O000000o(uwbScanDevice2);
            str = pluginDeviceManager.getModelByProductId((int) uwbScanDevice2.getPid());
        } else {
            Device device = this.tagDevice;
            if (device != null) {
                if (device == null) {
                    str = null;
                } else {
                    str = device.model;
                }
            }
            FragmentActivity fragmentActivity = this;
            fm O000000o2 = fo.O000000o(fragmentActivity).O000000o(ddv.class);
            ixe.O00000Oo(O000000o2, "of(this).get(BindUwbViewModel::class.java)");
            this.f5722O000000o = (ddv) O000000o2;
            this.controller = new BindUwbTagController(this.O00000o0, this.O00000o);
            bindUwbTagController = this.controller;
            if (bindUwbTagController == null) {
                bindUwbTagController.O000000o(fragmentActivity);
                if (this.controller != null) {
                    this.allAssociateDevId = BindUwbTagController.O00000Oo();
                    StringBuilder sb = new StringBuilder("onCreate: tagId: ");
                    sb.append((Object) this.O00000o0);
                    sb.append(",tagOwnHomeId:");
                    sb.append((Object) this.O00000o);
                    sb.append(",allAssociateDevId : ");
                    List<String> list = this.allAssociateDevId;
                    if (list != null) {
                        sb.append(list);
                        UwbLogUtil.d("Mijia-UWB-BindUwbTagDeviceActivit", sb.toString());
                        setContentView((int) R.layout.bind_uwb_tag_layout);
                        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.uwb_bind_select_device_title);
                        ImageView imageView = (ImageView) findViewById(R.id.module_a_3_return_btn);
                        imageView.setImageResource(R.drawable.title_cancel_selector);
                        imageView.setOnClickListener(new View.OnClickListener() {
                            /* class com.smarthome.uwb.ui.bind.$$Lambda$BindUwbTagDeviceActivity$qKKhUz1SwUmzb0gcSyKWB6JcdY */

                            public final void onClick(View view) {
                                BindUwbTagDeviceActivity.O000000o(BindUwbTagDeviceActivity.this, view);
                            }
                        });
                        View findViewById = findViewById(R.id.module_a_3_right_iv_setting_btn);
                        ixe.O00000Oo(findViewById, "findViewById(R.id.module_a_3_right_iv_setting_btn)");
                        this.filterBtn = (ImageView) findViewById;
                        ImageView imageView2 = this.filterBtn;
                        if (imageView2 != null) {
                            imageView2.setImageResource(R.drawable.title_filter_selector);
                            ImageView imageView3 = this.filterBtn;
                            if (imageView3 != null) {
                                imageView3.setOnClickListener(new View.OnClickListener() {
                                    /* class com.smarthome.uwb.ui.bind.$$Lambda$BindUwbTagDeviceActivity$mGvWBO3EZgtgnJokTyCncBeG_fU */

                                    public final void onClick(View view) {
                                        BindUwbTagDeviceActivity.O00000Oo(BindUwbTagDeviceActivity.this, view);
                                    }
                                });
                                View findViewById2 = findViewById(R.id.recycler);
                                ixe.O00000Oo(findViewById2, "findViewById(R.id.recycler)");
                                this.recycler = (RecyclerView) findViewById2;
                                RecyclerView recyclerView = this.recycler;
                                if (recyclerView != null) {
                                    recyclerView.setNestedScrollingEnabled(true);
                                    RecyclerView recyclerView2 = this.recycler;
                                    if (recyclerView2 != null) {
                                        recyclerView2.setLayoutManager(new BindUwbTagDeviceActivity$initView$3(getContext()));
                                        RecyclerView recyclerView3 = this.recycler;
                                        if (recyclerView3 != null) {
                                            go goVar = new go();
                                            goVar.O0000o00 = false;
                                            iuh iuh = iuh.f1631O000000o;
                                            recyclerView3.setItemAnimator(goVar);
                                            View findViewById3 = findViewById(R.id.pull_down_refresh);
                                            ixe.O00000Oo(findViewById3, "findViewById(R.id.pull_down_refresh)");
                                            this.O00000Oo = (DevicePtrFrameLayout) findViewById3;
                                            DevicePtrFrameLayout devicePtrFrameLayout = this.O00000Oo;
                                            if (devicePtrFrameLayout != null) {
                                                devicePtrFrameLayout.setPtrHandler(new O0000Oo0(this));
                                                ddv ddv = this.f5722O000000o;
                                                if (ddv != null) {
                                                    fa faVar = this;
                                                    ddv.O00000Oo.observe(faVar, new fh() {
                                                        /* class com.smarthome.uwb.ui.bind.$$Lambda$BindUwbTagDeviceActivity$hWaiVFH34qDYqfUjta714aL6Czc */

                                                        public final void onChanged(Object obj) {
                                                            BindUwbTagDeviceActivity.O000000o(BindUwbTagDeviceActivity.this, (List) obj);
                                                        }
                                                    });
                                                    ddv ddv2 = this.f5722O000000o;
                                                    if (ddv2 != null) {
                                                        ddv2.O00000o0.observe(faVar, new fh() {
                                                            /* class com.smarthome.uwb.ui.bind.$$Lambda$BindUwbTagDeviceActivity$DFiX6NBs3YriLDBw8BRYMNadGoA */

                                                            public final void onChanged(Object obj) {
                                                                BindUwbTagDeviceActivity.O00000Oo(BindUwbTagDeviceActivity.this, (List) obj);
                                                            }
                                                        });
                                                        if (!O000000o()) {
                                                            BindUwbTagController bindUwbTagController2 = this.controller;
                                                            if (bindUwbTagController2 != null) {
                                                                bindUwbTagController2.O000000o(true);
                                                            } else {
                                                                ixe.O000000o("controller");
                                                                throw null;
                                                            }
                                                        } else {
                                                            BindUwbTagController bindUwbTagController3 = this.controller;
                                                            if (bindUwbTagController3 != null) {
                                                                ddv ddv3 = bindUwbTagController3.O00000o0;
                                                                if (ddv3 != null) {
                                                                    fg<List<ddv.O00000Oo>> fgVar = ddv3.O00000o0;
                                                                    ddv.O000000o o000000o = ddv.f14525O000000o;
                                                                    fgVar.postValue(ddv.O00000oo);
                                                                } else {
                                                                    ixe.O000000o("state");
                                                                    throw null;
                                                                }
                                                            } else {
                                                                ixe.O000000o("controller");
                                                                throw null;
                                                            }
                                                        }
                                                        if (this.uwbScanDevice != null) {
                                                            if (this.controller != null) {
                                                                BindUwbTagController.O000000o((Activity) this);
                                                            } else {
                                                                ixe.O000000o("controller");
                                                                throw null;
                                                            }
                                                        }
                                                        boolean z2 = this.uwbScanDevice != null;
                                                        if (this.tagDevice != null) {
                                                            CharSequence charSequence4 = this.O00000o;
                                                        }
                                                        z = false;
                                                        if (!(z2 ^ z)) {
                                                            UwbLogUtil.d("Mijia-UWB-BindUwbTagDeviceActivit", "invalid params: uwbScanDevice: " + this.uwbScanDevice + ",tagDevice:" + this.tagDevice + ", homeOwnId: " + ((Object) this.O00000o));
                                                        }
                                                        hxi.O0000o00.f954O000000o.O000000o("uwb_bind_page", new Object[0]);
                                                        return;
                                                    }
                                                    ixe.O000000o("state");
                                                    throw null;
                                                }
                                                ixe.O000000o("state");
                                                throw null;
                                            }
                                            ixe.O000000o("ptrFrameLayout");
                                            throw null;
                                        }
                                        ixe.O000000o("recycler");
                                        throw null;
                                    }
                                    ixe.O000000o("recycler");
                                    throw null;
                                }
                                ixe.O000000o("recycler");
                                throw null;
                            }
                            ixe.O000000o("filterBtn");
                            throw null;
                        }
                        ixe.O000000o("filterBtn");
                        throw null;
                    }
                    ixe.O000000o("allAssociateDevId");
                    throw null;
                }
                ixe.O000000o("controller");
                throw null;
            }
            ixe.O000000o("controller");
            throw null;
        }
        this.O0000O0o = str;
        FragmentActivity fragmentActivity2 = this;
        fm O000000o22 = fo.O000000o(fragmentActivity2).O000000o(ddv.class);
        ixe.O00000Oo(O000000o22, "of(this).get(BindUwbViewModel::class.java)");
        this.f5722O000000o = (ddv) O000000o22;
        this.controller = new BindUwbTagController(this.O00000o0, this.O00000o);
        bindUwbTagController = this.controller;
        if (bindUwbTagController == null) {
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(BindUwbTagDeviceActivity bindUwbTagDeviceActivity, List list) {
        boolean z;
        ixe.O00000o(bindUwbTagDeviceActivity, "this$0");
        if (list != null) {
            Iterable iterable = list;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!((ddy.O000000o) it.next()).f14531O000000o.isEmpty()) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z = true;
            if (!z) {
                ImageView imageView = bindUwbTagDeviceActivity.filterBtn;
                if (imageView != null) {
                    imageView.setSelected(true);
                    return;
                } else {
                    ixe.O000000o("filterBtn");
                    throw null;
                }
            }
        }
        ImageView imageView2 = bindUwbTagDeviceActivity.filterBtn;
        if (imageView2 != null) {
            imageView2.setSelected(false);
        } else {
            ixe.O000000o("filterBtn");
            throw null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.util.List<java.lang.String>]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.util.List]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T>
     arg types: [java.util.List<com.xiaomi.smarthome.device.Device>, java.util.Comparator]
     candidates:
      _m_j.iuy.O000000o(java.util.List, int):T
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Collection):C
      _m_j.iuy.O000000o(java.lang.Iterable, java.lang.Object):boolean
      _m_j.iuv.O000000o(java.util.Collection, java.lang.Iterable):boolean
      _m_j.iuv.O000000o(java.util.List, _m_j.iwc):boolean
      _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void
      _m_j.iur.O000000o(java.lang.Iterable, int):int
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T> */
    /* access modifiers changed from: private */
    public static final void O00000Oo(BindUwbTagDeviceActivity bindUwbTagDeviceActivity, List list) {
        String rawName;
        ixe.O00000o(bindUwbTagDeviceActivity, "this$0");
        DevicePtrFrameLayout devicePtrFrameLayout = bindUwbTagDeviceActivity.O00000Oo;
        if (devicePtrFrameLayout != null) {
            devicePtrFrameLayout.refreshComplete();
            if (bindUwbTagDeviceActivity.controller != null) {
                bindUwbTagDeviceActivity.allAssociateDevId = BindUwbTagController.O00000Oo();
                List<String> list2 = bindUwbTagDeviceActivity.allAssociateDevId;
                if (list2 != null) {
                    UwbLogUtil.d("Mijia-UWB-BindUwbTagDeviceActivit", ixe.O000000o("after refresh : allAssociateDevId: ", (Object) list2));
                    UwbLogUtil.d("Mijia-UWB-BindUwbTagDeviceActivit", ixe.O000000o("after refresh : filterResults: ", (Object) list));
                    if (list != null) {
                        ddv.O000000o o000000o = ddv.f14525O000000o;
                        if (!ixe.O000000o(list, ddv.O00000oo)) {
                            if (!list.isEmpty()) {
                                ddv.O000000o o000000o2 = ddv.f14525O000000o;
                                if (!ixe.O000000o(list, ddv.O00000oO)) {
                                    gzl gzl = new gzl();
                                    Iterator it = list.iterator();
                                    while (it.hasNext()) {
                                        ddv.O00000Oo o00000Oo = (ddv.O00000Oo) it.next();
                                        String str = o00000Oo.f14526O000000o;
                                        List<Device> list3 = o00000Oo.O00000Oo;
                                        Home O00000o2 = ggb.O00000Oo().O00000o(str);
                                        String str2 = "";
                                        if (!(O00000o2 == null || (rawName = O00000o2.getRawName()) == null)) {
                                            str2 = rawName;
                                        }
                                        gzl.O000000o(new O0000O0o(str2));
                                        gzl.O000000o(new O00000Oo(bindUwbTagDeviceActivity, str, iuo.O000000o((Iterable) list3, (Comparator) bindUwbTagDeviceActivity.O00000oO.O000000o())));
                                    }
                                    gzl.O000000o(new O0000OOo(bindUwbTagDeviceActivity));
                                    RecyclerView recyclerView = bindUwbTagDeviceActivity.recycler;
                                    if (recyclerView != null) {
                                        recyclerView.setAdapter(gzl);
                                        ImageView imageView = bindUwbTagDeviceActivity.filterBtn;
                                        if (imageView != null) {
                                            imageView.setVisibility(0);
                                            return;
                                        } else {
                                            ixe.O000000o("filterBtn");
                                            throw null;
                                        }
                                    } else {
                                        ixe.O000000o("recycler");
                                        throw null;
                                    }
                                }
                            }
                            gzl gzl2 = new gzl();
                            gzl2.O000000o(new O00000o0());
                            RecyclerView recyclerView2 = bindUwbTagDeviceActivity.recycler;
                            if (recyclerView2 != null) {
                                recyclerView2.setAdapter(gzl2);
                                ImageView imageView2 = bindUwbTagDeviceActivity.filterBtn;
                                if (imageView2 != null) {
                                    imageView2.setVisibility(0);
                                    return;
                                } else {
                                    ixe.O000000o("filterBtn");
                                    throw null;
                                }
                            } else {
                                ixe.O000000o("recycler");
                                throw null;
                            }
                        }
                    }
                    gzl gzl3 = new gzl();
                    gzl3.O000000o(new O00000o(bindUwbTagDeviceActivity));
                    RecyclerView recyclerView3 = bindUwbTagDeviceActivity.recycler;
                    if (recyclerView3 != null) {
                        recyclerView3.setAdapter(gzl3);
                        ImageView imageView3 = bindUwbTagDeviceActivity.filterBtn;
                        if (imageView3 != null) {
                            imageView3.setVisibility(8);
                        } else {
                            ixe.O000000o("filterBtn");
                            throw null;
                        }
                    } else {
                        ixe.O000000o("recycler");
                        throw null;
                    }
                } else {
                    ixe.O000000o("allAssociateDevId");
                    throw null;
                }
            } else {
                ixe.O000000o("controller");
                throw null;
            }
        } else {
            ixe.O000000o("ptrFrameLayout");
            throw null;
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(BindUwbTagDeviceActivity bindUwbTagDeviceActivity, View view) {
        ixe.O00000o(bindUwbTagDeviceActivity, "this$0");
        bindUwbTagDeviceActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(BindUwbTagDeviceActivity bindUwbTagDeviceActivity, View view) {
        ixe.O00000o(bindUwbTagDeviceActivity, "this$0");
        BindUwbTagController bindUwbTagController = bindUwbTagDeviceActivity.controller;
        if (bindUwbTagController != null) {
            Context context = bindUwbTagDeviceActivity.getContext();
            ixe.O00000Oo(context, "context");
            bindUwbTagController.O000000o(context);
            return;
        }
        ixe.O000000o("controller");
        throw null;
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/smarthome/uwb/ui/bind/BindUwbTagDeviceActivity$initView$5", "Lin/srain/cube/views/ptr/PtrHandler;", "checkCanDoRefresh", "", "p0", "Lin/srain/cube/views/ptr/PtrFrameLayout;", "p1", "Landroid/view/View;", "p2", "onRefreshBegin", "", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000Oo0 implements PtrHandler {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ BindUwbTagDeviceActivity f5734O000000o;

        O0000Oo0(BindUwbTagDeviceActivity bindUwbTagDeviceActivity) {
            this.f5734O000000o = bindUwbTagDeviceActivity;
        }

        public final boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
            ImageView imageView = this.f5734O000000o.filterBtn;
            if (imageView != null) {
                return !imageView.isSelected();
            }
            ixe.O000000o("filterBtn");
            throw null;
        }

        public final void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
            BindUwbTagController bindUwbTagController = this.f5734O000000o.controller;
            if (bindUwbTagController != null) {
                bindUwbTagController.O000000o();
            } else {
                ixe.O000000o("controller");
                throw null;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/smarthome/uwb/ui/bind/BindUwbTagDeviceActivity$tvIntroLinkSetting$span$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000Oo extends ClickableSpan {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ BindUwbTagDeviceActivity f5733O000000o;

        O0000Oo(BindUwbTagDeviceActivity bindUwbTagDeviceActivity) {
            this.f5733O000000o = bindUwbTagDeviceActivity;
        }

        public final void onClick(View view) {
            ixe.O00000o(view, "widget");
            fbt fbt = new fbt(CommonApplication.getAppContext(), "OperationCommonWebViewActivity");
            hzp hzp = hzp.f1018O000000o;
            fbt.O000000o("url", hzp.O000000o("https://home.mi.com/views/article.html?articleId=561479692000000001"));
            fbt.O00000Oo(268435456);
            fbs.O000000o(fbt);
        }

        public final void updateDrawState(TextPaint textPaint) {
            ixe.O00000o(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setColor(this.f5733O000000o.getContext().getResources().getColor(R.color.mj_color_green_normal));
        }
    }

    public final void tvIntroLinkSetting(TextView textView) {
        O0000Oo o0000Oo = new O0000Oo(this);
        SpannableString spannableString = new SpannableString(getString(R.string.uwb_bind_tv_intro));
        spannableString.setSpan(o0000Oo, 0, spannableString.length(), 18);
        textView.setHighlightColor(0);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void onResume() {
        if (!O000000o() && !this.O00000oo) {
            BindUwbTagController bindUwbTagController = this.controller;
            if (bindUwbTagController != null) {
                bindUwbTagController.O000000o();
            } else {
                ixe.O000000o("controller");
                throw null;
            }
        }
        this.O00000oo = false;
        getWindow().addFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
        super.onResume();
    }

    private static boolean O000000o() {
        if (ServiceApplication.getStateNotifier().f15923O000000o == 4 || ServiceApplication.getStateNotifier().f15923O000000o == 2) {
            return false;
        }
        gty.O000000o().startLogin(UwbSdk.getApplication(), 7, null);
        return true;
    }

    public final void onPause() {
        getWindow().clearFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
        super.onPause();
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J4\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/smarthome/uwb/ui/bind/BindUwbTagDeviceActivity$TitleAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getItemCount", "", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "position", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onBindViewHolder", "vh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "pos", "onCreateViewHolder", "Landroid/view/ViewGroup;", "VH", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static final class O0000O0o extends gzm {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f5729O000000o;

        public final int getItemCount() {
            return 1;
        }

        public O0000O0o(String str) {
            ixe.O00000o(str, "name");
            this.f5729O000000o = str;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            ixe.O00000o(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.bind_uwb_list_title, viewGroup, false);
            ixe.O00000Oo(inflate, "item");
            return new O000000o(this, inflate);
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ixe.O00000o(o000OOo0, "vh");
            O000000o o000000o = (O000000o) o000OOo0;
            ((TextView) o000000o.itemView).setText(o000000o.f5730O000000o.f5729O000000o);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/smarthome/uwb/ui/bind/BindUwbTagDeviceActivity$TitleAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/smarthome/uwb/ui/bind/BindUwbTagDeviceActivity$TitleAdapter;Landroid/view/View;)V", "bind", "", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public final class O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O0000O0o f5730O000000o;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O000000o(O0000O0o o0000O0o, View view) {
                super(view);
                ixe.O00000o(o0000O0o, "this$0");
                ixe.O00000o(view, "itemView");
                this.f5730O000000o = o0000O0o;
            }
        }

        public final void O000000o(Rect rect, View view, int i, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
            ixe.O00000o(rect, "outRect");
            ixe.O00000o(view, "view");
            rect.left = gpc.O000000o(view.getContext(), 27.0f);
            rect.top = gpc.O000000o(view.getContext(), 24.0f);
            rect.bottom = gpc.O000000o(view.getContext(), 4.0f);
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001fB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J4\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\rH\u0016J\u0018\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\rH\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006 "}, d2 = {"Lcom/smarthome/uwb/ui/bind/BindUwbTagDeviceActivity$ItemAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "homeId", "", "devices", "", "Lcom/xiaomi/smarthome/device/Device;", "(Lcom/smarthome/uwb/ui/bind/BindUwbTagDeviceActivity;Ljava/lang/String;Ljava/util/List;)V", "getDevices", "()Ljava/util/List;", "getHomeId", "()Ljava/lang/String;", "getItemCount", "", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "position", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onBindViewHolder", "vh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "pos", "onCreateViewHolder", "Landroid/view/ViewGroup;", "VH", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O00000Oo extends gzm {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f5723O000000o;
        final /* synthetic */ BindUwbTagDeviceActivity O00000Oo;
        private final List<Device> O00000o0;

        /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List<com.xiaomi.smarthome.device.Device>, java.lang.Object, java.util.List<? extends com.xiaomi.smarthome.device.Device>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        public O00000Oo(BindUwbTagDeviceActivity bindUwbTagDeviceActivity, String str, List<? extends Device> r4) {
            ixe.O00000o(bindUwbTagDeviceActivity, "this$0");
            ixe.O00000o(str, "homeId");
            ixe.O00000o(r4, "devices");
            this.O00000Oo = bindUwbTagDeviceActivity;
            this.f5723O000000o = str;
            this.O00000o0 = r4;
        }

        public final int getItemCount() {
            return this.O00000o0.size();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            ixe.O00000o(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.bind_uwb_list_item_main, viewGroup, false);
            ixe.O00000Oo(inflate, "item");
            return new O000000o(this, inflate);
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ixe.O00000o(o000OOo0, "vh");
            ((O000000o) o000OOo0).O000000o(this.O00000o0.get(i));
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/smarthome/uwb/ui/bind/BindUwbTagDeviceActivity$ItemAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/smarthome/uwb/ui/bind/BindUwbTagDeviceActivity$ItemAdapter;Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "container", "kotlin.jvm.PlatformType", "iconIv", "Lcom/facebook/drawee/view/SimpleDraweeView;", "nameTv", "Landroid/widget/TextView;", "roomNameTv", "Lcom/smarthome/uwb/ui/widget/NameAndStateTextView;", "bind", "", "device", "Lcom/xiaomi/smarthome/device/Device;", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public final class O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O00000Oo f5724O000000o;
            private final TextView O00000Oo;
            private final SimpleDraweeView O00000o;
            private final NameAndStateTextView O00000o0;
            private final CheckBox O00000oO;
            private final View O00000oo;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O000000o(O00000Oo o00000Oo, View view) {
                super(view);
                ixe.O00000o(o00000Oo, "this$0");
                ixe.O00000o(view, "itemView");
                this.f5724O000000o = o00000Oo;
                View findViewById = view.findViewById(R.id.name);
                ixe.O00000Oo(findViewById, "itemView.findViewById(R.id.name)");
                this.O00000Oo = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.room_name);
                ixe.O00000Oo(findViewById2, "itemView.findViewById(R.id.room_name)");
                this.O00000o0 = (NameAndStateTextView) findViewById2;
                View findViewById3 = view.findViewById(R.id.icon);
                ixe.O00000Oo(findViewById3, "itemView.findViewById(R.id.icon)");
                this.O00000o = (SimpleDraweeView) findViewById3;
                View findViewById4 = view.findViewById(R.id.check_box);
                ixe.O00000Oo(findViewById4, "itemView.findViewById(R.id.check_box)");
                this.O00000oO = (CheckBox) findViewById4;
                this.O00000oo = view.findViewById(R.id.item);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
             arg types: [java.lang.String, java.lang.String]
             candidates:
              _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
              _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
              _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
              _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
            public final void O000000o(Device device) {
                ixe.O00000o(device, "device");
                this.O00000Oo.setText(device.name);
                List<String> list = this.f5724O000000o.O00000Oo.allAssociateDevId;
                String str = null;
                if (list != null) {
                    boolean contains = list.contains(device.did);
                    if (contains) {
                        str = this.f5724O000000o.O00000Oo.getString(R.string.uwb_associcate_msg_already_associcated);
                    }
                    this.O00000o0.setNameAndState(ggb.O00000Oo().O0000o0O(device.did), str);
                    String O0000oOO = DeviceFactory.O0000oOO(device.model);
                    if (O0000oOO == null) {
                        O0000oOO = "";
                    }
                    int i = 0;
                    if (O0000oOO.length() == 0) {
                        DeviceFactory.O00000Oo(device.model, this.O00000o);
                    } else {
                        DeviceFactory.O000000o(O0000oOO, this.O00000o);
                    }
                    this.O00000oo.setSelected(ixe.O000000o((Object) device.did, (Object) this.f5724O000000o.O00000Oo.lastSelectItem));
                    CheckBox checkBox = this.O00000oO;
                    if (!ixe.O000000o((Object) device.did, (Object) this.f5724O000000o.O00000Oo.lastSelectItem)) {
                        i = 4;
                    }
                    checkBox.setVisibility(i);
                    this.O00000oO.setChecked(ixe.O000000o((Object) device.did, (Object) this.f5724O000000o.O00000Oo.lastSelectItem));
                    if (contains) {
                        this.itemView.setOnClickListener($$Lambda$BindUwbTagDeviceActivity$O00000Oo$O000000o$z51VsACxQneZOZAsttw5VCRVRM.INSTANCE);
                        return;
                    }
                    View view = this.itemView;
                    O00000Oo o00000Oo = this.f5724O000000o;
                    view.setOnClickListener(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00ab: INVOKE  
                          (r0v6 'view' android.view.View)
                          (wrap: com.smarthome.uwb.ui.bind.-$$Lambda$BindUwbTagDeviceActivity$O00000Oo$O000000o$BPIdXqQXcmU0VuyJ0XDFEjfbzac : 0x00a8: CONSTRUCTOR  (r3v7 com.smarthome.uwb.ui.bind.-$$Lambda$BindUwbTagDeviceActivity$O00000Oo$O000000o$BPIdXqQXcmU0VuyJ0XDFEjfbzac) = 
                          (r1v10 'o00000Oo' com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity$O00000Oo)
                          (wrap: com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity : 0x00a4: IGET  (r2v12 com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity) = (r1v10 'o00000Oo' com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity$O00000Oo) com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity.O00000Oo.O00000Oo com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity)
                          (r5v0 'this' com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity$O00000Oo$O000000o A[THIS])
                          (r6v0 'device' com.xiaomi.smarthome.device.Device)
                         call: com.smarthome.uwb.ui.bind.-$$Lambda$BindUwbTagDeviceActivity$O00000Oo$O000000o$BPIdXqQXcmU0VuyJ0XDFEjfbzac.<init>(com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity$O00000Oo, com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity, com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity$O00000Oo$O000000o, com.xiaomi.smarthome.device.Device):void type: CONSTRUCTOR)
                         type: VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void in method: com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity.O00000Oo.O000000o.O000000o(com.xiaomi.smarthome.device.Device):void, dex: classes4.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a8: CONSTRUCTOR  (r3v7 com.smarthome.uwb.ui.bind.-$$Lambda$BindUwbTagDeviceActivity$O00000Oo$O000000o$BPIdXqQXcmU0VuyJ0XDFEjfbzac) = 
                          (r1v10 'o00000Oo' com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity$O00000Oo)
                          (wrap: com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity : 0x00a4: IGET  (r2v12 com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity) = (r1v10 'o00000Oo' com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity$O00000Oo) com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity.O00000Oo.O00000Oo com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity)
                          (r5v0 'this' com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity$O00000Oo$O000000o A[THIS])
                          (r6v0 'device' com.xiaomi.smarthome.device.Device)
                         call: com.smarthome.uwb.ui.bind.-$$Lambda$BindUwbTagDeviceActivity$O00000Oo$O000000o$BPIdXqQXcmU0VuyJ0XDFEjfbzac.<init>(com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity$O00000Oo, com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity, com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity$O00000Oo$O000000o, com.xiaomi.smarthome.device.Device):void type: CONSTRUCTOR in method: com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity.O00000Oo.O000000o.O000000o(com.xiaomi.smarthome.device.Device):void, dex: classes4.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 74 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.smarthome.uwb.ui.bind.-$$Lambda$BindUwbTagDeviceActivity$O00000Oo$O000000o$BPIdXqQXcmU0VuyJ0XDFEjfbzac, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 80 more
                        */
                    /*
                        this = this;
                        java.lang.String r0 = "device"
                        _m_j.ixe.O00000o(r6, r0)
                        android.widget.TextView r0 = r5.O00000Oo
                        java.lang.String r1 = r6.name
                        java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                        r0.setText(r1)
                        com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity$O00000Oo r0 = r5.f5724O000000o
                        com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity r0 = r0.O00000Oo
                        java.util.List<java.lang.String> r0 = r0.allAssociateDevId
                        r1 = 0
                        if (r0 == 0) goto L_0x00af
                        java.lang.String r2 = r6.did
                        boolean r0 = r0.contains(r2)
                        if (r0 == 0) goto L_0x002a
                        com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity$O00000Oo r1 = r5.f5724O000000o
                        com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity r1 = r1.O00000Oo
                        r2 = 2132678850(0x7f1e18c2, float:2.1014657E38)
                        java.lang.String r1 = r1.getString(r2)
                    L_0x002a:
                        com.smarthome.uwb.ui.widget.NameAndStateTextView r2 = r5.O00000o0
                        _m_j.ggb r3 = _m_j.ggb.O00000Oo()
                        java.lang.String r4 = r6.did
                        java.lang.String r3 = r3.O0000o0O(r4)
                        r2.setNameAndState(r3, r1)
                        java.lang.String r1 = r6.model
                        java.lang.String r1 = com.xiaomi.smarthome.device.DeviceFactory.O0000oOO(r1)
                        if (r1 != 0) goto L_0x0043
                        java.lang.String r1 = ""
                    L_0x0043:
                        r2 = r1
                        java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                        int r2 = r2.length()
                        r3 = 0
                        if (r2 != 0) goto L_0x004f
                        r2 = 1
                        goto L_0x0050
                    L_0x004f:
                        r2 = 0
                    L_0x0050:
                        if (r2 == 0) goto L_0x005a
                        java.lang.String r1 = r6.model
                        com.facebook.drawee.view.SimpleDraweeView r2 = r5.O00000o
                        com.xiaomi.smarthome.device.DeviceFactory.O00000Oo(r1, r2)
                        goto L_0x005f
                    L_0x005a:
                        com.facebook.drawee.view.SimpleDraweeView r2 = r5.O00000o
                        com.xiaomi.smarthome.device.DeviceFactory.O000000o(r1, r2)
                    L_0x005f:
                        android.view.View r1 = r5.O00000oo
                        java.lang.String r2 = r6.did
                        com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity$O00000Oo r4 = r5.f5724O000000o
                        com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity r4 = r4.O00000Oo
                        java.lang.String r4 = r4.lastSelectItem
                        boolean r2 = _m_j.ixe.O000000o(r2, r4)
                        r1.setSelected(r2)
                        android.widget.CheckBox r1 = r5.O00000oO
                        java.lang.String r2 = r6.did
                        com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity$O00000Oo r4 = r5.f5724O000000o
                        com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity r4 = r4.O00000Oo
                        java.lang.String r4 = r4.lastSelectItem
                        boolean r2 = _m_j.ixe.O000000o(r2, r4)
                        if (r2 == 0) goto L_0x0081
                        goto L_0x0082
                    L_0x0081:
                        r3 = 4
                    L_0x0082:
                        r1.setVisibility(r3)
                        android.widget.CheckBox r1 = r5.O00000oO
                        java.lang.String r2 = r6.did
                        com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity$O00000Oo r3 = r5.f5724O000000o
                        com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity r3 = r3.O00000Oo
                        java.lang.String r3 = r3.lastSelectItem
                        boolean r2 = _m_j.ixe.O000000o(r2, r3)
                        r1.setChecked(r2)
                        if (r0 == 0) goto L_0x00a0
                        android.view.View r6 = r5.itemView
                        com.smarthome.uwb.ui.bind.-$$Lambda$BindUwbTagDeviceActivity$O00000Oo$O000000o$z51VsACxQneZOZAsttw5VCR-VRM r0 = com.smarthome.uwb.ui.bind.$$Lambda$BindUwbTagDeviceActivity$O00000Oo$O000000o$z51VsACxQneZOZAsttw5VCRVRM.INSTANCE
                        r6.setOnClickListener(r0)
                        return
                    L_0x00a0:
                        android.view.View r0 = r5.itemView
                        com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity$O00000Oo r1 = r5.f5724O000000o
                        com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity r2 = r1.O00000Oo
                        com.smarthome.uwb.ui.bind.-$$Lambda$BindUwbTagDeviceActivity$O00000Oo$O000000o$BPIdXqQXcmU0VuyJ0XDFEjfbzac r3 = new com.smarthome.uwb.ui.bind.-$$Lambda$BindUwbTagDeviceActivity$O00000Oo$O000000o$BPIdXqQXcmU0VuyJ0XDFEjfbzac
                        r3.<init>(r1, r2, r5, r6)
                        r0.setOnClickListener(r3)
                        return
                    L_0x00af:
                        java.lang.String r6 = "allAssociateDevId"
                        _m_j.ixe.O000000o(r6)
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity.O00000Oo.O000000o.O000000o(com.xiaomi.smarthome.device.Device):void");
                }

                /* access modifiers changed from: private */
                public static final void O000000o(View view) {
                    gqg.O00000Oo((int) R.string.uwb_associcate_msg_already_associcated_toast);
                }

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
                 arg types: [java.lang.String, java.lang.String]
                 candidates:
                  _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
                  _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
                  _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
                  _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
                 arg types: [java.lang.String, java.lang.String]
                 candidates:
                  _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
                  _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
                  _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
                  _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
                /* access modifiers changed from: private */
                public static final void O000000o(O00000Oo o00000Oo, BindUwbTagDeviceActivity bindUwbTagDeviceActivity, O000000o o000000o, Device device, View view) {
                    ixe.O00000o(o00000Oo, "this$0");
                    ixe.O00000o(bindUwbTagDeviceActivity, "this$1");
                    ixe.O00000o(o000000o, "this$2");
                    ixe.O00000o(device, "$device");
                    StringBuilder sb = new StringBuilder("homeId:");
                    sb.append(o00000Oo.f5723O000000o);
                    sb.append(",name:");
                    Home O00000o2 = ggb.O00000Oo().O00000o(o00000Oo.f5723O000000o);
                    sb.append((Object) (O00000o2 == null ? null : O00000o2.getRawName()));
                    UwbLogUtil.d("Mijia-UWB-BindUwbTagDeviceActivit", ixe.O000000o("item click ", (Object) sb.toString()));
                    hxi.O00000o.f952O000000o.O000000o("uwb_bind_device", new Object[0]);
                    if (!ixe.O000000o((Object) bindUwbTagDeviceActivity.lastSelectItem, (Object) "")) {
                        RecyclerView recyclerView = bindUwbTagDeviceActivity.recycler;
                        if (recyclerView != null) {
                            gzl gzl = (gzl) recyclerView.getAdapter();
                            if (gzl != null) {
                                gzl.notifyDataSetChanged();
                            }
                        } else {
                            ixe.O000000o("recycler");
                            throw null;
                        }
                    }
                    o000000o.itemView.setSelected(true);
                    String str = device.did;
                    ixe.O00000Oo(str, "device.did");
                    bindUwbTagDeviceActivity.lastSelectItem = str;
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    bindUwbTagDeviceActivity.isBindDialogCanceledByUser = false;
                    BindUwbTagController bindUwbTagController = bindUwbTagDeviceActivity.controller;
                    if (bindUwbTagController != null) {
                        bindUwbTagController.O000000o(bindUwbTagDeviceActivity, device, bindUwbTagDeviceActivity.tagDevice, bindUwbTagDeviceActivity.uwbScanDevice, o00000Oo.f5723O000000o, new C0044O000000o(bindUwbTagDeviceActivity, objectRef, device));
                    } else {
                        ixe.O000000o("controller");
                        throw null;
                    }
                }

                @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016¨\u0006\u000e"}, d2 = {"com/smarthome/uwb/ui/bind/BindUwbTagDeviceActivity$ItemAdapter$VH$bind$2$1", "Lcom/smarthome/uwb/ui/bind/BindUwbTagController$UwbAssociateCallback;", "onAssocaiteBegin", "", "onAssociateAndRefreshSuccess", "onAssociateFail", "code", "", "msg", "", "onCancel", "onProcess", "progress", "onRefreshDeviceFail", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
                /* renamed from: com.smarthome.uwb.ui.bind.BindUwbTagDeviceActivity$O00000Oo$O000000o$O000000o  reason: collision with other inner class name */
                public static final class C0044O000000o implements BindUwbTagController.O00000Oo {

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ BindUwbTagDeviceActivity f5725O000000o;
                    final /* synthetic */ Ref.ObjectRef<SHLoadingDialog> O00000Oo;
                    final /* synthetic */ Device O00000o0;

                    C0044O000000o(BindUwbTagDeviceActivity bindUwbTagDeviceActivity, Ref.ObjectRef<SHLoadingDialog> objectRef, Device device) {
                        this.f5725O000000o = bindUwbTagDeviceActivity;
                        this.O00000Oo = objectRef;
                        this.O00000o0 = device;
                    }

                    public final void O000000o() {
                        if (!this.f5725O000000o.isDestroyed()) {
                            Ref.ObjectRef<SHLoadingDialog> objectRef = this.O00000Oo;
                            BindUwbTagDeviceActivity bindUwbTagDeviceActivity = this.f5725O000000o;
                            String string = bindUwbTagDeviceActivity.getString(R.string.default_uwb__loading_text);
                            ixe.O00000Oo(string, "getString(R.string.default_uwb__loading_text)");
                            objectRef.element = new SHLoadingDialog(bindUwbTagDeviceActivity, string, false, new BindUwbTagDeviceActivity$ItemAdapter$VH$bind$2$1$onAssocaiteBegin$1(this), null, 16, null);
                            SHLoadingDialog sHLoadingDialog = (SHLoadingDialog) this.O00000Oo.element;
                            if (sHLoadingDialog != null) {
                                sHLoadingDialog.show();
                            }
                        }
                    }

                    public final void O00000Oo() {
                        BindUwbTagDeviceActivity bindUwbTagDeviceActivity = this.f5725O000000o;
                        bindUwbTagDeviceActivity.isBindSuccess = true;
                        if (!bindUwbTagDeviceActivity.isDestroyed()) {
                            SHLoadingDialog sHLoadingDialog = (SHLoadingDialog) this.O00000Oo.element;
                            if (sHLoadingDialog != null) {
                                sHLoadingDialog.dismiss();
                            }
                            gqg.O00000Oo((int) R.string.uwb_associcate_success_toast);
                            BindUwbTagDeviceActivity bindUwbTagDeviceActivity2 = this.f5725O000000o;
                            Intent intent = new Intent();
                            intent.putExtra("args_change_associate_did", this.O00000o0.did);
                            iuh iuh = iuh.f1631O000000o;
                            bindUwbTagDeviceActivity2.setResult(-1, intent);
                            this.f5725O000000o.finish();
                        }
                    }

                    public final void O00000o0() {
                        BindUwbTagDeviceActivity bindUwbTagDeviceActivity = this.f5725O000000o;
                        bindUwbTagDeviceActivity.isBindSuccess = false;
                        if (!bindUwbTagDeviceActivity.isDestroyed()) {
                            SHLoadingDialog sHLoadingDialog = (SHLoadingDialog) this.O00000Oo.element;
                            if (sHLoadingDialog != null) {
                                sHLoadingDialog.dismiss();
                            }
                            if (this.f5725O000000o.uwbScanDevice != null) {
                                BindUwbTagController bindUwbTagController = this.f5725O000000o.controller;
                                if (bindUwbTagController != null) {
                                    bindUwbTagController.O00000Oo(this.f5725O000000o);
                                } else {
                                    ixe.O000000o("controller");
                                    throw null;
                                }
                            } else if (this.f5725O000000o.getIntent().getBooleanExtra("args_from_uwb_manager", false)) {
                                BindUwbTagDeviceActivity bindUwbTagDeviceActivity2 = this.f5725O000000o;
                                Intent intent = new Intent();
                                intent.putExtra("args_change_associate_did", this.O00000o0.did);
                                iuh iuh = iuh.f1631O000000o;
                                bindUwbTagDeviceActivity2.setResult(0, intent);
                                this.f5725O000000o.finish();
                            } else {
                                gqg.O00000Oo((int) R.string.uwb_associcate_failed_toast);
                            }
                        }
                    }

                    public final void O00000o() {
                        if (!this.f5725O000000o.isDestroyed()) {
                            SHLoadingDialog sHLoadingDialog = (SHLoadingDialog) this.O00000Oo.element;
                            if (sHLoadingDialog != null) {
                                sHLoadingDialog.dismiss();
                            }
                            BindUwbTagDeviceActivity bindUwbTagDeviceActivity = this.f5725O000000o;
                            Intent intent = new Intent();
                            intent.putExtra("args_change_associate_did", this.O00000o0.did);
                            iuh iuh = iuh.f1631O000000o;
                            bindUwbTagDeviceActivity.setResult(0, intent);
                            this.f5725O000000o.finish();
                        }
                    }

                    public final void O00000oO() {
                        BindUwbTagDeviceActivity bindUwbTagDeviceActivity = this.f5725O000000o;
                        bindUwbTagDeviceActivity.isBindSuccess = false;
                        bindUwbTagDeviceActivity.isBindDialogCanceledByUser = true;
                    }

                    public final void O000000o(int i, String str) {
                        SHLoadingDialog sHLoadingDialog;
                        if (!this.f5725O000000o.isDestroyed() && (sHLoadingDialog = (SHLoadingDialog) this.O00000Oo.element) != null) {
                            sHLoadingDialog.appendDebugView(hzs.O000000o(i) + " : " + ((Object) str));
                        }
                    }
                }
            }

            public final void O000000o(Rect rect, View view, int i, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
                ixe.O00000o(rect, "outRect");
                ixe.O00000o(view, "view");
                rect.left = gpc.O000000o(view.getContext(), 12.0f);
                rect.right = gpc.O000000o(view.getContext(), 12.0f);
                rect.top = gpc.O000000o(view.getContext(), 12.0f);
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0016¨\u0006\u000f"}, d2 = {"Lcom/smarthome/uwb/ui/bind/BindUwbTagDeviceActivity$NoFilterDeviceAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "()V", "getItemCount", "", "onBindViewHolder", "", "vh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "pos", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "position", "VH", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        static final class O00000o0 extends gzm {
            public final int getItemCount() {
                return 1;
            }

            public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
                ixe.O00000o(o000OOo0, "vh");
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
             arg types: [?, android.view.ViewGroup, int]
             candidates:
              ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
              ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
            public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
                ixe.O00000o(viewGroup, "parent");
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.uwb_bind_no_filter_item, viewGroup, false);
                ixe.O00000Oo(inflate, "item");
                return new O000000o(this, inflate);
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/smarthome/uwb/ui/bind/BindUwbTagDeviceActivity$NoFilterDeviceAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/smarthome/uwb/ui/bind/BindUwbTagDeviceActivity$NoFilterDeviceAdapter;Landroid/view/View;)V", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public final class O000000o extends RecyclerView.O000OOo0 {

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ O00000o0 f5728O000000o;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public O000000o(O00000o0 o00000o0, View view) {
                    super(view);
                    ixe.O00000o(o00000o0, "this$0");
                    ixe.O00000o(view, "itemView");
                    this.f5728O000000o = o00000o0;
                }
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0016¨\u0006\u000f"}, d2 = {"Lcom/smarthome/uwb/ui/bind/BindUwbTagDeviceActivity$NoSupportDeviceAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "(Lcom/smarthome/uwb/ui/bind/BindUwbTagDeviceActivity;)V", "getItemCount", "", "onBindViewHolder", "", "vh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "pos", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "position", "VH", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        final class O00000o extends gzm {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ BindUwbTagDeviceActivity f5726O000000o;

            public final int getItemCount() {
                return 1;
            }

            public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
                ixe.O00000o(o000OOo0, "vh");
            }

            public O00000o(BindUwbTagDeviceActivity bindUwbTagDeviceActivity) {
                ixe.O00000o(bindUwbTagDeviceActivity, "this$0");
                this.f5726O000000o = bindUwbTagDeviceActivity;
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
             arg types: [?, android.view.ViewGroup, int]
             candidates:
              ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
              ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
            public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
                ixe.O00000o(viewGroup, "parent");
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.uwb_bind_no_available_item, viewGroup, false);
                ixe.O00000Oo(inflate, "item");
                return new O000000o(this, inflate);
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/smarthome/uwb/ui/bind/BindUwbTagDeviceActivity$NoSupportDeviceAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/smarthome/uwb/ui/bind/BindUwbTagDeviceActivity$NoSupportDeviceAdapter;Landroid/view/View;)V", "supportDeviceBtn", "kotlin.jvm.PlatformType", "tvBindInfoBtn", "Landroid/widget/TextView;", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public final class O000000o extends RecyclerView.O000OOo0 {

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ O00000o f5727O000000o;
                private final View O00000Oo;
                private final TextView O00000o0;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public O000000o(O00000o o00000o, View view) {
                    super(view);
                    ixe.O00000o(o00000o, "this$0");
                    ixe.O00000o(view, "itemView");
                    this.f5727O000000o = o00000o;
                    this.O00000Oo = view.findViewById(R.id.check_support_device);
                    this.O00000o0 = (TextView) view.findViewById(R.id.tv_intro_desc);
                    BindUwbTagDeviceActivity bindUwbTagDeviceActivity = this.f5727O000000o.f5726O000000o;
                    TextView textView = this.O00000o0;
                    ixe.O00000Oo(textView, "tvBindInfoBtn");
                    bindUwbTagDeviceActivity.tvIntroLinkSetting(textView);
                    this.O00000Oo.setOnClickListener($$Lambda$BindUwbTagDeviceActivity$O00000o$O000000o$8eiu80ITiJVfKnRM6VrL2AOr4R8.INSTANCE);
                }

                /* access modifiers changed from: private */
                public static final void O000000o(View view) {
                    fbt fbt = new fbt(CommonApplication.getAppContext(), "OperationCommonWebViewActivity");
                    hzp hzp = hzp.f1018O000000o;
                    fbt.O000000o("url", hzp.O000000o("https://home.mi.com/views/article.html?articleId=94513520000000001"));
                    fbt.O00000Oo(268435456);
                    fbs.O000000o(fbt);
                }
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0016¨\u0006\u000f"}, d2 = {"Lcom/smarthome/uwb/ui/bind/BindUwbTagDeviceActivity$TvGuideAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "(Lcom/smarthome/uwb/ui/bind/BindUwbTagDeviceActivity;)V", "getItemCount", "", "onBindViewHolder", "", "vh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "pos", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "position", "VH", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        final class O0000OOo extends gzm {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ BindUwbTagDeviceActivity f5731O000000o;

            public final int getItemCount() {
                return 1;
            }

            public O0000OOo(BindUwbTagDeviceActivity bindUwbTagDeviceActivity) {
                ixe.O00000o(bindUwbTagDeviceActivity, "this$0");
                this.f5731O000000o = bindUwbTagDeviceActivity;
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
             arg types: [?, android.view.ViewGroup, int]
             candidates:
              ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
              ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
            public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
                ixe.O00000o(viewGroup, "parent");
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.uwb_bind_tv_intro, viewGroup, false);
                ixe.O00000Oo(inflate, "item");
                return new O000000o(this, inflate);
            }

            public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
                ixe.O00000o(o000OOo0, "vh");
                O000000o o000000o = (O000000o) o000OOo0;
                BindUwbTagDeviceActivity bindUwbTagDeviceActivity = o000000o.O00000Oo.f5731O000000o;
                TextView textView = o000000o.f5732O000000o;
                ixe.O00000Oo(textView, "tvBindIntro");
                bindUwbTagDeviceActivity.tvIntroLinkSetting(textView);
            }

            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/smarthome/uwb/ui/bind/BindUwbTagDeviceActivity$TvGuideAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/smarthome/uwb/ui/bind/BindUwbTagDeviceActivity$TvGuideAdapter;Landroid/view/View;)V", "tvBindIntro", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "bind", "", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public final class O000000o extends RecyclerView.O000OOo0 {

                /* renamed from: O000000o  reason: collision with root package name */
                final TextView f5732O000000o;
                final /* synthetic */ O0000OOo O00000Oo;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public O000000o(O0000OOo o0000OOo, View view) {
                    super(view);
                    ixe.O00000o(o0000OOo, "this$0");
                    ixe.O00000o(view, "itemView");
                    this.O00000Oo = o0000OOo;
                    this.f5732O000000o = (TextView) view.findViewById(R.id.tv_bind_intro);
                }
            }
        }

        public final boolean needExitUwb() {
            if (!this.isBindDialogCanceledByUser && this.isBindSuccess) {
                return false;
            }
            return true;
        }
    }

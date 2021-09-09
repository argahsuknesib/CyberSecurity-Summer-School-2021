package com.xiaomi.smarthome.newui.widget;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fcn;
import _m_j.fno;
import _m_j.fqu;
import _m_j.fqw;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ftt;
import _m_j.gfx;
import _m_j.ggb;
import _m_j.gge;
import _m_j.goy;
import _m_j.gpc;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gtc;
import _m_j.gtd;
import _m_j.gtf;
import _m_j.gzr;
import _m_j.gzs;
import _m_j.hag;
import _m_j.hfa;
import _m_j.hfy;
import _m_j.hhh;
import _m_j.hmq;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.izb;
import android.animation.LayoutTransition;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.MiTVDevice;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.utils.ClientRemarkInputView;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.adapter.DviceEditInterface;
import com.xiaomi.smarthome.newui.widget.DeviceMainPageEditBarV2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class DeviceMainPageEditBarV2 extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public gzr f10278O000000o;
    public XQProgressDialog O00000Oo;
    public MLAlertDialog O00000o;
    boolean O00000o0 = true;
    private LinearLayout O00000oO;
    private LinearLayout O00000oo;
    private O000000o O0000O0o;
    private O000000o O0000OOo;
    private O000000o O0000Oo;
    private O000000o O0000Oo0;
    private O000000o O0000OoO;
    private O000000o O0000Ooo;
    private final LayoutTransition O0000o;
    private O000000o O0000o0;
    private O000000o O0000o00;
    private O000000o O0000o0O;
    private O000000o O0000o0o;
    private ArrayList<O000000o> O0000oO0 = new ArrayList<>();

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        Button f10297O000000o;

        public O000000o(Button button) {
            this.f10297O000000o = button;
        }

        public final void O000000o(Boolean bool) {
            this.f10297O000000o.setEnabled(bool.booleanValue());
            this.f10297O000000o.setVisibility(bool.booleanValue() ? 0 : 8);
        }

        public final void O000000o(View.OnClickListener onClickListener) {
            this.f10297O000000o.setOnClickListener(onClickListener);
        }
    }

    public DeviceMainPageEditBarV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflate(context, R.layout.device_main_page_edit_bar_v3, this);
        this.O0000o = new LayoutTransition();
        ((ViewGroup) findViewById(R.id.ll_edit_bar_content)).setLayoutTransition(this.O0000o);
        this.O00000oO = (LinearLayout) findViewById(R.id.first_line);
        this.O00000oo = (LinearLayout) findViewById(R.id.ll_edit_bar_content);
        this.O0000Oo = new O000000o((Button) findViewById(R.id.btn_edit_shortcut));
        this.O0000oO0.add(this.O0000Oo);
        this.O0000O0o = new O000000o((Button) findViewById(R.id.btn_edit_move));
        this.O0000oO0.add(this.O0000O0o);
        this.O0000Oo0 = new O000000o((Button) findViewById(R.id.btn_edit_rename));
        this.O0000oO0.add(this.O0000Oo0);
        this.O0000OOo = new O000000o((Button) findViewById(R.id.btn_edit_share));
        this.O0000oO0.add(this.O0000OOo);
        this.O0000OoO = new O000000o((Button) findViewById(R.id.btn_edit_delete));
        this.O0000oO0.add(this.O0000OoO);
        this.O0000Ooo = new O000000o((Button) findViewById(R.id.btn_light_group));
        this.O0000oO0.add(this.O0000Ooo);
        this.O0000o00 = new O000000o((Button) findViewById(R.id.btn_edit_pin));
        this.O0000oO0.add(this.O0000o00);
        this.O0000o0 = new O000000o((Button) findViewById(R.id.btn_edit_common_add));
        this.O0000oO0.add(this.O0000o0);
        this.O0000o0O = new O000000o((Button) findViewById(R.id.btn_edit_common_del));
        this.O0000oO0.add(this.O0000o0O);
        this.O0000o0o = new O000000o((Button) findViewById(R.id.btn_edit_camera_freq));
        this.O0000oO0.add(this.O0000o0o);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    private void O000000o() {
        int O00000Oo2 = gpc.O00000Oo(getContext());
        int i = (int) (((float) O00000Oo2) * 0.075f);
        int O000000o2 = (int) ((((float) (O00000Oo2 - i)) - (((float) gpc.O000000o(44.0f)) * 4.85f)) / 4.0f);
        int childCount = this.O00000oo.getChildCount();
        View view = null;
        View view2 = null;
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.O00000oo.getChildAt(i3);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            if (marginLayoutParams != null && childAt.getVisibility() == 0) {
                if (view2 == null) {
                    marginLayoutParams.leftMargin = i;
                    marginLayoutParams.rightMargin = 0;
                    view2 = childAt;
                } else {
                    marginLayoutParams.leftMargin = O000000o2;
                    marginLayoutParams.rightMargin = 0;
                    view = childAt;
                }
                i2++;
                childAt.setLayoutParams(marginLayoutParams);
            }
        }
        if (view != null && i2 >= 5) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams2.rightMargin = i;
            view.setLayoutParams(marginLayoutParams2);
        }
    }

    private void O00000Oo() {
        this.O0000O0o.O000000o(Boolean.FALSE);
        this.O0000Oo.O000000o(Boolean.FALSE);
        this.O0000OOo.O000000o(Boolean.FALSE);
        this.O0000OoO.O000000o(Boolean.FALSE);
        this.O0000Oo0.O000000o(Boolean.FALSE);
        this.O0000Ooo.O000000o(Boolean.FALSE);
        this.O0000o00.O000000o(Boolean.FALSE);
        this.O0000o0.O000000o(Boolean.FALSE);
        this.O0000o0O.O000000o(Boolean.FALSE);
        this.O0000o0o.O000000o(Boolean.FALSE);
    }

    public void setDeviceMainPage(gzr gzr) {
        this.f10278O000000o = gzr;
    }

    public final void O000000o(final DviceEditInterface dviceEditInterface) {
        O00000Oo();
        this.O0000O0o.O000000o(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.widget.DeviceMainPageEditBarV2.AnonymousClass1 */

            public final void onClick(View view) {
                if (DeviceMainPageEditBarV2.this.f10278O000000o != null && DeviceMainPageEditBarV2.this.f10278O000000o.getActivity() != null) {
                    DeviceMainPageEditBarV2.this.O000000o(view, new Runnable(dviceEditInterface) {
                        /* class com.xiaomi.smarthome.newui.widget.$$Lambda$DeviceMainPageEditBarV2$1$AlylmGzDyCXQozO3qE32YtC0RJ0 */
                        private final /* synthetic */ DviceEditInterface f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            DeviceMainPageEditBarV2.AnonymousClass1.this.O000000o(this.f$1);
                        }
                    });
                }
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
             arg types: [java.lang.String, java.util.ArrayList]
             candidates:
              _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
              _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt */
            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(DviceEditInterface dviceEditInterface) {
                List<String> O0000Oo0 = dviceEditInterface.O0000Oo0();
                if (!O0000Oo0.isEmpty()) {
                    ArrayList arrayList = new ArrayList(O0000Oo0);
                    HashSet hashSet = new HashSet();
                    int i = 0;
                    while (true) {
                        if (i < arrayList.size()) {
                            Room O0000o00 = ggb.O00000Oo().O0000o00((String) arrayList.get(i));
                            if (O0000o00 != null && !TextUtils.isEmpty(O0000o00.getId())) {
                                hashSet.add(O0000o00.getId());
                                if (hashSet.size() > 1) {
                                    break;
                                }
                                i++;
                            } else {
                                hashSet.clear();
                            }
                        } else {
                            break;
                        }
                    }
                    DeviceMainPageEditBarV2.this.f10278O000000o.exitEditMode();
                    String str = hashSet.size() == 1 ? (String) hashSet.iterator().next() : "";
                    fbt fbt = new fbt(DeviceMainPageEditBarV2.this.f10278O000000o.getActivity(), "HomeRoomDeviceMoveActivity");
                    fbt.O000000o("key_checked_dids", (Serializable) arrayList);
                    fbt.O000000o("key_filter_room_id", str);
                    fbt.O000000o(gzs.O000O00o);
                    fbs.O000000o(fbt);
                    hxi.O00000o.O00000Oo("2", dviceEditInterface.O0000o0o());
                }
            }
        });
        this.O0000Oo.O000000o(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.widget.DeviceMainPageEditBarV2.AnonymousClass10 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.fqu.O000000o(android.app.Activity, boolean, com.xiaomi.smarthome.device.Device, android.content.Intent, java.lang.String, _m_j.ftt<java.lang.Void>):void
             arg types: [android.app.Activity, int, com.xiaomi.smarthome.device.Device, ?[OBJECT, ARRAY], java.lang.String, com.xiaomi.smarthome.newui.widget.DeviceMainPageEditBarV2$8]
             candidates:
              _m_j.fqu.O000000o(android.app.Activity, com.xiaomi.smarthome.device.Device, android.content.Intent, android.graphics.Bitmap, java.lang.String, boolean):void
              _m_j.fqu.O000000o(com.xiaomi.smarthome.device.Device, android.content.Intent, android.graphics.Bitmap, java.lang.String, boolean, java.util.List):void
              _m_j.fqu.O000000o(android.app.Activity, boolean, com.xiaomi.smarthome.device.Device, android.content.Intent, java.lang.String, _m_j.ftt<java.lang.Void>):void */
            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(DviceEditInterface dviceEditInterface) {
                DeviceMainPageEditBarV2 deviceMainPageEditBarV2 = DeviceMainPageEditBarV2.this;
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (String O000000o2 : dviceEditInterface.O0000Oo0()) {
                    Device O000000o3 = fno.O000000o().O000000o(O000000o2);
                    if (O000000o3 != null && O000000o3.hasShortcut()) {
                        z = true;
                        arrayList.add(O000000o3);
                        Context context = deviceMainPageEditBarV2.getContext();
                        fqu.O000000o(context instanceof Activity ? (Activity) context : null, true, O000000o3, (Intent) null, "device_page", (ftt<Void>) new ftt<Void>(context) {
                            /* class com.xiaomi.smarthome.newui.widget.DeviceMainPageEditBarV2.AnonymousClass8 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ Context f10295O000000o;

                            public final void O000000o(int i, Object obj) {
                            }

                            public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                            }

                            {
                                this.f10295O000000o = r2;
                            }

                            public final void O000000o(int i) {
                                if (i != -1) {
                                    return;
                                }
                                if (!(this.f10295O000000o instanceof Activity) || Build.VERSION.SDK_INT < 23 || !((Activity) this.f10295O000000o).shouldShowRequestPermissionRationale("com.android.launcher.permission.INSTALL_SHORTCUT")) {
                                    gqg.O00000Oo((int) R.string.permission_tips_denied_msg);
                                } else {
                                    ((Activity) this.f10295O000000o).requestPermissions(new String[]{"com.android.launcher.permission.INSTALL_SHORTCUT"}, 1);
                                }
                            }
                        });
                    }
                }
                if (z) {
                    gqg.O00000Oo((int) R.string.smarthome_add_short_cut_success);
                }
                deviceMainPageEditBarV2.f10278O000000o.onStateChanged();
                DeviceMainPageEditBarV2.O000000o("DevicelistEditShortcut");
                hxi.O00000o.O00000Oo("1", dviceEditInterface.O0000o0o());
            }

            public final void onClick(View view) {
                DeviceMainPageEditBarV2.this.O000000o(view, new Runnable(dviceEditInterface) {
                    /* class com.xiaomi.smarthome.newui.widget.$$Lambda$DeviceMainPageEditBarV2$10$knEYBlbOAM4hQzh3fzWCzqPFI */
                    private final /* synthetic */ DviceEditInterface f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        DeviceMainPageEditBarV2.AnonymousClass10.this.O000000o(this.f$1);
                    }
                });
            }
        });
        this.O0000OoO.O000000o(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.widget.DeviceMainPageEditBarV2.AnonymousClass11 */

            public final void onClick(View view) {
                DeviceMainPageEditBarV2.this.O000000o(view, new Runnable(dviceEditInterface) {
                    /* class com.xiaomi.smarthome.newui.widget.$$Lambda$DeviceMainPageEditBarV2$11$VTOg9q5VtTvtxmeIIFDKA8ClGqA */
                    private final /* synthetic */ DviceEditInterface f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        DeviceMainPageEditBarV2.AnonymousClass11.this.O000000o(this.f$1);
                    }
                });
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(DviceEditInterface dviceEditInterface) {
                DeviceMainPageEditBarV2 deviceMainPageEditBarV2 = DeviceMainPageEditBarV2.this;
                if (goy.O00000o()) {
                    izb.O000000o(CommonApplication.getAppContext(), (int) R.string.smarthome_device_mijia_cant_delete, 0).show();
                } else {
                    ArrayList arrayList = new ArrayList(dviceEditInterface.O0000Oo0());
                    if (!arrayList.isEmpty()) {
                        gtc gtc = new gtc();
                        for (int i = 0; i < arrayList.size(); i++) {
                            Device O000000o2 = fno.O000000o().O000000o((String) arrayList.get(i));
                            if (O000000o2 == null) {
                                O000000o2 = fno.O000000o().O0000OOo((String) arrayList.get(i));
                            }
                            if (O000000o2 != null) {
                                gtd gtd = new gtd();
                                try {
                                    gtd.put("model", O000000o2.model);
                                    gtc.put(gtd);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(deviceMainPageEditBarV2.getContext());
                        builder.O00000o0();
                        builder.O000000o(MLAlertDialog.ButtonStyle.Alert);
                        builder.O00000Oo(deviceMainPageEditBarV2.getResources().getQuantityString(R.plurals.dialog_title_confirm_delete_device, dviceEditInterface.O0000Ooo(), Integer.valueOf(dviceEditInterface.O0000Ooo())));
                        builder.O000000o((int) R.string.confirm, new DialogInterface.OnClickListener(dviceEditInterface, gtc) {
                            /* class com.xiaomi.smarthome.newui.widget.DeviceMainPageEditBarV2.AnonymousClass4 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ DviceEditInterface f10290O000000o;
                            final /* synthetic */ gtc O00000Oo;

                            {
                                this.f10290O000000o = r2;
                                this.O00000Oo = r3;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                DeviceMainPageEditBarV2 deviceMainPageEditBarV2 = DeviceMainPageEditBarV2.this;
                                deviceMainPageEditBarV2.O00000Oo = new XQProgressDialog(deviceMainPageEditBarV2.getContext());
                                DeviceMainPageEditBarV2.this.O00000Oo.setMessage(DeviceMainPageEditBarV2.this.getContext().getString(R.string.smarthome_deleting));
                                DeviceMainPageEditBarV2.this.O00000Oo.setCancelable(true);
                                DeviceMainPageEditBarV2.this.O00000Oo.show();
                                new ArrayList();
                                final ArrayList arrayList = new ArrayList(this.f10290O000000o.O0000Oo0());
                                final List<String> delFolderPathBatch = hmq.O000000o().getDelFolderPathBatch(arrayList);
                                if (this.f10290O000000o.O0000o0o() == 4) {
                                    ggb.O00000Oo().O000000o(ggb.O00000Oo().O00000o0(this.f10290O000000o.O0000o()), arrayList);
                                }
                                fno.O000000o().O000000o(arrayList, DeviceMainPageEditBarV2.this.getContext(), new fno.O00000Oo() {
                                    /* class com.xiaomi.smarthome.newui.widget.DeviceMainPageEditBarV2.AnonymousClass4.AnonymousClass1 */

                                    public final void O000000o() {
                                        DeviceMainPageEditBarV2.this.f10278O000000o.onStateChanged();
                                        ggb.O00000Oo().O00000o0();
                                        hmq.O000000o().delDataAfterDelDevice(delFolderPathBatch);
                                        Iterator it = arrayList.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            Device O000000o2 = fno.O000000o().O000000o((String) it.next());
                                            gtf.O000000o();
                                            if (gtf.O00000Oo(O000000o2)) {
                                                Handler globalHandler = ServiceApplication.getGlobalHandler();
                                                if (globalHandler != null) {
                                                    globalHandler.postDelayed($$Lambda$DeviceMainPageEditBarV2$4$1$0woSFEeRicJXuPmqMEqtIlb9SQ.INSTANCE, 300);
                                                }
                                            }
                                        }
                                        DeviceMainPageEditBarV2.this.O00000Oo.dismiss();
                                        gsy.O00000o0(LogType.MAIN_PAGE, "delDeviceBatch succ", Arrays.deepToString(arrayList.toArray()));
                                    }

                                    public final void O000000o(fso fso) {
                                        Device O000000o2 = fno.O000000o().O000000o(fso.O00000Oo.substring(fso.O00000Oo.indexOf("did:") + 4));
                                        if (O000000o2 == null || !ggb.O0000o.contains(O000000o2.model)) {
                                            gqg.O00000Oo((int) R.string.bind_error);
                                        } else {
                                            gqg.O00000Oo((int) R.string.miband_remove_warning);
                                        }
                                        fno.O000000o().O0000Oo0();
                                        DeviceMainPageEditBarV2.this.f10278O000000o.onStateChanged();
                                        DeviceMainPageEditBarV2.this.O00000Oo.dismiss();
                                        gsy.O00000o0(LogType.MAIN_PAGE, "delDeviceBatch fail", Arrays.deepToString(arrayList.toArray()));
                                    }
                                });
                                hxk hxk = hxi.O00000o;
                                String gtc = this.O00000Oo.toString();
                                hxk.f952O000000o.O000000o("home_delete_confirm", "model", gtc);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.newui.widget.DeviceMainPageEditBarV2.AnonymousClass5 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        builder.O000000o(new DialogInterface.OnCancelListener(gtc) {
                            /* class com.xiaomi.smarthome.newui.widget.DeviceMainPageEditBarV2.AnonymousClass6 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ gtc f10293O000000o;

                            {
                                this.f10293O000000o = r2;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                hxk hxk = hxi.O00000o;
                                String gtc = this.f10293O000000o.toString();
                                hxk.f952O000000o.O000000o("home_delete_cancel", "model", gtc);
                            }
                        });
                        builder.O000000o(true);
                        builder.O00000o().show();
                    }
                }
                hxi.O00000o.O00000Oo("5", dviceEditInterface.O0000o0o());
            }
        });
        this.O0000Oo0.O000000o(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.widget.DeviceMainPageEditBarV2.AnonymousClass12 */

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(DviceEditInterface dviceEditInterface) {
                String str;
                DeviceMainPageEditBarV2 deviceMainPageEditBarV2 = DeviceMainPageEditBarV2.this;
                List<String> O0000Oo0 = dviceEditInterface.O0000Oo0();
                if (O0000Oo0.isEmpty()) {
                    deviceMainPageEditBarV2.f10278O000000o.exitEditMode();
                    return;
                }
                String next = O0000Oo0.iterator().next();
                Device O000000o2 = fno.O000000o().O000000o(next);
                if (O000000o2 == null) {
                    O000000o2 = fno.O000000o().O0000OOo(next);
                }
                if (O000000o2 != null) {
                    Context context = deviceMainPageEditBarV2.getContext();
                    hhh.AnonymousClass6 r0 = new ClientRemarkInputView.O000000o(context, O000000o2, new fsm() {
                        /* class com.xiaomi.smarthome.newui.widget.DeviceMainPageEditBarV2.AnonymousClass7 */

                        public final void onSuccess(Object obj) {
                            DeviceMainPageEditBarV2.this.f10278O000000o.exitEditMode();
                        }

                        public final void onFailure(fso fso) {
                            DeviceMainPageEditBarV2.this.f10278O000000o.exitEditMode();
                        }
                    }) {
                        /* class _m_j.hhh.AnonymousClass6 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ Context f18945O000000o;
                        final /* synthetic */ Device O00000Oo;
                        final /* synthetic */ fsm O00000o0;

                        {
                            this.f18945O000000o = r1;
                            this.O00000Oo = r2;
                            this.O00000o0 = r3;
                        }

                        public final void modifyBackName(String str) {
                            XQProgressDialog xQProgressDialog = new XQProgressDialog(this.f18945O000000o);
                            xQProgressDialog.setMessage(this.f18945O000000o.getString(R.string.changeing_back_name));
                            xQProgressDialog.setCancelable(false);
                            xQProgressDialog.show();
                            Device device = this.O00000Oo;
                            if (device != null) {
                                Context context = this.f18945O000000o;
                                fsm fsm = this.O00000o0;
                                if (device instanceof BleDevice) {
                                    if (!TextUtils.isEmpty(device.did)) {
                                        gwe.O000000o();
                                        gwe.O000000o(device, str, new fsm<Void, fso>(xQProgressDialog, device, str, context, fsm, false) {
                                            /* class _m_j.hhh.AnonymousClass7 */

                                            /* renamed from: O000000o  reason: collision with root package name */
                                            final /* synthetic */ XQProgressDialog f18946O000000o;
                                            final /* synthetic */ Device O00000Oo;
                                            final /* synthetic */ Context O00000o;
                                            final /* synthetic */ String O00000o0;
                                            final /* synthetic */ fsm O00000oO;
                                            final /* synthetic */ boolean O00000oo = false;

                                            {
                                                this.f18946O000000o = r1;
                                                this.O00000Oo = r2;
                                                this.O00000o0 = r3;
                                                this.O00000o = r4;
                                                this.O00000oO = r5;
                                            }

                                            public final /* synthetic */ void onSuccess(Object obj) {
                                                Void voidR = (Void) obj;
                                                XQProgressDialog xQProgressDialog = this.f18946O000000o;
                                                if (xQProgressDialog != null) {
                                                    xQProgressDialog.dismiss();
                                                }
                                                Device O000000o2 = fno.O000000o().O000000o(this.O00000Oo.did);
                                                if (O000000o2 != null) {
                                                    O000000o2.name = this.O00000o0;
                                                }
                                                Device device = this.O00000Oo;
                                                device.name = this.O00000o0;
                                                foc.O000000o(device.mac, this.O00000o0);
                                                ft.O000000o(this.O00000o).O000000o(new Intent("com.smarthome.refresh_list_view"));
                                                fno.O000000o().O0000Oo0();
                                                ft.O000000o(this.O00000o).O000000o(new Intent("common_used_device_updated"));
                                                fsm fsm = this.O00000oO;
                                                if (fsm != null) {
                                                    fsm.onSuccess(voidR);
                                                }
                                            }

                                            public final void onFailure(fso fso) {
                                                XQProgressDialog xQProgressDialog = this.f18946O000000o;
                                                if (xQProgressDialog != null) {
                                                    xQProgressDialog.dismiss();
                                                }
                                                if (!this.O00000oo) {
                                                    gqg.O00000Oo((int) R.string.change_back_name_fail);
                                                }
                                                fsm fsm = this.O00000oO;
                                                if (fsm != null) {
                                                    fsm.onFailure(fso);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                    xQProgressDialog.dismiss();
                                    device.name = str;
                                    foc.O000000o(device.mac, str);
                                    ft.O000000o(context).O000000o(new Intent("com.smarthome.refresh_list_view"));
                                    fno.O000000o().O0000Oo0();
                                    ft.O000000o(context).O000000o(new Intent("common_used_device_updated"));
                                    if (fsm != null) {
                                        fsm.onSuccess(null);
                                    }
                                } else if (!(device instanceof MiTVDevice) || ((MiTVDevice) device).O000000o()) {
                                    gwe.O000000o();
                                    gwe.O000000o(device, str, new fsm<Void, fso>(xQProgressDialog, device, str, context, fsm, false) {
                                        /* class _m_j.hhh.AnonymousClass8 */

                                        /* renamed from: O000000o  reason: collision with root package name */
                                        final /* synthetic */ XQProgressDialog f18947O000000o;
                                        final /* synthetic */ Device O00000Oo;
                                        final /* synthetic */ Context O00000o;
                                        final /* synthetic */ String O00000o0;
                                        final /* synthetic */ fsm O00000oO;
                                        final /* synthetic */ boolean O00000oo = false;

                                        {
                                            this.f18947O000000o = r1;
                                            this.O00000Oo = r2;
                                            this.O00000o0 = r3;
                                            this.O00000o = r4;
                                            this.O00000oO = r5;
                                        }

                                        public final /* synthetic */ void onSuccess(Object obj) {
                                            Void voidR = (Void) obj;
                                            XQProgressDialog xQProgressDialog = this.f18947O000000o;
                                            if (xQProgressDialog != null) {
                                                xQProgressDialog.dismiss();
                                            }
                                            this.O00000Oo.name = this.O00000o0;
                                            ft.O000000o(this.O00000o).O000000o(new Intent("com.smarthome.refresh_list_view"));
                                            fno.O000000o().O0000Oo0();
                                            ft.O000000o(this.O00000o).O000000o(new Intent("common_used_device_updated"));
                                            fsm fsm = this.O00000oO;
                                            if (fsm != null) {
                                                fsm.onSuccess(voidR);
                                            }
                                            if (this.O00000Oo instanceof MiTVDevice) {
                                                JSONArray jSONArray = new JSONArray();
                                                jSONArray.put(this.O00000o0);
                                                XmPluginHostApi.instance().callMethodFromCloud(this.O00000Oo.did, "modify_device_name", jSONArray, null, null);
                                            }
                                        }

                                        public final void onFailure(fso fso) {
                                            XQProgressDialog xQProgressDialog = this.f18947O000000o;
                                            if (xQProgressDialog != null) {
                                                xQProgressDialog.dismiss();
                                            }
                                            if (!this.O00000oo) {
                                                gqg.O00000Oo((int) R.string.change_back_name_fail);
                                            }
                                            fsm fsm = this.O00000oO;
                                            if (fsm != null) {
                                                fsm.onFailure(fso);
                                            }
                                        }
                                    });
                                } else {
                                    xQProgressDialog.dismiss();
                                    gqg.O00000Oo((int) R.string.change_back_name_mitv_notsupport);
                                    if (fsm != null) {
                                        fsm.onFailure(null);
                                    }
                                }
                            }
                        }
                    };
                    boolean[] zArr = {true};
                    ClientRemarkInputView clientRemarkInputView = (ClientRemarkInputView) LayoutInflater.from(context).inflate((int) R.layout.client_remark_input_view, (ViewGroup) null);
                    MLAlertDialog O00000oo = new MLAlertDialog.Builder(context).O00000o0().O000000o((int) R.string.change_back_name).O000000o(clientRemarkInputView).O00000Oo(false).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener(clientRemarkInputView, zArr, O000000o2) {
                        /* class _m_j.hhh.AnonymousClass3 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ ClientRemarkInputView f18942O000000o;
                        final /* synthetic */ boolean[] O00000Oo;
                        final /* synthetic */ Device O00000o0;

                        {
                            this.f18942O000000o = r1;
                            this.O00000Oo = r2;
                            this.O00000o0 = r3;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f18942O000000o.O000000o(dialogInterface);
                            boolean[] zArr = this.O00000Oo;
                            if (zArr != null && zArr.length == 1 && zArr[0]) {
                                hxk hxk = hxi.O00000o;
                                String str = this.O00000o0.model;
                                hxk.f952O000000o.O000000o("home_rename_confirm", "model", str);
                            }
                        }
                    }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener(zArr, O000000o2) {
                        /* class _m_j.hhh.AnonymousClass2 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ boolean[] f18941O000000o;
                        final /* synthetic */ Device O00000Oo;

                        {
                            this.f18941O000000o = r1;
                            this.O00000Oo = r2;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ((MLAlertDialog) dialogInterface).setAudoDismiss(true);
                            boolean[] zArr = this.f18941O000000o;
                            if (zArr != null && zArr.length == 1 && zArr[0]) {
                                hxi.O00000o.O00000oO(this.O00000Oo.model);
                            }
                        }
                    }).O000000o(new DialogInterface.OnCancelListener(zArr, O000000o2) {
                        /* class _m_j.hhh.AnonymousClass1 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ boolean[] f18940O000000o;
                        final /* synthetic */ Device O00000Oo;

                        {
                            this.f18940O000000o = r1;
                            this.O00000Oo = r2;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            boolean[] zArr = this.f18940O000000o;
                            if (zArr != null && zArr.length == 1 && zArr[0]) {
                                hxi.O00000o.O00000oO(this.O00000Oo.model);
                            }
                        }
                    }).O00000oo();
                    hhh.AnonymousClass4 r7 = new ClientRemarkInputView.O000000o(r0) {
                        /* class _m_j.hhh.AnonymousClass4 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ ClientRemarkInputView.O000000o f18943O000000o;

                        {
                            this.f18943O000000o = r1;
                        }

                        public final void modifyBackName(String str) {
                            ClientRemarkInputView.O000000o o000000o = this.f18943O000000o;
                            if (o000000o != null) {
                                o000000o.modifyBackName(str);
                            }
                        }
                    };
                    if (O000000o2 == null) {
                        str = "";
                    } else {
                        str = O000000o2.name;
                    }
                    clientRemarkInputView.O000000o(r7, O00000oo, str);
                    clientRemarkInputView.setNeedVerifyConfirm(false);
                    EditText editText = clientRemarkInputView.getEditText();
                    editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(41)});
                    Button button = O00000oo.getButton(-1);
                    button.setEnabled(false);
                    button.setTextColor(context.getResources().getColor(R.color.mj_color_dialog_button1_bg_nor));
                    clientRemarkInputView.getEditText().addTextChangedListener(new TextWatcher(clientRemarkInputView, button, editText, context) {
                        /* class _m_j.hhh.AnonymousClass5 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ ClientRemarkInputView f18944O000000o;
                        final /* synthetic */ Button O00000Oo;
                        final /* synthetic */ Context O00000o;
                        final /* synthetic */ EditText O00000o0;

                        public final void afterTextChanged(Editable editable) {
                        }

                        {
                            this.f18944O000000o = r1;
                            this.O00000Oo = r2;
                            this.O00000o0 = r3;
                            this.O00000o = r4;
                        }

                        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                            this.f18944O000000o.setAlertText("");
                            this.O00000Oo.setEnabled(true);
                        }

                        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                            String obj = this.O00000o0.getText().toString();
                            if (obj.length() > 0) {
                                if (gqb.O00000o0(obj)) {
                                    this.f18944O000000o.setAlertText(this.O00000o.getString(R.string.tag_save_data_description));
                                } else if (!ggb.O0000oO(obj)) {
                                    this.f18944O000000o.setAlertText(this.O00000o.getString(R.string.room_name_too_long));
                                } else {
                                    this.f18944O000000o.setAlertText("");
                                    this.O00000Oo.setEnabled(true);
                                    return;
                                }
                            }
                            this.O00000Oo.setEnabled(false);
                        }
                    });
                    new ArrayList().add(O000000o2);
                    hxi.O00000o.O00000Oo("3", dviceEditInterface.O0000o0o());
                }
            }

            public final void onClick(View view) {
                DeviceMainPageEditBarV2.this.O000000o(view, new Runnable(dviceEditInterface) {
                    /* class com.xiaomi.smarthome.newui.widget.$$Lambda$DeviceMainPageEditBarV2$12$m5vKNpPM5J5bW96iOHjGKBYaDH4 */
                    private final /* synthetic */ DviceEditInterface f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        DeviceMainPageEditBarV2.AnonymousClass12.this.O000000o(this.f$1);
                    }
                });
            }
        });
        this.O0000Ooo.O000000o(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.widget.DeviceMainPageEditBarV2.AnonymousClass13 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
             arg types: [java.lang.String, java.util.ArrayList]
             candidates:
              _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
              _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt */
            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(DviceEditInterface dviceEditInterface) {
                DeviceMainPageEditBarV2 deviceMainPageEditBarV2 = DeviceMainPageEditBarV2.this;
                List<String> O0000Oo0 = dviceEditInterface.O0000Oo0();
                if (O0000Oo0.isEmpty()) {
                    deviceMainPageEditBarV2.f10278O000000o.exitEditMode();
                    return;
                }
                ArrayList arrayList = new ArrayList(O0000Oo0);
                fbt fbt = new fbt(deviceMainPageEditBarV2.f10278O000000o.getActivity(), "LightGroupSettingV2Activity");
                fbt.O000000o("args_key_did_list", (Serializable) arrayList);
                fbs.O000000o(fbt);
                deviceMainPageEditBarV2.f10278O000000o.exitEditMode();
                hxi.O00000o.O00000Oo("6", dviceEditInterface.O0000o0o());
            }

            public final void onClick(View view) {
                DeviceMainPageEditBarV2.this.O000000o(view, new Runnable(dviceEditInterface) {
                    /* class com.xiaomi.smarthome.newui.widget.$$Lambda$DeviceMainPageEditBarV2$13$In477Zop6faesWOFrJiHA2Gt47Y */
                    private final /* synthetic */ DviceEditInterface f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        DeviceMainPageEditBarV2.AnonymousClass13.this.O000000o(this.f$1);
                    }
                });
            }
        });
        this.O0000o00.O000000o(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.widget.DeviceMainPageEditBarV2.AnonymousClass14 */

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(DviceEditInterface dviceEditInterface) {
                DeviceMainPageEditBarV2 deviceMainPageEditBarV2 = DeviceMainPageEditBarV2.this;
                List<String> O0000Oo0 = dviceEditInterface.O0000Oo0();
                ArrayList arrayList = new ArrayList();
                for (String next : O0000Oo0) {
                    if (fqw.O000000o(next)) {
                        arrayList.add("com.xiaomi.smarthome.common_use.ir_did");
                    } else {
                        arrayList.add(next);
                    }
                }
                String simpleName = deviceMainPageEditBarV2.getClass().getSimpleName();
                gsy.O00000Oo(simpleName, "onClickPinToTop: " + Arrays.deepToString(arrayList.toArray()));
                Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
                if (O0000Oo02 != null && !TextUtils.isEmpty(O0000Oo02.getId()) && arrayList.size() > 0) {
                    List<String> O0000Oo = dviceEditInterface.O0000Oo();
                    O0000Oo.removeAll(arrayList);
                    O0000Oo.addAll(0, arrayList);
                    gfx.O000000o().O000000o(O0000Oo, O0000Oo02);
                    dviceEditInterface.O0000OoO();
                }
                deviceMainPageEditBarV2.f10278O000000o.exitEditMode();
                hxi.O00000o.O00000Oo("7", dviceEditInterface.O0000o0o());
            }

            public final void onClick(View view) {
                DeviceMainPageEditBarV2.this.O000000o(view, new Runnable(dviceEditInterface) {
                    /* class com.xiaomi.smarthome.newui.widget.$$Lambda$DeviceMainPageEditBarV2$14$zRRK3cRTILax7dXDbMOy8Z5IO4w */
                    private final /* synthetic */ DviceEditInterface f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        DeviceMainPageEditBarV2.AnonymousClass14.this.O000000o(this.f$1);
                    }
                });
            }
        });
        this.O0000o0.O000000o(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.widget.DeviceMainPageEditBarV2.AnonymousClass15 */

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(DviceEditInterface dviceEditInterface) {
                DeviceMainPageEditBarV2 deviceMainPageEditBarV2 = DeviceMainPageEditBarV2.this;
                List<String> O0000Oo0 = dviceEditInterface.O0000Oo0();
                if (O0000Oo0.isEmpty()) {
                    deviceMainPageEditBarV2.f10278O000000o.exitEditMode();
                    return;
                }
                gfx.O000000o().O000000o(O0000Oo0, new fsm[0]);
                deviceMainPageEditBarV2.f10278O000000o.exitEditMode();
                hxi.O00000o.O00000Oo("8", dviceEditInterface.O0000o0o());
            }

            public final void onClick(View view) {
                DeviceMainPageEditBarV2.this.O000000o(view, new Runnable(dviceEditInterface) {
                    /* class com.xiaomi.smarthome.newui.widget.$$Lambda$DeviceMainPageEditBarV2$15$oVUNpQXWteMFpmU7WHqh2Q8M */
                    private final /* synthetic */ DviceEditInterface f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        DeviceMainPageEditBarV2.AnonymousClass15.this.O000000o(this.f$1);
                    }
                });
            }
        });
        this.O0000o0O.O000000o(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.widget.DeviceMainPageEditBarV2.AnonymousClass16 */

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(DviceEditInterface dviceEditInterface) {
                DeviceMainPageEditBarV2.this.O00000o0(dviceEditInterface);
            }

            public final void onClick(View view) {
                DeviceMainPageEditBarV2.this.O000000o(view, new Runnable(dviceEditInterface) {
                    /* class com.xiaomi.smarthome.newui.widget.$$Lambda$DeviceMainPageEditBarV2$16$BnP4rwZJKBmVb2IipRqV918CrQ */
                    private final /* synthetic */ DviceEditInterface f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        DeviceMainPageEditBarV2.AnonymousClass16.this.O000000o(this.f$1);
                    }
                });
            }
        });
        this.O0000OOo.O000000o(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.widget.DeviceMainPageEditBarV2.AnonymousClass17 */

            public final void onClick(View view) {
                DeviceMainPageEditBarV2.this.O000000o(view, new Runnable(dviceEditInterface) {
                    /* class com.xiaomi.smarthome.newui.widget.$$Lambda$DeviceMainPageEditBarV2$17$Mty_7Q_1H6ut2Ypn0nR11lOiqk */
                    private final /* synthetic */ DviceEditInterface f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        DeviceMainPageEditBarV2.AnonymousClass17.this.O000000o(this.f$1);
                    }
                });
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(DviceEditInterface dviceEditInterface) {
                ArrayList arrayList = new ArrayList(dviceEditInterface.O0000Oo0());
                if (arrayList.size() > 0) {
                    fbt fbt = new fbt(DeviceMainPageEditBarV2.this.f10278O000000o.getActivity(), "/share/ShareDeviceActivity");
                    Bundle bundle = new Bundle();
                    bundle.putString("user_id", CoreApi.O000000o().O0000o0());
                    bundle.putStringArrayList("batch_dids", arrayList);
                    fbt.O000000o(bundle);
                    fbs.O000000o(fbt);
                }
                DeviceMainPageEditBarV2.this.f10278O000000o.exitEditMode();
                DeviceMainPageEditBarV2.O000000o("DevicelistEditShareBatch");
                hxi.O00000o.O00000Oo("4", dviceEditInterface.O0000o0o());
            }
        });
        this.O0000o0o.O000000o(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.widget.DeviceMainPageEditBarV2.AnonymousClass2 */

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(DviceEditInterface dviceEditInterface) {
                DeviceMainPageEditBarV2 deviceMainPageEditBarV2 = DeviceMainPageEditBarV2.this;
                List<String> O0000Oo0 = dviceEditInterface.O0000Oo0();
                if (O0000Oo0.isEmpty()) {
                    deviceMainPageEditBarV2.f10278O000000o.exitEditMode();
                    return;
                }
                hfy.f18887O000000o.O00000o0(ggb.O00000Oo().O0000Oo0(), O0000Oo0).subscribe();
                deviceMainPageEditBarV2.f10278O000000o.exitEditMode();
                hxi.O00000o.O00000Oo("10", dviceEditInterface.O0000o0o());
            }

            public final void onClick(View view) {
                DeviceMainPageEditBarV2.this.O000000o(view, new Runnable(dviceEditInterface) {
                    /* class com.xiaomi.smarthome.newui.widget.$$Lambda$DeviceMainPageEditBarV2$2$uLYGTGFxzD05qAt0v66ppIu3S6Q */
                    private final /* synthetic */ DviceEditInterface f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        DeviceMainPageEditBarV2.AnonymousClass2.this.O000000o(this.f$1);
                    }
                });
            }
        });
    }

    public final void O000000o(View view, final Runnable runnable) {
        hag hag = new hag(1.1f);
        hag.setDuration(100);
        hag.setInterpolator(new LinearInterpolator());
        hag.setAnimationListener(new Animation.AnimationListener() {
            /* class com.xiaomi.smarthome.newui.widget.DeviceMainPageEditBarV2.AnonymousClass3 */

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                runnable.run();
            }
        });
        view.startAnimation(hag);
    }

    public final void O00000Oo(DviceEditInterface dviceEditInterface) {
        try {
            ArrayList arrayList = new ArrayList(dviceEditInterface.O0000Oo0());
            int i = 1;
            if (arrayList.size() <= 0) {
                this.O0000o.disableTransitionType(0);
                this.O0000o.disableTransitionType(1);
                this.O0000o00.O000000o(Boolean.FALSE);
                this.O0000o0O.O000000o(Boolean.FALSE);
                this.O0000o0.O000000o(Boolean.FALSE);
                this.O0000o0o.O000000o(Boolean.FALSE);
                this.O0000Ooo.O000000o(Boolean.FALSE);
                this.O0000O0o.O000000o(Boolean.FALSE);
                this.O0000OOo.O000000o(Boolean.FALSE);
                this.O0000OoO.O000000o(Boolean.FALSE);
                this.O0000Oo0.O000000o(Boolean.FALSE);
                this.O0000Oo.O000000o(Boolean.FALSE);
            } else if (arrayList.size() == 1) {
                Device O000000o2 = fno.O000000o().O000000o((String) arrayList.get(0));
                if (O000000o2 != null) {
                    this.O0000o00.O000000o(Boolean.valueOf(dviceEditInterface.O0000o0o() == 6 && dviceEditInterface.O00000oO() != DviceEditInterface.HostPage.ALL_PAGE));
                    this.O0000o0O.O000000o(Boolean.valueOf(O00000Oo(arrayList, dviceEditInterface)));
                    this.O0000o0.O000000o(Boolean.valueOf(O000000o(arrayList, dviceEditInterface)));
                    this.O0000o0o.O000000o(Boolean.valueOf(O00000o0(arrayList)));
                    this.O0000Ooo.O000000o(Boolean.FALSE);
                    this.O0000O0o.O000000o(Boolean.valueOf(O00000Oo(arrayList)));
                    this.O0000OOo.O000000o(Boolean.valueOf(O000000o(arrayList)));
                    this.O0000OoO.O000000o(Boolean.valueOf(!fqw.O000000o(O000000o2.did)));
                    this.O0000Oo0.O000000o(Boolean.valueOf(DeviceRouterFactory.getDeviceWrapper().canRename(O000000o2) && !fqw.O000000o(O000000o2.did)));
                    this.O0000Oo.O000000o(Boolean.valueOf(!gge.O000000o(O000000o2)));
                } else {
                    return;
                }
            } else {
                this.O0000o.enableTransitionType(0);
                this.O0000o.enableTransitionType(1);
                this.O0000o00.O000000o(Boolean.valueOf(dviceEditInterface.O0000o0o() == 6 && dviceEditInterface.O00000oO() != DviceEditInterface.HostPage.ALL_PAGE));
                this.O0000o0O.O000000o(Boolean.valueOf(O00000Oo(arrayList, dviceEditInterface)));
                this.O0000o0.O000000o(Boolean.valueOf(O000000o(arrayList, dviceEditInterface)));
                this.O0000o0o.O000000o(Boolean.valueOf(O00000o0(arrayList)));
                this.O0000Ooo.O000000o(Boolean.valueOf(O00000o(arrayList)));
                this.O0000O0o.O000000o(Boolean.valueOf(O00000Oo(arrayList)));
                this.O0000OOo.O000000o(Boolean.valueOf(O000000o(arrayList)));
                this.O0000OoO.O000000o(Boolean.valueOf(arrayList.size() <= 20));
                this.O0000Oo0.O000000o(Boolean.FALSE);
                this.O0000Oo.O000000o(Boolean.FALSE);
            }
            if (dviceEditInterface.O0000o0o() == 2) {
                this.O0000OoO.O000000o(Boolean.FALSE);
                this.O0000Oo.O000000o(Boolean.FALSE);
                this.O0000o0.O000000o(Boolean.FALSE);
            }
            O000000o();
            if (this.O00000o0) {
                this.O00000o0 = false;
                if (dviceEditInterface.O0000o0o() == 6) {
                    i = 0;
                }
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < this.O0000oO0.size(); i2++) {
                    if (this.O0000oO0.get(i2).f10297O000000o.isEnabled()) {
                        sb.append(i2 + 1);
                        sb.append(" ");
                    }
                }
                hxi.O00000o0.O000000o(i, sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000a  */
    private static boolean O000000o(List<String> list) {
        for (String O000000o2 : list) {
            Device O000000o3 = fno.O000000o().O000000o(O000000o2);
            if (O000000o3 == null || !DeviceRouterFactory.getDeviceWrapper().canBeShared(O000000o3)) {
                return false;
            }
            while (r2.hasNext()) {
            }
        }
        return true;
    }

    private static boolean O00000Oo(List<String> list) {
        if (list.isEmpty()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            Device O000000o2 = fno.O000000o().O000000o(list.get(i));
            if (O000000o2 != null && (O000000o2.isShared() || O000000o2.isFamily() || O000000o2.isSharedReadOnly() || gge.O000000o(O000000o2) || !ggb.O000000o(O000000o2))) {
                return false;
            }
        }
        return true;
    }

    private static boolean O000000o(List<String> list, DviceEditInterface dviceEditInterface) {
        if (dviceEditInterface.O0000o0o() == 6 || list.isEmpty()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            Device O000000o2 = fno.O000000o().O000000o(list.get(i));
            if (O000000o2 != null && !O000000o2.freqFlag) {
                return true;
            }
        }
        return false;
    }

    private static boolean O00000Oo(List<String> list, DviceEditInterface dviceEditInterface) {
        if (dviceEditInterface.O0000o0o() != 6 || list.isEmpty()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            Device O000000o2 = fno.O000000o().O000000o(list.get(i));
            if (O000000o2 != null && O000000o2.freqFlag) {
                return true;
            }
        }
        return false;
    }

    private static boolean O00000o0(List<String> list) {
        if (list.isEmpty()) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Device O000000o2 = fno.O000000o().O000000o(list.get(i2));
            if (O000000o2 != null) {
                if (!gge.O00000Oo(O000000o2)) {
                    return false;
                }
                hfy hfy = hfy.f18887O000000o;
                if (!hfy.O000000o(O000000o2)) {
                    i++;
                }
            }
        }
        if (i > 0) {
            return true;
        }
        return false;
    }

    private static boolean O00000o(List<String> list) {
        if (list.isEmpty()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            Device O000000o2 = fno.O000000o().O000000o(list.get(i));
            if (O000000o2 != null && (O000000o2.isShared() || O000000o2.isFamily() || O000000o2.isSharedReadOnly() || gge.O000000o(O000000o2) || !ggb.O000000o(O000000o2) || !TextUtils.equals("light", hfa.O00000Oo(O000000o2)) || O000000o2.pid == Device.PID_VIRTUAL_GROUP)) {
                return false;
            }
        }
        return true;
    }

    public final void O00000o0(final DviceEditInterface dviceEditInterface) {
        List<String> O0000Oo02 = dviceEditInterface.O0000Oo0();
        if (O0000Oo02.isEmpty()) {
            this.f10278O000000o.exitEditMode();
            return;
        }
        if (O0000Oo02.size() == dviceEditInterface.O0000o00()) {
            View inflate = LayoutInflater.from(getContext()).inflate((int) R.layout.edit_bar_common_use_device_del, (ViewGroup) null);
            if (this.O00000o == null) {
                this.O00000o = new MLAlertDialog.Builder(getContext()).O00000o0().O00000o();
            }
            inflate.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.newui.widget.$$Lambda$DeviceMainPageEditBarV2$X7VGk6eT67JEJDxwEh_XhKEaBLM */

                public final void onClick(View view) {
                    DeviceMainPageEditBarV2.this.O000000o(view);
                }
            });
            inflate.findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.newui.widget.DeviceMainPageEditBarV2.AnonymousClass9 */

                public final void onClick(View view) {
                    gfx.O000000o().O00000Oo(dviceEditInterface.O0000Oo0(), new fsm[0]);
                    DeviceMainPageEditBarV2.this.O00000o.dismiss();
                    DeviceMainPageEditBarV2.this.f10278O000000o.exitEditMode();
                    hxi.O00000o.O0000oO("2");
                }
            });
            this.O00000o.setView(inflate, 0, 0, 0, 0);
            this.O00000o.show();
            hxi.O00000o0.f957O000000o.O000000o("alert.doublecheck.show", "time", Long.valueOf(System.currentTimeMillis()), "uid", fcn.O000000o().O00000Oo());
        } else {
            gfx.O000000o().O00000Oo(O0000Oo02, new fsm[0]);
            this.f10278O000000o.exitEditMode();
        }
        hxi.O00000o.O00000Oo("9", dviceEditInterface.O0000o0o());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        this.O00000o.dismiss();
        hxi.O00000o.O0000oO("1");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        XQProgressDialog xQProgressDialog = this.O00000Oo;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
        }
        MLAlertDialog mLAlertDialog = this.O00000o;
        if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
            this.O00000o.dismiss();
        }
        super.onDetachedFromWindow();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void
     arg types: [com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], int]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, boolean, long, long):int
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, _m_j.fsm<org.json.JSONObject, _m_j.fso>, boolean):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String[], boolean, com.xiaomi.smarthome.core.client.IClientCallback):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void */
    public static void O000000o(String str) {
        CoreApi.O000000o().O000000o(StatType.DEVICE_EDIT, str, (String) null, (String) null, false);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        O000000o();
    }
}

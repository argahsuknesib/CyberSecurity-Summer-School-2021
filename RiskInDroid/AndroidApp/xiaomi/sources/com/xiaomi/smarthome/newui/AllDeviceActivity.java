package com.xiaomi.smarthome.newui;

import _m_j.fad;
import _m_j.faw;
import _m_j.fno;
import _m_j.fpo;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ft;
import _m_j.ggb;
import _m_j.gpc;
import _m_j.gsy;
import _m_j.gwg;
import _m_j.gzr;
import _m_j.gzs;
import _m_j.hxi;
import _m_j.hzf;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.newui.adapter.DviceEditInterface;
import com.xiaomi.smarthome.newui.widget.CommonBlurView;
import com.xiaomi.smarthome.newui.widget.DeviceMainPageEditBarV2;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import java.util.ArrayList;
import java.util.List;

public class AllDeviceActivity extends BaseActivity implements gzr {
    public static final String TAG = "AllDeviceActivity";

    /* renamed from: O000000o  reason: collision with root package name */
    TextView f10079O000000o;
    DeviceRecycler O00000Oo;
    private CommonBlurView O00000o;
    protected TextView O00000o0;
    private Device O00000oO;
    private BroadcastReceiver O00000oo = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.newui.AllDeviceActivity.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            if (AllDeviceActivity.this.isValid()) {
                gsy.O00000Oo(AllDeviceActivity.TAG, intent.getAction());
                if ("com.smarthome.refresh_list_view".equals(intent.getAction()) && AllDeviceActivity.this.O00000Oo != null && AllDeviceActivity.this.O00000Oo.getAdapter() != null) {
                    gsy.O00000Oo(AllDeviceActivity.TAG, "com.smarthome.refresh_list_view");
                    AllDeviceActivity.this.refreshData(false);
                }
            }
        }
    };
    private long O0000O0o = 0;
    private View O0000OOo;
    private ImageView O0000Oo;
    private View O0000Oo0;
    private ImageView O0000OoO;
    public DviceEditInterface mEditInterface;
    public volatile boolean mEditMode = false;

    public Activity getActivity() {
        return this;
    }

    public static void startActivity(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, AllDeviceActivity.class);
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_all_device);
        ButterKnife.bind(this);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.$$Lambda$AllDeviceActivity$CAluxAXVY3bZuGbFUWcegQlu1T8 */

            public final void onClick(View view) {
                AllDeviceActivity.this.O00000Oo(view);
            }
        });
        this.f10079O000000o = (TextView) findViewById(R.id.module_a_3_return_title);
        this.O00000Oo = (DeviceRecycler) findViewById(R.id.recyclerview);
        this.f10079O000000o.setText((int) R.string.all_device);
        this.f10079O000000o.setTextSize(2, 18.0f);
        this.f10079O000000o.setTypeface(Typeface.DEFAULT_BOLD);
        gwg.O00000Oo(getWindow());
        this.O00000Oo.setPage(this);
        IntentFilter intentFilter = new IntentFilter("force_update_data_completed");
        intentFilter.addAction("com.smarthome.refresh_list_view");
        ft.O000000o(getContext()).O000000o(this.O00000oo, intentFilter);
        refreshData(true);
    }

    public void onResume() {
        super.onResume();
        this.O0000O0o = hxi.O00000o0.O0000OOo(0);
    }

    public void onPause() {
        super.onPause();
        hxi.O00000o0.O0000OOo(this.O0000O0o);
    }

    public void onBackPressed() {
        if (this.mEditMode) {
            exitEditMode();
            return;
        }
        super.onBackPressed();
        hxi.O00000o.f952O000000o.O000000o("room_room_detail_back", new Object[0]);
    }

    public void onDestroy() {
        ft.O000000o(getContext()).O000000o(this.O00000oo);
        this.O00000oo = null;
        super.onDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == gzs.O000O00o && i2 == -1) {
            this.O00000Oo.O00000Oo.notifyDataSetChanged();
        } else if (i == 6) {
            final Device device = this.O00000oO;
            gsy.O00000Oo(TAG, "wxf refreshDevice");
            if (device != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(device.did);
                fno.O000000o().O000000o(arrayList, new fsm<List<Device>, fso>() {
                    /* class com.xiaomi.smarthome.newui.AllDeviceActivity.AnonymousClass2 */

                    public final void onFailure(fso fso) {
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        fno.O000000o().O00000o0(device);
                        fad.O000000o().sendBrodCard(device.did);
                    }
                });
            }
            CommonBlurView commonBlurView = this.O00000o;
            if (commonBlurView != null) {
                commonBlurView.setBlurViewGone();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        onBackPressed();
    }

    public void refreshData(boolean z) {
        List<PageBean.O00000Oo> O000000o2 = PageBean.O000000o(this, ggb.O00000Oo().O00000o());
        String str = TAG;
        gsy.O00000Oo(str, "refreshData rooms size=" + O000000o2.size());
        DeviceRecycler deviceRecycler = this.O00000Oo;
        deviceRecycler.O00000o0.O000000o(O000000o2);
        if (z) {
            deviceRecycler.O00000o0.O000000o("mijia.roomid.all");
        }
        deviceRecycler.f10087O000000o.notifyDataSetChanged();
        deviceRecycler.O00000o.onNext(Boolean.TRUE);
    }

    public void onClickCommonUseDevice(Device device, RectF rectF, String str) {
        gsy.O00000Oo(TAG, "wxf onClickCommonUseDevice");
        hxi.O00000o.O000000o(false);
        this.O00000oO = device;
        faw.O000000o(this, device.did, str, rectF);
        if (this.O00000o == null) {
            this.O00000o = (CommonBlurView) ((ViewStub) findViewById(R.id.blur_view_vs)).inflate();
        }
        this.O00000o.setBlurView(findViewById(R.id.layout_layer1), true);
    }

    public void updateActionItems(DviceEditInterface dviceEditInterface, int i) {
        if (i > 0) {
            try {
                this.O00000o0.setText(getResources().getQuantityString(R.plurals.edit_choosed_device, i, Integer.valueOf(i)));
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            this.O00000o0.setText((int) R.string.title_choose_device);
        }
        this.O00000o0.setTypeface(null, 0);
        if (i >= dviceEditInterface.O0000o0O()) {
            this.O0000OoO.setImageResource(R.drawable.un_select_selector);
            this.O0000OoO.setContentDescription(getString(R.string.unselect_all));
        } else {
            this.O0000OoO.setImageResource(R.drawable.all_select_selector);
            this.O0000OoO.setContentDescription(getString(R.string.select_all));
        }
        ((DeviceMainPageEditBarV2) getChooseDeviceMenuBar2()).O00000Oo(dviceEditInterface);
    }

    public View getChooseDeviceTitleBar() {
        if (this.O0000OOo == null) {
            this.O0000OOo = ((ViewStub) findViewById(R.id.title_bar_choose_device_stub)).inflate();
            gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), this.O0000OOo.findViewById(R.id.title_bar_choose_device));
        }
        return this.O0000OOo;
    }

    public View getChooseDeviceMenuBar2() {
        if (this.O0000Oo0 == null) {
            this.O0000Oo0 = ((ViewStub) findViewById(R.id.edit_action_bar_stub_v2)).inflate();
        }
        return this.O0000Oo0;
    }

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
    public void enterEditMode(DviceEditInterface dviceEditInterface) {
        if (!this.mEditMode && dviceEditInterface != null) {
            this.mEditMode = true;
            this.mEditInterface = dviceEditInterface;
            Intent intent = new Intent("main_action_card_edit_mode_changed");
            intent.putExtra("main_extra_card_edit_mode_is_edit_mode", true);
            ft.O000000o(this).O000000o(intent);
            this.O00000Oo.setBackgroundColor(getResources().getColor(R.color.mj_color_black_10_transparent));
            fpo.O00000Oo();
            try {
                View chooseDeviceTitleBar = getChooseDeviceTitleBar();
                this.O0000OoO = (ImageView) chooseDeviceTitleBar.findViewById(16908313);
                this.O0000Oo = (ImageView) chooseDeviceTitleBar.findViewById(16908314);
                this.O0000Oo.setImageResource(R.drawable.title_right_tick_drawable);
                this.O00000o0 = (TextView) chooseDeviceTitleBar.findViewById(R.id.module_a_4_return_more_title);
                this.O0000Oo.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.newui.$$Lambda$AllDeviceActivity$R2LD0900_9aIfTSmIg7CqBWf6U */

                    public final void onClick(View view) {
                        AllDeviceActivity.this.O000000o(view);
                    }
                });
                this.O0000OoO.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.newui.$$Lambda$AllDeviceActivity$_Ec9pt56LEp2JpIteubaaZIQhHY */

                    public final void onClick(View view) {
                        AllDeviceActivity.O000000o(DviceEditInterface.this, view);
                    }
                });
                DeviceMainPageEditBarV2 deviceMainPageEditBarV2 = (DeviceMainPageEditBarV2) getChooseDeviceMenuBar2();
                deviceMainPageEditBarV2.setDeviceMainPage(this);
                deviceMainPageEditBarV2.O000000o(dviceEditInterface);
                O000000o(deviceMainPageEditBarV2, chooseDeviceTitleBar, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            dviceEditInterface.O00000oo();
            hxi.O00000o0.O00000Oo(dviceEditInterface.O0000o0o());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        exitEditMode();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(DviceEditInterface dviceEditInterface, View view) {
        boolean z = dviceEditInterface.O0000Oo0().size() < dviceEditInterface.O0000o0O();
        dviceEditInterface.a_(z);
        dviceEditInterface.O0000o0();
        hxi.O00000o.O00000o(z ? 1 : 0);
    }

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
    public void exitEditMode() {
        if (this.mEditMode) {
            this.mEditMode = false;
            Intent intent = new Intent("main_action_card_edit_mode_changed");
            intent.putExtra("main_extra_card_edit_mode_is_edit_mode", false);
            ft.O000000o(this).O000000o(intent);
            this.O00000Oo.setBackground(null);
            O000000o((DeviceMainPageEditBarV2) getChooseDeviceMenuBar2(), getChooseDeviceTitleBar(), false);
            DviceEditInterface dviceEditInterface = this.mEditInterface;
            if (dviceEditInterface != null) {
                dviceEditInterface.O0000O0o();
                this.mEditInterface.O0000o0();
                this.mEditInterface = null;
            }
        }
    }

    public void onStateChanged() {
        gsy.O00000Oo(TAG, "wxf onStateChanged");
        refreshData(false);
        exitEditMode();
    }

    private void O000000o(final DeviceMainPageEditBarV2 deviceMainPageEditBarV2, final View view, boolean z) {
        deviceMainPageEditBarV2.setVisibility(0);
        view.setVisibility(0);
        if (z) {
            view.setTranslationY((float) (-gpc.O00000o0(view.getContext(), 86.0f)));
            view.animate().translationY(0.0f);
            deviceMainPageEditBarV2.setTranslationY((float) gpc.O00000o0(view.getContext(), 90.0f));
            deviceMainPageEditBarV2.animate().translationY(0.0f);
            return;
        }
        view.animate().translationY((float) (-gpc.O00000o0(view.getContext(), 86.0f)));
        deviceMainPageEditBarV2.animate().translationY((float) gpc.O00000o0(deviceMainPageEditBarV2.getContext(), 90.0f)).withEndAction(new Runnable() {
            /* class com.xiaomi.smarthome.newui.AllDeviceActivity.AnonymousClass3 */

            public final void run() {
                view.setVisibility(8);
                deviceMainPageEditBarV2.setVisibility(8);
            }
        });
    }

    public boolean isEditMode() {
        return this.mEditMode;
    }
}

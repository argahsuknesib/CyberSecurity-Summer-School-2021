package com.xiaomi.smarthome.newui;

import _m_j.exo;
import _m_j.fno;
import _m_j.ft;
import _m_j.go;
import _m_j.goq;
import _m_j.gqg;
import _m_j.gth;
import _m_j.gti;
import _m_j.gtj;
import _m_j.gwg;
import _m_j.gzl;
import _m_j.hfy;
import _m_j.hxi;
import _m_j.hyy;
import _m_j.hzf;
import _m_j.izb;
import _m_j.mh;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.camera.api.CameraRouterFactory;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.DevicePtrFrameLayout;
import com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AllCameraActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f10069O000000o = false;
    gtj.O000000o O00000Oo = new gtj.O000000o() {
        /* class com.xiaomi.smarthome.newui.AllCameraActivity.AnonymousClass1 */

        public final void O000000o() {
            AllCameraActivity.this.mBs.onNext(Boolean.TRUE);
        }
    };
    BroadcastReceiver O00000o = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.newui.AllCameraActivity.AnonymousClass3 */

        public final void onReceive(Context context, Intent intent) {
            AllCameraActivity.this.onReceiveBackground(intent);
        }
    };
    fno.O000000o O00000o0 = new fno.O000000o() {
        /* class com.xiaomi.smarthome.newui.AllCameraActivity.AnonymousClass2 */

        public final void onRefreshClientDeviceChanged(int i, Device device) {
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            if (i == 3) {
                gtj.O000000o().O00000o0();
            }
        }
    };
    private PtrIndicator O00000oO;
    private RecyclerView.O000000o O00000oo;
    private ImageView O0000O0o;
    private int O0000OOo;
    private Disposable O0000Oo;
    private final String O0000Oo0 = "showedToast";
    public BehaviorSubject<Boolean> mBs = BehaviorSubject.create();
    public Dialog mDialog;
    public DevicePtrFrameLayout mPullRefresh;
    public RecyclerView mRecyclerView;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gth.O000000o(java.lang.String, boolean):_m_j.gth$O00000o0
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gth.O000000o(int, java.io.OutputStream):void
      _m_j.gth.O000000o(android.content.Context, com.xiaomi.smarthome.device.Device):void
      _m_j.gth.O000000o(com.xiaomi.smarthome.device.Device, com.xiaomi.smarthome.fastvideo.VideoView):void
      _m_j.gth.O000000o(java.lang.String, boolean):_m_j.gth$O00000o0 */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.client_all_container);
        gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), findViewById(R.id.title_bar_choose_device));
        gtj O000000o2 = gtj.O000000o();
        gtj.O000000o o000000o = this.O00000Oo;
        synchronized (O000000o2) {
            Iterator<gtj.O000000o> it = O000000o2.O0000OOo.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().equals(o000000o)) {
                        O000000o2.O0000OOo.remove(o000000o);
                        break;
                    }
                } else {
                    break;
                }
            }
            O000000o2.O0000OOo.add(o000000o);
        }
        fno.O000000o().O000000o(this.O00000o0);
        this.O0000Oo = this.mBs.throttleLatest(1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
            /* class com.xiaomi.smarthome.newui.$$Lambda$AllCameraActivity$hLo0483NwcWTF4QpRBbkX4n3XhM */

            public final void accept(Object obj) {
                AllCameraActivity.this.O000000o((Boolean) obj);
            }
        }, $$Lambda$Jxp4LOjD5wh7hYvpBAWXzgH0LNY.INSTANCE);
        this.O00000oO = new PtrIndicator();
        this.mPullRefresh = (DevicePtrFrameLayout) findViewById(R.id.pull_down_refresh);
        this.mPullRefresh.setVisibility(0);
        this.mPullRefresh.disableWhenHorizontalMove(true);
        this.mPullRefresh.setPullToRefresh(false);
        this.mPullRefresh.setPtrIndicator(this.O00000oO);
        this.mPullRefresh.addPtrUIHandler(new PtrUIHandler() {
            /* class com.xiaomi.smarthome.newui.AllCameraActivity.AnonymousClass4 */

            public final void onUIPositionChange(PtrFrameLayout ptrFrameLayout, boolean z, byte b, PtrIndicator ptrIndicator) {
            }

            public final void onUIRefreshBegin(PtrFrameLayout ptrFrameLayout) {
            }

            public final void onUIRefreshComplete(PtrFrameLayout ptrFrameLayout) {
            }

            public final void onUIRefreshPrepare(PtrFrameLayout ptrFrameLayout) {
            }

            public final void onUIReset(PtrFrameLayout ptrFrameLayout) {
            }
        });
        this.mPullRefresh.setPtrHandler(new PtrDefaultHandler() {
            /* class com.xiaomi.smarthome.newui.AllCameraActivity.AnonymousClass5 */

            public final void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                if (!AllCameraActivity.this.f10069O000000o) {
                    AllCameraActivity.this.updateDeviceRemote();
                }
            }
        });
        this.mRecyclerView = (RecyclerView) findViewById(R.id.device_grid_view);
        gzl gzl = new gzl();
        gzl.O000000o(new FavoriteCameraCardAdapter(true));
        this.O00000oo = gzl;
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(this, -1));
        this.mRecyclerView.setAdapter(this.O00000oo);
        this.mRecyclerView.setHasFixedSize(false);
        new go().O0000o00 = false;
        this.mRecyclerView.setItemAnimator(new go());
        this.O0000OOo = gti.O000000o().O00000o();
        hxi.O00000o0.f957O000000o.O000000o("camera_current_view", "status", Integer.valueOf(this.O0000OOo == 0 ? 1 : 2));
        O000000o();
        O00000Oo();
        ArrayList<gti.O000000o> arrayList = gti.O000000o().O00000o0;
        if (arrayList != null) {
            for (gti.O000000o o000000o2 : arrayList) {
                Device O000000o3 = fno.O000000o().O000000o(o000000o2.f18248O000000o);
                if (O000000o3 != null && gth.O000000o().O00000Oo(O000000o3.did) == null) {
                    gth.O000000o().O000000o(O000000o3.did, false);
                }
            }
        }
        ((TextView) findViewById(R.id.module_a_2_more_title)).setText((int) R.string.camera_count_tip);
        this.O0000O0o = (ImageView) findViewById(R.id.module_a_3_more_btn);
        this.O0000O0o.setImageResource(R.drawable.common_title_bar_more_black);
        this.O0000O0o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.$$Lambda$AllCameraActivity$POKTpnXgQob6lIrhlt5wt0st0A */

            public final void onClick(View view) {
                AllCameraActivity.this.O00000Oo(view);
            }
        });
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.$$Lambda$AllCameraActivity$6AFr953IoKBaA78Nj2LnyTowDo */

            public final void onClick(View view) {
                AllCameraActivity.this.O000000o(view);
            }
        });
        IntentFilter intentFilter = new IntentFilter("refresh_list");
        intentFilter.addAction("change_adapter");
        intentFilter.addAction("action_freq_camera_update");
        ft.O000000o(this).O000000o(this.O00000o, intentFilter);
        mh mhVar = new mh(this, "AllCameraPage", "");
        if (!mhVar.f2182O000000o.getBoolean("showedToast", false)) {
            if (hyy.O000000o()) {
                gqg.O00000Oo(R.string.all_camera_play_limit_4, 1);
            } else {
                gqg.O00000Oo(R.string.all_camera_play_limit_3, 1);
            }
            SharedPreferences.Editor edit = mhVar.f2182O000000o.edit();
            edit.putBoolean("showedToast", true);
            edit.apply();
        }
        hxi.O00000o0.f957O000000o.O000000o("all_camera_show", new Object[0]);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Boolean bool) throws Exception {
        if (isValid()) {
            O000000o();
        }
    }

    public void onResume() {
        super.onResume();
        CoreApi.O000000o().O000000o(getContext(), new CoreApi.O0000o0() {
            /* class com.xiaomi.smarthome.newui.$$Lambda$AllCameraActivity$MXnrVo6xeJmaI8CkcTQ7CpsBtBY */

            public final void onCoreReady() {
                AllCameraActivity.this.O00000o();
            }
        });
        updateDeviceRemote();
    }

    public void onPause() {
        super.onPause();
        gth O000000o2 = gth.O000000o();
        for (String O00000Oo2 : O000000o2.O00000Oo.keySet()) {
            gth.O00000o0 O00000Oo3 = O000000o2.O00000Oo(O00000Oo2);
            if (O00000Oo3 != null && O00000Oo3.O0000Oo && !O00000Oo3.O0000Oo0) {
                Intent intent = new Intent();
                intent.putExtra("run_on_main", O00000Oo3.O0000Oo0);
                Device O00000o02 = fno.O000000o().O00000o0(O00000Oo3.O00000Oo);
                if (O00000o02 != null) {
                    O000000o2.O000000o(this, O00000o02, 20, intent);
                    O00000Oo3.O0000Oo = false;
                    O00000Oo3.O0000O0o = false;
                    O00000Oo3.f18240O000000o = false;
                    if (O00000Oo3.O00000o != null) {
                        O00000Oo3.O00000o.setVisibility(8);
                        O00000Oo3.O00000o.clearAnimation();
                    }
                    O000000o2.O000000o(O00000o02, O00000Oo3.O00000oO, O00000Oo3.O00000o);
                }
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        CameraRouterFactory.getCameraManagerApi().destorySubscriberCameraDeviceOpManager();
        gtj O000000o2 = gtj.O000000o();
        gtj.O000000o o000000o = this.O00000Oo;
        synchronized (O000000o2) {
            Iterator<gtj.O000000o> it = O000000o2.O0000OOo.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().equals(o000000o)) {
                        O000000o2.O0000OOo.remove(o000000o);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        fno.O000000o().O00000Oo(this.O00000o0);
        ft.O000000o(this).O000000o(this.O00000o);
        Disposable disposable = this.O0000Oo;
        if (disposable != null && !disposable.isDisposed()) {
            this.O0000Oo.dispose();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        new AllCameraOptionsPopupWindow(this, this.O0000O0o, this.O0000OOo).e_();
        hxi.O00000o.f952O000000o.O000000o("all_camera_setting_click", new Object[0]);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        finish();
    }

    private void O000000o() {
        FavoriteCameraCardAdapter favoriteCameraCardAdapter;
        this.mPullRefresh.refreshComplete();
        RecyclerView.O000000o o000000o = this.O00000oo;
        if ((o000000o instanceof gzl) && (favoriteCameraCardAdapter = (FavoriteCameraCardAdapter) ((gzl) o000000o).O000000o(FavoriteCameraCardAdapter.class)) != null) {
            ArrayList arrayList = new ArrayList();
            List<gti.O000000o> O00000o02 = gti.O000000o().O00000o0();
            for (int i = 0; i < O00000o02.size(); i++) {
                arrayList.add(O00000o02.get(i).f18248O000000o);
            }
            hfy hfy = hfy.f18887O000000o;
            favoriteCameraCardAdapter.O000000o(hfy.O000000o(arrayList));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o() {
        exo stateNotifier = ServiceApplication.getStateNotifier();
        int i = stateNotifier.f15923O000000o;
        if (i == 2) {
            Dialog dialog = this.mDialog;
            if (dialog != null && dialog.isShowing()) {
                this.mDialog.dismiss();
            }
            this.mDialog = new XQProgressDialog(this);
            this.mDialog.setCancelable(false);
            ((XQProgressDialog) this.mDialog).setMessage(getResources().getString(R.string.logining_please_wait));
            this.mDialog.show();
            stateNotifier.O000000o(new exo.O000000o() {
                /* class com.xiaomi.smarthome.newui.AllCameraActivity.AnonymousClass6 */

                public final void onLoginSuccess() {
                    AllCameraActivity.this.mDialog.dismiss();
                    AllCameraActivity.this.updateDeviceRemote();
                    AllCameraActivity allCameraActivity = AllCameraActivity.this;
                    izb.O000000o(allCameraActivity, allCameraActivity.getString(R.string.login_success), 0).show();
                }

                public final void onLoginFailed() {
                    AllCameraActivity.this.mDialog.dismiss();
                    AllCameraActivity allCameraActivity = AllCameraActivity.this;
                    izb.O000000o(allCameraActivity, allCameraActivity.getString(R.string.login_fail), 0).show();
                    AllCameraActivity.this.showLoginDialog();
                }
            });
        } else if (i == 3) {
            showLoginDialog();
        }
    }

    public void showLoginDialog() {
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDialog.dismiss();
            this.mDialog = null;
        }
        Dialog dialog2 = this.mDialog;
        if (dialog2 == null) {
            this.mDialog = CommonApplication.getApplication().showAppLoginDialog(this, true);
            this.mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                /* class com.xiaomi.smarthome.newui.AllCameraActivity.AnonymousClass7 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AllCameraActivity.this.finish();
                }
            });
            this.mDialog.setCanceledOnTouchOutside(false);
        } else if (!dialog2.isShowing()) {
            this.mDialog.show();
        }
    }

    private void O00000Oo() {
        FavoriteCameraCardAdapter favoriteCameraCardAdapter;
        RecyclerView.O000000o o000000o = this.O00000oo;
        if ((o000000o instanceof gzl) && (favoriteCameraCardAdapter = (FavoriteCameraCardAdapter) ((gzl) o000000o).O000000o(FavoriteCameraCardAdapter.class)) != null) {
            favoriteCameraCardAdapter.O000000o(this.O0000OOo == 0 ? 1 : 2, this.mRecyclerView);
        }
    }

    public void updateDeviceRemote() {
        goq.O000000o($$Lambda$AllCameraActivity$OvB1kjkYN9bnVISqKTg6QqWpjA.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000o0() {
        gtj.O000000o().O00000Oo();
        fno.O000000o().O0000o0O();
    }

    public void onReceiveBackground(Intent intent) {
        if ("refresh_list".equals(intent.getAction()) || "com.smarthome.refresh_list_view".equals(intent.getAction())) {
            this.mBs.onNext(Boolean.TRUE);
        } else if ("change_adapter".equals(intent.getAction())) {
            if (this.O0000OOo != gti.O000000o().O00000o()) {
                this.O0000OOo = gti.O000000o().O00000o();
                gth.O000000o().O000000o(this);
                O00000Oo();
            }
        } else if ("action_freq_camera_update".equals(intent.getAction())) {
            updateDeviceRemote();
        }
    }
}

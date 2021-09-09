package com.xiaomi.smarthome.scene.timer;

import _m_j.awp;
import _m_j.aya;
import _m_j.aye;
import _m_j.fjz;
import _m_j.fni;
import _m_j.fnn;
import _m_j.fno;
import _m_j.fso;
import _m_j.gnp;
import _m_j.gqg;
import _m_j.gqq;
import _m_j.gwg;
import _m_j.hre;
import _m_j.hrf;
import _m_j.hyq;
import _m_j.hyr;
import _m_j.hyy;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.DevicePtrFrameLayout;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.scene.model.CorntabUtils;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.indicator.PtrIndicator;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonTimerListActivity extends BaseActivity implements hrf.O00000Oo, hyr {

    /* renamed from: O000000o  reason: collision with root package name */
    hrf f11211O000000o;
    View O00000Oo;
    ImageView O00000o;
    View O00000o0;
    TextView O00000oO;
    View O00000oo;
    View O0000O0o;
    View O0000OOo;
    boolean O0000Oo = false;
    DevicePtrFrameLayout O0000Oo0;
    private String O0000OoO;
    private boolean O0000Ooo;
    private View O0000o;
    private boolean O0000o0;
    private boolean O0000o00;
    private View O0000o0O;
    private View O0000o0o;
    private RecyclerView O0000oO;
    private boolean O0000oO0 = true;
    private RecyclerViewExpandableItemManager O0000oOO;
    private PtrIndicator O0000oOo;
    public O000000o mAdapter;
    public String mCustomName;
    public Device mDevice;
    public String mEndTimeTip;
    public boolean mForceBothTimerSet = false;
    public RecyclerView.LayoutManager mLayoutManager;
    public String mOffMethod;
    public String mOffParam;
    public String mOnMethod;
    public String mOnParam;
    public String mStartTimeTip;
    public String mTimeListTip;
    public String mTimerDisplayName;
    public String mTimerIdentifyRn;
    public String mTimerName;
    public RecyclerView.O000000o mWrappedAdapter;
    public XQProgressDialog mXQProgressDialog;

    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.mAdapter.notifyDataSetChanged();
            this.O0000oOO.O000000o();
            this.mXQProgressDialog.dismiss();
            this.O0000Oo0.refreshComplete();
            O000000o o000000o = this.mAdapter;
            if (o000000o == null || o000000o.getGroupCount() <= 0) {
                this.O0000o0O.setVisibility(0);
                this.O0000o0o.setVisibility(0);
                this.O0000o.setVisibility(4);
                return;
            }
            this.O0000o0O.setVisibility(4);
            this.O0000o0o.setVisibility(4);
            this.O0000o.setVisibility(0);
        } else if (i == 2) {
            this.O0000Oo0.refreshComplete();
            this.mXQProgressDialog.dismiss();
            int i2 = message.arg1;
            ErrorCode.ERROR_INVALID_REQUEST.getCode();
            O000000o o000000o2 = this.mAdapter;
            if (o000000o2 == null || o000000o2.getGroupCount() <= 0) {
                this.O0000o0O.setVisibility(0);
                this.O0000o0o.setVisibility(0);
                this.O0000o.setVisibility(4);
                return;
            }
            this.O0000o0O.setVisibility(4);
            this.O0000o0o.setVisibility(4);
            this.O0000o.setVisibility(0);
        } else if (i == 3) {
            this.mXQProgressDialog.dismiss();
            this.mAdapter.notifyDataSetChanged();
            this.O0000oOO.O000000o();
            O000000o o000000o3 = this.mAdapter;
            if (o000000o3 == null || o000000o3.getGroupCount() <= 0) {
                this.O0000o0O.setVisibility(0);
                this.O0000o0o.setVisibility(0);
                this.O0000o.setVisibility(4);
                return;
            }
            this.O0000o0O.setVisibility(4);
            this.O0000o0o.setVisibility(4);
            this.O0000o.setVisibility(0);
        } else if (i == 4) {
            this.mXQProgressDialog.dismiss();
            O000000o o000000o4 = this.mAdapter;
            if (o000000o4 == null || o000000o4.getGroupCount() <= 0) {
                this.O0000o0O.setVisibility(0);
                this.O0000o0o.setVisibility(0);
                this.O0000o.setVisibility(4);
                return;
            }
            this.O0000o0O.setVisibility(4);
            this.O0000o0o.setVisibility(4);
            this.O0000o.setVisibility(0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_time_setting_lamp);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("common_timer_device_id");
        this.mTimerName = intent.getStringExtra("action_common_timer_name");
        this.mTimerIdentifyRn = intent.getStringExtra("timer_identify_rn");
        this.mTimerDisplayName = intent.getStringExtra("common_timer_display_name");
        this.mDevice = fno.O000000o().O000000o(stringExtra);
        if (this.mDevice == null) {
            this.mDevice = fno.O000000o().O00000Oo(stringExtra);
        }
        if (this.mDevice == null) {
            finish();
            return;
        }
        this.mOnMethod = intent.getStringExtra("on_method");
        this.mOnParam = intent.getStringExtra("on_param");
        this.mOffMethod = intent.getStringExtra("off_method");
        this.mOffParam = intent.getStringExtra("off_param");
        this.O0000OoO = intent.getStringExtra("timer_manager");
        this.mCustomName = intent.getStringExtra("custom_title_text");
        this.O0000oO0 = intent.getBooleanExtra("shouldIncludeGroup", true);
        this.O0000Ooo = intent.getBooleanExtra("on_timer_type", true);
        this.O0000o00 = intent.getBooleanExtra("off_timer_type", true);
        this.O0000o0 = intent.getBooleanExtra("period_timer_type", true);
        this.mForceBothTimerSet = intent.getBooleanExtra("both_timer_must_be_set", false);
        if (this.mForceBothTimerSet) {
            this.O0000Ooo = false;
            this.O0000o00 = false;
            this.O0000o0 = true;
        }
        this.mStartTimeTip = intent.getStringExtra("on_timer_tips");
        this.mEndTimeTip = intent.getStringExtra("off_timer_tips");
        this.mTimeListTip = intent.getStringExtra("list_timer_tips");
        if (!this.O0000oO0 || !isGroupDevice(this.mDevice)) {
            this.f11211O000000o = hrf.O0000O0o();
            this.f11211O000000o.O000000o(this.mDevice, this.mTimerName, this.mTimerDisplayName);
        } else {
            this.f11211O000000o = hre.O000000o();
            this.f11211O000000o.O000000o(this.mDevice, this.mTimerName, this.mTimerDisplayName);
        }
        hyq.O000000o().O00000Oo = this;
        this.f11211O000000o.O000000o(this);
        this.f11211O000000o.O00000Oo(this.mTimerIdentifyRn);
        this.mXQProgressDialog = new XQProgressDialog(this);
        this.mXQProgressDialog.setMessage(getString(R.string.gateway_magnet_location_updating));
        this.mXQProgressDialog.setCancelable(true);
        View findViewById = findViewById(R.id.module_a_3_return_btn);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.timer.CommonTimerListActivity.AnonymousClass2 */

                public final void onClick(View view) {
                    CommonTimerListActivity.this.finish();
                }
            });
        }
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        if (textView != null) {
            if (!TextUtils.isEmpty(this.O0000OoO)) {
                textView.setText(this.O0000OoO);
            } else {
                textView.setText((int) R.string.timer_title);
            }
        }
        this.O00000Oo = findViewById(R.id.top_delete_bar);
        if (gwg.O000000o((Activity) this) && !hyy.O000000o()) {
            this.O00000Oo.getLayoutParams().height += gwg.O00000Oo(this);
            View view = this.O00000Oo;
            view.setPadding(0, view.getPaddingTop() + gwg.O00000Oo(this), 0, 0);
            View view2 = this.O00000Oo;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        this.O00000oO = (TextView) findViewById(R.id.selected_cnt);
        this.O00000o0 = findViewById(R.id.cancel_btn);
        this.O00000o0.setOnClickListener($$Lambda$CommonTimerListActivity$JYcCjtQzWNP1kDw348viOtxFWRk.INSTANCE);
        this.O00000o = (ImageView) findViewById(R.id.select_all_btn);
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.timer.$$Lambda$CommonTimerListActivity$BW7KVhqBuCwLQ19iCe1xtGX2dXM */

            public final void onClick(View view) {
                CommonTimerListActivity.this.O00000Oo(view);
            }
        });
        this.O00000oo = findViewById(R.id.bottom_delete_bar);
        this.O0000O0o = findViewById(R.id.delete_msg_btn);
        this.O00000oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.timer.$$Lambda$CommonTimerListActivity$O353ombBkso_U5bT3dZITsIVYLQ */

            public final void onClick(View view) {
                CommonTimerListActivity.this.O000000o(view);
            }
        });
        this.O0000oOo = new PtrIndicator();
        this.O0000Oo0 = (DevicePtrFrameLayout) findViewById(R.id.pull_down_refresh);
        this.O0000Oo0.setPtrHandler(new PtrDefaultHandler() {
            /* class com.xiaomi.smarthome.scene.timer.CommonTimerListActivity.AnonymousClass3 */

            public final void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                if (hyq.O000000o().f997O000000o == 0) {
                    CommonTimerListActivity.this.O0000Oo0.refreshComplete();
                    return;
                }
                CommonTimerListActivity commonTimerListActivity = CommonTimerListActivity.this;
                commonTimerListActivity.O0000Oo = true;
                commonTimerListActivity.f11211O000000o.O00000Oo(CommonTimerListActivity.this.mTimerIdentifyRn);
            }

            public final boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
                if (Build.VERSION.SDK_INT < 14) {
                    if (view instanceof AbsListView) {
                        AbsListView absListView = (AbsListView) view;
                        return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
                    } else if (!(view instanceof RecyclerView)) {
                        return view.getScrollY() > 0;
                    } else {
                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) CommonTimerListActivity.this.mLayoutManager;
                        List<CommonTimer> O00000Oo = CommonTimerListActivity.this.f11211O000000o.O00000Oo();
                        return (O00000Oo == null || O00000Oo.size() == 0) ? linearLayoutManager.findFirstCompletelyVisibleItemPosition() - 1 < 0 : linearLayoutManager.findFirstCompletelyVisibleItemPosition() - 1 <= 0;
                    }
                } else if (!(view instanceof RecyclerView)) {
                    return view.canScrollVertically(-1);
                } else {
                    LinearLayoutManager linearLayoutManager2 = (LinearLayoutManager) CommonTimerListActivity.this.mLayoutManager;
                    List<CommonTimer> O00000Oo2 = CommonTimerListActivity.this.f11211O000000o.O00000Oo();
                    return (O00000Oo2 == null || O00000Oo2.size() == 0) ? linearLayoutManager2.findFirstCompletelyVisibleItemPosition() - 1 < 0 : linearLayoutManager2.findFirstCompletelyVisibleItemPosition() - 1 <= 0;
                }
            }
        });
        this.O0000Oo0.disableWhenHorizontalMove(true);
        this.O0000Oo0.setPtrIndicator(this.O0000oOo);
        this.O0000Oo0.addPtrUIHandler(new gqq());
        this.O0000oO = (RecyclerView) findViewById(R.id.device_grid_view);
        this.O0000oO.setOverScrollMode(2);
        this.mLayoutManager = new LinearLayoutManager(getContext());
        this.O0000oOO = new RecyclerViewExpandableItemManager();
        this.mAdapter = new O000000o();
        this.mWrappedAdapter = this.O0000oOO.O000000o(this.mAdapter);
        awp awp = new awp();
        awp.O0000o00 = false;
        this.O0000oO.setLayoutManager(this.mLayoutManager);
        this.O0000oO.setAdapter(this.mWrappedAdapter);
        this.O0000oO.setItemAnimator(awp);
        this.O0000oO.setHasFixedSize(false);
        this.O0000oO.setOverScrollMode(2);
        this.O0000oOO.O000000o(this.O0000oO);
        this.O0000oOO.O000000o();
        this.O0000o0O = findViewById(R.id.empty_text);
        this.O0000o0o = findViewById(R.id.empty_icon);
        this.O0000o = findViewById(R.id.rl_timer_list_view);
        this.O0000o0O.setVisibility(4);
        this.O0000o0o.setVisibility(4);
        this.O0000o.setVisibility(0);
        this.O0000OOo = findViewById(R.id.add_timer_id);
        this.O0000OOo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.timer.CommonTimerListActivity.AnonymousClass1 */

            public final void onClick(View view) {
                if (!CommonTimerListActivity.this.mDevice.isOwner()) {
                    gqg.O00000Oo((int) R.string.gateway_user_cant_not_access);
                } else {
                    CommonTimerListActivity.this.showTimerTypeDialog(null);
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        this.f11211O000000o.O000000o(this);
        this.f11211O000000o.O00000Oo(this.mTimerIdentifyRn);
    }

    public void onPause() {
        super.onPause();
        this.f11211O000000o.O00000Oo(this);
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        RecyclerViewExpandableItemManager recyclerViewExpandableItemManager = this.O0000oOO;
        if (recyclerViewExpandableItemManager != null) {
            if (!(recyclerViewExpandableItemManager.O00000Oo == null || recyclerViewExpandableItemManager.O00000o == null)) {
                recyclerViewExpandableItemManager.O00000Oo.removeOnItemTouchListener(recyclerViewExpandableItemManager.O00000o);
            }
            recyclerViewExpandableItemManager.O00000o = null;
            recyclerViewExpandableItemManager.O00000oO = null;
            recyclerViewExpandableItemManager.O00000oo = null;
            recyclerViewExpandableItemManager.O00000Oo = null;
            recyclerViewExpandableItemManager.f4329O000000o = null;
            this.O0000oOO = null;
        }
        RecyclerView recyclerView = this.O0000oO;
        if (recyclerView != null) {
            recyclerView.setItemAnimator(null);
            this.O0000oO.setAdapter(null);
            this.O0000oO = null;
        }
        RecyclerView.O000000o o000000o = this.mWrappedAdapter;
        if (o000000o != null) {
            aye.O000000o(o000000o);
            this.mWrappedAdapter = null;
        }
        this.mLayoutManager = null;
        super.onDestroy();
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
    public void showTimerTypeDialog(CommonTimer commonTimer) {
        Intent intent = new Intent(this, SetTimerCommonActivity.class);
        if (this.f11211O000000o instanceof hre) {
            intent.putExtra("is_group", true);
        }
        intent.putExtra("action.add.common.timer", false);
        intent.putExtra("timer_identify_rn", this.mTimerIdentifyRn);
        intent.putExtra("on_timer_tips", this.mStartTimeTip);
        intent.putExtra("off_timer_tips", this.mEndTimeTip);
        if (commonTimer == null) {
            intent.putExtra("action.add.common.timer", true);
            commonTimer = new CommonTimer();
            commonTimer.O00000o0 = this.mTimerName;
            if (commonTimer.O00000o0 == null) {
                commonTimer.O00000o0 = "";
            }
            commonTimer.O0000OOo = this.mOnMethod;
            if (commonTimer.O0000OOo == null) {
                commonTimer.O0000OOo = "";
            }
            commonTimer.O0000Oo0 = this.mOnParam;
            if (commonTimer.O0000Oo0 == null) {
                commonTimer.O0000Oo0 = "";
            }
            commonTimer.O0000o00 = this.mOffParam;
            if (commonTimer.O0000o00 == null) {
                commonTimer.O0000o00 = "";
            }
            commonTimer.O0000Ooo = this.mOffMethod;
            if (commonTimer.O0000Ooo == null) {
                commonTimer.O0000Ooo = "";
            }
        }
        intent.putExtra("common.timer", commonTimer);
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        hashMap.put(getString(R.string.plug_timer_type_period), 0);
        hashMap.put(getString(R.string.plug_timer_type_on), 1);
        hashMap.put(getString(R.string.plug_timer_type_off), 2);
        if (this.O0000o0) {
            arrayList.add(getString(R.string.plug_timer_type_period));
        }
        if (this.O0000Ooo) {
            arrayList.add(getString(R.string.plug_timer_type_on));
        }
        if (this.O0000o00) {
            arrayList.add(getString(R.string.plug_timer_type_off));
        }
        if (arrayList.isEmpty() || arrayList.size() != 1) {
            gnp.O000000o(getContext(), new MLAlertDialog.Builder(getContext()).O000000o(new O00000Oo(this, arrayList), new DialogInterface.OnClickListener(arrayList, hashMap, intent) {
                /* class com.xiaomi.smarthome.scene.timer.$$Lambda$CommonTimerListActivity$zsEtzF1o8VpvturMwDiX0Wv16_k */
                private final /* synthetic */ List f$1;
                private final /* synthetic */ Map f$2;
                private final /* synthetic */ Intent f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    CommonTimerListActivity.this.O000000o(this.f$1, this.f$2, this.f$3, dialogInterface, i);
                }
            }).O00000oo());
            return;
        }
        int intValue = ((Integer) hashMap.get(arrayList.get(0))).intValue();
        if (intValue == 0) {
            intent.putExtra("custom_title_text", getString(R.string.plug_timer_type_period));
            intent.putExtra("both_timer_must_be_set", true);
            intent.putExtra("timer_type", 0);
        } else if (intValue == 1) {
            intent.putExtra("custom_title_text", getString(R.string.plug_timer_type_on));
            intent.putExtra("both_timer_must_be_set", false);
            intent.putExtra("off_gone", true);
            intent.putExtra("timer_type", 1);
        } else if (intValue == 2) {
            intent.putExtra("custom_title_text", getString(R.string.plug_timer_type_off));
            intent.putExtra("both_timer_must_be_set", false);
            intent.putExtra("on_gone", true);
            intent.putExtra("timer_type", 2);
        }
        startActivity(intent);
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
    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(List list, Map map, Intent intent, DialogInterface dialogInterface, int i) {
        if (i < list.size()) {
            int intValue = ((Integer) map.get(list.get(i))).intValue();
            if (intValue == 0) {
                intent.putExtra("custom_title_text", getString(R.string.plug_timer_type_period));
                intent.putExtra("both_timer_must_be_set", true);
                intent.putExtra("timer_type", 0);
            } else if (intValue == 1) {
                intent.putExtra("custom_title_text", getString(R.string.plug_timer_type_on));
                intent.putExtra("both_timer_must_be_set", false);
                intent.putExtra("off_gone", true);
                intent.putExtra("timer_type", 1);
            } else if (intValue != 2) {
                dialogInterface.cancel();
                return;
            } else {
                intent.putExtra("custom_title_text", getString(R.string.plug_timer_type_off));
                intent.putExtra("both_timer_must_be_set", false);
                intent.putExtra("on_gone", true);
                intent.putExtra("timer_type", 2);
            }
            startActivity(intent);
        }
        dialogInterface.cancel();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || hyq.O000000o().f997O000000o != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        hyq.O000000o().O000000o(1);
        return false;
    }

    public void onBrowseMode() {
        O000000o();
        this.mAdapter.notifyDataSetChanged();
        this.O00000Oo.setVisibility(8);
        this.O00000oo.setVisibility(8);
        this.O0000OOo.setVisibility(0);
    }

    public void onManageMode() {
        this.mAdapter.notifyDataSetChanged();
        this.O00000Oo.setVisibility(0);
        this.O00000oo.setVisibility(0);
        this.O0000OOo.setVisibility(8);
        this.O00000Oo.measure(0, 0);
        this.O00000oo.measure(0, 0);
        getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.O00000Oo, View.TRANSLATION_Y, -getResources().getDimension(R.dimen.titlebar_height), 0.0f);
        ViewGroup viewGroup = (ViewGroup) this.O00000oo.getParent();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.O00000oo, View.Y, (float) viewGroup.getHeight(), (float) (viewGroup.getHeight() - this.O00000oo.getMeasuredHeight()));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
    }

    private void O000000o() {
        hyq.O000000o().O00000o0.clear();
        this.O00000o.setImageResource(R.drawable.all_select_selector);
        this.O00000o.setContentDescription(getString(R.string.select_all));
        this.mAdapter.notifyDataSetChanged();
    }

    class O00000Oo extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ CommonTimerListActivity f11229O000000o;
        private List<String> O00000Oo = new ArrayList();
        private boolean O00000o0 = true;

        public final long getItemId(int i) {
            return (long) i;
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [com.xiaomi.smarthome.scene.timer.CommonTimerListActivity, java.util.List<java.lang.String>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        public O00000Oo(List<String> r2, boolean z) {
            this.f11229O000000o = r2;
            this.O00000Oo.clear();
            this.O00000Oo.addAll(z);
            this.O00000Oo.add(this.f11229O000000o.getString(R.string.sh_common_cancel));
        }

        public final int getCount() {
            List<String> list = this.O00000Oo;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public final Object getItem(int i) {
            List<String> list = this.O00000Oo;
            if (list == null) {
                return null;
            }
            return list.get(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            O000000o o000000o;
            if (view == null) {
                view = LayoutInflater.from(this.f11229O000000o).inflate((int) R.layout.dialog_single_choice_item_center, (ViewGroup) null);
                o000000o = new O000000o(this, (byte) 0);
                o000000o.f11230O000000o = (TextView) view.findViewById(R.id.text1);
                view.setTag(o000000o);
            } else {
                o000000o = (O000000o) view.getTag();
            }
            o000000o.f11230O000000o.setText(this.O00000Oo.get(i));
            if (this.O00000o0) {
                if (i == getCount() - 1) {
                    o000000o.f11230O000000o.setTextColor(this.f11229O000000o.getResources().getColor(R.color.mj_color_gray_normal));
                    o000000o.f11230O000000o.setTextSize(14.0f);
                } else {
                    o000000o.f11230O000000o.setTextColor(this.f11229O000000o.getResources().getColor(R.color.mj_color_black));
                    o000000o.f11230O000000o.setTextSize(15.0f);
                }
            }
            return view;
        }

        class O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            TextView f11230O000000o;

            private O000000o() {
            }

            /* synthetic */ O000000o(O00000Oo o00000Oo, byte b) {
                this();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        if (hyq.O000000o().O00000o0.size() == this.mAdapter.getChildCount(0)) {
            O000000o();
        } else {
            int childCount = this.mAdapter.getChildCount(0);
            hyq.O000000o().O00000o0.clear();
            for (int i = 0; i < childCount; i++) {
                hyq.O000000o().O00000o0.put(i, true);
            }
            this.O00000o.setImageResource(R.drawable.un_select_selector);
            this.O00000o.setContentDescription(getString(R.string.unselect_all));
            this.mAdapter.notifyDataSetChanged();
            this.O00000oO.setText(getResources().getQuantityString(R.plurals.selected_cnt_tips, hyq.O000000o().O00000o0.size(), Integer.valueOf(hyq.O000000o().O00000o0.size())));
        }
        this.O00000oO.setText(getResources().getQuantityString(R.plurals.selected_cnt_tips, hyq.O000000o().O00000o0.size(), Integer.valueOf(hyq.O000000o().O00000o0.size())));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        if (hyq.O000000o().O00000o0.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f11211O000000o.O00000Oo().size(); i++) {
                if (hyq.O000000o().O00000o0.get(i)) {
                    arrayList.add(this.f11211O000000o.O00000Oo().get(i));
                }
            }
            new MLAlertDialog.Builder(this).O000000o((int) R.string.plug_timer_del).O00000Oo((int) R.string.plug_timer_del_hint).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.plug_timer_delete, new DialogInterface.OnClickListener(arrayList) {
                /* class com.xiaomi.smarthome.scene.timer.$$Lambda$CommonTimerListActivity$vOlIhsX6h2JbSOToke6EvCAu9U */
                private final /* synthetic */ List f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    CommonTimerListActivity.this.O000000o(this.f$1, dialogInterface, i);
                }
            }).O00000oo();
            return;
        }
        gqg.O00000Oo((int) R.string.no_one_selected);
    }

    class O000000o extends aya<O00000Oo, C0091O000000o> {
        public final long getChildId(int i, int i2) {
            return (long) i2;
        }

        public final long getGroupId(int i) {
            return (long) i;
        }

        public final /* bridge */ /* synthetic */ boolean onCheckCanExpandOrCollapseGroup(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3, boolean z) {
            return false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0160, code lost:
            if (r10 != false) goto L_0x0162;
         */
        public final /* synthetic */ void onBindChildViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3) {
            boolean z;
            final CommonTimer commonTimer;
            boolean z2;
            final int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9 = i;
            int i10 = i2;
            C0091O000000o o000000o = (C0091O000000o) o000OOo0;
            List<List<CommonTimer>> O00000o = CommonTimerListActivity.this.f11211O000000o.O00000o();
            List<CommonTimer> O00000Oo2 = CommonTimerListActivity.this.f11211O000000o.O00000Oo();
            if (i9 == 0) {
                if (O00000Oo2 != null && O00000Oo2.size() > 0) {
                    z = false;
                    if (O00000Oo2.size() <= i10 && commonTimer != null) {
                        o000000o.itemView.setOnClickListener(null);
                        TextView textView = o000000o.f11227O000000o;
                        TextView textView2 = o000000o.O00000Oo;
                        if (!commonTimer.O0000O0o || !commonTimer.O0000OoO) {
                            z2 = z;
                            if (commonTimer.O0000O0o && !commonTimer.O0000OoO) {
                                if (!TextUtils.isEmpty(CommonTimerListActivity.this.mStartTimeTip)) {
                                    textView.setText(CommonTimerListActivity.this.mStartTimeTip);
                                } else {
                                    textView.setText((int) R.string.plug_timer_on_time);
                                }
                                textView2.setText(CommonTimer.O000000o(CommonTimerListActivity.this, commonTimer.O0000Oo));
                            } else if (!commonTimer.O0000O0o && commonTimer.O0000OoO) {
                                if (!TextUtils.isEmpty(CommonTimerListActivity.this.mEndTimeTip)) {
                                    textView.setText(CommonTimerListActivity.this.mEndTimeTip);
                                } else {
                                    textView.setText((int) R.string.plug_timer_off_time);
                                }
                                textView2.setText(CommonTimer.O000000o(CommonTimerListActivity.this, commonTimer.O0000o0));
                            }
                        } else {
                            if (!TextUtils.isEmpty(CommonTimerListActivity.this.mTimeListTip)) {
                                textView.setText(CommonTimerListActivity.this.mTimeListTip);
                            } else {
                                textView.setText((int) R.string.plug_timer_on_period);
                            }
                            StringBuilder sb = new StringBuilder();
                            if (commonTimer.O0000Oo.O00000Oo() == 0) {
                                Calendar instance = Calendar.getInstance();
                                CorntabUtils.CorntabParam corntabParam = (CorntabUtils.CorntabParam) commonTimer.O0000Oo.clone();
                                CorntabUtils.CorntabParam corntabParam2 = (CorntabUtils.CorntabParam) commonTimer.O0000o0.clone();
                                Calendar calendar = (Calendar) instance.clone();
                                Calendar calendar2 = (Calendar) instance.clone();
                                z2 = z;
                                calendar.set(instance.get(1), instance.get(2), instance.get(5), commonTimer.O0000o0.O00000o0, commonTimer.O0000o0.O00000Oo, commonTimer.O0000o0.f11160O000000o);
                                calendar2.set(instance.get(1), instance.get(2), instance.get(5), commonTimer.O0000Oo.O00000o0, commonTimer.O0000Oo.O00000Oo, commonTimer.O0000Oo.f11160O000000o);
                                boolean before = calendar.before(calendar2);
                                if (commonTimer.O00000oo) {
                                    calendar.set(commonTimer.O0000o0.O00000oo, commonTimer.O0000o0.O00000oO - 1, commonTimer.O0000o0.O00000o, commonTimer.O0000o0.O00000o0, commonTimer.O0000o0.O00000Oo, commonTimer.O0000o0.f11160O000000o);
                                    calendar2.set(commonTimer.O0000Oo.O00000oo, commonTimer.O0000Oo.O00000oO - 1, commonTimer.O0000Oo.O00000o, commonTimer.O0000Oo.O00000o0, commonTimer.O0000Oo.O00000Oo, commonTimer.O0000Oo.f11160O000000o);
                                } else {
                                    if (!before) {
                                        if (calendar.before(instance)) {
                                            i7 = 1;
                                        }
                                        i8 = 0;
                                        i6 = 0;
                                        calendar.add(5, i7);
                                        calendar2.add(5, i6);
                                        corntabParam.O00000oo = calendar2.get(1);
                                        corntabParam2.O00000oo = calendar.get(1);
                                        corntabParam.O00000oO = calendar2.get(2) + 1;
                                        corntabParam2.O00000oO = calendar.get(2) + 1;
                                        corntabParam.O00000o = calendar2.get(5);
                                        corntabParam2.O00000o = calendar.get(5);
                                        sb.append(CommonTimer.O000000o(CommonTimerListActivity.this, corntabParam));
                                        sb.append("-");
                                        sb.append(CommonTimer.O000000o(CommonTimerListActivity.this, corntabParam2));
                                    } else if (calendar2.before(instance)) {
                                        i7 = 2;
                                    }
                                    i6 = 1;
                                    calendar.add(5, i7);
                                    calendar2.add(5, i6);
                                    corntabParam.O00000oo = calendar2.get(1);
                                    corntabParam2.O00000oo = calendar.get(1);
                                    corntabParam.O00000oO = calendar2.get(2) + 1;
                                    corntabParam2.O00000oO = calendar.get(2) + 1;
                                    corntabParam.O00000o = calendar2.get(5);
                                    corntabParam2.O00000o = calendar.get(5);
                                    sb.append(CommonTimer.O000000o(CommonTimerListActivity.this, corntabParam));
                                    sb.append("-");
                                    sb.append(CommonTimer.O000000o(CommonTimerListActivity.this, corntabParam2));
                                }
                                i8 = 1;
                                i6 = 0;
                                calendar.add(5, i7);
                                calendar2.add(5, i6);
                                corntabParam.O00000oo = calendar2.get(1);
                                corntabParam2.O00000oo = calendar.get(1);
                                corntabParam.O00000oO = calendar2.get(2) + 1;
                                corntabParam2.O00000oO = calendar.get(2) + 1;
                                corntabParam.O00000o = calendar2.get(5);
                                corntabParam2.O00000o = calendar.get(5);
                                sb.append(CommonTimer.O000000o(CommonTimerListActivity.this, corntabParam));
                                sb.append("-");
                                sb.append(CommonTimer.O000000o(CommonTimerListActivity.this, corntabParam2));
                            } else {
                                z2 = z;
                                sb.append(PlugTimer.O000000o(CommonTimerListActivity.this.getContext(), commonTimer.O0000Oo, commonTimer.O0000o0, true, commonTimer.O0000Oo.O00000o0, commonTimer.O0000Oo.O00000Oo, true));
                                sb.append("-");
                                sb.append(PlugTimer.O000000o(CommonTimerListActivity.this.getContext(), commonTimer.O0000Oo, commonTimer.O0000o0, true, commonTimer.O0000o0.O00000o0, commonTimer.O0000o0.O00000Oo, false));
                                textView2.setText(sb.toString());
                            }
                            textView2.setText(sb.toString());
                        }
                        TextView textView3 = o000000o.O00000o0;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(" |   ");
                        if (commonTimer.O0000O0o) {
                            sb2.append(O000000o(commonTimer.O0000Oo));
                        } else {
                            sb2.append(O000000o(commonTimer.O0000o0));
                        }
                        if (commonTimer.O00000oo) {
                            if (commonTimer.O0000Oo.O00000Oo() == 0) {
                                sb2.append(" |   ");
                                CommonTimerListActivity commonTimerListActivity = CommonTimerListActivity.this;
                                sb2.append(commonTimer.O000000o(commonTimerListActivity, commonTimerListActivity.getString(R.string.plug_timer_on), CommonTimerListActivity.this.getString(R.string.plug_timer_off)));
                            }
                        } else if (commonTimer.O0000Oo.O00000Oo() == 0) {
                            sb2.append(" |   ");
                            CommonTimerListActivity commonTimerListActivity2 = CommonTimerListActivity.this;
                            sb2.append(commonTimer.O000000o(commonTimerListActivity2, commonTimerListActivity2.getString(R.string.plug_timer_on), CommonTimerListActivity.this.getString(R.string.plug_timer_off)));
                        }
                        textView3.setText(sb2.toString());
                        SwitchButton switchButton = o000000o.O00000o;
                        View view = o000000o.O00000oo;
                        switchButton.setOnCheckedChangeListener(null);
                        switchButton.setChecked(commonTimer.O00000oo);
                        final int adapterPosition = o000000o.getAdapterPosition();
                        int i11 = i;
                        if (i11 == getGroupCount() - 1) {
                            i4 = i2;
                            if (i4 == getChildCount(i11) - 1) {
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) o000000o.O0000OOo.getLayoutParams();
                                layoutParams.setMargins(0, 0, 0, 0);
                                o000000o.O0000OOo.setLayoutParams(layoutParams);
                            }
                        } else {
                            i4 = i2;
                        }
                        final CommonTimer commonTimer2 = commonTimer;
                        final C0091O000000o o000000o2 = o000000o;
                        final SwitchButton switchButton2 = switchButton;
                        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            /* class com.xiaomi.smarthome.scene.timer.CommonTimerListActivity.O000000o.AnonymousClass2 */

                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                                CommonTimerListActivity.this.mXQProgressDialog.show();
                                CommonTimerListActivity.this.f11211O000000o.O000000o(commonTimer2, z, new hrf.O00000Oo() {
                                    /* class com.xiaomi.smarthome.scene.timer.CommonTimerListActivity.O000000o.AnonymousClass2.AnonymousClass1 */

                                    public final void onGetSceneFailed(int i) {
                                    }

                                    public final void onGetSceneSuccess() {
                                    }

                                    public final void onSetSceneSuccess(CommonTimer commonTimer) {
                                    }

                                    public final void onSetSceneFailed(fso fso) {
                                        if (fso == null || fso.f17063O000000o != -1 || CommonTimerListActivity.this.mDevice.isOwner()) {
                                            gqg.O00000Oo((int) R.string.plug_timer_set_fail);
                                        } else {
                                            gqg.O00000Oo((int) R.string.gateway_user_cant_not_access);
                                        }
                                        if (o000000o2.getAdapterPosition() == adapterPosition) {
                                            switchButton2.setOnCheckedChangeListener(null);
                                            switchButton2.setChecked(!switchButton2.isChecked());
                                            switchButton2.setOnCheckedChangeListener(this);
                                        }
                                    }
                                }, CommonTimerListActivity.this.mTimerIdentifyRn);
                            }
                        });
                        if (z2) {
                            switchButton.setVisibility(8);
                            o000000o.O00000oO.setVisibility(8);
                            o000000o.O0000O0o.setVisibility(8);
                            i5 = 0;
                            o000000o.itemView.setClickable(false);
                            o000000o.itemView.setOnLongClickListener(null);
                            o000000o.itemView.setBackgroundColor(0);
                        } else {
                            o000000o.itemView.setClickable(true);
                            o000000o.itemView.setTag(o000000o);
                            o000000o.itemView.setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.timer.CommonTimerListActivity.O000000o.AnonymousClass3 */

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
                                public final void onClick(View view) {
                                    C0091O000000o o000000o = (C0091O000000o) view.getTag();
                                    boolean z = hyq.O000000o().O00000o0.get(i4);
                                    if (hyq.O000000o().f997O000000o == 0) {
                                        if (z) {
                                            o000000o.O00000oO.setChecked(false);
                                            hyq.O000000o().O00000o0.delete(i4);
                                        } else {
                                            o000000o.O00000oO.setChecked(true);
                                            hyq.O000000o().O00000o0.put(i4, true);
                                        }
                                        if (hyq.O000000o().O00000o0.size() == CommonTimerListActivity.this.mAdapter.getChildCount(0)) {
                                            CommonTimerListActivity.this.O00000o.setImageResource(R.drawable.un_select_selector);
                                            CommonTimerListActivity.this.O00000o.setContentDescription(CommonTimerListActivity.this.getString(R.string.unselect_all));
                                        } else {
                                            CommonTimerListActivity.this.O00000o.setImageResource(R.drawable.all_select_selector);
                                            CommonTimerListActivity.this.O00000o.setContentDescription(CommonTimerListActivity.this.getString(R.string.select_all));
                                        }
                                        CommonTimerListActivity.this.O00000oO.setText(CommonTimerListActivity.this.getResources().getQuantityString(R.plurals.selected_cnt_tips, hyq.O000000o().O00000o0.size(), Integer.valueOf(hyq.O000000o().O00000o0.size())));
                                        O000000o.this.notifyDataSetChanged();
                                        return;
                                    }
                                    Intent intent = new Intent(CommonTimerListActivity.this, SetTimerCommonActivity.class);
                                    if (CommonTimerListActivity.this.f11211O000000o instanceof hre) {
                                        intent.putExtra("is_group", true);
                                    }
                                    intent.putExtra("common.timer", commonTimer);
                                    intent.putExtra("custom_title_text", CommonTimerListActivity.this.mCustomName);
                                    intent.putExtra("action.add.common.timer", false);
                                    intent.putExtra("timer_identify_rn", CommonTimerListActivity.this.mTimerIdentifyRn);
                                    intent.putExtra("both_timer_must_be_set", CommonTimerListActivity.this.mForceBothTimerSet);
                                    intent.putExtra("on_timer_tips", CommonTimerListActivity.this.mStartTimeTip);
                                    intent.putExtra("off_timer_tips", CommonTimerListActivity.this.mEndTimeTip);
                                    if (CommonTimerListActivity.this.mForceBothTimerSet) {
                                        intent.putExtra("timer_type", 0);
                                    } else if (commonTimer.O0000O0o && commonTimer.O0000OoO) {
                                        intent.putExtra("timer_type", 0);
                                    } else if (commonTimer.O0000O0o && !commonTimer.O0000OoO) {
                                        intent.putExtra("timer_type", 1);
                                    } else if (!commonTimer.O0000O0o && commonTimer.O0000OoO) {
                                        intent.putExtra("timer_type", 2);
                                    }
                                    CommonTimerListActivity.this.startActivity(intent);
                                }
                            });
                            if (hyq.O000000o().f997O000000o == 0) {
                                o000000o.itemView.setOnLongClickListener(null);
                            } else {
                                o000000o.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                                    /* class com.xiaomi.smarthome.scene.timer.CommonTimerListActivity.O000000o.AnonymousClass4 */

                                    public final boolean onLongClick(View view) {
                                        if (hyq.O000000o().f997O000000o == 1 && !CommonTimerListActivity.this.O0000Oo0.isRefreshing()) {
                                            hyq.O000000o().O000000o(0);
                                            view.performClick();
                                        }
                                        return true;
                                    }
                                });
                            }
                            if (hyq.O000000o().f997O000000o == 0) {
                                switchButton.setVisibility(8);
                                o000000o.O00000oO.setVisibility(0);
                            } else {
                                switchButton.setVisibility(0);
                                o000000o.O00000oO.setVisibility(8);
                            }
                            if (hyq.O000000o().O00000o0.get(i4)) {
                                o000000o.O00000oO.setChecked(true);
                                i5 = 0;
                            } else {
                                i5 = 0;
                                o000000o.O00000oO.setChecked(false);
                            }
                            o000000o.O0000O0o.setVisibility(8);
                        }
                        if (hyq.O000000o().f997O000000o == 0) {
                            switchButton.setVisibility(8);
                            view.setVisibility(8);
                            o000000o.O00000oO.setVisibility(i5);
                            return;
                        } else if (commonTimer.O0000o0o == 0) {
                            switchButton.setVisibility(i5);
                            view.setVisibility(8);
                            return;
                        } else {
                            switchButton.setVisibility(8);
                            view.setVisibility(i5);
                            view.setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.timer.CommonTimerListActivity.O000000o.AnonymousClass5 */

                                public final void onClick(View view) {
                                    CommonTimerListActivity.this.showTimerLastOperationFailDialog(commonTimer);
                                }
                            });
                            return;
                        }
                    }
                } else if (O00000o != null) {
                    O00000Oo2 = O00000o.get(i9);
                } else {
                    return;
                }
            } else if (O00000o == null) {
                return;
            } else {
                if (O00000Oo2 == null || O00000Oo2.size() <= 0) {
                    O00000Oo2 = O00000o.get(i9);
                } else {
                    O00000Oo2 = O00000o.get(i9 - 1);
                }
            }
            z = true;
            if (O00000Oo2.size() <= i10) {
                commonTimer = O00000Oo2.get(i10);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
            r3 = (com.xiaomi.smarthome.scene.timer.CommonTimer) r3.get(0);
         */
        public final /* synthetic */ void onBindGroupViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, int i2) {
            List list;
            final CommonTimer commonTimer;
            O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            if (i2 != 1) {
                List<List<CommonTimer>> O00000o = CommonTimerListActivity.this.f11211O000000o.O00000o();
                List<CommonTimer> O00000Oo2 = CommonTimerListActivity.this.f11211O000000o.O00000Oo();
                if (O00000o != null) {
                    if (O00000Oo2 != null && O00000Oo2.size() > 0) {
                        i--;
                    }
                    if (i >= 0 && O00000o.size() > i && (list = O00000o.get(i)) != null && list.size() != 0 && commonTimer != null) {
                        Device O000000o2 = fno.O000000o().O000000o(commonTimer.O00000o0);
                        o00000Oo.f11228O000000o.setText(O000000o2 == null ? commonTimer.O00000o0 : O000000o2.getName());
                        o00000Oo.itemView.findViewById(R.id.smart_group_header_root).setOnClickListener(new View.OnClickListener() {
                            /* class com.xiaomi.smarthome.scene.timer.CommonTimerListActivity.O000000o.AnonymousClass1 */

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
                            public final void onClick(View view) {
                                Intent intent = new Intent(CommonTimerListActivity.this, CommonTimerListActivity.class);
                                intent.putExtra("common_timer_device_id", commonTimer.O00000o0);
                                intent.putExtra("on_method", CommonTimerListActivity.this.mOnMethod);
                                intent.putExtra("on_param", CommonTimerListActivity.this.mOnParam);
                                intent.putExtra("off_method", CommonTimerListActivity.this.mOffMethod);
                                intent.putExtra("off_param", CommonTimerListActivity.this.mOffParam);
                                intent.putExtra("action_common_timer_name", CommonTimerListActivity.this.mTimerName);
                                intent.putExtra("timer_identify_rn", CommonTimerListActivity.this.mTimerIdentifyRn);
                                intent.putExtra("common_timer_display_name", CommonTimerListActivity.this.mTimerDisplayName);
                                Device O000000o2 = fno.O000000o().O000000o(commonTimer.O00000o0);
                                intent.putExtra("timer_manager", O000000o2 == null ? CommonTimerListActivity.this.mTimerDisplayName : O000000o2.getName());
                                intent.putExtra("shouldIncludeGroup", false);
                                CommonTimerListActivity.this.startActivity(intent);
                            }
                        });
                    }
                }
            }
        }

        public O000000o() {
            setHasStableIds(true);
        }

        public final int getGroupCount() {
            List<List<CommonTimer>> O00000o = CommonTimerListActivity.this.f11211O000000o.O00000o();
            List<CommonTimer> O00000Oo2 = CommonTimerListActivity.this.f11211O000000o.O00000Oo();
            int i = 1;
            if (O00000o == null) {
                return (O00000Oo2 == null || O00000Oo2.size() == 0) ? 0 : 1;
            }
            int size = O00000o.size();
            if (O00000Oo2 == null || O00000Oo2.size() == 0) {
                i = 0;
            }
            return size + i;
        }

        public final int getChildCount(int i) {
            List list;
            List<List<CommonTimer>> O00000o = CommonTimerListActivity.this.f11211O000000o.O00000o();
            List<CommonTimer> O00000Oo2 = CommonTimerListActivity.this.f11211O000000o.O00000Oo();
            if (i == 0 && O00000Oo2 != null && O00000Oo2.size() > 0) {
                return O00000Oo2.size();
            }
            if (O00000o == null) {
                return 0;
            }
            if (O00000Oo2 != null && O00000Oo2.size() > 0) {
                i--;
            }
            if (i < 0 || i >= O00000o.size() || (list = O00000o.get(i)) == null) {
                return 0;
            }
            return list.size();
        }

        public final int getGroupItemViewType(int i) {
            List<CommonTimer> O00000Oo2 = CommonTimerListActivity.this.f11211O000000o.O00000Oo();
            if (O00000Oo2 == null || O00000Oo2.size() == 0 || i != 0) {
                return 0;
            }
            return 1;
        }

        private String O000000o(CorntabUtils.CorntabParam corntabParam) {
            if (corntabParam.O00000Oo() == 0) {
                return CommonTimerListActivity.this.getString(R.string.plug_timer_onetime);
            }
            return corntabParam.O000000o((Context) CommonTimerListActivity.this);
        }

        public class O00000Oo extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            TextView f11228O000000o;

            public O00000Oo(View view) {
                super(view);
                this.f11228O000000o = (TextView) view.findViewById(R.id.txt_group_title);
            }
        }

        /* renamed from: com.xiaomi.smarthome.scene.timer.CommonTimerListActivity$O000000o$O000000o  reason: collision with other inner class name */
        public class C0091O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            TextView f11227O000000o;
            TextView O00000Oo;
            SwitchButton O00000o;
            TextView O00000o0;
            CheckBox O00000oO;
            View O00000oo;
            View O0000O0o;
            View O0000OOo;

            public C0091O000000o(View view) {
                super(view);
                this.f11227O000000o = (TextView) view.findViewById(R.id.tv_on);
                this.O00000Oo = (TextView) view.findViewById(R.id.tv_on_time);
                this.O00000o0 = (TextView) view.findViewById(R.id.tv_repeat);
                this.O00000o = (SwitchButton) view.findViewById(R.id.sb_timer);
                this.O00000oo = view.findViewById(R.id.err_btn);
                this.O0000O0o = view.findViewById(R.id.group_indicator);
                this.O0000OOo = view.findViewById(R.id.divider);
                this.O00000oO = (CheckBox) view.findViewById(R.id.ckb_edit_selected);
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateChildViewHolder(ViewGroup viewGroup, int i) {
            return new C0091O000000o(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.plug_timer_item, viewGroup, false));
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateGroupViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.timer_list_header_layout, viewGroup, false);
            if (i == 1) {
                inflate.getLayoutParams().height = 0;
            }
            return new O00000Oo(inflate);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(List list, DialogInterface dialogInterface, int i) {
        this.mXQProgressDialog.show();
        this.f11211O000000o.O000000o(list, new hrf.O00000Oo() {
            /* class com.xiaomi.smarthome.scene.timer.CommonTimerListActivity.AnonymousClass4 */

            public final void onGetSceneFailed(int i) {
            }

            public final void onGetSceneSuccess() {
            }

            public final void onSetSceneSuccess(CommonTimer commonTimer) {
                hyq.O000000o().O000000o(1);
                CommonTimerListActivity.this.O0000Oo0.autoRefresh();
            }

            public final void onSetSceneFailed(fso fso) {
                if (!fjz.O000000o().O00000o0()) {
                    gqg.O00000Oo(CommonTimerListActivity.this.getString(R.string.phone_wifi_error));
                }
            }
        });
    }

    public void showTimerLastOperationFailDialog(final CommonTimer commonTimer) {
        DialogInterface.OnClickListener onClickListener;
        MLAlertDialog.Builder O00000Oo2 = new MLAlertDialog.Builder(this).O00000Oo((int) R.string.mj_i_know, (DialogInterface.OnClickListener) null);
        if (commonTimer.O0000o0o == -1) {
            O00000Oo2.O00000Oo((int) R.string.set_timer_fail_delete);
            onClickListener = new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.timer.CommonTimerListActivity.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    CommonTimerListActivity.this.mXQProgressDialog.show();
                    CommonTimerListActivity.this.f11211O000000o.O00000o0(commonTimer);
                }
            };
        } else if (commonTimer.O0000o0o == 1) {
            O00000Oo2.O00000Oo((int) R.string.set_timer_fail_disable);
            onClickListener = new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.timer.CommonTimerListActivity.AnonymousClass6 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.hrf.O000000o(com.xiaomi.smarthome.scene.timer.CommonTimer, boolean, _m_j.hrf$O00000Oo, java.lang.String):void
                 arg types: [com.xiaomi.smarthome.scene.timer.CommonTimer, int, com.xiaomi.smarthome.scene.timer.CommonTimerListActivity$6$1, java.lang.String]
                 candidates:
                  _m_j.hrf.O000000o(com.xiaomi.smarthome.scene.timer.CommonTimer, com.xiaomi.smarthome.scene.timer.CommonTimer, _m_j.hrf$O00000Oo, java.lang.String):void
                  _m_j.hrf.O000000o(com.xiaomi.smarthome.scene.timer.CommonTimer, boolean, _m_j.hrf$O00000Oo, java.lang.String):void */
                public final void onClick(DialogInterface dialogInterface, int i) {
                    CommonTimerListActivity.this.mXQProgressDialog.show();
                    CommonTimerListActivity.this.f11211O000000o.O000000o(commonTimer, false, (hrf.O00000Oo) new hrf.O00000Oo() {
                        /* class com.xiaomi.smarthome.scene.timer.CommonTimerListActivity.AnonymousClass6.AnonymousClass1 */

                        public final void onGetSceneFailed(int i) {
                        }

                        public final void onGetSceneSuccess() {
                        }

                        public final void onSetSceneFailed(fso fso) {
                        }

                        public final void onSetSceneSuccess(CommonTimer commonTimer) {
                            CommonTimerListActivity.this.mWrappedAdapter.notifyDataSetChanged();
                        }
                    }, CommonTimerListActivity.this.mTimerIdentifyRn);
                }
            };
        } else {
            O00000Oo2.O00000Oo((int) R.string.set_timer_fail_edit);
            onClickListener = new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.timer.CommonTimerListActivity.AnonymousClass7 */

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
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(CommonTimerListActivity.this, SetTimerCommonActivity.class);
                    if (CommonTimerListActivity.this.f11211O000000o instanceof hre) {
                        intent.putExtra("is_group", true);
                    }
                    intent.putExtra("common.timer", commonTimer);
                    intent.putExtra("custom_title_text", CommonTimerListActivity.this.mCustomName);
                    intent.putExtra("timer_identify_rn", CommonTimerListActivity.this.mTimerIdentifyRn);
                    intent.putExtra("both_timer_must_be_set", CommonTimerListActivity.this.mForceBothTimerSet);
                    intent.putExtra("on_timer_tips", CommonTimerListActivity.this.mStartTimeTip);
                    intent.putExtra("off_timer_tips", CommonTimerListActivity.this.mEndTimeTip);
                    CommonTimerListActivity.this.startActivity(intent);
                }
            };
        }
        O00000Oo2.O000000o((int) R.string.mj_retry, onClickListener);
        O00000Oo2.O00000oo();
    }

    public void onGetSceneSuccess() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
    }

    public void onGetSceneFailed(int i) {
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void onSetSceneSuccess(CommonTimer commonTimer) {
        Message obtainMessage = this.mHandler.obtainMessage(3);
        obtainMessage.obj = commonTimer;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void onSetSceneFailed(fso fso) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public static boolean isGroupDevice(Device device) {
        List<fni> allModelGroups = fnn.O000000o().f16706O000000o.getAllModelGroups();
        if (!(allModelGroups == null || allModelGroups.size() == 0)) {
            for (int i = 0; i < allModelGroups.size(); i++) {
                fni fni = allModelGroups.get(i);
                if (!(fni == null || fni.O00000o0 == null || fni.O00000o0.length == 0)) {
                    for (String equals : fni.O00000o0) {
                        if (TextUtils.equals(equals, device.model)) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }
}

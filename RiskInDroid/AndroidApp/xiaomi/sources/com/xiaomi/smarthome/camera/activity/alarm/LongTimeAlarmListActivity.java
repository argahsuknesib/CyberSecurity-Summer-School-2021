package com.xiaomi.smarthome.camera.activity.alarm;

import _m_j.awp;
import _m_j.chy;
import _m_j.gqg;
import _m_j.gqq;
import _m_j.gwg;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.activity.setting.LongTimeAlarm;
import com.xiaomi.smarthome.camera.activity.setting.LongTimeAlarmManager;
import com.xiaomi.smarthome.camera.activity.setting.ModeChangedListener;
import com.xiaomi.smarthome.camera.activity.setting.ModeController;
import com.xiaomi.smarthome.camera.activity.setting.SetLongTimeAlarmActivity;
import com.xiaomi.smarthome.camera.activity.utils.SpecConstantUtils;
import com.xiaomi.smarthome.camera.view.recycle.BaseViewHolder;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.DevicePtrFrameLayout;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.indicator.PtrIndicator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LongTimeAlarmListActivity extends CameraBaseActivity implements LongTimeAlarmManager.LongTimeAlarmListener, ModeChangedListener {
    private String TAG = LongTimeAlarmListActivity.class.getCanonicalName();
    View emptyAddTimer;
    boolean isPullRefresh = false;
    public RecyclerTimerAdapter mAdapter;
    View mBottomDeleteBar;
    View mBottomDeleteBtn;
    View mCancelBtn;
    ImageView mIvSelectAll;
    public RecyclerView.LayoutManager mLayoutManager;
    private PtrIndicator mPtrIndicator;
    DevicePtrFrameLayout mPullRefresh;
    private RecyclerView mRecyclerView;
    TextView mSelectCountText;
    List<LongTimeAlarm> mTimerList = new ArrayList();
    private View mTimerView;
    View mTopManageBar;
    public XQProgressDialog mXQProgressDialog;

    public void onAlarmValueUpdateFailed(int i, String str) {
    }

    public static void startLongTimeAlarmListActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, LongTimeAlarmListActivity.class);
        intent.putExtra("extra_device_did", str);
        activity.startActivity(intent);
    }

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.activity_long_time_alarm_list);
        ModeController.getInstance().setModeChangedListener(this);
        initUI();
        getData();
    }

    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: package-private */
    public void initUI() {
        initProgressDialog();
        initTitleView();
        initVpTimer();
        this.mTimerView = findViewById(R.id.rl_timer_list_view);
        this.mTimerView.setVisibility(0);
        this.emptyAddTimer = findViewById(R.id.add_timer_id);
        this.emptyAddTimer.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.LongTimeAlarmListActivity.AnonymousClass1 */

            public void onClick(View view) {
                if (!LongTimeAlarmListActivity.this.mCameraDevice.isOwner()) {
                    gqg.O00000Oo((int) R.string.gateway_user_cant_not_access);
                } else if (LongTimeAlarmListActivity.this.mTimerList == null || LongTimeAlarmListActivity.this.mTimerList.size() >= 10) {
                    gqg.O00000Oo((int) R.string.long_time_alarm_limit_tips);
                } else {
                    LongTimeAlarmListActivity.this.showTimerTypeDialog();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void initProgressDialog() {
        this.mXQProgressDialog = new XQProgressDialog(this);
        this.mXQProgressDialog.setMessage(getString(R.string.gateway_magnet_location_updating));
        this.mXQProgressDialog.setCancelable(true);
    }

    public void showTimerTypeDialog() {
        Intent intent = new Intent(this, SetLongTimeAlarmActivity.class);
        intent.putExtra("key_timer", new LongTimeAlarm());
        intent.putExtra("key_position", -1);
        startActivityForResult(intent, 1000);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || ModeController.getInstance().mCurrentMode != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        ModeController.getInstance().changeMode(1);
        return false;
    }

    /* access modifiers changed from: package-private */
    public void getData() {
        loadPropertiesFromServer(SpecConstantUtils.ChuangmiClocksSpecKV(this.mCameraDevice.getModel()), new Callback<List<PropertyParam>>() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.LongTimeAlarmListActivity.AnonymousClass2 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<PropertyParam>) ((List) obj));
            }

            public void onSuccess(List<PropertyParam> list) {
                if (!LongTimeAlarmListActivity.this.isFinishing()) {
                    Object propertyValueFromCache = LongTimeAlarmListActivity.this.getPropertyValueFromCache(LongTimeAlarmManager.LONG_TIME_SPEC_S, LongTimeAlarmManager.LONG_TIME_SPEC_P);
                    if (propertyValueFromCache != null) {
                        String str = (String) propertyValueFromCache;
                        if (!"".equals(str)) {
                            LongTimeAlarmListActivity.this.onUpdateSuccess(LongTimeAlarmManager.parseTimerList(str));
                            LongTimeAlarmListActivity longTimeAlarmListActivity = LongTimeAlarmListActivity.this;
                            LongTimeAlarmManager.getAlarmKey(longTimeAlarmListActivity, longTimeAlarmListActivity.mCameraDevice.getDid(), LongTimeAlarmListActivity.this);
                            return;
                        }
                    }
                    String model = LongTimeAlarmListActivity.this.mCameraDevice.getModel();
                    String did = LongTimeAlarmListActivity.this.mCameraDevice.getDid();
                    chy chy = LongTimeAlarmListActivity.this.mCameraSpecDevice;
                    LongTimeAlarmListActivity longTimeAlarmListActivity2 = LongTimeAlarmListActivity.this;
                    LongTimeAlarmManager.addDefaultTimer(model, did, chy, longTimeAlarmListActivity2, longTimeAlarmListActivity2);
                }
            }

            public void onFailure(int i, String str) {
                if (!LongTimeAlarmListActivity.this.isFinishing()) {
                    LongTimeAlarmListActivity.this.onUpdateFailed(i, str);
                }
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.setItemAnimator(null);
            this.mRecyclerView.setAdapter(null);
            this.mRecyclerView = null;
        }
        this.mLayoutManager = null;
    }

    public void onNormalMode() {
        unSelectAll();
        this.mAdapter.notifyDataSetChanged();
        this.mTopManageBar.setVisibility(8);
        this.mBottomDeleteBar.setVisibility(8);
        this.emptyAddTimer.setVisibility(0);
    }

    public void onEditMode() {
        this.mAdapter.notifyDataSetChanged();
        this.mTopManageBar.setVisibility(0);
        this.mBottomDeleteBar.setVisibility(0);
        this.emptyAddTimer.setVisibility(8);
        this.mTopManageBar.measure(0, 0);
        this.mBottomDeleteBar.measure(0, 0);
        getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mTopManageBar, View.TRANSLATION_Y, -getResources().getDimension(R.dimen.titlebar_height), 0.0f);
        ViewGroup viewGroup = (ViewGroup) this.mBottomDeleteBar.getParent();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mBottomDeleteBar, View.Y, (float) viewGroup.getHeight(), (float) (viewGroup.getHeight() - this.mBottomDeleteBar.getMeasuredHeight()));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
    }

    public void onUpdateSuccess() {
        if (!isFinishing()) {
            final List<LongTimeAlarm> parseTimerList = LongTimeAlarmManager.parseTimerList((String) getPropertyValueFromCache(LongTimeAlarmManager.LONG_TIME_SPEC_S, LongTimeAlarmManager.LONG_TIME_SPEC_P));
            runOnUiThread(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.alarm.LongTimeAlarmListActivity.AnonymousClass3 */

                public void run() {
                    LongTimeAlarmListActivity.this.onUpdateSuccess(parseTimerList);
                }
            });
        }
    }

    public void onUpdateSuccess(List<LongTimeAlarm> list) {
        this.mTimerList.clear();
        this.mTimerList.addAll(list);
        this.mAdapter.notifyDataSetChanged();
        this.mXQProgressDialog.dismiss();
        this.mPullRefresh.refreshComplete();
    }

    public void onUpdateFailed(int i, String str) {
        if (!isFinishing()) {
            this.mPullRefresh.refreshComplete();
            this.mXQProgressDialog.dismiss();
        }
    }

    public void onAlarmValueUpdateSuccess(Map<Integer, String> map) {
        if (!isFinishing()) {
            for (LongTimeAlarm next : this.mTimerList) {
                if (map.containsKey(Integer.valueOf(next.key))) {
                    next.alarmValue = map.get(Integer.valueOf(next.key));
                }
            }
            runOnUiThread(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.alarm.LongTimeAlarmListActivity.AnonymousClass4 */

                public void run() {
                    LongTimeAlarmListActivity.this.mAdapter.notifyDataSetChanged();
                }
            });
        }
    }

    public void onAlarmValueSetSuccess() {
        LongTimeAlarmManager.getAlarmKey(this, this.mCameraDevice.getDid(), this);
    }

    /* access modifiers changed from: package-private */
    public void unSelectAll() {
        ModeController.getInstance().mCheckedItems.clear();
        this.mIvSelectAll.setImageResource(R.drawable.all_select_selector);
        this.mIvSelectAll.setContentDescription(getString(R.string.select_all));
        this.mAdapter.notifyDataSetChanged();
    }

    /* access modifiers changed from: package-private */
    public void selectAll() {
        int itemCount = this.mAdapter.getItemCount() - 2;
        ModeController.getInstance().mCheckedItems.clear();
        for (int i = 0; i < itemCount; i++) {
            ModeController.getInstance().mCheckedItems.put(i, true);
        }
        this.mIvSelectAll.setImageResource(R.drawable.un_select_selector);
        this.mIvSelectAll.setContentDescription(getString(R.string.unselect_all));
        this.mAdapter.notifyDataSetChanged();
        this.mSelectCountText.setText(getResources().getQuantityString(R.plurals.selected_cnt_tips, ModeController.getInstance().mCheckedItems.size(), Integer.valueOf(ModeController.getInstance().mCheckedItems.size())));
    }

    private void initTitleView() {
        View findViewById = findViewById(R.id.module_a_3_return_btn);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.alarm.LongTimeAlarmListActivity.AnonymousClass5 */

                public void onClick(View view) {
                    LongTimeAlarmListActivity.this.finish();
                }
            });
        }
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        if (textView != null) {
            textView.setText((int) R.string.settings_alarm_long_time);
        }
        this.mTopManageBar = findViewById(R.id.top_delete_bar);
        if (gwg.O000000o((Activity) this)) {
            this.mTopManageBar.getLayoutParams().height += gwg.O00000Oo(this);
            View view = this.mTopManageBar;
            view.setPadding(0, view.getPaddingTop() + gwg.O00000Oo(this), 0, 0);
            View view2 = this.mTopManageBar;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        this.mSelectCountText = (TextView) findViewById(R.id.selected_cnt);
        this.mCancelBtn = findViewById(R.id.cancel_btn);
        this.mCancelBtn.setOnClickListener($$Lambda$LongTimeAlarmListActivity$dEVACkvm7vRM81lijbRppg5ajg.INSTANCE);
        this.mIvSelectAll = (ImageView) findViewById(R.id.select_all_btn);
        this.mIvSelectAll.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$LongTimeAlarmListActivity$hiOlyfvBeTORw6AQ0ZxkUCHM */

            public final void onClick(View view) {
                LongTimeAlarmListActivity.this.lambda$initTitleView$1$LongTimeAlarmListActivity(view);
            }
        });
        this.mBottomDeleteBar = findViewById(R.id.bottom_delete_bar);
        this.mBottomDeleteBtn = findViewById(R.id.delete_msg_btn);
        this.mBottomDeleteBar.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$LongTimeAlarmListActivity$EVaoVPRQGGFkGyqMAd4OyhkP95U */

            public final void onClick(View view) {
                LongTimeAlarmListActivity.this.lambda$initTitleView$2$LongTimeAlarmListActivity(view);
            }
        });
    }

    public /* synthetic */ void lambda$initTitleView$1$LongTimeAlarmListActivity(View view) {
        if (ModeController.getInstance().mCheckedItems.size() == this.mAdapter.getItemCount() - 2) {
            unSelectAll();
        } else {
            selectAll();
        }
        this.mSelectCountText.setText(getResources().getQuantityString(R.plurals.selected_cnt_tips, ModeController.getInstance().mCheckedItems.size(), Integer.valueOf(ModeController.getInstance().mCheckedItems.size())));
    }

    public /* synthetic */ void lambda$initTitleView$2$LongTimeAlarmListActivity(View view) {
        if (ModeController.getInstance().mCheckedItems.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.mTimerList.size(); i++) {
                if (ModeController.getInstance().mCheckedItems.get(i)) {
                    arrayList.add(this.mTimerList.get(i));
                }
            }
            deleteTimer(arrayList);
            return;
        }
        gqg.O00000Oo((int) R.string.no_one_selected);
    }

    private void initVpTimer() {
        this.mPtrIndicator = new PtrIndicator();
        this.mPullRefresh = (DevicePtrFrameLayout) findViewById(R.id.pull_down_refresh);
        this.mPullRefresh.setPtrHandler(new PtrDefaultHandler() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.LongTimeAlarmListActivity.AnonymousClass6 */

            public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                if (ModeController.getInstance().mCurrentMode == 0) {
                    LongTimeAlarmListActivity.this.mPullRefresh.refreshComplete();
                    return;
                }
                LongTimeAlarmListActivity longTimeAlarmListActivity = LongTimeAlarmListActivity.this;
                longTimeAlarmListActivity.isPullRefresh = true;
                longTimeAlarmListActivity.getData();
            }

            public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
                if (Build.VERSION.SDK_INT < 14) {
                    if (!(view instanceof AbsListView)) {
                        return view instanceof RecyclerView ? ((LinearLayoutManager) LongTimeAlarmListActivity.this.mLayoutManager).findFirstCompletelyVisibleItemPosition() - 1 < 0 : view.getScrollY() > 0;
                    }
                    AbsListView absListView = (AbsListView) view;
                    return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
                } else if (view instanceof RecyclerView) {
                    return ((LinearLayoutManager) LongTimeAlarmListActivity.this.mLayoutManager).findFirstCompletelyVisibleItemPosition() - 1 < 0;
                } else {
                    return view.canScrollVertically(-1);
                }
            }
        });
        this.mPullRefresh.disableWhenHorizontalMove(true);
        this.mPullRefresh.setPtrIndicator(this.mPtrIndicator);
        this.mPullRefresh.addPtrUIHandler(new gqq());
        this.mRecyclerView = (RecyclerView) findViewById(R.id.device_grid_view);
        this.mRecyclerView.setOverScrollMode(2);
        this.mLayoutManager = new LinearLayoutManager(getContext());
        this.mAdapter = new RecyclerTimerAdapter();
        awp awp = new awp();
        awp.O0000o00 = false;
        this.mRecyclerView.setLayoutManager(this.mLayoutManager);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setItemAnimator(awp);
        this.mRecyclerView.setHasFixedSize(false);
        this.mRecyclerView.setOverScrollMode(2);
    }

    class RecyclerTimerAdapter extends RecyclerView.O000000o<BaseViewHolder> {
        final int FOOT_TYPE = 2;
        final int HEAD_TYPE = 1;
        final int ITEM_TYPE = 3;

        public RecyclerTimerAdapter() {
            setHasStableIds(true);
        }

        public int getItemCount() {
            if (LongTimeAlarmListActivity.this.mTimerList != null) {
                return LongTimeAlarmListActivity.this.mTimerList.size() + 2;
            }
            return 2;
        }

        public int getItemViewType(int i) {
            if (i == 0) {
                return 1;
            }
            return getItemCount() - 1 == i ? 2 : 3;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            if (1 == i) {
                return new BaseViewHolder(from.inflate((int) R.layout.long_time_alarm_header, viewGroup, false));
            }
            if (2 == i) {
                return new BaseViewHolder(from.inflate((int) R.layout.long_time_alarm_foot, viewGroup, false));
            }
            return new ChildViewHolder(from.inflate((int) R.layout.long_time_timer_item, viewGroup, false));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
            r9 = r7.this$0.mTimerList.get(r9 - 1);
         */
        public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
            final LongTimeAlarm longTimeAlarm;
            if (i != 0 && i != getItemCount() - 1 && longTimeAlarm != null) {
                final ChildViewHolder childViewHolder = (ChildViewHolder) baseViewHolder;
                childViewHolder.itemView.setOnClickListener(null);
                childViewHolder.itemView.setBackground(null);
                TextView textView = childViewHolder.tvOn;
                TextView textView2 = childViewHolder.tvOnTime;
                textView.setText(longTimeAlarm.alarmValue);
                StringBuilder sb = new StringBuilder();
                sb.append(longTimeAlarm.time_start);
                sb.append("-");
                if (longTimeAlarm.time_end.compareTo(longTimeAlarm.time_start) < 0) {
                    sb.append(childViewHolder.itemView.getContext().getString(R.string.plug_timer_set_nextday));
                    sb.append(" ");
                }
                sb.append(longTimeAlarm.time_end);
                textView2.setText(sb.toString());
                TextView textView3 = childViewHolder.tvRepeat;
                textView3.setText(" |   " + LongTimeAlarmManager.getRepeatStr(LongTimeAlarmListActivity.this, longTimeAlarm.repeat));
                final SwitchButton switchButton = childViewHolder.sbTimer;
                View view = childViewHolder.exclamationView;
                switchButton.setOnCheckedChangeListener(null);
                switchButton.setChecked(longTimeAlarm.enable);
                final int adapterPosition = childViewHolder.getAdapterPosition() - 1;
                switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm.LongTimeAlarmListActivity.RecyclerTimerAdapter.AnonymousClass1 */

                    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        LongTimeAlarmListActivity.this.mXQProgressDialog.show();
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(LongTimeAlarmListActivity.this.mTimerList);
                        ((LongTimeAlarm) arrayList.get(adapterPosition)).enable = z;
                        LongTimeAlarmManager.updateTimer(LongTimeAlarmListActivity.this.mCameraDevice.getModel(), LongTimeAlarmListActivity.this.mCameraDevice.getDid(), LongTimeAlarmListActivity.this.mCameraSpecDevice, arrayList, new LongTimeAlarmManager.LongTimeAlarmListener() {
                            /* class com.xiaomi.smarthome.camera.activity.alarm.LongTimeAlarmListActivity.RecyclerTimerAdapter.AnonymousClass1.AnonymousClass1 */

                            public void onAlarmValueSetSuccess() {
                            }

                            public void onAlarmValueUpdateFailed(int i, String str) {
                            }

                            public void onAlarmValueUpdateSuccess(Map<Integer, String> map) {
                            }

                            public void onUpdateSuccess() {
                                LongTimeAlarmListActivity.this.mXQProgressDialog.dismiss();
                            }

                            public void onUpdateFailed(int i, String str) {
                                if (i != -1 || LongTimeAlarmListActivity.this.mCameraDevice.isOwner()) {
                                    gqg.O00000Oo((int) R.string.plug_timer_set_fail);
                                } else {
                                    gqg.O00000Oo((int) R.string.gateway_user_cant_not_access);
                                }
                                if (childViewHolder.getAdapterPosition() == adapterPosition + 1) {
                                    switchButton.setOnCheckedChangeListener(null);
                                    switchButton.setChecked(!switchButton.isChecked());
                                    switchButton.setOnCheckedChangeListener(this);
                                }
                                LongTimeAlarmListActivity.this.mXQProgressDialog.dismiss();
                            }
                        });
                    }
                });
                childViewHolder.itemView.setClickable(true);
                childViewHolder.itemView.setTag(childViewHolder);
                childViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm.LongTimeAlarmListActivity.RecyclerTimerAdapter.AnonymousClass2 */

                    public void onClick(View view) {
                        ChildViewHolder childViewHolder = (ChildViewHolder) view.getTag();
                        boolean z = ModeController.getInstance().mCheckedItems.get(adapterPosition);
                        if (ModeController.getInstance().mCurrentMode == 0) {
                            if (z) {
                                childViewHolder.checkbox.setChecked(false);
                                ModeController.getInstance().mCheckedItems.delete(adapterPosition);
                            } else {
                                childViewHolder.checkbox.setChecked(true);
                                ModeController.getInstance().mCheckedItems.put(adapterPosition, true);
                            }
                            if (ModeController.getInstance().mCheckedItems.size() == LongTimeAlarmListActivity.this.mAdapter.getItemCount() - 2) {
                                LongTimeAlarmListActivity.this.mIvSelectAll.setImageResource(R.drawable.un_select_selector);
                                LongTimeAlarmListActivity.this.mIvSelectAll.setContentDescription(LongTimeAlarmListActivity.this.getString(R.string.unselect_all));
                            } else {
                                LongTimeAlarmListActivity.this.mIvSelectAll.setImageResource(R.drawable.all_select_selector);
                                LongTimeAlarmListActivity.this.mIvSelectAll.setContentDescription(LongTimeAlarmListActivity.this.getString(R.string.select_all));
                            }
                            LongTimeAlarmListActivity.this.mSelectCountText.setText(LongTimeAlarmListActivity.this.getResources().getQuantityString(R.plurals.selected_cnt_tips, ModeController.getInstance().mCheckedItems.size(), Integer.valueOf(ModeController.getInstance().mCheckedItems.size())));
                            RecyclerTimerAdapter.this.notifyDataSetChanged();
                            return;
                        }
                        Intent intent = new Intent(LongTimeAlarmListActivity.this, SetLongTimeAlarmActivity.class);
                        intent.putExtra("key_timer", longTimeAlarm);
                        intent.putExtra("key_position", adapterPosition);
                        LongTimeAlarmListActivity.this.startActivityForResult(intent, 1000);
                    }
                });
                if (ModeController.getInstance().mCurrentMode == 0) {
                    childViewHolder.itemView.setOnLongClickListener(null);
                } else {
                    childViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                        /* class com.xiaomi.smarthome.camera.activity.alarm.LongTimeAlarmListActivity.RecyclerTimerAdapter.AnonymousClass3 */

                        public boolean onLongClick(View view) {
                            if (ModeController.getInstance().mCurrentMode == 1 && !LongTimeAlarmListActivity.this.mPullRefresh.isRefreshing()) {
                                ModeController.getInstance().changeMode(0);
                                view.performClick();
                            }
                            return true;
                        }
                    });
                }
                if (ModeController.getInstance().mCurrentMode == 0) {
                    switchButton.setVisibility(8);
                    childViewHolder.checkbox.setVisibility(0);
                } else {
                    switchButton.setVisibility(0);
                    childViewHolder.checkbox.setVisibility(8);
                }
                if (ModeController.getInstance().mCheckedItems.get(adapterPosition)) {
                    childViewHolder.checkbox.setChecked(true);
                } else {
                    childViewHolder.checkbox.setChecked(false);
                }
                childViewHolder.groupIndicator.setVisibility(8);
                if (ModeController.getInstance().mCurrentMode == 0) {
                    switchButton.setVisibility(8);
                    view.setVisibility(8);
                    childViewHolder.checkbox.setVisibility(0);
                    return;
                }
                switchButton.setVisibility(0);
                view.setVisibility(8);
            }
        }

        public class ChildViewHolder extends BaseViewHolder {
            CheckBox checkbox;
            View exclamationView;
            View groupIndicator;
            SwitchButton sbTimer;
            TextView tvOn;
            TextView tvOnTime;
            TextView tvRepeat;
            View vDivider;

            public ChildViewHolder(View view) {
                super(view);
                this.tvOn = (TextView) view.findViewById(R.id.tv_on);
                this.tvOnTime = (TextView) view.findViewById(R.id.tv_on_time);
                this.tvRepeat = (TextView) view.findViewById(R.id.tv_repeat);
                this.sbTimer = (SwitchButton) view.findViewById(R.id.sb_timer);
                this.exclamationView = view.findViewById(R.id.err_btn);
                this.groupIndicator = view.findViewById(R.id.group_indicator);
                this.vDivider = view.findViewById(R.id.divider);
                this.checkbox = (CheckBox) view.findViewById(R.id.ckb_edit_selected);
            }
        }
    }

    private void deleteTimer(List<LongTimeAlarm> list) {
        new MLAlertDialog.Builder(this).O000000o((int) R.string.plug_timer_del).O00000Oo((int) R.string.plug_timer_del_hint).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.plug_timer_delete, new DialogInterface.OnClickListener(list) {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$LongTimeAlarmListActivity$nl4PeiiMfZSQdVpnENhFOuPaJY */
            private final /* synthetic */ List f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                LongTimeAlarmListActivity.this.lambda$deleteTimer$3$LongTimeAlarmListActivity(this.f$1, dialogInterface, i);
            }
        }).O00000oo();
    }

    public /* synthetic */ void lambda$deleteTimer$3$LongTimeAlarmListActivity(List list, DialogInterface dialogInterface, int i) {
        this.mXQProgressDialog.show();
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mTimerList);
        arrayList.removeAll(list);
        LongTimeAlarmManager.updateTimer(this.mCameraDevice.getModel(), this.mCameraDevice.getDid(), this.mCameraSpecDevice, arrayList, new LongTimeAlarmManager.LongTimeAlarmListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.LongTimeAlarmListActivity.AnonymousClass7 */

            public void onAlarmValueSetSuccess() {
            }

            public void onAlarmValueUpdateFailed(int i, String str) {
            }

            public void onAlarmValueUpdateSuccess(Map<Integer, String> map) {
            }

            public void onUpdateSuccess() {
                ModeController.getInstance().changeMode(1);
                LongTimeAlarmListActivity.this.onUpdateSuccess(arrayList);
            }

            public void onUpdateFailed(int i, String str) {
                LongTimeAlarmListActivity.this.mXQProgressDialog.hide();
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1000 && i2 == -1) {
            LongTimeAlarm longTimeAlarm = (LongTimeAlarm) intent.getParcelableExtra("key_timer");
            int intExtra = intent.getIntExtra("key_position", -1);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.mTimerList);
            if (intExtra < 0 || intExtra >= arrayList.size()) {
                arrayList.add(longTimeAlarm);
            } else {
                arrayList.set(intExtra, longTimeAlarm);
            }
            LongTimeAlarmManager.updateTimer(this.mCameraDevice.getModel(), this.mCameraDevice.getDid(), this.mCameraSpecDevice, arrayList, this);
        }
    }
}

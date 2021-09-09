package com.xiaomi.smarthome.scene.timer;

import _m_j.fno;
import _m_j.fso;
import _m_j.gqg;
import _m_j.gwg;
import _m_j.hrf;
import _m_j.hyq;
import _m_j.hyr;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.redpoint.ServerTimerManager;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.CountDownWidget;
import com.xiaomi.smarthome.library.common.widget.TimePicker;
import com.xiaomi.smarthome.scene.model.CorntabUtils;
import com.xiaomi.smarthome.scene.timer.dialog.ChooseTimeDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CountDownTimerActivity extends BaseActivity implements hrf.O00000Oo, hyr {

    /* renamed from: O000000o  reason: collision with root package name */
    View f11231O000000o;
    ImageView O00000Oo;
    private boolean O00000o;
    private ListView O00000o0;
    private String O00000oO;
    private TextView O00000oo;
    private View O0000O0o;
    private View O0000OOo;
    private String O0000Oo;
    private View O0000Oo0;
    private boolean O0000OoO = true;
    public MyAdapter mAdapter;
    public TextView mBtn1;
    public View.OnClickListener mBtn1ClickListener = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.scene.timer.CountDownTimerActivity.AnonymousClass3 */

        public final void onClick(View view) {
            if (CountDownTimerActivity.this.mTargetCountDownTimer == null || !CountDownTimerActivity.this.mTargetCountDownTimer.O00000Oo) {
                CountDownTimerActivity.this.startTimer();
                return;
            }
            CountDownTimerActivity.this.mXQProgressDialog.show();
            CountDownTimerActivity.this.mTargetCountDownTimer.O00000Oo = false;
            CountDownTimerActivity.this.mTimerManager.O000000o(CountDownTimerActivity.this.mOriginTimer, CountDownTimerActivity.this.mTargetCountDownTimer, CountDownTimerActivity.this.mOnMethod, CountDownTimerActivity.this.mOffMethod, CountDownTimerActivity.this.mOnParams, CountDownTimerActivity.this.mOffParams, new hrf.O00000Oo() {
                /* class com.xiaomi.smarthome.scene.timer.CountDownTimerActivity.AnonymousClass3.AnonymousClass1 */

                public final void onGetSceneSuccess() {
                }

                public final void onSetSceneSuccess(CommonTimer commonTimer) {
                    CountDownTimerActivity.this.mXQProgressDialog.dismiss();
                    CountDownTimerActivity.this.setTimerOffStatus();
                    CountDownTimerActivity.this.mOriginTimer = CountDownTimerActivity.this.mTargetCountDownTimer;
                }

                public final void onSetSceneFailed(fso fso) {
                    CountDownTimerActivity.this.mTargetCountDownTimer.O00000Oo = true;
                    CountDownTimerActivity.this.mXQProgressDialog.dismiss();
                    gqg.O00000Oo((int) R.string.plug_timer_set_fail);
                }

                public final void onGetSceneFailed(int i) {
                    gqg.O00000Oo((int) R.string.plug_timer_get_fail);
                }
            }, CountDownTimerActivity.this.mTimerIdentifyRn);
        }
    };
    public TextView mBtn2;
    public View.OnClickListener mBtn2ClickListener = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.scene.timer.CountDownTimerActivity.AnonymousClass2 */

        public final void onClick(View view) {
            CountDownTimerActivity.this.mXQProgressDialog.show();
            CountDownTimerActivity.this.mTimerManager.O000000o(CountDownTimerActivity.this.mTargetCountDownTimer, new hrf.O00000Oo() {
                /* class com.xiaomi.smarthome.scene.timer.CountDownTimerActivity.AnonymousClass2.AnonymousClass1 */

                public final void onGetSceneFailed(int i) {
                }

                public final void onGetSceneSuccess() {
                }

                public final void onSetSceneSuccess(CommonTimer commonTimer) {
                    CountDownTimerActivity.this.mTargetCountDownTimer = null;
                    CountDownTimerActivity.this.mXQProgressDialog.dismiss();
                    CountDownTimerActivity.this.mCountDownView.setCurrentValue(0);
                    CountDownTimerActivity.this.mCountDownView.O000000o();
                    CountDownTimerActivity.this.mBtn1.setVisibility(8);
                    CountDownTimerActivity.this.mBtn2.setVisibility(8);
                    CountDownTimerActivity.this.mBtn3.setVisibility(0);
                    CountDownTimerActivity.this.mHandler.removeMessages(1);
                }

                public final void onSetSceneFailed(fso fso) {
                    CountDownTimerActivity.this.mXQProgressDialog.dismiss();
                    gqg.O00000Oo((int) R.string.set_timer_fail_delete);
                }
            });
        }
    };
    public TextView mBtn3;
    public List<Integer> mCommonMinutes = Collections.emptyList();
    public CountDownWidget mCountDownView;
    public Device mDevice;
    public O000000o mHandler = null;
    public int mMinuteForCountdown;
    public String mOffMethod;
    public String mOffParams;
    public String mOnMethod;
    public String mOnParams;
    public PlugTimer mOriginTimer = null;
    public PlugTimer mTargetCountDownTimer = null;
    public TimePicker mTimePicker;
    public String mTimerIdentifyRn;
    public hrf mTimerManager = null;
    public XQProgressDialog mXQProgressDialog;

    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000o0(DialogInterface dialogInterface, int i) {
    }

    public void onSetSceneFailed(fso fso) {
    }

    public void onSetSceneSuccess(CommonTimer commonTimer) {
    }

    public void setTimerOnStatus() {
    }

    static class MyAdapter extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f11240O000000o = -1;
        private int[] O00000Oo;
        private Context O00000o0;

        public final long getItemId(int i) {
            return (long) i;
        }

        public class ViewHolder_ViewBinding implements Unbinder {

            /* renamed from: O000000o  reason: collision with root package name */
            private ViewHolder f11242O000000o;

            public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
                this.f11242O000000o = viewHolder;
                viewHolder.textView = (TextView) Utils.findRequiredViewAsType(view, R.id.f3590tv, "field 'textView'", TextView.class);
                viewHolder.imageView = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv, "field 'imageView'", ImageView.class);
                viewHolder.checkbox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ckb_edit_selected, "field 'checkbox'", CheckBox.class);
                viewHolder.ivPickerIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_picker_icon, "field 'ivPickerIcon'", ImageView.class);
            }

            public void unbind() {
                ViewHolder viewHolder = this.f11242O000000o;
                if (viewHolder != null) {
                    this.f11242O000000o = null;
                    viewHolder.textView = null;
                    viewHolder.imageView = null;
                    viewHolder.checkbox = null;
                    viewHolder.ivPickerIcon = null;
                    return;
                }
                throw new IllegalStateException("Bindings already cleared.");
            }
        }

        MyAdapter(List<Integer> list, Context context) {
            this.O00000o0 = context;
            this.O00000Oo = new int[list.size()];
            int i = 0;
            for (Integer intValue : list) {
                this.O00000Oo[i] = intValue.intValue();
                i++;
            }
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(List<Integer> list) {
            this.O00000Oo = new int[list.size()];
            int i = 0;
            for (Integer intValue : list) {
                this.O00000Oo[i] = intValue.intValue();
                i++;
            }
        }

        public final int getCount() {
            return this.O00000Oo.length + 1;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(this.O00000o0).inflate((int) R.layout.list_item_countdown_minute, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            if (i >= this.O00000Oo.length) {
                viewHolder.textView.setText((int) R.string.customize_minute);
                viewHolder.imageView.setVisibility(0);
                viewHolder.checkbox.setVisibility(8);
            } else {
                viewHolder.imageView.setVisibility(8);
                if (hyq.O000000o().f997O000000o == 1) {
                    viewHolder.checkbox.setVisibility(8);
                } else {
                    viewHolder.checkbox.setVisibility(0);
                }
                if (hyq.O000000o().O00000o0.get(i)) {
                    viewHolder.checkbox.setChecked(true);
                } else {
                    viewHolder.checkbox.setChecked(false);
                }
                int i2 = this.O00000Oo[i];
                if (i2 < 60) {
                    TextView textView = viewHolder.textView;
                    textView.setText(String.valueOf(i2) + this.O00000o0.getString(R.string.minute));
                } else {
                    StringBuilder sb = new StringBuilder();
                    int i3 = i2 / 60;
                    int i4 = i2 % 60;
                    sb.append(i3);
                    sb.append(this.O00000o0.getString(R.string.hour));
                    if (i4 > 0) {
                        sb.append(i4);
                        sb.append(this.O00000o0.getString(R.string.minute));
                    }
                    viewHolder.textView.setText(sb.toString());
                }
            }
            if (i >= this.O00000Oo.length || this.f11240O000000o != i) {
                viewHolder.textView.setTextColor(view.getResources().getColor(R.color.mj_color_black));
                viewHolder.ivPickerIcon.setVisibility(8);
            } else {
                viewHolder.textView.setTextColor(view.getResources().getColor(R.color.mj_color_green_normal));
                viewHolder.ivPickerIcon.setVisibility(0);
            }
            return view;
        }

        class ViewHolder {
            @BindView(5239)
            CheckBox checkbox;
            @BindView(5644)
            ImageView imageView;
            @BindView(5659)
            ImageView ivPickerIcon;
            @BindView(6426)
            TextView textView;

            public ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            int[] iArr = this.O00000Oo;
            if (i >= iArr.length) {
                return Integer.MAX_VALUE;
            }
            return Integer.valueOf(iArr[i]);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_count_down_timer);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        this.O00000oO = intent.getStringExtra("common_timer_device_id");
        this.mDevice = fno.O000000o().O000000o(this.O00000oO);
        this.O00000o = intent.getBooleanExtra("device_power_on", false);
        this.mOnMethod = intent.getStringExtra("on_method");
        this.mOffMethod = intent.getStringExtra("off_method");
        this.mOnParams = intent.getStringExtra("on_param");
        this.mOffParams = intent.getStringExtra("off_param");
        this.O0000Oo = intent.getStringExtra("common_timer_display_name");
        if (TextUtils.isEmpty(this.O0000Oo)) {
            this.O0000Oo = "display_name";
        }
        if (this.mDevice == null) {
            finish();
            return;
        }
        hyq.O000000o().O00000Oo = this;
        this.mTimerIdentifyRn = intent.getStringExtra("timer_identify_rn");
        this.mHandler = new O000000o(this, getMainLooper());
        this.mTimerManager = hrf.O0000O0o();
        this.mTimerManager.O000000o(this.mDevice, "timer_name", this.O0000Oo);
        View findViewById = findViewById(R.id.module_a_3_return_btn);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.timer.$$Lambda$CountDownTimerActivity$6gXJUNFGyMNhubzXbfjkKWO6EaY */

                public final void onClick(View view) {
                    CountDownTimerActivity.this.O000000o(view);
                }
            });
        }
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.plug_timer_set_countdown);
        this.mCountDownView = (CountDownWidget) findViewById(R.id.count_down_timer);
        this.mCountDownView.O00000Oo();
        this.mTimePicker = (TimePicker) findViewById(R.id.tp_timer);
        this.mTimePicker.setIs24HourView(Boolean.TRUE);
        this.mTimePicker.setCurrentHour(0);
        this.mTimePicker.setCurrentMinute(0);
        this.mTimePicker.setOnTimeChangedListener(new TimePicker.O00000Oo() {
            /* class com.xiaomi.smarthome.scene.timer.$$Lambda$CountDownTimerActivity$xB7_6E5Wh25C0UdZMzxjJuJjZks */

            public final void onTimeChanged(TimePicker timePicker, int i, int i2) {
                CountDownTimerActivity.this.O000000o(timePicker, i, i2);
            }
        });
        this.O00000o0 = (ListView) findViewById(R.id.list_minute);
        this.O00000oo = (TextView) findViewById(R.id.tv_cur_set_time);
        this.O0000O0o = findViewById(R.id.bottom_delete_bar);
        this.O0000OOo = findViewById(R.id.delete_msg_btn);
        this.O0000Oo0 = findViewById(R.id.top_delete_bar);
        if (gwg.O000000o((Activity) this)) {
            this.O0000Oo0.getLayoutParams().height += gwg.O00000Oo(this);
            View view = this.O0000Oo0;
            view.setPadding(0, view.getPaddingTop() + gwg.O00000Oo(this), 0, 0);
            View view2 = this.O0000Oo0;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        this.f11231O000000o = findViewById(R.id.cancel_btn);
        this.mBtn3 = (TextView) findViewById(R.id.button3);
        this.mBtn1 = (TextView) findViewById(R.id.button1);
        this.mBtn2 = (TextView) findViewById(R.id.button2);
        this.O00000Oo = (ImageView) findViewById(R.id.select_all_btn);
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.timer.$$Lambda$CountDownTimerActivity$cFqb4aqyfBAdbYRx5r7FNuPyPQ */

            public final void onClick(View view) {
                CountDownTimerActivity.this.O00000o(view);
            }
        });
        this.O0000O0o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.timer.$$Lambda$CountDownTimerActivity$EkbgTWQWJHRc6UJXenDNMFM0gk4 */

            public final void onClick(View view) {
                CountDownTimerActivity.this.O00000o0(view);
            }
        });
        this.f11231O000000o.setOnClickListener($$Lambda$CountDownTimerActivity$98C0sIx3Yazo16wboDDS61AGmSc.INSTANCE);
        this.mTimerManager.O000000o(this);
        this.mXQProgressDialog = new XQProgressDialog(this);
        this.mXQProgressDialog.setMessage(getString(R.string.gateway_magnet_location_updating));
        this.mXQProgressDialog.setCancelable(true);
        this.mXQProgressDialog.show();
        findViewById(R.id.root_container).setAlpha(0.0f);
        this.mTimerManager.O00000Oo(this.mTimerIdentifyRn);
        if (this.mTimerManager.O00000o.getBoolean("common.countdown.firstin", true)) {
            SharedPreferences.Editor edit = this.mTimerManager.O00000o.edit();
            edit.putBoolean("common.countdown.firstin", false);
            edit.apply();
            this.mTimerManager.O000000o(new int[]{10, 30, 60});
            O000000o();
        }
    }

    public void onStop() {
        super.onStop();
        hyq.O000000o().O000000o(1);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || hyq.O000000o().f997O000000o != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        hyq.O000000o().O000000o(1);
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(View view) {
        if (hyq.O000000o().O00000o0.size() == this.mAdapter.getCount() - 1) {
            O00000Oo();
            return;
        }
        int count = this.mAdapter.getCount() - 1;
        hyq.O000000o().O00000o0.clear();
        for (int i = 0; i < count; i++) {
            hyq.O000000o().O00000o0.put(i, true);
        }
        this.O00000Oo.setImageResource(R.drawable.un_select_selector);
        this.O00000Oo.setContentDescription(getString(R.string.unselect_all));
        this.mAdapter.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        if (hyq.O000000o().O00000o0.size() > 0) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
            builder.O00000Oo("\n" + getResources().getString(R.string.delete_custom_timer) + "\n");
            builder.O000000o((int) R.string.delete, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.timer.$$Lambda$CountDownTimerActivity$0d982FtLhLYGIsHVE9LBgXUqZk */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    CountDownTimerActivity.this.O00000Oo(dialogInterface, i);
                }
            });
            builder.O00000Oo((int) R.string.sh_common_cancel, $$Lambda$CountDownTimerActivity$MjWb1Izn2SLYNArv8HbECJNANw4.INSTANCE);
            builder.O00000o().show();
            return;
        }
        gqg.O00000Oo(getString(R.string.choose_one_tip));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(TimePicker timePicker, int i, int i2) {
        String str;
        String str2;
        String str3;
        if (i == 0 && i2 == 0) {
            this.mBtn3.setEnabled(false);
            this.O00000oo.setText((int) R.string.count_down_not_set);
            return;
        }
        this.mBtn3.setEnabled(true);
        this.mCountDownView.setCurrentValue((i * 60) + i2);
        if (i == 0) {
            str = "";
        } else {
            str = getResources().getQuantityString(R.plurals.automation_hour, i, Integer.valueOf(i));
        }
        if (i2 == 0) {
            str2 = "";
        } else {
            str2 = getResources().getQuantityString(R.plurals.automation_minute, i2, Integer.valueOf(i2));
        }
        if (!this.O00000o) {
            String string = getString(R.string.timer_hint_open_all);
            Object[] objArr = new Object[3];
            boolean isEmpty = TextUtils.isEmpty("");
            objArr[0] = "";
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            objArr[1] = str;
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            objArr[2] = str2;
            str3 = String.format(string, objArr);
        } else {
            String string2 = getString(R.string.timer_hint_close_all);
            Object[] objArr2 = new Object[3];
            boolean isEmpty2 = TextUtils.isEmpty("");
            objArr2[0] = "";
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            objArr2[1] = str;
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            objArr2[2] = str2;
            str3 = String.format(string2, objArr2);
        }
        TextView textView = this.O00000oo;
        if (TextUtils.isEmpty(str3)) {
            str3 = getString(R.string.count_down_not_set);
        }
        textView.setText(str3);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        finish();
    }

    public void jumpStartActivity() {
        Intent intent = new Intent(this, CountDownTimerStartActivity.class);
        intent.putExtra("common_timer_device_id", this.O00000oO);
        intent.putExtra("on_method", this.mOnMethod);
        intent.putExtra("on_param", this.mOnParams);
        intent.putExtra("off_method", this.mOffMethod);
        intent.putExtra("off_param", this.mOffParams);
        intent.putExtra("device_power_on", this.O00000o);
        intent.putExtra("target_time", this.mTargetCountDownTimer);
        intent.putExtra("timer_identify_rn", this.mTimerIdentifyRn);
        intent.putExtra("common_timer_display_name", this.O0000Oo);
        startActivity(intent);
    }

    public void setTimerOffStatus() {
        PlugTimer plugTimer = this.mTargetCountDownTimer;
        if (plugTimer != null) {
            plugTimer.O00000Oo = false;
        }
        this.mCountDownView.O000000o();
        this.mBtn1.setText((int) R.string.start);
        this.mHandler.removeMessages(1);
    }

    public void promptCustomizeMinutesDialog() {
        ChooseTimeDialog chooseTimeDialog = new ChooseTimeDialog(this);
        chooseTimeDialog.setCancelable(true);
        chooseTimeDialog.O000000o(new DialogInterface.OnClickListener(chooseTimeDialog) {
            /* class com.xiaomi.smarthome.scene.timer.$$Lambda$CountDownTimerActivity$BPR3gnJEBYseRohJylTnRS4kq2w */
            private final /* synthetic */ ChooseTimeDialog f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                CountDownTimerActivity.this.O000000o(this.f$1, dialogInterface, i);
            }
        });
        chooseTimeDialog.O00000Oo($$Lambda$CountDownTimerActivity$JaTHQM9FvFz_uddul09tfF4Tm1Y.INSTANCE);
        chooseTimeDialog.show();
        chooseTimeDialog.O000000o((int) R.string.customize_minute);
        if (chooseTimeDialog.f11266O000000o.getCurrentHour().intValue() == 0 && chooseTimeDialog.f11266O000000o.getCurrentMinute().intValue() == 0) {
            chooseTimeDialog.getButton(-1).setEnabled(false);
        }
    }

    public void startTimer() {
        List list;
        if (this.mCountDownView.getCurrentValue() != 0 && this.mDevice != null) {
            List<CommonTimer> O00000Oo2 = this.mTimerManager.O00000Oo();
            if (O00000Oo2 == null) {
                list = Collections.EMPTY_LIST;
            } else {
                ArrayList arrayList = new ArrayList();
                for (CommonTimer next : O00000Oo2) {
                    if (next != null && !TextUtils.isEmpty(next.O0000o0O) && "1".equals(next.O0000o0O)) {
                        arrayList.add(CommonTimer.O000000o(next));
                    }
                }
                list = arrayList;
            }
            final int currentValue = this.mCountDownView.getCurrentValue();
            if (detectConflicting(currentValue, list)) {
                new MLAlertDialog.Builder(this).O00000Oo((int) R.string.set_timer_conflict).O00000Oo(17039360, (DialogInterface.OnClickListener) null).O000000o(17039370, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.timer.CountDownTimerActivity.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        CountDownTimerActivity countDownTimerActivity = CountDownTimerActivity.this;
                        countDownTimerActivity.setTimer(currentValue, countDownTimerActivity.mDevice);
                    }
                }).O00000oo();
            } else {
                setTimer(currentValue, this.mDevice);
            }
        }
    }

    public void setTimer(int i, Device device) {
        CorntabUtils.CorntabParam corntabParam = new CorntabUtils.CorntabParam();
        Calendar instance = Calendar.getInstance();
        instance.add(12, i);
        long O00000Oo2 = ServerTimerManager.O000000o(CommonApplication.getAppContext()).O00000Oo();
        if (ServerTimerManager.O000000o(CommonApplication.getAppContext()).O000000o()) {
            instance.add(12, (int) (O00000Oo2 / 60000));
        } else {
            ServerTimerManager.O000000o(getApplicationContext()).O00000oo.O000000o();
        }
        corntabParam.O00000oO = instance.get(2) + 1;
        corntabParam.O00000o = instance.get(5);
        corntabParam.O00000o0 = instance.get(11);
        corntabParam.O00000Oo = instance.get(12);
        boolean z = this.O00000o;
        PlugTimer plugTimer = this.mTargetCountDownTimer;
        if (plugTimer == null) {
            plugTimer = new PlugTimer();
        }
        final PlugTimer plugTimer2 = plugTimer;
        plugTimer2.f11250O000000o = true;
        plugTimer2.O00000Oo = true;
        if (z) {
            plugTimer2.O00000o0 = false;
            plugTimer2.O00000oo = true;
            plugTimer2.O0000OOo = corntabParam;
        } else {
            plugTimer2.O00000o0 = true;
            plugTimer2.O00000oO = corntabParam;
            plugTimer2.O00000oo = false;
        }
        plugTimer2.O00000o = plugTimer2.O00000o0;
        plugTimer2.O0000O0o = plugTimer2.O00000oo;
        plugTimer2.O0000OoO = "1";
        this.mXQProgressDialog.show();
        this.mTimerManager.O000000o(this.mOriginTimer, plugTimer2, this.mOnMethod, this.mOffMethod, this.mOnParams, this.mOffParams, new hrf.O00000Oo() {
            /* class com.xiaomi.smarthome.scene.timer.CountDownTimerActivity.AnonymousClass5 */

            public final void onGetSceneSuccess() {
            }

            public final void onSetSceneSuccess(CommonTimer commonTimer) {
                CountDownTimerActivity.this.mXQProgressDialog.dismiss();
                CountDownTimerActivity countDownTimerActivity = CountDownTimerActivity.this;
                PlugTimer plugTimer = plugTimer2;
                countDownTimerActivity.mOriginTimer = plugTimer;
                countDownTimerActivity.mTargetCountDownTimer = plugTimer;
                countDownTimerActivity.mBtn1.setVisibility(0);
                CountDownTimerActivity.this.mBtn2.setVisibility(0);
                CountDownTimerActivity.this.mBtn2.setOnClickListener(CountDownTimerActivity.this.mBtn2ClickListener);
                CountDownTimerActivity.this.mBtn1.setOnClickListener(CountDownTimerActivity.this.mBtn1ClickListener);
                CountDownTimerActivity.this.mBtn3.setVisibility(8);
                CountDownTimerActivity.this.setTimerOnStatus();
                CountDownTimerActivity.this.mHandler.sendEmptyMessageDelayed(1, 20000);
                CountDownTimerActivity.this.jumpStartActivity();
                CountDownTimerActivity.this.finish();
            }

            public final void onSetSceneFailed(fso fso) {
                CountDownTimerActivity.this.mXQProgressDialog.dismiss();
                gqg.O00000Oo((int) R.string.plug_timer_set_fail);
            }

            public final void onGetSceneFailed(int i) {
                gqg.O00000Oo((int) R.string.plug_timer_get_fail);
            }
        }, this.mTimerIdentifyRn);
    }

    public boolean detectConflicting(int i, List<PlugTimer> list) {
        List<Pair<Float, Float>> O000000o2;
        if (!(list == null || list.size() == 0 || (O000000o2 = hrf.O000000o(list)) == null || O000000o2.isEmpty())) {
            float O000000o3 = hrf.O000000o(Calendar.getInstance()) + ((((float) i) + (((float) ServerTimerManager.O000000o(CommonApplication.getAppContext()).O00000Oo()) / 60000.0f)) / 1440.0f);
            for (Pair next : O000000o2) {
                if (O000000o3 < ((Float) next.first).floatValue() && O000000o3 + 6.9444446E-4f >= ((Float) next.first).floatValue()) {
                    return true;
                }
                if (O000000o3 > ((Float) next.first).floatValue() && O000000o3 - 6.9444446E-4f <= ((Float) next.first).floatValue()) {
                    return true;
                }
                if (O000000o3 < ((Float) next.second).floatValue() && O000000o3 + 6.9444446E-4f >= ((Float) next.second).floatValue()) {
                    return true;
                }
                if (O000000o3 > ((Float) next.second).floatValue() && O000000o3 - 6.9444446E-4f <= ((Float) next.second).floatValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void O000000o() {
        List<Integer> emptyList = Collections.emptyList();
        hrf hrf = this.mTimerManager;
        if (hrf != null) {
            emptyList = hrf.O0000Oo0();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(emptyList);
        this.mCommonMinutes = new ArrayList();
        this.mCommonMinutes.addAll(arrayList);
        MyAdapter myAdapter = this.mAdapter;
        if (myAdapter == null) {
            this.mAdapter = new MyAdapter(this.mCommonMinutes, this);
            this.O00000o0.setAdapter((ListAdapter) this.mAdapter);
            this.O00000o0.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* class com.xiaomi.smarthome.scene.timer.CountDownTimerActivity.AnonymousClass6 */

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (hyq.O000000o().f997O000000o != 1) {
                        if (hyq.O000000o().O00000o0.get(i)) {
                            hyq.O000000o().O00000o0.delete(i);
                        } else {
                            hyq.O000000o().O00000o0.put(i, true);
                        }
                        if (hyq.O000000o().O00000o0.size() == CountDownTimerActivity.this.mAdapter.getCount() - 1) {
                            CountDownTimerActivity.this.O00000Oo.setImageResource(R.drawable.un_select_selector);
                            CountDownTimerActivity.this.O00000Oo.setContentDescription(CountDownTimerActivity.this.getString(R.string.unselect_all));
                        } else {
                            CountDownTimerActivity.this.O00000Oo.setImageResource(R.drawable.all_select_selector);
                            CountDownTimerActivity.this.O00000Oo.setContentDescription(CountDownTimerActivity.this.getString(R.string.select_all));
                        }
                        CountDownTimerActivity.this.mAdapter.notifyDataSetChanged();
                    } else if (i >= CountDownTimerActivity.this.mCommonMinutes.size()) {
                        CountDownTimerActivity.this.mAdapter.f11240O000000o = -1;
                        CountDownTimerActivity.this.mAdapter.notifyDataSetChanged();
                        if (CountDownTimerActivity.this.mCommonMinutes.size() >= 10) {
                            gqg.O00000Oo((int) R.string.frequent_use_timer_max);
                        } else {
                            CountDownTimerActivity.this.promptCustomizeMinutesDialog();
                        }
                    } else {
                        int intValue = CountDownTimerActivity.this.mCommonMinutes.get(i).intValue();
                        CountDownTimerActivity.this.mAdapter.f11240O000000o = i;
                        CountDownTimerActivity.this.mAdapter.notifyDataSetChanged();
                        CountDownTimerActivity countDownTimerActivity = CountDownTimerActivity.this;
                        countDownTimerActivity.mMinuteForCountdown = intValue;
                        countDownTimerActivity.mCountDownView.setCurrentValue(intValue);
                        if (intValue < 60) {
                            CountDownTimerActivity.this.mTimePicker.setCurrentMinute(Integer.valueOf(intValue));
                            CountDownTimerActivity.this.mTimePicker.setCurrentHour(0);
                            return;
                        }
                        CountDownTimerActivity.this.mTimePicker.setCurrentHour(Integer.valueOf(intValue / 60));
                        CountDownTimerActivity.this.mTimePicker.setCurrentMinute(Integer.valueOf(intValue % 60));
                    }
                }
            });
            this.O00000o0.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                /* class com.xiaomi.smarthome.scene.timer.$$Lambda$CountDownTimerActivity$Gy2MK3AqHXSdmk9_hUGRBJt8g */

                public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
                    return CountDownTimerActivity.this.O000000o(adapterView, view, i, j);
                }
            });
        } else {
            myAdapter.O000000o(this.mCommonMinutes);
            this.mAdapter.notifyDataSetChanged();
        }
        if (hyq.O000000o().f997O000000o == 0) {
            hyq.O000000o().O000000o(1);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean O000000o(AdapterView adapterView, View view, int i, long j) {
        if (i >= this.mAdapter.getCount() - 1 || hyq.O000000o().f997O000000o != 1) {
            return false;
        }
        hyq.O000000o().O00000o0.put(i, true);
        hyq.O000000o().O000000o(0);
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(DialogInterface dialogInterface, int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.mCommonMinutes.size(); i2++) {
            if (hyq.O000000o().O00000o0.get(i2)) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        O000000o(arrayList);
        dialogInterface.dismiss();
    }

    public void updateCountDownTimer() {
        PlugTimer plugTimer = this.mTargetCountDownTimer;
        if (plugTimer != null) {
            if (!plugTimer.O00000Oo) {
                this.mHandler.removeMessages(1);
            }
            Calendar instance = Calendar.getInstance();
            int i = instance.get(12) + (instance.get(11) * 60);
            CorntabUtils.CorntabParam corntabParam = this.O00000o ? this.mTargetCountDownTimer.O0000OOo : this.mTargetCountDownTimer.O00000oO;
            int O00000Oo2 = ((((corntabParam.O00000o0 * 60) + corntabParam.O00000Oo) - i) - (((int) ServerTimerManager.O000000o(CommonApplication.getAppContext()).O00000Oo()) / 60000)) + (instance.get(5) == corntabParam.O00000o ? 0 : 1440);
            if (O00000Oo2 >= 0) {
                this.mCountDownView.setCurrentValue(O00000Oo2);
                return;
            }
            this.mCountDownView.O000000o();
            this.mCountDownView.setCurrentValue(0);
            this.mHandler.removeMessages(1);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        hrf hrf = this.mTimerManager;
        if (hrf != null) {
            hrf.O00000Oo(this);
        }
        hyq.O000000o().O00000Oo();
    }

    public void onGetSceneSuccess() {
        if (!isFinishing()) {
            List<PlugTimer> O0000Oo2 = this.mTimerManager.O0000Oo();
            if (O0000Oo2.size() != 0) {
                ArrayList<PlugTimer> arrayList = new ArrayList<>();
                Calendar instance = Calendar.getInstance();
                int i = instance.get(5);
                int i2 = instance.get(12) + (instance.get(11) * 60);
                boolean z = this.O00000o;
                for (PlugTimer next : O0000Oo2) {
                    if (next.O00000Oo && (!z || !next.O00000o0 || (next.O00000oo && next.O0000O0o))) {
                        if (z || !next.O00000oo || (next.O00000o0 && next.O00000o)) {
                            if (!next.O00000o0 || !next.O00000oo) {
                                CorntabUtils.CorntabParam corntabParam = z ? next.O0000OOo : next.O00000oO;
                                if (corntabParam.O00000Oo() == 0 && ((i != corntabParam.O00000o || i2 < (corntabParam.O00000o0 * 60) + corntabParam.O00000Oo) && corntabParam.O00000Oo() == 0)) {
                                    arrayList.add(next);
                                }
                            }
                        }
                    }
                }
                if (arrayList.size() != 0) {
                    PlugTimer plugTimer = (PlugTimer) arrayList.get(0);
                    CorntabUtils.CorntabParam corntabParam2 = z ? plugTimer.O0000OOo : plugTimer.O00000oO;
                    int i3 = (((corntabParam2.O00000o0 * 60) + corntabParam2.O00000Oo) - i2) + (i == corntabParam2.O00000o ? 0 : 1440);
                    for (PlugTimer plugTimer2 : arrayList) {
                        CorntabUtils.CorntabParam corntabParam3 = z ? plugTimer2.O0000OOo : plugTimer2.O00000oO;
                        if (i3 > (((corntabParam3.O00000o0 * 60) + corntabParam3.O00000Oo) - i2) + (i == corntabParam3.O00000o ? 0 : 1440)) {
                            i3 = (((corntabParam3.O00000o0 * 60) + corntabParam3.O00000Oo) - i2) + (i == corntabParam3.O00000o ? 0 : 1440);
                            plugTimer = plugTimer2;
                        }
                    }
                    if (i3 <= 1440) {
                        this.mOriginTimer = plugTimer;
                        this.mTargetCountDownTimer = (PlugTimer) plugTimer.clone();
                    }
                }
            }
            PlugTimer plugTimer3 = this.mTargetCountDownTimer;
            if (plugTimer3 == null || !plugTimer3.O00000Oo || !this.O0000OoO) {
                findViewById(R.id.root_container).setAlpha(1.0f);
                this.O0000OoO = false;
                this.mBtn3.setText((int) R.string.start);
                this.mBtn1.setText((int) R.string.stop);
                this.mBtn2.setText((int) R.string.sh_common_cancel);
                this.mBtn3.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.timer.CountDownTimerActivity.AnonymousClass1 */

                    public final void onClick(View view) {
                        if (!CountDownTimerActivity.this.mDevice.isOwner()) {
                            gqg.O00000Oo((int) R.string.gateway_user_cant_not_access);
                        } else {
                            CountDownTimerActivity.this.startTimer();
                        }
                    }
                });
                this.mBtn3.setEnabled(false);
                if (this.mTargetCountDownTimer == null) {
                    setTimerOffStatus();
                    this.mBtn1.setVisibility(8);
                    this.mBtn2.setVisibility(8);
                    this.mBtn3.setVisibility(0);
                } else {
                    this.mBtn1.setVisibility(0);
                    this.mBtn2.setVisibility(0);
                    this.mBtn3.setVisibility(8);
                    if (!this.mTargetCountDownTimer.O00000Oo) {
                        setTimerOnStatus();
                    }
                    this.mBtn2.setOnClickListener(this.mBtn2ClickListener);
                    this.mBtn1.setOnClickListener(this.mBtn1ClickListener);
                }
                updateCountDownTimer();
                O000000o();
                PlugTimer plugTimer4 = this.mTargetCountDownTimer;
                if (plugTimer4 == null || !plugTimer4.O00000Oo) {
                    setTimerOffStatus();
                } else {
                    setTimerOnStatus();
                    this.mHandler.sendEmptyMessageDelayed(1, 20000);
                }
                this.mCountDownView.setStatus(this.O00000o);
                this.mXQProgressDialog.dismiss();
                return;
            }
            jumpStartActivity();
            finish();
        }
    }

    public void onGetSceneFailed(int i) {
        if (!isFinishing()) {
            this.mXQProgressDialog.dismiss();
            gqg.O00000Oo((int) R.string.kuailian_network_error);
            this.mBtn3.setEnabled(false);
            this.mTimePicker.setEnabled(false);
            this.mTimePicker.setAlpha(0.3f);
            this.O00000oo.setAlpha(0.3f);
        }
    }

    public void onBrowseMode() {
        O00000Oo();
        this.mTimePicker.setAlpha(1.0f);
        this.mTimePicker.setEnabled(true);
        this.O00000oo.setAlpha(1.0f);
        MyAdapter myAdapter = this.mAdapter;
        if (myAdapter != null) {
            myAdapter.notifyDataSetChanged();
        }
        this.O0000Oo0.setVisibility(8);
        this.O0000O0o.setVisibility(8);
    }

    public void onManageMode() {
        MyAdapter myAdapter = this.mAdapter;
        myAdapter.f11240O000000o = -1;
        myAdapter.notifyDataSetChanged();
        this.O0000Oo0.setVisibility(0);
        this.mTimePicker.setEnabled(false);
        this.mTimePicker.setAlpha(0.3f);
        this.O00000oo.setAlpha(0.3f);
        this.O0000O0o.setVisibility(0);
        this.O0000Oo0.measure(0, 0);
        this.O0000O0o.measure(0, 0);
        getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.O0000Oo0, View.TRANSLATION_Y, -getResources().getDimension(R.dimen.titlebar_height), 0.0f);
        ViewGroup viewGroup = (ViewGroup) this.O0000O0o.getParent();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.O0000O0o, View.Y, (float) viewGroup.getHeight(), (float) (viewGroup.getHeight() - this.O0000O0o.getMeasuredHeight()));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
    }

    private void O00000Oo() {
        hyq.O000000o().O00000o0.clear();
        this.O00000Oo.setImageResource(R.drawable.all_select_selector);
        this.O00000Oo.setContentDescription(getString(R.string.select_all));
        MyAdapter myAdapter = this.mAdapter;
        if (myAdapter != null) {
            myAdapter.notifyDataSetChanged();
        }
    }

    static class O000000o extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        private WeakReference<CountDownTimerActivity> f11243O000000o;

        public O000000o(CountDownTimerActivity countDownTimerActivity, Looper looper) {
            super(looper);
            this.f11243O000000o = new WeakReference<>(countDownTimerActivity);
        }

        public final void handleMessage(Message message) {
            CountDownTimerActivity countDownTimerActivity = this.f11243O000000o.get();
            boolean z = false;
            if (countDownTimerActivity != null && !countDownTimerActivity.isFinishing() && (Build.VERSION.SDK_INT < 17 || !countDownTimerActivity.isDestroyed())) {
                z = true;
            }
            if (z) {
                int i = message.what;
                if (i == 1) {
                    countDownTimerActivity.updateCountDownTimer();
                    countDownTimerActivity.mHandler.sendEmptyMessageDelayed(1, 20000);
                } else if (i == 2) {
                    countDownTimerActivity.refreshStatus();
                }
            }
        }
    }

    public void refreshStatus() {
        this.mCountDownView.setStatus(this.O00000o);
        this.mCountDownView.invalidate();
    }

    private void O000000o(List<Integer> list) {
        List<Integer> O0000Oo02 = this.mTimerManager.O0000Oo0();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(O0000Oo02);
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            int intValue = this.mCommonMinutes.get(list.get(i2).intValue()).intValue();
            Iterator it = arrayList.iterator();
            int i3 = 0;
            while (it.hasNext() && ((Integer) it.next()).intValue() != intValue) {
                i3++;
            }
            arrayList.remove(i3);
        }
        HashSet hashSet = new HashSet();
        hashSet.addAll(arrayList);
        int[] iArr = new int[hashSet.size()];
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            iArr[i] = ((Integer) it2.next()).intValue();
            i++;
        }
        this.mTimerManager.O000000o(iArr);
        O000000o();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(ChooseTimeDialog chooseTimeDialog, DialogInterface dialogInterface, int i) {
        int intValue;
        TimePicker timePicker = chooseTimeDialog.f11266O000000o;
        if (timePicker != null && (intValue = (timePicker.getCurrentHour().intValue() * 60) + timePicker.getCurrentMinute().intValue()) > 0) {
            for (Integer intValue2 : this.mCommonMinutes) {
                if (intValue2.intValue() == intValue) {
                    gqg.O00000Oo((int) R.string.count_down_already_set);
                    return;
                }
            }
            this.mCountDownView.setCurrentValue(intValue);
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(intValue));
            arrayList.addAll(this.mCommonMinutes);
            HashSet hashSet = new HashSet();
            hashSet.addAll(arrayList);
            int[] iArr = new int[hashSet.size()];
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (hashSet.contains(arrayList.get(i3))) {
                    iArr[i2] = ((Integer) arrayList.get(i3)).intValue();
                    hashSet.remove(arrayList.get(i3));
                    i2++;
                }
            }
            hrf hrf = this.mTimerManager;
            if (hrf != null) {
                hrf.O000000o(iArr);
            }
            O000000o();
        }
    }
}

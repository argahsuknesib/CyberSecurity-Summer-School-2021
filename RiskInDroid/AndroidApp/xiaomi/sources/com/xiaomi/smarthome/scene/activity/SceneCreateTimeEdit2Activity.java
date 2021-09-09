package com.xiaomi.smarthome.scene.activity;

import _m_j.ftn;
import _m_j.gnp;
import _m_j.gsy;
import _m_j.hpt;
import _m_j.izb;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.library.common.widget.TimePicker;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.model.CorntabUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class SceneCreateTimeEdit2Activity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f10814O000000o;
    private String O00000Oo;
    private boolean O00000o;
    private SceneApi.O000OOOo O00000o0;
    private int O00000oO = 0;
    private String[] O00000oo;
    private SceneApi.O0000o0 O0000O0o;
    @BindView(5829)
    ImageView mConfirmView;
    @BindView(5445)
    TextView mExecuteFrom;
    @BindView(5447)
    TimePicker mExecuteFromPicker;
    @BindView(5448)
    TextView mExecuteFromTitle;
    @BindView(5449)
    TextView mExecuteTo;
    @BindView(5451)
    TimePicker mExecuteToPicker;
    @BindView(5452)
    TextView mExecuteToTitle;
    @BindView(5094)
    SwitchButton mIsAlldaySwitch;
    @BindView(5093)
    View mIsAlldaySwitchLayout;
    public int mOffsetHours = 0;
    @BindView(6247)
    TextView mRepeatDayHint;
    public String mRepeatFilter;
    public boolean mRepeatTrigger;
    @BindView(5826)
    TextView mTitleView;
    public boolean[] mTriggerDays = new boolean[7];

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Arrays.fill(boolean[], boolean):void}
     arg types: [boolean[], int]
     candidates:
      ClspMth{java.util.Arrays.fill(double[], double):void}
      ClspMth{java.util.Arrays.fill(byte[], byte):void}
      ClspMth{java.util.Arrays.fill(long[], long):void}
      ClspMth{java.util.Arrays.fill(char[], char):void}
      ClspMth{java.util.Arrays.fill(short[], short):void}
      ClspMth{java.util.Arrays.fill(java.lang.Object[], java.lang.Object):void}
      ClspMth{java.util.Arrays.fill(int[], int):void}
      ClspMth{java.util.Arrays.fill(float[], float):void}
      ClspMth{java.util.Arrays.fill(boolean[], boolean):void} */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.layout_scene_create_time_edit2);
        ButterKnife.bind(this);
        this.f10814O000000o = getIntent().getBooleanExtra("is_from_recommend", false);
        if (!this.f10814O000000o) {
            this.O00000o0 = SmarthomeCreateAutoSceneActivity.mScene;
        } else {
            this.O00000o0 = hpt.O000000o().O0000OOo;
        }
        SceneApi.O000OOOo o000OOOo = this.O00000o0;
        if (o000OOOo == null) {
            gsy.O000000o(LogType.SCENE, "scene", "mScene == null");
            finish();
            return;
        }
        this.O00000Oo = o000OOOo.f11131O000000o;
        if (this.O00000o0.O0000oO == null) {
            this.O00000o0.O0000oO = new SceneApi.O0000o0();
        }
        this.O0000O0o = new SceneApi.O0000o0();
        if (this.O00000o0.O0000oO == null) {
            finish();
            return;
        }
        this.mRepeatFilter = this.O00000o0.O0000oO.O00000oo;
        if (this.O00000o0.O0000oO.f11125O000000o == this.O00000o0.O0000oO.O00000Oo && this.O00000o0.O0000oO.O00000o0 == this.O00000o0.O0000oO.O00000o) {
            this.O00000o = true;
        } else {
            this.O00000o = false;
        }
        CorntabUtils.CorntabParam corntabParam = new CorntabUtils.CorntabParam();
        corntabParam.O00000o0 = this.O00000o0.O0000oO.f11125O000000o;
        corntabParam.O00000Oo = this.O00000o0.O0000oO.O00000o0;
        if (this.O00000o0.O0000oO.O00000oO != null) {
            Arrays.fill(corntabParam.O0000O0o, false);
            for (int i : this.O00000o0.O0000oO.O00000oO) {
                corntabParam.O0000O0o[i] = true;
            }
        } else {
            Arrays.fill(corntabParam.O0000O0o, true);
        }
        CorntabUtils.CorntabParam O000000o2 = CorntabUtils.O000000o(TimeZone.getDefault(), TimeZone.getTimeZone("Asia/Shanghai"), corntabParam);
        CorntabUtils.CorntabParam corntabParam2 = new CorntabUtils.CorntabParam();
        corntabParam2.O00000o0 = this.O00000o0.O0000oO.O00000Oo;
        corntabParam2.O00000Oo = this.O00000o0.O0000oO.O00000o;
        if (this.O00000o0.O0000oO.O00000oO != null) {
            Arrays.fill(corntabParam2.O0000O0o, false);
            for (int i2 = 0; i2 < this.O00000o0.O0000oO.O00000oO.length; i2++) {
                if (this.O00000o0.O0000oO.f11125O000000o > this.O00000o0.O0000oO.O00000Oo || (this.O00000o0.O0000oO.f11125O000000o == this.O00000o0.O0000oO.O00000Oo && this.O00000o0.O0000oO.O00000o0 > this.O00000o0.O0000oO.O00000o)) {
                    corntabParam2.O0000O0o[(this.O00000o0.O0000oO.O00000oO[i2] + 1) % 7] = true;
                } else {
                    corntabParam2.O0000O0o[this.O00000o0.O0000oO.O00000oO[i2]] = true;
                }
            }
        }
        CorntabUtils.CorntabParam O000000o3 = CorntabUtils.O000000o(TimeZone.getDefault(), TimeZone.getTimeZone("Asia/Shanghai"), corntabParam2);
        this.mExecuteFromPicker.setIs24HourView(Boolean.TRUE);
        this.mExecuteFromPicker.setCurrentHour(Integer.valueOf(O000000o2.O00000o0));
        this.mExecuteFromPicker.setCurrentMinute(Integer.valueOf(O000000o2.O00000Oo));
        this.mExecuteToPicker.setIs24HourView(Boolean.TRUE);
        this.mExecuteToPicker.setCurrentHour(Integer.valueOf(O000000o3.O00000o0));
        this.mExecuteToPicker.setCurrentMinute(Integer.valueOf(O000000o3.O00000Oo));
        if (this.O00000o0.O0000oO.O00000oO != null) {
            for (int i3 = 0; i3 < 7; i3++) {
                this.mTriggerDays[i3] = O000000o2.O0000O0o[i3];
            }
            this.mRepeatTrigger = true;
        } else {
            this.O00000o0.O0000oO.O00000oO = new int[]{0, 1, 2, 3, 4, 5, 6};
            this.mRepeatTrigger = true;
        }
        if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            this.O00000oo = new String[]{getString(R.string.smarthome_scene_timer_everyday), getString(R.string.smarthome_scene_timer_official_workday), getString(R.string.smarthome_scene_timer_official_holiday), getString(R.string.smarthome_scene_custom)};
        } else {
            this.O00000oo = new String[]{getString(R.string.smarthome_scene_timer_everyday), getString(R.string.smarthome_scene_custom)};
        }
        this.mTitleView.setText((int) R.string.smarthome_scene_effective_timer_title);
        this.mConfirmView.setVisibility(0);
        this.mConfirmView.setContentDescription(getString(R.string.confirm_button));
        this.mConfirmView.setImageResource(R.drawable.title_right_tick_drawable);
        this.mIsAlldaySwitch.setChecked(this.O00000o);
        setTimerPikerUsable(this.O00000o);
        this.mIsAlldaySwitch.setOnPerformCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.scene.activity.SceneCreateTimeEdit2Activity.AnonymousClass1 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SceneCreateTimeEdit2Activity.this.mIsAlldaySwitch.setChecked(z);
                SceneCreateTimeEdit2Activity.this.setTimerPikerUsable(z);
            }
        });
        generateShortcutDaysHint();
        this.mOffsetHours = (int) TimeUnit.HOURS.convert((long) new GregorianCalendar().getTimeZone().getRawOffset(), TimeUnit.MILLISECONDS);
        this.mExecuteFromPicker.setOnTimeChangedListener(new TimePicker.O00000Oo() {
            /* class com.xiaomi.smarthome.scene.activity.SceneCreateTimeEdit2Activity.AnonymousClass2 */

            public final void onTimeChanged(TimePicker timePicker, int i, int i2) {
                SceneCreateTimeEdit2Activity sceneCreateTimeEdit2Activity = SceneCreateTimeEdit2Activity.this;
                sceneCreateTimeEdit2Activity.showNextTriggerHint(sceneCreateTimeEdit2Activity.mOffsetHours);
            }
        });
        this.mExecuteToPicker.setIs24HourView(Boolean.TRUE);
        this.mExecuteToPicker.setOnTimeChangedListener(new TimePicker.O00000Oo() {
            /* class com.xiaomi.smarthome.scene.activity.SceneCreateTimeEdit2Activity.AnonymousClass3 */

            public final void onTimeChanged(TimePicker timePicker, int i, int i2) {
                SceneCreateTimeEdit2Activity sceneCreateTimeEdit2Activity = SceneCreateTimeEdit2Activity.this;
                sceneCreateTimeEdit2Activity.showNextTriggerHint(sceneCreateTimeEdit2Activity.mOffsetHours);
            }
        });
        if (this.mIsAlldaySwitch.isChecked()) {
            this.mExecuteFromPicker.setCurrentHour(0);
            this.mExecuteFromPicker.setCurrentMinute(0);
            this.mExecuteToPicker.setCurrentHour(0);
            this.mExecuteToPicker.setCurrentMinute(0);
            return;
        }
        showNextTriggerHint(this.mOffsetHours);
    }

    public void onBackPressed() {
        O000000o();
    }

    @OnClick({5822, 5829, 6074, 5446, 5450, 5094, 5093})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.module_a_3_return_btn) {
            O000000o();
            return;
        }
        if (id == R.id.module_a_3_right_btn) {
            CorntabUtils.CorntabParam corntabParam = new CorntabUtils.CorntabParam();
            corntabParam.O00000o0 = this.mExecuteFromPicker.getCurrentHour().intValue();
            corntabParam.O00000Oo = this.mExecuteFromPicker.getCurrentMinute().intValue();
            if (this.mRepeatTrigger) {
                corntabParam.O0000O0o = this.mTriggerDays;
            } else {
                corntabParam.O0000O0o = new boolean[]{true, true, true, true, true, true, true};
            }
            CorntabUtils.CorntabParam O000000o2 = CorntabUtils.O000000o(TimeZone.getTimeZone("Asia/Shanghai"), TimeZone.getDefault(), corntabParam);
            CorntabUtils.CorntabParam corntabParam2 = new CorntabUtils.CorntabParam();
            corntabParam2.O00000o0 = this.mExecuteToPicker.getCurrentHour().intValue();
            corntabParam2.O00000Oo = this.mExecuteToPicker.getCurrentMinute().intValue();
            if (this.mRepeatTrigger) {
                corntabParam2.O0000O0o = this.mTriggerDays;
            } else {
                corntabParam2.O0000O0o = new boolean[]{true, true, true, true, true, true, true};
            }
            CorntabUtils.CorntabParam O000000o3 = CorntabUtils.O000000o(TimeZone.getTimeZone("Asia/Shanghai"), TimeZone.getDefault(), corntabParam2);
            this.O00000o0.O0000oO.f11125O000000o = O000000o2.O00000o0;
            this.O00000o0.O0000oO.O00000o0 = O000000o2.O00000Oo;
            this.O00000o0.O0000oO.O00000Oo = O000000o3.O00000o0;
            this.O00000o0.O0000oO.O00000o = O000000o3.O00000Oo;
            if (this.mRepeatTrigger) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < 7; i++) {
                    if (O000000o2.O0000O0o[i]) {
                        arrayList.add(Integer.valueOf(i));
                    }
                }
                this.O00000o0.O0000oO.O00000oO = new int[arrayList.size()];
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    this.O00000o0.O0000oO.O00000oO[i2] = ((Integer) arrayList.get(i2)).intValue();
                }
            }
            this.O00000o0.O0000oO.O00000oo = this.mRepeatFilter;
            if (!this.f10814O000000o) {
                SmarthomeCreateAutoSceneActivity.mScene = this.O00000o0;
            } else {
                hpt.O000000o().O0000OOo = this.O00000o0;
            }
            setResult(-1);
            finish();
        } else if (id == R.id.repeat_setting) {
            O00000Oo();
        } else if (id == R.id.execute_from_layout) {
            if (!this.mIsAlldaySwitch.isChecked()) {
                if (this.mExecuteFromPicker.getVisibility() == 0) {
                    this.mExecuteFromPicker.setVisibility(8);
                } else {
                    this.mExecuteFromPicker.setVisibility(0);
                }
                this.mExecuteToPicker.setVisibility(8);
            }
        } else if (id == R.id.execute_to_layout) {
            if (!this.mIsAlldaySwitch.isChecked()) {
                if (this.mExecuteToPicker.getVisibility() == 0) {
                    this.mExecuteToPicker.setVisibility(8);
                } else {
                    this.mExecuteToPicker.setVisibility(0);
                }
                this.mExecuteFromPicker.setVisibility(8);
            }
        } else if (id == R.id.all_day_setting || id == R.id.all_day_switch) {
            SwitchButton switchButton = this.mIsAlldaySwitch;
            switchButton.setChecked(!switchButton.isChecked());
            setTimerPikerUsable(this.mIsAlldaySwitch.isChecked());
        }
    }

    public void setTimerPikerUsable(boolean z) {
        if (z) {
            this.mExecuteFromPicker.setCurrentHour(0);
            this.mExecuteFromPicker.setCurrentMinute(0);
            this.mExecuteToPicker.setCurrentHour(0);
            this.mExecuteToPicker.setCurrentMinute(0);
            this.mExecuteFromPicker.setVisibility(8);
            this.mExecuteToPicker.setVisibility(8);
            showNextTriggerHint(this.mOffsetHours);
            this.mExecuteFromTitle.setTextColor(getContext().getResources().getColor(R.color.mj_color_gray_normal));
            this.mExecuteToTitle.setTextColor(getContext().getResources().getColor(R.color.mj_color_gray_normal));
            return;
        }
        this.mExecuteFromTitle.setTextColor(getContext().getResources().getColor(R.color.mj_color_black_100_transparent));
        this.mExecuteToTitle.setTextColor(getContext().getResources().getColor(R.color.mj_color_black_100_transparent));
    }

    private void O000000o() {
        if (this.O0000O0o == null) {
            finish();
            return;
        }
        CorntabUtils.CorntabParam corntabParam = new CorntabUtils.CorntabParam();
        corntabParam.O00000o0 = this.mExecuteFromPicker.getCurrentHour().intValue();
        corntabParam.O00000Oo = this.mExecuteFromPicker.getCurrentMinute().intValue();
        if (this.mRepeatTrigger) {
            corntabParam.O0000O0o = this.mTriggerDays;
        } else {
            corntabParam.O0000O0o = new boolean[]{true, true, true, true, true, true, true};
        }
        CorntabUtils.CorntabParam O000000o2 = CorntabUtils.O000000o(TimeZone.getTimeZone("Asia/Shanghai"), TimeZone.getDefault(), corntabParam);
        CorntabUtils.CorntabParam corntabParam2 = new CorntabUtils.CorntabParam();
        corntabParam2.O00000o0 = this.mExecuteToPicker.getCurrentHour().intValue();
        corntabParam2.O00000Oo = this.mExecuteToPicker.getCurrentMinute().intValue();
        if (this.mRepeatTrigger) {
            corntabParam2.O0000O0o = this.mTriggerDays;
        } else {
            corntabParam2.O0000O0o = new boolean[]{true, true, true, true, true, true, true};
        }
        CorntabUtils.CorntabParam O000000o3 = CorntabUtils.O000000o(TimeZone.getTimeZone("Asia/Shanghai"), TimeZone.getDefault(), corntabParam2);
        this.O0000O0o.f11125O000000o = O000000o2.O00000o0;
        this.O0000O0o.O00000o0 = O000000o2.O00000Oo;
        this.O0000O0o.O00000Oo = O000000o3.O00000o0;
        this.O0000O0o.O00000o = O000000o3.O00000Oo;
        SceneApi.O0000o0 o0000o0 = this.O0000O0o;
        o0000o0.O00000oo = this.mRepeatFilter;
        if (o0000o0.O000000o(this.O00000o0.O0000oO)) {
            finish();
        } else {
            new MLAlertDialog.Builder(this).O00000Oo((int) R.string.smarthome_scene_quit).O000000o((int) R.string.smarthome_scene_quest_ok, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.SceneCreateTimeEdit2Activity.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    SceneCreateTimeEdit2Activity.this.finish();
                }
            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.SceneCreateTimeEdit2Activity.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            }).O00000oo();
        }
    }

    private void O00000Oo() {
        int i = 0;
        if (TextUtils.equals(this.mRepeatFilter, "cn_workday")) {
            this.O00000oO = 255;
        } else if (TextUtils.equals(this.mRepeatFilter, "cn_freeday")) {
            this.O00000oO = 254;
        } else {
            this.O00000oO = 0;
            for (int i2 = 0; i2 < 7; i2++) {
                this.O00000oO <<= 1;
                if (this.mTriggerDays[i2]) {
                    this.O00000oO++;
                }
            }
        }
        int i3 = this.O00000oO;
        if (i3 != 127) {
            if (i3 != 255) {
                if (i3 == 254) {
                    i = 2;
                } else if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                    i = 3;
                }
            }
            i = 1;
        }
        MLAlertDialog O00000o2 = new MLAlertDialog.Builder(this).O000000o(this.O00000oo, i, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SceneCreateTimeEdit2Activity$nUI8OP48FIHAXD3Stne7IZ_QAo */

            public final void onClick(DialogInterface dialogInterface, int i) {
                SceneCreateTimeEdit2Activity.this.O000000o(dialogInterface, i);
            }
        }).O00000o();
        O00000o2.show();
        gnp.O000000o(O00000o2.getContext(), O00000o2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            this.mRepeatTrigger = true;
            this.mRepeatFilter = null;
            this.mTriggerDays = new boolean[]{true, true, true, true, true, true, true};
            generateShortcutDaysHint();
            showNextTriggerHint(this.mOffsetHours);
            dialogInterface.dismiss();
        } else if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && i == 1) {
            this.mRepeatTrigger = true;
            this.mRepeatFilter = "cn_workday";
            this.mTriggerDays = new boolean[]{true, true, true, true, true, true, true};
            generateShortcutDaysHint();
            showNextTriggerHint(this.mOffsetHours);
            dialogInterface.dismiss();
        } else if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && i == 2) {
            this.mRepeatTrigger = true;
            this.mRepeatFilter = "cn_freeday";
            this.mTriggerDays = new boolean[]{true, true, true, true, true, true, true};
            generateShortcutDaysHint();
            showNextTriggerHint(this.mOffsetHours);
            dialogInterface.dismiss();
        } else if ((!ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && i == 3) || (ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && i == 1)) {
            final boolean[] zArr = (boolean[]) this.mTriggerDays.clone();
            dialogInterface.dismiss();
            MLAlertDialog O00000o2 = new MLAlertDialog.Builder(this).O000000o((int) R.array.weekday, zArr, new DialogInterface.OnMultiChoiceClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.SceneCreateTimeEdit2Activity.AnonymousClass8 */

                public final void onClick(DialogInterface dialogInterface, int i, boolean z) {
                    zArr[i] = z;
                }
            }).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.SceneCreateTimeEdit2Activity.AnonymousClass7 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    boolean z = SceneCreateTimeEdit2Activity.this.mRepeatTrigger;
                    boolean[] zArr = SceneCreateTimeEdit2Activity.this.mTriggerDays;
                    SceneCreateTimeEdit2Activity sceneCreateTimeEdit2Activity = SceneCreateTimeEdit2Activity.this;
                    sceneCreateTimeEdit2Activity.mRepeatTrigger = true;
                    sceneCreateTimeEdit2Activity.mTriggerDays = zArr;
                    sceneCreateTimeEdit2Activity.mRepeatFilter = null;
                    if (!sceneCreateTimeEdit2Activity.generateShortcutDaysHint()) {
                        SceneCreateTimeEdit2Activity sceneCreateTimeEdit2Activity2 = SceneCreateTimeEdit2Activity.this;
                        sceneCreateTimeEdit2Activity2.mRepeatTrigger = z;
                        sceneCreateTimeEdit2Activity2.mTriggerDays = zArr;
                        izb.O000000o(sceneCreateTimeEdit2Activity2, (int) R.string.smarthome_span_error, 0).show();
                        return;
                    }
                    SceneCreateTimeEdit2Activity sceneCreateTimeEdit2Activity3 = SceneCreateTimeEdit2Activity.this;
                    sceneCreateTimeEdit2Activity3.showNextTriggerHint(sceneCreateTimeEdit2Activity3.mOffsetHours);
                    ((MLAlertDialog) dialogInterface).setAudoDismiss(true);
                }
            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.SceneCreateTimeEdit2Activity.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ((MLAlertDialog) dialogInterface).setAudoDismiss(true);
                }
            }).O00000o();
            O00000o2.show();
            gnp.O000000o(O00000o2.getContext(), O00000o2);
        }
    }

    public boolean generateShortcutDaysHint() {
        String str;
        this.O00000oO = 0;
        StringBuilder sb = new StringBuilder();
        if (TextUtils.equals(this.mRepeatFilter, "cn_workday")) {
            this.O00000oO = 255;
        } else if (TextUtils.equals(this.mRepeatFilter, "cn_freeday")) {
            this.O00000oO = 254;
        } else {
            TypedArray obtainTypedArray = getResources().obtainTypedArray(R.array.weekday_short);
            boolean z = false;
            for (int i = 0; i < 7; i++) {
                this.O00000oO <<= 1;
                if (this.mTriggerDays[i]) {
                    this.O00000oO++;
                    if (i == 0) {
                        z = true;
                    } else {
                        sb.append(". ");
                        sb.append(obtainTypedArray.getString(i));
                    }
                }
            }
            if (z) {
                sb.append(". ");
                sb.append(obtainTypedArray.getString(0));
            }
            obtainTypedArray.recycle();
        }
        int i2 = this.O00000oO;
        if (i2 == 0) {
            return false;
        }
        this.mRepeatTrigger = true;
        if (i2 == 127) {
            str = getResources().getString(R.string.smarthome_scene_timer_everyday);
        } else if (i2 == 254) {
            str = getResources().getString(R.string.smarthome_scene_timer_official_holiday);
        } else if (i2 != 255) {
            str = sb.substring(1);
        } else {
            str = getResources().getString(R.string.smarthome_scene_timer_official_workday);
        }
        this.mRepeatDayHint.setText(str);
        return true;
    }

    public void showNextTriggerHint(int i) {
        int intValue = this.mExecuteFromPicker.getCurrentHour().intValue();
        int intValue2 = this.mExecuteFromPicker.getCurrentMinute().intValue();
        int intValue3 = this.mExecuteToPicker.getCurrentHour().intValue();
        int intValue4 = this.mExecuteToPicker.getCurrentMinute().intValue();
        if (this.mExecuteFromPicker.getVisibility() == 0) {
            this.mExecuteFrom.setText(O000000o(intValue, intValue2));
        } else if (this.mExecuteToPicker.getVisibility() == 0) {
            if (intValue3 < intValue) {
                TextView textView = this.mExecuteTo;
                textView.setText(O000000o(intValue3, intValue4) + "(" + getResources().getString(R.string.scene_exetime_second_day) + ")");
                return;
            }
            this.mExecuteTo.setText(O000000o(intValue3, intValue4));
        } else if (this.mExecuteFromPicker.getVisibility() != 8 || this.mExecuteToPicker.getVisibility() != 8) {
        } else {
            if (this.mIsAlldaySwitch.isChecked()) {
                this.mExecuteFrom.setText(O000000o(0, 0));
                this.mExecuteTo.setText(O000000o(0, 0));
                return;
            }
            CorntabUtils.CorntabParam corntabParam = new CorntabUtils.CorntabParam();
            corntabParam.O00000o0 = this.O00000o0.O0000oO.f11125O000000o;
            corntabParam.O00000Oo = this.O00000o0.O0000oO.O00000o0;
            CorntabUtils.CorntabParam O000000o2 = CorntabUtils.O000000o(TimeZone.getDefault(), TimeZone.getTimeZone("Asia/Shanghai"), corntabParam);
            CorntabUtils.CorntabParam corntabParam2 = new CorntabUtils.CorntabParam();
            corntabParam2.O00000o0 = this.O00000o0.O0000oO.O00000Oo;
            corntabParam2.O00000Oo = this.O00000o0.O0000oO.O00000o;
            CorntabUtils.CorntabParam O000000o3 = CorntabUtils.O000000o(TimeZone.getDefault(), TimeZone.getTimeZone("Asia/Shanghai"), corntabParam2);
            this.mExecuteFrom.setText(O000000o(O000000o2.O00000o0, O000000o2.O00000Oo));
            this.mExecuteTo.setText(O000000o(O000000o3.O00000o0, O000000o3.O00000Oo));
        }
    }

    private static String O000000o(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        if (i < 0 || i >= 10) {
            sb.append(i);
        } else {
            sb.append("0".concat(String.valueOf(i)));
        }
        sb.append(":");
        if (i2 < 0 || i2 >= 10) {
            sb.append(i2);
        } else {
            sb.append("0".concat(String.valueOf(i2)));
        }
        return sb.toString();
    }
}

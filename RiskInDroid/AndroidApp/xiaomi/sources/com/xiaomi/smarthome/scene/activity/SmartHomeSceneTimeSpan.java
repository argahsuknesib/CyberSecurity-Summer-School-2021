package com.xiaomi.smarthome.scene.activity;

import _m_j.hpq;
import _m_j.izb;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.HourSpanPicker;
import com.xiaomi.smarthome.scene.api.SceneApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class SmartHomeSceneTimeSpan extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    String f10972O000000o;
    SceneApi.O000OOOo O00000Oo;
    TextView O00000o;
    Context O00000o0;
    View O00000oO;
    View O00000oo;
    boolean[] O0000O0o;
    TextView O0000OOo;
    HourSpanPicker O0000Oo;
    boolean O0000Oo0;
    TextView O0000OoO;
    SceneApi.O00000Oo O0000Ooo;
    int O0000o0;
    String[] O0000o00;

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
        setContentView((int) R.layout.smarthome_scene_timespan);
        this.O00000o0 = this;
        this.O00000o = (TextView) findViewById(R.id.module_a_3_return_title);
        this.O00000o.setText((int) R.string.smarthome_scene_timer_title);
        this.O00000oO = findViewById(R.id.module_a_3_return_btn);
        this.O00000oO.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimeSpan.AnonymousClass1 */

            public final void onClick(View view) {
                SmartHomeSceneTimeSpan.this.finish();
            }
        });
        this.O00000oo = findViewById(R.id.module_a_3_right_text_btn);
        ((TextView) this.O00000oo).setText((int) R.string.ok_button);
        this.O00000oo.setEnabled(true);
        this.O0000OOo = (TextView) findViewById(R.id.smarthome_scene_timer_day_hint);
        this.O0000OoO = (TextView) findViewById(R.id.smarthome_scene_time_hint);
        this.O0000Oo = (HourSpanPicker) findViewById(R.id.smarthome_scene_time_picker);
        this.O0000Oo.setOnTimeChangedListener(new HourSpanPicker.O000000o() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimeSpan.AnonymousClass2 */

            public final void O000000o() {
                SmartHomeSceneTimeSpan.this.showNextTriggerHint();
            }
        });
        findViewById(R.id.smarthome_scene_day_settting).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimeSpan.AnonymousClass3 */

            public final void onClick(View view) {
                SmartHomeSceneTimeSpan.this.showDayOptions();
            }
        });
        this.O00000oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimeSpan.AnonymousClass4 */

            public final void onClick(View view) {
                SmartHomeSceneTimeSpan.this.saveTimerSettings();
            }
        });
        this.O00000Oo = SmartHomeSceneCreateEditActivity.mScene;
        SceneApi.O000OOOo o000OOOo = this.O00000Oo;
        if (o000OOOo == null) {
            finish();
            return;
        }
        this.f10972O000000o = o000OOOo.f11131O000000o;
        this.O0000Ooo = hpq.O000000o().O00000oO.O00000o0;
        this.O0000O0o = new boolean[7];
        Arrays.fill(this.O0000O0o, false);
        int convert = (int) TimeUnit.HOURS.convert((long) new GregorianCalendar().getTimeZone().getRawOffset(), TimeUnit.MILLISECONDS);
        SceneApi.O00000Oo o00000Oo = this.O0000Ooo;
        if (o00000Oo != null) {
            this.O0000Oo.setFromHour(Integer.valueOf((((o00000Oo.O00000oO + convert) - 8) + 24) % 24));
            this.O0000Oo.setToHour(Integer.valueOf((((this.O0000Ooo.O00000oo + convert) - 8) + 24) % 24));
            if (this.O0000Ooo.O0000Oo0 != null) {
                int i = 0;
                while (i < this.O0000Ooo.O0000Oo0.length && i < 7 && this.O0000Ooo.O0000Oo0[i] < 7) {
                    this.O0000O0o[this.O0000Ooo.O0000Oo0[i]] = true;
                    i++;
                }
                this.O0000Oo0 = true;
            } else {
                Arrays.fill(this.O0000O0o, true);
                this.O0000Ooo.O0000Oo0 = new int[this.O0000O0o.length];
                for (int i2 = 0; i2 < this.O0000O0o.length; i2++) {
                    this.O0000Ooo.O0000Oo0[i2] = i2;
                }
            }
            generateShortcutDaysHint();
            showNextTriggerHint();
        } else {
            finish();
        }
        this.O0000o00 = new String[]{getString(R.string.smarthome_scene_timer_everyday), getString(R.string.smarthome_scene_timer_workday), getString(R.string.smarthome_scene_custom)};
    }

    public void saveTimerSettings() {
        int intValue = this.O0000Oo.getFromHour().intValue();
        int intValue2 = this.O0000Oo.getToHour().intValue();
        int convert = (int) TimeUnit.HOURS.convert((long) new GregorianCalendar().getTimeZone().getRawOffset(), TimeUnit.MILLISECONDS);
        SceneApi.O00000Oo o00000Oo = this.O0000Ooo;
        o00000Oo.O00000oO = (((intValue - convert) + 8) + 24) % 24;
        o00000Oo.O0000O0o = 0;
        o00000Oo.O00000oo = (((intValue2 - convert) + 8) + 24) % 24;
        o00000Oo.O0000OOo = 0;
        if (this.O0000Oo0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 7; i++) {
                if (this.O0000O0o[i]) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            this.O0000Ooo.O0000Oo0 = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                this.O0000Ooo.O0000Oo0[i2] = ((Integer) arrayList.get(i2)).intValue();
            }
        }
        setResult(-1);
        finish();
    }

    public boolean generateShortcutDaysHint() {
        String str;
        this.O0000o0 = 0;
        TypedArray obtainTypedArray = getResources().obtainTypedArray(R.array.weekday_short);
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i = 0; i < 7; i++) {
            this.O0000o0 <<= 1;
            if (this.O0000O0o[i]) {
                this.O0000o0++;
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
        int i2 = this.O0000o0;
        if (i2 == 0) {
            obtainTypedArray.recycle();
            return false;
        }
        this.O0000Oo0 = true;
        if (i2 == 62) {
            str = getResources().getString(R.string.smarthome_scene_timer_workday);
        } else if (i2 != 127) {
            str = sb.substring(1);
        } else {
            str = getResources().getString(R.string.smarthome_scene_timer_everyday);
        }
        this.O0000OOo.setText(str);
        obtainTypedArray.recycle();
        return true;
    }

    public void showNextTriggerHint() {
        int intValue = this.O0000Oo.getFromHour().intValue();
        int intValue2 = this.O0000Oo.getToHour().intValue();
        TextView textView = this.O0000OoO;
        textView.setText(intValue + ":00-" + intValue2 + ":00");
    }

    public void showDayOptions() {
        int i = 0;
        this.O0000o0 = 0;
        for (int i2 = 0; i2 < 7; i2++) {
            this.O0000o0 <<= 1;
            if (this.O0000O0o[i2]) {
                this.O0000o0++;
            }
        }
        int i3 = this.O0000o0;
        if (i3 != 127) {
            i = i3 == 62 ? 1 : 2;
        }
        new MLAlertDialog.Builder(this).O000000o(this.O0000o00, i, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimeSpan.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    SmartHomeSceneTimeSpan smartHomeSceneTimeSpan = SmartHomeSceneTimeSpan.this;
                    smartHomeSceneTimeSpan.O0000Oo0 = true;
                    smartHomeSceneTimeSpan.O0000O0o = new boolean[]{true, true, true, true, true, true, true};
                    smartHomeSceneTimeSpan.generateShortcutDaysHint();
                    SmartHomeSceneTimeSpan.this.showNextTriggerHint();
                    dialogInterface.dismiss();
                } else if (i == 1) {
                    SmartHomeSceneTimeSpan smartHomeSceneTimeSpan2 = SmartHomeSceneTimeSpan.this;
                    smartHomeSceneTimeSpan2.O0000Oo0 = true;
                    smartHomeSceneTimeSpan2.O0000O0o = new boolean[]{false, true, true, true, true, true, false};
                    smartHomeSceneTimeSpan2.generateShortcutDaysHint();
                    SmartHomeSceneTimeSpan.this.showNextTriggerHint();
                    dialogInterface.dismiss();
                } else if (i == 2) {
                    final boolean[] zArr = (boolean[]) SmartHomeSceneTimeSpan.this.O0000O0o.clone();
                    dialogInterface.dismiss();
                    new MLAlertDialog.Builder(SmartHomeSceneTimeSpan.this.O00000o0).O000000o((int) R.array.weekday, zArr, new DialogInterface.OnMultiChoiceClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimeSpan.AnonymousClass5.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i, boolean z) {
                            zArr[i] = z;
                        }
                    }).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimeSpan.AnonymousClass5.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            boolean z = SmartHomeSceneTimeSpan.this.O0000Oo0;
                            boolean[] zArr = SmartHomeSceneTimeSpan.this.O0000O0o;
                            SmartHomeSceneTimeSpan.this.O0000Oo0 = true;
                            SmartHomeSceneTimeSpan.this.O0000O0o = zArr;
                            if (!SmartHomeSceneTimeSpan.this.generateShortcutDaysHint()) {
                                SmartHomeSceneTimeSpan.this.O0000Oo0 = z;
                                SmartHomeSceneTimeSpan.this.O0000O0o = zArr;
                                izb.O000000o(SmartHomeSceneTimeSpan.this, (int) R.string.smarthome_span_error, 0).show();
                                return;
                            }
                            SmartHomeSceneTimeSpan.this.showNextTriggerHint();
                            ((MLAlertDialog) dialogInterface).setAudoDismiss(true);
                        }
                    }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimeSpan.AnonymousClass5.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ((MLAlertDialog) dialogInterface).setAudoDismiss(true);
                        }
                    }).O00000Oo(false).O00000o().show();
                }
            }
        }).O00000o().show();
    }
}

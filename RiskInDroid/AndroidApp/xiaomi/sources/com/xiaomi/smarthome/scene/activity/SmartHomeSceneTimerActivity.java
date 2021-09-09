package com.xiaomi.smarthome.scene.activity;

import _m_j.ftn;
import _m_j.gnp;
import _m_j.hpq;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.TimePicker;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;
import com.xiaomi.smarthome.scene.model.CorntabUtils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class SmartHomeSceneTimerActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f10981O000000o;
    TextView O00000Oo;
    View O00000o;
    View O00000o0;
    boolean[] O00000oO;
    TextView O00000oo;
    boolean O0000O0o;
    TimePicker O0000OOo;
    SceneApi.O0000o O0000Oo;
    TextView O0000Oo0;
    String[] O0000OoO;
    int O0000Ooo;
    boolean O0000o0;
    String O0000o00;
    boolean O0000o0O;
    private CorntabUtils.CorntabParam O0000o0o = null;

    public static String getRemainTimeHint(Context context, SceneApi.O0000o o0000o) {
        return null;
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
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.smarthome_scene_timer_setting_activity);
        this.f10981O000000o = this;
        Intent intent = getIntent();
        this.O0000o0 = intent.getBooleanExtra("from_plugin", false);
        this.O0000o0O = intent.getBooleanExtra("hideLegalTime", false);
        String stringExtra = intent.getStringExtra("title");
        this.O00000Oo = (TextView) findViewById(R.id.module_a_4_return_more_title);
        if (!TextUtils.isEmpty(stringExtra)) {
            this.O00000Oo.setText(stringExtra);
        } else {
            this.O00000Oo.setText((int) R.string.smarthome_scene_timer_title);
        }
        this.O00000o0 = findViewById(R.id.module_a_4_return_more_btn);
        this.O00000o0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimerActivity.AnonymousClass1 */

            public final void onClick(View view) {
                SmartHomeSceneTimerActivity.this.finish();
            }
        });
        this.O00000o = findViewById(R.id.module_a_4_return_finish_btn);
        ((TextView) this.O00000o).setText((int) R.string.confirm_button);
        this.O00000o.setEnabled(true);
        this.O00000oo = (TextView) findViewById(R.id.smarthome_scene_timer_day_hint);
        this.O0000Oo0 = (TextView) findViewById(R.id.smarthome_scene_time_hint);
        this.O0000OOo = (TimePicker) findViewById(R.id.smarthome_scene_time_picker);
        this.O0000OOo.setIs24HourView(Boolean.TRUE);
        Calendar instance = Calendar.getInstance();
        this.O0000OOo.setCurrentHour(Integer.valueOf(instance.get(11)));
        this.O0000OOo.setCurrentMinute(Integer.valueOf(instance.get(12)));
        this.O0000OOo.setOnTimeChangedListener(new TimePicker.O00000Oo() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimerActivity.AnonymousClass2 */

            public final void onTimeChanged(TimePicker timePicker, int i, int i2) {
                SmartHomeSceneTimerActivity.this.showNextTriggerHint();
            }
        });
        findViewById(R.id.smarthome_scene_day_settting).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimerActivity.AnonymousClass3 */

            public final void onClick(View view) {
                SmartHomeSceneTimerActivity.this.showDayOptions();
            }
        });
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimerActivity.AnonymousClass4 */

            public final void onClick(View view) {
                SmartHomeSceneTimerActivity.this.saveTimerSettings();
            }
        });
        this.O0000o0o = (CorntabUtils.CorntabParam) getIntent().getParcelableExtra("time_param");
        this.O0000o00 = getIntent().getStringExtra("time_filter");
        if (this.O0000o0) {
            String stringExtra2 = getIntent().getStringExtra("crontab");
            if (!TextUtils.isEmpty(stringExtra2)) {
                this.O0000o0o = CorntabUtils.O00000Oo(stringExtra2);
                if (this.O0000o0o == null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("result", false);
                    setResult(0, intent2);
                    finish();
                }
            }
        }
        CorntabUtils.CorntabParam corntabParam = this.O0000o0o;
        if (corntabParam != null) {
            O000000o(corntabParam);
        } else if (this.O0000o0) {
            O000000o(null);
        } else {
            SceneApi.O000000o o000000o = hpq.O000000o().O00000oO;
            if (o000000o == null) {
                finish();
                return;
            }
            this.O0000Oo = o000000o.O00000Oo;
            SceneApi.O0000o o0000o = this.O0000Oo;
            this.O0000o00 = o0000o == null ? "" : o0000o.O00000Oo;
            SceneApi.O0000o o0000o2 = this.O0000Oo;
            if (o0000o2 != null) {
                O000000o(o0000o2.f11124O000000o);
            } else {
                O000000o(null);
            }
        }
        if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) || this.O0000o0O) {
            this.O0000OoO = new String[]{getString(R.string.smarthome_scene_timer_once), getString(R.string.smarthome_scene_timer_everyday), getString(R.string.smarthome_scene_custom)};
        } else {
            this.O0000OoO = new String[]{getString(R.string.smarthome_scene_timer_once), getString(R.string.smarthome_scene_timer_everyday), getString(R.string.smarthome_scene_timer_official_workday), getString(R.string.smarthome_scene_timer_official_holiday), getString(R.string.smarthome_scene_custom)};
        }
    }

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
    private void O000000o(CorntabUtils.CorntabParam corntabParam) {
        this.O00000oO = new boolean[7];
        Arrays.fill(this.O00000oO, false);
        if (corntabParam != null) {
            CorntabUtils.CorntabParam O000000o2 = CorntabUtils.O000000o(TimeZone.getDefault(), TimeZone.getTimeZone("Asia/Shanghai"), corntabParam);
            this.O0000OOo.setCurrentHour(Integer.valueOf(O000000o2.O00000o0 % 24));
            this.O0000OOo.setCurrentMinute(Integer.valueOf(O000000o2.O00000Oo));
            if (O000000o2.O00000Oo() == 0) {
                this.O0000O0o = false;
            } else {
                this.O00000oO = O000000o2.O0000O0o;
                this.O0000O0o = true;
            }
            generateShortcutDaysHint();
            showNextTriggerHint();
        }
    }

    private CorntabUtils.CorntabParam O000000o() {
        TimePicker timePicker = this.O0000OOo;
        boolean[] zArr = this.O00000oO;
        boolean z = this.O0000O0o;
        Calendar instance = Calendar.getInstance();
        CorntabUtils.CorntabParam corntabParam = new CorntabUtils.CorntabParam();
        int intValue = timePicker.getCurrentHour().intValue();
        int intValue2 = timePicker.getCurrentMinute().intValue();
        int i = instance.get(11);
        int i2 = 0;
        boolean z2 = intValue < i || (intValue == i && intValue2 <= instance.get(12));
        instance.set(11, intValue);
        instance.set(12, intValue2);
        instance.set(13, 0);
        Calendar instance2 = Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"));
        if (instance2 != null) {
            instance2.setTimeInMillis(instance.getTimeInMillis());
        } else {
            instance2 = instance;
        }
        if (z2) {
            instance2.add(5, 1);
        }
        if (z) {
            corntabParam.O00000o0 = instance2.get(11);
            corntabParam.O00000Oo = instance2.get(12);
            for (int i3 = 0; i3 < zArr.length; i3++) {
                corntabParam.O000000o(i3, zArr[i3 % zArr.length]);
            }
            long currentTimeMillis = System.currentTimeMillis();
            int convert = (instance.get(11) * 60) + instance.get(12) + ((int) (TimeUnit.MINUTES.convert((long) TimeZone.getTimeZone("Asia/Shanghai").getOffset(currentTimeMillis), TimeUnit.MILLISECONDS) - TimeUnit.MINUTES.convert((long) TimeZone.getDefault().getOffset(currentTimeMillis), TimeUnit.MILLISECONDS)));
            boolean[] zArr2 = new boolean[7];
            if (convert < 0) {
                while (i2 < corntabParam.O0000O0o.length) {
                    zArr2[(i2 + 6) % 7] = corntabParam.O0000O0o[i2];
                    i2++;
                }
                corntabParam.O0000O0o = zArr2;
            } else if (convert >= 1440) {
                while (i2 < corntabParam.O0000O0o.length) {
                    int i4 = i2 + 1;
                    zArr2[i4 % 7] = corntabParam.O0000O0o[i2];
                    i2 = i4;
                }
                corntabParam.O0000O0o = zArr2;
            }
        } else {
            corntabParam.O000000o(0);
            if (corntabParam.O00000o == -1) {
                corntabParam.O00000o0 = instance2.get(11);
                corntabParam.O00000Oo = instance2.get(12);
            } else {
                corntabParam.O00000o = instance2.get(5);
                corntabParam.O00000oO = instance2.get(2) + 1;
                corntabParam.O00000o0 = instance2.get(11);
                corntabParam.O00000Oo = instance2.get(12);
            }
        }
        return corntabParam;
    }

    public void saveTimerSettings() {
        if (this.O0000o0) {
            String O000000o2 = CorntabUtils.O000000o(O000000o());
            Intent intent = new Intent();
            intent.putExtra("crontab", O000000o2);
            setResult(-1, intent);
            finish();
            return;
        }
        if (this.O0000o0o != null) {
            Intent intent2 = new Intent();
            intent2.putExtra("time_param", O000000o());
            SceneApi.O0000o o0000o = this.O0000Oo;
            if (o0000o == null) {
                intent2.putExtra("time_filter", o0000o.O00000Oo);
            }
            setResult(-1, intent2);
        } else {
            if (this.O0000Oo == null) {
                this.O0000Oo = new SceneApi.O0000o();
            }
            SceneApi.O000000o o000000o = hpq.O000000o().O00000oO;
            if (o000000o != null) {
                o000000o.O00000Oo = this.O0000Oo;
                o000000o.f11121O000000o = LAUNCH_TYPE.TIMER;
                o000000o.O00000Oo.f11124O000000o = O000000o();
                setResult(-1);
            }
        }
        finish();
    }

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
    public static String getTimerHint(Context context, SceneApi.O0000o o0000o) {
        String str;
        String str2;
        int i;
        String str3 = "";
        if (o0000o == null) {
            return null;
        }
        CorntabUtils.CorntabParam corntabParam = o0000o.f11124O000000o;
        boolean[] zArr = new boolean[7];
        Arrays.fill(zArr, false);
        if (corntabParam == null) {
            return null;
        }
        CorntabUtils.CorntabParam O000000o2 = CorntabUtils.O000000o(TimeZone.getDefault(), TimeZone.getTimeZone("Asia/Shanghai"), corntabParam);
        if (O000000o2.O00000Oo < 10) {
            str = "0" + O000000o2.O00000Oo;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(O000000o2.O00000Oo);
            str = sb.toString();
        }
        try {
            str2 = context.getString(R.string.smarthome_time_hint, Integer.valueOf(O000000o2.O00000o0), str);
        } catch (Exception unused) {
            str2 = str3;
        }
        StringBuilder sb2 = new StringBuilder();
        if (TextUtils.equals(o0000o.O00000Oo, "cn_workday")) {
            i = 255;
        } else if (TextUtils.equals(o0000o.O00000Oo, "cn_freeday")) {
            i = 254;
        } else {
            TypedArray obtainTypedArray = context.getResources().obtainTypedArray(R.array.weekday_short);
            if (O000000o2.O00000Oo() != 0) {
                zArr = O000000o2.O0000O0o;
            }
            boolean z = false;
            i = 0;
            for (int i2 = 0; i2 < 7; i2++) {
                i <<= 1;
                if (zArr[i2]) {
                    i++;
                    if (i2 == 0) {
                        z = true;
                    } else {
                        sb2.append(". ");
                        sb2.append(obtainTypedArray.getString(i2));
                    }
                }
            }
            if (z) {
                sb2.append(". ");
                sb2.append(obtainTypedArray.getString(0));
            }
            obtainTypedArray.recycle();
        }
        if (i != 0) {
            if (i == 127) {
                str3 = context.getResources().getString(R.string.smarthome_scene_timer_everyday);
            } else if (i == 254) {
                str3 = context.getResources().getString(R.string.smarthome_scene_timer_official_holiday);
            } else if (i != 255) {
                str3 = sb2.substring(1);
            } else {
                str3 = context.getResources().getString(R.string.smarthome_scene_timer_official_workday);
            }
        }
        return str3 + str2;
    }

    public void generateShortcutDaysHint() {
        String str;
        this.O0000Ooo = 0;
        StringBuilder sb = new StringBuilder();
        if (TextUtils.equals("cn_workday", this.O0000o00)) {
            this.O0000Ooo = 255;
        } else if (TextUtils.equals("cn_freeday", this.O0000o00)) {
            this.O0000Ooo = 254;
        } else {
            TypedArray obtainTypedArray = getResources().obtainTypedArray(R.array.weekday_short);
            boolean z = false;
            for (int i = 0; i < 7; i++) {
                this.O0000Ooo <<= 1;
                if (this.O00000oO[i]) {
                    this.O0000Ooo++;
                    if (i == 0) {
                        z = true;
                    } else {
                        sb.append(", ");
                        sb.append(obtainTypedArray.getString(i));
                    }
                }
            }
            if (z) {
                sb.append(", ");
                sb.append(obtainTypedArray.getString(0));
            }
            obtainTypedArray.recycle();
        }
        this.O0000O0o = true;
        int i2 = this.O0000Ooo;
        if (i2 == 0) {
            String string = getResources().getString(R.string.smarthome_scene_timer_once);
            this.O0000O0o = false;
            str = string;
        } else if (i2 == 127) {
            str = getResources().getString(R.string.smarthome_scene_timer_everyday);
        } else if (i2 == 254) {
            str = getResources().getString(R.string.smarthome_scene_timer_official_holiday);
        } else if (i2 != 255) {
            str = sb.substring(1);
        } else {
            str = getResources().getString(R.string.smarthome_scene_timer_official_workday);
        }
        this.O00000oo.setText(str);
    }

    public void showNextTriggerHint() {
        this.O0000Oo0.setText("");
    }

    public void showDayOptions() {
        int i = 0;
        if (TextUtils.equals(this.O0000o00, "cn_workday")) {
            this.O0000Ooo = 255;
        } else if (TextUtils.equals(this.O0000o00, "cn_freeday")) {
            this.O0000Ooo = 254;
        } else {
            this.O0000Ooo = 0;
            for (int i2 = 0; i2 < 7; i2++) {
                this.O0000Ooo <<= 1;
                if (this.O00000oO[i2]) {
                    this.O0000Ooo++;
                }
            }
        }
        int i3 = this.O0000Ooo;
        if (i3 != 0) {
            if (i3 == 127) {
                i = 1;
            } else {
                if (i3 != 255) {
                    if (i3 == 254) {
                        i = 3;
                    } else if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                        i = 4;
                    }
                }
                i = 2;
            }
        }
        MLAlertDialog O00000o2 = new MLAlertDialog.Builder(this).O000000o(this.O0000OoO, i, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimerActivity.AnonymousClass5 */

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
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (SmartHomeSceneTimerActivity.this.O0000Oo == null) {
                    SmartHomeSceneTimerActivity.this.O0000Oo = new SceneApi.O0000o();
                } else {
                    SmartHomeSceneTimerActivity.this.O0000Oo.O00000Oo = null;
                }
                if (i == 0) {
                    SmartHomeSceneTimerActivity smartHomeSceneTimerActivity = SmartHomeSceneTimerActivity.this;
                    smartHomeSceneTimerActivity.O0000O0o = false;
                    smartHomeSceneTimerActivity.O0000o00 = null;
                    Arrays.fill(smartHomeSceneTimerActivity.O00000oO, false);
                    SmartHomeSceneTimerActivity.this.generateShortcutDaysHint();
                    SmartHomeSceneTimerActivity.this.showNextTriggerHint();
                } else if (i == 1) {
                    SmartHomeSceneTimerActivity smartHomeSceneTimerActivity2 = SmartHomeSceneTimerActivity.this;
                    smartHomeSceneTimerActivity2.O0000O0o = true;
                    smartHomeSceneTimerActivity2.O0000o00 = null;
                    smartHomeSceneTimerActivity2.O00000oO = new boolean[]{true, true, true, true, true, true, true};
                    smartHomeSceneTimerActivity2.generateShortcutDaysHint();
                    SmartHomeSceneTimerActivity.this.showNextTriggerHint();
                } else if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && i == 2 && !SmartHomeSceneTimerActivity.this.O0000o0O) {
                    SmartHomeSceneTimerActivity smartHomeSceneTimerActivity3 = SmartHomeSceneTimerActivity.this;
                    smartHomeSceneTimerActivity3.O0000O0o = true;
                    smartHomeSceneTimerActivity3.O0000o00 = "cn_workday";
                    smartHomeSceneTimerActivity3.O00000oO = new boolean[]{true, true, true, true, true, true, true};
                    smartHomeSceneTimerActivity3.O0000Oo.O00000Oo = "cn_workday";
                    SmartHomeSceneTimerActivity.this.generateShortcutDaysHint();
                    SmartHomeSceneTimerActivity.this.showNextTriggerHint();
                } else if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && i == 3 && !SmartHomeSceneTimerActivity.this.O0000o0O) {
                    SmartHomeSceneTimerActivity smartHomeSceneTimerActivity4 = SmartHomeSceneTimerActivity.this;
                    smartHomeSceneTimerActivity4.O0000O0o = true;
                    smartHomeSceneTimerActivity4.O0000o00 = "cn_freeday";
                    smartHomeSceneTimerActivity4.O00000oO = new boolean[]{true, true, true, true, true, true, true};
                    smartHomeSceneTimerActivity4.O0000Oo.O00000Oo = "cn_freeday";
                    SmartHomeSceneTimerActivity.this.generateShortcutDaysHint();
                    SmartHomeSceneTimerActivity.this.showNextTriggerHint();
                } else if ((!ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && i == 4) || ((ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && i == 2) || (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && SmartHomeSceneTimerActivity.this.O0000o0O && i == 2))) {
                    final boolean[] zArr = (boolean[]) SmartHomeSceneTimerActivity.this.O00000oO.clone();
                    MLAlertDialog O00000o = new MLAlertDialog.Builder(SmartHomeSceneTimerActivity.this.f10981O000000o).O000000o((int) R.array.weekday, zArr, new DialogInterface.OnMultiChoiceClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimerActivity.AnonymousClass5.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i, boolean z) {
                            zArr[i] = z;
                        }
                    }).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.scene.activity.SmartHomeSceneTimerActivity.AnonymousClass5.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            SmartHomeSceneTimerActivity.this.O0000O0o = true;
                            SmartHomeSceneTimerActivity.this.O00000oO = zArr;
                            SmartHomeSceneTimerActivity.this.O0000o00 = null;
                            SmartHomeSceneTimerActivity.this.generateShortcutDaysHint();
                            SmartHomeSceneTimerActivity.this.showNextTriggerHint();
                        }
                    }).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O00000o();
                    O00000o.show();
                    gnp.O000000o(SmartHomeSceneTimerActivity.this.getContext(), O00000o);
                }
            }
        }).O00000o();
        O00000o2.show();
        gnp.O000000o(getContext(), O00000o2);
    }
}

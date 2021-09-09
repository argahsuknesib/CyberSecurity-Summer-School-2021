package com.xiaomi.smarthome.scene.ui.sleep;

import _m_j.gdw;
import _m_j.ggb;
import _m_j.gpn;
import _m_j.gqg;
import _m_j.grr;
import _m_j.gsy;
import _m_j.hhc;
import _m_j.hrk;
import _m_j.hxi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.library.common.widget.TimePicker;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.scene.model.CorntabUtils;
import com.xiaomi.smarthome.scene.timer.dialog.ChooseTimeDialog;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SleepTimeActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private TextView f11312O000000o;
    private TextView O00000Oo;
    private String O00000o;
    private SwitchButton O00000o0;
    private View O00000oO;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.mj_activity_sleeptime);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.mj_scene_sleeptime);
        this.f11312O000000o = (TextView) findViewById(R.id.tvSleep);
        this.O00000Oo = (TextView) findViewById(R.id.tvWake);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.ui.sleep.$$Lambda$SleepTimeActivity$f9adbCu4v9AFqeSzHPsfZIefLZo */

            public final void onClick(View view) {
                SleepTimeActivity.this.O00000o(view);
            }
        });
        this.f11312O000000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.ui.sleep.$$Lambda$SleepTimeActivity$vpJtC4A1i6_O819fD2CD1Y0yIg */

            public final void onClick(View view) {
                SleepTimeActivity.this.O00000o0(view);
            }
        });
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.ui.sleep.$$Lambda$SleepTimeActivity$STmsP_PiiKhVHpdfSlN3ko2iFG0 */

            public final void onClick(View view) {
                SleepTimeActivity.this.O00000Oo(view);
            }
        });
        this.O00000o0 = (SwitchButton) findViewById(R.id.sbSync);
        this.O00000oO = findViewById(R.id.tvSync);
        findViewById(R.id.tvSync).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.ui.sleep.$$Lambda$SleepTimeActivity$qhXxGKo28a3ryUhc6UhHlSeAye8 */

            public final void onClick(View view) {
                SleepTimeActivity.this.O000000o(view);
            }
        });
        this.O00000o = ggb.O00000Oo().O0000OOo();
        O000000o(this.f11312O000000o, "start");
        O000000o(this.O00000Oo, "end");
        SharedPreferences O000000o2 = hrk.O000000o();
        this.O00000o0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(O000000o2) {
            /* class com.xiaomi.smarthome.scene.ui.sleep.$$Lambda$SleepTimeActivity$_IyJNghB1SPoaT3zgVJQUh5oZJk */
            private final /* synthetic */ SharedPreferences f$1;

            {
                this.f$1 = r2;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SleepTimeActivity.this.O000000o(this.f$1, compoundButton, z);
            }
        });
        O000000o2.getString("auto_clock_time" + this.O00000o, "").split("-");
        O000000o(hrk.O000000o().getStringSet("auto_clock", new HashSet()).contains(this.O00000o));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        hxi.O00000o.f952O000000o.O000000o("sleep_time_bed", new Object[0]);
        O000000o((int) R.string.mj_scene_sleeptimeslp_dialog, this.f11312O000000o.getText().toString(), new gdw() {
            /* class com.xiaomi.smarthome.scene.ui.sleep.$$Lambda$SleepTimeActivity$MZsN0ekj4HlorkrQ43zzpqFxGag */

            public final void onResult(boolean z, Object obj) {
                SleepTimeActivity.this.O00000Oo(z, (String) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(boolean z, String str) {
        this.f11312O000000o.setText(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        hxi.O00000o.f952O000000o.O000000o("sleep_time_getup", new Object[0]);
        O000000o((int) R.string.mj_scene_sleeptimeweak_dialog, this.O00000Oo.getText().toString(), new gdw() {
            /* class com.xiaomi.smarthome.scene.ui.sleep.$$Lambda$SleepTimeActivity$RsUq9H2BYyJZ6tIeQTTqjDq7f5o */

            public final void onResult(boolean z, Object obj) {
                SleepTimeActivity.this.O000000o(z, (String) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(boolean z, String str) {
        this.O00000Oo.setText(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        startActivityForResult(O000000o(), 1);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(SharedPreferences sharedPreferences, CompoundButton compoundButton, boolean z) {
        try {
            hxi.O00000o.f952O000000o.O000000o("sleep_time_click", "type", Integer.valueOf(z ? 1 : 0));
            Cursor O00000Oo2 = O00000Oo();
            O00000Oo2.moveToFirst();
            String str = hrk.O000000o(O00000Oo2.getInt(1)) + ":" + hrk.O000000o(O00000Oo2.getInt(2));
            String str2 = hrk.O000000o(O00000Oo2.getInt(3)) + ":" + hrk.O000000o(O00000Oo2.getInt(4));
            int i = O00000Oo2.getInt(0);
            O00000Oo2.close();
            if (i != 0) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                if (z) {
                    if (!TextUtils.isEmpty(str)) {
                        if (!TextUtils.isEmpty(str2)) {
                            edit.putString("user_time" + this.O00000o, ((Object) this.f11312O000000o.getText()) + "-" + ((Object) this.O00000Oo.getText())).apply();
                            this.f11312O000000o.setText(str);
                            this.O00000Oo.setText(str2);
                        }
                    }
                    this.O00000o0.setChecked(false, false);
                    gqg.O00000Oo((int) R.string.no_data_tips);
                    return;
                }
                String string = sharedPreferences.getString("user_time" + this.O00000o, "");
                if (!TextUtils.isEmpty(string)) {
                    String[] split = string.split("-");
                    if (split.length == 2) {
                        this.f11312O000000o.setText(split[0]);
                        this.O00000Oo.setText(split[1]);
                    }
                }
                O00000Oo(z);
                return;
            }
            this.O00000o0.setChecked(false, false);
            startActivityForResult(O000000o(), 1);
            gsy.O00000o0(LogType.SCENE, "SleepTimeActivity", "setAutoSync off state:".concat(String.valueOf(i)));
        } catch (Throwable th) {
            this.O00000o0.setChecked(false, false);
            gsy.O00000o0(LogType.SCENE, "SleepTimeActivity", "setAutoSync Throwable:" + Log.getStackTraceString(th));
            gqg.O00000Oo((int) R.string.mj_scene_sleepupdate_clock);
        }
    }

    private static Intent O000000o() {
        return new Intent("com.android.deskclock.BEDTIME_MANAGE");
    }

    private void O000000o(TextView textView, String str) {
        String stringExtra = getIntent().getStringExtra(str);
        if (!TextUtils.isEmpty(stringExtra)) {
            textView.setText(stringExtra);
        }
    }

    private void O000000o(boolean z) {
        View findViewById = findViewById(R.id.set_title);
        View findViewById2 = findViewById(R.id.divider);
        List<ResolveInfo> queryIntentActivities = getPackageManager().queryIntentActivities(O000000o(), 0);
        if (!grr.O00000oO() || gpn.O000000o(queryIntentActivities) || grr.O00000oo()) {
            O00000Oo(false);
            this.O00000oO.setVisibility(8);
            this.O00000o0.setVisibility(8);
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            return;
        }
        try {
            Cursor O00000Oo2 = O00000Oo();
            O00000Oo2.moveToFirst();
            if (O00000Oo2.getInt(0) == 0) {
                this.O00000o0.setVisibility(8);
                this.O00000o0.setChecked(false, false);
                this.O00000oO.setVisibility(0);
                if (!this.f11312O000000o.getText().toString().contains(":")) {
                    O000000o(this.f11312O000000o, "start");
                }
                if (!this.O00000Oo.getText().toString().contains(":")) {
                    O000000o(this.O00000Oo, "end");
                }
            } else {
                this.O00000oO.setVisibility(8);
                this.O00000o0.setVisibility(0);
                findViewById.setVisibility(0);
                findViewById2.setVisibility(0);
                if (z) {
                    this.f11312O000000o.setText(hrk.O000000o(O00000Oo2.getInt(1)) + ":" + hrk.O000000o(O00000Oo2.getInt(2)));
                    this.O00000Oo.setText(hrk.O000000o(O00000Oo2.getInt(3)) + ":" + hrk.O000000o(O00000Oo2.getInt(4)));
                }
                this.O00000o0.setChecked(z, false);
                O00000Oo(z);
            }
            O00000Oo2.close();
        } catch (Exception e) {
            this.O00000oO.setVisibility(8);
            gsy.O00000o0(LogType.SCENE, "SleepTimeActivity", "onActivityResult Throwable:" + Log.getStackTraceString(e));
        }
    }

    private Cursor O00000Oo() {
        return getContentResolver().query(Uri.parse("content://com.android.deskclock.additionProvider/bedtime"), new String[]{"bedtime_state", "sleep_hour", "sleep_minute", "wake_hour", "wake_minute", "repeat_type"}, null, null, null);
    }

    private void O00000Oo(boolean z) {
        int i = 8;
        findViewById(R.id.title).setVisibility(z ? 8 : 0);
        findViewById(R.id.sleep).setVisibility(z ? 8 : 0);
        findViewById(R.id.wake).setVisibility(z ? 8 : 0);
        this.f11312O000000o.setVisibility(z ? 8 : 0);
        TextView textView = this.O00000Oo;
        if (!z) {
            i = 0;
        }
        textView.setVisibility(i);
        SharedPreferences O000000o2 = hrk.O000000o();
        SharedPreferences.Editor edit = O000000o2.edit();
        Set<String> stringSet = O000000o2.getStringSet("auto_clock", new HashSet());
        String str = "";
        if (z) {
            stringSet.add(ggb.O00000Oo().O0000OOo());
            SharedPreferences.Editor putStringSet = edit.putStringSet("auto_clock", stringSet);
            String str2 = "auto_clock_time" + this.O00000o;
            if (z) {
                str = ((Object) this.f11312O000000o.getText()) + "-" + ((Object) this.O00000Oo.getText());
            }
            putStringSet.putString(str2, str).apply();
            return;
        }
        stringSet.remove(ggb.O00000Oo().O0000OOo());
        edit.putStringSet("auto_clock", stringSet).putString("auto_clock_time" + this.O00000o, str).apply();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hhc.O000000o(java.lang.Object, int):int
     arg types: [java.lang.String, int]
     candidates:
      _m_j.hhc.O000000o(java.lang.Object, double):double
      _m_j.hhc.O000000o(java.lang.Object, int):int */
    private void O000000o(int i, String str, gdw<String> gdw) {
        CorntabUtils.CorntabParam corntabParam = new CorntabUtils.CorntabParam();
        Calendar instance = Calendar.getInstance();
        if (str != null) {
            String[] split = str.split(":");
            if (split.length == 2) {
                corntabParam.O00000o0 = hhc.O000000o((Object) split[0], instance.get(11));
                corntabParam.O00000Oo = hhc.O000000o((Object) split[1], instance.get(12));
                ChooseTimeDialog chooseTimeDialog = new ChooseTimeDialog(this, 2132739282, corntabParam);
                chooseTimeDialog.O00000o0 = new ChooseTimeDialog.O000000o() {
                    /* class com.xiaomi.smarthome.scene.ui.sleep.$$Lambda$SleepTimeActivity$XYDBSJpM6V6qKRD58JV2BV83mA */

                    public final String onTimeChanged(int i, int i2) {
                        return SleepTimeActivity.this.O000000o(i, i2);
                    }
                };
                chooseTimeDialog.setCancelable(true);
                chooseTimeDialog.setTitle(i);
                chooseTimeDialog.O00000Oo(new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.ui.sleep.$$Lambda$SleepTimeActivity$MVOoeLdSMsmfM0cKpSw82uat0g */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ChooseTimeDialog.this.dismiss();
                    }
                });
                chooseTimeDialog.O000000o(new DialogInterface.OnClickListener(gdw) {
                    /* class com.xiaomi.smarthome.scene.ui.sleep.$$Lambda$SleepTimeActivity$mLDZGGArFNfHSAyK7S4XOqxzugc */
                    private final /* synthetic */ gdw f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SleepTimeActivity.O000000o(ChooseTimeDialog.this, this.f$1, dialogInterface, i);
                    }
                });
                chooseTimeDialog.show();
            }
        }
        corntabParam.O00000o0 = instance.get(11);
        corntabParam.O00000Oo = instance.get(12);
        ChooseTimeDialog chooseTimeDialog2 = new ChooseTimeDialog(this, 2132739282, corntabParam);
        chooseTimeDialog2.O00000o0 = new ChooseTimeDialog.O000000o() {
            /* class com.xiaomi.smarthome.scene.ui.sleep.$$Lambda$SleepTimeActivity$XYDBSJpM6V6qKRD58JV2BV83mA */

            public final String onTimeChanged(int i, int i2) {
                return SleepTimeActivity.this.O000000o(i, i2);
            }
        };
        chooseTimeDialog2.setCancelable(true);
        chooseTimeDialog2.setTitle(i);
        chooseTimeDialog2.O00000Oo(new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.ui.sleep.$$Lambda$SleepTimeActivity$MVOoeLdSMsmfM0cKpSw82uat0g */

            public final void onClick(DialogInterface dialogInterface, int i) {
                ChooseTimeDialog.this.dismiss();
            }
        });
        chooseTimeDialog2.O000000o(new DialogInterface.OnClickListener(gdw) {
            /* class com.xiaomi.smarthome.scene.ui.sleep.$$Lambda$SleepTimeActivity$mLDZGGArFNfHSAyK7S4XOqxzugc */
            private final /* synthetic */ gdw f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                SleepTimeActivity.O000000o(ChooseTimeDialog.this, this.f$1, dialogInterface, i);
            }
        });
        chooseTimeDialog2.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String O000000o(int i, int i2) {
        return hrk.O000000o(i) + getString(R.string.mj_picker_hour) + hrk.O000000o(i2) + getString(R.string.mj_picker_minite);
    }

    public void finish() {
        setResult(-1, getIntent().putExtra("start", this.f11312O000000o.getText().toString()).putExtra("end", this.O00000Oo.getText().toString()));
        super.finish();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            try {
                O000000o(true);
            } catch (Exception e) {
                LogType logType = LogType.SCENE;
                gsy.O00000o0(logType, "SleepTimeActivity", "onActivityResult Throwable:" + Log.getStackTraceString(e));
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(ChooseTimeDialog chooseTimeDialog, gdw gdw, DialogInterface dialogInterface, int i) {
        TimePicker timePicker = chooseTimeDialog.f11266O000000o;
        if (timePicker != null) {
            gdw.onResult(true, hrk.O000000o(timePicker.getCurrentHour().intValue()) + ":" + hrk.O000000o(timePicker.getCurrentMinute().intValue()));
        }
    }
}

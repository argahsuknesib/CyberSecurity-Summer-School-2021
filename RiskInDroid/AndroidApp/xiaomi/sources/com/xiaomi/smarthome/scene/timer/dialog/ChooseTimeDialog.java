package com.xiaomi.smarthome.scene.timer.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.TimePicker;
import com.xiaomi.smarthome.scene.model.CorntabUtils;
import com.xiaomi.smarthome.scene.timer.PlugTimer;

public final class ChooseTimeDialog extends MLAlertDialog {

    /* renamed from: O000000o  reason: collision with root package name */
    public TimePicker f11266O000000o;
    protected Context O00000Oo;
    private TextView O00000o;
    public O000000o O00000o0;
    private TextView O00000oO;
    private CorntabUtils.CorntabParam O00000oo;
    private boolean O0000O0o;
    private boolean O0000OOo;
    private CorntabUtils.CorntabParam O0000Oo;
    private CorntabUtils.CorntabParam O0000Oo0;
    private boolean O0000OoO;
    private boolean O0000Ooo;

    public interface O000000o {
        String onTimeChanged(int i, int i2);
    }

    public ChooseTimeDialog(Context context, CorntabUtils.CorntabParam corntabParam, CorntabUtils.CorntabParam corntabParam2, CorntabUtils.CorntabParam corntabParam3, boolean z, boolean z2, boolean z3) {
        this(context);
        this.O00000oo = corntabParam;
        this.O0000Oo0 = corntabParam2;
        this.O0000Oo = corntabParam3;
        this.O0000O0o = z;
        this.O0000OOo = z2;
        this.O0000OoO = z3;
    }

    public ChooseTimeDialog(Context context) {
        this(context, 2132739282, null);
    }

    public final void onCreate(Bundle bundle) {
        View inflate = LayoutInflater.from(this.O00000Oo).inflate((int) R.layout.choose_time_dialog, (ViewGroup) null);
        setView(inflate);
        this.O00000o = (TextView) inflate.findViewById(R.id.tv_timer_off_hint);
        this.f11266O000000o = (TimePicker) inflate.findViewById(R.id.tp_timer_off);
        this.O00000oO = (TextView) inflate.findViewById(R.id.tv_custom_title);
        this.f11266O000000o.setIs24HourView(Boolean.TRUE);
        CorntabUtils.CorntabParam corntabParam = this.O00000oo;
        if (corntabParam != null) {
            this.f11266O000000o.setCurrentHour(Integer.valueOf(corntabParam.O00000o0));
            this.f11266O000000o.setCurrentMinute(Integer.valueOf(this.O00000oo.O00000Oo));
            O000000o(this.O00000oo.O00000o0, this.O00000oo.O00000Oo);
        } else {
            this.f11266O000000o.setCurrentHour(0);
            this.f11266O000000o.setCurrentMinute(0);
            O000000o(0, 0);
        }
        this.f11266O000000o.setOnTimeChangedListener(new TimePicker.O00000Oo() {
            /* class com.xiaomi.smarthome.scene.timer.dialog.$$Lambda$ChooseTimeDialog$hsPPtz9QLvFVHUv12vd9Qk6KnZg */

            public final void onTimeChanged(TimePicker timePicker, int i, int i2) {
                ChooseTimeDialog.this.O000000o(timePicker, i, i2);
            }
        });
        if (this.O0000Ooo) {
            this.O00000oO.setVisibility(0);
        } else {
            this.O00000oO.setVisibility(8);
        }
        super.onCreate(bundle);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(TimePicker timePicker, int i, int i2) {
        O000000o(i, i2);
    }

    private void O000000o(int i, int i2) {
        String str;
        O000000o o000000o = this.O00000o0;
        if (o000000o != null) {
            this.O00000o.setText(o000000o.onTimeChanged(i, i2));
        } else if (this.O00000oo != null) {
            this.O00000o.setText(PlugTimer.O000000o(this.O00000Oo, this.O0000Oo0, this.O0000Oo, this.O0000O0o, i, i2, this.O0000OoO));
        } else {
            Button button = getButton(-1);
            if (i == 0 && i2 == 0) {
                this.O00000o.setText((int) R.string.plug_timer_no_set);
                if (button != null) {
                    button.setEnabled(false);
                    return;
                }
                return;
            }
            TextView textView = this.O00000o;
            Context context = getContext();
            Object[] objArr = new Object[2];
            String str2 = "";
            if (i == 0) {
                str = str2;
            } else {
                str = getContext().getResources().getQuantityString(R.plurals.automation_hour, i, Integer.valueOf(i));
            }
            objArr[0] = str;
            if (i2 != 0) {
                str2 = getContext().getResources().getQuantityString(R.plurals.count_down_minute, i2, Integer.valueOf(i2));
            }
            objArr[1] = str2;
            textView.setText(context.getString(R.string.count_down_timer_frequent, objArr));
            if (button != null) {
                button.setEnabled(true);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.<init>(android.content.Context, boolean, int, int, int):void
     arg types: [android.content.Context, int, int, int, int]
     candidates:
      com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.<init>(android.content.Context, boolean, android.content.DialogInterface$OnCancelListener, int, int):void
      com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.<init>(android.content.Context, boolean, int, int, int):void */
    public ChooseTimeDialog(Context context, int i, CorntabUtils.CorntabParam corntabParam) {
        super(context, true, 2132739282, 80, 0);
        this.O0000Ooo = false;
        this.O00000Oo = context;
        this.O00000oo = corntabParam;
    }

    public final void O000000o(DialogInterface.OnClickListener onClickListener) {
        setButton(-1, getContext().getString(R.string.ok_button), onClickListener);
    }

    public final void O00000Oo(DialogInterface.OnClickListener onClickListener) {
        setButton(-2, getContext().getString(R.string.sh_common_cancel), onClickListener);
    }

    public final void O000000o(int i) {
        this.O0000Ooo = true;
        TextView textView = this.O00000oO;
        if (textView != null) {
            textView.setVisibility(0);
            this.O00000oO.setText(i);
        }
    }
}

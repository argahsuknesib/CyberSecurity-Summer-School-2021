package _m_j;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.TimePicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public final class gnq extends MLAlertDialog {

    /* renamed from: O000000o  reason: collision with root package name */
    public TextView f18050O000000o;
    public TimePicker O00000Oo;
    protected int O00000o;
    protected Context O00000o0;

    public gnq(Context context, int i) {
        this(context);
        this.O00000o = i;
    }

    private gnq(Context context) {
        this(context, 2132739282, (byte) 0);
    }

    public static String O000000o(int i, int i2, int i3) {
        if (i3 > 0 && (i2 = i2 + (i3 * 2)) >= 60) {
            i2 -= 60;
            i++;
            if (i == 24) {
                i = 0;
            }
        }
        Calendar instance = Calendar.getInstance();
        if ((instance.get(11) * 60) + instance.get(12) <= (i * 60) + i2) {
            return "";
        }
        Locale locale = Locale.getDefault();
        if (locale.equals(Locale.CHINA) || locale.equals(Locale.TAIWAN)) {
            return CommonApplication.getApplication().getResources().getString(R.string.plug_timer_tomorrow);
        }
        return CommonApplication.getApplication().getResources().getString(R.string.plug_timer_tomorrow).toLowerCase(locale);
    }

    public static String O000000o(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(":");
        if (i2 < 10) {
            sb.append("0".concat(String.valueOf(i2)));
        } else {
            sb.append(i2);
        }
        return sb.toString();
    }

    public final void onCreate(Bundle bundle) {
        String[] strArr;
        View inflate = LayoutInflater.from(this.O00000o0).inflate((int) R.layout.choose_time_dialog, (ViewGroup) null);
        this.f18050O000000o = (TextView) inflate.findViewById(R.id.tv_timer_off_hint);
        this.O00000Oo = (TimePicker) inflate.findViewById(R.id.tp_timer_off);
        this.O00000Oo.setIs24HourView(Boolean.TRUE);
        TimePicker timePicker = this.O00000Oo;
        String[] strArr2 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", ayt.f12712O000000o};
        int i = this.O00000o;
        if (i == 0) {
            strArr = new String[]{"0"};
        } else {
            int i2 = 60 / i;
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                arrayList.add(String.valueOf(i3));
                i3 += this.O00000o;
            }
            strArr = (String[]) arrayList.toArray(new String[i2]);
        }
        timePicker.O00000o0.setMinValue(0);
        timePicker.O00000o0.setMaxValue(23);
        timePicker.O00000o0.setDisplayedValues(strArr2);
        timePicker.O00000o.setMinValue(0);
        timePicker.O00000o.setMaxValue(strArr.length - 1);
        timePicker.O00000o.setDisplayedValues(strArr);
        this.O00000Oo.setCurrentHour(0);
        this.O00000Oo.setCurrentMinute(0);
        String O000000o2 = O000000o(0, 0, 0);
        TextView textView = this.f18050O000000o;
        Context context = this.O00000o0;
        textView.setText(context.getString(R.string.one_time_password_choose_time_title_new, O000000o2 + "0:00", O000000o2 + O00000Oo(0, 0, this.O00000o)));
        this.O00000Oo.setOnTimeChangedListener(new TimePicker.O00000Oo() {
            /* class _m_j.gnq.AnonymousClass1 */

            public final void onTimeChanged(TimePicker timePicker, int i, int i2) {
                String str;
                int i3 = gnq.this.O00000o * i2;
                String O000000o2 = gnq.O000000o(i, i3, 0);
                if (!TextUtils.isEmpty(O000000o2)) {
                    str = O000000o2;
                } else {
                    str = gnq.O000000o(i, i3, gnq.this.O00000o);
                }
                TextView textView = gnq.this.f18050O000000o;
                Context context = gnq.this.O00000o0;
                textView.setText(context.getString(R.string.one_time_password_choose_time_title_new, O000000o2 + gnq.O000000o(i, i3), str + gnq.O00000Oo(i, i3, gnq.this.O00000o)));
            }
        });
        setView(inflate);
        super.onCreate(bundle);
    }

    private gnq(Context context, int i, byte b) {
        super(context, 2132739282);
        this.O00000o0 = context;
    }

    public static String O00000Oo(int i, int i2, int i3) {
        int i4 = i2 + (i3 * 2);
        if (i4 >= 60) {
            i4 -= 60;
            i++;
            if (i == 24) {
                i = 0;
            }
        }
        return O000000o(i, i4);
    }
}

package com.xiaomi.smarthome.library.common.dialog;

import _m_j.gqb;
import _m_j.gqj;
import _m_j.gqk;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.library.common.wheel.WheelView;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class WheelDialog extends MLAlertDialog {
    private static final int[] O00000o0 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /* renamed from: O000000o  reason: collision with root package name */
    public View.OnClickListener f9107O000000o;
    public View.OnClickListener O00000Oo;
    private WheelView O00000o;
    private WheelView O00000oO;
    private WheelView O00000oo;
    private Button O0000O0o;
    private Button O0000OOo;
    private String[] O0000Oo;
    private String[] O0000Oo0;
    private String[] O0000OoO;
    private int O0000Ooo;
    private String O0000o0;
    private int O0000o00;

    public WheelDialog(Context context) {
        this(context, (byte) 0);
    }

    private WheelDialog(Context context, byte b) {
        super(context, 2132739282);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String[] split;
        int i;
        View inflate = LayoutInflater.from(this.mContext).inflate((int) R.layout.wheel_dialog, (ViewGroup) null);
        this.O00000o = (WheelView) inflate.findViewById(R.id.year);
        this.O00000oO = (WheelView) inflate.findViewById(R.id.month);
        this.O00000oo = (WheelView) inflate.findViewById(R.id.day);
        this.O0000OoO = gqb.O000000o(ServiceApplication.getAppContext());
        this.O0000Oo0 = O000000o(1900, Calendar.getInstance().get(1));
        this.O0000Oo = O000000o(1, 31);
        int i2 = 0;
        gqj gqj = new gqj(this.O0000Oo0, (byte) 0);
        gqj gqj2 = new gqj(this.O0000OoO, (byte) 0);
        gqj gqj3 = new gqj(this.O0000Oo, (byte) 0);
        this.O00000o.setAdapter(gqj);
        this.O00000oO.setAdapter(gqj2);
        this.O00000oo.setAdapter(gqj3);
        this.O0000OOo = (Button) inflate.findViewById(R.id.button2);
        int i3 = this.O0000o00;
        if (i3 > 0) {
            this.O0000OOo.setText(i3);
        }
        this.O0000O0o = (Button) inflate.findViewById(R.id.button1);
        int i4 = this.O0000Ooo;
        if (i4 > 0) {
            this.O0000O0o.setText(i4);
        }
        String str = this.O0000o0;
        if (!(TextUtils.isEmpty(str) || this.O00000o == null || this.O00000oO == null || this.O00000oo == null || (split = str.split("\\/")) == null || split.length != 3)) {
            WheelView wheelView = this.O00000o;
            String str2 = split[0];
            String[] strArr = this.O0000Oo0;
            if (TextUtils.isEmpty(str2) || strArr == null) {
                i = -1;
            } else {
                int length = strArr.length;
                i = 0;
                while (i2 < length && !str2.equalsIgnoreCase(strArr[i2])) {
                    i++;
                    i2++;
                }
            }
            wheelView.setCurrentItem$2563266(i);
            this.O00000oO.setCurrentItem$2563266(Integer.parseInt(split[1]) - 1);
            this.O00000oo.setCurrentItem$2563266(Integer.parseInt(split[2]) - 1);
            O000000o();
        }
        this.O00000o.O000000o(new gqk() {
            /* class com.xiaomi.smarthome.library.common.dialog.WheelDialog.AnonymousClass1 */

            public final void O000000o() {
                WheelDialog.this.O000000o();
            }
        });
        this.O00000oO.O000000o(new gqk() {
            /* class com.xiaomi.smarthome.library.common.dialog.WheelDialog.AnonymousClass2 */

            public final void O000000o() {
                WheelDialog.this.O000000o();
            }
        });
        this.O00000oo.O000000o(new gqk() {
            /* class com.xiaomi.smarthome.library.common.dialog.WheelDialog.AnonymousClass3 */

            public final void O000000o() {
            }
        });
        this.O0000OOo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.library.common.dialog.WheelDialog.AnonymousClass4 */

            public final void onClick(View view) {
                if (WheelDialog.this.O00000Oo != null) {
                    WheelDialog.this.O00000Oo.onClick(view);
                }
                WheelDialog.this.dismiss();
            }
        });
        this.O0000O0o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.library.common.dialog.WheelDialog.AnonymousClass5 */

            public final void onClick(View view) {
                if (WheelDialog.this.f9107O000000o != null) {
                    WheelDialog.this.f9107O000000o.onClick(view);
                }
                WheelDialog.this.dismiss();
            }
        });
        setView(inflate);
        super.onCreate(bundle);
    }

    public final void O000000o() {
        int currentItem = this.O00000oo.getCurrentItem() + 1;
        int O00000Oo2 = O00000Oo(this.O00000o.getCurrentItem() + 1900, this.O00000oO.getCurrentItem() + 1);
        if (currentItem > O00000Oo2) {
            this.O00000oo.setCurrentItem(O00000Oo2 - 1);
        }
        this.O0000Oo = O000000o(1, O00000Oo2);
        this.O00000oo.setAdapter(new gqj(this.O0000Oo, (byte) 0));
    }

    private static String[] O000000o(int i, int i2) {
        if (i > i2) {
            return null;
        }
        int i3 = (i2 - i) + 1;
        String[] strArr = new String[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            strArr[i4] = String.valueOf(i + i4);
        }
        return strArr;
    }

    private static int O00000Oo(int i, int i2) {
        return i2 != 2 ? O00000o0[i2 - 1] : O00000o0[i2 - 1] + (((GregorianCalendar) Calendar.getInstance()).isLeapYear(i) ? 1 : 0);
    }
}

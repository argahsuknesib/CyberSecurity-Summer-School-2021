package com.xiaomi.smarthome.camera.activity.timelapse;

import _m_j.ayt;
import _m_j.gsy;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.wx.wheelview.widget.WheelView;
import com.xiaomi.smarthome.R;
import java.util.Arrays;

public abstract class ShootTimeDialog extends BottomBaseDialog {

    public interface CancelListener {
        void onCancel(ShootTimeDialog shootTimeDialog);
    }

    public interface ConfirmListener {
        void onConfirm(ShootTimeDialog shootTimeDialog, String str, String str2);
    }

    public ShootTimeDialog(Context context) {
        super(context);
    }

    public ShootTimeDialog(Context context, int i) {
        super(context, i);
    }

    public ShootTimeDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }

    public static class Builder {
        CancelListener cancelListener;
        ConfirmListener confirmListener;
        Context context;
        ShootTimeDialog dialog;
        String[] hour = null;
        String hourTime;
        boolean isCancelable;
        String[] min = null;
        String minTime;
        String startTimeHour;
        String startTimeMin;
        String title;

        public Builder(Context context2, boolean z, String str, String str2) {
            this.context = context2;
            this.isCancelable = z;
            this.startTimeHour = str;
            this.startTimeMin = str2;
        }

        public String getTitle() {
            return this.title;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder setConfirmListener(ConfirmListener confirmListener2) {
            this.confirmListener = confirmListener2;
            return this;
        }

        public Builder setCancelListener(CancelListener cancelListener2) {
            this.cancelListener = cancelListener2;
            return this;
        }

        public ShootTimeDialog build() {
            this.dialog = new ShootTimeDialog(this.context, this.isCancelable, null) {
                /* class com.xiaomi.smarthome.camera.activity.timelapse.ShootTimeDialog.Builder.AnonymousClass1 */

                public View onCreateView() {
                    Builder builder = Builder.this;
                    builder.hour = new String[]{"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", ayt.f12712O000000o};
                    builder.min = new String[]{"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", ayt.f12712O000000o, "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};
                    View inflate = LayoutInflater.from(builder.context).inflate((int) R.layout.layout_shoot_time, (ViewGroup) null);
                    ((TextView) inflate.findViewById(R.id.tv_tips_title)).setText(Builder.this.title);
                    ((TextView) inflate.findViewById(R.id.tv_cancel)).setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.camera.activity.timelapse.ShootTimeDialog.Builder.AnonymousClass1.AnonymousClass1 */

                        public void onClick(View view) {
                            if (Builder.this.cancelListener != null) {
                                Builder.this.cancelListener.onCancel(this);
                            }
                            this.dismiss();
                        }
                    });
                    ((TextView) inflate.findViewById(R.id.tv_ok)).setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.camera.activity.timelapse.ShootTimeDialog.Builder.AnonymousClass1.AnonymousClass2 */

                        public void onClick(View view) {
                            if (Builder.this.confirmListener != null) {
                                Builder.this.confirmListener.onConfirm(this, Builder.this.hourTime, Builder.this.minTime);
                            }
                            this.dismiss();
                        }
                    });
                    WheelView wheelView = (WheelView) inflate.findViewById(R.id.wv_hour);
                    WheelView wheelView2 = (WheelView) inflate.findViewById(R.id.wv_min);
                    wheelView.setWheelAdapter(new TimeWheelAdapter(Builder.this.context));
                    wheelView2.setWheelAdapter(new TimeWheelAdapter(Builder.this.context));
                    wheelView.setWheelData(Arrays.asList(Builder.this.hour));
                    wheelView2.setWheelData(Arrays.asList(Builder.this.min));
                    wheelView.setWheelSize(5);
                    wheelView2.setWheelSize(5);
                    wheelView.setLoop(true);
                    wheelView2.setLoop(true);
                    wheelView.setSkin(WheelView.Skin.None);
                    wheelView2.setSkin(WheelView.Skin.None);
                    WheelView.O00000o0 o00000o0 = new WheelView.O00000o0();
                    o00000o0.O00000o = Color.parseColor("#0bb58b");
                    wheelView.setStyle(o00000o0);
                    wheelView2.setStyle(o00000o0);
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= Builder.this.hour.length) {
                            i2 = 0;
                            break;
                        } else if (Builder.this.hour[i2].equals(Builder.this.startTimeHour)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    int i3 = 0;
                    while (true) {
                        if (i3 >= Builder.this.min.length) {
                            break;
                        } else if (Builder.this.min[i3].equals(Builder.this.startTimeMin)) {
                            i = i3;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    wheelView.setSelection(i2);
                    wheelView2.setSelection(i);
                    wheelView.setOnWheelItemSelectedListener(new WheelView.O00000Oo() {
                        /* class com.xiaomi.smarthome.camera.activity.timelapse.ShootTimeDialog.Builder.AnonymousClass1.AnonymousClass3 */

                        public void onItemSelected(int i, Object obj) {
                            Builder.this.hourTime = Builder.this.hour[i];
                            gsy.O000000o(4, "ShootTimeDialog", "==========hour=========" + i + "=============hourTime=========" + Builder.this.hourTime);
                        }
                    });
                    wheelView2.setOnWheelItemSelectedListener(new WheelView.O00000Oo() {
                        /* class com.xiaomi.smarthome.camera.activity.timelapse.ShootTimeDialog.Builder.AnonymousClass1.AnonymousClass4 */

                        public void onItemSelected(int i, Object obj) {
                            Builder.this.minTime = Builder.this.min[i];
                            gsy.O000000o(4, "ShootTimeDialog", "=============min==========" + i + "============minTime===" + Builder.this.minTime);
                        }
                    });
                    return inflate;
                }
            };
            return this.dialog;
        }
    }
}

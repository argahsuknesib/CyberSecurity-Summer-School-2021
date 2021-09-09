package com.xiaomi.smarthome.camera.activity.timelapse;

import _m_j.ayt;
import _m_j.civ;
import _m_j.gsy;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.wx.wheelview.widget.WheelView;
import com.xiaomi.smarthome.R;
import java.util.Arrays;
import java.util.Calendar;

public abstract class ScheduldShootTimeDialog extends BottomBaseDialog {

    public interface CancelListener {
        void onCancel(ScheduldShootTimeDialog scheduldShootTimeDialog);
    }

    public interface ConfirmListener {
        void onConfirm(ScheduldShootTimeDialog scheduldShootTimeDialog, String str, String str2, String str3);
    }

    public ScheduldShootTimeDialog(Context context) {
        super(context);
    }

    public ScheduldShootTimeDialog(Context context, int i) {
        super(context, i);
    }

    public ScheduldShootTimeDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }

    public static class Builder {
        CancelListener cancelListener;
        ConfirmListener confirmListener;
        Context context;
        Calendar currentCalendar;
        String[] day = null;
        String dayTime;
        ScheduldShootTimeDialog dialog;
        String[] hour = null;
        String hourTime;
        boolean isCancelable;
        String[] min = null;
        String minTime;
        int resultHour;
        int resultMin;
        String startTimeDay;
        String startTimeHour;
        String startTimeMin;
        String title;

        public Builder(Context context2, boolean z, String str, String str2, String str3) {
            this.context = context2;
            this.isCancelable = z;
            this.startTimeHour = str;
            this.startTimeMin = str2;
            this.startTimeDay = str3;
            this.currentCalendar = Calendar.getInstance();
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

        public String getCurrentHour() {
            int i = this.currentCalendar.get(11);
            if (i < 10) {
                return "0".concat(String.valueOf(i));
            }
            return String.valueOf(i);
        }

        public String getCurrentMin() {
            int i = this.currentCalendar.get(12);
            if (i < 10) {
                return "0".concat(String.valueOf(i));
            }
            return String.valueOf(i);
        }

        public ScheduldShootTimeDialog build() {
            this.dialog = new ScheduldShootTimeDialog(this.context, this.isCancelable, null) {
                /* class com.xiaomi.smarthome.camera.activity.timelapse.ScheduldShootTimeDialog.Builder.AnonymousClass1 */

                public View onCreateView() {
                    Builder builder = Builder.this;
                    int i = 0;
                    builder.day = new String[]{builder.context.getString(R.string.sleep_auto_times_today), Builder.this.context.getString(R.string.sleep_auto_times_tomorrow)};
                    Builder builder2 = Builder.this;
                    builder2.hour = new String[]{"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", ayt.f12712O000000o};
                    builder2.min = new String[]{"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", ayt.f12712O000000o, "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};
                    View inflate = LayoutInflater.from(builder2.context).inflate((int) R.layout.camera_layout_scheduled_shoot_time, (ViewGroup) null);
                    ((TextView) inflate.findViewById(R.id.tv_tips_title)).setText(Builder.this.title);
                    ((TextView) inflate.findViewById(R.id.tv_cancel)).setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.camera.activity.timelapse.ScheduldShootTimeDialog.Builder.AnonymousClass1.AnonymousClass1 */

                        public void onClick(View view) {
                            if (Builder.this.cancelListener != null) {
                                Builder.this.cancelListener.onCancel(this);
                            }
                            this.dismiss();
                        }
                    });
                    ((TextView) inflate.findViewById(R.id.tv_ok)).setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.camera.activity.timelapse.ScheduldShootTimeDialog.Builder.AnonymousClass1.AnonymousClass2 */

                        public void onClick(View view) {
                            if (Builder.this.confirmListener != null) {
                                Builder.this.confirmListener.onConfirm(this, Builder.this.hourTime, Builder.this.minTime, Builder.this.dayTime);
                            }
                            this.dismiss();
                        }
                    });
                    final WheelView wheelView = (WheelView) inflate.findViewById(R.id.wv_day);
                    WheelView wheelView2 = (WheelView) inflate.findViewById(R.id.wv_hour);
                    WheelView wheelView3 = (WheelView) inflate.findViewById(R.id.wv_min);
                    wheelView.setAdapter((ListAdapter) new TimeWheelAdapter(Builder.this.context));
                    wheelView2.setWheelAdapter(new TimeWheelAdapter(Builder.this.context));
                    wheelView3.setWheelAdapter(new TimeWheelAdapter(Builder.this.context));
                    wheelView.setWheelData(Arrays.asList(Builder.this.day));
                    wheelView2.setWheelData(Arrays.asList(Builder.this.hour));
                    wheelView3.setWheelData(Arrays.asList(Builder.this.min));
                    wheelView.setWheelSize(5);
                    wheelView2.setWheelSize(5);
                    wheelView3.setWheelSize(5);
                    wheelView.setLoop(false);
                    wheelView2.setLoop(true);
                    wheelView3.setLoop(true);
                    wheelView.setSkin(WheelView.Skin.None);
                    wheelView2.setSkin(WheelView.Skin.None);
                    wheelView3.setSkin(WheelView.Skin.None);
                    WheelView.O00000o0 o00000o0 = new WheelView.O00000o0();
                    o00000o0.O00000o = Color.parseColor("#0bb58b");
                    o00000o0.f5949O000000o = Builder.this.context.getResources().getColor(R.color.mj_color_white);
                    o00000o0.O00000o0 = Builder.this.context.getResources().getColor(R.color.mj_color_black_75_transparent);
                    wheelView.setStyle(o00000o0);
                    wheelView2.setStyle(o00000o0);
                    wheelView3.setStyle(o00000o0);
                    int i2 = 0;
                    while (true) {
                        if (i2 >= Builder.this.day.length) {
                            i2 = 0;
                            break;
                        } else if (Builder.this.day[i2].equals(Builder.this.startTimeDay)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    int i3 = 0;
                    while (true) {
                        if (i3 >= Builder.this.hour.length) {
                            i3 = 0;
                            break;
                        } else if (Builder.this.hour[i3].equals(Builder.this.startTimeHour)) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    int i4 = 0;
                    while (true) {
                        if (i4 >= Builder.this.min.length) {
                            break;
                        } else if (Builder.this.min[i4].equals(Builder.this.startTimeMin)) {
                            i = i4;
                            break;
                        } else {
                            i4++;
                        }
                    }
                    wheelView.setSelection(i2);
                    wheelView2.setSelection(i3);
                    wheelView3.setSelection(i);
                    wheelView.setOnWheelItemSelectedListener(new WheelView.O00000Oo() {
                        /* class com.xiaomi.smarthome.camera.activity.timelapse.ScheduldShootTimeDialog.Builder.AnonymousClass1.AnonymousClass3 */

                        public void onItemSelected(int i, Object obj) {
                            Builder.this.dayTime = Builder.this.day[i];
                            gsy.O000000o(4, "ScheduldShootTimeDialog", "==========day=========" + i + "=============dayTime=========" + Builder.this.dayTime);
                        }
                    });
                    wheelView2.setOnWheelItemSelectedListener(new WheelView.O00000Oo() {
                        /* class com.xiaomi.smarthome.camera.activity.timelapse.ScheduldShootTimeDialog.Builder.AnonymousClass1.AnonymousClass4 */

                        public void onItemSelected(int i, Object obj) {
                            Builder.this.hourTime = Builder.this.hour[i];
                            String currentHour = Builder.this.getCurrentHour();
                            Builder.this.resultHour = Builder.this.hourTime.compareTo(currentHour);
                            civ.O000000o("ScheduldShootTimeDialog", "hour onItemSelected resultHour=" + Builder.this.resultHour);
                            if (Builder.this.resultHour < 0) {
                                Builder.this.dayTime = Builder.this.day[1];
                                wheelView.setSelection(1);
                            } else if (!(Builder.this.resultHour == 0 || wheelView.getSelection() == 0)) {
                                Builder.this.dayTime = Builder.this.day[0];
                                wheelView.setSelection(0);
                            }
                            gsy.O000000o(4, "ScheduldShootTimeDialog", "==========hour=========" + i + "=============hourTime=========" + Builder.this.hourTime);
                        }
                    });
                    wheelView3.setOnWheelItemSelectedListener(new WheelView.O00000Oo() {
                        /* class com.xiaomi.smarthome.camera.activity.timelapse.ScheduldShootTimeDialog.Builder.AnonymousClass1.AnonymousClass5 */

                        public void onItemSelected(int i, Object obj) {
                            Builder.this.minTime = Builder.this.min[i];
                            String currentMin = Builder.this.getCurrentMin();
                            Builder.this.resultMin = Builder.this.minTime.compareTo(currentMin);
                            gsy.O000000o(4, "ScheduldShootTimeDialog", "=============resultMin==========" + Builder.this.resultMin + "============resultHour===" + Builder.this.resultHour);
                            if (Builder.this.resultMin <= 0 && Builder.this.resultHour <= 0) {
                                Builder.this.dayTime = Builder.this.day[1];
                                wheelView.setSelection(1);
                            } else if (wheelView.getSelection() != 0) {
                                Builder.this.dayTime = Builder.this.day[0];
                                wheelView.setSelection(0);
                            }
                            gsy.O000000o(4, "ScheduldShootTimeDialog", "=============min==========" + i + "============minTime===" + Builder.this.minTime);
                        }
                    });
                    return inflate;
                }
            };
            return this.dialog;
        }
    }
}

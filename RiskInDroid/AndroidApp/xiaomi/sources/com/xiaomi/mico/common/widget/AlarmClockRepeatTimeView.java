package com.xiaomi.mico.common.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.xiaomi.mico.common.util.BiMap;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class AlarmClockRepeatTimeView extends LinearLayout {
    private final BiMap<String, Integer> WEEKDAY = new BiMap().put("mon", 0).put("tue", 1).put("wed", 2).put("thu", 3).put("fri", 4).put("sat", 5).put("sun", 6);
    Button fridayView;
    private boolean[] mAlarmCustomDays = new boolean[7];
    Button mondayView;
    Button saturdayView;
    Button sundayView;
    Button thursdayView;
    Button tuesdayView;
    Button wednesdayView;

    public AlarmClockRepeatTimeView(Context context) {
        super(context);
    }

    public AlarmClockRepeatTimeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AlarmClockRepeatTimeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mondayView = (Button) findViewById(R.id.monday);
        this.mondayView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$AlarmClockRepeatTimeView$QO9AguYepmB4WpAFu3dPV6jnJbs */

            public final void onClick(View view) {
                AlarmClockRepeatTimeView.this.lambda$onFinishInflate$0$AlarmClockRepeatTimeView(view);
            }
        });
        this.tuesdayView = (Button) findViewById(R.id.tuesday);
        this.tuesdayView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$AlarmClockRepeatTimeView$WWeGd87NoQ_dKJsAZF22yz2i6I */

            public final void onClick(View view) {
                AlarmClockRepeatTimeView.this.lambda$onFinishInflate$1$AlarmClockRepeatTimeView(view);
            }
        });
        this.wednesdayView = (Button) findViewById(R.id.wednesday);
        this.wednesdayView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$AlarmClockRepeatTimeView$49akg9njRmqXlMQlaD3aEJE5f0 */

            public final void onClick(View view) {
                AlarmClockRepeatTimeView.this.lambda$onFinishInflate$2$AlarmClockRepeatTimeView(view);
            }
        });
        this.thursdayView = (Button) findViewById(R.id.thursday);
        this.thursdayView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$AlarmClockRepeatTimeView$WQtw98YESkh0_JIgduRGgkoufrE */

            public final void onClick(View view) {
                AlarmClockRepeatTimeView.this.lambda$onFinishInflate$3$AlarmClockRepeatTimeView(view);
            }
        });
        this.fridayView = (Button) findViewById(R.id.friday);
        this.fridayView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$AlarmClockRepeatTimeView$3IamDywELWOI7GnnbGF7ib4w52o */

            public final void onClick(View view) {
                AlarmClockRepeatTimeView.this.lambda$onFinishInflate$4$AlarmClockRepeatTimeView(view);
            }
        });
        this.saturdayView = (Button) findViewById(R.id.saturday);
        this.saturdayView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$AlarmClockRepeatTimeView$lbZZ8xdM0yTebKl2qi39XEQwDI */

            public final void onClick(View view) {
                AlarmClockRepeatTimeView.this.lambda$onFinishInflate$5$AlarmClockRepeatTimeView(view);
            }
        });
        this.sundayView = (Button) findViewById(R.id.sunday);
        this.sundayView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.$$Lambda$AlarmClockRepeatTimeView$sYfJs5dq8viGP9v75nRAxJb3KA0 */

            public final void onClick(View view) {
                AlarmClockRepeatTimeView.this.lambda$onFinishInflate$6$AlarmClockRepeatTimeView(view);
            }
        });
        initSelected();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    private void initSelected() {
        this.mondayView.setSelected(true);
        updateSelected(this.mondayView, true);
        this.tuesdayView.setSelected(true);
        updateSelected(this.tuesdayView, true);
        this.wednesdayView.setSelected(true);
        updateSelected(this.wednesdayView, true);
        this.thursdayView.setSelected(true);
        updateSelected(this.thursdayView, true);
        this.fridayView.setSelected(true);
        updateSelected(this.fridayView, true);
    }

    private void updateSelected(View view, boolean z) {
        this.mAlarmCustomDays[Integer.valueOf((String) view.getTag()).intValue()] = z;
    }

    /* renamed from: onClick */
    public void lambda$onFinishInflate$6$AlarmClockRepeatTimeView(View view) {
        view.setSelected(!view.isSelected());
        updateSelected(view, view.isSelected());
    }

    public String getSelected() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 7; i++) {
            if (this.mAlarmCustomDays[i]) {
                arrayList.add(this.WEEKDAY.key(Integer.valueOf(i)));
            }
        }
        if (!arrayList.isEmpty()) {
            return TextUtils.join(" ", arrayList);
        }
        return null;
    }
}

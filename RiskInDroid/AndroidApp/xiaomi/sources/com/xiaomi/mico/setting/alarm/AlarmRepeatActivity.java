package com.xiaomi.mico.setting.alarm;

import _m_j.gku;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import com.xiaomi.mico.api.model.AlarmCircle;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.recyclerview.itemdecoration.ItemDecorationHelper;
import com.xiaomi.mico.common.util.TimeUtil;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.setting.alarm.AlarmRepeatActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class AlarmRepeatActivity extends MicoBaseActivity {
    public AlarmCircleAdapter alarmCircleAdapter;
    public String extra;
    private boolean[] mAlarmCustomDays;
    RecyclerView recyclerView;
    public int selectedCycle;
    public long timestamp;
    TitleBar titleBar;

    static /* synthetic */ boolean lambda$onCreate$0(int i, int i2) {
        return i > 0;
    }

    static /* synthetic */ void lambda$showCustomRepeatSetting$3(DialogInterface dialogInterface, int i, boolean z) {
    }

    public boolean isDarkMode() {
        return true;
    }

    public static Intent buildIntent(Context context, int i, String str, long j) {
        Intent intent = new Intent(context, AlarmRepeatActivity.class);
        intent.putExtra("cycle", i);
        intent.putExtra("extra", str);
        intent.putExtra("timestamp", j);
        return intent;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_alarm_repeat);
        this.titleBar = (TitleBar) findViewById(R.id.title_bar);
        this.recyclerView = (RecyclerView) findViewById(R.id.linear_recycle_view);
        this.titleBar.setTitleViewMainStyle();
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.setting.alarm.$$Lambda$v6Pi36eQXQOBkwDxXsTG4IbxdM4 */

            public final void onLeftIconClick() {
                AlarmRepeatActivity.this.onBackPressed();
            }
        });
        this.alarmCircleAdapter = new AlarmCircleAdapter();
        this.recyclerView.setAdapter(this.alarmCircleAdapter);
        this.recyclerView.addItemDecoration(ItemDecorationHelper.listDivider(getContext(), R.color.mj_color_black_00_transparent, R.dimen.size_7dp, 0, 0, $$Lambda$AlarmRepeatActivity$WRVzfpAcmbDMiTVcItu63lYDI.INSTANCE));
        initAlarmRepeatData();
        this.alarmCircleAdapter.setCycles(Arrays.asList(getAlarmRepeatOption()));
    }

    private void initAlarmRepeatData() {
        this.selectedCycle = getIntent().getIntExtra("cycle", AlarmCircle.ONCE.getCircle());
        this.timestamp = getIntent().getLongExtra("timestamp", System.currentTimeMillis());
        this.extra = getIntent().getStringExtra("extra");
        this.mAlarmCustomDays = new boolean[7];
        if (!TextUtils.isEmpty(this.extra)) {
            for (String value : this.extra.toLowerCase().split(" ")) {
                this.mAlarmCustomDays[AlarmHelper.WEEKDAY.value(value).intValue()] = true;
            }
        }
    }

    private String[] getAlarmRepeatOption() {
        return getResources().getStringArray(R.array.alarm_repeat_option_v2);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public class AlarmCircleAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
        private List<String> cycles;

        public AlarmCircleAdapter() {
        }

        /* access modifiers changed from: package-private */
        public void setCycles(List<String> list) {
            this.cycles = list;
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new AlarmCircleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_alarm_cycle_item, viewGroup, false));
        }

        public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ((AlarmCircleViewHolder) o000OOo0).bindView(this.cycles.get(i), i);
        }

        public int getItemCount() {
            List<String> list = this.cycles;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }

    class AlarmCircleViewHolder extends RecyclerView.O000OOo0 {
        private int cycle;
        TextView description;
        View divider;
        ImageView more;
        TextView name;
        ImageView selected;

        AlarmCircleViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.name = (TextView) view.findViewById(R.id.alarm_cycle_name);
            this.selected = (ImageView) view.findViewById(R.id.alarm_cycle_selected);
            this.description = (TextView) view.findViewById(R.id.description);
            this.more = (ImageView) view.findViewById(R.id.more);
            this.divider = view.findViewById(R.id.divider);
            view.findViewById(R.id.root_view).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.setting.alarm.$$Lambda$AlarmRepeatActivity$AlarmCircleViewHolder$IrqP0RqGiLhXz_yCQ_01XvRcvWI */

                public final void onClick(View view) {
                    AlarmRepeatActivity.AlarmCircleViewHolder.this.lambda$new$0$AlarmRepeatActivity$AlarmCircleViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$AlarmRepeatActivity$AlarmCircleViewHolder(View view) {
            onClick();
        }

        public void bindView(String str, int i) {
            this.name.setText(str);
            int i2 = 4;
            if (i == AlarmCircle.ONCE.getCircle()) {
                this.more.setVisibility(0);
                this.divider.setVisibility(4);
                if (AlarmRepeatActivity.this.timestamp > 0) {
                    this.description.setText(AlarmHelper.formatAlarmDateTime(AlarmRepeatActivity.this.getContext(), AlarmRepeatActivity.this.timestamp));
                    this.description.setVisibility(0);
                } else {
                    this.description.setVisibility(8);
                }
            } else if (i == AlarmCircle.CUSTOM.getCircle()) {
                this.more.setVisibility(0);
                this.divider.setVisibility(4);
                if (!TextUtils.isEmpty(AlarmRepeatActivity.this.extra)) {
                    TextView textView = this.description;
                    AlarmRepeatActivity alarmRepeatActivity = AlarmRepeatActivity.this;
                    textView.setText(alarmRepeatActivity.getString(R.string.weekly, new Object[]{AlarmHelper.getCustomRepeatStr(alarmRepeatActivity.getContext(), AlarmRepeatActivity.this.extra)}));
                    this.description.setVisibility(0);
                } else {
                    this.description.setVisibility(8);
                }
            } else {
                this.more.setVisibility(4);
                this.divider.setVisibility(0);
                this.description.setVisibility(8);
            }
            this.cycle = AlarmCircle.index2circle(i, 2);
            ImageView imageView = this.selected;
            if (this.cycle == AlarmRepeatActivity.this.selectedCycle) {
                i2 = 0;
            }
            imageView.setVisibility(i2);
        }

        public void onClick() {
            if (this.cycle == AlarmCircle.ONCE.getCircle()) {
                AlarmRepeatActivity.this.showDatePicker();
            } else if (this.cycle == AlarmCircle.CUSTOM.getCircle()) {
                AlarmRepeatActivity.this.showCustomRepeatSetting();
            } else {
                AlarmRepeatActivity alarmRepeatActivity = AlarmRepeatActivity.this;
                alarmRepeatActivity.selectedCycle = this.cycle;
                alarmRepeatActivity.alarmCircleAdapter.notifyDataSetChanged();
            }
        }
    }

    private void setResultInfo() {
        Intent intent = new Intent();
        intent.putExtra("cycle", this.selectedCycle);
        intent.putExtra("timestamp", this.timestamp);
        if (!TextUtils.isEmpty(this.extra)) {
            intent.putExtra("extra", this.extra);
        }
        setResult(-1, intent);
    }

    public void onBackPressed() {
        setResultInfo();
        super.onBackPressed();
    }

    public void showDatePicker() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.timestamp);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, gku.O000000o(getContext()) ? 2 : 3, new DatePickerDialog.OnDateSetListener() {
            /* class com.xiaomi.mico.setting.alarm.$$Lambda$AlarmRepeatActivity$3GLp6gJ0L8OZGVVZQCSN9tUcyR4 */

            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                AlarmRepeatActivity.this.lambda$showDatePicker$1$AlarmRepeatActivity(datePicker, i, i2, i3);
            }
        }, instance.get(1), instance.get(2), instance.get(5));
        instance.setTimeInMillis(this.timestamp);
        if (!TimeUtil.isBeforeCurrentTimeOfHourMinute(instance.get(11), instance.get(12))) {
            instance.setTimeInMillis(System.currentTimeMillis());
        }
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        datePickerDialog.getDatePicker().setMinDate(instance.getTimeInMillis());
        datePickerDialog.show();
    }

    public /* synthetic */ void lambda$showDatePicker$1$AlarmRepeatActivity(DatePicker datePicker, int i, int i2, int i3) {
        this.timestamp = calculateTimeStamp(i, i2, i3);
        this.selectedCycle = AlarmCircle.ONCE.getCircle();
        this.alarmCircleAdapter.notifyDataSetChanged();
    }

    private long calculateTimeStamp(int i, int i2, int i3) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.timestamp);
        instance.set(1, i);
        instance.set(2, i2);
        instance.set(5, i3);
        return instance.getTimeInMillis();
    }

    public void showCustomRepeatSetting() {
        new MLAlertDialog.Builder(this).O000000o((int) R.string.time_setting_repeat).O00000Oo((int) R.string.common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.common_confirm, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.mico.setting.alarm.$$Lambda$AlarmRepeatActivity$rO0tPyO7LFq1gPE3gjqC7DSVMI */

            public final void onClick(DialogInterface dialogInterface, int i) {
                AlarmRepeatActivity.this.lambda$showCustomRepeatSetting$2$AlarmRepeatActivity(dialogInterface, i);
            }
        }).O000000o((int) R.array.weekdays, this.mAlarmCustomDays, $$Lambda$AlarmRepeatActivity$nwzzhlIfQBuv3dABJyAsxw62Wg.INSTANCE).O00000o().show();
    }

    public /* synthetic */ void lambda$showCustomRepeatSetting$2$AlarmRepeatActivity(DialogInterface dialogInterface, int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 7; i2++) {
            if (this.mAlarmCustomDays[i2]) {
                arrayList.add(AlarmHelper.WEEKDAY.key(Integer.valueOf(i2)));
            }
        }
        this.extra = TextUtils.join(" ", arrayList);
        dialogInterface.dismiss();
        this.selectedCycle = AlarmCircle.CUSTOM.getCircle();
        this.alarmCircleAdapter.notifyDataSetChanged();
    }
}

package com.xiaomi.mico.setting.babyschedule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.setting.babyschedule.TimedOffActivity;
import com.xiaomi.mico.setting.babyschedule.bean.TimedOffBean;
import com.xiaomi.smarthome.R;

public class TimedOffActivity extends MicoBaseActivity {
    RecyclerView recyclerView;
    public TimedOffAdapter timedOffAdapter;
    public TimedOffBean timedOffBean;
    TitleBar titleBar;

    public boolean isDarkMode() {
        return true;
    }

    public static Intent buildIntent(Context context, TimedOffBean timedOffBean2) {
        Intent intent = new Intent(context, TimedOffActivity.class);
        intent.putExtra("INTENT_KEY_CLOSE_TIME", timedOffBean2);
        return intent;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_timed_off);
        this.titleBar = (TitleBar) findViewById(R.id.title_bar);
        this.recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        this.titleBar.setTitleViewMainStyle();
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$s3X3p30RSXyAU4psBDM54ZRPRY */

            public final void onLeftIconClick() {
                TimedOffActivity.this.onBackPressed();
            }
        });
        TimedOffBean[] timedOffBeans = TimedOffBean.getTimedOffBeans(this);
        this.timedOffBean = (TimedOffBean) getIntent().getSerializableExtra("INTENT_KEY_CLOSE_TIME");
        this.timedOffAdapter = new TimedOffAdapter();
        this.timedOffAdapter.setTimedOffArray(timedOffBeans);
        this.recyclerView.setAdapter(this.timedOffAdapter);
    }

    public void onBackPressed() {
        setResultInfo();
        super.onBackPressed();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private void setResultInfo() {
        Intent intent = new Intent();
        intent.putExtra("INTENT_KEY_CLOSE_TIME", this.timedOffBean);
        setResult(-1, intent);
    }

    public class TimedOffAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
        private TimedOffBean[] timedOffBeans;

        public TimedOffAdapter() {
        }

        /* access modifiers changed from: package-private */
        public void setTimedOffArray(TimedOffBean[] timedOffBeanArr) {
            this.timedOffBeans = timedOffBeanArr;
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new TimedOffViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_alarm_cycle_item, viewGroup, false));
        }

        public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ((TimedOffViewHolder) o000OOo0).bindView(this.timedOffBeans[i]);
        }

        public int getItemCount() {
            return ContainerUtil.getSize(this.timedOffBeans);
        }
    }

    class TimedOffViewHolder extends RecyclerView.O000OOo0 {
        TextView description;
        View divider;
        ImageView more;
        TextView name;
        ImageView selectedView;
        private TimedOffBean timedOffBean;

        TimedOffViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.name = (TextView) view.findViewById(R.id.alarm_cycle_name);
            this.description = (TextView) view.findViewById(R.id.description);
            this.more = (ImageView) view.findViewById(R.id.more);
            this.divider = view.findViewById(R.id.divider);
            this.selectedView = (ImageView) view.findViewById(R.id.alarm_cycle_selected);
            view.findViewById(R.id.root_view).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$TimedOffActivity$TimedOffViewHolder$elKyBxNURcJh2wbI3v190QcW8 */

                public final void onClick(View view) {
                    TimedOffActivity.TimedOffViewHolder.this.lambda$new$0$TimedOffActivity$TimedOffViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$TimedOffActivity$TimedOffViewHolder(View view) {
            onClick();
        }

        public void onClick() {
            TimedOffActivity timedOffActivity = TimedOffActivity.this;
            timedOffActivity.timedOffBean = this.timedOffBean;
            timedOffActivity.timedOffAdapter.notifyDataSetChanged();
        }

        public void bindView(TimedOffBean timedOffBean2) {
            this.timedOffBean = timedOffBean2;
            this.name.setText(timedOffBean2.displayStr);
            this.description.setVisibility(8);
            int i = 4;
            this.more.setVisibility(4);
            this.divider.setVisibility(0);
            ImageView imageView = this.selectedView;
            if (TimedOffActivity.this.timedOffBean.equals(timedOffBean2)) {
                i = 0;
            }
            imageView.setVisibility(i);
        }
    }
}

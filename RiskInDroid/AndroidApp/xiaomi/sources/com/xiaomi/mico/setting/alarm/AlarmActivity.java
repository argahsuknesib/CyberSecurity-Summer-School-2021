package com.xiaomi.mico.setting.alarm;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.AlarmCircle;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.application.MicoCapabilityUtil;
import com.xiaomi.mico.common.util.TimeUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.RatioBanner;
import com.xiaomi.mico.common.widget.SlidingButton;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.setting.alarm.AlarmActivity;
import com.xiaomi.mico.setting.alarm.Banner;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlarmActivity extends MicoBaseActivity {
    public AlarmAdapter adapter;
    public List<Remote.Response.Alarm> alarms;
    RecyclerView list;
    TitleBar titleBar;

    public boolean isDarkMode() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_alarm);
        this.titleBar = (TitleBar) findViewById(R.id.title_bar);
        this.list = (RecyclerView) findViewById(R.id.linear_recycle_view);
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.setting.alarm.$$Lambda$JW2SlOLJM1LS39wGgymQJpgGCXQ */

            public final void onLeftIconClick() {
                AlarmActivity.this.onBackPressed();
            }
        });
        this.adapter = new AlarmAdapter();
        this.list.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.list.setAdapter(this.adapter);
        AlarmHelper.loadConfig();
    }

    public void onResume() {
        super.onResume();
        loadDataFromServer(true);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void deleteAlarm(Remote.Response.Alarm alarm) {
        showProgressDialog(null);
        ApiHelper.deleteAlarm(alarm.id, new ApiRequest.Listener<Remote.Response.NullInfo>() {
            /* class com.xiaomi.mico.setting.alarm.AlarmActivity.AnonymousClass1 */

            public void onSuccess(Remote.Response.NullInfo nullInfo) {
                AlarmActivity.this.dismissProgressDialog();
                AlarmActivity.this.loadDataFromServer(false);
            }

            public void onFailure(ApiError apiError) {
                AlarmActivity.this.dismissProgressDialog();
                ToastUtil.showToast((int) R.string.alarm_delete_fail, 0);
            }
        });
    }

    public void loadDataFromServer(final boolean z) {
        if (z) {
            showProgressDialog(null);
        }
        ApiHelper.getAlarm(new ApiRequest.Listener<Remote.Response.AlarmResponse>() {
            /* class com.xiaomi.mico.setting.alarm.AlarmActivity.AnonymousClass2 */

            public void onSuccess(Remote.Response.AlarmResponse alarmResponse) {
                AlarmActivity.this.dismissProgressDialog();
                AlarmActivity.this.alarms = alarmResponse.alarm;
                if (AlarmActivity.this.alarms != null && !AlarmActivity.this.alarms.isEmpty()) {
                    for (Remote.Response.Alarm alarm : AlarmActivity.this.alarms) {
                        alarm.timestamp *= 1000;
                    }
                    Collections.sort(AlarmActivity.this.alarms, $$Lambda$AlarmActivity$2$rN8KZXrg5md0kHMoC46LWRVSdzI.INSTANCE);
                }
                AlarmActivity.this.adapter.updateData(AlarmActivity.this.alarms, z);
            }

            public void onFailure(ApiError apiError) {
                AlarmActivity.this.dismissProgressDialog();
                ToastUtil.showToast((int) R.string.failed_of_load_retry);
            }
        });
    }

    public class AlarmAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
        private int addedCount;
        private List<Remote.Response.Alarm> data;
        private boolean firstIn = (!this.hasAlarms);
        private boolean hasAlarms;

        AlarmAdapter() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 1) {
                return new HeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.alarm_header, viewGroup, false));
            } else if (i == 2) {
                return new TypeItemsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.alarm_type_items, viewGroup, false));
            } else {
                if (i == 3) {
                    return new BannerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.alarm_banner, viewGroup, false));
                }
                if (i == 4) {
                    return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.widget_icon_title_desc_and_switcher, viewGroup, false));
                } else if (i != 5) {
                    return new EmptyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_channel_empty, viewGroup, false));
                } else {
                    return new EmptyHintViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.alarm_empty_item, viewGroup, false));
                }
            }
        }

        public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            if (this.data != null && getItemViewType(i) == 4) {
                ((ItemViewHolder) o000OOo0).bindView(this.data.get(i - 2));
            }
        }

        public int getItemViewType(int i) {
            if (i == 0) {
                return 1;
            }
            if (this.hasAlarms) {
                return i == 1 ? 3 : 4;
            }
            if (this.firstIn) {
                return 2;
            }
            if (i == 1) {
                return 3;
            }
            return 5;
        }

        public int getItemCount() {
            this.addedCount = 1;
            if (this.hasAlarms) {
                this.addedCount++;
            } else if (this.firstIn) {
                this.addedCount++;
            } else {
                this.addedCount++;
                this.addedCount++;
            }
            List<Remote.Response.Alarm> list = this.data;
            return list == null ? this.addedCount : this.addedCount + list.size();
        }

        public void updateData(List<Remote.Response.Alarm> list, boolean z) {
            this.data = list;
            List<Remote.Response.Alarm> list2 = this.data;
            this.hasAlarms = list2 != null && !list2.isEmpty();
            this.firstIn = z;
            notifyDataSetChanged();
        }
    }

    class HeaderViewHolder extends RecyclerView.O000OOo0 {
        ImageView addAlarm;

        /* access modifiers changed from: package-private */
        /* renamed from: onClick */
        public void lambda$new$0$AlarmActivity$HeaderViewHolder(View view) {
            view.getContext().startActivity(AlarmSettingActivity.buildIntent(view.getContext(), "系统铃声"));
        }

        HeaderViewHolder(View view) {
            super(view);
            this.addAlarm = (ImageView) view.findViewById(R.id.alarm_add);
            this.addAlarm.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.setting.alarm.$$Lambda$AlarmActivity$HeaderViewHolder$jZXU6AX_6EG7qanACHPO5Tj0AY */

                public final void onClick(View view) {
                    AlarmActivity.HeaderViewHolder.this.lambda$new$0$AlarmActivity$HeaderViewHolder(view);
                }
            });
        }
    }

    static class TypeItemsViewHolder extends RecyclerView.O000OOo0 {
        View videoBanner;

        /* access modifiers changed from: package-private */
        /* renamed from: onClick */
        public void lambda$new$3$AlarmActivity$TypeItemsViewHolder(View view) {
            int id = view.getId();
            if (id == R.id.music_banner) {
                view.getContext().startActivity(AlarmSettingActivity.buildIntent(view.getContext(), "音乐"));
            } else if (id == R.id.video_banner) {
                view.getContext().startActivity(AlarmSettingActivity.buildIntent(view.getContext(), "视频"));
            } else if (id == R.id.nature_banner) {
                view.getContext().startActivity(AlarmSettingActivity.buildIntent(view.getContext(), "自然"));
            } else if (id == R.id.fun_banner) {
                view.getContext().startActivity(AlarmSettingActivity.buildIntent(view.getContext(), "趣味"));
            }
        }

        TypeItemsViewHolder(View view) {
            super(view);
            this.videoBanner = view.findViewById(R.id.video_banner);
            this.videoBanner.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.setting.alarm.$$Lambda$AlarmActivity$TypeItemsViewHolder$0iLtDIbxgcSnqInvtVG14tetx2Y */

                public final void onClick(View view) {
                    AlarmActivity.TypeItemsViewHolder.this.lambda$new$0$AlarmActivity$TypeItemsViewHolder(view);
                }
            });
            view.findViewById(R.id.music_banner).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.setting.alarm.$$Lambda$AlarmActivity$TypeItemsViewHolder$c4m6GxPtPzAH8V8BaBLuVQtGVA */

                public final void onClick(View view) {
                    AlarmActivity.TypeItemsViewHolder.this.lambda$new$1$AlarmActivity$TypeItemsViewHolder(view);
                }
            });
            view.findViewById(R.id.nature_banner).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.setting.alarm.$$Lambda$AlarmActivity$TypeItemsViewHolder$aSuWZjS7C_3uEDYMKvWttjayQyk */

                public final void onClick(View view) {
                    AlarmActivity.TypeItemsViewHolder.this.lambda$new$2$AlarmActivity$TypeItemsViewHolder(view);
                }
            });
            view.findViewById(R.id.fun_banner).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.setting.alarm.$$Lambda$AlarmActivity$TypeItemsViewHolder$vn5Qk50_vofhtZF8jlUhHmxp8Cg */

                public final void onClick(View view) {
                    AlarmActivity.TypeItemsViewHolder.this.lambda$new$3$AlarmActivity$TypeItemsViewHolder(view);
                }
            });
            this.videoBanner.setVisibility(MicoCapabilityUtil.hasCapabilityVideoAlarm() ? 0 : 8);
        }
    }

    static class BannerViewHolder extends RecyclerView.O000OOo0 {
        public List<Banner.Item> banners = loadBanners();
        RatioBanner ratioBanner;

        BannerViewHolder(View view) {
            super(view);
            this.ratioBanner = (RatioBanner) view.findViewById(R.id.music_section_banner);
            this.ratioBanner.setImageLoader(new ImageLoader() {
                /* class com.xiaomi.mico.setting.alarm.AlarmActivity.BannerViewHolder.AnonymousClass2 */

                public void displayImage(Context context, Object obj, ImageView imageView) {
                    Picasso.get().load(((Banner.Item) obj).drawable).noFade().into(imageView);
                }
            }).setOnBannerListener(new OnBannerListener() {
                /* class com.xiaomi.mico.setting.alarm.AlarmActivity.BannerViewHolder.AnonymousClass1 */

                public void OnBannerClick(int i) {
                    BannerViewHolder.this.ratioBanner.getContext().startActivity(AlarmSettingActivity.buildIntent(BannerViewHolder.this.ratioBanner.getContext(), BannerViewHolder.this.banners.get(i).type));
                }
            });
            this.ratioBanner.setCorner(10.0f);
            this.ratioBanner.update(this.banners);
            this.ratioBanner.startAutoPlay();
        }

        private List<Banner.Item> loadBanners() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Banner.Item("音乐", R.drawable.alarm_music_banner));
            if (MicoCapabilityUtil.hasCapabilityVideoAlarm()) {
                arrayList.add(new Banner.Item("视频", R.drawable.alarm_video_banner));
            }
            arrayList.add(new Banner.Item("自然", R.drawable.alarm_nature_banner));
            arrayList.add(new Banner.Item("趣味", R.drawable.alarm_fun_banner));
            return arrayList;
        }
    }

    class ItemViewHolder extends RecyclerView.O000OOo0 {
        public Remote.Response.Alarm alarm;
        TextView desc;
        ImageView icon;
        SlidingButton slidingButton;
        TextView subTitle;
        TextView title;

        public ItemViewHolder(View view) {
            super(view);
            this.icon = (ImageView) view.findViewById(R.id.icon);
            this.title = (TextView) view.findViewById(R.id.title);
            this.subTitle = (TextView) view.findViewById(R.id.sub_title);
            this.desc = (TextView) view.findViewById(R.id.description);
            this.slidingButton = (SlidingButton) view.findViewById(R.id.switcher);
            view.findViewById(R.id.root_view).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.setting.alarm.$$Lambda$AlarmActivity$ItemViewHolder$2_axihpdP1iThLFs4s8NjWI4C4 */

                public final void onClick(View view) {
                    AlarmActivity.ItemViewHolder.this.lambda$new$0$AlarmActivity$ItemViewHolder(view);
                }
            });
            view.findViewById(R.id.root_view).setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.xiaomi.mico.setting.alarm.$$Lambda$AlarmActivity$ItemViewHolder$VpDiwLp4ez6z14JhWPhKgMwR5Fw */

                public final boolean onLongClick(View view) {
                    return AlarmActivity.ItemViewHolder.this.lambda$new$1$AlarmActivity$ItemViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$AlarmActivity$ItemViewHolder(View view) {
            onClick();
        }

        public /* synthetic */ boolean lambda$new$1$AlarmActivity$ItemViewHolder(View view) {
            return onLongClick();
        }

        public void bindView(Remote.Response.Alarm alarm2) {
            this.alarm = alarm2;
            this.title.setText(getTitle(alarm2));
            this.subTitle.setText(getSubTitle(alarm2));
            this.desc.setText(getDescription(alarm2));
            this.icon.setImageResource(getIconResId(alarm2));
            this.slidingButton.setChecked(alarm2.status == 0, false);
            this.slidingButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.xiaomi.mico.setting.alarm.$$Lambda$AlarmActivity$ItemViewHolder$gw4WZqXpc7e2eLdGjxHJqq3eO7U */

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AlarmActivity.ItemViewHolder.this.lambda$bindView$2$AlarmActivity$ItemViewHolder(compoundButton, z);
                }
            });
        }

        public /* synthetic */ void lambda$bindView$2$AlarmActivity$ItemViewHolder(CompoundButton compoundButton, final boolean z) {
            AlarmActivity.this.showProgressDialog(null);
            ApiHelper.enableAlarm(this.alarm.id, z, new ApiRequest.Listener<Remote.Response.NullInfo>() {
                /* class com.xiaomi.mico.setting.alarm.AlarmActivity.ItemViewHolder.AnonymousClass1 */

                public void onSuccess(Remote.Response.NullInfo nullInfo) {
                    ItemViewHolder.this.alarm.status = z ^ true ? 1 : 0;
                    AlarmActivity.this.loadDataFromServer(false);
                    AlarmActivity.this.dismissProgressDialog();
                }

                public void onFailure(ApiError apiError) {
                    AlarmActivity.this.dismissProgressDialog();
                    ItemViewHolder.this.slidingButton.setChecked(!z, false);
                    ToastUtil.showToast((int) R.string.common_save_fail, 0);
                }
            });
        }

        public void onClick() {
            AlarmActivity alarmActivity = AlarmActivity.this;
            alarmActivity.startActivity(AlarmSettingActivity.buildIntent(alarmActivity.getContext(), this.alarm));
        }

        public boolean onLongClick() {
            new MLAlertDialog.Builder(AlarmActivity.this.getContext()).O000000o((int) R.string.mico_common_hint).O00000Oo((int) R.string.time_setting_delete_clock_title).O00000Oo((int) R.string.common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.common_confirm, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.mico.setting.alarm.AlarmActivity.ItemViewHolder.AnonymousClass2 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    AlarmActivity.this.deleteAlarm(ItemViewHolder.this.alarm);
                }
            }).O00000oo();
            return true;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        private int getIconResId(Remote.Response.Alarm alarm2) {
            char c;
            String alarmRingType = AlarmHelper.getAlarmRingType(alarm2.getAlarmRing());
            switch (alarmRingType.hashCode()) {
                case 1059980:
                    if (alarmRingType.equals("自然")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1132427:
                    if (alarmRingType.equals("视频")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1145648:
                    if (alarmRingType.equals("趣味")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1225917:
                    if (alarmRingType.equals("音乐")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 985578705:
                    if (alarmRingType.equals("系统铃声")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0 || c == 1) {
                return R.drawable.alarm_icon_music;
            }
            if (c == 2) {
                return R.drawable.alarm_icon_video;
            }
            if (c != 3) {
                return c != 4 ? R.drawable.alarm_icon_more : R.drawable.alarm_icon_fun;
            }
            return R.drawable.alarm_icon_nature;
        }

        private String getDescription(Remote.Response.Alarm alarm2) {
            if (!TextUtils.isEmpty(alarm2.event)) {
                return alarm2.event;
            }
            if (!TextUtils.isEmpty(alarm2.displayTxt)) {
                return URLDecoder.decode(alarm2.displayTxt);
            }
            if (!AlarmHelper.isRingToneQueryEmpty(alarm2) && !AlarmHelper.isRingToneTypeEmpty(alarm2)) {
                return AlarmHelper.loadQueryName(alarm2.ringToneQuery, alarm2.ringToneType);
            }
            String alarmRingType = AlarmHelper.getAlarmRingType(alarm2.getAlarmRing());
            char c = 65535;
            switch (alarmRingType.hashCode()) {
                case 1059980:
                    if (alarmRingType.equals("自然")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1132427:
                    if (alarmRingType.equals("视频")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1145648:
                    if (alarmRingType.equals("趣味")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1225917:
                    if (alarmRingType.equals("音乐")) {
                        c = 0;
                        break;
                    }
                    break;
                case 985578705:
                    if (alarmRingType.equals("系统铃声")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                return AlarmActivity.this.getContext().getString(R.string.alarm_tone_music);
            }
            if (c == 1) {
                return AlarmActivity.this.getContext().getString(R.string.alarm_tone_video);
            }
            if (c == 2) {
                return AlarmActivity.this.getContext().getString(R.string.alarm_tone_nature);
            }
            if (c == 3) {
                return AlarmActivity.this.getContext().getString(R.string.alarm_tone_fun);
            }
            if (c != 4) {
                return AlarmActivity.this.getContext().getString(R.string.alarm_tone_system);
            }
            return AlarmActivity.this.getContext().getString(R.string.alarm_tone_system);
        }

        private String getSubTitle(Remote.Response.Alarm alarm2) {
            if (alarm2.circle == AlarmCircle.ONCE.getCircle()) {
                return TimeUtil.timestampToStr(alarm2.timestamp, AlarmActivity.this.getString(R.string.alarm_date_format));
            }
            return AlarmCircle.getRepeatOptionDesc(AlarmActivity.this.getContext(), alarm2.circle);
        }

        private String getTitle(Remote.Response.Alarm alarm2) {
            return TimeUtil.timestampToStr(alarm2.timestamp, "HH:mm");
        }
    }

    static class EmptyHintViewHolder extends RecyclerView.O000OOo0 {
        EmptyHintViewHolder(View view) {
            super(view);
        }
    }

    static class EmptyViewHolder extends RecyclerView.O000OOo0 {
        EmptyViewHolder(View view) {
            super(view);
        }
    }
}

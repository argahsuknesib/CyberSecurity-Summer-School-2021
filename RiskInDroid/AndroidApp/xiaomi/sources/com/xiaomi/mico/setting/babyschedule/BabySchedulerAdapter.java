package com.xiaomi.mico.setting.babyschedule;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import com.xiaomi.mico.common.recyclerview.itemdecoration.SpaceItemDecoration;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.setting.babyschedule.BabySchedulerAdapter;
import com.xiaomi.mico.setting.babyschedule.bean.AddMoreItem;
import com.xiaomi.mico.setting.babyschedule.bean.BabyInfoItem;
import com.xiaomi.mico.setting.babyschedule.bean.BabySchedule;
import com.xiaomi.mico.setting.babyschedule.bean.BabyScheduleItem;
import com.xiaomi.mico.setting.babyschedule.bean.ScheduleRecommendation;
import com.xiaomi.mico.setting.babyschedule.bean.TitleItem;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.ArrayList;

public class BabySchedulerAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    private BabyInfoItem babyInfoItem;
    public OnCustomScheduleClearListener customScheduleClearListener;
    public ArrayList<BabyScheduleItem> listItems = new ArrayList<>();
    public OnBabyInfoItemClickListener onBabyInfoItemClickListener;
    private RecyclerView recyclerView;
    private SpaceItemDecoration spaceItemDecoration;
    public OnStartBabyScheduleEditActivityListener startBabyScheduleEditActivityListener;

    public interface OnBabyInfoItemClickListener {
        void onBabyInfoItemClick();
    }

    public interface OnCustomScheduleClearListener {
        void onCustomScheduleClear();
    }

    public interface OnStartBabyScheduleEditActivityListener {
        void onAddMoreClick();

        void onDialogEditItemClick(int i, BabySchedule babySchedule);

        void onRecommendationClick(ScheduleRecommendation scheduleRecommendation);
    }

    public interface ViewHolderInterface {
        void bindView(BabyScheduleItem babyScheduleItem);
    }

    BabySchedulerAdapter() {
        this.listItems.add(new TitleItem());
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView2) {
        super.onAttachedToRecyclerView(recyclerView2);
        this.recyclerView = recyclerView2;
        this.spaceItemDecoration = new SpaceItemDecoration(recyclerView2.getContext().getResources().getDimensionPixelSize(R.dimen.size_16dp));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new AddMoreViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.list_item_baby_schedule_recommendation_add, viewGroup, false));
        }
        if (i == 1) {
            return new BabyInfoViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.list_item_baby_schedule_header_profile, viewGroup, false));
        }
        if (i == 2) {
            return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.list_item_baby_schedule, viewGroup, false));
        }
        if (i == 3) {
            return new RecommendationItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.list_item_baby_schedule_recommendation, viewGroup, false));
        }
        if (i != 4) {
            return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.list_item_baby_schedule_recommendation, viewGroup, false));
        }
        return new TitleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.list_item_baby_schedule_header_title, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        if (!ContainerUtil.isEmpty(this.listItems)) {
            ((ViewHolderInterface) o000OOo0).bindView(this.listItems.get(i));
        }
    }

    public int getItemViewType(int i) {
        if (ContainerUtil.isEmpty(this.listItems)) {
            return 4;
        }
        return this.listItems.get(i).getItemType();
    }

    public int getItemCount() {
        return ContainerUtil.getSize(this.listItems);
    }

    public void updateData(ArrayList<? extends BabyScheduleItem> arrayList, boolean z) {
        if (z && this.recyclerView.getItemDecorationCount() != 0) {
            this.recyclerView.removeItemDecoration(this.spaceItemDecoration);
        } else if (this.recyclerView.getItemDecorationCount() == 0) {
            this.recyclerView.addItemDecoration(this.spaceItemDecoration);
        }
        this.listItems.clear();
        this.listItems.add(new TitleItem());
        if (!z) {
            this.babyInfoItem = new BabyInfoItem(new BabyInfoItem.ChildrenProfileLoadListener() {
                /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$BabySchedulerAdapter$LyvRPWQx1e_BB5rkcgwZUd_aH0 */

                public final void onChildrenProfileLoad() {
                    BabySchedulerAdapter.this.lambda$updateData$0$BabySchedulerAdapter();
                }
            });
            this.listItems.add(this.babyInfoItem);
        }
        this.listItems.addAll(arrayList);
        if (z) {
            this.listItems.add(new AddMoreItem());
        }
        notifyDataSetChanged();
    }

    public /* synthetic */ void lambda$updateData$0$BabySchedulerAdapter() {
        notifyItemChanged(1);
    }

    public void deleteScheduler(String str, final int i) {
        BabySchedulerApiHelper.deleteDeviceCourses(str, new ApiRequest.Listener<String>() {
            /* class com.xiaomi.mico.setting.babyschedule.BabySchedulerAdapter.AnonymousClass1 */

            public void onSuccess(String str) {
                if (BabySchedulerAdapter.this.getItemCount() <= 3) {
                    BabySchedulerAdapter.this.customScheduleClearListener.onCustomScheduleClear();
                    return;
                }
                BabySchedulerAdapter.this.listItems.remove(i);
                BabySchedulerAdapter.this.notifyItemRemoved(i);
            }

            public void onFailure(ApiError apiError) {
                ToastUtil.showToast((int) R.string.alarm_save_fail, 0);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void replaceItem(int i, BabySchedule babySchedule) {
        this.listItems.set(i, babySchedule);
        notifyItemChanged(i);
    }

    /* access modifiers changed from: package-private */
    public void updateBabyInfo(ThirdPartyResponse.ChildProfile childProfile) {
        this.babyInfoItem.setChildProfile(childProfile);
        this.listItems.set(1, this.babyInfoItem);
        notifyItemChanged(1);
    }

    class TitleViewHolder extends BaseItemViewHolder {
        ImageView ivAddSchedule;

        /* access modifiers changed from: package-private */
        /* renamed from: onClick */
        public void lambda$new$0$BabySchedulerAdapter$TitleViewHolder(View view) {
            if (BabySchedulerAdapter.this.startBabyScheduleEditActivityListener != null) {
                BabySchedulerAdapter.this.startBabyScheduleEditActivityListener.onAddMoreClick();
            }
        }

        TitleViewHolder(View view) {
            super(view);
            this.ivAddSchedule = (ImageView) view.findViewById(R.id.ivAddSchedule);
            this.ivAddSchedule.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$BabySchedulerAdapter$TitleViewHolder$0swnM8x9dU6pdt7_U31Mwrc_uuA */

                public final void onClick(View view) {
                    BabySchedulerAdapter.TitleViewHolder.this.lambda$new$0$BabySchedulerAdapter$TitleViewHolder(view);
                }
            });
        }

        public void bindView(BabyScheduleItem babyScheduleItem) {
            super.bindView(babyScheduleItem);
        }
    }

    class AddMoreViewHolder extends BaseItemViewHolder {
        AddMoreViewHolder(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$BabySchedulerAdapter$AddMoreViewHolder$b41g_VaPlQenXzHCvgAtMqjTgY */

                public final void onClick(View view) {
                    BabySchedulerAdapter.AddMoreViewHolder.this.lambda$new$0$BabySchedulerAdapter$AddMoreViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$BabySchedulerAdapter$AddMoreViewHolder(View view) {
            if (BabySchedulerAdapter.this.startBabyScheduleEditActivityListener != null) {
                BabySchedulerAdapter.this.startBabyScheduleEditActivityListener.onAddMoreClick();
            }
        }

        public void bindView(BabyScheduleItem babyScheduleItem) {
            super.bindView(babyScheduleItem);
        }
    }

    class BabyInfoViewHolder extends BaseItemViewHolder {
        ImageView ivAvatar;
        TextView tvAge;
        TextView tvNickName;

        BabyInfoViewHolder(View view) {
            super(view);
            this.ivAvatar = (ImageView) view.findViewById(R.id.ivAvatar);
            this.tvNickName = (TextView) view.findViewById(R.id.tvNickName);
            this.tvAge = (TextView) view.findViewById(R.id.tvAge);
        }

        public void bindView(BabyScheduleItem babyScheduleItem) {
            super.bindView(babyScheduleItem);
            ThirdPartyResponse.ChildProfile childProfile = ((BabyInfoItem) babyScheduleItem).getChildProfile();
            int i = R.drawable.class_baby_man;
            if (childProfile == null || ContainerUtil.isEmpty(childProfile.nickName)) {
                this.tvNickName.setText((int) R.string.baby_schedule_set_info);
                this.tvAge.setText((int) R.string.baby_schedule_improve_info);
                this.ivAvatar.setImageResource(R.drawable.class_baby_man);
                return;
            }
            this.tvNickName.setText(childProfile.nickName);
            this.tvAge.setText(childProfile.getBirthText());
            ImageView imageView = this.ivAvatar;
            if (!childProfile.isBoy()) {
                i = R.drawable.class_baby_woman;
            }
            imageView.setImageResource(i);
        }
    }

    class ItemViewHolder extends BaseItemViewHolder {
        private BabySchedulerHorizontalAdapter babySchedulerHorizontalAdapter;
        ImageView ivMoreSetting;
        RecyclerView lvContents;
        TextView tvRepeatTime;
        TextView tvTime;

        ItemViewHolder(View view) {
            super(view);
            this.tvTime = (TextView) view.findViewById(R.id.tvTime);
            this.tvRepeatTime = (TextView) view.findViewById(R.id.tvRepeatTime);
            this.ivMoreSetting = (ImageView) view.findViewById(R.id.ivMoreSetting);
            this.ivMoreSetting.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$BabySchedulerAdapter$ItemViewHolder$qjoCfpUAvWGgbbpbqROqNUMg */

                public final void onClick(View view) {
                    BabySchedulerAdapter.ItemViewHolder.this.lambda$new$0$BabySchedulerAdapter$ItemViewHolder(view);
                }
            });
            this.lvContents = (RecyclerView) view.findViewById(R.id.lvContents);
        }

        public /* synthetic */ void lambda$new$0$BabySchedulerAdapter$ItemViewHolder(View view) {
            onClick();
        }

        public void onClick() {
            new MLAlertDialog.Builder(this.ivMoreSetting.getContext()).O000000o((int) R.array.baby_schedule_edit_delete_cancel, -1, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$BabySchedulerAdapter$ItemViewHolder$GQFxCMavgUqrTuZOQVaKa7ZExc */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    BabySchedulerAdapter.ItemViewHolder.this.lambda$onClick$1$BabySchedulerAdapter$ItemViewHolder(dialogInterface, i);
                }
            }).O00000o().show();
        }

        public /* synthetic */ void lambda$onClick$1$BabySchedulerAdapter$ItemViewHolder(DialogInterface dialogInterface, int i) {
            if (i == 0) {
                if (BabySchedulerAdapter.this.startBabyScheduleEditActivityListener != null) {
                    BabySchedulerAdapter.this.startBabyScheduleEditActivityListener.onDialogEditItemClick(getAdapterPosition(), (BabySchedule) this.babyScheduleItem);
                }
            } else if (i == 1) {
                BabySchedulerAdapter.this.deleteScheduler(((BabySchedule) this.babyScheduleItem).alarmId, getAdapterPosition());
            }
            dialogInterface.dismiss();
        }

        public void bindView(BabyScheduleItem babyScheduleItem) {
            super.bindView(babyScheduleItem);
            BabySchedule babySchedule = (BabySchedule) babyScheduleItem;
            this.tvTime.setText(babySchedule.getFormattedAlarmTime());
            TextView textView = this.tvRepeatTime;
            textView.setText(babySchedule.getFormattedCircle(textView.getContext()));
            this.babySchedulerHorizontalAdapter = new BabySchedulerHorizontalAdapter();
            this.lvContents.setAdapter(this.babySchedulerHorizontalAdapter);
            this.babySchedulerHorizontalAdapter.updateData(babySchedule.getScheduleResource(), false);
        }
    }

    class RecommendationItemViewHolder extends BaseItemViewHolder {
        ImageView ivIcon;
        TextView tvIntro;
        TextView tvTime;

        RecommendationItemViewHolder(View view) {
            super(view);
            this.tvTime = (TextView) view.findViewById(R.id.tvTime);
            this.tvIntro = (TextView) view.findViewById(R.id.tvIntro);
            this.ivIcon = (ImageView) view.findViewById(R.id.ivIcon);
        }

        public void bindView(BabyScheduleItem babyScheduleItem) {
            super.bindView(babyScheduleItem);
            ScheduleRecommendation scheduleRecommendation = (ScheduleRecommendation) babyScheduleItem;
            this.tvTime.setText(scheduleRecommendation.getRepeatTime());
            this.tvIntro.setText(scheduleRecommendation.getIntro());
            Picasso.get().load(scheduleRecommendation.getCoverResId()).into(this.ivIcon);
        }
    }

    class BaseItemViewHolder extends RecyclerView.O000OOo0 implements ViewHolderInterface {
        protected final int adapterPosition = getAdapterPosition();
        BabyScheduleItem babyScheduleItem;

        BaseItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener(view) {
                /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$BabySchedulerAdapter$BaseItemViewHolder$6x5Ns8bmnRtYMp8IuGNajMQQjk */
                private final /* synthetic */ View f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    BabySchedulerAdapter.BaseItemViewHolder.this.lambda$new$0$BabySchedulerAdapter$BaseItemViewHolder(this.f$1, view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$BabySchedulerAdapter$BaseItemViewHolder(View view, View view2) {
            int itemViewType = BabySchedulerAdapter.this.getItemViewType(getAdapterPosition());
            if (itemViewType == 3) {
                if (BabySchedulerAdapter.this.startBabyScheduleEditActivityListener != null) {
                    BabySchedulerAdapter.this.startBabyScheduleEditActivityListener.onRecommendationClick((ScheduleRecommendation) this.babyScheduleItem);
                }
            } else if (itemViewType != 1) {
                BabyScheduleItem babyScheduleItem2 = this.babyScheduleItem;
                if (babyScheduleItem2 != null) {
                    babyScheduleItem2.handleItemClick(view.getContext(), getAdapterPosition());
                }
            } else if (BabySchedulerAdapter.this.onBabyInfoItemClickListener != null) {
                BabySchedulerAdapter.this.onBabyInfoItemClickListener.onBabyInfoItemClick();
            }
        }

        public void bindView(BabyScheduleItem babyScheduleItem2) {
            this.babyScheduleItem = babyScheduleItem2;
        }
    }

    /* access modifiers changed from: package-private */
    public void setOnStartBabyScheduleEditActivityListener(OnStartBabyScheduleEditActivityListener onStartBabyScheduleEditActivityListener) {
        this.startBabyScheduleEditActivityListener = onStartBabyScheduleEditActivityListener;
    }

    /* access modifiers changed from: package-private */
    public void setOnCustomScheduleClearListener(OnCustomScheduleClearListener onCustomScheduleClearListener) {
        this.customScheduleClearListener = onCustomScheduleClearListener;
    }

    /* access modifiers changed from: package-private */
    public void setOnBabyInfoItemClickListener(OnBabyInfoItemClickListener onBabyInfoItemClickListener2) {
        this.onBabyInfoItemClickListener = onBabyInfoItemClickListener2;
    }
}

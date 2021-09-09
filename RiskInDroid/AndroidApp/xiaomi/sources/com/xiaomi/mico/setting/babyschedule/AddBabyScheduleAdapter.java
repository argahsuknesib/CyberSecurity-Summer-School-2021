package com.xiaomi.mico.setting.babyschedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import com.xiaomi.mico.common.schema.SchemaManager;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.setting.babyschedule.AddBabyScheduleAdapter;
import com.xiaomi.mico.setting.babyschedule.bean.BabyScheduleItem;
import com.xiaomi.mico.setting.babyschedule.bean.ScheduleItem;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Iterator;

public class AddBabyScheduleAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    public ArrayList<ScheduleItem> schedulerItems = new ArrayList<>();
    public ArrayList<ScheduleItem> schedulerItemsFromEditPage = new ArrayList<>();

    public interface ViewHolderInterface {
        void bindView(BabyScheduleItem babyScheduleItem, int i);
    }

    AddBabyScheduleAdapter() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new RecommendationItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.list_item_add_baby_schedule, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        if (!ContainerUtil.isEmpty(this.schedulerItems)) {
            ((ViewHolderInterface) o000OOo0).bindView(this.schedulerItems.get(i), i);
        }
    }

    public int getItemCount() {
        return ContainerUtil.getSize(this.schedulerItems);
    }

    public void updateData(ArrayList<ScheduleItem> arrayList, ArrayList<ScheduleItem> arrayList2) {
        this.schedulerItemsFromEditPage = arrayList2;
        this.schedulerItems.clear();
        if (ContainerUtil.isEmpty(arrayList)) {
            this.schedulerItems.addAll(new ArrayList());
        } else {
            Iterator<ScheduleItem> it = arrayList.iterator();
            while (it.hasNext()) {
                ScheduleItem next = it.next();
                next.isAdded = arrayList2.contains(next);
            }
            this.schedulerItems.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    class RecommendationItemViewHolder extends BaseItemViewHolder {
        TextView btAdd;
        private ScheduleItem item;
        ImageView ivIcon;
        TextView tvChannelName;
        TextView tvIntro;

        RecommendationItemViewHolder(View view) {
            super(view);
            this.tvChannelName = (TextView) view.findViewById(R.id.tvChannelName);
            this.tvIntro = (TextView) view.findViewById(R.id.tvIntro);
            this.ivIcon = (ImageView) view.findViewById(R.id.ivIcon);
            this.btAdd = (TextView) view.findViewById(R.id.btAdd);
            this.btAdd.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$AddBabyScheduleAdapter$RecommendationItemViewHolder$bfOfdpCA8rtqlJfqCmt_qWeZcdc */

                public final void onClick(View view) {
                    AddBabyScheduleAdapter.RecommendationItemViewHolder.this.lambda$new$0$AddBabyScheduleAdapter$RecommendationItemViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$AddBabyScheduleAdapter$RecommendationItemViewHolder(View view) {
            onClick();
        }

        public void onClick() {
            ScheduleItem scheduleItem = this.item;
            scheduleItem.isAdded = !scheduleItem.isAdded;
            if (!this.item.isAdded) {
                AddBabyScheduleAdapter.this.schedulerItemsFromEditPage.remove(this.item);
            } else if (ContainerUtil.getSize(AddBabyScheduleAdapter.this.schedulerItemsFromEditPage) < 30) {
                AddBabyScheduleAdapter.this.schedulerItemsFromEditPage.add(this.item);
                ToastUtil.showToast((int) R.string.baby_schedule_add_schedule_success);
            } else {
                this.item.isAdded = false;
                ToastUtil.showToast((int) R.string.baby_schedule_add_schedule_more_than_thirty);
            }
            updateBtnAdd();
        }

        private void updateBtnAdd() {
            String str;
            this.btAdd.setSelected(this.item.isAdded);
            this.btAdd.setCompoundDrawablesWithIntrinsicBounds(this.item.isAdded ? 0 : R.drawable.class_particulars_alarm, 0, 0, 0);
            Context context = this.btAdd.getContext();
            TextView textView = this.btAdd;
            if (this.item.isAdded) {
                str = context.getString(R.string.baby_schedule_cancel);
            } else {
                str = context.getString(R.string.baby_schedule_add);
            }
            textView.setText(str);
        }

        public void bindView(BabyScheduleItem babyScheduleItem, int i) {
            super.bindView(babyScheduleItem, i);
            this.item = (ScheduleItem) babyScheduleItem;
            this.tvChannelName.setText(this.item.title);
            this.tvIntro.setText(this.item.shortDescription);
            Picasso.get().load(this.item.getImageUrl()).into(this.ivIcon);
            updateBtnAdd();
        }
    }

    class BaseItemViewHolder extends RecyclerView.O000OOo0 implements ViewHolderInterface {
        protected int position;

        BaseItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener(view) {
                /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$AddBabyScheduleAdapter$BaseItemViewHolder$EPpOcDjoVHFxgbN7_yEuoraWnS4 */
                private final /* synthetic */ View f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    AddBabyScheduleAdapter.BaseItemViewHolder.this.lambda$new$0$AddBabyScheduleAdapter$BaseItemViewHolder(this.f$1, view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$AddBabyScheduleAdapter$BaseItemViewHolder(View view, View view2) {
            handleItemClick(view);
        }

        private void handleItemClick(View view) {
            ScheduleItem scheduleItem = AddBabyScheduleAdapter.this.schedulerItems.get(this.position);
            String str = scheduleItem.target;
            if (ContainerUtil.hasData(str)) {
                Context context = view.getContext();
                SchemaManager.handleSchema(context, str + "&fromAddBabySchedule=true");
                return;
            }
            MusicHelper.processStation(view.getContext(), null, scheduleItem.srcStation, null);
        }

        public void bindView(BabyScheduleItem babyScheduleItem, int i) {
            this.position = i;
        }
    }
}

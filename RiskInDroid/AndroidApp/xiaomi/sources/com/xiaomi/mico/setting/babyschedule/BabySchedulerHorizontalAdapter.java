package com.xiaomi.mico.setting.babyschedule;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.setting.babyschedule.BabySchedulerHorizontalAdapter;
import com.xiaomi.mico.setting.babyschedule.bean.HorizontalListItemAddMore;
import com.xiaomi.mico.setting.babyschedule.bean.HorizontalListItemInterface;
import com.xiaomi.mico.setting.babyschedule.bean.HorizontalListItemWhiteSpace;
import com.xiaomi.mico.setting.babyschedule.bean.ScheduleItem;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class BabySchedulerHorizontalAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    public boolean isEditing;
    public ArrayList<HorizontalListItemInterface> listItems = new ArrayList<>();
    public OnAddMoreClickListener onAddMoreClickListener;

    public interface OnAddMoreClickListener {
        void onAddMoreClick();
    }

    public interface ViewHolderInterface {
        void bindView(HorizontalListItemInterface horizontalListItemInterface);
    }

    BabySchedulerHorizontalAdapter() {
        this.listItems.add(new HorizontalListItemAddMore());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == -1) {
            return new FakeItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.list_item_fake_of_list_item_baby_schedule, viewGroup, false));
        }
        if (i == 0) {
            return new AddMoreViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.list_item_add_of_list_item_baby_schedule, viewGroup, false));
        }
        if (i != 1) {
            return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.list_item_of_list_item_baby_schedule, viewGroup, false));
        }
        return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.list_item_of_list_item_baby_schedule, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        if (!ContainerUtil.isEmpty(this.listItems) && getItemViewType(i) != -1) {
            ((ViewHolderInterface) o000OOo0).bindView(this.listItems.get(i));
        }
    }

    public int getItemViewType(int i) {
        if (ContainerUtil.isEmpty(this.listItems)) {
            return 0;
        }
        return this.listItems.get(i).getItemType();
    }

    public int getItemCount() {
        return ContainerUtil.getSize(this.listItems);
    }

    public void updateData(ArrayList<? extends HorizontalListItemInterface> arrayList, boolean z) {
        this.isEditing = z;
        this.listItems.clear();
        if (this.isEditing) {
            this.listItems.add(new HorizontalListItemAddMore());
        } else {
            this.listItems.add(new HorizontalListItemWhiteSpace());
        }
        this.listItems.addAll(arrayList);
        notifyDataSetChanged();
    }

    /* access modifiers changed from: package-private */
    public ArrayList getListItems() {
        if (ContainerUtil.isEmpty(this.listItems)) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(this.listItems);
        arrayList.remove(0);
        return arrayList;
    }

    class AddMoreViewHolder extends BaseItemViewHolder {
        AddMoreViewHolder(View view) {
            super(view);
        }

        public void bindView(HorizontalListItemInterface horizontalListItemInterface) {
            super.bindView(horizontalListItemInterface);
        }
    }

    class ItemViewHolder extends BaseItemViewHolder {
        ImageView ivDel;

        ItemViewHolder(View view) {
            super(view);
            this.ivDel = (ImageView) view.findViewById(R.id.ivDel);
            this.ivDel.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$BabySchedulerHorizontalAdapter$ItemViewHolder$fSbkykQpejNre5y46jXHrXQ1Hw */

                public final void onClick(View view) {
                    BabySchedulerHorizontalAdapter.ItemViewHolder.this.lambda$new$0$BabySchedulerHorizontalAdapter$ItemViewHolder(view);
                }
            });
        }

        public void bindView(HorizontalListItemInterface horizontalListItemInterface) {
            super.bindView(horizontalListItemInterface);
            ScheduleItem scheduleItem = (ScheduleItem) horizontalListItemInterface;
            this.tvChannelName.setText(scheduleItem.title);
            this.tvChannelInfo.setText(scheduleItem.shortDescription);
            Picasso.get().load(scheduleItem.getImageUrl()).into(this.ivChannelCover);
            this.ivDel.setVisibility(BabySchedulerHorizontalAdapter.this.isEditing ? 0 : 8);
        }

        /* renamed from: onClick */
        public void lambda$new$0$BabySchedulerHorizontalAdapter$ItemViewHolder(View view) {
            BabySchedulerHorizontalAdapter.this.listItems.remove(getAdapterPosition());
            BabySchedulerHorizontalAdapter.this.notifyDataSetChanged();
        }
    }

    class FakeItemViewHolder extends RecyclerView.O000OOo0 implements ViewHolderInterface {
        public void bindView(HorizontalListItemInterface horizontalListItemInterface) {
        }

        FakeItemViewHolder(View view) {
            super(view);
        }
    }

    class BaseItemViewHolder extends RecyclerView.O000OOo0 implements ViewHolderInterface {
        private HorizontalListItemInterface itemInterface;
        ImageView ivChannelCover;
        TextView tvChannelInfo;
        TextView tvChannelName;

        BaseItemViewHolder(View view) {
            super(view);
            this.tvChannelName = (TextView) view.findViewById(R.id.tvChannelName);
            this.tvChannelInfo = (TextView) view.findViewById(R.id.tvChannelInfo);
            this.ivChannelCover = (ImageView) view.findViewById(R.id.ivChannelCover);
            view.setOnClickListener(new View.OnClickListener(view) {
                /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$BabySchedulerHorizontalAdapter$BaseItemViewHolder$oEnU5NkXLoVRc5IhCGnj8DlzJ_8 */
                private final /* synthetic */ View f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    BabySchedulerHorizontalAdapter.BaseItemViewHolder.this.lambda$new$0$BabySchedulerHorizontalAdapter$BaseItemViewHolder(this.f$1, view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$BabySchedulerHorizontalAdapter$BaseItemViewHolder(View view, View view2) {
            HorizontalListItemInterface horizontalListItemInterface = this.itemInterface;
            if (horizontalListItemInterface instanceof HorizontalListItemAddMore) {
                BabySchedulerHorizontalAdapter.this.onAddMoreClickListener.onAddMoreClick();
            } else if (horizontalListItemInterface != null) {
                horizontalListItemInterface.handleItemClick(view.getContext());
            }
        }

        public void bindView(HorizontalListItemInterface horizontalListItemInterface) {
            this.itemInterface = horizontalListItemInterface;
        }
    }

    /* access modifiers changed from: package-private */
    public void setOnAddMoreClickListener(OnAddMoreClickListener onAddMoreClickListener2) {
        this.onAddMoreClickListener = onAddMoreClickListener2;
    }
}

package com.xiaomi.smarthome.miio.camera.face.adapter;

import _m_j.cnw;
import _m_j.cnx;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import com.xiaomi.smarthome.miio.camera.face.adapter.DailyStoryAdapter;
import com.xiaomi.smarthome.miio.camera.face.model.DailyStory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DailyStoryAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    private int ITEM_TYPE_EMPTY = 1;
    public int ITEM_TYPE_LAST = 2;
    public int ITEM_TYPE_VIDEO = 0;
    public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
    public ClickCallBack mClickCallBack;
    public Context mContext;
    public List<DailyStory> mData = new ArrayList();
    public String mDid;
    public cnw mOptions;
    public long mRollingSaveInterval;

    public interface ClickCallBack {
        void onRecyclerClick(int i);
    }

    public DailyStoryAdapter(Context context, ClickCallBack clickCallBack, String str) {
        initImageDisplayOptions(context);
        this.mClickCallBack = clickCallBack;
        this.mContext = context;
        this.mDid = str;
    }

    public List<DailyStory> getData() {
        return this.mData;
    }

    public void setData(List<DailyStory> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    public void setRollingSaveInterval(long j) {
        this.mRollingSaveInterval = j;
        notifyItemChanged(this.mData.size());
    }

    public class ViewHolder extends RecyclerView.O000OOo0 {
        ImageView daily_story_image;
        ImageView iv_daily_story_play;
        TextView tv_empty_des;
        TextView tv_empty_tip;
        TextView tv_time;

        public ViewHolder(View view, int i) {
            super(view);
            if (i == DailyStoryAdapter.this.ITEM_TYPE_LAST) {
                this.tv_empty_tip = (TextView) view.findViewById(R.id.tv_empty_tip);
                return;
            }
            this.tv_time = (TextView) view.findViewById(R.id.tv_time);
            this.tv_empty_des = (TextView) view.findViewById(R.id.tv_empty_des);
            this.daily_story_image = (ImageView) view.findViewById(R.id.daily_story_image);
            this.iv_daily_story_play = (ImageView) view.findViewById(R.id.iv_daily_story_play);
            if (i == DailyStoryAdapter.this.ITEM_TYPE_VIDEO) {
                this.tv_empty_des.setVisibility(8);
                this.daily_story_image.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.miio.camera.face.adapter.$$Lambda$DailyStoryAdapter$ViewHolder$ElfBc07nDy7h_fbJ_AsxiyB3Vp8 */

                    public final void onClick(View view) {
                        DailyStoryAdapter.ViewHolder.this.lambda$new$0$DailyStoryAdapter$ViewHolder(view);
                    }
                });
                return;
            }
            this.daily_story_image.setVisibility(8);
            this.iv_daily_story_play.setVisibility(8);
        }

        public /* synthetic */ void lambda$new$0$DailyStoryAdapter$ViewHolder(View view) {
            int layoutPosition = getLayoutPosition();
            if (layoutPosition == -1) {
                layoutPosition = getAdapterPosition();
            }
            DailyStoryAdapter.this.mClickCallBack.onRecyclerClick(layoutPosition);
        }

        public void bindView(int i) {
            if (i < DailyStoryAdapter.this.mData.size()) {
                DailyStory dailyStory = DailyStoryAdapter.this.mData.get(i);
                this.tv_time.setText(DailyStoryAdapter.this.dateFormat.format(Long.valueOf(dailyStory.createTime)));
                if (dailyStory.fileId != null && dailyStory.imgStoreId != null) {
                    String snapshotUrl = CloudVideoNetUtils.getInstance().getSnapshotUrl(DailyStoryAdapter.this.mDid, dailyStory.fileId, dailyStory.imgStoreId);
                    if (cnx.O000000o().O00000Oo()) {
                        cnx.O000000o().O000000o(snapshotUrl, this.daily_story_image, DailyStoryAdapter.this.mOptions);
                        return;
                    }
                    return;
                }
                return;
            }
            this.tv_empty_tip.setText(String.format(DailyStoryAdapter.this.mContext.getResources().getString(R.string.daily_story_empty_content_tips2), Long.valueOf(DailyStoryAdapter.this.mRollingSaveInterval / 86400000)));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        if (i == this.ITEM_TYPE_LAST) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_daily_story_last, viewGroup, false);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_daily_story, viewGroup, false);
        }
        return new ViewHolder(view, i);
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        ((ViewHolder) o000OOo0).bindView(i);
    }

    public int getItemCount() {
        return this.mData.size() + 1;
    }

    public int getItemViewType(int i) {
        if (i == this.mData.size()) {
            return this.ITEM_TYPE_LAST;
        }
        if (i < 0 || i >= this.mData.size() || this.mData.get(i).fileId.length() <= 0) {
            return this.ITEM_TYPE_EMPTY;
        }
        return this.ITEM_TYPE_VIDEO;
    }

    private void initImageDisplayOptions(Context context) {
        cnw.O000000o o000000o = new cnw.O000000o();
        o000000o.O00000o = context.getResources().getDrawable(R.drawable.event_list_item_img_bg);
        o000000o.O00000oO = context.getResources().getDrawable(R.drawable.event_list_item_img_bg);
        o000000o.O00000oo = context.getResources().getDrawable(R.drawable.event_list_item_img_bg);
        o000000o.O0000OOo = true;
        o000000o.O0000Oo0 = true;
        o000000o.O0000o00 = true;
        cnw.O000000o O000000o2 = o000000o.O000000o(Bitmap.Config.RGB_565);
        O000000o2.O0000Oo = ImageScaleType.EXACTLY_STRETCHED;
        this.mOptions = O000000o2.O000000o();
    }
}

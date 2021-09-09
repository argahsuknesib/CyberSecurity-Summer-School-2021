package com.xiaomi.smarthome.camera.activity.alarm2.adapter;

import _m_j.cid;
import _m_j.cnx;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mijia.model.alarmcloud.AlarmVideo;
import com.mijia.model.alarmcloud.FaceInfoMeta;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.alarm2.util.Alarm2Utils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class AlarmEventListAdapter2 extends RecyclerView.O000000o<ItemViewHolder> {
    public int currentOffset;
    public boolean isShareUser;
    public boolean itemIsPlaying;
    private cid mCameraDevice;
    public Context mContext;
    public List<AlarmVideo> mData;
    public OnItemClickLister mOnItemClickLister;
    public SimpleDateFormat mSdf = new SimpleDateFormat("HH:mm:ss", Locale.CHINA);

    public interface OnItemClickLister {
        void onBtnClick(AlarmVideo alarmVideo, int i, boolean z);

        void onItemClick(AlarmVideo alarmVideo, int i, String str, String str2);

        void smoothScrollToPosition(AlarmVideo alarmVideo, int i);

        void touchPosition(AlarmVideo alarmVideo, int i, String str, String str2);
    }

    public AlarmEventListAdapter2(Context context, cid cid) {
        this.mContext = context;
        this.mCameraDevice = cid;
        this.mData = new ArrayList();
    }

    public List<AlarmVideo> getDatas() {
        return this.mData;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ItemViewHolder(LayoutInflater.from(this.mContext).inflate((int) R.layout.event_list_item_normal2, viewGroup, false));
    }

    public void setData(List<AlarmVideo> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    public void setShareUser(boolean z) {
        this.isShareUser = z;
    }

    public AlarmVideo getItem(int i) {
        return this.mData.get(i);
    }

    public int getItemCount() {
        return this.mData.size();
    }

    public void parseProgress(long j) {
        int size = this.mData.size();
        if (size != 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= size) {
                    break;
                } else if (new Double(this.mData.get(i).startDuration * 1000.0d).longValue() > j) {
                    this.mData.get(i);
                    i2 = i - 1;
                    break;
                } else {
                    i2 = i;
                    i++;
                }
            }
            if (i2 >= 0 && i2 < getItemCount()) {
                AlarmVideo item = getItem(i2);
                if (this.currentOffset != item.offset) {
                    this.currentOffset = item.offset;
                    notifyDataSetChanged();
                    OnItemClickLister onItemClickLister = this.mOnItemClickLister;
                    if (onItemClickLister != null) {
                        onItemClickLister.smoothScrollToPosition(item, i2);
                    }
                }
                if (this.mOnItemClickLister != null) {
                    this.mOnItemClickLister.touchPosition(item, i2, Alarm2Utils.getEventName(item, Alarm2Utils.sortEventTypes(item.eventType)), this.mSdf.format(Long.valueOf(item.createTime)));
                }
            }
        }
    }

    public void onBindViewHolder(ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.bindView(i);
    }

    public void setOnItemClickLister(OnItemClickLister onItemClickLister) {
        this.mOnItemClickLister = onItemClickLister;
    }

    class ItemViewHolder extends RecyclerView.O000OOo0 {
        private ImageView ivCover;
        private ImageView iv_event_type_ring;
        public TextView tvEventName;
        public TextView tvTime;
        private TextView tv_playing;

        public ItemViewHolder(View view) {
            super(view);
            this.ivCover = (ImageView) view.findViewById(R.id.crv_event_image);
            this.tvTime = (TextView) view.findViewById(R.id.tv_event_time);
            this.tv_playing = (TextView) view.findViewById(R.id.tv_playing);
            this.tvEventName = (TextView) view.findViewById(R.id.tv_event_des);
            this.iv_event_type_ring = (ImageView) view.findViewById(R.id.iv_event_type_ring);
        }

        public void bindView(final int i) {
            final AlarmVideo item = AlarmEventListAdapter2.this.getItem(i);
            this.tv_playing.setVisibility(item.isPlaying ? 0 : 8);
            if (cnx.O000000o().O00000Oo()) {
                cnx.O000000o().O000000o(item.imgStoreUrl, this.ivCover);
            }
            this.tvTime.setText(AlarmEventListAdapter2.this.mSdf.format(Long.valueOf(item.createTime)));
            if (AlarmEventListAdapter2.this.currentOffset == item.offset) {
                AlarmEventListAdapter2.this.itemIsPlaying = true;
                this.tv_playing.setVisibility(0);
                this.tvTime.setTextColor(AlarmEventListAdapter2.this.mContext.getResources().getColor(R.color.mj_color_green_normal));
                this.tvEventName.setTextColor(AlarmEventListAdapter2.this.mContext.getResources().getColor(R.color.mj_color_green_normal));
            } else {
                AlarmEventListAdapter2.this.itemIsPlaying = false;
                this.tv_playing.setVisibility(8);
                if (item.isRead) {
                    this.tvTime.setTextColor(Color.parseColor("#999999"));
                    this.tvEventName.setTextColor(Color.parseColor("#999999"));
                } else {
                    this.tvTime.setTextColor(AlarmEventListAdapter2.this.mContext.getResources().getColor(R.color.mj_color_black_50_transparent));
                    this.tvEventName.setTextColor(AlarmEventListAdapter2.this.mContext.getResources().getColor(R.color.mj_color_black));
                }
            }
            String str = item.eventType;
            if (TextUtils.isEmpty(str)) {
                this.tvEventName.setText("");
                return;
            }
            String[] sortEventTypes = Alarm2Utils.sortEventTypes(str);
            this.tvEventName.setText(Alarm2Utils.getEventName(item, sortEventTypes));
            setViews(sortEventTypes);
            if (item.fileIdMetaResult != null && !AlarmEventListAdapter2.this.isShareUser) {
                Iterator<FaceInfoMeta> it = item.fileIdMetaResult.faceInfoMetas.iterator();
                while (it.hasNext() && ((r2 = it.next()) == null || !r2.matched)) {
                }
            }
            this.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmEventListAdapter2.ItemViewHolder.AnonymousClass1 */

                public void onClick(View view) {
                    AlarmEventListAdapter2.this.currentOffset = item.offset;
                    AlarmEventListAdapter2.this.notifyDataSetChanged();
                    if (AlarmEventListAdapter2.this.mOnItemClickLister != null) {
                        AlarmEventListAdapter2.this.mOnItemClickLister.onItemClick(AlarmEventListAdapter2.this.mData.get(i), i, ItemViewHolder.this.tvEventName.getText().toString(), ItemViewHolder.this.tvTime.getText().toString());
                    }
                }
            });
        }

        private void setViews(String[] strArr) {
            if (strArr != null && strArr.length > 0) {
                if (strArr[0].equals("AI")) {
                    this.iv_event_type_ring.setImageResource(R.drawable.icon_event_ai_new);
                    if (AlarmEventListAdapter2.this.itemIsPlaying) {
                        this.tvTime.setTextColor(AlarmEventListAdapter2.this.mContext.getResources().getColor(R.color.video_player_selected_color_ai));
                        this.tvEventName.setTextColor(AlarmEventListAdapter2.this.mContext.getResources().getColor(R.color.video_player_selected_color_ai));
                    }
                } else if (strArr[0].equals("BabyCry")) {
                    this.iv_event_type_ring.setImageResource(R.drawable.icon_event_baby_cry_new);
                    if (AlarmEventListAdapter2.this.itemIsPlaying) {
                        this.tvTime.setTextColor(AlarmEventListAdapter2.this.mContext.getResources().getColor(R.color.video_player_selected_color_baby));
                        this.tvEventName.setTextColor(AlarmEventListAdapter2.this.mContext.getResources().getColor(R.color.video_player_selected_color_baby));
                    }
                } else if (strArr[0].equals("KnownFace") || strArr[0].equals("Face")) {
                    this.iv_event_type_ring.setImageResource(R.drawable.icon_event_face_new);
                    if (AlarmEventListAdapter2.this.itemIsPlaying) {
                        this.tvTime.setTextColor(AlarmEventListAdapter2.this.mContext.getResources().getColor(R.color.video_player_selected_color_face));
                        this.tvEventName.setTextColor(AlarmEventListAdapter2.this.mContext.getResources().getColor(R.color.video_player_selected_color_face));
                    }
                } else if (strArr[0].equals("Pet")) {
                    this.iv_event_type_ring.setImageResource(R.drawable.icon_event_pet_new);
                    if (AlarmEventListAdapter2.this.itemIsPlaying) {
                        this.tvTime.setTextColor(AlarmEventListAdapter2.this.mContext.getResources().getColor(R.color.video_player_selected_color_pet));
                        this.tvEventName.setTextColor(AlarmEventListAdapter2.this.mContext.getResources().getColor(R.color.video_player_selected_color_pet));
                    }
                } else if (strArr[0].equals("PeopleMotion")) {
                    this.iv_event_type_ring.setImageResource(R.drawable.icon_event_people_motion_new);
                } else if (strArr[0].equals("ObjectMotion")) {
                    this.iv_event_type_ring.setImageResource(R.drawable.icon_event_motion_new);
                    if (AlarmEventListAdapter2.this.itemIsPlaying) {
                        this.tvTime.setTextColor(AlarmEventListAdapter2.this.mContext.getResources().getColor(R.color.video_player_selected_color_move));
                        this.tvEventName.setTextColor(AlarmEventListAdapter2.this.mContext.getResources().getColor(R.color.video_player_selected_color_move));
                    }
                }
            }
        }
    }

    public static void sortByEventType(String[] strArr) {
        if (strArr != null && strArr.length > 1) {
            Arrays.sort(strArr, new Comparator<String>() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmEventListAdapter2.AnonymousClass1 */

                public final int compare(String str, String str2) {
                    return Alarm2Utils.getIntByType(str) - Alarm2Utils.getIntByType(str2);
                }
            });
        }
    }

    public static String[] getEventTypesOrdered(String str) {
        String[] split = str.split(":");
        sortByEventType(split);
        return split.length > 2 ? (String[]) Arrays.copyOfRange(split, 0, 2) : split;
    }
}

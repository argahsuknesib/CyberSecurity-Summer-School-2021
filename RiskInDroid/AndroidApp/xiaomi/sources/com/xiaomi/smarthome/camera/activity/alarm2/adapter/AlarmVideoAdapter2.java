package com.xiaomi.smarthome.camera.activity.alarm2.adapter;

import _m_j.cb;
import _m_j.cid;
import _m_j.cnx;
import _m_j.coo;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mijia.model.alarmcloud.AlarmVideo;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.alarm2.util.Alarm2Utils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AlarmVideoAdapter2 extends RecyclerView.O000000o<ViewHolder> {
    final int ITEM_TYPE_LAST = 2;
    final int ITEM_TYPE_NORMAL = 1;
    private boolean isToTheEnd;
    private boolean isVip;
    private cid mCameraDevice;
    public Context mContext;
    public List<AlarmVideo> mData;
    public ItemClickedListener mItemClickedListener;
    public SimpleDateFormat mSdf = new SimpleDateFormat("HH:mm", Locale.CHINA);
    public boolean needSetTransitionName;

    public interface ItemClickedListener {
        void onItemClicked(AlarmVideo alarmVideo, int i, String str, String str2, View view);

        void onPlaying(AlarmVideo alarmVideo, int i, String str, String str2);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public AlarmVideoAdapter2(Context context, cid cid, boolean z) {
        this.mContext = context;
        this.mCameraDevice = cid;
        this.needSetTransitionName = z;
        this.mData = new ArrayList();
        cnx.O000000o().O00000o0 = new coo() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmVideoAdapter2.AnonymousClass1 */

            public void onLoadingCancelled(String str, View view) {
            }

            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            }

            public void onLoadingFailed(String str, View view, FailReason failReason) {
            }

            public void onLoadingStarted(String str, View view) {
            }
        };
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = null;
        if (i == 1) {
            view = LayoutInflater.from(this.mContext).inflate((int) R.layout.event_list_item_normal2, (ViewGroup) null);
        } else if (i == 2) {
            view = LayoutInflater.from(this.mContext).inflate((int) R.layout.event_list_item_last, (ViewGroup) null);
        }
        return new ViewHolder(view, i);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.bindView(i);
    }

    public void setData(List<AlarmVideo> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        if (!this.isToTheEnd) {
            return this.mData.size();
        }
        return this.mData.size() + 1;
    }

    public boolean isTheLastVideo(int i) {
        return (this.isToTheEnd && i == getItemCount() + -2) || (!this.isToTheEnd && i == getItemCount() - 1);
    }

    public AlarmVideo getItem(int i) {
        if (i >= this.mData.size() || i < 0) {
            return null;
        }
        return this.mData.get(i);
    }

    public int getItemViewType(int i) {
        if (this.isToTheEnd && i == getItemCount() - 1) {
            return 2;
        }
        return 1;
    }

    public void update(List<AlarmVideo> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    public void setVipStatus(boolean z) {
        this.isVip = z;
    }

    public void setToTheEnd(boolean z) {
        this.isToTheEnd = z;
        notifyDataSetChanged();
    }

    public void highLightPlaying(int i) {
        AlarmVideo item = getItem(i);
        if (item != null) {
            resetPlayingStatus();
            item.isPlaying = true;
            notifyDataSetChanged();
        }
    }

    private void resetPlayingStatus() {
        List<AlarmVideo> list = this.mData;
        if (list != null && list.size() > 0) {
            for (AlarmVideo alarmVideo : this.mData) {
                alarmVideo.isPlaying = false;
            }
        }
    }

    public void setOnItemClickedListener(ItemClickedListener itemClickedListener) {
        this.mItemClickedListener = itemClickedListener;
    }

    class ViewHolder extends RecyclerView.O000OOo0 {
        public TextView eventDesc;
        public TextView eventTime;
        private ImageView ivCover;
        private ImageView ivRing;
        private ImageView ivRun;
        public View transitionView;
        private TextView tv_playing;
        int type;
        private View vDividerLine;

        public ViewHolder(View view, int i) {
            super(view);
            this.type = i;
            if (i != 2) {
                this.ivCover = (ImageView) view.findViewById(R.id.crv_event_image);
                this.tv_playing = (TextView) view.findViewById(R.id.tv_playing);
                this.eventTime = (TextView) view.findViewById(R.id.tv_event_time);
                this.eventDesc = (TextView) view.findViewById(R.id.tv_event_des);
                this.ivRun = (ImageView) view.findViewById(R.id.iv_event_type_pepole);
                this.ivRing = (ImageView) view.findViewById(R.id.iv_event_type_ring);
                this.vDividerLine = view.findViewById(R.id.v_divider_line);
            }
        }

        public void bindView(int i) {
            if (this.type != 2) {
                final AlarmVideo alarmVideo = AlarmVideoAdapter2.this.mData.get(i);
                this.tv_playing.setVisibility(alarmVideo.isPlaying ? 0 : 8);
                if (cnx.O000000o().O00000Oo()) {
                    cnx.O000000o().O000000o(alarmVideo.imgStoreUrl, this.ivCover);
                }
                if (AlarmVideoAdapter2.this.needSetTransitionName) {
                    this.transitionView = this.ivCover;
                    View view = this.transitionView;
                    cb.O000000o(view, "Alarm_SN" + alarmVideo.fileId + alarmVideo.offset);
                } else {
                    this.transitionView = null;
                }
                if (alarmVideo.isRead) {
                    this.eventTime.setTextColor(Color.parseColor("#999999"));
                    this.eventDesc.setTextColor(Color.parseColor("#999999"));
                } else {
                    this.eventTime.setTextColor(AlarmVideoAdapter2.this.mContext.getResources().getColor(R.color.mj_color_black));
                    this.eventDesc.setTextColor(AlarmVideoAdapter2.this.mContext.getResources().getColor(R.color.mj_color_black));
                }
                this.eventTime.setText(AlarmVideoAdapter2.this.mSdf.format(Long.valueOf(alarmVideo.createTime)));
                String str = alarmVideo.eventType;
                if (TextUtils.isEmpty(str)) {
                    this.eventDesc.setText("");
                    return;
                }
                this.ivRing.setVisibility(8);
                this.ivRun.setVisibility(8);
                String[] sortEventTypes = Alarm2Utils.sortEventTypes(str);
                this.vDividerLine.setVisibility(8);
                this.eventDesc.setText(Alarm2Utils.getEventName(alarmVideo, sortEventTypes));
                setViews(alarmVideo, sortEventTypes);
                this.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmVideoAdapter2.ViewHolder.AnonymousClass1 */

                    public void onClick(View view) {
                        if (AlarmVideoAdapter2.this.mItemClickedListener != null) {
                            AlarmVideoAdapter2.this.mItemClickedListener.onItemClicked(alarmVideo, ViewHolder.this.getAdapterPosition(), ViewHolder.this.eventDesc.getText().toString().trim(), ViewHolder.this.eventTime.getText().toString().trim(), ViewHolder.this.transitionView);
                        }
                    }
                });
                if (alarmVideo.isPlaying && AlarmVideoAdapter2.this.mItemClickedListener != null) {
                    AlarmVideoAdapter2.this.mItemClickedListener.onPlaying(alarmVideo, i, this.eventDesc.getText().toString().trim(), this.eventTime.getText().toString().trim());
                }
            }
        }

        private void setViews(AlarmVideo alarmVideo, String[] strArr) {
            if (strArr != null && strArr.length > 0) {
                if (strArr[0].equals("AI")) {
                    this.ivRing.setVisibility(0);
                    this.ivRing.setImageResource(R.drawable.icon_event_ai_new);
                    if (alarmVideo.isPlaying) {
                        this.eventTime.setTextColor(AlarmVideoAdapter2.this.mContext.getResources().getColor(R.color.video_player_selected_color_ai));
                        this.eventDesc.setTextColor(AlarmVideoAdapter2.this.mContext.getResources().getColor(R.color.video_player_selected_color_ai));
                    }
                } else if (strArr[0].equals("BabyCry")) {
                    this.ivRing.setVisibility(0);
                    this.ivRing.setImageResource(R.drawable.icon_event_baby_cry_new);
                    if (alarmVideo.isPlaying) {
                        this.eventTime.setTextColor(AlarmVideoAdapter2.this.mContext.getResources().getColor(R.color.video_player_selected_color_baby));
                        this.eventDesc.setTextColor(AlarmVideoAdapter2.this.mContext.getResources().getColor(R.color.video_player_selected_color_baby));
                    }
                } else if (strArr[0].equals("KnownFace") || strArr[0].equals("Face")) {
                    this.ivRing.setVisibility(0);
                    this.ivRing.setImageResource(R.drawable.icon_event_face_new);
                    if (alarmVideo.isPlaying) {
                        this.eventTime.setTextColor(AlarmVideoAdapter2.this.mContext.getResources().getColor(R.color.video_player_selected_color_face));
                        this.eventDesc.setTextColor(AlarmVideoAdapter2.this.mContext.getResources().getColor(R.color.video_player_selected_color_face));
                    }
                } else if (strArr[0].equals("Pet")) {
                    this.ivRing.setVisibility(0);
                    this.ivRing.setImageResource(R.drawable.icon_event_pet_new);
                    if (alarmVideo.isPlaying) {
                        this.eventTime.setTextColor(AlarmVideoAdapter2.this.mContext.getResources().getColor(R.color.video_player_selected_color_pet));
                        this.eventDesc.setTextColor(AlarmVideoAdapter2.this.mContext.getResources().getColor(R.color.video_player_selected_color_pet));
                    }
                } else if (strArr[0].equals("PeopleMotion")) {
                    this.ivRing.setVisibility(0);
                    this.ivRing.setImageResource(R.drawable.icon_event_people_motion_new);
                    if (alarmVideo.isPlaying) {
                        this.eventTime.setTextColor(AlarmVideoAdapter2.this.mContext.getResources().getColor(R.color.video_player_selected_color));
                        this.eventDesc.setTextColor(AlarmVideoAdapter2.this.mContext.getResources().getColor(R.color.video_player_selected_color));
                    }
                } else if (strArr[0].equals("ObjectMotion")) {
                    this.ivRing.setVisibility(0);
                    this.ivRing.setImageResource(R.drawable.icon_event_motion_new);
                    if (alarmVideo.isPlaying) {
                        this.eventTime.setTextColor(AlarmVideoAdapter2.this.mContext.getResources().getColor(R.color.video_player_selected_color_move));
                        this.eventDesc.setTextColor(AlarmVideoAdapter2.this.mContext.getResources().getColor(R.color.video_player_selected_color_move));
                    }
                } else {
                    this.ivRing.setVisibility(8);
                    this.ivRun.setVisibility(8);
                }
            }
        }
    }
}

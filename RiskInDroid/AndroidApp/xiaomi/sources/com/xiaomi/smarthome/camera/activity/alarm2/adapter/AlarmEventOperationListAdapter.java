package com.xiaomi.smarthome.camera.activity.alarm2.adapter;

import _m_j.cid;
import _m_j.cnx;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mijia.model.alarmcloud.AlarmVideo;
import com.mijia.model.alarmcloud.FaceInfoMeta;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmEventOperationListAdapter;
import com.xiaomi.smarthome.camera.activity.alarm2.util.Alarm2Utils;
import com.xiaomi.smarthome.library.common.widget.RoundedImageView;
import com.xiaomi.smarthome.miio.camera.face.FaceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlarmEventOperationListAdapter extends RecyclerView.O000000o<ItemViewHolder> {
    private Context mContext;
    private List<AlarmVideo> mData = new ArrayList();
    public OnItemClickLister mOnItemClickLister;
    public cid mijiaCameraDevice;

    public interface OnItemClickLister {
        void onItemClick(View view, AlarmVideo alarmVideo, int i);
    }

    public AlarmEventOperationListAdapter(Context context, cid cid) {
        this.mContext = context;
        this.mijiaCameraDevice = cid;
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
        return new ItemViewHolder(LayoutInflater.from(this.mContext).inflate((int) R.layout.event_operation_list_item, viewGroup, false));
    }

    public void setData(List<AlarmVideo> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    public AlarmVideo getItem(int i) {
        return this.mData.get(i);
    }

    public int getItemCount() {
        return this.mData.size();
    }

    public void onBindViewHolder(ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.bindView(i);
    }

    public void setOnItemClickLister(OnItemClickLister onItemClickLister) {
        this.mOnItemClickLister = onItemClickLister;
    }

    class ItemViewHolder extends RecyclerView.O000OOo0 {
        private RelativeLayout event_operation_item_rl;
        private RoundedImageView icon_face;
        private ImageView iv_add_face;
        private TextView tv_event_des;
        private TextView tv_event_time;
        private TextView tv_feed_back;

        public ItemViewHolder(View view) {
            super(view);
            this.event_operation_item_rl = (RelativeLayout) view.findViewById(R.id.event_operation_item_rl);
            this.icon_face = (RoundedImageView) view.findViewById(R.id.icon_face);
            this.iv_add_face = (ImageView) view.findViewById(R.id.iv_add_face);
            this.tv_event_des = (TextView) view.findViewById(R.id.tv_event_des);
            this.tv_event_time = (TextView) view.findViewById(R.id.tv_event_time);
            this.tv_feed_back = (TextView) view.findViewById(R.id.tv_feed_back);
        }

        public void bindView(int i) {
            AlarmVideo item = AlarmEventOperationListAdapter.this.getItem(i);
            this.tv_feed_back.setOnClickListener(new View.OnClickListener(item) {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.adapter.$$Lambda$AlarmEventOperationListAdapter$ItemViewHolder$aob7xcUwLOKJcV0uagwFnevVBz0 */
                private final /* synthetic */ AlarmVideo f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    AlarmEventOperationListAdapter.ItemViewHolder.this.lambda$bindView$0$AlarmEventOperationListAdapter$ItemViewHolder(this.f$1, view);
                }
            });
            setViews(item, Alarm2Utils.getEventName(item, Alarm2Utils.sortEventTypes(item.eventType)));
        }

        public /* synthetic */ void lambda$bindView$0$AlarmEventOperationListAdapter$ItemViewHolder(AlarmVideo alarmVideo, View view) {
            if (AlarmEventOperationListAdapter.this.mOnItemClickLister != null) {
                AlarmEventOperationListAdapter.this.mOnItemClickLister.onItemClick(view, alarmVideo, getAdapterPosition());
            }
        }

        private void setViews(AlarmVideo alarmVideo, String str) {
            if (alarmVideo != null && !TextUtils.isEmpty(alarmVideo.eventType)) {
                this.tv_event_time.setVisibility(8);
                this.iv_add_face.setVisibility(8);
                this.tv_event_des.setGravity(16);
                this.tv_event_des.setText(str);
                FaceInfoMeta faceInfoMeta = null;
                this.icon_face.setOnClickListener(null);
                this.iv_add_face.setOnClickListener(null);
                this.tv_event_des.setOnClickListener(null);
                this.tv_event_time.setOnClickListener(null);
                if (alarmVideo.eventType.equals("AI")) {
                    this.icon_face.setImageResource(R.drawable.icon_event_ai_new);
                } else if (alarmVideo.eventType.equals("BabyCry")) {
                    this.icon_face.setImageResource(R.drawable.icon_event_baby_cry_new);
                } else if (alarmVideo.eventType.equals("KnownFace") || alarmVideo.eventType.equals("Face")) {
                    if (alarmVideo.fileIdMetaResult != null) {
                        Iterator<FaceInfoMeta> it = alarmVideo.fileIdMetaResult.faceInfoMetas.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                FaceInfoMeta next = it.next();
                                if (next != null && !TextUtils.isEmpty(next.faceId)) {
                                    faceInfoMeta = next;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    if (faceInfoMeta != null) {
                        this.tv_event_des.setGravity(48);
                        String faceImg = FaceManager.getInstance(AlarmEventOperationListAdapter.this.mijiaCameraDevice).getFaceImg(faceInfoMeta.faceId);
                        if (cnx.O000000o().O00000Oo()) {
                            cnx.O000000o().O000000o(faceImg, this.icon_face);
                        }
                        if (faceInfoMeta.matched) {
                            this.tv_event_des.setText(str);
                            this.iv_add_face.setVisibility(8);
                            if (AlarmEventOperationListAdapter.this.mijiaCameraDevice.isOwner()) {
                                this.tv_event_time.setText((int) R.string.modify_notes);
                                this.tv_event_time.setVisibility(0);
                            } else {
                                this.tv_event_time.setVisibility(8);
                            }
                        } else {
                            if (AlarmEventOperationListAdapter.this.mijiaCameraDevice.isOwner()) {
                                this.tv_event_des.setText((int) R.string.add_notes);
                                this.iv_add_face.setVisibility(0);
                            } else {
                                this.tv_event_des.setText(str);
                                this.iv_add_face.setVisibility(8);
                            }
                            this.tv_event_time.setVisibility(8);
                        }
                        boolean z = faceInfoMeta.matched;
                        if (AlarmEventOperationListAdapter.this.mijiaCameraDevice.isOwner()) {
                            $$Lambda$AlarmEventOperationListAdapter$ItemViewHolder$E6FAUsZdwbmG1ygvLWgLZiaZB8 r0 = new View.OnClickListener(z, alarmVideo) {
                                /* class com.xiaomi.smarthome.camera.activity.alarm2.adapter.$$Lambda$AlarmEventOperationListAdapter$ItemViewHolder$E6FAUsZdwbmG1ygvLWgLZiaZB8 */
                                private final /* synthetic */ boolean f$1;
                                private final /* synthetic */ AlarmVideo f$2;

                                {
                                    this.f$1 = r2;
                                    this.f$2 = r3;
                                }

                                public final void onClick(View view) {
                                    AlarmEventOperationListAdapter.ItemViewHolder.this.lambda$setViews$1$AlarmEventOperationListAdapter$ItemViewHolder(this.f$1, this.f$2, view);
                                }
                            };
                            this.icon_face.setOnClickListener(r0);
                            this.iv_add_face.setOnClickListener(r0);
                            this.tv_event_des.setOnClickListener(r0);
                            this.tv_event_time.setOnClickListener(r0);
                            return;
                        }
                        return;
                    }
                    this.icon_face.setImageResource(R.drawable.icon_event_face_new);
                } else if (alarmVideo.eventType.equals("Pet")) {
                    this.icon_face.setImageResource(R.drawable.icon_event_pet_new);
                } else if (alarmVideo.eventType.equals("PeopleMotion")) {
                    this.icon_face.setImageResource(R.drawable.icon_event_people_motion_new);
                } else if (alarmVideo.eventType.equals("ObjectMotion")) {
                    this.icon_face.setImageResource(R.drawable.icon_event_motion_new);
                }
            }
        }

        public /* synthetic */ void lambda$setViews$1$AlarmEventOperationListAdapter$ItemViewHolder(boolean z, AlarmVideo alarmVideo, View view) {
            if (z) {
                alarmVideo.isKnownFace = true;
            } else {
                alarmVideo.isKnownFace = false;
            }
            AlarmEventOperationListAdapter.this.mOnItemClickLister.onItemClick(view, alarmVideo, getAdapterPosition());
        }
    }
}

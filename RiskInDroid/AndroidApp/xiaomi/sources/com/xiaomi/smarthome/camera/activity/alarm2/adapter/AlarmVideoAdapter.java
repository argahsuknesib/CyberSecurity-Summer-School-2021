package com.xiaomi.smarthome.camera.activity.alarm2.adapter;

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
import com.mijia.model.alarmcloud.FaceInfoMeta;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.xiaomi.smarthome.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class AlarmVideoAdapter extends RecyclerView.O000000o<ViewHolder> {
    final int ITEM_TYPE_LAST = 2;
    final int ITEM_TYPE_NORMAL = 1;
    private boolean isToTheEnd;
    private boolean isVip;
    public Context mContext;
    public List<AlarmVideo> mData;
    public ItemClickedListener mItemClickedListener;
    public SimpleDateFormat mSdf = new SimpleDateFormat("HH:mm", Locale.CHINA);

    public interface ItemClickedListener {
        void onItemClicked(AlarmVideo alarmVideo, int i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public AlarmVideoAdapter(Context context) {
        this.mContext = context;
        this.mData = new ArrayList();
        cnx.O000000o().O00000o0 = new coo() {
            /* class com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmVideoAdapter.AnonymousClass1 */

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
            view = LayoutInflater.from(this.mContext).inflate((int) R.layout.event_list_item_normal, (ViewGroup) null);
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
        if (i >= this.mData.size()) {
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
        private TextView eventDesc;
        private TextView eventTime;
        private ImageView[] imageViews;
        private ImageView ivCover;
        private ImageView ivRing;
        private ImageView ivRun;
        int type;
        private View vDividerLine;

        public ViewHolder(View view, int i) {
            super(view);
            this.type = i;
            if (i != 2) {
                this.ivCover = (ImageView) view.findViewById(R.id.crv_event_image);
                this.eventTime = (TextView) view.findViewById(R.id.tv_event_time);
                this.eventDesc = (TextView) view.findViewById(R.id.tv_event_des);
                this.ivRun = (ImageView) view.findViewById(R.id.iv_event_type_pepole);
                this.ivRing = (ImageView) view.findViewById(R.id.iv_event_type_ring);
                this.vDividerLine = view.findViewById(R.id.v_divider_line);
                this.imageViews = new ImageView[]{this.ivRing, this.ivRun};
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:55:0x024f  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x0323  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x035f  */
        public void bindView(final int i) {
            int i2;
            boolean z;
            int i3;
            String sb;
            String string;
            if (this.type != 2) {
                AlarmVideo alarmVideo = AlarmVideoAdapter.this.mData.get(i);
                this.itemView.findViewById(R.id.rl_right_function).setBackgroundResource(alarmVideo.isPlaying ? R.drawable.alarm_item_select_bg : Color.parseColor("#00000000"));
                if (cnx.O000000o().O00000Oo()) {
                    cnx.O000000o().O000000o(alarmVideo.imgStoreUrl, this.ivCover);
                }
                this.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmVideoAdapter.ViewHolder.AnonymousClass1 */

                    public void onClick(View view) {
                        if (AlarmVideoAdapter.this.mItemClickedListener != null) {
                            AlarmVideoAdapter.this.mItemClickedListener.onItemClicked(AlarmVideoAdapter.this.mData.get(i), i);
                        }
                    }
                });
                if (alarmVideo.isRead) {
                    this.eventTime.setTextColor(Color.parseColor("#999999"));
                    this.eventDesc.setTextColor(Color.parseColor("#999999"));
                } else {
                    this.eventTime.setTextColor(AlarmVideoAdapter.this.mContext.getResources().getColor(R.color.mj_color_black));
                    this.eventDesc.setTextColor(AlarmVideoAdapter.this.mContext.getResources().getColor(R.color.mj_color_black));
                }
                this.eventTime.setText(AlarmVideoAdapter.this.mSdf.format(Long.valueOf(alarmVideo.createTime)));
                String str = alarmVideo.eventType;
                String str2 = "";
                if (TextUtils.isEmpty(str)) {
                    this.eventDesc.setText(str2);
                    return;
                }
                this.imageViews[0].setVisibility(8);
                this.imageViews[1].setVisibility(8);
                String[] split = str.split(":");
                AlarmVideoAdapter.sortByEventType(split);
                if (split.length > 2) {
                    Arrays.copyOfRange(split, 0, 2);
                }
                StringBuilder sb2 = new StringBuilder();
                this.vDividerLine.setVisibility(8);
                if (str.contains("BabyCry")) {
                    sb2.append(AlarmVideoAdapter.this.mContext.getResources().getString(R.string.baby_cry_desc));
                    sb2.append(AlarmVideoAdapter.this.mContext.getResources().getString(R.string.and));
                    this.imageViews[1].setVisibility(0);
                    this.imageViews[1].setImageResource(R.drawable.icon_event_type_baby_cry);
                    this.vDividerLine.setVisibility(0);
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (str.contains("Face")) {
                    i2++;
                    if (alarmVideo.fileIdMetaResult == null || alarmVideo.fileIdMetaResult.faceInfoMetas == null || alarmVideo.fileIdMetaResult.faceInfoMetas.size() == 0) {
                        this.imageViews[1].setVisibility(0);
                        this.imageViews[1].setImageResource(R.drawable.icon_event_type_unknow_people);
                        this.vDividerLine.setVisibility(0);
                        sb2.append(AlarmVideoAdapter.this.mContext.getResources().getString(R.string.unknown_people_desc));
                        sb2.append(AlarmVideoAdapter.this.mContext.getResources().getString(R.string.and));
                    } else {
                        Iterator<FaceInfoMeta> it = alarmVideo.fileIdMetaResult.faceInfoMetas.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                FaceInfoMeta next = it.next();
                                if (next != null && next.matched) {
                                    str2 = next.figureName;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (TextUtils.isEmpty(str2)) {
                            this.imageViews[1].setVisibility(0);
                            this.imageViews[1].setImageResource(R.drawable.icon_event_type_unknow_people);
                            sb2.append(AlarmVideoAdapter.this.mContext.getResources().getString(R.string.unknown_people_desc));
                            sb2.append(AlarmVideoAdapter.this.mContext.getResources().getString(R.string.and));
                            this.vDividerLine.setVisibility(0);
                        } else {
                            sb2.append(String.format(AlarmVideoAdapter.this.mContext.getResources().getString(R.string.known_people_desc), str2));
                            sb2.append(AlarmVideoAdapter.this.mContext.getResources().getString(R.string.and));
                            this.imageViews[1].setVisibility(0);
                            this.imageViews[1].setImageResource(R.drawable.icon_event_type_known_people);
                            this.vDividerLine.setVisibility(0);
                        }
                    }
                }
                if (str.contains("Pet")) {
                    i3 = i2 + 1;
                    if (i2 < 2) {
                        sb2.append(AlarmVideoAdapter.this.mContext.getResources().getString(R.string.event_type_pet));
                        sb2.append(AlarmVideoAdapter.this.mContext.getResources().getString(R.string.and));
                        this.vDividerLine.setVisibility(0);
                        this.imageViews[0].setVisibility(8);
                        this.imageViews[1].setVisibility(8);
                        z = true;
                        if (!str.contains("Face")) {
                            if (str.contains("PeopleMotion")) {
                                int i4 = i3 + 1;
                                if (i3 < 2) {
                                    sb2.append(AlarmVideoAdapter.this.mContext.getResources().getString(R.string.event_type_people_motion));
                                    sb2.append(AlarmVideoAdapter.this.mContext.getResources().getString(R.string.and));
                                    this.imageViews[1].setVisibility(0);
                                    this.imageViews[1].setImageResource(R.drawable.icon_event_type_people_run);
                                    this.vDividerLine.setVisibility(0);
                                }
                                i3 = i4;
                            }
                            if (!z && !str.contains("PeopleMotion") && str.contains("ObjectMotion")) {
                                int i5 = i3 + 1;
                                if (i3 < 2 && TextUtils.isEmpty(sb2)) {
                                    sb2.append(AlarmVideoAdapter.this.mContext.getResources().getString(R.string.event_type_obj_motion));
                                    sb2.append(AlarmVideoAdapter.this.mContext.getResources().getString(R.string.and));
                                    this.imageViews[0].setVisibility(8);
                                    this.imageViews[1].setVisibility(8);
                                }
                                i3 = i5;
                            }
                        }
                        if (str.contains("AI") && i3 < 2) {
                            sb2.delete(0, sb2.length());
                            sb2.append(AlarmVideoAdapter.this.mContext.getResources().getString(R.string.ai_scene_desc));
                            sb2.append(AlarmVideoAdapter.this.mContext.getResources().getString(R.string.and));
                            this.imageViews[0].setVisibility(8);
                            this.imageViews[1].setVisibility(8);
                        }
                        if (TextUtils.isEmpty(sb2)) {
                            sb2.append(this.type);
                            sb2.append(AlarmVideoAdapter.this.mContext.getResources().getString(R.string.and));
                            this.imageViews[0].setVisibility(8);
                            this.imageViews[1].setVisibility(8);
                        }
                        sb = sb2.toString();
                        string = AlarmVideoAdapter.this.mContext.getResources().getString(R.string.and);
                        if (sb.length() > string.length()) {
                            sb2.replace(sb.length() - string.length(), sb2.length(), "!");
                        }
                        this.eventDesc.setText(sb2.toString());
                    }
                } else {
                    i3 = i2;
                }
                z = false;
                if (!str.contains("Face")) {
                }
                sb2.delete(0, sb2.length());
                sb2.append(AlarmVideoAdapter.this.mContext.getResources().getString(R.string.ai_scene_desc));
                sb2.append(AlarmVideoAdapter.this.mContext.getResources().getString(R.string.and));
                this.imageViews[0].setVisibility(8);
                this.imageViews[1].setVisibility(8);
                if (TextUtils.isEmpty(sb2)) {
                }
                sb = sb2.toString();
                string = AlarmVideoAdapter.this.mContext.getResources().getString(R.string.and);
                if (sb.length() > string.length()) {
                }
                this.eventDesc.setText(sb2.toString());
            }
        }
    }

    public static void sortByEventType(String[] strArr) {
        if (strArr != null && strArr.length > 1) {
            Arrays.sort(strArr, new Comparator<String>() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmVideoAdapter.AnonymousClass2 */

                public final int compare(String str, String str2) {
                    return AlarmVideoAdapter.getIntByType(str) - AlarmVideoAdapter.getIntByType(str2);
                }
            });
        }
    }

    public static int getIntByType(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1293551627:
                if (str.equals("ObjectMotion")) {
                    c = 4;
                    break;
                }
                break;
            case -740191200:
                if (str.equals("KnownFace")) {
                    c = 1;
                    break;
                }
                break;
            case 2088:
                if (str.equals("AI")) {
                    c = 6;
                    break;
                }
                break;
            case 80127:
                if (str.equals("Pet")) {
                    c = 5;
                    break;
                }
                break;
            case 2181757:
                if (str.equals("Face")) {
                    c = 2;
                    break;
                }
                break;
            case 722651973:
                if (str.equals("PeopleMotion")) {
                    c = 3;
                    break;
                }
                break;
            case 1316906260:
                if (str.equals("BabyCry")) {
                    c = 0;
                    break;
                }
                break;
        }
        if (c == 0) {
            return 1;
        }
        if (c == 1) {
            return 2;
        }
        if (c == 2) {
            return 3;
        }
        if (c == 3) {
            return 4;
        }
        if (c != 4) {
            return c != 5 ? 8 : 6;
        }
        return 5;
    }

    public static void sortByEventTypeForTimeLine(String[] strArr) {
        if (strArr != null && strArr.length > 1) {
            Arrays.sort(strArr, new Comparator<String>() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmVideoAdapter.AnonymousClass3 */

                public final int compare(String str, String str2) {
                    return AlarmVideoAdapter.getIntByTypeForTimeLine(str2) - AlarmVideoAdapter.getIntByTypeForTimeLine(str);
                }
            });
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0059, code lost:
        if (r9.equals("ObjectMotion") != false) goto L_0x005d;
     */
    public static int getIntByTypeForTimeLine(String str) {
        char c = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        switch (str.hashCode()) {
            case -1293551627:
                break;
            case -740191200:
                if (str.equals("KnownFace")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 2088:
                if (str.equals("AI")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 80127:
                if (str.equals("Pet")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 2181757:
                if (str.equals("Face")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 722651973:
                if (str.equals("PeopleMotion")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1316906260:
                if (str.equals("BabyCry")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            default:
                return -1;
        }
    }
}

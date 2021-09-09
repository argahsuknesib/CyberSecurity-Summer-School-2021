package com.xiaomi.smarthome.camera.activity.alarm2.adapter;

import android.content.Context;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class AlarmEventListAdapter extends RecyclerView.O000000o<ItemViewHolder> {
    public int currentOffset;
    public boolean isShareUser;
    public Context mContext;
    public List<AlarmVideo> mData;
    public String mFaceName;
    public OnItemClickLister mOnItemClickLister;
    public SimpleDateFormat mSdf = new SimpleDateFormat("HH:mm:ss", Locale.CHINA);

    public interface OnItemClickLister {
        void onBtnClick(AlarmVideo alarmVideo, int i, boolean z);

        void onItemClick(AlarmVideo alarmVideo, int i);

        void smoothScrollToPosition(int i);
    }

    public AlarmEventListAdapter(Context context) {
        this.mContext = context;
        this.mData = new ArrayList();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ItemViewHolder(LayoutInflater.from(this.mContext).inflate((int) R.layout.recycler_item_alarm_player_event, viewGroup, false));
    }

    public void setData(List<AlarmVideo> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    public void setFaceName(String str) {
        this.mFaceName = str;
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
                        onItemClickLister.smoothScrollToPosition(i2);
                    }
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
        private final View dividerLine;
        private final View dividerLineFull;
        private ImageView ivPlayIcon;
        public TextView tvButton;
        private TextView tvEventName;
        private TextView tvTime;

        public ItemViewHolder(View view) {
            super(view);
            this.tvTime = (TextView) view.findViewById(R.id.tv_time);
            this.tvEventName = (TextView) view.findViewById(R.id.tv_event);
            this.tvButton = (TextView) view.findViewById(R.id.tv_btn);
            this.ivPlayIcon = (ImageView) view.findViewById(R.id.iv_play);
            this.dividerLine = view.findViewById(R.id.divider_line);
            this.dividerLineFull = view.findViewById(R.id.divider_line_full);
        }

        /* JADX WARNING: Removed duplicated region for block: B:49:0x01fb  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0227  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x02a2  */
        public void bindView(final int i) {
            int i2;
            boolean z;
            int i3;
            String sb;
            String string;
            boolean z2 = true;
            if (i == AlarmEventListAdapter.this.getItemCount() - 1) {
                this.dividerLineFull.setVisibility(0);
                this.dividerLine.setVisibility(8);
            } else {
                this.dividerLineFull.setVisibility(8);
                this.dividerLine.setVisibility(0);
            }
            final AlarmVideo item = AlarmEventListAdapter.this.getItem(i);
            this.tvTime.setText(AlarmEventListAdapter.this.mSdf.format(Long.valueOf(item.createTime)));
            if (AlarmEventListAdapter.this.currentOffset == item.offset) {
                this.ivPlayIcon.setVisibility(0);
                this.tvTime.setTextColor(AlarmEventListAdapter.this.mContext.getResources().getColor(R.color.mj_color_green_normal));
                this.tvEventName.setTextColor(AlarmEventListAdapter.this.mContext.getResources().getColor(R.color.mj_color_green_normal));
            } else {
                this.ivPlayIcon.setVisibility(4);
                this.tvTime.setTextColor(AlarmEventListAdapter.this.mContext.getResources().getColor(R.color.mj_color_black_50_transparent));
                this.tvEventName.setTextColor(AlarmEventListAdapter.this.mContext.getResources().getColor(R.color.mj_color_black));
            }
            String str = item.eventType;
            String str2 = "";
            if (TextUtils.isEmpty(str)) {
                this.tvEventName.setText(str2);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            if (str.contains("BabyCry")) {
                sb2.append(AlarmEventListAdapter.this.mContext.getResources().getString(R.string.baby_cry_desc));
                sb2.append(AlarmEventListAdapter.this.mContext.getResources().getString(R.string.and));
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (str.contains("Face")) {
                i2++;
                if (item.fileIdMetaResult == null || item.fileIdMetaResult.faceInfoMetas == null || item.fileIdMetaResult.faceInfoMetas.size() == 0) {
                    sb2.append(AlarmEventListAdapter.this.mContext.getResources().getString(R.string.unknown_people_desc));
                    sb2.append(AlarmEventListAdapter.this.mContext.getResources().getString(R.string.and));
                } else {
                    Iterator<FaceInfoMeta> it = item.fileIdMetaResult.faceInfoMetas.iterator();
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
                    if (!TextUtils.isEmpty(str2)) {
                        sb2.append(String.format(AlarmEventListAdapter.this.mContext.getResources().getString(R.string.known_people_desc), str2));
                        sb2.append(AlarmEventListAdapter.this.mContext.getResources().getString(R.string.and));
                    } else if (!TextUtils.isEmpty(AlarmEventListAdapter.this.mFaceName)) {
                        sb2.append(String.format(AlarmEventListAdapter.this.mContext.getResources().getString(R.string.known_people_desc), AlarmEventListAdapter.this.mFaceName));
                        sb2.append(AlarmEventListAdapter.this.mContext.getResources().getString(R.string.and));
                    } else {
                        sb2.append(AlarmEventListAdapter.this.mContext.getResources().getString(R.string.unknown_people_desc));
                        sb2.append(AlarmEventListAdapter.this.mContext.getResources().getString(R.string.and));
                    }
                }
            }
            if (str.contains("Pet")) {
                i3 = i2 + 1;
                if (i2 < 2) {
                    sb2.append(AlarmEventListAdapter.this.mContext.getResources().getString(R.string.event_type_pet));
                    sb2.append(AlarmEventListAdapter.this.mContext.getResources().getString(R.string.and));
                    z = true;
                    if (str.contains("AI")) {
                        int i4 = i3 + 1;
                        if (i3 < 2) {
                            sb2.append(AlarmEventListAdapter.this.mContext.getResources().getString(R.string.ai_scene_desc));
                            sb2.append(AlarmEventListAdapter.this.mContext.getResources().getString(R.string.and));
                        }
                        i3 = i4;
                    }
                    if (!str.contains("Face")) {
                        if (str.contains("PeopleMotion")) {
                            int i5 = i3 + 1;
                            if (i3 < 2) {
                                sb2.append(AlarmEventListAdapter.this.mContext.getResources().getString(R.string.event_type_people_motion));
                                sb2.append(AlarmEventListAdapter.this.mContext.getResources().getString(R.string.and));
                            }
                            i3 = i5;
                        }
                        if (!z && !str.contains("PeopleMotion") && str.contains("ObjectMotion") && i3 < 2) {
                            sb2.append(AlarmEventListAdapter.this.mContext.getResources().getString(R.string.event_type_obj_motion));
                            sb2.append(AlarmEventListAdapter.this.mContext.getResources().getString(R.string.and));
                        }
                    }
                    sb = sb2.toString();
                    string = AlarmEventListAdapter.this.mContext.getResources().getString(R.string.and);
                    if (sb.length() > string.length()) {
                        sb2.replace(sb.length() - string.length(), sb2.length(), "!");
                    }
                    this.tvEventName.setText(sb2.toString());
                    if (item.fileIdMetaResult != null || AlarmEventListAdapter.this.isShareUser) {
                        this.tvButton.setVisibility(8);
                    } else {
                        Iterator<FaceInfoMeta> it2 = item.fileIdMetaResult.faceInfoMetas.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z2 = false;
                                break;
                            }
                            FaceInfoMeta next2 = it2.next();
                            if (next2 != null && next2.matched) {
                                break;
                            }
                        }
                        this.tvButton.setVisibility(0);
                        if (z2 || !TextUtils.isEmpty(AlarmEventListAdapter.this.mFaceName)) {
                            this.tvButton.setText((int) R.string.modify_notes);
                        } else {
                            this.tvButton.setText((int) R.string.add_notes);
                        }
                    }
                    this.tvButton.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmEventListAdapter.ItemViewHolder.AnonymousClass1 */

                        public void onClick(View view) {
                            if (AlarmEventListAdapter.this.mOnItemClickLister != null) {
                                AlarmEventListAdapter.this.mOnItemClickLister.onBtnClick(AlarmEventListAdapter.this.mData.get(i), i, ItemViewHolder.this.tvButton.getText().equals(AlarmEventListAdapter.this.mContext.getResources().getString(R.string.add_notes)));
                            }
                        }
                    });
                    this.itemView.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmEventListAdapter.ItemViewHolder.AnonymousClass2 */

                        public void onClick(View view) {
                            AlarmEventListAdapter.this.currentOffset = item.offset;
                            AlarmEventListAdapter.this.notifyDataSetChanged();
                            if (AlarmEventListAdapter.this.mOnItemClickLister != null) {
                                AlarmEventListAdapter.this.mOnItemClickLister.onItemClick(AlarmEventListAdapter.this.mData.get(i), i);
                            }
                        }
                    });
                }
            } else {
                i3 = i2;
            }
            z = false;
            if (str.contains("AI")) {
            }
            if (!str.contains("Face")) {
            }
            sb = sb2.toString();
            string = AlarmEventListAdapter.this.mContext.getResources().getString(R.string.and);
            if (sb.length() > string.length()) {
            }
            this.tvEventName.setText(sb2.toString());
            if (item.fileIdMetaResult != null) {
            }
            this.tvButton.setVisibility(8);
            this.tvButton.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmEventListAdapter.ItemViewHolder.AnonymousClass1 */

                public void onClick(View view) {
                    if (AlarmEventListAdapter.this.mOnItemClickLister != null) {
                        AlarmEventListAdapter.this.mOnItemClickLister.onBtnClick(AlarmEventListAdapter.this.mData.get(i), i, ItemViewHolder.this.tvButton.getText().equals(AlarmEventListAdapter.this.mContext.getResources().getString(R.string.add_notes)));
                    }
                }
            });
            this.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmEventListAdapter.ItemViewHolder.AnonymousClass2 */

                public void onClick(View view) {
                    AlarmEventListAdapter.this.currentOffset = item.offset;
                    AlarmEventListAdapter.this.notifyDataSetChanged();
                    if (AlarmEventListAdapter.this.mOnItemClickLister != null) {
                        AlarmEventListAdapter.this.mOnItemClickLister.onItemClick(AlarmEventListAdapter.this.mData.get(i), i);
                    }
                }
            });
        }
    }

    private void smoothScrollToPosition(int i) {
        OnItemClickLister onItemClickLister = this.mOnItemClickLister;
        if (onItemClickLister != null) {
            onItemClickLister.smoothScrollToPosition(i);
        }
    }

    private void sortByEventType(String[] strArr) {
        if (strArr != null && strArr.length > 1) {
            Arrays.sort(strArr, new Comparator<String>() {
                /* class com.xiaomi.smarthome.camera.activity.alarm2.adapter.AlarmEventListAdapter.AnonymousClass1 */

                public int compare(String str, String str2) {
                    return AlarmEventListAdapter.this.getIntByType(str) - AlarmEventListAdapter.this.getIntByType(str2);
                }
            });
        }
    }

    public int getIntByType(String str) {
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
}

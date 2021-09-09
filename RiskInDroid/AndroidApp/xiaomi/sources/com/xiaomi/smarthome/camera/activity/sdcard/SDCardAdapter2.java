package com.xiaomi.smarthome.camera.activity.sdcard;

import _m_j.cki;
import _m_j.clq;
import _m_j.clu;
import _m_j.clv;
import _m_j.cnw;
import _m_j.cnx;
import _m_j.gpc;
import _m_j.gsy;
import _m_j.hyy;
import android.app.Activity;
import android.graphics.Bitmap;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mijia.model.sdcard.TimeItem;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class SDCardAdapter2 extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    private static final String TAG = "SDCardAdapter2";
    private Activity activity;
    public boolean editMode = false;
    private boolean hideIcon = false;
    public int itemWidth;
    private String mDid;
    private cnw mOptions;
    public OnItemClickListener onItemClickListener;
    SparseIntArray positionMap = new SparseIntArray();
    List<clv> selectedItems = new ArrayList();
    List<TimeItem> selectedSubItems = new ArrayList();
    clu timeItemDay;
    List<clv> timeItemHourList = new ArrayList();

    public interface OnItemClickListener {
        void onItemClick(int i, int i2);

        void onItemLongClick();

        void onSelectChanged();
    }

    public SDCardAdapter2(RecyclerView recyclerView, Activity activity2, String str, OnItemClickListener onItemClickListener2) {
        this.activity = activity2;
        this.mDid = str;
        this.onItemClickListener = onItemClickListener2;
        String str2 = TAG;
        gsy.O00000Oo(str2, "recyclerView.getPadding=" + recyclerView.getPaddingLeft() + "--" + recyclerView.getPaddingRight());
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        gsy.O00000Oo(TAG, "gridLayoutManager=".concat(String.valueOf(gridLayoutManager)));
        int i = 3;
        if (hyy.O000000o()) {
            this.itemWidth = ((hyy.O00000Oo(activity2.getIntent()).widthPixels - recyclerView.getPaddingLeft()) - recyclerView.getPaddingRight()) / (gridLayoutManager != null ? gridLayoutManager.getSpanCount() : i);
        } else {
            this.itemWidth = ((gpc.O00000Oo(activity2) - recyclerView.getPaddingLeft()) - recyclerView.getPaddingRight()) / (gridLayoutManager != null ? gridLayoutManager.getSpanCount() : i);
        }
        cnw.O000000o o000000o = new cnw.O000000o();
        o000000o.O00000o = activity2.getResources().getDrawable(R.drawable.camera_v4_remind_load_fail);
        o000000o.O00000oO = activity2.getResources().getDrawable(R.drawable.camera_v4_remind_load_fail);
        o000000o.O00000oo = activity2.getResources().getDrawable(R.drawable.camera_v4_remind_load_fail);
        o000000o.O0000OOo = true;
        o000000o.O0000Oo0 = true;
        o000000o.O0000o00 = true;
        cnw.O000000o O000000o2 = o000000o.O000000o(Bitmap.Config.RGB_565);
        O000000o2.O0000Oo = ImageScaleType.EXACTLY_STRETCHED;
        this.mOptions = O000000o2.O000000o();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(this.activity).inflate((int) R.layout.camera_sdcard_file_item2, viewGroup, false));
    }

    public void setHideIcon(boolean z) {
        this.hideIcon = z;
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        MyViewHolder myViewHolder = (MyViewHolder) o000OOo0;
        clv clv = this.timeItemHourList.get(i);
        myViewHolder.people_move_icon.setVisibility(8);
        myViewHolder.baby_cry_icon.setVisibility(8);
        ImageView[] imageViewArr = {myViewHolder.people_move_icon, myViewHolder.baby_cry_icon};
        if (!this.hideIcon) {
            try {
                int[] iArr = {0, 0};
                for (TimeItem timeItem : clv.O00000o0) {
                    int O000000o2 = clq.O000000o(timeItem.f5243O000000o);
                    if (O000000o2 > iArr[0]) {
                        iArr[1] = iArr[0];
                        iArr[0] = O000000o2;
                    } else if (O000000o2 > iArr[1] && O000000o2 != iArr[0]) {
                        iArr[1] = O000000o2;
                    }
                }
                for (int i2 = 0; i2 < 2; i2++) {
                    int i3 = iArr[i2];
                    if (i3 == 1) {
                        imageViewArr[i2].setVisibility(0);
                        imageViewArr[i2].setImageResource(R.drawable.icon_event_type_people_run);
                    } else if (i3 == 2 || i3 == 3) {
                        imageViewArr[i2].setVisibility(0);
                        imageViewArr[i2].setImageResource(R.drawable.icon_event_type_pet);
                    } else if (i3 == 4) {
                        imageViewArr[i2].setVisibility(0);
                        imageViewArr[i2].setImageResource(R.drawable.icon_event_type_unknow_people);
                    } else if (i3 == 5) {
                        imageViewArr[i2].setVisibility(0);
                        imageViewArr[i2].setImageResource(R.drawable.icon_event_type_known_people);
                    } else if (i3 == 7) {
                        imageViewArr[i2].setVisibility(0);
                        imageViewArr[i2].setImageResource(R.drawable.icon_event_type_baby_cry);
                    }
                }
            } catch (Exception e) {
                cki.O00000oO(TAG, e.toString());
            }
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = clv.f14114O000000o > 9 ? new StringBuilder() : new StringBuilder("0");
        sb2.append(clv.f14114O000000o);
        sb.append(sb2.toString());
        sb.append(":00");
        myViewHolder.tv_hour_time.setText(sb.toString());
        if (clv.O00000o0 != null && clv.O00000o0.size() > 0) {
            String O000000o3 = clv.O00000o0.get(0).O000000o(this.mDid);
            myViewHolder.iv_sdcard_video.setTag(O000000o3);
            if (cnx.O000000o().O00000Oo()) {
                cnx.O000000o().O000000o(O000000o3, myViewHolder.iv_sdcard_video, this.mOptions);
            }
        }
        if (this.editMode) {
            myViewHolder.checkbox.setVisibility(0);
            if (clv.O00000Oo) {
                myViewHolder.checkbox.setImageResource(R.drawable.camera_delete_checked);
            } else {
                myViewHolder.checkbox.setImageResource(R.drawable.camera_delete_unchecked);
            }
        } else {
            myViewHolder.checkbox.setVisibility(4);
        }
    }

    public void setMultiSelectMode(boolean z) {
        this.editMode = z;
        if (!z) {
            selectAll(false);
        }
        notifyDataSetChanged();
        OnItemClickListener onItemClickListener2 = this.onItemClickListener;
        if (onItemClickListener2 != null) {
            onItemClickListener2.onSelectChanged();
        }
    }

    public void selectAll(boolean z) {
        for (clv clv : this.timeItemHourList) {
            clv.O00000Oo = z;
        }
        this.selectedItems.clear();
        if (z) {
            this.selectedItems.addAll(this.timeItemHourList);
        }
        notifyDataSetChanged();
    }

    public int getSelectCount() {
        return this.selectedItems.size();
    }

    public List<TimeItem> getSelectSubItems() {
        this.selectedSubItems.clear();
        for (clv clv : this.selectedItems) {
            this.selectedSubItems.addAll(clv.O00000o0);
        }
        return this.selectedSubItems;
    }

    public int getItemCount() {
        return this.timeItemHourList.size();
    }

    public void update(clu clu) {
        gsy.O00000Oo(TAG, "update=".concat(String.valueOf(clu)));
        this.timeItemDay = clu;
        this.timeItemHourList.clear();
        if (!(clu == null || clu.O0000O0o == null)) {
            int i = 0;
            for (int size = clu.O0000O0o.size() - 1; size >= 0; size--) {
                clv clv = clu.O0000O0o.get(size);
                if (!(clv == null || clv.O00000o0 == null || clv.O00000o0.size() <= 0)) {
                    this.positionMap.put(i, size);
                    this.timeItemHourList.add(clv);
                    i++;
                }
            }
        }
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.O000OOo0 {
        ImageView baby_cry_icon;
        ImageView checkbox;
        ImageView iv_sdcard_video;
        ImageView people_move_icon;
        TextView tv_hour_time;

        public MyViewHolder(View view) {
            super(view);
            this.iv_sdcard_video = (ImageView) view.findViewById(R.id.iv_sdcard_video);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iv_sdcard_video.getLayoutParams();
            layoutParams.width = (SDCardAdapter2.this.itemWidth - view.getPaddingLeft()) - view.getPaddingRight();
            double d = (double) layoutParams.width;
            Double.isNaN(d);
            layoutParams.height = (int) (d * 0.6d);
            this.iv_sdcard_video.setLayoutParams(layoutParams);
            this.checkbox = (ImageView) view.findViewById(R.id.checkbox);
            this.tv_hour_time = (TextView) view.findViewById(R.id.tv_hour_time);
            this.people_move_icon = (ImageView) view.findViewById(R.id.people_move_icon);
            this.baby_cry_icon = (ImageView) view.findViewById(R.id.baby_cry_icon);
            view.setOnClickListener(new View.OnClickListener(SDCardAdapter2.this) {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardAdapter2.MyViewHolder.AnonymousClass1 */

                public void onClick(View view) {
                    if (SDCardAdapter2.this.editMode) {
                        clv clv = SDCardAdapter2.this.timeItemHourList.get(MyViewHolder.this.getAdapterPosition());
                        clv.O00000Oo = !clv.O00000Oo;
                        if (clv.O00000Oo) {
                            SDCardAdapter2.this.selectedItems.add(clv);
                        } else {
                            SDCardAdapter2.this.selectedItems.remove(clv);
                        }
                        SDCardAdapter2.this.notifyItemChanged(MyViewHolder.this.getAdapterPosition());
                        if (SDCardAdapter2.this.onItemClickListener != null) {
                            SDCardAdapter2.this.onItemClickListener.onSelectChanged();
                        }
                    } else if (SDCardAdapter2.this.onItemClickListener != null) {
                        SDCardAdapter2.this.onItemClickListener.onItemClick(SDCardAdapter2.this.positionMap.get(MyViewHolder.this.getAdapterPosition()), SDCardAdapter2.this.timeItemHourList.get(MyViewHolder.this.getAdapterPosition()).f14114O000000o);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener(SDCardAdapter2.this) {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardAdapter2.MyViewHolder.AnonymousClass2 */

                public boolean onLongClick(View view) {
                    if (SDCardAdapter2.this.onItemClickListener == null) {
                        return false;
                    }
                    clv clv = SDCardAdapter2.this.timeItemHourList.get(MyViewHolder.this.getAdapterPosition());
                    clv.O00000Oo = true;
                    SDCardAdapter2.this.selectedItems.add(clv);
                    SDCardAdapter2.this.onItemClickListener.onItemLongClick();
                    return false;
                }
            });
        }
    }
}

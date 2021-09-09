package com.xiaomi.smarthome.camera.activity.sdcard;

import _m_j.cki;
import _m_j.cnw;
import _m_j.cnx;
import _m_j.gpc;
import _m_j.hyy;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
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
import com.xiaomi.smarthome.camera.view.recycle.RecyclerClickListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SDCardHourAdapter extends RecyclerView.O000000o<SDCardHourViewHolder> {
    public static final String TAG = "SDCardHourAdapter";
    public boolean isV4;
    public int itemWidth;
    public Activity mContext;
    public List<TimeItemData> mData = new ArrayList();
    String mDid = "";
    public boolean mIsMultiSelectMode;
    public RecyclerClickListener mListener;
    public cnw mOptions;
    boolean[] mSelectMap;
    public int selectedPos = -1;

    public SDCardHourAdapter(RecyclerView recyclerView, Activity activity, RecyclerClickListener recyclerClickListener, String str, boolean z) {
        this.isV4 = z;
        this.mListener = recyclerClickListener;
        this.mContext = activity;
        this.mDid = str;
        initImageDisplayOptions(activity);
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        int i = 3;
        if (hyy.O000000o()) {
            this.itemWidth = ((hyy.O00000Oo(activity.getIntent()).widthPixels - recyclerView.getPaddingLeft()) - recyclerView.getPaddingRight()) / (gridLayoutManager != null ? gridLayoutManager.getSpanCount() : i);
            String str2 = TAG;
            cki.O00000o(str2, "isPad=" + this.itemWidth);
            return;
        }
        this.itemWidth = ((gpc.O00000Oo(activity) - recyclerView.getPaddingLeft()) - recyclerView.getPaddingRight()) / (gridLayoutManager != null ? gridLayoutManager.getSpanCount() : i);
        String str3 = TAG;
        cki.O00000o(str3, "notPad=" + this.itemWidth);
    }

    public void destroyDisplayImageOptions() {
        this.mOptions = null;
        this.mListener = null;
    }

    private void initImageDisplayOptions(Context context) {
        cnw.O000000o o000000o = new cnw.O000000o();
        if (this.isV4) {
            o000000o.O00000o = context.getResources().getDrawable(R.drawable.camera_v4_remind_load_fail);
            o000000o.O00000oO = context.getResources().getDrawable(R.drawable.camera_v4_remind_load_fail);
            o000000o.O00000oo = context.getResources().getDrawable(R.drawable.camera_v4_remind_load_fail);
        } else {
            o000000o.O00000o = context.getResources().getDrawable(R.drawable.camera_remind_load_fail);
            o000000o.O00000oO = context.getResources().getDrawable(R.drawable.camera_remind_load_fail);
            o000000o.O00000oo = context.getResources().getDrawable(R.drawable.camera_remind_load_fail);
        }
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
    public SDCardHourViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new SDCardHourViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.camera_sdcard_hour_item, viewGroup, false));
    }

    public void onBindViewHolder(SDCardHourViewHolder sDCardHourViewHolder, int i) {
        sDCardHourViewHolder.bindView(i);
    }

    public void setData(List<TimeItemData> list) {
        this.mData = list;
        this.mSelectMap = new boolean[this.mData.size()];
    }

    public void setSelected(int i) {
        if (i < 0 || i >= this.mData.size()) {
            this.selectedPos = -1;
        } else {
            this.selectedPos = i;
        }
    }

    public TimeItemData getData(int i) {
        if (i < 0 || i > this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
    }

    public int getItemCount() {
        return this.mData.size();
    }

    public void setSelectMode(boolean z) {
        if (this.mIsMultiSelectMode != z) {
            if (!z) {
                unSelectAll();
            }
            this.mIsMultiSelectMode = z;
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Arrays.fill(boolean[], boolean):void}
     arg types: [boolean[], int]
     candidates:
      ClspMth{java.util.Arrays.fill(double[], double):void}
      ClspMth{java.util.Arrays.fill(byte[], byte):void}
      ClspMth{java.util.Arrays.fill(long[], long):void}
      ClspMth{java.util.Arrays.fill(char[], char):void}
      ClspMth{java.util.Arrays.fill(short[], short):void}
      ClspMth{java.util.Arrays.fill(java.lang.Object[], java.lang.Object):void}
      ClspMth{java.util.Arrays.fill(int[], int):void}
      ClspMth{java.util.Arrays.fill(float[], float):void}
      ClspMth{java.util.Arrays.fill(boolean[], boolean):void} */
    public void selectAll() {
        boolean[] zArr = this.mSelectMap;
        if (zArr != null) {
            Arrays.fill(zArr, true);
        }
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Arrays.fill(boolean[], boolean):void}
     arg types: [boolean[], int]
     candidates:
      ClspMth{java.util.Arrays.fill(double[], double):void}
      ClspMth{java.util.Arrays.fill(byte[], byte):void}
      ClspMth{java.util.Arrays.fill(long[], long):void}
      ClspMth{java.util.Arrays.fill(char[], char):void}
      ClspMth{java.util.Arrays.fill(short[], short):void}
      ClspMth{java.util.Arrays.fill(java.lang.Object[], java.lang.Object):void}
      ClspMth{java.util.Arrays.fill(int[], int):void}
      ClspMth{java.util.Arrays.fill(float[], float):void}
      ClspMth{java.util.Arrays.fill(boolean[], boolean):void} */
    public void unSelectAll() {
        boolean[] zArr = this.mSelectMap;
        if (zArr != null) {
            Arrays.fill(zArr, false);
        }
        notifyDataSetChanged();
    }

    public int getSelectCount() {
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean[] zArr = this.mSelectMap;
            if (i >= zArr.length) {
                return i2;
            }
            if (zArr[i]) {
                i2++;
            }
            i++;
        }
    }

    public void selectToggle(int i) {
        boolean[] zArr = this.mSelectMap;
        if (zArr != null && i >= 0 && i < zArr.length) {
            zArr[i] = !zArr[i];
        }
    }

    public boolean isSelected(int i) {
        boolean[] zArr = this.mSelectMap;
        if (zArr == null || i < 0 || i >= zArr.length) {
            return false;
        }
        return zArr[i];
    }

    public void setMultiSelectMode(boolean z) {
        if (this.mIsMultiSelectMode != z) {
            this.mIsMultiSelectMode = z;
            if (!z) {
                unSelectAll();
            }
            notifyDataSetChanged();
        }
    }

    public ArrayList<TimeItem> getSelectItems() {
        ArrayList<TimeItem> arrayList = new ArrayList<>();
        for (int i = 0; i < this.mData.size(); i++) {
            boolean[] zArr = this.mSelectMap;
            if (i >= zArr.length) {
                break;
            }
            if (zArr[i]) {
                arrayList.add(this.mData.get(i).timeItem);
            }
        }
        return arrayList;
    }

    class SDCardHourViewHolder extends RecyclerView.O000OOo0 {
        private ImageView checkView;
        private ImageView imageView;
        private ImageView ivForeverStoreIcon;
        public ImageView ivSelected;
        private TextView timeView;

        public SDCardHourViewHolder(View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.thumb);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.imageView.getLayoutParams();
            layoutParams.width = (SDCardHourAdapter.this.itemWidth - this.imageView.getPaddingLeft()) - this.imageView.getPaddingRight();
            double d = (double) layoutParams.width;
            Double.isNaN(d);
            layoutParams.height = (int) (d * 0.6d);
            this.imageView.setLayoutParams(layoutParams);
            this.timeView = (TextView) view.findViewById(R.id.title);
            this.checkView = (ImageView) view.findViewById(R.id.checkbox);
            this.ivForeverStoreIcon = (ImageView) view.findViewById(R.id.ivForeverStoreIcon);
            this.ivForeverStoreIcon.setImageResource(SDCardHourAdapter.this.isV4 ? R.drawable.camera_v4_store_tag_forever_nor : R.drawable.camera_store_tag_forever_nor);
            this.ivSelected = (ImageView) view.findViewById(R.id.ivSelected);
            ViewGroup.LayoutParams layoutParams2 = this.imageView.getLayoutParams();
            this.ivSelected.getLayoutParams().height = layoutParams2.height;
            this.ivSelected.getLayoutParams().width = layoutParams2.width;
            view.setOnClickListener(new View.OnClickListener(SDCardHourAdapter.this) {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardHourAdapter.SDCardHourViewHolder.AnonymousClass1 */

                public void onClick(View view) {
                    if (SDCardHourAdapter.this.mListener != null) {
                        SDCardHourAdapter.this.mListener.onRecyclerClick(view);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener(SDCardHourAdapter.this) {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardHourAdapter.SDCardHourViewHolder.AnonymousClass2 */

                public boolean onLongClick(View view) {
                    if (SDCardHourAdapter.this.mListener == null) {
                        return true;
                    }
                    SDCardHourAdapter.this.mListener.onRecyclerLongClick(view);
                    return true;
                }
            });
        }

        public void bindView(int i) {
            TimeItemData timeItemData = SDCardHourAdapter.this.mData.get(i);
            this.itemView.setTag(timeItemData);
            if (cnx.O000000o().O00000Oo()) {
                cnx.O000000o().O000000o(timeItemData.timeItem.O000000o(SDCardHourAdapter.this.mDid), this.imageView, SDCardHourAdapter.this.mOptions);
            }
            this.timeView.setText(timeItemData.title);
            int i2 = timeItemData.timeItem.O00000o;
            if (i2 == 1) {
                Drawable drawable = SDCardHourAdapter.this.mContext.getResources().getDrawable(R.drawable.icon_event_type_people_run);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.timeView.setCompoundDrawables(null, null, drawable, null);
            } else if (i2 == 2 || i2 == 3) {
                Drawable drawable2 = SDCardHourAdapter.this.mContext.getResources().getDrawable(R.drawable.icon_event_type_pet);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                this.timeView.setCompoundDrawables(null, null, drawable2, null);
            } else if (i2 == 4) {
                Drawable drawable3 = SDCardHourAdapter.this.mContext.getResources().getDrawable(R.drawable.icon_event_type_unknow_people);
                drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                this.timeView.setCompoundDrawables(null, null, drawable3, null);
            } else if (i2 == 5) {
                Drawable drawable4 = SDCardHourAdapter.this.mContext.getResources().getDrawable(R.drawable.icon_event_type_known_people);
                drawable4.setBounds(0, 0, drawable4.getMinimumWidth(), drawable4.getMinimumHeight());
                this.timeView.setCompoundDrawables(null, null, drawable4, null);
            } else if (i2 != 7) {
                this.timeView.setCompoundDrawables(null, null, null, null);
            } else {
                Drawable drawable5 = SDCardHourAdapter.this.mContext.getResources().getDrawable(R.drawable.icon_event_type_baby_cry);
                drawable5.setBounds(0, 0, drawable5.getMinimumWidth(), drawable5.getMinimumHeight());
                this.timeView.setCompoundDrawables(null, null, drawable5, null);
            }
            if (SDCardHourAdapter.this.mIsMultiSelectMode) {
                this.checkView.setVisibility(0);
                if (SDCardHourAdapter.this.isSelected(i)) {
                    this.checkView.setImageResource(R.drawable.camera_delete_checked);
                } else {
                    this.checkView.setImageResource(R.drawable.camera_delete_unchecked);
                }
            } else {
                this.checkView.setVisibility(8);
            }
            if (i == SDCardHourAdapter.this.selectedPos) {
                this.ivSelected.setVisibility(0);
            } else {
                this.ivSelected.setVisibility(8);
            }
            if (timeItemData != null && timeItemData.timeItem != null && this.ivForeverStoreIcon != null) {
                if (timeItemData.timeItem.O00000oO != 0) {
                    this.ivForeverStoreIcon.setVisibility(0);
                } else {
                    this.ivForeverStoreIcon.setVisibility(8);
                }
            }
        }
    }
}

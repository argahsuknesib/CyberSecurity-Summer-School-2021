package com.xiaomi.smarthome.camera.activity.alarm;

import _m_j.chp;
import _m_j.clc;
import _m_j.cnw;
import _m_j.cnx;
import _m_j.gqg;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.view.recycle.BaseViewHolder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlarmDayV2Adapter extends RecyclerView.O000000o<BaseViewHolder> {
    private int TYPE_DATA = 1;
    public int TYPE_TITLE = 0;
    public ClickCallBack mClickCallBak = null;
    public ArrayList<AlarmDayBeanV2> mData = new ArrayList<>();
    private int mDataCount = 0;
    public boolean mDisableLongPress;
    public boolean mIsMultiSelectMode = false;
    public cnw mOptions;
    private boolean[] mSelectList;

    interface ClickCallBack {
        void onRecyclerClick(View view);

        void onRecyclerLongClick(View view);
    }

    public void destroyDisplayImageOptions() {
        this.mOptions = null;
    }

    private void initImageDisplayOptions(Context context) {
        cnw.O000000o o000000o = new cnw.O000000o();
        o000000o.O00000o = context.getResources().getDrawable(R.drawable.camera_remind_load_fail);
        o000000o.O00000oO = context.getResources().getDrawable(R.drawable.camera_remind_load_fail);
        o000000o.O00000oo = context.getResources().getDrawable(R.drawable.camera_remind_load_fail);
        o000000o.O0000OOo = true;
        o000000o.O0000Oo0 = true;
        o000000o.O0000o00 = true;
        cnw.O000000o O000000o2 = o000000o.O000000o(Bitmap.Config.RGB_565);
        O000000o2.O0000Oo = ImageScaleType.EXACTLY_STRETCHED;
        this.mOptions = O000000o2.O000000o();
    }

    public AlarmDayV2Adapter(Context context, ClickCallBack clickCallBack) {
        initImageDisplayOptions(context);
        this.mClickCallBak = clickCallBack;
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
    public void setData(ArrayList<AlarmDayBeanV2> arrayList) {
        this.mData = arrayList;
        this.mSelectList = new boolean[this.mData.size()];
        Arrays.fill(this.mSelectList, false);
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2).item != null) {
                i++;
            }
        }
        this.mDataCount = i;
        notifyDataSetChanged();
    }

    public List<AlarmDayBeanV2> getData() {
        ArrayList<AlarmDayBeanV2> arrayList = this.mData;
        if (arrayList != null) {
            return arrayList;
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == this.TYPE_TITLE) {
            return new TitleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.camera_alarm_day_title, viewGroup, false));
        }
        return new DataViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.camera_alarm_day_item, viewGroup, false));
    }

    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        if (getItemViewType(i) == this.TYPE_TITLE) {
            ((TitleViewHolder) baseViewHolder).bindView(this.mData.get(i).title);
        } else {
            ((DataViewHolder) baseViewHolder).bindView(i);
        }
    }

    public int getItemCount() {
        return this.mData.size();
    }

    public int getItemViewType(int i) {
        if (i < 0 || i >= this.mData.size() || this.mData.get(i).item != null) {
            return this.TYPE_DATA;
        }
        return this.TYPE_TITLE;
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

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.O00000Oo() {
                /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmDayV2Adapter.AnonymousClass1 */

                public int getSpanSize(int i) {
                    if (AlarmDayV2Adapter.this.getItemViewType(i) == AlarmDayV2Adapter.this.TYPE_TITLE) {
                        return gridLayoutManager.getSpanCount();
                    }
                    return 1;
                }
            });
        }
    }

    public void disableLongPress(boolean z) {
        this.mDisableLongPress = z;
    }

    public boolean getEditMode() {
        return this.mIsMultiSelectMode;
    }

    class DataViewHolder extends BaseViewHolder {
        private ImageView checkView;
        private ImageView imageView;
        private TextView timeView;

        DataViewHolder(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener(AlarmDayV2Adapter.this) {
                /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmDayV2Adapter.DataViewHolder.AnonymousClass1 */

                public void onClick(View view) {
                    if (AlarmDayV2Adapter.this.mClickCallBak != null) {
                        AlarmDayV2Adapter.this.mClickCallBak.onRecyclerClick(view);
                    }
                }
            });
            if (!AlarmDayV2Adapter.this.mDisableLongPress) {
                view.setOnLongClickListener(new View.OnLongClickListener(AlarmDayV2Adapter.this) {
                    /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmDayV2Adapter.DataViewHolder.AnonymousClass2 */

                    public boolean onLongClick(View view) {
                        if (AlarmDayV2Adapter.this.mClickCallBak == null) {
                            return true;
                        }
                        AlarmDayV2Adapter.this.mClickCallBak.onRecyclerLongClick(view);
                        return true;
                    }
                });
            }
            this.imageView = (ImageView) view.findViewById(R.id.thumb);
            this.checkView = (ImageView) view.findViewById(R.id.checkbox);
            this.timeView = (TextView) view.findViewById(R.id.title);
            this.imageView.getLayoutParams().height = (((int) (((float) chp.f13827O000000o) - (chp.O00000o0 * 4.0f))) * 3) / 16;
        }

        /* access modifiers changed from: package-private */
        public void bindView(int i) {
            if (i >= 0 && i <= AlarmDayV2Adapter.this.getItemCount()) {
                AlarmDayBeanV2 alarmDayBeanV2 = AlarmDayV2Adapter.this.mData.get(i);
                if (alarmDayBeanV2.item != null) {
                    this.itemView.setTag(alarmDayBeanV2.item);
                    String str = alarmDayBeanV2.item.O00000oo;
                    if (cnx.O000000o().O00000Oo()) {
                        cnx.O000000o().O000000o(str, this.imageView, AlarmDayV2Adapter.this.mOptions);
                    }
                    this.timeView.setText(alarmDayBeanV2.title);
                    if (AlarmDayV2Adapter.this.mIsMultiSelectMode) {
                        this.checkView.setVisibility(0);
                        if (AlarmDayV2Adapter.this.isSelected(i)) {
                            this.checkView.setImageResource(R.drawable.camera_delete_checked);
                        } else {
                            this.checkView.setImageResource(R.drawable.camera_delete_unchecked);
                        }
                    } else {
                        this.checkView.setVisibility(8);
                    }
                }
            }
        }
    }

    public void selectAll() {
        boolean[] zArr = this.mSelectList;
        if (zArr != null) {
            int i = 50;
            if (zArr.length <= 50) {
                i = zArr.length;
            }
            for (int i2 = 0; i2 < i; i2++) {
                if (getItemViewType(i2) == this.TYPE_DATA) {
                    this.mSelectList[i2] = true;
                } else {
                    i++;
                    boolean[] zArr2 = this.mSelectList;
                    if (i > zArr2.length) {
                        i = zArr2.length;
                    }
                }
            }
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
    public void unSelectAll() {
        if (getItemCount() != 0 || !this.mIsMultiSelectMode) {
            boolean[] zArr = this.mSelectList;
            if (zArr != null) {
                Arrays.fill(zArr, false);
            }
            notifyDataSetChanged();
        }
    }

    public void selectToggle(int i) {
        if (i >= 0) {
            boolean[] zArr = this.mSelectList;
            if (i < zArr.length) {
                if (zArr[i] || getSelectedCount() < 50) {
                    boolean[] zArr2 = this.mSelectList;
                    zArr2[i] = !zArr2[i];
                    return;
                }
                gqg.O00000Oo((int) R.string.cs_max_delete_50);
            }
        }
    }

    public int getSelectedCount() {
        boolean[] zArr = this.mSelectList;
        if (zArr == null) {
            return 0;
        }
        int i = 0;
        for (boolean z : zArr) {
            if (z) {
                i++;
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public int getDayIndex(int i) {
        for (int i2 = i; i2 >= 0; i2--) {
            if (getItemViewType(i2) == 0) {
                return i - i2;
            }
        }
        return 0;
    }

    public ArrayList<clc> getSelectList() {
        clc clc;
        ArrayList<clc> arrayList = new ArrayList<>();
        for (int i = 0; i < this.mData.size(); i++) {
            boolean[] zArr = this.mSelectList;
            if (i < zArr.length && zArr[i] && (clc = this.mData.get(i).item) != null) {
                arrayList.add(clc);
            }
        }
        return arrayList;
    }

    public int getDataCount() {
        return this.mDataCount;
    }

    public boolean isSelected(int i) {
        if (i < 0) {
            return true;
        }
        boolean[] zArr = this.mSelectList;
        return i >= zArr.length || zArr[i];
    }

    class TitleViewHolder extends BaseViewHolder {
        private TextView titleView;

        TitleViewHolder(View view) {
            super(view);
            this.titleView = (TextView) view.findViewById(R.id.list_title_txt);
        }

        /* access modifiers changed from: package-private */
        public void bindView(String str) {
            this.titleView.setText(str);
        }
    }
}

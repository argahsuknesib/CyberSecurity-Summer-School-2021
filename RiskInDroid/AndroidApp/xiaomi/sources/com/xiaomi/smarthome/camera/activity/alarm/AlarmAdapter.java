package com.xiaomi.smarthome.camera.activity.alarm;

import _m_j.clb;
import _m_j.clw;
import _m_j.cnw;
import _m_j.cnx;
import _m_j.me;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.xiaomi.smarthome.R;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class AlarmAdapter extends BaseAdapter {
    private Context mContext;
    HashSet<String> mDownList = new HashSet<>();
    private List<clb> mList = new ArrayList();
    private cnw mOptions;
    private SimpleDateFormat mTimeFormat = new SimpleDateFormat("HH:mm");

    public long getItemId(int i) {
        return (long) i;
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

    public AlarmAdapter(Context context) {
        initImageDisplayOptions(context);
        this.mContext = context;
    }

    public void setData(List<clb> list, String str) {
        String[] list2;
        for (clb next : list) {
            next.O0000OoO = this.mTimeFormat.format(new Date(next.O00000Oo));
        }
        this.mList = list;
        String O00000o0 = me.O00000o0(str);
        this.mDownList.clear();
        if (!TextUtils.isEmpty(O00000o0)) {
            File file = new File(O00000o0);
            if (file.exists() && (list2 = file.list()) != null) {
                this.mDownList.addAll(Arrays.asList(list2));
            }
        }
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.clw.O000000o(long, boolean):java.lang.String
     arg types: [long, int]
     candidates:
      _m_j.clw.O000000o(java.lang.String, boolean):long
      _m_j.clw.O000000o(long, boolean):java.lang.String */
    public void addDownSuccess(clb clb) {
        this.mDownList.add(clw.O000000o().O000000o(clb.O00000Oo, true) + ".mp4");
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.mList.size();
    }

    public clb getItem(int i) {
        return this.mList.get(i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.clw.O000000o(long, boolean):java.lang.String
     arg types: [long, int]
     candidates:
      _m_j.clw.O000000o(java.lang.String, boolean):long
      _m_j.clw.O000000o(long, boolean):java.lang.String */
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        View view2;
        String str;
        clb clb = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = LayoutInflater.from(this.mContext).inflate((int) R.layout.camera_alarm_list_item, (ViewGroup) null);
            viewHolder.mTypeImage = (ImageView) view2.findViewById(R.id.media_list_item_type_picture);
            viewHolder.mTime = (TextView) view2.findViewById(R.id.media_list_item_time);
            viewHolder.mImage = (ImageView) view2.findViewById(R.id.media_list_items_picture);
            viewHolder.mNormalItemLayout = (LinearLayout) view2.findViewById(R.id.normal_item_layout);
            viewHolder.mBottomLine = view2.findViewById(R.id.bottom_line);
            viewHolder.mTopLine = view2.findViewById(R.id.top_line);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        clb item = getItem(i);
        if (i > 0) {
            clb = getItem(i - 1);
        }
        viewHolder.mTime.setText(this.mList.get(i).O0000OoO);
        String O000000o2 = item.O000000o();
        cnx.O000000o().O000000o(viewHolder.mImage);
        if (TextUtils.isEmpty(O000000o2)) {
            viewHolder.mImage.setImageDrawable(view2.getContext().getResources().getDrawable(R.drawable.camera_remind_load_fail));
        } else if (cnx.O000000o().O00000Oo()) {
            cnx.O000000o().O000000o(O000000o2, viewHolder.mImage, this.mOptions);
        }
        String str2 = clw.O000000o().O000000o(item.O00000Oo, true) + ".mp4";
        if (clb != null) {
            str = clw.O000000o().O000000o(clb.O00000Oo, true) + ".mp4";
        } else {
            str = "";
        }
        if (this.mDownList.contains(str2) && this.mDownList.contains(str)) {
            viewHolder.mTypeImage.setImageResource(R.drawable.camera_time_line_dot_click);
            viewHolder.mTopLine.setBackgroundColor(Color.parseColor("#dfdfdf"));
            viewHolder.mTime.setTextColor(Color.parseColor("#8d8d8d"));
            viewHolder.mBottomLine.setBackgroundColor(Color.parseColor("#dfdfdf"));
        } else if (this.mDownList.contains(str2)) {
            viewHolder.mTypeImage.setImageResource(R.drawable.camera_time_line_dot_click);
            viewHolder.mTopLine.setBackgroundColor(Color.parseColor("#ff692e"));
            viewHolder.mTime.setTextColor(Color.parseColor("#8d8d8d"));
            viewHolder.mBottomLine.setBackgroundColor(Color.parseColor("#dfdfdf"));
        } else if (this.mDownList.contains(str)) {
            viewHolder.mTypeImage.setImageResource(R.drawable.camera_time_line_dot);
            viewHolder.mTopLine.setBackgroundColor(Color.parseColor("#dfdfdf"));
            viewHolder.mTime.setTextColor(Color.parseColor("#ff692e"));
            viewHolder.mBottomLine.setBackgroundColor(Color.parseColor("#ff692e"));
        } else {
            viewHolder.mTypeImage.setImageResource(R.drawable.camera_time_line_dot);
            viewHolder.mTopLine.setBackgroundColor(Color.parseColor("#ff692e"));
            viewHolder.mTime.setTextColor(Color.parseColor("#ff692e"));
            viewHolder.mBottomLine.setBackgroundColor(Color.parseColor("#ff692e"));
        }
        if (i == 0) {
            viewHolder.mTopLine.setVisibility(4);
        } else {
            viewHolder.mTopLine.setVisibility(0);
        }
        if (i == this.mList.size() - 1) {
            viewHolder.mBottomLine.setVisibility(4);
        } else {
            viewHolder.mBottomLine.setVisibility(0);
        }
        return view2;
    }

    class ViewHolder {
        public View mBottomLine;
        public ImageView mImage;
        public LinearLayout mNormalItemLayout;
        public TextView mTime;
        public View mTopLine;
        public ImageView mTypeImage;

        ViewHolder() {
        }
    }
}

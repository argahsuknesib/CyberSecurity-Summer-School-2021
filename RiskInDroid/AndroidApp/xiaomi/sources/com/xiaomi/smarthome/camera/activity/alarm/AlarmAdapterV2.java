package com.xiaomi.smarthome.camera.activity.alarm;

import _m_j.clc;
import _m_j.clf;
import _m_j.clw;
import _m_j.cnw;
import _m_j.cnx;
import _m_j.gpc;
import _m_j.me;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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

public class AlarmAdapterV2 extends BaseAdapter {
    private Context mContext;
    HashSet<String> mDownList = new HashSet<>();
    private List<clc> mList = new ArrayList();
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

    public AlarmAdapterV2(Context context) {
        initImageDisplayOptions(context);
        this.mContext = context;
    }

    public void setData(List<clc> list, String str) {
        String[] list2;
        for (clc next : list) {
            next.O0000OoO = this.mTimeFormat.format(new Date(next.O00000o0));
            clf.O000000o();
            next.O0000Ooo = clf.O000000o(this.mContext, next.O0000O0o);
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
    public void addDownSuccess(clc clc) {
        this.mDownList.add(clw.O000000o().O000000o(clc.O00000o0, true) + ".mp4");
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.mList.size();
    }

    public clc getItem(int i) {
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
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = LayoutInflater.from(this.mContext).inflate((int) R.layout.camera_alarm_list_item, (ViewGroup) null);
            viewHolder.mTypeImage = (ImageView) view2.findViewById(R.id.media_list_item_type_picture);
            viewHolder.mTime = (TextView) view2.findViewById(R.id.media_list_item_time);
            viewHolder.mTVMotionHint = (TextView) view2.findViewById(R.id.tvMotionHint);
            viewHolder.mImage = (ImageView) view2.findViewById(R.id.media_list_items_picture);
            viewHolder.mNormalItemLayout = (LinearLayout) view2.findViewById(R.id.normal_item_layout);
            viewHolder.mBottomLine = view2.findViewById(R.id.bottom_line);
            viewHolder.mTopLine = view2.findViewById(R.id.top_line);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        clc item = getItem(i);
        clc item2 = i > 0 ? getItem(i - 1) : null;
        viewHolder.mTime.setText(this.mList.get(i).O0000OoO);
        String str2 = item.O00000oo;
        if (!(viewHolder == null || viewHolder.mImage == null || !cnx.O000000o().O00000Oo())) {
            cnx.O000000o().O000000o(viewHolder.mImage);
            if (TextUtils.isEmpty(str2)) {
                viewHolder.mImage.setImageDrawable(view2.getContext().getResources().getDrawable(R.drawable.camera_remind_load_fail));
            } else {
                cnx.O000000o().O000000o(str2, viewHolder.mImage, this.mOptions);
            }
        }
        String str3 = clw.O000000o().O000000o(item.O00000o0, true) + ".mp4";
        if (item2 != null) {
            str = clw.O000000o().O000000o(item2.O00000o0, true) + ".mp4";
        } else {
            str = "";
        }
        if (this.mDownList.contains(str3) && this.mDownList.contains(str)) {
            viewHolder.mTypeImage.setImageResource(R.drawable.camera_time_line_dot_click);
            viewHolder.mTopLine.setBackgroundColor(Color.parseColor("#dfdfdf"));
            viewHolder.mTime.setTextColor(Color.parseColor("#8d8d8d"));
            viewHolder.mBottomLine.setBackgroundColor(Color.parseColor("#dfdfdf"));
        } else if (this.mDownList.contains(str3)) {
            viewHolder.mTypeImage.setImageResource(R.drawable.camera_time_line_dot_click);
            viewHolder.mTopLine.setBackgroundColor(Color.parseColor("#dfdfdf"));
            viewHolder.mTime.setTextColor(Color.parseColor("#8d8d8d"));
            viewHolder.mBottomLine.setBackgroundColor(Color.parseColor("#dfdfdf"));
        } else if (item.O0000Ooo) {
            viewHolder.mTypeImage.setImageResource(R.drawable.camera_time_line_dot_click);
            viewHolder.mTopLine.setBackgroundColor(Color.parseColor("#dfdfdf"));
            viewHolder.mTime.setTextColor(Color.parseColor("#8d8d8d"));
            viewHolder.mBottomLine.setBackgroundColor(Color.parseColor("#dfdfdf"));
        } else {
            this.mDownList.contains(str);
            viewHolder.mTypeImage.setImageResource(R.drawable.camera_time_line_dot);
            viewHolder.mTopLine.setBackgroundColor(Color.parseColor("#ff692e"));
            viewHolder.mTime.setTextColor(Color.parseColor("#ff692e"));
            viewHolder.mBottomLine.setBackgroundColor(Color.parseColor("#ff692e"));
        }
        if (item == null || TextUtils.isEmpty(item.O0000Oo) || !item.O0000Oo.contains("people")) {
            viewHolder.mTVMotionHint.setText((int) R.string.alarm_change_string);
            viewHolder.mTVMotionHint.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            viewHolder.mTVMotionHint.setCompoundDrawablePadding(gpc.O00000o0(view2.getContext(), 10.0f));
        } else {
            viewHolder.mTVMotionHint.setText((int) R.string.alarm_change_people_move);
            viewHolder.mTVMotionHint.setCompoundDrawablesWithIntrinsicBounds(view2.getContext().getResources().getDrawable(R.drawable.camera_motion_icon), (Drawable) null, (Drawable) null, (Drawable) null);
            viewHolder.mTVMotionHint.setCompoundDrawablePadding(gpc.O00000o0(view2.getContext(), 10.0f));
        }
        return view2;
    }

    class ViewHolder {
        public View mBottomLine;
        public ImageView mImage;
        public LinearLayout mNormalItemLayout;
        public TextView mTVMotionHint;
        public TextView mTime;
        public View mTopLine;
        public ImageView mTypeImage;

        ViewHolder() {
        }
    }
}

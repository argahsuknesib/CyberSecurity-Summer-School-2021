package com.xiaomi.smarthome.camera.v4.activity.alarm;

import _m_j.cid;
import _m_j.clb;
import _m_j.clw;
import _m_j.cnw;
import _m_j.cnx;
import _m_j.gsy;
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
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class AlarmAdapterV2 extends BaseAdapter {
    private Context mContext;
    private String mDid;
    HashSet<String> mDownList = new HashSet<>();
    private List<clb> mList = new ArrayList();
    private cnw mOptions;
    private SharePrefHelper mSP;
    private String mServer;
    private SimpleDateFormat mTimeFormat = new SimpleDateFormat("HH:mm");

    public long getItemId(int i) {
        return (long) i;
    }

    public void destroyDisplayImageOptions() {
        this.mOptions = null;
    }

    private void initImageDisplayOptions(Context context) {
        cnw.O000000o o000000o = new cnw.O000000o();
        o000000o.O00000o = context.getResources().getDrawable(R.drawable.camera_v4_remind_load_fail);
        o000000o.O00000oO = context.getResources().getDrawable(R.drawable.camera_v4_remind_load_fail);
        o000000o.O00000oo = context.getResources().getDrawable(R.drawable.camera_v4_remind_load_fail);
        o000000o.O0000OOo = true;
        o000000o.O0000Oo0 = true;
        o000000o.O0000o00 = true;
        cnw.O000000o O000000o2 = o000000o.O000000o(Bitmap.Config.RGB_565);
        O000000o2.O0000Oo = ImageScaleType.EXACTLY_STRETCHED;
        this.mOptions = O000000o2.O000000o();
    }

    public AlarmAdapterV2(Context context, String str) {
        initImageDisplayOptions(context);
        this.mContext = context;
        this.mDid = str;
        this.mServer = XmPluginHostApi.instance().getGlobalSettingServer();
        this.mSP = new SharePrefHelper(this.mContext, "housekeping", this.mDid);
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

    /* JADX WARNING: Removed duplicated region for block: B:55:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x024e  */
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        final ViewHolder viewHolder;
        String str;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = LayoutInflater.from(this.mContext).inflate((int) R.layout.imi_event_list_item, (ViewGroup) null);
            viewHolder.mTypeImage = (ImageView) view2.findViewById(R.id.media_list_item_type_picture);
            viewHolder.mTime = (TextView) view2.findViewById(R.id.media_list_item_time);
            viewHolder.mSubTitle = (TextView) view2.findViewById(R.id.media_list_item_subtitle);
            viewHolder.mPeople = (ImageView) view2.findViewById(R.id.media_list_item_people);
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
        viewHolder.mTime.setText(this.mList.get(i).O0000OoO);
        if (item.O0000Ooo) {
            str = item.O0000oO;
        } else {
            str = item.O000000o();
        }
        cnx.O000000o().O000000o(viewHolder.mImage);
        if (TextUtils.isEmpty(str)) {
            viewHolder.mImage.setImageDrawable(view2.getContext().getResources().getDrawable(R.drawable.store_icon_placeholder_nor));
        } else if (cnx.O000000o().O00000Oo()) {
            cnx.O000000o().O000000o(str, viewHolder.mImage, this.mOptions);
        }
        if (!item.O0000Ooo) {
            DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(this.mDid);
            if (deviceByDid != null) {
                cid.O000000o(deviceByDid, this.mDid).O000000o(this.mList.get(i).O00000oo, new Callback<Boolean>() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.alarm.AlarmAdapterV2.AnonymousClass1 */

                    public void onSuccess(Boolean bool) {
                        if (bool.booleanValue()) {
                            viewHolder.mPeople.setVisibility(0);
                            viewHolder.mSubTitle.setText((int) R.string.alarm_change_people_move);
                            return;
                        }
                        viewHolder.mPeople.setVisibility(8);
                        viewHolder.mSubTitle.setText((int) R.string.alarm_change_string);
                    }

                    public void onFailure(int i, String str) {
                        gsy.O000000o(3, "cmkj", "onFailure i:" + i + "  s:" + str);
                    }
                });
            }
        } else if (item == null || TextUtils.isEmpty(item.O0000oo) || !item.O0000oo.contains("people")) {
            viewHolder.mPeople.setVisibility(8);
            viewHolder.mSubTitle.setText((int) R.string.alarm_change_string);
        } else {
            viewHolder.mPeople.setVisibility(0);
            viewHolder.mSubTitle.setText((int) R.string.alarm_change_people_move);
        }
        if (!TextUtils.isEmpty(this.mSP.getStrValue("click_alarm_list"))) {
            String strValue = this.mSP.getStrValue("click_alarm_list");
            StringBuilder sb = new StringBuilder();
            sb.append(this.mList.get(i).O00000Oo);
            if (strValue.indexOf(sb.toString()) > 0) {
                viewHolder.mTypeImage.setImageResource(R.drawable.camera_time_line_dot_click);
                if (i == 0) {
                    viewHolder.mTopLine.setBackgroundColor(0);
                } else {
                    if (i != this.mList.size() - 1 && !TextUtils.isEmpty(this.mSP.getStrValue("click_alarm_list"))) {
                        String strValue2 = this.mSP.getStrValue("click_alarm_list");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(this.mList.get(i - 1).O00000Oo);
                        if (strValue2.indexOf(sb2.toString()) > 0) {
                            viewHolder.mTopLine.setBackgroundColor(Color.parseColor("#dfdfdf"));
                        }
                    }
                    viewHolder.mTopLine.setBackgroundColor(Color.parseColor("#ff692e"));
                }
                viewHolder.mTime.setTextColor(Color.parseColor("#8d8d8d"));
                viewHolder.mBottomLine.setBackgroundColor(Color.parseColor("#dfdfdf"));
                if (i != this.mList.size() - 1) {
                    viewHolder.mBottomLine.setVisibility(4);
                } else {
                    viewHolder.mBottomLine.setVisibility(0);
                }
                return view2;
            }
        }
        viewHolder.mTypeImage.setImageResource(R.drawable.camera_time_line_dot);
        if (i == 0) {
            viewHolder.mTopLine.setBackgroundColor(0);
        } else {
            if (i != this.mList.size() - 1 && !TextUtils.isEmpty(this.mSP.getStrValue("click_alarm_list"))) {
                String strValue3 = this.mSP.getStrValue("click_alarm_list");
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.mList.get(i - 1).O00000Oo);
                if (strValue3.indexOf(sb3.toString()) > 0) {
                    viewHolder.mTopLine.setBackgroundColor(Color.parseColor("#dfdfdf"));
                }
            }
            viewHolder.mTopLine.setBackgroundColor(Color.parseColor("#ff692e"));
        }
        viewHolder.mTime.setTextColor(Color.parseColor("#ff692e"));
        viewHolder.mBottomLine.setBackgroundColor(Color.parseColor("#ff692e"));
        if (i != this.mList.size() - 1) {
        }
        return view2;
    }

    class ViewHolder {
        public View mBottomLine;
        public ImageView mImage;
        public LinearLayout mNormalItemLayout;
        public ImageView mPeople;
        public TextView mSubTitle;
        public TextView mTime;
        public View mTopLine;
        public ImageView mTypeImage;

        ViewHolder() {
        }
    }
}

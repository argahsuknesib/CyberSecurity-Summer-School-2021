package com.xiaomi.smarthome.camera.activity.sdcard.fragment;

import _m_j.cib;
import _m_j.cid;
import _m_j.civ;
import _m_j.ckb;
import _m_j.fsp;
import _m_j.fvm;
import _m_j.goq;
import _m_j.gqg;
import _m_j.hxi;
import _m_j.hyy;
import _m_j.mi;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.mijia.generalplayer.videoview.GeneralVideoViewTimeLine;
import com.mijia.model.alarmcloud.AlarmCloudCallback;
import com.mijia.model.alarmcloud.AlarmVideo;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.local.LocalPicActivity;
import com.xiaomi.smarthome.camera.activity.sdcard.SDCardCloudVideoActivity;
import com.xiaomi.smarthome.camera.activity.sdcard.fragment.CloudTimeLineFragment;
import com.xiaomi.smarthome.camera.view.timeline.TimeLineControlView2;
import com.xiaomi.smarthome.camera.view.timeline.TimeLineUtils;
import com.xiaomi.smarthome.camera.view.timeline.TimeLineWithDatePickView2;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoChildListData;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDate;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.DailyList;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.ICloudVideoCallback;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.StatsRecord2;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoUtils;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudTimeLineFragment extends fvm {
    public static final String TAG = "CloudTimeLineFragment";
    private final int DEFAULT_LOADED_DAYS = 2;
    private TextView cb_ai;
    private TextView cb_area_move;
    private TextView cb_baby_cry;
    private TextView cb_face;
    private TextView cb_people_move;
    public int curPlayState = -909090;
    public CloudVideoChildListData currentItem;
    List<CloudVideoDate> dateListDays = new ArrayList();
    public int datesUpdateVar = 0;
    private String did;
    public String fileId = "";
    public GeneralVideoViewTimeLine generalVideoView;
    public boolean isCompleted = false;
    private boolean isVip = false;
    public View ll_event_types;
    protected cid mCameraDevice;
    protected TextView mErrorInfoView;
    protected View mErrorRetryView;
    private Handler mHandler;
    protected ImageView mRetryView;
    private TimeLineControlView2.TimeLineCallback mTimeCallBack = new TimeLineControlView2.TimeLineCallback() {
        /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.CloudTimeLineFragment.AnonymousClass1 */

        public void onUpdateTime(long j) {
            CloudTimeLineFragment.this.mTimeUpdateView.setText(mi.O000000o(j));
            if (CloudTimeLineFragment.this.mTimeUpdateView.getVisibility() != 0) {
                CloudTimeLineFragment.this.mTimeUpdateView.setVisibility(0);
            }
        }

        public void onSelectTime(final long j) {
            civ.O000000o(CloudTimeLineFragment.TAG, "onSelectTime = ".concat(String.valueOf(j)));
            long dayTS0 = CloudVideoUtils.getDayTS0(j);
            if (CloudTimeLineFragment.this.treeMapDatas == null || CloudTimeLineFragment.this.treeMapDatas.isEmpty() || !CloudTimeLineFragment.this.treeMapDatas.containsKey(Long.valueOf(dayTS0))) {
                String str = CloudTimeLineFragment.TAG;
                civ.O000000o(str, "onSelectTime don't containsKey= " + mi.O00000Oo(j));
                CloudTimeLineFragment.this.startPlayVideoItem(j, false);
            } else if (CloudTimeLineFragment.this.treeMapDatas.get(Long.valueOf(dayTS0)) == null) {
                long j2 = dayTS0;
                long j3 = (86400000 + dayTS0) - 1000;
                CloudTimeLineFragment.this.getPlayListLimit(j2, j3, new OnPlayListReturn() {
                    /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.CloudTimeLineFragment.AnonymousClass1.AnonymousClass1 */

                    public void onLoaded() {
                        String str = CloudTimeLineFragment.TAG;
                        civ.O000000o(str, "onSelectTime by getPlayListLimit= " + mi.O00000Oo(j));
                        CloudTimeLineFragment.this.startPlayVideoItem(j, false);
                    }
                });
                CloudTimeLineFragment.this.getEventList(j2, j3, false);
            } else {
                String str2 = CloudTimeLineFragment.TAG;
                civ.O000000o(str2, "onSelectTime by hased= " + mi.O00000Oo(j));
                CloudTimeLineFragment.this.startPlayVideoItem(j, false);
            }
            CloudTimeLineFragment.this.mTimeUpdateView.setVisibility(8);
        }

        public void onChangeTime(long j) {
            CloudTimeLineFragment.this.loadPreNext(j);
        }

        public void onPlayLive() {
            CloudTimeLineFragment.this.toSdFilesEnd();
            CloudTimeLineFragment.this.mTimeUpdateView.setVisibility(8);
        }

        public void onCancel() {
            if (CloudTimeLineFragment.this.mTimeUpdateView.getVisibility() == 0) {
                CloudTimeLineFragment.this.mTimeUpdateView.setVisibility(8);
            }
        }
    };
    public TimeLineWithDatePickView2 mTimeLineControlView;
    public TextView mTimeUpdateView;
    private String model;
    private TextView pet_move;
    private FrameLayout root;
    private View rootView;
    public TextView see_all_video;
    protected TextView see_help;
    HashMap<Long, Boolean> statesMap = new HashMap<>();
    public long todayStartTime = 0;
    TreeMap<Long, List<CloudVideoChildListData>> treeMapDatas = new TreeMap<>();
    TreeMap<Long, List<AlarmVideo>> treeMapEvents = new TreeMap<>();
    private String videoUrl;
    private ViewGroup videoViewParent;
    private boolean window = false;

    interface OnPlayListReturn {
        void onLoaded();
    }

    public void setData(cid cid, Handler handler) {
        this.mCameraDevice = cid;
        this.mHandler = handler;
        this.did = cid.getDid();
        this.model = cid.getModel();
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        civ.O000000o(TAG, "onHiddenChanged = ".concat(String.valueOf(z)));
        this.generalVideoView.setHidden(z);
        if (z) {
            this.generalVideoView.O00000o0();
        } else {
            this.generalVideoView.O00000Oo();
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        civ.O000000o(TAG, "setUserVisibleHint = ".concat(String.valueOf(z)));
    }

    public void loadPreNext(long j) {
        Map.Entry entry;
        long dayTS0 = CloudVideoUtils.getDayTS0(j);
        TreeMap<Long, List<CloudVideoChildListData>> treeMap = this.treeMapDatas;
        if (treeMap != null && !treeMap.isEmpty()) {
            Iterator<Map.Entry<Long, List<CloudVideoChildListData>>> it = this.treeMapDatas.entrySet().iterator();
            Map.Entry entry2 = null;
            do {
                entry = entry2;
                if (it.hasNext()) {
                    entry2 = it.next();
                } else {
                    return;
                }
            } while (dayTS0 != ((Long) entry2.getKey()).longValue());
            if (it.hasNext()) {
                Map.Entry next = it.next();
                if (next.getValue() == null) {
                    long longValue = ((Long) next.getKey()).longValue();
                    long j2 = longValue;
                    long j3 = (longValue + 86400000) - 1000;
                    getPlayListLimit(j2, j3, null);
                    getEventList(j2, j3, false);
                }
            }
            if (entry != null && entry.getValue() == null) {
                long longValue2 = ((Long) entry.getKey()).longValue();
                long j4 = longValue2;
                long j5 = (86400000 + longValue2) - 1000;
                getPlayListLimit(j4, j5, null);
                getEventList(j4, j5, false);
            }
        }
    }

    public void toSdFilesEnd() {
        CloudVideoChildListData endItem = TimeLineUtils.getEndItem(this.treeMapDatas);
        if (endItem != null) {
            String str = TAG;
            civ.O000000o(str, "toSdFilesEnd" + mi.O00000Oo(endItem.endTime));
            this.mTimeLineControlView.updatePlayTime(endItem.endTime, false);
        }
        this.generalVideoView.O000000o();
        this.generalVideoView.O00000oO();
        this.generalVideoView.O0000Ooo();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.rootView == null) {
            this.rootView = LayoutInflater.from(getContext()).inflate((int) R.layout.camera_fragment_cloud_tab, viewGroup, false);
        }
        cid cid = this.mCameraDevice;
        if (cid == null || cid.O00000oO() == null) {
            return this.rootView;
        }
        this.window = this.mCameraDevice.O00000oO().O000000o();
        this.isVip = this.mCameraDevice.O00000oO().O00000Oo() || this.window;
        initView(this.rootView);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long currentDayTS0 = CloudVideoUtils.getCurrentDayTS0();
        Calendar instance = Calendar.getInstance();
        for (int i = 29; i >= 0; i--) {
            CloudVideoDate cloudVideoDate = new CloudVideoDate();
            long j = currentDayTS0 - (((long) i) * 86400000);
            instance.setTime(new Date(j));
            String format = simpleDateFormat.format(Long.valueOf(j));
            cloudVideoDate.day = format.split("-")[2];
            cloudVideoDate.month = format.split("-")[1];
            cloudVideoDate.year = format.split("-")[0];
            cloudVideoDate.week = instance.get(7) - 1;
            cloudVideoDate.timeStamp = j;
            cloudVideoDate.startTime = j;
            this.dateListDays.add(cloudVideoDate);
        }
        this.mTimeLineControlView.setDateList(this.dateListDays);
        if (this.isVip) {
            getVideoDatesSerial();
        }
        return this.rootView;
    }

    private void initView(View view) {
        this.mErrorRetryView = LayoutInflater.from(this.mContext).inflate((int) R.layout.camera_error_retry, (ViewGroup) null);
        this.mRetryView = (ImageView) this.mErrorRetryView.findViewById(R.id.retry_btn);
        this.mRetryView.setImageResource(R.drawable.camera_state_conn_error);
        this.mErrorInfoView = (TextView) this.mErrorRetryView.findViewById(R.id.error_info);
        if (this.mCameraDevice.O00000oO().O00000Oo.getInt("camera_vip_status", 0) == 0) {
            this.mErrorInfoView.setText((int) R.string.cloud_vip_no_open);
        } else {
            this.mErrorInfoView.setText((int) R.string.cloud_vip_end);
        }
        this.see_help = (TextView) this.mErrorRetryView.findViewById(R.id.see_help);
        this.see_help.setText((int) R.string.to_open_cloud_vip);
        this.see_help.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$CloudTimeLineFragment$4f95yiDhV8FHIMeIqFkSPhUung */

            public final void onClick(View view) {
                CloudTimeLineFragment.this.lambda$initView$0$CloudTimeLineFragment(view);
            }
        });
        this.see_help.setVisibility(0);
        this.see_all_video = (TextView) view.findViewById(R.id.see_all_video);
        this.see_all_video.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$CloudTimeLineFragment$dsP4VfvIYTT9gZPHWsSsp41OQk */

            public final void onClick(View view) {
                CloudTimeLineFragment.this.lambda$initView$1$CloudTimeLineFragment(view);
            }
        });
        this.cb_people_move = (TextView) view.findViewById(R.id.cb_people_move);
        this.cb_area_move = (TextView) view.findViewById(R.id.cb_area_move);
        this.cb_baby_cry = (TextView) view.findViewById(R.id.cb_baby_cry);
        this.cb_face = (TextView) view.findViewById(R.id.cb_face);
        this.cb_ai = (TextView) view.findViewById(R.id.cb_ai);
        this.pet_move = (TextView) view.findViewById(R.id.pet_move);
        if (!"chuangmi.camera.ipc022".equals(this.mCameraDevice.getModel())) {
            this.pet_move.setVisibility(8);
        }
        this.cb_people_move.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$CloudTimeLineFragment$I242rfLOjcqPswxnaY8hHK6oLpM */

            public final void onClick(View view) {
                CloudTimeLineFragment.this.lambda$initView$2$CloudTimeLineFragment(view);
            }
        });
        this.cb_area_move.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$CloudTimeLineFragment$pWk9YML8RhTBMkkTjDtmZ2xjMn8 */

            public final void onClick(View view) {
                CloudTimeLineFragment.this.lambda$initView$3$CloudTimeLineFragment(view);
            }
        });
        this.cb_baby_cry.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$CloudTimeLineFragment$2USCS5j0ckbVxcFFxNfbPkoWZaU */

            public final void onClick(View view) {
                CloudTimeLineFragment.this.lambda$initView$4$CloudTimeLineFragment(view);
            }
        });
        this.cb_face.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$CloudTimeLineFragment$Z3Q0NYosyW8Jt1pukaloc_oEshE */

            public final void onClick(View view) {
                CloudTimeLineFragment.this.lambda$initView$5$CloudTimeLineFragment(view);
            }
        });
        this.cb_ai.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$CloudTimeLineFragment$89UbMX4SDr919cT8Gv5Ml6iU50 */

            public final void onClick(View view) {
                CloudTimeLineFragment.this.lambda$initView$6$CloudTimeLineFragment(view);
            }
        });
        this.pet_move.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$CloudTimeLineFragment$NPCp7rq8WxrQFZ0TUB_lXEPkJa8 */

            public final void onClick(View view) {
                CloudTimeLineFragment.this.lambda$initView$7$CloudTimeLineFragment(view);
            }
        });
        this.ll_event_types = view.findViewById(R.id.ll_event_types);
        this.root = (FrameLayout) view.findViewById(R.id.root);
        this.generalVideoView = new GeneralVideoViewTimeLine(this.mContext);
        this.generalVideoView.O00000Oo(false);
        GeneralVideoViewTimeLine generalVideoViewTimeLine = this.generalVideoView;
        generalVideoViewTimeLine.O0000o00 = 1000;
        generalVideoViewTimeLine.O000000o(this.mCameraDevice.getModel(), this.mCameraDevice.getDid());
        this.videoViewParent = (ViewGroup) view.findViewById(R.id.videoViewParent);
        this.videoViewParent.addView(this.generalVideoView);
        this.generalVideoView.setOnImageShortListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$CloudTimeLineFragment$koXpTAi0GNyRJfb6ulm2oRb3raU */

            public final void onClick(View view) {
                CloudTimeLineFragment.this.lambda$initView$8$CloudTimeLineFragment(view);
            }
        });
        this.mTimeLineControlView = (TimeLineWithDatePickView2) view.findViewById(R.id.time_line_date_pick);
        this.mTimeLineControlView.setTimeLineCallback(this.mTimeCallBack);
        if (!this.isVip) {
            this.generalVideoView.O000000o(this.mErrorRetryView);
            this.ll_event_types.setVisibility(8);
            if (!this.window) {
                this.see_all_video.setVisibility(8);
            }
            this.mTimeLineControlView.setCloudVip(false);
        }
        this.mTimeUpdateView = (TextView) view.findViewById(R.id.time_container_center);
        this.mTimeUpdateView.bringToFront();
        this.generalVideoView.setPlayerListener(new ckb.O00000Oo() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.CloudTimeLineFragment.AnonymousClass2 */

            public void isPlayingChanged(boolean z) {
            }

            public void onLoadingChanged(boolean z) {
            }

            public void onPrepared() {
                civ.O000000o(CloudTimeLineFragment.TAG, "onPrepared");
                if (!CloudTimeLineFragment.this.isCompleted) {
                    CloudTimeLineFragment.this.generalVideoView.O00000o();
                }
            }

            public void onPlayerStateChanged(int i) {
                if (CloudTimeLineFragment.this.curPlayState != i) {
                    CloudTimeLineFragment.this.curPlayState = i;
                    civ.O000000o(CloudTimeLineFragment.TAG, "onPlayerStateChanged=".concat(String.valueOf(i)));
                    if (i == 4) {
                        CloudTimeLineFragment.this.onCompletion();
                    }
                }
            }

            public void onPlayerError(String str) {
                CloudTimeLineFragment.this.mErrorInfoView.setText((int) R.string.common_net_error);
                CloudTimeLineFragment.this.see_help.setText((int) R.string.retry_network);
                CloudTimeLineFragment.this.generalVideoView.O000000o(CloudTimeLineFragment.this.mErrorRetryView);
                CloudTimeLineFragment.this.ll_event_types.setVisibility(8);
                CloudTimeLineFragment.this.see_all_video.setVisibility(8);
                CloudTimeLineFragment.this.mTimeLineControlView.setEnabled(false);
                CloudTimeLineFragment.this.see_help.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$CloudTimeLineFragment$2$TplL6LoFR45lOTzbqtV6XoS8M */

                    public final void onClick(View view) {
                        CloudTimeLineFragment.AnonymousClass2.this.lambda$onPlayerError$0$CloudTimeLineFragment$2(view);
                    }
                });
            }

            public /* synthetic */ void lambda$onPlayerError$0$CloudTimeLineFragment$2(View view) {
                CloudTimeLineFragment cloudTimeLineFragment = CloudTimeLineFragment.this;
                cloudTimeLineFragment.fileId = "";
                if (cloudTimeLineFragment.currentItem != null) {
                    CloudTimeLineFragment cloudTimeLineFragment2 = CloudTimeLineFragment.this;
                    cloudTimeLineFragment2.getLinkAndPlay(cloudTimeLineFragment2.currentItem, CloudTimeLineFragment.this.currentItem.startTime);
                } else {
                    CloudTimeLineFragment.this.getVideoDatesSerial();
                }
                CloudTimeLineFragment.this.generalVideoView.O00000Oo(CloudTimeLineFragment.this.mErrorRetryView);
                CloudTimeLineFragment.this.ll_event_types.setVisibility(0);
                CloudTimeLineFragment.this.see_all_video.setVisibility(0);
                CloudTimeLineFragment.this.mTimeLineControlView.setEnabled(true);
            }

            public void onPlaySchedule(long j) {
                if (j >= 0 && CloudTimeLineFragment.this.currentItem != null && !CloudTimeLineFragment.this.mTimeLineControlView.getIsPress()) {
                    CloudTimeLineFragment.this.mTimeLineControlView.updatePlayTime(CloudTimeLineFragment.this.currentItem.startTime + j, false);
                }
            }
        });
    }

    public /* synthetic */ void lambda$initView$0$CloudTimeLineFragment(View view) {
        if (this.mCameraDevice.isShared()) {
            gqg.O000000o((int) R.string.cloud_share_hint);
        } else {
            CloudVideoNetUtils.getInstance().openCloudVideoBuyPage(getActivity(), this.mCameraDevice.getDid());
        }
    }

    public /* synthetic */ void lambda$initView$1$CloudTimeLineFragment(View view) {
        hxi.O00000o.O00000o(!TextUtils.isEmpty(this.mCameraDevice.getModel()) ? this.mCameraDevice.getModel() : "", "cloud");
        if (this.isVip || this.window) {
            fsp.O000000o().O0000Oo.openCloudVideoListActivity(getActivity(), this.mCameraDevice.getDid(), this.mCameraDevice.getName());
        } else if (getActivity() != null) {
            CloudVideoNetUtils.getInstance().openCloudVideoBuyPage(getActivity(), this.mCameraDevice.getDid());
        }
    }

    public /* synthetic */ void lambda$initView$2$CloudTimeLineFragment(View view) {
        boolean z = true;
        boolean z2 = !this.cb_people_move.isSelected();
        this.cb_people_move.setSelected(z2);
        TimeLineWithDatePickView2 timeLineWithDatePickView2 = this.mTimeLineControlView;
        if (z2) {
            z = false;
        }
        timeLineWithDatePickView2.setPeopleMove(z);
    }

    public /* synthetic */ void lambda$initView$3$CloudTimeLineFragment(View view) {
        boolean z = true;
        boolean z2 = !this.cb_area_move.isSelected();
        this.cb_area_move.setSelected(z2);
        TimeLineWithDatePickView2 timeLineWithDatePickView2 = this.mTimeLineControlView;
        if (z2) {
            z = false;
        }
        timeLineWithDatePickView2.setAreaMove(z);
    }

    public /* synthetic */ void lambda$initView$4$CloudTimeLineFragment(View view) {
        boolean z = true;
        boolean z2 = !this.cb_baby_cry.isSelected();
        this.cb_baby_cry.setSelected(z2);
        TimeLineWithDatePickView2 timeLineWithDatePickView2 = this.mTimeLineControlView;
        if (z2) {
            z = false;
        }
        timeLineWithDatePickView2.setBabyCry(z);
    }

    public /* synthetic */ void lambda$initView$5$CloudTimeLineFragment(View view) {
        boolean z = true;
        boolean z2 = !this.cb_face.isSelected();
        this.cb_face.setSelected(z2);
        TimeLineWithDatePickView2 timeLineWithDatePickView2 = this.mTimeLineControlView;
        if (z2) {
            z = false;
        }
        timeLineWithDatePickView2.setFace(z);
    }

    public /* synthetic */ void lambda$initView$6$CloudTimeLineFragment(View view) {
        boolean z = true;
        boolean z2 = !this.cb_ai.isSelected();
        this.cb_ai.setSelected(z2);
        TimeLineWithDatePickView2 timeLineWithDatePickView2 = this.mTimeLineControlView;
        if (z2) {
            z = false;
        }
        timeLineWithDatePickView2.setAi(z);
    }

    public /* synthetic */ void lambda$initView$7$CloudTimeLineFragment(View view) {
        boolean z = true;
        boolean z2 = !this.pet_move.isSelected();
        this.pet_move.setSelected(z2);
        TimeLineWithDatePickView2 timeLineWithDatePickView2 = this.mTimeLineControlView;
        if (z2) {
            z = false;
        }
        timeLineWithDatePickView2.setPetMove(z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public /* synthetic */ void lambda$initView$8$CloudTimeLineFragment(View view) {
        if (!XmPluginHostApi.instance().checkAndRequestPermisson(getActivity(), true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            getContext();
            gqg.O000000o((int) R.string.no_write_permission);
            return;
        }
        Intent intent = new Intent(getActivity(), LocalPicActivity.class);
        intent.putExtra("noScroll", true);
        this.generalVideoView.O000000o(intent);
    }

    public void onCompletion() {
        if (!this.isCompleted) {
            String str = TAG;
            civ.O000000o(str, "onCompletion=" + mi.O00000Oo(this.currentItem.endTime));
            this.isCompleted = true;
            startPlayVideoItem(this.currentItem.endTime, true);
        }
    }

    public void startPlayVideoItem(long j, boolean z) {
        civ.O000000o(TAG, "startPlayVideoItem=" + mi.O00000Oo(j));
        Iterator<Long> descendingIterator = descendingIterator(this.treeMapDatas);
        CloudVideoChildListData cloudVideoChildListData = null;
        CloudVideoChildListData cloudVideoChildListData2 = null;
        CloudVideoChildListData cloudVideoChildListData3 = null;
        while (descendingIterator.hasNext()) {
            List<CloudVideoChildListData> list = this.treeMapDatas.get(Long.valueOf(descendingIterator.next().longValue()));
            if (list != null && list.size() > 0) {
                if (cloudVideoChildListData == null) {
                    cloudVideoChildListData = (CloudVideoChildListData) list.get(0);
                }
                if (((CloudVideoChildListData) list.get(0)).endTime >= j) {
                    for (CloudVideoChildListData cloudVideoChildListData4 : list) {
                        if (cloudVideoChildListData4.endTime > j) {
                            if (cloudVideoChildListData4.startTime < j) {
                                cloudVideoChildListData2 = cloudVideoChildListData4;
                                cloudVideoChildListData3 = cloudVideoChildListData2;
                            } else {
                                cloudVideoChildListData2 = cloudVideoChildListData4;
                            }
                        }
                    }
                    if (cloudVideoChildListData3 != null) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        if (cloudVideoChildListData3 != null) {
            civ.O000000o(TAG, "result=" + mi.O00000Oo(cloudVideoChildListData3.startTime));
            this.mTimeLineControlView.updatePlayTime(j, false);
            getLinkAndPlay(cloudVideoChildListData3, j);
        } else if (cloudVideoChildListData2 != null) {
            civ.O000000o(TAG, "near_result=" + mi.O00000Oo(cloudVideoChildListData2.startTime));
            this.mTimeLineControlView.updatePlayTime(cloudVideoChildListData2.startTime, false);
            getLinkAndPlay(cloudVideoChildListData2, cloudVideoChildListData2.startTime);
        } else if (cloudVideoChildListData == null || z) {
            civ.O000000o(TAG, "toSdFilesEnd");
            toSdFilesEnd();
        } else {
            civ.O000000o(TAG, "endItem=" + mi.O00000Oo(cloudVideoChildListData.startTime));
            this.mTimeLineControlView.updatePlayTime(cloudVideoChildListData.endTime, false);
            if (cloudVideoChildListData.endTime - cloudVideoChildListData.startTime > 2000) {
                getLinkAndPlay(cloudVideoChildListData, cloudVideoChildListData.endTime - 2000);
            } else {
                getLinkAndPlay(cloudVideoChildListData, cloudVideoChildListData.startTime);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00ac, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00c1, code lost:
        return;
     */
    public synchronized void getLinkAndPlay(CloudVideoChildListData cloudVideoChildListData, long j) {
        if (!this.fileId.equals(cloudVideoChildListData.fileId)) {
            this.fileId = cloudVideoChildListData.fileId;
            String str = TAG;
            civ.O000000o(str, "getLinkAndPlay  --" + this.fileId + "---" + j);
            if (!TextUtils.isEmpty(this.did) && !TextUtils.isEmpty(this.fileId)) {
                this.videoUrl = CloudVideoNetUtils.getInstance().getVideoFileUrl(this.did, this.fileId, false);
                if (TextUtils.isEmpty(this.videoUrl)) {
                    civ.O00000o0(TAG, "videoUrl is null");
                    return;
                }
                HashMap hashMap = new HashMap();
                MiServiceTokenInfo tokenInfo = CloudVideoNetUtils.getInstance().getTokenInfo();
                if (tokenInfo != null) {
                    hashMap.put("Cookie", "yetAnotherServiceToken=" + tokenInfo.O00000o0);
                    String str2 = TAG;
                    civ.O000000o(str2, "videoUrl=" + this.videoUrl);
                    this.isCompleted = false;
                    showVideoLoading(false);
                    this.currentItem = cloudVideoChildListData;
                    this.generalVideoView.O00000Oo(this.videoUrl, hashMap);
                    this.generalVideoView.O000000o(j - cloudVideoChildListData.startTime);
                }
            }
        } else {
            this.isCompleted = false;
            this.currentItem = cloudVideoChildListData;
            civ.O000000o(TAG, "getLinkAndPlay  seekAndPlay");
            this.generalVideoView.O000000o(j - cloudVideoChildListData.startTime);
        }
    }

    /* access modifiers changed from: protected */
    public void setWindow(boolean z) {
        if (z) {
            getActivity().getWindow().setFlags(1024, 1024);
        } else {
            getActivity().getWindow().clearFlags(1024);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        GeneralVideoViewTimeLine generalVideoViewTimeLine = this.generalVideoView;
        if (generalVideoViewTimeLine != null) {
            generalVideoViewTimeLine.O000000o(configuration);
        }
        try {
            boolean z = !(configuration.orientation == 1);
            if ((getContext() instanceof cib) && hyy.O000000o()) {
                z = ((cib) getContext()).getFullScreenThroughPad(z);
            }
            setWindow(z);
            if (z) {
                this.generalVideoView.getTime_line_land().removeAllViews();
                this.root.removeAllViews();
                this.mTimeLineControlView.setFull(true);
                this.generalVideoView.getTime_line_land().addView(this.mTimeLineControlView);
                this.generalVideoView.getTime_line_land().setVisibility(0);
                this.ll_event_types.setVisibility(8);
                this.see_all_video.setVisibility(8);
            } else {
                this.generalVideoView.getTime_line_land().removeAllViews();
                this.generalVideoView.getTime_line_land().setVisibility(8);
                this.mTimeLineControlView.setFull(false);
                this.root.removeAllViews();
                this.root.addView(this.mTimeLineControlView);
                this.ll_event_types.setVisibility(0);
                this.see_all_video.setVisibility(0);
            }
            this.generalVideoView.O00000o0(true);
        } catch (Exception e) {
            String str = TAG;
            civ.O00000o0(str, "onConfigurationChanged:" + e.getLocalizedMessage());
        }
    }

    private void showVideoLoading(boolean z) {
        this.generalVideoView.O000000o(z);
    }

    public void getPlayListLimit(long j, long j2, OnPlayListReturn onPlayListReturn) {
        long j3 = j2;
        if (this.isVip) {
            try {
                String str = TAG;
                civ.O000000o(str, "getPlayListLimit: beginTime" + j + "- endTime -" + j3);
                long gMT8TimeZone = CloudVideoNetUtils.getInstance().toGMT8TimeZone(j);
                long gMT8TimeZone2 = CloudVideoNetUtils.getInstance().toGMT8TimeZone(j3);
                String str2 = TAG;
                civ.O000000o(str2, "getPlayListLimit: beginTimeGMT8" + gMT8TimeZone + "- endTimeGMT8 -" + gMT8TimeZone2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("did", this.mCameraDevice.getDid());
                jSONObject.put("model", this.mCameraDevice.getModel());
                jSONObject.put("region", Locale.getDefault().getCountry());
                jSONObject.put("language", Locale.getDefault().getLanguage());
                jSONObject.put("beginTime", gMT8TimeZone);
                jSONObject.put("endTime", gMT8TimeZone2);
                jSONObject.put("limit", 20);
                final long j4 = j2;
                final long j5 = j;
                final OnPlayListReturn onPlayListReturn2 = onPlayListReturn;
                CloudVideoNetUtils.getInstance().getVideoDailyListLimitV2(getContext(), jSONObject.toString(), new ICloudVideoCallback<List<DailyList>>() {
                    /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.CloudTimeLineFragment.AnonymousClass3 */

                    public /* bridge */ /* synthetic */ void onCloudVideoSuccess(Object obj, Object obj2, boolean z) {
                        onCloudVideoSuccess((List<DailyList>) ((List) obj), obj2, z);
                    }

                    public void onCloudVideoSuccess(List<DailyList> list, Object obj, boolean z) {
                        List list2;
                        if (!((SDCardCloudVideoActivity) CloudTimeLineFragment.this.mContext).isFinishing()) {
                            long localTimeZone = CloudVideoNetUtils.getInstance().toLocalTimeZone(((Long) obj).longValue());
                            long j = j4;
                            long dayTS0 = CloudVideoUtils.getDayTS0(localTimeZone);
                            long dayTS02 = CloudVideoUtils.getDayTS0(j);
                            if (localTimeZone > 0 && dayTS0 == dayTS02 && list != null && !list.isEmpty()) {
                                List list3 = CloudTimeLineFragment.this.treeMapDatas.get(Long.valueOf(dayTS0));
                                if (list3 == null) {
                                    list3 = new ArrayList();
                                    CloudTimeLineFragment.this.treeMapDatas.put(Long.valueOf(dayTS0), list3);
                                }
                                new SimpleDateFormat("HH");
                                CloudVideoChildListData cloudVideoChildListData = null;
                                for (DailyList next : list) {
                                    CloudVideoChildListData cloudVideoChildListData2 = new CloudVideoChildListData();
                                    cloudVideoChildListData2.duration = next.duration;
                                    cloudVideoChildListData2.isPeople = next.isHuman;
                                    cloudVideoChildListData2.fileId = next.fileId;
                                    cloudVideoChildListData2.startTime = next.createTime;
                                    cloudVideoChildListData2.endTime = next.createTime + (next.duration * 1000);
                                    list3.add(cloudVideoChildListData2);
                                    cloudVideoChildListData = cloudVideoChildListData2;
                                }
                                if (z) {
                                    CloudTimeLineFragment.this.getPlayListLimit(j5, cloudVideoChildListData.startTime, onPlayListReturn2);
                                    return;
                                }
                                String str = CloudTimeLineFragment.TAG;
                                civ.O000000o(str, "complited--" + mi.O00000Oo(j5));
                                CloudTimeLineFragment.this.mTimeLineControlView.synCurrentTime(System.currentTimeMillis());
                                CloudTimeLineFragment.this.mTimeLineControlView.setTimeItems(CloudTimeLineFragment.this.treeMapDatas);
                                if (j5 == CloudTimeLineFragment.this.todayStartTime && (list2 = CloudTimeLineFragment.this.treeMapDatas.get(Long.valueOf(CloudTimeLineFragment.this.todayStartTime))) != null && list2.size() > 0) {
                                    CloudTimeLineFragment.this.getLinkAndPlay((CloudVideoChildListData) list2.get(0), ((CloudVideoChildListData) list2.get(0)).startTime);
                                    CloudTimeLineFragment.this.mTimeLineControlView.updatePlayTime(((CloudVideoChildListData) list2.get(0)).startTime, false);
                                }
                                OnPlayListReturn onPlayListReturn = onPlayListReturn2;
                                if (onPlayListReturn != null) {
                                    onPlayListReturn.onLoaded();
                                }
                            }
                        }
                    }

                    public void onCloudVideoFailed(int i, String str) {
                        List list;
                        if (!((SDCardCloudVideoActivity) CloudTimeLineFragment.this.mContext).isFinishing()) {
                            String str2 = CloudTimeLineFragment.TAG;
                            civ.O00000o0(str2, "errorCode:" + i + " errorInfo:" + str);
                            if (i == -90004) {
                                CloudTimeLineFragment.this.mTimeLineControlView.synCurrentTime(System.currentTimeMillis());
                                CloudTimeLineFragment.this.mTimeLineControlView.setTimeItems(CloudTimeLineFragment.this.treeMapDatas);
                                if (j5 == CloudTimeLineFragment.this.todayStartTime && (list = CloudTimeLineFragment.this.treeMapDatas.get(Long.valueOf(CloudTimeLineFragment.this.todayStartTime))) != null && list.size() > 0) {
                                    CloudTimeLineFragment.this.getLinkAndPlay((CloudVideoChildListData) list.get(0), ((CloudVideoChildListData) list.get(0)).startTime);
                                    CloudTimeLineFragment.this.mTimeLineControlView.updatePlayTime(((CloudVideoChildListData) list.get(0)).startTime, false);
                                }
                                OnPlayListReturn onPlayListReturn = onPlayListReturn2;
                                if (onPlayListReturn != null) {
                                    onPlayListReturn.onLoaded();
                                }
                            }
                        }
                    }
                });
            } catch (JSONException e) {
                civ.O00000o0(TAG, e.toString());
            }
        }
    }

    public void getVideoDatesSerial() {
        int i;
        if (this.isVip) {
            this.datesUpdateVar = 0;
            this.statesMap.clear();
            int i2 = 29;
            for (int i3 = 0; i3 < 5; i3++) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("did", this.did);
                    jSONObject.put("model", this.model);
                    Locale O00oOooo = CoreApi.O000000o().O00oOooo();
                    if (O00oOooo != null) {
                        jSONObject.put("region", O00oOooo.getCountry());
                    } else {
                        jSONObject.put("region", Locale.getDefault().getCountry());
                    }
                    JSONArray jSONArray = new JSONArray();
                    i = i2;
                    int i4 = 0;
                    while (i4 < 6) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            CloudVideoDate cloudVideoDate = this.dateListDays.get(i);
                            long gMT8TimeZone = CloudVideoNetUtils.getInstance().toGMT8TimeZone(cloudVideoDate.timeStamp);
                            long gMT8TimeZone2 = CloudVideoNetUtils.getInstance().toGMT8TimeZone(cloudVideoDate.timeStamp + 86399000);
                            jSONObject2.put("beginTime", gMT8TimeZone);
                            jSONObject2.put("endTime", gMT8TimeZone2);
                            jSONArray.put(jSONObject2);
                            i--;
                            i4++;
                        } catch (JSONException e) {
                            e = e;
                            civ.O00000o0(TAG, "exception:" + e.toString());
                            i2 = i;
                        }
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("intervals", jSONArray);
                    jSONObject.put("intervals", jSONObject3);
                    if (!TextUtils.isEmpty(this.did)) {
                        showVideoLoading(false);
                        CloudVideoNetUtils.getInstance().getVideoDatesSerial(this.mContext, jSONObject.toString(), new ICloudVideoCallback<List<StatsRecord2>>() {
                            /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.CloudTimeLineFragment.AnonymousClass4 */

                            public /* bridge */ /* synthetic */ void onCloudVideoSuccess(Object obj, Object obj2) {
                                onCloudVideoSuccess((List<StatsRecord2>) ((List) obj), obj2);
                            }

                            public void onCloudVideoSuccess(List<StatsRecord2> list, Object obj) {
                                if (!((SDCardCloudVideoActivity) CloudTimeLineFragment.this.mContext).isFinishing()) {
                                    CloudTimeLineFragment.this.datesUpdateVar++;
                                    civ.O000000o(CloudTimeLineFragment.TAG, "datesUpdateVar++ = " + CloudTimeLineFragment.this.datesUpdateVar);
                                    for (StatsRecord2 next : list) {
                                        CloudTimeLineFragment.this.statesMap.put(Long.valueOf(CloudVideoNetUtils.getInstance().toLocalTimeZone(next.timeStamp)), Boolean.valueOf(next.isExist));
                                    }
                                    if (CloudTimeLineFragment.this.datesUpdateVar >= 5) {
                                        CloudTimeLineFragment.this.updateDataListAdapter();
                                    }
                                }
                            }

                            public void onCloudVideoFailed(int i, String str) {
                                if (!((SDCardCloudVideoActivity) CloudTimeLineFragment.this.mContext).isFinishing()) {
                                    CloudTimeLineFragment.this.datesUpdateVar++;
                                    civ.O00000o0(CloudTimeLineFragment.TAG, "errorCode:" + i + ":" + str);
                                    if (CloudTimeLineFragment.this.datesUpdateVar >= 5) {
                                        CloudTimeLineFragment.this.updateDataListAdapter();
                                    }
                                }
                            }
                        });
                    } else {
                        gqg.O00000Oo((int) R.string.cs_device_info_fail);
                    }
                } catch (JSONException e2) {
                    e = e2;
                    i = i2;
                    civ.O00000o0(TAG, "exception:" + e.toString());
                    i2 = i;
                }
                i2 = i;
            }
        }
    }

    public void getEventList(final long j, long j2, final boolean z) {
        if (this.isVip) {
            this.mCameraDevice.O00000oo().getEventList("Default", j, j2, new AlarmCloudCallback<ArrayList<AlarmVideo>>() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.CloudTimeLineFragment.AnonymousClass5 */

                public void onSuccess(ArrayList<AlarmVideo> arrayList) {
                }

                public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    onSuccess((ArrayList<AlarmVideo>) ((ArrayList) obj));
                }

                public /* bridge */ /* synthetic */ void onSuccess(Object obj, long j, boolean z) {
                    onSuccess((ArrayList<AlarmVideo>) ((ArrayList) obj), j, z);
                }

                public void onFailure(int i, String str) {
                    if (!((SDCardCloudVideoActivity) CloudTimeLineFragment.this.mContext).isFinishing()) {
                        String str2 = CloudTimeLineFragment.TAG;
                        civ.O000000o(str2, "onFailure=" + str + " errorCode=" + i);
                    }
                }

                public void onSuccess(ArrayList<AlarmVideo> arrayList, long j, boolean z) {
                    if (!((SDCardCloudVideoActivity) CloudTimeLineFragment.this.mContext).isFinishing()) {
                        if (arrayList != null && arrayList.size() > 0) {
                            Object obj = CloudTimeLineFragment.this.treeMapEvents.get(Long.valueOf(j));
                            if (obj == null) {
                                obj = new ArrayList();
                                CloudTimeLineFragment.this.treeMapEvents.put(Long.valueOf(j), obj);
                            }
                            goq.O000000o(new Runnable(arrayList) {
                                /* class com.xiaomi.smarthome.camera.activity.sdcard.fragment.$$Lambda$CloudTimeLineFragment$5$MPmZXg_2BAx63keyj8qmwB8RRs */
                                private final /* synthetic */ ArrayList f$0;

                                {
                                    this.f$0 = r1;
                                }

                                public final void run() {
                                    CloudTimeLineFragment.AnonymousClass5.lambda$onSuccess$0(this.f$0);
                                }
                            });
                            obj.addAll(arrayList);
                        }
                        if (z) {
                            if (z) {
                                CloudTimeLineFragment.this.mTimeLineControlView.setTimeEventItems(CloudTimeLineFragment.this.treeMapEvents);
                            }
                            CloudTimeLineFragment.this.getEventList(j, j, z);
                            return;
                        }
                        String str = CloudTimeLineFragment.TAG;
                        civ.O000000o(str, "getEvents success --" + mi.O00000Oo(j));
                        CloudTimeLineFragment.this.mTimeLineControlView.setTimeEventItems(CloudTimeLineFragment.this.treeMapEvents);
                    }
                }

                static /* synthetic */ void lambda$onSuccess$0(ArrayList arrayList) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        AlarmVideo alarmVideo = (AlarmVideo) it.next();
                        alarmVideo.imgStoreId = null;
                        alarmVideo.videoStoreId = null;
                        alarmVideo.extraInfo = null;
                    }
                }
            });
        }
    }

    public void updateDataListAdapter() {
        Iterator<CloudVideoDate> it = this.dateListDays.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            CloudVideoDate next = it.next();
            Boolean bool = this.statesMap.get(Long.valueOf(next.timeStamp + 86399000));
            if (bool != null) {
                z = bool.booleanValue();
            }
            next.isHasVideo = z;
            if (z) {
                this.treeMapDatas.put(Long.valueOf(next.timeStamp), null);
            }
        }
        Iterator<Long> descendingIterator = descendingIterator(this.treeMapDatas);
        int i = 0;
        boolean z2 = true;
        while (descendingIterator.hasNext()) {
            int i2 = i + 1;
            long longValue = descendingIterator.next().longValue();
            if (this.todayStartTime == 0) {
                this.todayStartTime = longValue;
            }
            long j = longValue;
            long j2 = (86400000 + longValue) - 1000;
            getPlayListLimit(j, j2, null);
            getEventList(j, j2, z2);
            if (i2 >= 2) {
                break;
            }
            i = i2;
            z2 = false;
        }
        this.mTimeLineControlView.setDateList(this.dateListDays);
    }

    public static Iterator<Long> descendingIterator(TreeMap<Long, List<CloudVideoChildListData>> treeMap) {
        TreeSet treeSet = new TreeSet();
        for (Long longValue : treeMap.keySet()) {
            treeSet.add(Long.valueOf(longValue.longValue()));
        }
        return treeSet.descendingIterator();
    }

    public void onDestroy() {
        super.onDestroy();
        this.treeMapDatas.clear();
    }
}

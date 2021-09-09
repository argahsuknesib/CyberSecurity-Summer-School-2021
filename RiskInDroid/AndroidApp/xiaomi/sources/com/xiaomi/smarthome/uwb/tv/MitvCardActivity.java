package com.xiaomi.smarthome.uwb.tv;

import _m_j.fde;
import _m_j.fdg;
import _m_j.gpc;
import _m_j.hxi;
import _m_j.hzf;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Transformation;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.uwb.api.UwbMitvApi;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.mitv.data.MitvInfo;
import com.xiaomi.smarthome.uwb.lib.mitv.data.VideoInfo;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import com.xiaomi.smarthome.uwb.tv.remote.TVInfo;
import com.xiaomi.smarthome.uwb.tv.remote.TVRemoteApi;
import com.xiaomi.smarthome.uwb.tv.widget.BaseRecyclerArrayAdapter;
import com.xiaomi.smarthome.uwb.tv.widget.BaseViewHolder;
import com.xiaomi.smarthome.uwb.tv.widget.HorizontalItemDecoration;
import java.util.ArrayList;
import java.util.List;

public class MitvCardActivity extends BaseMitvCardActivity {
    public static final String TAG = "com.xiaomi.smarthome.uwb.tv.MitvCardActivity";
    final int SEEK_DEFAULT = 0;
    final int SEEK_START_TOUCH = 1;
    final int SEEK_STOP_TOUCH = 2;
    HistoryAdapter mHistoryAdapter;
    fde mHistoryCB;
    View mHistoryErrorLayout;
    View mHistoryLayout;
    RecyclerView mHistoryRecycler;
    volatile int mIsStartTrackingTouch = 0;
    private String mLastMediaId;
    private long mLastVideoInfoPos = -1;
    fde mPlayerCB;
    TextView mPlayerCiTv;
    TextView mPlayerCursorTv;
    TextView mPlayerDurationTv;
    View mPlayerLayout;
    ImageView mPlayerPosterIv;
    SeekBar mPlayerSeek;
    TextView mPlayerTitleTv;
    public final Handler mSeekBarHandler = new Handler(Looper.getMainLooper()) {
        /* class com.xiaomi.smarthome.uwb.tv.MitvCardActivity.AnonymousClass2 */

        public void handleMessage(Message message) {
            if (message.what == 4096) {
                UwbLogUtil.w(MitvCardActivity.TAG, "UwbLogUtilPlus MSG_SECOND_1");
                MitvCardActivity mitvCardActivity = MitvCardActivity.this;
                mitvCardActivity.refreshSeekBar(mitvCardActivity.mMitvCardActivityImpl.getmMitvInfo(), MitvCardActivity.this.mSeekTime + 1000, false);
                MitvCardActivity.this.releaseSeekBarHandler();
            }
        }
    };
    public long mSeekTime = -1;
    public final Handler mStartTrackingTouchHandler = new Handler(Looper.getMainLooper()) {
        /* class com.xiaomi.smarthome.uwb.tv.MitvCardActivity.AnonymousClass1 */

        public void handleMessage(Message message) {
            if (message.what == 8192) {
                MitvCardActivity.this.mIsStartTrackingTouch = 0;
                String str = MitvCardActivity.TAG;
                UwbLogUtil.w(str, "UwbLogUtilPlus sendStartTrackingTouchHandler handleMessage: " + MitvCardActivity.this.mIsStartTrackingTouch);
            }
        }
    };
    List<View> mTopLayoutList;

    public static void startCardActivity(Context context, UwbScanDevice uwbScanDevice) {
        UwbLogUtil.e("Mijia-UWB-timestamp", "UwbLogUtilPlus MitvCardActivity will start");
        Intent intent = new Intent();
        intent.setClass(context, MitvCardActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("UWB_SCAN_DEVICE", uwbScanDevice.toJSON().toString());
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Util.isOwner(this.mMitvCardActivityImpl.getmUwbScanDevice())) {
            initRecycler();
            requestHistory();
            hxi.O00000o0.O00000oo(0);
            return;
        }
        hxi.O00000o0.O00000oo(1);
    }

    public void initUI() {
        super.initUI();
        this.mPlayerLayout = findViewById(R.id.tv_card_player_l);
        this.mHistoryLayout = findViewById(R.id.tv_card_history_l);
        this.mHistoryErrorLayout = findViewById(R.id.tv_card_history_error_l);
        this.mTopLayoutList = new ArrayList();
        this.mTopLayoutList.add(this.mPlayerLayout);
        this.mTopLayoutList.add(this.mHistoryLayout);
        this.mTopLayoutList.add(this.mHistoryErrorLayout);
        this.mPlayerPosterIv = (ImageView) findViewById(R.id.player_poster_iv);
        this.mPlayerTitleTv = (TextView) findViewById(R.id.player_title_tv);
        this.mPlayerCiTv = (TextView) findViewById(R.id.player_ci_tv);
        this.mPlayerSeek = (SeekBar) findViewById(R.id.player_progress_seek);
        this.mPlayerCursorTv = (TextView) findViewById(R.id.player_cursor_tv);
        this.mPlayerDurationTv = (TextView) findViewById(R.id.player_duration_tv);
        this.mPlayerSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /* class com.xiaomi.smarthome.uwb.tv.MitvCardActivity.AnonymousClass3 */

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                UwbLogUtil.w(MitvCardActivity.TAG, "UwbLogUtilPlus onStartTrackingTouch");
                MitvCardActivity.this.mIsStartTrackingTouch = 1;
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                MitvInfo mitvInfo = MitvCardActivity.this.mMitvCardActivityImpl.getmMitvInfo();
                if (mitvInfo != null) {
                    int parseInt = Integer.parseInt(mitvInfo.getmCurVideo().getPosition());
                    UwbLogUtil.w(MitvCardActivity.TAG, "UwbLogUtilPlus mPlayerSeek onStopTrackingTouch: " + seekBar.getProgress() + " postionInt: " + parseInt);
                    long floatValue = (long) ((Float.valueOf(mitvInfo.getmCurVideo().getDuration()).floatValue() * ((float) seekBar.getProgress())) / 100.0f);
                    if (floatValue < 1) {
                        floatValue = 1;
                    }
                    UwbMitvApi.doVideoPosition(mitvInfo.getmCurVideo().getMediaId(), floatValue);
                    hxi.O00000o.O00oOooO();
                    MitvCardActivity.this.refreshSeekBar(mitvInfo, floatValue, true);
                    MitvCardActivity.this.sendStartTrackingTouchHandler();
                    return;
                }
                MitvCardActivity.this.mIsStartTrackingTouch = 0;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void initRecycler() {
        if (this.mHistoryRecycler == null) {
            this.mHistoryRecycler = (RecyclerView) findViewById(R.id.history_recycler);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(0);
            this.mHistoryRecycler.setLayoutManager(linearLayoutManager);
            this.mHistoryRecycler.addItemDecoration(new HorizontalItemDecoration(gpc.O000000o(27.0f), this));
            this.mHistoryAdapter = new HistoryAdapter();
            this.mHistoryRecycler.setAdapter(this.mHistoryAdapter);
        }
    }

    class HistoryAdapter extends BaseRecyclerArrayAdapter<TVInfo.TVItem> {
        HistoryAdapter() {
        }

        public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new HistoryItem(viewGroup, R.layout.history_item);
        }
    }

    class HistoryItem extends BaseViewHolder<TVInfo.TVItem> {
        ImageView mPosterIv = ((ImageView) this.itemView.findViewById(R.id.poster_iv));
        TextView mProgressTv = ((TextView) this.itemView.findViewById(R.id.progress_tv));
        TextView mTitleTv = ((TextView) this.itemView.findViewById(R.id.title_tv));

        public HistoryItem(ViewGroup viewGroup, int i) {
            super(viewGroup, i);
        }

        public void setData(final TVInfo.TVItem tVItem) {
            RequestCreator requestCreator;
            super.setData((Object) tVItem);
            if (TextUtils.isEmpty(tVItem.poster)) {
                requestCreator = Picasso.get().load((int) R.drawable.tv_item_default_img).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).placeholder((int) R.drawable.tv_item_default_img);
            } else {
                requestCreator = Picasso.get().load(tVItem.poster).placeholder((int) R.drawable.tv_item_default_img).error((int) R.drawable.tv_item_default_img).fit().asBitmap().transform(new RoundCornerTransformation());
            }
            requestCreator.into(this.mPosterIv);
            this.mTitleTv.setText(tVItem.title);
            if (1 == tVItem.extra.ci && tVItem.extra.moviepercent < 1.0d) {
                this.mProgressTv.setText(getContext().getString(R.string.mj_uwb_tv_item_progress, Integer.valueOf(tVItem.extra.ci)));
            } else if (tVItem.extra.ci > 1) {
                this.mProgressTv.setText(getContext().getString(R.string.mj_uwb_tv_item_progress, Integer.valueOf(tVItem.extra.ci)));
            } else {
                this.mProgressTv.setText((CharSequence) null);
            }
            this.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.uwb.tv.MitvCardActivity.HistoryItem.AnonymousClass1 */

                public void onClick(View view) {
                    String str = MitvCardActivity.TAG;
                    UwbLogUtil.w(str, "UwbLogUtilPlus doVideoPlay seconds: " + tVItem.extra.seconds);
                    UwbMitvApi.doVideoPlay(tVItem.id, tVItem.title, tVItem.extra.ci, tVItem.extra.seconds, tVItem.source);
                    hzf.O00000oO(HistoryItem.this.itemView);
                    hxi.O00000o.O000O0Oo(HistoryItem.this.getAdapterPosition());
                }
            });
        }
    }

    class RoundCornerTransformation implements Transformation {
        public String key() {
            return "RoundCornerTransformation()";
        }

        RoundCornerTransformation() {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.gpc.O000000o(android.content.Context, float):int
         arg types: [com.xiaomi.smarthome.uwb.tv.MitvCardActivity, int]
         candidates:
          _m_j.gpc.O000000o(android.app.Activity, float):int
          _m_j.gpc.O000000o(android.view.View, int):void
          _m_j.gpc.O000000o(android.content.Context, float):int */
        public Bitmap transform(Bitmap bitmap) {
            return Util.roundCornerImage(bitmap, gpc.O000000o((Context) MitvCardActivity.this, 8.0f));
        }
    }

    public void refreshUI() {
        super.refreshUI();
        MitvInfo mitvInfo = this.mMitvCardActivityImpl.getmMitvInfo();
        if (Util.isMitvPlaying(mitvInfo)) {
            refreshPlayerLayout(mitvInfo);
        } else if (Util.isOwner(this.mMitvCardActivityImpl.getmUwbScanDevice()) && this.mHistoryLayout.getVisibility() != 0) {
            HistoryAdapter historyAdapter = this.mHistoryAdapter;
            if (historyAdapter != null && historyAdapter.getItemCount() > 0) {
                hxi.O00000o0.O00000oO();
                showTopLayout(this.mHistoryLayout);
            }
            requestHistory();
        } else if (this.mPlayerLayout.getVisibility() == 0) {
            this.mPlayerLayout.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public void requestHistory() {
        this.mHistoryCB = new fde<TVInfo, fdg>() {
            /* class com.xiaomi.smarthome.uwb.tv.MitvCardActivity.AnonymousClass4 */

            public void onSuccess(TVInfo tVInfo) {
                UwbLogUtil.w(MitvCardActivity.TAG, "UwbLogUtilPlus onSuccess tryTvMediaList");
                if (Util.isActivityValid(MitvCardActivity.this)) {
                    String str = MitvCardActivity.TAG;
                    UwbLogUtil.w(str, "UwbLogUtilPlus showHistoryLayout: " + tVInfo.uc.size());
                    if (tVInfo.uc.size() > 0 && MitvCardActivity.this.mPlayerLayout.getVisibility() != 0) {
                        hxi.O00000o0.O00000oO();
                        MitvCardActivity mitvCardActivity = MitvCardActivity.this;
                        mitvCardActivity.showTopLayout(mitvCardActivity.mHistoryLayout);
                        MitvCardActivity.this.mHistoryAdapter.setData(tVInfo.uc);
                    }
                }
            }

            public void onFailure(fdg fdg) {
                String str = MitvCardActivity.TAG;
                UwbLogUtil.w(str, "UwbLogUtilPlus onFailure tryTvMediaList: " + fdg.O000000o());
                if (Util.isActivityValid(MitvCardActivity.this) && -999 == fdg.O000000o() && MitvCardActivity.this.mPlayerLayout.getVisibility() != 0) {
                    MitvCardActivity mitvCardActivity = MitvCardActivity.this;
                    mitvCardActivity.showTopLayout(mitvCardActivity.mHistoryErrorLayout);
                }
            }
        };
        String str = TAG;
        UwbLogUtil.w(str, "UwbLogUtilPlus requestHistory xiaomi account: " + CoreApi.O000000o().O0000o0());
        TVRemoteApi.tryMediaList(CoreApi.O000000o().O0000o0(), null, this.mHistoryCB);
    }

    public void onPlayerPosNotify(MitvInfo mitvInfo) {
        if (mitvInfo != null && mitvInfo.getmCurVideo() != null) {
            long postionL = mitvInfo.getmCurVideo().getPostionL();
            String str = TAG;
            UwbLogUtil.w(str, "uwbLogUtilPlus onPlayerPosNotify curPosL: " + postionL + " mLastVideoInfoPos: " + this.mLastVideoInfoPos + " mSeekTime: " + this.mSeekTime);
            long j = this.mLastVideoInfoPos;
            boolean z = true;
            if (j == postionL) {
                refreshSeekBar(mitvInfo, j, true);
                releaseSeekBarHandler();
                return;
            }
            this.mLastVideoInfoPos = postionL;
            long j2 = this.mSeekTime;
            if (postionL < j2 && j2 - postionL < 5000) {
                UwbLogUtil.w(TAG, "uwbLogUtilPlus onPlayerPosNotify curPosL < mSeekTime");
                if (!TextUtils.equals(Util.getPlayerDuration(this.mSeekTime), Util.getPlayerDuration(postionL))) {
                    z = false;
                }
            }
            if (z && refreshSeekBar(mitvInfo, postionL, false)) {
                sendSeekBarHandler(4096);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean refreshSeekBar(MitvInfo mitvInfo, long j, boolean z) {
        if (isFinishing() || isDestroyed() || mitvInfo == null || mitvInfo.getmCurVideo() == null || j < 0) {
            return false;
        }
        String str = TAG;
        UwbLogUtil.w(str, "uwbLogUtilPlus refreshSeekBar refreshTime: " + j + " mSeekTime: " + this.mSeekTime + " mIsStartTrackingTouch: " + this.mIsStartTrackingTouch + " forceRefresh: " + z);
        if (!z && this.mIsStartTrackingTouch != 0 && (2 != this.mIsStartTrackingTouch || Math.abs(j - this.mSeekTime) >= 5000)) {
            return false;
        }
        this.mSeekTime = j;
        this.mPlayerSeek.setProgress((int) getPostionFloat(mitvInfo.getmCurVideo()));
        String str2 = TAG;
        UwbLogUtil.w(str2, "uwbLogUtilPlus refreshSeekBar: " + Util.getPlayerDuration(this.mSeekTime));
        this.mPlayerCursorTv.setText(Util.getPlayerDuration(this.mSeekTime));
        return true;
    }

    public float getPostionFloat(VideoInfo videoInfo) {
        return ((float) (this.mSeekTime * 100)) / Float.parseFloat(videoInfo.getDuration());
    }

    /* access modifiers changed from: package-private */
    public void refreshPlayerLayout(MitvInfo mitvInfo) {
        UwbLogUtil.w(TAG, "UwbLogUtilPlus refreshPlayerLayout");
        hxi.O00000o0.O00000o();
        showTopLayout(this.mPlayerLayout);
        VideoInfo videoInfo = mitvInfo.getmCurVideo();
        onPlayerPosNotify(mitvInfo);
        this.mPlayerTitleTv.setText(videoInfo.getMediaName());
        this.mPlayerCiTv.setText(getString(R.string.mj_uwb_tv_player_progress, new Object[]{videoInfo.getCi()}));
        this.mPlayerDurationTv.setText(Util.getPlayerDuration(Long.parseLong(videoInfo.getDuration())));
        this.mPlayerCB = new fde<TVInfo, fdg>() {
            /* class com.xiaomi.smarthome.uwb.tv.MitvCardActivity.AnonymousClass5 */

            public void onSuccess(TVInfo tVInfo) {
                UwbLogUtil.w(MitvCardActivity.TAG, "UwbLogUtilPlus refreshPlayerPoster success");
                if (Util.isActivityValid(MitvCardActivity.this)) {
                    String str = MitvCardActivity.TAG;
                    UwbLogUtil.w(str, "UwbLogUtilPlus refreshPlayerPoster: " + tVInfo.medias.size());
                    if (MitvCardActivity.this.mPlayerLayout.getVisibility() == 0 && tVInfo.medias.size() > 0) {
                        MitvCardActivity.this.refreshPlayerPoster(tVInfo.medias.get(0));
                    }
                }
            }

            public void onFailure(fdg fdg) {
                String str = MitvCardActivity.TAG;
                UwbLogUtil.w(str, "UwbLogUtilPlus refreshPlayerPoster onFailure: " + fdg.O000000o());
            }
        };
        if (!TextUtils.equals(this.mLastMediaId, videoInfo.getMediaId())) {
            TVRemoteApi.tryMediaList(null, videoInfo.getMediaId(), this.mPlayerCB);
            this.mLastMediaId = videoInfo.getMediaId();
        }
    }

    /* access modifiers changed from: package-private */
    public void showTopLayout(View view) {
        for (View next : this.mTopLayoutList) {
            if (next == view) {
                if (next.getVisibility() != 0) {
                    next.setVisibility(0);
                }
            } else if (next.getVisibility() != 8) {
                next.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void refreshPlayerPoster(TVInfo.TVItem tVItem) {
        RequestCreator requestCreator;
        if (TextUtils.isEmpty(tVItem.poster)) {
            requestCreator = Picasso.get().load((int) R.drawable.tv_item_default_img).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).placeholder((int) R.drawable.tv_item_default_img);
        } else {
            requestCreator = Picasso.get().load(tVItem.poster).placeholder((int) R.drawable.tv_item_default_img).error((int) R.drawable.tv_item_default_img).fit().asBitmap().transform(new RoundCornerTransformation());
        }
        requestCreator.into(this.mPlayerPosterIv);
    }

    public void onDestroy() {
        super.onDestroy();
        releaseSeekBarHandler();
        releaseStartTrackingTouchHandler();
    }

    /* access modifiers changed from: package-private */
    public void sendSeekBarHandler(int i) {
        this.mSeekBarHandler.removeCallbacksAndMessages(null);
        this.mSeekBarHandler.sendEmptyMessageDelayed(i, 700);
    }

    /* access modifiers changed from: package-private */
    public void releaseSeekBarHandler() {
        this.mSeekBarHandler.removeCallbacksAndMessages(null);
    }

    /* access modifiers changed from: package-private */
    public void sendStartTrackingTouchHandler() {
        this.mIsStartTrackingTouch = 2;
        String str = TAG;
        UwbLogUtil.w(str, "UwbLogUtilPlus sendStartTrackingTouchHandler: " + this.mIsStartTrackingTouch);
        this.mStartTrackingTouchHandler.removeCallbacksAndMessages(null);
        this.mStartTrackingTouchHandler.sendEmptyMessageDelayed(8192, 10000);
    }

    /* access modifiers changed from: package-private */
    public void releaseStartTrackingTouchHandler() {
        this.mIsStartTrackingTouch = 0;
        this.mStartTrackingTouchHandler.removeCallbacksAndMessages(null);
    }
}

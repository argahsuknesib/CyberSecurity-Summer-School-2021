package com.xiaomi.smarthome.uwb.mico;

import _m_j.dcp;
import _m_j.ee;
import _m_j.fa;
import _m_j.fh;
import _m_j.fm;
import _m_j.fno;
import _m_j.fo;
import _m_j.ggb;
import _m_j.ggw;
import _m_j.gsy;
import _m_j.hfa;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxp;
import _m_j.hzf;
import _m_j.hzq;
import _m_j.ixc;
import _m_j.ixe;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.common.schema.SchemaManager;
import com.xiaomi.mico.common.schema.handler.HomepageSchemaHandler;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.miplay.audioclient.MiPlayDevice;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.controls.AllReadyCallback;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.mico.MicoHelper;
import com.xiaomi.smarthome.uwb.lib.data.DidInfo;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import com.xiaomi.smarthome.uwb.mico.Command;
import com.xiaomi.smarthome.uwb.ui.UwbBaseActivity;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\n\u0010&\u001a\u0004\u0018\u00010%H\u0002J\u0012\u0010'\u001a\u00020 2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010*\u001a\u00020 2\b\u0010+\u001a\u0004\u0018\u00010,H\u0015J\b\u0010-\u001a\u00020 H\u0014J\u0010\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020\u000eH\u0016J\b\u00100\u001a\u00020 H\u0002J\u0018\u00101\u001a\u00020 2\u000e\u00102\u001a\n\u0012\u0004\u0012\u000204\u0018\u000103H\u0002J\u0018\u00105\u001a\u00020 2\u000e\u00106\u001a\n\u0012\u0004\u0012\u000207\u0018\u000103H\u0002J\u0012\u00108\u001a\u00020 2\b\u00109\u001a\u0004\u0018\u00010%H\u0002J\u0010\u0010:\u001a\u00020 2\u0006\u0010;\u001a\u00020<H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006>"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/UwbMicoActivity;", "Lcom/xiaomi/smarthome/uwb/ui/UwbBaseActivity;", "Landroid/view/View$OnClickListener;", "()V", "lastModifyVolumeActionTime", "", "getLastModifyVolumeActionTime", "()J", "setLastModifyVolumeActionTime", "(J)V", "lastPlayOrPauseActionTime", "getLastPlayOrPauseActionTime", "setLastPlayOrPauseActionTime", "mNeedLog", "", "getMNeedLog", "()Z", "setMNeedLog", "(Z)V", "mUwbMicoPlayerViewModel", "Lcom/xiaomi/smarthome/uwb/mico/UwbMicoPlayerViewModel;", "getMUwbMicoPlayerViewModel", "()Lcom/xiaomi/smarthome/uwb/mico/UwbMicoPlayerViewModel;", "mUwbScanDevice", "Lcom/xiaomi/smarthome/uwb/lib/data/UwbScanDevice;", "recentRecommendLatch", "Ljava/util/concurrent/CountDownLatch;", "getRecentRecommendLatch", "()Ljava/util/concurrent/CountDownLatch;", "setRecentRecommendLatch", "(Ljava/util/concurrent/CountDownLatch;)V", "initView", "", "launchPlugin", "activity", "Landroid/app/Activity;", "device", "Lcom/xiaomi/smarthome/device/Device;", "matchDevice", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onWindowFocusChanged", "hasFocus", "playOrPause", "renderRecentSongs", "songs", "", "Lcom/xiaomi/mico/api/model/Music$Song;", "renderRecommendSongs", "item", "Lcom/xiaomi/mico/api/model/PatchWall$Item;", "updatePlainDid", "first", "updateRelayImage", "type", "", "Companion", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbMicoActivity extends UwbBaseActivity implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    private long lastModifyVolumeActionTime;
    private long lastPlayOrPauseActionTime;
    private boolean mNeedLog = true;
    private UwbScanDevice mUwbScanDevice;
    private CountDownLatch recentRecommendLatch = new CountDownLatch(2);

    public final void _$_clearFindViewByIdCache() {
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/UwbMicoActivity$Companion;", "", "()V", "RELAY_DISABLE", "", "RELAY_HIGHLIGHT", "RELAY_NORMAL", "TAG", "", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(ixc ixc) {
            this();
        }

        private Companion() {
        }
    }

    public final UwbMicoPlayerViewModel getMUwbMicoPlayerViewModel() {
        fm O000000o2 = fo.O000000o(this).O000000o(UwbMicoPlayerViewModel.class);
        ixe.O00000Oo(O000000o2, "of(this).get(UwbMicoPlayerViewModel::class.java)");
        return (UwbMicoPlayerViewModel) O000000o2;
    }

    public final long getLastPlayOrPauseActionTime() {
        return this.lastPlayOrPauseActionTime;
    }

    public final void setLastPlayOrPauseActionTime(long j) {
        this.lastPlayOrPauseActionTime = j;
    }

    public final long getLastModifyVolumeActionTime() {
        return this.lastModifyVolumeActionTime;
    }

    public final void setLastModifyVolumeActionTime(long j) {
        this.lastModifyVolumeActionTime = j;
    }

    public final CountDownLatch getRecentRecommendLatch() {
        return this.recentRecommendLatch;
    }

    public final void setRecentRecommendLatch(CountDownLatch countDownLatch) {
        ixe.O00000o(countDownLatch, "<set-?>");
        this.recentRecommendLatch = countDownLatch;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setNavigationBarColor(getColor(17170444));
        setContentView((int) R.layout.activity_uwb_mico);
        this.mUwbScanDevice = (UwbScanDevice) getIntent().getParcelableExtra("uwb_scan_device");
        UwbLogUtil.d("Mijia-UWB-UwbMicoActivity", "onCreate");
        PluginDeviceManager pluginDeviceManager = PluginDeviceManager.instance;
        UwbScanDevice uwbScanDevice = this.mUwbScanDevice;
        Integer valueOf = uwbScanDevice == null ? null : Integer.valueOf((int) uwbScanDevice.getPid());
        ixe.O000000o(valueOf);
        String modelByProductId = pluginDeviceManager.getModelByProductId(valueOf.intValue());
        if (this.mUwbScanDevice == null || TextUtils.isEmpty(modelByProductId)) {
            LogType logType = LogType.LOG_UWB;
            gsy.O000000o(logType, "", 6, "zxtMijia-UWB-UwbMicoActivity", "mUwbScanDevice: " + this.mUwbScanDevice + " , model: " + ((Object) modelByProductId));
            finish();
            return;
        }
        UwbScanDevice uwbScanDevice2 = this.mUwbScanDevice;
        ixe.O000000o(uwbScanDevice2);
        uwbScanDevice2.getDidInfo().setPlainDid("");
        MicoHelper.O000000o(CommonApplication.getAppContext());
        new AllReadyCallback(6, new Runnable() {
            /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$UwbMicoActivity$gkKyVTJ3gBVMPicAYf4Wn_BK50 */

            public final void run() {
                UwbMicoActivity.m526onCreate$lambda1(UwbMicoActivity.this);
            }
        });
        startShowAni(findViewById(R.id.player_recent_recommend), (RelativeLayout) findViewById(R.id.player_card));
        getMUwbMicoPlayerViewModel().setUwbScanDevice(this.mUwbScanDevice);
        fa faVar = this;
        getMUwbMicoPlayerViewModel().getBaseController().observe(faVar, new fh() {
            /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$UwbMicoActivity$dHPPSE0kWL02IgpgFjDCVtsh7uA */

            public final void onChanged(Object obj) {
                UwbMicoActivity.m527onCreate$lambda3(UwbMicoActivity.this, (BaseControl) obj);
            }
        });
        getMUwbMicoPlayerViewModel().getContents().observe(faVar, new fh() {
            /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$UwbMicoActivity$TOqjAsYLuhbA4XHwtWdJ_yFMLz0 */

            public final void onChanged(Object obj) {
                UwbMicoActivity.m528onCreate$lambda6(UwbMicoActivity.this, (ContentInfo) obj);
            }
        });
        getMUwbMicoPlayerViewModel().getMiPlayDeviceLiveData().observe(faVar, new fh() {
            /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$UwbMicoActivity$BtkgOwZOji3mqm6KRSNpiIIlnc */

            public final void onChanged(Object obj) {
                UwbMicoActivity.m529onCreate$lambda8(UwbMicoActivity.this, (MiPlayDevice) obj);
            }
        });
        dcp.O000000o().O00000Oo(true);
        UwbLogUtil.d("Mijia-UWB-UwbMicoActivity", "onCreate");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m526onCreate$lambda1(UwbMicoActivity uwbMicoActivity) {
        ixe.O00000o(uwbMicoActivity, "this$0");
        Device matchDevice = uwbMicoActivity.matchDevice();
        if (matchDevice == null) {
            matchDevice = null;
        } else {
            uwbMicoActivity.updatePlainDid(matchDevice);
        }
        if (matchDevice == null) {
            Home O00000o = ggb.O00000Oo().O00000o(hzq.O0000O0o(uwbMicoActivity.mUwbScanDevice));
            if (O00000o == null || O00000o.isOwner()) {
                uwbMicoActivity.updatePlainDid(matchDevice);
                return;
            }
            gsy.O000000o(LogType.LOG_UWB, "", 4, "zxtMijia-UWB-UwbMicoActivity", ixe.O000000o("共享家庭 ", (Object) O00000o.getId()));
            ggw O000000o2 = ggw.O000000o();
            String id = O00000o.getId();
            ixe.O00000Oo(id, "home.id");
            O000000o2.O000000o(Long.parseLong(id), new UwbMicoActivity$onCreate$1$1(uwbMicoActivity, matchDevice));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.Integer]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-3  reason: not valid java name */
    public static final void m527onCreate$lambda3(UwbMicoActivity uwbMicoActivity, BaseControl baseControl) {
        ixe.O00000o(uwbMicoActivity, "this$0");
        if (baseControl != null) {
            gsy.O000000o(LogType.LOG_UWB, "", 4, "zxtMijia-UWB-UwbMicoActivity", ixe.O000000o("基础控制更新 status = ", (Object) Integer.valueOf(baseControl.getStatus())));
            ((LinearLayout) uwbMicoActivity.findViewById(R.id.player_control_container)).setAlpha(1.0f);
            if (uwbMicoActivity.getLastModifyVolumeActionTime() == 0 || System.currentTimeMillis() - uwbMicoActivity.getLastModifyVolumeActionTime() >= 800) {
                ((VolumeBar) uwbMicoActivity.findViewById(R.id.player_volume_bar)).setProgress(baseControl.getVolume());
            }
            if (uwbMicoActivity.getLastPlayOrPauseActionTime() == 0 || System.currentTimeMillis() - uwbMicoActivity.getLastPlayOrPauseActionTime() >= 800) {
                if (baseControl.getStatus() == 1) {
                    ((ImageView) uwbMicoActivity.findViewById(R.id.player_play)).setImageResource(R.drawable.uwb_mico_icon_pause_selector);
                } else {
                    ((ImageView) uwbMicoActivity.findViewById(R.id.player_play)).setImageResource(R.drawable.uwb_mico_icon_play_selector);
                }
                ((ImageView) uwbMicoActivity.findViewById(R.id.player_play)).setTag(Integer.valueOf(baseControl.getStatus()));
                View findViewById = uwbMicoActivity.findViewById(R.id.player_progress_bar);
                UwbMicoProgressBar uwbMicoProgressBar = findViewById instanceof UwbMicoProgressBar ? (UwbMicoProgressBar) findViewById : null;
                if (uwbMicoProgressBar != null) {
                    uwbMicoProgressBar.setMStatus(baseControl.getStatus());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ed  */
    /* renamed from: onCreate$lambda-6  reason: not valid java name */
    public static final void m528onCreate$lambda6(UwbMicoActivity uwbMicoActivity, ContentInfo contentInfo) {
        Music.Song song;
        String str;
        Remote.Response.PlayerStatus playerStatus;
        ixe.O00000o(uwbMicoActivity, "this$0");
        gsy.O000000o(LogType.LOG_UWB, "", 4, "zxtMijia-UWB-UwbMicoActivity", "内容播放更新");
        View findViewById = uwbMicoActivity.findViewById(R.id.player_progress_bar);
        Music.Song song2 = null;
        UwbMicoProgressBar uwbMicoProgressBar = findViewById instanceof UwbMicoProgressBar ? (UwbMicoProgressBar) findViewById : null;
        if (uwbMicoProgressBar != null) {
            uwbMicoProgressBar.updateProgress((contentInfo == null || (playerStatus = contentInfo.getPlayerStatus()) == null) ? null : playerStatus.play_song_detail);
        }
        ee supportFragmentManager = uwbMicoActivity.getSupportFragmentManager();
        ixe.O00000Oo(supportFragmentManager, "supportFragmentManager");
        Fragment O000000o2 = supportFragmentManager.O000000o((int) R.id.lrc_view);
        if (O000000o2 != null) {
            UwbMicoLrcFragment uwbMicoLrcFragment = (UwbMicoLrcFragment) O000000o2;
            uwbMicoActivity.findViewById(R.id.player_recent_recommend).setTag(Boolean.TRUE);
            if (!(contentInfo == null || (song = contentInfo.getSong()) == null)) {
                Remote.Response.PlayingData playingData = contentInfo.getPlayerStatus().play_song_detail;
                Long valueOf = playingData == null ? null : Long.valueOf(playingData.position);
                uwbMicoLrcFragment.updatePlayingMusic(song, valueOf == null ? 0 : (int) valueOf.longValue());
                Remote.Response.PlayerStatus playerStatus2 = contentInfo.getPlayerStatus();
                ((RelativeLayout) uwbMicoActivity.findViewById(R.id.progress_start_end_time)).setVisibility(0);
                if (playerStatus2 instanceof MiPlayStreamPlayerStatus) {
                    MiPlayStreamPlayerStatus miPlayStreamPlayerStatus = (MiPlayStreamPlayerStatus) playerStatus2;
                    if (miPlayStreamPlayerStatus.getBitmap() != null) {
                        Bitmap bitmap = miPlayStreamPlayerStatus.getBitmap();
                        Boolean valueOf2 = bitmap == null ? null : Boolean.valueOf(bitmap.isRecycled());
                        ixe.O000000o(valueOf2);
                        if (valueOf2.booleanValue()) {
                            ((ImageView) uwbMicoActivity.findViewById(R.id.player_cover)).setBackgroundResource(R.drawable.uwb_mico_shape_cover_bg);
                        } else {
                            ((ImageView) uwbMicoActivity.findViewById(R.id.player_cover)).setImageBitmap(miPlayStreamPlayerStatus.getBitmap());
                        }
                        TextView textView = (TextView) uwbMicoActivity.findViewById(R.id.player_name);
                        str = song.name;
                        if (str == null) {
                            str = uwbMicoActivity.getString(R.string.mico_music_directive_default_title);
                        }
                        textView.setText(str);
                        ((TextView) uwbMicoActivity.findViewById(R.id.player_cp)).setVisibility(0);
                        ((TextView) uwbMicoActivity.findViewById(R.id.player_cp)).setText(((Object) song.artistDisplayName) + " - " + ((Object) song.albumName));
                        ((LinearLayout) uwbMicoActivity.findViewById(R.id.player_control_container)).setAlpha(1.0f);
                        ((SeekBar) uwbMicoActivity.findViewById(R.id.player_control_bar_progress_seek)).setThumb(uwbMicoActivity.getResources().getDrawable(R.drawable.uwb_mico_shape_bg_seek_bar_thumb));
                        uwbMicoActivity.findViewById(R.id.player_recent_recommend).setVisibility(8);
                    }
                }
                MusicHelper.loadCover(song.coverURL, (ImageView) uwbMicoActivity.findViewById(R.id.player_cover), R.drawable.uwb_mico_shape_cover_bg, 10);
                TextView textView2 = (TextView) uwbMicoActivity.findViewById(R.id.player_name);
                str = song.name;
                if (str == null) {
                }
                textView2.setText(str);
                ((TextView) uwbMicoActivity.findViewById(R.id.player_cp)).setVisibility(0);
                ((TextView) uwbMicoActivity.findViewById(R.id.player_cp)).setText(((Object) song.artistDisplayName) + " - " + ((Object) song.albumName));
                ((LinearLayout) uwbMicoActivity.findViewById(R.id.player_control_container)).setAlpha(1.0f);
                ((SeekBar) uwbMicoActivity.findViewById(R.id.player_control_bar_progress_seek)).setThumb(uwbMicoActivity.getResources().getDrawable(R.drawable.uwb_mico_shape_bg_seek_bar_thumb));
                uwbMicoActivity.findViewById(R.id.player_recent_recommend).setVisibility(8);
            }
            if (contentInfo != null) {
                song2 = contentInfo.getSong();
            }
            if (song2 == null) {
                ((TextView) uwbMicoActivity.findViewById(R.id.player_cp)).setVisibility(8);
                ((TextView) uwbMicoActivity.findViewById(R.id.player_name)).setText(uwbMicoActivity.getString(R.string.uwb_mico_can_not_get_audio));
                ((ImageView) uwbMicoActivity.findViewById(R.id.player_cover)).setBackgroundResource(R.drawable.uwb_mico_shape_cover_bg);
                UwbScanDevice uwbScanDevice = uwbMicoActivity.mUwbScanDevice;
                ixe.O000000o(uwbScanDevice);
                String plainDid = uwbScanDevice.getDidInfo().getPlainDid();
                ixe.O00000Oo(plainDid, "mUwbScanDevice!!.didInfo.plainDid");
                Device device = UwbMicoActivityKt.getDevice(plainDid);
                if (device != null && device.isOnline) {
                    ((SeekBar) uwbMicoActivity.findViewById(R.id.player_control_bar_progress_seek)).setThumb(uwbMicoActivity.getResources().getDrawable(R.drawable.uwb_mico_shape_bg_seek_bar_thumb1));
                    if (uwbMicoActivity.getRecentRecommendLatch().getCount() < 2 && uwbMicoActivity.findViewById(R.id.player_recent_recommend).getVisibility() != 0) {
                        uwbMicoActivity.findViewById(R.id.player_recent_recommend).setVisibility(0);
                        hxi.O00000o0.O00000o0();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.uwb.mico.UwbMicoLrcFragment");
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-8  reason: not valid java name */
    public static final void m529onCreate$lambda8(UwbMicoActivity uwbMicoActivity, MiPlayDevice miPlayDevice) {
        ixe.O00000o(uwbMicoActivity, "this$0");
        if (miPlayDevice != null) {
            LogType logType = LogType.LOG_UWB;
            gsy.O000000o(logType, "", 4, "zxtMijia-UWB-UwbMicoActivity", "MiPlayDeviceUpdate " + ((Object) miPlayDevice.O00000Oo) + ' ' + ((Object) miPlayDevice.f6039O000000o) + ' ' + UwbMicoPlayerManagerKt.getRelayType(miPlayDevice));
            uwbMicoActivity.updateRelayImage(UwbMicoPlayerManagerKt.getRelayType(miPlayDevice));
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        dcp.O000000o().O00000Oo(false);
        UwbLogUtil.d("Mijia-UWB-UwbMicoActivity", "onDestroy");
    }

    public final void updatePlainDid(Device device) {
        String str;
        UwbScanDevice uwbScanDevice = this.mUwbScanDevice;
        ixe.O000000o(uwbScanDevice);
        DidInfo didInfo = uwbScanDevice.getDidInfo();
        String str2 = "";
        if (!(device == null || (str = device.did) == null)) {
            str2 = str;
        }
        didInfo.setPlainDid(str2);
        UwbMicoPlayerViewModel mUwbMicoPlayerViewModel = getMUwbMicoPlayerViewModel();
        UwbScanDevice uwbScanDevice2 = this.mUwbScanDevice;
        ixe.O000000o(uwbScanDevice2);
        mUwbMicoPlayerViewModel.updateCurrentMico(uwbScanDevice2);
        initView();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004b A[EDGE_INSN: B:14:0x004b->B:11:0x004b ?: BREAK  , SYNTHETIC] */
    public final Device matchDevice() {
        Object obj;
        boolean z;
        Iterator it = fno.O000000o().O00000oO().values().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Device device = (Device) obj;
            if (TextUtils.equals("speaker", hfa.O00000Oo(device))) {
                UwbScanDevice uwbScanDevice = this.mUwbScanDevice;
                ixe.O000000o(uwbScanDevice);
                if (UwbDeviceUtil.isUwbHashEnd(uwbScanDevice.getDidInfo().getDid(), device.did)) {
                    z = true;
                    continue;
                    if (z) {
                        break;
                    }
                }
            }
            z = false;
            continue;
            if (z) {
            }
        }
        return (Device) obj;
    }

    private final void initView() {
        int i;
        String str;
        ((VolumeBar) findViewById(R.id.player_volume_bar)).setOnSeekBarChangeListener(new UwbMicoActivity$initView$1(this));
        UwbScanDevice uwbScanDevice = this.mUwbScanDevice;
        ixe.O000000o(uwbScanDevice);
        String plainDid = uwbScanDevice.getDidInfo().getPlainDid();
        ixe.O00000Oo(plainDid, "mUwbScanDevice!!.didInfo.plainDid");
        Device device = UwbMicoActivityKt.getDevice(plainDid);
        if (device != null) {
            TextView textView = (TextView) findViewById(R.id.device_name);
            if (device.isOnline) {
                str = device.name;
            } else {
                str = device.name + '(' + getString(R.string.offline_device) + ')';
            }
            textView.setText(str);
            if (device.isOnline) {
                fa faVar = this;
                getMUwbMicoPlayerViewModel().getRecentSongs().observe(faVar, new fh() {
                    /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$UwbMicoActivity$Ielcak0IG6oIGCmZAdNGRD8fCA */

                    public final void onChanged(Object obj) {
                        UwbMicoActivity.m521initView$lambda12$lambda10(UwbMicoActivity.this, (List) obj);
                    }
                });
                getMUwbMicoPlayerViewModel().getRecommendSongs().observe(faVar, new fh() {
                    /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$UwbMicoActivity$uXQbFwovQHb5k45RpCid0pSezEo */

                    public final void onChanged(Object obj) {
                        UwbMicoActivity.m522initView$lambda12$lambda11(UwbMicoActivity.this, (List) obj);
                    }
                });
            } else {
                ((LinearLayout) findViewById(R.id.player_control_container)).setAlpha(0.3f);
            }
        }
        if (device == null) {
            ((LinearLayout) findViewById(R.id.player_control_container)).setAlpha(0.3f);
        }
        UwbScanDevice uwbScanDevice2 = this.mUwbScanDevice;
        Integer num = null;
        Integer valueOf = uwbScanDevice2 == null ? null : Integer.valueOf(uwbScanDevice2.getDeviceType());
        if (valueOf != null && valueOf.intValue() == 1 && UwbMicoPlayerManager.INSTANCE.getMMiplayDisable()) {
            ((ImageView) findViewById(R.id.relay_image)).setVisibility(0);
        }
        updateRelayImage(0);
        if (device != null) {
            ((TextView) findViewById(R.id.enter_Plugin)).setVisibility(0);
            findViewById(R.id.divider).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.enter_Plugin)).setVisibility(8);
            findViewById(R.id.divider).setVisibility(8);
        }
        int i2 = -1;
        if (device == null) {
            i = -1;
        } else {
            i = device.isOnline ? 1 : 2;
        }
        if (device != null) {
            i2 = device.isOwner() ? 1 : 2;
        }
        PluginDeviceManager pluginDeviceManager = PluginDeviceManager.instance;
        UwbScanDevice uwbScanDevice3 = this.mUwbScanDevice;
        if (uwbScanDevice3 != null) {
            num = Integer.valueOf((int) uwbScanDevice3.getPid());
        }
        ixe.O000000o(num);
        String modelByProductId = pluginDeviceManager.getModelByProductId(num.intValue());
        hxp hxp = hxi.O00000o0;
        UwbScanDevice uwbScanDevice4 = this.mUwbScanDevice;
        ixe.O000000o(uwbScanDevice4);
        hxp.f957O000000o.O000000o("uwb_mico_view", "online_status", Integer.valueOf(i), "device_model_0", modelByProductId, "uwbdevice_type", Integer.valueOf(uwbScanDevice4.getDeviceType()), "user_auth", Integer.valueOf(i2));
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-12$lambda-10  reason: not valid java name */
    public static final void m521initView$lambda12$lambda10(UwbMicoActivity uwbMicoActivity, List list) {
        ixe.O00000o(uwbMicoActivity, "this$0");
        uwbMicoActivity.renderRecentSongs(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-12$lambda-11  reason: not valid java name */
    public static final void m522initView$lambda12$lambda11(UwbMicoActivity uwbMicoActivity, List list) {
        ixe.O00000o(uwbMicoActivity, "this$0");
        uwbMicoActivity.renderRecommendSongs(list);
    }

    private final void updateRelayImage(int i) {
        if (i == 0) {
            ((ImageView) findViewById(R.id.relay_image)).setAlpha(0.2f);
            ((ImageView) findViewById(R.id.relay_image)).setImageResource(R.drawable.uwb_mico_icon_music_relay_normal);
        } else if (i == 1) {
            ((ImageView) findViewById(R.id.relay_image)).setAlpha(1.0f);
            ((ImageView) findViewById(R.id.relay_image)).setImageResource(R.drawable.uwb_mico_icon_music_relay_normal);
        } else if (i == 2) {
            ((ImageView) findViewById(R.id.relay_image)).setAlpha(1.0f);
            ((ImageView) findViewById(R.id.relay_image)).setImageResource(R.drawable.uwb_mico_icon_music_relay_highlight);
        }
        ((ImageView) findViewById(R.id.relay_image)).setTag(Integer.valueOf(i));
    }

    private final void renderRecentSongs(List<? extends Music.Song> list) {
        if ((list == null ? 0 : list.size()) > 0) {
            ((LinearLayout) findViewById(R.id.recentGroup)).setVisibility(0);
            ContentInfo value = getMUwbMicoPlayerViewModel().getContents().getValue();
            if ((value == null ? null : value.getSong()) != null || !ixe.O000000o(findViewById(R.id.player_recent_recommend).getTag(), Boolean.TRUE)) {
                this.recentRecommendLatch.countDown();
            } else if (findViewById(R.id.player_recent_recommend).getVisibility() != 0) {
                findViewById(R.id.player_recent_recommend).setVisibility(0);
                hxi.O00000o0.O00000o0();
            }
        } else {
            ((LinearLayout) findViewById(R.id.recentGroup)).setVisibility(4);
        }
        ((ImageView) findViewById(R.id.recentBg)).setOnClickListener(new View.OnClickListener(list) {
            /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$UwbMicoActivity$Uzxw333XCybU9jXVo_TQDOdyUHs */
            private final /* synthetic */ List f$0;

            {
                this.f$0 = r1;
            }

            public final void onClick(View view) {
                UwbMicoActivity.m530renderRecentSongs$lambda13(this.f$0, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: renderRecentSongs$lambda-13  reason: not valid java name */
    public static final void m530renderRecentSongs$lambda13(List list, View view) {
        hzf.O00000oO(view);
        MusicHelper.playSongs(list, 0, null);
        hxi.O00000o.O0000ooO(3);
    }

    private final void renderRecommendSongs(List<? extends PatchWall.Item> list) {
        PatchWall.Item item;
        PatchWall.Item item2;
        PatchWall.Poster poster;
        PatchWall.Poster poster2;
        if ((list == null ? 0 : list.size()) == 2) {
            Music.Song song = null;
            if (list == null) {
                item = null;
            } else {
                item = (PatchWall.Item) list.get(0);
            }
            if (list == null) {
                item2 = null;
            } else {
                item2 = (PatchWall.Item) list.get(1);
            }
            ((LinearLayout) findViewById(R.id.recommendGroup1)).setVisibility(0);
            ((LinearLayout) findViewById(R.id.recommendGroup2)).setVisibility(0);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.recommendBg1);
            PatchWall.Image image = item == null ? null : item.images;
            simpleDraweeView.setImageURI((image == null || (poster2 = image.poster) == null) ? null : poster2.url);
            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) findViewById(R.id.recommendBg2);
            PatchWall.Image image2 = item2 == null ? null : item2.images;
            simpleDraweeView2.setImageURI((image2 == null || (poster = image2.poster) == null) ? null : poster.url);
            ((TextView) findViewById(R.id.recommendTitle1)).setText(item == null ? null : item.title);
            ((TextView) findViewById(R.id.recommendTitle2)).setText(item2 == null ? null : item2.title);
            ((SimpleDraweeView) findViewById(R.id.recommendBg1)).setOnClickListener(new View.OnClickListener(item) {
                /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$UwbMicoActivity$3yRrFtIoWuiTNab2JjhKDpW2Ums */
                private final /* synthetic */ PatchWall.Item f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    UwbMicoActivity.m531renderRecommendSongs$lambda14(UwbMicoActivity.this, this.f$1, view);
                }
            });
            ((SimpleDraweeView) findViewById(R.id.recommendBg2)).setOnClickListener(new View.OnClickListener(item2) {
                /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$UwbMicoActivity$SAgfKmnCakNmW0WM5gHpTcaGxcs */
                private final /* synthetic */ PatchWall.Item f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    UwbMicoActivity.m532renderRecommendSongs$lambda15(UwbMicoActivity.this, this.f$1, view);
                }
            });
            ContentInfo value = getMUwbMicoPlayerViewModel().getContents().getValue();
            if (value != null) {
                song = value.getSong();
            }
            if (song != null || !ixe.O000000o(findViewById(R.id.player_recent_recommend).getTag(), Boolean.TRUE)) {
                this.recentRecommendLatch.countDown();
            } else if (findViewById(R.id.player_recent_recommend).getVisibility() != 0) {
                findViewById(R.id.player_recent_recommend).setVisibility(0);
                hxi.O00000o0.O00000o0();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: renderRecommendSongs$lambda-14  reason: not valid java name */
    public static final void m531renderRecommendSongs$lambda14(UwbMicoActivity uwbMicoActivity, PatchWall.Item item, View view) {
        ixe.O00000o(uwbMicoActivity, "this$0");
        hzf.O00000oO(view);
        SchemaManager.handleSchema(uwbMicoActivity, HomepageSchemaHandler.buildPlaySheetSchema(item == null ? null : item.target));
        hxi.O00000o.O0000ooO(1);
    }

    /* access modifiers changed from: private */
    /* renamed from: renderRecommendSongs$lambda-15  reason: not valid java name */
    public static final void m532renderRecommendSongs$lambda15(UwbMicoActivity uwbMicoActivity, PatchWall.Item item, View view) {
        ixe.O00000o(uwbMicoActivity, "this$0");
        hzf.O00000oO(view);
        SchemaManager.handleSchema(uwbMicoActivity, HomepageSchemaHandler.buildPlaySheetSchema(item == null ? null : item.target));
        hxi.O00000o.O0000ooO(2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.Object, int]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    public final void onClick(View view) {
        hzf.O00000oO(view);
        if (ixe.O000000o(view, (ImageView) findViewById(R.id.player_play))) {
            playOrPause();
        } else if (ixe.O000000o(view, (ImageView) findViewById(R.id.player_prev))) {
            getMUwbMicoPlayerViewModel().sendCommand(Command.Prev.INSTANCE);
            hxi.O00000o.O00oOooO(0);
        } else if (ixe.O000000o(view, (ImageView) findViewById(R.id.player_next))) {
            getMUwbMicoPlayerViewModel().sendCommand(Command.Next.INSTANCE);
            hxi.O00000o.O00oOooO(1);
        } else if (ixe.O000000o(view, (ImageView) findViewById(R.id.relay_image))) {
            if (ixe.O000000o(((ImageView) findViewById(R.id.relay_image)).getTag(), (Object) 1)) {
                getMUwbMicoPlayerViewModel().miplayAudioPlay();
                hxi.O00000o.O0000ooo(2);
            } else if (ixe.O000000o(((ImageView) findViewById(R.id.relay_image)).getTag(), (Object) 2)) {
                getMUwbMicoPlayerViewModel().miplayAudioStop();
                hxi.O00000o.O0000ooo(1);
            }
        } else if (ixe.O000000o(view, (TextView) findViewById(R.id.enter_Plugin))) {
            Activity activity = this;
            UwbScanDevice uwbScanDevice = this.mUwbScanDevice;
            ixe.O000000o(uwbScanDevice);
            String plainDid = uwbScanDevice.getDidInfo().getPlainDid();
            ixe.O00000Oo(plainDid, "mUwbScanDevice!!.didInfo.plainDid");
            Device device = UwbMicoActivityKt.getDevice(plainDid);
            if (device != null) {
                launchPlugin(activity, device);
                hxi.O00000o.f952O000000o.O000000o("uwb_mico_more_fun_click", new Object[0]);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.Object, int]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    /* JADX WARNING: Multi-variable type inference failed */
    private final void playOrPause() {
        if (ixe.O000000o(((ImageView) findViewById(R.id.player_play)).getTag(), (Object) 1)) {
            ((ImageView) findViewById(R.id.player_play)).setImageResource(R.drawable.uwb_mico_icon_play_selector);
            ((ImageView) findViewById(R.id.player_play)).setTag(2);
            getMUwbMicoPlayerViewModel().sendCommand(new Command.PlayOrPause(false));
        } else {
            ((ImageView) findViewById(R.id.player_play)).setImageResource(R.drawable.uwb_mico_icon_pause_selector);
            ((ImageView) findViewById(R.id.player_play)).setTag(1);
            getMUwbMicoPlayerViewModel().sendCommand(new Command.PlayOrPause(true));
        }
        this.lastPlayOrPauseActionTime = System.currentTimeMillis();
        hxk hxk = hxi.O00000o;
        Object tag = ((ImageView) findViewById(R.id.player_play)).getTag();
        if (tag != null) {
            hxk.f952O000000o.O000000o("uwb_mico_play_pause_click", "play_pause", Integer.valueOf(((Integer) tag).intValue()));
            View findViewById = findViewById(R.id.player_progress_bar);
            Integer num = null;
            UwbMicoProgressBar uwbMicoProgressBar = findViewById instanceof UwbMicoProgressBar ? (UwbMicoProgressBar) findViewById : null;
            if (uwbMicoProgressBar != null) {
                Object tag2 = ((ImageView) findViewById(R.id.player_play)).getTag();
                if (tag2 instanceof Integer) {
                    num = tag2;
                }
                if (num != null) {
                    uwbMicoProgressBar.setMStatus(num.intValue());
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final void launchPlugin(Activity activity, Device device) {
        PluginApi.getInstance().sendMessage(activity, device.model, 1, new Intent(), DeviceRouterFactory.getDeviceWrapper().newDeviceStat(device), null, true, new UwbMicoActivity$launchPlugin$1(this));
    }

    public final boolean getMNeedLog() {
        return this.mNeedLog;
    }

    public final void setMNeedLog(boolean z) {
        this.mNeedLog = z;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.Long]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.mNeedLog) {
            this.mNeedLog = false;
            UwbLogUtil.d("Mijia-UWB-UwbMicoActivity", ixe.O000000o("UWBPERFORMANCE-9-mijia-card-complete: ", (Object) Long.valueOf(System.currentTimeMillis())));
        }
    }
}

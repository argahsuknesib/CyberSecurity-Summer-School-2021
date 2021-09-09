package com.xiaomi.mico.setting.stereo;

import _m_j.jgc;
import _m_j.jgi;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.IncompleteApiListener;
import com.xiaomi.mico.api.WrappedIncompleteApiListener;
import com.xiaomi.mico.api.model.Admin;
import com.xiaomi.mico.api.model.MicoLanGroup;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.PairedGroupInfo;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.api.model.StereoData;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.application.Hardware;
import com.xiaomi.mico.common.application.MicoCapability;
import com.xiaomi.mico.common.util.GsonUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.common.widget.dialog.InputViewDialog;
import com.xiaomi.mico.music.event.MusicEvent;
import com.xiaomi.mico.music.player.PlayerManager;
import com.xiaomi.mico.setting.SettingItem;
import com.xiaomi.mico.setting.stereo.StereoConfigActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

public class StereoConfigActivity extends MicoBaseActivity {
    SettingItem channelSettingItem;
    TextView deleteGroupBtn;
    public String deviceId;
    ImageView groupConfigIv;
    SettingItem groupNameItem;
    public String groupOldName;
    public boolean playOk;
    public int playState = 0;
    SettingItem soundEffectPlayItem;
    public StereoData.StereoGroup stereoGroup;
    public Music.Station stereoMusic;
    TitleBar titleBar;

    static /* synthetic */ void lambda$onClickView$5(DialogInterface dialogInterface, int i) {
    }

    public boolean isDarkMode() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        Hardware hardware;
        Hardware hardware2;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_setting_stereo_config);
        this.titleBar = (TitleBar) findViewById(R.id.title_bar);
        this.groupConfigIv = (ImageView) findViewById(R.id.stereo_group_config_iv);
        this.groupNameItem = (SettingItem) findViewById(R.id.stereo_group_setting_item);
        this.groupNameItem.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.stereo.$$Lambda$StereoConfigActivity$YFg0ViF28FnT4g0Z1z9OdPJtNNM */

            public final void onClick(View view) {
                StereoConfigActivity.this.lambda$onCreate$0$StereoConfigActivity(view);
            }
        });
        this.channelSettingItem = (SettingItem) findViewById(R.id.stereo_channel_setting_item);
        this.channelSettingItem.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.stereo.$$Lambda$StereoConfigActivity$6VGIU_BAYcu9UQ57B4frfz99x0 */

            public final void onClick(View view) {
                StereoConfigActivity.this.lambda$onCreate$1$StereoConfigActivity(view);
            }
        });
        this.soundEffectPlayItem = (SettingItem) findViewById(R.id.stereo_effect_audition_item);
        this.soundEffectPlayItem.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.stereo.$$Lambda$StereoConfigActivity$Kws9Xg3NTzSx2Rm4pkZ2YTJ_pEo */

            public final void onClick(View view) {
                StereoConfigActivity.this.lambda$onCreate$2$StereoConfigActivity(view);
            }
        });
        this.deleteGroupBtn = (TextView) findViewById(R.id.stereo_delete_group_btn);
        this.deleteGroupBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.stereo.$$Lambda$StereoConfigActivity$BaZ3NFAyHGkDOFWzwTnaLAAjNss */

            public final void onClick(View view) {
                StereoConfigActivity.this.lambda$onCreate$3$StereoConfigActivity(view);
            }
        });
        jgc.O000000o().O000000o(this);
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.setting.stereo.$$Lambda$S_itconCyoageyKDI5n2J4CGqVo */

            public final void onLeftIconClick() {
                StereoConfigActivity.this.onBackPressed();
            }
        });
        this.stereoGroup = (StereoData.StereoGroup) getIntent().getParcelableExtra("stereo_group");
        StereoData.StereoGroup stereoGroup2 = this.stereoGroup;
        if (stereoGroup2 != null) {
            if (TextUtils.isEmpty(stereoGroup2.leftDeviceHardware)) {
                hardware = Hardware.LX06;
            } else {
                hardware = Hardware.safeValueOf(this.stereoGroup.leftDeviceHardware.toUpperCase());
            }
            if (TextUtils.isEmpty(this.stereoGroup.rightDeviceHardware)) {
                hardware2 = Hardware.LX06;
            } else {
                hardware2 = Hardware.safeValueOf(this.stereoGroup.rightDeviceHardware.toUpperCase());
            }
            if (hardware == Hardware.LX06 && hardware2 == Hardware.LX06) {
                this.groupConfigIv.setImageResource(R.drawable.mico_image_group_stereo_a);
            } else if (hardware == Hardware.L06A && hardware2 == Hardware.L06A) {
                this.groupConfigIv.setImageResource(R.drawable.mico_image_group_stereo_c);
            } else if (hardware == Hardware.L09A || hardware2 == Hardware.L09A) {
                this.groupConfigIv.setImageResource(R.drawable.mico_image_group_stereo_d);
            } else if (hardware == Hardware.L09B || hardware2 == Hardware.L09B) {
                this.groupConfigIv.setImageResource(R.drawable.mico_image_stereo_group_l09b);
            } else if (hardware == Hardware.L15A || hardware2 == Hardware.L15A) {
                this.groupConfigIv.setImageResource(R.drawable.mico_image_stereo_group_l15a);
            } else if (hardware == Hardware.L16A || hardware2 == Hardware.L16A) {
                this.groupConfigIv.setImageResource(R.drawable.mico_image_stereo_group_l16a);
            } else {
                this.groupConfigIv.setImageResource(R.drawable.mico_image_group_stereo_b);
            }
            this.groupOldName = this.stereoGroup.groupName;
            this.groupNameItem.setContent(this.groupOldName);
        }
        this.stereoMusic = (Music.Station) getIntent().getSerializableExtra("audition_music");
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
    /* renamed from: onClickView */
    public void lambda$onCreate$3$StereoConfigActivity(View view) {
        int id = view.getId();
        if (id == R.id.stereo_group_setting_item) {
            new InputViewDialog(getContext()).setTitle((int) R.string.setting_stereo_group_rename).setInitText(this.stereoGroup.groupName).setMaxInputLength(20).setMinInputLength(1).setRegularExpression("[a-zA-Z0-9\\u4E00-\\u9FA5]*").setListener(new InputViewDialog.Listener() {
                /* class com.xiaomi.mico.setting.stereo.$$Lambda$StereoConfigActivity$uPkKGI1ErthjI4o8dErOoO9_xJ0 */

                public final void onFinish(String str) {
                    StereoConfigActivity.this.lambda$onClickView$4$StereoConfigActivity(str);
                }
            }).show();
        } else if (id == R.id.stereo_channel_setting_item) {
            StereoData.StereoGroup stereoGroup2 = this.stereoGroup;
            if (stereoGroup2 == null || stereoGroup2.leftUnknownError || this.stereoGroup.rightUnknownError) {
                new MLAlertDialog.Builder(getContext()).O000000o((int) R.string.mico_common_hint).O00000Oo((int) R.string.setting_stereo_error_dialog_msg).O000000o((int) R.string.mico_understand, $$Lambda$StereoConfigActivity$ctE_HhWeRwwxazCNKB9pFm0GK6E.INSTANCE).O00000Oo((int) R.string.common_cancel, (DialogInterface.OnClickListener) null).O00000oo();
                return;
            }
            Intent intent = new Intent(getContext(), StereoChannelSettingActivity.class);
            intent.putExtra("stereo_channel_group", this.stereoGroup);
            intent.putExtra("stereo_channel_update", true);
            startActivityForResult(intent, 1);
        } else if (id == R.id.stereo_effect_audition_item) {
            Music.Station station = this.stereoMusic;
            if (station != null) {
                int i = this.playState;
                if (i == 0) {
                    onPlay(true, true, station, null);
                } else if (i == 1) {
                    playOrPause(this.deviceId, "pause", null);
                } else {
                    playOrPause(this.deviceId, "play", null);
                }
            } else {
                getStationSoundList(true);
            }
        } else if (id == R.id.stereo_delete_group_btn) {
            deleteStereoGroup(this.stereoGroup);
        }
    }

    public /* synthetic */ void lambda$onClickView$4$StereoConfigActivity(String str) {
        if (!str.equals(this.stereoGroup.groupName)) {
            StereoData.StereoGroup stereoGroup2 = this.stereoGroup;
            stereoGroup2.groupName = str;
            updateStereoGroup(stereoGroup2);
        }
    }

    public void onStop() {
        super.onStop();
        if (!TextUtils.isEmpty(this.deviceId) && this.playState != 2) {
            new Object[1][0] = "StereoConfigActivity pause play ";
            PlayerManager.getInstance().control(this.deviceId, "pause", null);
        }
    }

    public void onDestroy() {
        if (jgc.O000000o().O00000Oo(this)) {
            jgc.O000000o().O00000o0(this);
        }
        super.onDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1 || i2 != -1) {
            return;
        }
        if (intent != null) {
            this.stereoGroup = (StereoData.StereoGroup) intent.getParcelableExtra("stereo_group");
            return;
        }
        String stereoGroupJson = MicoManager.getInstance().getStereoGroupJson();
        if (TextUtils.isEmpty(stereoGroupJson)) {
            loadStereoGroup(true, "");
        } else {
            this.stereoGroup = (StereoData.StereoGroup) GsonUtil.getGsonInstance().fromJson(stereoGroupJson, StereoData.StereoGroup.class);
        }
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onPlayerStatusUpdate(MusicEvent.PlayerStatusUpdate playerStatusUpdate) {
        if (PlayerManager.getInstance().getQueryDeviceId().equals(this.deviceId)) {
            Remote.Response.PlayerStatus playerStatus = playerStatusUpdate.playerStatus;
            if (!this.playOk) {
                return;
            }
            if (playerStatus.status == 1) {
                this.soundEffectPlayItem.setMoreRes(R.drawable.icon_stereo_pause);
                this.playState = 1;
                return;
            }
            this.soundEffectPlayItem.setMoreRes(R.drawable.icon_stereo_play);
            if (playerStatus.status == 2) {
                this.playState = 2;
            } else {
                this.playState = 0;
            }
        }
    }

    private void updateStereoGroup(final StereoData.StereoGroup stereoGroup2) {
        showProgressDialog(null);
        ApiHelper.updateStereoGroup(GsonUtil.getGsonInstance().toJson(stereoGroup2), new ApiRequest.Listener<Boolean>() {
            /* class com.xiaomi.mico.setting.stereo.StereoConfigActivity.AnonymousClass1 */

            public void onSuccess(Boolean bool) {
                new Object[1][0] = "StereoConfigActivity updateStereoGroup response ".concat(String.valueOf(bool));
                StereoConfigActivity.this.dismissProgressDialog();
                StereoConfigActivity.this.groupNameItem.setContent(stereoGroup2.groupName);
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = "StereoConfigActivity updateStereoGroup: ".concat(String.valueOf(apiError));
                StereoConfigActivity.this.groupNameItem.setContent(StereoConfigActivity.this.groupOldName);
                StereoConfigActivity.this.stereoGroup.groupName = StereoConfigActivity.this.groupOldName;
                StereoConfigActivity.this.dismissProgressDialog();
                ToastUtil.showToast((int) R.string.common_save_fail1);
            }
        }).bindToLifecycle(this);
        setNameToBluetooth(stereoGroup2.leftDeviceId, stereoGroup2.groupName);
    }

    private void deleteStereoGroup(final StereoData.StereoGroup stereoGroup2) {
        showProgressDialog(null);
        ApiHelper.deleteStereoGroup(stereoGroup2.groupId, new ApiRequest.Listener<Boolean>() {
            /* class com.xiaomi.mico.setting.stereo.StereoConfigActivity.AnonymousClass2 */

            public void onSuccess(Boolean bool) {
                new Object[1][0] = "StereoConfigActivity deleteStereoGroup response ".concat(String.valueOf(bool));
                if (bool.booleanValue()) {
                    MicoManager.getInstance().clearStereoData(false);
                    MicoManager.getInstance().clearStereoService(stereoGroup2.groupId);
                    String currentMicoID = MicoManager.getInstance().getCurrentMicoID();
                    new Object[1][0] = "StereoConfigActivity after delete stereoGroup reset query deviceId to current: ".concat(String.valueOf(currentMicoID));
                    PlayerManager.getInstance().setQueryDeviceId(currentMicoID);
                    StereoConfigActivity.this.titleBar.postDelayed(new Runnable() {
                        /* class com.xiaomi.mico.setting.stereo.$$Lambda$StereoConfigActivity$2$5ZQOK0yxKstqTGT0ZDYh5hoxhB0 */

                        public final void run() {
                            StereoConfigActivity.AnonymousClass2.this.lambda$onSuccess$0$StereoConfigActivity$2();
                        }
                    }, 2000);
                    return;
                }
                StereoConfigActivity.this.dismissProgressDialog();
                ToastUtil.showToast((int) R.string.common_save_fail1);
            }

            public /* synthetic */ void lambda$onSuccess$0$StereoConfigActivity$2() {
                StereoConfigActivity.this.dismissProgressDialog();
                StereoConfigActivity.this.finish();
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = "StereoConfigActivity deleteStereoGroup: ".concat(String.valueOf(apiError));
                StereoConfigActivity.this.dismissProgressDialog();
                ToastUtil.showToast((int) R.string.common_save_fail1);
            }
        }).bindToLifecycle(this);
        setNameToBluetooth(stereoGroup2.leftDeviceId, "");
    }

    private void loadStereoGroup(boolean z, String str) {
        if (z) {
            showProgressDialog(null);
        }
        ApiHelper.getMicoLanGroup("", "", str, new ApiRequest.Listener<MicoLanGroup>() {
            /* class com.xiaomi.mico.setting.stereo.StereoConfigActivity.AnonymousClass3 */

            public void onSuccess(MicoLanGroup micoLanGroup) {
                StereoConfigActivity.this.titleBar.post(new Runnable(micoLanGroup) {
                    /* class com.xiaomi.mico.setting.stereo.$$Lambda$StereoConfigActivity$3$kZjr8aBoFgy7QAvaLrrbdEAwpAo */
                    private final /* synthetic */ MicoLanGroup f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        StereoConfigActivity.AnonymousClass3.this.lambda$onSuccess$0$StereoConfigActivity$3(this.f$1);
                    }
                });
            }

            public /* synthetic */ void lambda$onSuccess$0$StereoConfigActivity$3(MicoLanGroup micoLanGroup) {
                StereoConfigActivity.this.dismissProgressDialog();
                PairedGroupInfo pairedGroupInfo = micoLanGroup.pairedGroupInfo;
                if (pairedGroupInfo != null) {
                    List<StereoData.StereoGroup> list = pairedGroupInfo.stereoList;
                    if (list == null || list.isEmpty()) {
                        MicoManager.getInstance().clearStereoData(false);
                        StereoConfigActivity.this.finish();
                        return;
                    }
                    StereoConfigActivity.this.stereoGroup = list.get(0);
                }
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = "StereoSettingActivity loadStereoGroup: ".concat(String.valueOf(apiError));
                StereoConfigActivity.this.dismissProgressDialog();
                StereoConfigActivity.this.finish();
            }
        }).bindToLifecycle(this);
    }

    private void getStationSoundList(final boolean z) {
        showProgressDialog(null);
        ApiHelper.getStationSoundList("123", "xiaoaifm", "", 0, 3, "NOT_REVERSE", null, new ApiRequest.Listener<Music.StationSoundList>() {
            /* class com.xiaomi.mico.setting.stereo.StereoConfigActivity.AnonymousClass4 */

            public void onSuccess(Music.StationSoundList stationSoundList) {
                Iterator<Music.Station> it = stationSoundList.soundList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Music.Station next = it.next();
                    if ("立体声音效测试".equals(next.title)) {
                        StereoConfigActivity.this.stereoMusic = next;
                        break;
                    }
                }
                if (!z || StereoConfigActivity.this.stereoMusic == null) {
                    ToastUtil.showToast((int) R.string.common_failed);
                    StereoConfigActivity.this.dismissProgressDialog();
                    return;
                }
                StereoConfigActivity stereoConfigActivity = StereoConfigActivity.this;
                stereoConfigActivity.onPlay(false, true, stereoConfigActivity.stereoMusic, null);
            }

            public void onFailure(ApiError apiError) {
                StereoConfigActivity.this.dismissProgressDialog();
            }
        }).bindToLifecycle(this);
    }

    private void setNameToBluetooth(String str, String str2) {
        ApiHelper.setStereoNameToBluetooth(str, str2, new ApiRequest.Listener<Remote.Response.NullInfo>() {
            /* class com.xiaomi.mico.setting.stereo.StereoConfigActivity.AnonymousClass5 */

            public void onSuccess(Remote.Response.NullInfo nullInfo) {
                new Object[1][0] = "StereoConfigActivity setNameToBluetooth: ".concat(String.valueOf(nullInfo));
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = "StereoConfigActivity setNameToBluetooth: ".concat(String.valueOf(apiError));
            }
        });
    }

    private void setLoop(boolean z) {
        if (z) {
            showProgressDialog(null);
        }
        this.deviceId = !TextUtils.isEmpty(this.stereoGroup.server) ? this.stereoGroup.server : this.stereoGroup.leftDeviceId;
        PlayerManager.getInstance().loop(this.deviceId, 2, new IncompleteApiListener() {
            /* class com.xiaomi.mico.setting.stereo.StereoConfigActivity.AnonymousClass6 */

            public void onSuccess() {
                StereoConfigActivity stereoConfigActivity = StereoConfigActivity.this;
                stereoConfigActivity.onPlay(false, false, stereoConfigActivity.stereoMusic, null);
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = "StereoConfigActivity onPlay setLoop onFailure ".concat(String.valueOf(apiError));
                StereoConfigActivity stereoConfigActivity = StereoConfigActivity.this;
                stereoConfigActivity.onPlay(false, true, stereoConfigActivity.stereoMusic, null);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onPlay(boolean z, final boolean z2, Music.Station station, IncompleteApiListener incompleteApiListener) {
        String str;
        if (z) {
            showProgressDialog(null);
        }
        this.deviceId = !TextUtils.isEmpty(this.stereoGroup.server) ? this.stereoGroup.server : this.stereoGroup.leftDeviceId;
        Admin.Mico micoByDeviceId = MicoManager.getInstance().getMicoByDeviceId(this.deviceId);
        if (micoByDeviceId == null) {
            dismissProgressDialog();
            return;
        }
        if (micoByDeviceId.hasCapability(MicoCapability.AI_PROTOCOL_3_0)) {
            str = Remote.Request.buildV3PlayStationListMessage(null, Collections.singletonList(station), 0, "NOT_REVERSE");
        } else {
            str = Remote.Request.buildStationListMessage(null, Collections.singletonList(station), 0);
        }
        ApiHelper.remote(this.deviceId, "mediaplayer", "player_play_music", str, new WrappedIncompleteApiListener<Remote.Response.NullInfo>(incompleteApiListener) {
            /* class com.xiaomi.mico.setting.stereo.StereoConfigActivity.AnonymousClass7 */

            public void onSuccess(Remote.Response.NullInfo nullInfo) {
                new Object[1][0] = "StereoConfigActivity onPlay onSuccess " + nullInfo.code;
                super.onSuccess((Object) nullInfo);
                StereoConfigActivity.this.dismissProgressDialog();
                if (nullInfo.code == 0) {
                    if (z2) {
                        PlayerManager.getInstance().loop(StereoConfigActivity.this.deviceId, 2, null);
                    }
                    StereoConfigActivity stereoConfigActivity = StereoConfigActivity.this;
                    stereoConfigActivity.playOk = true;
                    stereoConfigActivity.playState = 1;
                    stereoConfigActivity.soundEffectPlayItem.setMoreRes(R.drawable.icon_stereo_pause);
                    return;
                }
                StereoConfigActivity stereoConfigActivity2 = StereoConfigActivity.this;
                stereoConfigActivity2.playState = 0;
                stereoConfigActivity2.soundEffectPlayItem.setMoreRes(R.drawable.icon_stereo_play);
            }

            public void onFailure(ApiError apiError) {
                super.onFailure(apiError);
                StereoConfigActivity.this.dismissProgressDialog();
                new Object[1][0] = "StereoConfigActivity onPlay onFailure ".concat(String.valueOf(apiError));
                ToastUtil.showToast((int) R.string.local_music_play_failed);
            }
        }, Remote.Response.NullInfo.class);
    }

    private void playOrPause(String str, final String str2, IncompleteApiListener incompleteApiListener) {
        ApiHelper.remote(str, "mediaplayer", "player_play_operation", Remote.Request.buildControlActionMessage(str2), new WrappedIncompleteApiListener<Remote.Response.NullInfo>(incompleteApiListener) {
            /* class com.xiaomi.mico.setting.stereo.StereoConfigActivity.AnonymousClass8 */

            public void onSuccess(Remote.Response.NullInfo nullInfo) {
                super.onSuccess((Object) nullInfo);
                new Object[1][0] = "StereoConfigActivity playOrPause onSuccess ,and action is " + str2;
                if (nullInfo.code != 0) {
                    return;
                }
                if (str2.equals("pause")) {
                    StereoConfigActivity.this.soundEffectPlayItem.setMoreRes(R.drawable.icon_stereo_play);
                    StereoConfigActivity.this.playState = 2;
                    return;
                }
                StereoConfigActivity.this.soundEffectPlayItem.setMoreRes(R.drawable.icon_stereo_pause);
                StereoConfigActivity.this.playState = 1;
            }

            public void onFailure(ApiError apiError) {
                super.onFailure(apiError);
                new Object[1][0] = "StereoConfigActivity playOrPause onFailure ".concat(String.valueOf(apiError));
                if (apiError.getCode() == 109 || apiError.getCode() == 108 || apiError.getCode() == 114) {
                    StereoConfigActivity stereoConfigActivity = StereoConfigActivity.this;
                    stereoConfigActivity.playState = 0;
                    stereoConfigActivity.soundEffectPlayItem.setMoreRes(R.drawable.icon_stereo_play);
                }
            }
        }, Remote.Response.NullInfo.class);
    }
}

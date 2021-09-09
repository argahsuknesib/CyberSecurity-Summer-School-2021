package com.xiaomi.mico.setting.stereo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.IncompleteApiListener;
import com.xiaomi.mico.api.WrappedIncompleteApiListener;
import com.xiaomi.mico.api.model.Admin;
import com.xiaomi.mico.api.model.DeviceState;
import com.xiaomi.mico.api.model.LanGroupInfo;
import com.xiaomi.mico.api.model.MicoLanGroup;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.api.model.StereoData;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.application.Hardware;
import com.xiaomi.mico.common.application.MicoCapability;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.common.util.GsonUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.music.player.PlayerManager;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class StereoChannelSettingActivity extends MicoBaseActivity {
    LinearLayout channelLayoutLeft;
    LinearLayout channelLayoutRight;
    ImageView channelLeftDeviceIv;
    TextView channelLeftDeviceName;
    Button channelLeftPlayBtn;
    ImageView channelRightDeviceIv;
    TextView channelRightDeviceName;
    Button channelRightPlayBtn;
    ImageView channelSwitchBtn;
    Button finishBtn;
    public ArrayList<String> lastDeviceIdList;
    public Music.Station leftPlayMusic;
    public StereoData.StereoGroup mGroupInfo;
    public int mPlayTag;
    private boolean mUpdateChannel;
    public String playDeviceId;
    public Music.Station rightPlayMusic;
    public List<Music.Station> soundList;
    public Music.Station stereoMusic;
    private DeviceState tempDevice;
    TitleBar titleBar;
    public HashMap<String, String> wakeUpResourceMap;

    public boolean isDarkMode() {
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.mico.common.util.DisplayUtils.dip2px(android.app.Activity, float):int
     arg types: [android.app.Activity, int]
     candidates:
      com.xiaomi.mico.common.util.DisplayUtils.dip2px(android.content.Context, float):int
      com.xiaomi.mico.common.util.DisplayUtils.dip2px(android.app.Activity, float):int */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_setting_stereo_channel);
        this.titleBar = (TitleBar) findViewById(R.id.title_bar);
        this.channelSwitchBtn = (ImageView) findViewById(R.id.channel_lr_switch_btn);
        this.channelSwitchBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.stereo.$$Lambda$StereoChannelSettingActivity$6sfsCxhgeuGeuZMOV3_aUFuOjHQ */

            public final void onClick(View view) {
                StereoChannelSettingActivity.this.lambda$onCreate$0$StereoChannelSettingActivity(view);
            }
        });
        this.channelLayoutLeft = (LinearLayout) findViewById(R.id.channel_device_layout_left);
        this.channelLayoutRight = (LinearLayout) findViewById(R.id.channel_device_layout_right);
        this.channelLeftDeviceName = (TextView) findViewById(R.id.channel_device_name_left);
        this.channelLeftPlayBtn = (Button) findViewById(R.id.channel_play_btn_left);
        this.channelLeftPlayBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.stereo.$$Lambda$StereoChannelSettingActivity$Brg710p2PclqY2SQtniAiTq7Gn4 */

            public final void onClick(View view) {
                StereoChannelSettingActivity.this.lambda$onCreate$1$StereoChannelSettingActivity(view);
            }
        });
        this.channelLeftDeviceIv = (ImageView) findViewById(R.id.channel_device_icon_left);
        this.channelRightDeviceName = (TextView) findViewById(R.id.channel_device_name_right);
        this.channelRightPlayBtn = (Button) findViewById(R.id.channel_play_btn_right);
        this.channelRightPlayBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.stereo.$$Lambda$StereoChannelSettingActivity$RCbpFgJXAyCtuRUZSE0_KjIzsTY */

            public final void onClick(View view) {
                StereoChannelSettingActivity.this.lambda$onCreate$2$StereoChannelSettingActivity(view);
            }
        });
        this.channelRightDeviceIv = (ImageView) findViewById(R.id.channel_device_icon_right);
        this.finishBtn = (Button) findViewById(R.id.finish_btn);
        this.finishBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.stereo.$$Lambda$StereoChannelSettingActivity$nrETBHTVPSofVTxfXNo8EW3Bn_A */

            public final void onClick(View view) {
                StereoChannelSettingActivity.this.lambda$onCreate$3$StereoChannelSettingActivity(view);
            }
        });
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.setting.stereo.$$Lambda$W9HSAy0Y_vSpOKH7ZLgzUpfZg0 */

            public final void onLeftIconClick() {
                StereoChannelSettingActivity.this.onBackPressed();
            }
        });
        this.mGroupInfo = (StereoData.StereoGroup) getIntent().getParcelableExtra("stereo_channel_group");
        int i = 0;
        this.mUpdateChannel = getIntent().getBooleanExtra("stereo_channel_update", false);
        StereoData.StereoGroup stereoGroup = this.mGroupInfo;
        if (stereoGroup != null) {
            if (!TextUtils.isEmpty(stereoGroup.groupId)) {
                this.lastDeviceIdList = new ArrayList<>(2);
                this.lastDeviceIdList.add(this.mGroupInfo.leftDeviceId);
                this.lastDeviceIdList.add(this.mGroupInfo.rightDeviceId);
            }
            if (this.mGroupInfo.leftDeviceName.length() >= 12 || this.mGroupInfo.rightDeviceName.length() >= 12) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.channelLayoutLeft.getLayoutParams();
                layoutParams.width = DisplayUtils.dip2px(getContext(), 155.0f);
                layoutParams.leftMargin = DisplayUtils.dip2px(getContext(), 20.0f);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.channelLayoutRight.getLayoutParams();
                layoutParams2.width = DisplayUtils.dip2px(getContext(), 155.0f);
                layoutParams2.rightMargin = DisplayUtils.dip2px(getContext(), 20.0f);
            }
            this.channelLeftDeviceName.setText(this.mGroupInfo.leftDeviceName);
            this.channelRightDeviceName.setText(this.mGroupInfo.rightDeviceName);
            updateSoundBoxIcon();
        }
        Button button = this.finishBtn;
        if (this.mUpdateChannel) {
            i = 8;
        }
        button.setVisibility(i);
        getStationSoundList(-1);
    }

    public void onStop() {
        super.onStop();
        new Object[1][0] = "StereoChannelSettingActivity onStop pause play";
        pauseDevice(this.playDeviceId, null);
    }

    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("stereo_group", this.mGroupInfo);
        setResult(-1, intent);
        super.onBackPressed();
    }

    /* renamed from: onClickView */
    public void lambda$onCreate$3$StereoChannelSettingActivity(View view) {
        int id = view.getId();
        if (id == R.id.channel_lr_switch_btn) {
            if (this.tempDevice == null) {
                this.tempDevice = new DeviceState();
            }
            this.tempDevice.deviceId = this.mGroupInfo.leftDeviceId;
            this.tempDevice.hardware = this.mGroupInfo.leftDeviceHardware;
            this.tempDevice.resource = this.mGroupInfo.leftDeviceResource;
            this.tempDevice.deviceName = this.mGroupInfo.leftDeviceName;
            StereoData.StereoGroup stereoGroup = this.mGroupInfo;
            stereoGroup.leftDeviceId = stereoGroup.rightDeviceId;
            StereoData.StereoGroup stereoGroup2 = this.mGroupInfo;
            stereoGroup2.leftDeviceHardware = stereoGroup2.rightDeviceHardware;
            StereoData.StereoGroup stereoGroup3 = this.mGroupInfo;
            stereoGroup3.leftDeviceResource = stereoGroup3.rightDeviceResource;
            StereoData.StereoGroup stereoGroup4 = this.mGroupInfo;
            stereoGroup4.leftDeviceName = stereoGroup4.rightDeviceName;
            this.mGroupInfo.rightDeviceId = this.tempDevice.deviceId;
            this.mGroupInfo.rightDeviceHardware = this.tempDevice.hardware;
            this.mGroupInfo.rightDeviceResource = this.tempDevice.resource;
            this.mGroupInfo.rightDeviceName = this.tempDevice.deviceName;
            this.channelLeftDeviceName.setText(this.mGroupInfo.leftDeviceName);
            this.channelRightDeviceName.setText(this.mGroupInfo.rightDeviceName);
            updateSoundBoxIcon();
            Object[] objArr = {"StereoChannelSettingActivity 切换声道后，左边的设备id %s, name %s ", this.mGroupInfo.leftDeviceId, this.mGroupInfo.leftDeviceName};
            if (this.mUpdateChannel) {
                updateStereoGroup(this.mGroupInfo, null);
            }
        } else if (id == R.id.finish_btn) {
            new Object[1][0] = "StereoChannelSettingActivity finish button click, pause play ";
            pauseDevice(this.playDeviceId, null);
            if (TextUtils.isEmpty(this.mGroupInfo.groupId)) {
                showProgressDialog(null);
                setNameToBluetooth(this.mGroupInfo.leftDeviceId, this.mGroupInfo.groupName);
                createStereo(this.mGroupInfo).flatMap(new Func1() {
                    /* class com.xiaomi.mico.setting.stereo.$$Lambda$StereoChannelSettingActivity$TaqSmQH_R3rMkTRN669ubjG2Wvo */

                    public final Object call(Object obj) {
                        return StereoChannelSettingActivity.this.lambda$onClickView$4$StereoChannelSettingActivity(obj);
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() {
                    /* class com.xiaomi.mico.setting.stereo.$$Lambda$StereoChannelSettingActivity$S7iasFuzDePoRqX4HjJ66x7dI */

                    public final void call(Object obj) {
                        StereoChannelSettingActivity.this.lambda$onClickView$5$StereoChannelSettingActivity(obj);
                    }
                });
                return;
            }
            ArrayList<String> arrayList = this.lastDeviceIdList;
            if (arrayList == null || !arrayList.get(0).equals(this.mGroupInfo.leftDeviceId)) {
                updateStereoGroup(this.mGroupInfo, null);
            } else {
                finish();
            }
        } else if (id == R.id.channel_play_btn_left) {
            this.mPlayTag = 1;
            List<Music.Station> list = this.soundList;
            if (list == null || list.isEmpty() || this.leftPlayMusic == null) {
                getStationSoundList(1);
                return;
            }
            ArrayList<String> arrayList2 = this.lastDeviceIdList;
            if (arrayList2 == null || arrayList2.get(0).equals(this.mGroupInfo.leftDeviceId)) {
                play(true, this.leftPlayMusic);
            } else {
                updateStereoGroup(this.mGroupInfo, this.leftPlayMusic);
            }
        } else if (id == R.id.channel_play_btn_right) {
            this.mPlayTag = 2;
            List<Music.Station> list2 = this.soundList;
            if (list2 == null || list2.isEmpty() || this.rightPlayMusic == null) {
                getStationSoundList(2);
                return;
            }
            ArrayList<String> arrayList3 = this.lastDeviceIdList;
            if (arrayList3 == null || arrayList3.get(0).equals(this.mGroupInfo.leftDeviceId)) {
                play(true, this.rightPlayMusic);
            } else {
                updateStereoGroup(this.mGroupInfo, this.rightPlayMusic);
            }
        }
    }

    public /* synthetic */ Object lambda$onClickView$4$StereoChannelSettingActivity(Object obj) {
        if (obj instanceof String) {
            return queryStereo();
        }
        return Observable.just(Boolean.FALSE);
    }

    public /* synthetic */ void lambda$onClickView$5$StereoChannelSettingActivity(Object obj) {
        if (obj instanceof Boolean) {
            switchAwakeStatus();
            dismissProgressDialog();
            setResult(-1);
            finish();
            Intent intent = new Intent(getContext(), StereoConfigActivity.class);
            intent.putExtra("stereo_group", this.mGroupInfo);
            intent.putExtra("audition_music", this.stereoMusic);
            startActivity(intent);
        }
    }

    @Deprecated
    private void createStereoGroup(final StereoData.StereoGroup stereoGroup) {
        final ArrayList arrayList = new ArrayList();
        showProgressDialog(null);
        final Gson gsonInstance = GsonUtil.getGsonInstance();
        ApiHelper.createStereoGroup(gsonInstance.toJson(stereoGroup), new ApiRequest.Listener<String>() {
            /* class com.xiaomi.mico.setting.stereo.StereoChannelSettingActivity.AnonymousClass1 */

            public void onSuccess(String str) {
                new Object[1][0] = "StereoChannelSettingActivity createStereoGroup response ".concat(String.valueOf(str));
                StereoChannelSettingActivity.this.dismissProgressDialog();
                StereoChannelSettingActivity.this.setResult(-1);
                StereoChannelSettingActivity.this.finish();
                stereoGroup.groupId = str;
                MicoManager.getInstance().saveStereoGroupJson(gsonInstance.toJson(stereoGroup));
                arrayList.add(stereoGroup);
                MicoManager.getInstance().setStereoGroup(arrayList);
                Admin.Mico currentMico = MicoManager.getInstance().getCurrentMico();
                if (currentMico.isOnline() && (stereoGroup.leftDeviceId.equalsIgnoreCase(currentMico.deviceID) || stereoGroup.rightDeviceId.equalsIgnoreCase(currentMico.deviceID))) {
                    Object[] objArr = {"StereoChannelSettingActivity setQueryDeviceId %s after createStereoGroup And resetAndQuery Player Status", stereoGroup.leftDeviceId};
                    PlayerManager.getInstance().setQueryDeviceId(stereoGroup.leftDeviceId);
                }
                Intent intent = new Intent(StereoChannelSettingActivity.this.getContext(), StereoConfigActivity.class);
                intent.putExtra("stereo_group", stereoGroup);
                intent.putExtra("audition_music", StereoChannelSettingActivity.this.stereoMusic);
                StereoChannelSettingActivity.this.startActivity(intent);
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = "StereoChannelSettingActivity createStereoGroup: ".concat(String.valueOf(apiError));
                StereoChannelSettingActivity.this.dismissProgressDialog();
                ToastUtil.showToast((int) R.string.common_save_fail1);
            }
        }).bindToLifecycle(this);
    }

    private void updateStereoGroup(StereoData.StereoGroup stereoGroup, Music.Station station) {
        final ArrayList arrayList = new ArrayList();
        showProgressDialog(null);
        String json = GsonUtil.getGsonInstance().toJson(stereoGroup);
        final StereoData.StereoGroup stereoGroup2 = stereoGroup;
        final String str = json;
        final Music.Station station2 = station;
        ApiHelper.updateStereoGroup(json, new ApiRequest.Listener<Boolean>() {
            /* class com.xiaomi.mico.setting.stereo.StereoChannelSettingActivity.AnonymousClass2 */

            public void onSuccess(Boolean bool) {
                arrayList.add(stereoGroup2);
                new Object[1][0] = "StereoChannelSettingActivity updateStereoGroup response " + bool + " and server is :" + stereoGroup2.server;
                MicoManager.getInstance().saveStereoGroupJson(str);
                MicoManager.getInstance().setStereoGroup(arrayList);
                StereoChannelSettingActivity.this.lastDeviceIdList.clear();
                StereoChannelSettingActivity.this.lastDeviceIdList.add(stereoGroup2.leftDeviceId);
                StereoChannelSettingActivity.this.lastDeviceIdList.add(stereoGroup2.rightDeviceId);
                Music.Station station = station2;
                if (station != null) {
                    StereoChannelSettingActivity.this.play(false, station);
                    return;
                }
                StereoChannelSettingActivity.this.dismissProgressDialog();
                ToastUtil.showToast((int) R.string.setting_stereo_channel_switch_success);
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = "StereoChannelSettingActivity updateStereoGroup: ".concat(String.valueOf(apiError));
                StereoChannelSettingActivity.this.dismissProgressDialog();
                ToastUtil.showToast((int) R.string.common_save_fail1);
            }
        }).bindToLifecycle(this);
    }

    private void getStationSoundList(final int i) {
        showProgressDialog(null);
        ApiHelper.getStationSoundList("123", "xiaoaifm", "", 0, 3, "NOT_REVERSE", null, new ApiRequest.Listener<Music.StationSoundList>() {
            /* class com.xiaomi.mico.setting.stereo.StereoChannelSettingActivity.AnonymousClass3 */

            public void onSuccess(Music.StationSoundList stationSoundList) {
                StereoChannelSettingActivity.this.soundList = stationSoundList.soundList;
                if (StereoChannelSettingActivity.this.soundList.size() >= 2) {
                    for (Music.Station next : StereoChannelSettingActivity.this.soundList) {
                        if ("左声道测试音".equals(next.title)) {
                            StereoChannelSettingActivity.this.leftPlayMusic = next;
                        } else if ("右声道测试音".equals(next.title)) {
                            StereoChannelSettingActivity.this.rightPlayMusic = next;
                        } else if ("立体声音效测试".equals(next.title)) {
                            StereoChannelSettingActivity.this.stereoMusic = next;
                        }
                    }
                    int i = i;
                    if (i == 1) {
                        StereoChannelSettingActivity stereoChannelSettingActivity = StereoChannelSettingActivity.this;
                        stereoChannelSettingActivity.play(false, stereoChannelSettingActivity.leftPlayMusic);
                    } else if (i == 2) {
                        StereoChannelSettingActivity stereoChannelSettingActivity2 = StereoChannelSettingActivity.this;
                        stereoChannelSettingActivity2.play(false, stereoChannelSettingActivity2.rightPlayMusic);
                    } else {
                        StereoChannelSettingActivity.this.dismissProgressDialog();
                    }
                } else {
                    ToastUtil.showToast((int) R.string.common_failed);
                    StereoChannelSettingActivity.this.dismissProgressDialog();
                    StereoChannelSettingActivity.this.finish();
                }
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = "StereoChannelSettingActivity getStationSoundList: ".concat(String.valueOf(apiError));
                StereoChannelSettingActivity.this.dismissProgressDialog();
                ToastUtil.showToast((int) R.string.local_music_play_failed);
            }
        }).bindToLifecycle(this);
    }

    private void pauseDevice(String str, IncompleteApiListener incompleteApiListener) {
        if (!TextUtils.isEmpty(str)) {
            PlayerManager.getInstance().control(str, "pause", incompleteApiListener);
        }
    }

    public void play(boolean z, Music.Station station) {
        String str;
        if (z) {
            showProgressDialog(null);
        }
        this.playDeviceId = this.mGroupInfo.leftDeviceId;
        int i = this.mPlayTag;
        if (i == 1) {
            this.playDeviceId = this.mGroupInfo.leftDeviceId;
        } else if (i == 2) {
            this.playDeviceId = this.mGroupInfo.rightDeviceId;
        }
        if (MicoManager.getInstance().getMicoByDeviceId(this.playDeviceId).hasCapability(MicoCapability.AI_PROTOCOL_3_0)) {
            str = Remote.Request.buildV3PlayStationListMessage(null, Collections.singletonList(station), 0, "NOT_REVERSE");
        } else {
            str = Remote.Request.buildStationListMessage(null, Collections.singletonList(station), 0);
        }
        ApiHelper.remote(this.playDeviceId, "mediaplayer", "player_play_music", str, new WrappedIncompleteApiListener<Remote.Response.NullInfo>(null) {
            /* class com.xiaomi.mico.setting.stereo.StereoChannelSettingActivity.AnonymousClass4 */

            public void onSuccess(Remote.Response.NullInfo nullInfo) {
                super.onSuccess((Object) nullInfo);
                StereoChannelSettingActivity.this.dismissProgressDialog();
                PlayerManager.getInstance().loop(StereoChannelSettingActivity.this.playDeviceId, 2, null);
                if (StereoChannelSettingActivity.this.mPlayTag == 1) {
                    Object[] objArr = {"StereoChannelSettingActivity play channel left %s ok", StereoChannelSettingActivity.this.playDeviceId};
                } else if (StereoChannelSettingActivity.this.mPlayTag == 2) {
                    Object[] objArr2 = {"StereoChannelSettingActivity play channel right %s ok", StereoChannelSettingActivity.this.playDeviceId};
                }
            }

            public void onFailure(ApiError apiError) {
                super.onFailure(apiError);
                StereoChannelSettingActivity.this.dismissProgressDialog();
                if (StereoChannelSettingActivity.this.mPlayTag == 1) {
                    new Object[1][0] = "StereoChannelSettingActivity play channel left failed ".concat(String.valueOf(apiError));
                } else if (StereoChannelSettingActivity.this.mPlayTag == 2) {
                    new Object[1][0] = "StereoChannelSettingActivity play channel right failed ".concat(String.valueOf(apiError));
                }
                ToastUtil.showToast((int) R.string.local_music_play_failed);
            }
        }, Remote.Response.NullInfo.class);
    }

    private Observable createStereo(StereoData.StereoGroup stereoGroup) {
        return Observable.unsafeCreate(new Observable.OnSubscribe(stereoGroup) {
            /* class com.xiaomi.mico.setting.stereo.$$Lambda$StereoChannelSettingActivity$Y0wjHMtCE5u4vZptRZZaroDcU7Y */
            private final /* synthetic */ StereoData.StereoGroup f$1;

            {
                this.f$1 = r2;
            }

            public final void call(Object obj) {
                StereoChannelSettingActivity.this.lambda$createStereo$6$StereoChannelSettingActivity(this.f$1, (Subscriber) obj);
            }
        });
    }

    public /* synthetic */ void lambda$createStereo$6$StereoChannelSettingActivity(final StereoData.StereoGroup stereoGroup, final Subscriber subscriber) {
        ApiHelper.createStereoGroup(GsonUtil.getGsonInstance().toJson(stereoGroup), new ApiRequest.Listener<String>() {
            /* class com.xiaomi.mico.setting.stereo.StereoChannelSettingActivity.AnonymousClass5 */

            public void onSuccess(String str) {
                stereoGroup.groupId = str;
                new Object[1][0] = "StereoChannelSettingActivity createStereoGroup response ".concat(String.valueOf(str));
                subscriber.onNext(str);
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = "StereoChannelSettingActivity createStereoGroup: ".concat(String.valueOf(apiError));
                subscriber.onNext(null);
            }
        });
    }

    private void setNameToBluetooth(String str, String str2) {
        ApiHelper.setStereoNameToBluetooth(str, str2, new ApiRequest.Listener<Remote.Response.NullInfo>() {
            /* class com.xiaomi.mico.setting.stereo.StereoChannelSettingActivity.AnonymousClass6 */

            public void onSuccess(Remote.Response.NullInfo nullInfo) {
            }

            public void onFailure(ApiError apiError) {
                StereoChannelSettingActivity.this.dismissProgressDialog();
                new Object[1][0] = "StereoSettingActivity setNameToBluetooth: ".concat(String.valueOf(apiError));
            }
        });
    }

    private Observable queryStereo() {
        return Observable.unsafeCreate(new Observable.OnSubscribe() {
            /* class com.xiaomi.mico.setting.stereo.$$Lambda$StereoChannelSettingActivity$84_WhiG7npI3h8KxOYe0Y_qi8t0 */

            public final void call(Object obj) {
                StereoChannelSettingActivity.this.lambda$queryStereo$7$StereoChannelSettingActivity((Subscriber) obj);
            }
        });
    }

    public /* synthetic */ void lambda$queryStereo$7$StereoChannelSettingActivity(final Subscriber subscriber) {
        ApiHelper.getMicoLanGroup("", "", "stereo", new ApiRequest.Listener<MicoLanGroup>() {
            /* class com.xiaomi.mico.setting.stereo.StereoChannelSettingActivity.AnonymousClass7 */

            public void onSuccess(MicoLanGroup micoLanGroup) {
                if (StereoChannelSettingActivity.this.wakeUpResourceMap == null) {
                    StereoChannelSettingActivity.this.wakeUpResourceMap = new HashMap<>();
                } else {
                    StereoChannelSettingActivity.this.wakeUpResourceMap.clear();
                }
                for (LanGroupInfo.LanGroup next : micoLanGroup.lanGroupInfo.wakeUpLanList) {
                    if (next != null) {
                        int size = next.devices.size();
                        for (int i = 0; i < size; i++) {
                            DeviceState deviceState = next.devices.get(i);
                            StereoChannelSettingActivity.this.wakeUpResourceMap.put(deviceState.deviceId, deviceState.resource);
                        }
                    }
                }
                subscriber.onNext(Boolean.TRUE);
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = "StereoChannelSettingActivity queryStereo onFailure ".concat(String.valueOf(apiError));
                subscriber.onNext(Boolean.FALSE);
            }
        });
    }

    private void switchAwakeStatus() {
        if (MicoManager.getInstance().getMicoByDeviceId(this.mGroupInfo.leftDeviceId).hasCapability(MicoCapability.NEARBY_WAKEUP_CLOUD) || MicoManager.getInstance().getMicoByDeviceId(this.mGroupInfo.rightDeviceId).hasCapability(MicoCapability.NEARBY_WAKEUP_CLOUD)) {
            final DeviceState deviceState = new DeviceState();
            deviceState.deviceId = this.mGroupInfo.leftDeviceId;
            deviceState.hardware = this.mGroupInfo.leftDeviceHardware;
            HashMap<String, String> hashMap = this.wakeUpResourceMap;
            if (hashMap != null) {
                deviceState.resource = hashMap.get(deviceState.deviceId);
            } else {
                deviceState.resource = "wakeup";
            }
            deviceState.deviceName = this.mGroupInfo.leftDeviceName;
            ApiHelper.updateAwakeStatus(deviceState, 1, new ApiRequest.Listener<Boolean>() {
                /* class com.xiaomi.mico.setting.stereo.StereoChannelSettingActivity.AnonymousClass8 */

                public void onSuccess(Boolean bool) {
                    Object[] objArr = {"StereoChannelSettingActivity left device %s %s updateAwakeStatus cloud onSuccess ", deviceState.deviceName, deviceState.deviceId};
                }

                public void onFailure(ApiError apiError) {
                    Object[] objArr = {"StereoChannelSettingActivity left device %s %s updateAwakeStatus cloud onFailure %s", deviceState.deviceName, deviceState.deviceId, apiError};
                }
            });
            final DeviceState deviceState2 = new DeviceState();
            deviceState2.deviceId = this.mGroupInfo.rightDeviceId;
            deviceState2.hardware = this.mGroupInfo.rightDeviceHardware;
            HashMap<String, String> hashMap2 = this.wakeUpResourceMap;
            if (hashMap2 != null) {
                deviceState2.resource = hashMap2.get(deviceState2.deviceId);
            } else {
                deviceState2.resource = "wakeup";
            }
            deviceState2.deviceName = this.mGroupInfo.rightDeviceName;
            ApiHelper.updateAwakeStatus(deviceState2, 1, new ApiRequest.Listener<Boolean>() {
                /* class com.xiaomi.mico.setting.stereo.StereoChannelSettingActivity.AnonymousClass9 */

                public void onSuccess(Boolean bool) {
                    Object[] objArr = {"StereoChannelSettingActivity right device %s %s updateAwakeStatus cloud onSuccess ", deviceState2.deviceName, deviceState2.deviceId};
                }

                public void onFailure(ApiError apiError) {
                    Object[] objArr = {"StereoChannelSettingActivity right device %s %s updateAwakeStatus cloud onFailure %s", deviceState2.deviceName, deviceState2.deviceId, apiError};
                }
            });
            return;
        }
        ApiHelper.setNearbyWakeupStatus(this.mGroupInfo.leftDeviceId, 1, new ApiRequest.Listener<Remote.Response.NullInfo>() {
            /* class com.xiaomi.mico.setting.stereo.StereoChannelSettingActivity.AnonymousClass10 */

            public void onSuccess(Remote.Response.NullInfo nullInfo) {
                Object[] objArr = {"StereoChannelSettingActivity left device %s %s updateAwakeStatus local onSuccess ", StereoChannelSettingActivity.this.mGroupInfo.leftDeviceName, StereoChannelSettingActivity.this.mGroupInfo.leftDeviceId};
            }

            public void onFailure(ApiError apiError) {
                Object[] objArr = {"StereoChannelSettingActivity left device %s %s updateAwakeStatus local onFailure %s", StereoChannelSettingActivity.this.mGroupInfo.leftDeviceName, StereoChannelSettingActivity.this.mGroupInfo.leftDeviceId, apiError};
            }
        });
        ApiHelper.setNearbyWakeupStatus(this.mGroupInfo.rightDeviceId, 1, new ApiRequest.Listener<Remote.Response.NullInfo>() {
            /* class com.xiaomi.mico.setting.stereo.StereoChannelSettingActivity.AnonymousClass11 */

            public void onSuccess(Remote.Response.NullInfo nullInfo) {
                Object[] objArr = {"StereoChannelSettingActivity right device %s %s updateAwakeStatus local onSuccess ", StereoChannelSettingActivity.this.mGroupInfo.rightDeviceName, StereoChannelSettingActivity.this.mGroupInfo.rightDeviceId};
            }

            public void onFailure(ApiError apiError) {
                Object[] objArr = {"StereoChannelSettingActivity right device %s %s updateAwakeStatus local onFailure %s", StereoChannelSettingActivity.this.mGroupInfo.rightDeviceName, StereoChannelSettingActivity.this.mGroupInfo.rightDeviceId, apiError};
            }
        });
    }

    private void updateSoundBoxIcon() {
        Hardware safeValueOf = Hardware.safeValueOf(this.mGroupInfo.leftDeviceHardware.toUpperCase());
        Hardware safeValueOf2 = Hardware.safeValueOf(this.mGroupInfo.rightDeviceHardware.toUpperCase());
        updateSoundBoxIcon(safeValueOf, this.channelLeftDeviceIv);
        updateSoundBoxIcon(safeValueOf2, this.channelRightDeviceIv);
    }

    private static void updateSoundBoxIcon(Hardware hardware, ImageView imageView) {
        if (hardware == Hardware.LX06) {
            imageView.setImageResource(R.drawable.mico_icon_stereo_lx06);
        } else if (hardware == Hardware.L06A) {
            imageView.setImageResource(R.drawable.mico_icon_stereo_lx06a);
        } else if (hardware == Hardware.L09A) {
            imageView.setImageResource(R.drawable.mico_icon_stereo_lx09a);
        } else if (hardware == Hardware.L09B) {
            imageView.setImageResource(R.drawable.mico_icon_stereo_l09b);
        } else if (hardware == Hardware.L15A) {
            imageView.setImageResource(R.drawable.mico_icon_stereo_l15a);
        } else if (hardware == Hardware.L16A) {
            imageView.setImageResource(R.drawable.mico_icon_stereo_l16a);
        }
    }
}

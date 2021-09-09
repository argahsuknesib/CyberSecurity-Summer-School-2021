package com.xiaomi.mico.module.update;

import _m_j.ahg;
import _m_j.ahh;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Admin;
import com.xiaomi.mico.api.model.BaseResponse;
import com.xiaomi.mico.api.model.DeviceStatus;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.application.Hardware;
import com.xiaomi.mico.common.application.MicoCapability;
import com.xiaomi.mico.common.application.UserPreference;
import com.xiaomi.mico.common.util.GsonUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.util.jobqueue.ProgressJob;
import com.xiaomi.mico.module.update.UpdatePresenter;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class RomUpgradeJob extends ProgressJob {
    private String FORCE_UPDATE = "forceUpdate";
    private long LONG_UPGRADE_TIMEOUT_TIME = TimeUnit.MINUTES.toMillis(30);
    private int MAX_TRY_TIMES = 30;
    private long UPGRADE_NORMAL_TIME = TimeUnit.MINUTES.toMillis(2);
    private long UPGRADE_TIMEOUT_TIME = TimeUnit.MINUTES.toMillis(8);
    public ahg loggerNew = new ahg();
    public final Context mContext;
    public int mCurrentStep = 0;
    public DeviceStatus mDeviceStatus;
    public Handler mHandler;
    public int mJobStatus;
    private long mLastCheckTime;
    public int mProgress;
    public String mProgressStatus;
    public long mStartTime;
    public String mStatus = "download";
    public final UpdatePresenter.UpdateInfo mUpdateInfo;
    public final ThirdPartyResponse.RomVersionInfo mVersionInfo;
    private int retryCount = 0;
    private int tryTime = 0;
    private String upgradeVersion;

    public boolean shouldRunImmediately() {
        return true;
    }

    public RomUpgradeJob(UpdatePresenter.UpdateInfo updateInfo) {
        new ahh();
        this.mUpdateInfo = updateInfo;
        this.mVersionInfo = (ThirdPartyResponse.RomVersionInfo) this.mUpdateInfo.getVersionInfo();
        this.mContext = CommonApplication.getAppContext();
        if (this.mVersionInfo.needUpgrade) {
            ahg.O00000Oo("RomUpgrade %s %s %s with %d steps", getId(), this.mVersionInfo.model, this.mVersionInfo.deviceName, Integer.valueOf(this.mVersionInfo.upgradeSteps.size()));
        }
    }

    public String getId() {
        return this.mUpdateInfo.getDeviceId();
    }

    public void onAdded() {
        super.onAdded();
        this.mHandler = new Handler(new Handler.Callback() {
            /* class com.xiaomi.mico.module.update.RomUpgradeJob.AnonymousClass1 */

            public boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    ahg.O00000Oo("upgrade timeout with 8 minutes");
                    RomUpgradeJob.this.onUpgradeFail();
                    return true;
                } else if (i != 3) {
                    return false;
                } else {
                    ApiHelper.getRomUpgradeStatus(RomUpgradeJob.this.mVersionInfo.deviceId, new ApiRequest.Listener<String>() {
                        /* class com.xiaomi.mico.module.update.RomUpgradeJob.AnonymousClass1.AnonymousClass1 */

                        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                        public void onSuccess(String str) {
                            char c;
                            if (str != null) {
                                RomUpgradeJob.this.mDeviceStatus = (DeviceStatus) GsonUtil.getGsonInstance().fromJson(str, DeviceStatus.class);
                                if (RomUpgradeJob.this.mDeviceStatus != null) {
                                    RomUpgradeJob.this.mStatus = RomUpgradeJob.this.mDeviceStatus.status;
                                    RomUpgradeJob.this.mProgress = RomUpgradeJob.this.mDeviceStatus.getProgress();
                                    RomUpgradeJob.this.mHandler.sendEmptyMessageDelayed(3, 1000);
                                    String str2 = RomUpgradeJob.this.mStatus;
                                    switch (str2.hashCode()) {
                                        case -1867169789:
                                            if (str2.equals("success")) {
                                                c = 7;
                                                break;
                                            }
                                            c = 65535;
                                            break;
                                        case -1305289599:
                                            if (str2.equals("extract")) {
                                                c = 4;
                                                break;
                                            }
                                            c = 65535;
                                            break;
                                        case -934938715:
                                            if (str2.equals("reboot")) {
                                                c = 6;
                                                break;
                                            }
                                            c = 65535;
                                            break;
                                        case -869078336:
                                            if (str2.equals("ota_failed")) {
                                                c = 1;
                                                break;
                                            }
                                            c = 65535;
                                            break;
                                        case -819951495:
                                            if (str2.equals("verify")) {
                                                c = 3;
                                                break;
                                            }
                                            c = 65535;
                                            break;
                                        case 3035599:
                                            if (str2.equals("burn")) {
                                                c = 5;
                                                break;
                                            }
                                            c = 65535;
                                            break;
                                        case 156934100:
                                            if (str2.equals("download_failed")) {
                                                c = 2;
                                                break;
                                            }
                                            c = 65535;
                                            break;
                                        case 1427818632:
                                            if (str2.equals("download")) {
                                                c = 0;
                                                break;
                                            }
                                            c = 65535;
                                            break;
                                        default:
                                            c = 65535;
                                            break;
                                    }
                                    switch (c) {
                                        case 0:
                                            RomUpgradeJob.this.mProgressStatus = RomUpgradeJob.this.mContext.getString(R.string.update_rom_downloading);
                                            break;
                                        case 1:
                                        case 2:
                                            RomUpgradeJob.this.mProgressStatus = RomUpgradeJob.this.mContext.getString(R.string.update_rom_downloading_fail);
                                            RomUpgradeJob.this.onUpgradeFail();
                                            break;
                                        case 3:
                                            RomUpgradeJob.this.mProgressStatus = RomUpgradeJob.this.mContext.getString(R.string.update_rom_verify);
                                            break;
                                        case 4:
                                            RomUpgradeJob.this.mProgressStatus = RomUpgradeJob.this.mContext.getString(R.string.update_rom_extract);
                                            break;
                                        case 5:
                                            RomUpgradeJob.this.mProgressStatus = RomUpgradeJob.this.mContext.getString(R.string.update_rom_burn);
                                            break;
                                        case 6:
                                            RomUpgradeJob.this.mProgressStatus = RomUpgradeJob.this.mContext.getString(R.string.update_rom_reboot);
                                            break;
                                        case 7:
                                            RomUpgradeJob.this.mCurrentStep++;
                                            if (RomUpgradeJob.this.mCurrentStep >= RomUpgradeJob.this.mVersionInfo.upgradeSteps.size()) {
                                                ahg.O00000Oo("RomUpgrade %s %s %s onUpgradeSuccess", RomUpgradeJob.this.getId(), RomUpgradeJob.this.mVersionInfo.model, RomUpgradeJob.this.mVersionInfo.deviceName);
                                                RomUpgradeJob.this.mProgressStatus = RomUpgradeJob.this.mContext.getString(R.string.update_rom_success);
                                                RomUpgradeJob.this.onUpgradeSuccess();
                                                break;
                                            } else {
                                                ahg.O00000Oo("RomUpgrade %s %s %s < steps size, start", RomUpgradeJob.this.getId(), RomUpgradeJob.this.mVersionInfo.model, RomUpgradeJob.this.mVersionInfo.deviceName);
                                                RomUpgradeJob.this.start();
                                                break;
                                            }
                                    }
                                    ahg.O00000Oo("RomUpgrade %s %s %s real progress: %s", RomUpgradeJob.this.mVersionInfo.deviceId, RomUpgradeJob.this.mVersionInfo.model, RomUpgradeJob.this.mVersionInfo.deviceName, str);
                                }
                            }
                        }

                        public void onFailure(ApiError apiError) {
                            RomUpgradeJob.this.mHandler.sendEmptyMessageDelayed(3, 1000);
                        }
                    });
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void matchUpgradeStateString(String str) {
        char c;
        switch (str.hashCode()) {
            case -1867169789:
                if (str.equals("success")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1305289599:
                if (str.equals("extract")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -934938715:
                if (str.equals("reboot")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -869078336:
                if (str.equals("ota_failed")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -819951495:
                if (str.equals("verify")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3035599:
                if (str.equals("burn")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 156934100:
                if (str.equals("download_failed")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1427818632:
                if (str.equals("download")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                this.mProgressStatus = this.mContext.getString(R.string.update_rom_downloading);
                return;
            case 1:
            case 2:
                this.mProgressStatus = this.mContext.getString(R.string.update_rom_downloading_fail);
                onUpgradeFail();
                return;
            case 3:
                this.mProgressStatus = this.mContext.getString(R.string.update_rom_verify);
                return;
            case 4:
                this.mProgressStatus = this.mContext.getString(R.string.update_rom_extract);
                return;
            case 5:
                this.mProgressStatus = this.mContext.getString(R.string.update_rom_burn);
                return;
            case 6:
                this.mProgressStatus = this.mContext.getString(R.string.update_rom_reboot);
                return;
            case 7:
                this.mCurrentStep++;
                if (this.mCurrentStep < this.mVersionInfo.upgradeSteps.size()) {
                    start();
                    return;
                }
                this.mProgressStatus = this.mContext.getString(R.string.update_rom_success);
                onUpgradeSuccess();
                return;
            default:
                return;
        }
    }

    public void onUpgradeSuccess() {
        this.mJobStatus = 3;
        this.mProgressStatus = this.mContext.getString(R.string.update_rom_upgrade_success);
        this.mHandler.removeCallbacksAndMessages(null);
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(CommonApplication.getAppContext()).edit();
        edit.putLong("ROM_UPDATE_" + this.mVersionInfo.deviceId, System.currentTimeMillis()).apply();
    }

    public void onUpgradeFail() {
        this.mJobStatus = 4;
        this.mProgressStatus = this.mContext.getString(R.string.update_rom_upgrade_fail);
        this.mHandler.removeCallbacksAndMessages(null);
        ToastUtil.showToast((int) R.string.update_rom_upgrade_fail);
    }

    public void start() {
        super.start();
        this.mStartTime = System.currentTimeMillis();
        UserPreference.setUpgradeTime(getId());
        boolean z = false;
        ahg.O00000Oo("RomUpgrade start %s %s step:%d", this.mUpdateInfo.getDeviceId(), this.mVersionInfo.deviceName, Integer.valueOf(this.mCurrentStep));
        this.mProgressStatus = this.mContext.getString(R.string.update_rom_downloading1);
        this.mJobStatus = 2;
        ThirdPartyResponse.UpgradeInfo upgradeInfo = this.mVersionInfo.getUpgradeInfo(this.mCurrentStep);
        if (upgradeInfo != null) {
            this.upgradeVersion = upgradeInfo.version;
            String str = upgradeInfo.otherParam;
            try {
                Admin.Mico micoByDeviceId = MicoManager.getInstance().getMicoByDeviceId(this.mUpdateInfo.getDeviceId());
                if (micoByDeviceId != null) {
                    z = micoByDeviceId.hasCapability(MicoCapability.FORCE_OTA);
                }
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.put(this.FORCE_UPDATE, z);
                str = jSONObject.toString();
            } catch (Exception e) {
                e.printStackTrace();
                ahg.O000000o(e);
            }
            ApiHelper.upgradeV2(this.mUpdateInfo.getDeviceId(), upgradeInfo.link, upgradeInfo.hash, upgradeInfo.version, this.mVersionInfo.model, str, new ApiRequest.Listener<String>() {
                /* class com.xiaomi.mico.module.update.RomUpgradeJob.AnonymousClass2 */

                public void onSuccess(String str) {
                    BaseResponse baseResponse;
                    ahg.O00000o0("RomUpgradeJob upgradeV2 %s onSuccess = %s", RomUpgradeJob.this.mUpdateInfo.getDeviceId(), str);
                    if (TextUtils.isEmpty(str) || ((baseResponse = (BaseResponse) GsonUtil.getGsonInstance().fromJson(str, BaseResponse.class)) != null && baseResponse.code == 0)) {
                        RomUpgradeJob.this.checkStatus();
                        return;
                    }
                    ahg.O00000o("RomUpgradeJob start upgradeV2 response invalid-> %s ", str);
                    RomUpgradeJob.this.onUpgradeFail();
                }

                public void onFailure(ApiError apiError) {
                    if (apiError.getMessage().contains("request timed out")) {
                        ApiHelper.getRomUpgradeStatus(RomUpgradeJob.this.mVersionInfo.deviceId, new ApiRequest.Listener<String>() {
                            /* class com.xiaomi.mico.module.update.RomUpgradeJob.AnonymousClass2.AnonymousClass1 */

                            public void onSuccess(String str) {
                                ahg.O00000Oo("timed out, RomUpgrade %s %s %s real progress: %s", RomUpgradeJob.this.mVersionInfo.deviceId, RomUpgradeJob.this.mVersionInfo.model, RomUpgradeJob.this.mVersionInfo.deviceName, str);
                                if (str != null) {
                                    RomUpgradeJob.this.mDeviceStatus = (DeviceStatus) GsonUtil.getGsonInstance().fromJson(str, DeviceStatus.class);
                                    if (RomUpgradeJob.this.mDeviceStatus != null && "download".equals(RomUpgradeJob.this.mStatus)) {
                                        return;
                                    }
                                }
                                RomUpgradeJob.this.onUpgradeFail();
                            }

                            public void onFailure(ApiError apiError) {
                                RomUpgradeJob.this.onUpgradeFail();
                            }
                        });
                        return;
                    }
                    ahg.O00000o("RomUpgradeJob start upgradeV2 response onFailure", apiError);
                    RomUpgradeJob.this.onUpgradeFail();
                }
            });
            return;
        }
        onUpgradeFail();
    }

    public void checkStatus() {
        if (this.mVersionInfo.isAndroidRom()) {
            this.mHandler.sendEmptyMessageDelayed(1, this.LONG_UPGRADE_TIMEOUT_TIME);
        } else {
            this.mHandler.sendEmptyMessageDelayed(1, this.UPGRADE_TIMEOUT_TIME);
        }
        this.mHandler.sendEmptyMessageDelayed(3, 1000);
    }

    public long updateTime() {
        if (this.mVersionInfo == null || !Hardware.LX04.getName().equalsIgnoreCase(this.mVersionInfo.model)) {
            return this.UPGRADE_NORMAL_TIME;
        }
        return this.LONG_UPGRADE_TIMEOUT_TIME;
    }

    public int getProgress() {
        if (this.mProgress > 0 || this.mVersionInfo.isAndroidRom()) {
            return this.mProgress;
        }
        int currentTimeMillis = (int) (((System.currentTimeMillis() - this.mStartTime) * 100) / updateTime());
        if (currentTimeMillis >= 100) {
            return 99;
        }
        return currentTimeMillis;
    }

    public int getJobStatus() {
        return this.mJobStatus;
    }

    public String getProgressStatus() {
        return this.mProgressStatus;
    }

    public String getUpgradeVersion() {
        DeviceStatus deviceStatus;
        ThirdPartyResponse.RomVersionInfo romVersionInfo = this.mVersionInfo;
        if (!(romVersionInfo == null || romVersionInfo.upgradeSteps == null || this.mVersionInfo.upgradeSteps.size() <= 0)) {
            Iterator<ThirdPartyResponse.UpgradeInfo> it = this.mVersionInfo.upgradeSteps.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ThirdPartyResponse.UpgradeInfo next = it.next();
                if (!TextUtils.isEmpty(next.version)) {
                    this.upgradeVersion = next.version;
                    break;
                }
            }
            if (TextUtils.isEmpty(this.upgradeVersion) && (deviceStatus = this.mDeviceStatus) != null) {
                this.upgradeVersion = deviceStatus.updateVersion();
            }
        }
        return this.upgradeVersion;
    }

    public void checkUpgrading(final ProgressJob.UpgradingRomCheckLisenler upgradingRomCheckLisenler) {
        ApiHelper.getRomUpgradeStatus(this.mUpdateInfo.getDeviceId(), new ApiRequest.Listener<String>() {
            /* class com.xiaomi.mico.module.update.RomUpgradeJob.AnonymousClass3 */

            public void onSuccess(String str) {
                DeviceStatus deviceStatus;
                if (str != null && (deviceStatus = (DeviceStatus) GsonUtil.getGsonInstance().fromJson(str, DeviceStatus.class)) != null && deviceStatus.isUpgrading(RomUpgradeJob.this.mUpdateInfo.getVersionInfo().version)) {
                    RomUpgradeJob romUpgradeJob = RomUpgradeJob.this;
                    romUpgradeJob.mDeviceStatus = deviceStatus;
                    romUpgradeJob.mStatus = romUpgradeJob.mDeviceStatus.status;
                    RomUpgradeJob romUpgradeJob2 = RomUpgradeJob.this;
                    romUpgradeJob2.mProgress = romUpgradeJob2.mDeviceStatus.getProgress();
                    RomUpgradeJob romUpgradeJob3 = RomUpgradeJob.this;
                    romUpgradeJob3.mJobStatus = 2;
                    long upgradeTime = UserPreference.getUpgradeTime(romUpgradeJob3.getId());
                    if (upgradeTime == 0 || System.currentTimeMillis() - upgradeTime > RomUpgradeJob.this.updateTime()) {
                        RomUpgradeJob.this.mStartTime = System.currentTimeMillis();
                    } else {
                        RomUpgradeJob.this.mStartTime = upgradeTime;
                    }
                    if (RomUpgradeJob.this.mHandler == null) {
                        RomUpgradeJob.this.onAdded();
                    }
                    ahg.O00000o0("RomUpgradeJob checkUpgrading %s device_status/v2 onSuccess = %s then checkStatus by 1 second", RomUpgradeJob.this.mUpdateInfo.getDeviceId(), str);
                    RomUpgradeJob.this.checkStatus();
                    ProgressJob.UpgradingRomCheckLisenler upgradingRomCheckLisenler = upgradingRomCheckLisenler;
                    if (upgradingRomCheckLisenler != null) {
                        upgradingRomCheckLisenler.onUpgrading(deviceStatus);
                    }
                }
            }

            public void onFailure(ApiError apiError) {
                ahg.O00000o0("RomUpgradeJob checkUpgrading %s device_status/v2 onFailure = %s", RomUpgradeJob.this.mUpdateInfo.getDeviceId(), apiError);
            }
        });
    }
}

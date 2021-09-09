package com.xiaomi.mico.module.update;

import _m_j.ahg;
import _m_j.ahh;
import _m_j.jgc;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.LoginManager;
import com.xiaomi.mico.api.model.Admin;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.application.Hardware;
import com.xiaomi.mico.common.application.MicoCapability;
import com.xiaomi.mico.common.micobuild.BuildSettings;
import com.xiaomi.mico.common.util.VersionUtils;
import com.xiaomi.mico.common.util.jobqueue.JobQueueManager;
import com.xiaomi.mico.common.util.jobqueue.ProgressJob;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;

public class UpdatePresenter {
    ahg loggerNew = new ahg();
    public final Context mContext;
    public ThirdPartyResponse.UpdateData mUpdateInfo;
    private ArrayList<UpdateInfo> mUpdateInfos;
    public final IUpdateView mView;

    public interface IUpdateView {
        void onCheckComplete(boolean z, List<UpdateInfo> list);

        void onCheckStart();

        void onRefreshUpdateInfo(boolean z, List<UpdateInfo> list);
    }

    public enum OnlineStatus {
        CHECKING,
        ONLINE,
        OFFLINE
    }

    public enum UpdateType {
        APP,
        ROM
    }

    public UpdatePresenter(Context context, IUpdateView iUpdateView) {
        new ahh();
        this.mContext = context;
        this.mView = iUpdateView;
    }

    public void startCheck() {
        String str;
        this.mView.onCheckStart();
        try {
            str = String.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode);
        } catch (Exception unused) {
            str = "0";
        }
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        for (Admin.Mico next : MicoManager.getInstance().getMicoList()) {
            if (!next.getHardwareType().equals(Hardware.T646)) {
                if (next.isOnline()) {
                    arrayList.add(next.deviceID);
                } else {
                    ThirdPartyResponse.RomVersionInfo romVersionInfo = new ThirdPartyResponse.RomVersionInfo();
                    romVersionInfo.deviceId = next.deviceID;
                    romVersionInfo.deviceName = next.name;
                    romVersionInfo.model = next.hardware;
                    romVersionInfo.version = next.romVersion;
                    romVersionInfo.needUpgrade = false;
                    arrayList2.add(new UpdateInfo(romVersionInfo));
                }
            }
        }
        ApiHelper.getUpdateInfo(BuildSettings.getReleaseChannelNew(this.mContext), str, LoginManager.getInstance().getPassportInfo().getUserId(), this.mContext.getResources().getConfiguration().locale.toString(), arrayList).doOnNext(new Action1<ThirdPartyResponse.UpdateResponse>() {
            /* class com.xiaomi.mico.module.update.UpdatePresenter.AnonymousClass4 */

            public void call(ThirdPartyResponse.UpdateResponse updateResponse) {
                UpdatePresenter.this.mUpdateInfo = updateResponse.data;
            }
        }).flatMap(new Func1<ThirdPartyResponse.UpdateResponse, Observable<ThirdPartyResponse.GrayUpgradeResponse>>() {
            /* class com.xiaomi.mico.module.update.UpdatePresenter.AnonymousClass3 */

            public Observable<ThirdPartyResponse.GrayUpgradeResponse> call(ThirdPartyResponse.UpdateResponse updateResponse) {
                if (BuildSettings.IsDailyBuild) {
                    return ApiHelper.getDailyAppUpgradeInfo(null, null, null, "", "").onErrorResumeNext(new Func1<Throwable, Observable<? extends ThirdPartyResponse.GrayUpgradeResponse>>() {
                        /* class com.xiaomi.mico.module.update.UpdatePresenter.AnonymousClass3.AnonymousClass1 */

                        public Observable<? extends ThirdPartyResponse.GrayUpgradeResponse> call(Throwable th) {
                            return Observable.just(null);
                        }
                    });
                }
                return Observable.just(null);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<ThirdPartyResponse.GrayUpgradeResponse>() {
            /* class com.xiaomi.mico.module.update.UpdatePresenter.AnonymousClass1 */

            public void call(ThirdPartyResponse.GrayUpgradeResponse grayUpgradeResponse) {
                if (grayUpgradeResponse != null) {
                    if (VersionUtils.getVersionCode(UpdatePresenter.this.mContext) < Integer.valueOf(grayUpgradeResponse.data.updateInfo.version).intValue()) {
                        UpdatePresenter.this.mUpdateInfo.appInfo.needUpgrade = false;
                        UpdatePresenter.this.mUpdateInfo.appInfo.upgradeInfo = new ThirdPartyResponse.UpgradeInfo();
                    }
                }
                UpdatePresenter.this.mUpdateInfo.appInfo.channel = BuildSettings.getReleaseChannelNew(UpdatePresenter.this.mContext);
                UpdatePresenter.this.mUpdateInfo.appInfo.deviceName = UpdatePresenter.this.mContext.getString(R.string.update_app_name);
                UpdatePresenter.this.mUpdateInfo.appInfo.version = String.valueOf(VersionUtils.getVersionCode(UpdatePresenter.this.mContext));
                UpdatePresenter.this.mUpdateInfo.appInfo.deviceId = "APP";
                for (ThirdPartyResponse.RomVersionInfo next : UpdatePresenter.this.mUpdateInfo.deviceInfo) {
                    Admin.Mico micoByDeviceId = MicoManager.getInstance().getMicoByDeviceId(next.deviceId);
                    if (micoByDeviceId != null) {
                        next.deviceName = micoByDeviceId.name;
                        next.forceOta = micoByDeviceId.hasCapability(MicoCapability.FORCE_OTA);
                    }
                }
                UpdatePresenter.this.refreshUpdateInfo(arrayList2);
            }
        }, new Action1<Throwable>() {
            /* class com.xiaomi.mico.module.update.UpdatePresenter.AnonymousClass2 */

            public void call(Throwable th) {
                ahg.O000000o(th);
                UpdatePresenter.this.mView.onCheckComplete(false, null);
            }
        });
    }

    public void refreshUpdateInfo(ArrayList<UpdateInfo> arrayList) {
        this.mUpdateInfos = new ArrayList<>();
        for (ThirdPartyResponse.RomVersionInfo updateInfo : this.mUpdateInfo.deviceInfo) {
            this.mUpdateInfos.add(new UpdateInfo(updateInfo));
        }
        this.mUpdateInfos.addAll(arrayList);
        this.mView.onCheckComplete(this.mUpdateInfo.conflict, this.mUpdateInfos);
        this.mView.onRefreshUpdateInfo(this.mUpdateInfo.conflict, this.mUpdateInfos);
    }

    public void upgradeAll() {
        Iterator<UpdateInfo> it = this.mUpdateInfos.iterator();
        while (it.hasNext()) {
            UpdateInfo next = it.next();
            if (next.hasUpdate()) {
                next.upgrade();
            }
        }
    }

    public boolean hasUpdate() {
        ArrayList<UpdateInfo> arrayList = this.mUpdateInfos;
        if (arrayList == null) {
            return false;
        }
        Iterator<UpdateInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().hasUpdate()) {
                return true;
            }
        }
        return false;
    }

    public static class UpdateInfo {
        private String deviceId;
        private Boolean mIsChecking = Boolean.FALSE;
        private ProgressJob mJob;
        private final ThirdPartyResponse.VersionInfo mVersionInfo;
        private int name;

        public OnlineStatus getOnlineStatus() {
            if (this.mIsChecking.booleanValue()) {
                return OnlineStatus.CHECKING;
            }
            if (this.mVersionInfo instanceof ThirdPartyResponse.AppVersionInfo) {
                return OnlineStatus.ONLINE;
            }
            Admin.Mico micoByDeviceId = MicoManager.getInstance().getMicoByDeviceId(this.mVersionInfo.deviceId);
            if (micoByDeviceId != null) {
                return micoByDeviceId.isOnline() ? OnlineStatus.ONLINE : OnlineStatus.OFFLINE;
            }
            return OnlineStatus.OFFLINE;
        }

        public void setIsChecking(Boolean bool) {
            this.mIsChecking = bool;
        }

        public UpdateInfo(ThirdPartyResponse.VersionInfo versionInfo) {
            this.mVersionInfo = versionInfo;
            String jobId = getJobId();
            if (JobQueueManager.instance().hasJob(jobId)) {
                this.mJob = (ProgressJob) JobQueueManager.instance().getJob(jobId);
                if (this.mJob.isFinished()) {
                    this.mJob = null;
                }
            }
            if (this.mJob == null && (versionInfo instanceof ThirdPartyResponse.RomVersionInfo)) {
                this.mJob = new RomUpgradeJob(this);
            }
        }

        public ThirdPartyResponse.VersionInfo getVersionInfo() {
            return this.mVersionInfo;
        }

        public boolean equals(Object obj) {
            if (obj instanceof UpdateInfo) {
                return this.mVersionInfo.deviceId.equals(((UpdateInfo) obj).mVersionInfo.deviceId);
            }
            return false;
        }

        public boolean hasUpdate() {
            boolean z;
            if (this.mVersionInfo instanceof ThirdPartyResponse.RomVersionInfo) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(CommonApplication.getAppContext());
                if (defaultSharedPreferences.getLong("ROM_UPDATE_" + getDeviceId(), 0) + 300000 > System.currentTimeMillis()) {
                    z = false;
                    return getUpgradeJob() == null && z && this.mVersionInfo.needUpgrade && !isUpdating() && getUpgradeJob().getJobStatus() != 3;
                }
            }
            z = true;
            if (getUpgradeJob() == null) {
                return false;
            }
        }

        private String getJobId() {
            return this.mVersionInfo.deviceId;
        }

        public void upgrade() {
            if (!JobQueueManager.instance().hasJob(getJobId()) && this.mJob != null) {
                JobQueueManager.instance().addJob(this.mJob);
            }
            jgc.O000000o().O00000o(new UpgradeEvent(this));
        }

        public ProgressJob getUpgradeJob() {
            return this.mJob;
        }

        public String getCurrentVersionName() {
            if (getUpdateType() == UpdateType.APP) {
                return VersionUtils.formatVersionCode(this.mVersionInfo.version, 1000);
            }
            return this.mVersionInfo.version;
        }

        public String getName(Context context) {
            return this.mVersionInfo.deviceName;
        }

        public String getChannel() {
            return this.mVersionInfo.channel;
        }

        public int getIcon() {
            if (this.mVersionInfo instanceof ThirdPartyResponse.AppVersionInfo) {
                return R.drawable.update_list_icon_phone;
            }
            Hardware safeValueOf = Hardware.safeValueOf(this.mVersionInfo.model, MicoManager.getInstance().getMicoByDeviceId(this.mVersionInfo.deviceId).serialNumber);
            return safeValueOf != null ? safeValueOf.getUpgradeIcon() : R.drawable.icon_s12_upgrade;
        }

        public String getDeviceId() {
            return this.mVersionInfo.deviceId;
        }

        public UpdateType getUpdateType() {
            if (this.mVersionInfo instanceof ThirdPartyResponse.AppVersionInfo) {
                return UpdateType.APP;
            }
            return UpdateType.ROM;
        }

        public boolean isUpdating() {
            return JobQueueManager.instance().hasJob(getJobId());
        }
    }
}

package com.xiaomi.mico.module.update;

import _m_j.gsy;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xiaomi.mico.api.model.DeviceStatus;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import com.xiaomi.mico.common.application.AppVersionUtils;
import com.xiaomi.mico.common.schema.SchemaManager;
import com.xiaomi.mico.common.schema.handler.SkillSchemaHandler;
import com.xiaomi.mico.common.util.jobqueue.ProgressJob;
import com.xiaomi.mico.module.update.UpdatePresenter;
import com.xiaomi.smarthome.R;

public class UpdateItemView extends LinearLayout {
    public String deviceid;
    TextView hasUpdate;
    ImageView icon;
    public OnUpdateRefreshListener listener;
    private Handler mHandler;
    public UpdatePresenter.UpdateInfo mUpdateInfo;
    TextView name;
    ProgressBar progressbar;
    TextView upgradeBtn;
    LinearLayout upgradeItem;
    TextView upgradeStatus;

    public interface OnUpdateRefreshListener {
        void onRefreshLeftIcon();

        void onUpdateSuccess();

        void onUpgrading(boolean z);
    }

    public UpdateItemView(Context context) {
        super(context);
    }

    public UpdateItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.icon = (ImageView) findViewById(R.id.icon);
        this.name = (TextView) findViewById(R.id.name);
        this.hasUpdate = (TextView) findViewById(R.id.has_update);
        this.upgradeStatus = (TextView) findViewById(R.id.upgrade_status);
        this.progressbar = (ProgressBar) findViewById(R.id.progressbar);
        this.upgradeBtn = (TextView) findViewById(R.id.upgrade_btn);
        this.upgradeBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.module.update.$$Lambda$UpdateItemView$t7G5Z3SxSQhGbMqa51knTCuJBMU */

            public final void onClick(View view) {
                UpdateItemView.this.lambda$onFinishInflate$0$UpdateItemView(view);
            }
        });
        this.upgradeItem = (LinearLayout) findViewById(R.id.upgrade_item);
        this.upgradeItem.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.module.update.$$Lambda$UpdateItemView$84HqIZaOA0BOZGb2AYxky73txjQ */

            public final void onClick(View view) {
                UpdateItemView.this.lambda$onFinishInflate$1$UpdateItemView(view);
            }
        });
    }

    public /* synthetic */ void lambda$onFinishInflate$0$UpdateItemView(View view) {
        onUpgradeClick();
    }

    public /* synthetic */ void lambda$onFinishInflate$1$UpdateItemView(View view) {
        onViewChangeLog();
    }

    public void setOnRefreshUIListener(OnUpdateRefreshListener onUpdateRefreshListener) {
        this.listener = onUpdateRefreshListener;
    }

    public void bindData(UpdatePresenter.UpdateInfo updateInfo) {
        this.mUpdateInfo = updateInfo;
        this.deviceid = updateInfo.getDeviceId();
        this.name.setText(updateInfo.getName(getContext()));
        this.hasUpdate.setVisibility(8);
        this.upgradeBtn.setVisibility(8);
        this.progressbar.setVisibility(8);
        this.icon.setImageResource(updateInfo.getIcon());
        int i = AnonymousClass3.$SwitchMap$com$xiaomi$mico$module$update$UpdatePresenter$OnlineStatus[updateInfo.getOnlineStatus().ordinal()];
        if (i == 1) {
            this.upgradeStatus.setText((int) R.string.update_device_checking);
        } else if (i == 2) {
            scheduleRefresh();
            checkUpgrading();
        } else if (i == 3) {
            this.upgradeStatus.setText((int) R.string.update_device_offline);
        }
    }

    /* renamed from: com.xiaomi.mico.module.update.UpdateItemView$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaomi$mico$module$update$UpdatePresenter$OnlineStatus = new int[UpdatePresenter.OnlineStatus.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            $SwitchMap$com$xiaomi$mico$module$update$UpdatePresenter$OnlineStatus[UpdatePresenter.OnlineStatus.CHECKING.ordinal()] = 1;
            $SwitchMap$com$xiaomi$mico$module$update$UpdatePresenter$OnlineStatus[UpdatePresenter.OnlineStatus.ONLINE.ordinal()] = 2;
            try {
                $SwitchMap$com$xiaomi$mico$module$update$UpdatePresenter$OnlineStatus[UpdatePresenter.OnlineStatus.OFFLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void refreshUI() {
        ProgressJob upgradeJob = this.mUpdateInfo.getUpgradeJob();
        gsy.O000000o(3, "UpdateItemView", "job status : " + upgradeJob.getJobStatus());
        this.hasUpdate.setVisibility(8);
        this.upgradeBtn.setVisibility(8);
        this.progressbar.setVisibility(8);
        if (upgradeJob != null) {
            if (!TextUtils.isEmpty(upgradeJob.getProgressStatus())) {
                this.upgradeStatus.setText(upgradeJob.getProgressStatus());
            }
            int jobStatus = upgradeJob.getJobStatus();
            if (jobStatus == 0) {
                refreshUpdateInfo();
            } else if (jobStatus == 1) {
                Handler handler = this.mHandler;
                if (handler != null && !handler.hasMessages(1)) {
                    this.mHandler.sendEmptyMessageDelayed(1, 1000);
                }
            } else if (jobStatus == 2) {
                this.progressbar.setVisibility(0);
                this.progressbar.setProgress(upgradeJob.getProgress());
                Handler handler2 = this.mHandler;
                if (handler2 != null && !handler2.hasMessages(1)) {
                    this.mHandler.sendEmptyMessageDelayed(1, 1000);
                }
            } else if (jobStatus == 3) {
                refreshUpdateSuccess(upgradeJob.getUpgradeVersion());
            } else if (jobStatus == 4) {
                refreshUpdateInfo();
            }
        } else {
            refreshUpdateInfo();
        }
    }

    private void refreshUpdateSuccess(String str) {
        String str2;
        this.progressbar.setVisibility(8);
        this.hasUpdate.setVisibility(8);
        this.upgradeBtn.setVisibility(8);
        if (this.mUpdateInfo.getUpdateType() == UpdatePresenter.UpdateType.ROM) {
            str2 = AppVersionUtils.getChannelName(getContext(), this.mUpdateInfo.getChannel());
        } else {
            str2 = AppVersionUtils.getAppChannelName(getContext(), this.mUpdateInfo.getChannel());
        }
        if (TextUtils.isEmpty(str)) {
            str = this.mUpdateInfo.getCurrentVersionName();
        }
        this.upgradeStatus.setText(getContext().getString(R.string.update_version_info, str, str2));
        this.upgradeStatus.setVisibility(0);
        OnUpdateRefreshListener onUpdateRefreshListener = this.listener;
        if (onUpdateRefreshListener != null) {
            onUpdateRefreshListener.onUpdateSuccess();
        }
        stopScheduleRefresh();
    }

    private void refreshUpdateInfo() {
        String str;
        int i = 8;
        this.progressbar.setVisibility(8);
        this.hasUpdate.setVisibility(this.mUpdateInfo.hasUpdate() ? 0 : 8);
        TextView textView = this.upgradeBtn;
        if (this.mUpdateInfo.hasUpdate()) {
            i = 0;
        }
        textView.setVisibility(i);
        if (this.mUpdateInfo.getUpdateType() == UpdatePresenter.UpdateType.ROM) {
            str = AppVersionUtils.getChannelName(getContext(), this.mUpdateInfo.getChannel());
        } else {
            str = AppVersionUtils.getAppChannelName(getContext(), this.mUpdateInfo.getChannel());
        }
        this.upgradeStatus.setText(getContext().getString(R.string.update_version_info, this.mUpdateInfo.getCurrentVersionName(), str));
        this.upgradeStatus.setVisibility(0);
        stopScheduleRefresh();
    }

    /* access modifiers changed from: package-private */
    public void onUpgradeClick() {
        Object[] objArr = {"UpdateItemView onUpgradeClick deviceName %s, deviceId %s", this.mUpdateInfo.getName(getContext()), this.mUpdateInfo.getDeviceId()};
        this.mUpdateInfo.upgrade();
        this.hasUpdate.setVisibility(8);
        this.upgradeBtn.setVisibility(8);
        OnUpdateRefreshListener onUpdateRefreshListener = this.listener;
        if (onUpdateRefreshListener != null) {
            onUpdateRefreshListener.onRefreshLeftIcon();
        }
        scheduleRefresh();
    }

    /* access modifiers changed from: package-private */
    public void onViewChangeLog() {
        ThirdPartyResponse.VersionInfo versionInfo = this.mUpdateInfo.getVersionInfo();
        String str = versionInfo.changelogUrl;
        if (this.mUpdateInfo.hasUpdate()) {
            if (versionInfo instanceof ThirdPartyResponse.RomVersionInfo) {
                ThirdPartyResponse.RomVersionInfo romVersionInfo = (ThirdPartyResponse.RomVersionInfo) versionInfo;
                str = romVersionInfo.upgradeSteps.get(romVersionInfo.upgradeSteps.size() - 1).changelogUrl;
            } else if (versionInfo instanceof ThirdPartyResponse.AppVersionInfo) {
                str = ((ThirdPartyResponse.AppVersionInfo) versionInfo).upgradeInfo.changelogUrl;
            }
        }
        SchemaManager.handleSchema(getContext(), SkillSchemaHandler.buildWebSchema(getContext().getString(R.string.update_change_log), str, false));
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopScheduleRefresh();
    }

    private void stopScheduleRefresh() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
    }

    public void scheduleRefresh() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(new Handler.Callback() {
                /* class com.xiaomi.mico.module.update.UpdateItemView.AnonymousClass1 */

                public boolean handleMessage(Message message) {
                    if (message.what != 1 || UpdateItemView.this.deviceid == null || !UpdateItemView.this.deviceid.equals(UpdateItemView.this.mUpdateInfo.getDeviceId())) {
                        return false;
                    }
                    UpdateItemView.this.refreshUI();
                    return false;
                }
            });
        }
        this.mHandler.sendEmptyMessageDelayed(1, 100);
    }

    private void checkUpgrading() {
        ProgressJob upgradeJob = this.mUpdateInfo.getUpgradeJob();
        if (upgradeJob != null) {
            upgradeJob.checkUpgrading(new ProgressJob.UpgradingRomCheckLisenler() {
                /* class com.xiaomi.mico.module.update.UpdateItemView.AnonymousClass2 */

                public void onUpgrading(DeviceStatus deviceStatus) {
                    UpdateItemView.this.scheduleRefresh();
                    if (UpdateItemView.this.listener != null) {
                        UpdateItemView.this.listener.onUpgrading(deviceStatus.isUpgrading(UpdateItemView.this.mUpdateInfo.getVersionInfo().version));
                    }
                }
            });
        }
    }
}

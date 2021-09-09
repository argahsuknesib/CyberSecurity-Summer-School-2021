package com.xiaomi.mico.common.util.jobqueue;

import _m_j.ahg;
import _m_j.ahh;
import com.xiaomi.mico.api.model.DeviceStatus;

public class ProgressJob implements IJob {
    ahg loggerNew = new ahg();

    public interface UpgradingRomCheckLisenler {
        void onUpgrading(DeviceStatus deviceStatus);
    }

    public void checkUpgrading(UpgradingRomCheckLisenler upgradingRomCheckLisenler) {
    }

    public String getId() {
        return "";
    }

    public int getJobStatus() {
        return 0;
    }

    public int getProgress() {
        return 0;
    }

    public String getProgressStatus() {
        return "";
    }

    public String getUpgradeVersion() {
        return "";
    }

    public boolean shouldRunImmediately() {
        return false;
    }

    public ProgressJob() {
        new ahh();
    }

    public void onAdded() {
        ahg.O00000o0("onAdded %s", toString());
    }

    public boolean isRunning() {
        return getJobStatus() == 2;
    }

    public boolean isFinished() {
        return getJobStatus() == 3 || getJobStatus() == 4;
    }

    public void start() {
        ahg.O00000o0("onAdded %s", toString());
    }

    public String toString() {
        return getClass().getSimpleName() + " " + getId();
    }
}

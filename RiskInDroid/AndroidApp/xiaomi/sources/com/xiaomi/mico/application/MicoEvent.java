package com.xiaomi.mico.application;

import com.xiaomi.mico.api.model.Admin;
import com.xiaomi.mico.api.model.Remote;

public class MicoEvent {

    public static class AccountLogin {
    }

    public static class AccountLogout {
    }

    public static class CurrentMicoInfoUpdate {
    }

    public static class ForceUpdate {
    }

    public static class InitDeviceSuccess {
    }

    public static class RingConfigUpdated {
    }

    public static class SecondTabSwitched {
    }

    public static class ServerEnvSwitched {
    }

    public static class SkillPopToastDismissEvent {
    }

    public static class CurrentMicoChanged {
        public String queryDeviceId;

        public CurrentMicoChanged() {
        }

        public CurrentMicoChanged(String str) {
            this.queryDeviceId = str;
        }
    }

    public static class MicoAutoSwitched {
        public Admin.Mico current;
        public Admin.Mico previous;
        public Reason reason;

        public enum Reason {
            BIND,
            UNBIND,
            LACK_OF_PERMISSION
        }

        MicoAutoSwitched(Reason reason2, Admin.Mico mico) {
            this.reason = reason2;
            this.current = mico;
        }

        MicoAutoSwitched(Reason reason2, Admin.Mico mico, Admin.Mico mico2) {
            this.reason = reason2;
            this.previous = mico;
            this.current = mico2;
        }
    }

    public static class UpdateAssistant {
        public boolean needUpdate;

        public UpdateAssistant(boolean z) {
            this.needUpdate = z;
        }
    }

    public static class AlarmRingChange {
        public Remote.Response.AlarmRing ring;

        public AlarmRingChange(Remote.Response.AlarmRing alarmRing) {
            this.ring = alarmRing;
        }
    }
}

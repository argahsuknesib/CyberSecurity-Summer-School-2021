package com.xiaomi.smarthome.smartconfig;

import _m_j.fbs;
import _m_j.huo;
import _m_j.hup;
import _m_j.huq;
import _m_j.hur;
import _m_j.hus;
import _m_j.hut;
import _m_j.huu;
import _m_j.huz;
import _m_j.hva;
import _m_j.hvb;
import _m_j.hvc;
import _m_j.hvd;
import _m_j.hve;
import _m_j.hvf;
import androidx.annotation.Keep;

@Keep
public class SmartConfigRouterFactory {
    public static void selfCheck() {
        if (fbs.O000000o(huz.class, "key.com.xiaomi.smarthome.smartconfig.core.api.router") == null) {
            throw new RuntimeException("ICoreApiManager does not implement classes");
        } else if (fbs.O000000o(hvb.class, "key.com.xiaomi.smarthome.smartconfig.main.router") == null) {
            throw new RuntimeException("ISmartConfigManager does not implement classes");
        } else if (fbs.O000000o(hvc.class, "key.com.xiaomi.smarthome.smartconfig.stat.bind.router") == null) {
            throw new RuntimeException("IStatBindManager does not implement classes");
        } else if (fbs.O000000o(hvd.class, "key.com.xiaomi.smarthome.smartconfig.stat.click.router") == null) {
            throw new RuntimeException("IStatClickManager does not implement classes");
        } else if (fbs.O000000o(hve.class, "key.com.xiaomi.smarthome.smartconfig.stat.page.router") == null) {
            throw new RuntimeException("IStatPagev2Manager does not implement classes");
        } else if (fbs.O000000o(hvf.class, "key.com.xiaomi.smarthome.smartconfig.stat.result.router") == null) {
            throw new RuntimeException("IStatResultManager does not implement classes");
        } else if (fbs.O000000o(hva.class, "key.com.xiaomi.smarthome.home..router") == null) {
            throw new RuntimeException("IHomeManager does not implement classes");
        }
    }

    public static huz getCoreApiManager() {
        if (fbs.O000000o(huz.class, "key.com.xiaomi.smarthome.smartconfig.core.api.router") != null) {
            return (huz) fbs.O000000o(huz.class, "key.com.xiaomi.smarthome.smartconfig.core.api.router");
        }
        return new huo();
    }

    public static hvb getSmartConfigManager() {
        if (fbs.O000000o(hvb.class, "key.com.xiaomi.smarthome.smartconfig.main.router") != null) {
            return (hvb) fbs.O000000o(hvb.class, "key.com.xiaomi.smarthome.smartconfig.main.router");
        }
        return new huq();
    }

    public static hvc getStatBindManager() {
        if (fbs.O000000o(hvc.class, "key.com.xiaomi.smarthome.smartconfig.stat.bind.router") != null) {
            return (hvc) fbs.O000000o(hvc.class, "key.com.xiaomi.smarthome.smartconfig.stat.bind.router");
        }
        return new hur();
    }

    public static hvd getStatClickManager() {
        if (fbs.O000000o(hvd.class, "key.com.xiaomi.smarthome.smartconfig.stat.click.router") != null) {
            return (hvd) fbs.O000000o(hvd.class, "key.com.xiaomi.smarthome.smartconfig.stat.click.router");
        }
        return new hus();
    }

    public static hve getStatPageV2Manager() {
        if (fbs.O000000o(hve.class, "key.com.xiaomi.smarthome.smartconfig.stat.page.router") != null) {
            return (hve) fbs.O000000o(hve.class, "key.com.xiaomi.smarthome.smartconfig.stat.page.router");
        }
        return new hut();
    }

    public static hvf getStatResultManager() {
        if (fbs.O000000o(hvf.class, "key.com.xiaomi.smarthome.smartconfig.stat.result.router") != null) {
            return (hvf) fbs.O000000o(hvf.class, "key.com.xiaomi.smarthome.smartconfig.stat.result.router");
        }
        return new huu();
    }

    public static hva getHomeManager() {
        if (fbs.O000000o(hva.class, "key.com.xiaomi.smarthome.home..router") != null) {
            return (hva) fbs.O000000o(hva.class, "key.com.xiaomi.smarthome.home..router");
        }
        return new hup();
    }
}

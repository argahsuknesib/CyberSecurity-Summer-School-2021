package com.xiaomi.mico.common.application;

import _m_j.ahg;
import com.xiaomi.mico.common.log.L;
import com.xiaomi.smarthome.R;

public enum Hardware implements HardwareConfig {
    L09A {
        public final String getAIClientId() {
            return "527512289645953024";
        }

        public final int getAlarmVolume() {
            return 30;
        }

        public final int getBLEType() {
            return 15;
        }

        public final int getDefaultAlias() {
            return R.string.mico_bind_alias_l09a_default;
        }

        public final int getImageBig() {
            return R.drawable.mico_img_found_l09a_big;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_l09a_menu;
        }

        public final String getName() {
            return "L09A";
        }

        public final int getScanIcon() {
            return R.drawable.mico_img_found_l09a;
        }

        public final int getTimerVolume() {
            return 59;
        }

        public final int getUpgradeIcon() {
            return R.drawable.mico_icon_l09a_upgrade;
        }

        public final boolean isAndroidRom() {
            return false;
        }

        public final boolean support5GHz() {
            return true;
        }
    },
    L07A_BLUE {
        public final String getAIClientId() {
            return "486994720757645312";
        }

        public final int getAlarmVolume() {
            return 36;
        }

        public final int getBLEType() {
            return 12;
        }

        public final int getDefaultAlias() {
            return R.string.mico_bind_alias_l07a_default;
        }

        public final int getImageBig() {
            return R.drawable.mico_img_found_l07a_blue_big;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_l07a_menu;
        }

        public final String getName() {
            return "L07A_BLUE";
        }

        public final int getScanIcon() {
            return R.drawable.mico_img_found_l07a_blue;
        }

        public final int getTimerVolume() {
            return 48;
        }

        public final int getUpgradeIcon() {
            return R.drawable.mico_icon_l07a_upgrade_blue;
        }

        public final boolean isAndroidRom() {
            return false;
        }

        public final boolean support5GHz() {
            return false;
        }

        public final boolean supportVoip() {
            return false;
        }
    },
    L07A_GREEN {
        public final String getAIClientId() {
            return "486994720757645312";
        }

        public final int getAlarmVolume() {
            return 36;
        }

        public final int getBLEType() {
            return 12;
        }

        public final int getDefaultAlias() {
            return R.string.mico_bind_alias_l07a_default;
        }

        public final int getImageBig() {
            return R.drawable.mico_img_found_l07a_green_big;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_l07a_menu;
        }

        public final String getName() {
            return "L07A_GREEN";
        }

        public final int getScanIcon() {
            return R.drawable.mico_img_found_l07a_green;
        }

        public final int getTimerVolume() {
            return 48;
        }

        public final int getUpgradeIcon() {
            return R.drawable.mico_icon_l07a_upgrade_green;
        }

        public final boolean isAndroidRom() {
            return false;
        }

        public final boolean support5GHz() {
            return false;
        }

        public final boolean supportVoip() {
            return false;
        }
    },
    L07A {
        public final String getAIClientId() {
            return "486994720757645312";
        }

        public final int getAlarmVolume() {
            return 36;
        }

        public final int getBLEType() {
            return 12;
        }

        public final int getDefaultAlias() {
            return R.string.mico_bind_alias_l07a_default;
        }

        public final int getImageBig() {
            return R.drawable.mico_img_found_l07a_big;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_l07a_menu;
        }

        public final String getName() {
            return "L07A";
        }

        public final int getScanIcon() {
            return R.drawable.mico_img_found_l07a;
        }

        public final int getTimerVolume() {
            return 48;
        }

        public final int getUpgradeIcon() {
            return R.drawable.mico_icon_l07a_upgrade;
        }

        public final boolean isAndroidRom() {
            return false;
        }

        public final boolean support5GHz() {
            return false;
        }

        public final boolean supportVoip() {
            return false;
        }
    },
    X06A {
        public final String getAIClientId() {
            return "528885308293382144";
        }

        public final int getAlarmVolume() {
            return 30;
        }

        public final int getBLEType() {
            return 16;
        }

        public final int getDefaultAlias() {
            return R.string.mico_bind_alias_x08a_default;
        }

        public final int getImageBig() {
            return R.drawable.mico_img_found_x08a_big;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_x08a_menu;
        }

        public final String getName() {
            return "X06A";
        }

        public final int getScanIcon() {
            return R.drawable.mico_img_found_x08a;
        }

        public final int getTimerVolume() {
            return 59;
        }

        public final int getUpgradeIcon() {
            return R.drawable.mico_icon_x08a_upgrade;
        }

        public final boolean hasCapabilityVideoAlarm() {
            return true;
        }

        public final boolean hasScreen() {
            return true;
        }

        public final boolean isAndroidRom() {
            return true;
        }

        public final boolean needAuthXiaomiAccount() {
            return true;
        }

        public final boolean needBindToServer() {
            return false;
        }
    },
    X08A {
        public final String getAIClientId() {
            return "486990470963004416";
        }

        public final int getAlarmVolume() {
            return 30;
        }

        public final int getBLEType() {
            return 10;
        }

        public final int getDefaultAlias() {
            return R.string.mico_bind_alias_x08a_default;
        }

        public final int getImageBig() {
            return R.drawable.mico_img_found_x08a_big;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_x08a_menu;
        }

        public final String getName() {
            return "X08A";
        }

        public final int getScanIcon() {
            return R.drawable.mico_img_found_x08a;
        }

        public final int getTimerVolume() {
            return 59;
        }

        public final int getUpgradeIcon() {
            return R.drawable.mico_icon_x08a_upgrade;
        }

        public final boolean hasCapabilityVideoAlarm() {
            return true;
        }

        public final boolean hasScreen() {
            return true;
        }

        public final boolean isAndroidRom() {
            return true;
        }

        public final boolean needAuthXiaomiAccount() {
            return true;
        }

        public final boolean needBindToServer() {
            return false;
        }
    },
    X08B {
        public final String getAIClientId() {
            return "486990470963004416";
        }

        public final int getAlarmVolume() {
            return 30;
        }

        public final int getBLEType() {
            return 13;
        }

        public final int getDefaultAlias() {
            return R.string.mico_bind_alias_x08b_default;
        }

        public final int getImageBig() {
            return R.drawable.mico_img_found_x08a_big;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_x08a_menu;
        }

        public final String getName() {
            return "X08B";
        }

        public final int getScanIcon() {
            return R.drawable.mico_img_found_x08a;
        }

        public final int getTimerVolume() {
            return 59;
        }

        public final int getUpgradeIcon() {
            return R.drawable.mico_icon_x08a_upgrade;
        }

        public final boolean hasCapabilityVideoAlarm() {
            return true;
        }

        public final boolean hasScreen() {
            return true;
        }

        public final boolean isAndroidRom() {
            return true;
        }

        public final boolean needAuthXiaomiAccount() {
            return true;
        }

        public final boolean needBindToServer() {
            return false;
        }
    },
    X08C {
        public final String getAIClientId() {
            return "527449393826104320";
        }

        public final int getAlarmVolume() {
            return 30;
        }

        public final int getBLEType() {
            return 14;
        }

        public final int getDefaultAlias() {
            return R.string.mico_bind_alias_x08c_default;
        }

        public final int getImageBig() {
            return R.drawable.mico_img_found_x08c_big;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_x08c_menu;
        }

        public final String getName() {
            return "X08C";
        }

        public final int getScanIcon() {
            return R.drawable.mico_img_found_x08c;
        }

        public final int getTimerVolume() {
            return 59;
        }

        public final int getUpgradeIcon() {
            return R.drawable.mico_icon_x08c_upgrade;
        }

        public final boolean hasCapabilityVideoAlarm() {
            return true;
        }

        public final boolean hasScreen() {
            return true;
        }

        public final boolean isAndroidRom() {
            return true;
        }

        public final boolean needAuthXiaomiAccount() {
            return true;
        }

        public final boolean needBindToServer() {
            return false;
        }

        public final boolean support5GHz() {
            return false;
        }
    },
    L06A {
        public final String getAIClientId() {
            return "461124604870524928";
        }

        public final int getAlarmVolume() {
            return 30;
        }

        public final int getBLEType() {
            return 9;
        }

        public final int getDefaultAlias() {
            return R.string.mico_default_alias;
        }

        public final int getImageBig() {
            return R.drawable.mico_img_found_l06a_big;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_l06a_menu;
        }

        public final String getName() {
            return "L06A";
        }

        public final int getScanIcon() {
            return R.drawable.mico_img_found_l06a;
        }

        public final int getTimerVolume() {
            return 59;
        }

        public final int getUpgradeIcon() {
            return R.drawable.mico_icon_l06a_upgrade;
        }

        public final boolean isAndroidRom() {
            return false;
        }
    },
    LX06 {
        public final String getAIClientId() {
            return "425753316392175616";
        }

        public final int getAlarmVolume() {
            return 30;
        }

        public final int getBLEType() {
            return 8;
        }

        public final int getDefaultAlias() {
            return R.string.mico_bind_alias_lx06_default;
        }

        public final int getImageBig() {
            return R.drawable.mico_img_found_lx06_big;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_lx06_menu;
        }

        public final String getName() {
            return "LX06";
        }

        public final int getScanIcon() {
            return R.drawable.mico_img_found_lx06;
        }

        public final int getTimerVolume() {
            return 59;
        }

        public final int getUpgradeIcon() {
            return R.drawable.mico_icon_lx06_upgrade;
        }

        public final boolean isAndroidRom() {
            return false;
        }

        public final boolean supportIR() {
            return true;
        }
    },
    LX05A {
        public final String getAIClientId() {
            return "396248989835468800";
        }

        public final int getAlarmVolume() {
            return 36;
        }

        public final int getBLEType() {
            return 7;
        }

        public final int getDefaultAlias() {
            return R.string.mico_bind_alias_lx05a_default;
        }

        public final int getImageBig() {
            return R.drawable.mico_img_found_lx05a_big;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_lx05a_menu;
        }

        public final String getName() {
            return "LX05A";
        }

        public final int getScanIcon() {
            return R.drawable.mico_img_found_lx05a;
        }

        public final int getTimerVolume() {
            return 48;
        }

        public final int getUpgradeIcon() {
            return R.drawable.mico_icon_lx05a_upgrade;
        }

        public final boolean isAndroidRom() {
            return false;
        }

        public final boolean support5GHz() {
            return false;
        }

        public final boolean supportIR() {
            return true;
        }
    },
    LX05 {
        public final String getAIClientId() {
            return "353933914248580096";
        }

        public final int getAlarmVolume() {
            return 36;
        }

        public final int getBLEType() {
            return 6;
        }

        public final int getDefaultAlias() {
            return R.string.mico_bind_alias_lx05_default;
        }

        public final int getImageBig() {
            return R.drawable.mico_img_found_lx05_big;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_lx05_menu;
        }

        public final String getName() {
            return "LX05";
        }

        public final int getScanIcon() {
            return R.drawable.mico_img_found_lx05;
        }

        public final int getTimerVolume() {
            return 48;
        }

        public final int getUpgradeIcon() {
            return R.drawable.mico_icon_lx05_upgrade;
        }

        public final boolean isAndroidRom() {
            return false;
        }

        public final boolean support5GHz() {
            return false;
        }

        public final boolean supportVoip() {
            return false;
        }
    },
    LX04 {
        public final String getAIClientId() {
            return "310807211611790336";
        }

        public final int getAlarmVolume() {
            return 50;
        }

        public final int getBLEType() {
            return 5;
        }

        public final int getDefaultAlias() {
            return R.string.mico_bind_alias_lx04_default;
        }

        public final int getImageBig() {
            return R.drawable.mico_img_found_lx04_big;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_lx04_menu;
        }

        public final String getName() {
            return "LX04";
        }

        public final int getScanIcon() {
            return R.drawable.mico_img_found_lx04;
        }

        public final int getTimerVolume() {
            return 60;
        }

        public final int getUpgradeIcon() {
            return R.drawable.mico_icon_lx04_upgrade;
        }

        public final boolean hasCapabilityVideoAlarm() {
            return true;
        }

        public final boolean hasScreen() {
            return true;
        }

        public final boolean isAndroidRom() {
            return true;
        }

        public final boolean needAuthXiaomiAccount() {
            return true;
        }

        public final boolean needBindToServer() {
            return false;
        }

        public final boolean support5GHz() {
            return false;
        }
    },
    M01 {
        public final String getAIClientId() {
            return "292009787862814720";
        }

        public final int getAlarmVolume() {
            return 25;
        }

        public final int getBLEType() {
            return 4;
        }

        public final int getDefaultAlias() {
            return R.string.mico_bind_alias_default_m01;
        }

        public final int getImageBig() {
            return R.drawable.mico_img_found_big_m01;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_m01_menu;
        }

        public final String getName() {
            return "M01";
        }

        public final int getScanIcon() {
            return R.drawable.mico_img_found_m01;
        }

        public final int getTimerVolume() {
            return 45;
        }

        public final int getUpgradeIcon() {
            return R.drawable.mico_icon_m01_upgrade;
        }

        public final boolean isAndroidRom() {
            return false;
        }

        public final boolean supportVoip() {
            return false;
        }
    },
    S12 {
        public final String getAIClientId() {
            return "2882303761517406012";
        }

        public final int getAlarmVolume() {
            return 16;
        }

        public final int getBLEType() {
            return 0;
        }

        public final int getDefaultAlias() {
            return R.string.mico_bind_alias_default;
        }

        public final int getImageBig() {
            return R.drawable.mico_img_found_s12_big;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_s12_menu;
        }

        public final String getName() {
            return "S12";
        }

        public final int getScanIcon() {
            return R.drawable.mico_img_found_s12;
        }

        public final int getTimerVolume() {
            return 45;
        }

        public final int getUpgradeIcon() {
            return R.drawable.mico_icon_s12_upgrade;
        }

        public final boolean isAndroidRom() {
            return false;
        }
    },
    S12A {
        public final String getAIClientId() {
            return "2882303761517406012";
        }

        public final int getAlarmVolume() {
            return 16;
        }

        public final int getBLEType() {
            return 0;
        }

        public final int getDefaultAlias() {
            return R.string.mico_bind_alias_default;
        }

        public final int getImageBig() {
            return R.drawable.mico_img_found_s12_big;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_s12_menu;
        }

        public final String getName() {
            return "S12A";
        }

        public final int getScanIcon() {
            return R.drawable.mico_img_found_s12;
        }

        public final int getTimerVolume() {
            return 45;
        }

        public final int getUpgradeIcon() {
            return R.drawable.mico_icon_s12_upgrade;
        }

        public final boolean isAndroidRom() {
            return false;
        }
    },
    LX01 {
        public final String getAIClientId() {
            return "262522317551175680";
        }

        public final int getAlarmVolume() {
            return 42;
        }

        public final int getBLEType() {
            return 1;
        }

        public final int getDefaultAlias() {
            return R.string.mico_bind_alias_lx01_default;
        }

        public final int getImageBig() {
            return R.drawable.mico_img_found_lx01_big;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_lx01_menu;
        }

        public final String getName() {
            return "LX01";
        }

        public final int getScanIcon() {
            return R.drawable.mico_img_found_lx01;
        }

        public final int getTimerVolume() {
            return 60;
        }

        public final int getUpgradeIcon() {
            return R.drawable.mico_icon_lx01_upgrade;
        }

        public final boolean isAndroidRom() {
            return false;
        }

        public final boolean support5GHz() {
            return false;
        }
    },
    S6 {
        public final String getAIClientId() {
            return "2882303761517405987";
        }

        public final int getAlarmVolume() {
            return 20;
        }

        public final int getBLEType() {
            return 3;
        }

        public final int getDefaultAlias() {
            return R.string.mico_bind_alias_s6_default;
        }

        public final int getImageBig() {
            return R.drawable.mico_img_found_s6_big;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_s6_menu;
        }

        public final String getName() {
            return "S6";
        }

        public final int getScanIcon() {
            return R.drawable.mico_img_found_s6;
        }

        public final int getTimerVolume() {
            return 20;
        }

        public final int getUpgradeIcon() {
            return R.drawable.mico_icon_s6_upgrade;
        }

        public final boolean isAndroidRom() {
            return false;
        }

        public final boolean supportVoip() {
            return false;
        }
    },
    T646 {
        public final String getAIClientId() {
            return "332154829059134464";
        }

        public final int getAlarmVolume() {
            return 20;
        }

        public final int getBLEType() {
            return -1;
        }

        public final int getDefaultAlias() {
            return R.string.mico_bind_alias_t646_default;
        }

        public final int getImageBig() {
            return -1;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_t646_tv_menu;
        }

        public final String getName() {
            return "T646";
        }

        public final int getScanIcon() {
            return -1;
        }

        public final int getTimerVolume() {
            return 20;
        }

        public final int getUpgradeIcon() {
            return -1;
        }

        public final boolean hasScreen() {
            return true;
        }

        public final boolean isAndroidRom() {
            return false;
        }

        public final boolean supportVoip() {
            return false;
        }
    },
    AI02 {
        public final String getAIClientId() {
            return "413372885600575488";
        }

        public final int getAlarmVolume() {
            return 36;
        }

        public final int getBLEType() {
            return 17;
        }

        public final int getDefaultAlias() {
            return R.string.mico_bind_alias_lx05a_default;
        }

        public final int getImageBig() {
            return R.drawable.mico_img_found_lx05a_big;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_lx05a_menu;
        }

        public final String getName() {
            return "AI02";
        }

        public final int getScanIcon() {
            return R.drawable.mico_img_found_lx05a;
        }

        public final int getTimerVolume() {
            return 48;
        }

        public final int getUpgradeIcon() {
            return R.drawable.mico_icon_lx05a_upgrade;
        }

        public final boolean isAndroidRom() {
            return false;
        }

        public final boolean support5GHz() {
            return false;
        }
    },
    X08E {
        public final String getAIClientId() {
            return "530351618386821120";
        }

        public final int getAlarmVolume() {
            return 30;
        }

        public final int getBLEType() {
            return 18;
        }

        public final int getDefaultAlias() {
            return R.string.mico_bind_alias_x08e_default;
        }

        public final int getImageBig() {
            return R.drawable.mico_img_found_x08c_big;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_x08c_menu;
        }

        public final String getName() {
            return "X08E";
        }

        public final int getScanIcon() {
            return R.drawable.mico_img_found_x08c;
        }

        public final int getTimerVolume() {
            return 59;
        }

        public final int getUpgradeIcon() {
            return R.drawable.mico_img_found_x08c;
        }

        public final boolean hasCapabilityVideoAlarm() {
            return true;
        }

        public final boolean hasScreen() {
            return true;
        }

        public final boolean isAndroidRom() {
            return true;
        }

        public final boolean needAuthXiaomiAccount() {
            return true;
        }

        public final boolean needBindToServer() {
            return false;
        }

        public final boolean support5GHz() {
            return true;
        }
    },
    L09B {
        public final String getAIClientId() {
            return "529027180873647104";
        }

        public final int getAlarmVolume() {
            return 30;
        }

        public final int getBLEType() {
            return 20;
        }

        public final int getDefaultAlias() {
            return R.string.mico_bind_alias_l09b_default;
        }

        public final int getImageBig() {
            return R.drawable.mico_img_found_l09b_big;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_l09a_menu;
        }

        public final String getName() {
            return "L09B";
        }

        public final int getScanIcon() {
            return R.drawable.mico_img_found_l09b;
        }

        public final int getTimerVolume() {
            return 59;
        }

        public final int getUpgradeIcon() {
            return R.drawable.mico_img_found_l09b;
        }

        public final boolean isAndroidRom() {
            return false;
        }
    },
    L15A {
        public final String getAIClientId() {
            return "636636926589275136";
        }

        public final int getAlarmVolume() {
            return 30;
        }

        public final int getBLEType() {
            return 21;
        }

        public final int getDefaultAlias() {
            return R.string.mico_bind_alias_l15a_default;
        }

        public final int getImageBig() {
            return R.drawable.mico_mine_img_l15a;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_s12_menu;
        }

        public final String getName() {
            return "L15A";
        }

        public final int getScanIcon() {
            return R.drawable.mico_img_found_l15a;
        }

        public final int getTimerVolume() {
            return 30;
        }

        public final int getUpgradeIcon() {
            return R.drawable.mico_img_found_l15a;
        }

        public final boolean isAndroidRom() {
            return false;
        }
    },
    L16A {
        public final String getAIClientId() {
            return "695233442085864448";
        }

        public final int getAlarmVolume() {
            return 30;
        }

        public final int getBLEType() {
            return 22;
        }

        public final int getDefaultAlias() {
            return R.string.mico_bind_alias_l16a_default;
        }

        public final int getImageBig() {
            return R.drawable.mico_img_found_l16a_big;
        }

        public final int getMenuIcon() {
            return R.drawable.mico_icon_s12_menu;
        }

        public final String getName() {
            return "L16A";
        }

        public final int getScanIcon() {
            return R.drawable.mico_img_found_l16a;
        }

        public final int getTimerVolume() {
            return 30;
        }

        public final int getUpgradeIcon() {
            return R.drawable.mico_img_found_l16a;
        }

        public final boolean isAndroidRom() {
            return false;
        }
    };

    public static Hardware valueOf(int i, int i2) {
        ahg ahg = L.bt;
        int i3 = 0;
        ahg.O00000o0("bleType: %s", Integer.toHexString(i));
        if (i == 23) {
            return S12;
        }
        if (i == 24) {
            return S12A;
        }
        Hardware[] values = values();
        int length = values.length;
        while (i3 < length) {
            Hardware hardware = values[i3];
            if (hardware.getBLEType() != i) {
                i3++;
            } else if (i != L07A.getBLEType()) {
                return hardware;
            } else {
                if (i2 == 16) {
                    return L07A_BLUE;
                }
                if (i2 == 32) {
                    return L07A_GREEN;
                }
                return L07A;
            }
        }
        return S12;
    }

    public static Hardware safeValueOf(String str) {
        return safeValueOf(str, null);
    }

    public static Hardware safeValueOf(String str, String str2) {
        if (str2 != null) {
            if (str2.startsWith("27432")) {
                return L07A_GREEN;
            }
            if (str2.startsWith("27433")) {
                return L07A_BLUE;
            }
            if (str2.startsWith("26215")) {
                return L07A;
            }
        }
        for (Hardware hardware : values()) {
            String name = hardware.getName();
            if (name != null) {
                if (name.equalsIgnoreCase(str)) {
                    return hardware;
                }
                if (str.startsWith("T") || str.startsWith("T".toLowerCase())) {
                    return T646;
                }
            }
        }
        return S12;
    }

    public static boolean canSetupStereo(Hardware hardware, Hardware hardware2) {
        if (hardware == null) {
            return false;
        }
        if (hardware.equals(hardware2)) {
            return true;
        }
        int i = AnonymousClass25.$SwitchMap$com$xiaomi$mico$common$application$Hardware[hardware.ordinal()];
        if (i == 1 || i == 2) {
            return hardware2 == LX06 || hardware2 == L06A;
        }
        return false;
    }

    /* renamed from: com.xiaomi.mico.common.application.Hardware$25  reason: invalid class name */
    static /* synthetic */ class AnonymousClass25 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaomi$mico$common$application$Hardware = new int[Hardware.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            $SwitchMap$com$xiaomi$mico$common$application$Hardware[Hardware.LX06.ordinal()] = 1;
            $SwitchMap$com$xiaomi$mico$common$application$Hardware[Hardware.L06A.ordinal()] = 2;
        }
    }
}

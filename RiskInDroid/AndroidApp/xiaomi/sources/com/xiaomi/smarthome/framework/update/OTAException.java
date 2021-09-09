package com.xiaomi.smarthome.framework.update;

public class OTAException extends Exception {
    private int mCode;

    public OTAException(int i) {
        super(code2String(i));
        this.mCode = i;
    }

    public OTAException(int i, String str) {
        super(str);
        this.mCode = i;
    }

    public int getCode() {
        return this.mCode;
    }

    public static String code2String(int i) {
        if (i == -599) {
            return "switch firmware unknown error";
        }
        if (i == -499) {
            return "packet response unknown error";
        }
        if (i == -413) {
            return "packet response busy";
        }
        if (i == -412) {
            return "packet response timeout";
        }
        if (i == -201) {
            return "read remote version info fail";
        }
        if (i == -200) {
            return "read firmware version fail";
        }
        if (i == -108) {
            return "open data fragment notify fail";
        }
        if (i == -107) {
            return "open control point notify fail";
        }
        if (i == 0) {
            return "ota success";
        }
        if (i == 1) {
            return "it's latest version";
        }
        if (i == 2) {
            return "user cancel upgrade";
        }
        if (i == 3) {
            return "protocol version is low, need to update app";
        }
        switch (i) {
            case -508:
                return "device low battery";
            case -507:
                return "receive firmware fragment fail";
            case -506:
                return "switch firmware invalid sign";
            case -505:
                return "switch firmware device busy";
            case -504:
                return "switch firmware memory is full";
            case -503:
                return "switch firmware invalid params";
            case -502:
                return "switch firmware auth fail";
            case -501:
                return "switch firmware invalid command";
            default:
                switch (i) {
                    case -403:
                        return "read device fragment size fail";
                    case -402:
                        return "read fragment last index fail";
                    case -401:
                        return "read protocol version fail";
                    default:
                        switch (i) {
                            case -303:
                                return "download url is empty";
                            case -302:
                                return "download file md5 not equal";
                            case -301:
                                return "download file fail";
                            default:
                                switch (i) {
                                    case -105:
                                        return "ble disconnect";
                                    case -104:
                                        return "download file not exist";
                                    case -103:
                                        return "another update ongoing";
                                    case -102:
                                        return "mac is empty";
                                    case -101:
                                        return "ota ongoing,but ble disconnect";
                                    case -100:
                                        return "connect device fail";
                                    default:
                                        return "unknown error!【" + i + "】";
                                }
                        }
                }
        }
    }
}

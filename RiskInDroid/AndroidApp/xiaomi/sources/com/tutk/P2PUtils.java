package com.tutk;

import _m_j.cki;
import _m_j.wd;
import android.support.v4.app.NotificationCompat;
import com.tutk.IOTC.AVAPIs;
import com.tutk.IOTC.IOTCAPIs;
import com.tutk.IOTC.RDTAPIs;
import com.tutk.IOTC.TUTKGlobalAPIs;

public class P2PUtils {
    private static volatile int REF_COUNT = 0;
    public static volatile boolean sInit = false;

    public static synchronized void initial() {
        synchronized (P2PUtils.class) {
            if (REF_COUNT == 0) {
                sInit = true;
                cki.O00000o("P2P", "initial");
                IOTCAPIs.IOTC_Setup_Session_Alive_Timeout(16);
                int currentTimeMillis = (int) ((System.currentTimeMillis() % 10000) + 10000);
                TUTKGlobalAPIs.TUTK_SDK_Set_License_Key("AQAAAMUWWQKwJBRi72sru3muMUMlWko8VI05E3rGSaqXyXTgKpsjBdMSh7pMZwTLa+t/592gMBlEEqhF1vIgmx53rFGy70bFm9n+yX1QIAXo5tYHAj1fMlhK9+BBa3RsATb0vA5BPyjEumbiOAc//EawTH/ncOZUkfI+/XORjYvCSgkqanVkRlO48A+2PDOLei8sSks0Pw==");
                int IOTC_Initialize2 = IOTCAPIs.IOTC_Initialize2(currentTimeMillis);
                cki.O00000o("P2P", "IOTC_Initialize2 port:" + currentTimeMillis + " ret:" + IOTC_Initialize2);
                if (IOTC_Initialize2 == 0 || IOTC_Initialize2 == -3) {
                    int avInitialize = AVAPIs.avInitialize(NotificationCompat.FLAG_HIGH_PRIORITY);
                    AVAPIs.avClientSetMaxBufSize(5000);
                    cki.O00000o("P2P", "avInitialize ret:".concat(String.valueOf(avInitialize)));
                    if (avInitialize < 0) {
                        wd.O00000o0("P2P", "avInitialize :" + getError(avInitialize));
                        return;
                    }
                    int RDT_Initialize = RDTAPIs.RDT_Initialize();
                    cki.O00000o("P2P", "RDT_Initialize ret:".concat(String.valueOf(RDT_Initialize)));
                    if (RDT_Initialize < 0) {
                        wd.O00000o0("P2P", "RDT_Initialize :" + getError(RDT_Initialize));
                        return;
                    }
                } else {
                    wd.O00000o0("P2P", "IOTC_Initialize2 :" + getError(IOTC_Initialize2));
                    return;
                }
            }
            REF_COUNT++;
        }
    }

    public static synchronized void unInitial() {
        synchronized (P2PUtils.class) {
            int i = REF_COUNT - 1;
            REF_COUNT = i;
            if (i <= 0) {
                sInit = false;
                cki.O00000o("P2P", "RDT_Initialize ret:".concat(String.valueOf(RDTAPIs.RDT_DeInitialize())));
                cki.O00000o("P2P", "avDeInitialize ret:".concat(String.valueOf(AVAPIs.avDeInitialize())));
                cki.O00000o("P2P", "IOTC_DeInitialize ret:".concat(String.valueOf(IOTCAPIs.IOTC_DeInitialize())));
                REF_COUNT = 0;
            }
        }
    }

    public static String getError(int i) {
        wd.O00000o0("P2P", "getError:".concat(String.valueOf(i)));
        if (i == -26) {
            return "Channel isn't on.Please open it by IOTC_Session_Channel_ON() or IOTC_Session_Get_Free_Channel()";
        }
        if (i == -10) {
            return "This UID is unlicense,Check your UID.";
        }
        if (i == -19) {
            return "Device didn't register on server, so we can't find device.Please check the device again.";
        }
        if (i == -18) {
            return "The amount of session reach to the maximum.It cannot be connected unless the session is released.";
        }
        if (i == -5) {
            return "Can't create thread.";
        }
        if (i == -4) {
            return "Can't create mutex.";
        }
        if (i == -3) {
            return "Already initialized";
        }
        if (i == -2) {
            return "Can't resolve hostname.";
        }
        if (i == -1) {
            return "Master doesn't respond,Please check the network wheather it could connect to the Internet.";
        }
        switch (i) {
            case -43:
                return "Server doesn't support UDP relay mode,So client can't use UDP relay to connect to a device.";
            case -42:
                return "Client can't connect to a device via Lan, P2P, and Relay mode";
            case -41:
                return "Network is unreachable,Please check your network,Retry...";
            case -40:
                return "This UID's license doesn't support TCP.";
            default:
                switch (i) {
                    case -33:
                        return "Device can't connect to server by TCP.";
                    case -32:
                        return "Device can't connect to Master.";
                    case -31:
                        return "All channels are occupied,Please release some channel";
                    default:
                        switch (i) {
                            case -24:
                                return "Device doesn't listen or the sessions of device reach to maximum.Please release the session and check the device wheather it listen or not.";
                            case -23:
                                return "We can't receive an acknowledgement character within a TIMEOUT";
                            case -22:
                                return "Session is closed by remote so we can't access.Please close it or establish session again.";
                            default:
                                switch (i) {
                                    case -14:
                                    case -13:
                                        return "This SID is invalid.Please check it again.";
                                    case -12:
                                        return "Please initialize the IOTCAPI first.";
                                    default:
                                        return "";
                                }
                        }
                }
        }
    }
}

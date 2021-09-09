package com.miui.nfc;

import android.nfc.NfcAdapter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MiuiNfcAdapter {
    public static boolean isRoutingESE(NfcAdapter nfcAdapter) {
        return nfcAdapter != null && nfcAdapter.getSeRouting() == 1;
    }

    public static void setListenTechMask(NfcAdapter nfcAdapter, int i) throws IOException {
        nfcAdapter.setListenTechMask(i);
    }

    public static int setConfig(NfcAdapter nfcAdapter, String str) {
        return nfcAdapter.setConfig(str);
    }

    public static boolean disableNdefPush(NfcAdapter nfcAdapter) {
        return nfcAdapter.disableNdefPush();
    }

    public static byte[] getNfccDieid(NfcAdapter nfcAdapter) {
        try {
            Method method = nfcAdapter.getClass().getMethod("getNfccDieid", new Class[0]);
            method.setAccessible(true);
            return (byte[]) method.invoke(nfcAdapter, new Object[0]);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static int getEseRouting(NfcAdapter nfcAdapter) {
        return nfcAdapter.getSeRouting();
    }

    public static void setEseRouting(NfcAdapter nfcAdapter, int i) {
        nfcAdapter.setSeRouting(i);
    }

    public static boolean isNfcOff(NfcAdapter nfcAdapter) {
        int adapterState = nfcAdapter.getAdapterState();
        return adapterState == 1 || adapterState == 4;
    }

    public static boolean enble(NfcAdapter nfcAdapter) {
        return nfcAdapter.enable();
    }

    public static boolean disable(NfcAdapter nfcAdapter) {
        return nfcAdapter.disable();
    }
}

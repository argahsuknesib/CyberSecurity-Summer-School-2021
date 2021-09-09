package _m_j;

import android.app.AppOpsManager;
import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.os.Process;
import com.xiaomi.smarthome.application.ServiceApplication;

public final class hig {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f18961O000000o = -1;
    public static String O00000Oo = null;
    public static String O00000o = null;
    public static String O00000o0 = null;
    private static String O00000oO = "0123456789ABCDEF";

    public interface O000000o {
        void O000000o();

        void O000000o(int i, String str);
    }

    public static void O000000o(Tag tag, NdefMessage ndefMessage, int i, O000000o o000000o) {
        NdefRecord[] ndefRecordArr;
        hih.O000000o("smarthome-nfc", "start write");
        NdefRecord[] records = ndefMessage.getRecords();
        if (records != null && records.length != 0) {
            if (i > 0) {
                ndefRecordArr = new NdefRecord[(records.length + i)];
            } else {
                ndefRecordArr = new NdefRecord[(records.length + 1)];
            }
            for (int i2 = 0; i2 < records.length; i2++) {
                ndefRecordArr[i2] = records[i2];
            }
            NdefRecord createExternal = NdefRecord.createExternal("android.com", "pkg", "com.xiaomi.smarthome".getBytes());
            NdefRecord createApplicationRecord = NdefRecord.createApplicationRecord("com.xiaomi.mi_connect_service");
            NdefRecord createUri = NdefRecord.createUri("https://g.home.mi.com");
            if (i == 3) {
                ndefRecordArr[records.length] = createExternal;
                ndefRecordArr[records.length + 1] = createApplicationRecord;
                ndefRecordArr[records.length + 2] = createUri;
            } else {
                ndefRecordArr[records.length] = createUri;
            }
            NdefMessage ndefMessage2 = new NdefMessage(ndefRecordArr);
            int length = ndefMessage2.toByteArray().length;
            try {
                Ndef ndef = Ndef.get(tag);
                if (ndef != null) {
                    ndef.connect();
                    if (!ndef.isWritable()) {
                        if (o000000o != null) {
                            o000000o.O000000o(-9999, "tag is not writable");
                            return;
                        }
                        return;
                    } else if (ndef.getMaxSize() >= length) {
                        try {
                            ndef.writeNdefMessage(ndefMessage2);
                            if (o000000o != null) {
                                o000000o.O000000o();
                            }
                        } catch (FormatException e) {
                            e.printStackTrace();
                            hih.O000000o("smarthome-nfc", e.getMessage());
                            if (o000000o != null) {
                                o000000o.O000000o(-9000, e.getMessage());
                            }
                        }
                    } else if (o000000o != null) {
                        o000000o.O000000o(-9999, "too large ndefMessage");
                        return;
                    } else {
                        return;
                    }
                } else {
                    NdefFormatable ndefFormatable = NdefFormatable.get(tag);
                    ndefFormatable.connect();
                    ndefFormatable.format(ndefMessage2);
                    if (ndefFormatable.isConnected()) {
                        ndefFormatable.close();
                    }
                    if (o000000o != null) {
                        o000000o.O000000o();
                    }
                }
                ndef.close();
            } catch (Exception e2) {
                e2.printStackTrace();
                if (o000000o != null) {
                    o000000o.O000000o(-9000, e2.getMessage());
                }
            }
            hih.O000000o("smarthome-nfc", "end write");
        } else if (o000000o != null) {
            o000000o.O000000o(-9999, "ndefMessage is empty");
        }
    }

    private static boolean O0000Oo() {
        return ((Application) ServiceApplication.getAppContext()).getPackageManager().hasSystemFeature("android.hardware.nfc");
    }

    public static boolean O000000o() {
        NfcAdapter defaultAdapter;
        if (O0000Oo() && (defaultAdapter = NfcAdapter.getDefaultAdapter(ServiceApplication.getAppContext())) != null && defaultAdapter.isEnabled()) {
            return true;
        }
        return false;
    }

    public static boolean O00000Oo() {
        if (!O000000o()) {
            return false;
        }
        if (grr.O00000oO()) {
            AppOpsManager appOpsManager = (AppOpsManager) ServiceApplication.getAppContext().getSystemService("appops");
            try {
                if (((Integer) appOpsManager.getClass().getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, 10016, Integer.valueOf(Process.myUid()), ServiceApplication.getAppContext().getPackageName())).intValue() == 0) {
                    return true;
                }
                return false;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    public static boolean O00000o0() {
        return grr.O00000oO();
    }

    public static boolean O00000o() {
        if (grr.O00000oO()) {
            try {
                PackageInfo packageInfo = ServiceApplication.getAppContext().getPackageManager().getPackageInfo("com.xiaomi.mi_connect_service", 0);
                if (packageInfo == null || packageInfo.versionCode < hif.O00000oO()) {
                    return true;
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return true;
            }
        }
        return false;
    }

    public static boolean O00000oO() {
        if (O00000oo() && grr.O00000oO() && !O00000o()) {
            return true;
        }
        return false;
    }

    public static boolean O00000oo() {
        return O0000Oo() && hif.O00000o0();
    }

    public static String O0000O0o() {
        return hif.O00000Oo();
    }

    public static boolean O0000OOo() {
        return hif.O00000o();
    }

    public static boolean O0000Oo0() {
        return hif.O00000oo();
    }

    public static NdefMessage O000000o(String str, byte[] bArr) {
        NdefRecord createExternal = NdefRecord.createExternal(str, "externalType", bArr);
        if (createExternal == null) {
            return null;
        }
        return new NdefMessage(createExternal, new NdefRecord[0]);
    }

    public static byte[] O000000o(String str) {
        String[] split = str.split(":");
        if (split == null || split.length != 6) {
            hih.O000000o("smarthome-nfc", "mac address is wrong format");
            return str.getBytes();
        }
        byte[] bArr = new byte[6];
        for (int i = 0; i < 6; i++) {
            String upperCase = split[i].toUpperCase();
            int length = upperCase.length() / 2;
            byte[] bArr2 = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr2[i2] = (byte) (((byte) O00000oO.indexOf(upperCase.charAt(i3 + 1))) | ((byte) (O00000oO.indexOf(upperCase.charAt(i3)) << 4)));
            }
            System.arraycopy(bArr2, 0, bArr, i, 1);
        }
        return bArr;
    }
}

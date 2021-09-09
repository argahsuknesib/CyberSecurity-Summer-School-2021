package _m_j;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class eca {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static final String f15159O000000o = ebs.O00000Oo(ebp.f15153O000000o, "CLIENT_ID");
    protected static final int O00000Oo;
    protected static final String O00000o = ebu.O000000o().O000000o(ebp.f15153O000000o);
    protected static final String O00000o0 = ebs.O00000Oo(ebp.f15153O000000o, "mishopSdkVersionName");
    protected static final String O00000oO = ebs.O00000Oo(ebp.f15153O000000o, "XM_APPCHANNEL");

    /* JADX WARNING: Removed duplicated region for block: B:23:0x002f A[SYNTHETIC, Splitter:B:23:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x003b A[SYNTHETIC, Splitter:B:30:0x003b] */
    private static byte[] O000000o(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (-1 == read) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return byteArray;
            } catch (IOException e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            byteArrayOutputStream = null;
            e.printStackTrace();
            if (byteArrayOutputStream != null) {
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
            }
            throw th;
        }
    }

    public static een O000000o(int i, byte[] bArr) {
        NetworkInfo networkInfo = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        een een = new een();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(eby.O00000Oo).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setConnectTimeout(C.MSG_CUSTOM_BASE);
            httpURLConnection.setReadTimeout(C.MSG_CUSTOM_BASE);
            httpURLConnection.setRequestProperty("Mishop-Client-Id", f15159O000000o);
            ConnectivityManager connectivityManager = (ConnectivityManager) ebp.f15153O000000o.getSystemService("connectivity");
            if (connectivityManager != null) {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            }
            String str = "unknown";
            if (networkInfo != null) {
                if (networkInfo.getType() == 1) {
                    str = "wifi";
                } else if (networkInfo.getType() == 0) {
                    switch (networkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            str = "2g";
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        case 9:
                        case 10:
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        case 14:
                        case GmsLogger.MAX_PII_TAG_LENGTH:
                            str = "3g";
                            break;
                        case 13:
                            str = "4g";
                            break;
                    }
                } else {
                    str = networkInfo.getType() == 7 ? "bluetooth" : "others";
                }
            }
            httpURLConnection.setRequestProperty("Network-Stat", str);
            httpURLConnection.setRequestProperty("Mishop-Client-VersionCode", String.valueOf(O00000Oo));
            httpURLConnection.setRequestProperty("Mishop-Client-VersionName", O00000o0);
            httpURLConnection.setRequestProperty("Device-Id", O00000o);
            httpURLConnection.setRequestProperty("Mishop-Is-Pad", "0");
            httpURLConnection.setRequestProperty("Android-Ver", String.valueOf(Build.VERSION.SDK_INT));
            httpURLConnection.setRequestProperty("Mishop-Channel-Id", O00000oO);
            ecc unused = ech.f15164O000000o;
            int length = bArr.length;
            byte[] bArr2 = new byte[2];
            byte[] bArr3 = new byte[2];
            ecc.O000000o(bArr2, 1);
            ecc.O000000o(bArr3, i);
            byte[] O000000o2 = ecc.O000000o(ecc.O000000o(bArr2, bArr3, new byte[]{(byte) ((length >> 24) & 255), (byte) ((length >> 16) & 255), (byte) ((length >> 8) & 255), (byte) (length & 255)}), bArr);
            String O000000o3 = ebw.O000000o(O000000o2);
            if (ecd.O000000o(O000000o3)) {
                O000000o3 = "";
            }
            httpURLConnection.setRequestProperty("Mishop-Sign", O000000o3);
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(O000000o2);
            dataOutputStream.flush();
            dataOutputStream.close();
            if (httpURLConnection.getResponseCode() == 200) {
                een.f15191O000000o = true;
                if (i == 9) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    een.O00000Oo = O000000o(inputStream);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } else {
                een.f15191O000000o = false;
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
            een.f15191O000000o = false;
        }
        return een;
    }

    static {
        Bundle O00000o2 = ebs.O00000o(ebp.f15153O000000o);
        int i = 0;
        if (O00000o2 != null) {
            i = O00000o2.getInt("mishopSdkVersionCode", 0);
        }
        O00000Oo = i;
    }
}

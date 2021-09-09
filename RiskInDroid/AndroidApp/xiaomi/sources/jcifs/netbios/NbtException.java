package jcifs.netbios;

import android.support.v4.app.NotificationCompat;
import java.io.IOException;

public class NbtException extends IOException {
    public int errorClass;
    public int errorCode;

    public static String getErrorString(int i, int i2) {
        if (i == 0) {
            return "" + "SUCCESS";
        } else if (i == 1) {
            String str = "" + "ERR_NAM_SRVC/";
            if (i2 == 1) {
                str = str + "FMT_ERR: Format Error";
            }
            return str + "Unknown error code: " + i2;
        } else if (i != 2) {
            return "" + "unknown error class: " + i;
        } else {
            String str2 = "" + "ERR_SSN_SRVC/";
            if (i2 == -1) {
                return str2 + "Connection refused";
            } else if (i2 != 143) {
                switch (i2) {
                    case NotificationCompat.FLAG_HIGH_PRIORITY:
                        return str2 + "Not listening on called name";
                    case 129:
                        return str2 + "Not listening for calling name";
                    case 130:
                        return str2 + "Called name not present";
                    case 131:
                        return str2 + "Called name present, but insufficient resources";
                    default:
                        return str2 + "Unknown error code: " + i2;
                }
            } else {
                return str2 + "Unspecified error";
            }
        }
    }

    public NbtException(int i, int i2) {
        super(getErrorString(i, i2));
        this.errorClass = i;
        this.errorCode = i2;
    }

    public String toString() {
        return new String("errorClass=" + this.errorClass + ",errorCode=" + this.errorCode + ",errorString=" + getErrorString(this.errorClass, this.errorCode));
    }
}

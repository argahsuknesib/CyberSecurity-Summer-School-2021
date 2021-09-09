package jcifs.smb;

import _m_j.its;
import _m_j.itt;
import _m_j.itu;
import _m_j.itv;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class SmbException extends IOException implements its, itt, itu {
    private Throwable rootCause;
    private int status;

    private static String getMessageByCode(int i) {
        if (i == 0) {
            return "NT_STATUS_SUCCESS";
        }
        int i2 = 1;
        if ((i & -1073741824) == -1073741824) {
            int length = b_.length - 1;
            while (length >= i2) {
                int i3 = (i2 + length) / 2;
                if (i > b_[i3]) {
                    i2 = i3 + 1;
                } else if (i >= b_[i3]) {
                    return c_[i3];
                } else {
                    length = i3 - 1;
                }
            }
        } else {
            int length2 = f1626O000000o.length - 1;
            int i4 = 0;
            while (length2 >= i4) {
                int i5 = (i4 + length2) / 2;
                if (i > f1626O000000o[i5][0]) {
                    i4 = i5 + 1;
                } else if (i >= f1626O000000o[i5][0]) {
                    return O00000Oo[i5];
                } else {
                    length2 = i5 - 1;
                }
            }
        }
        return "0x" + itv.O000000o(i);
    }

    private static int getStatusByCode(int i) {
        if ((-1073741824 & i) != 0) {
            return i;
        }
        int length = f1626O000000o.length - 1;
        int i2 = 0;
        while (length >= i2) {
            int i3 = (i2 + length) / 2;
            if (i > f1626O000000o[i3][0]) {
                i2 = i3 + 1;
            } else if (i >= f1626O000000o[i3][0]) {
                return f1626O000000o[i3][1];
            } else {
                length = i3 - 1;
            }
        }
        return -1073741823;
    }

    private static String getMessageByWinerrCode(int i) {
        int length = d_.length - 1;
        int i2 = 0;
        while (length >= i2) {
            int i3 = (i2 + length) / 2;
            if (i > d_[i3]) {
                i2 = i3 + 1;
            } else if (i >= d_[i3]) {
                return e_[i3];
            } else {
                length = i3 - 1;
            }
        }
        return String.valueOf(i);
    }

    SmbException() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmbException(int i, boolean z) {
        super(z ? getMessageByWinerrCode(i) : getMessageByCode(i));
        this.status = !z ? getStatusByCode(i) : i;
    }

    public int getNtStatus() {
        return this.status;
    }

    public Throwable getRootCause() {
        return this.rootCause;
    }

    public String toString() {
        if (this.rootCause == null) {
            return super.toString();
        }
        StringWriter stringWriter = new StringWriter();
        this.rootCause.printStackTrace(new PrintWriter(stringWriter));
        return super.toString() + "\n" + stringWriter;
    }
}

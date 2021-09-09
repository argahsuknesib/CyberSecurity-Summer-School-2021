package org.apache.commons.compress.archivers.zip;

import _m_j.jcn;
import _m_j.jco;
import java.io.Serializable;
import java.util.Date;
import java.util.zip.ZipException;

public class X5455_ExtendedTimestamp implements jcn, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final ZipShort f15424O000000o = new ZipShort(21589);
    private static final long serialVersionUID = 1;
    private ZipLong accessTime;
    private boolean bit0_modifyTimePresent;
    private boolean bit1_accessTimePresent;
    private boolean bit2_createTimePresent;
    private ZipLong createTime;
    private byte flags;
    private ZipLong modifyTime;

    public final ZipShort O00000oO() {
        return f15424O000000o;
    }

    public final ZipShort O00000o() {
        int i = 4;
        int i2 = (this.bit0_modifyTimePresent ? 4 : 0) + 1 + ((!this.bit1_accessTimePresent || this.accessTime == null) ? 0 : 4);
        if (!this.bit2_createTimePresent || this.createTime == null) {
            i = 0;
        }
        return new ZipShort(i2 + i);
    }

    public final ZipShort O00000Oo() {
        return new ZipShort((this.bit0_modifyTimePresent ? 4 : 0) + 1);
    }

    public final byte[] O00000o0() {
        ZipLong zipLong;
        ZipLong zipLong2;
        byte[] bArr = new byte[O00000o().value];
        bArr[0] = 0;
        int i = 1;
        if (this.bit0_modifyTimePresent) {
            bArr[0] = (byte) (bArr[0] | 1);
            System.arraycopy(ZipLong.O000000o(this.modifyTime.value), 0, bArr, 1, 4);
            i = 5;
        }
        if (this.bit1_accessTimePresent && (zipLong2 = this.accessTime) != null) {
            bArr[0] = (byte) (bArr[0] | 2);
            System.arraycopy(ZipLong.O000000o(zipLong2.value), 0, bArr, i, 4);
            i += 4;
        }
        if (this.bit2_createTimePresent && (zipLong = this.createTime) != null) {
            bArr[0] = (byte) (bArr[0] | 4);
            System.arraycopy(ZipLong.O000000o(zipLong.value), 0, bArr, i, 4);
        }
        return bArr;
    }

    public final byte[] O000000o() {
        byte[] bArr = new byte[O00000Oo().value];
        System.arraycopy(O00000o0(), 0, bArr, 0, bArr.length);
        return bArr;
    }

    private void O000000o(byte b) {
        this.flags = b;
        boolean z = false;
        this.bit0_modifyTimePresent = (b & 1) == 1;
        this.bit1_accessTimePresent = (b & 2) == 2;
        if ((b & 4) == 4) {
            z = true;
        }
        this.bit2_createTimePresent = z;
    }

    public String toString() {
        ZipLong zipLong;
        ZipLong zipLong2;
        Date date;
        ZipLong zipLong3;
        Date date2;
        StringBuilder sb = new StringBuilder();
        sb.append("0x5455 Zip Extra Field: Flags=");
        sb.append(Integer.toBinaryString(jco.O000000o((int) this.flags)));
        sb.append(" ");
        Date date3 = null;
        if (this.bit0_modifyTimePresent && (zipLong3 = this.modifyTime) != null) {
            if (zipLong3 != null) {
                date2 = new Date(zipLong3.value * 1000);
            } else {
                date2 = null;
            }
            sb.append(" Modify:[");
            sb.append(date2);
            sb.append("] ");
        }
        if (this.bit1_accessTimePresent && (zipLong2 = this.accessTime) != null) {
            if (zipLong2 != null) {
                date = new Date(zipLong2.value * 1000);
            } else {
                date = null;
            }
            sb.append(" Access:[");
            sb.append(date);
            sb.append("] ");
        }
        if (this.bit2_createTimePresent && (zipLong = this.createTime) != null) {
            if (zipLong != null) {
                date3 = new Date(zipLong.value * 1000);
            }
            sb.append(" Create:[");
            sb.append(date3);
            sb.append("] ");
        }
        return sb.toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        ZipLong zipLong;
        ZipLong zipLong2;
        ZipLong zipLong3;
        ZipLong zipLong4;
        if (obj instanceof X5455_ExtendedTimestamp) {
            X5455_ExtendedTimestamp x5455_ExtendedTimestamp = (X5455_ExtendedTimestamp) obj;
            if ((this.flags & 7) == (x5455_ExtendedTimestamp.flags & 7) && (((zipLong = this.modifyTime) == (zipLong2 = x5455_ExtendedTimestamp.modifyTime) || (zipLong != null && zipLong.equals(zipLong2))) && ((zipLong3 = this.accessTime) == (zipLong4 = x5455_ExtendedTimestamp.accessTime) || (zipLong3 != null && zipLong3.equals(zipLong4))))) {
                ZipLong zipLong5 = this.createTime;
                ZipLong zipLong6 = x5455_ExtendedTimestamp.createTime;
                if (zipLong5 == zipLong6) {
                    return true;
                }
                if (zipLong5 == null || !zipLong5.equals(zipLong6)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = (this.flags & 7) * -123;
        ZipLong zipLong = this.modifyTime;
        if (zipLong != null) {
            i ^= zipLong.hashCode();
        }
        ZipLong zipLong2 = this.accessTime;
        if (zipLong2 != null) {
            i ^= Integer.rotateLeft(zipLong2.hashCode(), 11);
        }
        ZipLong zipLong3 = this.createTime;
        return zipLong3 != null ? i ^ Integer.rotateLeft(zipLong3.hashCode(), 22) : i;
    }

    public final void O000000o(byte[] bArr, int i, int i2) throws ZipException {
        int i3;
        O000000o((byte) 0);
        this.modifyTime = null;
        this.accessTime = null;
        this.createTime = null;
        int i4 = i2 + i;
        int i5 = i + 1;
        O000000o(bArr[i]);
        if (this.bit0_modifyTimePresent) {
            this.modifyTime = new ZipLong(bArr, i5);
            i5 += 4;
        }
        if (!this.bit1_accessTimePresent || (i3 = i5 + 4) > i4) {
            i3 = i5;
        } else {
            this.accessTime = new ZipLong(bArr, i5);
        }
        if (this.bit2_createTimePresent && i3 + 4 <= i4) {
            this.createTime = new ZipLong(bArr, i3);
        }
    }
}

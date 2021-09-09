package com.xiaomi.smarthome.camera.audioprocess;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public class ByteDataBufferCopy {
    final ArrayList<byte[]> dataList = new ArrayList<>();

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0063, code lost:
        return true;
     */
    public boolean take(byte[] bArr) {
        synchronized (this.dataList) {
            if (this.dataList.size() == 0) {
                return false;
            }
            int i = 0;
            int i2 = 0;
            while (i < this.dataList.size() && (i2 = i2 + this.dataList.get(i).length) < bArr.length) {
                i++;
            }
            if (i2 < bArr.length) {
                return false;
            }
            int i3 = 0;
            while (i > 0) {
                byte[] remove = this.dataList.remove(0);
                System.arraycopy(remove, 0, bArr, i3, remove.length);
                i3 += remove.length;
                i--;
            }
            int length = bArr.length - i3;
            byte[] remove2 = this.dataList.remove(0);
            if (remove2.length > length) {
                System.arraycopy(remove2, 0, bArr, i3, length);
                byte[] bArr2 = new byte[(remove2.length - length)];
                System.arraycopy(remove2, length, bArr2, 0, bArr2.length);
                this.dataList.add(0, bArr2);
            } else {
                System.arraycopy(remove2, 0, bArr, i3, length);
            }
        }
    }

    public byte[] takeAll() {
        synchronized (this.dataList) {
            if (this.dataList.size() == 0) {
                return null;
            }
            if (this.dataList.size() == 1) {
                byte[] remove = this.dataList.remove(0);
                return remove;
            }
            int i = 0;
            for (int i2 = 0; i2 < this.dataList.size(); i2++) {
                i += this.dataList.get(i2).length;
            }
            byte[] bArr = new byte[i];
            int i3 = 0;
            for (int i4 = 0; i4 < this.dataList.size(); i4++) {
                System.arraycopy(this.dataList.get(i4), 0, bArr, i3, this.dataList.get(i4).length);
                i3 += this.dataList.get(i4).length;
            }
            this.dataList.clear();
            return bArr;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0066, code lost:
        r7.rewind();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006a, code lost:
        return true;
     */
    public boolean take(ByteBuffer byteBuffer) {
        byteBuffer.clear();
        synchronized (this.dataList) {
            if (this.dataList.size() == 0) {
                return false;
            }
            int i = 0;
            int i2 = 0;
            while (i < this.dataList.size() && (i2 = i2 + this.dataList.get(i).length) < byteBuffer.remaining()) {
                i++;
            }
            if (i2 < byteBuffer.remaining()) {
                return false;
            }
            while (i > 0) {
                byteBuffer.put(this.dataList.remove(0));
                i--;
            }
            int remaining = byteBuffer.remaining();
            byte[] remove = this.dataList.remove(0);
            byteBuffer.put(remove, 0, remaining);
            if (remove.length > remaining) {
                byte[] bArr = new byte[(remove.length - remaining)];
                System.arraycopy(remove, remaining, bArr, 0, bArr.length);
                this.dataList.add(0, bArr);
            }
        }
    }

    public void put(byte[] bArr) {
        synchronized (this.dataList) {
            this.dataList.add(bArr);
        }
    }

    public void clear() {
        synchronized (this.dataList) {
            this.dataList.clear();
        }
    }

    public int length() {
        int size;
        synchronized (this.dataList) {
            size = this.dataList.size();
        }
        return size;
    }
}

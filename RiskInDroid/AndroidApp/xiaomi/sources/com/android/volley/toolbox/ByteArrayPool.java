package com.android.volley.toolbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ByteArrayPool {
    protected static final Comparator<byte[]> BUF_COMPARATOR = new Comparator<byte[]>() {
        /* class com.android.volley.toolbox.ByteArrayPool.AnonymousClass1 */

        public final int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };
    private List<byte[]> mBuffersByLastUse = new LinkedList();
    private List<byte[]> mBuffersBySize = new ArrayList(64);
    private int mCurrentSize = 0;
    private final int mSizeLimit;

    public ByteArrayPool(int i) {
        this.mSizeLimit = i;
    }

    public synchronized byte[] getBuf(int i) {
        for (int i2 = 0; i2 < this.mBuffersBySize.size(); i2++) {
            byte[] bArr = this.mBuffersBySize.get(i2);
            if (bArr.length >= i) {
                this.mCurrentSize -= bArr.length;
                this.mBuffersBySize.remove(i2);
                this.mBuffersByLastUse.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    public synchronized void returnBuf(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.mSizeLimit) {
                this.mBuffersByLastUse.add(bArr);
                int binarySearch = Collections.binarySearch(this.mBuffersBySize, bArr, BUF_COMPARATOR);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.mBuffersBySize.add(binarySearch, bArr);
                this.mCurrentSize += bArr.length;
                trim();
            }
        }
    }

    private synchronized void trim() {
        while (this.mCurrentSize > this.mSizeLimit) {
            byte[] remove = this.mBuffersByLastUse.remove(0);
            this.mBuffersBySize.remove(remove);
            this.mCurrentSize -= remove.length;
        }
    }
}

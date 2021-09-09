package com.miui.tsmclient.hcievent;

import android.os.Handler;
import java.util.Arrays;

public class HciEventAssembler {
    private Handler mHandler;
    private HciData mLastHciData;

    public class HciData {
        private byte[] mAid;
        private byte[] mData;
        public OnHciEventListener mOnHciEventListener;
        public Runnable mRunnable;

        private HciData(byte[] bArr, byte[] bArr2, OnHciEventListener onHciEventListener) {
            this.mRunnable = new Runnable() {
                /* class com.miui.tsmclient.hcievent.HciEventAssembler.HciData.AnonymousClass1 */

                public void run() {
                    HciData.this.mOnHciEventListener.onHciEvent(HciData.this);
                }
            };
            this.mAid = bArr;
            this.mData = bArr2;
            this.mOnHciEventListener = onHciEventListener;
        }

        private int getDataLength() {
            byte[] bArr = this.mData;
            if (bArr == null) {
                return 0;
            }
            return bArr.length;
        }

        public byte[] getAid() {
            return this.mAid;
        }

        public byte[] getData() {
            return this.mData;
        }

        public boolean isIncomplete() {
            byte[] bArr = this.mData;
            return bArr != null && bArr.length == 224;
        }

        public boolean merge(HciData hciData) {
            if (hciData == null || Arrays.equals(this.mData, hciData.mData) || !hciData.isIncomplete()) {
                return false;
            }
            byte[] bArr = new byte[(getDataLength() + hciData.getDataLength())];
            System.arraycopy(hciData.mData, 0, bArr, 0, hciData.getDataLength());
            System.arraycopy(this.mData, 0, bArr, hciData.getDataLength(), getDataLength());
            this.mData = bArr;
            return true;
        }
    }

    public interface OnHciEventListener {
        void onHciEvent(HciData hciData);
    }

    public HciEventAssembler(Handler handler) {
        this.mHandler = handler;
    }

    public void process(byte[] bArr, byte[] bArr2, OnHciEventListener onHciEventListener) {
        HciData hciData = new HciData(bArr, bArr2, onHciEventListener);
        if (hciData.isIncomplete()) {
            this.mLastHciData = hciData;
            this.mHandler.postDelayed(hciData.mRunnable, 150);
        } else if (hciData.merge(this.mLastHciData)) {
            this.mHandler.removeCallbacks(this.mLastHciData.mRunnable);
            this.mLastHciData = null;
            this.mHandler.post(hciData.mRunnable);
        } else {
            this.mLastHciData = null;
            this.mHandler.post(hciData.mRunnable);
        }
    }
}

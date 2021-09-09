package cn.com.xm.bt.profile.nfc;

public class HMNFCStatus {
    private int mStatus = 0;

    public HMNFCStatus() {
    }

    public HMNFCStatus(int i) {
        this.mStatus = i;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public boolean isSuccess() {
        return this.mStatus == 0;
    }

    public String toString() {
        return "HMNFCStatus{mStatus=" + this.mStatus + '}';
    }
}

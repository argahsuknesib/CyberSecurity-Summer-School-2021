package _m_j;

import com.lidroid.xutils.exception.HttpException;

public abstract class bqm<T> {
    private int rate;
    private String requestUrl;
    protected Object userTag;

    public void onCancelled() {
    }

    public abstract void onFailure(HttpException httpException, String str);

    public void onLoading(long j, long j2, boolean z) {
    }

    public void onStart() {
    }

    public abstract void onSuccess(bqi<T> bqi);

    public bqm() {
        this.rate = 1000;
    }

    public bqm(int i) {
        this.rate = i;
    }

    public bqm(Object obj) {
        this.rate = 1000;
        this.userTag = obj;
    }

    public bqm(int i, Object obj) {
        this.rate = i;
        this.userTag = obj;
    }

    public final int getRate() {
        int i = this.rate;
        if (i < 200) {
            return 200;
        }
        return i;
    }

    public final void setRate(int i) {
        this.rate = i;
    }

    public Object getUserTag() {
        return this.userTag;
    }

    public void setUserTag(Object obj) {
        this.userTag = obj;
    }

    public final String getRequestUrl() {
        return this.requestUrl;
    }

    public final void setRequestUrl(String str) {
        this.requestUrl = str;
    }
}

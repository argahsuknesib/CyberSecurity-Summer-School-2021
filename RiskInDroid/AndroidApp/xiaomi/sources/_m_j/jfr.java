package _m_j;

import com.google.android.exoplayer2.source.ExtractorMediaSource;

public abstract class jfr {
    protected int bitflags = ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES;
    protected Object[] preInitializationState;
    protected Object[] state;

    public abstract Object run(Object[] objArr) throws Throwable;

    public jfr() {
    }

    public jfr(Object[] objArr) {
        this.state = objArr;
    }

    public int getFlags() {
        return this.bitflags;
    }

    public Object[] getState() {
        return this.state;
    }

    public Object[] getPreInitializationState() {
        return this.preInitializationState;
    }

    public jfl linkClosureAndJoinPoint() {
        Object[] objArr = this.state;
        jfl jfl = (jfl) objArr[objArr.length - 1];
        jfl.O000000o(this);
        return jfl;
    }

    public jfl linkClosureAndJoinPoint(int i) {
        Object[] objArr = this.state;
        jfl jfl = (jfl) objArr[objArr.length - 1];
        jfl.O000000o(this);
        this.bitflags = i;
        return jfl;
    }
}

package com.mibi.sdk.task;

import _m_j.chg;
import _m_j.chh;
import _m_j.chi;
import _m_j.chj;

public class RxCountDown {
    private CounterTask mCounterTask;
    private CountListener mInnerCountListener;

    public interface ICountDownListener {
        void onCompleted();

        void onError();

        void onProgress(long j);

        void onStart();
    }

    private RxCountDown() {
    }

    public static RxCountDown getTask() {
        return new RxCountDown();
    }

    public void start(int i, ICountDownListener iCountDownListener) {
        this.mInnerCountListener = new CountListener(i, this, iCountDownListener);
        this.mCounterTask = new CounterTask();
        countInterval(0);
    }

    public void countInterval(int i) {
        if (i == 0) {
            this.mInnerCountListener.startCount();
        }
        this.mCounterTask.setCurrentTime(i);
        chh.O000000o(this.mCounterTask).O000000o(this.mInnerCountListener);
    }

    static class CounterTask implements chj<Integer> {
        private int mCurrentTime;

        private CounterTask() {
        }

        public void setCurrentTime(int i) {
            this.mCurrentTime = i;
        }

        public void call(chg<? super Integer> chg) {
            try {
                Thread.sleep(1000);
                chg.O000000o(Integer.valueOf(this.mCurrentTime));
            } catch (InterruptedException e) {
                e.printStackTrace();
                chg.O00000Oo = e;
            }
        }
    }

    static class CountListener implements chi<Integer> {
        private int mCount;
        private ICountDownListener mCountDownListener;
        private RxCountDown mRxCountDown;

        private CountListener(int i, RxCountDown rxCountDown, ICountDownListener iCountDownListener) {
            this.mCount = i;
            this.mRxCountDown = rxCountDown;
            this.mCountDownListener = iCountDownListener;
        }

        public void startCount() {
            this.mCountDownListener.onStart();
            this.mCountDownListener.onProgress(0);
        }

        public void onSuccess(Integer num) {
            if (num.intValue() < this.mCount) {
                Integer valueOf = Integer.valueOf(num.intValue() + 1);
                this.mCountDownListener.onProgress((long) valueOf.intValue());
                this.mRxCountDown.countInterval(valueOf.intValue());
                return;
            }
            this.mCountDownListener.onCompleted();
        }

        public void onError(Throwable th) {
            this.mCountDownListener.onError();
        }
    }
}

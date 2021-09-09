package com.hzy.tvmao.ir.ac;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ACExpandKey implements Serializable {
    private static final long serialVersionUID = 1;
    private int curState;
    private int fid;
    private int maxState;
    private int minState;
    private List<Integer> stateRangeList = new ArrayList();
    private List<Integer> supportModelList = new ArrayList();
    private int supportPower;

    public void changeState(int i, int i2) {
        if (isCanUsed(i, i2)) {
            this.curState++;
            int i3 = this.curState;
            if (i3 > this.maxState) {
                i3 = this.minState;
            }
            this.curState = i3;
        }
    }

    public void changeToTargetState(int i) {
        this.curState = i;
    }

    public boolean keyIsManyState() {
        return this.maxState - this.minState > 1;
    }

    public boolean keyIsSingleState() {
        return this.maxState - this.minState == 0;
    }

    public boolean keyIsSupportClose() {
        return this.minState == 0;
    }

    public int getExpandKeyState(int i, int i2) {
        if (!isCanUsed(i, i2)) {
            return -1;
        }
        return this.curState;
    }

    public boolean isUsedAtPower(int i) {
        int i2 = this.supportPower;
        if (i2 == 2) {
            return true;
        }
        if (i == 1) {
            if (i2 != 0 && i2 == 1) {
                return true;
            }
        } else if (i2 != 1 && i2 == 0) {
            return true;
        }
        return false;
    }

    public boolean isSupportModel(int i) {
        return this.supportModelList.indexOf(Integer.valueOf(i)) != -1;
    }

    public boolean isCanUsed(int i, int i2) {
        if (isUsedAtPower(i) && isSupportModel(i2)) {
            return true;
        }
        return false;
    }

    public int getFid() {
        return this.fid;
    }

    public void setFid(int i) {
        this.fid = i;
    }

    public int getMinState() {
        return this.minState;
    }

    public void setMinState(int i) {
        this.minState = i;
    }

    public int getMaxState() {
        return this.maxState;
    }

    public void setMaxState(int i) {
        this.maxState = i;
    }

    public void setCurState(int i) {
        this.curState = i;
    }

    public int getSupportPower() {
        return this.supportPower;
    }

    public void setSupportPower(int i) {
        this.supportPower = i;
    }

    public int getCurState() {
        return this.curState;
    }

    public List<Integer> getSupportModelList() {
        return this.supportModelList;
    }

    public void setSupportModelList(List<Integer> list) {
        this.supportModelList = list;
    }

    public List<Integer> getStateRangeList() {
        return this.stateRangeList;
    }

    public void setStateRangeList(List<Integer> list) {
        this.stateRangeList = list;
    }
}

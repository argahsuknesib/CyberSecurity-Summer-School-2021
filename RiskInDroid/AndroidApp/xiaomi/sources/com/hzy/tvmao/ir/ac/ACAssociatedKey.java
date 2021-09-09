package com.hzy.tvmao.ir.ac;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ACAssociatedKey implements Serializable {
    private static final long serialVersionUID = 1;
    private int configId;
    private boolean containsPrimary;
    private int maxState;
    private int minState;
    private List<Integer> primaryList = new ArrayList();
    private int targetState;

    public boolean isWithinScope(int i) {
        return i >= this.minState && i <= this.maxState;
    }

    public boolean isWithinPryKeyScope(int i) {
        return this.primaryList.lastIndexOf(Integer.valueOf(i)) != -1;
    }

    public List<Integer> getPrimaryList() {
        return this.primaryList;
    }

    public void setPrimaryList(List<Integer> list) {
        this.primaryList = list;
    }

    public boolean isContainsPrimary() {
        return this.containsPrimary;
    }

    public void setContainsPrimary(boolean z) {
        this.containsPrimary = z;
    }

    public int getConfigId() {
        return this.configId;
    }

    public void setConfigId(int i) {
        this.configId = i;
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

    public int getTargetState() {
        return this.targetState;
    }

    public void setTargetState(int i) {
        this.targetState = i;
    }
}

package com.hzy.tvmao.model.legacy.api.data;

import java.util.List;

public class VoteData {
    private String expire;
    private List<String> options;
    private String resid;
    private int selectCount;
    private boolean singleChoice;
    private String title;
    private int typeId;
    private boolean visiableAfterVote;

    public boolean isSingleChoice() {
        return this.singleChoice;
    }

    public void setSingleChoice(boolean z) {
        this.singleChoice = z;
    }

    public int getTypeId() {
        return this.typeId;
    }

    public void setTypeId(int i) {
        this.typeId = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public boolean isVisiableAfterVote() {
        return this.visiableAfterVote;
    }

    public void setVisiableAfterVote(boolean z) {
        this.visiableAfterVote = z;
    }

    public int getSelectCount() {
        return this.selectCount;
    }

    public void setSelectCount(int i) {
        this.selectCount = i;
    }

    public String getExpire() {
        return this.expire;
    }

    public void setExpire(String str) {
        this.expire = str;
    }

    public String getResid() {
        return this.resid;
    }

    public void setResid(String str) {
        this.resid = str;
    }

    public List<String> getOptions() {
        return this.options;
    }

    public void setOptions(List<String> list) {
        this.options = list;
    }
}

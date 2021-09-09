package com.hzy.tvmao.model.legacy.api.data;

public class CategryData {
    private String cateName;
    private boolean checked;

    public CategryData() {
    }

    public CategryData(String str) {
        this.cateName = str;
        this.checked = false;
    }

    public CategryData(String str, boolean z) {
        this.cateName = str;
        this.checked = z;
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    public void setCateName(String str) {
        this.cateName = str;
    }

    public boolean getChecked() {
        return this.checked;
    }

    public String getCateName() {
        return this.cateName;
    }
}

package com.xiaomi.mico.setting.babyschedule.bean;

public class BabyScheduleCategoryContent implements CategoryInterface {
    public long id;
    public String name;

    public BabyScheduleCategoryContent(long j, String str) {
        this.id = j;
        this.name = str;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}

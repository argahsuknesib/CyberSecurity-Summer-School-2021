package com.xiaomi.mico.setting.babyschedule.bean;

import android.content.Context;
import com.google.gson.annotations.Expose;

public class BaseScheduleItem implements BabyScheduleItem {
    public Categories categories;
    @Expose
    public String cp;
    @Expose
    public String cpId;
    public String globalId;
    public Images images;
    public boolean isAdded = false;
    public String resourceType;
    public String shortDescription;
    public String target;
    public String title;
    public long updateTime;

    public int getItemType() {
        return 0;
    }

    public void handleItemClick(Context context, int i) {
    }

    public String getImageUrl() {
        Poster poster;
        Images images2 = this.images;
        if (images2 == null || (poster = images2.poster) == null) {
            return "";
        }
        return poster.url;
    }
}

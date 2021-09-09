package com.mi.global.shop.model;

import android.graphics.Bitmap;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CustomNotificationContent {
    private List<Data> data;
    @SerializedName("icon_url")
    private String iconUrl;
    private String title;
    private String url;

    public static class Data {
        private Bitmap bitmap;
        private boolean completed;
        private String content;
        private int type;

        public int getType() {
            return this.type;
        }

        public void setType(int i) {
            this.type = i;
        }

        public String getContent() {
            return this.content;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public boolean isCompleted() {
            return this.completed;
        }

        public void setCompleted(boolean z) {
            this.completed = z;
        }

        public Bitmap getBitmap() {
            return this.bitmap;
        }

        public void setBitmap(Bitmap bitmap2) {
            this.bitmap = bitmap2;
        }

        public String toString() {
            return "Data{type=" + this.type + ", content='" + this.content + '\'' + '}';
        }
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public List<Data> getData() {
        return this.data;
    }

    public void setData(List<Data> list) {
        this.data = list;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public String toString() {
        return "CustomNotificationContent{title='" + this.title + '\'' + ", url='" + this.url + '\'' + ", data=" + this.data + ", iconUrl='" + this.iconUrl + '\'' + '}';
    }
}

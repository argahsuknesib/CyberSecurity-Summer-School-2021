package com.xiaomi.mico.api.model;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class Banner {
    public List<Item> banners;
    public int typeId;
    public String view_type;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0016  */
    public boolean isValid() {
        List<Item> list = this.banners;
        if (list == null || list.size() <= 0) {
            return true;
        }
        for (Item next : this.banners) {
            if (next.data == null || !next.data.isValid()) {
                return false;
            }
            while (r0.hasNext()) {
            }
        }
        return true;
    }

    public static class Item {
        @SerializedName("bannerURL")
        public Data data;
        public String trackKey;

        public boolean equals(Object obj) {
            Data data2;
            Data data3 = this.data;
            if (data3 == null || obj == null || !(obj instanceof Item) || (data2 = ((Item) obj).data) == null) {
                return false;
            }
            return data3.equals(data2);
        }
    }

    public static class Data {
        public int id;
        public String image;
        public String mainTitle;
        public String url;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            return Util.equals(this.image, data.image) && Util.equals(this.url, data.url);
        }

        public boolean isValid() {
            return !TextUtils.isEmpty(this.image) && this.url != null;
        }
    }
}

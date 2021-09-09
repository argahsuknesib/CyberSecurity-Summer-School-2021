package com.xiaomi.mico.api.model;

import android.content.Context;
import com.xiaomi.mico.common.schema.SchemaManager;
import com.xiaomi.mico.common.util.ContainerUtil;
import java.io.Serializable;
import java.util.ArrayList;

public class GetPurchasedRecordResponse {
    public ArrayList<PurchasedItem> list = new ArrayList<>();
    public long nextIndex;

    public boolean hasMoreData() {
        return this.nextIndex > 0;
    }

    public static class PurchasedItem implements AudioSourceInterface, Serializable {
        public String action;
        public String category;
        public long firstPayTime;
        public String group;
        public long lastPayTime;
        public String origin;
        private String originName;
        private String pictureUrl;
        private String productId;
        private String productName;
        public String productType;
        public boolean success;
        public long userId;

        public CharSequence getDescription() {
            return "";
        }

        public boolean isLegal() {
            return ContainerUtil.hasData(this.origin);
        }

        public String getTitle() {
            return this.productName;
        }

        public String getCover() {
            return this.pictureUrl;
        }

        public String getID() {
            return this.productId;
        }

        public void handleItemClick(Context context) {
            SchemaManager.handleSchema(context, this.action);
        }
    }
}

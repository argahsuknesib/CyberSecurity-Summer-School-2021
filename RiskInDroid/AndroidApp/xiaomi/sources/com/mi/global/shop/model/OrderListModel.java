package com.mi.global.shop.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class OrderListModel {
    @SerializedName("orderList")
    public OrderList orderList;

    public static class OrderList {
        @SerializedName("data")
        public ArrayList<OrderItem> items;
        @SerializedName("total_pages")
        public int totalPages;

        public static class OrderItem {
            @SerializedName("goods_amount_txt")
            public String amount;
            public ArrayList<Deliver> delivers;
            public boolean hasCancel;
            public boolean hasPay;
            public boolean hasRefund;
            public boolean hasSuborder;
            public boolean hasTrace;
            @SerializedName("order_id")
            public String orderId;
            @SerializedName("order_status")
            public int orderStatus;
            @SerializedName("product")
            public ArrayList<Product> products;
            @SerializedName("order_status_info")
            public StatusInfo statusInfo;
            @SerializedName("add_time")
            public long time;

            public static class Deliver {
                @SerializedName("deliver_id")
                public String deliver_id;
            }

            public static class Product {
                @SerializedName("image_url")
                public String imageUrl;
                @SerializedName("price_txt")
                public String priceTxt;
                @SerializedName("product_count")
                public String productCount;
                @SerializedName("product_name")
                public String productName;
            }

            public static class StatusInfo {
                @SerializedName("next")
                public ArrayList<String> next;
                @SerializedName("info")
                public String status;
                @SerializedName("trace")
                public ArrayList<TraceItem> trace;

                public static class TraceItem {
                    @SerializedName("text")
                    public String text;
                    @SerializedName("time")
                    public String time;
                }
            }
        }
    }
}

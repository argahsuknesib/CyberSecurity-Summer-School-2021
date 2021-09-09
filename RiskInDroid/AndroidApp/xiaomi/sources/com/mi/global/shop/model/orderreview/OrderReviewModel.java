package com.mi.global.shop.model.orderreview;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class OrderReviewModel {
    @SerializedName("goodsList")
    public ArrayList<OrderReviewItemModel> goodsList;
    @SerializedName("page_index")
    public int page_index;
    @SerializedName("page_total")
    public int page_total;
    @SerializedName("total_count")
    public int total_count;

    public static class OrderReviewItemModel {
        @SerializedName("comments_star")
        public double comments_star;
        @SerializedName("comments_total")
        public int comments_total;
        @SerializedName("goods_img")
        public String goods_img;
        @SerializedName("goods_name")
        public String goods_name;
        @SerializedName("goods_sku")
        public String goods_sku;
        @SerializedName("order_item_id")
        public String order_item_id;
        @SerializedName("pms_commodity_id")
        public String pms_commodity_id;
        @SerializedName("pms_goods_id")
        public String pms_goods_id;
        @SerializedName("pms_product_id")
        public String pms_product_id;
        @SerializedName("shop_price")
        public String shop_price;
    }
}

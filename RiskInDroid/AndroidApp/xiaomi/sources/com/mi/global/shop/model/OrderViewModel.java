package com.mi.global.shop.model;

import com.google.gson.annotations.SerializedName;
import com.mi.global.shop.model.common.ListItem;
import com.mi.global.shop.model.common.ListProduct;
import com.mi.global.shop.model.common.TraceItem;
import com.squareup.wire.Wire;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderViewModel implements Serializable {
    @SerializedName("differenceAmount")
    public String differenceAmount;
    @SerializedName("goodsAmt_txt")
    public String goodsAmt_txt;
    @SerializedName("id")
    public String id;
    @SerializedName("orderInfo")
    public OrderInfo orderInfo;

    public static class Addr_india implements Serializable {
        @SerializedName("addr")
        public String addr;
        @SerializedName("city")
        public String city;
        @SerializedName("landmark")
        public String landmark;
    }

    public static class City implements Serializable {
        @SerializedName("id")
        public String id;
        @SerializedName("name")
        public String name;
    }

    public static class Delivers implements Serializable {
        @SerializedName("deliver_id")
        public String deliver_id;
        @SerializedName("express")
        public Express express;
        @SerializedName("express_sn")
        public String express_sn;
        @SerializedName("order_status_info")
        public OrderStatusInfo order_status_info;
        @SerializedName("product")
        public ArrayList<Product> product;
    }

    public static class Express implements Serializable {
        @SerializedName("express_name")
        public String express_name;
        @SerializedName("express_sn")
        public String express_sn;
    }

    public static class Extentions implements Serializable {
        @SerializedName("goods_dealer")
        public String goods_dealer;
    }

    public static class OrderInfo implements Serializable {
        @SerializedName("add_time")
        public String add_time;
        @SerializedName("addr_india")
        public Addr_india addr_india;
        @SerializedName("city")
        public City city;
        @SerializedName("consignee")
        public String consignee;
        @SerializedName("delivered")
        public int delivered;
        @SerializedName("email")
        public String email;
        @SerializedName("goods_amount_txt")
        public String goods_amount_txt;
        @SerializedName("order_id")
        public String order_id;
        @SerializedName("order_status_info")
        public OrderStatusInfo order_status_info;
        @SerializedName("product")
        public ArrayList<Product> product;
        @SerializedName("reduce_price_txt")
        public String reduce_price_txt;
        @SerializedName("shipment_expense_txt")
        public String shipment_expense_txt;
        @SerializedName("tel")
        public String tel;
        @SerializedName("ttl")
        public String ttl;
        @SerializedName("zipcode")
        public String zipcode;
    }

    public static class OrderStatusInfo implements Serializable {
        @SerializedName("info")
        public String info;
        @SerializedName("next")
        public ArrayList<String> next;
        @SerializedName("trace")
        public ArrayList<TraceItem> trace;

        public static class TraceItem implements Serializable {
            @SerializedName("text")
            public String text;
            @SerializedName("time")
            public String time;
        }
    }

    public static class Product implements Serializable {
        @SerializedName("commodity_id")
        public String commodity_id;
        @SerializedName("extentions")
        public Extentions extentions;
        @SerializedName("image_url")
        public String image_url;
        @SerializedName("list")
        public ArrayList<ListItem> list;
        @SerializedName("price_txt")
        public String price_txt;
        @SerializedName("product_count")
        public String product_count;
        @SerializedName("product_name")
        public String product_name;
        @SerializedName("subtotal_txt")
        public String subtotal_txt;

        public static class ListItem implements Serializable {
            @SerializedName("commodity_id")
            public String commodity_id;
            @SerializedName("image_url")
            public String image_url;
            @SerializedName("product_id")
            public String product_id;
            @SerializedName("product_name")
            public String product_name;
        }
    }

    public static OrderStatusInfo parseOrderStatusInfo(com.mi.global.shop.model.common.OrderStatusInfo orderStatusInfo) {
        OrderStatusInfo orderStatusInfo2 = new OrderStatusInfo();
        if (orderStatusInfo != null) {
            orderStatusInfo2.info = (String) Wire.get(orderStatusInfo.info, "");
            ArrayList<String> arrayList = new ArrayList<>();
            if (orderStatusInfo.next != null) {
                for (String add : orderStatusInfo.next) {
                    arrayList.add(add);
                }
            }
            orderStatusInfo2.next = arrayList;
            ArrayList<OrderStatusInfo.TraceItem> arrayList2 = new ArrayList<>();
            if (orderStatusInfo.trace != null) {
                for (TraceItem next : orderStatusInfo.trace) {
                    OrderStatusInfo.TraceItem traceItem = new OrderStatusInfo.TraceItem();
                    traceItem.text = (String) Wire.get(next.text, "");
                    traceItem.time = (String) Wire.get(next.time, "");
                    arrayList2.add(traceItem);
                }
            }
            orderStatusInfo2.trace = arrayList2;
        }
        return orderStatusInfo2;
    }

    public static ArrayList<Product> parseListProducts(List<ListProduct> list) {
        ArrayList<Product> arrayList = new ArrayList<>();
        if (list != null) {
            for (ListProduct next : list) {
                Product product = new Product();
                product.product_name = (String) Wire.get(next.product_name, "");
                product.image_url = (String) Wire.get(next.image_url, "");
                product.price_txt = (String) Wire.get(next.price_txt, "");
                product.subtotal_txt = (String) Wire.get(next.subtotal_txt, "");
                product.product_count = (String) Wire.get(next.product_count, "");
                Extentions extentions = new Extentions();
                com.mi.global.shop.model.common.Extentions extentions2 = next.extentions;
                if (extentions2 != null) {
                    extentions.goods_dealer = (String) Wire.get(extentions2.goods_dealer, "");
                }
                product.extentions = extentions;
                ArrayList<Product.ListItem> arrayList2 = new ArrayList<>();
                if (next.list != null) {
                    for (ListItem next2 : next.list) {
                        Product.ListItem listItem = new Product.ListItem();
                        listItem.commodity_id = (String) Wire.get(next2.commodity_id, "");
                        listItem.product_name = (String) Wire.get(next2.product_name, "");
                        listItem.image_url = (String) Wire.get(next2.image_url, "");
                        arrayList2.add(listItem);
                    }
                }
                product.list = arrayList2;
                product.commodity_id = (String) Wire.get(next.commodity_id, "");
                arrayList.add(product);
            }
        }
        return arrayList;
    }
}

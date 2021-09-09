package com.mi.global.shop.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ShoppingCartBargainModel {
    @SerializedName("bargainList")
    public ArrayList<BargainsItem> bargainList;
    @SerializedName("bargainNum")
    public String bargainNum;

    public static class BargainsItem {
        public Boolean Selected = Boolean.FALSE;
        @SerializedName("bargainAdapt")
        public ArrayList<String> bargainAdapt;
        @SerializedName("bargainGoodsId")
        public String bargainGoodsId;
        @SerializedName("bargainImg")
        public String bargainImg;
        @SerializedName("bargainName")
        public String bargainName;
        @SerializedName("bargainPrice_txt")
        public String bargainPrice_txt;
    }
}

package com.mi.global.shop.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class HomeThemeTopicItem {
    @SerializedName("activity_img")
    public String mImageUrl;
    @SerializedName("activity_url")
    public String mLinkUrl;
    @SerializedName("open_type")
    public String mOpenType;
    @SerializedName("cells")
    public ArrayList<HomeThemeItem> mTopicItems;
}

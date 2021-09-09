package com.mi.global.shop.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;

public class HomeThemeProductItem implements Serializable {
    private static final long serialVersionUID = 2258271968243509484L;
    @SerializedName("more_link")
    public String mMoreLink;
    @SerializedName("cells")
    public ArrayList<HomeThemeItem> mProductItems;
    @SerializedName("title")
    public String mTitle;
    @SerializedName("title_color")
    public String mTitleColor;
}

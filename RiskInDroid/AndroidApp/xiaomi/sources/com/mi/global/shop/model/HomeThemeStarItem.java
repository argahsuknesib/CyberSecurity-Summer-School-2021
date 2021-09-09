package com.mi.global.shop.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;

public class HomeThemeStarItem implements Serializable {
    private static final long serialVersionUID = -7937902964410925782L;
    @SerializedName("more_link")
    public String mMoreLinkUrl;
    @SerializedName("cells")
    public ArrayList<HomeThemeItem> mStartCells;
    @SerializedName("title")
    public String mTitle;
    @SerializedName("title_color")
    public String mTitleColor;
}

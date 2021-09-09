package com.mi.global.shop.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class HomeThemeItem implements Serializable {
    private static final long serialVersionUID = -1495756615508283196L;
    @SerializedName("big_img")
    public String mBigImageUrl;
    @SerializedName("col")
    public int mColumn;
    @SerializedName("col_span")
    public int mColumnSpan;
    @SerializedName("img")
    public String mImageUrl;
    @SerializedName("is_login")
    public String mIsNeedLogin;
    @SerializedName("keyword")
    public String mKeyword;
    @SerializedName("link_url")
    public String mLinkUrl;
    @SerializedName("open_type")
    public String mOpenType;
    @SerializedName("product_id")
    public String mProductId;
    @SerializedName("market_price")
    public String mProductMarketPrice;
    @SerializedName("name")
    public String mProductName;
    @SerializedName("price")
    public String mProductPrice;
    @SerializedName("row")
    public int mRow;
    @SerializedName("row_span")
    public int mRowSpan;

    public boolean isNeedLogin() {
        return "1".equals(this.mIsNeedLogin);
    }

    public String toString() {
        return "HomeThemeItem{mBigImageUrl=" + this.mBigImageUrl + ", mColumn=" + this.mColumn + ", mColumnSpan=" + this.mColumnSpan + ", mRow=" + this.mRow + ", mRowSpan=" + this.mRowSpan + ", mProductId=" + this.mProductId + ", mProductName=" + this.mProductName + ", mProductPrice=" + this.mProductPrice + ", mProductMarketPrice=" + this.mProductMarketPrice + ", mImageUrl=" + this.mImageUrl + ", mOpenType=" + this.mOpenType + ", mLinkUrl=" + this.mLinkUrl + '}';
    }
}

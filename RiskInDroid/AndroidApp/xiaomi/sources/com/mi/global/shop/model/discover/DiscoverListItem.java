package com.mi.global.shop.model.discover;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.Wire;
import java.io.Serializable;

public class DiscoverListItem implements Serializable {
    private static final long serialVersionUID = -6489285428639002694L;
    @SerializedName("addtime")
    public String addtime;
    @SerializedName("desc")
    public String content;
    @SerializedName("id")
    public String id;
    @SerializedName("img")
    public String imageUrl;
    @SerializedName("supportnum")
    public String likeCount;
    @SerializedName("share")
    public ShareItem share;
    @SerializedName("status")
    public int status;
    @SerializedName("title")
    public String title;
    @SerializedName("classify")
    public int type;
    @SerializedName("url")
    public String url;
    @SerializedName("icon")
    public String userHeadImg;
    @SerializedName("uname")
    public String username;

    public static DiscoverListItem parseProtobuf(ItemsInfo itemsInfo) {
        if (itemsInfo == null) {
            return null;
        }
        DiscoverListItem discoverListItem = new DiscoverListItem();
        discoverListItem.id = (String) Wire.get(itemsInfo.id, "");
        discoverListItem.imageUrl = (String) Wire.get(itemsInfo.img, "");
        discoverListItem.url = (String) Wire.get(itemsInfo.url, "");
        discoverListItem.title = (String) Wire.get(itemsInfo.title, "");
        discoverListItem.content = (String) Wire.get(itemsInfo.desc, "");
        discoverListItem.addtime = (String) Wire.get(itemsInfo.addtime, "");
        discoverListItem.userHeadImg = (String) Wire.get(itemsInfo.icon, "");
        discoverListItem.username = (String) Wire.get(itemsInfo.uname, "");
        discoverListItem.likeCount = (String) Wire.get(itemsInfo.supportnum, "");
        if (discoverListItem.likeCount.isEmpty()) {
            discoverListItem.likeCount = "0";
        }
        discoverListItem.type = Integer.parseInt((String) Wire.get(itemsInfo.classify, ""));
        String str = (String) Wire.get(itemsInfo.status, "");
        if (str.isEmpty()) {
            discoverListItem.status = 0;
        } else {
            discoverListItem.status = Integer.parseInt(str);
        }
        discoverListItem.share = new ShareItem();
        if (itemsInfo.share != null) {
            discoverListItem.share.text = (String) Wire.get(itemsInfo.share.text, "");
        }
        return discoverListItem;
    }
}

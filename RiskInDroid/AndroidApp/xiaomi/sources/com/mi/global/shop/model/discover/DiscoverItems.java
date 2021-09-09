package com.mi.global.shop.model.discover;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.Wire;
import java.io.Serializable;
import java.util.ArrayList;

public class DiscoverItems implements Serializable {
    private static final long serialVersionUID = 1044423013391540237L;
    @SerializedName("currentpage")
    public int currentpage;
    @SerializedName("items")
    public ArrayList<DiscoverListItem> items;
    @SerializedName("totalpages")
    public long totalpages;

    public static DiscoverItems parseProtobuf(Find find) {
        FindData findData;
        if (find == null || (findData = find.data) == null) {
            return null;
        }
        DiscoverItems discoverItems = new DiscoverItems();
        discoverItems.totalpages = ((Long) Wire.get(findData.totalpages, FindData.DEFAULT_TOTALPAGES)).longValue();
        discoverItems.items = new ArrayList<>();
        if (findData.items != null) {
            for (int i = 0; i < findData.items.size(); i++) {
                discoverItems.items.add(DiscoverListItem.parseProtobuf(findData.items.get(i)));
            }
        }
        return discoverItems;
    }
}

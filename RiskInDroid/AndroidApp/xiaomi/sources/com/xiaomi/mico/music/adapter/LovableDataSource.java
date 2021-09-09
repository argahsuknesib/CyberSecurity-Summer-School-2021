package com.xiaomi.mico.music.adapter;

import java.util.Map;

public interface LovableDataSource {
    void addFavouriteMap(Map<String, Boolean> map);

    void updateFavouriteData(String str, boolean z);

    void updateFavouriteMap(Map<String, Boolean> map);
}

package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AssetPackStates {
    public static AssetPackStates a(long j, Map<String, AssetPackState> map) {
        return new bj(j, map);
    }

    public static AssetPackStates a(Bundle bundle, cb cbVar) {
        return a(bundle, cbVar, new ArrayList());
    }

    public static AssetPackStates a(Bundle bundle, cb cbVar, ba baVar) {
        return a(bundle, cbVar, new ArrayList(), baVar);
    }

    public static AssetPackStates a(Bundle bundle, cb cbVar, List<String> list) {
        return a(bundle, cbVar, list, bb.f3646a);
    }

    private static AssetPackStates a(Bundle bundle, cb cbVar, List<String> list, ba baVar) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        HashMap hashMap = new HashMap();
        int size = stringArrayList.size();
        for (int i = 0; i < size; i++) {
            String str = stringArrayList.get(i);
            hashMap.put(str, AssetPackState.a(bundle, str, cbVar, baVar));
        }
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            String str2 = list.get(i2);
            hashMap.put(str2, AssetPackState.a(str2, 4, 0, 0, 0, 0.0d));
        }
        return a(bundle.getLong("total_bytes_to_download"), hashMap);
    }

    public abstract Map<String, AssetPackState> packStates();

    public abstract long totalBytes();
}

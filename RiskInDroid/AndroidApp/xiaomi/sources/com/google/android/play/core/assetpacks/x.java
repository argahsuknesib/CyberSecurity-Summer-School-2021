package com.google.android.play.core.assetpacks;

import android.os.ParcelFileDescriptor;
import com.google.android.play.core.tasks.Task;
import java.util.List;
import java.util.Map;

interface x {
    Task<AssetPackStates> a(List<String> list, ba baVar, Map<String, Long> map);

    Task<AssetPackStates> a(List<String> list, List<String> list2, Map<String, Long> map);

    Task<List<String>> a(Map<String, Long> map);

    void a();

    void a(int i);

    void a(int i, String str);

    void a(int i, String str, String str2, int i2);

    void a(String str);

    void a(List<String> list);

    Task<ParcelFileDescriptor> b(int i, String str, String str2, int i2);
}

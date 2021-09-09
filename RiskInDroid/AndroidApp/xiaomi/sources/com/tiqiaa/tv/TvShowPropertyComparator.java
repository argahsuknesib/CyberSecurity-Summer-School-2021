package com.tiqiaa.tv;

import android.util.SparseArray;
import com.tiqiaa.icontrol.util.LogUtil;
import com.tiqiaa.tv.entity.TvForenotice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TvShowPropertyComparator implements Comparator<TvForenotice> {
    private Map<String, Integer> mCacheLikeData = new HashMap();
    private TvForenotice referTvForenotice;

    private static int compareTvShowPropertys(String str, String str2) {
        if (str == null || str2 == null) {
            return 0;
        }
        int i = 0;
        for (String contains : str.split(",")) {
            if (str2.contains(contains)) {
                i++;
            }
        }
        return i;
    }

    public List<TvForenotice> getMostLikelyForenotices(List<TvForenotice> list, TvForenotice tvForenotice, int i) {
        if (list == null || list.size() == 0) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        Date date = new Date();
        ArrayList arrayList = new ArrayList();
        for (TvForenotice next : list) {
            if (next != null && !next.getEt().before(date)) {
                if (tvForenotice != null) {
                    if (next.getFid() == 0 || (next.getFid() != tvForenotice.getFid() && sparseArray.get(next.getFid()) == null)) {
                        if (next.getFid2() != 0) {
                            if (next.getFid2() != tvForenotice.getFid2()) {
                                if (sparseArray.get(next.getFid2()) != null) {
                                }
                            }
                        }
                    }
                }
                if (next.getFid() > 0) {
                    sparseArray.put(next.getFid(), next);
                }
                if (next.getFid2() > 0) {
                    sparseArray.put(next.getFid2(), next);
                }
                arrayList.add(next);
            }
        }
        if (tvForenotice != null) {
            Date date2 = new Date();
            LogUtil.i("TvShowPropertyComparator", "getMostLikelyForenotices..............根据最佳匹配排序.");
            this.referTvForenotice = tvForenotice;
            Collections.sort(arrayList, this);
            this.referTvForenotice = null;
            LogUtil.w("TvShowPropertyComparator", "getMostLikelyForenotices..............排序用时 --> " + (new Date().getTime() - date2.getTime()) + " ms");
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (size >= i) {
                arrayList.remove(size);
            }
        }
        LogUtil.w("TvShowPropertyComparator", "getMostLikelyForenotices..............clearForenotices.size = " + arrayList.size());
        return arrayList;
    }

    public int compare(TvForenotice tvForenotice, TvForenotice tvForenotice2) {
        if (this.referTvForenotice == null || tvForenotice == null || tvForenotice2 == null) {
            return 0;
        }
        int compareTvShowPropertys = compareTvShowPropertys(tvForenotice.getPp(), this.referTvForenotice.getPp());
        int compareTvShowPropertys2 = compareTvShowPropertys(tvForenotice2.getPp(), this.referTvForenotice.getPp());
        this.mCacheLikeData.put(tvForenotice.getPp(), Integer.valueOf(compareTvShowPropertys));
        this.mCacheLikeData.put(tvForenotice2.getPp(), Integer.valueOf(compareTvShowPropertys2));
        if (compareTvShowPropertys < compareTvShowPropertys2) {
            return 1;
        }
        if (compareTvShowPropertys == compareTvShowPropertys2) {
            return 0;
        }
        return -1;
    }
}

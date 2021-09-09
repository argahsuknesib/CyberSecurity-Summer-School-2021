package com.xiaomi.smarthome.camera.view.timeline;

import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoChildListData;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class TimeLineUtils {
    public static CloudVideoChildListData getEndItem(TreeMap<Long, List<CloudVideoChildListData>> treeMap) {
        if (treeMap != null && !treeMap.isEmpty()) {
            TreeSet treeSet = new TreeSet();
            for (Long add : treeMap.keySet()) {
                treeSet.add(add);
            }
            Iterator descendingIterator = treeSet.descendingIterator();
            while (descendingIterator.hasNext()) {
                List list = treeMap.get(Long.valueOf(((Long) descendingIterator.next()).longValue()));
                if (list != null && list.size() > 0) {
                    return (CloudVideoChildListData) list.get(0);
                }
            }
        }
        return null;
    }
}

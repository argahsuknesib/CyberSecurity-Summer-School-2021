package com.xiaomi.push.service;

import _m_j.eml;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ai {

    /* renamed from: a  reason: collision with root package name */
    private static Object f6495a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static Map<String, Queue<String>> f246a = new HashMap();

    public static boolean a(XMPushService xMPushService, String str, String str2) {
        synchronized (f6495a) {
            SharedPreferences sharedPreferences = xMPushService.getSharedPreferences("push_message_ids", 0);
            Queue queue = f246a.get(str);
            if (queue == null) {
                String[] split = sharedPreferences.getString(str, "").split(",");
                LinkedList linkedList = new LinkedList();
                for (String add : split) {
                    linkedList.add(add);
                }
                f246a.put(str, linkedList);
                queue = linkedList;
            }
            if (queue.contains(str2)) {
                return true;
            }
            queue.add(str2);
            if (queue.size() > 25) {
                queue.poll();
            }
            String O000000o2 = eml.O000000o(queue, ",");
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, O000000o2);
            edit.commit();
            return false;
        }
    }
}

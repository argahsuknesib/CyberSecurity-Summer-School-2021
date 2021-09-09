package com.google.android.play.core.splitinstall;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Map<String, String>> f3814a;

    /* synthetic */ f(Map map) {
        this.f3814a = map;
    }

    public final Map<String, Set<String>> a(Collection<String> collection) {
        Set set;
        HashMap hashMap = new HashMap();
        for (String next : this.f3814a.keySet()) {
            if (!this.f3814a.containsKey(next)) {
                set = Collections.emptySet();
            } else {
                HashSet hashSet = new HashSet();
                for (Map.Entry entry : this.f3814a.get(next).entrySet()) {
                    if (collection.contains(entry.getKey())) {
                        hashSet.add((String) entry.getValue());
                    }
                }
                set = Collections.unmodifiableSet(hashSet);
            }
            hashMap.put(next, set);
        }
        return hashMap;
    }
}

package com.tencent.open.a;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;

public class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, String> f5871a = new HashMap<>();

    public b(Bundle bundle) {
        for (String next : bundle.keySet()) {
            this.f5871a.put(next, bundle.getString(next));
        }
    }
}

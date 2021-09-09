package com.google.firebase.components;

import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class zzc {
    private final Context mContext;
    private final zzf zzag;

    public zzc(Context context) {
        this(context, new zze());
    }

    private zzc(Context context, zzf zzf) {
        this.mContext = context;
        this.zzag = zzf;
    }

    private static List<ComponentRegistrar> zza(List<String> list) {
        String str;
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            try {
                Class<?> cls = Class.forName(next);
                if (!ComponentRegistrar.class.isAssignableFrom(cls)) {
                    Log.w("ComponentDiscovery", String.format("Class %s is not an instance of %s", next, "com.google.firebase.components.ComponentRegistrar"));
                } else {
                    arrayList.add((ComponentRegistrar) cls.newInstance());
                }
            } catch (ClassNotFoundException e) {
                e = e;
                str = String.format("Class %s is not an found.", next);
                Log.w("ComponentDiscovery", str, e);
            } catch (IllegalAccessException e2) {
                e = e2;
                str = String.format("Could not instantiate %s.", next);
                Log.w("ComponentDiscovery", str, e);
            } catch (InstantiationException e3) {
                e = e3;
                str = String.format("Could not instantiate %s.", next);
                Log.w("ComponentDiscovery", str, e);
            }
        }
        return arrayList;
    }

    public final List<ComponentRegistrar> zzj() {
        return zza(this.zzag.zzc(this.mContext));
    }
}

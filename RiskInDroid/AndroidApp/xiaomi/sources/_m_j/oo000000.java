package _m_j;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class oo000000 {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Object f2358O000000o = new Object();
    private static Field O00000Oo;
    private static final Object O00000o = new Object();
    private static boolean O00000o0;

    public static SparseArray<Bundle> O000000o(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle O000000o(Notification notification) {
        synchronized (f2358O000000o) {
            if (O00000o0) {
                return null;
            }
            try {
                if (O00000Oo == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        O00000o0 = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    O00000Oo = declaredField;
                }
                Bundle bundle = (Bundle) O00000Oo.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    O00000Oo.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                O00000o0 = true;
                return null;
            } catch (NoSuchFieldException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                O00000o0 = true;
                return null;
            }
        }
    }

    public static Bundle O000000o(Notification.Builder builder, NotificationCompat.O000000o o000000o) {
        int i;
        IconCompat O000000o2 = o000000o.O000000o();
        if (O000000o2 != null) {
            i = O000000o2.O000000o();
        } else {
            i = 0;
        }
        builder.addAction(i, o000000o.O0000Oo0, o000000o.O0000Oo);
        Bundle bundle = new Bundle(o000000o.f2823O000000o);
        if (o000000o.O00000Oo != null) {
            bundle.putParcelableArray("android.support.remoteInputs", O000000o(o000000o.O00000Oo));
        }
        if (o000000o.O00000o0 != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", O000000o(o000000o.O00000o0));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", o000000o.O00000o);
        return bundle;
    }

    static Bundle O000000o(NotificationCompat.O000000o o000000o) {
        int i;
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat O000000o2 = o000000o.O000000o();
        if (O000000o2 != null) {
            i = O000000o2.O000000o();
        } else {
            i = 0;
        }
        bundle2.putInt("icon", i);
        bundle2.putCharSequence("title", o000000o.O0000Oo0);
        bundle2.putParcelable("actionIntent", o000000o.O0000Oo);
        if (o000000o.f2823O000000o != null) {
            bundle = new Bundle(o000000o.f2823O000000o);
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", o000000o.O00000o);
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", O000000o(o000000o.O00000Oo));
        bundle2.putBoolean("showsUserInterface", o000000o.O00000oO);
        bundle2.putInt("semanticAction", o000000o.O00000oo);
        return bundle2;
    }

    private static Bundle[] O000000o(b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[bVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            b bVar = bVarArr[i];
            Bundle bundle = new Bundle();
            bundle.putString("resultKey", bVar.f12739O000000o);
            bundle.putCharSequence("label", bVar.O00000Oo);
            bundle.putCharSequenceArray("choices", bVar.O00000o0);
            bundle.putBoolean("allowFreeFormInput", bVar.O00000o);
            bundle.putBundle("extras", bVar.O00000oO);
            Set<String> set = bVar.O00000oo;
            if (set != null && !set.isEmpty()) {
                ArrayList arrayList = new ArrayList(set.size());
                for (String add : set) {
                    arrayList.add(add);
                }
                bundle.putStringArrayList("allowedDataTypes", arrayList);
            }
            bundleArr[i] = bundle;
        }
        return bundleArr;
    }
}

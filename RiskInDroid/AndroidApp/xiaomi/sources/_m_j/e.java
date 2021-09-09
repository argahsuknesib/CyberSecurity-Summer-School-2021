package _m_j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class e implements Iterable<Intent> {

    /* renamed from: O000000o  reason: collision with root package name */
    public final ArrayList<Intent> f15113O000000o = new ArrayList<>();
    public final Context O00000Oo;

    public interface O000000o {
        Intent getSupportParentActivityIntent();
    }

    private e(Context context) {
        this.O00000Oo = context;
    }

    public static e O000000o(Context context) {
        return new e(context);
    }

    public final e O000000o(ComponentName componentName) {
        int size = this.f15113O000000o.size();
        try {
            Intent O000000o2 = oOOO0o00.O000000o(this.O00000Oo, componentName);
            while (O000000o2 != null) {
                this.f15113O000000o.add(size, O000000o2);
                O000000o2 = oOOO0o00.O000000o(this.O00000Oo, O000000o2.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    @Deprecated
    public final Iterator<Intent> iterator() {
        return this.f15113O000000o.iterator();
    }
}

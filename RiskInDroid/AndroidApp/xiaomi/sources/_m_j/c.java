package _m_j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.util.ArrayList;

public final class c {

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final Intent f13508O000000o = new Intent().setAction("android.intent.action.SEND");
        public ArrayList<String> O00000Oo;
        public ArrayList<String> O00000o;
        public ArrayList<String> O00000o0;
        public ArrayList<Uri> O00000oO;
        private final Context O00000oo;

        public O000000o(Context context, ComponentName componentName) {
            this.O00000oo = (Context) bf.O000000o(context);
            this.f13508O000000o.putExtra("androidx.core.app.EXTRA_CALLING_PACKAGE", context.getPackageName());
            this.f13508O000000o.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", context.getPackageName());
            this.f13508O000000o.putExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY", componentName);
            this.f13508O000000o.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", componentName);
            this.f13508O000000o.addFlags(524288);
        }

        public final void O000000o(String str, ArrayList<String> arrayList) {
            String[] stringArrayExtra = this.f13508O000000o.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr = new String[(arrayList.size() + length)];
            arrayList.toArray(strArr);
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), length);
            }
            this.f13508O000000o.putExtra(str, strArr);
        }
    }
}

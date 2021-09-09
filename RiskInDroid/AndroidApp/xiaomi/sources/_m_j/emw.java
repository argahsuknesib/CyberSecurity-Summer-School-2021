package _m_j;

import _m_j.end;
import android.content.Context;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class emw implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f15638O000000o;
    private WeakReference<Context> O00000Oo;

    public emw(String str, WeakReference<Context> weakReference) {
        this.f15638O000000o = str;
        this.O00000Oo = weakReference;
    }

    public final void run() {
        Context context;
        emx emx;
        WeakReference<Context> weakReference = this.O00000Oo;
        if (weakReference != null && (context = weakReference.get()) != null) {
            if (enj.O000000o(this.f15638O000000o) > emv.O00000Oo) {
                String str = this.f15638O000000o;
                emz emz = new emz(str, "status = ?", new String[]{"2"}, "a job build to delete uploaded job");
                String str2 = this.f15638O000000o;
                ArrayList arrayList = new ArrayList();
                arrayList.add("count(*)");
                emy emy = new emy(str2, arrayList, "job to get count of all message");
                emz.O00000oO = emy;
                String str3 = this.f15638O000000o;
                duv.O00000Oo("delete  messages when db size is too bigger");
                String O000000o2 = end.O000000o(context).O000000o(str3).O000000o();
                if (TextUtils.isEmpty(O000000o2)) {
                    emx = null;
                } else {
                    emx = new emx(str3, "rowDataId in (select " + "rowDataId from ".concat(String.valueOf(O000000o2)) + " order by createTimeStamp asc" + " limit ?)", new String[]{"1000"}, "a job build to delete history message");
                }
                emy.O00000oO = emx;
                end.O000000o(context).O000000o((end.O000000o) emz);
                return;
            }
            duv.O00000Oo("=====> do not need clean db");
        }
    }
}

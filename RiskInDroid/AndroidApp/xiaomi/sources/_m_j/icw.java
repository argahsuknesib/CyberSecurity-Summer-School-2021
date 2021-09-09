package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.xiaomiyoupin.toast.dialog.MLAlertDialog;
import java.util.List;

public final class icw implements iom<List<String>> {

    /* renamed from: O000000o  reason: collision with root package name */
    public ict f1200O000000o;

    public final /* synthetic */ void O000000o(Context context, Object obj, final ion ion) {
        List list = (List) obj;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null || activity.isFinishing()) {
            ict ict = this.f1200O000000o;
            if (ict != null) {
                ict.O000000o(false);
                return;
            }
            return;
        }
        List<String> O000000o2 = iol.O000000o(context, list);
        MLAlertDialog.Builder title = new MLAlertDialog.Builder(activity).setCancelable(false).setTitle("需要授权");
        title.setMessage("为正常使用，需要访问" + TextUtils.join(",", O000000o2)).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            /* class _m_j.icw.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                ion.O00000Oo();
            }
        }).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
            /* class _m_j.icw.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                ion.O00000o0();
                if (icw.this.f1200O000000o != null) {
                    icw.this.f1200O000000o.O000000o(false);
                }
            }
        }).create().show();
    }

    public icw(ict ict) {
        this.f1200O000000o = ict;
    }
}

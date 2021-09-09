package _m_j;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.log.LogType;

public class gxb extends gwy {
    private static final String O00000Oo = "gxb";
    private String O00000o;
    private String O00000o0;
    private Context O00000oO;

    public gxb(Context context, String str, String str2) {
        this.O00000o0 = str;
        this.O00000o = str2;
        this.O00000oO = context;
    }

    public final void O00000Oo() {
        try {
            if (TextUtils.isEmpty(this.O00000o0)) {
                LogType logType = LogType.PUSH;
                String str = O00000Oo;
                gsy.O00000Oo(logType, str, "uid == " + this.O00000o0);
            } else if (!TextUtils.equals(this.O00000o0, CoreApi.O000000o().O0000o0())) {
                if (this.O00000oO != null) {
                    new MLAlertDialog.Builder(this.O00000oO).O000000o((int) R.string.knows_already_tips, (DialogInterface.OnClickListener) null).O00000Oo((int) R.string.change_account_text).O00000Oo(true).O00000oo();
                    hxr hxr = hxi.O00000oO;
                    String str2 = this.O00000o;
                    hxr.f958O000000o.O000000o("alert_miu_acc", "model", str2);
                }
            } else if (O000000o() != null) {
                O000000o().O00000Oo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package _m_j;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.log.LogType;

public class gxa extends gwy {
    private static final String O00000Oo = "gxa";
    private String O00000o;
    private String O00000o0;
    private Context O00000oO;

    public gxa(Context context, String str, String str2) {
        this.O00000o0 = str;
        this.O00000o = str2;
        this.O00000oO = context;
    }

    public final void O00000Oo() {
        try {
            ServerBean O000000o2 = ftn.O000000o(this.O00000oO);
            if (TextUtils.isEmpty(this.O00000o0)) {
                LogType logType = LogType.PUSH;
                String str = O00000Oo;
                gsy.O00000Oo(logType, str, "srv == " + this.O00000o0);
            } else if (O000000o2 == null) {
                gsy.O00000Oo(LogType.PUSH, O00000Oo, "currentServer == null");
            } else if (!this.O00000o0.equalsIgnoreCase(O000000o2.O00000Oo)) {
                if (this.O00000oO != null) {
                    new MLAlertDialog.Builder(this.O00000oO).O000000o((int) R.string.switch_region, new DialogInterface.OnClickListener() {
                        /* class _m_j.$$Lambda$gxa$r45P8Grtd3BxiX8icQSUj0yjE */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            gxa.this.O000000o(dialogInterface, i);
                        }
                    }).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O00000Oo((int) R.string.change_region_text).O00000Oo(true).O00000oo();
                    hxr hxr = hxi.O00000oO;
                    String str2 = this.O00000o;
                    hxr.f958O000000o.O000000o("alert_miu_sev", "model", str2);
                }
            } else if (O000000o() != null) {
                O000000o().O00000Oo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(DialogInterface dialogInterface, int i) {
        hsl.O00000Oo().gotoSelectServerPage(this.O00000oO, 1, null, O00000Oo);
    }
}

package _m_j;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.idm.tap.dispatcher.impl.AbstractActionExecutor;
import com.xiaomi.smarthome.nfctag.ui.NFCSceneRunActivity;

public final class hiw extends AbstractActionExecutor {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f18966O000000o;
    private String O00000Oo;
    private String O00000o;
    private String O00000o0;
    private Context O00000oO;

    public hiw(Context context, String str, String str2, String str3, String str4) {
        this.O00000oO = context;
        this.f18966O000000o = str;
        this.O00000Oo = str2;
        this.O00000o0 = str3;
        this.O00000o = str4;
    }

    public final boolean execute() {
        Context context = this.O00000oO;
        if (context == null) {
            return false;
        }
        Intent intent = new Intent(context, NFCSceneRunActivity.class);
        intent.putExtra("us_id", this.f18966O000000o);
        intent.putExtra("owner_uid", this.O00000Oo);
        intent.putExtra("region", this.O00000o0);
        intent.putExtra("scene_name", this.O00000o);
        this.O00000oO.startActivity(intent);
        return true;
    }
}

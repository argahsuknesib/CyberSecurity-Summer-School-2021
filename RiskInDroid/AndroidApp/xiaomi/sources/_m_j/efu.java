package _m_j;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"sendSnsBroadcast", "", "context", "Landroid/content/Context;", "result", "", "client-ui_release"}, k = 2, mv = {1, 1, 10})
public final class efu {
    public static final void O000000o(Context context, String str) {
        Intent intent = new Intent("passport_sns_events");
        intent.putExtra("sns_result", str);
        ft.O000000o(context).O000000o(intent);
    }
}

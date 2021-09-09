package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.mi.global.shop.imageselector.MultiImageSelectorActivity;
import java.util.ArrayList;

public final class bzy {
    public static bzy O00000o;

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f13504O000000o = true;
    public int O00000Oo = 1;
    public ArrayList<String> O00000o0;
    private int O00000oO = 9;

    private bzy() {
    }

    public static bzy O000000o() {
        if (O00000o == null) {
            O00000o = new bzy();
        }
        return O00000o;
    }

    public final bzy O000000o(int i) {
        this.O00000oO = i;
        return O00000o;
    }

    public final void O000000o(Activity activity, int i) {
        activity.startActivityForResult(O000000o(activity), i);
    }

    private Intent O000000o(Context context) {
        Intent intent = new Intent(context, MultiImageSelectorActivity.class);
        intent.putExtra("show_camera", this.f13504O000000o);
        intent.putExtra("max_select_count", this.O00000oO);
        ArrayList<String> arrayList = this.O00000o0;
        if (arrayList != null) {
            intent.putStringArrayListExtra("default_list", arrayList);
        }
        intent.putExtra("select_count_mode", this.O00000Oo);
        return intent;
    }
}

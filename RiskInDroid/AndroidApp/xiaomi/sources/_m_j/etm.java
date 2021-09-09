package _m_j;

import android.app.Activity;
import android.content.DialogInterface;

public final class etm implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Activity f15799O000000o;

    public etm(Activity activity) {
        this.f15799O000000o = activity;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f15799O000000o.finish();
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f15799O000000o.finish();
    }
}
